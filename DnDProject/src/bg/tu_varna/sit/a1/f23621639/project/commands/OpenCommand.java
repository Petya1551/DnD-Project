package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelOne;
import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.util.Scanner;

public class OpenCommand implements Command{
    private final Scanner scanner;
    private final Hero hero;

    public OpenCommand(Scanner scanner, Hero hero) {
        this.scanner = scanner;
        this.hero = hero;
    }

    @Override
    public void execute() throws InterruptedException {
        System.out.println("Opening Level 1...\n");

        MapLevelOne levelOne = new MapLevelOne(hero);
        levelOne.start();
    }
}
