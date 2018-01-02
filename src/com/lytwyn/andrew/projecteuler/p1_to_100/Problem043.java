package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;
import com.lytwyn.andrew.projecteuler.util.StopWatch;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Sub-string divisibility
 * Problem 43
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
 *
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 *
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 *
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem043
{
    public static void main(String[] args)
    {
        StopWatch watch = new StopWatch();

        watch.start();

        List<BigInteger> allPandigital = ProblemUtil.getAllPandigitalNumbers(false);

        List<BigInteger> validNumbers = new ArrayList<>();

        while(!allPandigital.isEmpty())
        {
            BigInteger i = allPandigital.remove(0);
            if(hasProperty(i)) validNumbers.add(i);
        }

        System.out.println(validNumbers);

        BigInteger sum = BigInteger.ZERO;

        for(BigInteger i : validNumbers)
        {
            sum = sum.add(i);
        }

        System.out.println(sum);
        watch.stop();

        watch.printExecutionTime();
    }

    private static boolean hasProperty(BigInteger i)
    {
        String test = i.toString();

        List<Integer> values = new ArrayList<>();

        for(int ind = 1; ind < test.length() - 2; ++ind)
        {
            String sub = test.substring(ind, ind+3);

            int value = Integer.valueOf(sub);

            values.add(value);
        }

        List<Integer> mods = new ArrayList<>();
        mods.add(2);
        mods.add(3);
        mods.add(5);
        mods.add(7);
        mods.add(11);
        mods.add(13);
        mods.add(17);


        for(int ind = 0; ind < values.size(); ++ind)
        {
            int mod = mods.get(ind);
            int value = values.get(ind);

            if(value % mod != 0)
            {
                return false;
            }
        }

        System.err.printf("Valid Number found: %s\n", i);
        return true;
    }
}
