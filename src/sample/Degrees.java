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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Degrees implements Initializable {
    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private TableView<degreeModelTable> tbl;

    @FXML
    private TableColumn<degreeModelTable, String> deg_Col;

    @FXML
    private TableColumn<degreeModelTable, String> year_Col;

    @FXML
    private TableColumn<degreeModelTable, String> fac_Col;

    ObservableList<degreeModelTable> obList = FXCollections.observableArrayList();

    @FXML
    void HandleBtn(ActionEvent event) throws IOException {
        if(event.getSource()==exit_btn){
            exit_btn.getScene().getWindow().hide();
        }
        else if(event.getSource()==back_btn){
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

            stage.show();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dbHandler dbhandler = new dbHandler();
            Connection conn = dbhandler.getDbConn();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM degreeTbl");

            while (rs.next()){
                obList.add(new degreeModelTable(rs.getString("degreeName"),
                        rs.getString("facultyName"),rs.getString("years")));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        deg_Col.setCellValueFactory(new PropertyValueFactory<>("deg"));
        fac_Col.setCellValueFactory(new PropertyValueFactory<>("fac"));
        year_Col.setCellValueFactory(new PropertyValueFactory<>("year"));

        tbl.setItems(obList);
    }
}
