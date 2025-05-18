package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

public class MapLevelOne extends Maps {

    public MapLevelOne(Hero hero) {
        super(hero);
    }

    /**
     * Returns the file paths of the maps available for level one.
     *
     * @return array of level 1 map file paths
     */
    @Override
    protected String[] getMapFilePaths() {
        return new String[] {
                "res/level1_1.txt",
                "res/level1_2.txt"
        };
    }

    /**
     * Returns the string representation of this level.
     *
     * @return "First"
     */
    @Override
    protected String getLevel() {
        return "First";
    }

    /**
     * Returns the numeric representation of this level.
     *
     * @return 1
     */
    @Override
    public int currentLevel() {
        return 1;
    }

    /**
     * Returns the X coordinate for the level exit.
     *
     * @return 8
     */
    @Override
    protected int getPlayerXEnd() {
        return 8;
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