package bg.tu_varna.sit.a1.f23621639.project.races;

/**
 * Represents a Warrior hero race with specific attributes.
 */
public class Warrior extends Hero {

    /**
     * Constructs a Warrior hero with the given name and default attributes.
     *
     * @param name the name of the Warrior hero
     */
    public Warrior(String name) {
        super(name);
        this.strength = 40;
        this.mana = 10;
        this.health = 50;
    }

    /**
     * Returns the race type of this hero.
     *
     * @return the string "Warrior"
     */
    @Override
    public String getRace() {
        return "Warrior";
    }
}
