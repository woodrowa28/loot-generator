package edu.grinnell.csc207.lootgenerator;

import edu.grinnell.csc207.lootgenerator.datatypes.Armor;
import edu.grinnell.csc207.lootgenerator.datatypes.MagicPrefix;
import edu.grinnell.csc207.lootgenerator.datatypes.MagicSuffix;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    public final String smallDataSet = "data/small";
    public final String largeDataSet = "data/large";
    
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
    
    @Test
    public void baseStatsInRangeTest() throws FileNotFoundException{
        Random rand = new Random();
        Armor armor;
        int defense;
        for (int i = 0; i < 50; i++) {
            armor = LootGenerator.generateBaseItem(rand, LootGenerator.fetchTreasureClass(rand,
                    LootGenerator.pickMonster(rand)));
            defense = LootGenerator.generateBaseStats(rand, armor);
            assertTrue(defense >= armor.getMinac());
            assertTrue(defense <= armor.getMaxac());
        }
    }
    
    @Test
    public void prefixStatsInRangeTest() throws FileNotFoundException{
        Random rand = new Random();
        ArrayList<MagicPrefix> prefixes = DataReader.readPrefixes(LootGenerator.DATA_SET);
        MagicPrefix prefix;
        int stat;
        for (int i = 0; i < 50; i++) {
            prefix = prefixes.get(rand.nextInt(prefixes.size()));
            stat = LootGenerator.randStatValue(rand, prefix.getModmin(), 
                    prefix.getModmax());
            assertTrue(stat >= prefix.getModmin());
            assertTrue(stat <= prefix.getModmax());
        }
    }
    
    @Test
    public void suffixStatsInRangeTest() throws FileNotFoundException{
        Random rand = new Random();
        ArrayList<MagicSuffix> suffixes = DataReader.readSuffixes(LootGenerator.DATA_SET);
        MagicSuffix suffix;
        int stat;
        for (int i = 0; i < 50; i++) {
            suffix = suffixes.get(rand.nextInt(suffixes.size()));
            stat = LootGenerator.randStatValue(rand, suffix.getModmin(), 
                    suffix.getModmax());
            assertTrue(stat >= suffix.getModmin());
            assertTrue(stat <= suffix.getModmax());
        }
    }
}
