package edu.grinnell.csc207.lootgenerator.datatype;

public class TreasureClass {
    
    private String treasureClass;
    
    private String item1;
    
    private String item2;
    
    private String item3;
    
    /**
     * Creates a new TreasureClass with the given values. The items may
     * refer to the names of other TreasureClass objects as well
     * @param treasureClass the name of the class
     * @param item1 the first possible item
     * @param item2 the second possible item
     * @param item3 the third possible item
     */
    public TreasureClass(String treasureClass, String item1, String item2, String item3) {
        this.treasureClass = treasureClass;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }
    
    /**
     * Gets the class (name) of the treasure class
     * @return treasureClass
     */
    public String getTreasureClass() {
        return this.treasureClass;
    }
    
    /**
     * Gets the first possible item/class drop
     * @return item1
     */
    public String getItem1() {
        return this.item1;
    }
    
    /**
     * Gets the second possible item/class drop
     * @return item2
     */
    public String getItem2() {
        return this.item2;
    }
    
    /**
     * Gets the third possible item/class drop
     * @return item3
     */
    public String getItem3() {
        return this.item3;
    }
}
    
