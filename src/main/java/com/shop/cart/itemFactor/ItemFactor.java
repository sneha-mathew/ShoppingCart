package com.shop.cart.itemFactor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;
import com.shop.cart.item.*;

public class ItemFactor {
	private static final String IMPORTED = "imported";
	private static final String AT = " at ";
	private static final String SPACE = " ";
	static Map<String, Supplier<Item>> itemMapping = new HashMap<>();
	static void createHashMap(BigInteger quantity, String itemName, BigDecimal price )
	{
		itemMapping.put("chocolate", new Food(quantity,itemName,price));
		itemMapping.put("chocolates", new Food(quantity,itemName,price));
		itemMapping.put("book", new Book(quantity,itemName,price));
		itemMapping.put("pill", new Medicine(quantity,itemName,price));
		itemMapping.put("pills", new Medicine(quantity,itemName,price));
		itemMapping.put("medicine", new Medicine(quantity,itemName,price));
		itemMapping.put("perfume", new Other(quantity,itemName,price));
		itemMapping.put("others", new Other(quantity,itemName,price));
	}

	public static Item getItem(String itemLine) {
		try {
			String[] word = splitWords(itemLine);
			String[] item = itemLine.split(AT);
			createHashMap(new BigInteger(word[0]), item[0],new BigDecimal(item[1]));
			return List.of(word)
					.stream()
					.filter(s -> itemMapping.containsKey(StringUtils.lowerCase(s)))
					.map(s -> itemMapping.get(StringUtils.lowerCase(s))).findFirst()
					.orElse(itemMapping.get("other")).get()
					.isImported(checkIsImported(word));
		} catch (NumberFormatException | IndexOutOfBoundsException ex ) {
			System.out.println("Error for item "+ itemLine);
			return null;
		}

	}

	private static Boolean  checkIsImported(String[] word) {
		return List.of(word)
					.stream()
					.filter(s -> IMPORTED.equalsIgnoreCase(StringUtils.lowerCase(s)))
					.map(s -> true)
					.findFirst().orElse(false);
	}

	private static String[] splitWords(String str) {
		return str.replaceAll("\\p{Punct}", SPACE).split(SPACE);
	}
}