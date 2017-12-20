package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.io.File;
import java.util.*;

/**
 * Created by andrew on 12/15/2017.
 */
public class Problem022
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(new File("./data/input/problem_22.txt"));

        List<String> names = new ArrayList<>();

        while(in.hasNext())
        {
            names.addAll(Arrays.asList(in.nextLine().replaceAll("\"", "").split(",")));
            names.remove("");
        }
        Collections.sort(names);
        int sum = 0;

        for(int i = 0; i < names.size(); ++i)
        {
            String name = names.get(i);
            int nameScore = getNameScore(name);
            sum += ((i + 1) * nameScore);
        }

        System.out.println(sum);
    }

    private static int getNameScore(String name)
    {
        int score = 0;

        for(int i = 0; i < name.length(); ++i)
        {
            score += ((int) name.charAt(i)) - 64;
        }

        return score;
    }
}
