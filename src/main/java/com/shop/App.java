package com.shop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.shop.cart.itemFactor.ItemFactor;
public class App 
{
	public static void main( String[] args )
	{  
		try { 
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the number of orders");
			int size =  Integer.parseInt(reader.readLine());
			String[] stringArr= new String[size];
			
			System.out.println("Enter the orders");
			for(int i=0;i<size;i++)
				stringArr[i]=reader.readLine();
			
			getBill(stringArr);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void getBill(String[] stringArr) {
		List<BigDecimal> salesTax= new ArrayList();
		List<BigDecimal> total= new ArrayList();
		System.out.println("**** Output ****");
		List.of(stringArr).stream().map(s->ItemFactor.getItem(s))
		    .filter(item-> item!=null)
			.peek(item->salesTax.add(item.getTotalTax()))
			.peek(item->total.add(item.getTaxInclusivePrice()))
			.forEach(item->System.out.println(item.getName()+": "+item.getTaxInclusivePrice()));
		System.out.println("Sales Taxes: "+sumOfElements(salesTax));
		System.out.println("Total: "+ sumOfElements(total));
	}

	private static BigDecimal sumOfElements(List<BigDecimal> list) {
		return list.stream().reduce(new BigDecimal("0"), (a, b) -> a.add(b));
	}
}
