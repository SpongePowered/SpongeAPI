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

package org.spongepowered.api.entity.player;

import com.google.common.base.Optional;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.util.Identifiable;

/**
 * A User is the data usually associated with a Player that is persisted across server restarts.
 * This is in contrast to Player which represents the ingame entity associated with an online User.
 */
public interface User extends DataHolder, Identifiable, ArmorEquipable, Tamer, DataSerializable, Subject, Carrier {

    /**
     * Gets the associated {@link GameProfile} of this player.
     *
     * @return The user's profile
     */
    GameProfile getProfile();

    /**
     * Gets the player's last known username.
     *
     * @return The player's last known username
     */
    @Override
    String getName();

    /**
     * Checks if this user is online or not.
     *
     * @return True if the corresponding player is online
     */
    boolean isOnline();

    /**
     * Gets the related online {@link Player} if the player is
     * in fact online.
     *
     * @return The associated online Player, if available
     */
    Optional<Player> getPlayer();


}
