package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Faculty implements Initializable {
    @FXML
    private Button cs_btn;

    @FXML
    private Button law_btn;

    @FXML
    private Button bus_btn;

    @FXML
    private Button home_lbl;

    @FXML
    private Button eng_btn;
    @FXML
    private JFXComboBox<String> deg_cb;

    @FXML
    private JFXComboBox<String> year_cb;

    ObservableList<String> degOB = FXCollections.observableArrayList("BSc.Computer Science","LAW","Bsc.Engineering",
            "BBA.Management");

    ObservableList<String> yearOB = FXCollections.observableArrayList(
            "1st Year","2nd Year","3rd Year","4th Year");

    @FXML
    private JFXButton mod_btn;


    @FXML
    void modHandle(ActionEvent event) throws IOException {
        // old scene hide
        mod_btn.getScene().getWindow().hide();
        //New Scene
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "StuModule.fxml"
                )
        );

        Stage stage = new Stage();
        stage.setScene(
                new Scene(loader.load())
        );
         StuModule stdmd = loader.getController();
        stdmd.getDetails(deg_cb.getSelectionModel().getSelectedItem(),year_cb.getSelectionModel().getSelectedItem());

        stage.show();
    }

    @FXML
    void handleFac(ActionEvent event) throws IOException {
            if(event.getSource()==home_lbl){
                //oldScene
                home_lbl.getScene().getWindow().hide();

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
//            else if(event.getSource()==cs_btn){
//                //oldScene
//                cs_btn.getScene().getWindow().hide();
//
//                //New Scene
//                FXMLLoader loader = new FXMLLoader(
//                        getClass().getResource(
//                                "CSS_course.fxml"
//                        )
//                );
//
//                Stage stage = new Stage();
//                stage.setScene(
//                        new Scene(loader.load())
//                );
//
//                CSS_course cMod = loader.getController();
//                cMod.setDetails("Certificate in Computer Science");
//                stage.show();
//
//            }
//            else if(event.getSource()==law_btn){
//                //oldScene
//                law_btn.getScene().getWindow().hide();
//
//                //New Scene
//                FXMLLoader loader = new FXMLLoader(
//                        getClass().getResource(
//                                "Law_course.fxml"
//                        )
//                );
//
//                Stage stage = new Stage();
//                stage.setScene(
//                        new Scene(loader.load())
//                );
//                stage.show();
//            }
//            else if(event.getSource()==bus_btn){
//                //oldScene
//                bus_btn.getScene().getWindow().hide();
//
//                //New Scene
//                FXMLLoader loader = new FXMLLoader(
//                        getClass().getResource(
//                                "Business_course.fxml"
//                        )
//                );
//
//                Stage stage = new Stage();
//                stage.setScene(
//                        new Scene(loader.load())
//                );
//                stage.show();
//            }
//            else if(event.getSource()==eng_btn){
//                //oldScene
//                eng_btn.getScene().getWindow().hide();
//
//                //New Scene
//                FXMLLoader loader = new FXMLLoader(
//                        getClass().getResource(
//                                "Engineering_course.fxml"
//                        )
//                );
//
//                Stage stage = new Stage();
//                stage.setScene(
//                        new Scene(loader.load())
//                );
//                stage.show();
//            }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
                deg_cb.setItems(degOB);
                year_cb.setItems(yearOB);
    }
}
