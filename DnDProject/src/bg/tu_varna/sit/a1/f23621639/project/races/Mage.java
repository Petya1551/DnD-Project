package bg.tu_varna.sit.a1.f23621639.project.races;


public class Mage extends Hero {

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
