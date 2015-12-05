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
package org.spongepowered.api.util.ban;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.util.ResettableBuilder;

import java.net.InetAddress;
import java.util.Date;
import java.util.Optional;

import javax.annotation.Nullable;

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
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates an indefinite ban on a user.
     *
     * @param user The user
     * @return The created ban
     */
    static Ban of(org.spongepowered.api.entity.living.player.User user) {
        return builder().user(user).build();
    }

    /**
     * Creates an indefinite ban with a reason on a user.
     *
     * @param user The user
     * @param reason The reason
     * @return The created ban
     */
    static Ban of(org.spongepowered.api.entity.living.player.User user, Text.Literal reason) {
        return builder().user(user).reason(reason).build();
    }

    /**
     * Gets the type of this ban.
     *
     * @return The ban type
     */
    BanType getType();

    /**
     * Get the reason for the ban.
     *
     * @return The reason specified for the ban.
     */
    Text.Literal getReason();

    /**
     * Gets the start date of the ban.
     *
     * @return Creation date of the ban
     */
    Date getStartDate();

    /**
     * Gets the source that banned the user, if available.
     *
     * @return The banning source or {@link Optional#empty()}
     */
    Optional<CommandSource> getSource();

    /**
     * Gets the expiration date of this ban, if available.
     *
     * @return Expiration time of the ban or {@link Optional#empty()}
     */
    Optional<Date> getExpirationDate();

    /**
     * Gets whether this ban is indefinitely long, e.g. has no expiration date.
     *
     * @return True if this ban has no expiration date, otherwise false
     */
    boolean isIndefinite();

    /**
     * Represents a ban made on a user.
     */
    interface User extends Ban {

        /**
         * Gets the user this ban applies to.
         *
         * @return The user
         */
        org.spongepowered.api.entity.living.player.User getUser();

    }

    /**
     * Represents a ban made on an IP.
     */
    interface Ip extends Ban {

        /**
         * Gets the address this ban applies to.
         *
         * @return The address
         */
        InetAddress getAddress();

    }

    /**
     * Represents a builder that creates bans.
     */
    interface Builder extends ResettableBuilder<Builder> {

        /**
         * Sets the user to be banned.
         *
         * <p>This can only be done if the {@link BanType} has been set to {@link BanType#USER_BAN}.</p>
         *
         * @param user The user
         * @return This builder
         */
        Builder user(org.spongepowered.api.entity.living.player.User user);

        /**
         * Sets the IP address to be banned.
         *
         * <p>This can only be done if the {@link BanType} has been set to {@link BanType#IP_BAN}.</p>
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
         * @param reason The reason
         * @return This builder
         */
        Builder reason(Text.Literal reason);

        /**
         * Sets the date that the ban starts.
         *
         * @param date The start date
         * @return This builder
         */
        Builder startDate(Date date);

        /**
         * Sets the expiration date of the ban, or removes it.
         *
         * @param date The expiration date, or null in order to remove it
         * @return This builder
         */
        Builder expirationDate(@Nullable Date date);

        /**
         * Sets the source of the ban, or removes it if {@code null} is passed in.
         *
         * @param source The source of the ban, or {@code null}
         * @return This builder
         */
        Builder source(@Nullable CommandSource source);

        /**
         * Creates a new Ban from this builder.
         *
         * @return A new Ban
         */
        Ban build();

    }
}
