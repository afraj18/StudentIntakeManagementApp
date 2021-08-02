package sample;

import com.jfoenix.controls.JFXButton;
import database.dbHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentHome implements Initializable {

    @FXML
    private Button fac_btn;

    @FXML
    private Button mod_btn;

    @FXML
    private Button SemReg_btn;

    @FXML
    private Label name_lbl;

    @FXML
    private Label email_lbl;

    @FXML
    private Label degree_lbl;

    @FXML
    private Label town_lbl;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private Label cNo_lbl;

    @FXML
    private Button back_btn;


    @FXML
    private JFXButton lect_btn;

    @FXML
    void HomePageHandle(ActionEvent event) throws IOException {
            if(event.getSource()==back_btn){
//                name_lbl.setText("Btnwrking");
                back_btn.getScene().getWindow().hide();
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
//                  StudentHome std = loader.getController();
//                  std.setDetails(userName_lbl.getText());
                stage.show();

            }
            else if(event.getSource()==fac_btn){
//                name_lbl.setText("FacSuccess");
                fac_btn.getScene().getWindow().hide();
                //New Scene
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Faculty.fxml"));
                stage.setScene(new Scene(root, 700, 560));
                stage.show();
            }
//            else if(event.getSource()==mod_btn){
//                mod_btn.getScene().getWindow().hide();
//                //New Scene
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("Module.fxml"));
//                stage.setScene(new Scene(root, 637, 575));
//                stage.show();
//            }
            else if(event.getSource()==SemReg_btn){
//                name_lbl.setText("SemSuccess");
                SemReg_btn.getScene().getWindow().hide();

                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "SemReg.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );
//                SemReg semReg =loader.getController();
////                semReg.setUserName(name_lbl.getText());

                stage.show();
            }
            else if (event.getSource()==lect_btn){
               lect_btn.getScene().getWindow().hide();

                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "StuLectDet.fxml"
                        )
                );
                Stage stage = new Stage();
                stage.setScene(
                        new Scene(loader.load())
                );

                stage.show();
            }
            else if (event.getSource()==exit_btn){
                exit_btn.getScene().getWindow().hide();
            }

    }



//    public void setDetails(String name) throws SQLException, ClassNotFoundException {
//        ResultSet resultSet = null;
//        PreparedStatement prepareStatement = null;
//
//        String query = "SELECT * FROM students WHERE userName = ? ";
//        //+ Const.USER_TABLE+" WHERE "+ Const.USER_USERNAME+"=?"+user+" AND "+Const.USER_PASSWORD +" =? ";
//        dbHandler dbhandler = new dbHandler();
//        prepareStatement = dbhandler.getDbConn().prepareStatement(query);
//
//        prepareStatement.setString(1, name);
//
//
//        resultSet = prepareStatement.executeQuery();
//
//        if (resultSet.next()) {
//            String Dname = resultSet.getString("fname");
//            name_lbl.setText(Dname);
//            String Dmail = resultSet.getString("email");
//            email_lbl.setText(Dmail);
//            String DDeg = resultSet.getString("degree");
//            degree_lbl.setText(DDeg);
//            String Dtown = resultSet.getString("city");
//            town_lbl.setText(Dtown);
//            String DCNo = resultSet.getString("c_no");
//            cNo_lbl.setText(DCNo);
//        }
//    }

        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
