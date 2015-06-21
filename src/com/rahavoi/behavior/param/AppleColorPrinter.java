package com.rahavoi.behavior.param;

public class AppleColorPrinter implements ApplePrinter{
	public void print(Apple a){
		System.out.println("Color: " + a.getColor());
	}
}
