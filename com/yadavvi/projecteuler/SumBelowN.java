package com.yadavvi.projecteuler;

import java.util.Scanner;

public class SumBelowN {

	private final static int three = 3;
	private final static int five = 5;

	private double getSum(int N) {
		int firstMultiple = 3;
		int secondMultiple = 5;
		double sum = 0;

		// Consider N = 20

		while (firstMultiple < N || secondMultiple < N) {
			// If both the multiples are divisible by 3 & 5
			// only add one of the multiples but increment both multiples
			if (firstMultiple == secondMultiple) {
				// firstMultiple/secondMultiple are 15.
				sum += firstMultiple;
				firstMultiple += three;
				secondMultiple += five;

			} else if (firstMultiple < secondMultiple) {
				// when the firstMultiple is lesser than secondMultiple
				// add it to sum and increment it

				// This is when <firstMultiple, secondMultiple> is
				// <3, 5>, <6, 10>, <9, 10>, <12, 15>, <18, 20>
				sum += firstMultiple;
				firstMultiple += three;

			} else {
				// when the secondMultiple is lesser than firstMultiple
				// add it to sum and increment it

				// This is when <firstMultiple, secondMultiple> is
				// <5, 6>, <10, 12>
				sum += secondMultiple;
				secondMultiple += five;
			}
		}

		return sum;
	}

	/**
	 * Returns the sum of all the multiples of {@code value} smaller than
	 * {@code limit}.
	 */
	private double sumOfSequence(int value, int limit) {
		int count = (limit - 1) / value;
		return value * count * (count + 1) / 2;
	}

	private double getSumConstTime(int N) {
		// The numbers that are multiple of 3 and less than N are of type
		// <3, 6, 9, 12, 15, ....>.
		// Thus they can be written as <3*1, 3*2, 3*3, 3*4, 3*5, ....> and
		// all these numbers form a sequence 3*(1, 2, 3, 4, .....N/3).
		// The sum of this sequence can be given by n*(n+1)/2.

		// To find the sum of all the numbers divisible by 3 & 5, we take
		// the sum of the sequence of 3, 5 and Subtract the sum of multiples of
		// LCM of 3 and 5 i.e. 15.

		// The final result should be something like -
		return sumOfSequence(3, N) + sumOfSequence(5, N) - sumOfSequence(15, N);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();

		// print the sum of all the numbers below 'i'
		// which are divisible by both 3 and 5.
		SumBelowN sumBelowN = new SumBelowN();

		System.out.println("Sum: " + sumBelowN.getSum(i));
		System.out
				.println("Constant time Sum: " + sumBelowN.getSumConstTime(i));

		sc.close();
	}
}
