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

import java.util.Objects;

/**
 * Represents an angle in the range of 0 (inclusive) to 360 (exclusive) degrees.
 */
public final class Angle {

    private static final double DEGREES_TO_RADIANS = Math.PI / 180.0;

    /**
     * Creates an {@link Angle} based on the provided angle in degrees.
     *
     * <p>Any angle that falls outside of the range 0 (inclusive) to
     * 360 (exclusive) degrees will be mapped to be within this range.
     * </p>
     *
     * @param degrees The angle in degrees.
     * @return The {@link Angle}
     */
    public static Angle fromDegrees(final double degrees) {
        return new Angle(degrees, degrees * Angle.DEGREES_TO_RADIANS);
    }

    /**
     * Creates an {@link Angle} based on the provided angle in degrees.
     *
     * <p>Any angle that falls outside of the range 0 (inclusive) to
     * 2*pi (exclusive) degrees will be mapped to be within this range.
     * </p>
     *
     * @param radians The angle in radians.
     * @return The {@link Angle}
     */
    public static Angle fromRadians(final double radians) {
        return new Angle(radians / Angle.DEGREES_TO_RADIANS, radians);
    }

    private final double degrees;
    private final double radians;

    private Angle(final double degrees, final double radians) {
        this.degrees = degrees;
        this.radians = radians;
    }

    /**
     * Gets this angle in degrees.
     *
     * @return The angle in degrees.
     */
    public double degrees() {
        return this.degrees;
    }

    /**
     * Gets this angle in radians.
     *
     * @return The angle in radians.
     */
    public double radians() {
        return this.radians;
    }

    // Note that radians and degrees should always have a 1-1 mapping,
    // so we'll just use degrees for checks.
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Angle angle = (Angle) o;
        return Double.compare(angle.degrees, this.degrees) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.degrees);
    }
}
