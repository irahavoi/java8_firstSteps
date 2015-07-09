package com.rahavoi.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rahavoi.streams.Dish;

/**
 * Illustrates some basic cases of using collectors.
 * @author irahavoi
 *
 */
public class CollectorsExamples {
	public static void main(String[] args){
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		
		long howManyDishes = menu.stream().collect(Collectors.counting());
		System.out.println("Total number of dishes: " + howManyDishes);
		
		//Finding the most and the least calory-rich dishes:
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> maxCaloryDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		Optional<Dish> minCaloryDish = menu.stream().collect(Collectors.minBy(dishCaloriesComparator));
		
		if(maxCaloryDish.isPresent()){
			System.out.println("Maximum calories dish: " + maxCaloryDish.get().getName());
		}
		
		if(minCaloryDish.isPresent()){
			System.out.println("Minimum calory dish: " + minCaloryDish.get().getName()	);
		}
		
		//Summarization:
		int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println("If you eat all the items on the menu, you'll get " + totalCalories + " calories.");
		
		//Average:
		double averageCalories = menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
		System.out.println("Average calories: " + averageCalories);
		
		
		//Statistics. Yay!
		IntSummaryStatistics menuStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
		
		
		
		String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
		System.out.println("Short menu: " + shortMenu);
		
		
		//Partitioning:
		Map<Boolean, List<Dish>> partitionedMenu =
				menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		
		System.out.println("Partitioned menu based on 'is vegetarian' criterion:");
		System.out.println(partitionedMenu);
		
		//Filtering:
		List<Dish> vegetarianDishes = 
				menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		
		System.out.println("Vegetarian dishes: " + vegetarianDishes);
		
		
	}
}
