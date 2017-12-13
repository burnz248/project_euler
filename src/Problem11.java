import java.io.File;
import java.util.Scanner;

public class Problem11
{
    private static int[][] grid = new int[20][20];

    public static void main(String[] args) throws Exception
    {
        initGrid();

        int rows = getMaxRows();
        int columns = getMaxColumns();
        int rightDiagonals = getMaxRightDiagonals();
        int leftDiagonals = getMaxLeftDiagonals();

        int max = 0;

        if (rows >= max) max = rows;
        if (columns >= max) max = columns;
        if (rightDiagonals >= max) max = rightDiagonals;
        if (leftDiagonals >= max) max = leftDiagonals;

        System.out.println(max);
    }

    private static void initGrid() throws Exception
    {
        Scanner input = new Scanner(new File("./data/input/problem_11.txt"));

        for(int gridIndex = 0; input.hasNext(); ++gridIndex)
        {
            grid[gridIndex] = getLineData(input);
        }
    }

    private static int[] getLineData(Scanner input)
    {
        String[] lineData = input.nextLine().split("\\s");
        int[] result = new int[lineData.length];

        for (int i = 0; i < lineData.length; i++)
        {
            result[i] = Integer.valueOf(lineData[i]);
        }
        return result;
    }

    private static int getMaxRows()
    {
        int max = 0;

        for(int row = 0; row <= 19; ++row)
        {
            for(int column = 0; column <= 16; ++column)
            {
                int tempIndex = column;
                int product = grid[row][tempIndex]
                            * grid[row][++tempIndex]
                            * grid[row][++tempIndex]
                            * grid[row][++tempIndex];
                if(product >= max) max = product;
            }
        }

        return max;
    }

    private static int getMaxColumns()
    {
        int max = 0;

        for(int column = 0; column <= 19; ++column)
        {
            for(int row = 0; row <= 16; ++row)
            {
                int tempIndex = row;
                int product = grid[tempIndex][column]
                            * grid[++tempIndex][column]
                            * grid[++tempIndex][column]
                            * grid[++tempIndex][column];
                if(product >= max) max = product;
            }
        }

        return max;
    }

    private static int getMaxRightDiagonals()
    {
        int max = 0;

        for(int row = 0; row <= 16; ++row)
        {
            for(int column = 0; column <= 16; ++column)
            {
                int rowIndex = row;
                int columnIndex = column;

                int product = grid[rowIndex][columnIndex]
                            * grid[++rowIndex][++columnIndex]
                            * grid[++rowIndex][++columnIndex]
                            * grid[++rowIndex][++columnIndex];
                if(product >= max) max = product;
            }
        }

        return max;
    }

    private static int getMaxLeftDiagonals()
    {
        int max = 0;

        for(int row = 0; row <= 16; ++row)
        {
            for(int column = 3; column <= 19; ++column)
            {
                int rowIndex = row;
                int columnIndex = column;

                int product = grid[rowIndex][columnIndex]
                            * grid[++rowIndex][--columnIndex]
                            * grid[++rowIndex][--columnIndex]
                            * grid[++rowIndex][--columnIndex];
                if(product >= max) max = product;
            }
        }

        return max;
    }
}
