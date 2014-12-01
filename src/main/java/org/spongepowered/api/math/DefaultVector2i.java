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

class DefaultVector2i implements Vector2i {

    private static final long serialVersionUID = 3714823649760540104L;
    private final int x;
    private final int y;

    public DefaultVector2i(final int x, final int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public DefaultVector2i(final double x, final double y) {
        super();
        this.x = (int) x;
        this.y = (int) y;
    }

    public DefaultVector2i(final Vector2i vector2i) {
        super();
        this.x = vector2i.getX();
        this.y = vector2i.getY();
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
    public Vector2i add(final Vector2i v) {
        return add(v.getX(), v.getY());
    }

    @Override
    public Vector2i add(final int x, final int y) {
        return new DefaultVector2i(this.x + x, this.y + y);
    }

    @Override
    public Vector2i add(final double x, final double y) {
        return new DefaultVector2i(this.x + x, this.y + y);
    }

    @Override
    public Vector2i sub(final Vector2i v) {
        return sub(v.getX(), v.getY());
    }

    @Override
    public Vector2i sub(final int x, final int y) {
        return new DefaultVector2i(this.x - x, this.y - y);
    }

    @Override
    public Vector2i sub(final double x, final double y) {
        return new DefaultVector2i(this.x - x, this.y - y);
    }

    @Override
    public Vector2i mul(final int a) {
        return mul(a, a);
    }

    @Override
    public Vector2i mul(final double a) {
        return mul(a, a);
    }

    @Override
    public Vector2i mul(final Vector2i v) {
        return mul(v.getX(), v.getY());
    }

    @Override
    public Vector2i mul(final int x, final int y) {
        return new DefaultVector2i(this.x * x, this.y * y);
    }

    @Override
    public Vector2i mul(final double x, final double y) {
        return new DefaultVector2i(this.x * x, this.y * y);
    }

    @Override
    public Vector2i div(final int a) {
        return div(a, a);
    }

    @Override
    public Vector2i div(final double a) {
        return div(a, a);
    }

    @Override
    public Vector2i div(final Vector2i v) {
        return div(v.getX(), v.getY());
    }

    @Override
    public Vector2i div(final int x, final int y) {
        return new DefaultVector2i(this.x / x, this.y / y);
    }

    @Override
    public Vector2i div(final double x, final double y) {
        return new DefaultVector2i(this.x / x, this.y / y);
    }

    @Override
    public int dot(final Vector2i v) {
        return dot(v.getX(), v.getY());
    }

    @Override
    public int dot(final int x, final int y) {
        return this.x * x + this.y * y;
    }

    @Override
    public int dot(final double x, final double y) {
        return (int) (this.x * x + this.y * y);
    }

    @Override
    public Vector2i project(final Vector2i v) {
        return v.mul(dot(x, y) / v.lengthSquared());
    }

    private Vector2i project(final Vector2d v) {
        return v.mul(dot(x, y) / v.lengthSquared()).toInt();
    }

    @Override
    public Vector2i project(final int x, final int y) {
        return project(new DefaultVector2i(x, y));
    }

    @Override
    public Vector2i project(final double x, final double y) {
        return project(new DefaultVector2d(x, y));
    }

    @Override
    public Vector2i pow(final int power) {
        return new DefaultVector2i(Math.pow(this.x, power), Math.pow(this.y, power));
    }

    @Override
    public Vector2i pow(final double power) {
        return new DefaultVector2i(Math.pow(this.x, power), Math.pow(this.y, power));
    }

    @Override
    public Vector2i abs() {
        return new DefaultVector2i(Math.abs(this.x), Math.abs(this.y));
    }

    @Override
    public Vector2i negate() {
        return new DefaultVector2i(-this.x, -this.y);
    }

    @Override
    public Vector2i min(final Vector2i v) {
        return min(v.getX(), v.getY());
    }

    @Override
    public Vector2i min(final int x, final int y) {
        return new DefaultVector2i(Math.min(this.x, x), Math.min(this.y, y));
    }

    @Override
    public Vector2i min(final double x, final double y) {
        return new DefaultVector2i(Math.min(this.x, x), Math.min(this.y, y));
    }

    @Override
    public Vector2i max(final Vector2i v) {
        return min(v.getX(), v.getY());
    }

    @Override
    public Vector2i max(final int x, final int y) {
        return new DefaultVector2i(Math.max(this.x, x), Math.max(this.y, y));
    }

    @Override
    public Vector2i max(final double x, final double y) {
        return new DefaultVector2i(Math.max(this.x, x), Math.max(this.y, y));
    }

    @Override
    public int distanceSquared(final Vector2i v) {
        return distanceSquared(v.getX(), v.getY());
    }

    @Override
    public int distanceSquared(final int x, final int y) {
        return lengthSquared(x - this.x, y - this.y);
    }

    @Override
    public int distanceSquared(final double x, final double y) {
        return (int) lengthSquared(x - this.x, y - this.y);
    }

    @Override
    public int distance(final Vector2i v) {
        return distance(v.getX(), v.getY());
    }

    @Override
    public int distance(final int x, final int y) {
        return (int) Math.sqrt(distanceSquared(x, y));
    }

    @Override
    public int distance(final double x, final double y) {
        return (int) Math.sqrt(distanceSquared(x, y));
    }

    @Override
    public int lengthSquared() {
        return lengthSquared(this.x, this.y);
    }

    @Override
    public int length() {
        return (int) Math.sqrt(lengthSquared());
    }

    @Override
    public int getMinAxis() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMaxAxis() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Vector3i toVector3() {
        return toVector3(0);
    }

    @Override
    public Vector3i toVector3(final int z) {
        return Vectors.create3i(x, y, z);
    }

    @Override
    public Vector3i toVector3(final double z) {
        return toVector3((int) z);
    }

    @Override
    public int[] toArray() {
        return new int[] { this.x, this.y };
    }

    @Override
    public Vector2f toFloat() {
        return Vectors.create2f(this.x, this.y);
    }

    @Override
    public Vector2d toDouble() {
        return Vectors.create2d(this.x, this.y);
    }

    @Override
    public int compareTo(final Vector2i v) {
        final int c = Integer.compare(this.x, v.getX());
        if (c != 0) {
            return c;
        }
        return Integer.compare(this.y, v.getY());
    }
    @Override
    public Vector2i clone() {
        return new DefaultVector2i(this);
    }

    private static double lengthSquared(final double x, final double y) {
        return x * x + y * y;
    }

    private static int lengthSquared(final int x, final int y) {
        return x * x + y * y;
    }

}
