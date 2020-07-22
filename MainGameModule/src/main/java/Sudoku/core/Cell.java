package Sudoku.core;

import javax.swing.*;

public class Cell extends JButton {
    private int value;
    private int x;
    private int y;
    private boolean isNumberCorrect=true;

    public void setNumberCorrect(boolean numberCorrect) {
        isNumberCorrect = numberCorrect;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
