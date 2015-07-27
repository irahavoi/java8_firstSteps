package com.rahavoi.refactoring;

/**
 * Using lambdas allows to write more readable and consise code 
 * that when using anonymous classes.
 * @author irahavoi
 *
 */
public class AnonymousClsVsLambdas {
	public static void main(String args[]){
		
		//Anonymous class:
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello");				
			}
		};
		
		//Lambda:
		Runnable r2 = () -> System.out.println("Hello");
		
	}
}
