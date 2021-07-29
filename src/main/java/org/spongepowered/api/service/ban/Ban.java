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
package org.spongepowered.api.service.ban;

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.util.CopyableBuilder;

import java.net.InetAddress;
import java.time.Instant;
import java.util.Optional;

/**
 * Represents a ban made on an object.
 */
public interface Ban {

    /**
     * Creates a new Builder.
     *
     * @return A new ban builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Creates an indefinite ban on a profile.
     *
     * @param profile The profile
     * @return The created ban
     */
    static Ban of(GameProfile profile) {
        return Ban.builder().type(BanTypes.PROFILE.get()).profile(profile).build();
    }

    /**
     * Creates an indefinite ban with a reason on a profile.
     *
     * @param profile The profile
     * @param reason The reason
     * @return The created ban
     */
    static Ban of(GameProfile profile, Component reason) {
        return Ban.builder().type(BanTypes.PROFILE.get()).profile(profile).reason(reason).build();
    }

    /**
     * Gets the type of this ban.
     *
     * @return The ban type
     */
    BanType type();

    /**
     * Gets the reason for the ban, if available.
     *
     * @return The reason specified for the ban, if available
     */
    Optional<Component> reason();

    /**
     * Gets the creation date of the ban.
     *
     * <p>Note that this {@link Instant} has no effect on whether or not a ban is
     * active. Any ban returned by {@link BanService#find(GameProfile)}
     * will be used (when checking if a player can join, for example),
     * regardless of its creation date.</p>
     *
     * @return Creation date of the ban
     */
    Instant creationDate();

    /**
     * Gets the source that created this ban, if available.
     *
     * @return the source of this ban, if available
     */
    Optional<Component> banSource();

    /**
     * Gets the expiration date of this ban, if available.
     *
     * @return Expiration time of the ban or {@link Optional#empty()}
     */
    Optional<Instant> expirationDate();

    /**
     * Gets whether this ban is indefinitely long, e.g. has no expiration date.
     *
     * @return True if this ban has no expiration date, otherwise false
     */
    default boolean isIndefinite() {
        return !this.expirationDate().isPresent();
    }

    /**
     * Represents a ban made on a {@link GameProfile}.
     */
    interface Profile extends Ban {

        /**
         * Gets the {@link GameProfile} this ban applies to.
         *
         * @return The {@link GameProfile}
         */
        GameProfile profile();

    }

    /**
     * Represents a ban made on an IP.
     */
    interface IP extends Ban {

        /**
         * Gets the address this ban applies to.
         *
         * @return The address
         */
        InetAddress address();

    }

    /**
     * Represents a builder that creates bans.
     */
    interface Builder extends org.spongepowered.api.util.Builder<Ban, Builder>, CopyableBuilder<Ban, Builder> {

        /**
         * Sets the profile to be banned.
         *
         * <p>This can only be done if the {@link BanType} has been set to {@link BanTypes#PROFILE}.</p>
         *
         * @param profile The profile
         * @return This builder
         */
        Builder profile(GameProfile profile);

        /**
         * Sets the IP address to be banned.
         *
         * <p>This can only be done if the {@link BanType} has been set to {@link BanTypes#IP}.</p>
         *
         * @param address The IP address
         * @return This builder
         */
        Builder address(InetAddress address);

        /**
         * Sets the type of the ban.
         *
         * @param type The type to be set
         * @return This builder
         */
        Builder type(BanType type);

        /**
         * Sets the reason for the ban.
         *
         * <p>If the specified reason is <code>null</code>, or not provided,
         * then the reason will be be available on the created ban.</p>
         *
         * @param reason The reason
         * @return This builder
         */
        Builder reason(@Nullable Component reason);

        /**
         * Sets the date that the ban starts.
         *
         * @param instant The start date
         * @return This builder
         */
        Builder startDate(Instant instant);

        /**
         * Sets the expiration date of the ban, or removes it.
         *
         * @param instant The expiration date, or null in order to remove it
         * @return This builder
         */
        Builder expirationDate(@Nullable Instant instant);

        /**
         * Sets the source of the ban as a {@link Component}, or removes it if
         * {@code null} is passed in.
         *
         * @param source The source of the ban, or {@code null}
         * @return This builder
         */
        Builder source(@Nullable Component source);

        /**
         * Creates a new Ban from this builder.
         *
         * @return A new Ban
         */
        @Override
        Ban build();

    }
}
