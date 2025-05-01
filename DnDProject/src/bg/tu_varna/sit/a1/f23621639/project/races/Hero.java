package bg.tu_varna.sit.a1.f23621639.project.races;

import bg.tu_varna.sit.a1.f23621639.project.items.Armor;
import bg.tu_varna.sit.a1.f23621639.project.items.Item;
import bg.tu_varna.sit.a1.f23621639.project.items.Spell;
import bg.tu_varna.sit.a1.f23621639.project.items.Weapon;

import java.util.Scanner;

public abstract class Hero {
    protected String name;
    protected int strength;
    protected int mana;
    protected int health;
    protected int level;
    protected Weapon weapon;
    protected Spell spell;
    protected Armor armor;

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.weapon = new Weapon("Ordinary sword", 20);
        this.spell = new Spell("Fire ball", 20);
        this.armor = new Armor("None", 0);
    }

    public void takeDamage(int damage) {
        int reduced = damage;
        if (armor != null) {
            reduced -= damage * armor.getBonus() / 100;
        }

        if (reduced < 0){
            reduced = 0;
        }

        health -= reduced;
        System.out.println(name + " takes " + reduced + " damage. Remaining health: " + health);
    }

    public void findTreasure(Item foundItem) {
        System.out.println(name + " found a " + foundItem.getType() + " " + foundItem.getName() + " with bonus " + foundItem.getBonus() + "%!");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to equip it? Yes(Y) / No(N) ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            if (foundItem instanceof Weapon) {
                System.out.println("Equipped new weapon: " + foundItem.getName());
                this.weapon = (Weapon) foundItem;
            } else if (foundItem instanceof Armor) {
                System.out.println("Equipped new armor: " + foundItem.getName());
                this.armor = (Armor) foundItem;
            } else if (foundItem instanceof Spell) {
                System.out.println("Equipped new spell: " + foundItem.getName());
                this.spell = (Spell) foundItem;
            }
        } else {
            System.out.println("You discarded the " + foundItem.getName() + ".");
        }
    }

    public void levelUp() {
        Scanner scanner = new Scanner(System.in);
        int points = 30;
        int str = 0, mana = 0, hp = 0;

        System.out.println("\n" + name + " leveled up to level " + (level + 1) + "!");
        System.out.println("You have " + points + " points to distribute between Strength, Mana, and Health.");

        while (points > 0) {
            System.out.println("Remaining points: " + points);
            System.out.print("Allocate to Strength: ");
            str = Integer.parseInt(scanner.nextLine());
            System.out.print("Allocate to Mana: ");
            mana = Integer.parseInt(scanner.nextLine());
            System.out.print("Allocate to Health: ");
            hp = Integer.parseInt(scanner.nextLine());

            if (str + mana + hp != 30) {
                System.out.println("Invalid input. Total must be exactly 30 points. Try again.");
                str = mana = hp = 0;
            } else {
                break;
            }
        }

        this.strength += str;
        this.mana += mana;
        this.health += hp;
        this.level++;

        System.out.println("New stats -> Strength: " + this.strength + ", Mana: " + this.mana + ", Health: " + this.health);
    }

    public int attack() {
        int bonus = weapon.getBonus();
        return strength + (strength * bonus / 100);
    }

    public int castSpell() {
        int bonus = spell.getBonus();
        return mana + (mana * bonus / 100);
    }

    public boolean isAlive() {
        if (health > 0)
            return true;
        else
            return false;
    }

    public abstract String getRace();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Spell getSpell() {
        return spell;
    }

    public void setSpell(Spell spell) {
        this.spell = spell;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return  "Name: " + getName() +
                "\nRace: " + getRace() +
                "\nStrength: " + getStrength() +
                "\nMana: " + getMana() +
                "\nHealth: " + getHealth() +
                "\nLevel: " + getLevel() +
                "\nWeapon: " + getWeapon().getName() +
                "\nSpell: " + getSpell().getName() +
                "\nArmor: " + getArmor().getName();
    }
}
