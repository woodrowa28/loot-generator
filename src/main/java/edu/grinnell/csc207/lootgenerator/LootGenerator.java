package edu.grinnell.csc207.lootgenerator;

import edu.grinnell.csc207.lootgenerator.datatypes.*;
import java.util.Random;
import java.util.Scanner;

public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    public static final String DATA_SET = "data/small";
    
    public static void main(String[] args) {
        System.out.println("This program kills monsters and generates loot!");
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean running = true;
        Monster monster;
        TreasureClass treasure;
        Armor armor;
        
        while (running) {
            monster = pickMonster(rand);
            treasure = fetchTreasureClass(rand, monster);
            armor = generateBaseItem(rand, treasure);
            generateBaseStats(rand, armor);
            generateAffix(rand);
            running = promptUser(input);
        }
    }
    
    public static Monster pickMonster(Random rand) {
        return null;
    }
    
    public static TreasureClass fetchTreasureClass(Random rand, Monster monster) {
        return null;
    }
    
    public static Armor generateBaseItem(Random rand, TreasureClass treasure) {
        return null;
    }
    
    public static void generateBaseStats(Random rand, Armor armor) {
        
    }
    
    public static void generateAffix(Random rand) {
        
    }
    
    public static boolean promptUser(Scanner input) {
        return false;
    }
}
