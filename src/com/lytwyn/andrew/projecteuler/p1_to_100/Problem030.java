package com.lytwyn.andrew.projecteuler.p1_to_100;

/**
 * Created by andrew on 12/15/2017.
 */
public class Problem030
{
    public static void main(String[] args)
    {
        int sum = 0;
        for (int i = 2; i < 10000000; ++i)
        {
            String current = Integer.toString(i);
            int currentSum = 0;

            for (int j = 0; j < current.length(); ++j)
            {
                currentSum += (int) Math.pow(Integer.valueOf("" + current.charAt(j)), 5);
            }
            if (currentSum == i)
            {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
