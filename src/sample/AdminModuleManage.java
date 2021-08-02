package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.dbHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminModuleManage implements Initializable {

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXTextField modName_tf;

    @FXML
    private JFXTextField credit_tf;

    @FXML
    private JFXComboBox<String> deg_Cb;

    @FXML
    private JFXComboBox<String> fac_Cb;

    @FXML
    private JFXComboBox<String> year_cb;

    ObservableList<String> degOB = FXCollections.observableArrayList("BSc.Computer Science","LAW","Bsc.Engineering",
            "BBA.Management");
    ObservableList<String> facOB = FXCollections.observableArrayList(
                                "Faculty of Computer Science",
                                    "Faculty of LAW",
                                    "Faculty of Engineering",
                                    "Faculty of Management");

    ObservableList<String> yearOB = FXCollections.observableArrayList(
            "1st Year","2nd Year","3rd Year","4th Year");
    @FXML
    private JFXButton add_btn;

    @FXML
    private JFXButton mod_btn;

    @FXML
    void HandleBtn(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
            if(event.getSource()==add_btn) {
                if(!modName_tf.getText().equals("")|| !credit_tf.getText().equals("")
                        ){

                                addModule(modName_tf.getText().trim(),deg_Cb.getSelectionModel().getSelectedItem(),
                                fac_Cb.getSelectionModel().getSelectedItem(),credit_tf.getText().trim(),
                                        year_cb.getSelectionModel().getSelectedItem());

                    //oldScene
                    add_btn.getScene().getWindow().hide();

                    //New Scene
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "AdminModuleTable.fxml"
                            )
                    );

                    Stage stage = new Stage();
                    stage.setScene(
                            new Scene(loader.load())
                    );
                    stage.show();

                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING,"Please fill all required informations",
                            ButtonType.OK);
                    alert.setTitle("Error");
                    alert.setHeaderText("Some fields are left out blank");
                    alert.showAndWait();
                }
            }

            else if(event.getSource()==mod_btn){
                //oldScene
                mod_btn.getScene().getWindow().hide();

                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "AdminModuleTable.fxml"
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
            else if(event.getSource()==back_btn){
                //oldScene
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

    //Add Function
    public boolean addModule(String mod,String deg,String fac,String cred,String year) throws SQLException, ClassNotFoundException {
        ResultSet rs  = null;
        PreparedStatement preparedStatement = null;

        dbHandler dbhandler = new dbHandler();
        String query = "INSERT INTO modules (moduleName,degree,faculty,credits,year)" +
                " VALUES (?,?,?,?,?)";
        preparedStatement = dbhandler.getDbConn().prepareStatement(query);

        preparedStatement.setString(1,mod);
        preparedStatement.setString(2,deg);
        preparedStatement.setString(3,fac);
        preparedStatement.setString(4,cred);
        preparedStatement.setString(5,year);

        int result = preparedStatement.executeUpdate();

        if(result==1){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            deg_Cb.setItems(degOB);
            fac_Cb.setItems(facOB);
            year_cb.setItems(yearOB);
    }
}
