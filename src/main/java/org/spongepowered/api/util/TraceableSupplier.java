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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;

import java.util.Arrays;

/**
 * A traceable {@link Supplier} can be used to track down the original source of
 * a malicious {@link Supplier}. Due to the callback functionality of suppliers
 * the stacktrace of the real exception is less useful. Instead the location
 * where the suppliers has been set is more important.
 *
 * @param <T> The type of supplied values
 */
public class TraceableSupplier<T> implements Supplier<T> {

    /**
     * Wraps the given supplier in a traceable supplier.
     *
     * @param <T> The type of supplied values
     * @param supplier The supplier to wrap
     * @return The traceable supplier
     */
    public static <T> Supplier<T> wrap(Supplier<T> supplier) {
        if (supplier instanceof TraceableSupplier) {
            return supplier;
        } else {
            return new TraceableSupplier<T>(supplier);
        }
    }

    private final StackTraceElement[] trace;
    private final Supplier<T> supplier;

    /**
     * Creates a new traceable supplier wrapping the given supplier.
     *
     * @param supplier The supplier to wrap
     */
    public TraceableSupplier(Supplier<T> supplier) {
        this(supplier, Thread.currentThread().getStackTrace());
    }

    /**
     * Creates a new traceable supplier wrapping the given supplier.
     *
     * @param supplier The supplier to wrap
     * @param trace The trace to keep track of
     */
    public TraceableSupplier(Supplier<T> supplier, StackTraceElement[] trace) {
        super();
        this.supplier = checkNotNull(supplier, "supplier");
        this.trace = checkNotNull(trace, "trace");
    }

    @Override
    public T get() {
        try {
            return this.supplier.get();
        } catch (Exception e) {
            throw new TraceableException("An error occured while trying to supply", e, this.supplier, this.trace);
        }
    }

    /**
     * Gets the parent supplier this supplier wraps.
     *
     * @return The parent supplier
     */
    public Supplier<T> getParent() {
        return this.supplier;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("supplier", this.supplier)
                .add("trace", Arrays.toString(this.trace))
                .toString();
    }

}
