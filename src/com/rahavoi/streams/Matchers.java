package com.rahavoi.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Matchers {
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
		
		//anyMatch example
		if(menu.stream().anyMatch(Dish::isVegetarian)){
			System.out.println("Menu is vegetarian-friendly!");
		}
		
		//all match (opposite of noneMatch)
		if(menu.stream().allMatch(d -> d.getCalories() < 1000)){
			System.out.println("All dishes are less than 1000 calories");
		}
		
		
		Optional<Dish> oDish = menu.stream().filter(Dish::isVegetarian).findFirst();
		
		if(oDish.isPresent()){
			System.out.println(oDish.get().getName() + " is the first vegetarian dish." );
		}
		
		
	}

}
