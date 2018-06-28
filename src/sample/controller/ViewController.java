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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewController {

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
        viewNumeClientColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Client"));
        viewnrInmatColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Registration"));
        viewMarcaColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Make"));
        viewModelColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Model"));
        viewColorColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Color"));
        viewPDateColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("P-Date"));
        viewPhoneColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Phone"));
        viewTView.setItems(getmasini());
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

    public ObservableList<Masina> getmasini() {
        Masina masina;
        String numeClient, nrInmat, marca, modelul, culoarea, dataParcare, nrTelefon;
        ObservableList<Masina> masini = FXCollections.observableArrayList();
        String dbUrl = "jdbc:mysql://localhost/admin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from masini");
            while (myRs.next()) {
                numeClient = myRs.getString(2);
                nrInmat = myRs.getString(3);
                marca = myRs.getString(4);
                modelul = myRs.getString(5);
                culoarea = myRs.getString(6);
                dataParcare = myRs.getString(7);
                nrTelefon = myRs.getString(8);
                System.out.println(numeClient + nrInmat + marca + modelul + culoarea + dataParcare + nrTelefon);
                masini.add(new Masina(numeClient, nrInmat, marca, modelul, culoarea, dataParcare, nrTelefon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return masini;
    }
}