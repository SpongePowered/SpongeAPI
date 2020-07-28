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
package org.spongepowered.api.world.teleport;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

/**
 * A {@link TeleportHelperFilter} contains routines to determine whether a
 * location is a suitable candidate for teleporting to safely.
 */
@CatalogedBy(TeleportHelperFilters.class)
public interface TeleportHelperFilter extends CatalogType {

    /**
     * Tests whether the location in question is valid, regardless of whether
     * the block is safe or not. This is <em>only</em> intended to be used by
     * kernels that blacklist/whitelist certain locations, and any block checks
     * should be performed by {@link #isSafeFloorMaterial(BlockState)} and
     * {@link #isSafeBodyMaterial(BlockState)} instead, to obtain the full
     * benefits of the {@link TeleportHelper}.
     *
     * <ul>
     *     <li>Returning {@link Tristate#UNDEFINED} denotes that the filter
     *     does not regard the location as valid or otherwise, and that the
     *     helper should determine if the location is suitable using the
     *     {@link #isSafeBodyMaterial(BlockState)} and
     *     {@link #isSafeFloorMaterial(BlockState)} methods. Implementations
     *     should generally return this result.</li>
     *
     *     <li>Returning {@link Tristate#TRUE} marks the location as valid and
     *     will causes the parent {@link TeleportHelper} to return this
     *     location. No checks using {@link #isSafeBodyMaterial(BlockState)}
     *     and {@link #isSafeFloorMaterial(BlockState)} will be performed.</li>
     *
     *     <li>Returning {@link Tristate#FALSE} marks the location as invalid
     *     and causes the parent {@link TeleportHelper} to move onto the next
     *     block to check, regardless of whether it would have otherwise been
     *     marked as safe.</li>
     * </ul>
     *
     * <p>This method has a default implementation of always returning
     * {@link Tristate#UNDEFINED}, that is, such a filter is not location
     * specific.</p>
     *
     * <p>This will be called before any other check on the target location is
     * performed, this is the first check performed when investigating a
     * location.</p>
     *
     * @param world The {@link World} to check
     * @param position The {@link Vector3i} (block position) to check
     * @return A {@link Tristate}
     */
    default Tristate isValidLocation(ServerWorld world, Vector3i position) {
        return Tristate.UNDEFINED;
    }

    /**
     * Tests whether a {@link BlockState} should be considered a safe block
     * to land on.
     *
     * @param blockState The {@link BlockState} to check
     * @return <code>true</code> if the material should be safe to land on
     */
    boolean isSafeFloorMaterial(BlockState blockState);

    /**
     * Tests whether a {@link BlockState} should be considered a safe block
     * for the body to be inside of.
     *
     * <p>Generally, you want this to be a passable block!</p>
     *
     * @param blockState The {@link BlockState} to check
     * @return <code>true</code> if the material should be safe for the body to
     *         be inside of
     */
    boolean isSafeBodyMaterial(BlockState blockState);

}
