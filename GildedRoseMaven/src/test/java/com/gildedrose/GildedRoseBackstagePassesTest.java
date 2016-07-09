package com.gildedrose;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.testdata.ItemTestDataFactory;

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
 void backstagePassesIncreasesInQualityAsOlderItGets() {
  gildedRose.updateQuality();

  Assert.assertThat(item.getQuality(),
   Matchers.equalTo(ItemTestDataFactory.STANDARD_QUALITY + 1));
 }

}
