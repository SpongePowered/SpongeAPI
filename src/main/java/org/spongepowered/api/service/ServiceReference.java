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
package org.spongepowered.api.service;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;

/**
 * A reference to a service that may or may not be currently registered, but will be updated if a registration does happen.
 *
 * @param <T> The type of the reference
 */
public interface ServiceReference<T> {

    /**
     * Get the reference to the current state of this service.
     *
     * @return reference to the latest value of the service -- may not be present
     */
    Optional<T> ref();

    /**
     * Block until the service is available. Bad idea to run this on the main thread.
     *
     * @return The service if available
     * @throws InterruptedException if waiting is interrupted
     */
    T await() throws InterruptedException;

    /**
     * Queue a command to be executed after a service is registered.
     * If the service is already registered, this function will be run immediately from the current thread.
     *
     * <p>If the service has not yet been registered, this function is called from the thread the service is registered on after registration occurs.
     * The return value of the function is ignored.
     *
     * @param run The function to execute
     */
    void executeWhenPresent(Predicate<T> run);
}
