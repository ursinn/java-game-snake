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

package dev.ursinn.game.snake.actions;

import dev.ursinn.game.snake.Main;
import dev.ursinn.game.snake.game.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        //
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP:
                if (Main.getSnake().getHead().getDirection() != Direction.DOWN && !Main.getSnake().isWaitToMove()) {
                    Main.getSnake().getHead().setDirection(Direction.UP);
                    Main.getSnake().setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT:
                if (Main.getSnake().getHead().getDirection() != Direction.RIGHT && !Main.getSnake().isWaitToMove()) {
                    Main.getSnake().getHead().setDirection(Direction.LEFT);
                    Main.getSnake().setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                if (Main.getSnake().getHead().getDirection() != Direction.UP && !Main.getSnake().isWaitToMove()) {
                    Main.getSnake().getHead().setDirection(Direction.DOWN);
                    Main.getSnake().setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                if (Main.getSnake().getHead().getDirection() != Direction.LEFT && !Main.getSnake().isWaitToMove()) {
                    Main.getSnake().getHead().setDirection(Direction.RIGHT);
                    Main.getSnake().setWaitToMove(true);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //
    }
}
