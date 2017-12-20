package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.math.BigInteger;

/**
 * Created by andrew on 12/15/2017.
 */
public class Problem20
{
    public static void main(String[] args)
    {
        System.out.println(ProblemUtil.sumDigits(ProblemUtil.factorial(new BigInteger("100"))));
    }
}
