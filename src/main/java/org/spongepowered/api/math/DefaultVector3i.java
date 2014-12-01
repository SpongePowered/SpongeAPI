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

class DefaultVector3i implements Vector3i {

    private static final long serialVersionUID = 3714823649760540104L;
    private final int x;
    private final int y;
    private final int z;

    public DefaultVector3i(final int x, final int y, final int z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public DefaultVector3i(final double x, final double y, final double z) {
        super();
        this.x = (int) x;
        this.y = (int) y;
        this.z = (int) z;
    }

    public DefaultVector3i(final Vector3i vector3i) {
        super();
        this.x = vector3i.getX();
        this.y = vector3i.getY();
        this.z = vector3i.getZ();
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
    public int getZ() {
        return z;
    }

    @Override
    public Vector3i add(final Vector3i v) {
        return add(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3i add(final int x, final int y, final int z) {
        return new DefaultVector3i(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3i add(final double x, final double y, final double z) {
        return new DefaultVector3i(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3i sub(final Vector3i v) {
        return sub(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3i sub(final int x, final int y, final int z) {
        return new DefaultVector3i(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3i sub(final double x, final double y, final double z) {
        return new DefaultVector3i(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3i mul(final int a) {
        return mul(a, a, a);
    }

    @Override
    public Vector3i mul(final double a) {
        return mul(a, a, a);
    }

    @Override
    public Vector3i mul(final Vector3i v) {
        return mul(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3i mul(final int x, final int y, final int z) {
        return new DefaultVector3i(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Vector3i mul(final double x, final double y, final double z) {
        return new DefaultVector3i(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Vector3i div(final int a) {
        return div(a, a, a);
    }

    @Override
    public Vector3i div(final double a) {
        return div(a, a, a);
    }

    @Override
    public Vector3i div(final Vector3i v) {
        return div(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3i div(final int x, final int y, final int z) {
        return new DefaultVector3i(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public Vector3i div(final double x, final double y, final double z) {
        return new DefaultVector3i(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public int dot(final Vector3i v) {
        return dot(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public int dot(final int x, final int y, final int z) {
        return this.x * x + this.y * y + this.z * z;
    }

    @Override
    public int dot(final double x, final double y, final double z) {
        return (int) (this.x * x + this.y * y + this.z * z);
    }

    @Override
    public Vector3i cross(final Vector3i v) {
        return cross(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3i cross(final int x, final int y, final int z) {
        return new DefaultVector3i(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    @Override
    public Vector3i cross(final double x, final double y, final double z) {
        return new DefaultVector3i(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    @Override
    public Vector3i project(final Vector3i v) {
        return v.mul(dot(x, y, z) / v.lengthSquared());
    }

    private Vector3i project(final Vector3d v) {
        return v.mul(dot(x, y, z) / v.lengthSquared()).toInt();
    }

    @Override
    public Vector3i project(final int x, final int y, final int z) {
        return project(new DefaultVector3i(x, y, z));
    }

    @Override
    public Vector3i project(final double x, final double y, final double z) {
        return project(new DefaultVector3d(x, y, z));
    }

    @Override
    public Vector3i pow(final int power) {
        return new DefaultVector3i(Math.pow(this.x, power), Math.pow(this.y, power), Math.pow(this.z, power));
    }

    @Override
    public Vector3i pow(final double power) {
        return new DefaultVector3i(Math.pow(this.x, power), Math.pow(this.y, power), Math.pow(this.z, power));
    }

    @Override
    public Vector3i abs() {
        return new DefaultVector3i(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    @Override
    public Vector3i negate() {
        return new DefaultVector3i(-this.x, -this.y, -this.z);
    }

    @Override
    public Vector3i min(final Vector3i v) {
        return min(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3i min(final int x, final int y, final int z) {
        return new DefaultVector3i(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    @Override
    public Vector3i min(final double x, final double y, final double z) {
        return new DefaultVector3i(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    @Override
    public Vector3i max(final Vector3i v) {
        return min(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public Vector3i max(final int x, final int y, final int z) {
        return new DefaultVector3i(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    @Override
    public Vector3i max(final double x, final double y, final double z) {
        return new DefaultVector3i(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    @Override
    public double distanceSquared(final Vector3i v) {
        return distanceSquared(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public double distanceSquared(final int x, final int y, final int z) {
        return lengthSquared(x - this.x, y - this.y, z - this.z);
    }

    @Override
    public double distanceSquared(final double x, final double y, final double z) {
        return lengthSquared(x - this.x, y - this.y, z - this.z);
    }

    @Override
    public double distance(final Vector3i v) {
        return distance(v.getX(), v.getY(), v.getZ());
    }

    @Override
    public double distance(final int x, final int y, final int z) {
        return Math.sqrt(distanceSquared(x, y, z));
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
    public Vector2i toVector2() {
        return toVector2(false);
    }

    @Override
    public Vector2i toVector2(final boolean useZ) {
        if (useZ) {
            return Vectors.create2i(x, z);
        } else {
            return Vectors.create2i(x, y);
        }
    }

    @Override
    public int[] toArray() {
        return new int[] { this.x, this.y, this.z };
    }

    @Override
    public Vector3f toFloat() {
        return Vectors.create3f(this.x, this.y, this.z);
    }

    @Override
    public Vector3d toDouble() {
        return Vectors.create3d(this.x, this.y, this.z);
    }

    @Override
    public int compareTo(final Vector3i v) {
        int c = Integer.compare(this.x, v.getX());
        if (c != 0) {
            return c;
        }
        c = Integer.compare(this.y, v.getY());
        if (c != 0) {
            return c;
        }
        return Integer.compare(this.z, v.getZ());
    }
    @Override
    public Vector3i clone() {
        return new DefaultVector3i(this);
    }

    private static double lengthSquared(final double x, final double y, final double z) {
        return x * x + y * y + z * z;
    }

    private static int lengthSquared(final int x, final int y, final int z) {
        return x * x + y * y + z * z;
    }

}
