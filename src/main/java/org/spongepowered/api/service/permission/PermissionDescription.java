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

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.plugin.PluginContainer;
import org.spongepowered.api.util.Tristate;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * A description object for permissions.
 *
 * <p>The description is meant to provide human readable descriptions and
 * metadata for a permission, and a central point for the plugin registering
 * each permission.</p>
 *
 * <p>Descriptions are primarily informational, but some default value
 * information may be provided here.</p>
 *
 * <p>Instances can be built using
 * {@link PermissionService#newDescriptionBuilder(PluginContainer)}.</p>
 */
public interface PermissionDescription {

    /**
     * The standard role for users.
     *
     * <p>The user role should be assigned to permissions where everyone should
     * have basic access. For example: joining in an arena.</p>
     */
    String ROLE_USER = "user";

    /**
     * The standard role for staff.
     *
     * <p>The staff role should be assigned to permissions only meant for users
     * with elevated access permissions. For example: force start an arena.</p>
     */
    String ROLE_STAFF = "staff";

    /**
     * The standard role for admins.
     *
     * <p>The admin role should be assigned to permissions only meant for users
     * with full access to administrate the server. For example: setup an
     * arena.</p>
     */
    String ROLE_ADMIN = "admin";

    /**
     * Gets the permission id this description belongs to.
     *
     * <p>The permission id must be of the specified format as specified using
     * EBNF:
     * <ul>
     * <li>CHARACTER  = "A" - "Z" | "a" - "z" | "0" - "9" | "_" | "-"</li>
     * <li>NAME       = CHARACTER , { CHARACTER }</li>
     * <li>TEMPLATE   = "&lt;" , NAME , "&gt;"</li>
     * <li>PERMISSION = NAME , { "." , NAME }, {".", TEMPLATE}</li>
     * </ul>
     *
     * <p>The following examples shall help you to structure your permissions
     * well:
     * <ul>
     * <li>"myplugin" - Grants everything in myPlugin</li>
     * <li>"myplugin.give" - Grants everything related to give including
     * all ItemTypes and Enchantments</li>
     * <li>"myplugin.give.execute" - Allows the execution of give</li>
     * <li>"myplugin.give.type" - Grants all ItemTypes</li>
     * <li>"myplugin.give.type.&lt;item-type&gt;" - A template should not be
     * granted to anybody</li>
     * <li>"myplugin.give.type.minecraft.diamond" - Only
     * grants minecraft:diamond</li>
     * <li>"myplugin.give.enchantment" - Grants all Enchantments</li>
     * <li>"myplugin.give.others" - Allow giving to other players</li>
     * </ul>
     * The addition of the "execute" permission instead of just "myPlugin.give"
     * permission is useful to prevent unauthorized access to sub-permissions
     * that are not documented or have been added lately.
     *
     * <p>
     * So if you want to allow someone to give themself only DIAMONDs, you would
     * assign them the following permissions:
     * <ul>
     * <li>"myplugin.give.execute"</li>
     * <li>"myplugin.give.type.minecraft.diamond"</li>
     * </ul>
     *
     * <p><b>Note:</b> Permission ids are case insensitive!
     * If permission ids do not start with the plugin ID, implementations will
     * prepend the plugin ID (so {@code command.give} will turn into
     * {@code myplugin.command.give}<)/p>
     *
     * @return The permission id
     */
    String id();

    /**
     * Gets a short description of the linked permission.
     *
     * <p>May include a link to a more detailed description on the plugin's
     * web page.</p>
     *
     * <p>Will return an empty optional for descriptions which have been
     * automatically generated, or where a description was omitted when the
     * {@link PermissionDescription} was created.</p>
     *
     * @return A short description of the linked permission
     */
    Optional<Component> description();

    /**
     * Gets the owning plugin the permission belongs to.
     *
     * <p>Will return an empty optional for descriptions which have been
     * automatically generated.</p>
     *
     * @return The owning plugin the permission belongs to
     */
    Optional<PluginContainer> owner();

    /**
     * Gets the default value this permission should have on this server.
     * This value will have been applied to the default subject.
     *
     * @return The default value for this permission.
     */
    Tristate defaultValue();

    /**
     * Gets all subjects that have this permission set in the given collection.
     *
     * <p>If you want to know to which role-templates this permission is
     * assigned, use {@link PermissionService#SUBJECTS_ROLE_TEMPLATE}.
     *
     * <p>This method is equivalent to calling
     * {@link SubjectCollection#allWithPermission(String)} for the given
     * collection, using {@link #id()} as the permission.</p>
     *
     * @param collectionIdentifier The subject collection to query
     * @return A reference to any subject known to have this permission
     *         set, and the value this permission is set to
     * @see SubjectCollection#allWithPermission(String)
     */
    CompletableFuture<Map<? extends SubjectReference, Boolean>> findAssignedSubjects(String collectionIdentifier);

    /**
     * Gets all loaded subjects that have this permission set in the given
     * collection.
     *
     * <p>If you want to know to which role-templates this permission is
     * assigned, use {@link PermissionService#SUBJECTS_ROLE_TEMPLATE}.</p>
     *
     * <p>This method is equivalent to calling
     * {@link SubjectCollection#loadedWithPermission(String)} for the given
     * collection, using {@link #id()} as the permission.</p>
     *
     * <p>This method will return an empty map if the given collection is not
     * loaded or does not exist.</p>
     *
     * @param collectionIdentifier The subject collection to query
     * @return An immutable map of subjects that have this permission set
     * @see SubjectCollection#loadedWithPermission(String)
     */
    Map<? extends Subject, Boolean> assignedSubjects(String collectionIdentifier);

    /**
     * Check if the given subject has the permission described.
     *
     * <p>If {@link #id()} contains any template
     * parameters, they will be stripped out. See overloads if parameters
     * are desired.</p>
     *
     * @param subj The subject to query
     * @return Whether the given subject has this permission.
     */
    boolean query(Subject subj);

    /**
     * Check if the given subject has the permission described.
     *
     * <p>Template parameters will be trimmed, and the catalog key will be
     * appended in the format
     * {@link ResourceKey#namespace()}.{@link ResourceKey#value()}.</p>
     *
     * @param subj The subject to query
     * @param key The catalog key to relativize this permission for
     * @return Whether the given subject has this permission.
     */
    boolean query(Subject subj, ResourceKey key);

    /**
     * Check if the given subject has the permission described.
     *
     * <p>Template parameters will be trimmed from the permission,
     * and the given parameters will be appended joined by {@code .}.</p>
     *
     * @param subj The subject to query
     * @param parameters The parameters to append to the permission being checked
     * @return Whether the given subject has this permission.
     */
    boolean query(Subject subj, String... parameters);

    /**
     * Check if the given subject has the permission described.
     *
     * <p>Template parameters will be trimmed from the permission, and the given
     * parameter will be appended</p>
     *
     * @param subj The subject to query
     * @param parameter The parameter to append to the permission when checking
     * @return Whether the given subject has this permission.
     */
    boolean query(Subject subj, String parameter);

    /**
     * A builder for permission descriptions.
     */
    interface Builder {

        /**
         * Sets the permission id for the description this builder creates.
         *
         * <p>See {@link PermissionDescription#id()} for format
         * specifications.</p>
         *
         * @param permissionId The permission id
         * @return This builder for chaining
         */
        Builder id(String permissionId);

        /**
         * Sets the short description to use.
         *
         * <p>May include a link to a more detailed description on the plugin's
         * web page.</p>
         *
         * <p>Can be null if the permission does not have a description.</p>
         *
         * @param description The short description to use
         * @return This builder for chaining
         */
        Builder description(@Nullable Component description);

        /**
         * Assigns this permission to the given role-template {@link Subject}.
         *
         * <p>Role templates will be namespaced by the plugin that owns each
         * registered permission. The expected format of the namespaced subject
         * identifier is {@code <plugin id>:<role>}. Implementations must
         * provide an un-namespaced role template that inherits its permissions
         * from every plugin-namespaced role template.</p>
         *
         * <p>If the given subject does not exist it will be created.</p>
         *
         * <p>It is recommended to use the standard role suggestions expressed
         * as static parameters in {@link PermissionDescription}.</p>
         *
         * <p>Do not assign a permission to user, staff and admin at the same
         * time but solve this with subject inheritance if possible.</p>
         *
         * <p><b>Note:</b> The permissions are only assigned during
         * {@link #register()}.</p>
         *
         * @param role The role-template to assign the permission to. See
         *             constants in {@link PermissionDescription} for common
         *             roles (not exhaustive).
         * @param value The value to to assign
         * @return This builder for chaining
         */
        Builder assign(String role, boolean value);


        /**
         * Sets a value that this permission should have by default.
         * This can be used to exclude permissions from node tree inheritance,
         * or to provide a permission to users by default.
         *
         * <p>This is shorthand for giving {@link #id()} (with templates
         * stripped) a value on the default subject, except that the default
         * value will only be applied once {@link #register()} is called.</p>
         *
         * <p>Assigning default permissions should be used sparingly, and by
         * convention, only in situations where "default" game behaviour is restored
         * by granting a certain permission.</p>
         *
         * @param defaultValue The value this permission should have for
         *                      subjects where none has been assigned.
         * @return The builder for chaining.
         */
        Builder defaultValue(Tristate defaultValue);

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
