package com.lytwyn.andrew.projecteuler.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 12/28/2017.
 */
public class Cell
{
    private List<Integer> candidates = new ArrayList<>();
    private int solution = 0;

    public void setCandidates(List<Integer> candidates){ this.candidates = candidates; }

    public void removeCandidate(int candidate) { candidates.remove(candidate); }

    public void setSolution(int solution) { this.solution = solution; }

    public List<Integer> getCandidates() { return candidates; }

    public int getSolution() { return solution; }

}
