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

package org.spongepowered.api.event.world.chunk;

import org.spongepowered.api.world.World;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.chunk.ChunkDecorator;

/**
 * Called when a {@link Chunk} will be (re)decorated.
 */
public interface ChunkPreDecorateEvent extends ChunkEvent {

    /**
     * Use the {@link World}s default chunk decorator.
     */
    void setDefaultDecorator();

    /**
     * Checks whether the {@link World}s default decorator is used to decorate
     * the chunk.
     *
     * @return True, if the worlds default decorator is used. False otherwise
     */
    boolean isDefaultDecorator();

    /**
     * Gets the decorator that will be used to decorate the chunk.
     *
     * @return The decorator that will be used to decorate the chunk
     */
    ChunkDecorator getDecorator();

    /**
     * Checks whether the given world supports custom {@link ChunkDecorator}s
     * and can be used for the given chunk.
     *
     * @return True, if custom decorators are supported. False otherwise
     */
    boolean supportsCustomDecorators();

    /**
     * Sets a custom decorator that will be used to decorate the given chunk.
     *
     * @param decorator The custom decorator to decorate the chunk
     * @throws IllegalStateException If custom decorators are not supported
     * @see #supportsCustomDecorators()
     */
    void setCustomDecorator(ChunkDecorator decorator) throws IllegalStateException;

}
