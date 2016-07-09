package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.MINIMUM_QUALITY;
import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_QUALITY;
import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_SELL_IN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

@RunWith(JUnitPlatform.class)
public class GildedRoseStandardItemTest {

 private GildedRose gildedRose;
 private Item item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getStandardItem();
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
 void qualityOfAnItemIsNeverNegative() {
  item.quality = 0;

  gildedRose.updateQuality();

  assertThat(item.quality, equalTo(MINIMUM_QUALITY));
 }

 @Test
 void onceSellInDatePassedQualityDecreasesByTwo() {
  item.sellIn = 0;

  gildedRose.updateQuality();

  assertThat(item.quality, equalTo(STANDARD_QUALITY - 2));
 }

 @Test
 void atEndOfDayQualityIsDecreasedByOne() {
  gildedRose.updateQuality();

  assertThat(item.quality, equalTo(STANDARD_QUALITY - 1));
 }

 @Test
 void atEndOfDaySellInIsDecreasedByOne() {
  gildedRose.updateQuality();

  assertThat(item.sellIn, equalTo(STANDARD_SELL_IN - 1));
 }

}
