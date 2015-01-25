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
     * Adds some arguments to this selector.
     *
     * @param arguments The arguments to add
     * @return This selector builder
     */
    SelectorBuilder add(Argument<?>... arguments);

    /**
     * Adds some arguments to this selector.
     *
     * @param arguments The arguments to add
     * @return This selector builder
     */
    SelectorBuilder add(Iterable<Argument<?>> arguments);

    /**
     * Adds a new {@link Argument} with the specified {@link ArgumentType} and
     * value to this selector.
     *
     * @param type The type of the argument
     * @param value The value of the argument
     * @param <T> The type of the argument value
     * @return This selector builder
     */
    <T> SelectorBuilder add(ArgumentType<T> type, T value);

    /**
     * Removes the specified arguments, if they exist.
     *
     * @param arguments The arguments to remove
     * @return This selector builder
     */
    SelectorBuilder remove(Argument<?>... arguments);

    /**
     * Removes the specified arguments, if they exist.
     *
     * @param arguments The arguments to remove
     * @return This selector builder
     */
    SelectorBuilder remove(Iterable<Argument<?>> arguments);

    /**
     * Removes the arguments with the specified {@link ArgumentType}, if they
     * exist.
     *
     * @param types The argument types
     * @return This selector builder
     */
    SelectorBuilder remove(ArgumentType<?>... types);

    /**
     * Builds an immutable instance of the current state of this selector
     * builder.
     *
     * @return An immutable {@link Selector} with the current properties of this
     *         builder
     */
    Selector build();

}
