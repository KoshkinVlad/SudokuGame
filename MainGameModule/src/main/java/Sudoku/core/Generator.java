package Sudoku.core;

import Sudoku.commons.*;

import java.util.HashMap;
import java.util.Random;

public class Generator {

    private NumberCell[][] cells = new NumberCell[CommonVariables.FIELD_SIZE][CommonVariables.FIELD_SIZE];
    private Fillable field;
    private Сomplexity complexity;
    private Random rand = new Random();
    private HashMap<Сomplexity, Integer> complexityOpenedCellsMap = new HashMap<>();

    public Generator(Fillable field, Сomplexity complexity) {
        this.field = field;
        this.complexity = complexity;
        complexityOpenedCellsMap.put(Сomplexity.ZERO, 81);
        complexityOpenedCellsMap.put(Сomplexity.EASY, 15);
        complexityOpenedCellsMap.put(Сomplexity.MEDIUM, 10);
        complexityOpenedCellsMap.put(Сomplexity.HARD, 7);
        complexityOpenedCellsMap.put(Сomplexity.GENIUS, 5);
        complexityOpenedCellsMap.put(Сomplexity.IMPOSSIBLE, 3);
    }

    private void initializeCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int k = 0; k < cells[0].length; k++) {
                cells[i][k] = new NumberCell();
                cells[i][k].setValue(0);
            }
        }
    }

    public void generate() {
        initializeCells();
        int openCellsAmount = complexityOpenedCellsMap.get(complexity);
        Checker checker = new Checker(cells);
        for (int i = 0; i < openCellsAmount; i++) {
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);
            int value = rand.nextInt(9) + 1;
            cells[x][y].setValue(value);
        }
        field.fill(cells);
    }
}
