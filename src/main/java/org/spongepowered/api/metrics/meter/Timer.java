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

import java.util.concurrent.Callable;
import java.util.function.Supplier;

@FunctionalInterface
public interface Timer {
    void observe(double seconds, Object... labels);

    default long now() {
        return System.nanoTime();
    }

    default RunningTimer start() {
        final long startTime = this.now();
        return () -> this.observe(this.now() - startTime);
    }

    default void time(Runnable f, Object... labels) {
        final long startTime = this.now();
        try {
            f.run();
        } finally {
            this.observe(this.now() - startTime, labels);
        }
    }

    default <T> T time(Supplier<T> f, Object... labels) {
        final long startTime = this.now();
        try {
            return f.get();
        } finally {
            this.observe(this.now() - startTime, labels);
        }
    }

    default <T> T time(Callable<T> f, Object... labels) throws Exception {
        final long startTime = this.now();
        try {
            return f.call();
        } finally {
            this.observe(this.now() - startTime, labels);
        }
    }

    interface RunningTimer extends AutoCloseable {
        void stop();

        @Override
        default void close() {
            this.stop();
        }
    }

    abstract class Builder extends MeterBuilder<Timer, Builder> {
    }
}
