package com.rahavoi.behavior.param;
import java.util.ArrayList;
import java.util.List;

/**
 * This example illustrates different solutions for solving "behavior parameterization" problem.
 * @author irahavoi
 *
 */
public class PredicateExample {
	public static void main(String[] args){
		AppleService aService = new AppleService();
		Apple a1 = new Apple("green", 124);
		Apple a2 = new Apple("red", 160);
		Apple a3 = new Apple("green", 84);
		Apple a4 = new Apple("green", 104);
		
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(a1);
		apples.add(a2);
		apples.add(a3);
		apples.add(a4);
		/**
		 * Strategy pattern: behavior is expressed through different ApplePrinter implementations.
		 */
		//List<Apple> filteredApples = aService.filter(apples, new GreenApplePredicate());
		
		/**
		 * The same filtering using a lambda:
		 */
		List<Apple> filteredApples = aService.filter(apples, (Apple apple) -> "green".equals(apple.getColor()));
		
		/**
		 * Sorting using a lambda:
		 */
		filteredApples.sort(
				(Apple first, Apple second) -> first.getWeight().compareTo(second.getWeight())
		);
		
		aService.prettyPrintApple(filteredApples, new AppleWeightColorPrinter());
		
		
		/**
		 * Anonymous class solution.
		 */
		aService.prettyPrintApple(filteredApples, new ApplePrinter() {
			
			@Override
			public void print(Apple a) {
				System.out.println("Anonymous printer: " + a.getColor());
				
			}
		});
	}
}
