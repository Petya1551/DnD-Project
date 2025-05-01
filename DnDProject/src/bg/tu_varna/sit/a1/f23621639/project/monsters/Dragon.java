package bg.tu_varna.sit.a1.f23621639.project.monsters;

public class Dragon extends Monster {
    private double scales;
    public Dragon(int strength, int mana, int health, double scales) {
        super(25, 25, 50);
        this.scales = 0.15;
    }

    @Override
    public int attack() {
        return strength;
    }

    @Override
    public int castSpell() {
        return mana;
    }

    @Override
    public void takeDamage(int damage) {
        double scalesReduction = damage * scales;
        int reduced = damage - (int) scalesReduction;
        health -= reduced;

        if (health < 0) {
            health = 0;
            System.out.println("The Dragon is dead.");
        }
        else {
            System.out.println("The Dragon gets " + reduced + " damage. \nRemaining health: " + health);
        }
    }

    @Override
    public String getMonsterType() {
        return "Dragon";
    }
}
