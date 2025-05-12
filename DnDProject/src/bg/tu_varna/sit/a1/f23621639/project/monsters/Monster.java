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

    public abstract int attack(Hero hero);
    public abstract int castSpell(Hero hero);
    public abstract void takeDamage(int damage);
    public abstract String getMonsterType();
    public abstract String getMonsterArmorType();

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

    @Override
    public String toString() {
        return  "Strength: " + strength +
                "\nMana: " + mana +
                "\nHealth: " + health +
                "\nArmor: " + (int)(armor*100) + "% (" + getMonsterArmorType() + ")";
    }
}
