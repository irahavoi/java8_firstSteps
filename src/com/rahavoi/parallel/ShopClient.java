package com.rahavoi.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ShopClient {
	public static List<Shop> shops = Arrays.asList(new Shop("Best Shop"),
			new Shop("ShopMart"),
			new Shop("SuperShop"),
			new Shop("CanadianShop"));
	
	public static void main(String [] args){
		
		long start = System.nanoTime();
		
		System.out.println(findPrices("myPhone332s"));
		
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		
		System.out.println("Invocation returned after " + invocationTime + "msecs");
	}
	
	public static List<String> findPrices(String product){
		return shops.stream()
				.map(shop -> String.format("%s format is %.2f", shop.getName(), shop.getPrice(product)))
				.collect(Collectors.toList());
	}
}
