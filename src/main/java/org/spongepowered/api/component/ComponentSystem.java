/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.component;

import java.util.Collection;

/**
 * Processes objects who have certain {@link org.spongepowered.api.component.Component}s.
 */
public interface ComponentSystem<H> {
    /**
     * Gets the {@link org.spongepowered.api.component.Filter} that will be used to determine which objects to process.
     *
     * @return The filter
     */
    Filter getFilter();

    /**
     * Returns if this system should invoke {@link ComponentSystem#process(Object, float)}.
     *
     * Useful for systems where you want to process them at a manual rate.
     *
     * @return True to process, false to not
     */
    boolean shouldProcess();

    /**
     * Offers an object to the system to be processed.
     *
     * @param holder The holder
     * @return True if this holder will be processed (or is already being processed by this processor) or false if not
     */
    boolean offer(H holder);

    /**
     * Called before {@link ComponentSystem#process(Object, float)}.
     */
    void preProcess();

    /**
     * Processes all objects in this system.
     *
     * @param holder The holder being processed
     * @param dt Time since the last processing
     */
    void process(H holder, float dt);

    /**
     * Called after {@link ComponentSystem#process(Object, float)}.
     */
    void postProcess();

    /**
     * Gets all objects being processed by this system.
     * @return The collection of holders
     */
    Collection<H> getAll();
}
