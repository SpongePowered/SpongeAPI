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

package org.spongepowered.api.service.permission;

import com.google.common.base.Optional;
import org.spongepowered.api.service.permission.context.Context;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.util.command.CommandSource;

import java.util.List;
import java.util.Set;

/**
 * A source of permission requests.
 *
 * <p>Authorization checks are made using "permission strings."
 *
 * <p>Permission strings are hierarchical with each level separated by periods
 * (full stops). An example of a valid permission string is {@code
 * example.function}. Inheritance is implicit; that is, if a subject has been
 * granted {@code example}, then the subject should have also be automatically
 * granted {@code example.function}, {@code example.another}, {@code
 * example.deeper.nesting}, and so on. However, implementations may allow
 * administrators to configure "negation" such that {@code example} and all
 * child levels would granted but {@code example.access} would denied (for
 * example).
 *
 * <p>Plugins may opt to implement "dynamic" permissions such as {@code
 * example.region.define.&lt;region&gt;} where {@code region} would be a
 * dynamically added level based on the context, though some attention should be
 * made towards the handling of periods / full stops in such cases.
 *
 * <p>Due to the implicit inheritance, it is recommended that commands that allow a
 * user to "apply" an effect to other users use {@code example.function.self} as
 * the permission for applying this effect to one's self. This allows
 * administrators to grant {@code example.function.self} to permit usage on
 * one's self and grant {@code example.function} to grant usage on other users.
 *
 * <p>Use a {@link PermissionService} to create instances.
 *
 * @see PermissionService
 */
public interface Subject {

    /**
     * Returns the identifier associated with this subject. May not be
     * human-readable, but always refers to a single subject
     *
     * @return The unique identifier for this subject
     */
    String getIdentifier();

    /**
     * If this subject represents an actual user currently connected, this
     * method returns this user. This user may in fact be the same as this
     * subject. Some subjects may never directly map to a command source, while
     * others may temporarily not have an accessible command source
     *
     * @return an optional active command source
     */
    Optional<CommandSource> getCommandSource();

    /**
     * Returns the subject collection this subject is a member of.
     *
     * @return The appropriate collection
     */
    SubjectCollection getContainingCollection();

    /**
     * The container for permissions data that *may* be persisted if the service
     * provider supports it.
     *
     * @return The container for permissions data this subject uses
     */
    SubjectData getData();

    /**
     * Returns container for subject data that is guaranteed to be transient
     * (only lasting for the duration of the subject's session, not persisted).
     * This might return the same object as {@link #getData()} if the provider
     * for this service does not implement persistence for permissions data
     *
     * @return Transient data storage for this subject
     */
    SubjectData getTransientData();

    /**
     * Test whether the subject is permitted to perform an action given as the
     * given permission string.

     * @param contexts The set of contexts that represents the subject's current environment
     * @param permission The permission string
     * @return True if permission is granted
     */
    boolean hasPermission(Set<Context> contexts, String permission);

    /**
     * Test whether the subject is permitted to perform an action given as the
     * given permission string.
     *
     * @param permission The permission string
     * @return True if permission is granted
     */
    boolean hasPermission(String permission);

    /**
     * Returns the calculated value set for a given permission.
     *
     * @param contexts The contexts to check for permissions in
     * @param permission The permission to check
     * @return The tristate true/false/unset value for permissions
     */
    Tristate getPermissionValue(Set<Context> contexts, String permission);

    /**
     * Check if this subject is a child of the given parent in the subject's
     * current context, traversing inheritance.
     *
     * @param parent The parent to check for inheritance
     * @return Whether this is a child of the given parent
     */
    boolean isChildOf(Subject parent);

    /**
     * Check if this subject is a child of the given parent in the given context
     * combination, traversing inheritance.
     *
     * @param contexts The context combination to check in
     * @param parent The parent to check for inheritance
     * @return Whether this is a child of the given parent
     */
    boolean isChildOf(Set<Context> contexts, Subject parent);

    /**
     * Return all parents that this group has in its current context
     * combination. This must include inherited values if the permissions
     * service supports inheritance.
     *
     * @return An immutable list of parents
     */
    List<Subject> getParents();

    /**
     * Return all parents that this group has. This must include inherited
     * values if the permissions service supports inheritance.
     *
     * @param contexts The set of contexts that represents the subject's current environment
     * @return An immutable list of parents
     */
    List<Subject> getParents(Set<Context> contexts);

    /**
     * Calculate active contexts, using the {@link org.spongepowered.api.service.permission.context.ContextCalculator}s
     * from {@link PermissionService#registerContextCalculator(org.spongepowered.api.service.permission.context.ContextCalculator)}.
     * The result of these calculations may be cached.
     *
     * @return An immutable set of active contexts
     */
    Set<Context> getActiveContexts();
}
