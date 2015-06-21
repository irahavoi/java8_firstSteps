package com.rahavoi.behavior.param;

public class AppleWeightColorPrinter implements ApplePrinter{
	public void print(Apple a){
		System.out.println("Weight: " + a.getWeight() + " Color: " + a.getColor());
	}
}
