package Sudoku.core;

public class Checker {
    private static NumberCell[][] cells;

    public Checker(NumberCell[][] cells) {
        this.cells = cells;
    }

    public boolean isNumberCorrect(NumberCell numberCell) {
        return checkSquare(numberCell) & checkHorizontal(numberCell) & checkVertical(numberCell);
    }

    private boolean checkVertical(NumberCell numberCell) {
        int x = numberCell.getX();
        int y = numberCell.getY();
        for (int i = 0; i < cells[x].length; i++) {
            if (i != y) {
                if (cells[x][i].getValue() != 0 && cells[x][i].getValue() == numberCell.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkHorizontal(NumberCell numberCell) {
        int x = numberCell.getX();
        int y = numberCell.getY();
        for (int i = 0; i < cells[y].length; i++) {
            if (i != x) {
                if (cells[i][y].getValue() != 0 && cells[i][y].getValue() == numberCell.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSquare(NumberCell numberCell) throws RuntimeException {
        int x = numberCell.getX();
        int y = numberCell.getY();
        if (x < 3 && y < 3) {
            return checkSquareLimit(0, 3, 0, 3, numberCell);
        } else if (x < 3 && (y >= 3 && y < 6)) {
            return checkSquareLimit(0, 3, 3, 6, numberCell);
        } else if (x < 3 && y >= 6) {
            return checkSquareLimit(0, 3, 6, 9, numberCell);
        } else if ((x >= 3 && x < 6) && y < 3) {
            return checkSquareLimit(3, 6, 0, 3, numberCell);
        } else if ((x >= 3 && x < 6) && (y >= 3 && y < 6)) {
            return checkSquareLimit(3, 6, 3, 6, numberCell);
        } else if ((x >= 3 && x < 6) && y >= 6) {
            return checkSquareLimit(3, 6, 6, 9, numberCell);
        } else if (x >= 6 && y < 3) {
            return checkSquareLimit(6, 9, 0, 3, numberCell);
        } else if (x >= 6 && (y >= 3 && y < 6)) {
            return checkSquareLimit(6, 9, 3, 6, numberCell);
        } else if (x >= 6 && y >= 6) {
            return checkSquareLimit(6, 9, 6, 9, numberCell);
        } else {
            throw new RuntimeException("Что-то пошло не так при проверке в квадрате!");
        }
    }

    // low включительно, high исключительно
    private boolean checkSquareLimit(int lowAtX, int highAtX, int lowAtY, int highAtY, NumberCell numberCell) {
        for (int x = lowAtX; x < highAtX; x++) {
            for (int y = lowAtY; y < highAtY; y++) {
                if (x != numberCell.getX() && y != numberCell.getY()) {
                    if (cells[x][y].getValue() != 0 && cells[x][y].getValue() == numberCell.getValue()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
