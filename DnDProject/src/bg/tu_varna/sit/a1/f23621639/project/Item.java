package bg.tu_varna.sit.a1.f23621639.project;

public class Item {
    private String name;
    private double bonus;
    private String type;

    public Item(String name, double bonus, String type) {
        this.name = name;
        this.bonus = bonus;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getBonus() {
        return bonus;
    }

    public String getType() {
        return type;
    }
}
