package com.rahavoi.behavior.param;

public class HeavyApplePredicate implements ApplePredicate{
	public boolean test(Apple a){
		return new Integer(150).compareTo(a.getWeight()) <= 0;
	}
}
