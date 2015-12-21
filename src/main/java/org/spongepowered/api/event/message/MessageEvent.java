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
package org.spongepowered.api.event.message;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.text.Text;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Describes events when a involving a {@link Text} message.
 */
public interface MessageEvent extends Event {

    /**
     * Gets the original {@link Text} message.
     *
     * @return The message if present, otherwise {@link Optional#empty()}
     */
    Optional<Text> getOriginalMessage();

    /**
     * Gets the new {@link Text} message.
     *
     * @return The new message if present, otherwise {@link Optional#empty()}
     */
    Optional<Text> getMessage();

    /**
     * Sets the new {@link Text} message.
     *
     * @param message The new message
     */
    void setMessage(@Nullable Text message);

}
