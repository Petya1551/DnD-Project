package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

public class MapLevelFour extends Maps{

    public MapLevelFour(Hero hero) {
        super(hero);
    }

    @Override
    protected String[] getMapFilePaths() {
        return new String[] {
                "res/level4_1.txt",
                "res/level4_2.txt"
        };
    }

    @Override
    protected String getLevel() {
        return "Forth";
    }

    @Override
    public int currentLevel() {
        return 4;
    }

    @Override
    protected int getPlayerXEnd() {
        return 38;
    }

    @Override
    protected int getPlayerYEnd() {
        return 28;
    }
}
