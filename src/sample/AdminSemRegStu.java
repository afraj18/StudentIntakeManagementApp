package sample;

import com.jfoenix.controls.JFXButton;
import database.dbHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminSemRegStu implements Initializable {
    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton back_btn;

    @FXML
    private TableView<AdminSemRegModelTable> tbl;

    @FXML
    private TableColumn<AdminSemRegModelTable, String> id_Col;

    @FXML
    private TableColumn<AdminSemRegModelTable, String> name_Col;

    @FXML
    private TableColumn<AdminSemRegModelTable, String> fac_Col;

    @FXML
    private TableColumn<AdminSemRegModelTable, String> deg_Col;

    @FXML
    private TableColumn<AdminSemRegModelTable, String> year_Col;

    ObservableList<AdminSemRegModelTable> obList= FXCollections.observableArrayList();

    @FXML
    void handleBtn(ActionEvent event) throws IOException {
            if (event.getSource()==exit_btn){
                exit_btn.getScene().getWindow().hide();
            }
            else if(event.getSource()==back_btn){
                    back_btn.getScene().getWindow().hide();

                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "AdminHomePage.fxml"
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

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM sem_reg");
            while (rs.next()){
                obList.add(new AdminSemRegModelTable(
                                rs.getString("id"),rs.getString("iName"),
                                rs.getString("faculty"),rs.getString("degree"),
                                rs.getString("year")));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        id_Col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_Col.setCellValueFactory(new PropertyValueFactory<>("name"));
        fac_Col.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        deg_Col.setCellValueFactory(new PropertyValueFactory<>("degree"));
        year_Col.setCellValueFactory(new PropertyValueFactory<>("year"));


        tbl.setItems(obList);

    }
}
