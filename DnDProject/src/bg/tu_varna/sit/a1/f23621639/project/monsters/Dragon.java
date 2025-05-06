package bg.tu_varna.sit.a1.f23621639.project.monsters;

import java.util.Random;

public class Dragon extends Monster {
    private double scales;
    Random random = new Random();

    public Dragon() {
        this.strength = 25;
        this.mana = 25;
        this.health = 50;
        this.scales = 0.15;
    }

    @Override
    public int attack() {
        int attack = 10 + random.nextInt(16);
        return attack;
    }

    @Override
    public int castSpell() {
        int spell = 10 + random.nextInt(16);
        return spell;
    }

    @Override
    public void takeDamage(int damage) {
        double scalesReduction = damage * scales;
        int reduced = damage - (int) scalesReduction;
        health -= reduced;
        strength -= reduced;
        mana -= reduced;

        if (health < 0) {
            health = 0;
        }
        else {
            System.out.println("The Dragon gets " + reduced + " damage. \nDragon's remaining health: " + health);
        }
    }

    @Override
    public String getMonsterType() {
        return "Dragon";
    }
}
