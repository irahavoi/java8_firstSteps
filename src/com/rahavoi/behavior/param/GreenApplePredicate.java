package com.rahavoi.behavior.param;

public class GreenApplePredicate implements ApplePredicate{
	public boolean test(Apple a){
		return "green".equals(a.getColor());
	}
}
