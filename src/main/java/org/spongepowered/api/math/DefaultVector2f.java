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

class DefaultVector2f implements Vector2f {

    private static final long serialVersionUID = 3714823649760540104L;
    private final float x;
    private final float y;

    public DefaultVector2f(final float x, final float y) {
        super();
        this.x = x;
        this.y = y;
    }

    public DefaultVector2f(final double x, final double y) {
        super();
        this.x = (float) x;
        this.y = (float) y;
    }

    public DefaultVector2f(final Vector2f vector2f) {
        super();
        this.x = vector2f.getX();
        this.y = vector2f.getY();
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public int getFloorX() {
        return (int) Math.floor(x);
    }

    @Override
    public int getFloorY() {
        return (int) Math.floor(y);
    }

    @Override
    public Vector2f add(final Vector2f v) {
        return add(v.getX(), v.getY());
    }

    @Override
    public Vector2f add(final float x, final float y) {
        return new DefaultVector2f(this.x + x, this.y + y);
    }

    @Override
    public Vector2f add(final double x, final double y) {
        return new DefaultVector2f(this.x + x, this.y + y);
    }

    @Override
    public Vector2f sub(final Vector2f v) {
        return sub(v.getX(), v.getY());
    }

    @Override
    public Vector2f sub(final float x, final float y) {
        return new DefaultVector2f(this.x - x, this.y - y);
    }

    @Override
    public Vector2f sub(final double x, final double y) {
        return new DefaultVector2f(this.x - x, this.y - y);
    }

    @Override
    public Vector2f mul(final float a) {
        return mul(a, a);
    }

    @Override
    public Vector2f mul(final double a) {
        return mul(a, a);
    }

    @Override
    public Vector2f mul(final Vector2f v) {
        return mul(v.getX(), v.getY());
    }

    @Override
    public Vector2f mul(final float x, final float y) {
        return new DefaultVector2f(this.x * x, this.y * y);
    }

    @Override
    public Vector2f mul(final double x, final double y) {
        return new DefaultVector2f(this.x * x, this.y * y);
    }

    @Override
    public Vector2f div(final float a) {
        return div(a, a);
    }

    @Override
    public Vector2f div(final double a) {
        return div(a, a);
    }

    @Override
    public Vector2f div(final Vector2f v) {
        return div(v.getX(), v.getY());
    }

    @Override
    public Vector2f div(final float x, final float y) {
        return new DefaultVector2f(this.x / x, this.y / y);
    }

    @Override
    public Vector2f div(final double x, final double y) {
        return new DefaultVector2f(this.x / x, this.y / y);
    }

    @Override
    public float dot(final Vector2f v) {
        return dot(v.getX(), v.getY());
    }

    @Override
    public float dot(final float x, final float y) {
        return this.x * x + this.y * y;
    }

    @Override
    public float dot(final double x, final double y) {
        return (float) (this.x * x + this.y * y);
    }

    @Override
    public Vector2f project(final Vector2f v) {
        return v.mul(dot(x, y) / v.lengthSquared());
    }

    private Vector2f project(final Vector2d v) {
        return v.mul(dot(x, y) / v.lengthSquared()).toFloat();
    }

    @Override
    public Vector2f project(final float x, final float y) {
        return project(new DefaultVector2f(x, y));
    }

    @Override
    public Vector2f project(final double x, final double y) {
        return project(new DefaultVector2d(x, y));
    }

    @Override
    public Vector2f pow(final float power) {
        return new DefaultVector2f(Math.pow(this.x, power), Math.pow(this.y, power));
    }

    @Override
    public Vector2f pow(final double power) {
        return new DefaultVector2f(Math.pow(this.x, power), Math.pow(this.y, power));
    }

    @Override
    public Vector2f ceil() {
        return new DefaultVector2f(Math.ceil(this.x), Math.ceil(this.y));
    }

    @Override
    public Vector2f floor() {
        return new DefaultVector2f(Math.floor(this.x), Math.floor(this.y));
    }

    @Override
    public Vector2f round() {
        return new DefaultVector2f(Math.round(this.x), Math.round(this.y));
    }

    @Override
    public Vector2f abs() {
        return new DefaultVector2f(Math.abs(this.x), Math.abs(this.y));
    }

    @Override
    public Vector2f negate() {
        return new DefaultVector2f(-this.x, -this.y);
    }

    @Override
    public Vector2f min(final Vector2f v) {
        return min(v.getX(), v.getY());
    }

    @Override
    public Vector2f min(final float x, final float y) {
        return new DefaultVector2f(Math.min(this.x, x), Math.min(this.y, y));
    }

    @Override
    public Vector2f min(final double x, final double y) {
        return new DefaultVector2f(Math.min(this.x, x), Math.min(this.y, y));
    }

    @Override
    public Vector2f max(final Vector2f v) {
        return min(v.getX(), v.getY());
    }

    @Override
    public Vector2f max(final float x, final float y) {
        return new DefaultVector2f(Math.max(this.x, x), Math.max(this.y, y));
    }

    @Override
    public Vector2f max(final double x, final double y) {
        return new DefaultVector2f(Math.max(this.x, x), Math.max(this.y, y));
    }

    @Override
    public float distanceSquared(final Vector2f v) {
        return distanceSquared(v.getX(), v.getY());
    }

    @Override
    public float distanceSquared(final float x, final float y) {
        return lengthSquared(x - this.x, y - this.y);
    }

    @Override
    public float distanceSquared(final double x, final double y) {
        return (float) lengthSquared(x - this.x, y - this.y);
    }

    @Override
    public float distance(final Vector2f v) {
        return distance(v.getX(), v.getY());
    }

    @Override
    public float distance(final float x, final float y) {
        return (float) Math.sqrt(distanceSquared(x, y));
    }

    @Override
    public float distance(final double x, final double y) {
        return (float) Math.sqrt(distanceSquared(x, y));
    }

    @Override
    public float lengthSquared() {
        return lengthSquared(this.x, this.y);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public Vector2f normalize() {
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
    public Vector3f toVector3() {
        return toVector3(0);
    }

    @Override
    public Vector3f toVector3(final float z) {
        return Vectors.create3f(x, y, z);
    }

    @Override
    public Vector3f toVector3(final double z) {
        return toVector3((float) z);
    }

    @Override
    public float[] toArray() {
        return new float[] { this.x, this.y };
    }

    @Override
    public Vector2i toInt() {
        return Vectors.create2i((int) Math.floor(this.x), (int) Math.floor(this.y));
    }

    @Override
    public Vector2d toDouble() {
        return Vectors.create2d(this.x, this.y);
    }

    @Override
    public int compareTo(final Vector2f v) {
        final int c = Float.compare(this.x, v.getX());
        if (c != 0) {
            return c;
        }
        return Float.compare(this.y, v.getY());
    }

    @Override
    public Vector2f clone() {
        return new DefaultVector2f(this);
    }

    private static double lengthSquared(final double x, final double y) {
        return x * x + y * y;
    }

    private static float lengthSquared(final float x, final float y) {
        return x * x + y * y;
    }

}
