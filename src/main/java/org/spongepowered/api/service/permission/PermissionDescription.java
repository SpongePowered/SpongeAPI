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

import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import java.util.Map;

/**
 * A description object for permissions. The description is meant to provide
 * human readable descriptions and meta data for a permission. Instances should
 * be registered at the {@link PermissionService}, but the registration does not
 * have any impact on the results of the permission checks of the service.
 */
public interface PermissionDescription {

    /**
     * The user role should be assigned to everyone who should have basic access
     * permissions. For example: joining in an arena.
     */
    String ROLE_USER = "user";
    /**
     * The staff role should be assigned to everyone who should have elevated
     * access permissions. For example: force start an arena.
     */
    String ROLE_STAFF = "staff";
    /**
     * The admin role should be assigned to everyone who should have full access
     * permissions. For example: setup an arena.
     */
    String ROLE_ADMIN = "admin";

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
     * <p>The following examples shall help you to structure your permissions
     * well:
     * <ul>
     * <li>"myplugin" - Grants everything in myPlugin</li>
     * <li>"myplugin.give" - Grants everything related to give including
     * all ItemTypes and Enchantments</li>
     * <li>"myplugin.give.execute" - Allows the execution of give</li>
     * <li>"myplugin.give.type" - Grants all ItemTypes</li>
     * <li>"myplugin.give.type.&ltItemType&gt" - A template should not be
     * granted to anybody</li>
     * <li>"myplugin.give.type.DIAMOND" - Only grants DIAMOND</li>
     * <li>"myplugin.give.enchantment" - Grants all Enchantments</li>
     * <li>"myplugin.give.others" - Allow giving to other players</li>
     * </ul>
     * The addition of the "execute" permission instead of just "myPlugin.give"
     * permission is useful to prevent unauthorized access to sub-permissions
     * that are not documented or have been added lately.
     * </p>
     *
     * <p>
     * So if you want to allow someone to give themself only DIAMONDs, you would
     * assign them the following permissions:
     * <ul>
     * <li>"myPlugin.give.execute"</li>
     * <li>"myPlugin.give.type.DIAMOND"</li>
     * </ul>
     * </p>
     *
     * <p><b>Note:</b> Permission ids are case insensitive! Permission ids
     * should start with the owning plugin's id.</p>
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
     * Get all subjects that have this permission set.
     *
     * <p>If you want to know to which role-templates this permission is
     * assigned use {@link PermissionService#SUBJECTS_ROLE_TEMPLATE}.
     *
     * @param type The subject type identifier to use
     * @return An immutable set of subjects that have this permission set
     * @see SubjectCollection#getAllWithPermission(String)
     */
    Map<Subject, Boolean> getAssignedSubjects(String type);

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
         * Assigns this permission to the given role-template {@link Subject}.
         * If the given subject does not exist it will be created. It is
         * recommended to use the role suggestions provided
         * by {@link PermissionDescription}. Please
         * do not assign a permission to user, staff and admin at the same time
         * but solve this with subject inheritance if possible.
         *
         * <p><b>Note:</b> The permissions are only assigned during
         * {@link #register()}. Permission templates should not be assigned to
         * anyone.</p>
         *
         * @param role The role-template to assign the permission to. See
         *      constants in {@link PermissionDescription} for common roles
         *      (not exhaustive).
         * @param value The value to to assign
         * @return This builder for chaining
         */
        Builder assign(String role, boolean value);

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
    }

}
