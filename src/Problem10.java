import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 11/30/2017.
 */
public class Problem10
{

    public static void main(String[] args)
    {
        final int MAX = 2000000;

        long sum = 0;

        boolean[] set = ProblemUtil.sieveOfEratosthenes(MAX);

        for(int i = 2; i < set.length; ++i)
        {
            if(set[i]) sum += i;
        }
        System.out.println(sum);
    }
}
