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
package org.spongepowered.api.metrics;

import org.spongepowered.api.metrics.meter.Counter;
import org.spongepowered.api.metrics.meter.Gauge;
import org.spongepowered.api.metrics.meter.Histogram;
import org.spongepowered.api.metrics.meter.Timer;

public final class Meter {

    public static final MetricCollection DEFAULT = Meter.newCollection();

    private Meter() {
    }

    public static Counter.Builder newCounter() {
        return DEFAULT.newCounter();
    }

    public static Gauge.Builder newGauge() {
        return DEFAULT.newGauge();
    }

    public static Timer.Builder newTimer() {
        return DEFAULT.newTimer();
    }

    public static Histogram.Builder newHistogram() {
        return DEFAULT.newHistogram();
    }

    public static MetricCollection newCollection() {
        return new SimpleMetricCollection();
    }

}
