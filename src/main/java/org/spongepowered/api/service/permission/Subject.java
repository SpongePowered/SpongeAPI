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

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.context.Contextual;
import org.spongepowered.api.util.Tristate;

import java.util.List;
import java.util.Optional;
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
 * <p>It is the responsibility of the {@link PermissionService} implementation
 * to provide this behavior, and resolve the implicit permission node
 * inheritance explained above when a Subject is queried for permissions. Use
 * of a {@link NodeTree} is recommended.
 *
 * <p>Plugins may opt to implement "dynamic" permissions such as {@code
 * example.region.define.&lt;region&gt;} where {@code region} would be a
 * dynamically added level based on the context, though some attention should be
 * made towards the handling of periods / full stops in such cases.
 *
 * <p>Due to the implicit inheritance, it is recommended that commands that
 * allow a user to "apply" an effect to other users use
 * {@code example.function.self} as the permission for applying this effect
 * to one's self. This allows administrators to grant
 * {@code example.function.self} to permit usage on one's self and grant
 * {@code example.function} to grant usage on other users.
 *
 * <p>All methods are expected unlike {@link SubjectData}, to account for data
 * inherited from parent subjects. For a representation of the data that the
 * subject explicitly holds, obtain the {@link SubjectData} for the object.
 *
 * <p>Additionally, all methods are expected to account for the defaults
 * defined in the {@link SubjectCollection} containing this subject, as well
 * as the defaults set globally in {@link PermissionService#getDefaults()}.
 *
 * <p>Use a {@link SubjectCollection} to create instances.
 *
 * @see PermissionService
 */
public interface Subject extends Contextual {

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
    SubjectData getSubjectData();

    /**
     * Returns container for subject data that is guaranteed to be transient
     * (only lasting for the duration of the subject's session, not persisted).
     * This might return the same object as {@link #getSubjectData()} if the
     * provider for this service does not implement persistence for permissions
     * data.
     *
     * @return Transient data storage for this subject
     */
    SubjectData getTransientSubjectData();

    /**
     * Test whether the subject is permitted to perform an action corresponding
     * to the given permission string. This must return the same boolean
     * equivalent as {@link #getPermissionValue(Set, String)}.
     *
     * @param contexts The set of contexts that represents the subject's current
     *     environment
     * @param permission The permission string
     * @return True if permission is granted
     */
    default boolean hasPermission(Set<Context> contexts, String permission) {
        return getPermissionValue(contexts, permission).asBoolean();
    }

    /**
     * Test whether the subject is permitted to perform an action given as the
     * given permission string. This must return the same value as
     * {@link #hasPermission(Set, String)} using {@link #getActiveContexts()}.
     *
     * @param permission The permission string
     * @return True if permission is granted
     */
    default boolean hasPermission(String permission) {
        return hasPermission(getActiveContexts(), permission);
    }

    /**
     * Returns the calculated value set for a given permission.
     *
     * <p>It is expected that this method will also account for values
     * inherited from parent subjects, as well as permission nodes inherited
     * implicitly from a more generic level.</p>
     *
     * <p>Additionally, the defaults defined the {@link SubjectCollection}
     * that holds this subject, as well as defaults defined in
     * {@link PermissionService#getDefaults()} should be considered for this
     * lookup.</p>
     *
     * <p>This method is likely to be called frequently, so it is desirable
     * that implementations cache the results to method calls.</p>
     *
     * @param contexts The contexts to check for permissions in
     * @param permission The permission to check
     * @return The tristate true/false/unset value for permissions
     */
    Tristate getPermissionValue(Set<Context> contexts, String permission);

    /**
     * Check if this subject is a child of the given parent in the subject's
     * current context, traversing inheritance. This must return the same value
     * as {@link #isChildOf(Set, Subject)} using {@link #getActiveContexts()}.
     *
     * @param parent The parent to check for inheritance
     * @return Whether this is a child of the given parent
     */
    default boolean isChildOf(Subject parent) {
        return isChildOf(getActiveContexts(), parent);
    }

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
     * service supports inheritance. This must return the same value as
     * {@link #getParents(Set)} using {@link #getActiveContexts()}.
     *
     * @return An immutable list of parents
     */
    default List<Subject> getParents() {
        return getParents(getActiveContexts());
    }

    /**
     * Return all parents that this group has. This must include inherited
     * values if the permissions service supports inheritance.
     *
     * @param contexts The set of contexts that represents the subject's
     *     current environment
     * @return An immutable list of parents
     */
    List<Subject> getParents(Set<Context> contexts);

    /**
     * Gets the value of a given option in the given context.
     *
     * <p>It is expected that this method will account for options
     * inherited from parent subjects.
     *
     * <p>Additionally, the default options defined the {@link SubjectCollection}
     * that holds this subject, as well as defaults defined in
     * {@link PermissionService#getDefaults()} should be considered for this lookup.
     *
     * @param contexts The contexts to get the options from
     * @param key The key to get an option by. Case-insensitive.
     * @return The value of the option, if any is present
     */
    Optional<String> getOption(Set<Context> contexts, String key);

    /**
     * Gets the value of a given option in the subject's current context
     * This must return the same value as {@link #getOption(Set, String)}
     * using {@link #getActiveContexts()}.
     *
     * @param key The key to get an option by. Case-insensitive.
     * @return The value of the option, if any is present
     */
    default Optional<String> getOption(String key) {
        return getOption(getActiveContexts(), key);
    }
}
