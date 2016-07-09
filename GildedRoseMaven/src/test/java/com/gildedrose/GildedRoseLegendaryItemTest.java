package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_QUALITY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

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
 void qualityOfAnLegendaryItemIsNeverChanged() {
  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY));
 }
}
