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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.util.Tristate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Container for a subject's data.
 *
 * <p>This container updates live, and provides raw data for a subject not
 * taking into account any sort of inheritance. This interface is meant to
 * represent what's 'in the file', rather than the higher-level query methods
 * available in {@link Subject}.</p>
 *
 * <p>Methods which modify the state of the data return
 * {@link CompletableFuture}s. This allows for the time which is taken to apply
 * and persist the change to the implementations storage backend. These futures
 * should return quickly for changes made to transient subject data, but may
 * take longer to return for changes made to a subjects persistent data. Methods
 * which use this data in {@link Subject} may not reflect the change until the
 * future has returned.</p>
 *
 * <p>{@link CompletableFuture#allOf(CompletableFuture[])} can be used to
 * combine multiple futures into one, if the result of methods is not
 * needed.</p>
 */
public interface SubjectData {

    /**
     * A convenience constant for the global context combination (the empty
     * set), if you want your code to look especially fancy.
     */
    Set<Context> GLOBAL_CONTEXT = Collections.emptySet();

    /**
     * Gets the {@link Subject} which holds this data.
     *
     * @return The subject which holds this data
     */
    Subject getSubject();

    /**
     * Return if this SubjectData is transient.
     *
     * @return If this SubjectData is transient
     * @see Subject#getTransientSubjectData()
     */
    boolean isTransient();

    /**
     * Return all permissions associated with this data object.
     *
     * @return An immutable copy of the mappings between contexts and lists of
     *         permissions containing every permission registered
     */
    Map<Set<Context>, Map<String, Boolean>> getAllPermissions();

    /**
     * Returns the list of permissions set for the given context.
     *
     * <p>This list is immutable and is not a live view. If no permissions have
     * been set, it returns an empty list.</p>
     *
     * @param contexts The particular context combination to check
     * @return Any permissions set
     */
    Map<String, Boolean> getPermissions(Set<Context> contexts);

    /**
     * Sets a permission to a given value.
     *
     * <p>Setting value as {@link Tristate#UNDEFINED} unsets the permission.</p>
     *
     * <p>An empty set of contexts applies this permission to the global
     * context.</p>
     *
     *  @param contexts The particular combination of contexts to set this
     *                  permission in
     * @param permission The permission to set
     * @param value The value to set this permission to
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> setPermission(Set<Context> contexts, String permission, Tristate value);

    /**
     * Clear all permissions set in any context.
     *
     * @return Whether any change occurred
     */
    CompletableFuture<Boolean> clearPermissions();

    /**
     * Clear all permissions set in a given context combination.
     *
     * <p>Passing an empty context set clears permissions in the global
     * context.</p>
     *
     * @param contexts The context combination to clear permissions in
     * @return Whether any change occurred
     */
    CompletableFuture<Boolean> clearPermissions(Set<Context> contexts);

    /**
     * Return all registered parent subjects for all contexts.
     *
     * <p>The returned map is immutable and not a live view. The results of this
     * method do not traverse any sort of inheritance structure a permissions
     * plugin may implement.</p>
     *
     * @return All registered parents and the context they are registered in
     */
    Map<Set<Context>, List<SubjectReference>> getAllParents();

    /**
     * Return all registered parent subjects for a given context.
     *
     * <p>The returned map is immutable and not a live view. The results of this
     * method do not traverse any sort of inheritance structure a permissions
     * plugin may implement.</p>
     *
     * @param contexts The context to check
     * @return names of parents valid in the given context
     */
    List<SubjectReference> getParents(Set<Context> contexts);

    /**
     * Adds a parent in a particular context combination.
     *
     * <p>Passing an empty context combination means the parent is added in the
     * global context.</p>
     *
     * @param contexts The context combination this operation is applicable to
     * @param parent The name of the parent to add
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> addParent(Set<Context> contexts, SubjectReference parent);

    /**
     * Removes a parent in a particular context combination.
     *
     * <p>Passing an empty context combination means the parent is removed in
     * the global context.</p>
     *
     * @param contexts The context combination this operation is applicable to
     * @param parent The name of the parent to remove
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> removeParent(Set<Context> contexts, SubjectReference parent);

    /**
     * Remove all parents in any context combination.
     *
     * @return Whether any change occurred
     */
    CompletableFuture<Boolean> clearParents();

    /**
     * Remove all parents in a given context combination.
     *
     * <p>Passing an empty context set clears parents in the global
     * context.</p>
     *
     * @param contexts The context combination to clear the parents of
     * @return Whether any change occurred
     */
    CompletableFuture<Boolean> clearParents(Set<Context> contexts);

    /**
     * Return all options for all context combinations currently registered.
     *
     * @return An immutable snapshot of all options data
     */
    Map<Set<Context>, Map<String, String>> getAllOptions();

    /**
     * Gets options for a specific context combination.
     *
     * @param contexts The context combination to get options for
     * @return All available options, returning an empty map if none are present
     */
    Map<String, String> getOptions(Set<Context> contexts);

    /**
     * Sets a specific option to a value.
     *
     * <p>Passing a null value will unset the option.</p>
     *
     * @param contexts The context combination to set the given option in
     * @param key The key to set. Case-insensitive.
     * @param value The value to set.
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> setOption(Set<Context> contexts, String key, @Nullable String value);

    /**
     * Clear all options.
     *
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> clearOptions();

    /**
     * Clear all options in the given context combination.
     *
     * <p>Passing an empty context set clears options in the global
     * context.</p>
     *
     * @param contexts The context combination
     * @return Whether the operation was successful (any options were removed)
     */
    CompletableFuture<Boolean> clearOptions(Set<Context> contexts);

}
