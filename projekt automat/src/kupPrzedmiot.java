import java.sql.*;
import java.util.Scanner;

class KupPrzedmiot {
    public static void kup(Connection con, Statement stmt) {
        try {
            Scanner scan = new Scanner(System.in);
            ResultSet rs;
            System.out.print("Podaj ID przedmiotu: ");
            int id = scan.nextInt();
            scan.nextLine();
            String sql = "SELECT * FROM przedmioty WHERE idprzedmioty = " + id;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String nazwa = rs.getString("nazwa");
                double cena = rs.getDouble("koszt");
                int ilosc = rs.getInt("ilosc");
                if (ilosc > 0) {
                    if (Automat.getKonto() >= cena) {
                        Automat.setKonto(Automat.getKonto() - cena);
                        ilosc--;
                        sql = "UPDATE przedmioty SET ilosc = " + ilosc + " WHERE idprzedmioty = " + id;
                        stmt.executeUpdate(sql);
                        Automat.setOstatniPrzedmiot(nazwa);
                        System.out.println("Kupiono " + nazwa + " za " + cena + "zł. Stan konta: " + Automat.getKonto() + "zł");
                    } else {
                        System.out.println("Brak wystarczającej ilości środków na koncie");
                    }
                } else {
                    System.out.println("Przedmiot jest niedostępny");
                }
            } else {
                System.out.println("Podany przedmiot nie istnieje");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------------------------------------");
    }

}