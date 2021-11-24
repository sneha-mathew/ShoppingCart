package com.shop.cart.item;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.shop.cart.itemFactor.ItemFactor;

class ItemCreationTest {

	@Test
	void shouldReturnSamePrice_whenNotImportedChocolate() {
		ItemFactor itemBuilder= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemBuilder.getItem("1 Chocolate- KitKat box at 10.00")
			.getTaxInclusivePrice();
		assertEquals(price, taxIncusivePrice);
	}
	@Test
	void shouldReturnTaxInclusivePrice_whenImportedBooks() {
		ItemFactor itemBuilder= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemBuilder.getItem("1 Imported Book- How to become successful at 10.00")
			.getTaxInclusivePrice();
		assertEquals(price.add(new BigDecimal(".5")), taxIncusivePrice);
	}
	@Test
	void shouldReturnSamePrice_whenNotImportedBook() {
		ItemFactor itemBuilder= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemBuilder.getItem("1 Book- The truth at 10.00")
			.getTaxInclusivePrice();
		assertEquals(price, taxIncusivePrice);
	}
	@Test
	void shouldReturnTaxInclusivePrice_whenImportedMedicine() {
		ItemFactor itemBuilder= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemBuilder.getItem("1 Imported Pills- XATR200 at 10.00")
			.getTaxInclusivePrice();
		assertEquals(price.add(new BigDecimal(".5")), taxIncusivePrice);
	}
	@Test
	void shouldReturnSamePrice_whenNotImportedMedicine() {
		ItemFactor itemBuilder= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemBuilder.getItem("1 Medicine- SE38E at 10.00")
			.getTaxInclusivePrice();
		assertEquals(price, taxIncusivePrice);
	}
	@Test
	void shouldReturnTaxInclusivePrice_whenImportedChocolate() {
		ItemFactor itemBuilder= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemBuilder.getItem("1 Imported Chocolate- KitKat box at 10.00")
			.getTaxInclusivePrice();
		assertEquals(price.add(new BigDecimal(".5")), taxIncusivePrice);
	}

	@Test
	void shouldReturnSalesTaxInclusivePrice_whenNotImportedPerfume() {
		ItemFactor itemBuilder= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemBuilder.getItem("1 Yadley Perfume at 10")
			.getTaxInclusivePrice();
		assertEquals(price.add(new BigDecimal("1")), taxIncusivePrice);
	}
	@Test
	void shouldReturnTaxInclusivePrice_whenImportedPerfume() {
		ItemFactor itemFactor= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemFactor.getItem("1 Candiana Perfume - Imported at 10.00")
			.getTaxInclusivePrice();
		assertEquals(price.add(new BigDecimal("1")).add(new BigDecimal(".5")), taxIncusivePrice);
	}
	@Test
	void shouldReturnTaxInclusivePrice_whenTwoImportedPerfume() {
		ItemFactor itemFactor= new ItemFactor();
		BigDecimal price = new BigDecimal("10.00");
		BigDecimal taxIncusivePrice = itemFactor.getItem("2 Candian Perfume - Imported at 10.00")
			.getTaxInclusivePrice();
		assertEquals(price.multiply(new BigDecimal("2")).add(new BigDecimal("1")).add(new BigDecimal("1")), taxIncusivePrice);
	}
	@Test
	void shouldReturnNull_whenQuantityMissing() {
		ItemFactor itemFactor= new ItemFactor();
		Item item = itemFactor.getItem("Candian Perfume - Imported at 10.00");
		assertEquals(null, item);
	}
	@Test
	void shouldReturnNull_whenATMissing() {
		ItemFactor itemFactor= new ItemFactor();
		Item item = itemFactor.getItem("2 Candian Perfume - Imported 10.00");
		assertEquals(null, item);
	}
	@Test
	void shouldReturnNull_whenPriceMissing() {
		ItemFactor itemFactor= new ItemFactor();
		Item item = itemFactor.getItem("2 Candian Perfume - Imported at ten");
		assertEquals(null, item);
	}
}
