import java.util.Scanner;

class DodajdoKonta {
    public static void dodaj() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj kwotę do dodania: ");
        double kwota = scan.nextDouble();
        scan.nextLine();
        Automat.konto += kwota;
        System.out.println("Konto zostało zasilone o " + kwota + "zł. Stan konta: " + Automat.getKonto() + "zł");
        System.out.println("----------------------------------------------------------------");
    }
}