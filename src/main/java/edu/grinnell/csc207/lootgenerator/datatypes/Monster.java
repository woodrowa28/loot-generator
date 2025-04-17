package edu.grinnell.csc207.lootgenerator.datatypes;

/**
 * Details for a monster type. Has a name, type, level (type and level are irrelevant for
 * program but present in data files), and treasure class that details what loot is dropped.
 * @author Aubrey Woodrow
 */
public class Monster {
    
    private String monsterClass;
    
    private String type;
    
    private int level;
    
    private String treasureClass;
    
    /**
     * Creates a new Monster with the given values
     * @param monsterClass the class (name) of monster
     * @param type the type of monster
     * @param level the level of monster
     * @param treasureClass the treasure class this monster drops
     */
    public Monster(String monsterClass, String type, int level, String treasureClass) {
        this.monsterClass = monsterClass;
        this.type = type;
        this.level = level;
        this.treasureClass = treasureClass;
    }
    
    /**
     * Gets the class (name) of the monster
     * @return monsterClass
     */
    public String getMonsterClass() { 
        return this.monsterClass;
    }
    
    /**
     * Gets the treasure class the monster drops upon death
     * @return treasureClass
     */
    public String getTreasureClass() {
        return this.treasureClass;
    }
}
