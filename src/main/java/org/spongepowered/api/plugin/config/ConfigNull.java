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
package org.spongepowered.api.plugin.config;

import javax.lang.model.type.NullType;

/**
 * Represents an element without a value, set type, or is equal to null.
 */
public interface ConfigNull extends ConfigPrimitive<NullType> {

    /**
     * Sets this element to be a {@link ConfigArray} of the given type.
     * 
     * @param type The type
     * @return The array
     */
    <T> ConfigArray<T> setArrayType(Class<T> type);

    /**
     * Sets this element to be a {@link ConfigObject}.
     * 
     * @return The object
     */
    ConfigObject setAsObject();

    /**
     * Sets this element to be a {@link ConfigPrimitive} of the given type.
     * 
     * @param type The type of primitive
     * @return The primitive
     */
    <T> ConfigPrimitive<T> setPrimitiveType(Class<T> type);
}
