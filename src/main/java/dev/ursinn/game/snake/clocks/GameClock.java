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

package dev.ursinn.game.snake.clocks;

import dev.ursinn.game.snake.Main;
import dev.ursinn.game.snake.actions.Collision;

public class GameClock extends Thread {

    public static boolean running = true;

    public void run() {
        while (running) {
            try {
                sleep(200);
                Main.getSnake().move();
                Main.getSnake().waitToMove = false;
                Collision.collidePickUp();
                if (Collision.collideSelf()) {
                    Main.getSnake().tails.clear();
                    Main.getSnake().score = 0;
                }
                if (Collision.collideWall()) {
                    Main.getSnake().tails.clear();
                    Main.getSnake().head.setX(7);
                    Main.getSnake().head.setY(7);
                    Main.getSnake().score = 0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
