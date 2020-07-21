package Sudoku.core;

import Sudoku.commons.Сomplexity;

import javax.swing.*;
import java.awt.*;

public class Field extends JFrame implements Fillable {
    private JPanel gameFieldPanel;
    private NumberCell[][] cells;

    public Field() {
        // берёт откуда-то сложность, пока напрямую задаю
        Сomplexity сomplexity = Сomplexity.ZERO;
        Generator generator = new Generator(this, сomplexity);
        generator.generate();
    }

    public JPanel getGameFieldPanel() {
        return gameFieldPanel;
    }

    @Override
    public void fill(NumberCell[][] cells) {
        gameFieldPanel = new JPanel(new GridLayout(9, 9));
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[0].length; y++) {
                if (cells[x][y].getValue() != 0) {
                    cells[x][y].setText(String.valueOf(cells[x][y].getValue()));
//                    cells[x][y].setEnabled(false);
                }
                gameFieldPanel.add(cells[x][y]);
                System.out.print(cells[x][y].getValue() + " ");
            }
            System.out.print(System.lineSeparator());
        }
    }
}
