package sample.PM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculator {
    private static final DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

    public static long calculZile(String dataParcare) throws ParseException {
        Date dataParcarii = getDate(dataParcare);
        Date dataDeAstazi = new Date();
        long nrZile = calculZile(dataParcarii, dataDeAstazi);
        return nrZile;
    }

    private static Date getDate(String date) throws ParseException {
        return format.parse(date);                                  //transforma Stringul in data
    }

    private static long calculZile(Date dataParcarii, Date dataDeAstazi) {
        long diferenta = (dataParcarii.getTime() - (dataDeAstazi.getTime() + 86400000)) / 86400000; //data de azi + 1 zi, converit din milisecunde
        return Math.abs(diferenta);
    }


    public static long calculPlata(Statement stmt2, long totalZile) {
        ResultSet rs = null;
        long suma = 0;
        try {
            rs = stmt2.executeQuery("SELECT * FROM tarife");
            while (rs.next()) {
                int tarif1 = rs.getInt(2);
                int tarif2 = rs.getInt(3);
                int tarif3 = rs.getInt(4);
                if (totalZile == 1) suma = totalZile * tarif1;
                else if (totalZile <= 7) suma = totalZile * tarif2;
                else suma = totalZile * tarif3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suma;
    }
}
