package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 1f, yDir = 1f;
    private Color color = new Color(150, 20, 90);
    private Random random;

    private ArrayList<MyRect> rects = new ArrayList<>();
    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void spawnRect(int x, int y) {
        rects.add(new MyRect(x, y));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MyRect rect : rects) {
            rect.updateRect();
            rect.draw(g);
        }
    }

    public class MyRect {
        int x, y, w, h;
        int xDir = 1, yDir = 1;
        Color color;

        public MyRect(int x, int y) {
            this.x = x;
            this.y = y;
            w = random.nextInt(50);
            h = w;
            color = newColor();
        }

        public void updateRect() {
            this.x += xDir;
            this.y += yDir;

            if ((x + w) > GameWindow.WINDOW_WIDTH || x < 0) {
                xDir *= -1;
                color = newColor();
            }
            if ((y + h) > GameWindow.WINDOW_HEIGHT || y < 0) {
                yDir *= -1;
                color = newColor();
            }
        }

        private Color newColor() {
            return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, w, h);
        }
    }
}
