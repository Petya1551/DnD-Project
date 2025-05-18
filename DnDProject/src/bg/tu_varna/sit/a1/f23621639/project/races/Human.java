package bg.tu_varna.sit.a1.f23621639.project.races;

public class Human extends Hero {

    public Human(String name) {
        super(name);
        this.strength = 30;
        this.mana = 20;
        this.health = 50;
    }

    /**
     * Returns the race type of this hero.
     *
     * @return "Human" as the race type
     */
    @Override
    public String getRace() {
        return "Human";
    }
}
