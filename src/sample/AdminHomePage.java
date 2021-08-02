package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomePage implements Initializable {
    @FXML
    private Button signOut_btn;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton stuDet_btn;

    @FXML
    private JFXButton sem_Reg_btn;

    @FXML
    private JFXButton ModManage_btn;

    @FXML
    private JFXButton admin_btn;

    @FXML
    private JFXButton manageFac_btn;

    @FXML
    private JFXButton lect_btn;

    @FXML
    void HandleAct(ActionEvent event) throws IOException {
            if(event.getSource()==signOut_btn){
                signOut_btn.getScene().getWindow().hide();
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
            else if(event.getSource()==exit_btn){
                exit_btn.getScene().getWindow().hide();
            }
            else if(event.getSource()==stuDet_btn){
                stuDet_btn.getScene().getWindow().hide();

                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "StuDetAdmin.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );
                stage.show();
            }
            else if(event.getSource()==lect_btn){
                stuDet_btn.getScene().getWindow().hide();

                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "LecturerAdd.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );
                stage.show();
            }
            else if(event.getSource()==admin_btn){
                admin_btn.getScene().getWindow().hide();

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
            else if(event.getSource()==sem_Reg_btn){
                sem_Reg_btn.getScene().getWindow().hide();

                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "AdminSemRegStu.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );
                stage.show();

            }
            else if(event.getSource()==manageFac_btn){
                manageFac_btn.getScene().getWindow().hide();

                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "AdminFac.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );
                stage.show();

            }
            else if(event.getSource()==ModManage_btn){
                ModManage_btn.getScene().getWindow().hide();

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

    }
}
