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

package org.spongepowered.api.entity;

/**
 * Describes a type of entity.
 */
public interface EntityType {

    /**
     * Return the internal ID for the entity type.
     *
     * @return The id
     */
    String getId();

    /**
     * Checks whether this entity type does support the given feature class
     * (including interfaces). A feature class is supported if every
     * {@link Entity} of this entity type can be cast to the given feature
     * class. This means that every {@link Entity} that is spawned using this
     * entity type is an instance of either the given feature class or any
     * subclass of the feature class. This method will always return
     * <tt>true</tt> for {@link Entity}.class.
     *
     * @param featureClass The feature class or interface to check
     * @return True if every spawned entity is guaranteed to be an instance of
     *         the given feature class or any of its subclasses. False otherwise
     */
    boolean supportsFeatures(Class<?> featureClass);

}
