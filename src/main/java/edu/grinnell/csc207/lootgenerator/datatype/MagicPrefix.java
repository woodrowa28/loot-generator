package edu.grinnell.csc207.lootgenerator.datatype;

public class MagicPrefix {
    
    private String name;
    
    private String modcode;
    
    private int modmin;
    
    private int modmax;
    
    /**
     * Creates a new MagicPrefix with the given values
     * @param name the prefix to attach to the item
     * @param modcode the statistic text
     * @param modmin the minimum stat value
     * @param modmax the maximum stat value
     */
    public MagicPrefix(String name, String modcode, int modmin, int modmax) {
        this.name = name;
        this.modcode = modcode;
        this.modmin = modmin;
        this.modmax = modmax;
    }
    
    /**
     * Gets the name of the added prefix
     * @return name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Gets the statistic tag detailing what the prefix does
     * @return modcode
     */
    public String getModcode() {
        return this.modcode;
    }
    
    /**
     * Gets the minimum value for the modifier statistic (inclusive)
     * @return modmin
     */
    public int getModmin() {
        return this.modmin;
    }
    
    /**
     * Gets the maximum value for the modifier statistic (inclusive)
     * @return modmax
     */
    public int getModmax() {
        return this.modmax;
    }
}
