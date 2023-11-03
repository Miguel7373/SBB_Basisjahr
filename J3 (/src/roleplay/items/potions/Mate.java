package roleplay.items.potions;

import roleplay.gameCharacters.GameCharacters;

public class Mate extends Potions{
    public Mate(int weight, String designation, int prise) {
        super(weight, designation, prise);
    }
    public static void OverHealPlayer(GameCharacters player) {
        player.setHp(player.getHp() + 40);
        System.out.println("you heald your hp is now:" + player.getHp());
    }
}
