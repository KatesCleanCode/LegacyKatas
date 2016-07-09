package com.gildedrose;

public class UpdatableItem {

 private Item item;

 public UpdatableItem(Item item) {
  this.item = item;
 }

 public Item getItem() {
  return item;
 }

 public Object getQuality() {
  return item.quality;
 }

}
