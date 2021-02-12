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
package org.spongepowered.api.service.metrics.pullgauge;

import io.prometheus.client.Collector;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.Collections.emptyList;

public class PullGaugeCollector<T> extends Collector {
    private final T root;
    private final List<Function<T, MetricFamilySamples>> gauges;

    public PullGaugeCollector(T root, List<Function<T, MetricFamilySamples>> gauges) {
        this.root = root;
        this.gauges = gauges;
    }

    @Override
    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> samples = new ArrayList<>(gauges.size());

        for (Function<T, MetricFamilySamples> gauge : gauges) {
            samples.add(gauge.apply(root));
        }

        return samples;
    }

    public static <T> Builder<T> build(T root) {
        return new Builder<>(root, emptyList());
    }

    public static final class Builder<T> {
        private final T root;
        private final List<Function<T, MetricFamilySamples>> gauges;

        public Builder(T root, List<Function<T, MetricFamilySamples>> gauges) {
            this.root = root;
            this.gauges = gauges;
        }

        public Builder<T> withGauge(PullGauge<T> gauge) {
            return withGauge(gauge::sample);
        }

        public <V> Builder<T> withGauge(PullGauge<V> gauge, Function<T, V> selector) {
            return withGauge(root -> gauge.sample(selector.apply(root)));
        }

        public <V> Builder<T> withMultiGauge(PullGauge<V> gauge, Function<T, Iterable<V>> selector) {
            return withGauge(root -> gauge.sampleAll(selector.apply(root)));
        }

        public Builder<T> withGauge(Function<T, MetricFamilySamples> gauge) {
            final ArrayList<Function<T, MetricFamilySamples>> newGauges = new ArrayList<>(gauges.size() + 1);
            newGauges.addAll(gauges);
            newGauges.add(gauge);
            return new Builder<>(root, newGauges);
        }

        public PullGaugeCollector<T> build() {
            return new PullGaugeCollector<>(root, gauges);
        }
    }
}
