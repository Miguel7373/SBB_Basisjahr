package zoo.enclosures;

import zoo.animals.Animals;
import zoo.animals.aquatic_animals.Aquatic_animals;

public class Aquarium extends Enclosure {
    public enum WaterType{
        fresh_Water,
        salt_Water
    }
    private int capacity;
    private WaterType waterType;
    private Aquatic_animals aquaticAnimalInTheEnclosure;

    public Aquarium(int gehegeNumber, double sizeInSquareMeters, int temperature, int capacity, WaterType waterType, Aquatic_animals aquaticAnimalInTheEnclosure) {
        super(gehegeNumber, sizeInSquareMeters, temperature);
        this.capacity = capacity;
        this.waterType = waterType;
        this.aquaticAnimalInTheEnclosure = aquaticAnimalInTheEnclosure;
    }
}
