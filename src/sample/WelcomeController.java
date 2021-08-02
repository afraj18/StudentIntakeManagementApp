package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private JFXButton stuBtn;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton lectBtn;

    @FXML
    void goToStuLog(ActionEvent event) throws IOException {
        stuBtn.getScene().getWindow().hide();
        //New Scene
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "StuLogin.fxml"
                )
        );
        Stage stage = new Stage();
        stage.setScene(
                new Scene(loader.load())
        );
//                  StudentHome std = loader.getController();
//                  std.setDetails(userName_lbl.getText());
        stage.show();
    }


    @FXML
    void adminLog(ActionEvent event) throws IOException {
        stuBtn.getScene().getWindow().hide();
        //New Scene
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "adminLogin.fxml"
                )
        );
        Stage stage = new Stage();
        stage.setScene(
                new Scene(loader.load())
        );

        stage.show();
    }

    @FXML
    void BackHandle(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        //New Scene
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "sample.fxml"
                )
        );
        Stage stage = new Stage();
        stage.setScene(
                new Scene(loader.load())
        );

        stage.show();

    }

    @FXML
    void initialize() {

    }
}


