package com.shop.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import com.shop.cart.tax.Tax;
import com.shop.cart.tax.GoodsTax;

class GoodsTaxTest {

	@Test
	void generateTax_shouldReturn1_whenPrice20Rate5() {
		Tax taxCompute= new GoodsTax(new BigDecimal("5"));
		BigDecimal actual=taxCompute.generateTax(new BigDecimal("20.00"));
		assertEquals(new BigDecimal("1.00"), actual);
	}
	@Test
	void generateTax_shouldReturn2_whenPrice20Rate10() {
		Tax taxCompute= new GoodsTax(new BigDecimal("10"));
		BigDecimal actual=taxCompute.generateTax(new BigDecimal("20.00"));
		assertEquals(new BigDecimal("2.00"), actual);
	}
	@Test
	void shouldReturn2_whenPrice49Rate5() {
		Tax taxCompute= new GoodsTax(new BigDecimal("5"));
		BigDecimal actual=taxCompute.generateTax(new BigDecimal("49.5"));
		assertEquals(new BigDecimal("2.475"), actual);
	}
	@Test
	void shouldReturn2_whenPrice41Rate10() {
		Tax taxCompute= new GoodsTax(new BigDecimal("10"));
		BigDecimal actual=taxCompute.generateTax(new BigDecimal("41.143"));
		assertEquals(new BigDecimal("4.1143"), actual);
	}
	
	@Test
	void rounding_shouldReturnUp_whenBelow0_05() {
		BigDecimal actual=Tax.rounding(new BigDecimal("4.1143"));
		assertEquals(new BigDecimal("4.15"), actual);
	}

	@Test
	void rounding_shouldReturnUp_whenAbove0_05() {
		BigDecimal actual=Tax.rounding(new BigDecimal("4.1563"));
		assertEquals(new BigDecimal("4.20"), actual);
	}
	@Test
	void rounding_shouldReturnUp_whenSame0_05() {
		BigDecimal actual=Tax.rounding(new BigDecimal("4.1502"));
		assertEquals(new BigDecimal("4.20"), actual);
	}
	@Test
	void rounding_shouldReturnSame_whenSame0_05() {
		BigDecimal actual=Tax.rounding(new BigDecimal("4.15"));
		assertEquals(new BigDecimal("4.15"), actual);
	}
}
