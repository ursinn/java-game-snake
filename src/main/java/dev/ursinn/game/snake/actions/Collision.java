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

package dev.ursinn.game.snake.actions;

import dev.ursinn.game.snake.Main;

public class Collision {

    public static boolean collideSelf() {
        for (int i = 0; i < Main.getSnake().tails.size(); i++) {
            if (Main.getSnake().head.getX() == Main.getSnake().tails.get(i).getX() && Main.getSnake().head.getY() == Main.getSnake().tails.get(i).getY() && !Main.getSnake().tails.get(i).isWait())
                return true;
        }
        return false;
    }

    public static boolean collideWall() {
        return (Main.getSnake().head.getX() < 0 || Main.getSnake().head.getX() > 15 || Main.getSnake().head.getY() < 0 || Main.getSnake().head.getY() > 15);
    }

    public static void collidePickUp() {
        if (Main.getSnake().head.getX() == Main.getSnake().pickUp.getX() && Main.getSnake().head.getY() == Main.getSnake().pickUp.getY()) {
            Main.getSnake().pickUp.reset();
            Main.getSnake().addTail();
            Main.getSnake().score += 1;
            if (Main.getSnake().score > Main.getSnake().bestScore)
                Main.getSnake().bestScore = Main.getSnake().score;
        }
    }
}
