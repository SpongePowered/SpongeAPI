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

package org.spongepowered.api.service.permission;

import com.google.common.base.Optional;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;

/**
 * A description object for permissions. The description is meant to provide
 * human readable descriptions and meta data for a permission. Instances should
 * be registered at the {@link PermissionService}, but the registration does not
 * have any impact on the results of the permission checks of the service.
 */
public interface PermissionDescription {

    /**
     * A permission with this rank can be granted to anybody including the
     * untrusted guests. For most servers there is no difference between
     * {@link #RANK_GUEST} and {@link #RANK_USER}.
     *
     * <p>Examples can be chat, MotD receive.</p>
     */
    static final String RANK_GUEST = "guest";
    /**
     * A permission with this rank can be granted to anybody that should have
     * default user access. For most servers there is no difference between
     * {@link #RANK_GUEST} and {@link #RANK_USER}.
     *
     * <p>Examples can be claim city plot, access to games and public warps.</p>
     */
    static final String RANK_USER = "user";
    /**
     * A permission with this rank should only be granted to known server staff.
     * The permission's impact on the server is quite low.
     *
     * <p>Examples can be give items, teleport other players, access to support
     * commands, globally mute other players.</p>
     */
    static final String RANK_STAFF = "staff";
    /**
     * A permission with this rank should only be granted to fully trusted
     * server administrators. The permission's impact on the server may be high.
     *
     * <p>Examples can be create/delete worlds, grant permissions, restart
     * server.</p>
     */
    static final String RANK_ADMIN = "admin";
    /**
     * A permission with this rank should normally not granted to anybody. This
     * usually applies to debug permissions or specializations of permissions
     * that would already be granted.
     *
     * <p>Examples can be show debug messages or myPlugin.give.type.DIRT where
     * myPlugin.give.type is already granted.</p>
     */
    static final String RANK_NOBODY = "nobody";

    /**
     * Gets the permission id this description belongs too.
     *
     * <p>The permission id must be of the specified format as specified using
     * EBNF:
     * <ul>
     * <li>CHARACTER  = "A" - "Z" | "a" - "z" | "0" - "9" | "_" | "-"</li>
     * <li>NAME       = CHARACTER , { CHARACTER }</li>
     * <li>TEMPLATE   = "&lt" , NAME , "&gt"</li>
     * <li>PART       = NAME | TEMPLATE</li>
     * <li>PERMISSION = NAME , { "." , PART }</li>
     * </ul>
     * </p>
     *
     * <p>Examples:
     * <ul>
     * <li>"myPlugin.give.type" - Grants all ItemTypes</li>
     * <li>"myPlugin.give.type.&ltItemType&gt" - A template should not be granted to anybody</li>
     * <li>"myPlugin.give.type.DIAMOND" - Only grants DIAMOND</li>
     * </ul>
     * </p>
     *
     * <p><b>Note:</b> Permission ids are case insensitive! Permission ids should
     * start with the owning plugin's id.</p>
     *
     * @return The permission id
     */
    String getId();

    /**
     * Gets a short description of the linked permission. May include a link to
     * a more detailed description on the plugin's web page.
     *
     * @return A short description of the linked permission
     */
    Text getDescription();

    /**
     * Gets the human readable <b>suggested</b> rank the players should have
     * before they should have access to this permission.
     *
     * <p><b>Note:</b> This is a suggestion for server owners and does not have
     * any impact on the results of the permission checks.</p>
     *
     * @return The suggested player rank the permission should be granted to
     */
    Optional<String> getSuggestedRank();

    /**
     * Gets the owning plugin the permission belongs to.
     *
     * @return The owning plugin the permission belongs to
     */
    PluginContainer getOwner();

    /**
     * A builder for permission descriptions.
     */
    interface Builder {

        /**
         * Sets the permission id for the description this builder creates. See
         * {@link PermissionDescription#getId()} for format specifications.
         *
         * @param permissionId The permission id
         * @return This builder for chaining
         */
        Builder id(String permissionId);

        /**
         * Sets the short description to use. May include a link to a more
         * detailed description on the plugin's web page.
         *
         * @param description The short description to use
         * @return This builder for chaining
         */
        Builder description(Text description);

        /**
         * Sets the suggested rank players should have before being able to
         * access this permission. Setting this is optional although
         * recommended.
         *
         * @param rank The suggested rank to have
         * @return This builder for chaining
         */
        Builder suggestedRank(@Nullable String rank);

        /**
         * Creates and registers a new {@link PermissionDescription} instance
         * with the given settings.
         *
         * @return The newly created permission description instance
         * @throws IllegalStateException If there are any settings left unset or
         *         a description with the given permission id was already
         *         registered and the {@link PermissionService} does not support
         *         overwriting descriptions
         */
        PermissionDescription register() throws IllegalStateException;

        /**
         * Resets this builder to its default settings.
         *
         * @return This builder for chaining
         */
        Builder reset();

    }

}
