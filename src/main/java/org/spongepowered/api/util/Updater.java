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
package org.spongepowered.api.util;

/**
 * An updater that will take a {@code type} and update it
 * across different versions. Whether this is applicable to
 * serialization or object management is not required.
 *
 * @param <C> The type of object being updated
 */
public interface Updater<C> {

    /**
     * Gets the numerical {@code version} that this {@link Updater}
     * can accept.
     *
     * @return The numerical input version
     */
    int getInputVersion();

    /**
     * The outputted {@code version} that this {@link Updater} will
     * output to. Note that it is possible multiple updaters are able to
     * cross between different versions.
     *
     * @return The numerical output version
     */
    int getOutputVersion();

    /**
     * Attempts to update the content of {@code C} as long as the content
     * version itself has been abided by.
     *
     * @param content The content to update
     * @return The updated content
     */
    C update(C content);

}
