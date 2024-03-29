package com.shop.cart.item;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Supplier;

import com.shop.cart.constants.CartConstants;
import com.shop.cart.tax.GoodsTax;
import com.shop.cart.tax.Tax;

public abstract class Item implements Supplier {
    

	private boolean imported;
	private BigInteger quantity;
	private String name;
	private BigDecimal price;
	private  Tax importedTax ;
	public Item(BigInteger quantity, String name, BigDecimal price) {
		super();
		this.quantity = quantity;
		this.name = name;
		this.price = price;
	}	
	{
		importedTax = new GoodsTax(CartConstants.IMPORT_TAX_RATE);
	}
	
	public String getName() {
		return name;
	}
	
	public BigInteger getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}
		
	public final Item isImported(boolean imported) {
		this.imported= imported;
		return this;
	}
	
	public BigDecimal getImportTax() {
		return importedTax.generateTax(getPrice().multiply(new BigDecimal(quantity)));
	}
	
	public final BigDecimal getTotalTax() {
		BigDecimal salesTaxQuantity = getSalesTax().multiply(new BigDecimal(quantity));
      	if(imported)	
		   return Tax.rounding(salesTaxQuantity.add(getImportTax()));
		else 
			return Tax.rounding(salesTaxQuantity);
	}
	
	public final BigDecimal getTaxInclusivePrice() {
		return price.multiply(new BigDecimal(quantity)).add(getTotalTax());
	}
	
	public abstract BigDecimal getSalesTax();

	@Override
	public Item get() {
		return this;
	}
}
