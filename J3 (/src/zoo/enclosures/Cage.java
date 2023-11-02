package zoo.enclosures;

import zoo.animals.Animals;
import zoo.animals.birds.Birds;

public class Cage extends Enclosure {
    private double cageHeight;
    public Birds birdInTheEnclosure;

    public Cage(int gehegeNumber, double sizeInSquareMeters, int temperature, double cageHeight,Birds birdInTheEnclosure) {
        super(gehegeNumber, sizeInSquareMeters, temperature);
        this.cageHeight = cageHeight;
        this.birdInTheEnclosure = birdInTheEnclosure;
    }
}
