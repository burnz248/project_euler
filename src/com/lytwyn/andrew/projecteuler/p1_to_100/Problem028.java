package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Number spiral diagonals
 * Problem 28
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * Thread Post: Wed, 20 Dec 2017, 13:07
 */
public class Problem028
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = Integer.valueOf(in.nextLine());


        Set<Integer> diagonalOne = new TreeSet<>();
        Set<Integer> diagonalTwo = new TreeSet<>();
        Set<Integer> diagonalThree = new TreeSet<>();
        Set<Integer> diagonalFour = new TreeSet<>();

        for (int i = 1, x = 0; i <= num; i += 2, ++x)
        {
            int squared = (int) Math.pow(i, 2);
            int fxTwo = squared - (6 * x);
            int fxThree = squared - (4 * x);
            int fxFour = squared - (2 * x);

            diagonalOne.add(squared);
            diagonalTwo.add(fxTwo);
            diagonalThree.add(fxThree);
            diagonalFour.add(fxFour);
        }

        Set<Integer> all = new TreeSet<>();

        all.addAll(diagonalOne);
        all.addAll(diagonalTwo);
        all.addAll(diagonalThree);
        all.addAll(diagonalFour);

        int sum = 0;
        for (int i : all)
        {
            sum += i;
            if (sum < 0) System.err.println("It overflowed, need a long");
        }

        System.out.println(sum);
    }
}
