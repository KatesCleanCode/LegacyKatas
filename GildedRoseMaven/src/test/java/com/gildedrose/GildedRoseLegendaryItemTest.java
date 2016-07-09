package com.gildedrose;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.testdata.ItemTestDataFactory;

public class GildedRoseLegendaryItemTest {
// - "Sulfuras", being a legendary item, never has to be sold or
// decreases in Quality
 private GildedRose gildedRose;
 private UpdatableItem item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableLegendaryItem();
  gildedRose = new GildedRose(item);
 }

 @Test
 void qualityOfAnItemIsNeverMoreThanMaxValue() {
  gildedRose.updateQuality();

  Assert.assertThat(item.getQuality(),
   Matchers.equalTo(ItemTestDataFactory.STANDARD_QUALITY));
 }
//
// @Test
// void agedBrieIncreasesInQualityTheOlderItGets() {
// gildedRose.updateQuality();
//
// assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 1));
// }

}
