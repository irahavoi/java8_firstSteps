package com.rahavoi.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransRunner {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian,2011, 300), 
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), 
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
		
		//Find all transactions in the year 2011 and sort them by value (small to high).
		transactions.stream()
			.filter(tx -> tx.getYear() == 2011)
			.sorted((tx1, tx2) -> tx1.getValue() - tx2.getValue())
			.collect(Collectors.toList())
			.forEach(tx -> System.out.println(tx));
		
		System.out.println("Unique cities:");
		//Unique cites where traders work:
		traders.stream().map(t -> 
			t.getCity())
			.distinct()
			.forEach(city -> System.out.println(city));
		
		
		//Find All traders from Cambridge and sort them by name:
		System.out.println("Traders from cambridge sorted by name:");
		traders.stream()
			.filter(t -> "Cambridge".equalsIgnoreCase(t.getCity()))
			.sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
			.forEach(t -> System.out.println(t.getName()));
		
	}
	
}
