package com.gildedrose.testdata;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;

public class ItemTestDataFactory {
 public static final int STANDARD_SELL_IN = 10;
 public static final int STANDARD_QUALITY = 20;
 public static final int MINIMUM_QUALITY = 0;
 public static final int MAX_QUALITY = 50;

 public static Item getStandardItem() {
  return new Item("standard", STANDARD_SELL_IN, STANDARD_QUALITY);
 }

 public static Item getAgedBrie() {
  return new Item("Aged Brie", STANDARD_SELL_IN, STANDARD_QUALITY);
 }

 public static UpdatableItem getUpdatableAgedBrie() {
  return new UpdatableItem(getAgedBrie());
 }

 public static UpdatableItem getUpdatableStandardItem() {
  return new UpdatableItem(getStandardItem());
 }

 public static UpdatableItem getUpdatableLegendaryItem() {
  return new UpdatableItem(new Item("Sulfuras, Hand of Ragnaros",
   STANDARD_SELL_IN, STANDARD_QUALITY));
 }

}
