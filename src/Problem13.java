import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem13
{
    public static void main(String[] args) throws Exception
    {
        List<String> numbers = new ArrayList<>();

        Scanner input = new Scanner(new File("./data/input/problem_13.txt"));

        while(input.hasNext())
        {
            numbers.add(input.nextLine());
        }

        String solution = "";

        int carry = 0;
        // i--> character index in string
        for(int i = 49; i >= 0; --i)
        {
            int sum = carry;

            for(String number : numbers)
            {
                sum += Integer.valueOf("" + number.charAt(i));
            }

            solution = String.format("%d%s", (sum % 10), solution);
            carry = sum / 10;
        }
        solution = String.format("%d%s", carry, solution);

        System.out.println(solution.substring(0, 10));
    }
}
