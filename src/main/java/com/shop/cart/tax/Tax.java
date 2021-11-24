package com.shop.cart.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.shop.cart.constants.CartConstants;

public interface Tax {

	BigDecimal generateTax(BigDecimal bigInteger);

	public static BigDecimal rounding(BigDecimal price) {
		return price.divide(CartConstants.ROUNDING_SCALE)
				    .setScale(0, RoundingMode.UP)
					.multiply(CartConstants.ROUNDING_SCALE);	
	}

}
