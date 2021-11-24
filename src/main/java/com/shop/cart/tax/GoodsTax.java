package com.shop.cart.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.shop.cart.constants.CartConstants;

public class GoodsTax implements Tax{
	
	private BigDecimal rate;
	

	public GoodsTax(BigDecimal rate) {
		this.rate=rate;
	}
	
	@Override
	public BigDecimal generateTax(BigDecimal price) {
		return price.multiply(rate).divide(CartConstants.PERCENT);
	}

}
