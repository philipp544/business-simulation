package business_simulation;

import java.util.Scanner;

public class BusinessSimulation001 {

    public static void main(String[] args) {
        System.out.println("Wirtschaftssimulation Programmierung II");

        // Objekte instanziieren
        Niederlassung niederlassungEinbeck = new Niederlassung("Einbeck", Warenart.BIER, 1);
        Lager lagerAugsburg = new Lager("Augsburg");
        Scanner scanner = new Scanner(System.in);
        int guthabenInTaler = 0;

        // Schleife für mehrere Runden
        for (int runde = 1; runde <= 3; runde++) { // Beispielhaft für 3 Runden, kann angepasst werden
            System.out.println("Runde " + runde);

            // Übersicht über aktuellen Bestand im Lager und aktuelles Guthaben
            System.out.println("Aktueller Bestand im Lager:");
            lagerAugsburg.printBestand();
            System.out.println("Aktuelles Guthaben: " + guthabenInTaler + " Taler");

            // Entscheidung des Benutzers, ob produziert werden soll
            System.out.println("Möchten Sie in dieser Runde produzieren? (ja/nein)");
            String antwort = scanner.nextLine();
            if (antwort.equalsIgnoreCase("ja")) {
                niederlassungEinbeck.produzieren();
                int produzierteMenge = niederlassungEinbeck.abholen();
                Warenart produzierteWarenart = niederlassungEinbeck.getWarenart();
                lagerAugsburg.einlagern(produzierteWarenart, produzierteMenge);
            }

            // Festlegung der Menge zu verkaufender Ware
            System.out.println("Bitte geben Sie die Menge der zu verkaufenden Ware ein:");
            int mengeZuVerkaufen = scanner.nextInt();
            scanner.nextLine(); // Buffer leeren

            // Verkauf der Ware
            int preis = 10; // Beispielhafter Preis
            int erloes = lagerAugsburg.verkaufen(Warenart.BIER, mengeZuVerkaufen, preis);
            guthabenInTaler += erloes;

            System.out.println("Erlös durch Verkauf: " + erloes);
        }

        scanner.close();
    }
}
