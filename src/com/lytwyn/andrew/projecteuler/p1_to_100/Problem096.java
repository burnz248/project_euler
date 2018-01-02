package com.lytwyn.andrew.projecteuler.p1_to_100;

import com.lytwyn.andrew.projecteuler.sudoku.Board;
import com.lytwyn.andrew.projecteuler.sudoku.Cell;
import com.lytwyn.andrew.projecteuler.util.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by andrew on 12/28/2017.
 */
public class Problem096
{
    public static void main(String[] args) throws Exception
    {
        List<Board> boards = new ArrayList<>();

        Scanner input = new Scanner(new File(Files.PROBLEM_96));

        while(input.hasNext())
        {
            String name = input.nextLine();

            int[][] b = new int[9][9];

            for(int i = 0; i < 9 && input.hasNext(); ++i)
            {
                b[i] = convertStringToInt(input.nextLine());
            }

            boards.add(new Board(b, name));
        }

        Thread.sleep(10000);

        for(Board board : boards)
        {
            System.out.printf("Starting board: \"%s\"\n", board.getName());
            for(int row = 0; row < 9; ++row)
            {
                for(int column = 0; column < 9; ++column)
                {
                    Cell cell = board.getCell(row, column);
                    if(row == 3 && column == 1) System.err.printf("(3, 1): %d\n", cell.getSolution());

                    if(cell.getSolution() == 0)
                    {
                        System.err.printf("****found unsolved cell at (%d,%d). Current possibilities: %s\n", row, column, cell.getCandidates());
                    }
                }
            }
        }

        for(Board board : boards)
        {
            System.out.printf("Printing board: \"%s\"\n", board.getName());
            for(int row = 0; row < 9; ++row)
            {
                for(int column = 0; column < 9; ++column)
                {
                    Cell cell = board.getCell(row, column);

                    System.out.print(cell.getSolution());
                }
                System.out.println();
            }
        }
    }

    private static int[] convertStringToInt(String values)
    {
        int[] result = new int[9];

        for(int i = 0; i < 9; ++i)
        {
            result[i] = Integer.valueOf("" + values.charAt(i));
        }

        return result;
    }
}
