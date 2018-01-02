package com.lytwyn.andrew.projecteuler.util;

/**
 * Created by andrew on 12/28/2017.
 */
public class StopWatch
{
    private long startTime;
    private long endTime;

    private static final long SECOND = 1000L;
    private static final long MINUTE = 60 * SECOND;
    private static final long HOUR = 60 * MINUTE;


    public void start()
    {
        this.startTime = System.currentTimeMillis();
    }

    public void stop()
    {
        this.endTime = System.currentTimeMillis();
    }

    public void printExecutionTime()
    {
        long time = endTime - startTime;
        if(time < SECOND)
        {
            System.out.printf("Execution time: %d ms\n", time);
        } else if (time < MINUTE && time > SECOND)
        {
            long seconds = time / SECOND;
            long ms = time % SECOND;
            System.out.printf("Execution time: %d s %d ms\n", seconds, ms);
        } else if(time < HOUR && time > MINUTE)
        {
            long minutes = time / MINUTE;
            long seconds = (time - (minutes * MINUTE)) / SECOND;
            long ms = (time - (minutes * MINUTE)) % SECOND;

            System.out.printf("Execution time: %d m %d s %d ms\n"
                    , minutes
                    , seconds
                    , ms);
        } else
        {
            long hours = time / HOUR;
            long minutes = (time - (hours * HOUR)) / MINUTE;
            long seconds = (time - (minutes * MINUTE)) / SECOND;
            long ms = (time - (minutes * MINUTE)) % SECOND;

            System.out.printf("Execution time: %d hr %d m %d s %d ms\n"
                    , hours
                    , minutes
                    , seconds
                    , ms);
        }


    }
}
