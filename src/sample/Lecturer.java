package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import database.dbHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Lecturer implements Initializable {
    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton back_btn;
    @FXML
    private TableView<LecturerModelTable> lect_tbl;

    @FXML
    private TableColumn<ObservableList, String> id_col;

    @FXML
    private TableColumn<LecturerModelTable, String> name_col;

    @FXML
    private TableColumn<LecturerModelTable, String> fac_col;

    @FXML
    private TableColumn<LecturerModelTable, String> course_col;

    ObservableList<String> fac_ObList = FXCollections.observableArrayList("Faculty of Computer Science",
            "Faculty of Management","Faculty of Law","Facluty of Engineering");

    ObservableList<LecturerModelTable> obList = FXCollections.observableArrayList();
    //MainHandler


   //Initializable
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            dbHandler dbhandler = new dbHandler();
            Connection conn = dbhandler.getDbConn();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM lecturer");

            while (rs.next()){
                obList.add(new LecturerModelTable(rs.getString("id"),rs.getString("name"),
                            rs.getString("faculty"),rs.getString("course_unit")));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        fac_col.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        course_col.setCellValueFactory(new PropertyValueFactory<>("course"));

        lect_tbl.setItems(obList);




    }

    @FXML
    void handleBtn(ActionEvent event) throws IOException {
        if(event.getSource()==exit_btn){
            //Hide
            exit_btn.getScene().getWindow().hide();
        }
        else if(event.getSource()==back_btn){
            //oldScene
            back_btn.getScene().getWindow().hide();

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
    }


}
