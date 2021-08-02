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
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LecturerAdd implements Initializable {


    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXTextField lectName_tf;

    @FXML
    private JFXTextField cUnit_tf;

    @FXML
    private JFXButton add_btn;

    @FXML
    private Label rs_lbl;

    @FXML
    private JFXComboBox<String> fac_cb;
    ObservableList<String> fac_ObList = FXCollections.observableArrayList("Faculty of Computer Science",
            "Faculty of Management","Faculty of Law","Facluty of Engineering");


    @FXML
    private JFXButton lecturer_btn;

    @FXML
    void HandleAdd(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if(event.getSource()==add_btn){
            if(!lectName_tf.getText().equals("") &&
                    !cUnit_tf.getText().equals("")){
                if(addLect(lectName_tf.getText(),fac_cb.getSelectionModel().getSelectedItem(),cUnit_tf.getText())){
                    rs_lbl.setVisible(true);
                    rs_lbl.setText("Lecturer Registration Success");

                    //oldScene
                    lecturer_btn.getScene().getWindow().hide();

                    //New Scene
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "Lecturer.fxml"
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
                lectName_tf.setText("");
                cUnit_tf.setText("");
                rs_lbl.setVisible(true);
                rs_lbl.setText("Registration failed");
                Alert alert = new Alert(Alert.AlertType.WARNING,"Please fill all fields", ButtonType.OK);
                alert.setTitle("Registration Failed");
                alert.setHeaderText("Empty fields recognized");

                alert.showAndWait();
            }

        }

    }

    //Adding Lecture to the table Function
    public boolean addLect(String user,String faculty,String course)
            throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        dbHandler dbhandler = new dbHandler();
        String insertquery = "INSERT INTO lecturer (name,course_unit,faculty) VALUES (?,?,?)";


        preparedStatement = dbhandler.getDbConn().prepareStatement(insertquery);

        preparedStatement.setString(1,user);
        preparedStatement.setString(2,course);
        preparedStatement.setString(3,faculty);


        int regResultSet = preparedStatement.executeUpdate();

        if(regResultSet==1){
            return true;
        }
        else {
            return false;
        }
    }
    @FXML
    void handleBtn(ActionEvent event) throws IOException {
            if(event.getSource()==lecturer_btn){
                //oldScene
                lecturer_btn.getScene().getWindow().hide();
                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "Lecturer.fxml"
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fac_cb.setItems(fac_ObList);
    }
}
