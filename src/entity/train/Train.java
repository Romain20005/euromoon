package entity.train;
import java.util.ArrayList;
import java.util.List;

/**
 * Een trein met locomotief en wagons
 */
public class Train {
    private Locomotief locomotief;
    private List<Wagon> wagons = new ArrayList<>();

    public Train(Locomotief Locomotief) {
        this.locomotief = locomotief;
    }
    public boolean addWagon(Wagon wagon) {
        if (wagons.size() < locomotief.getMaxWagons()) {
            wagons.add(wagon);
            return true;
        }
        return false;
    }
    public int getTotalSeats(){
        return 80 + wagons.size() * 40;
        //Locomotief heeft 80 plaatsen , elke wagon 40
    }
}
