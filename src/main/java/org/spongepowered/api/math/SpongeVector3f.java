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

public class SpongeVector3f implements Vector3f {
    static final long serialVersionUID = 1L;

    private static final float FLT_EPSILON = Float.intBitsToFloat(0x34000000);

    private final float x;
    private final float y;
    private final float z;

    public SpongeVector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    public float getZ() {
        return z;
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
    public int getFloorZ() {
        return (int) Math.floor(z);
    }

    @Override
    public Vector3f add(Vector3f v) {
        checkNotNull(v);
        return new SpongeVector3f(this.x + v.getX(), this.y + v.getY(), this.z + v.getZ());
    }

    @Override
    public Vector3f add(double x, double y, double z) {
        return new SpongeVector3f(this.x + (float) x, this.y + (float) y, this.z + (float) z);
    }

    @Override
    public Vector3f add(float x, float y, float z) {
        return new SpongeVector3f(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3f sub(Vector3f v) {
        checkNotNull(v);
        return new SpongeVector3f(this.x - v.getX(), this.y - v.getY(), this.z - v.getZ());
    }

    @Override
    public Vector3f sub(double x, double y, double z) {
        return new SpongeVector3f(this.x - (float) x, this.y - (float) y, this.z - (float) z);
    }

    @Override
    public Vector3f sub(float x, float y, float z) {
        return new SpongeVector3f(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3f mul(double a) {
        return new SpongeVector3f(this.x * (float) a, this.y * (float) a, this.z * (float) a);
    }

    @Override
    public Vector3f mul(float a) {
        return new SpongeVector3f(this.x * a, this.y * a, this.z * a);
    }

    @Override
    public Vector3f mul(Vector3f v) {
        checkNotNull(v);
        return new SpongeVector3f(this.x * v.getX(), this.y * v.getY(), this.z * v.getZ());
    }

    @Override
    public Vector3f mul(double x, double y, double z) {
        return new SpongeVector3f(this.x * (float) x, this.y * (float) y, this.z * (float) z);
    }

    @Override
    public Vector3f mul(float x, float y, float z) {
        return new SpongeVector3f(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Vector3f div(double a) {
        return new SpongeVector3f(this.x / (float) a, this.y / (float) a, this.z / (float) a);
    }

    @Override
    public Vector3f div(float a) {
        return new SpongeVector3f(this.x / a, this.y / a, this.z / a);
    }

    @Override
    public Vector3f div(Vector3f v) {
        checkNotNull(v);
        return new SpongeVector3f(this.x / v.getX(), this.y / v.getY(), this.z / v.getZ());
    }

    @Override
    public Vector3f div(double x, double y, double z) {
        return new SpongeVector3f(this.x / (float) x, this.y / (float) y, this.z / (float) z);
    }

    @Override
    public Vector3f div(float x, float y, float z) {
        return new SpongeVector3f(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public float dot(Vector3f v) {
        checkNotNull(v);
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    @Override
    public float dot(double x, double y, double z) {
        return this.x * (float) x + this.y * (float) y + this.z * (float) z;
    }

    @Override
    public float dot(float x, float y, float z) {
        return this.x * x + this.y * y + this.z * z;
    }

    @Override
    public Vector3f cross(Vector3f v) {
        checkNotNull(v);
        return new SpongeVector3f(this.y * v.getZ() - this.z * v.getY(), this.z * v.getX() - this.x * v.getZ(),
                this.x * v.getY() - this.y * v.getX());
    }

    @Override
    public Vector3f cross(double x, double y, double z) {
        return new SpongeVector3f(this.y * (float) z - this.z * (float) y, this.z * (float) x - this.x * (float) z,
                this.x * (float) y - this.y * (float) x);
    }

    @Override
    public Vector3f cross(float x, float y, float z) {
        return new SpongeVector3f(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    @Override
    public Vector3f pow(double pow) {
        return new SpongeVector3f((float) Math.pow(x, pow), (float) Math.pow(y, pow), (float) Math.pow(z, pow));
    }

    @Override
    public Vector3f pow(float power) {
        return new SpongeVector3f((float) Math.pow(x, power), (float) Math.pow(y, power), (float) Math.pow(z, power));
    }

    @Override
    public Vector3f ceil() {
        return new SpongeVector3f((float) Math.ceil(x), (float) Math.ceil(y), (float) Math.ceil(z));
    }

    @Override
    public Vector3f floor() {
        return new SpongeVector3f((float) Math.floor(x), (float) Math.floor(y), (float) Math.floor(z));
    }

    @Override
    public Vector3f round() {
        return new SpongeVector3f((float) Math.round(x), (float) Math.round(y), (float) Math.round(z));
    }

    @Override
    public Vector3f abs() {
        return new SpongeVector3f(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3f negate() {
        return new SpongeVector3f(-x, -y, -z);
    }

    @Override
    public Vector3f min(Vector3f v) {
        checkNotNull(v);
        return new SpongeVector3f(Math.min(this.x, v.getX()), Math.min(this.y, v.getY()), Math.min(this.z, v.getZ()));
    }

    @Override
    public Vector3f min(double x, double y, double z) {
        return new SpongeVector3f((float) Math.min(this.x, x), (float) Math.min(this.y, y), (float) Math.min(this.z, z));
    }

    @Override
    public Vector3f min(float x, float y, float z) {
        return new SpongeVector3f(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    @Override
    public Vector3f max(Vector3f v) {
        checkNotNull(v);
        return new SpongeVector3f(Math.max(this.x, v.getX()), Math.max(this.y, v.getY()), Math.max(this.z, v.getZ()));
    }

    @Override
    public Vector3f max(double x, double y, double z) {
        return new SpongeVector3f((float) Math.max(this.x, x), (float) Math.max(this.y, y), (float) Math.max(this.z, z));
    }

    @Override
    public Vector3f max(float x, float y, float z) {
        return new SpongeVector3f(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    @Override
    public float distanceSquared(Vector3f v) {
        checkNotNull(v);
        return distanceSquared(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public float distanceSquared(double x, double y, double z) {
        return (float) (this.x * x + this.y * y + this.z * z);
    }

    @Override
    public float distanceSquared(float x, float y, float z) {
        return this.x * x + this.y * y + this.z * z;
    }

    @Override
    public float distance(Vector3f v) {
        checkNotNull(v);
        return distance(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public float distance(double x, double y, double z) {
        return (float) Math.sqrt(this.x * x + this.y * y + this.z * z);
    }

    @Override
    public float distance(float x, float y, float z) {
        return (float) Math.sqrt(this.x * x + this.y * y + this.z * z);
    }

    @Override
    public float lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public Vector3f normalize() {
        final float length = (float) Math.sqrt(x * x + y * y + z * z);
        return new SpongeVector3f(x / length, y / length, z / length);
    }

    @Override
    public int getMinAxis() {
        if (x < y) {
            if (x < z) {
                return 0;
            }
        } else if (y < z) {
            return 1;
        }
        return 2;
    }

    @Override
    public int getMaxAxis() {
        if (x > y) {
            if (x > z) {
                return 0;
            }
        } else if (y > z) {
            return 1;
        }
        return 2;
    }

    @Override
    public Vector2f toVector2() {
        return new SpongeVector2f(x, y);
    }

    @Override
    public Vector2f toVector2(boolean useZ) {
        if (useZ) {
            return new SpongeVector2f(x, z);
        } else {
            return new SpongeVector2f(x, y);
        }
    }

    @Override
    public float[] toArray() {
        return new float[] { x, y, z };
    }

    @Override
    public Vector3i toInt() {
        return new SpongeVector3i((int) x, (int) y, (int) z);
    }

    @Override
    public Vector3d toDouble() {
        return new SpongeVector3d(x, y, z);
    }

    @Override
    public int compareTo(Vector3f v) {
        checkNotNull(v);
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vector3f) {
            Vector3f v = (Vector3f) o;
            return (Math.abs(x - v.getX()) < .001) && (Math.abs(y - v.getY()) < FLT_EPSILON)
                    && (Math.abs(z - v.getZ()) < FLT_EPSILON);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = (x != +0.0f ? Float.floatToIntBits(x) : 0);
        result = 31 * result + (y != +0.0f ? Float.floatToIntBits(y) : 0);
        result = 31 * result + (z != +0.0f ? Float.floatToIntBits(z) : 0);
        return result;
    }

    @Override
    public Vector3f clone() {
        return new SpongeVector3f(x, y, z);
    }
}
