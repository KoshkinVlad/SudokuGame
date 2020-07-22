package Sudoku.core;

import Sudoku.commons.Сomplexity;

import javax.swing.*;
import java.awt.*;

public class Field extends JFrame implements Fillable {
    private JPanel gameFieldPanel;
    private Cell[][] cells;

    public Field() {
        // берёт откуда-то сложность, пока напрямую задаю
        Сomplexity сomplexity = Сomplexity.ZERO;
        Generator generator = new Generator(this, сomplexity);
        generator.generate();
    }

    @Override
    public void fill(Cell[][] cells) {
    }

    public JPanel getGameFieldPanel() {
        return null;
    }
}
