package entity.train;

/**
 * Klasse voor locomotieven.
 */
public abstract class Locomotief { private int maxWagons;
    public Locomotief(int maxWagons) {
        this.maxWagons = maxWagons;
    }
    public int getMaxWagons() {
        return maxWagons;
    }
}
