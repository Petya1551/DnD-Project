package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

/**
 * Represents the second level of the labyrinth map.
 */
public class MapLevelTwo extends Maps {

    /**
     * Constructs the second map level for the specified hero.
     *
     * @param hero the hero navigating the map
     */
    public MapLevelTwo(Hero hero) {
        super(hero);
    }

    /**
     * Returns the file paths of the maps available for level two.
     *
     * @return array of level 2 map file paths
     */
    @Override
    protected String[] getMapFilePaths() {
        return new String[] {
                "res/level2_1.txt",
                "res/level2_2.txt"
        };
    }

    /**
     * Returns the string representation of this level.
     *
     * @return "Second"
     */
    @Override
    protected String getLevel() {
        return "Second";
    }

    /**
     * Returns the numeric representation of this level.
     *
     * @return 2
     */
    @Override
    public int currentLevel() {
        return 2;
    }

    /**
     * Returns the X coordinate for the level exit.
     *
     * @return 13
     */
    @Override
    protected int getPlayerXEnd() {
        return 13;
    }

    /**
     * Returns the Y coordinate for the level exit.
     *
     * @return 8
     */
    @Override
    protected int getPlayerYEnd() {
        return 8;
    }
}