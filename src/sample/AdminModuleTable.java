package sample;

import com.jfoenix.controls.JFXButton;
import database.Const;
import database.dbHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminModuleTable implements Initializable {


    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private TableView<AdminModuleTableModel> tbl;

    @FXML
    private TableColumn<AdminModuleTableModel,String> id_Col;

    @FXML
    private TableColumn<AdminModuleTableModel,String> mod_Col;

    @FXML
    private TableColumn<AdminModuleTableModel,String> Deg_Col;

    @FXML
    private TableColumn<AdminModuleTableModel,String> Fac_Col;
    @FXML
    private TableColumn<AdminModuleTableModel,String> year_Col;

    @FXML
    private JFXButton del_btn;

    private ObservableList<AdminModuleTableModel> aModModel;
    ObservableList<AdminModuleTableModel> obList = FXCollections.observableArrayList();

    @FXML
    void HandleBtn(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
            if(event.getSource()==del_btn){
                dbHandler dbHandler = new dbHandler();

                String query = "DELETE FROM modules WHERE moduleId =?";
                PreparedStatement preparedStatement =
                        dbHandler.getDbConn().prepareStatement(query);

                AdminModuleTableModel aModModel = tbl.getSelectionModel().getSelectedItem();

                preparedStatement.setString(1,aModModel.getId());
                preparedStatement.execute();
                preparedStatement.close();

                tbl.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                ObservableList<AdminModuleTableModel> selectRow =
                        tbl.getSelectionModel().getSelectedItems();

                ArrayList<AdminModuleTableModel> rows = new ArrayList<>(selectRow);
                rows.forEach(row -> tbl.getItems().remove(row));
            }

            else if(event.getSource()==exit_btn){
                exit_btn.getScene().getWindow().hide();
            }
            else if(event.getSource()==back_btn){
                back_btn.getScene().getWindow().hide();
                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "AdminModuleManage.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );
                stage.show();
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dbHandler dbhandler = new dbHandler();
            Connection conn = dbhandler.getDbConn();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM modules");

            while (rs.next()){
                this.obList.add(new AdminModuleTableModel(rs.getString("moduleId"),rs.getString("moduleName"),
                                    rs.getString("degree"),rs.getString("faculty"),
                                    rs.getString("year")));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        id_Col.setCellValueFactory(new PropertyValueFactory<>("id"));
        mod_Col.setCellValueFactory(new PropertyValueFactory<>("moduleName"));
        Deg_Col.setCellValueFactory(new PropertyValueFactory<>("deg"));
        Fac_Col.setCellValueFactory(new PropertyValueFactory<>("fac"));
        year_Col.setCellValueFactory(new PropertyValueFactory<>("year"));

        tbl.setItems(obList);

    }
}
