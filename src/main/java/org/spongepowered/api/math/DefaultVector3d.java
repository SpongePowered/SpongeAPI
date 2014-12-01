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

class DefaultVector3d implements Vector3d {

    private static final long serialVersionUID = 3714823649760540104L;
    private final double x;
    private final double y;
    private final double z;

    public DefaultVector3d(final double x, final double y, final double z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public DefaultVector3d(final Vector3d vector3d) {
        super();
        this.x = vector3d.getX();
        this.y = vector3d.getY();
        this.z = vector3d.getZ();
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
    public double getZ() {
        return z;
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
    public long getFloorZ() {
        return (long) Math.floor(z);
    }

    @Override
    public Vector3d add(final Vector3d v) {
        return add(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3d add(final double x, final double y, final double z) {
        return new DefaultVector3d(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3d sub(final Vector3d v) {
        return sub(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3d sub(final double x, final double y, final double z) {
        return new DefaultVector3d(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3d mul(final double a) {
        return mul(a, a, a);
    }

    @Override
    public Vector3d mul(final Vector3d v) {
        return mul(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3d mul(final double x, final double y, final double z) {
        return new DefaultVector3d(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Vector3d div(final double a) {
        return div(a, a, a);
    }

    @Override
    public Vector3d div(final Vector3d v) {
        return div(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3d div(final double x, final double y, final double z) {
        return new DefaultVector3d(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public double dot(final Vector3d v) {
        return dot(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public double dot(final double x, final double y, final double z) {
        return this.x * x + this.y * y + this.z * z;
    }

    @Override
    public Vector3d cross(final Vector3d v) {
        return cross(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3d cross(final double x, final double y, final double z) {
        return new DefaultVector3d(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    @Override
    public Vector3d project(final Vector3d v) {
        return v.mul(dot(x, y, z) / v.lengthSquared());
    }

    @Override
    public Vector3d project(final double x, final double y, final double z) {
        return project(new DefaultVector3d(x, y, z));
    }

    @Override
    public Vector3d pow(final double power) {
        return new DefaultVector3d(Math.pow(this.x, power), Math.pow(this.y, power), Math.pow(this.z, power));
    }

    @Override
    public Vector3d ceil() {
        return new DefaultVector3d(Math.ceil(this.x), Math.ceil(this.y), Math.ceil(this.z));
    }

    @Override
    public Vector3d floor() {
        return new DefaultVector3d(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }

    @Override
    public Vector3d round() {
        return new DefaultVector3d(Math.round(this.x), Math.round(this.y), Math.round(this.z));
    }

    @Override
    public Vector3d abs() {
        return new DefaultVector3d(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    @Override
    public Vector3d negate() {
        return new DefaultVector3d(-this.x, -this.y, -this.z);
    }

    @Override
    public Vector3d min(final Vector3d v) {
        return min(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3d min(final double x, final double y, final double z) {
        return new DefaultVector3d(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    @Override
    public Vector3d max(final Vector3d v) {
        return min(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3d max(final double x, final double y, final double z) {
        return new DefaultVector3d(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    @Override
    public double distanceSquared(final Vector3d v) {
        return distanceSquared(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public double distanceSquared(final double x, final double y, final double z) {
        return lengthSquared(x - this.x, y - this.y, z - this.z);
    }

    @Override
    public double distance(final Vector3d v) {
        return distance(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public double distance(final double x, final double y, final double z) {
        return Math.sqrt(distanceSquared(x, y, z));
    }

    @Override
    public double lengthSquared() {
        return lengthSquared(this.x, this.y, this.z);
    }

    @Override
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    @Override
    public Vector3d normalize() {
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
    public Vector2d toVector2() {
        return toVector2(false);
    }

    @Override
    public Vector2d toVector2(final boolean useZ) {
        if (useZ) {
            return Vectors.create2d(x, z);
        } else {
            return Vectors.create2d(x, y);
        }
    }

    @Override
    public double[] toArray() {
        return new double[] { this.x, this.y, this.z };
    }

    @Override
    public Vector3i toInt() {
        return Vectors.create3i((int) Math.floor(this.x), (int) Math.floor(this.y), (int) Math.floor(this.z));
    }

    @Override
    public Vector3f toFloat() {
        return Vectors.create3f((float) this.x, (float) this.y, (float) this.z);
    }

    @Override
    public int compareTo(final Vector3d v) {
        int c = Double.compare(this.x, v.getX());
        if (c != 0) {
            return c;
        }
        c = Double.compare(this.y, v.getY());
        if (c != 0) {
            return c;
        }
        return Double.compare(this.z, v.getZ());
    }

    @Override
    public Vector3d clone() {
        return new DefaultVector3d(this);
    }

    private static double lengthSquared(final double x, final double y, final double z) {
        return x * x + y * y + z * z;
    }

}
