package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_QUALITY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

@RunWith(JUnitPlatform.class)
public class GildedRoseAgedBrieTest {

 private GildedRose gildedRose;
 private Item item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getAgedBrie();
  gildedRose = new GildedRose(new Item[] { item });
 }

// - The Quality of an item is never more than 50
// - "Sulfuras", being a legendary item, never has to be sold or
// decreases in Quality
// - "Backstage passes", like aged brie, increases in Quality as
// its SellIn value approaches;
// Quality increases by 2 when there are 10 days or less and by 3
// when there are 5 days or less but
// Quality drops to 0 after the concert
//
// - "Conjured" items degrade in Quality twice as fast as normal
// items
 @Test
 void agedBrieIncreasesInQualityTheOlderItGets() {
  gildedRose.updateQuality();

  assertThat(item.quality, equalTo(STANDARD_QUALITY + 1));
 }

}
