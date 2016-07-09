package com.gildedrose;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.gildedrose.testdata.ItemTestDataFactory;

public class GildedRoseConjuredItemTest {

 private GildedRose gildedRose;
 private UpdatableItem item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableConjuredItem();
  gildedRose = new GildedRose(item);
 }

 @Test
 @Disabled
 void itemsDegradeInQualityByTwo() {
  gildedRose.updateQuality();
// TODO not implemented yet
  Assert.assertThat(item.getQuality(),
   Matchers.equalTo(ItemTestDataFactory.STANDARD_QUALITY - 2));
 }

}
