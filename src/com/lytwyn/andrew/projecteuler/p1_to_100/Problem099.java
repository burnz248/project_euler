package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by andrew on 12/5/2017.
 */
public class Problem099
{
    public static void main(String[] args) throws Exception
    {
//        BigInteger test = new BigInteger("632382");
//        BigInteger testPow = test.pow(518061);
//        BigInteger test2 = new BigInteger("519432");
//        BigInteger test2Pow = test2.pow(525806);
//
//        System.out.println(testPow.compareTo(test2Pow));

        long start = System.currentTimeMillis();

        Scanner input = new Scanner(new File("./data/input/problem_99.txt"));

        BigInteger max = new BigInteger("0");
        int lineNumber = 1;

        int maxLineNumber = 0;

        while(input.hasNext())
        {
            String[] info = input.nextLine().split(",");

            int exponent = Integer.valueOf(info[1]);

            BigInteger current = (new BigInteger(info[0])).pow(exponent);

            if(current.compareTo(max) > 0)
            {
                max = current;
                maxLineNumber = lineNumber;
            }

            ++lineNumber;
        }

        System.out.println(maxLineNumber);
        System.out.println(System.currentTimeMillis() - start);

    }
}
