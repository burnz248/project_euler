package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.util.ArrayList;
import java.util.List;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

/**
 * 10001st prime
 * Problem 7
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */
public class Problem007
{
    public static void main(String[] args)
    {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int number = 3;
        while(primes.size() != 10001)
        {
            if(ProblemUtil.isPrime(number)) primes.add(number);
            ++number;
        }

        System.out.println(primes.get(primes.size() - 1));
    }
}
