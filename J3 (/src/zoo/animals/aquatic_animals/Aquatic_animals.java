package zoo.animals.aquatic_animals;

import zoo.animals.Animals;

public abstract class Aquatic_animals extends Animals {
    private int length;

    public Aquatic_animals(String funFact, int length) {
        super(funFact);
        this.length = length;
    }

}
