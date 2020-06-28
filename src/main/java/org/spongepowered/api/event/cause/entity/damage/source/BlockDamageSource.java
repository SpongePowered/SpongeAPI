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
package org.spongepowered.api.event.cause.entity.damage.source;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.world.ServerLocation;

public interface BlockDamageSource extends DamageSource {

    /**
     * Creates a new {@link Builder builder} for building a
     * {@link BlockDamageSource}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the location of the {@link BlockSnapshot}.
     *
     * @return The location of the block
     */
    ServerLocation getLocation();

    /**
     * Gets the {@link BlockSnapshot} of the source.
     *
     * @return The block snapshot of the source
     */
    BlockSnapshot getBlockSnapshot();

    interface Builder extends DamageSource.DamageSourceBuilder<BlockDamageSource, Builder> {

        /**
         * Sets the {@link ServerLocation} to use as a "source".
         *
         * @param location The location of the block as the damage source
         * @return This builder, for chaining
         */
        Builder block(ServerLocation location);

        /**
         * Sets the {@link BlockSnapshot} to act as the "damage source".
         *
         * @param blockState The block snapshot to use as the damage source
         * @return This builder, for chaining
         */
        Builder block(BlockSnapshot blockState);

    }
}
