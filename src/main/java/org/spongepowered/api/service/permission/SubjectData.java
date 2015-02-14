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

import org.spongepowered.api.service.permission.context.Context;
import org.spongepowered.api.util.Tristate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Container for a subject's data. This container updates live, and provides raw
 * data for a subject not taking into account any sort of inheritance.
 * Basically, this interface is meant to represent what's 'in the file', rather
 * than the higher-level query methods available in {@link Subject}
 */
public interface SubjectData {

    /**
     * A convenience constant for the global context combination (the empty
     * set), if you want your code to look especially fancy.
     */
    Set<Context> GLOBAL_CONTEXT = Collections.emptySet();

    /**
     * Return all permissions associated with this data object.
     *
     * @return an immutable copy of the mappings between contexts and lists of
     *         permissions containing every permission registered
     */
    Map<Set<Context>, Map<String, Boolean>> getAllPermissions();

    /**
     * Returns the list of permissions set for the given context. This list is
     * immutable and is not a live view. If no permissions have been set,
     * returns an empty list.
     *
     * @param contexts The particular context combination to check
     * @return Any permissions set
     */
    Map<String, Boolean> getPermissions(Set<Context> contexts);

    /**
     * Set a permission to a given value. Setting value as
     * {@link Tristate#UNDEFINED} unsets the permission. An empty set of
     * contexts applies this permission to the global context.
     *
     *  @param contexts The particular combination of contexts to set this
     *                  permission in
     * @param permission The permission to set
     * @param value The value to set this permission to
     * @return Whether the operation was successful
     */
    boolean setPermission(Set<Context> contexts, String permission, Tristate value);

    /**
     * Clear all permissions set in any context.
     *
     * @return Whether any change occurred
     */
    boolean clearPermissions();

    /**
     * Clear all permissions set in a given context combination. Passing an
     * empty context set unsets permissions in the global context.
     *
     * @param contexts The context combination to clear permissions in
     * @return Whether any change occurred
     */
    boolean clearPermissions(Set<Context> contexts);

    /**
     * Return all registered parent subjects for all contexts. The returned map
     * is immutable and not a live view. The results of this method do not
     * traverse any sort of inheritance structure a permissions plugin may
     * implement.
     *
     * @return All registered parents and the context they are registered in
     */
    Map<Set<Context>, List<Subject>> getAllParents();

    /**
     * Return all registered parent subjects for a given context. The returned
     * map is immutable and not a live view. The results of this method do not
     * traverse any sort of inheritance structure a permissions plugin may
     * implement.
     *
     * @param contexts The context to check
     * @return names of parents valid in the given context
     */
    List<Subject> getParents(Set<Context> contexts);

    /**
     * Adds a parent in a particular context combination. Passing an empty
     * context combination means the parent is added in the global context
     *
     * @param contexts The context combination this operation is applicable to
     * @param parent The name of the parent to add
     * @return Whether the operation was successful
     */
    boolean addParent(Set<Context> contexts, Subject parent);

    /**
     * Removes a parent in a particular context combination. Passing an empty
     * context combination means the parent is removed in the global context.
     *
     * @param contexts The context combination this operation is applicable to
     * @param parent The name of the parent to remove
     * @return Whether the operation was successful
     */
    boolean removeParent(Set<Context> contexts, Subject parent);

    /**
     * Remove all parents in any context combination.
     *
     * @return Whether any change occurred
     */
    boolean clearParents();

    /**
     * Remove all parents in a given context combination. An empty context
     * combination represents the global context.
     *
     * @param contexts The context combination to clear the parents of
     * @return Whether any change occurred
     */
    boolean clearParents(Set<Context> contexts);

}
