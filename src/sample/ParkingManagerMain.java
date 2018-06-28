package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.PM.Calculator;

import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class ParkingManagerMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/welcome.fxml"));
        primaryStage.setTitle("Parking Management System");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }

    static Scanner scan = new Scanner(System.in);

    public static void meniu() { // Sistem de Management pentru Parcari Private
        System.out.println("\n------------- MENIU ------------");
        System.out.println(" 1. Afiseaza lista clientilor");
        System.out.println(" 2. Afiseaza date client");
        System.out.println(" 3. Afiseaza tarifele actuale");
        System.out.println(" 4. Adauga client");
        System.out.println(" 5. Modifica date client");
        System.out.println(" 6. Checkout client");
        System.out.println(" 7. Modifica tarifele");
        System.out.println(" 0. Inchidere program");
        System.out.println("----------------------------©SzP");
    }

    public static void main(String[] args) {
        launch(args);
        boolean exit = false;
        String dbUrl = "jdbc:mysql://localhost/proiect?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "Pedrosz23";
        meniu();
        try {
            Connection con = DriverManager.getConnection(dbUrl, user, pass);
            Statement stmt = con.createStatement();
            Statement stmt2 = con.createStatement();
            while (exit == false) {
                System.out.println("\n Meniu: m ");
                System.out.print(">> Optiune: ");
                String opt = scan.nextLine();
                String optiune = opt.toLowerCase();
                switch (optiune) {
                    case "m":
                        meniu();
                        break;
                    case "1":
                        afiseazaClientiDB(stmt);
                        break;
                    case "2":
                        System.out.print("Afiseaza datele clientului: ");
                        String client = scan.nextLine();
                        afiseazaDB(stmt, client);
                        break;
                    case "3":
                        afiseazaTarife(stmt2);
                        break;
                    case "4":
                        adaugaClientDB(stmt);
                        break;
                    case "5":
                        modificaClientDB(stmt);
                        break;
                    case "6":
                        checkout(stmt, stmt2);
                        break;
                    case "7":
                        modificaTarife(stmt2);
                        break;
                    case "0":
                        System.out.println("\nLa revedere!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Optiune gresita!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void afiseazaClientiDB(Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT numeClient FROM masini");
            System.out.print("Clienti existenti: ");
            while (rs.next()) {
                String numeClient = rs.getString("numeClient");
                System.out.print(numeClient + ", ");
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void afiseazaDB(Statement stmt, String client) {
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * from masini WHERE numeClient = '" + client + "'");
            if (rs.next()) {
                System.out.println("\n-----------------------------------");
                System.out.println("  Datele clientului " + client);
                System.out.println("-----------------------------------");
                String nrInmat = rs.getString(3);
                System.out.println("Numar inmatriculare: " + nrInmat);
                String marca = rs.getString(4);
                System.out.println("Marca masina: " + marca);
                String modelul = rs.getString(5);
                System.out.println("Model masina: " + modelul);
                String culoarea = rs.getString(6);
                System.out.println("Culoare masina: " + culoarea);
                String dataParcare = rs.getString(7);
                System.out.println("Data parcarii: " + dataParcare);
                String nrTelefon = rs.getString(8);
                System.out.println("Nr. telefon: " + nrTelefon);
            } else System.out.println("Client inexistent! Verificati numele introdus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adaugaClientDB(Statement stmt) {
        try {
            System.out.print("Nume client: ");
            String numeClient = scan.nextLine();
            System.out.print("Numar inmatriculare: ");
            String nrInmat = scan.nextLine();
            System.out.print("Marca masina: ");
            String marca = scan.nextLine();
            System.out.print("Model masina: ");
            String modelul = scan.nextLine();
            System.out.print("Culoare masina: ");
            String culoarea = scan.nextLine();
            System.out.print("Data parcarii: ");
            String dataParcare = scan.nextLine();
            System.out.print("Nr. telefon: ");
            String nrTelefon = scan.nextLine();
            stmt.executeUpdate("insert into masini (numeClient, nrInmat, marca, modelul, culoarea, dataParcare, nrTelefon) " +
                    "values ('" + numeClient + "', '" + nrInmat + "', '" + marca + "', '" + modelul + "', '" + culoarea + "', '" + dataParcare + "', '" + nrTelefon + "')");
            System.out.println("Clientul a fost adaugat!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void modificaClientDB(Statement stmt) {
        try {
            System.out.print("Numele clientului: ");
            String client = scan.nextLine();
            ResultSet rs = stmt.executeQuery("SELECT * FROM masini where numeClient = '" + client + "'");
            if (rs.next()) {
                System.out.print("Informatia ce doriti sa o modificati (nrInmat/marca/modelul/culoarea/dataParcare/nrTelefon): ");
                String colVeche = scan.nextLine();
                System.out.print(colVeche + ": ");
                String info = scan.nextLine();
                String infoVechi = null;
                infoVechi = rs.getString(colVeche);
                stmt.executeUpdate("UPDATE masini SET " + colVeche + " = REPLACE(" + colVeche + ", '" + infoVechi + "', '" + info + "') WHERE INSTR(numeClient, '" + client + "')");
                System.out.println("\nModificare efectuata cu succes!");
                afiseazaDB(stmt, client);
            } else System.out.println("Client inexistent! Verificati numele introdus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkout(Statement stmt, Statement stmt2) {
        ResultSet rs;
        System.out.print("Checkout client: ");
        String client = scan.nextLine();
        try {
            rs = stmt.executeQuery("SELECT * FROM masini where numeClient = '" + client + "'");
            if (rs.next()) {
                System.out.println("\n-----------------------------------");
                System.out.println("       CHECKOUT  " + client);
                System.out.println("-----------------------------------");
                String dataParcare = rs.getString(7);
                System.out.println("    Data parcarii: " + dataParcare);
                long totalZile = Calculator.calculZile(dataParcare);
                System.out.println("    Zile stationate: " + totalZile);
                long totalPlata = Calculator.calculPlata(stmt2, totalZile);
                System.out.println("    Total de plata: " + totalPlata + " Ron");
                stmt.executeUpdate("DELETE FROM masini where numeClient = '" + client + "'");
                System.out.println("\n Clientul a fost scos din sistem!");
            } else System.out.println("Client inexistent! Verificati numele introdus.");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void afiseazaTarife(Statement stmt2) {
        try {
            ResultSet rs = stmt2.executeQuery("SELECT * FROM proiect.tarife");
            while (rs.next()) {
                int tf1Act = rs.getInt(2);
                int tf2Act = rs.getInt(3);
                int tf3Act = rs.getInt(4);
                System.out.println("\nTarifele actuale sunt: ");
                System.out.println("  O zi: " + tf1Act + " Ron");
                System.out.println("  Intre 2 si 7 zile: " + tf2Act + " Ron");
                System.out.println("  Peste 7 zile: " + tf3Act + " Ron");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void modificaTarife(Statement stmt2) {
        try {
            ResultSet rs = stmt2.executeQuery("SELECT * FROM tarife");
            afiseazaTarife(stmt2);
            System.out.print("\nTariful nou pentru stationare 1 zi: ");
            int tf1Nou = scan.nextInt();
            System.out.print("Tarif stationare intre 2 si 7 zile: ");
            int tf2Nou = scan.nextInt();
            System.out.print("Tarif stationare peste 7 zile: ");
            int tf3Nou = scan.nextInt();
            stmt2.executeUpdate("UPDATE tarife set oZi = '" + tf1Nou + "'; ");
            stmt2.executeUpdate("UPDATE tarife set intreDouaSiSapteZile = '" + tf2Nou + "';");
            stmt2.executeUpdate("UPDATE tarife set pesteSapteZile = '" + tf3Nou + "';");
            scan.nextLine();
            System.out.println("\nTarifele au fost actualizate!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
