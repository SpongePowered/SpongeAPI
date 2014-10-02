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

public class SpongeVector2f implements Vector2f {
    static final long serialVersionUID = 1L;

    private static final float FLT_EPSILON = Float.intBitsToFloat(0x34000000);

    private final float x;
    private final float y;

    public SpongeVector2f(float x, float y) {
        this.x = x;
        this.y = y;
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
    public Vector2f add(Vector2f v) {
        checkNotNull(v);
        return new SpongeVector2f(this.x + v.getX(), this.y + v.getY());
    }

    @Override
    public Vector2f add(double x, double y) {
        return new SpongeVector2f(this.x + (float) x, this.y + (float) y);
    }

    @Override
    public Vector2f add(float x, float y) {
        return new SpongeVector2f(this.x + x, this.y + y);
    }

    @Override
    public Vector2f sub(Vector2f v) {
        checkNotNull(v);
        return new SpongeVector2f(this.x - v.getX(), this.y - v.getY());
    }

    @Override
    public Vector2f sub(double x, double y) {
        return new SpongeVector2f(this.x - (float) x, this.y - (float) y);
    }

    @Override
    public Vector2f sub(float x, float y) {
        return new SpongeVector2f(this.x - x, this.y - y);
    }

    @Override
    public Vector2f mul(double a) {
        return new SpongeVector2f(this.x * (float) a, this.y * (float) a);
    }

    @Override
    public Vector2f mul(float a) {
        return new SpongeVector2f(this.x * a, this.y * a);
    }

    @Override
    public Vector2f mul(Vector2f v) {
        checkNotNull(v);
        return new SpongeVector2f(this.x * v.getX(), this.y * v.getY());
    }

    @Override
    public Vector2f mul(double x, double y) {
        return new SpongeVector2f(this.x * (float) x, this.y * (float) y);
    }

    @Override
    public Vector2f mul(float x, float y) {
        return new SpongeVector2f(this.x * x, this.y * y);
    }

    @Override
    public Vector2f div(double a) {
        return new SpongeVector2f(this.x / (float) a, this.y / (float) a);
    }

    @Override
    public Vector2f div(float a) {
        return new SpongeVector2f(this.x / a, this.y / a);
    }

    @Override
    public Vector2f div(Vector2f v) {
        checkNotNull(v);
        return new SpongeVector2f(this.x / v.getX(), this.y / v.getY());
    }

    @Override
    public Vector2f div(double x, double y) {
        return new SpongeVector2f(this.x / (float) x, this.y / (float) y);
    }

    @Override
    public Vector2f div(float x, float y) {
        return new SpongeVector2f(this.x / x, this.y / y);
    }

    @Override
    public float dot(Vector2f v) {
        checkNotNull(v);
        return this.x * v.getX() + this.y + v.getY();
    }

    @Override
    public float dot(double x, double y) {
        return this.x * (float) x + this.y + (float) y;
    }

    @Override
    public float dot(float x, float y) {
        return this.x * x + this.y + y;
    }

    @Override
    public Vector2f pow(double pow) {
        return new SpongeVector2f((float) Math.pow(x, pow), (float) Math.pow(y, pow));
    }

    @Override
    public Vector2f pow(float power) {
        return new SpongeVector2f((float) Math.pow(x, power), (float) Math.pow(y, power));
    }

    @Override
    public Vector2f ceil() {
        return new SpongeVector2f((float) Math.ceil(x), (float) Math.ceil(y));
    }

    @Override
    public Vector2f floor() {
        return new SpongeVector2f((float) Math.floor(x), (float) Math.floor(y));
    }

    @Override
    public Vector2f round() {
        return new SpongeVector2f((float) Math.round(x), (float) Math.round(y));
    }

    @Override
    public Vector2f abs() {
        return new SpongeVector2f(Math.abs(x), Math.abs(y));
    }

    @Override
    public Vector2f negate() {
        return new SpongeVector2f(-x, -y);
    }

    @Override
    public Vector2f min(Vector2f v) {
        checkNotNull(v);
        return new SpongeVector2f(Math.min(this.x, v.getX()), Math.min(this.y, v.getY()));
    }

    @Override
    public Vector2f min(double x, double y) {
        return new SpongeVector2f(Math.min(this.x, (float) x), Math.min(this.y, (float) y));
    }

    @Override
    public Vector2f min(float x, float y) {
        return new SpongeVector2f(Math.min(this.x, x), Math.min(this.y, y));
    }

    @Override
    public Vector2f max(Vector2f v) {
        checkNotNull(v);
        return new SpongeVector2f(Math.max(this.x, v.getX()), Math.max(this.y, v.getY()));
    }

    @Override
    public Vector2f max(double x, double y) {
        return new SpongeVector2f(Math.max(this.x, (float) x), Math.max(this.y, (float) y));
    }

    @Override
    public Vector2f max(float x, float y) {
        return new SpongeVector2f(Math.max(this.x, x), Math.max(this.y, y));
    }

    @Override
    public float distanceSquared(Vector2f v) {
        checkNotNull(v);
        final float distanceX = this.x - v.getX();
        final float distanceY = this.y - v.getY();
        return distanceX * distanceX + distanceY * distanceY;
    }

    @Override
    public float distanceSquared(double x, double y) {
        final float distanceX = this.x - (float) x;
        final float distanceY = this.y - (float) y;
        return distanceX * distanceX + distanceY * distanceY;
    }

    @Override
    public float distanceSquared(float x, float y) {
        final float distanceX = this.x - x;
        final float distanceY = this.y - y;
        return distanceX * distanceX + distanceY * distanceY;
    }

    @Override
    public float distance(Vector2f v) {
        checkNotNull(v);
        final float distanceX = this.x - v.getX();
        final float distanceY = this.y - v.getY();
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    @Override
    public float distance(double x, double y) {
        final float distanceX = this.x - (float) x;
        final float distanceY = this.y - (float) y;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    @Override
    public float distance(float x, float y) {
        final float distanceX = this.x - x;
        final float distanceY = this.y - y;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    @Override
    public float lengthSquared() {
        return x * x + y * y;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    @Override
    public Vector2f normalize() {
        final float length = (float) Math.sqrt(x * x + y * y);
        return new SpongeVector2f(x / length, y / length);
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
    public Vector3f toVector3() {
        return new SpongeVector3f(x, y, 0);
    }

    @Override
    public Vector3f toVector3(double z) {
        return new SpongeVector3f(x, y, (float) z);
    }

    @Override
    public Vector3f toVector3(float z) {
        return new SpongeVector3f(x, y, z);
    }

    @Override
    public float[] toArray() {
        return new float[] { x, y };
    }

    @Override
    public Vector2i toInt() {
        return new SpongeVector2i((int) x, (int) y);
    }

    @Override
    public Vector2d toDouble() {
        return new SpongeVector2d(x, y);
    }

    @Override
    public int compareTo(Vector2f v) {
        checkNotNull(v);
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vector2f) {
            Vector2f v = (Vector2f) o;
            return (Math.abs(x - v.getX()) < FLT_EPSILON) && (Math.abs(y - v.getY()) < FLT_EPSILON);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }

    @Override
    public Vector2f clone() {
        return new SpongeVector2f(x, y);
    }
}
