package bg.tu_varna.sit.a1.f23621639.project.monsters;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.util.Random;

/**
 * Represents a Dragon monster with stats that scale based on level.
 * The Dragon can attack and cast spells based on the level of the hero it faces.
 */
public class Dragon extends Monster {
    Random random = new Random();

    /**
     * Constructs a new Dragon instance, initializing its stats based on the given level.
     *
     * @param level the level of the Dragon, which scales its attributes
     */
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

    /**
     * Executes a physical attack on the given hero.
     * The damage scales based on the hero's level.
     *
     * @param hero the hero being attacked
     * @return the amount of physical damage dealt
     */
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

    /**
     * Executes a magical attack on the given hero.
     * The damage scales based on the hero's level.
     *
     * @param hero the hero being attacked
     * @return the amount of spell damage dealt
     */
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

    /**
     * Applies incoming damage to the Dragon, reduced based on its armor.
     *
     * @param damage the raw damage received
     */
    @Override
    public void takeDamage(int damage) {
        double scalesReduction = damage * armor;
        int reduced = damage - (int) scalesReduction;
        health -= reduced;

        if (health < 0) {
            health = 0;
        }
        else {
            System.out.println("The Dragon gets " + reduced + " damage. \nDragon's remaining health: " + health);
        }
    }

    /**
     * Gets the monster type name.
     *
     * @return the type "Dragon"
     */
    @Override
    public String getMonsterType() {
        return "Dragon";
    }

    /**
     * Gets the monster's armor type.
     *
     * @return the string "Scales"
     */
    @Override
    public String getMonsterArmorType() {
        return "Scales";
    }
}
