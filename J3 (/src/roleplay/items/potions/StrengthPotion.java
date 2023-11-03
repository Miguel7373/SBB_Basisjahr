package roleplay.items.potions;

import roleplay.gameCharacters.GameCharacters;

public class StrengthPotion extends Potions {
    private static int damageIncrease;

    public StrengthPotion(int weight, String designation, int prise, int damageIncrease) {
        super(weight, designation, prise);
        this.damageIncrease = damageIncrease;
    }
    public static void useStrengthPotion(GameCharacters character) {
        double currentAttackDamage = character.getDamage();
        double newAttackDamage = currentAttackDamage + damageIncrease;
        character.setDamage(newAttackDamage);
    }
}


