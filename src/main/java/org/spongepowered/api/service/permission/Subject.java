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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.context.Contextual;
import org.spongepowered.api.util.Tristate;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * An object which can hold permission data.
 *
 * <p>Subjects are objects which hold permission data, in the form of
 * {@link SubjectData}. They can also be the source of permission requests.</p>
 *
 * <p>The most common forms of Subject are "users" and "groups", although these
 * are not the only forms. Anything can hold permission data, and therefore be a
 * subject.</p>
 *
 * <p>Authorization checks are made using "permission strings."</p>
 *
 * <p>Permission strings are hierarchical with each level separated by periods
 * (full stops). An example of a valid permission string is {@code
 * example.function}. Inheritance is implicit; that is, if a subject has been
 * granted {@code example}, then the subject should have also be automatically
 * granted {@code example.function}, {@code example.another}, {@code
 * example.deeper.nesting}, and so on. However, implementations may allow
 * administrators to configure "negation" such that {@code example} and all
 * child levels would granted but {@code example.access} would denied (for
 * example).</p>
 *
 * <p>It is the responsibility of the {@link PermissionService} implementation
 * to provide this behavior, and resolve the implicit permission node
 * inheritance explained above when a Subject is queried for permissions. Use
 * of a {@link NodeTree} is recommended.</p>
 *
 * <p>Plugins may opt to implement "dynamic" permissions such as {@code
 * example.region.define.[region]} where {@code region} would depend on
 * the context of the check. Attention should be made towards the handling of
 * periods / full stops in such cases.</p>
 *
 * <p>Due to the implicit inheritance, it is recommended that commands that
 * allow a user to "apply" an effect to other users use
 * {@code example.function.self} as the permission for applying this effect
 * to one's self. This allows administrators to grant
 * {@code example.function.self} to permit usage on one's self and grant
 * {@code example.function} to grant usage on other users.</p>
 *
 * <p>All methods are expected to account for data inherited from parent
 * subjects. For a representation of the data that the subject explicitly holds,
 * obtain the {@link SubjectData} for the subject.</p>
 *
 * <p>Additionally, all methods are expected to account for the defaults
 * defined in the {@link SubjectCollection} containing this subject, as well
 * as the defaults set globally in {@link PermissionService#defaults()}.</p>
 *
 * <p>Use a {@link SubjectCollection} to create instances.</p>
 *
 * @see PermissionService
 */
public interface Subject extends Contextual {

    /**
     * Returns the subject collection this subject is a member of.
     *
     * @return The appropriate collection
     */
    SubjectCollection containingCollection();

    /**
     * Gets a SubjectReference representing this subject.
     *
     * @return A subject reference representing this subject
     */
    SubjectReference asSubjectReference();

    /**
     * Get the game object that may be associated with this subject.
     *
     * <p>This could be a player, system subject, or something else. The return
     * value of this method should not be stored.</p>
     *
     * @return a potential game object
     */
    Optional<?> associatedObject();

    /**
     * Returns if this Subject has persistent, non-transient data.
     *
     * <p>If true, this subject should have two distinct stores of SubjectData,
     * and the non-transient form should be saved between sessions.</p>
     *
     * <p>If false, this subject will have only one store of SubjectData, which
     * will not be persisted between sessions.</p>
     *
     * @return If this Subject has persistent, non-transient data.
     */
    boolean isSubjectDataPersisted();

    /**
     * Returns the primary data backing for this Subject.
     *
     * <p>If this Subject is not persisted, this data will not be saved
     * between sessions.</p>
     *
     * <p>For subjects which are not persisted, the same store will be returned
     * by {@link #transientSubjectData()}.</p>
     *
     * @return The primary data backing for this Subject
     */
    SubjectData subjectData();

    /**
     * Returns the transient data backing for this Subject.
     *
     * <p>Transient data is guaranteed to only last for the duration of the
     * subject's session, and is not persisted.</p>
     *
     * <p>For subjects which are not persisted, the same store will be returned
     * by {@link #subjectData()}.</p>
     *
     * @return The transient data backing for this Subject
     */
    SubjectData transientSubjectData();

    /**
     * Test whether the subject is permitted to perform an action given as the
     * given permission string.
     *
     * <p>This must return the same value as {@link #hasPermission(String, Cause)}
     * called with the phase tracker's current cause.
     *
     * @param permission The permission string
     * @return True if permission is granted
     */
    default boolean hasPermission(final String permission) {
        return this.hasPermission(permission, Sponge.server().causeStackManager().currentCause());
    }

    /**
     * Test whether the subject is permitted to perform an action corresponding
     * to the given permission string.
     *
     * <p>This must return the same boolean equivalent as
     * {@link #permissionValue(String, Cause)}.</p>
     *
     * @param permission The permission string
     * @param cause The cause stack to extract context information from
     * @return True if permission is granted
     */
    default boolean hasPermission(final String permission, final Cause cause) {
        return this.permissionValue(permission, cause).asBoolean();
    }

    /**
     * Test whether the subject is permitted to perform an action corresponding
     * to the given permission string.
     *
     * <p>This must return the same boolean equivalent as
     * {@link #permissionValue(String, Cause)}.</p>
     *
     * @param permission The permission string
     * @param contexts The contexts to calculate permission status in
     * @return True if permission is granted
     */
    default boolean hasPermission(final String permission, final Set<Context> contexts) {
        return this.permissionValue(permission, contexts).asBoolean();
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
     * {@link PermissionService#defaults()} should be considered for this
     * lookup.</p>
     *
     * <p>This method is likely to be called frequently, so it is desirable
     * that implementations cache the results to method calls.</p>
     *
     * @param permission The permission to check
     * @return The tristate result of the check
     */
    default Tristate permissionValue(final String permission) {
        return this.permissionValue(permission, Sponge.server().causeStackManager().currentCause());
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
     * {@link PermissionService#defaults()} should be considered for this
     * lookup.</p>
     *
     * <p>This method is likely to be called frequently, so it is desirable
     * that implementations cache the results to method calls.</p>
     *
     * @param permission The permission to check
     * @param cause The cause to gather context from.
     * @return The tristate result of the check
     */
    Tristate permissionValue(String permission, Cause cause);

    /**
     * Returns the calculated value set for a given permission.
     *
     * <p>It is expected that this method will also account for values
     * inherited from parent subjects, as well as permission nodes inherited
     * implicitly from a more generic level.</p>
     *
     * <p>Additionally, the defaults defined the {@link SubjectCollection}
     * that holds this subject, as well as defaults defined in
     * {@link PermissionService#defaults()} should be considered for this
     * lookup.</p>
     *
     * <p>This method is likely to be called frequently, so it is desirable
     * that implementations cache the results to method calls.</p>
     *
     * @param permission The permission to check
     * @param contexts The contexts to query permission value in
     * @return The tristate result of the check
     */
    Tristate permissionValue(String permission, Set<Context> contexts);

    /**
     * Check if this subject is a child of the given parent in the subject's
     * current context, traversing inheritance.
     *
     * <p>This must return the same value as
     * {@link #isChildOf(SubjectReference, Cause)} called with the phase
     * tracker's current cause.
     *
     * @param parent The parent to check for inheritance
     * @return Whether this is a child of the given parent
     */
    default boolean isChildOf(final SubjectReference parent) {
        return this.isChildOf(parent, Sponge.server().causeStackManager().currentCause());
    }

    /**
     * Check if this subject is a child of the given parent in the given context
     * combination, traversing inheritance.
     *
     * <p>It is expected that this method will also account for data from
     * distant parents, inherited from direct parent subjects.
     *
     * <p>Additionally, the defaults defined the {@link SubjectCollection}
     * that holds this subject, as well as defaults defined in
     * {@link PermissionService#defaults()} should be considered for this
     * lookup.</p>
     *
     * @param parent The parent to check for inheritance
     * @param cause The cause to gather context from.
     * @return Whether this is a child of the given parent
     */
    boolean isChildOf(SubjectReference parent, Cause cause);

    /**
     * Check if this subject is a child of the given parent in the given context
     * combination, traversing inheritance.
     *
     * <p>It is expected that this method will also account for data from
     * distant parents, inherited from direct parent subjects.
     *
     * <p>Additionally, the defaults defined the {@link SubjectCollection}
     * that holds this subject, as well as defaults defined in
     * {@link PermissionService#defaults()} should be considered for this
     * lookup.</p>
     *
     * @param parent The parent to check for inheritance
     * @param contexts The contexts to query inheritance in
     * @return Whether this is a child of the given parent
     */
    boolean isChildOf(SubjectReference parent, Set<Context> contexts);

    /**
     * Return all parents that this group has in its current context
     * combination.
     *
     * <p>This must include inherited values if the permissions
     * service supports inheritance.</p>
     *
     * <p>It must also must return the same value as {@link #parents(Cause)}
     *
     * @return An immutable list of parents
     */
    default List<? extends SubjectReference> parents() {
        return this.parents(Sponge.server().causeStackManager().currentCause());
    }

    /**
     * Return all parents that this group has in the given context combination.
     *
     * <p>This must include inherited values if the permissions
     * service supports inheritance.</p>
     *
     * @param cause The cause to gather context from.
     * @return An immutable list of parents
     */
    List<? extends SubjectReference> parents(Cause cause);

    /**
     * Return all parents that this group has in the given context combination.
     *
     * <p>This must include inherited values if the permissions
     * service supports inheritance.</p>
     *
     * @param contexts The cause to gather context from.
     * @return An immutable list of parents
     */
    List<? extends SubjectReference> parents(Set<Context> contexts);

    /**
     * Gets the value of a given option in the subject's current context.
     *
     * <p>This must return the same value as {@link #option(String, Cause)}
     * called with the phase tracker's current cause.
     *
     * @param key The key to get an option by. Case-insensitive.
     * @return The value of the option, if any is present
     */
    default Optional<String> option(final String key) {
        return this.option(key, Sponge.server().causeStackManager().currentCause());
    }

    /**
     * Gets the value of a given option in the given context.
     *
     * <p>It is expected that this method will account for options
     * inherited from parent subjects.
     *
     * <p>Additionally, the default options defined by the
     * {@link SubjectCollection} that holds this subject, as well as defaults
     * defined in {@link PermissionService#defaults()} should be considered
     * for this lookup.
     *
     * @param key The key to get an option by. Case-insensitive.
     * @param cause The cause to gather context from.
     * @return The value of the option, if any is present
     */
    Optional<String> option(String key, Cause cause);

    /**
     * Gets the value of a given option in the given context.
     *
     * <p>It is expected that this method will account for options
     * inherited from parent subjects.
     *
     * <p>Additionally, the default options defined by the
     * {@link SubjectCollection} that holds this subject, as well as defaults
     * defined in {@link PermissionService#defaults()} should be considered
     * for this lookup.
     *
     * @param key The key to get an option by. Case-insensitive.
     * @param contexts The context set to use when calculating causes
     * @return The value of the option, if any is present
     */
    Optional<String> option(String key, Set<Context> contexts);
}
