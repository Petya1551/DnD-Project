package bg.tu_varna.sit.a1.f23621639.project.items;

import java.util.Random;

public class ItemFactory {
    public Item generateRandomItem() {
        Random random = new Random();

        int itemType = random.nextInt(3);
        int bonus = 10 + random.nextInt(41);

        Item item = null;

        if (itemType == 0) {
            String[] weapons = {"Sword of Destiny", "Axe of Fury", "Blade of Shadows", "Hammer of Thunder", "Staff of Wisdom", "Dagger of Eternal Night", "Bow of the Sky", "Dragon Slayer Sword"};
            String weaponName = weapons[random.nextInt(weapons.length)];
            item = new Weapon(weaponName, bonus);
        }
        else if (itemType == 1) {
            String[] armors = {"Shield of Light", "Dragon Scale Armor", "Mystic Robe", "Iron Plate", "Cloak of Invisibility", "Titanium Chestplate", "Frostbite Mail", "Phoenix Feather Armor"};
            String armorName = armors[random.nextInt(armors.length)];
            item = new Armor(armorName, bonus);
        }
        else if (itemType == 2) {
            String[] spells = {"Fireball of Doom", "Ice Storm", "Lightning Strike", "Wind Blast", "Arcane Explosion", "Healing Light", "Meteor Shower", "Mana Surge"};
            String spellName = spells[random.nextInt(spells.length)];
            item = new Spell(spellName, bonus);
        }

        return item;
    }
}
