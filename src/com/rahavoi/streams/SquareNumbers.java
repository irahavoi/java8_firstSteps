package com.rahavoi.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SquareNumbers {
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4, 5};
		
		Arrays.stream(nums).map(i -> i*i).forEach(n -> System.out.println(n + ", "));
		
	}
}
