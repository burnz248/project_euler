package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

/**
 * Created by andrew on 12/15/2017.
 */
public class Problem027
{
    public static void main(String[] args)
    {
        int maxPrimes = 0;
        int maxA = 0;
        int maxB = 0;

        for(int a = -999; a < 1000; ++a)
        {
            for(int b = -1000; b <= 1000; ++b)
            {
                int primes = getConsecutivePrimes(a,b);
                if(primes > maxPrimes)
                {
                    maxA = a;
                    maxB = b;
                    maxPrimes = primes;
                }
            }

        }
        System.out.printf("n^2 + %dn + %d produces length of %d\nProduct is: %d", maxA, maxB, maxPrimes, (maxA * maxB));
    }

    private static int getConsecutivePrimes(int a, int b)
    {
        int num = 0;

        for(int n = 0; ProblemUtil.isPrime(Math.abs(evaluate(n, a, b))); ++n, ++num)
        {}

        return num;
    }

    private static int evaluate(int n, int a, int b)
    {
        return (int) (Math.pow(n, 2) + (a * n) + b);
    }
}
