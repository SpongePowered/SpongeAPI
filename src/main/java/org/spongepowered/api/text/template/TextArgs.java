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

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public final class TextArgs {

    private ImmutableList<Object> positionedArgs;
    private ImmutableMap<String, Object> namedArgs;

    private TextArgs(ImmutableList<Object> positionedArgs, ImmutableMap<String, Object> namedArgs) {
        this.positionedArgs = positionedArgs;
        this.namedArgs = namedArgs;
    }

    public TextArgs add(Object arg) {
        return new TextArgs(
            ImmutableList.builder().addAll(positionedArgs).add(arg).build(),
            namedArgs
        );
    }

    public TextArgs add(Object... args) {
        return new TextArgs(
            ImmutableList.builder().addAll(positionedArgs).add(args).build(),
            namedArgs
        );
    }

    public TextArgs add(Iterable<Object> args) {
        return new TextArgs(
            ImmutableList.builder().addAll(positionedArgs).addAll(args).build(),
            namedArgs
        );
    }

    public TextArgs with(String name, Object arg) {
        return new TextArgs(
            positionedArgs,
            ImmutableMap.<String, Object>builder().putAll(namedArgs).put(name, arg).build()
        );
    }

    public TextArgs with(Map<String, Object> argsMap) {
        return new TextArgs(
            positionedArgs,
            ImmutableMap.<String, Object>builder().putAll(namedArgs).putAll(argsMap).build()
        );
    }

    public Object getPositionedArg(int position) throws IndexOutOfBoundsException {
        return positionedArgs.get(position);
    }

    public Optional<Object> getPositionedArgOpt(int position) {
        if (position >= positionedArgs.size()) {
            return Optional.absent();
        } else {
            return Optional.fromNullable(positionedArgs.get(position));
        }
    }

    public Object getNamedArg(String name) throws IllegalArgumentException {
        if (!namedArgs.containsKey(name)) {
            throw new IllegalArgumentException("Named arg " + name + " not found");
        }
        return namedArgs.get(name);
    }

    public Optional<Object> getNamedArgOpt(String name) {
        if (namedArgs.containsKey(name)) {
            return Optional.absent();
        } else {
            return Optional.fromNullable(namedArgs.get(name));
        }
    }

    public static TextArgs of() {
        return new TextArgs(ImmutableList.of(), ImmutableMap.of());
    }

    public static TextArgs of(Object... args) {
        return of().add(args);
    }

}
