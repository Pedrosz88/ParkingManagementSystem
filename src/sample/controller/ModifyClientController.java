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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.model.Masina;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ModifyClientController {
    @FXML
    private TableView<Masina> modifyTView;

    @FXML
    private TableColumn<Masina, String> modifyNumeClientColumn;

    @FXML
    private TableColumn<Masina, String> modifynrInmatColumn;

    @FXML
    private TableColumn<Masina, String> modifyMarcaColumn;

    @FXML
    private TableColumn<Masina, String> modifyModelColumn;

    @FXML
    private TableColumn<Masina, String> modifyColorColumn;

    @FXML
    private TableColumn<Masina, String> modifyPDateColumn;

    @FXML
    private TableColumn<Masina, String> modifyPhoneColumn;

    @FXML
    private TextField findnumeClientTField;

    @FXML
    private Button viewExitButton;

    @FXML
    private Button viewBackButton;

    @FXML
    public Button viewSearchButton;

    @FXML
    private ChoiceBox<String> modifyClientCBox;


    @FXML
    void initialize() {
        modifyClientCBox.setItems(FXCollections.observableArrayList("Client", "Registration", "Make", "Model", "Color", "Parking Date", "Phone"));

        viewSearchButton.setOnAction(event -> {
            try {
                viewSearchButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
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

    private ObservableList<Masina> getMasini(String numeCautat) {
        String numeClient, nrInmat, marca, modelul, culoarea, dataParcare, nrTelefon;
        ObservableList<Masina> masini = FXCollections.observableArrayList();
        String dbUrl = "jdbc:mysql://localhost/proiect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("SELECT * from masini WHERE numeClient = '" + numeCautat + "'");
            while (myRs.next()) {
                numeClient = myRs.getString(2);
                nrInmat = myRs.getString(3);
                marca = myRs.getString(4);
                modelul = myRs.getString(5);
                culoarea = myRs.getString(6);
                dataParcare = myRs.getString(7);
                nrTelefon = myRs.getString(8);
                System.out.println("\n" + numeClient + " " + nrInmat + " " + marca + " " + modelul + " " + culoarea + " " + dataParcare + " " + nrTelefon);
                masini.add(new Masina(numeClient, nrInmat, marca, modelul, culoarea, dataParcare, nrTelefon));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return masini;
    }


    public void backScreenButtonPushed(ActionEvent event) throws IOException {
        Parent welcomeParent = FXMLLoader.load(getClass().getResource("../view/welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

    public void viewSearchButtonPushed(ActionEvent event) throws IOException {
        String numeCautat = (findnumeClientTField.getText());
        if (numeCautat!=null){
            modifyNumeClientColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("NumeClient"));
            modifynrInmatColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("NrInmat"));
            modifyMarcaColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Marca"));
            modifyModelColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Modelul"));
            modifyColorColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("Culoare"));
            modifyPDateColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("DataParcare"));
            modifyPhoneColumn.setCellValueFactory(new PropertyValueFactory<Masina, String>("NrTelefon"));
            modifyTView.setItems(getMasini(numeCautat));
        } else {modifyNumeClientColumn.setCellValueFactory(null);}
    }
}