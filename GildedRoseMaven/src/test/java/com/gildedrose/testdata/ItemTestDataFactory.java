package com.gildedrose.testdata;

import com.gildedrose.Item;

public class ItemTestDataFactory {
 public static final int STANDARD_SELL_IN = 10;
 public static final int STANDARD_QUALITY = 20;

 public static Item getStandardItem() {
  return new Item("standard", STANDARD_SELL_IN, STANDARD_QUALITY);
 }

 public static final int MINIMUM_QUALITY = 0;

 public static Item getAgedBrie() {
  return new Item("Aged Brie", STANDARD_SELL_IN, STANDARD_QUALITY);
 }

}
