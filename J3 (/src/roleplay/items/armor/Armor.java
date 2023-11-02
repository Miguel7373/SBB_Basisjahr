package roleplay.items.armor;

import roleplay.items.Items;

public abstract class Armor extends Items {
    double damageReduction;

    public Armor(int weight, String designation, int prise, double damageReduction) {
        super(weight, designation, prise);
        this.damageReduction = damageReduction;
    }

    public double getDamageReduction() {
        return damageReduction;
    }
}
