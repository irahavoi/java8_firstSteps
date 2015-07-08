package com.rahavoi.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamExamples {
	public static void main(String[] args){
		Stream.of("Java 8", "in", "action")
			.map(String::toUpperCase)
			.forEach(System.out::println);
		
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		
		int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);
		
		//File stream:
		try {
			Stream<String> lines = Files.lines(Paths.get("C:\\work\\java8_firstSteps\\src\\words.txt"), Charset.defaultCharset());
			long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
					.distinct()
					.count();
			
			System.out.println("Unique words: " + uniqueWords);
			lines.close();
		} catch(IOException ioe){
			ioe.printStackTrace();
		}
		
		
		System.out.println("Look, ma: infinite stream:");
		Stream.iterate(0, n -> n +2)
			.limit(10)
			.forEach(System.out::println);
		
		//Iterate applies successively a function on each new produced number:
		System.out.println("Fibbonacci:");
		Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0] + t[1]})
			.limit(20)
			.forEach(t -> System.out.println(t[1]));
		
		System.out.println("Random numbers:");
		//Generate takes a lambda of type supplier to provide new values:
		//(SUPPLIER DOES NOT HAVE TO BE STATELESS. but stateful suppliers are not safe in parallel code)
		Stream.generate(Math::random)
			.limit(5)
			.forEach(System.out::println);
		
	}
}
