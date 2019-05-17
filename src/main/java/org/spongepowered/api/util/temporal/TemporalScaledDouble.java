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
package org.spongepowered.api.util.temporal;

import static java.util.Objects.requireNonNull;

import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;

/**
 * Represents a double that is affected by a
 * {@link TemporalAmount}.
 */
public final class TemporalScaledDouble implements TemporalScaledNumber<Double>, Comparable<TemporalScaledDouble> {

    /**
     * Represents a temporal scaled double value that is always 0.
     */
    public static final TemporalScaledDouble ZERO = of(Duration.ZERO, 0);

    /**
     * Constructs a new {@link TemporalScaledDouble} with the given unit and value.
     *
     * @param unit The temporal unit
     * @param value The value per unit of time
     * @return The temporal scaled double
     */
    public static TemporalScaledDouble of(TemporalUnit unit, double value) {
        return new TemporalScaledDouble(unit.getDuration(), value);
    }

    /**
     * Constructs a new {@link TemporalScaledDouble} with the given duration and value.
     *
     * @param duration The duration
     * @param value The value per unit of time (the duration)
     * @return The temporal scaled double
     */
    public static TemporalScaledDouble of(Duration duration, double value) {
        return new TemporalScaledDouble(duration, value);
    }

    // The number
    private final double value;

    // The duration this number is originally based on
    private final BigDecimal duration;

    private TemporalScaledDouble(Duration duration, double value) {
        requireNonNull(duration, "duration");
        this.duration = BigDecimal.valueOf(duration.getSeconds()).add(BigDecimal.valueOf(duration.getNano(), 9));
        this.value = value;
    }

    @Override
    public Double get(TemporalAmount temporalAmount) {
        return getDouble(temporalAmount);
    }

    /**
     * Gets the double value based on the given {@link TemporalUnit}.
     *
     * @param unit The temporal unit
     * @return The double value based on the temporal unit
     */
    public double getDouble(TemporalUnit unit) {
        return getDouble(unit.getDuration());
    }

    /**
     * Gets the double value based on the given {@link TemporalAmount}.
     *
     * @param amount The temporal amount
     * @return The double value based on the temporal amount
     */
    public double getDouble(TemporalAmount amount) {
        requireNonNull(amount, "amount");
        if (this.value == 0) { // Don't bother
            return 0;
        }
        // Convert the temporal amount to a duration so we can divide them
        final Duration divisor = amount instanceof Duration ? (Duration) amount : Duration.from(amount);
        // Calculate the scaling factor
        final BigDecimal newDurationValue = BigDecimal.valueOf(divisor.getSeconds()).add(BigDecimal.valueOf(divisor.getNano(), 9));
        final double scaleFactor = newDurationValue.divide(this.duration, RoundingMode.UNNECESSARY).doubleValue();
        // Rescale the value
        return scaleFactor * this.value;
    }

    @Override
    public int compareTo(TemporalScaledDouble o) {
        return Double.compare(getDouble(TemporalUnits.SECONDS), o.getDouble(TemporalUnits.SECONDS));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TemporalScaledDouble)) {
            return false;
        }
        final TemporalScaledDouble other = (TemporalScaledDouble) obj;
        return other.compareTo(this) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(getDouble(TemporalUnits.SECONDS));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .addValue(getDouble(TemporalUnits.SECONDS) + "/s")
                .toString();
    }
}
