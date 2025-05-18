package bg.tu_varna.sit.a1.f23621639.project.items;

/**
 * Represents an armor item in the game.
 */
public class Armor extends Item {

    /**
     * Creates a new Armor item with the specified name and bonus value.
     *
     * @param name  the name of the armor
     * @param bonus the bonus value that the armor provides
     */
    public Armor(String name, int bonus) {
        super(name, bonus);
        this.type = "armor";
    }
}
