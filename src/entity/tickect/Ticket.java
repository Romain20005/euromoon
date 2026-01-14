package entity.tickect;
import entity.person.Passanger;
import entity.trip.Trip;

/**
 * Klasse voor de ticket
 */
public class Ticket {
    private Passanger passanger;
    private Trip trip;
    private boolean firstClass;

    public Ticket(Passanger passanger, Trip trip, boolean firstClass) {
        this.passanger = passanger;
        this.trip = trip;
        this.firstClass = firstClass;
    }
    public Passanger getPassanger() {
        return passanger;
    }
    public Trip getTrip() {
        return trip;
    }
    public boolean isFirstClass() {
        return firstClass;
    }
}
