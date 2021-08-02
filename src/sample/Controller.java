package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private JFXButton startBtn;

    @FXML
    private JFXButton deg_btn;

    @FXML
    private JFXButton fac_btn;
    @FXML
    private JFXButton exit_btn;

    @FXML
    void handleBtn(ActionEvent event) throws IOException {
        if(event.getSource()==exit_btn){
            exit_btn.getScene().getWindow().hide();
        }
        else if(event.getSource()==fac_btn){
            // old scene hide
            fac_btn.getScene().getWindow().hide();
            //New Scene
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "AvailableFaculty.fxml"
                    )
            );
            Stage stage = new Stage();
            stage.setScene(
                    new Scene(loader.load())
            );

            stage.show();
        }
        else if(event.getSource()==deg_btn){
            deg_btn.getScene().getWindow().hide();
            //New Scene
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "Degrees.fxml"
                    )
            );
            Stage stage = new Stage();
            stage.setScene(
                    new Scene(loader.load())
            );

            stage.show();
        }

    }

    @FXML
    void st_action(ActionEvent event) throws IOException {
        // old scene hide
        startBtn.getScene().getWindow().hide();
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


    @FXML
    private JFXButton regBtn;

    @FXML
    void regHandle(ActionEvent event) throws IOException{
        // old scene hide
        startBtn.getScene().getWindow().hide();
        //New Scene
        //New Scene
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "StuReg.fxml"
                )
        );
        Stage stage = new Stage();
        stage.setScene(
                new Scene(loader.load())
        );

        stage.show();
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
