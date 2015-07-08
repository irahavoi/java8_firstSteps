package com.rahavoi.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
		
		//Finding the most calory-rich dish:
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		
		Optional<Dish> maxCaloryDish = menu.stream().collect(Collectors.maxBy(dishCaloriesComparator));
		
		if(maxCaloryDish.isPresent()){
			System.out.println("Maximum calories dish: " + maxCaloryDish.get().getName());
		}
		
	}
}
