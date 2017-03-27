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

import java.util.concurrent.CompletableFuture;

/**
 * Represents a reference to a given subject.
 *
 * <p>SubjectReferences should be used when a subject needs to be represented,
 * but the backing Subject is not needed.</p>
 *
 * <p>SubjectReferences are unique to a given PermissionService, and will not
 * resolve to the correct service if the provider changes.</p>
 *
 * <p>Note that implementations of this interface should be capable of
 * resolving the reference to a real subject.</p>
 *
 * <p>Instances can be obtained using
 * {@link PermissionService#newSubjectReference(String, String)},
 * {@link SubjectCollection#newSubjectReference(String)} or
 * {@link Subject#asSubjectReference()}.</p>
 */
public interface SubjectReference {

    /**
     * Gets the identifier of the collection containing the subject
     * being referenced.
     *
     * @return The identifier of the collection holding this subject
     */
    String getCollectionIdentifier();

    /**
     * Gets the identifier of the subject.
     *
     * @return The subject identifier
     */
    String getSubjectIdentifier();

    /**
     * Resolves and returns the Subject being referenced.
     *
     * <p>The returned future will complete exceptionally if the subject
     * collection with the given identifier cannot be loaded.</p>
     *
     * @return The subject being referenced by this instance.
     */
    CompletableFuture<Subject> resolve();

}
