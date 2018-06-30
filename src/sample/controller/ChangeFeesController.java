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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ChangeFeesController {

    @FXML
    private TextField changeFeesDailyText;

    @FXML
    private TextField changeFeesBetweenText;

    @FXML
    private TextField changeFeesOverText;

    @FXML
    private TextField changeFeesResultText;

    @FXML
    private Button modifyFeesButton;

    @FXML
    private Button viewExitButton;

    @FXML
    private Button viewBackButton;


    @FXML
    void initialize() {
        modifyFeesButton.setOnAction(event -> {
            int dailyFee = Integer.valueOf(changeFeesDailyText.getText());
            int betweenFee = Integer.valueOf(changeFeesBetweenText.getText());
            int overFee = Integer.valueOf(changeFeesOverText.getText());
            changeFees(dailyFee, betweenFee, overFee);
            modifyFeesButton.setText("DONE!");
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
        Scene welcomeScene = new Scene(welcomeParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(welcomeScene);
        window.show();
    }

    public void changeFees(int dailyFee, int betweenFee, int overFee) {
        String dbUrl = "jdbc:mysql://localhost/proiect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            myStmt.executeUpdate("UPDATE tarife set oZi = '" + dailyFee + "'; ");
            myStmt.executeUpdate("UPDATE tarife set intreDouaSiSapteZile = '" + betweenFee + "';");
            myStmt.executeUpdate("UPDATE tarife set pesteSapteZile = '" + overFee + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}