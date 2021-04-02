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
import org.spongepowered.api.metrics.meter.Metadata;
import org.spongepowered.api.metrics.meter.Timer;

public class NoOpMetricCollection implements MetricCollection {

    @Override
    public void subscribe(MetricSubscriber subscriber) {
    }

    @Override
    public void unsubscribe(MetricSubscriber subscriber) {
    }

    @Override
    public Counter newCounter(Metadata metadata) {
        return (by, labels) -> {};
    }

    @Override
    public Gauge newGauge(Metadata metadata) {
        return (value, labels) -> {};
    }

    @Override
    public Timer newTimer(Metadata metadata) {
        return (seconds, labels) -> {};
    }

    @Override
    public Histogram newHistogram(Metadata metadata, double[] buckets) {
        return (value, labels) -> {};
    }

}
