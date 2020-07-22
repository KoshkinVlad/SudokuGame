package Sudoku.GUI;

import Sudoku.commons.CommonVariables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame implements ActionListener {

    public final int HEIGHT = 200;
    private JButton start = new JButton("Начать новую игру");
    private JButton load = new JButton("Загрузить сохранённую игру");
    private JButton settings = new JButton("Настройки");
    private JButton exit = new JButton("Выход");
    private JPanel menuPanel = new JPanel(new GridLayout(4, 1));

    public static void main(String[] args) {
        new MenuGUI();
    }

    MenuGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Главное меню");
        setLocation(CommonVariables.X_SPAWN, CommonVariables.Y_SPAWN);
        setSize(CommonVariables.WIDTH, HEIGHT);
        start.addActionListener(this);
        load.addActionListener(this);
        settings.addActionListener(this);
        exit.addActionListener(this);
        menuPanel.add(start);
        menuPanel.add(load);
        menuPanel.add(settings);
        menuPanel.add(exit);
        add(menuPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == start) {
            new GameGUI();
        } else {
            throw new RuntimeException("Метод ещё не реализован");
        }
    }
}
