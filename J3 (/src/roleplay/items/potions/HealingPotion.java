package roleplay.items.potions;

import roleplay.gameCharacters.GameCharacters;

public class HealingPotion extends Potions {
    private static int healingPower;

    public HealingPotion(int weight, String designation, int prise,int healingPower) {
        super(weight, designation, prise);
        this.healingPower = healingPower;
    }

    public static int getHealingPower() {
        return healingPower;
    }

    public static void healPlayer(GameCharacters player) {
        int currentHp = (int) player.getHp();
        double maxHp = player.getMaxHP();

        if (currentHp < player.getMaxHP()) {
            double newHp = Math.min(currentHp + HealingPotion.getHealingPower(), maxHp);
            player.setHp(newHp);
            System.out.println("You used a healing potion and gained " + (newHp - currentHp) + " HP.");
        } else {
            System.out.println("You are already at full HP. The healing potion had no effect.");
        }
    }
}