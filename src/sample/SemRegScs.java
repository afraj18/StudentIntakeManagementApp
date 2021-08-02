package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SemRegScs {
    @FXML
    private JFXButton goHome_btn;

    @FXML
    private JFXButton logout_btn;

    @FXML
    void handleAct(ActionEvent event) throws IOException {
        if(event.getSource()==goHome_btn){
            goHome_btn.getScene().getWindow().hide();
            //New Scene
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "StudentHome.fxml"
                    )
            );
            Stage stage = new Stage();
            stage.setScene(
                    new Scene(loader.load())
            );
            stage.show();
        }
        else if(event.getSource()==logout_btn){
            logout_btn.getScene().getWindow().hide();
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
            stage.show();
        }

    }

}
