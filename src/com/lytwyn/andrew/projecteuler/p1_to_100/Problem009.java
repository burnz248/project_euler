package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

/**
 * Special Pythagorean triplet
 * Problem 9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * <p>
 * Thread Post: Fri, 15 Dec 2017, 11:25
 */
public class Problem009
{
    public static void main(String[] args)
    {
        int a = 0;
        int b = 0;
        int c = 0;

        for (a = 1; a <= 1000; ++a)
        {
            for (b = 1; b <= 1000; ++b)
            {
                for (c = 1; c <= 1000; ++c)
                {
                    if ((a + b + c) == 1000)
                    {
                        if (ProblemUtil.isPythagoreanTriple(a, b, c))
                        {
                            System.out.println((a * b * c));
                            System.err.printf("a: %d\nb: %d\nc: %d\n", a, b, c);
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
}
