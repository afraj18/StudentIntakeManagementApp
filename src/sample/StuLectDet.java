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

public class StuLectDet implements Initializable {

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private TableView<LecturerModelTable> tbl;

    @FXML
    private TableColumn<LecturerModelTable, String> name_col;

    @FXML
    private TableColumn<LecturerModelTable, String> course_col;

    @FXML
    private TableColumn<LecturerModelTable, String> fac_col;

    ObservableList<LecturerModelTable> obList = FXCollections.observableArrayList();
    @FXML
    void HandleBtn(ActionEvent event) throws IOException {
        if(event.getSource()==exit_btn){
            exit_btn.getScene().getWindow().hide();
        }
        else if(event.getSource()==back_btn){
            //oldScene
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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dbHandler dbhandler = new dbHandler();
            Connection conn = dbhandler.getDbConn();

            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM lecturer");

            while (rs.next()){
                obList.add(new LecturerModelTable(rs.getString("name"),
                        rs.getString("faculty"),rs.getString("course_unit")));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        fac_col.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        course_col.setCellValueFactory(new PropertyValueFactory<>("course"));

        tbl.setItems(obList);
    }
}
