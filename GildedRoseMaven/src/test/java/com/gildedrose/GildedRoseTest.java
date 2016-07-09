package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

/**
 * - At the end of each day our system lowers both values for every
 * item
 *
 * Pretty simple, right? Well this is where it gets interesting:
 *
 * - Once the sell by date has passed, Quality degrades twice as
 * fast - The Quality of an item is never negative - "Aged Brie"
 * actually increases in Quality the older it gets - The Quality of
 * an item is never more than 50 - "Sulfuras", being a legendary
 * item, never has to be sold or decreases in Quality -
 * "Backstage passes", like aged brie, increases in Quality as its
 * SellIn value approaches; Quality increases by 2 when there are
 * 10 days or less and by 3 when there are 5 days or less but
 * Quality drops to 0 after the concert
 *
 * We have recently signed a supplier of conjured items. This
 * requires an update to our system:
 *
 * - "Conjured" items degrade in Quality twice as fast as normal
 * items
 *
 *
 */
@RunWith(JUnitPlatform.class)
public class GildedRoseTest {

 public static final int STANDARD_SELL_IN = 10;
 public static final int STANDARD_QUALITY = 20;

 @Test
 void atEndOfDayQualityIsDecreasedByOne() {
  int sellIn = 10;
  int quality = 20;
  Item item = new Item("standard", sellIn, quality);
  GildedRose gildedRose = new GildedRose(new Item[] { item });

  gildedRose.updateQuality();

  assertThat(item.quality, equalTo(quality - 1));
 }

 @Test
 void atEndOfDaySellInIsDecreasedByOne() {
// Item item =
  Item item = ItemTestDataFactory.getStandardItem();
  GildedRose gildedRose = new GildedRose(new Item[] { item });

  gildedRose.updateQuality();

  assertThat(item.sellIn, equalTo(STANDARD_SELL_IN - 1));
 }

}
