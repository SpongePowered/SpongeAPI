/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
 * Processes {@link org.spongepowered.api.component.ComponentHolder}s who have certain {@link org.spongepowered.api.component.Component}s.
 */
public interface ComponentSystem<H extends ComponentHolder> {
    /**
     * Gets the {@link org.spongepowered.api.component.Filter} that will determine which {@link org.spongepowered.api.component.ComponentHolder}s to process.
     *
     * @return The filter
     */
    Filter getFilter();

    /**
     * Returns if this system should invoke {@link ComponentSystem#process(org.spongepowered.api.component.ComponentHolder, float)}
     *
     * Useful for systems where you want to process them at a manual rate.
     *
     * @return True to process, false to not
     */
    boolean shouldProcess();

    /**
     * Offers a {@link org.spongepowered.api.component.ComponentHolder} to the system to be processed.
     *
     * @param holder The holder
     * @return True if this holder will be processed (or is already being processed by this processor) or false if not
     */
    boolean offer(H holder);

    /**
     * Instructs the system to determine if {@link org.spongepowered.api.component.ComponentHolder} is still processable.
     *
     * If the holder isn't being processed by this system, this is ignored. If the holder is no longer valid, it will be
     * removed.
     *
     * @param holder The holder in question
     */
    void update(H holder);

    /**
     * Called before {@link ComponentSystem#process(ComponentHolder, float)}.
     */
    void preProcess();

    /**
     * Processes all {@link org.spongepowered.api.component.ComponentHolder} in this system.
     *
     * @param holder The holder being processed
     * @param dt Time since the last processing
     */
    void process(H holder, float dt);

    /**
     * Called after {@link ComponentSystem#process(ComponentHolder, float)}.
     */
    void postProcess();

    /**
     * Gets all {@link org.spongepowered.api.component.ComponentHolder}s being processed by this system.
     * @return The collection of holders
     */
    Collection<H> getAll();
}
