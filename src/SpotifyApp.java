import java.util.ArrayList;
import java.util.Scanner;

public class SpotifyApp {
    private static ArrayList<Sang> sangListe = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static User bruger;

    //Main metode
    public static void main(String[] args) {

        // Spørgen om brugerens username
        System.out.print("Indtast dit Username: ");
        String navn = scanner.nextLine();

        // Spørger
        System.out.print("Er du Premium-bruger? (ja/nej): ");
        String svar = scanner.nextLine().toLowerCase();
        bruger = svar.equals("ja") ? new PremiumUser(navn) : new FreeUser(navn);

        // Menu hvor brugeren kan vælge input do-while lykke
        int valg;
        do {
            bruger.showAdvertisment();
            System.out.println("\n MENU: ");
            System.out.println("1. Tilføj sang");
            System.out.println("2. Fjern sang");
            System.out.println("3. Find sang");
            System.out.println("4. Vis alle sange");
            System.out.println("5. Rediger sangtitel");
            System.out.println("6. Download sang");
            System.out.println("0. Afslut");
            System.out.print("Vælg: ");
            valg = Integer.parseInt(scanner.nextLine());

            switch (valg) {
                case 1 -> tilfoejSang();
                case 2 -> fjernSang();
                case 3 -> findSang();
                case 4 -> visAlleSange();
                case 5 -> redigerTitel();
                case 6 -> downloadSang();
                case 0 -> System.out.println("Farvel, " + navn + "!");
                default -> System.out.println("Ugyldigt valg.");
            }
        } while (valg != 0);
    }
    //
    private static void tilfoejSang() {
        System.out.print("Titel: ");
        String titel = scanner.nextLine();
        System.out.print("Genre (ROCK, POP, JAZZ, REGGAE, CLASSICAL, HIPHOP, ELECTRONIC): ");
        try {
            Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
            sangListe.add(new Sang(titel, genre));
            System.out.println(" Sang tilføjet.");
        } catch (IllegalArgumentException e) {
            System.out.println(" Ugyldig genre.");
        }
    }

    private static void fjernSang() {
        System.out.print("Titel på sang der skal fjernes: ");
        String titel = scanner.nextLine();
        boolean fjernet = sangListe.removeIf(s -> s.getTitel().equalsIgnoreCase(titel));
        System.out.println(fjernet ? " Sang fjernet." : " Sang ikke fundet.");
    }

    private static void findSang() {
        System.out.print("Titel på sang der skal findes: ");
        String titel = scanner.nextLine();
        for (Sang s : sangListe) {
            if (s.getTitel().equalsIgnoreCase(titel)) {
                System.out.println(" Fundet: " + s);
                return;
            }
        }
        System.out.println(" Ingen sang med den titel.");
    }

    private static void visAlleSange() {
        if (sangListe.isEmpty()) {
            System.out.println(" Listen er tom.");
        } else {
            System.out.println(" Alle sange:");
            for (Sang s : sangListe) {
                System.out.println(s);
            }
        }
    }

    private static void redigerTitel() {
        System.out.print("Titel på sang der skal redigeres: ");
        String gammelTitel = scanner.nextLine();
        for (Sang s : sangListe) {
            if (s.getTitel().equalsIgnoreCase(gammelTitel)) {
                System.out.print("Ny titel: ");
                s.setTitel(scanner.nextLine());
                System.out.println(" Titel opdateret.");
                return;
            }
        }
        System.out.println(" Sang ikke fundet.");
    }

    private static void downloadSang() {
        if (bruger.canDownload()) {
            System.out.print("Titel på sang der skal downloades: ");
            String titel = scanner.nextLine();
            for (Sang s : sangListe) {
                if (s.getTitel().equalsIgnoreCase(titel)) {
                    System.out.println(" Downloader: " + s);
                    return;
                }
            }
            System.out.println(" Sang ikke fundet.");
        } else {
            System.out.println(" Kun Premium-brugere kan downloade sange.");
        }
    }
}
