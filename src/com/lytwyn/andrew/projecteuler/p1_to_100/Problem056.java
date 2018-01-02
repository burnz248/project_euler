package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;
import com.lytwyn.andrew.projecteuler.util.StopWatch;

import java.math.BigInteger;

/**
 * Created by andrew on 12/28/2017.
 */
public class Problem056
{
    public static void main(String[] args)
    {
        StopWatch watch = new StopWatch();
        watch.start();
        BigInteger max = BigInteger.ZERO;
        for(int a = 1; a < 100; ++a)
        {
            for(int b = 1; b < 100; ++b)
            {
                BigInteger bigA = new BigInteger("" + a);

                BigInteger pow = bigA.pow(b);

                BigInteger sum = ProblemUtil.sumDigits(pow);

                if(sum.compareTo(max) > 0) max = sum;
            }
        }
        System.out.println(max);
        watch.stop();
        watch.printExecutionTime();
    }
}
