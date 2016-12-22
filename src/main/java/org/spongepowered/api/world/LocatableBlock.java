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
package org.spongepowered.api.world;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.ImmutableDataHolder;
import org.spongepowered.api.data.persistence.DataBuilder;

public interface LocatableBlock extends ImmutableDataHolder<LocatableBlock>, Locatable {

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    BlockState getBlockState();

    default Vector3i getPosition() {
        return getLocation().getBlockPosition();
    }

    interface Builder extends DataBuilder<LocatableBlock> {

        Builder state(BlockState blockState);

        Builder location(Location<World> location);

        Builder position(Vector3i position);

        Builder position(int x, int y, int z);

        Builder world(World world);

        @Override
        Builder reset();

        @Override
        Builder from(LocatableBlock value);

        LocatableBlock build();
    }

}
