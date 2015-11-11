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
package org.spongepowered.api.text.template;

import org.spongepowered.api.text.Text;

import java.util.function.Function;

/**
 * Represents a wrapped function that can transform a value of type {@link T} into a Text object.
 *
 * @param <T>
 * @see TextElements
 */
@FunctionalInterface
public interface TextElement<T> {

    Text create(T value);

    default <U> TextElement<U> contramap(Function<? super U, ? extends T> function) {
        return value -> create(function.apply(value));
    }

    default TextElement<T> andThen(Function<Text, Text> function) {
        return value -> function.apply(create(value));
    }

    default TextArgsElement<T> name(String name) {
        return new TextArgsElement.Named<>(name, this);
    }

    default TextArgsElement<T> pos(int position) {
        return new TextArgsElement.Pos<>(position, this);
    }

}
