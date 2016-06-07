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
package org.spongepowered.api.profile;

import com.google.common.collect.Multimap;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.profile.property.ProfileProperty;
import org.spongepowered.api.service.user.UserStorageService;
import org.spongepowered.api.util.Identifiable;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * Represents a profile of a user.
 *
 * <p>Use the {@link UserStorageService} service to
 * obtain the stored data associated with a profile.</p>
 */
public interface GameProfile extends Identifiable, DataSerializable {

    /**
     * Creates a {@link GameProfile} from the provided ID and name.
     *
     * @param uniqueId The unique ID
     * @param name The name
     * @return The created profile
     */
    static GameProfile of(UUID uniqueId, @Nullable String name) {
        return Sponge.getServer().getGameProfileManager().createProfile(uniqueId, name);
    }

    /**
     * Gets the name associated with this profile.
     *
     * @return The associated name if present, otherwise {@link Optional#empty()}
     */
    Optional<String> getName();

    /**
     * Gets the property map for this profile.
     *
     * <p>This is a mutable map.</p>
     *
     * @return The property map
     */
    Multimap<String, ProfileProperty> getPropertyMap();

    /**
     * Checks if this profile is filled.
     *
     * <p>A filled profile contains both a unique id and name.</p>
     *
     * @return {@code true} if this profile is filled
     * @see GameProfileManager#fill(GameProfile)
     * @see GameProfileManager#fill(GameProfile, boolean)
     * @see GameProfileManager#fill(GameProfile, boolean, boolean)
     */
    boolean isFilled();

}
