package com.lytwyn.andrew.projecteuler.p1_to_100;

import java.util.Calendar;
import java.util.Date;

public class Problem019
{
    public static void main(String[] args)
    {
        Calendar c = Calendar.getInstance();
        int count = 0;

        for(int year = 1901; year <= 2000; ++year)
        {
            for(int month = 1; month <= 12; ++month)
            {
                String dateFormat = String.format("%d/1/%d", month, year);

                c.setTime(new Date(dateFormat));
                if(c.get(Calendar.DAY_OF_WEEK) == 1) ++count;
            }
        }

        System.out.println(count);
    }
}
