package bg.tu_varna.sit.a1.f23621639.project;

public class Human extends Hero{

    public Human(String name) {
        super(name);
        this.strength = 30;
        this.mana = 20;
        this.health = 50;
    }

    @Override
    public String getRace() {
        return "Human";
    }
}
