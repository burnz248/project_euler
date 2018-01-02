package com.lytwyn.andrew.projecteuler.util;

import java.math.BigInteger;
import java.util.*;

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
        
        Set<Integer> numbers = new TreeSet<>();
        numbers.addAll(lower);
        numbers.addAll(upper);
        return Arrays.asList(numbers.toArray(new Integer[numbers.size()]));
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

    public static boolean isPrime(BigInteger i)
    {
        for(BigInteger b = new BigInteger("2"); b.compareTo(i) < 0; b = b.add(BigInteger.ONE))
        {
            if(i.mod(b).equals(BigInteger.ZERO)) return false;
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

    public static List<BigInteger> getAllPandigitalNumbers(boolean startWithZero)
    {
        List<BigInteger> permutations = new ArrayList<>();
        for (int a = 0; a <= 9; ++a)
        {
            List<Integer> possibleValues = new ArrayList<>();

            for (int i = 0; i <= 9; ++i)
            {
                possibleValues.add(i);
            }
            if(a == 0)
            {
                if (!startWithZero)
                {
                    a = 1;
                }
            }
            possibleValues.remove(a);

            for (int b = 0; b < possibleValues.size(); ++b)
            {
                int currentB = possibleValues.remove(b);

                for (int c = 0; c < possibleValues.size(); ++c)
                {
                    int currentC = possibleValues.remove(c);

                    for (int d = 0; d < possibleValues.size(); ++d)
                    {
                        int currentD = possibleValues.remove(d);
                        for (int e = 0; e < possibleValues.size(); ++e)
                        {
                            int currentE = possibleValues.remove(e);
                            for (int f = 0; f < possibleValues.size(); ++f)
                            {
                                int currentF = possibleValues.remove(f);
                                for (int g = 0; g < possibleValues.size(); ++g)
                                {
                                    int currentG = possibleValues.remove(g);
                                    for (int h = 0; h < possibleValues.size(); ++h)
                                    {
                                        int currentH = possibleValues.remove(h);
                                        for (int i = 0; i < possibleValues.size(); ++i)
                                        {
                                            int currentI = possibleValues.remove(i);
                                            for (int j = 0; j < possibleValues.size(); ++j)
                                            {
                                                int currentJ = possibleValues.remove(j);

                                                String out = String.format("%d%d%d%d%d%d%d%d%d%d", a
                                                        , currentB, currentC, currentD, currentE
                                                        , currentF, currentG, currentH, currentI
                                                        , currentJ);
                                                permutations.add(new BigInteger(out));

                                                possibleValues.add(j, currentJ);
                                            }
                                            possibleValues.add(i, currentI);
                                        }
                                        possibleValues.add(h, currentH);
                                    }
                                    possibleValues.add(g, currentG);
                                }
                                possibleValues.add(f, currentF);
                            }
                            possibleValues.add(e, currentE);
                        }
                        possibleValues.add(d, currentD);
                    }

                    possibleValues.add(c, currentC);
                }

                possibleValues.add(b, currentB);
            }
        }
        Collections.sort(permutations);
        return permutations;
    }

}