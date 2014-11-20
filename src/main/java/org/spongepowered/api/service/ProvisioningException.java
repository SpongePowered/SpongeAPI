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

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Thrown when a provider has not been registered or one cannot be
 * provisioned.
 */
public class ProvisioningException extends RuntimeException {

    private static final long serialVersionUID = -7538212541921643926L;

    private final Class<?> service;

    public ProvisioningException(Class<?> service) {
        checkNotNull(service);
        this.service = service;
    }

    public ProvisioningException(String message, Class<?> service) {
        super(message);
        checkNotNull(service);
        this.service = service;
    }

    public ProvisioningException(String message, Throwable cause, Class<?> service) {
        super(message, cause);
        checkNotNull(service);
        this.service = service;
    }

    public ProvisioningException(Throwable cause, Class<?> service) {
        super(cause);
        checkNotNull(service);
        this.service = service;
    }
    /**
     * Get the service that was requested.
     *
     * @return The service
     */
    public Class<?> getService() {
        return service;
    }

}
