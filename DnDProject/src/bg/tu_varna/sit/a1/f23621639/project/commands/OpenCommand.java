package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.files.LoadHeroFile;
import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelFour;
import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelOne;
import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelThree;
import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelTwo;
import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

public class OpenCommand implements Command{

    /**
     * Loads the saved hero from the file {@code save_game.txt} and resumes the game
     * from the corresponding map level. If the file or hero data is not found,
     * the method will display an error and exit the program.
     *
     * @throws InterruptedException if the thread is interrupted during the simulated loading process.
     */
    @Override
    public void execute() throws InterruptedException {
        System.out.println();
        for (int i = 0; i <= 100; i++) {
            System.out.print("\rLoading last saved hero " + i + "%");
            Thread.sleep(50);
        }

        Hero loadedHero = LoadHeroFile.loadHero("save_game.txt");

        if (loadedHero != null) {
            System.out.println("\n\nHero loaded successfully!\n");
            System.out.println("Current status: \n" + loadedHero.toString() + "\n");
            if (loadedHero.getLevel() == 1) {
                MapLevelOne levelOne = new MapLevelOne(loadedHero);
                levelOne.start();
            } else if (loadedHero.getLevel() == 2) {
                MapLevelTwo levelTwo = new MapLevelTwo(loadedHero);
                levelTwo.start();
            } else if (loadedHero.getLevel() == 3) {
                MapLevelThree levelThree = new MapLevelThree(loadedHero);
                levelThree.start();
            } else if (loadedHero.getLevel() == 4) {
                MapLevelFour levelFour = new MapLevelFour(loadedHero);
                levelFour.start();
            }
        } else {
            System.out.println("\n\nNo saved hero found. Cannot start the game.");
            System.exit(0);
        }
    }
}
