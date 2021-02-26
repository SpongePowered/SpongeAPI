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

import org.spongepowered.api.event.Cause;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.util.Tristate;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Enables an object to act as a proxy to a Subject, delegating all calls through
 * to the actual Subject.
 */
public interface SubjectProxy extends Subject {

    /**
     * Gets the {@link Subject} this interface is a proxy for.
     *
     * @return The {@link Subject}
     */
    Subject subject();

    @Override
    default SubjectCollection containingCollection() {
        return this.subject().containingCollection();
    }

    @Override
    default SubjectReference asSubjectReference() {
        return this.subject().asSubjectReference();
    }

    @Override
    default Optional<?> getAssociatedObject() {
        return this.subject().getAssociatedObject();
    }

    @Override
    default boolean isSubjectDataPersisted() {
        return this.subject().isSubjectDataPersisted();
    }

    @Override
    default SubjectData subjectData() {
        return this.subject().subjectData();
    }

    @Override
    default SubjectData transientSubjectData() {
        return this.subject().transientSubjectData();
    }

    @Override
    default Tristate permissionValue(String permission, Set<Context> contexts) {
        return this.subject().permissionValue(permission, contexts);
    }

    @Override
    default Tristate permissionValue(final String permission, final Cause causes) {
        return this.subject().permissionValue(permission, causes);
    }

    @Override
    default boolean isChildOf(SubjectReference parent, Set<Context> contexts) {
        return this.subject().isChildOf(parent, contexts);
    }

    @Override
    default boolean isChildOf(final SubjectReference parent, final Cause causes) {
        return this.subject().isChildOf(parent, causes);
    }

    @Override
    default boolean isChildOf(final SubjectReference parent) {
        return this.subject().isChildOf(parent);
    }

    @Override
    default List<? extends SubjectReference> parents(Set<Context> contexts) {
        return this.subject().parents(contexts);
    }

    @Override
    default List<? extends SubjectReference> parents(final Cause causes) {
        return this.subject().parents(causes);
    }

    @Override
    default List<? extends SubjectReference> parents() {
        return this.subject().parents();
    }

    @Override
    default Optional<String> option(String key, Set<Context> contexts) {
        return this.subject().option(key, contexts);
    }

    @Override
    default Optional<String> option(final String key, final Cause cause) {
        return this.subject().option(key, cause);
    }

    @Override
    default Optional<String> option(final String key) {
        return this.subject().option(key);
    }

    @Override
    default String identifier() {
        return this.subject().identifier();
    }

    @Override
    default boolean hasPermission(final String permission, final Set<Context> contexts) {
        return this.subject().hasPermission(permission, contexts);
    }

    @Override
    default boolean hasPermission(final String permission, final Cause cause) {
        return this.subject().hasPermission(permission, cause);
    }

    @Override
    default boolean hasPermission(final String permission) {
        return this.subject().hasPermission(permission);
    }

    @Override
    default Optional<String> friendlyIdentifier() {
        return this.subject().friendlyIdentifier();
    }

}
