package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        
        app.updateQuality();
        
        assertEquals("foo", app.items[0].name);
    }

    @ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"2, 0, 1, 1",
		"-1, 48, -2, 50",
		"2, 50, 1, 50",
		"-2, 49, -3, 50",
		"1, 1, 0, 2",
		})
	void product_Aged_Brie_Test(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Aged Brie";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
    
    @ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"1, 0, 1, 0",
		"0, 1, 0, 1",
		"-1, 1, -1, 1",
		})
	void product_Sulfuras_Test(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Sulfuras, Hand of Ragnaros";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
    
    @ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"11, 0, 10, 1",
		"7, 1, 6, 3",
		"7, 49, 6, 50",
		"5, 3, 4, 6",
		"0, 3, -1, 0",
		"-1, 3, -2, 0",
		})
    @DisplayName("Product: Backstage passes")
	void productPassesTest(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Backstage passes to a TAFKAL80ETC concert";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
    
    @ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"11, 10, 10, 9",
		"7, 1, 6, 0",
		"5, -5, 4, 0",
		"0, 3, -1, 1",
		})
	void other_Product_Test(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Normal Product";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}

    @ParameterizedTest(name = "{index} => sellIn: {0} quality: {1} –> sellIn: {2} quality: {3}")
	@CsvSource({
		"11, 10, 10, 8",
		"7, 1, 6, 0",
		"-5, 10, -6, 6",
		"0, 3, -1, 0",
		})
	void product_Conjured_Test(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Conjured Mana Cake";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}

    @Nested
    class FuncionalesTest {

    	@Test
    	void test() {
    		assertDoesNotThrow(() -> TexttestFixture.main(new String[] {}));
    	}
    	
    	class ItemTest extends Item {

			public ItemTest(String name, int sellIn, int quality) {
				super(name, sellIn, quality);
			}
			@Override
			public int hashCode() {
				return Objects.hash(name, quality, sellIn);
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (!(obj instanceof Item))
					return false;
				Item other = (Item) obj;
				return Objects.equals(name, other.name) && quality == other.quality && sellIn == other.sellIn;
			}
    		
    	}

    	@Test
    	void resultTest() {
            Item[] items_in = new Item[] {
                    new Item("+5 Dexterity Vest", 10, 20), //
                    new Item("Aged Brie", 2, 0), //
                    new Item("Elixir of the Mongoose", 5, 7), //
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    // this conjured item does not work properly yet
//                    new Item("Conjured Mana Cake", 3, 6) 
                    };
            ItemTest[] items_out = new ItemTest[] {
                    new ItemTest("+5 Dexterity Vest", 9, 19), //
                    new ItemTest("Aged Brie", 1, 1), //
                    new ItemTest("Elixir of the Mongoose", 4, 6), //
                    new ItemTest("Sulfuras, Hand of Ragnaros", 0, 80), //
                    new ItemTest("Sulfuras, Hand of Ragnaros", -1, 80),
                    new ItemTest("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                    new ItemTest("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                    new ItemTest("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                    // this conjured item does not work properly yet
//                    new ItemTest("Conjured Mana Cake", 2, 4) 
                    };
            GildedRose app = new GildedRose(items_in);
            app.updateQuality();
            assertArrayEquals(items_out, items_in);
    	}
    }
}
