package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

import java.math.BigInteger;
import java.util.List;

/**
 * Lexicographic permutations
 * Problem 24
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * <p>
 * 012   021   102   120   201   210
 * <p>
 * What is the millionth lexicographic permutation of the digits
 * 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * <p>
 * Thread Post: Fri, 15 Dec 2017, 13:15
 */
public class Problem024
{
    public static void main(String[] args)
    {
        List<BigInteger> permutations = ProblemUtil.getAllPandigitalNumbers(true);
        System.out.println(permutations.size());
    }
}
