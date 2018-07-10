package sample.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

import static sample.controller.CheckinController.addedCars;
import static sample.controller.CheckoutClientController.removedCars;

public class ParkingStatusController implements CheckoutClientController.CheckoutControllerInterface, CheckinController.CheckinControllerInterface {

    @FXML
    private Button viewExitButton;

    @FXML
    private Button viewBackButton;

    @FXML
    private TextField currentClientsTField;

    @FXML
    private TextField checkedInClientsTField;

    @FXML
    private TextField checkedOutClientsTField;

    @FXML
    void initialize() {
        statusChecker();

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

    public void statusChecker() {
        String dbUrl = "jdbc:mysql://localhost/proiect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        int countCars = 0;
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRes = myStmt.executeQuery("SELECT * from masini");
            while (myRes.next()) {
                countCars++;
            }
            currentClientsTField.setText(String.valueOf(countCars));
            checkedInClientsTField.setText(String.valueOf(addedCars));
            checkedOutClientsTField.setText((String.valueOf(removedCars)));
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void checkoutButtonPushed() {

    }

    @Override
    public void addMasina() {

    }
}
