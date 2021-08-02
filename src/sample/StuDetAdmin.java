package sample;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StuDetAdmin<Stirng> implements Initializable {

    @FXML
    private JFXButton backBtn;

    @FXML
    private JFXButton exitBtn;

    @FXML
    private TableView<StuModelTable> stuTable;

    @FXML
    private TableColumn<StuModelTable, String> id_Col;

    @FXML
    private TableColumn<StuModelTable, String> name_Col;
    @FXML
    private TableColumn<StuModelTable, String> email_Col;

    @FXML
    private TableColumn<StuModelTable, String> stream_Col;

    @FXML
    private TableColumn<StuModelTable, String> deg_Col;

    ObservableList<StuModelTable> obList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            dbHandler dbhandler = new dbHandler();
            Connection conn = dbhandler.getDbConn();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");

            while(rs.next()){
                obList.add(new StuModelTable(rs.getString("id"),rs.getString("userName"),
                                                rs.getString("email"),rs.getString("stream"),
                                                rs.getString("degree")));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        id_Col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_Col.setCellValueFactory(new PropertyValueFactory<>("name"));
        email_Col.setCellValueFactory(new PropertyValueFactory<>("email"));
        stream_Col.setCellValueFactory(new PropertyValueFactory<>("stream"));
        deg_Col.setCellValueFactory(new PropertyValueFactory<>("degree"));
        stuTable.setItems(obList);

    }

    @FXML
    void backActions(ActionEvent event) throws IOException {
        if(event.getSource()==backBtn){
            //oldScene
            backBtn.getScene().getWindow().hide();

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
        else if(event.getSource()==exitBtn){
            //Hide
            exitBtn.getScene().getWindow().hide();

        }
    }
}
