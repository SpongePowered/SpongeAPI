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

import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

import java.util.List;

/**
 * Represents an immutable selector of targets, as used in commands.
 *
 * <p>In Vanilla, selectors are mostly represented as plain text, starting with
 * an {@code @} symbol and followed by a single character signifying the type,
 * and finally the (optional) arguments in brackets.</p> <p>As an example, the
 * all player selector is {@code @a}, and with a radius of 20 it would be
 * {@code @a[r=20]}.</p>
 *
 * @see <a href="http://minecraft.gamepedia.com/Selector#Target_selectors">
 *      Target selectors on the Minecraft Wiki</a>
 */
public interface Selector {

    /**
     * Returns the type of this {@link Selector}.
     *
     * @return The type of this selector
     */
    SelectorType getType();

    /**
     * Returns the argument value for the specified {@link ArgumentType} in this
     * {@link Selector}.
     *
     * @param type The argument type
     * @param <T> The type of the value
     * @return The value of the argument, if available
     */
    <T> Optional<T> get(ArgumentType<T> type);

    /**
     * Returns the {@link Argument} for the specified {@link ArgumentType} in
     * this {@link Selector}.
     *
     * @param type The argument type
     * @param <T> The type of the argument value
     * @return The argument, if available
     */
    <T> Optional<Argument<T>> getArgument(ArgumentType<T> type);

    /**
     * Returns the arguments for this {@link Selector}.
     *
     * @return The arguments for this {@link Selector}
     */
    List<Argument<?>> getArguments();

    /**
     * Resolves this {@link Selector} to a list of entities around (0|0|0) in
     * the given {@link Extent}.
     *
     * @param extent The extent to search for targets
     * @return The matched entities
     */
    List<Entity> resolve(Extent extent);

    /**
     * Resolves this {@link Selector} to a list of entities around the given
     * {@link Location}.
     *
     * @param location The location to resolve the selector around
     * @return The matched entities
     */
    List<Entity> resolve(Location location);

    /**
     * Converts this {@link Selector} to a valid selector string.
     *
     * @return A valid {@link Selector} string that can be inserted into a
     *         command
     */
    String toPlain();

    /**
     * Returns a new {@link SelectorBuilder} with the content of this selector.
     * This can be used to edit an immutable {@link Selector} instance.
     *
     * @return A new selector builder with the content of this selector
     */
    SelectorBuilder builder();

}
