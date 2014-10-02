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

public class SpongeVector3i implements Vector3i {
    static final long serialVersionUID = 1L;

    private final int x;
    private final int y;
    private final int z;

    public SpongeVector3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
    public Vector3i add(Vector3i v) {
        checkNotNull(v);
        return new SpongeVector3i(this.x + v.getX(), this.y + v.getY(), this.z + v.getZ());
    }

    @Override
    public Vector3i add(double x, double y, double z) {
        return new SpongeVector3i(this.x + (int) Math.round(x), this.y + (int) Math.round(y),
                this.z + (int) Math.round(z));
    }

    @Override
    public Vector3i add(int x, int y, int z) {
        return new SpongeVector3i(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3i sub(Vector3i v) {
        checkNotNull(v);
        return new SpongeVector3i(this.x - v.getX(), this.y - v.getY(), this. z - v.getZ());
    }

    @Override
    public Vector3i sub(double x, double y, double z) {
        return new SpongeVector3i(this.x - (int) Math.round(x), this.y - (int) Math.round(y),
                this.z - (int) Math.round(z));
    }

    @Override
    public Vector3i sub(int x, int y, int z) {
        return new SpongeVector3i(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3i mul(double a) {
        return new SpongeVector3i((int) Math.round(this.x * a), (int) Math.round(this.y * a),
                (int) Math.round(this.z * a));
    }

    @Override
    public Vector3i mul(int a) {
        return new SpongeVector3i(this.x * a, this.y * a, this.z * a);
    }

    @Override
    public Vector3i mul(Vector3i v) {
        checkNotNull(v);
        return new SpongeVector3i(this.x * v.getX(), this.y * v.getY(), this.z * v.getZ());
    }

    @Override
    public Vector3i mul(double x, double y, double z) {
        return new SpongeVector3i((int) Math.round(this.x * x), (int) Math.round(this.y * y),
                (int) Math.round(this.z * z));
    }

    @Override
    public Vector3i mul(int x, int y, int z) {
        return new SpongeVector3i(this.x * x, this.y * y, this.z * z);
    }

    @Override
    public Vector3i div(double a) {
        return new SpongeVector3i((int) Math.round(this.x / a), (int) Math.round(this.y / a),
                (int) Math.round(this.z / a));
    }

    @Override
    public Vector3i div(int a) {
        return new SpongeVector3i(this.x / a, this.y / a, this.z / a);
    }

    @Override
    public Vector3i div(Vector3i v) {
        checkNotNull(v);
        return new SpongeVector3i(this.x / v.getX(), this.y / v.getY(), this.z / v.getZ());
    }

    @Override
    public Vector3i div(double x, double y, double z) {
        return new SpongeVector3i((int) Math.round(this.x / x), (int) Math.round(this.y / y),
                (int) Math.round(this.z / z));
    }

    @Override
    public Vector3i div(int x, int y, int z) {
        return new SpongeVector3i(this.x / x, this.y / y, this.z / z);
    }

    @Override
    public int dot(Vector3i v) {
        checkNotNull(v);
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    @Override
    public int dot(double x, double y, double z) {
        return (int) Math.round(this.x * x + this.y * y + this.z * z);
    }

    @Override
    public int dot(int x, int y, int z) {
        return this.x * x + this.y * y + this.z * z;
    }

    @Override
    public Vector3i cross(Vector3i v) {
        checkNotNull(v);
        return new SpongeVector3i(this.y * v.getZ() - this.z * v.getY(), this.z * v.getX() - this.x * v.getZ(),
                this.x * v.getY() - this.y * v.getX());
    }

    @Override
    public Vector3i cross(double x, double y, double z) {
        return new SpongeVector3i((int) (this.y * z - this.z * y), (int) (this.z * x - this.x * z),
                (int) (this.x * y - this.y * x));
    }

    @Override
    public Vector3i cross(int x, int y, int z) {
        return new SpongeVector3i(this.y * z - this.z * y, this.z * x - this.x * z, this.x * y - this.y * x);
    }

    @Override
    public Vector3i pow(double pow) {
        return new SpongeVector3i((int) Math.pow(x, pow), (int) Math.pow(y, pow), (int) Math.pow(z, pow));
    }

    @Override
    public Vector3i pow(int power) {
        return new SpongeVector3i((int) Math.pow(x, power), (int) Math.pow(y, power), (int) Math.pow(z, power));
    }

    @Override
    public Vector3i abs() {
        return new SpongeVector3i(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3i negate() {
        return new SpongeVector3i(Math.abs(x), Math.abs(y), Math.abs(z));
    }

    @Override
    public Vector3i min(Vector3i v) {
        checkNotNull(v);
        return new SpongeVector3i(-x, -y, -z);
    }

    @Override
    public Vector3i min(double x, double y, double z) {
        return new SpongeVector3i(Math.min(this.x, (int) Math.round(x)), Math.min(this.y, (int) Math.round(y)),
                Math.min(this.z, (int) Math.round(z)));
    }

    @Override
    public Vector3i min(int x, int y, int z) {
        return new SpongeVector3i(Math.min(this.x, x), Math.min(this.y, y), Math.min(this.z, z));
    }

    @Override
    public Vector3i max(Vector3i v) {
        checkNotNull(v);
        return new SpongeVector3i(Math.max(this.x, v.getX()), Math.max(this.y, v.getY()), Math.max(this.z, v.getZ()));
    }

    @Override
    public Vector3i max(double x, double y, double z) {
        return new SpongeVector3i(Math.max(this.x, (int) Math.round(x)), Math.max(this.y, (int) Math.round(y)),
                Math.max(this.z, (int) Math.round(z)));
    }

    @Override
    public Vector3i max(int x, int y, int z) {
        return new SpongeVector3i(Math.max(this.x, x), Math.max(this.y, y), Math.max(this.z, z));
    }

    @Override
    public int distanceSquared(Vector3i v) {
        checkNotNull(v);
        final int distanceX = this.x - v.getX();
        final int distanceY = this.y - v.getY();
        final int distanceZ = this.z - v.getZ();
        return distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;
    }

    @Override
    public int distanceSquared(double x, double y, double z) {
        final double distanceX = this.x - x;
        final double distanceY = this.y - y;
        final double distanceZ = this.z - z;
        return (int) Math.round(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
    }

    @Override
    public int distanceSquared(int x, int y, int z) {
        final int distanceX = this.x - x;
        final int distanceY = this.y - y;
        final int distanceZ = this.z - z;
        return distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;
    }

    @Override
    public int distance(Vector3i v) {
        checkNotNull(v);
        final int distanceX = this.x - v.getX();
        final int distanceY = this.y - v.getY();
        final int distanceZ = this.z - v.getZ();
        return (int) Math.round(Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ));
    }

    @Override
    public int distance(double x, double y, double z) {
        final double distanceX = this.x - x;
        final double distanceY = this.y - y;
        final double distanceZ = this.z - z;
        return (int) Math.round(Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ));
    }

    @Override
    public int distance(int x, int y, int z) {
        final int distanceX = this.x - x;
        final int distanceY = this.y - y;
        final int distanceZ = this.z - z;
        return (int) Math.round(Math.sqrt(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ));
    }

    @Override
    public int lengthSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public int length() {
        return (int) Math.round(Math.sqrt(x * x + y * y + z * z));
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
    public Vector2i toVector2() {
        return new SpongeVector2i(x, y);
    }

    @Override
    public Vector2i toVector2(boolean useZ) {
        if (useZ) {
            return new SpongeVector2i(x, z);
        } else {
            return new SpongeVector2i(x, y);
        }
    }

    @Override
    public int[] toArray() {
        return new int[] { x, y, z };
    }

    @Override
    public Vector3f toFloat() {
        return new SpongeVector3f(x, y, z);
    }

    @Override
    public Vector3d toDouble() {
        return new SpongeVector3d(x, y, z);
    }

    @Override
    public int compareTo(Vector3i v) {
        checkNotNull(v);
        return (int) Math.signum(lengthSquared() - v.lengthSquared());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vector3i) {
            Vector3i v = (Vector3i) o;
            return x == v.getX() && y == v.getY() && z == v.getZ();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    @Override
    public Vector3i clone() {
        return new SpongeVector3i(x, y, z);
    }
}
