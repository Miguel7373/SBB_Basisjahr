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

public class Goblins extends GameCharacters{
    public Goblins(String name, double hp, int loadCapacity, Weapons weapons, int initiative, Armor armor, double maxHP, int coins, double damage, int defens) {
        super(name, hp, loadCapacity, weapons, initiative, armor, maxHP, coins, damage, defens);
    }

    public double goblinDamage(Weapons weapons) {
        if (weapons instanceof Sword || weapons instanceof Club) {
            double attackWithMeleeWeapons = weapons.getAttackValue() * Main.getRandom(0.9, 1.1) + ((MeleeWeapons) weapons).getDefenseValue();
            return attackWithMeleeWeapons;
        }else if (weapons instanceof Bow){
            double attackWithBow = weapons.getAttackValue() * Main.getRandom(0.9, 1.1) * 1.5;
            return attackWithBow;
        } else if (weapons != null) {
            double attackwithRangedWeapons = weapons.getAttackValue() * Main.getRandom(0.9, 1.1);
            return attackwithRangedWeapons;
        } else {
            double attackWithHand = getDamage();
            return attackWithHand;
        }
    }
}
