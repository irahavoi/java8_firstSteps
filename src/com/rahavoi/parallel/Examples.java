package com.rahavoi.parallel;

import java.util.function.Function;

/**
 * Examples of working with parallel streams.
 * 
 * @author irahavoi
 *
 */
public class Examples {
	public static void main(String[] args) {
		System.out.println("Sequential sum done in: " +
				measureSumPerf(ParallelStream::sequentialSum, 10_000_000) + " msecs");
	}

	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			System.out.println("Result: " + sum);
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

}
