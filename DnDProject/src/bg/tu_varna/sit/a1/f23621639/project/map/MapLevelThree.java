package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

public class MapLevelThree extends Maps{

    public MapLevelThree(Hero hero) {
        super(hero);
    }

    /**
     * Returns the file paths of the maps available for level three.
     *
     * @return array of level 3 map file paths
     */
    @Override
    protected String[] getMapFilePaths() {
        return new String[] {
                "res/level3_1.txt",
                "res/level3_2.txt"
        };
    }

    /**
     * Returns the string representation of this level.
     *
     * @return "Third"
     */
    @Override
    protected String getLevel() {
        return "Third";
    }

    /**
     * Returns the numeric representation of this level.
     *
     * @return 3
     */
    @Override
    public int currentLevel() {
        return 3;
    }

    /**
     * Returns the X coordinate for the level exit.
     *
     * @return 23
     */
    @Override
    protected int getPlayerXEnd() {
        return 23;
    }

    /**
     * Returns the Y coordinate for the level exit.
     *
     * @return 18
     */
    @Override
    protected int getPlayerYEnd() {
        return 18;
    }
}
