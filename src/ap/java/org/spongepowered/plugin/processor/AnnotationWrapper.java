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
package org.spongepowered.plugin.processor;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableMap;

import java.lang.annotation.Annotation;

import javax.lang.model.AnnotatedConstruct;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.QualifiedNameable;

final class AnnotationWrapper<T extends Annotation> {

    private final T annotation;
    private final AnnotationMirror mirror;
    private final ImmutableMap<String, AnnotationValue> values;

    AnnotationWrapper(T annotation, AnnotationMirror mirror) {
        this.annotation = annotation;
        this.mirror = mirror;

        ImmutableMap.Builder<String, AnnotationValue> builder = ImmutableMap.builder();
        mirror.getElementValues().forEach((field, value) -> builder.put(field.getSimpleName().toString(), value));
        this.values = builder.build();
    }

    T get() {
        return this.annotation;
    }

    AnnotationMirror getMirror() {
        return this.mirror;
    }

    ImmutableMap<String, AnnotationValue> getValues() {
        return this.values;
    }

    AnnotationValue getValue(String name) {
        AnnotationValue value = this.values.get(name);
        checkArgument(value != null, "Annotation value '%s' is not present in %s", name, this.mirror);
        return value;
    }

    static <T extends Annotation> AnnotationWrapper<T> of(AnnotatedConstruct element, Class<T> annotationClass) {
        checkNotNull(element, "element");
        checkNotNull(annotationClass, "annotationClass");

        final T annotation = element.getAnnotation(annotationClass);
        final String name = annotationClass.getName();
        for (AnnotationMirror mirror : element.getAnnotationMirrors()) {
            if (((QualifiedNameable) mirror.getAnnotationType().asElement()).getQualifiedName().contentEquals(name)) {
                return new AnnotationWrapper<>(annotation, mirror);
            }
        }

        throw new IllegalArgumentException("Annotation " + annotation + " not found in " + element);
    }

}
