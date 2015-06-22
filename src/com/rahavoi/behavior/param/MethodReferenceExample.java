package com.rahavoi.behavior.param;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
	public static void main(String[] args){
		List<String> str = Arrays.asList("a","b","A","B");
		str.sort(String::compareToIgnoreCase);
		
		System.out.println(str);
	}

}
