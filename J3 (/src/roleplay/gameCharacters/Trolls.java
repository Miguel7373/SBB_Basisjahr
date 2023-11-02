package roleplay.gameCharacters;

import roleplay.Main;
import roleplay.items.armor.Armor;
import roleplay.items.weapons.Weapons;
import roleplay.items.weapons.meleeWeapons.Club;
import roleplay.items.weapons.meleeWeapons.MeleeWeapons;
import roleplay.items.weapons.meleeWeapons.Sword;

public class Trolls extends GameCharacters {
    public Trolls(String name, double hp, int loadCapacity, Weapons weapons, int initiative, Armor armor, double maxHP, int coins, double damage, int defens) {
        super(name, hp, loadCapacity, weapons, initiative, armor, maxHP, coins, damage, defens);
    }

    public double trollsDamage(Weapons weapons) {
        if (weapons instanceof Sword) {
            double attackWithMeleeWeapons = weapons.getAttackValue() * Main.getRandom(0.9, 1.1) + ((MeleeWeapons) weapons).getDefenseValue();
            return attackWithMeleeWeapons;
        } else if (weapons instanceof Club) {
            double attackWithClub = weapons.getAttackValue() * Main.getRandom(0.9, 1.1) + ((MeleeWeapons) weapons).getDefenseValue() * 2;
            return attackWithClub;
        } else if (weapons != null) {
            double attackwithRangedWeapons = weapons.getAttackValue() * Main.getRandom(0.9, 1.1);
            return attackwithRangedWeapons;
        } else {
            double attackWithHand = getDamage();
            return attackWithHand;
        }
    }
}