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

import io.prometheus.client.Collector.MetricFamilySamples;
import io.prometheus.client.Collector.MetricFamilySamples.Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToDoubleFunction;

import static io.prometheus.client.Collector.Type.GAUGE;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public abstract class PullGauge<T> {
    private final String name;
    private final String unit;
    private final String help;

    public PullGauge(String name, String unit, String help) {
        this.name = name;
        this.unit = unit;
        this.help = help;
    }

    protected final Sample sample(List<String> labelNames, List<String> labelValues, double value) {
        return new Sample(name, labelNames, labelValues, value);
    }

    protected final Sample sample(double value) {
        return sample(emptyList(), emptyList(), value);
    }

    protected final MetricFamilySamples bundle(List<Sample> samples) {
        return new MetricFamilySamples(name, unit, GAUGE, help, samples);
    }

    protected abstract List<Sample> makeSamples(T subject);

    public final MetricFamilySamples sample(T subject) {
        return bundle(makeSamples(subject));
    }

    public final MetricFamilySamples sampleAll(Iterable<T> subjects) {
        List<Sample> samples;
        if (subjects instanceof Collection) {
            samples = new ArrayList<>(((Collection<T>) subjects).size());
        } else {
            samples = new ArrayList<>();
        }

        for (T subject : subjects) {
            samples.addAll(makeSamples(subject));
        }

        return bundle(samples);
    }

    public static <T> Builder<T> build(String name, ToDoubleFunction<T> f) {
        return new Builder<>("", "", (unit, help) -> new SimplePullGauge<>(name, unit, help, f));
    }

    public static <T> Builder<T> build(String name, LabeledPullGauge.Sampler<T> f) {
        return new Builder<>("", "", (unit, help) -> new LabeledPullGauge<>(name, unit, help, v -> singletonList(f.apply(v))));
    }

    public static <T> Builder<T> build(String name, LabeledPullGauge.MultiSampler<T> f) {
        return new Builder<>("", "", (unit, help) -> new LabeledPullGauge<>(name, unit, help, f));
    }

    public static final class Builder<T> {
        private final String unit;
        private final String help;
        private final BiFunction<String, String, PullGauge<T>> ctor;

        private Builder(String unit, String help, BiFunction<String, String, PullGauge<T>> ctor) {
            this.unit = unit;
            this.help = help;
            this.ctor = ctor;
        }

        public Builder<T> unit(String unit) {
            return new Builder<>(unit, help, ctor);
        }

        public Builder<T> help(String help) {
            return new Builder<>(unit, help, ctor);
        }

        public PullGauge<T> build() {
            return ctor.apply(unit, help);
        }
    }

    public static final class LabeledValue {
        private final double value;
        private final Iterable<Label> labels;

        public LabeledValue(double value, Iterable<Label> labels) {
            this.value = value;
            this.labels = labels;
        }

        public double getValue() {
            return value;
        }

        public Iterable<Label> getLabels() {
            return labels;
        }

        public static LabeledValue value(double value, Label... labels) {
            return value(value, Arrays.asList(labels));
        }

        public static LabeledValue value(double value, List<Label> labels) {
            return new LabeledValue(value, labels);
        }
    }

    public static final class Label {
        private final String name;
        private final String value;

        public Label(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public static Label label(String name, String value) {
            return new Label(name, value);
        }
    }
}
