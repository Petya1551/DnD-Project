package bg.tu_varna.sit.a1.f23621639.project.files;

import bg.tu_varna.sit.a1.f23621639.project.items.Armor;
import bg.tu_varna.sit.a1.f23621639.project.items.Spell;
import bg.tu_varna.sit.a1.f23621639.project.items.Weapon;
import bg.tu_varna.sit.a1.f23621639.project.races.Hero;
import bg.tu_varna.sit.a1.f23621639.project.races.Human;
import bg.tu_varna.sit.a1.f23621639.project.races.Mage;
import bg.tu_varna.sit.a1.f23621639.project.races.Warrior;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utility class responsible for loading a Hero object from a formatted text file.
 */
public class LoadHeroFile {

    /**
     * Reads hero attributes and equipment from a file and creates a corresponding Hero object.
     * The file must contain lines specifying the hero's name, race, stats, level,
     * and equipped weapon, spell, and armor with their respective bonuses.
     *
     * @param filename the path to the hero save file
     * @return a Hero object populated with the saved data, or null if loading fails
     */
    public static Hero loadHero(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String name = null, race = null;
            int strength = 0, mana = 0, health = 0, maxHealth = 0, level = 0;
            String weaponName = null, spellName = null, armorName = null;
            int weaponBonus = 0, spellBonus = 0, armorBonus = 0;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    name = line.substring(6).trim();
                } else if (line.startsWith("Race: ")) {
                    race = line.substring(6).trim();
                } else if (line.startsWith("Strength: ")) {
                    strength = Integer.parseInt(line.substring(10).trim());
                } else if (line.startsWith("Mana: ")) {
                    mana = Integer.parseInt(line.substring(6).trim());
                } else if (line.startsWith("Health: ")) {
                    String[] hpParts = line.substring(8).trim().split("/");
                    health = Integer.parseInt(hpParts[0]);
                    maxHealth = Integer.parseInt(hpParts[1]);
                } else if (line.startsWith("Level: ")) {
                    level = Integer.parseInt(line.substring(7).trim());
                } else if (line.startsWith("Weapon: ")) {
                    weaponName = line.substring(8).trim();
                } else if (line.startsWith("Weapon's bonus: ")) {
                    weaponBonus = Integer.parseInt(line.substring(15).trim().replace("%", ""));
                } else if (line.startsWith("Spell: ")) {
                    spellName = line.substring(7).trim();
                } else if (line.startsWith("Spell's bonus: ")) {
                    spellBonus = Integer.parseInt(line.substring(14).trim().replace("%", ""));
                } else if (line.startsWith("Armor: ")) {
                    armorName = line.substring(7).trim();
                } else if (line.startsWith("Armor's bonus: ")) {
                    armorBonus = Integer.parseInt(line.substring(14).trim().replace("%", ""));
                }
            }

            Hero hero;

            if (race.equals("Human")) {
                hero = new Human(name);
            } else if (race.equals("Mage")) {
                hero = new Mage(name);
            } else {
                hero = new Warrior(name);
            }

            hero.setStrength(strength);
            hero.setMana(mana);
            hero.setHealth(health);
            hero.setMaxHealth(maxHealth);
            hero.setLevel(level);
            hero.setWeapon(new Weapon(weaponName, weaponBonus));
            hero.setSpell(new Spell(spellName, spellBonus));
            hero.setArmor(new Armor(armorName, armorBonus));
            return hero;

        } catch (IOException e) {
            System.out.println("Failed to load hero from file: " + e.getMessage());
            return null;
        }
    }
}
