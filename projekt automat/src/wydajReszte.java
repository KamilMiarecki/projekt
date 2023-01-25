class WydajReszte{
    public static void wydaj(){
        double reszta = Automat.getKonto();
        if (reszta > 0) {
            System.out.println("Wydano resztę w wysokości: " + reszta + "zł");
            Automat.setKonto(0);
        } else {
            System.out.println("Brak środków do wydania");
        }
        System.out.println("----------------------------------------------------------------");
    }

}