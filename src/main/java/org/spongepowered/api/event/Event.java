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

package org.spongepowered.api.event;

import org.spongepowered.api.Game;

/**
 * A game event. A game event can be any sort of event from anywhere, and can be anything.
 */
public interface Event {

    /**
     * Gets the {@link Game}.
     *
     * @return The game
     */
    Game getGame();

    /**
     * Gets a simple name of the current class.
     *
     * @return String name
     */
    String getSimpleName();

    /**
     * Gets if the {@link Event} can be cancelled.
     *
     * @return Can this event be cancelled
     */
    boolean isCancellable();

    /**
     * Gets if the {@link Event} has been cancelled.
     *
     * @return Is this event cancelled
     */
    boolean isCancelled();

    /**
     * Sets the cancelled state of the {@link Event}.
     *
     * @param cancel the new cancelled state
     */
    void setCancelled(boolean cancel);

    /**
     * Gets the {@link Result} of the {@link Event}.
     *
     * @return The result of this event
     */
    Result getResult();

    /**
     * Sets the {@link Result} of the {@link Event}.
     *
     * @param result The result
     */
    void setResult(Result result);

}
