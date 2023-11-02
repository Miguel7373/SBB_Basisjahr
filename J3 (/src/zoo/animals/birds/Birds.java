package zoo.animals.birds;

import zoo.animals.Animals;

public abstract class Birds extends Animals {
    private int wingspan;


    public Birds(String funFact, int wingspan) {
        super(funFact);
        this.wingspan = wingspan;
    }
}
