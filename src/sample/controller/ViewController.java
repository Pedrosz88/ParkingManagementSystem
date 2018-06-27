package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

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

public class ViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Masina> viewTView;

    @FXML
    private TableColumn<Masina, String> viewPrenumeColumn;

    @FXML
    private TableColumn<Masina, String> viewNumeColumn;

    @FXML
    private TableColumn<Masina, String> viewMateriaColumn;

    @FXML
    private Button viewExitButton;

    @FXML
    private TableColumn<Masina, Integer> viewVarstaColumn;

    @FXML
    private Button viewBackButton;


    @FXML
    void initialize() {
        viewNumeColumn.setCellValueFactory(new PropertyValueFactory<Masina,String>("Nume"));
        viewPrenumeColumn.setCellValueFactory(new PropertyValueFactory<Masina,String>("Prenume"));
        viewVarstaColumn.setCellValueFactory(new PropertyValueFactory<Masina,Integer>("Varsta"));
        viewMateriaColumn.setCellValueFactory(new PropertyValueFactory<Masina,String>("Materia"));
        viewTView.setItems(getStudents());
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
    public ObservableList<Masina> getStudents() {
        Masina masina;
        String nume, prenume, materia;
        int varsta;
        ObservableList<Masina> students = FXCollections.observableArrayList();
        String dbUrl = "jdbc:mysql://localhost/admin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from student");
            while (myRs.next()) {
                nume = myRs.getString(2);
                prenume = myRs.getString(3);
                varsta = Integer.parseInt(myRs.getString(4));
                materia = myRs.getString(5);
                System.out.println(nume+prenume+varsta+materia);
                students.add(new Masina(nume, prenume, varsta, materia));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}