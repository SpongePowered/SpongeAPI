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
package org.spongepowered.api.text.selector;

/**
 * Represents an invertible argument. An invertible argument is exactly like a
 * normal {@linkplain Argument} but also supports being inverted via the
 * {@link #invert()} method.
 *
 * @param <T> The type of the value
 * @param <I> The type of the inverted value
 */
public interface InvertibleArgument<T, I> extends Argument<T> {

    /**
     * Returns the result of inverting this {@linkplain InvertibleArgument}'s
     * value. For example, {@code type=Player} is inverted to
     * {@code type=!Player}. The only restriction on the invert method is that
     * for any InvertibleArgument {@code a} and {@code b = a.invert()},
     * {@code a.equals(b.invert())} is {@code true}. In other words, it is
     * reflexive.
     * 
     * @return The result of inverting this InvertableArgument
     */
    InvertibleArgument<I, T> invert();

}
