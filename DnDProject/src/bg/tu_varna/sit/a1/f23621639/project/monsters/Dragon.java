package bg.tu_varna.sit.a1.f23621639.project.monsters;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.util.Random;

public class Dragon extends Monster {
    Random random = new Random();

    public Dragon(int level) {
        int baseStrength = 25;
        int baseMana = 25;
        int baseHealth = 50;
        double baseArmor = 0.15;

        this.strength = baseStrength + (level - 1) * 10;
        this.mana = baseMana + (level - 1) * 10;
        this.health = baseHealth + (level - 1) * 10;
        this.armor = baseArmor + (level - 1) * 0.05;
    }

    @Override
    public int attack(Hero hero) {
        int attackLevel = 6;
        int attack = 10 + random.nextInt(attackLevel);

        if (hero.getLevel() == 2){
            attack = 15 + random.nextInt(attackLevel);
        } else if (hero.getLevel() == 3) {
            attack = 20 + random.nextInt(attackLevel);
        } else if (hero.getLevel() == 4) {
            attack = 25 + random.nextInt(attackLevel);
        } else if (hero.getLevel() == 5) {
            attack = 30 + random.nextInt(attackLevel);
        }
        return attack;
    }

    @Override
    public int castSpell(Hero hero) {
        int spellLevel = 6;
        int spell = 10 + random.nextInt(spellLevel);

        if (hero.getLevel() == 2){
            spell = 15 + random.nextInt(spellLevel);
        } else if (hero.getLevel() == 3) {
            spell = 20 + random.nextInt(spellLevel);
        } else if (hero.getLevel() == 4) {
            spell = 25 + random.nextInt(spellLevel);
        } else if (hero.getLevel() == 5) {
            spell = 30 + random.nextInt(spellLevel);
        }
        return spell;
    }

    @Override
    public void takeDamage(int damage) {
        double scalesReduction = damage * armor;
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

    @Override
    public String getMonsterArmorType() {
        return "Scales";
    }
}
