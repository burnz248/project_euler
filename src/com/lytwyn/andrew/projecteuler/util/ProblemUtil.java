package com.lytwyn.andrew.projecteuler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 12/4/2017.
 */
public class ProblemUtil
{
    public static String exponent(int base, int exponent)
    {
        return (new BigInteger(""+base)).pow(exponent).toString();
    }

    public static List<Integer> getDivisors(int num)
    {
        List<Integer> lower = new ArrayList<>();
        List<Integer> upper = new ArrayList<>();

        lower.add(1);
        upper.add(0, num);

        for(int i = 2; i <= Math.sqrt(num); ++i)
        {
            if(num % i == 0 && i < upper.get(0))
            {
                lower.add(i);
                upper.add(0, (num/i));
            }
        }
        boolean b = lower.addAll(upper);
        return lower;
    }

    public static List<Long> getDivisors(long num)
    {
        List<Long> lower = new ArrayList<>();
        List<Long> upper = new ArrayList<>();

        lower.add(1L);
        upper.add(0, num);

        for(long i = 2; i <= Math.sqrt(num); ++i)
        {
            if(num % i == 0 && i < upper.get(0))
            {
                lower.add((long)i);
                upper.add(0, (num/i));
            }
        }
        boolean b = lower.addAll(upper);
        return lower;
    }

    public static boolean[] sieveOfEratosthenes(int number)
    {
        // so that we can get set[number],
        // because of the array index starting at 0, not 1
        boolean[] set = new boolean[number + 1];

        for (int i = 0; i < set.length; i++)
        {
            set[i] = true;
        }

        for (int i = 2; i < set.length; i++)
        {
            if(set[i])
            {
                for(int j = i+i; j < set.length; j += i)
                {
                    set[j] = false;
                }
            }
        }

        return set;
    }

    public static boolean isPrime(int n)
    {
        for(int i = 2; i <= Math.sqrt(n); ++i)
        {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime(long l)
    {
        for(long i = 2; i < Math.sqrt(l); ++i)
        {
            if(l % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(String s)
    {
        StringBuilder s_2 = (new StringBuilder(s)).reverse();
        return s_2.toString().equals(s);
    }

    public static boolean isEvenlyDivisible(int number, int low, int high)
    {
        for(int i = low; i <= high; ++i)
        {
            if(number % i != 0) return false;
        }
        return true;
    }

    public static boolean isPythagoreanTriple(int a, int b, int c)
    {
        return ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2));
    }

    public static BigInteger factorial(BigInteger n)
    {
        if(n.equals(BigInteger.ONE)) return BigInteger.ONE;
        else return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    public static BigInteger sumDigits(BigInteger n)
    {
        BigInteger result = BigInteger.ZERO;
        String num = n.toString();

        for(int i = 0; i < num.length(); ++i)
        {
            result = result.add(new BigInteger("" + num.charAt(i)));
        }

        return result;
    }

}