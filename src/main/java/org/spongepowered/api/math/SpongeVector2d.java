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

public class SpongeVector2d implements Vector2d {
    static final long serialVersionUID = 1L;

    private static final double DBL_EPSILON = Double.longBitsToDouble(0x3cb0000000000000L);

    private final double x;
    private final double y;

    public SpongeVector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public long getFloorX() {
        return (long) Math.floor(x);
    }

    @Override
    public long getFloorY() {
        return (long) Math.floor(y);
    }

    @Override
    public Vector2d add(Vector2d v) {
        checkNotNull(v);
        return new SpongeVector2d(this.x + v.getX(), this.y + v.getY());
    }

    @Override
    public Vector2d add(double x, double y) {
        return new SpongeVector2d(this.x + x, this.y + y);
    }

    @Override
    public Vector2d sub(Vector2d v) {
        checkNotNull(v);
        return new SpongeVector2d(this.x - v.getX(), this.y - v.getY());
    }

    @Override
    public Vector2d sub(double x, double y) {
        return new SpongeVector2d(this.x - x, this.y - y);
    }

    @Override
    public Vector2d mul(double a) {
        return new SpongeVector2d(this.x * a, this.y * a);
    }

    @Override
    public Vector2d mul(Vector2d v) {
        checkNotNull(v);
        return new SpongeVector2d(this.x * v.getX(), this.y * v.getY());
    }

    @Override
    public Vector2d mul(double x, double y) {
        return new SpongeVector2d(this.x * x, this.y * y);
    }

    @Override
    public Vector2d div(double a) {
        return new SpongeVector2d(this.x / a, this.y / a);
    }

    @Override
    public Vector2d div(Vector2d v) {
        checkNotNull(v);
        return new SpongeVector2d(this.x / v.getX(), this.y / v.getY());
    }

    @Override
    public Vector2d div(double x, double y) {
        return new SpongeVector2d(this.x / x, this.y / y);
    }

    @Override
    public double dot(Vector2d v) {
        checkNotNull(v);
        return this.x * v.getX() + this.y * v.getY();
    }

    @Override
    public double dot(double x, double y) {
        return this.x * x + this.y * y;
    }

    @Override
    public Vector2d pow(double power) {
        return new SpongeVector2d(Math.pow(x, power), Math.pow(y, power));
    }

    @Override
    public Vector2d ceil() {
        return new SpongeVector2d(Math.ceil(x), Math.ceil(y));
    }

    @Override
    public Vector2d floor() {
        return new SpongeVector2d(Math.floor(x), Math.floor(y));
    }

    @Override
    public Vector2d round() {
        return new SpongeVector2d(Math.round(x), Math.round(y));
    }

    @Override
    public Vector2d abs() {
        return new SpongeVector2d(Math.abs(x), Math.abs(y));
    }

    @Override
    public Vector2d negate() {
        return new SpongeVector2d(-x, -y);
    }

    @Override
    public Vector2d min(Vector2d v) {
        checkNotNull(v);
        return new SpongeVector2d(Math.min(this.x, v.getX()), Math.min(this.y, v.getY()));
    }

    @Override
    public Vector2d min(double x, double y) {
        return new SpongeVector2d(Math.min(this.x, x), Math.min(this.y, y));
    }

    @Override
    public Vector2d max(Vector2d v) {
        checkNotNull(v);
        return new SpongeVector2d(Math.max(this.x, v.getX()), Math.max(this.y, v.getY()));
    }

    @Override
    public Vector2d max(double x, double y) {
        return new SpongeVector2d(Math.max(this.x, x), Math.max(this.y, y));
    }

    @Override
    public double distanceSquared(Vector2d v) {
        checkNotNull(v);
        final double distanceX = this.x - v.getX();
        final double distanceY = this.y - v.getY();
        return distanceX * distanceX + distanceY * distanceY;
    }

    @Override
    public double distanceSquared(double x, double y) {
        final double distanceX = this.x - x;
        final double distanceY = this.y - y;
        return distanceX * distanceX + distanceY * distanceY;
    }

    @Override
    public double distance(Vector2d v) {
        checkNotNull(v);
        final double distanceX = this.x - v.getX();
        final double distanceY = this.y - v.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    @Override
    public double distance(double x, double y) {
        final double distanceX = this.x - x;
        final double distanceY = this.y - y;
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    @Override
    public double lengthSquared() {
        return x * x + y * y;
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public Vector2d normalize() {
        double length = Math.sqrt(x * x + y * y);
        return new SpongeVector2d(x / length, y / length);
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
    public Vector3d toVector3() {
        return new SpongeVector3d(x, y, 0);
    }

    @Override
    public Vector3d toVector3(double z) {
        return new SpongeVector3d(x, y, z);
    }

    @Override
    public double[] toArray() {
        return new double[] { x, y };
    }

    @Override
    public Vector2i toInt() {
        return new SpongeVector2i((int) x, (int) y);
    }

    @Override
    public Vector2f toFloat() {
        return new SpongeVector2f((float) x, (float) y);
    }

    @Override
    public int compareTo(Vector2d v) {
        checkNotNull(v);
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vector2d) {
            Vector2d v = (Vector2d) o;
            return (Math.abs(x - v.getX()) < DBL_EPSILON) && (Math.abs(y - v.getY()) < DBL_EPSILON);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public Vector2d clone() {
        return new SpongeVector2d(x, y);
    }
}
