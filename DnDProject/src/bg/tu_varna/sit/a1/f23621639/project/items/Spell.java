package bg.tu_varna.sit.a1.f23621639.project.items;

/**
 * Represents a spell item in the game.
 */
public class Spell extends Item {

    /**
     * Creates a new Spell item with the specified name and bonus value.
     *
     * @param name  the name of the spell
     * @param bonus the bonus value that the spell provides
     */
    public Spell(String name, int bonus) {
        super(name, bonus);
        this.type = "spell";
    }
}
