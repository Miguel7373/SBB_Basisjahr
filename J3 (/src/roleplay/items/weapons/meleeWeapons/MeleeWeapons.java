package roleplay.items.weapons.meleeWeapons;
import roleplay.items.weapons.Weapons;

public abstract class MeleeWeapons extends Weapons {
    int defenseValue;

    public MeleeWeapons(int weight, String designation, int prise, int attackValue, int defenseValue) {
        super(weight, designation, prise, attackValue);
        this.defenseValue = defenseValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }
}
