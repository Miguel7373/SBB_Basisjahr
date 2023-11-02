package roleplay.items.weapons;

import roleplay.items.Items;

public abstract class Weapons extends Items {
    int attackValue;

    public Weapons(int weight, String designation, int prise, int attackValue) {
        super(weight, designation, prise);
        this.attackValue = attackValue;
    }

    public int getAttackValue() {
        return attackValue;
    }
}