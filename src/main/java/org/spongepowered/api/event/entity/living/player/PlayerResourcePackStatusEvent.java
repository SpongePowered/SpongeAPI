package org.spongepowered.api.event.entity.living.player;

import org.spongepowered.api.resourcepack.ResourcePack;

import com.google.common.base.Optional;

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

    public enum ResourcePackStatus {
        /**
         * The client is attempting to download the pack.
         */
        ACCEPTED(Optional.<Boolean> absent()),

        /**
         * The client declined to download the pack.
         */
        DECLINED(Optional.of(false)),

        /**
         * The pack was not a .zip file.
         */
        PACK_FILE_FORMAT_NOT_RECOGNIZED(Optional.of(false)),

        /**
         * The pack URL was successfully loaded. This does not mean that pack
         * was loaded, as the vanilla client sends this even when encountering a
         * 404 or similar.
         */
        SUCCESSFULLY_LOADED(Optional.of(true));

        private final Optional<Boolean> success;

        ResourcePackStatus(Optional<Boolean> success) {
            this.success = success;
        }

        /**
         * Gets if this status indicates that the pack was successfully set.
         * 
         * @return true if it was successful, false if it was not, and
         *         Optional.absent() if it cannot be determined at this time.
         */
        public Optional<Boolean> wasSuccessful() {
            return success;
        }

    }
}
