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

class DefaultVector3f implements Vector3f {

    private static final long serialVersionUID = 3714823649760540104L;
    private final float x;
    private final float y;
    private final float z;

    public DefaultVector3f(final float x, final float y, final float z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public DefaultVector3f(final double x, final double y, final double z) {
        super();
        this.x = (float) x;
        this.y = (float) y;
        this.z = (float) z;
    }

    public DefaultVector3f(final Vector3f Vector3f) {
        super();
        this.x = Vector3f.getX();
        this.y = Vector3f.getY();
        this.z = Vector3f.getZ();
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
    public Vector3f add(final Vector3f v) {
        return add(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3f add(final float x, final float y, final float z) {
        return new DefaultVector3f(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3f add(final double x, final double y, final double z) {
        return new DefaultVector3f(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3f sub(final Vector3f v) {
        return sub(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3f sub(final float x, final float y, final float z) {
        return new DefaultVector3f(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3f sub(final double x, final double y, final double z) {
        return new DefaultVector3f(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3f mul(final float a) {
        return mul(a, a, a);
    }

    @Override
    public Vector3f mul(final double a) {
        return mul(a, a, a);
    }

    @Override
    public Vector3f mul(final Vector3f v) {
        return mul(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3f mul(final float x, final float y, final float z) {
        return new DefaultVector3f(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Vector3f mul(final double x, final double y, final double z) {
        return new DefaultVector3f(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Vector3f div(final float a) {
        return div(a, a, a);
    }

    @Override
    public Vector3f div(final double a) {
        return div(a, a, a);
    }

    @Override
    public Vector3f div(final Vector3f v) {
        return div(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3f div(final float x, final float y, final float z) {
        return new DefaultVector3f(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public Vector3f div(final double x, final double y, final double z) {
        return new DefaultVector3f(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public float dot(final Vector3f v) {
        return dot(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public float dot(final float x, final float y, final float z) {
        return this.x * x + this.y * y + this.z * z;
    }

    @Override
    public float dot(final double x, final double y, final double z) {
        return (float) (this.x * x + this.y * y + this.z * z);
    }

    @Override
    public Vector3f cross(final Vector3f v) {
        return cross(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3f cross(final float x, final float y, final float z) {
        return new DefaultVector3f(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    @Override
    public Vector3f cross(final double x, final double y, final double z) {
        return new DefaultVector3f(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    @Override
    public Vector3f project(final Vector3f v) {
        return v.mul(dot(x, y, z) / v.lengthSquared());
    }

    private Vector3f project(final Vector3d v) {
        return v.mul(dot(x, y, z) / v.lengthSquared()).toFloat();
    }

    @Override
    public Vector3f project(final float x, final float y, final float z) {
        return project(new DefaultVector3f(x, y, z));
    }

    @Override
    public Vector3f project(final double x, final double y, final double z) {
        return project(new DefaultVector3d(x, y, z));
    }

    @Override
    public Vector3f pow(final float power) {
        return new DefaultVector3f(Math.pow(this.x, power), Math.pow(this.y, power), Math.pow(this.z, power));
    }

    @Override
    public Vector3f pow(final double power) {
        return new DefaultVector3f(Math.pow(this.x, power), Math.pow(this.y, power), Math.pow(this.z, power));
    }

    @Override
    public Vector3f ceil() {
        return new DefaultVector3f(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));
    }

    @Override
    public Vector3f floor() {
        return new DefaultVector3f(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }

    @Override
    public Vector3f round() {
        return new DefaultVector3f(Math.round(this.x), Math.round(this.y), Math.round(this.z));
    }

    @Override
    public Vector3f abs() {
        return new DefaultVector3f(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    @Override
    public Vector3f negate() {
        return new DefaultVector3f(-this.x, -this.y, -this.z);
    }

    @Override
    public Vector3f min(final Vector3f v) {
        return min(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3f min(final float x, final float y, final float z) {
        return new DefaultVector3f(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    @Override
    public Vector3f min(final double x, final double y, final double z) {
        return new DefaultVector3f(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    @Override
    public Vector3f max(final Vector3f v) {
        return min(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3f max(final float x, final float y, final float z) {
        return new DefaultVector3f(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    @Override
    public Vector3f max(final double x, final double y, final double z) {
        return new DefaultVector3f(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    @Override
    public float distanceSquared(final Vector3f v) {
        return distanceSquared(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public float distanceSquared(final float x, final float y, final float z) {
        return lengthSquared(x - this.x, y - this.y, z - this.z);
    }

    @Override
    public float distanceSquared(final double x, final double y, final double z) {
        return (float) lengthSquared(x - this.x, y - this.y, z - this.z);
    }

    @Override
    public float distance(final Vector3f v) {
        return distance(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public float distance(final float x, final float y, final float z) {
        return (float) Math.sqrt(distanceSquared(x, y, z));
    }

    @Override
    public float distance(final double x, final double y, final double z) {
        return (float) Math.sqrt(distanceSquared(x, y, z));
    }

    @Override
    public float lengthSquared() {
        return lengthSquared(this.x, this.y, this.z);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    @Override
    public Vector3f normalize() {
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
    public Vector2f toVector2() {
        return toVector2(false);
    }

    @Override
    public Vector2f toVector2(final boolean useZ) {
        if (useZ) {
            return Vectors.create2f(x, z);
        } else {
            return Vectors.create2f(x, y);
        }
    }

    @Override
    public float[] toArray() {
        return new float[] { this.x, this.y, this.z };
    }

    @Override
    public Vector3i toInt() {
        return Vectors.create3i((int) Math.floor(this.x), (int) Math.floor(this.y), (int) Math.floor(this.z));
    }

    @Override
    public Vector3d toDouble() {
        return Vectors.create3d(this.x, this.y, this.z);
    }

    @Override
    public int compareTo(final Vector3f v) {
        int c = Float.compare(this.x, v.getX());
        if (c != 0) {
            return c;
        }
        c = Float.compare(this.y, v.getY());
        if (c != 0) {
            return c;
        }
        return Float.compare(this.z, v.getZ());
    }

    @Override
    public Vector3f clone() {
        return new DefaultVector3f(this);
    }

    private static double lengthSquared(final double x, final double y, final double z) {
        return x * x + y * y + z * z;
    }

    private static float lengthSquared(final float x, final float y, final float z) {
        return x * x + y * y + z * z;
    }

}
