package Sudoku.core;

import Sudoku.GUI.Drawable;
import Sudoku.commons.Сomplexity;

import javax.swing.*;
import java.awt.*;

public class Field extends JFrame implements Fillable {
    private JPanel gameFieldPanel;
    private Cell[][] cells;
    private Drawable GUI;

    public Field(Drawable GUI) {
        this.GUI = GUI;
        // берёт откуда-то сложность, пока напрямую задаю
        Сomplexity сomplexity = Сomplexity.EASY;
        Generator generator = new Generator(this, сomplexity);
        generator.generate();
    }

    @Override
    public void fill(Cell[][] cells) {
        GUI.drawOnPanel(cells);
    }
}
