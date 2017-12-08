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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

/**
 * Represents a collection of {@link VarietyQueryable}s that can be filtered
 * using a {@link VarietyQuery}.
 *
 * @param <T> The variety queryable object type
 */
@SuppressWarnings("unchecked")
public interface VariantCollection<T extends VarietyQueryable> {

    /**
     * Creates a {@link Builder}.
     *
     * @param <T> The variety queryable type
     * @return The builder
     */
    static <T extends VarietyQueryable> Builder<T> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a {@link VariantCollection} for the given {@link Iterable}.
     *
     * @param iterable The iterable
     * @param <T> The variety queryable type
     * @return The variant collection
     */
    static <T extends VarietyQueryable> VariantCollection<T> of(Iterable<T> iterable) {
        return VariantCollection.<T>builder().addAll(iterable).build();
    }

    /**
     * Creates a {@link VariantCollection} for the given {@link Iterable}.
     *
     * @param queryables The queryables
     * @param <T> The variety queryable type
     * @return The variant collection
     */
    static <T extends VarietyQueryable> VariantCollection<T> of(T... queryables) {
        return VariantCollection.<T>builder().add(queryables).build();
    }

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
    default VariantCollection<T> query(Variety variety) {
        return query(VarietyQuery.of(variety));
    }

    /**
     * Gets a {@link VariantCollection} with all
     * the {@link T}s that match the {@link Variety} with
     * the specific {@link MatchOperator}.
     *
     * @param variety The variety
     * @param operator The operator
     * @return A new variant collection with the matches
     */
    default VariantCollection<T> query(Variety variety, MatchOperator operator) {
        return query(VarietyQuery.of(variety, operator));
    }

    /**
     * Gets a {@link VariantCollection} with all
     * the {@link T}s that match the {@link Property property}.
     *
     * @param property The property
     * @return A new variant collection with the matches
     */
    default VariantCollection<T> query(Property<?, ?> property) {
        return query(VarietyQuery.of(property));
    }

    /**
     * Gets the first {@link T} that matches
     * the {@link VarietyQuery}.
     *
     * @param query The variety query
     * @return The matched type, if present
     */
    Optional<T> queryFirst(VarietyQuery query);

    /**
     * Gets the first {@link T} that matches
     * the {@link Variety}.
     *
     * @param variety The variety
     * @return The matched type, if present
     */
    default Optional<T> queryFirst(Variety variety) {
        return queryFirst(VarietyQuery.of(variety));
    }

    /**
     * Gets the first {@link T} that matches the {@link Variety}
     * with the specific {@link MatchOperator}.
     *
     * @param variety The variety
     * @param operator The operator
     * @return The matched type, if present
     */
    default Optional<T> queryFirst(Variety variety, MatchOperator operator) {
        return queryFirst(VarietyQuery.of(variety, operator));
    }

    /**
     * Gets the first {@link T} that matches
     * the {@link Property}.
     *
     * @param property The property
     * @return The matched type, if present
     */
    default Optional<T> queryFirst(Property<?, ?> property) {
        return queryFirst(VarietyQuery.of(property));
    }

    /**
     * Gets the first {@link T} within this collection.
     *
     * @return The first matched type, if present
     */
    Optional<T> first();

    /**
     * Gets all the {@link T} within this collection.
     *
     * @return The collection with all the matched types
     */
    Collection<T> all();

    /**
     * A builder to create {@link VariantCollection}s.
     *
     * @param <T> The type of the variety queryable
     */
    interface Builder<T extends VarietyQueryable> extends ResettableBuilder<VariantCollection<T>, Builder<T>> {

        /**
         * Adds the {@link VarietyQueryable} object.
         *
         * @param queryable The queryable
         * @return This builder, for chaining
         */
        Builder<T> add(T queryable);

        /**
         * Adds the {@link VarietyQueryable} objects.
         *
         * @param queryables The queryables
         * @return This builder, for chaining
         */
        Builder<T> add(T... queryables);

        /**
         * Adds the {@link VarietyQueryable} objects.
         *
         * @param iterable The queryables iterable
         * @return This builder, for chaining
         */
        Builder<T> addAll(Iterable<T> iterable);

        /**
         * Adds the {@link VarietyQueryable} objects.
         *
         * @param iterator The queryables iterator
         * @return This builder, for chaining
         */
        Builder<T> addAll(Iterator<T> iterator);

        /**
         * Builds the {@link VariantCollection}.
         *
         * @return The variant collection
         */
        VariantCollection<T> build();
    }
}
