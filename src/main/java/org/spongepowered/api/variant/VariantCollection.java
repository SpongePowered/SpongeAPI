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
package org.spongepowered.api.variant;

import org.spongepowered.api.data.Property;

import java.util.Collection;
import java.util.Optional;

/**
 * Represents a collection of {@link VarietyQueryable}s that can be filtered
 * using a {@link VarietyQuery}.
 *
 * @param <T> The variety queryable object type
 */
public interface VariantCollection<T extends VarietyQueryable> {

    /**
     * Gets a {@link VariantCollection} with all
     * the {@link T}s that match the {@link VarietyQuery}.
     *
     * @param query The variety query
     * @return A new variant collection with the matches
     */
    VariantCollection<T> query(VarietyQuery query);

    /**
     * Gets a {@link VariantCollection} with all
     * the {@link T}s that match the {@link Variety}.
     *
     * @param variety The variety
     * @return A new variant collection with the matches
     */
    VariantCollection<T> query(Variety variety);

    /**
     * Gets a {@link VariantCollection} with all
     * the {@link T}s that match the {@link Property property}.
     *
     * @param property The property
     * @return A new variant collection with the matches
     */
    VariantCollection<T> query(Property<?, ?> property);

    /**
     * Gets the first {@link T} that matches
     * the {@link VarietyQuery}.
     *
     * @param query The variety query
     * @return The catalog type, if present
     */
    Optional<T> queryFirst(VarietyQuery query);

    /**
     * Gets the first {@link T} that matches
     * the {@link Variety}.
     *
     * @param variety The variety
     * @return The catalog type, if present
     */
    Optional<T> queryFirst(Variety variety);

    /**
     * Gets the first {@link T} that matches
     * the {@link Property}.
     *
     * @param property The property
     * @return The catalog type, if present
     */
    Optional<T> queryFirst(Property<?, ?> property);

    /**
     * Gets the first {@link T} within this collection.
     *
     * @return The first catalog type, if present
     */
    Optional<T> first();

    /**
     * Gets all the {@link T} within this collection.
     *
     * @return The collection with all the catalog types
     */
    Collection<T> all();
}
