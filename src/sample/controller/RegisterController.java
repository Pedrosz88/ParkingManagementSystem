package sample.controller;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button registerViewButton;

    @FXML
    private Button registerRegisterButton;

    @FXML
    private Button registerExitButton;

    @FXML
    private TextField registernumeClientTField;

    @FXML
    private TextField registernrInmatTField;

    @FXML
    private TextField registermarcaTField;

    @FXML
    private TextField registermodelulTField;

    @FXML
    private TextField registerculoareaTField;

    @FXML
    private TextField registerdataParcareTField;

    @FXML
    private TextField registernrTelefonTField;

    @FXML
    void initialize() {
        registerRegisterButton.setOnAction(event -> {
            String numeClient = registernumeClientTField.getText();
            String nrInmat = registernrInmatTField.getText();
            String marca = registermarcaTField.getText();
            String modelul = registermodelulTField.getText();
            String culoarea = registerculoareaTField.getText();
            String dataParcare = registerdataParcareTField.getText();
            String nrTelefon = registernrTelefonTField.getText();

            addMasina(numeClient,nrInmat,marca,modelul,culoarea,dataParcare,nrTelefon);
        });
        registerViewButton.setOnAction(event -> {
            try {
                viewScreenButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        registerExitButton.setOnAction(e -> {
            Platform.exit();
        });
    }
    public void viewScreenButtonPushed(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("../view/viewAll.fxml"));
        Scene viewScene = new Scene(viewParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }
    public void addMasina(String numeClient, String nrInmat, String marca, String modelul, String culoarea, String dataParcare, String nrTelefon){
        String dbUrl = "jdbc:mysql://localhost/admin?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            String insertDb = "insert into proiect.masini (numeClient, nrInmat, marca, modelul, culoarea, dataParcare, nrTelefon) " +
                    "values ('" + numeClient + "', '" + nrInmat + "', '" + marca + "', '" + modelul + "', '" + culoarea + "', '" + dataParcare + "', '" + nrTelefon + "')";
            System.out.println(insertDb);
            myStmt.executeUpdate(insertDb);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}