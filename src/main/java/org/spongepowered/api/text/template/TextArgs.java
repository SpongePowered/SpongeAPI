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

import java.util.Map;
import java.util.Optional;

/**
 * Represents an aggregate of arguments that can be given to a {@link TextTemplate}.
 *
 * Arguments may be positioned or keyed by strings.
 */
public class TextArgs {

    /**
     * The positioned arguments this TextArgs object holds.
     */
    private ImmutableList<Object> positionedArgs;

    /**
     * The named arguments this TextArgs object holds.
     */
    private ImmutableMap<String, Object> namedArgs;

    /**
     * Builds a TextArgs object from a list of positioned args and map of named args.
     *
     * @param positionedArgs The positioned arguments
     * @param namedArgs The named arguments
     */
    private TextArgs(ImmutableList<Object> positionedArgs, ImmutableMap<String, Object> namedArgs) {
        this.positionedArgs = positionedArgs;
        this.namedArgs = namedArgs;
    }

    /**
     * Adds the given argument to end of the positioned arguments.
     *
     * @param arg The new argument
     * @return A new TextArgs object
     */
    public TextArgs add(Object arg) {
        return new TextArgs(
            ImmutableList.builder().addAll(positionedArgs).add(arg).build(),
            namedArgs
        );
    }

    /**
     * Adds the given arguments to end of the positioned arguments.
     *
     * @param args The new arguments
     * @return A new TextArgs object
     */
    public TextArgs add(Object... args) {
        return new TextArgs(
            ImmutableList.builder().addAll(positionedArgs).add(args).build(),
            namedArgs
        );
    }

    /**
     * Adds the given arguments to end of the positioned arguments.
     *
     * @param args The new argument
     * @return A new TextArgs object
     */
    public TextArgs add(Iterable<Object> args) {
        return new TextArgs(
            ImmutableList.builder().addAll(positionedArgs).addAll(args).build(),
            namedArgs
        );
    }

    /**
     * Adds the given argument to the named arguments.
     *
     * @param name The name, or key of the argument
     * @param arg The new argument
     * @return A new TextArgs object
     */
    public TextArgs with(String name, Object arg) {
        return new TextArgs(
            positionedArgs,
            ImmutableMap.<String, Object>builder().putAll(namedArgs).put(name, arg).build()
        );
    }

    /**
     * Adds the given arguments to the named arguments.
     *
     * @param argsMap A map from string to native arguments
     * @return A new TextArgs object
     */
    public TextArgs with(Map<String, Object> argsMap) {
        return new TextArgs(
            positionedArgs,
            ImmutableMap.<String, Object>builder().putAll(namedArgs).putAll(argsMap).build()
        );
    }

    /**
     * Gets a positioned argument by its position index.
     *
     * @param position The position of the argument
     * @return The argument at that position
     * @throws IndexOutOfBoundsException If the position is out of bounds
     */
    public Object getPositionedArg(int position) throws IndexOutOfBoundsException {
        return positionedArgs.get(position);
    }

    /**
     * Gets a positioned argument by its position index, if it exists.
     *
     * @param position The position of the argument
     * @return The argument at that position, or {@link Optional#empty()}
     */
    public Optional<Object> getPositionedArgOpt(int position) {
        if (position >= positionedArgs.size()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(positionedArgs.get(position));
        }
    }

    /**
     * Gets a named argument by its name.
     *
     * @param name The name of the argument
     * @return The argument with that name
     * @throws IllegalArgumentException If an argument with the given name does not exist.
     */
    public Object getNamedArg(String name) throws IllegalArgumentException {
        if (!namedArgs.containsKey(name)) {
            throw new IllegalArgumentException("Named arg " + name + " not found");
        }
        return namedArgs.get(name);
    }

    /**
     * Gets a named argument by its name, if it exists
     *
     * @param name The name of the argument
     * @return The argument with that name, or {@link Optional#empty()}
     */
    public Optional<Object> getNamedArgOpt(String name) {
        if (namedArgs.containsKey(name)) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(namedArgs.get(name));
        }
    }

    /**
     * Builds an empty TextArgs object
     *
     * @return The new TextArgs instance
     */
    public static TextArgs of() {
        return new TextArgs(ImmutableList.of(), ImmutableMap.of());
    }

    /**
     * Builds a TextArgs object out of the given positioned arguments.
     *
     * @param args The positioned arguments
     * @return The new TextArgs instance
     */
    public static TextArgs of(Object... args) {
        return of().add(args);
    }

}
