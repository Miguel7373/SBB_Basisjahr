package roleplay.gameCharacters;

import roleplay.Main;
import roleplay.items.Items;
import roleplay.items.armor.Armor;
import roleplay.items.weapons.Weapons;
import roleplay.items.weapons.meleeWeapons.Club;
import roleplay.items.weapons.meleeWeapons.MeleeWeapons;
import roleplay.items.weapons.meleeWeapons.Sword;
import roleplay.items.weapons.rangedWeapons.Bow;

import java.util.List;

public class Elves extends GameCharacters {
    private int magicValue;

    public Elves(String name, double hp, int loadCapacity, Weapons weapons, int initiative, Armor armor, double maxHP, int coins, double damage, int defens, int magicValue) {
        super(name, hp, loadCapacity, weapons, initiative, armor, maxHP, coins, damage, defens);
        this.magicValue = magicValue;
    }

    public double elvDamage(Weapons weapons) {
        if (weapons instanceof Sword || weapons instanceof Club) {
            double attackWithMeleeWeapons = weapons.getAttackValue() * Main.getRandom(0.9, 1.1) + (magicValue / 2) + ((MeleeWeapons) weapons).getDefenseValue();
            return attackWithMeleeWeapons;
        } else if (weapons instanceof Bow) {
            double attackWithBow = weapons.getAttackValue() * Main.getRandom(0.9, 1.1) + (magicValue / 2) * 1.5;
            return attackWithBow;
        } else if (weapons != null) {
            double attackWithBow = weapons.getAttackValue() * Main.getRandom(0.9, 1.1) + (magicValue / 2);
            return attackWithBow;
        } else {
            double attackWithHand = getDamage();
            return attackWithHand;
        }
    }
}