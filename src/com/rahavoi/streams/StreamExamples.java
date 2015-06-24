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
		
		
		try {
			Stream<String> lines = Files.lines(Paths.get("C:\\work\\java8_firstSteps\\src\\words.txt"), Charset.defaultCharset());
			long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
					.distinct()
					.count();
			
			System.out.println("Unique words: " + uniqueWords);
			lines.close();
		} catch(IOException ioe){
			ioe.printStackTrace();
		} finally{
		}
	}
}
