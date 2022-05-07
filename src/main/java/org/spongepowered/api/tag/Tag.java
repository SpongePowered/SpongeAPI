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

import org.spongepowered.api.Engine;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.registry.DefaultedRegistryType;

/**
 * A {@link ResourceKey resource keyed} collection of {@link Taggable} values
 * (of type {@code T}).
 *
 * <p>While any number of tags may exist and the values each tag contains is
 * arbitrary, vanilla Minecraft generally uses pre-defined tags for one of the
 * following reasons:</p>
 *
 * <ul>
 *     <li>To define a common material that {@link BlockType blocks} are made
 *     of, for example, {@link BlockTypeTags#ACACIA_LOGS}</li>
 *     <li>To define a common behavior that the {@link Engine engine} should
 *     apply to a block, such as specifying a block as a log that can burn via
 *     {@link BlockTypeTags#LOGS_THAT_BURN}</li>
 * </ul>
 */
public interface Tag<T> extends ResourceKeyed {

    interface Factory {
        <T> Tag<T> of(DefaultedRegistryType<T> registryType, ResourceKey key);
    }

    static <T> Tag<T> of(DefaultedRegistryType<T> registryType, ResourceKey key) {
        return Sponge.game().factoryProvider().provide(Tag.Factory.class).of(registryType, key);
    }

}
