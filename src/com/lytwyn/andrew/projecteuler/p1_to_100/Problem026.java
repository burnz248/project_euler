package com.lytwyn.andrew.projecteuler.p1_to_100;

public class Problem026
{
    public static void main(String[] args)
    {
        int sequenceLength = 0;

        for (int i = 1000; i > 1; i--)
        {
            if (sequenceLength >= i)
            {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0)
            {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength)
            {
                sequenceLength = position - foundRemainders[value];
            }
        }

        System.out.println(sequenceLength);
    }
}
