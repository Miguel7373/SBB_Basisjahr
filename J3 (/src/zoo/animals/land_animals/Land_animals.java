package zoo.animals.land_animals;

import zoo.animals.Animals;

public abstract class Land_animals extends Animals {
    private int size;

    public Land_animals(String funFact, int size) {
        super(funFact);
        this.size = size;
    }
}
