package Sudoku.core;

import javax.swing.*;

public class NumberCell extends JButton {
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

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
