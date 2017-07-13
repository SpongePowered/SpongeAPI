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
package org.spongepowered.api.inject;

import com.google.common.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * A {@link InjectionPoint} is a method to get extra information when a
 * field or parameter is being injected. This gives access to all the
 * {@link Annotation}s and the field or parameter type.
 */
public interface InjectionPoint extends AnnotatedElement {

    /**
     * Gets the {@link TypeToken} of the class that declared
     * the field or parameter.
     *
     * @return The source type token
     */
    TypeToken<?> getSource();

    /**
     * Gets the {@link TypeToken} of the type of the injected
     * field or parameter.
     *
     * @return The type
     */
    TypeToken<?> getType();

}
