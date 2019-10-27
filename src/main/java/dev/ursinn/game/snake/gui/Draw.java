/*
 * MIT License
 *
 * Copyright (c) 2019 Ursin Filli
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package dev.ursinn.game.snake.gui;

import dev.ursinn.game.snake.actions.Main;
import dev.ursinn.game.snake.game.Snake;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    private Point point;

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        // Draw Background
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, Gui.width, Gui.height);

        // Draw Snake Tails
        graphics.setColor(new Color(50, 200, 50));
        for (int i = 0; i < Main.getSnake().tails.size(); i++) {
            point = Snake.ptc(Main.getSnake().tails.get(i).getX(), Main.getSnake().tails.get(i).getY());
            graphics.fillRect(point.x, point.y, 32, 32);
        }

        // Draw Snake Head
        graphics.setColor(new Color(0, 150, 0));
        point = Snake.ptc(Main.getSnake().head.getX(), Main.getSnake().head.getY());
        graphics.fillRect(point.x, point.y, 32, 32);

        // Draw PickUp
        graphics.setColor(new Color(200, 50, 0));
        point = Snake.ptc(Main.getSnake().pickUp.getX(), Main.getSnake().pickUp.getY());
        graphics.fillRect(point.x, point.y, 32, 32);

        // Draw Grid
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                graphics.drawRect(i * 32 + Gui.xOff, j * 32 + Gui.yOff, 32, 32);
            }
        }

        // Draw Border
        graphics.setColor(Color.BLACK);
        graphics.drawRect(Gui.xOff, Gui.yOff, 512, 512);

        // Draw Score
        graphics.setFont(new Font("Arial", Font.BOLD, 20));
        graphics.drawString("Score: " + Main.getSnake().score, 5, 25);
        graphics.drawString("Best: " + Main.getSnake().bestScore, 655, 25);

        repaint();
    }
}
