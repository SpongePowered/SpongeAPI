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

package org.spongepowered.api.block.tile.data;

import com.google.common.base.Optional;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.block.tile.Skull;
import org.spongepowered.api.util.Direction;

/**
 * Represents data associated with a {@link Skull}. The information related to
 * the {@link GameProfile} may be used for skinning purposes.
 */
public interface SkullData extends TileEntityData<Skull, SkullData> {

    /**
     * Gets the rotation of the skull.
     * <p>
     * This rotation is only used if the Skull is placed on top of the block,
     * otherwise its rotation is defined by the BlockState of the Skull block.
     * </p>
     *
     * @return The rotation direction
     */
    Direction getRotation();

    /**
     * Sets the rotation of the skull.
     * <p>
     * This rotation is only used if the Skull is placed on top of the block,
     * otherwise its rotation is defined by the BlockState of the Skull block.
     * </p>
     *
     * @param rotation The new rotation
     */
    void setRotation(Direction rotation);

    /**
     * If the type of the skull is {@link SkullTypes#PLAYER} then this will
     * return the associated {@link GameProfile}.
     *
     * @return The player
     */
    Optional<GameProfile> getPlayer();

    /**
     * Sets the player associated with this skull. Also ensures that
     * {@link #getType()} is set to {@link SkullTypes#PLAYER} (setting it if
     * necessary).
     *
     * @param player The new player
     */
    void setPlayer(GameProfile player);

    /**
     * Gets the type of skull.
     *
     * @return The skull type
     */
    SkullType getType();

    /**
     * Sets the skull type. If the new type is not {@link SkullTypes#PLAYER}
     * then the player profile will be cleared.
     *
     * @param type The new type
     */
    void setType(SkullType type);

}
