package roleplay.gameCharacters;
import roleplay.items.Items;
import roleplay.items.armor.Armor;
import roleplay.items.weapons.Weapons;

import java.util.ArrayList;
import java.util.List;

public abstract class GameCharacters {
    private String name;
    private double hp;
    private int loadCapacity;

    public List<Items> items = new ArrayList<>();
    private Weapons weapons;
    private int initiative;
    private Armor armor;
    private double maxHP;

    private int coins;
    private double damage;
    private int defens;

    public GameCharacters(String name, double hp, int loadCapacity, Weapons weapons, int initiative, Armor armor, double maxHP,int coins,double damage,int defens) {
        this.name = name;
        this.hp = hp;
        this.loadCapacity = loadCapacity;
        this.weapons = weapons;
        this.initiative = initiative;
        this.armor = armor;
        this.maxHP = maxHP;
        this.coins = coins;
        this.damage = damage;
        this.defens = defens;
    }

    public void ablegenWaffe() {
        if (getWeapons() != null) {
            loadCapacity += getWeapons().getWeight();
//            getWeapons() = null;
        }
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }


    public int getCoins() {
        return coins;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public double getDamage() {
        return damage;
    }

    public int getDefens() {
        return defens;
    }

    public void setDefens(int defens) {
        this.defens = defens;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    private List<Items> getItems() {
        return items;
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void assignWeapon(Weapons weapon) {
        this.weapons = weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public static void assignWeapon(GameCharacters player, Weapons weapon) {
        player.setWeapons(weapon);
    }
    public static void assingArmor(GameCharacters player, Armor armor){
        player.setArmor(armor);
    }

    public int getInitiative() {
        return initiative;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public Armor getArmor() {
        return armor;
    }
}



