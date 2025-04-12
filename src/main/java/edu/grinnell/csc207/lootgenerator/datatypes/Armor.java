package edu.grinnell.csc207.lootgenerator.datatypes;

public class Armor {
    
    private String name;
    
    private int minac;
    
    private int maxac;
    
    /**
     * Creates a new Armor piece with the given values
     * @param name the name of the armor
     * @param minac the minimum possible armor class value
     * @param maxac the maximum possible armor class value
     */
    public Armor(String name, int minac, int maxac) {
        this.name = name;
        this.minac = minac;
        this.maxac = maxac;
    }
    
    /**
     * Gets the name of the armor item
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the smallest possible armor class value (inclusive)
     * @return minac
     */
    public int getMinac() {
        return this.minac;
    }
    
    /**
     * Gets the largest possible armor class value (inclusive)
     * @return maxac
     */
    public int getMaxac() {
        return this.maxac;
    }
}
