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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminDetTable implements Initializable {
    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton log_btn;

    @FXML
    private JFXButton back_btn;

    @FXML
    private TableView<adminModelTable> adminDetTable;

    @FXML
    private TableColumn<adminModelTable, String> id_Col;

    @FXML
    private TableColumn<adminModelTable, String> name_Col;

    @FXML
    private TableColumn<adminModelTable, String> mail_Col;

    @FXML
    private TableColumn<adminModelTable, String> role_Col;

    ObservableList<adminModelTable> obList = FXCollections.observableArrayList();

    @FXML
    void btnHandle(ActionEvent event) throws IOException {
            if(event.getSource()==back_btn){
                back_btn.getScene().getWindow().hide();
                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "AdminManage.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );
                stage.show();
            }
            else if(event.getSource()==log_btn){
                log_btn.getScene().getWindow().hide();
                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "welcome.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );
                stage.show();
            }
            else if(event.getSource()==exit_btn){
                exit_btn.getScene().getWindow().hide();
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dbHandler dbhandler = new dbHandler();
            Connection conn = dbhandler.getDbConn();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM admin");

            while (rs.next()){
                obList.add(new adminModelTable(rs.getString("id"),rs.getString("userName"),
                                                rs.getString("mail"),rs.getString("role")));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        id_Col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_Col.setCellValueFactory(new PropertyValueFactory<>("name"));
        mail_Col.setCellValueFactory(new PropertyValueFactory<>("mail"));
        role_Col.setCellValueFactory(new PropertyValueFactory<>("role"));

        adminDetTable.setItems(obList);


    }
}
