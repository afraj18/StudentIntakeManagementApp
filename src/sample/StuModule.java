package sample;

import com.jfoenix.controls.JFXButton;
import database.dbHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StuModule implements Initializable {
    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private TableView<StuModuleModel> tbl;

    @FXML
    private TableColumn<StuModuleModel, String> Mod_Col;

    @FXML
    private TableColumn<StuModuleModel, String> Cred_Col;

    @FXML
    private TableColumn<StuModuleModel, String> Deg_Col;

    @FXML
    private TableColumn<StuModuleModel, String> Year_Col;

    @FXML
    private Label year_lbl;

    @FXML
    private Label degree_lbl;

    public String deg,year;

    ObservableList<StuModuleModel> obList = FXCollections.observableArrayList();


    @FXML
    void HandleBtn(ActionEvent event) throws IOException {
            if(event.getSource()==exit_btn){
                exit_btn.getScene().getWindow().hide();
            }
            else if(event.getSource()==back_btn){
                // old scene hide
                back_btn.getScene().getWindow().hide();
                //New Scene
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "Faculty.fxml"
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

    public void getDetails(String deg,String year){
            year_lbl.setText("Year : "+year);
            degree_lbl.setText("Degree : "+deg);
            this.year = year;
            this.deg = deg;

            getMod();
    }

    public void  getMod(){

        try {
            ResultSet rs = null;
            PreparedStatement prepareStatement = null;

            String query = "SELECT * FROM modules where degree = ? AND year = ? ";
            //+ Const.USER_TABLE+" WHERE "+ Const.USER_USERNAME+"=?"+user+" AND "+Const.USER_PASSWORD +" =? ";
            dbHandler dbhandler = new dbHandler();
            prepareStatement = dbhandler.getDbConn().prepareStatement(query);

            prepareStatement.setString(1, deg);
            prepareStatement.setString(2, year);


            rs = prepareStatement.executeQuery();

            while (rs.next()){
                obList.add(new StuModuleModel(rs.getString("moduleName"),
                        rs.getString("credits"),
                        rs.getString("degree"),
                        rs.getString("year")));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        Mod_Col.setCellValueFactory(new PropertyValueFactory<>("module"));
        Cred_Col.setCellValueFactory(new PropertyValueFactory<>("credit"));
        Deg_Col.setCellValueFactory(new PropertyValueFactory<>("degree"));
        Year_Col.setCellValueFactory(new PropertyValueFactory<>("year"));

        tbl.setItems(obList);


    }
}
