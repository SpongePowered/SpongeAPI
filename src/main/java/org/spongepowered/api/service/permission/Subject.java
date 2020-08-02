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
 * as the defaults set globally in {@link PermissionService#getDefaults()}.</p>
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
    SubjectCollection getContainingCollection();

    /**
     * Gets a SubjectReference representing this subject.
     *
     * @return A subject reference representing this subject
     */
    SubjectReference asSubjectReference();

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
     * by {@link #getTransientSubjectData()}.</p>
     *
     * @return The primary data backing for this Subject
     */
    SubjectData getSubjectData();

    /**
     * Returns the transient data backing for this Subject.
     *
     * <p>Transient data is guaranteed to only last for the duration of the
     * subject's session, and is not persisted.</p>
     *
     * <p>For subjects which are not persisted, the same store will be returned
     * by {@link #getSubjectData()}.</p>
     *
     * @return The transient data backing for this Subject
     */
    SubjectData getTransientSubjectData();

    /**
     * Test whether the subject is permitted to perform an action corresponding
     * to the given permission string.
     *
     * <p>This must return the same boolean equivalent as
     * {@link #getPermissionValue(Set, String)}.</p>
     *
     * @param contexts The set of contexts that represents the subject's current
     *     environment
     * @param permission The permission string
     * @return True if permission is granted
     */
    default boolean hasPermission(final Set<Context> contexts, final String permission) {
        return this.getPermissionValue(contexts, permission).asBoolean();
    }

    /**
     * Test whether the subject is permitted to perform an action given as the
     * given permission string.
     *
     * <p>This must return the same value as {@link #hasPermission(Set, String)}
     * using {@link #getActiveContexts()}.</p>
     *
     * @param permission The permission string
     * @return True if permission is granted
     */
    default boolean hasPermission(final String permission) {
        return this.hasPermission(this.getActiveContexts(), permission);
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
     * @return The tristate result of the check
     */
    Tristate getPermissionValue(Set<Context> contexts, String permission);

    /**
     * Check if this subject is a child of the given parent in the subject's
     * current context, traversing inheritance.
     *
     * <p>This must return the same value as
     * {@link #isChildOf(Set, SubjectReference)} using
     * {@link #getActiveContexts()}.</p>
     *
     * @param parent The parent to check for inheritance
     * @return Whether this is a child of the given parent
     */
    default boolean isChildOf(final SubjectReference parent) {
        return this.isChildOf(this.getActiveContexts(), parent);
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
     * {@link PermissionService#getDefaults()} should be considered for this
     * lookup.</p>
     *
     * @param contexts The context combination to check in
     * @param parent The parent to check for inheritance
     * @return Whether this is a child of the given parent
     */
    boolean isChildOf(Set<Context> contexts, SubjectReference parent);

    /**
     * Return all parents that this group has in its current context
     * combination.
     *
     * <p>This must include inherited values if the permissions
     * service supports inheritance.</p>
     *
     * <p>It must also must return the same value as {@link #getParents(Set)}
     * using {@link #getActiveContexts()}.</p>
     *
     * @return An immutable list of parents
     */
    default List<SubjectReference> getParents() {
        return this.getParents(this.getActiveContexts());
    }

    /**
     * Return all parents that this group has in the given context combination.
     *
     * <p>This must include inherited values if the permissions
     * service supports inheritance.</p>
     *
     * @param contexts The context combination to check in
     * @return An immutable list of parents
     */
    List<SubjectReference> getParents(Set<Context> contexts);

    /**
     * Gets the value of a given option in the given context.
     *
     * <p>It is expected that this method will account for options
     * inherited from parent subjects.
     *
     * <p>Additionally, the default options defined by the
     * {@link SubjectCollection} that holds this subject, as well as defaults
     * defined in {@link PermissionService#getDefaults()} should be considered
     * for this lookup.
     *
     * @param contexts The contexts to get the options from
     * @param key The key to get an option by. Case-insensitive.
     * @return The value of the option, if any is present
     */
    Optional<String> getOption(Set<Context> contexts, String key);

    /**
     * Gets the value of a given option in the subject's current context.
     *
     * <p>This must return the same value as {@link #getOption(Set, String)}
     * using {@link #getActiveContexts()}.</p>
     *
     * @param key The key to get an option by. Case-insensitive.
     * @return The value of the option, if any is present
     */
    default Optional<String> getOption(final String key) {
        return this.getOption(this.getActiveContexts(), key);
    }
}
