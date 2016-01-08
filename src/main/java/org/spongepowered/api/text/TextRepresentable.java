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
import org.spongepowered.api.text.format.TextStyles;

/**
 * Represents an instance that have a {@link Text} representation that should be
 * used when this instance should be displayed in chat or wrapped in
 * {@link Text} objects. Developers should use the default text representation
 * of this instance whenever they want to use this instance in chat. Only in
 * cases where the default representation does not fit the requirements of the
 * situation a different text representation may be used. However developers
 * should stick to the original text representation as closely as possible to
 * avoid inconsistent user experience.
 */
public interface TextRepresentable {

    /**
     * Gets the representation of this instance as a {@link Text}.
     *
     * <p>The resulting {@link Text} should contain of the following:</p>
     *
     * <ul>
     * <li>A formated name of this instance. The usage of
     * {@link TextStyles#OBFUSCATED} and TextStyles#STRIKETHROUGH} is
     * discouraged.</li>
     * <li>A {@link HoverAction} with more details concerning this instance or
     * its current state. This may but does not need to include the id, uuid,
     * the plain name, an image, a short description or other appropriate
     * details.</li>
     * <li>Optionally one or more other {@link TextAction} or similar things to
     * interact with this instance. Examples for this could be starting a
     * conversation with this instance, opening some kind of gui related to this
     * instance or proposing a command or keyword related to this instance.</li>
     * </ul>
     *
     * @return The text instance representing this instance
     */
    Text toText();

}
