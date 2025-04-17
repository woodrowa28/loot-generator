package edu.grinnell.csc207.lootgenerator;

import edu.grinnell.csc207.lootgenerator.datatypes.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Allows users to simulate killing monsters and generates possible loot drops. Program
 * will continue execution and user prompting until the user decides to quit.
 * @author Aubrey Woodrow
 */
public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    public static final String DATA_SET = "data/large";
    
    /**
     * Main program entry. Continually executes loot generation loop.
     * @param args command line arguments (not used here)
     * @throws FileNotFoundException upon data file parsing error.
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("This program kills monsters and generates loot!");
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;
        Monster monster;
        String treasureName;
        Armor armor;
        int defense;
        
        while (running) {
            monster = pickMonster(rand);
            treasureName = fetchTreasureClass(monster);
            armor = generateBaseItem(rand, treasureName);
            defense = generateBaseStats(rand, armor);
            generateAffix(rand, armor, defense);
            running = promptUser(input);
        }
    }
    
    /**
     * Chooses a random monster from the possible monsters. Reads in the data from
     * the monster file, picks a random one, and prints its details to the screen.
     * @param rand Random object for random num generation
     * @return the monster chosen
     * @throws FileNotFoundException upon data file parsing error
     */
    public static Monster pickMonster(Random rand) throws FileNotFoundException {
        ArrayList<Monster> monsters = DataReader.readMonsters(DATA_SET);
        Monster monster = monsters.get(rand.nextInt(monsters.size()));
        String monsterName = monster.getMonsterClass();
        System.out.println("\nFighting " + monsterName + "...");
        System.out.println("You have slain " + monsterName + "!");
        System.out.println(monsterName + " dropped:\n");
        return monster;
    }
    
    /**
     * Gets the treasure class associated with the monster
     * @param monster the slain monster to retrieve the treasure from
     * @return the treasure class
     * @throws FileNotFoundException upon data file parsing error
     */
    public static String fetchTreasureClass(Monster monster) 
            throws FileNotFoundException {
        return monster.getTreasureClass();
    }
    
    /**
     * Chooses a random armor from the treasure class. Reads in the data from
     * the treasure and armor files, and keeps repeating the random selection of treasure until
     * an armor item is chosen (as opposed to another treasure class)
     * @param rand Random object for random num generation
     * @param treasureName the name of the starting treasure class
     * @return the armor chosen
     * @throws FileNotFoundException upon data file parsing error
     */
    public static Armor generateBaseItem(Random rand, String treasureName) 
            throws FileNotFoundException {
        HashMap<String, TreasureClass> treasures = DataReader.readTreasure(DATA_SET);
        TreasureClass treasure;
        while (treasures.containsKey(treasureName)) {
            treasure = treasures.get(treasureName);
            switch ((rand.nextInt(3) + 1)) {
                case 1:
                    treasureName = treasure.getItem1();
                    break;
                case 2:
                    treasureName = treasure.getItem2();
                    break;
                case 3:
                    treasureName = treasure.getItem3();
                    break;
            }
        }
        HashMap<String, Armor> armors = DataReader.readArmor(DATA_SET);
        return armors.get(treasureName);
    }
    
    /**
     * Chooses a random value between the min and max provided for the armor/affix stat
     * @param rand Random object for random num generation
     * @param min minimum possible stat value
     * @param max maximum possible stat value
     * @return chosen stat, between min and max (inclusive)
     */
    public static int randStatValue(Random rand, int min, int max) {
        return min + rand.nextInt(max - min + 1);
    }
    
    /**
     * Chooses a random value for the given armor item
     * @param rand Random object for random num generation
     * @param armor armor item to get stat for
     * @return defense stat of armor, between armor's max and min values (inclusive)
     */
    public static int generateBaseStats(Random rand, Armor armor) {
        return randStatValue(rand, armor.getMinac(), armor.getMaxac());
    }
    
    /**
     * Generates a random prefix, suffix, both, or neither for the current armor item.
     * Each affix has a 50% chance of being chosen
     * @param rand Random object for random num generation
     * @param armor armor item to modify stats for
     * @param defense base defense stat of armor
     * @throws FileNotFoundException upon data file parsing error
     */
    public static void generateAffix(Random rand, Armor armor, int defense) 
            throws FileNotFoundException {
        MagicPrefix prefix = null;
        MagicSuffix suffix = null;
        if (rand.nextBoolean()) {
            ArrayList<MagicPrefix> prefixes = DataReader.readPrefixes(DATA_SET);
            prefix = prefixes.get(rand.nextInt(prefixes.size()));
        }
        
        if (rand.nextBoolean()) {
            ArrayList<MagicSuffix> suffixes = DataReader.readSuffixes(DATA_SET);
            suffix = suffixes.get(rand.nextInt(suffixes.size()));
        } 
        
        System.out.print((prefix == null ? "" : (prefix.getName() + " ")));
        System.out.print(armor.getName());
        System.out.print((suffix == null ? "" : (" " + suffix.getName())));
        System.out.println("\nDefense: " + defense);
        if (prefix != null) {
            System.out.println(randStatValue(rand, prefix.getModmin(), 
                    prefix.getModmax()) + " " + prefix.getModcode());
        }
        if (suffix != null) {
            System.out.println(randStatValue(rand, suffix.getModmin(), 
                    suffix.getModmax()) + " " + suffix.getModcode());
        }
    }
    
    /**
     * Manages user input for each round of combat. Prompts the user for whether or not
     * they wish to continue fighting repeatedly until an accepted response is provided
     * (non-case sensitive y/n)
     * @param input scanner object, reading user input from System.in
     * @return whether or not to keep running the loot generation (from user)
     */
    public static boolean promptUser(Scanner input) {
        String again;
        while (true) {
            System.out.print("Fight again [y/n]? ");
            again = input.nextLine();
            if (again.equals("Y") || again.equals("y")) {
                return true;
            } else if (again.equals("N") || again.equals("n")) {
                return false;
            }
        }
    }
}
