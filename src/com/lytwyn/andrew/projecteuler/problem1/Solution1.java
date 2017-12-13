package com.lytwyn.andrew.projecteuler.problem1;

import java.util.Set;
import java.util.TreeSet;

/**
 * Multiples of 3 and 5
 * Problem 1
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Thread Post: Wed, 13 Dec 2017, 09:05
 */
public class Solution1
{
    public static void main(String[] args)
    {
        Set<Integer> threes = getMultiples(3, 1000);
        Set<Integer> fives = getMultiples(5, 1000);

        Set<Integer> merge = new TreeSet<>();
        merge.addAll(threes);
        merge.addAll(fives);

        int sum = 0;
        for(Integer i : merge)
        {
            sum += i;
        }

        System.out.println(sum);
    }

    private static Set<Integer> getMultiples(int number, final int LIMIT)
    {
        Set<Integer> result = new TreeSet<>();

        for(int i = number; i < LIMIT; i+=number)
        {
            result.add(i);
        }

        return result;
    }
}
