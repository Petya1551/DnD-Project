package bg.tu_varna.sit.a1.f23621639.project;

import java.util.Scanner;

public abstract class Hero {
    protected String name;
    protected int strength;
    protected int mana;
    protected int health;
    protected int level;

    protected Item weapon;
    protected Item spell;
    protected Item armor;

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.weapon = new Item("Ordinary sword", 20, "weapon");
        this.spell = new Item("Fire ball", 20, "spell");
        this.armor = null;
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

        System.out.println("New stats -> Strength: " + strength + ", Mana: " + mana + ", Health: " + health);
    }
    public abstract String getRace();
}
