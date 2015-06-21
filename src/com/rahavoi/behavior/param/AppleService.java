package com.rahavoi.behavior.param;

import java.util.List;

public class AppleService {
	public void prettyPrintApple(List<Apple> apples, ApplePrinter printer){
		for(Apple a: apples){
			printer.print(a);
		}
	}

}
