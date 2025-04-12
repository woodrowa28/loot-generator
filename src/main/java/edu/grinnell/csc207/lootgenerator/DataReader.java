package edu.grinnell.csc207.lootgenerator;

import edu.grinnell.csc207.lootgenerator.datatypes.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {
    
    public static ArrayList<Monster> readMonsters(String dataSet) throws FileNotFoundException {
        File file = new File(dataSet + "/monstats.txt");
        ArrayList<Monster> monsters = new ArrayList<>();
        Scanner input = new Scanner(file);
        String[] dataEntries;
        while (input.hasNextLine()) {
            dataEntries = input.nextLine().split("\t");
            monsters.add(new Monster(dataEntries[0], dataEntries[1], 
                    Integer.parseInt(dataEntries[2]), dataEntries[3]));
        }
        return monsters;
    }
    
    public static ArrayList<MagicPrefix> readPrefixes(String dataSet) 
            throws FileNotFoundException {
        File file = new File(dataSet + "/MagicPrefix.txt");
        ArrayList<MagicPrefix> prefixes = new ArrayList<>();
        Scanner input = new Scanner(file);
        String[] dataEntries;
        while (input.hasNextLine()) {
            dataEntries = input.nextLine().split("\t");
            prefixes.add(new MagicPrefix(dataEntries[0], dataEntries[1], 
                    Integer.parseInt(dataEntries[2]), Integer.parseInt(dataEntries[3])));
        }
        return prefixes;
    }
    
    public static ArrayList<MagicSuffix> readSuffixes(String dataSet) 
            throws FileNotFoundException {
        File file = new File(dataSet + "/MagicSuffix.txt");
        ArrayList<MagicSuffix> suffixes = new ArrayList<>();
        Scanner input = new Scanner(file);
        String[] dataEntries;
        while (input.hasNextLine()) {
            dataEntries = input.nextLine().split("\t");
            suffixes.add(new MagicSuffix(dataEntries[0], dataEntries[1], 
                    Integer.parseInt(dataEntries[2]), Integer.parseInt(dataEntries[3])));
        }
        return suffixes;
    }
    
    public static HashMap<String, Armor> readArmor(String dataSet) throws FileNotFoundException {
        File file = new File(dataSet + "/armor.txt");
        HashMap<String, Armor> armors = new HashMap<>();
        Scanner input = new Scanner(file);
        String[] dataEntries;
        while (input.hasNextLine()) {
            dataEntries = input.nextLine().split("\t");
            armors.put(dataEntries[0], new Armor(dataEntries[0], 
                    Integer.parseInt(dataEntries[1]), Integer.parseInt(dataEntries[2])));
        }
        return armors;
    }
    
    public static HashMap<String, TreasureClass> readTreasure(String dataSet) 
            throws FileNotFoundException {
        File file = new File(dataSet + "/TreasureClassEx.txt");
        HashMap<String, TreasureClass> treasures = new HashMap<>();
        Scanner input = new Scanner(file);
        String[] dataEntries;
        while (input.hasNextLine()) {
            dataEntries = input.nextLine().split("\t");
            treasures.put(dataEntries[0], new TreasureClass(dataEntries[0], dataEntries[1],
                dataEntries[2], dataEntries[3]));
        }
        return treasures;
    }
}
