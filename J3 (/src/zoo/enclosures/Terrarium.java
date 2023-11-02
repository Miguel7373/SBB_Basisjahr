package zoo.enclosures;

import zoo.animals.Animals;
import zoo.animals.reptiles.Reptiles;

public class Terrarium extends Enclosure {
    private int humidity;
    private int capacity;
    private Reptiles reptilesInTheEnclosure;

    public Terrarium(int gehegeNumber, double sizeInSquareMeters, int temperature, int humidity, int capacity,Reptiles reptilesInTheEnclosure) {
        super(gehegeNumber, sizeInSquareMeters, temperature);
        this.humidity = humidity;
        this.capacity = capacity;
        this.reptilesInTheEnclosure = reptilesInTheEnclosure;
    }
}
