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
package org.spongepowered.api.metrics.meter;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Histogram extends Timer {
    abstract class Builder extends MeterBuilder<Histogram, Builder> {
        private double[] buckets;

        public Builder buckets(double... buckets) {
            this.buckets = buckets;
            return this;
        }

        /**
         * Set the upper bounds of buckets for the histogram with a linear sequence.
         */
        public Builder linearBuckets(double start, double width, int count) {
            buckets = new double[count];
            for (int i = 0; i < count; i++) {
                buckets[i] = start + i * width;
            }
            return this;
        }

        /**
         * Set the upper bounds of buckets for the histogram with an exponential sequence.
         */
        public Builder exponentialBuckets(double start, double factor, int count) {
            buckets = new double[count];
            for (int i = 0; i < count; i++) {
                buckets[i] = start * Math.pow(factor, i);
            }
            return this;
        }

        @Override
        protected final @NotNull Histogram build(Metadata metadata) {
            if (this.buckets == null || this.buckets.length == 0) {
                throw new IllegalStateException("buckets are required!");
            }
            return build(metadata, buckets);
        }

        protected abstract Histogram build(Metadata metadata, double[] buckets);
    }
}
