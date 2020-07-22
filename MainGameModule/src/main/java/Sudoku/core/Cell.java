package Sudoku.core;

import javax.swing.*;

public class Cell extends JButton {
    private int value;
    private int x;
    private int y;
    private boolean isNumberCorrect = true;

    public void setNumberCorrect(boolean numberCorrect) {
        isNumberCorrect = numberCorrect;
    }

    public void setValue(int value) {
        this.value = value;
        setText(String.valueOf(value == 0 ? "" : value));
    }

    public int getValue() {
        return value;
    }

    public void setXPos(int x) {
        this.x = x;
    }

    public void setYPos(int y) {
        this.y = y;
    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }
}
