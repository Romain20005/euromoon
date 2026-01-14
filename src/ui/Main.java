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
public class Main {private static List<Passanger> passangers = new ArrayList<>();
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
                case 2:
                    maakReis(scanner);
                case 3:
                    koppelTrein(scanner);
                case 4:
                    verkoopTicket(scanner);
                case 5:
                    printBoardinglijst(scanner);
                case 0:
                    running = false;
                default:
                    System.out.println("Geen goede keuze");
            }
        }
        System.out.println("Programma afgesloten");
    }
        private static void registreerPassagier (Scanner scanner){
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



