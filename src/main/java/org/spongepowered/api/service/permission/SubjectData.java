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

import java.util.List;
import java.util.Map;

/**
 * Container for a subject's data.
 */
public interface SubjectData {
    /**
     * Return all permissions associated with this data object
     * TODO: create permissions tree data structure that is used for all these methods rather than List&lt;String>
     * @return
     */
    public Map<Context, List<String>> getAllPermissions();

    public List<String> getPermissions(Context context);

    /**
     * set permissions in context to the given permissions. Null unsets.
     * @param context
     * @param permission
     */
    public void setPermission(Context context, String permission, Tristate value);
    public void setPermission(String permission, Tristate value);
    public void clearPermissions();

    /**
     * Return all registered parent names for all contexts
     * @return
     */
    public Map<Context, List<Subject>> getAllParents();


    /**
     *
     * @param context The context to check
     * @return names of parents valid in the given context
     */
    public List<Subject> getParents(Context context);

    /**
     * set permissions in context to the given permissions. Null unsets.
     * @param context
     * @param permission
     */
    public void addParent(Context context, String parent);
    public void removeParent(Context context, String parent);
    public void clearParents();

}
