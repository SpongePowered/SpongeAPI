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
package org.spongepowered.api.service.persistence.data;

/**
 * Represents the options for a {@link DataContainer}. Options may include
 * things such as path separators.
 */
public interface DataOptions {

    /**
     * Gets the path separator.
     * <p>When performing a {@link DataView#get(String)}, the string is parsed
     * with the returning path separator, separating one {@link DataView} from
     * it's parent DataView.</p>
     *
     * @return The character representing a separator in a path
     */
    char getPathSeparator();

    /**
     * Sets the path separator.
     * <p>When performing a {@link DataView#get(String)}, the string is parsed
     * with the returning path separator, separating one {@link DataView} from
     * it's parent DataView.</p>
     *
     * @param separator The character to separate paths
     * @return This instance of options for chaining
     */
    DataOptions setPathSeparator(char separator);

    /**
     * Gets the container this set of options is affecting. No container can
     * exist without a form of DataOptions.
     *
     * @return The container this set of options affects
     */
    DataContainer getContainer();

}
