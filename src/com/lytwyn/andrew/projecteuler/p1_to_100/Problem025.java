package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.math.BigInteger;

/**
 * 1000-digit Fibonacci number
 * Problem 25
 * The Fibonacci sequence is defined by the recurrence relation:
 * <p>
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * <p>
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * <p>
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 * <p>
 * Thread Post: Fri, 15 Dec 2017, 12:45
 */
public class Problem025
{
    public static void main(String[] args)
    {
        BigInteger termOne = BigInteger.ONE;
        BigInteger termTwo = new BigInteger("2");

        int term = 3;

        BigInteger current = termOne.add(termTwo);

        while (current.toString().length() != 1000)
        {
            current = termOne.add(termTwo);
            termOne = termTwo;
            termTwo = current;
            ++term;
        }

        System.out.println(current);
        System.out.println(term);

    }
}
