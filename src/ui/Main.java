package ui;
import entity.person.Passanger;
import entity.person.Driver;
import entity.person.Steward;
import entity.train.*;
import entity.tickect.Ticket;
import entity.trip.Trip;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Dit is het start van mijn applicatie
 */
public class Main {
    private static List<Passanger> passangers = new ArrayList<>();
    private static List<Trip> trips = new ArrayList<>();
    private static List<Train> trains = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n=== EUROMOON MENU ===");
            System.out.println("1. Registreer passagier");
            System.out.println("2. Maak reis aan");
            System.out.println("3. Koppel een trein aan een reis");
            System.out.println("4. Verkoop ticket");
            System.out.println("5. Print boardinglijst");
            System.out.println("0. Afsluiten");

            System.out.println("keuze: ");
            int keuze = scanner.nextInt();
            scanner.nextLine(); // leegmaken

            switch (keuze) {
                case 1:
                    registreerPassagier(scanner);
                    break;
                case 2:
                    maakReis(scanner);
                    break;
                case 3:
                    koppelTrein(scanner);
                    break;
                case 4:
                    verkoopTicket(scanner);
                    break;
                case 5:
                    printBoardinglijst(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Geen goede keuze");
            }
        }
        System.out.println("Programma afgesloten");
    }

    private static void registreerPassagier(Scanner scanner) {
        System.out.print("Voornaam: ");
        String firstName = scanner.nextLine();

        System.out.print("Achternaam: ");
        String lastName = scanner.nextLine();

        System.out.print("Rijksregisternummer: ");
        String rrn = scanner.nextLine();

        System.out.print("Geboortedatum (bv 2000-05-14): ");
        String birthDate = scanner.nextLine();

        Passanger p = new Passanger(firstName, lastName, birthDate, rrn);
        passangers.add(p);

        System.out.println("Passagier geregistreerd ");
    }

    private static void maakReis(Scanner scanner) {
        System.out.println("Vertrekstation: ");
        String from = scanner.nextLine();
        System.out.println("Bestemmingsstation: ");
        String to = scanner.nextLine();

        System.out.println("Vertrektijd (bv 2026-03-05T12:30): ");
        String dateInput = scanner.nextLine();

        LocalDateTime departureTime;
        try {
            departureTime = LocalDateTime.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Fout formaat datum! ");
            return;
        }
        Trip trip = new Trip(from, to, departureTime);
        trips.add(trip);

        System.out.println("Reis succesvol aangemaakt ");
    }

    private static void koppelTrein(Scanner scanner) {
        if (trips.isEmpty()) {
            System.out.println("Geen reizen beschikbaar.");
            return;
        }
        // Hier toon ik de reizen met een nummer ervoor
        for (int i = 0; i < trips.size(); i++) {
            Trip t = trips.get(i);
            System.out.println(i + ": " + t.getFromStation() + " -> " +
                    t.getToStation() + " " + t.getDepartureTime());
        }
        System.out.print("Kies reis index: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= trips.size()) {
            System.out.println("Ongeldige index.");
            return;
        }
        System.out.println("Kies locomotief type:");
        System.out.println("1: Class373");
        System.out.println("2: Class374");

        int keuze = scanner.nextInt();
        scanner.nextLine();

        Locomotief loco = (keuze == 1) ? new Class373() : new Class374();

        Train train = new Train(loco);

        trips.get(index).setTrain(train);
        trains.add(train);

        System.out.println("Trein gekoppeld aan reis ✔️");
    }

    private static void verkoopTicket(Scanner scanner) {
        if (passangers.isEmpty() || trips.isEmpty()) {
            System.out.println("Niet genoeg data.");
            return;
        }
        //Kies passagier
        System.out.println("kies passagier index: ");
        for (int i = 0; i < passangers.size(); i++) {
            System.out.println(i + " : " + passangers.get(i).getFirstName());
        }
        int pIndex = scanner.nextInt();
        scanner.nextLine();

        // Kies reis
        System.out.println("kies reis index: ");
        for (int i = 0; i < trips.size(); i++) {
            System.out.println(i + " : " + trips.get(i).getFromStation() + " -> " + trips.get(i).getToStation());
        }
        int rIndex = scanner.nextInt();
        scanner.nextLine();

        Trip trip = trips.get(rIndex);

        // Foutcontrole zien of mijn trein bestaat
        if (trip.getTrain() == null) {
            System.out.println("Nog geen treiin gekoppeld ! ");
            return;
        }
        // klasse kiezen
        System.out.println("Eerste klasse ? (true/false)");
        boolean firstclass = scanner.nextBoolean();
        scanner.nextLine();

        // Ticket maken
        Ticket t = new Ticket(passangers.get(pIndex), trip, firstclass);
        tickets.add(t);

        System.out.println("Ticket verkocht");

    }

    private static void printBoardinglijst(Scanner scanner) {
        if (trips.isEmpty()) {
            System.out.println("Geen reizen beschikbaar.");
            return;
        }
        // Toon reizen
        for (int i = 0; i < trips.size(); i++) {
            Trip t = trips.get(i);
            System.out.println(i + ": " + t.getFromStation() + " -> " +
                    t.getToStation() + " " + t.getDepartureTime());
        }
        System.out.println("Kies reis index");
        int index = scanner.nextInt();
        scanner.nextLine();
        if (index < 0 || index >= trips.size()) {
            System.out.println("Ongeldige index.");
            return;
        }
        Trip gekozenTrip = trips.get(index);

        // Bestandsnaam maken
        String filename = gekozenTrip.getFromStation() + "_" +
                gekozenTrip.getToStation() + "_" +
                gekozenTrip.getDepartureTime() + ".txt";

        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {

            writer.write("Boardinglijst voor reis:\n");
            writer.write(gekozenTrip.getFromStation() + " -> " +
                    gekozenTrip.getToStation() + " " +
                    gekozenTrip.getDepartureTime() + "\n\n");

            for (Ticket t : tickets) {
                if (t.getTrip() == gekozenTrip) {
                    writer.write(t.getPassanger().getFirstName() + " " +
                            t.getPassanger().getLastName() + "\n");
                }
            }

            System.out.println("Boardinglijst opgeslagen als: " + filename);

        } catch (Exception e) {
            System.out.println("Fout bij schrijven bestand.");
        }
    }
}




