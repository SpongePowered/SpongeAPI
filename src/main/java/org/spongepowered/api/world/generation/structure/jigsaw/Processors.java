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
package org.spongepowered.api.world.generation.structure.jigsaw;

import org.spongepowered.api.ResourceKey;

/**
 * Registry IDs of the vanilla {@link Processor structure processors}.
 *
 * <p>Since Minecraft 26.2-snapshot-1, processor kinds are no longer
 * represented by a per-kind object in SpongeAPI — the vanilla registry stores
 * codecs directly. This class holds the stable {@link ResourceKey} identifiers
 * of the processors provided by vanilla, suitable for passing to
 * {@link Processor#parse(org.spongepowered.api.registry.RegistryHolder,
 * ResourceKey, org.spongepowered.api.data.persistence.DataView)}.</p>
 */
public final class Processors {

    public static final ResourceKey BLACKSTONE_REPLACE = ResourceKey.minecraft("blackstone_replace");

    public static final ResourceKey BLOCK_AGE = ResourceKey.minecraft("block_age");

    public static final ResourceKey BLOCK_IGNORE = ResourceKey.minecraft("block_ignore");

    public static final ResourceKey BLOCK_ROT = ResourceKey.minecraft("block_rot");

    public static final ResourceKey CAPPED = ResourceKey.minecraft("capped");

    public static final ResourceKey GRAVITY = ResourceKey.minecraft("gravity");

    public static final ResourceKey JIGSAW_REPLACEMENT = ResourceKey.minecraft("jigsaw_replacement");

    public static final ResourceKey LAVA_SUBMERGED_BLOCK = ResourceKey.minecraft("lava_submerged_block");

    public static final ResourceKey NOP = ResourceKey.minecraft("nop");

    public static final ResourceKey PROTECTED_BLOCKS = ResourceKey.minecraft("protected_blocks");

    public static final ResourceKey RULE = ResourceKey.minecraft("rule");

    private Processors() {
    }
}
