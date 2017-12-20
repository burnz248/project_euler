package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.util.List;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

/**
 * Largest prime factor
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem003
{
    public static void main(String[] args)
    {
        long l = 600851475143L;
        List<Long> divisors = ProblemUtil.getDivisors(l);

        long max = 0L;
        for(Long l1 : divisors)
        {
            if(ProblemUtil.isPrime(l1))
            {
                if(l1 > max) max = l1;
            }
        }
        System.out.println(max);
    }
}
