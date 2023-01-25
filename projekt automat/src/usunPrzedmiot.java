import java.sql.*;
import java.util.Scanner;


class UsunPrzedmiot {
    private Connection con;
    private Statement stmt;


    public UsunPrzedmiot(Connection con, Statement stmt) {
        this.con = con;
        this.stmt = stmt;
    }

    public void usun() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj ID przedmiotu do usunięcia: ");
        int id = scan.nextInt();
        scan.nextLine();

        String query = "DELETE FROM przedmioty WHERE idprzedmioty = " + id;
        stmt.executeUpdate(query);
        System.out.println("Przedmiot został usunięty z bazy danych.");
        System.out.println("----------------------------------------------------------------");
    }
}