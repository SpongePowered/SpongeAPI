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

class DefaultVector2d implements Vector2d {

    private static final long serialVersionUID = 3714823649760540104L;
    private final double x;
    private final double y;

    public DefaultVector2d(final double x, final double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public DefaultVector2d(final Vector2d vector2d) {
        super();
        this.x = vector2d.getX();
        this.y = vector2d.getY();
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
    public Vector2d add(final Vector2d v) {
        return add(v.getX(), v.getY());
    }

    @Override
    public Vector2d add(final double x, final double y) {
        return new DefaultVector2d(this.x + x, this.y + y);
    }

    @Override
    public Vector2d sub(final Vector2d v) {
        return sub(v.getX(), v.getY());
    }

    @Override
    public Vector2d sub(final double x, final double y) {
        return new DefaultVector2d(this.x - x, this.y - y);
    }

    @Override
    public Vector2d mul(final double a) {
        return mul(a, a);
    }

    @Override
    public Vector2d mul(final Vector2d v) {
        return mul(v.getX(), v.getY());
    }

    @Override
    public Vector2d mul(final double x, final double y) {
        return new DefaultVector2d(this.x * x, this.y * y);
    }

    @Override
    public Vector2d div(final double a) {
        return div(a, a);
    }

    @Override
    public Vector2d div(final Vector2d v) {
        return div(v.getX(), v.getY());
    }

    @Override
    public Vector2d div(final double x, final double y) {
        return new DefaultVector2d(this.x / x, this.y / y);
    }

    @Override
    public double dot(final Vector2d v) {
        return dot(v.getX(), v.getY());
    }

    @Override
    public double dot(final double x, final double y) {
        return this.x * x + this.y * y;
    }

    @Override
    public Vector2d project(final Vector2d v) {
        return v.mul(dot(x, y) / v.lengthSquared());
    }

    @Override
    public Vector2d project(final double x, final double y) {
        return project(new DefaultVector2d(x, y));
    }

    @Override
    public Vector2d pow(final double power) {
        return new DefaultVector2d(Math.pow(this.x, power), Math.pow(this.y, power));
    }

    @Override
    public Vector2d ceil() {
        return new DefaultVector2d(Math.ceil(this.x), Math.ceil(this.y));
    }

    @Override
    public Vector2d floor() {
        return new DefaultVector2d(Math.floor(this.x), Math.floor(this.y));
    }

    @Override
    public Vector2d round() {
        return new DefaultVector2d(Math.round(this.x), Math.round(this.y));
    }

    @Override
    public Vector2d abs() {
        return new DefaultVector2d(Math.abs(this.x), Math.abs(this.y));
    }

    @Override
    public Vector2d negate() {
        return new DefaultVector2d(-this.x, -this.y);
    }

    @Override
    public Vector2d min(final Vector2d v) {
        return min(v.getX(), v.getY());
    }

    @Override
    public Vector2d min(final double x, final double y) {
        return new DefaultVector2d(Math.min(this.x, x), Math.min(this.y, y));
    }

    @Override
    public Vector2d max(final Vector2d v) {
        return min(v.getX(), v.getY());
    }

    @Override
    public Vector2d max(final double x, final double y) {
        return new DefaultVector2d(Math.max(this.x, x), Math.max(this.y, y));
    }

    @Override
    public double distanceSquared(final Vector2d v) {
        return distanceSquared(v.getX(), v.getY());
    }

    @Override
    public double distanceSquared(final double x, final double y) {
        return lengthSquared(x - this.x, y - this.y);
    }

    @Override
    public double distance(final Vector2d v) {
        return distance(v.getX(), v.getY());
    }

    @Override
    public double distance(final double x, final double y) {
        return Math.sqrt(distanceSquared(x, y));
    }

    @Override
    public double lengthSquared() {
        return lengthSquared(this.x, this.y);
    }

    @Override
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    @Override
    public Vector2d normalize() {
        return div(length());
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
    public Vector3d toVector3() {
        return toVector3(0);
    }

    @Override
    public Vector3d toVector3(final double z) {
        return Vectors.create3d(this.x, this.y, z);
    }

    @Override
    public double[] toArray() {
        return new double[] { this.x, this.y };
    }

    @Override
    public Vector2i toInt() {
        return Vectors.create2i((int) Math.floor(this.x), (int) Math.floor(this.y));
    }

    @Override
    public Vector2f toFloat() {
        return Vectors.create2f((float) this.x, (float) this.y);
    }

    @Override
    public int compareTo(final Vector2d v) {
        final int c = Double.compare(this.x, v.getX());
        if (c != 0) {
            return c;
        }
        return Double.compare(this.y, v.getY());
    }

    @Override
    public Vector2d clone() {
        return new DefaultVector2d(this);
    }

    private static double lengthSquared(final double x, final double y) {
        return x * x + y * y;
    }

}
