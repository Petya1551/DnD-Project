package bg.tu_varna.sit.a1.f23621639.project.battle;

import bg.tu_varna.sit.a1.f23621639.project.monsters.Monster;
import bg.tu_varna.sit.a1.f23621639.project.races.Hero;
import bg.tu_varna.sit.a1.f23621639.project.races.Human;
import bg.tu_varna.sit.a1.f23621639.project.races.Mage;
import bg.tu_varna.sit.a1.f23621639.project.races.Warrior;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Battle {
    private final Hero hero;
    private final Monster monster;
    private final Random random;
    private final Scanner scanner;

    public Battle(Hero hero, Monster monster, Random random, Scanner scanner) {
        this.hero = hero;
        this.monster = monster;
        this.random = random;
        this.scanner = scanner;
    }

    public void startBattle() {
        System.out.println("A battle begins between " + hero.getName() + " the " + hero.getRace() + " and a " + monster.getMonsterType() + "!");
        System.out.println("Your status is: \n" + hero.toString());
        System.out.println("The " + monster.getMonsterType() + " status is: \n" + monster.toString());

        boolean heroTurn = random.nextBoolean();
        if (heroTurn) {
            System.out.println(hero.getName() + " starts the battle!");
        } else {
            System.out.println(monster.getMonsterType() + " starts the battle!");
        }

        while (hero.getHealth() > 0 && monster.getHealth() > 0) {
            if (heroTurn) {
                System.out.println("Choose your attack: Physical or Spell:");
                Map<String, Supplier<Integer>> attack = new HashMap<>();
                attack.put("physical", () -> hero.attack());
                attack.put("spell", () -> hero.castSpell());

                String choice = scanner.nextLine().trim().toLowerCase();

                while (!choice.equals("physical") && !choice.equals("spell")) {
                    System.out.println("Invalid choice! Please choose 'Physical' or 'Spell'.");
                    choice = scanner.nextLine().trim().toLowerCase();
                }

                int damage = attack.get(choice).get();

                if (choice.equals("physical")) {
                    System.out.println(hero.getName() + " attacks with " + hero.getWeapon().getName() + " weapon for " + damage + " damage!");
                } else if (choice.equals("spell")) {
                    System.out.println(hero.getName() + " casts " + hero.getSpell().getName() + " spell for " + damage + " damage!");
                }
                monster.takeDamage(damage);
            }
            else {
                boolean useAttack = random.nextBoolean();
                if (useAttack) {
                    int damage = monster.attack();
                    System.out.println(monster.getMonsterType() + " attacks for " + damage + " damage!");
                    hero.takeDamage(damage);
                } else {
                    int damage = monster.castSpell();
                    System.out.println(monster.getMonsterType() + " casts a spell for " + damage + " damage!");
                    hero.takeDamage(damage);
                }
            }

            heroTurn = !heroTurn;
        }

        if (hero.getHealth() <= 0) {
            System.out.println(hero.getName() + " has died. Game over.");
        }
        else {
            System.out.println("The " + monster.getMonsterType() + " is defeated!");
            int restoredHealth = hero.getHealth() + hero.getHealth() / 2;
            hero.setHealth(restoredHealth);
            System.out.println(hero.getName() + "'s health is restored to " + restoredHealth);
            hero.levelUp();
            System.out.println(hero.toString());
        }
    }
}
