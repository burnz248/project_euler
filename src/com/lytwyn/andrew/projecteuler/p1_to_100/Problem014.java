package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.util.List;
import java.util.ArrayList;

/**
 * Longest Collatz sequence
 * Problem 14
 * The following iterative sequence is defined for the set of positive
 * integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem014
{
    public static void main(String[] args)
    {
        int maxIndex = 0;
        int maxSize = 0;

        for (int i = 2; i < 1000000; ++i)
        {
            int size = getChainSize(i);

            if (size > maxSize)
            {
                maxIndex = i;
                maxSize = size;
            }
        }

        System.out.println(maxIndex);
    }

    private static int getChainSize(int num)
    {
//        List<Integer> chain = new ArrayList<>();

//        chain.add(num);

        int size = 1;

        long currentNum = 0;

        while (currentNum != 1)
        {
            if (currentNum != 0)
            {
                currentNum = (currentNum % 2 == 0) ? currentNum / 2 : (3 * currentNum) + 1;
            } else
            {
                currentNum = (num % 2 == 0) ? num / 2 : (3 * num) + 1;
            }
            ++size;
            if (num == 113383) // this is a big one
            {
                System.err.printf("\t\t%d: %d\n", size, currentNum);
                if (currentNum < 0) System.exit(0);
            }
        }
        System.out.println(num + ": " + size);
        return size;
    }
}
