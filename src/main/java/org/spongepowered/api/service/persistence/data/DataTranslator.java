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
 * A translator that can translate {@link DataView}s into other types of data structures
 * for various uses, such as configurate's configuration node, or for implementation with
 * NBT.
 *
 * @param <T> The type of data structure to translate to and from
 */
public interface DataTranslator<T> {

    /**
     * Translates the given {@link DataView} into the type of data structure.
     *
     * @param container The container to translate
     * @return The data structure
     */
    T translateData(DataView container);

    /**
     * Translates the given {@link DataView} into the given data structure.
     *
     * <p>This assumes that the given data structure will be the top level node
     * of the data contained in the {@link DataView}.</p>
     *
     * @param node The node to store data
     * @param container The container of data to translate
     */
    void translateContainerToData(T node, DataView container);

    /**
     * Translates the given data structure into a usable {@link DataView} that
     * can be used with the rest of DataAPI.
     *
     * @param node The data structure containing raw data
     * @return The newly created and translated {@link DataView}
     */
    DataView translateFrom(T node);

}
