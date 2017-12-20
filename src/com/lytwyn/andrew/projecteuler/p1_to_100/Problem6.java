package com.lytwyn.andrew.projecteuler.p1_to_100;

/**
 * Sum square difference
 * Problem 6
 *
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum/
 */
public class Problem6
{
    public static void main(String[] args)
    {
        double sumOfSquare = 0.0;

        for(double i = 1.0; i <= 100.0; ++i)
        {
            sumOfSquare += Math.pow(i, 2);
        }

        double sum = 0.0;

        for(int i = 1; i <= 100; ++i) sum += i;

        double squareOfSum = Math.pow(sum, 2);

        System.out.println((int)(squareOfSum - sumOfSquare));
    }
}
