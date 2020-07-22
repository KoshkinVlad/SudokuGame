package Sudoku.core;

public class Checker {
    private static Cell[][] cells;

    public Checker(Cell[][] cells) {
        this.cells = cells;
    }

    public boolean isNumberCorrect(Cell cell) {
        return checkSquare(cell) & checkHorizontal(cell) & checkVertical(cell);
    }

    private boolean checkVertical(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        for (int i = 0; i < cells[x].length; i++) {
            if (i != y) {
                if (cells[x][i].getValue() != 0 && cells[x][i].getValue() == cell.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkHorizontal(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        for (int i = 0; i < cells[y].length; i++) {
            if (i != x) {
                if (cells[i][y].getValue() != 0 && cells[i][y].getValue() == cell.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSquare(Cell cell) throws RuntimeException {
        int x = cell.getX();
        int y = cell.getY();
        if (x < 3 && y < 3) {
            return checkSquareLimit(0, 3, 0, 3, cell);
        } else if (x < 3 && (y >= 3 && y < 6)) {
            return checkSquareLimit(0, 3, 3, 6, cell);
        } else if (x < 3 && y >= 6) {
            return checkSquareLimit(0, 3, 6, 9, cell);
        } else if ((x >= 3 && x < 6) && y < 3) {
            return checkSquareLimit(3, 6, 0, 3, cell);
        } else if ((x >= 3 && x < 6) && (y >= 3 && y < 6)) {
            return checkSquareLimit(3, 6, 3, 6, cell);
        } else if ((x >= 3 && x < 6) && y >= 6) {
            return checkSquareLimit(3, 6, 6, 9, cell);
        } else if (x >= 6 && y < 3) {
            return checkSquareLimit(6, 9, 0, 3, cell);
        } else if (x >= 6 && (y >= 3 && y < 6)) {
            return checkSquareLimit(6, 9, 3, 6, cell);
        } else if (x >= 6 && y >= 6) {
            return checkSquareLimit(6, 9, 6, 9, cell);
        } else {
            throw new RuntimeException("Что-то пошло не так при проверке в квадрате!");
        }
    }

    // low включительно, high исключительно
    private boolean checkSquareLimit(int lowAtX, int highAtX, int lowAtY, int highAtY, Cell cell) {
        for (int x = lowAtX; x < highAtX; x++) {
            for (int y = lowAtY; y < highAtY; y++) {
                if (x != cell.getX() && y != cell.getY()) {
                    if (cells[x][y].getValue() != 0 && cells[x][y].getValue() == cell.getValue()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
