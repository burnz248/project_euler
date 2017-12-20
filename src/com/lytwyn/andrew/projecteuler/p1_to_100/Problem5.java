package com.lytwyn.andrew.projecteuler.p1_to_100;/* Smallest multiple
 * Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class Problem5
{
    public static void main(String[] args)
    {
        int num = 1;

        while(!ProblemUtil.isEvenlyDivisible(num, 1, 20))
        { ++num; }

        System.out.println(num);
    }
}
