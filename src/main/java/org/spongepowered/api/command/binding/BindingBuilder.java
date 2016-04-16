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
package org.spongepowered.api.command.binding;

import org.spongepowered.api.command.provider.Provider;

import java.lang.annotation.Annotation;

import javax.annotation.Nullable;

/**
 * A binding builder.
 *
 * @param <T> The bound type
 */
public interface BindingBuilder<T> {

    /**
     * Sets the classifier the binding will listen for.
     *
     * @param annotation The classifier annotation class
     * @return This builder
     */
    BindingBuilder<T> annotatedWith(@Nullable Class<? extends Annotation> annotation);

    /**
     * Creates a binding that is provided by the given provider class.
     * @param provider The provider
     */
    void toProvider(Provider<T> provider);

    /**
     * Creates a binding that is provided by the given static instance.
     *
     * @param instance The instance to provide
     */
    void toInstance(T instance);

}
