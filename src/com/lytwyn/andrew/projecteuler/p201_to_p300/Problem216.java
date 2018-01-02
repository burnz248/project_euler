package com.lytwyn.andrew.projecteuler.p201_to_p300;

import com.lytwyn.andrew.projecteuler.util.ProblemUtil;
import com.lytwyn.andrew.projecteuler.util.StopWatch;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andrew on 12/29/2017.
 */
public class Problem216
{
    public static void main(String[] args)
    {
        StopWatch watch = new StopWatch();
        watch.start();

        int count = 0;

        for(int i = 2; i < 50000000; ++i)
        {
            BigInteger result = getFunction(i);
            if(ProblemUtil.isPrime(result))
            {
                ++count;
            }

            if(i % 10000 == 0) System.out.println(i);
        }

        System.out.println(count);
        watch.stop();
        watch.printExecutionTime();
    }

    int makeArrayConsecutive2(int[] statues) {
        List<Integer> list = Arrays.asList((Integer[])statues);

        return 0;
    }


    private static BigInteger getFunction(int i)
    {

        BigInteger result = new BigInteger("" + i);
        result = result.pow(2);
        result = result.multiply(new BigInteger("2"));
        result = result.subtract(BigInteger.ONE);

        return result;
    }
}
