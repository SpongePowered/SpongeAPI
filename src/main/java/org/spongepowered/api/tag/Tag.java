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
package org.spongepowered.api.tag;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.registry.DefaultedRegistryValue;

import java.util.Collection;
import java.util.Optional;

/**
 * Represents a Tag for a given type.
 * Tags group CatalogTypes by a key
 * and unique values.
 * For example, {@link BlockTypeTags#WOOL} has key {@link Keys#DYE_COLOR}.
 * Each BlockType in {@link BlockTypeTags#WOOL} has a unique
 * {@link org.spongepowered.api.data.type.DyeColor}.
 * To retrieve a wool BlockType with {@link org.spongepowered.api.data.type.DyeColors#RED}
 * you could invoke {@link #find(Object)} with {@link org.spongepowered.api.data.type.DyeColors#RED}
 * on the {@link BlockTypeTags#WOOL}.
 *
 * Note that tags added by datapacks and mods may not
 * have a unique key/value associated with them. In this case,
 * attempts to retrieve those will fail.
 *
 * @param <T> Type that this tag groups
 * @param <U> Unique value that differentiates these types.
 */
public interface Tag<T, U> extends DefaultedRegistryValue {

    @SuppressWarnings("unchecked")
    static Builder<?, ?> builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Get every value in this Tag.
     *
     * @return All tag values
     */
    Collection<T> all();

    /**
     * Check whether this tag
     * contains the given value
     *
     * @param value Value to check
     * @return Whether the value is a part of this tag
     */
    default boolean contains(T value) {
        return all().contains(value);
    }

    /**
     * Searches this {@link Tag} <b>But not any of its children</b>
     * for the given value.
     *
     * Note that
     *
     * @param value Value to get
     * @return The corresponding value
     */
    T get(U value);

    /**
     * Same as {@link #get(Object)} but does not require
     * the value to be present, instead returns an optional.
     * @param value Value to search for
     * @return The corresponding value if found
     */
    Optional<T> find(U value);

    /**
     * Searches this {@link Tag} and all of its children
     * who have compatible keys.
     *
     * @param key Key to search with.
     * @param value Value to match
     * @param <E> Type retrievable by the key
     * @return A collection of all found corresponding values.
     *         Empty if none.
     */
    <E> Collection<T> findAll(Key<? extends Value<E>> key, E value);

    interface Builder<T, U> extends org.spongepowered.api.util.Builder<Tag<T, U>, Builder<T, U>> {

        /**
         * Generifies the builder properly to the given type.
         *
         * @param type Type to build a tag for, e.g {@link org.spongepowered.api.block.BlockType}
         * @return This builder, for chaining
         */
        <NT> Builder<NT, U> type(Class<NT> type);

        Builder<T, U> key(ResourceKey key);

        /**
         * <p>Adds a key that has an unique value for each value
         * contained in this tag.
         * This key should be show why these aren't the same
         * block. For example, {@link org.spongepowered.api.block.BlockTypes#BLACK_WOOL}
         * is different to {@link org.spongepowered.api.block.BlockTypes#RED_WOOL}
         * because it has a different {@link org.spongepowered.api.data.type.DyeColor}, thus
         * {@link Keys#DYE_COLOR} would be the correct choice for the key.</p>
         *
         * <p>If there are multiple {@link Keys} that separate the values,
         * consider creating multiple tags then creating a tag with those
         * as children.</p>
         *
         * @param key Key that differentiates these values.
         * @return The next step of this builder.
         */
        <NU> EndStep<T, NU> uniqueBy(Key<? extends Value<NU>> key);

        interface EndStep<T, U> extends Builder<T, U> {
            /**
             * Adds a child tag to this tag.
             * This allows for searching through the tag
             * and its sub tags for all blocktypes with a given
             * Key using {@link Tag#findAll(Key, Object)}
             *
             * @param childTag Child tag to add.
             * @return This builder, for chaining
             */
            Builder<T, U> addChild(Tag<T, ?> childTag);

            Builder<T, U> addChildren(Iterable<Tag<T, ?>> children);

            /**
             * Adds the value, retrieving the unique value from
             * the value provided, using the {@link Key} provided in
             * {@link #uniqueBy(Key)}
             *
             * @param value Value to add
             * @return This builder, for chaining
             * @throws IllegalArgumentException If the value provided did not contain or support
             *                                  the given key.
             * @throws IllegalStateException If {@link #uniqueBy(Key)} has not been set yet.
             */
            Builder<T, U>  addValue(T value) throws IllegalArgumentException;

            Builder<T, U>  addValues(Iterable<T> values) throws IllegalArgumentException;
        }
    }
}
