package com.rahavoi.behavior.param;

import java.util.ArrayList;
import java.util.List;

public class AppleService {
	public List<Apple> filter(List<Apple> apples, ApplePredicate ap){
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : apples){
			if(ap.test(apple)){
				result.add(apple);
			}
		}
		
		return result;
	}
	
	public void prettyPrintApple(List<Apple> apples, ApplePrinter printer){
		for(Apple a: apples){
			printer.print(a);
		}
	}

}
