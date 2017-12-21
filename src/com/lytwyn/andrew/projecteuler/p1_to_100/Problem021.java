package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

/**
 * Amicable numbers
 * Problem 21
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair
 * and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class Problem021
{

    public static void main(String[] args)
    {
        final Map<Integer, Integer> numSumDivisors = new HashMap<>();

        for (int i = 2; i < 10000; ++i)
        {
            List<Integer> divisors = ProblemUtil.getDivisors(i);
            int sum = 0;

            for (int num : divisors)
            {
                sum += num;
            }

            sum -= i;
            if (i == 220 || i == 284 || i == 4)
            {
                System.out.println(divisors);
            }
            numSumDivisors.put(i, sum);
        }

        System.out.println(numSumDivisors);


        final Set<Integer> amicableNumbers = new TreeSet<>();

        numSumDivisors.forEach((key, value) ->
                               {
                                   int a = key;
                                   int b = value;
                                   if (numSumDivisors.containsKey(b))
                                   {
                                       int valueValue = numSumDivisors.get(b);
                                       if (valueValue == a)
                                       {
                                           if (a != b)
                                           {
                                               amicableNumbers.add(a);
                                               amicableNumbers.add(b);
                                           }
                                       }
                                   }
                               });

        System.out.println(amicableNumbers);

        int finalSum = 0;
        for (int i : amicableNumbers)
        {
            finalSum += i;
        }

        System.out.println(finalSum);


    }

}
