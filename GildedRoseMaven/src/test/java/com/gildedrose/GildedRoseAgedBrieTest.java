package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.MAX_QUALITY;
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
 private UpdatableItem item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableAgedBrie();
  gildedRose = new GildedRose(item);
 }

 @Test
 void qualityOfAnItemIsNeverMoreThanMaxValue() {
  item.setQuality(MAX_QUALITY);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(MAX_QUALITY));
 }

 @Test
 void agedBrieIncreasesInQualityTheOlderItGets() {
  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 1));
 }

}
