package zoo.enclosures;

import zoo.animals.Animals;
import zoo.animals.land_animals.Land_animals;

public class Terrain extends Enclosure {
    private double fenceHeight;
    private  boolean moatAvailable;
    private Land_animals landAnimalInTheEnclosure;

    public Terrain(int gehegeNumber, double sizeInSquareMeters, int temperature , double fenceHeight, boolean moatAvailable,Land_animals landAnimalInTheEnclosure) {
        super(gehegeNumber, sizeInSquareMeters, temperature);
        this.fenceHeight = fenceHeight;
        this.moatAvailable = moatAvailable;
        this.landAnimalInTheEnclosure = landAnimalInTheEnclosure;
    }
}
