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

/**
 * Represents multiple {@link ChunkDecorator}s merged to one. Useful if you
 * want to add some custom decoration to a chunk but still want to keep the
 * original decoration.
 */
public final class ChunkMultiDecorator implements ChunkDecorator {

    private final List<ChunkDecorator> decorators = new ArrayList<ChunkDecorator>();

    /**
     * Combines the given decorators to one {@link ChunkDecorator}.
     *
     * @param decorators The decorators to combine
     * @return The combined decorators
     */
    public static ChunkMultiDecorator of(final Iterable<ChunkDecorator> decorators) {
        final ChunkMultiDecorator combined = new ChunkMultiDecorator();
        for (final ChunkDecorator decorator : decorators) {
            if (decorator instanceof ChunkMultiDecorator) {
                combined.decorators.addAll(((ChunkMultiDecorator) decorator).getDecorators());
            } else {
                combined.decorators.add(decorator);
            }
        }
        return combined;
    }

    /**
     * Combines the given decorators to one {@link ChunkDecorator}.
     *
     * @param decorators The decorators to combine
     * @return The combined decorators
     */
    public static ChunkMultiDecorator of(final ChunkDecorator... decorators) {
        final ChunkMultiDecorator combined = new ChunkMultiDecorator();
        for (final ChunkDecorator decorator : decorators) {
            if (decorator instanceof ChunkMultiDecorator) {
                combined.decorators.addAll(((ChunkMultiDecorator) decorator).getDecorators());
            } else {
                combined.decorators.add(decorator);
            }
        }
        return combined;
    }

    private ChunkMultiDecorator() {
    }

    @Override
    public void decorate(final Chunk chunk) {
        for (final ChunkDecorator decorator : decorators) {
            decorator.decorate(chunk);
        }
    }

    /**
     * Gets the list of decorators included in this decorator.
     *
     * @return The list of decorators
     */
    public List<ChunkDecorator> getDecorators() {
        return decorators;
    }

}
