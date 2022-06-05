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
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.event.lifecycle.RegisterDataPackValueEvent;
import org.spongepowered.api.registry.DefaultedRegistryType;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryType;

import java.util.Collection;
import java.util.Map;

/**
 * A template that creates a or modifies a {@link Tag}.
 */
public interface TagTemplate extends DataPack.Reloadable {

    /**
     * Returns a {@link Builder} that creates {@link TagTemplate}s.
     *
     * @param registryType The {@link DefaultedRegistryType} of the builder
     * @return The builder.
     */
    @SuppressWarnings("unchecked")
    static <T extends Taggable<T>> Builder<T> builder(final DefaultedRegistryType<T> registryType) {
        return Sponge.game().factoryProvider().provide(Factory.class).builder(registryType);
    }

    interface Builder<T extends Taggable<T>> extends org.spongepowered.api.util.ResourceKeyedBuilder<TagTemplate, Builder<T>> {

        /**
         * Sets whether the values contained by a tag template will replace
         * existing values if a tag with the same {@link #key()} and
         * {@link RegistryType} already exists when datapacks are (re)loaded.
         *
         * <p>If this is set to {@code true}, any previous entries for this
         * given key-tag type combination will be discarded and the data
         * in the built template will <strong>replace</strong> the data. If
         * this is set to {@code false}, the entries in this template will
         * be <strong>merged</strong> with any existing data. The default
         * behavior is to merge data.</p>
         *
         * <p>As no guarantees are made to the order in which templates are
         * applied when datapacks are (re)loaded, note that replacement will
         * only act upon templates that have previously been applied.</p>
         *
         * @param replace Whether to replace instead of merge.
         * @return This builder, for chaining.
         */
        Builder<T> replace(boolean replace);

        /**
         * Indicates that any existing values of a tag with the same
         * {@link #key()} and {@link RegistryType} during datapack (re)loading will
         * have their values discarded and replaced by this template.
         *
         * @see #replace(boolean)
         * @return This builder, for chaining
         */
        default Builder<T> replace() {
            return this.replace(true);
        }

        /**
         * Adds the {@link RegistryKey} for a value to the builder.
         *
         * <p>As the objects that this tag will contain may be available at this
         * stage, their {@link ResourceKey resource key ID} should be provided
         * instead. However, this gives rise to the possibility that a value
         * may not be available when tags are generated. The behavior during tag
         * generation if the a value for the supplied key is not present can be
         * controlled with the argument passed to the {@code required}
         * parameter:</p>
         *
         * <ul>
         *     <li>if {@code true}, the entire tag will not be applied.</li>
         *     <li>if {@code false}, the tag will be applied without the value.
         *     </li>
         * </ul>
         *
         * @param value Value to add
         * @param required Whether this tag should fail to load if
         *                 the value is not found while loading.
         * @return This builder, for chaining
         */
        Builder<T> addValue(RegistryKey<T> value, boolean required);

        /**
         * Adds the {@link RegistryKey} for a value to the builder, marking it
         * as required.
         *
         * @see #addValue(RegistryKey, boolean)
         * @param value Value to add
         * @return This builder, for chaining
         */
        default Builder<T> addValue(final RegistryKey<T> value) {
            return this.addValue(value, true);
        }

        /**
         * Adds a collection of {@link RegistryKey}s for values to this builder.
         *
         * @see #addValue(RegistryKey, boolean)
         * @param values Values to add
         * @param required Whether the values are required. If required,
         *                 the tag will fail to load if they are not found
         *                 while loading.
         * @return This builder, for chaining.
         */
        Builder<T> addValues(Collection<RegistryKey<T>> values, boolean required);

        /**
         * Adds a collection of {@link RegistryKey}s for values to this builder,
         * marking all as required.
         *
         * @see #addValue(RegistryKey, boolean)
         * @param values Values to add
         * @return This builder, for chaining.
         */
        default Builder<T> addValues(final Collection<RegistryKey<T>> values) {
            return this.addValues(values, true);
        }

        /**
         * Marks a tag with a given {@link RegistryKey} as a child of the tag
         * generated by this template.
         *
         * <p>A child {@link Tag} is considered a subset of its parent, that is,
         * the tag generated from this template will include all values from all
         * its children, as well as those directly provided via the addValue(s)
         * methods.</p>
         *
         * <p>As {@link Tag}s may not be available at this stage, their
         * {@link #key()} should be provided instead. If the key does not point
         * to a valid tag (or tag template) when datapacks are reloaded, the
         * argument supplied to {@code required} determines whether this tag
         * is ultimately generated, that is, if the supplied child key does
         * not represent a tag:</p>
         *
         * <ul>
         *     <li>if {@code true}, no tag will be generated.</li>
         *     <li>if {@code false}, a tag will be generated without the given
         *     child.</li>
         * </ul>
         *
         * @param childTag {@link RegistryKey} for tag to be added.
         * @param required Whether loading this tag should fail if the child tag is not found.
         * @return This builder, for chaining
         */
        Builder<T> addChild(final Tag<T> childTag, final boolean required);

        /**
         * Marks a tag with a given {@link RegistryKey} as a required child of
         * the tag generated by this template.
         *
         * @see #addChild(Tag)
         * @param childTag {@link RegistryKey} for tag to be added.
         * @return This builder, for chaining
         */
        default Builder<T> addChild(final Tag<T> childTag) {
            return this.addChild(childTag, true);
        }

        /**
         * Adds a child tag to this builder, using a {@link TagTemplate}.
         *
         * @see #addChild(Tag, boolean)
         * @param childTag The child to be added.
         * @return This builder, for chaining
         * @throws IllegalArgumentException If this TagTemplate is not the same {@link RegistryType}
         *                                  as this builder.
         */
        Builder<T> addChild(TagTemplate childTag) throws IllegalArgumentException;

        /**
         * Adds multiple children to this template.
         *
         * @see #addChild(Tag, boolean)
         * @param children Children to add.
         * @param required Whether to fail loading the tag if these children are
         *                 not found.
         * @return This builder, for chaining
         */
        Builder<T> addChildren(Collection<Tag<T>> children, boolean required);

        /**
         * Adds multiple required children to this template.
         *
         * @see #addChild(Tag, boolean)
         * @param children Children to add.
         * @return This builder, for chaining
         */
        default Builder<T> addChildren(final Collection<Tag<T>> children) {
            return this.addChildren(children, true);
        }

        /**
         * Adds multiple required children to this template, where each
         * key-value pair in this map represents a child {@link ResourceKey}
         * and whether the child is required.
         *
         * @see #addChild(Tag, boolean)
         * @param childrenMap Map of children, RegistryKey
         * @return This builder, for chaining.
         */
        Builder<T> addChildren(Map<Tag<T>, Boolean> childrenMap);

        /**
         * Creates a {@link TagTemplate} that should be registered during the
         * {@link RegisterDataPackValueEvent}.
         *
         * @return The built {@link TagTemplate}.
         */
        @Override
        @NonNull
        TagTemplate build();
    }

    interface Factory {

        <T extends Taggable<T>> Builder<T> builder(DefaultedRegistryType<T> registryType);

    }

}
