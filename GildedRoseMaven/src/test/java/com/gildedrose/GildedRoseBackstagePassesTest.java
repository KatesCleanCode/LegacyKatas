package com.gildedrose;

import static com.gildedrose.testdata.ItemTestDataFactory.EXPIRE_DATE;
import static com.gildedrose.testdata.ItemTestDataFactory.STANDARD_QUALITY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gildedrose.testdata.ItemTestDataFactory;

import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.assertThat;

public class GildedRoseBackstagePassesTest {
 private static final int SELL_IN_BETWEEN_ZERO_AND_FOUR = 4;
 private static final int SELL_IN_BETWEEN_SIX_AND_NINE = 6;
 private GildedRose gildedRose;
 private UpdatableItem item;

 @BeforeEach
 void setUp() {
  item = ItemTestDataFactory.getUpdatableBackstagePasses();
  gildedRose = new GildedRose(item);
 }

 @Test
 void itemIncreasesInQualityByOneWhenSellInIsHigherThanTenDays() {
  item.setSellIn(11);
  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 1));
 }

 @Test
 void itemIncreasesInQualityByTwoWhenSellInIsInTenDays() {
  item.setSellIn(10);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 2));
 }

 @Test
 void itemIncreasesInQualityByTwoWhenSellInIsLessThanTenDays() {
  item.setSellIn(SELL_IN_BETWEEN_SIX_AND_NINE);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 2));
 }

 @Test
 void itemIncreasesInQualityByThreeWhenSellInIsFiveDays() {
  item.setSellIn(5);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 3));
 }

 @Test
 void
  itemIncreasesInQualityByThreeWhenSellInIsLowerThanFiveDays() {
  item.setSellIn(SELL_IN_BETWEEN_ZERO_AND_FOUR);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(STANDARD_QUALITY + 3));
 }

 @Test
 void itemQualityDropsAfterConcert() {
  item.setSellIn(EXPIRE_DATE);

  gildedRose.updateQuality();

  assertThat(item.getQuality(), equalTo(EXPIRE_DATE));
 }
}
