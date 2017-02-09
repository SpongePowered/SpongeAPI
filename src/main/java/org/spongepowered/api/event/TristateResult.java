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
package org.spongepowered.api.event;

/**
 * Used for events that require a tri-state {@link Result}.
 */
public interface TristateResult {

    enum Result {
        /**
         * Disallow the event from resolving.
         *
         * <p>Note: Normally, this means cancelling or reverting the default
         * behavior, but in some cases, especially when {@link #hasAllowResult}
         * is true, this could be default behavior.</p>
         */
        DENY,
        /**
         * Let the event resolve with its normal behavior, as if the event was
         * not handled at all.
         *
         * <p>Note: This will fall back to the "vanilla" behavior for this
         * event, or the plugin-defined behavior if it was originally created
         * by a plugin.</p>
         */
        DEFAULT,
        /**
         * Forcibly execute the action of this event when it resolves, even if
         * another condition would normally prevent this event from finishing
         * normally.
         *
         * <p>Note that not all events have an overridable behavior,
         * so {@link #hasAllowResult} should be checked before setting the
         * result to ALLOW.</p>
         */
        ALLOW
    }

    /**
     * Returns whether the
     * {@link TristateResult.Result#ALLOW} can be
     * used.
     *
     * @return Whether allow can be used
     */
    boolean hasAllowResult();

    /**
     * Returns the original {@link Result} of this event.
     *
     * @return The original result of this event
     */
    Result getOriginalResult();

    /**
     * Returns the {@link Result} of this event.
     *
     * @return The result of this event
     */
    Result getResult();

    /**
     * Sets the result value for this event.
     *
     * <p> Note: The functionality of setting the {@link Result} is defined on a
     * per-event basis.</p>
     *
     * @param value The new result
     * @throws IllegalStateException if
     *     {@link TristateResult.Result#ALLOW} is
     *     given, but {@link #hasAllowResult} is {@code false}
     */
    void setResult(Result value) throws IllegalStateException;
}
