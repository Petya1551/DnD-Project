package bg.tu_varna.sit.a1.f23621639.project;


public class Mage extends Hero{

    public Mage(String name) {
        super(name);
        this.strength = 10;
        this.mana = 40;
        this.health = 50;
    }

    @Override
    public String getRace() {
        return "Mage";
    }
}
