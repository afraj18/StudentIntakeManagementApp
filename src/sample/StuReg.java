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
import javafx.scene.Parent;
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

public class StuReg implements Initializable {

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXTextField userName_lbl;

    @FXML
    private JFXPasswordField pwd_lbl;

    @FXML
    private JFXButton RegBtn;

    @FXML
    private JFXPasswordField c_pwd_lbl;

    @FXML
    private JFXTextField iName_lbl;

    @FXML
    private JFXTextField fName_lbl;

    @FXML
    private JFXTextField stream_lbl;

    @FXML
    private JFXTextField z_score_lbl;

    @FXML
    private JFXTextField c_no_lbl;

    @FXML
    private JFXTextField deg_lbl;

    @FXML
    private JFXTextField email_lbl;

    @FXML
    private Label log_status;


    @FXML
    private JFXTextField homeTown_lbl;


    @FXML
    private JFXComboBox<String> deg_Cb;

    @FXML
    private JFXComboBox<String> stream_Cb;

    ObservableList<String> deg_observableList = FXCollections.observableArrayList(
            "Computer Science","Management","Law","Engineering");
    ObservableList<String> stream_observableList = FXCollections.observableArrayList(
            "Commerce","Science","Arts","Technology");

    @FXML
    void regHandle(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        dbHandler regDBHandler = new dbHandler();
        boolean result = regNow(userName_lbl.getText(),email_lbl.getText(),pwd_lbl.getText(),
                fName_lbl.getText(),iName_lbl.getText(),stream_Cb.getSelectionModel().getSelectedItem(),deg_Cb.getSelectionModel().getSelectedItem(),
                c_no_lbl.getText(),z_score_lbl.getText(),homeTown_lbl.getText());

        if(!userName_lbl.getText().trim().equals("") && !pwd_lbl.getText().trim().equals("")){
            if(pwd_lbl.getText().trim().equals(c_pwd_lbl.getText().trim())){
              if(result){
                  log_status.setVisible(true);
                  log_status.setText("Login Success");

                  // old scene hide
                  RegBtn.getScene().getWindow().hide();
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
              else{ //DB PRoblem
                  log_status.setVisible(true);
                  log_status.setText("UserName Already exists");
              }
          }else{ // Password Dont Match
//              log_status.setVisible(true);
//              log_status.setText("Passwords Dont Match");

                pwd_lbl.setText("");
                c_pwd_lbl.setText("");
                Alert alert = new Alert(Alert.AlertType.WARNING,"Passwords Don't match ", ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText("Please Enter same passwords in both fields");

                alert.showAndWait();
          }
        }else{ // Empty Fields
//            log_status.setVisible(true);
//            log_status.setText("Insert Values");
//            log_status.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.WARNING,"Fill all the fields", ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText("Some fields are left out blank");

            alert.showAndWait();
        }
    }




    @FXML
    void BackHandle(ActionEvent event) throws IOException {
       if(event.getSource()==back){
           back.getScene().getWindow().hide();
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
       else if(event.getSource()==back_btn){
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
    }

    public boolean regNow(String user,String email,String pass,
                          String fname,String iName,String stream,String degree,String c_no,String zscore,String town)
            throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        dbHandler dbhandler = new dbHandler();
        String insertquery = "INSERT INTO students (userName,password,email,fname,nameInitial,stream,degree,c_no,zscore,city) VALUES (?,?,?,?,?,?,?,?,?,?)";


        preparedStatement = dbhandler.getDbConn().prepareStatement(insertquery);

        preparedStatement.setString(1,user);
        preparedStatement.setString(2,pass);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,fname);
        preparedStatement.setString(5,iName);
        preparedStatement.setString(6,stream);
        preparedStatement.setString(7,degree);
        preparedStatement.setString(8,c_no);
        preparedStatement.setString(9,zscore);
        preparedStatement.setString(10,town);

        int regResultSet = preparedStatement.executeUpdate();

        if(regResultSet==1){
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deg_Cb.setItems(deg_observableList);
        stream_Cb.setItems(stream_observableList);
    }

}



