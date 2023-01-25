import java.sql.*;
import java.util.Scanner;

public class Automat {
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static double konto = 0.0;

    private static String ostatniPrzedmiot = "";

    public static void main(String[] args) {
        try {
            // Łączenie z bazą danych
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/automat","root", "root");
            stmt = con.createStatement();

            Scanner scan = new Scanner(System.in);
            int wybor;
            do {
                System.out.println("----------------------------------------------------------------");
                System.out.println("MENU");
                System.out.println("1. Wyświetl przedmioty z bazy danych");
                System.out.println("2. Dodaj przedmiot do bazy danych");
                System.out.println("3. Usuń przedmiot z bazy danych");
                System.out.println("4. Dodaj pieniądze do stanu konta");
                System.out.println("5. Kup przedmiot");
                System.out.println("6. Sprawdź ostatnio kupiony przedmiot");
                System.out.println("7. Wydaj resztę");
                System.out.println("8. Sprawdź stan konta");
                System.out.println("9. Wyjdź z programu");
                System.out.println("----------------------------------------------------------------");
                System.out.print("Wybierz opcję: ");
                wybor = scan.nextInt();
                scan.nextLine();

                switch (wybor) {
                    case 1:
                        WyswietlPrzedmioty.wyswietl(con, stmt);
                        break;
                    case 2:
                        System.out.println("Dodawanie przedmiotu do bazy danych, wpisz dane: ");
                        DodajPrzedmiot dodajPrzedmiot = new DodajPrzedmiot(con, stmt);
                        dodajPrzedmiot.dodaj();
                        break;
                    case 3:
                        System.out.println("Usuwanie przedmiotu z bazy danych, wpisz dane: ");
                        UsunPrzedmiot usunPrzedmiot = new UsunPrzedmiot(con, stmt);
                        usunPrzedmiot.usun();
                        break;
                    case 4:
                        DodajdoKonta dodajDoKonta = new DodajdoKonta();
                        dodajDoKonta.dodaj();
                        break;
                    case 5:
                        KupPrzedmiot.kup(con, stmt);
                        break;
                    case 6:
                        SprawdzOstatni.sprawdz();
                        break;
                    case 7:
                        WydajReszte.wydaj();
                        break;
                    case 8:
                        SprawdzKonto.sprawdz();
                        break;
                }
            } while (wybor != 9);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static double getKonto(){
        return konto;
    }
    public static void setKonto(double konto) {
        Automat.konto = konto;
    }
    public static String getOstatniPrzedmiot(){
        return ostatniPrzedmiot;
    }
    public static void setOstatniPrzedmiot(String ostatniPrzedmiot) {
        Automat.ostatniPrzedmiot = ostatniPrzedmiot;
    }





}
