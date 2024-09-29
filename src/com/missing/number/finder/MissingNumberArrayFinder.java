package com.missing.number.finder;

import java.util.Arrays;

public class MissingNumberArrayFinder {
	public static void main(String[] args) {
		int[] numbers = new int[99];
		int missingNumber = 45;
		
		int index = 0;
		for(int i=1; i <= 100; i++) {
			if(i != missingNumber) {
				numbers[index++] = i;
			}
		} 
		
		int missing = findMissingNumber(numbers, 100);
		System.out.println(missing); 
		
		numbers = new int[] {1, 1, 2, 2, 3, 4, 5};
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(removeDuplicates(numbers)));
		
		System.out.println(getFindByNumber(numbers, 2));
		
		largestAndSmallest(numbers);
		
		
		 
	}

	private static void largestAndSmallest(int[] numbers) {
		int largeNumber = Integer.MIN_VALUE;
		int smallNumber = Integer.MAX_VALUE;
		for (int num : numbers) {
			if(num > largeNumber) {
				largeNumber = num;
			} else if(num < smallNumber) {
				smallNumber = num;
			}
		}
		
		System.out.println("Small :" + smallNumber + "Large :" + largeNumber );
	}

	private static boolean getFindByNumber(int[] numbers, int i) {
		boolean result = false;
		
		for(int num : numbers) {
			if(num == i) {
				return true;
			}
		}
		return result;
	}

	private static int[] removeDuplicates(int[] numbers) {
		int[] result = new int[numbers.length];
		int previous = numbers[0];
		result[0] = previous;
		for(int i = 1; i < numbers.length; i++) {
			int ch = numbers[i];
			if(previous != ch) {
				result[i] = ch;
			}
			previous = ch;
		}
		
		return result;
	}

	private static int findMissingNumber(int[] numbers, int n) {
		int expectNumber = n * (n+1)/2;
		int actualSum = 0;
		for(int num: numbers) {
			actualSum += num; 
		}
		return expectNumber - actualSum;
	}
}
