package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

public class MapLevelThree extends Maps{

    public MapLevelThree(Hero hero) {
        super(hero);
    }

    @Override
    protected String[] getMapFilePaths() {
        return new String[] {
                "res/level3_1.txt",
                "res/level3_2.txt"
        };
    }

    protected String getLevel() {
        return "Third";
    }

    public int currentLevel() {
        return 3;
    }

    @Override
    protected int getPlayerXEnd() {
        return 23;
    }

    @Override
    protected int getPlayerYEnd() {
        return 18;
    }
}
