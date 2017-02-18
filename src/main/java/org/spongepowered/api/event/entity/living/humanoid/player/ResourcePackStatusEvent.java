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
package org.spongepowered.api.event.entity.living.humanoid.player;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

import java.util.Optional;

/**
 * Called when a {@link Player} notifies the server of the status of a resource pack
 * change request.
 */
@GenerateFactoryMethod
public interface ResourcePackStatusEvent extends Event {

    /**
     * Get the player for this event.
     *
     * @return The player
     */
    Player getPlayer();

    /**
     * Gets the pack that this status corresponds to.
     *
     * @return The pack that this status corresponds to.
     */
    ResourcePack getPack();

    /**
     * Gets the status of the sent pack.
     *
     * @return The status of the sent pack.
     */
    ResourcePackStatus getStatus();

    /**
     * The different possible responses the client can have.
     */
    enum ResourcePackStatus {

        /**
         * The client is attempting to download the pack.
         */
        ACCEPTED(null),

        /**
         * The client declined to download the pack.
         */
        DECLINED(false),

        /**
         * The client failed to download the resource pack.
         *
         * <p>In some client versions, such as 1.8.0, this may only be sent when
         * the resource pack URL does not end in <tt>.zip</tt>. Otherwise,
         * {@link #SUCCESSFULLY_LOADED} will be sent.</p>
         */
        FAILED(false),

        /**
         * The pack URI was successfully loaded. This does not mean that pack
         * was loaded, as the vanilla client sends this even when encountering a
         * 404 or similar.
         */
        SUCCESSFULLY_LOADED(true);

        private final Optional<Boolean> success;

        ResourcePackStatus(Boolean success) {
            this.success = Optional.ofNullable(success);
        }

        /**
         * Gets if this status indicates that the pack was successfully set.
         *
         * @return true if it was successful, false if it was not, and
         *         Optional.empty() if it cannot be determined at this time.
         */
        public Optional<Boolean> wasSuccessful() {
            return this.success;
        }

    }

}
