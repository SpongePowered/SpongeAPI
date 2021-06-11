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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.registry.DefaultedRegistryValue;

import java.util.Collection;

/**
 * Represents a Tag for a given type.
 * Tags group {@link TagTypes}.
 *
 * @param <T> Type that this tag groups
 */
public interface Tag<T> extends DefaultedRegistryValue, ResourceKeyed, TagRegistration {

    /**
     * Creates a builder to create a new {@link Tag}
     * or modify an existing one.
     * @return Builder to build a new Tag.
     */
    @SuppressWarnings("unchecked")
    static Builder<?> builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Get every value in this Tag.
     *
     * @return All tag values
     */
    Collection<T> all();

    interface Builder<T extends Taggable> extends org.spongepowered.api.util.ResourceKeyedBuilder<TagRegistration, Builder<T>> {

        /**
         * Sets the tag type and generifies the builder.
         *
         * @param tagType Type to build a tag for, e.g {@link TagTypes#BLOCK_TYPE}
         * @return This builder, for chaining
         */
        <NT extends Taggable> Builder<NT> type(TagType<NT> tagType);

        /**
         * <p>Whether to replace instead of append if the tag already
         * exists.</p>
         *
         * <p>By default, if the {@link ResourceKey#value()} is the same as
         * another data pack / plugin, the two will be combined, and their
         * tags appended to each other.</p>
         *
         * @param replace Whether to replace instead of merge.
         * @return This builder, for chaining.
         */
        Builder<T> replace(boolean replace);

        default Builder<T> replace() {
            return replace(true);
        }

        /**
         * Adds a child tag to this tag.
         * This adds all of its values to this tag.
         *
         * @param childTag Child tag to add.
         * @return This builder, for chaining
         */
        Builder<T> addChild(Tag<T> childTag);

        Builder<T> addChildren(Collection<Tag<T>> children);

        /**
         * Adds the value to the tag.
         *
         * @param value Value to add
         * @return This builder, for chaining
         */
        Builder<T> addValue(T value);

        Builder<T> addValues(Collection<T> values);

        /**
         * A nicely generified tag, <b>That must be registered</b> in {@link org.spongepowered.api.event.lifecycle.RegisterDataPackValueEvent}.
         *
         * @return The built tag.
         */
        @Override
        @NonNull TagRegistration build();
    }
}
