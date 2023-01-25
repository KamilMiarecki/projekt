import java.sql.*;
import java.util.Scanner;



class WyswietlPrzedmioty{
    public static void wyswietl(Connection con, Statement stmt) throws SQLException {
        String query = "SELECT * FROM przedmioty";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int idprzedmioty = rs.getInt("idprzedmioty");
            String nazwa = rs.getString("nazwa");
            double koszt = rs.getDouble("koszt");
            int ilosc = rs.getInt("ilosc");
            System.out.println( + idprzedmioty +". " + nazwa + ", cena: " + koszt + "zł, Ilość: " + ilosc);
        }
        System.out.println("----------------------------------------------------------------");
    }

}