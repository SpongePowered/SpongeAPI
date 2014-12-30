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

import org.spongepowered.api.entity.EntityType;

import com.flowpowered.math.vector.Vector3i;

/**
 * Represents a builder interface to create immutable {@link Selector}
 * instances.
 */
public interface SelectorBuilder {

    /**
     * Sets the type of this selector.
     *
     * @param type The type to set
     * @return This selector builder
     */
    SelectorBuilder type(SelectorType type);

    /**
     * Adds an argument to the arguments in this selector.
     *
     * @param key The argument key, like {@code r} for radius
     * @param value The argument value
     * @return This selector builder
     */
    SelectorBuilder addArgument(String key, String value);

    /**
     * Adds an argument to the arguments in this selector.
     *
     * @param key The argument key, like {@code r} for radius
     * @param value The argument value
     * @return This selector builder
     */
    SelectorBuilder addArgument(String key, int value);

    /**
     * Removes the specified argument, if it exists.
     *
     * @param key The argument key to remove
     * @return This selector builder
     */
    SelectorBuilder removeArgument(String key);

    /**
     * Sets the x, y, and z arguments. Equivalent to calling
     * {@link #addArgument(String, int)} for each part of the vector.
     *
     * @param center The values for the x, y, and z arguments
     * @return This selector builder
     */
    SelectorBuilder center(Vector3i center);

    /**
     * Sets the name argument. Equivalent to calling
     * {@link #name(String, boolean)} with {@code invert = false}.
     *
     * @param name The name to set
     * @return This selector builder
     */
    SelectorBuilder name(String name);

    /**
     * Sets the name argument. Equivalent to calling
     * {@link #addArgument(String, String)} with {@code "name"} and
     * {@code name}, with a ! before the name if {@code invert} is
     * true.
     *
     * @param name The name to set
     * @param invert If true, the argument will be inverted to select all but
     *        entities with the given name
     * @return This selector builder
     */
    SelectorBuilder name(String name, boolean invert);

    /**
     * Sets the team argument. Equivalent to calling
     * {@link #team(String, boolean)} with {@code invert = false}.
     *
     * @param team The team to set
     * @return This selector builder
     */
    SelectorBuilder team(String team);

    /**
     * Sets the team argument. Equivalent to calling
     * {@link #addArgument(String, String)} with {@code "team"} and
     * {@code team}, with a ! before the team if {@code invert} is
     * true.
     *
     * @param team The team to set
     * @param invert If true, the argument will be inverted to select all but
     *        members of the team
     * @return This selector builder
     */
    SelectorBuilder team(String team, boolean invert);

    /**
     * Sets the type argument. Equivalent to calling
     * {@link #type(EntityType, boolean)} with {@code invert = false}.
     *
     * @param type The entity type
     * @return This selector builder
     */
    SelectorBuilder type(EntityType type);

    /**
     * Sets the type argument. Equivalent to calling
     * {@link #addArgument(String, String)} with {@code "type"} and
     * {@link EntityType#getId()}, with a ! before the ID if {@code invert} is
     * true.
     *
     * @param type The entity type
     * @param invert If true, the argument will be inverted to select all but
     *        the type
     * @return This selector builder
     */
    SelectorBuilder type(EntityType type, boolean invert);

    /**
     * Builds an immutable instance of the current state of this selector
     * builder.
     *
     * @return An immutable {@link Selector} with the current properties of this
     *         builder
     */
    Selector build();

}
