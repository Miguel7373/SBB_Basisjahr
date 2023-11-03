package roleplay.Game;
import roleplay.Main;
import roleplay.gameCharacters.*;
import roleplay.gameCharacters.GameCharacters;
import roleplay.items.weapons.meleeWeapons.MeleeWeapons;

public class Kampf {
    static double runden = 1;

    public static double getRunden() {
        return runden;
    }

    public static void setRunden(double runden) {
        Kampf.runden = runden;
    }

    public static boolean kaempfe(GameCharacters gegner, GameCharacters attacker) {
        double eigenerSchaden = checkType(attacker);

        double armorReductionChance = 0.0;

        if (gegner.getArmor() != null) {
            armorReductionChance = gegner.getArmor().getDamageReduction();
        }

        double damagarandom = Main.getRandom(0, 1);

        if (damagarandom < armorReductionChance) {
            eigenerSchaden = 0.0;
        }

        if (gegner.getWeapons() != null && gegner.getWeapons() instanceof MeleeWeapons) {
            eigenerSchaden -= ((MeleeWeapons) gegner.getWeapons()).getDefenseValue();
            if (eigenerSchaden < 0) {
                eigenerSchaden = 0;
            }
        }
        if (gegner instanceof Orcs && gegner.getMaxHP() * 0.25 >= gegner.getHp()){
            eigenerSchaden = eigenerSchaden / 2;
        }
        eigenerSchaden = eigenerSchaden - gegner.getDefens();

        System.out.println("Runde " + runden);
        System.out.println(attacker.getName() + " verursacht " + eigenerSchaden + " Schaden an " + gegner.getName());

        gegner.setHp(gegner.getHp() - eigenerSchaden);

        System.out.println(gegner.getName() + " hat " + gegner.getHp() + " Lebenspunkte übrig.");
        System.out.println();

        runden += 0.5;

        return true;
    }



    public static double checkType(GameCharacters attackPlayer) {

        if (attackPlayer instanceof Elves) {
            return ((Elves) attackPlayer).elvDamage(attackPlayer.getWeapons());
        } else if (attackPlayer instanceof Human) {
            return ((Human) attackPlayer).humanDamage(attackPlayer.getWeapons());
        } else if (attackPlayer instanceof Dwarfs) {
            return ((Dwarfs) attackPlayer).dwarfDamage(attackPlayer.getWeapons());
        } else if (attackPlayer instanceof Goblins) {
            return ((Goblins) attackPlayer).goblinDamage(attackPlayer.getWeapons());
        } else if (attackPlayer instanceof Trolls) {
            return ((Trolls) attackPlayer).trollsDamage(attackPlayer.getWeapons());
        } else if (attackPlayer instanceof Orcs){
            return ((Orcs) attackPlayer).orcDamage(attackPlayer.getWeapons());
        }else {
            return ((Levin)attackPlayer).levinDamage(attackPlayer.getWeapons());
        }
    }
}