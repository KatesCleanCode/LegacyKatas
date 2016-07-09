package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_QUALITY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

@RunWith(JUnitPlatform.class)
public class GildedRoseAgedBrieTest {

 private GildedRose gildedRose;
 private Item item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableAgedBrie().getItem();
  gildedRose = new GildedRose(item);
 }

// - The Quality of an item is never more than 50
 @Test
 void agedBrieIncreasesInQualityTheOlderItGets() {
  gildedRose.updateQuality();

  assertThat(item.quality, equalTo(STANDARD_QUALITY + 1));
 }

}