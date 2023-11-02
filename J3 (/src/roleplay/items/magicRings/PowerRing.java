package roleplay.items.magicRings;

import roleplay.gameCharacters.GameCharacters;

public class PowerRing extends MagicRings{
    static int plusLoadCapacity;
    public PowerRing(int weight, String designation, int prise, int plusLoadCapacity) {
        super(weight, designation, prise);
        this.plusLoadCapacity = plusLoadCapacity;
    }
    public static void applyPowerRing(GameCharacters character){
        character.setLoadCapacity(character.getLoadCapacity() + PowerRing.plusLoadCapacity);
    }
}