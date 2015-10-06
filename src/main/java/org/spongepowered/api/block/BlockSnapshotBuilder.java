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
package org.spongepowered.api.block;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.data.ImmutableDataBuilder;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.UUID;

public interface BlockSnapshotBuilder extends ImmutableDataBuilder<BlockSnapshot, BlockSnapshotBuilder> {

    /**
     * Sets the {@link WorldProperties} for this {@link BlockSnapshot}.
     *
     * <p>
     *     This is used to grab the {@link UUID} of the World for this snapshot.
     * </p>
     *
     * @param worldProperties The WorldProperties
     * @return This builder, for chaining
     */
    BlockSnapshotBuilder world(WorldProperties worldProperties);

    /**
     * Sets the {@link BlockState} for this {@link BlockSnapshot}
     *
     * @param blockState The BlockState
     * @return This builder, for chaining
     */
    BlockSnapshotBuilder blockState(BlockState blockState);

    /**
     * Sets the coordinates of this {@link BlockSnapshot} from a {@link Vector3i}.
     *
     * @param position The Vector3i representing the coordinates
     * @return This builder, for chaining
     */
    BlockSnapshotBuilder position(Vector3i position);

    /**
     * Copies over block data from a {@link Location}<{@link World}>.
     * @param location The Location to copy from
     * @return This builder, for chaining
     */
    BlockSnapshotBuilder from(Location<World> location);
}
