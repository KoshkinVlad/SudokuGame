package Sudoku.GUI;

import Sudoku.commons.CommonVariables;
import Sudoku.core.Cell;
import Sudoku.core.Field;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame implements Drawable {

    private JPanel panel;

    GameGUI() {
        Field field = new Field(this);
        setDefaultCloseOperation(saveBoxResult());
        setTitle("Игра");
        setLocation(CommonVariables.X_SPAWN, CommonVariables.Y_SPAWN);
        setSize(CommonVariables.WIDTH, CommonVariables.HEIGHT);
        add(panel);
        setVisible(true);
    }

    private int saveBoxResult() {
//        DO_NOTHING_ON_CLOSE = 0;
//        HIDE_ON_CLOSE = 1;
//        DISPOSE_ON_CLOSE = 2;
//        EXIT_ON_CLOSE = 3;
        return 3;
    }

    @Override
    public void drawOnPanel(Cell[][] cells) {
        panel = new JPanel(new GridLayout(9, 9));
        for (int x = 0; x < CommonVariables.FIELD_SIZE; x++) {
            for (int y = 0; y < CommonVariables.FIELD_SIZE; y++) {
                panel.add(cells[x][y]);
            }
        }
    }
}

