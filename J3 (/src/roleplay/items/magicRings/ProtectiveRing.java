package roleplay.items.magicRings;

import roleplay.gameCharacters.GameCharacters;

public class ProtectiveRing extends MagicRings {
    private static double damageReduction;

    public ProtectiveRing(int weight, String designation, int price, double damageReduction) {
        super(weight, designation, price);
        this.damageReduction = damageReduction;
    }

    private static double getDamageReduction() {
        return damageReduction;
    }

    public static void applyProtectiveRing(GameCharacters character) {
        character.setDefens((int) (character.getDefens() - ProtectiveRing.getDamageReduction()));
    }
}
