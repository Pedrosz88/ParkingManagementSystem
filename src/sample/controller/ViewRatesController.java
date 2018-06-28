package sample.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.model.Masina;
import sample.model.Tarif;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewRatesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Masina> viewTView;

    @FXML
    private TableColumn<Masina, String> viewNumeClientColumn;

    @FXML
    private TableColumn<Masina, String> viewnrInmatColumn;

    @FXML
    private TableColumn<Masina, String> viewMarcaColumn;

    @FXML
    private TableColumn<Masina, String> viewModelColumn;

    @FXML
    private TableColumn<Masina, String> viewColorColumn;

    @FXML
    private TableColumn<Masina, String> viewPDateColumn;

    @FXML
    private TableColumn<Masina, String> viewPhoneColumn;

    @FXML
    private Button viewExitButton;

    @FXML
    private Button viewBackButton;


    @FXML
    void initialize() {

        viewBackButton.setOnAction(event -> {
            try {
                backScreenButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        viewExitButton.setOnAction(e -> {
            Platform.exit();
        });
    }

    public void backScreenButtonPushed(ActionEvent event) throws IOException {
        Parent welcomeParent = FXMLLoader.load(getClass().getResource("../view/welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

    public ObservableList<Tarif> getTarife() {
        ObservableList<Tarif> tarife = FXCollections.observableArrayList();
        String dbUrl = "jdbc:mysql://localhost/proiect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from tarife");
            while (myRs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarife;
    }
}