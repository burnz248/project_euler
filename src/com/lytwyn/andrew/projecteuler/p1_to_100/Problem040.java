package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.util.StopWatch;

/**
 * Champernowne's constant
 * Problem 40
 * An irrational decimal fraction is created by concatenating the positive integers:
 *
 * 0.123456789101112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 *
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000 */
public class Problem040
{
    public static void main(String[] args)
    {
        StopWatch watch = new StopWatch();
        watch.start();

        StringBuilder number = new StringBuilder();

        int i = 1;
        while(number.length() <= 999999)
        {
            number.append(i);
            ++i;
        }

        int d1 = Integer.valueOf("" + number.charAt(0));
        int d10 = Integer.valueOf("" + number.charAt(9));
        int d100 = Integer.valueOf("" + number.charAt(99));
        int d1000 = Integer.valueOf("" + number.charAt(999));
        int d10000 = Integer.valueOf("" + number.charAt(9999));
        int d100000 = Integer.valueOf("" + number.charAt(99999));
        int d1000000 = Integer.valueOf("" + number.charAt(999999));

        System.out.println(d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000);
        watch.stop();
        watch.printExecutionTime();
    }
}
