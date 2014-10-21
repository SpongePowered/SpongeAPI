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

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

/**
 * A source of permission requests.
 *
 * <p>Authorization checks are made using "permission strings."</p>
 *
 * <p>Permission strings are hierarchical with each level separated
 * by periods (full stops). An example of a valid permission string is
 * {@code example.function}. Inheritance is implicit; that is,
 * if a subject has been granted {@code example}, then the subject
 * should have also be automatically granted
 * {@code example.function}, {@code example.another},
 * {@code example.deeper.nesting}, and so on. However, implementations
 * may allow administrators to configure "negation" such that
 * {@code example} and all child levels would granted but
 * {@code example.access} would denied (for example).</p>
 *
 * <p>Plugins may opt to implement "dynamic" permissions such as
 * {@code example.region.define.&lt;region&gt;} where {@code region}
 * would be a dynamically added level based on the context, though some
 * attention should be made towards the handling of periods / full stops
 * in such cases.</p>
 *
 * <p>Due to the implicit inheritance, it is recommended that
 * commands that allow a user to "apply" an effect to other users
 * use {@code example.function.self} as the permission for applying
 * this effect to one's self. This allows administrators to grant
 * {@code example.function.self} to permit usage on one's self
 * and grant {@code example.function} to grant usage on other users.</p>
 *
 * <p>Use a {@link PermissionService} to create instances.</p>
 *
 * @see PermissionService
 */
public interface Subject {

    /**
     * Returns the identifier associated with this subject. May not be human-readable, but always refers to a single subject
     * @return
     */
    public String getIdentifier();

    /**
     * The container for permissions data that *may* be persisted if the service provider supports it.
     * @return The container for permissions data this subject uses
     */
    public SubjectData getData();

    /**
     * Returns container for subject data that is guaranteed to be transient (only lasting for the duration of the subject's session, not persisted).
     * This might return the same object as {@link #getData()} if the provider for this service does not implement persistence for permissions data.
     * @return
     */
    public SubjectData getTransientData();

    /**
     * Test whether the subject is permitted to perform an action given as
     * the given permission string.
     *
     * @param permission The permission string
     * @return True if permission is granted
     */
    public boolean hasPermission(List<Context> contexts, String permission);

    /**
     * Does the player have a permission?
     * @param permission
     * @return
     *//**
     * Test whether the subject is permitted to perform an action given as
     * the given permission string.
     *
     * @param permission The permission string
     * @return True if permission is granted
     */
    public boolean hasPermission(String permission);

    public boolean childOf(String parent);

    public boolean childOf(Subject parent);

    /**
     * Return all parents that this group has. This must include inherited values if the permissions service supports inheritance.
     * @return An immutable list of parents
     */
    public List<Subject> getParents();

    /**
     *
     * @return An immutable list of active contexts
     */
    public List<Context> getActiveContexts();
}
