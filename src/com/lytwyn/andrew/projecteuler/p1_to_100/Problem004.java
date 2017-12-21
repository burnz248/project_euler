package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

/**
 * Largest palindrome product
 * Problem 4
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem004
{
    public static void main(String[] args)
    {
        int largestPalindrome = 0;
        for (int n_1 = 100; n_1 <= 999; ++n_1)
        {
            for (int n_2 = 100; n_2 <= 999; ++n_2)
            {
                int product = n_1 * n_2;
                if (ProblemUtil.isPalindrome("" + product))
                {
                    if (product > largestPalindrome) largestPalindrome = product;
                }
            }
        }
        System.out.println(largestPalindrome);
    }
}
