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
package org.spongepowered.api.event.entity.living.player;

import com.google.common.base.Optional;
import org.spongepowered.api.event.entity.player.PlayerEvent;
import org.spongepowered.api.resourcepack.ResourcePack;

/**
 * Called when a player notifies the server of the status of a resource pack
 * change request.
 */
public interface PlayerResourcePackStatusEvent extends PlayerEvent {

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
         * The pack was not a .zip file.
         */
        PACK_FILE_FORMAT_NOT_RECOGNIZED(false),

        /**
         * The pack URL was successfully loaded. This does not mean that pack
         * was loaded, as the vanilla client sends this even when encountering a
         * 404 or similar.
         */
        SUCCESSFULLY_LOADED(true);

        private final Optional<Boolean> success;

        ResourcePackStatus(Boolean success) {
            this.success = Optional.fromNullable(success);
        }

        /**
         * Gets if this status indicates that the pack was successfully set.
         *
         * @return true if it was successful, false if it was not, and
         *         Optional.absent() if it cannot be determined at this time.
         */
        public Optional<Boolean> wasSuccessful() {
            return this.success;
        }

    }
}
