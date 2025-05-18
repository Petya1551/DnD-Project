package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

public class MapLevelFour extends Maps{

    public MapLevelFour(Hero hero) {
        super(hero);
    }

    /**
     * Returns the file paths of the map layout options for this level.
     *
     * @return an array of strings representing file paths for level 4 maps
     */
    @Override
    protected String[] getMapFilePaths() {
        return new String[] {
                "res/level4_1.txt",
                "res/level4_2.txt"
        };
    }

    /**
     * Returns the name of this level.
     *
     * @return a string describing the level (e.g., "Fourth")
     */
    @Override
    protected String getLevel() {
        return "Fourth";
    }

    /**
     * Returns the integer representing the current level number.
     *
     * @return 4 as this is the fourth level
     */
    @Override
    public int currentLevel() {
        return 4;
    }

    /**
     * Returns the X-coordinate where the player should reach to complete this level.
     *
     * @return the X-coordinate of the level's exit point
     */
    @Override
    protected int getPlayerXEnd() {
        return 38;
    }

    /**
     * Returns the Y-coordinate where the player should reach to complete this level.
     *
     * @return the Y-coordinate of the level's exit point
     */
    @Override
    protected int getPlayerYEnd() {
        return 28;
    }
}
