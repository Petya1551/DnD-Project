package bg.tu_varna.sit.a1.f23621639.project;

public abstract class Hero {
    private int strength;
    private int mana;
    private int health;
    private int level;

    public Hero(int strength, int mana, int health) {
        this.strength = strength;
        this.mana = mana;
        this.health = health;
        this.level = 1;
    }

    public abstract void attack();
    public abstract void castSpell();
    public abstract void takeDamage();
    public abstract void findTreasure();

    public void levelUp() {
        this.level++;
        System.out.println("Level up! Now at level " + level);
    }
}
