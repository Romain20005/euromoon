package entity.trip;
import entity.train.Train;
import entity.person.Driver;
import entity.person.Steward;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reizen tussen twee stations met een trein en wat personeel
 */
public class Trip {
    private String fromStation;
    private String toStation;
    private LocalDateTime departureTime;
    private Train train;

    private Driver driver;
    private List<Steward> stewards = new ArrayList<>();

    public Trip(String fromStation, String toStation, LocalDateTime departureTime) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean addSteward(Steward steward) {
        if (stewards.size() < 3) {
            stewards.add(steward);
            return true;
        }
        return false;
    }

    public boolean isReadyToDepart() {
        return train != null && driver != null && stewards.size() >= 3;
    }

    public Train getTrain() {
        return train;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
}

