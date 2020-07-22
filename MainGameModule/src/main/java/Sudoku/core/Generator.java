package Sudoku.core;

import Sudoku.commons.*;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Generator {

    private Cell[][] cells = new Cell[CommonVariables.FIELD_SIZE][CommonVariables.FIELD_SIZE];
    private Fillable field;
    private Сomplexity complexity;
    private Random rand = new Random();
    private HashMap<Сomplexity, Integer> complexityOpenedCellsMap = new HashMap<>();

    public Generator(Fillable field, Сomplexity complexity) {
        this.field = field;
        this.complexity = complexity;
        complexityOpenedCellsMap.put(Сomplexity.ZERO, 81);
        complexityOpenedCellsMap.put(Сomplexity.EASY, 33);
        complexityOpenedCellsMap.put(Сomplexity.MEDIUM, 28);
        complexityOpenedCellsMap.put(Сomplexity.HARD, 23);
        complexityOpenedCellsMap.put(Сomplexity.GENIUS, 20);
        complexityOpenedCellsMap.put(Сomplexity.IMPOSSIBLE, 17);
    }

    private void initializeCells() {
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[0].length; y++) {
                cells[x][y] = new Cell();
                cells[x][y].setX(x);
                cells[x][y].setY(y);
            }
        }
    }

    public void generate() {
        initializeCells();
        makeBaseField();
        shuffleField(150);

        printField();
    }

    private void makeBaseField() {
        int[] row = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < CommonVariables.FIELD_SIZE; i++) {
            for (int k = 0; k < CommonVariables.FIELD_SIZE; k++) {
                cells[i][k].setValue(row[k]);
            }
            int shiftSize = 3;
            if (i == 2 || i == 5) {
                shiftSize = 4;
            }
            row = shiftArrayLeft(row, shiftSize);
        }
    }

    private int[] shiftArrayLeft(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += value;
            if (arr[i] > CommonVariables.FIELD_SIZE) {
                arr[i] -= CommonVariables.FIELD_SIZE;
            }
        }
        return arr;
    }

    private void printField() {
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[0].length; y++) {
                System.out.print(cells[x][y].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void shuffleField(int shuffleAmount) {
        HashMap<Integer, Action> actions = new HashMap<>();
        actions.put(0, Action.TRANSPOSE);
        actions.put(1, Action.SWAP_ROWS_WITHIN_REGION);
        actions.put(2, Action.SWAP_COLUMNS_WITHIN_REGION);
        actions.put(3, Action.SWAP_REGIONS_HORIZONTAL);
        actions.put(4, Action.SWAP_REGIONS_VERTICAL);
        Random random = new Random();
        for (int i = 0; i < shuffleAmount; i++) {
            Action action = actions.get(random.nextInt(5));
            switch (action) {
                case TRANSPOSE:
                    transpose();
                    break;
                case SWAP_COLUMNS_WITHIN_REGION:
                    swapColumnsWithinRegion();
                    break;
                case SWAP_ROWS_WITHIN_REGION:
                    swapRowsWithinRegion();
                    break;
                case SWAP_REGIONS_HORIZONTAL:
                    swapRegionsHorizontal();
                    break;
                case SWAP_REGIONS_VERTICAL:
                    swapRegionsVertical();
                    break;
                default:
                    throw new RuntimeException("в методе shuffleField неизвестный тип перетасовки!");
            }
        }
    }

    private enum Action {
        TRANSPOSE,
        SWAP_ROWS_WITHIN_REGION,
        SWAP_COLUMNS_WITHIN_REGION,
        SWAP_REGIONS_HORIZONTAL,
        SWAP_REGIONS_VERTICAL
    }

    private void transpose() {
        for (int x = 0; x < CommonVariables.FIELD_SIZE; x++) {
            for (int y = 0; y < CommonVariables.FIELD_SIZE; y++) {
                int temp = cells[x][y].getValue();
                cells[x][y].setValue(cells[y][x].getValue());
                cells[y][x].setValue(temp);
            }
        }
    }

    private void swapRegionsVertical() {
        ;
        Random random = new Random();
        int firstRegion = random.nextInt(3);
        int secondRegion;
        do {
            secondRegion = random.nextInt(3);
        } while (firstRegion == secondRegion);
        for (int i = 0; i < CommonVariables.FIELD_SIZE; i++) {
            for (int k = 0; k < 3; k++) {
                int temp = cells[i][firstRegion * 3 + k].getValue();
                cells[i][firstRegion * 3 + k].setValue(cells[i][secondRegion * 3 + k].getValue());
                cells[i][secondRegion * 3 + k].setValue(temp);
            }
        }
    }

    private void swapRegionsHorizontal() {
        Random random = new Random();
        int firstRegion = random.nextInt(3);
        int secondRegion;
        do {
            secondRegion = random.nextInt(3);
        } while (firstRegion == secondRegion);
        for (int i = 0; i < CommonVariables.FIELD_SIZE; i++) {
            for (int k = 0; k < 3; k++) {
                int temp = cells[firstRegion * 3 + k][i].getValue();
                cells[firstRegion * 3 + k][i].setValue(cells[secondRegion * 3 + k][i].getValue());
                cells[secondRegion * 3 + k][i].setValue(temp);
            }
        }

    }

    private void swapColumnsWithinRegion() {
        Random random = new Random();
        int regionNumber = random.nextInt(3);
        int firstColumn = random.nextInt(3);
        int secondColumn;
        do {
            secondColumn = random.nextInt(3);
        } while (secondColumn == firstColumn);
        firstColumn += regionNumber * 3;
        secondColumn += regionNumber * 3;
        for (int i = 0; i < CommonVariables.FIELD_SIZE; i++) {
            int temp = cells[i][firstColumn].getValue();
            cells[i][firstColumn].setValue(cells[i][secondColumn].getValue());
            cells[i][secondColumn].setValue(temp);
        }

    }

    private void swapRowsWithinRegion() {
        Random random = new Random();
        int regionNumber = random.nextInt(3);
        int firstRow = random.nextInt(3);
        int secondRow;
        do {
            secondRow = random.nextInt(3);
        } while (secondRow == firstRow);
        firstRow += regionNumber * 3;
        secondRow += regionNumber * 3;
        for (int i = 0; i < CommonVariables.FIELD_SIZE; i++) {
            int temp = cells[firstRow][i].getValue();
            cells[firstRow][i].setValue(cells[secondRow][i].getValue());
            cells[secondRow][i].setValue(temp);
        }

    }
}
