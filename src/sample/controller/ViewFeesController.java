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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.model.Tarif;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewFeesController {
    @FXML
    private TableView<Tarif> viewTView;

    @FXML
    private TableColumn<Tarif, Integer> viewDailyRateColumn;

    @FXML
    private TableColumn<Tarif, Integer> view2_7DaysRateColumn;

    @FXML
    private TableColumn<Tarif, Integer> viewOver7DaysRateColumn;

    @FXML
    private Button viewExitButton;

    @FXML
    private Button viewBackButton;


    @FXML
    void initialize() {
        viewDailyRateColumn.setCellValueFactory(new PropertyValueFactory<Tarif, Integer>("OZi"));
        view2_7DaysRateColumn.setCellValueFactory(new PropertyValueFactory<Tarif, Integer>("IntreDouaSiSapteZile"));
        viewOver7DaysRateColumn.setCellValueFactory(new PropertyValueFactory<Tarif, Integer>("PesteSapteZile"));
        viewTView.setItems(getTarife());
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

    public ObservableList<Tarif> getTarife() {
        int oZi,intre2si7zile,peste7zile;
        ObservableList<Tarif> tarife = FXCollections.observableArrayList();
        String dbUrl = "jdbc:mysql://localhost/proiect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Pedrosz23";
        try {
            Connection myConn = DriverManager.getConnection(dbUrl, user, password);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from tarife");
            while (myRs.next()) {
                oZi = myRs.getInt(2);
                intre2si7zile = myRs.getInt(3);
                peste7zile = myRs.getInt(4);
                tarife.add(new Tarif(oZi,intre2si7zile,peste7zile));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarife;
    }
}