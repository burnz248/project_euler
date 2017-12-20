package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.math.BigInteger;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;

/**
 * Created by andrew on 12/15/2017.
 */
public class Problem020
{
    public static void main(String[] args)
    {
        System.out.println(ProblemUtil.sumDigits(ProblemUtil.factorial(new BigInteger("100"))));
    }
}
