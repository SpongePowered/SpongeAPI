/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
package org.spongepowered.api.util;

import static java.util.Objects.requireNonNull;

import com.flowpowered.math.vector.Vector3d;

import java.util.Objects;

public final class RelativeVector3d {

    public static final RelativeVector3d ZERO_RELATIVE = new RelativeVector3d(
            RelativeDouble.ZERO_RELATIVE, RelativeDouble.ZERO_RELATIVE, RelativeDouble.ZERO_RELATIVE);
    public static final RelativeVector3d ZERO_ABSOLUTE = new RelativeVector3d(
            RelativeDouble.ZERO_ABSOLUTE, RelativeDouble.ZERO_ABSOLUTE, RelativeDouble.ZERO_ABSOLUTE);

    private final RelativeDouble x;
    private final RelativeDouble y;
    private final RelativeDouble z;

    public RelativeVector3d(Vector3d vector3d) {
        requireNonNull(vector3d, "vector3d");
        this.x = new RelativeDouble(vector3d.getX(), false);
        this.y = new RelativeDouble(vector3d.getY(), false);
        this.z = new RelativeDouble(vector3d.getZ(), false);
    }

    public RelativeVector3d(RelativeDouble x, RelativeDouble y, RelativeDouble z) {
        this.x = requireNonNull(x, "x");
        this.y = requireNonNull(y, "y");
        this.z = requireNonNull(z, "z");
    }

    /**
     * Gets whether at least one of the x, y or z
     * components is relative.
     *
     * @return Is relative
     */
    public boolean isRelative() {
        return this.x.isRelative() || this.y.isRelative() || this.z.isRelative();
    }

    /**
     * Gets the x component.
     *
     * @return The x component
     */
    public RelativeDouble getX() {
        return this.x;
    }

    /**
     * Gets the y component.
     *
     * @return The y component
     */
    public RelativeDouble getY() {
        return this.y;
    }

    /**
     * Gets the z component.
     *
     * @return The z component
     */
    public RelativeDouble getZ() {
        return this.z;
    }

    /**
     * Applies this {@link RelativeVector3d} to the {@link Vector3d}.
     *
     * @param value The value
     * @return The result value
     */
    public Vector3d applyToValue(Vector3d value) {
        double x = this.x.getValue();
        double y = this.y.getValue();
        double z = this.z.getValue();

        if (this.x.isRelative()) {
            x += value.getX();
        }
        if (this.y.isRelative()) {
            y += value.getY();
        }
        if (this.z.isRelative()) {
            z += value.getZ();
        }

        return new Vector3d(x, y, z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y, this.z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RelativeVector3d)) {
            return false;
        }
        final RelativeVector3d other = (RelativeVector3d) o;
        return this.x.equals(other.x) && this.y.equals(other.y) && this.z.equals(other.z);
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}
