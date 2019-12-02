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
package co.aikar.timings;

/**
 * Provides an ability to time sections of code within the server.
 */
public interface Timing extends AutoCloseable {

    /**
     * Starts timing the execution until {@link #stopTiming} is called.
     *
     * @return This timing, for chaining
     */
    Timing startTiming();

    /**
     * Stops timing and records the data. Propagates the data up to group
     * handlers. Will automatically be called when this timing is used with
     * try-with-resources.
     */
    void stopTiming();

    /**
     * Starts timing the execution until {@link #stopTiming} is called only if
     * called from the main server thread.
     */
    void startTimingIfSync();

    /**
     * Stops timing and records the data. Propagates the data up to group
     * handlers. Will automatically be called when this timing is used with
     * try-with-resources.
     *
     * <p>But only if called from the main server thread.</p>
     */
    void stopTimingIfSync();

    /**
     * Stops timing and disregards current timing data.
     */
    void abort();

    @Override
    void close();

}
