package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.math.BigInteger;

/**
 * Power digit sum
 * Problem 16
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * Thread Post: Wed, 13 Dec 2017, 09:40
 */
public class Problem16
{
    public static void main(String[] args)
    {
        String big = ProblemUtil.exponent(2, 1000);
        BigInteger sum = BigInteger.ZERO;

        for(int i = 0; i < big.length(); ++i)
        {
            sum = sum.add(new BigInteger("" + big.charAt(i)));
        }

        System.out.println(sum);

    }
}
