package sample.controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomeController {
    @FXML
    private Button welcomeExitButton;

    @FXML
    private Button welcomeRegisterButton;

    @FXML
    private Button welcomeViewClientButton;

    @FXML
    private Button welcomeModifyClientButton;

    @FXML
    private Button welcomeCheckoutClientButton;

    @FXML
    private Button welcomeViewAllButton;

    @FXML
    private Button welcomeParkingStatusButton;

    @FXML
    private Button welcomeCurrentRatesButton;

    @FXML
    private Button welcomeChangeRatesButton;

    @FXML
    void initialize() {
        welcomeRegisterButton.setOnAction(event -> {
            try {
                registerScreenButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeViewClientButton.setOnAction(event -> {
            try {
                welcomeViewClientButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeModifyClientButton.setOnAction(event -> {
            try {
                welcomeModifyClientButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeCheckoutClientButton.setOnAction(event -> {
            try {
                welcomeCheckoutClientButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeViewAllButton.setOnAction(event -> {
            try {
                welcomeViewAllButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeParkingStatusButton.setOnAction(event -> {
            try {
                welcomeParkingStatusButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeCurrentRatesButton.setOnAction(event -> {
            try {
                welcomeCurrentRatesButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeChangeRatesButton.setOnAction(event -> {
            try {
                welcomeChangeRatesButtonPushed(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        welcomeExitButton.setOnAction(e -> {
            Platform.exit();
        });
    }

    public void registerScreenButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
        Scene registerScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registerScene);
        window.show();
    }

    public void welcomeViewClientButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/viewClient.fxml"));
        Scene viewClientScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewClientScene);
        window.show();
    }

    public void welcomeModifyClientButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/modifyClient.fxml"));
        Scene modifyClientScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(modifyClientScene);
        window.show();
    }

    public void welcomeCheckoutClientButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/checkoutClient.fxml"));
        Scene checkoutClientScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(checkoutClientScene);
        window.show();
    }

    public void welcomeViewAllButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/viewAll.fxml"));
        Scene viewAllScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(viewAllScene);
        window.show();
    }

    public void welcomeParkingStatusButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/parkingStatus.fxml"));
        Scene parkingStatusScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(parkingStatusScene);
        window.show();
    }

    public void welcomeCurrentRatesButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/currentFees.fxml"));
        Scene currentRatesScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(currentRatesScene);
        window.show();
    }

    public void welcomeChangeRatesButtonPushed(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../view/changeFees.fxml"));
        Scene changeRatesScene = new Scene(registerParent, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(changeRatesScene);
        window.show();
    }
}