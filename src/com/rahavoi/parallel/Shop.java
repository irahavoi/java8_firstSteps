package com.rahavoi.parallel;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
	private String name;
	
	public Shop(String name){
		this.name = name;
	}
	public Future<Double> getPriceAsync(String product){
		return CompletableFuture.supplyAsync(() -> calculatePrice(product));
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
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
