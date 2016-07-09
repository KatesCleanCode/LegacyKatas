package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;

import com.gildedrose.testdata.ItemTestDataFactory;

public class GildedRoseConjuredItemTest {

 private GildedRose gildedRose;
 private UpdatableItem item;

// - "Conjured" items degrade in Quality twice as fast as normal
// items

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableConjuredItem();
  gildedRose = new GildedRose(item);
 }

}
