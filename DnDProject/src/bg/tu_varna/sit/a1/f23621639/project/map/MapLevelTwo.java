package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

public class MapLevelTwo extends Maps {

    public MapLevelTwo(Hero hero) {
        super(hero);
    }

    @Override
    protected String[] getMapFilePaths() {
        return new String[] {
                "res/level2_1.txt",
                "res/level2_2.txt"
        };
    }

    protected String getLevel() {
        return "Second";
    }

    public int currentLevel() {
        return 2;
    }

    @Override
    protected int getPlayerXEnd() {
        return 13;
    }

    @Override
    protected int getPlayerYEnd() {
        return 8;
    }
}