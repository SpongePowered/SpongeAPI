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

public class SpongeVector3d implements Vector3d {
    static final long serialVersionUID = 1L;

    private static final double DBL_EPSILON = Double.longBitsToDouble(0x3cb0000000000000L);

    private final double x;
    private final double y;
    private final double z;

    public SpongeVector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = y;
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
    public Vector3d add(Vector3d v) {
        checkNotNull(v);
        return new SpongeVector3d(this.x + v.getX(), this.y + v.getY(), this.z + v.getZ());
    }

    @Override
    public Vector3d add(double x, double y, double z) {
        return new SpongeVector3d(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3d sub(Vector3d v) {
        checkNotNull(v);
        return new SpongeVector3d(this.x - v.getX(), this.y - v.getY(), this.z - v.getZ());
    }

    @Override
    public Vector3d sub(double x, double y, double z) {
        return new SpongeVector3d(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3d mul(double a) {
        return new SpongeVector3d(this.x * a, this.y * a, this.z * a);
    }

    @Override
    public Vector3d mul(Vector3d v) {
        checkNotNull(v);
        return new SpongeVector3d(this.x * v.getX(), this.y * v.getY(), this.z * v.getZ());
    }

    @Override
    public Vector3d mul(double x, double y, double z) {
        return new SpongeVector3d(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Vector3d div(double a) {
        return new SpongeVector3d(this.x / a, this.y / a, this.z / a);
    }

    @Override
    public Vector3d div(Vector3d v) {
        checkNotNull(v);
        return new SpongeVector3d(this.x / v.getX(), this.y / v.getY(), this.z / v.getZ());
    }

    @Override
    public Vector3d div(double x, double y, double z) {
        return new SpongeVector3d(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public double dot(Vector3d v) {
        checkNotNull(v);
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    @Override
    public double dot(double x, double y, double z) {
        return this.x * x + this.y * y + this.z * z;
    }

    @Override
    public Vector3d cross(Vector3d v) {
        checkNotNull(v);
        return new SpongeVector3d(this.y * v.getZ() - this.z * v.getY(), this.z * v.getX() - this.x * v.getZ(),
                this.x * v.getY() - this.y * v.getX());
    }

    @Override
    public Vector3d cross(double x, double y, double z) {
        return new SpongeVector3d(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    @Override
    public Vector3d pow(double power) {
        return new SpongeVector3d(Math.pow(x, power), Math.pow(y, power), Math.pow(z, power));
    }

    @Override
    public Vector3d ceil() {
        return new SpongeVector3d(Math.ceil(x), Math.ceil(y), Math.ceil(z));
    }

    @Override
    public Vector3d floor() {
        return new SpongeVector3d(Math.floor(x), Math.floor(y), Math.floor(z));
    }

    @Override
    public Vector3d round() {
        return new SpongeVector3d(Math.round(x), Math.round(y), Math.round(z));
    }

    @Override
    public Vector3d abs() {
        return new SpongeVector3d(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3d negate() {
        return new SpongeVector3d(-x, -y, -z);
    }

    @Override
    public Vector3d min(Vector3d v) {
        checkNotNull(v);
        return new SpongeVector3d(Math.min(this.x, v.getX()), Math.min(this.y, v.getY()), Math.min(this.z, v.getZ()));
    }

    @Override
    public Vector3d min(double x, double y, double z) {
        return new SpongeVector3d(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    @Override
    public Vector3d max(Vector3d v) {
        checkNotNull(v);
        return new SpongeVector3d(Math.max(this.x, v.getX()), Math.max(this.y, v.getY()), Math.max(this.z, v.getZ()));
    }

    @Override
    public Vector3d max(double x, double y, double z) {
        return new SpongeVector3d(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    @Override
    public double distanceSquared(Vector3d v) {
        checkNotNull(v);
        final double distanceX = this.x - v.getX();
        final double distanceY = this.y - v.getY();
        final double distanceZ = this.z - v.getZ();
        return distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;
    }

    @Override
    public double distanceSquared(double x, double y, double z) {
        final double distanceX = this.x - x;
        final double distanceY = this.y - y;
        final double distanceZ = this.z - z;
        return distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;
    }

    @Override
    public double distance(Vector3d v) {
        checkNotNull(v);
        final double distanceX = this.x - v.getX();
        final double distanceY = this.y - v.getY();
        final double distanceZ = this.z - v.getZ();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
    }

    @Override
    public double distance(double x, double y, double z) {
        final double distanceX = this.x - x;
        final double distanceY = this.y - y;
        final double distanceZ = this.z - z;
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
    }

    @Override
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public Vector3d normalize() {
        final double length = Math.sqrt(x * x + y * y + z * z);
        return new SpongeVector3d(x / length, y / length, z / length);
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
    public Vector2d toVector2() {
        return new SpongeVector2d(x, y);
    }

    @Override
    public Vector2d toVector2(boolean useZ) {
        if (useZ) {
            return new SpongeVector2d(x, z);
        } else {
            return new SpongeVector2d(x, y);
        }
    }

    @Override
    public double[] toArray() {
        return new double[] { x, y, z };
    }

    @Override
    public Vector3i toInt() {
        return new SpongeVector3i((int) x, (int) y, (int) z);
    }

    @Override
    public Vector3f toFloat() {
        return new SpongeVector3f((float) x, (float) y, (float) z);
    }

    @Override
    public int compareTo(Vector3d v) {
        checkNotNull(v);
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vector3d) {
            Vector3d v = (Vector3d) o;
            return (Math.abs(x - v.getX()) < DBL_EPSILON) && (Math.abs(y - v.getY()) < DBL_EPSILON)
                    && (Math.abs(z - v.getZ()) < DBL_EPSILON);
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
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public Vector3d clone() {
        return new SpongeVector3d(x, y, z);
    }
}
