/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.math;

import static com.google.common.base.Preconditions.checkNotNull;

public class SpongeVector2i implements Vector2i {
    static final long serialVersionUID = 1L;

    private final int x;
    private final int y;

    public SpongeVector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Vector2i add(Vector2i v) {
        checkNotNull(v);
        return new SpongeVector2i(this.x + v.getX(), this.y + v.getY());
    }

    @Override
    public Vector2i add(double x, double y) {
        return new SpongeVector2i(this.x + (int) Math.round(x), this.y + (int) Math.round(y));
    }

    @Override
    public Vector2i add(int x, int y) {
        return new SpongeVector2i(this.x + x, this.y + y);
    }

    @Override
    public Vector2i sub(Vector2i v) {
        checkNotNull(v);
        return new SpongeVector2i(this.x - v.getX(), this.y - v.getY());
    }

    @Override
    public Vector2i sub(double x, double y) {
        return new SpongeVector2i(this.x - (int) Math.round(x), this.y - (int) Math.round(y));
    }

    @Override
    public Vector2i sub(int x, int y) {
        return new SpongeVector2i(this.x - x, this.y - y);
    }

    @Override
    public Vector2i mul(double a) {
        return new SpongeVector2i((int) Math.round(x * a), (int) Math.round(y * a));
    }

    @Override
    public Vector2i mul(int a) {
        return new SpongeVector2i(x * a, y * a);
    }

    @Override
    public Vector2i mul(Vector2i v) {
        checkNotNull(v);
        return new SpongeVector2i(this.x * v.getX(), this.y * v.getY());
    }

    @Override
    public Vector2i mul(double x, double y) {
        return new SpongeVector2i((int) Math.round(this.x * x), (int) Math.round(this.y * y));
    }

    @Override
    public Vector2i mul(int x, int y) {
        return new SpongeVector2i(this.x * x, this.y * y);
    }

    @Override
    public Vector2i div(double a) {
        return new SpongeVector2i((int) Math.round(x / a), (int) Math.round(y / a));
    }

    @Override
    public Vector2i div(int a) {
        return new SpongeVector2i(x / a, y / a);
    }

    @Override
    public Vector2i div(Vector2i v) {
        return new SpongeVector2i(this.x / v.getX(), this.y / v.getY());
    }

    @Override
    public Vector2i div(double x, double y) {
        return new SpongeVector2i((int) Math.round(this.x / x), (int) Math.round(this.y / y));
    }

    @Override
    public Vector2i div(int x, int y) {
        return new SpongeVector2i(this.x / x, this.y / y);
    }

    @Override
    public int dot(Vector2i v) {
        checkNotNull(v);
        return x * v.getX() + y * v.getY();
    }

    @Override
    public int dot(double x, double y) {
        return (int) Math.round(this.x * x + this.y * y);
    }

    @Override
    public int dot(int x, int y) {
        return this.x * x + this.y * y;
    }

    @Override
    public Vector2i pow(double pow) {
        return new SpongeVector2i((int) Math.pow(x, pow), (int) Math.pow(y, pow));
    }

    @Override
    public Vector2i pow(int power) {
        return new SpongeVector2i((int) Math.pow(x, power), (int) Math.pow(y, power));
    }

    @Override
    public Vector2i abs() {
        return new SpongeVector2i(Math.abs(x), Math.abs(y));
    }

    @Override
    public Vector2i negate() {
        return new SpongeVector2i(-x, -y);
    }

    @Override
    public Vector2i min(Vector2i v) {
        checkNotNull(v);
        return new SpongeVector2i(Math.min(x, v.getX()), Math.min(y, v.getY()));
    }

    @Override
    public Vector2i min(double x, double y) {
        return new SpongeVector2i(Math.min(this.x, (int) Math.round(x)), Math.min(this.y, (int) Math.round(y)));
    }

    @Override
    public Vector2i min(int x, int y) {
        return new SpongeVector2i(Math.min(this.x, x), Math.min(this.y, y));
    }

    @Override
    public Vector2i max(Vector2i v) {
        checkNotNull(v);
        return new SpongeVector2i(Math.max(x, v.getX()), Math.max(y, v.getY()));
    }

    @Override
    public Vector2i max(double x, double y) {
        return new SpongeVector2i(Math.max(this.x, (int) Math.round(x)), Math.max(this.y, (int) Math.round(y)));
    }

    @Override
    public Vector2i max(int x, int y) {
        return new SpongeVector2i(Math.max(this.x, x), Math.max(this.y, y));
    }

    @Override
    public int distanceSquared(Vector2i v) {
        checkNotNull(v);
        final int distanceX = this.x - v.getX();
        final int distanceY = this.y - v.getY();
        return distanceX * distanceX + distanceY * distanceY;
    }

    @Override
    public int distanceSquared(double x, double y) {
        final double distanceX = this.x - x;
        final double distanceY = this.y - y;
        return (int) Math.round(distanceX * distanceX + distanceY * distanceY);
    }

    @Override
    public int distanceSquared(int x, int y) {
        final int distanceX = this.x - x;
        final int distanceY = this.y - y;
        return distanceX * distanceX + distanceY * distanceY;
    }

    @Override
    public int distance(Vector2i v) {
        checkNotNull(v);
        return (int) Math.round(Math.sqrt(distanceSquared(v)));
    }

    @Override
    public int distance(double x, double y) {
        final double distanceX = this.x - x;
        final double distanceY = this.y - y;
        return (int) Math.round(Math.sqrt((int) Math.round(distanceX * distanceX + distanceY * distanceY)));
    }

    @Override
    public int distance(int x, int y) {
        final int distanceX = this.x - x;
        final int distanceY = this.y - y;
        return (int) Math.round(Math.sqrt(distanceX * distanceX + distanceY * distanceY));
    }

    @Override
    public int lengthSquared() {
        return x * x + y * y;
    }

    @Override
    public int length() {
        return (int) Math.round(Math.sqrt(x * x + y * y));
    }

    @Override
    public int getMinAxis() {
        if (x < y) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getMaxAxis() {
        if (x > y) {
            return 0;
        }
        return 1;
    }

    @Override
    public Vector3i toVector3() {
        return new SpongeVector3i(x, y, 0);
    }

    @Override
    public Vector3i toVector3(double z) {
        return new SpongeVector3i(x, y, (int) z);
    }

    @Override
    public Vector3i toVector3(int z) {
        return new SpongeVector3i(x, y, z);
    }

    @Override
    public int[] toArray() {
        return new int[] { x, y };
    }

    @Override
    public Vector2f toFloat() {
        return new SpongeVector2f(x, y);
    }

    @Override
    public Vector2d toDouble() {
        return new SpongeVector2d(x, y);
    }

    @Override
    public int compareTo(Vector2i v) {
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vector2i) {
            Vector2i v = (Vector2i) o;
            return x == v.getX() && y == v.getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public Vector2i clone() {
        return new SpongeVector2i(x, y);
    }
}
