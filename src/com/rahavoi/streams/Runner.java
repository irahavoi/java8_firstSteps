package com.rahavoi.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {
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
		
		
		System.out.println("Getting 3 dishes with more than 400 calories. Ascending order:");
		
		menu.stream()
			.filter(d -> {
				System.out.println("Analyzing a dish with " + d.getCalories() + " calories..");
				return d.getCalories() > 400;
			})
			.sorted((d1, d2) -> d1.getCalories() - d2.getCalories())
			.skip(2)
			.limit(3)
			.map(Dish::getCalories)
			.collect(Collectors.toList())
			.forEach(calories -> System.out.println(calories));
		
		//Finding the sum of all callories 0 is the starting number to be used in the lambda:
		int total = menu.stream().map(d -> d.getCalories()).reduce(0, (a, b) -> a + b);
		System.out.println("The sum of calories in all dishes is: " + total);
		
		
		//Calculating maximum:
		Optional<Integer> maxCal = menu.stream().map(d -> d.getCalories()).reduce(Integer::max);
		System.out.println("Maximum calories: " + maxCal.get());
		//Calculating minimum:
		Optional<Integer> minCal = menu.stream().map(d -> d.getCalories()).reduce(Integer::min);
		System.out.println("Minimum calories: " + minCal.get());
		
		
		
		
	}
}
