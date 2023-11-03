package roleplay.Game;

import roleplay.Main;
import roleplay.gameCharacters.*;
import roleplay.items.Items;
import roleplay.items.armor.armorTyp.HeavyArmor;
import roleplay.items.armor.armorTyp.LightArmor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop {
    public static List<Items> shopItems = new ArrayList<>();

    public boolean addShopItems(Items items) {
        return shopItems.add(items);
    }

    public static void shop(GameCharacters player) {
        System.out.println(player.getCoins());
        for (int i = 0; i < shopItems.size(); i++) {
            Items item = shopItems.get(i);
            System.out.println(i + " - " + item.getDesignation() + " - Price: " + item.getPrise() + "\n    Gewicht:" + item.getWeight());
        }
        System.out.println("Which item would you like to buy?");
        int interestedItem = Main.getValidIntegerInput(Main.scanner, "\n\nEnter your choice: ");

        if (interestedItem >= 0 && interestedItem < shopItems.size()) {
            Items selectedItem = shopItems.get(interestedItem);
            int playerCoins = player.getCoins();
            int itemPrice = selectedItem.getPrise();

            if (playerCoins >= itemPrice) {
                int newPlayerCoins = playerCoins - itemPrice;
                player.setCoins(newPlayerCoins);

                int availableCapacity = player.getLoadCapacity() - selectedItem.getWeight();
                if (selectedItem instanceof HeavyArmor) {
                    if (player instanceof Human || player instanceof Dwarfs || player instanceof Orcs) {
                        if (availableCapacity >= 0) {
                            player.setLoadCapacity(availableCapacity);
                            System.out.println("\nYou are now the proud owner of a " + selectedItem.getDesignation());
                            player.items.add(selectedItem);
                            System.out.println("\nYour load capacity: " + player.getLoadCapacity());
                            System.out.println("Your coins: " + player.getCoins());
                        } else {
                            System.out.println("\nYou don't have enough inventory space.");
                        }
                    } else {
                        System.out.println("\nYou are not strong enough to wear this.");
                    }
                } else if (selectedItem instanceof LightArmor) {
                    if (player instanceof Trolls || player instanceof Levin) {
                        System.out.println("\nYou are not the right size for this.");
                    } else {
                        if (availableCapacity >= 0) {
                            player.setLoadCapacity(availableCapacity);
                            System.out.println("\nYou are now the proud owner of a " + selectedItem.getDesignation());
                            player.items.add(selectedItem);
                            System.out.println("\nYour load capacity: " + player.getLoadCapacity());
                            System.out.println("Your coins: " + player.getCoins());
                        } else {
                            System.out.println("\nYou don't have enough inventory space.");
                        }
                    }
                } else {
                    if (availableCapacity >= 0) {
                        player.setLoadCapacity(availableCapacity);
                        System.out.println("\nYou are now the proud owner of a " + selectedItem.getDesignation());
                        player.items.add(selectedItem);
                        System.out.println("\nYour load capacity: " + player.getLoadCapacity());
                        System.out.println("Your coins: " + player.getCoins());
                    } else {
                        System.out.println("\nYou don't have enough inventory space.");
                    }
                }
            } else {
                System.out.println("\nYou don't have enough coins to purchase this item.");
            }
        } else {
            System.out.println("\nInvalid item choice.");
        }
    }
}