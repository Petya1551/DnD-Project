package bg.tu_varna.sit.a1.f23621639.project.monsters;

public abstract class Monster {
    protected int strength;
    protected int mana;
    protected int health;

    public Monster(int strength, int mana, int health) {
        this.strength = strength;
        this.mana = mana;
        this.health = health;
    }

    public abstract int attack();
    public abstract int castSpell();
    public abstract void takeDamage(int damage);
    public abstract String getMonsterType();

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

    @Override
    public String toString() {
        return  "Strength: " + strength +
                "\nMana: " + mana +
                "\nHealth: " + health;
    }
}
