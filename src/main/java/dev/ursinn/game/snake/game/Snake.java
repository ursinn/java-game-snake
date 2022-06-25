/*
 * MIT License
 *
 * Copyright (c) 2019-2022 Ursin Filli
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
 */

package dev.ursinn.game.snake.game;

import dev.ursinn.game.snake.gui.Gui;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    @Getter
    @Setter
    private int score = 0;

    @Getter
    @Setter
    private int bestScore = 0;

    @Getter
    @Setter
    private boolean waitToMove = false;

    @Getter
    private final Head head = new Head(7, 7);

    @Getter
    private final List<Tail> tails = new ArrayList<>();

    @Getter
    private final PickUp pickUp = new PickUp();

    // Position to Coordinates
    public static Point ptc(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * 32 + Gui.X_OFF;
        p.y = y * 32 + Gui.Y_OFF;

        return p;
    }

    public void addTail() {
        if (tails.isEmpty()) {
            tails.add(new Tail(head.getX(), head.getY()));
        } else {
            tails.add(new Tail(tails.get(tails.size() - 1).getX(), tails.get(tails.size() - 1).getY()));
        }
    }

    public void move() {
        // Move Tails
        if (tails.size() >= 2) {
            for (int i = tails.size() - 1; i >= 1; i--) {
                if (tails.get(i).isWait()) {
                    tails.get(i).setWait(false);
                } else {
                    tails.get(i).setX(tails.get(i - 1).getX());
                    tails.get(i).setY(tails.get(i - 1).getY());
                }
            }
        }

        // Move First Tail to Head
        if (!tails.isEmpty()) {
            if (tails.get(0).isWait()) {
                tails.get(0).setWait(false);
            } else {
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        // Move Head
        switch (head.getDirection()) {
            case UP -> head.setY(head.getY() - 1);
            case DOWN -> head.setY(head.getY() + 1);
            case LEFT -> head.setX(head.getX() - 1);
            case RIGHT -> head.setX(head.getX() + 1);
        }
    }
}
