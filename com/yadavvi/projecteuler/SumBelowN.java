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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();

		// print the sum of all the numbers below 'i'
		// which are divisible by both 3 and 5.
		SumBelowN sumBelowN = new SumBelowN();

		System.out.println("Sum: " + sumBelowN.getSum(i));
		sc.close();
	}
}
