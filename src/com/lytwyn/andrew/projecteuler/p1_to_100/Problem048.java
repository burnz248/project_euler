package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.math.BigInteger;

/**
 * Created by andrew on 12/15/2017.
 */
public class Problem048
{
    public static void main(String[] args)
    {
        BigInteger sum = BigInteger.ZERO;
        for(int i = 1; i <= 1000; ++i)
        {
            BigInteger power = (new BigInteger("" + i)).pow(i);
            sum = sum.add(power);
        }
        System.out.println(sum.toString().substring(sum.toString().length() - 10, sum.toString().length()));
    }
}
