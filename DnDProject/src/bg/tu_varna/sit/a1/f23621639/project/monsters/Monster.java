package bg.tu_varna.sit.a1.f23621639.project.monsters;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

public abstract class Monster {
    protected int strength;
    protected int mana;
    protected int health;
    protected double armor;

    public Monster() {
        this.strength = strength;
        this.mana = mana;
        this.health = health;
        this.armor = armor;
    }

    /**
     * Executes a physical attack on the given hero.
     *
     * @param hero the hero being attacked
     * @return the amount of damage dealt
     */
    public abstract int attack(Hero hero);
    /**
     * Executes a magical attack on the given hero.
     *
     * @param hero the hero being attacked
     * @return the amount of spell damage dealt
     */
    public abstract int castSpell(Hero hero);
    /**
     * Applies damage to the monster, factoring in its armor.
     *
     * @param damage the incoming raw damage
     */
    public abstract void takeDamage(int damage);
    /**
     * Returns the type of the monster (e.g., "Dragon").
     *
     * @return the monster's type
     */
    public abstract String getMonsterType();
    /**
     * Returns the type of armor the monster has (e.g., "Scales").
     *
     * @return the armor type
     */
    public abstract String getMonsterArmorType();

    /**
     * Checks if the monster is still alive.
     *
     * @return true if health > 0, otherwise false
     */
    public boolean isAlive() {
        if (health > 0)
            return true;
        else
            return false;
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

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    /**
     * Returns a string representation of the monster's stats.
     *
     * @return formatted stats as a string
     */
    @Override
    public String toString() {
        return  "Strength: " + strength +
                "\nMana: " + mana +
                "\nHealth: " + health +
                "\nArmor: " + (int)(armor*100) + "% (" + getMonsterArmorType() + ")";
    }
}
