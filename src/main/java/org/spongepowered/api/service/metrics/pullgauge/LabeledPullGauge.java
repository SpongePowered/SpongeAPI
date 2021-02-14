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

import io.prometheus.client.Collector.MetricFamilySamples.Sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public final class LabeledPullGauge<T> extends PullGauge<T> {
    private final MultiSampler<T> sampler;

    public LabeledPullGauge(String name, String unit, String help, MultiSampler<T> sampler) {
        super(name, unit, help);
        this.sampler = sampler;
    }

    @Override
    protected List<Sample> makeSamples(T subject) {
        final List<LabeledValue> values = sampler.apply(subject);
        List<Sample> samples = new ArrayList<>(values.size());
        for (LabeledValue labeledValue : values) {
            final Iterable<Label> labels = labeledValue.getLabels();
            final List<String> labelNames;
            final List<String> labelValues;
            if (labels instanceof Collection) {
                final int size = ((Collection<Label>) labels).size();
                labelNames = new ArrayList<>(size);
                labelValues = new ArrayList<>(size);
            } else {
                labelNames = new ArrayList<>();
                labelValues = new ArrayList<>();
            }
            for (Label label : labels) {
                labelNames.add(label.getName());
                labelValues.add(label.getValue());
            }

            samples.add(sample(labelNames, labelValues, labeledValue.getValue()));
        }

        return samples;
    }

    public interface Sampler<T> extends Function<T, LabeledValue> {
    }

    public interface MultiSampler<T> extends Function<T, List<LabeledValue>> {
    }
}
