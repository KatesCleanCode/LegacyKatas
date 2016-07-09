package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.MINIMUM_QUALITY;
import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_QUALITY;
import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_SELL_IN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

public class GildedRoseStandardItemTest {

 private GildedRose gildedRose;
 private UpdatableItem item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableStandardItem();
  gildedRose = new GildedRose(item);
 }

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
  item.setQuality(MINIMUM_QUALITY);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(MINIMUM_QUALITY));
 }

 @Test
 void onceSellInDatePassedQualityDecreasesByTwo() {
  item.setSellIn(0);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY - 2));
 }

 @Test
 void atEndOfDayQualityIsDecreasedByOne() {
  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY - 1));
 }

 @Test
 void atEndOfDaySellInIsDecreasedByOne() {
  gildedRose.updateQuality();

  assertThat(item.getSellIn(), equalTo(STANDARD_SELL_IN - 1));
 }

}
