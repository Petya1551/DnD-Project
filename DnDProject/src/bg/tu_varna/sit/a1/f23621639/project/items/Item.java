package bg.tu_varna.sit.a1.f23621639.project.items;

/**
 * Represents an item that can be found or used by heroes in the game.
 * Each item has a name, a bonus value, and a type.
 */
public class Item {
    private String name;
    private int bonus;
    protected String type;

    /**
     * Constructs a new Item with the specified name and bonus.
     *
     * @param name  the name of the item
     * @param bonus the bonus value provided by the item
     */
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
