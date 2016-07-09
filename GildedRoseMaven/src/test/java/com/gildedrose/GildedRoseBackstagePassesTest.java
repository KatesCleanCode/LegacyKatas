package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_QUALITY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

public class GildedRoseBackstagePassesTest {
 private GildedRose gildedRose;
 private UpdatableItem item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableBackstagePasses();
  gildedRose = new GildedRose(item);
 }

// - "Backstage passes", like aged brie, increases in Quality as
// its SellIn value approaches;
// Quality increases by 2 when there are 10 days or less and by 3
// when there are 5 days or less but
// Quality drops to 0 after the concert
//
 @Test
 void itemIncreasesInQualityByOne() {
  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 1));
 }

 @Test
 void itemIncreasesInQualityByTwoWhenSellInIsInTenDays() {
  item.setSellIn(10);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 2));
 }

 @Test
 void itemIncreasesInQualityByTwoWhenSellInIsLessThanTenDays() {
  item.setSellIn(9);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 2));
 }

}
