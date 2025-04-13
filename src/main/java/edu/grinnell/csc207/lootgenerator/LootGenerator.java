package edu.grinnell.csc207.lootgenerator;

import edu.grinnell.csc207.lootgenerator.datatypes.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    public static final String DATA_SET = "data/small";
    
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
            treasureName = fetchTreasureClass(rand, monster);
            armor = generateBaseItem(rand, treasureName);
            defense = generateBaseStats(rand, armor);
            generateAffix(rand, armor, defense);
            running = promptUser(input);
        }
    }
    
    public static Monster pickMonster(Random rand) throws FileNotFoundException {
        ArrayList<Monster> monsters = DataReader.readMonsters(DATA_SET);
        Monster monster = monsters.get(rand.nextInt(monsters.size()));
        String monsterName = monster.getMonsterClass();
        System.out.println("\nFighting " + monsterName + "...");
        System.out.println("You have slain " + monsterName + "!");
        System.out.println(monsterName + " dropped:\n");
        return monster;
    }
    
    public static String fetchTreasureClass(Random rand, Monster monster) 
            throws FileNotFoundException {
        return monster.getTreasureClass();
    }
    
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
    
    public static int randStatValue(Random rand, int min, int max) {
        return min + rand.nextInt(max - min + 1);
    }
    
    public static int generateBaseStats(Random rand, Armor armor) throws FileNotFoundException {
        return randStatValue(rand, armor.getMinac(), armor.getMaxac());
    }
    
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
    
    public static boolean promptUser(Scanner input) {
        String again;
        while (true) {
            System.out.print("Fight again [y/n]? ");
            again = input.nextLine();
            if (again.equals("Y") || again.equals("y")) {
                return true;
            } else if(again.equals("N") || again.equals("n")) {
                return false;
            }
        }
    }
}
