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

package org.spongepowered.api.text;

import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.TextAction;

/**
 * Represents an instance that have a {@link Text} representation that should be
 * used when this instance should be used inside a {@link Text}.
 */
public interface TextRepresentable extends TextElement {

    /**
     * Gets the textual representation of this instance for its usage in other
     * {@link Text} objects. This may but does not need to include
     * {@link HoverAction hover texts} or other {@link TextAction actions}. This
     * method is basically the {@link Object#toString() toString()} equivalent
     * for {@link Text}s.
     *
     * @return The text instance representing this instance
     */
    Text toText();

    @Override
    default void applyTo(Text.Builder builder) {
        builder.append(toText());
    }

}
