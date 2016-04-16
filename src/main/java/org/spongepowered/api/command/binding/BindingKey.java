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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.Nullable;

/**
 * A binding key consists of an injection type and an optional annotation.
 *
 * @param <T> The bound type
 */
public final class BindingKey<T> implements Comparable<BindingKey<?>>, Predicate<BindingKey<?>> {

    private final Type type;
    @Nullable private final Class<? extends Annotation> classifier;

    /**
     * Creates a binding key from the provided class.
     *
     * @param clazz The class
     * @param <T> The bound type
     * @return A binding key
     */
    public static <T> BindingKey<T> of(Class<T> clazz) {
        return new BindingKey<>(clazz, null);
    }

    /**
     * Creates a binding key from the provided class and classifier.
     *
     * @param clazz The class
     * @param classifier The classifier annotation
     * @param <T> The bound type
     * @return A binding key
     */
    public static <T> BindingKey<T> of(Class<T> clazz, @Nullable Class<? extends Annotation> classifier) {
        return new BindingKey<>(clazz, classifier);
    }

    /**
     * Creates a binding key from the provided type.
     *
     * @param type The type
     * @param <T> The bound type
     * @return A binding key
     */
    public static <T> BindingKey<T> of(Type type) {
        return new BindingKey<>(type, null);
    }

    /**
     * Creates a binding key from the provided type and classifier.
     *
     * @param type The type
     * @param classifier The classifier annotation
     * @param <T> The bound type
     * @return A binding key
     */
    public static <T> BindingKey<T> of(Type type, @Nullable Class<? extends Annotation> classifier) {
        return new BindingKey<>(type, classifier);
    }

    /**
     * Creates a binding key
     *
     * @param type The type
     * @param classifier The classifier annotation
     */
    private BindingKey(Type type, @Nullable Class<? extends Annotation> classifier) {
        this.type = checkNotNull(type, "type");
        this.classifier = classifier;
    }

    /**
     * Gets the type.
     *
     * @return The type
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Gets the classifier annotation.
     *
     * @return The classifier annotation
     */
    public Optional<Class<? extends Annotation>> getClassifier() {
        return Optional.ofNullable(this.classifier);
    }

    /**
     * Sets the annotation classifier.
     *
     * @param classifier The classifier annotation
     * @return A new binding key
     */
    public BindingKey<T> setClassifier(@Nullable Class<? extends Annotation> classifier) {
        return new BindingKey<>(this.type, classifier);
    }

    /**
     * Determines if another binding key matches this binding key.
     *
     * @param that The other binding key
     * @return {@code true} if the other binding key matches, {@code false} otherwise
     */
    @Override
    public boolean test(BindingKey<?> that) {
        checkNotNull(that, "that");
        return Objects.equal(this.type, that.type) && Objects.equal(this.classifier, that.classifier);
    }

    @Override
    public int compareTo(BindingKey<?> that) {
        if (this.classifier != null && that.classifier == null) {
            return -1;
        } else if (this.classifier == null && that.classifier != null) {
            return 1;
        }

        return 0;
    }

}
