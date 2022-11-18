package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;

class GildedRoseTest {

//	Alle Einzelteile haben einen Verkaufswert, der die Anzahl der Tage spiegelt, nach dem die Items verkauft sein müssen.
//	Alle Einzelteile haben einen Qualitätswert, der aussagt, wie wertvoll der Artikel ist
//	Am Ende jedes Tages senkt unser System beide Werte für jedes Element
//	Sobald das Verfallsdatum abgelaufen ist, verschlechtert die Qualität doppelt so schnell
//	Die Qualität eines Artikels ist nie negativ
//	"Aged Brie" erhöht die Qualität, je älter es wird
//	Die Qualität eines Artikels ist nie höher als 50
//	"Sulfuras", ein legendärer Gegenstand kann nie verkauft werden oder verringert die  Qualität
//	"Backstage-Pässe", so wie bei „Aged Brie“, steigern die Qualität, wenn sich das Verfallsdatum nähert. 
//	Qualität erhöht sich doppelt so schnell, wenn 10 Tage oder weniger fehlen, und dreifach, wenn 5 Tagen oder weniger fehlen.
//	Aber Qualität fällt auf 0 nach dem Konzert.
//	Wir haben kürzlich einen Anbieter von zauberte Artikel. Dies erfordert eine Aktualisierung unseres Systems:
//	"Bezauberte" Artikel degradieren in Qualität doppelt so schnell wie normale Artikel

//	test ob alle items verändert werden

	private static final int EXPIRED_SELLIN = 0;

	@Test
	void qualityOfBackstagePassesIncreasesByOneWhenSellInIsHigherThanTen() {
		int initialQuality = 2;
		GildedRose app = createAppWithBackstagePassesItem(11, initialQuality);
		app.updateItems();
		assertEquals(initialQuality + 1, app.items[0].quality);
	}

	@Test
	void qualityOfBackstagePassesIncreasesByTwoWhenSellInIsTen() {
		int initialQuality = 2;
		GildedRose app = createAppWithBackstagePassesItem(10, initialQuality);
		app.updateItems();
		assertEquals(initialQuality + 2, app.items[0].quality);
	}

	@Test
	void qualityOfBackstagePassesIncreasesByThreeWhenSellInIsFive() {
		int initialQuality = 2;
		GildedRose app = createAppWithBackstagePassesItem(5, initialQuality);
		app.updateItems();
		assertEquals(initialQuality + 3, app.items[0].quality);
	}

	@Test
	void qualityOfBackstagePassesIsZeroWhenSellInExpires() {
		int initialQuality = 2;
		GildedRose app = createAppWithBackstagePassesItem(EXPIRED_SELLIN, initialQuality);
		app.updateItems();
		assertEquals(0, app.items[0].quality);
	}

	@Test
	void qualityOfSimpleItemDecreasesByOneAfterOneDay() {
		int initialQuality = 2;
		GildedRose app = createAppWithSimpleItem(4, initialQuality);
		app.updateItems();
		assertEquals(initialQuality - 1, app.items[0].quality);
	}

	@Test
	@Disabled("not yet implemented")
	void qualityOfConjuredItemDecreasesByTwoAfterOneDay() {
		int initialQuality = 2;
		GildedRose app = createAppWithConjuredItem(4, initialQuality);
		app.updateItems();
		assertEquals(initialQuality - 2, app.items[0].quality);
	}

	@Test
	void qualityOfAgedBrieIsIncreasedByOneAfterOneDay() {
		int initialQuality = 2;
		GildedRose app = createAppWithAgedBrieItem(4, initialQuality);
		app.updateItems();
		assertEquals(initialQuality + 1, app.items[0].quality);
	}

	@Test
	void qualityOfSimpleItemDecreasesByTwoAfterSellInExpired() {
		int initialQuality = 5;
		GildedRose app = createAppWithSimpleItem(EXPIRED_SELLIN, initialQuality);
		app.updateItems();
		assertEquals(initialQuality - 2, app.items[0].quality);
	}

	@Test
	@Disabled("not yet implemented")
	void qualityOfConjuredItemDecreasesByFourAfterSellInExpired() {
		int initialQuality = 5;
		GildedRose app = createAppWithConjuredItem(EXPIRED_SELLIN, initialQuality);
		app.updateItems();
		assertEquals(initialQuality - 4, app.items[0].quality);
	}

	@Test
	void qualityCannotBeNegative() {
		int initialQuality = 0;
		GildedRose app = createAppWithSimpleItem(1, initialQuality);
		app.updateItems();
		assertEquals(initialQuality, app.items[0].quality);
	}

	@Test
	void qualityIsMax50() {
		int initialQuality = 50;
		GildedRose app = createAppWithAgedBrieItem(1, initialQuality);
		app.updateItems();
		assertEquals(initialQuality, app.items[0].quality);
	}

	@Test
	void qualityOfSulfarasIsNotChanged() {
		int initialQuality = 2;
		GildedRose app = createAppWithSulfarasItem(4, initialQuality);
		app.updateItems();
		assertEquals(initialQuality, app.items[0].quality);
	}

	@Test
	void sellInOfSulfarasIsNotChanged() {
		int initialSellIn = 4;
		GildedRose app = createAppWithSulfarasItem(initialSellIn, 6);
		app.updateItems();
		assertEquals(initialSellIn, app.items[0].sellIn);
	}

	@Test
	void sellInOfSimpleItemDecreasesByOneAfterOneDay() {
		int initialSellIn = 4;
		GildedRose app = createAppWithSimpleItem(initialSellIn, 3);
		app.updateItems();
		assertEquals(initialSellIn - 1, app.items[0].sellIn);
	}

	private GildedRose createAppWithItem(String itemName, int initialSellIn, int initialQuality) {
		Item[] items = new Item[] { new Item(itemName, initialSellIn, initialQuality) };
		return new GildedRose(items);
	}

	private GildedRose createAppWithSimpleItem(int initialSellIn, int initialQuality) {
		return createAppWithItem("foo", initialSellIn, initialQuality);
	}

	private GildedRose createAppWithAgedBrieItem(int initialSellIn, int initialQuality) {
		return createAppWithItem("Aged Brie", initialSellIn, initialQuality);
	}

	private GildedRose createAppWithSulfarasItem(int initialSellIn, int initialQuality) {
		return createAppWithItem("Sulfuras, Hand of Ragnaros", initialSellIn, initialQuality);
	}

	private GildedRose createAppWithBackstagePassesItem(int initialSellIn, int initialQuality) {
		return createAppWithItem("Backstage passes to a TAFKAL80ETC concert", initialSellIn, initialQuality);
	}

	private GildedRose createAppWithConjuredItem(int initialSellIn, int initialQuality) {
		return createAppWithItem("Conjured Mana Cake", initialSellIn, initialQuality);
	}
}
