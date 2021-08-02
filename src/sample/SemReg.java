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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SemReg implements Initializable {
    @FXML
    private Button back_btn;

    @FXML
    private JFXComboBox<String> deg_CBox;
    @FXML
    private JFXComboBox<String> Fac_Cb;

    @FXML
    private JFXTextField u_name_lbl;

    @FXML
    private JFXTextField iName_lbl;

    @FXML
    private JFXButton Reg_btn;

    @FXML
    private JFXComboBox<String> Year_Cb;
    ObservableList<String> deg_observableList = FXCollections.observableArrayList(
            "Computer Science","Management","Law","Engineering");
    ObservableList<String> Fac_observableList = FXCollections.observableArrayList(
            "Faculty of Computer Science","Faculty of Law","Faculty of Management","Faculty of Engineering");
    ObservableList<String> Year_observableList = FXCollections.observableArrayList(
            "1st Year","2nd Year","3rd Year");


//    public void setUserName(String Name){
//        u_name_lbl.setText(Name);
//    }

    @FXML
    void backHandle(ActionEvent event) throws IOException {
        back_btn.getScene().getWindow().hide();
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

    @FXML
    void RegHandle(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
            if(!u_name_lbl.getText().equals("") && !iName_lbl.getText().equals("")){
                if (regNow(
                        u_name_lbl.getText(),
                        iName_lbl.getText(),
                        deg_CBox.getSelectionModel().getSelectedItem(),
                        Fac_Cb.getSelectionModel().getSelectedItem(),
                        Year_Cb.getSelectionModel().getSelectedItem()
                )){
                    back_btn.getScene().getWindow().hide();
                    //New Scene
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource(
                                    "SemRegScs.fxml"
                            )
                    );
                    Stage stage = new Stage();
                    stage.setScene(
                            new Scene(loader.load())
                    );
                    stage.show();


//                    Alert alert = new Alert(Alert.AlertType.WARNING,"Reg Completed", ButtonType.OK);
//                    alert.setTitle("Success");
//                    alert.setHeaderText("");
//
//                    alert.showAndWait();


                }
                else{

                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING,"Failed", ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText("Some fields are left out blank");
                alert.showAndWait();
            }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Year_Cb.setItems(Year_observableList);
        deg_CBox.setItems(deg_observableList);
        Fac_Cb.setItems(Fac_observableList);
    }

    public boolean regNow(String userName,String iName,String degree,String fac,String year)
            throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        dbHandler dbhandler = new dbHandler();
        String insertquery = "INSERT INTO sem_reg (userName,iName,degree,faculty,year) VALUES (?,?,?,?,?)";


        preparedStatement = dbhandler.getDbConn().prepareStatement(insertquery);

        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,iName);
        preparedStatement.setString(3,degree);
        preparedStatement.setString(4,fac);
        preparedStatement.setString(5,year);
//

        int regResultSet = preparedStatement.executeUpdate();

        if(regResultSet==1){
            return true;
        }
        else {
            return false;
        }
    }
}
