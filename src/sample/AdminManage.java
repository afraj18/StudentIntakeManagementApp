package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminManage implements Initializable {
    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXButton adminPanel_btn;

    @FXML
    private JFXTextField uName_tf;

    @FXML
    private JFXPasswordField pwd_tf;

    @FXML
    private JFXPasswordField cpwd_tf;


    @FXML
    private JFXTextField mail_tf;


    @FXML
    private JFXComboBox<String> role_tf;
    ObservableList<String> roleList = FXCollections.observableArrayList("Admin","Editor",
                                        "Analysis","QA");
    @FXML
    private JFXButton add_btn;

    @FXML
    void addAdmin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if(!uName_tf.getText().trim().equals("") && !pwd_tf.getText().trim().equals("")
                && !role_tf.getSelectionModel().getSelectedItem().equals("") ){
            if(pwd_tf.getText().equals(cpwd_tf.getText())){

                if(adminadd(uName_tf.getText().trim().toLowerCase(),pwd_tf.getText().trim(),
                        role_tf.getSelectionModel().getSelectedItem(),mail_tf.getText().trim().toLowerCase())){
                    // old scene hide
                    add_btn.getScene().getWindow().hide();
                    //New Scene
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "AdminDetTable.fxml"
                            )
                    );
                    Stage stage = new Stage();
                    stage.setScene(
                            new Scene(loader.load())
                    );
                    stage.show();
                }

            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING,"Passwords do not match", ButtonType.OK);
                alert.setTitle("Incorrect passwords");
                alert.setHeaderText("");

                alert.showAndWait();
            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING,"Please Fill all fields", ButtonType.OK);
            alert.setTitle("Empty Fields Detected");
            alert.setHeaderText("");
            alert.showAndWait();
        }
    }

    @FXML
    void handleBtn(ActionEvent event) throws IOException {
            if(event.getSource()==exit_btn){
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
            else if(event.getSource()==adminPanel_btn){
                adminPanel_btn.getScene().getWindow().hide();
                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "AdminDetTable.fxml"
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
        role_tf.setItems(roleList);
    }

    private boolean adminadd(String name,String password,String role,String mail) throws SQLException, ClassNotFoundException {
        ResultSet rs  = null;
        PreparedStatement preparedStatement = null;

        dbHandler dbhandler = new dbHandler();
        String query = "INSERT INTO admin (userName,password,role,mail)" +
                " VALUES (?,?,?,?)";
        preparedStatement = dbhandler.getDbConn().prepareStatement(query);

        preparedStatement.setString(1,name);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,role);
        preparedStatement.setString(4,mail);

        int result = preparedStatement.executeUpdate();

        if(result==1){
            return true;
        }
        else {
            return false;
        }
    }
}
