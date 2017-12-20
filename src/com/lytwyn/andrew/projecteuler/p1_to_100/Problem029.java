package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

/**
 * Thread Post: Wed, 20 Dec 2017, 13:28
 */

public class Problem029 {
	public static void main(String[] args) {
		Set<BigInteger> numbers = new TreeSet<>();
		
		for(int a = 2; a <= 100; ++a)
		{
			for(int b = 2; b <= 100; ++b)
			{
				numbers.add((new BigInteger("" + a)).pow(b));
			}
		}
		
		System.out.println(numbers.size());
	}
}
