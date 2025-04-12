package edu.grinnell.csc207.lootgenerator;

import edu.grinnell.csc207.lootgenerator.datatypes.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DataReader {
    
    /**
     * Reads the monsters data file and stores every monster in an ArrayList. Data
     * should be spaced in the file to work with the array accesses
     * @param dataSet the data pathway to read from - either the large or small set
     * @return ArrayList of all monsters
     * @throws FileNotFoundException upon file parsing error
     */
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
    
    /**
     * Reads the prefixes data file and stores every magic prefix in an ArrayList. Data
     * should be spaced in the file to work with the array accesses
     * @param dataSet the data pathway to read from - either the large or small set
     * @return ArrayList of all prefixes
     * @throws FileNotFoundException upon file parsing error
     */
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
    
    /**
     * Reads the suffixes data file and stores every magic suffix in an ArrayList. Data
     * should be spaced in the file to work with the array accesses
     * @param dataSet the data pathway to read from - either the large or small set
     * @return ArrayList of all suffixes
     * @throws FileNotFoundException upon file parsing error
     */
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
    
    /**
     * Reads the armor data file and stores every armor piece in a HashMap. Data
     * should be spaced in the file to work with the array accesses
     * @param dataSet the data pathway to read from - either the large or small set
     * @return HashMap of all armors
     * @throws FileNotFoundException upon file parsing error
     */
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
    
    /**
     * Reads the treasure data file and stores every armor class in a HashMap. Data
     * should be spaced in the file to work with the array accesses
     * @param dataSet the data pathway to read from - either the large or small set
     * @return HashMap of all treasure classes
     * @throws FileNotFoundException upon file parsing error
     */
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
