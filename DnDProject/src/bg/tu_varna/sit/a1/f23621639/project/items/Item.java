package bg.tu_varna.sit.a1.f23621639.project.items;

public class Item {
    private String name;
    private int bonus;
    protected String type;

    public Item(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    public String getType() {
        return type;
    }
}
