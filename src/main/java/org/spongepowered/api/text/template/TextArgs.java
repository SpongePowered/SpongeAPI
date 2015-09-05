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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public final class TextArgs {

    private ImmutableList.Builder<Object> positionedArgsBuilder;
    private ImmutableList<Object> positionedArgs = null;
    private ImmutableMap.Builder<String, Object> namedArgsBuilder;
    private ImmutableMap<String, Object> namedArgs = null;

    private TextArgs(ImmutableList.Builder<Object> positionedArgsBuilder,
                     ImmutableMap.Builder<String, Object> namedArgsBuilder) {
        this.positionedArgsBuilder = positionedArgsBuilder;
        this.namedArgsBuilder = namedArgsBuilder;
    }

    public TextArgs add(Object arg) {
        if (positionedArgsBuilder == null) {
            throw new IllegalArgumentException("Positioned arguments were already accessed, to add" +
                "more arguments use TextArgs.copy()");
        }
        positionedArgsBuilder.add(arg);
        return this;
    }

    public TextArgs add(Object... args) {
        if (positionedArgsBuilder == null) {
            throw new IllegalArgumentException("Positioned arguments were already accessed, to add" +
                "more arguments use TextArgs.copy()");
        }
        positionedArgsBuilder.add(args);
        return this;
    }

    public TextArgs with(String name, Object arg) {
        if (positionedArgsBuilder == null) {
            throw new IllegalArgumentException("Named arguments were already accessed, to add" +
                "more arguments use TextArgs.copy()");
        }
        namedArgsBuilder.put(name, arg);
        return this;
    }

    public TextArgs copy() {
        ImmutableList.Builder<Object> newPositionedBuilder = ImmutableList.builder();
        if (positionedArgs == null) {
            newPositionedBuilder.addAll(positionedArgsBuilder.build());
        } else {
            newPositionedBuilder.addAll(positionedArgs);
        }
        ImmutableMap.Builder<String, Object> newNamedBuilder = ImmutableMap.builder();
        if (namedArgs == null) {
            newNamedBuilder.putAll(namedArgsBuilder.build());
        } else {
            newNamedBuilder.putAll(namedArgs);
        }
        return new TextArgs(newPositionedBuilder, newNamedBuilder);
    }

    public Object getPositionedArg(int position) throws IndexOutOfBoundsException {
        if (positionedArgs == null) {
            positionedArgs = positionedArgsBuilder.build();
            positionedArgsBuilder = null;
        }
        return positionedArgs.get(position);
    }

    public Object getNamedArg(String name) throws IllegalArgumentException {
        if (namedArgs == null) {
            namedArgs = namedArgsBuilder.build();
            namedArgsBuilder = null;
        }
        if (namedArgs.containsKey(name)) {
            throw new IllegalArgumentException("Named arg " + name + " not found");
        }
        return namedArgs.get(name);
    }

    public static TextArgs create() {
        return new TextArgs(ImmutableList.builder(), ImmutableMap.<String, Object>builder());
    }

    public static TextArgs of(Object... args) {
        return create().add(args);
    }

}
