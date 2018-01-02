package com.lytwyn.andrew.projecteuler.p201_to_p300;

import com.lytwyn.andrew.projecteuler.util.StopWatch;

import java.math.BigInteger;

/**
 * Created by andrew on 12/29/2017.
 */
public class Problem206
{
    public static void main(String[] args)
    {
        StopWatch watch = new StopWatch();
        watch.start();
        BigInteger b = new BigInteger("1");

        while(!verify(b.pow(2)))
        {
            b = b.add(BigInteger.ONE);
        }

        System.out.println(b);
        watch.stop();
        watch.printExecutionTime();
    }

    private static boolean verify(BigInteger i)
    {
        String s = i.toString();
        if(s.length() != 19) return false;
        else return (s.charAt(0) == '1' &&
                s.charAt(2) == '2' &&
                s.charAt(4) == '3' &&
                s.charAt(6) == '4' &&
                s.charAt(8) == '5' &&
                s.charAt(10) == '6' &&
                s.charAt(12) == '7' &&
                s.charAt(14) == '8' &&
                s.charAt(16) == '9' &&
                s.charAt(18) == '0'
        );
    }
}
