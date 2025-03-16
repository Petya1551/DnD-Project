package bg.tu_varna.sit.a1.f23621639.project;

public abstract class Monster {
    private int strength;
    private int mana;
    private int health;

    public Monster(int strength, int mana, int health) {
        this.strength = strength;
        this.mana = mana;
        this.health = health;
    }

    public abstract void attack();
    public abstract void castSpell();
    public abstract void takeDamage();
}
