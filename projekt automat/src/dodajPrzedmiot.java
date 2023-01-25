import java.sql.*;
import java.util.Scanner;

class DodajPrzedmiot {
    private Connection con;
    private Statement stmt;

    public DodajPrzedmiot(Connection con, Statement stmt) {
        this.con = con;
        this.stmt = stmt;
    }

    public void dodaj() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj id przedmiotu: ");
        int idprzedmioty = scan.nextInt();
        scan.nextLine();
        System.out.print("Podaj nazwę przedmiotu: ");
        String nazwa = scan.nextLine();
        System.out.print("Podaj koszt przedmiotu: ");
        double koszt = scan.nextDouble();
        System.out.print("Podaj ilość przedmiotu: ");
        int ilosc = scan.nextInt();
        scan.nextLine();

        String query = "INSERT INTO przedmioty (idprzedmioty, nazwa, koszt, ilosc) VALUES ("+idprzedmioty +", '"+ nazwa + "', '" + koszt + "', " + ilosc + ")";
        stmt.executeUpdate(query);
        System.out.println("Przedmiot został dodany do bazy danych.");
        System.out.println("----------------------------------------------------------------");

    }
}





