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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.PM.Calculator;
import sample.model.Masina;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;

public class CheckoutClientController {

    @FXML
    private TextField findnumeClientTField;

    @FXML
    private TextField parkingDateTField;

    @FXML
    private TextField daysParkedTField;

    @FXML
    private TextField statusTField;

    @FXML
    private TextField toPayTField;

    @FXML
    private Button viewExitButton;

    @FXML
    private Button viewBackButton;

    @FXML
    public Button checkoutButton;

    @FXML
    void initialize() {

        checkoutButton.setOnAction(event -> {
            try {
                checkoutButtonPushed(event);
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

    public void checkoutButtonPushed(ActionEvent event) throws IOException {
        String dbUrl = "jdbc:mysql://localhost/proiect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        String numeCautat = (findnumeClientTField.getText());
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement mySt = myConn.createStatement();
            Statement mySt2 = myConn.createStatement();
            ResultSet myRes = mySt.executeQuery("SELECT * from masini WHERE numeClient = '" + numeCautat + "'");
            while (myRes.next()) {
                String dataParcare = myRes.getString(7);
                parkingDateTField.setText(dataParcare);
                long totalZile = Calculator.calculZile(dataParcare);
                daysParkedTField.setText(String.valueOf(totalZile));
                statusTField.setText("Removed from system.");
                long totalPlata = Calculator.calculPlata(mySt2, totalZile);
                toPayTField.setText(String.valueOf(totalPlata));
                mySt.executeUpdate("DELETE FROM masini where numeClient = '" + numeCautat + "'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

