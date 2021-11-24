package com.shop.cart.item;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.shop.cart.constants.CartConstants;
import com.shop.cart.tax.GoodsTax;
import com.shop.cart.tax.Tax;

public class Medicine extends Item {

	public Medicine(BigInteger quantity, String name, BigDecimal price) {
		super(quantity, name, price);
	}

	private  Tax serviceTax ;
	{
		serviceTax = new GoodsTax(CartConstants.NECESSITY_TAX_RATE);
	}

	@Override
	public BigDecimal getServiceTax() {
		return serviceTax.generateTax(getPrice());
	}

}
