package edu.grinnell.csc207.lootgenerator;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    public String smallDataSet = "data/small";
    public String largeDataSet = "data/large";
    
    @Test
    public void collectionsSizeSmallDataTest() throws FileNotFoundException {
        assertEquals(DataReader.readMonsters(smallDataSet).size(), 1);
        assertEquals(DataReader.readArmor(smallDataSet).size(), 9);
        assertEquals(DataReader.readTreasure(smallDataSet).size(), 6);
        assertEquals(DataReader.readPrefixes(smallDataSet).size(), 5);
        assertEquals(DataReader.readSuffixes(smallDataSet).size(), 5);
    }
    
    @Test
    public void collectionsSizeLargeDataTest() throws FileNotFoundException{
        assertEquals(DataReader.readMonsters(largeDataSet).size(), 49);
        assertEquals(DataReader.readArmor(largeDataSet).size(), 202);
        assertEquals(DataReader.readTreasure(largeDataSet).size(), 68);
        assertEquals(DataReader.readPrefixes(largeDataSet).size(), 372);
        assertEquals(DataReader.readSuffixes(largeDataSet).size(), 386);
    }
}
