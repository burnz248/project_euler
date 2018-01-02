package com.lytwyn.andrew.projecteuler.sudoku;

/**
 * Created by andrew on 12/28/2017.
 */
public class Test
{
    public static void main(String[] args)
    {
        int[][] b = {
                  {0, 0, 3, 0, 2, 0, 6, 0, 0}
                , {9, 0, 0, 3, 0, 5, 0, 0, 1}
                , {0, 0, 1, 8, 0, 6, 4, 0, 0}
                , {0, 0, 8, 1, 0, 2, 9, 0, 0}
                , {7, 0, 0, 0, 0, 0, 0, 0, 8}
                , {0, 0, 6, 7, 0, 8, 2, 0, 0}
                , {0, 0, 2, 6, 0, 9, 5, 0, 0}
                , {8, 0, 0, 2, 0, 3, 0, 0, 9}
                , {0, 0, 5, 0, 1, 0, 3, 0, 0}
        };

        Board board = new Board(b);

        for(int row = 0; row < 9; ++row)
        {
            for(int column = 0; column < 9; ++column)
            {
                Cell cell = board.getCell(row, column);

                if(cell.getSolution() == 0)
                {
                    System.out.printf("found unsolved cell at (%d,%d). Current possibilities: %s", row, column, cell.getCandidates());
                }
            }
        }
    }
}
