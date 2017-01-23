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
package org.spongepowered.api.event.service.permission;

import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.service.permission.change.OptionChange;
import org.spongepowered.api.service.permission.change.PermissionChange;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Events to report when changes occur to permissions subjects
 */
public interface ChangeSubjectEvent extends TargetSubjectEvent {

    /**
     * The set of {@link Context}s that this value was changed in
     *
     * @return The contexts changed
     */
    Set<Context> getContexts();

    /**
     * Event thrown when a subject has a permission change.
     */
    interface Permission extends ChangeSubjectEvent {

        /**
         * Get the list of changed permissions. This list is immutable.
         *
         * @return The changed permissions
         */
        List<PermissionChange> getChangedPermissions();

        default void forEach(Consumer<PermissionChange> func) {
            getChangedPermissions().forEach(func);
        }
    }

    /**
     * Event thrown when a subject has an option change.
     */
    interface Option extends ChangeSubjectEvent {
        /**
         * Get the list of changed options. This list is immutable.
         *
         * @return The changed options
         */
        List<OptionChange> getChangedOptions();

        default void forEach(Consumer<OptionChange> func) {
            getChangedOptions().forEach(func);
        }
    }

    /**
     * Event thrown when a subject has a parent
     */
    interface Parents extends ChangeSubjectEvent {

        /**
         * The old list of parents assigned to this subject. Will be immutable.
         *
         * @return The old parents
         */
        List<Subject> getOldParents();

        /**
         * The new list of parents assigned to this subject. Will be immutable.
         *
         * @return The new parents
         */
        List<Subject> getNewParents();
    }

}
