package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

/**
 * Created by andrew on 11/30/2017.
 */
public class Problem010
{

    public static void main(String[] args)
    {
        final int MAX = 2000000;

        long sum = 0;

        boolean[] set = ProblemUtil.sieveOfEratosthenes(MAX);

        for (int i = 2; i < set.length; ++i)
        {
            if (set[i]) sum += i;
        }
        System.out.println(sum);
    }
}
