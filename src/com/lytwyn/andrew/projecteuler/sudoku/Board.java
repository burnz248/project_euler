package com.lytwyn.andrew.projecteuler.sudoku;

import java.util.*;

/**
 * Created by andrew on 12/28/2017.
 */
public class Board
{
    public String getName()
    {
        return name;
    }

    private String name = "";
    private Cell[][] board;
    private final Integer[] POSSIBLE_VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public Cell getCell(int row, int column) { return board[row][column]; }

    public Board(int[][] solutions, String... name)
    {
        if(name.length != 0) this.name = name[0];
        int rows = solutions.length;
        int columns = solutions.length;
        board = new Cell[rows][columns];

        for(int row = 0; row < solutions.length; ++row)
        {
            for(int column = 0; column < solutions.length; ++column)
            {
                int solution = solutions[row][column];
                if(solution != 0)
                {
                    Cell c = new Cell();
                    c.setSolution(solution);
                    board[row][column] = c;
                } else board[row][column] = new Cell();
            }
        }

//        populateCandidates();
//        while(performSingles() != 0)
//        {
//            populateCandidates();
//        }
//
//        while(performHiddenSingles() != 0)
//        {
//            populateCandidates();
//        }

        int counter = 0;
        while(!isSolved())
        {
            int singles = performSingles();
            populateCandidates();
            int hiddenSingles = performHiddenSingles();
            populateCandidates();

            ++counter;
            if(counter == 10000)
            {
                printBoard();
                System.exit(-401);
            }
        }
    }

    public void printBoard()
    {
        System.out.printf("Printing board: \"%s\"\n", name);
        for(int row = 0; row < 9; ++row)
        {
            for(int column = 0; column < 9; ++column)
            {
                Cell cell = board[row][column];

                System.out.print(cell.getSolution());
            }
            System.out.println();
        }
    }

    private int performHiddenSingles()
    {
        int count = 0;

        for(int row = 0; row < 9; ++row)
        {
            for(int column = 0; column < 9; ++column)
            {
                Cell c = board[row][column];

                if(row == 8 && column == 8)
                {
                    System.err.println(c.getCandidates() + " | Solution? : " + c.getSolution());
                }

                if(c.getSolution() == 0)
                {
//                    int rowHidden = getRowHiddenCandidate(row, column);
//                    int columnHidden = getColumnHiddenCandidate(row, column);
                    int boxHidden = getBoxHiddenCandidate(row, column);

                    if (boxHidden != 0)
                    {
                        c.setSolution(boxHidden);
                        ++count;
                        System.out.printf("%s: Hidden Single found at (%d, %d): %d\n", name, row, column, boxHidden);
                        populateCandidates();
                    }
                }
            }
        }

        return count;
    }

    private int getRowHiddenCandidate(int row, int column)
    {
        List<Integer> cellPossibilities = board[row][column].getCandidates();

        Set<Integer> rowPossibilities = new TreeSet<>();

        for(int c = 0; c < 9; ++c)
        {
            if(c != column)
            {
                Cell cell = board[row][c];
                if(cell.getSolution() == 0)
                {
                    rowPossibilities.addAll(cell.getCandidates());
                }
            }
        }

        cellPossibilities.retainAll(rowPossibilities);
        if(row == 3 && column == 0)
        {
            System.out.println(cellPossibilities);
        }
        if(cellPossibilities.size() == 1) return cellPossibilities.get(0);
        else return 0;
    }

    private int getColumnHiddenCandidate(int row, int column)
    {
        List<Integer> cellPossibilities = board[row][column].getCandidates();

        Set<Integer> columnPossibilities = new TreeSet<>();

        for(int r = 0; r < 9; ++r)
        {
            if(r != row)
            {
                Cell cell = board[r][column];
                if(cell.getSolution() == 0)
                {
                    columnPossibilities.addAll(cell.getCandidates());
                }
            }
        }

        cellPossibilities.retainAll(columnPossibilities);
        if(row == 3 && column == 0)
        {
            System.out.println(cellPossibilities);
        }
        if(cellPossibilities.size() == 1) return cellPossibilities.get(0);
        else return 0;
    }

    private int getBoxHiddenCandidate(int row, int column)
    {
        int startRow = 0;
        int startColumn = 0;

        int endRow = 0;
        int endColumn = 0;

        if (row >= 0 && row <= 2)
        {
            if(column >= 0 && column <= 2)
            {
                startRow = 0;
                startColumn = 0;
                endRow = 2;
                endColumn = 2;
            } else if(column >= 3 && column <= 5)
            {
                startRow = 0;
                startColumn = 3;
                endRow = 2;
                endColumn = 5;
            } else if(column >= 6 && column <= 8)
            {
                startRow = 0;
                startColumn = 6;
                endRow = 2;
                endColumn = 8;
            }
        } else if ( row >= 3 && row <= 5)
        {
            if(column >= 0 && column <= 2)
            {
                startRow = 3;
                startColumn = 0;
                endRow = 5;
                endColumn = 2;
            } else if(column >= 3 && column <= 5)
            {
                startRow = 3;
                startColumn = 3;
                endRow = 5;
                endColumn = 5;
            } else if(column >= 6 && column <= 8)
            {
                startRow = 3;
                startColumn = 6;
                endRow = 5;
                endColumn = 8;
            }
        } else if (row >= 6 && column <= 8)
        {
            if(column >= 0 && column <= 2)
            {
                startRow = 6;
                startColumn = 0;
                endRow = 8;
                endColumn = 2;
            } else if(column >= 3 && column <= 5)
            {
                startRow = 6;
                startColumn = 3;
                endRow = 8;
                endColumn = 5;
            } else if(column >= 6 && column <= 8)
            {
                startRow = 6;
                startColumn = 6;
                endRow = 8;
                endColumn = 8;
            }
        }

        List<Integer> cellPossibilities = board[row][column].getCandidates();

        Set<Integer> boxPossibilities = new TreeSet<>();

        for(int r = startRow; r <= endRow; ++r)
        {
            for(int c = startColumn; c <= endColumn; ++c)
            {
                if(r != row && c != column)
                {
                    Cell cell = board[r][c];
                    if(cell.getSolution() == 0)
                    {
                        boxPossibilities.addAll(cell.getCandidates());
                    }
                }

            }
        }

        cellPossibilities.retainAll(boxPossibilities);
        if(row == 3 && column == 0)
        {
            System.out.println(cellPossibilities);
        }
        if(cellPossibilities.size() == 1) return cellPossibilities.get(0);
        else return 0;
    }

    private int performSingles()
    {
        int count = 0;

        for(int row = 0; row < 9; ++row)
        {
            for(int column = 0; column < 9; ++column)
            {
                Cell cell = board[row][column];

                if(cell.getSolution() == 0)
                {
                    if(cell.getCandidates().size() == 1)
                    {
                        System.out.printf("Entry (%d,%d) naked value: %s\n", row, column, cell.getCandidates());
                        cell.setSolution(cell.getCandidates().get(0));
                        ++count;
                    }
                }
            }
        }

        return count;
    }

    private void populateCandidates()
    {
        for(int row = 0; row < board.length; ++row)
        {
            for(int column = 0; column < board[row].length; ++column)
            {
                List<Integer> rowCandidates = getRowCandidates(row);
                List<Integer> columnCandidates = getColumnCandidates(column);
                List<Integer> boxCandidates = getBoxCandidates(row, column);

                List<Integer> candidates = new ArrayList<>(rowCandidates);
                candidates.retainAll(columnCandidates);
                candidates.retainAll(boxCandidates);

                board[row][column].setCandidates(candidates);

                if(row == 8 && column == 8)
                {
                    System.err.printf("***(8,8)\n" +
                                         "******rowCandidates: %s\n" +
                                         "******columnCandidates: %s\n" +
                                         "******boxCandidates: %s\n", rowCandidates, columnCandidates, boxCandidates );
                }
            }
        }
    }

    private List<Integer> getRowCandidates(int row)
    {
        List<Integer> possibleValues = new ArrayList<Integer>();
        possibleValues.addAll(Arrays.asList(POSSIBLE_VALUES));

        for(int column = 0; column < board[row].length; ++column)
        {
            Cell cell = board[row][column];
            int solution = cell.getSolution();
            if(solution != 0)
            {
                for(int i = 0; i < possibleValues.size(); ++i)
                {
                    if(possibleValues.get(i) == solution) possibleValues.remove(i);
                }
            }
        }

        return possibleValues;
    }

    private List<Integer> getColumnCandidates(int column)
    {
        List<Integer> possibleValues = new ArrayList<>();
        possibleValues.addAll(Arrays.asList(POSSIBLE_VALUES));

        for(int row = 0; row < board.length; ++row)
        {
            Cell cell = board[row][column];
            int solution = cell.getSolution();
            if(solution != 0)
            {
                for(int i = 0; i < possibleValues.size(); ++i)
                {
                    if(possibleValues.get(i) == solution) possibleValues.remove(i);
                }
            }
        }

        return possibleValues;
    }

    // this can probably be simplified
    private List<Integer> getBoxCandidates(int row, int column)
    {
        int startRow = 0;
        int startColumn = 0;

        int endRow = 0;
        int endColumn = 0;

        if (row >= 0 && row <= 2)
        {
            if(column >= 0 && column <= 2)
            {
                startRow = 0;
                startColumn = 0;
                endRow = 2;
                endColumn = 2;
            } else if(column >= 3 && column <= 5)
            {
                startRow = 0;
                startColumn = 3;
                endRow = 2;
                endColumn = 5;
            } else if(column >= 6 && column <= 8)
            {
                startRow = 0;
                startColumn = 6;
                endRow = 2;
                endColumn = 8;
            }
        } else if ( row >= 3 && row <= 5)
        {
            if(column >= 0 && column <= 2)
            {
                startRow = 3;
                startColumn = 0;
                endRow = 5;
                endColumn = 2;
            } else if(column >= 3 && column <= 5)
            {
                startRow = 3;
                startColumn = 3;
                endRow = 5;
                endColumn = 5;
            } else if(column >= 6 && column <= 8)
            {
                startRow = 3;
                startColumn = 6;
                endRow = 5;
                endColumn = 8;
            }
        } else if (row >= 6 && column <= 8)
        {
            if(column >= 0 && column <= 2)
            {
                startRow = 6;
                startColumn = 0;
                endRow = 8;
                endColumn = 2;
            } else if(column >= 3 && column <= 5)
            {
                startRow = 6;
                startColumn = 3;
                endRow = 8;
                endColumn = 5;
            } else if(column >= 6 && column <= 8)
            {
                startRow = 6;
                startColumn = 6;
                endRow = 8;
                endColumn = 8;
            }
        }

        List<Integer> possibleValues = new ArrayList<Integer>();
        possibleValues.addAll(Arrays.asList(POSSIBLE_VALUES));

        for(int r = startRow; r <= endRow; ++r)
        {
            for(int c = startColumn; c <= endColumn; ++c)
            {
                Cell cell = board[r][c];
                int solution = cell.getSolution();
                if(solution != 0)
                {
                    for(int i = 0; i < possibleValues.size(); ++i)
                    {
                        if(possibleValues.get(i) == solution) possibleValues.remove(i);
                    }
                }

            }
        }

        return possibleValues;
    }

    private boolean isSolved()
    {
        for(int row = 0; row < 9; ++row)
        {
            for(int column = 0; column < 9; ++column)
            {
                if(board[row][column].getSolution() == 0) return false;
            }
        }
        return true;
    }


}
