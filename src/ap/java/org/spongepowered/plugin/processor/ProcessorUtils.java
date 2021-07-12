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

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

final class ProcessorUtils {

    private ProcessorUtils() {
    }

    static boolean contains(final Collection<? extends TypeElement> elements, final Class<?> clazz) {
        if (elements.isEmpty()) {
            return false;
        }

        final String name = clazz.getName();
        for (final TypeElement element : elements) {
            if (element.getQualifiedName().contentEquals(name)) {
                return true;
            }
        }

        return false;
    }

    static @Nullable Element containingWithNameAndType(final List<? extends Element> elements, final CharSequence name, final ElementKind kind) {
        for (final Element el : elements) {
            if ((kind == null || el.getKind() == kind)
                && el.getSimpleName().contentEquals(name)) {
                return el;
            }
        }
        return null;
    }

}
