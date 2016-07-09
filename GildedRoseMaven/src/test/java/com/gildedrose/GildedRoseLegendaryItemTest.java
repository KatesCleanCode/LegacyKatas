package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_QUALITY;
import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_SELL_IN;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

public class GildedRoseLegendaryItemTest {
 private GildedRose gildedRose;
 private UpdatableItem item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableLegendaryItem();
  gildedRose = new GildedRose(item);
 }

 @Test
 void qualityOfAnLegendaryItemIsNeverChanged() {
  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY));
 }

 @Test
 void sellInOfAnLegendaryItemIsNeverChanged() {
  gildedRose.updateQuality();

  assertThat(item.getSellIn(), equalTo(STANDARD_SELL_IN));
 }
}
