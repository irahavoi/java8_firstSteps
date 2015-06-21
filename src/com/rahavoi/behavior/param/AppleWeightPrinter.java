package com.rahavoi.behavior.param;

public class AppleWeightPrinter implements ApplePrinter{
	public void print(Apple a){
		System.out.println("Weight: " + a.getWeight());
	}
}
