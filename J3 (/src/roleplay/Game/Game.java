package roleplay.Game;

import roleplay.Main;
import roleplay.gameCharacters.GameCharacters;
import roleplay.items.armor.Armor;
import roleplay.items.magicRings.MagicRings;
import roleplay.items.magicRings.PowerRing;
import roleplay.items.magicRings.ProtectiveRing;
import roleplay.items.potions.HealingPotion;
import roleplay.items.potions.Mate;
import roleplay.items.potions.Potions;
import roleplay.items.potions.StrengthPotion;
import roleplay.items.weapons.Weapons;

import static roleplay.gameCharacters.GameCharacters.assignWeapon;

public class Game {
    public static void game(GameCharacters userTurn, GameCharacters userDefens) {
        boolean Turn = true;
        while (Turn) {
            System.out.println("\nChoose an Action:");
            System.out.println("1: Attack");
            System.out.println("2: Use Item");
            System.out.println("3: Chill");
            System.out.println("4: Equip Weapon");
            System.out.println("5: Drop Item");
            System.out.println("6: Equip Armor");
            System.out.println("7: Exit");
            int whileFight = Main.getValidIntegerInput(Main.scanner, "Enter your choice: ");

            switch (whileFight) {
                case 1:
                    Kampf.kaempfe(userTurn, userDefens);
                    Turn = false;
                    break;
                case 2:
                    if (userTurn.items != null) {
                        useItem(userTurn);
                    } else {
                        System.out.println("You dont have Items");
                        break;
                    }
                case 3:
                    Turn = false;
                    break;
                case 4:
                    if (userTurn.items != null) {
                        for (int i = 0; i < userTurn.items.size(); i++) {
                            if (userTurn.items.get(i) instanceof Weapons) {
                                System.out.println(i + ": " + userTurn.items.get(i).getDesignation());
                            }
                        }
                        int chosenWeapon = Main.scanner.nextInt();
                        if (chosenWeapon >= 0 && chosenWeapon < userTurn.items.size()) {
                            Weapons selectedWeapon = (Weapons) userTurn.items.get(chosenWeapon);
                            assignWeapon(userTurn, selectedWeapon);
                        }
                    } else {
                        System.out.println("\nYou don't even have a weapon.");
                        break;
                    }
                    break;
                case 5:
                    for (int i = 0; i < userTurn.items.size(); i++) {
                        System.out.println(i + ": " + userTurn.items.get(i).getDesignation());
                    }
                    System.out.println("Enter the index of the item you want to remove:");
                    int itemIndexToRemove = Main.scanner.nextInt();
                    if (itemIndexToRemove >= 0 && itemIndexToRemove < userTurn.items.size()) {
                        userTurn.items.remove(itemIndexToRemove);
                    } else {
                        System.out.println("\nInvalid item index.");
                    }
                    break;
                case 6:
                    if (userTurn.items != null) {
                        for (int i = 0; i < userTurn.items.size(); i++) {
                            if (userTurn.items.get(i) instanceof Armor) {
                                System.out.println(i + ": " + userTurn.items.get(i).getDesignation());
                            }
                        }
                        int chosenArmor = Main.scanner.nextInt();
                        if (chosenArmor >= 0 && chosenArmor < userTurn.items.size()) {
                            Armor selectedArmor = (Armor) userTurn.items.get(chosenArmor);
                            GameCharacters.assingArmor(userTurn, selectedArmor);
                        }
                    } else {
                        System.out.println("\nYou don't even have armor");
                        break;
                    }
                    break;
                case 7:
                    System.out.println("game over" + userTurn + "lost");
                    System.exit(0);
                    break;
                default:
            }
        }

    }

    public static void useItem(GameCharacters userTurn) {
        for (int i = 0; i < userTurn.items.size(); i++) {
            if (userTurn.items.get(i) instanceof Potions || userTurn.items.get(i) instanceof MagicRings) {
                System.out.println(i + ": " + userTurn.items.get(i).getDesignation());
            }
        }
        System.out.println("\nEnter the index of the item you want to use:");
        int itemIndexToUse = Main.scanner.nextInt();
        if (userTurn.items.get(itemIndexToUse) instanceof HealingPotion) {
            HealingPotion.healPlayer(userTurn);
            userTurn.items.remove(itemIndexToUse);
        } else if (userTurn.items.get(itemIndexToUse) instanceof StrengthPotion) {
            StrengthPotion.useStrengthPotion(userTurn);
            userTurn.items.remove(itemIndexToUse);
        } else if (userTurn.items.get(itemIndexToUse) instanceof PowerRing) {
            PowerRing.applyPowerRing(userTurn);
            userTurn.items.remove(itemIndexToUse);
        } else if (userTurn.items.get(itemIndexToUse) instanceof ProtectiveRing) {
            ProtectiveRing.applyProtectiveRing(userTurn);
            userTurn.items.remove(itemIndexToUse);
        } else if (userTurn.items.get(itemIndexToUse) instanceof Mate) {
            Mate.OverHealPlayer(userTurn);
            userTurn.items.remove(itemIndexToUse);
        } else {
            System.out.println("\nThat isn't an item.");
        }

    }
}


