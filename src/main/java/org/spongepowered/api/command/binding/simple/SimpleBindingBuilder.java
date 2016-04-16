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
package org.spongepowered.api.command.binding.simple;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.command.annotation.Classifier;
import org.spongepowered.api.command.binding.BindingBuilder;
import org.spongepowered.api.command.binding.BindingKey;
import org.spongepowered.api.command.provider.Provider;
import org.spongepowered.api.command.provider.StaticProvider;

import java.lang.annotation.Annotation;

import javax.annotation.Nullable;

/**
 * A simple implementation of {@link BindingBuilder}.
 *
 * @param <T> The bound type
 */
final class SimpleBindingBuilder<T> implements BindingBuilder<T> {

    private final SimpleBinder binder;
    private BindingKey<T> key;

    /**
     * Constructs a new binding builder.
     *
     * @param binder The binder
     * @param key The binding key
     */
    SimpleBindingBuilder(SimpleBinder binder, BindingKey<T> key) {
        this.binder = checkNotNull(binder, "binder");
        this.key = checkNotNull(key, "key");
    }

    @Override
    public BindingBuilder<T> annotatedWith(@Nullable Class<? extends Annotation> annotation) {
        if (annotation != null) {
            checkArgument(annotation.getAnnotation(Classifier.class) != null, "The '@%s' annotation must be decorated with '@%s' to be used as a "
                    + "classifier", annotation.getName(), Classifier.class.getName());
        }

        this.key = this.key.setClassifier(annotation);
        return this;
    }

    @Override
    public void toProvider(Provider<T> provider) {
        this.binder.addBinding(this.key, checkNotNull(provider, "provider"));
    }

    @Override
    public void toInstance(T instance) {
        this.toProvider(new StaticProvider<>(instance));
    }

}
