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

/**
 * Manages a turn-based battle between a Hero and a Monster.
 * Handles attack choices, damage application, and battle outcome.
 */
public class Battle {
    private final Hero hero;
    private final Monster monster;
    private final Random random;
    private final Scanner scanner;

    /**
     * Constructs a new Battle instance between a hero and a monster.
     *
     * @param hero    the Hero participating in the battle
     * @param monster the Monster opponent the hero will fight
     * @param random  a Random instance used to determine turn order and monster actions
     * @param scanner a Scanner instance used to read user input for attack choices
     */
    public Battle(Hero hero, Monster monster, Random random, Scanner scanner) {
        this.hero = hero;
        this.monster = monster;
        this.random = random;
        this.scanner = scanner;
    }

    /**
     * Starts the battle sequence. The battle continues until either
     * the hero or the monster's health reaches zero.
     */
    public void startBattle() {
        int initialHeroHealth = hero.getHealth();
        System.out.println("BATTLE BEGINS");
        System.out.println("A battle begins between " + hero.getName() + " the " + hero.getRace() + " and a " + monster.getMonsterType() + "!\n");
        System.out.println("Your current status is: \n" + hero.toString());
        System.out.println("\nThe " + monster.getMonsterType() + " status is: \n" + monster.toString() + "\n");

        boolean heroTurn = random.nextBoolean();
        if (heroTurn) {
            System.out.println(hero.getName() + " starts the battle!");
        } else {
            System.out.println(monster.getMonsterType() + " starts the battle!");
        }

        while (hero.getHealth() > 0 && monster.getHealth() > 0) {
            if (heroTurn) {
                System.out.printf("Choose your attack 'Physical' or 'Spell': ");
                Map<String, Supplier<Integer>> attack = new HashMap<>();
                attack.put("physical", hero::attack);
                attack.put("spell", hero::castSpell);

                String choice = scanner.nextLine().trim().toLowerCase();

                while (!choice.equals("physical") && !choice.equals("spell")) {
                    System.out.printf("\nInvalid choice! Please choose 'Physical' or 'Spell': ");
                    choice = scanner.nextLine().trim().toLowerCase();
                }

                int damage = attack.get(choice).get();

                if (choice.equals("physical")) {
                    System.out.println("\n" + hero.getName() + " attacks with " + hero.getWeapon().getName() + " weapon for " + damage + " damage!");
                } else if (choice.equals("spell")) {
                    System.out.println("\n" + hero.getName() + " casts " + hero.getSpell().getName() + " spell for " + damage + " damage!");
                }
                monster.takeDamage(damage);
            }
            else {
                boolean useAttack = random.nextBoolean();
                if (useAttack) {
                    int damage = monster.attack(hero);
                    System.out.println(monster.getMonsterType() + " attacks for " + damage + " damage!");
                    hero.takeDamage(damage);
                } else {
                    int damage = monster.castSpell(hero);
                    System.out.println(monster.getMonsterType() + " casts a spell for " + damage + " damage!");
                    hero.takeDamage(damage);
                }
            }

            heroTurn = !heroTurn;
        }

        if (hero.getHealth() <= 0) {
            System.out.println("\n------------------------------------------------------------------------\n" +
                    "|                             GAME OVER                                |\n" +
                    "|                                                                      |\n" +
                    "|                         You have fallen...                           |\n" +
                    "|      The labyrinth claims yet another brave soul in silence.         |\n" +
                    "|     Your journey ends here, but legends are not so easily lost.      |\n" +
                    "------------------------------------------------------------------------\n");
            System.exit(0);
        }
        else {
            System.out.println("The " + monster.getMonsterType() + " is defeated!");
            if (hero.getHealth() >= hero.getMaxHealth()) {
                System.out.println(hero.getName() + "'s current health is " + hero.getMaxHealth());
            }
            else {
                int restoredHealth = hero.getHealth() + initialHeroHealth / 2;

                if (restoredHealth > hero.getMaxHealth()) {
                    restoredHealth = hero.getMaxHealth();
                }

                hero.setHealth(restoredHealth);
                System.out.println(hero.getName() + "'s health is restored to " + hero.getHealth() + "\n");
            }

        }
    }
}
