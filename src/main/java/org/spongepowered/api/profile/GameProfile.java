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

import net.kyori.adventure.identity.Identity;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.profile.property.ProfileProperty;
import org.spongepowered.api.user.UserManager;
import org.spongepowered.api.util.Identifiable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * Represents a profile of a user.
 *
 * <p>Use the {@link UserManager} service to
 * obtain the stored data associated with a profile.</p>
 */
public interface GameProfile extends Identifiable, Identity, DataSerializable {

    /**
     * Creates a {@link GameProfile} from the provided ID.
     *
     * <p>The name of the created profile will be {@code null}.</p>
     *
     * @param uniqueId The unique id
     * @return The created profile
     */
    static GameProfile of(final UUID uniqueId) {
        return GameProfile.of(uniqueId, null);
    }

    /**
     * Creates a {@link GameProfile} from the provided ID and name.
     *
     * @param uniqueId The unique id
     * @param name The name
     * @return The created profile
     */
    static GameProfile of(final UUID uniqueId, final @Nullable String name) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).of(uniqueId, name);
    }

    @Override
    default UUID uuid() {
        return this.getUniqueId();
    }

    /**
     * Gets the name associated with this profile.
     *
     * @return The associated name if present, otherwise {@link Optional#empty()}
     */
    Optional<String> getName();

    /**
     * Gets whether this game profile has a known name.
     *
     * @return Whether the name is known
     */
    default boolean hasName() {
        return this.getName().isPresent();
    }

    /**
     * Gets a new {@link GameProfile} with the given name.
     *
     * @param name The name
     * @return The new game profile
     */
    GameProfile withName(@Nullable String name);

    /**
     * Gets an immutable list of all the properties in this game profile.
     *
     * @return The properties
     */
    List<ProfileProperty> getProperties();

    /**
     * Gets a new {@link GameProfile} with the same name and unique id of this profile, but
     * without any of the properties.
     *
     * @return The new game profile
     */
    GameProfile withoutProperties();

    /**
     * Gets a new {@link GameProfile} with the given properties added to its properties.
     *
     * @param properties The profile properties to add
     * @return The new game profile
     */
    GameProfile withProperties(Iterable<ProfileProperty> properties);

    /**
     * Gets a new {@link GameProfile} with the given property added to its properties.
     *
     * @param property The profile property to add
     * @return The new game profile
     */
    GameProfile withProperty(ProfileProperty property);

    /**
     * Gets a new {@link GameProfile} with the given property removed from to its properties.
     *
     * @param properties The profile properties to remove
     * @return The new game profile
     */
    GameProfile withoutProperties(Iterable<ProfileProperty> properties);

    /**
     * Gets a new {@link GameProfile} where the properties which have the given name
     * are removed from its properties.
     *
     * @param name The profile property name to remove
     * @return The new game profile
     */
    default GameProfile withoutProperties(final String name) {
        return this.withoutProperties(property -> property.getName().equals(name));
    }

    /**
     * Gets a new {@link GameProfile} with the given property removed from its properties.
     *
     * @param property The profile property to remove
     * @return The new game profile
     */
    GameProfile withoutProperty(ProfileProperty property);

    /**
     * Gets a new {@link GameProfile} with where the properties that match the given
     * filter are removed.
     *
     * @param filter The profile property filter
     * @return The new game profile
     */
    GameProfile withoutProperties(Predicate<ProfileProperty> filter);

    /**
     * A factory for {@link GameProfile}s.
     */
    interface Factory {

        GameProfile of(UUID uniqueId, @Nullable String name);
    }
}
