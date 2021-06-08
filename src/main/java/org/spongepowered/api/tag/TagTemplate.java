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
import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPackSerializable;
import org.spongepowered.api.event.lifecycle.RegisterDataPackValueEvent;
import org.spongepowered.api.registry.RegistryKey;

import java.util.Collection;
import java.util.Map;

/**
 * A template that creates a or modifies a {@link Tag}.
 */
public interface TagTemplate extends DataPackSerializable {

    /**
     * Creates a builder to create a new {@link Tag}
     * or modify an existing one.
     * @return Builder to build a new Tag.
     */
    @SuppressWarnings("unchecked")
    static Builder<?> builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    interface Builder<T extends Taggable<T>> extends org.spongepowered.api.util.ResourceKeyedBuilder<TagTemplate, Builder<T>> {

        /**
         * Sets the tag type and generifies the builder.
         *
         * @param tagType Type to build a tag for, e.g {@link TagTypes#BLOCK_TYPE}
         * @return This builder, for chaining
         */
        <NT extends Taggable<NT>> Builder<NT> type(TagType<NT> tagType);

        /**
         * <p>Whether to replace instead of append if the tag already
         * exists. This replaces any minecraft tag data and any data packs
         * that are lower priority than this one (the plugin data pack)</p>
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
         * Adds the {@link RegistryKey} for a value to the builder.
         *
         * @param value Value to add
         * @param required Whether this tag should fail to load if
         *                 the value is not found while loading.
         * @return This builder, for chaining
         */
        Builder<T> addValue(RegistryKey<T> value, boolean required);

        default Builder<T> addValue(RegistryKey<T> value) {
            return addValue(value, true);
        }

        /**
         * Adds a collection of {@link RegistryKey}s for values to this builder.
         *
         * @param values Values to add
         * @param required Whether the values are required. If required,
         *                 the tag will fail to load if they are not found
         *                 while loading.
         * @return This builder, for chaining.
         */
        Builder<T> addValues(Collection<RegistryKey<T>> values, boolean required);

        default Builder<T> addValues(Collection<RegistryKey<T>> values) {
            return addValues(values, true);
        }

        /**
         * Adds a {@link RegistryKey} for a Tag to this builder.
         * This means anything contained in that tag, is always
         * also contained in this one.
         *
         * @param childTag {@link RegistryKey} for tag to be added.
         * @param required Whether loading this tag should fail if the child tag is not found.
         * @return This builder, for chaining
         */
        Builder<T> addChild(RegistryKey<Tag<T>> childTag, boolean required);

        default Builder<T> addChild(RegistryKey<Tag<T>> childTag) {
            return addChild(childTag, true);
        }

        /**
         * Adds a child tag to this builder, using a {@link TagTemplate}.
         *
         * @param childTag The child to be added.
         * @return This builder, for chaining
         * @throws IllegalArgumentException If this TagTemplate is not the same {@link TagType}
         *                                  as this builder, so is incompatible.
         */
        Builder<T> addChild(TagTemplate childTag) throws IllegalArgumentException;

        /**
         * Adds a collection of children, that are required.
         * If these are not found they will cause the tag to fail to load.
         * @param children Children to add.
         * @param required Whether to fail loading the tag
         *                 if these children are not found.
         * @return This builder, for chaining
         */
        Builder<T> addChildren(Collection<RegistryKey<Tag<T>>> children, boolean required);

        default Builder<T> addChildren(Collection<RegistryKey<Tag<T>>> children) {
            return addChildren(children, true);
        }

        /**
         * Adds a map of children to this builder, of
         * {@link RegistryKey} to whether they are required.
         * This tag will fail to load if the child tag is not
         * present and it is required.
         *
         * @param childrenMap Map of children, RegistryKey-Required
         * @return This builder, for chaining.
         */
        Builder<T> addChildren(Map<RegistryKey<Tag<T>>, Boolean> childrenMap);

        /**
         * Creates a {@link TagTemplate} that should be registered during the {@link RegisterDataPackValueEvent}.
         *
         * @return The built {@link TagTemplate}.
         */
        @Override
        @NonNull TagTemplate build();
    }
}
