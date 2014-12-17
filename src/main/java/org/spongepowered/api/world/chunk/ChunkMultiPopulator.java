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

package org.spongepowered.api.world.chunk;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Represents multiple {@link ChunkPopulator}s merged to one. Useful if you want
 * to add some custom population to a chunk but still want to keep the original
 * population.
 */
public final class ChunkMultiPopulator implements ChunkPopulator {

    private final List<ChunkPopulator> populators = new ArrayList<ChunkPopulator>();

    /**
     * Combines the given populators to one {@link ChunkPopulator}.
     *
     * @param populators The populators to combine
     * @return The combined populators
     */
    public static ChunkMultiPopulator of(final Iterable<ChunkPopulator> populators) {
        final ChunkMultiPopulator combined = new ChunkMultiPopulator();
        for (final ChunkPopulator populator : populators) {
            if (populator instanceof ChunkMultiPopulator) {
                combined.populators.addAll(((ChunkMultiPopulator) populator).getPopulators());
            } else {
                combined.populators.add(populator);
            }
        }
        return combined;
    }

    /**
     * Combines the given populators to one {@link ChunkPopulator}.
     *
     * @param populators The populators to combine
     * @return The combined populators
     */
    public static ChunkMultiPopulator of(final ChunkPopulator... populators) {
        final ChunkMultiPopulator combined = new ChunkMultiPopulator();
        for (final ChunkPopulator populator : populators) {
            if (populator instanceof ChunkMultiPopulator) {
                combined.populators.addAll(((ChunkMultiPopulator) populator).getPopulators());
            } else {
                combined.populators.add(populator);
            }
        }
        return combined;
    }

    private ChunkMultiPopulator() {
    }

    @Override
    public void populate(final Chunk chunk) {
        for (final ChunkPopulator populator : populators) {
            populator.populate(chunk);
        }
    }

    /**
     * Gets the immutable list of populators included in this populator.
     *
     * @return The list of decorators
     */
    public ImmutableList<ChunkPopulator> getPopulators() {
        return ImmutableList.copyOf(populators);
    }

}
