package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;

import com.gildedrose.testdata.ItemTestDataFactory;

public class GildedRoseBackstagePassesTest {
 private GildedRose gildedRose;
 private UpdatableItem item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableBackstagePasses();
  gildedRose = new GildedRose(item);
 }

}
