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

public final class RelativeDouble {

    public static final RelativeDouble ZERO_RELATIVE = new RelativeDouble(0, true);
    public static final RelativeDouble ZERO_ABSOLUTE = new RelativeDouble(0, false);

    private final double value;
    private final boolean relative;

    public RelativeDouble(double value, boolean relative) {
        this.relative = relative;
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return The value
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Whether the value is relative.
     *
     * @return Is relative
     */
    public boolean isRelative() {
        return this.relative;
    }

    /**
     * Applies this {@link RelativeDouble} to the value.
     *
     * @param value The value
     * @return The result value
     */
    public double applyToValue(double value) {
        return this.relative ? value + this.value : this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RelativeDouble)) {
            return false;
        }
        final RelativeDouble other = (RelativeDouble) o;
        return other.relative == this.relative && Double.compare(this.value, other.value) == 0;
    }

    @Override
    public String toString() {
        return (this.relative ? "~" : "") + Double.toString(this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.relative);
    }
}
