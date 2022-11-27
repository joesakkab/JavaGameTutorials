package main;

import javax.swing.*;

public class GameWindow extends JFrame {

    public static final int WINDOW_HEIGHT = 400;
    public static final int WINDOW_WIDTH = 400;

    public GameWindow(GamePanel gamePanel) {
//        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(gamePanel);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        setVisible(true);
    }
}
