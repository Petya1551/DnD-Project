package bg.tu_varna.sit.a1.f23621639.project.items;

/**
 * Represents a weapon item in the game.
 */
public class Weapon extends Item {

    /**
     * Creates a new Weapon item with the specified name and bonus value.
     *
     * @param name  the name of the weapon
     * @param bonus the bonus value that the weapon provides
     */
    public Weapon(String name, int bonus) {
        super(name, bonus);
        this.type = "weapon";
    }
}
