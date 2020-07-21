package Sudoku.GUI;

import Sudoku.commons.CommonVariables;
import Sudoku.core.Field;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {

    GameGUI() {
        Field field=new Field();
        setDefaultCloseOperation(saveBoxResult());
        setTitle("Игра");
        setLocation(CommonVariables.X_SPAWN, CommonVariables.Y_SPAWN);
        setSize(CommonVariables.WIDTH, CommonVariables.HEIGHT);
        JPanel gameFieldPanel=field.getGameFieldPanel();
        add(gameFieldPanel,BorderLayout.CENTER);
        setVisible(true);


    }

    private void drawField(Field field) {
        // TODO
    }

    private int saveBoxResult() {
//        DO_NOTHING_ON_CLOSE = 0;
//        HIDE_ON_CLOSE = 1;
//        DISPOSE_ON_CLOSE = 2;
//        EXIT_ON_CLOSE = 3;
        return 3;
    }
}

