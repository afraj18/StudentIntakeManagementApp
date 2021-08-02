package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import database.dbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminLogin implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    private JFXButton back;

    @FXML
    private JFXButton logBtn;

    @FXML
    private Label log_status;

    @FXML
    private JFXTextField u_id_lbl;

    @FXML
    private JFXPasswordField pwd_lbl;

    @FXML
    void BackHandle(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        //New Scene
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    @FXML
    void adminLogFunc(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        dbHandler dbhandler = new dbHandler();
        if(!u_id_lbl.getText().toString().trim().equals("")
                && !pwd_lbl.getText().toString().trim().equals("")){
            if(dbhandler.loginNow("admin",u_id_lbl.getText(),pwd_lbl.getText())){

                //log_status.setVisible(true);
                //log_status.setText("Login Success");

                // old scene hide
                logBtn.getScene().getWindow().hide();
                //New Scene
                FXMLLoader adminloader = new FXMLLoader(
                        getClass().getResource(
                                "adminHomePage.fxml"
                        )
                );

                Stage adminstage = new Stage();
                adminstage.setScene(
                        new Scene(adminloader.load())
                );



                adminstage.show();
            }
            else{
                u_id_lbl.setText("");
                pwd_lbl.setText("");

                Alert alert = new Alert(Alert.AlertType.WARNING,"Username or Password is incorrect", ButtonType.OK);
                alert.setTitle("Wrong Credential");
                alert.setHeaderText("Login Failed");

                alert.showAndWait();
            }
        }
        else{
            u_id_lbl.setText("");
            pwd_lbl.setText("");

            Alert alert = new Alert(Alert.AlertType.WARNING,"fill all inputs", ButtonType.OK);
            alert.setTitle("Login Failed");
            alert.setHeaderText("Empty fields");

            alert.showAndWait();
        }
    }


}
