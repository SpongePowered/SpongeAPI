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

import java.util.Collection;

/**
 * Represents a builder interface to create immutable {@link Selector}
 * instances.
 */
public interface SelectorBuilder {

    /**
     * Sets the type of this selector.
     *
     * @param type
     *            The type to set
     * @return This selector builder
     */
    SelectorBuilder type(SelectorType type);

    /**
     * Adds an argument to the arguments in this selector.
     *
     * @param argument
     *            The argument to add
     * @return This selector builder
     */
    SelectorBuilder addArgument(Argument argument);
    
    /**
     * Adds some arguments to the arguments in this selector.
     *
     * @param arguments
     *            The arguments to add
     * @return This selector builder
     */
    SelectorBuilder addArguments(Argument... arguments);

    /**
     * Adds some arguments to the arguments in this selector.
     *
     * @param arguments
     *            The arguments to add
     * @return This selector builder
     */
    SelectorBuilder addArguments(Collection<Argument> arguments);

    /**
     * Removes the specified argument, if it exists.
     *
     * @param argument The argument to remove
     * @return This selector builder
     */
    SelectorBuilder removeArgument(Argument argument);

    /**
     * Builds an immutable instance of the current state of this selector
     * builder.
     *
     * @return An immutable {@link Selector} with the current properties of this
     *         builder
     */
    Selector build();

}
