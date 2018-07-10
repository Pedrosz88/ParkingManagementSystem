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

    static int removedCars;

    @FXML
    void initialize() {

        checkoutButton.setOnAction(event -> {
            checkoutButtonPushed(event);
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


    public void backScreenButtonPushed(ActionEvent event) throws IOException {
        Parent welcomeParent = FXMLLoader.load(getClass().getResource("../view/welcome.fxml"));
        Scene welcomeScene = new Scene(welcomeParent, 793, 420);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

    public void checkoutButtonPushed(ActionEvent event) {
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
                statusTField.setText("Removed from system!");
                long totalPlata = Calculator.calculPlata(mySt2, totalZile);
                toPayTField.setText(String.valueOf(totalPlata + " Ron"));
                mySt.executeUpdate("DELETE FROM masini where numeClient = '" + numeCautat + "'");
                removedCars++;
            }
        } catch (SQLException e) {
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public interface CheckoutControllerInterface {
        void checkoutButtonPushed();
    }
}

