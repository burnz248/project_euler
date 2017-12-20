package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lexicographic permutations
 * Problem 24
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits
 * 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * Thread Post: Fri, 15 Dec 2017, 13:15
 */
public class Problem024
{
    public static void main(String[] args)
    {
        List<BigInteger> permutations = new ArrayList<>();
        for(int a = 0; a <= 9; ++a)
        {
            List<Integer> possibleValues = new ArrayList<>();

            for(int i = 0; i <= 9; ++i) possibleValues.add(i);
            possibleValues.remove(a);

            for(int b = 0; b < possibleValues.size(); ++b)
            {
                int currentB = possibleValues.remove(b);

                for(int c = 0; c < possibleValues.size(); ++c)
                {
                    int currentC = possibleValues.remove(c);

                    for(int d = 0; d < possibleValues.size(); ++d)
                    {
                        int currentD = possibleValues.remove(d);
                        for(int e = 0; e < possibleValues.size(); ++e)
                        {
                            int currentE = possibleValues.remove(e);
                            for(int f = 0; f < possibleValues.size(); ++f)
                            {
                                int currentF = possibleValues.remove(f);
                                for(int g = 0; g < possibleValues.size(); ++g)
                                {
                                    int currentG = possibleValues.remove(g);
                                    for(int h = 0; h < possibleValues.size(); ++h)
                                    {
                                        int currentH = possibleValues.remove(h);
                                        for(int i = 0; i < possibleValues.size(); ++i)
                                        {
                                            int currentI = possibleValues.remove(i);
                                            for(int j = 0; j < possibleValues.size(); ++j)
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
        System.out.println(permutations.get(999999));
    }
}
