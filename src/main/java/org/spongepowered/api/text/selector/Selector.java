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
package org.spongepowered.api.text.selector;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.Location;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Represents an immutable selector. A selector starts with the {@code @} symbol
 * and is followed by a single character signifying which selector is being used
 * (known as the type), and finally the optional arguments in brackets. For
 * example, the all player selector is {@code @a}, and with a radius of 20 it
 * would be {@code @a[r=20]}.
 *
 * @see <a
 *      href="http://minecraft.gamepedia.com/Selector#Target_selectors">Target
 *      Selectors on the Minecraft Wiki</a>
 */
public interface Selector {

    /**
     * Returns the type of this {@link Selector}.
     *
     * @return The type of this {@link Selector}
     */
    SelectorType getType();

    /**
     * Returns the arguments for this {@link Selector}.
     *
     * @return The arguments for this {@link Selector}
     */
    Map<String, String> getArguments();

    /**
     * Resolves this {@link Selector} to a list of entities based on the
     * arguments and type.
     *
     * @param location The location to resolve the selector around
     * @return A list of entities that were resolved from this {@link Selector}
     * @throws IllegalArgumentException If {@code location} is null and
     *         {@link #requiresLocation()} returned {@code true}
     */
    List<Entity> resolve(@Nullable Location location) throws IllegalArgumentException;

    /**
     * Returns {@code true} if this selector will require a location to resolve.
     *
     * @return {@code true} if this selector will require a location to resolve
     */
    boolean requiresLocation();

    /**
     * Converts this {@link Selector} to a valid selector string.
     *
     * @return A valid {@link Selector} string that can be inserted into a
     *         command
     */
    String asString();

    /**
     * Returns a new {@link SelectorBuilder} with the content of this selector.
     * This can be used to edit an immutable {@link Selector} instance.
     *
     * @return A new message builder with the content of this selector
     */
    SelectorBuilder builder();

}
