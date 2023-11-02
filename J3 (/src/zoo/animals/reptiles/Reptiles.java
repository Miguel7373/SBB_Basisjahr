package zoo.animals.reptiles;

import zoo.animals.Animals;

public abstract class Reptiles extends Animals {
    private int preferredTemperature;

    public Reptiles(String funFact, int preferredTemperature) {
        super(funFact);
        this.preferredTemperature = preferredTemperature;
    }
}
