/*
 * MIT License
 *
 * Copyright (c) 2019 - 2021 Ursin Filli
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

import dev.ursinn.game.snake.actions.KeyHandler;

import javax.swing.*;

public class Gui {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int X_OFF = 130;
    public static final int Y_OFF = 20;

    public void create() {
        JFrame jFrame = new JFrame("Snake");
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.addKeyListener(new KeyHandler());

        Draw draw = new Draw();
        draw.setBounds(0, 0, WIDTH, HEIGHT);
        draw.setVisible(true);
        jFrame.add(draw);

        jFrame.requestFocus();
        jFrame.setVisible(true);
    }
}
