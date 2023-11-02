package roleplay;
import roleplay.Game.*;
import roleplay.gameCharacters.*;
import roleplay.items.armor.Armor;
import roleplay.items.armor.armorTyp.HeavyArmor;
import roleplay.items.armor.armorTyp.LightArmor;
import roleplay.items.potions.*;
import roleplay.items.magicRings.*;
import roleplay.items.weapons.Weapons;
import roleplay.items.weapons.meleeWeapons.*;
import roleplay.items.weapons.rangedWeapons.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static roleplay.Game.Shop.shop;
import static roleplay.gameCharacters.GameCharacters.*;

public class Main {
    public static List<GameCharacters> characters = new ArrayList<>();

    public boolean addCharacter(GameCharacters gameCharacter) {
        return characters.add(gameCharacter);
    }

    public List<GameCharacters> getCharacters() {
        return characters;
    }

    public static double getRandom(double min, double max) {
        return min + (Math.random() * (max - min));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        Shop shop = new Shop();

        Potions healingPotion = new HealingPotion(5, "Healing Potion: Heals 10 HP", 2, 10);
        Potions strengthPotion = new StrengthPotion(6, "Strength Potion: 20% more damage", 2, 10);
        Potions mate = new Mate(3, "your mate is making you overpowerd", 3);
        MagicRings powerRing = new PowerRing(8, "Power Ring: 30% more damage", 3, 10);
        MagicRings protectiveRing = new ProtectiveRing(8, "Protective Ring: 30% less damage", 3, 10);

        MeleeWeapons club = new Club(10, "Club: Slow but hard-hitting weapon", 4, 20, 10);
        MeleeWeapons sword = new Sword(8, "Sword: An iron sword, the normal weapon", 5, 25, 10);
        RangedWeapons bow = new Bow(6, "Bow: Ranged high damage weapon", 6, 20);
        RangedWeapons throwingKnife = new ThrowingKnife(4, "Throwing Knife: A light ranged weapon", 4, 15);
        RangedWeapons fifaController = new FIFAController(2, "while playing Fifa your controller evolved into a deadly weapon", 3, 15);

        Armor netheriteArmor = new HeavyArmor(11, "Heavy Armor: Can't be worn by players with an initiative stat under three", 5, 0.5);
        Armor diamondArmor = new HeavyArmor(9, "Heavy Armor: Can't be worn by players with an initiative stat under three", 4, 0.4);
        Armor ironArmor = new LightArmor(6, "Light Armor: Can't be worn by players with an initiative stat under two", 3, 0.3);
        Armor leatherArmor = new LightArmor(4, "Light Armor: Can't be worn by players with an initiative stat under two", 2, 0.2);

        shop.addShopItems(healingPotion);
        shop.addShopItems(strengthPotion);
        shop.addShopItems(mate);
        shop.addShopItems(powerRing);
        shop.addShopItems(protectiveRing);
        shop.addShopItems(club);
        shop.addShopItems(sword);
        shop.addShopItems(bow);
        shop.addShopItems(throwingKnife);
        shop.addShopItems(fifaController);
        shop.addShopItems(netheriteArmor);
        shop.addShopItems(diamondArmor);
        shop.addShopItems(ironArmor);
        shop.addShopItems(leatherArmor);


        double dwarfsHP = Main.getRandom(100, 120);
        double humanHP = Main.getRandom(90, 110);
        double orcHP = Main.getRandom(120, 140);
        double trollHP = Main.getRandom(75, 95);
        double goblinHP = Main.getRandom(80, 100);
        double elvHP = Main.getRandom(85, 105);
        double levinHP = Main.getRandom(105, 125);
        int coinsFord = (int) Main.getRandom(15, 20);
        int coinsForh = (int) Main.getRandom(15, 22);
        int coinsForo = (int) Main.getRandom(15, 18);
        int coinsFort = (int) Main.getRandom(15, 25);
        int coinsForg = (int) Main.getRandom(15, 24);
        int coinsFore = (int) Main.getRandom(15, 23);
        int coinsForl = (int) Main.getRandom(15, 19);

        GameCharacters dwarfs = new Dwarfs("Dwarf", dwarfsHP, (int) Main.getRandom(50, 60), null, 2, null, dwarfsHP, coinsFord, 1, 0);
        GameCharacters human = new Human("Human", humanHP, (int) Main.getRandom(40, 50), null, 4, null, humanHP, coinsForh, 1, 0);
        GameCharacters orcs = new Orcs("Orc", orcHP, (int) Main.getRandom(60, 70), null, 1, null, orcHP, coinsForo, 1, 0);
        GameCharacters trolls = new Trolls("Troll", trollHP, (int) Main.getRandom(30, 40), null, 3, null, trollHP, coinsFort, 1, 0);
        GameCharacters goblins = new Goblins("Goblin", goblinHP, (int) Main.getRandom(35, 45), null, 2, null, goblinHP, coinsForg, 1, 0);
        GameCharacters elves = new Elves("Elf", elvHP, (int) Main.getRandom(38, 42), null, 4, null, elvHP, coinsFore, 1, 0, 10);
        GameCharacters levin = new Levin("Levin", levinHP, (int) Main.getRandom(40, 50), null, 2, null, levinHP, coinsForl, 1, 0);

        main.addCharacter(dwarfs);
        main.addCharacter(human);
        main.addCharacter(orcs);
        main.addCharacter(levin);
        main.addCharacter(trolls);
        main.addCharacter(goblins);
        main.addCharacter(elves);


        double count = 7;
        System.out.println("Player 1, name your character");
        GameCharacters player1Character = selectCharacter(count, scanner, main);
        boolean shop_p1 = true;
        while (shop_p1) {
            if (player1Character instanceof Dwarfs) {
                System.out.println("You're a Dwarf");
            } else if (player1Character instanceof Human) {
                System.out.println("You're a Human");
            } else if (player1Character instanceof Orcs) {
                System.out.println("You're a Orc");
            } else if (player1Character instanceof Levin) {
                System.out.println("You're a Levin");
            } else if (player1Character instanceof Trolls) {
                System.out.println("You're a Troll");
            } else if (player1Character instanceof Goblins) {
                System.out.println("You're a Goblin");
            } else {
                System.out.println("You're a Elv");
            }
            player1Character.items.forEach(item -> System.out.println(item.getDesignation() + "\n"));
            System.out.println("\n1: Shop");
            System.out.println("2: End Turn");
            int inputToShop1 = getValidIntegerInput(scanner, "Enter your choice: ");
            switch (inputToShop1) {
                case 1:
                    shop(player1Character);
                    break;
                case 2:
                    shop_p1 = false;
                    break;
                default:
            }
        }
        count--;

        System.out.println("Player 2, name your character");
        GameCharacters player2Character = selectCharacter(count, scanner, main);
        boolean shop_p2 = true;
        while (shop_p2) {
            if (player2Character instanceof Dwarfs) {
                System.out.println("You're a Dwarf");
            } else if (player2Character instanceof Human) {
                System.out.println("You're a Human");
            } else if (player2Character instanceof Orcs) {
                System.out.println("You're a Orc");
            } else if (player2Character instanceof Levin) {
                System.out.println("You're a Levin");
            } else if (player2Character instanceof Trolls) {
                System.out.println("You're a Troll");
            } else if (player2Character instanceof Goblins) {
                System.out.println("You're a Goblin");
            } else {
                System.out.println("You're a Elv");
            }
            System.out.println("\n");
            player2Character.items.forEach(item -> System.out.println(item.getDesignation()));
            System.out.println("\n1: Shop");
            System.out.println("2: End Turn");
            int inputToShop2 = getValidIntegerInput(scanner, "Enter your choice: ");
            switch (inputToShop2) {
                case 1:
                    shop(player2Character);
                    break;
                case 2:
                    shop_p2 = false;
                    break;
                default:
            }
        }
        int player = 0;
        if (player1Character.getInitiative() < player2Character.getInitiative()) {
            player = 1;
        }
        boolean rule = true;
        while (rule) {
            System.out.println("Regeln\n 1: Unlimeted Coins \n 2: Doppelte HP \n 3: Start\n");
            int inputTorule = getValidIntegerInput(scanner, "Enter your choice: ");
            switch (inputTorule) {
                case 1:
                    player2Character.setCoins(999999);
                    player1Character.setCoins(999999);
                case 2:
                    player1Character.setHp(player1Character.getHp() * 2);
                    player1Character.setMaxHP(player1Character.getMaxHP() * 2);
                    player2Character.setHp(player2Character.getHp() * 2);
                    player2Character.setMaxHP(player2Character.getMaxHP() * 2);
                case 3:
                    rule = false;
                    break;
                default:
                    break;
            }
        }

        boolean gameOn = true;
        while (gameOn) {
            if (Kampf.runden > 20 || player1Character.getHp() <= 0 || player2Character.getHp() <= 0) {
                player1Character.setHp(player1Character.getMaxHP());
                System.out.println("\nPlayer one's HP got reset to full " + player1Character.getMaxHP());
                player1Character.setCoins(player1Character.getCoins() + 10);
                System.out.println("Your got 10 Coins");
                shop(player1Character);
                player2Character.setHp(player2Character.getMaxHP());
                System.out.println("\nPlayer two's HP got reset to full " + player2Character.getMaxHP());
                player2Character.setCoins(player2Character.getCoins() + 10);
                System.out.println("Your got 10 Coins");
                shop(player2Character);
                System.out.println("\nThe fight starts again");
                if (player1Character.getInitiative() < player2Character.getInitiative()) {
                    player = 1;
                } else {
                    player = 0;
                }
                Kampf.runden = 1;

            }
            if (player == 0) {
                System.out.println("\nIts Your Turn " + player1Character.getName());
            } else {
                System.out.println("\nIts Your Turn " + player2Character.getName());
            }



            System.out.println("\nChoose an Action:");
            System.out.println("1: Attack");
            System.out.println("2: Use Item");
            System.out.println("3: Chill");
            System.out.println("4: Equip Weapon");
            System.out.println("5: Drop Item");
            System.out.println("6: Equip Armor");
            System.out.println("7: Exit");
            int whileFight = getValidIntegerInput(scanner, "Enter your choice: ");

            switch (whileFight) {
                case 1:
                    if (player == 0) {
                        Kampf.kaempfe(player2Character, player1Character);
                        player = 1;
                    } else {
                        Kampf.kaempfe(player1Character, player2Character);
                        player = 0;
                    }
                    break;
                case 2:
                    if (player1Character.items != null || player2Character.items != null) {
                        if (player == 0) {
                            for (int i = 0; i < player1Character.items.size(); i++) {
                                if (player1Character.items.get(i) instanceof Potions || player1Character.items.get(i) instanceof MagicRings) {
                                    System.out.println(i + ": " + player1Character.items.get(i).getDesignation());
                                }
                            }
                            System.out.println("\nEnter the index of the item you want to use:");
                            int itemIndexToUse = scanner.nextInt();
                            if (player1Character.items.get(itemIndexToUse) instanceof HealingPotion) {
                                HealingPotion.healPlayer(player1Character);
                                player1Character.items.remove(itemIndexToUse);
                            } else if (player1Character.items.get(itemIndexToUse) instanceof StrengthPotion) {
                                StrengthPotion.useStrengthPotion(player1Character);
                                player1Character.items.remove(itemIndexToUse);
                            } else if (player1Character.items.get(itemIndexToUse) instanceof PowerRing) {
                                PowerRing.applyPowerRing(player1Character);
                                player1Character.items.remove(itemIndexToUse);
                            } else if (player1Character.items.get(itemIndexToUse) instanceof ProtectiveRing) {
                                ProtectiveRing.applyProtectiveRing(player1Character);
                                player1Character.items.remove(itemIndexToUse);
                            } else if (player1Character.items.get(itemIndexToUse) instanceof Mate) {
                                Mate.OverHealPlayer(player1Character);
                                player1Character.items.remove(itemIndexToUse);
                            } else {
                                System.out.println("\nThat isn't an item.");
                            }
                        } else {
                            for (int l = 0; l < player2Character.items.size(); l++) {
                                if (player2Character.items.get(l) instanceof Potions || player2Character.items.get(l) instanceof MagicRings) {
                                    System.out.println(l + ": " + player2Character.items.get(l).getDesignation());
                                }
                            }
                            System.out.println("\nEnter the index of the item you want to use:");
                            int itemIndexToUse = scanner.nextInt();
                            if (player2Character.items.get(itemIndexToUse) instanceof HealingPotion) {
                                HealingPotion.healPlayer(player2Character);
                                player2Character.items.remove(itemIndexToUse);
                            } else if (player2Character.items.get(itemIndexToUse) instanceof StrengthPotion) {
                                StrengthPotion.useStrengthPotion(player2Character);
                                player2Character.items.remove(itemIndexToUse);
                            } else if (player2Character.items.get(itemIndexToUse) instanceof PowerRing) {
                                PowerRing.applyPowerRing(player2Character);
                                player2Character.items.remove(itemIndexToUse);
                            } else if (player2Character.items.get(itemIndexToUse) instanceof ProtectiveRing) {
                                ProtectiveRing.applyProtectiveRing(player2Character);
                                player2Character.items.remove(itemIndexToUse);
                            } else if (player2Character.items.get(itemIndexToUse) instanceof Mate) {
                                Mate.OverHealPlayer(player2Character);
                                player2Character.items.remove(itemIndexToUse);
                            } else {
                                System.out.println("\nThat isn't an item.");
                            }
                        }
                        break;
                    }
                    else {
                        System.out.println("You dont have Items");
                        break;
                    }
                case 3:
                    if (player == 0) {
                        player = 1;
                    } else {
                        player = 0;
                    }
                    break;
                case 4:
                    if (player1Character.items != null || player2Character.items != null) {
                        if (player == 0) {
                            for (int i = 0; i < player1Character.items.size(); i++) {
                                if (player1Character.items.get(i) instanceof Weapons) {
                                    System.out.println(i + ": " + player1Character.items.get(i).getDesignation());
                                }
                            }
                            int chosenWeapon = scanner.nextInt();
                            if (chosenWeapon >= 0 && chosenWeapon < player1Character.items.size()) {
                                Weapons selectedWeapon = (Weapons) player1Character.items.get(chosenWeapon);
                                assignWeapon(player1Character, selectedWeapon);
                            }
                        } else {
                            for (int i = 0; i < player2Character.items.size(); i++) {
                                if (player2Character.items.get(i) instanceof Weapons) {
                                    System.out.println(i + ": " + player2Character.items.get(i).getDesignation());
                                }
                            }
                            int chosenWeapon = scanner.nextInt();
                            if (chosenWeapon >= 0 && chosenWeapon < player2Character.items.size()) {
                                Weapons selectedWeapon = (Weapons) player2Character.items.get(chosenWeapon);
                                assignWeapon(player2Character, selectedWeapon);
                            }
                        }
                    } else {
                        System.out.println("\nYou don't even have a weapon.");
                        break;
                    }
                    break;
                case 5:
                    if (player == 0) {
                        for (int i = 0; i < player1Character.items.size(); i++) {
                            System.out.println(i + ": " + player1Character.items.get(i).getDesignation());
                        }
                        System.out.println("Enter the index of the item you want to remove:");
                        int itemIndexToRemove = scanner.nextInt();
                        if (itemIndexToRemove >= 0 && itemIndexToRemove < player1Character.items.size()) {
                            player1Character.items.remove(itemIndexToRemove);
                        } else {
                            System.out.println("\nInvalid item index.");
                        }
                    } else {
                        for (int i = 0; i < player2Character.items.size(); i++) {
                            System.out.println(i + ": " + player2Character.items.get(i).getDesignation());
                        }
                        System.out.println("Enter the index of the item you want to remove:");
                        int itemIndexToRemove = scanner.nextInt();

                        if (itemIndexToRemove >= 0 && itemIndexToRemove < player2Character.items.size()) {
                            player2Character.items.remove(itemIndexToRemove);
                        } else {
                            System.out.println("\nInvalid item index.");
                        }
                    }
                    break;
                case 6:
                    if (player1Character.items != null || player2Character.items != null) {
                        if (player == 0) {
                            for (int i = 0; i < player1Character.items.size(); i++) {
                                if (player1Character.items.get(i) instanceof Armor) {
                                    System.out.println(i + ": " + player1Character.items.get(i).getDesignation());
                                }
                            }
                            int chosenArmor = scanner.nextInt();
                            if (chosenArmor >= 0 && chosenArmor < player1Character.items.size()) {
                                Armor selectedArmor = (Armor) player1Character.items.get(chosenArmor);
                                GameCharacters.assingArmor(player1Character, selectedArmor);
                            }
                        } else {
                            for (int i = 0; i < player2Character.items.size(); i++) {
                                if (player2Character.items.get(i) instanceof Armor) {
                                    System.out.println(i + ": " + player2Character.items.get(i).getDesignation());
                                }
                            }
                            int chosenWeapon = scanner.nextInt();
                            if (chosenWeapon >= 0 && chosenWeapon < player2Character.items.size()) {
                                Armor selectedArmor = (Armor) player2Character.items.get(chosenWeapon);
                                GameCharacters.assingArmor(player2Character, selectedArmor);
                            }
                        }
                    } else {
                        System.out.println("\nYou don't even have armor");
                        break;
                    }
                    break;
                case 7:
                    gameOn = false;
                    break;
                default:
            }
        }
        System.out.println("\nGame Over!");
    }

    public static GameCharacters selectCharacter(double count, Scanner scanner, Main main) {
        System.out.println("Enter a name: ");
        String name = scanner.nextLine();
        GameCharacters playerChosen = main.getCharacters().get((int) Main.getRandom(1, count));
        characters.remove(playerChosen);
        playerChosen.setName(name);
        return playerChosen;
    }

    public static int getValidIntegerInput(Scanner scanner, String prompt) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter an integer.");
            }
        }

        return input;
    }
}