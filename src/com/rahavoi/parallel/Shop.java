package com.rahavoi.parallel;

import java.util.Random;

public class Shop {
	public double getPrice(String product){
		return calculatePrice(product);
	}
	
	private double calculatePrice(String product){
		delay();
		return new Random().nextDouble() * product.charAt(0) * product.charAt(1);
	}
	
	public static void delay(){
		try{
			Thread.sleep(1000);
		} catch(InterruptedException e){
			throw new RuntimeException(e);
		}
	}
}
