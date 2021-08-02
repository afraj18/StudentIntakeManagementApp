package sample;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminFac implements Initializable {

    @FXML
    private JFXTextField facName_tf;

    @FXML
    private JFXButton add_btn;

    @FXML
    private TableView tbl;

    @FXML
    private JFXButton exit_btn;

    @FXML
    private JFXButton back_btn;



    @FXML
    private JFXTextField maxStu_tf;

    public AdminFac() throws SQLException, ClassNotFoundException {
    }
    @FXML
    void handleBtn(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
            if(event.getSource()==exit_btn){
                exit_btn.getScene().getWindow().hide();
            }
            else if(event.getSource()==back_btn){
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

    @FXML
    void handleAdd(ActionEvent event) {
        if (facName_tf.getText().isEmpty() || maxStu_tf.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Fill all text fields", ButtonType.OK);
            alert.setTitle("Action not performed");
            alert.setHeaderText("Empty Strings spotted");

            alert.showAndWait();
        } else {
            saveData();
        }
    }
    PreparedStatement preparedStatement;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fetColumnList();
        fetRowList();
    }

    @FXML
    private void HandleEvents(MouseEvent event) {
        //check if not empty
//        if (facName_tf.getText().isEmpty() || maxStu_tf.getText().isEmpty()) {
//
////            lblStatus.setText("Enter all details");
//        } else {
//            saveData();
//        }

    }

    private void clearFields() {
        facName_tf.clear();
        maxStu_tf.clear();

    }

    private String saveData() {

        try {
            dbHandler dbHandler = new dbHandler();
            Connection conn = dbHandler.getDbConn();
            String st = "INSERT INTO faculty (facultyName,max_stu) VALUES (?,?)";
            preparedStatement = conn.prepareStatement(st);
            preparedStatement.setString(1, facName_tf.getText());
            preparedStatement.setString(2, maxStu_tf.getText());


            preparedStatement.executeUpdate();
//            lblStatus.setTextFill(Color.GREEN);
//            lblStatus.setText("Added Successfully");

            fetRowList();
            //clear fields
            clearFields();
            return "Success";

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
//            lblStatus.setTextFill(Color.TOMATO);
//            lblStatus.setText(ex.getMessage());
            return "Exception";
        }
    }

    private ObservableList<ObservableList> data;
    String SQL = "SELECT * from faculty";

    //only fetch columns
    private void fetColumnList() {

        try {
            dbHandler dbHandler = new dbHandler();
            Connection connn = dbHandler.getDbConn();
            ResultSet rs = connn.createStatement().executeQuery(SQL);

            //SQL FOR SELECTING ALL OF CUSTOMER
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1).toUpperCase());
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                tbl.getColumns().removeAll(col);
                tbl.getColumns().addAll(col);

//                System.out.println("Column [" + i + "] ");

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());

        }
    }

    //fetches rows and data from the list
    private void fetRowList() {
        data = FXCollections.observableArrayList();
        ResultSet rs;
        try {
            dbHandler dbHandler = new dbHandler();
            Connection con = dbHandler.getDbConn();
            rs = con.createStatement().executeQuery(SQL);

            while (rs.next()) {
                //Iterate Row
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }
//                System.out.println("Row [1] added " + row);
                data.add(row);

            }
            tbl.setItems(data);
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }


}
