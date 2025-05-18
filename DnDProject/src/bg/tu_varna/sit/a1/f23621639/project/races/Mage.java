package bg.tu_varna.sit.a1.f23621639.project.races;

/**
 * Represents a Mage hero race with specific attributes.
 */
public class Mage extends Hero {

    /**
     * Constructs a Mage hero with the given name and default attributes.
     *
     * @param name the name of the Mage hero
     */
    public Mage(String name) {
        super(name);
        this.strength = 10;
        this.mana = 40;
        this.health = 50;
    }

    /**
     * Returns the race type of this hero.
     *
     * @return the string "Mage"
     */
    @Override
    public String getRace() {
        return "Mage";
    }
}
