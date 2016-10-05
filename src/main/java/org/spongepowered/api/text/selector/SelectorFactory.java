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
package org.spongepowered.api.text.selector;

import org.spongepowered.api.text.selector.ArgumentHolder.Limit;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Internal implementation factory: Use the methods in
 * {@link Selector}, {@link Argument} and {@link ArgumentTypes} instead.
 */
public interface SelectorFactory {

    /**
     * Creates a {@link Selector.Builder}.
     *
     * @return A new selector builder with the specified type
     */
    Selector.Builder createBuilder();

    /**
     * Parses a {@link Selector} from the given selector string.
     *
     * @param selector The raw selector string
     * @return A new selector containing the given selector data
     */
    Selector parseRawSelector(String selector);

    /**
     * Creates a minimum and maximum {@link ArgumentType} filtering depending on
     * the score of the specified objective.
     *
     * @param name The objective name to use
     * @return The created argument type
     */
    Limit<ArgumentType<Integer>> createScoreArgumentType(String name);

    /**
     * Gets the {@link ArgumentType} with the provided name.
     *
     * @param name The name of the argument type
     * @return The {@link ArgumentType} with the given name or Optional.empty()
     *         if not found
     */
    Optional<ArgumentType<?>> getArgumentType(String name);

    /**
     * Gets a {@link Collection} of all possible {@link ArgumentType}s.
     *
     * @return The list of all available {@link ArgumentType}s
     */
    Collection<ArgumentType<?>> getArgumentTypes();

    /**
     * Creates a custom {@link ArgumentType} with the specified key.
     *
     * @param key The key to use for the argument
     * @return The created argument type
     */
    ArgumentType<String> createArgumentType(String key);

    /**
     * Creates a custom {@link ArgumentType} with the specified key and value.
     *
     * @param key The key to use for the argument
     * @param type The class of the argument's value type
     * @param <T> The argument's value type
     * @return The created argument type
     */
    <T> ArgumentType<T> createArgumentType(String key, Class<T> type);

    /**
     * Creates a new {@link Argument} using the specified type and value.
     *
     * @param type The type of the argument
     * @param value The value of the argument
     * @param <T> The type of the argument value
     * @return The created argument
     */
    <T> Argument<T> createArgument(ArgumentType<T> type, T value);

    /**
     * Creates a new {@link Argument.Invertible} using the specified type and
     * value. The created {@link Argument} will be inverted based on the given
     * parameter.
     *
     * @param type The type of the invertible argument
     * @param value The value of the invertible argument
     * @param inverted {@code true} if the argument should be inverted
     * @param <T> The type of the argument value
     * @return The created invertible argument
     */
    <T> Argument.Invertible<T> createArgument(ArgumentType.Invertible<T> type, T value, boolean inverted);

    /**
     * Creates a new set of {@link Argument}s using the specified type and
     * value.
     *
     * @param type The type of the arguments
     * @param value The value of the arguments
     * @param <T> The type of the arguments' joined value
     * @param <V> The type of the arguments' sub-values
     * @return The created argument
     */
    <T, V> Set<Argument<T>> createArguments(ArgumentHolder<? extends ArgumentType<T>> type, V value);

    /**
     * Parses an {@link Argument} from the given argument string.
     *
     * <p>In Vanilla, it should be formatted like {@code key=value}.</p>
     *
     * @param argument The argument string
     * @return The parsed argument
     * @throws IllegalArgumentException If the argument couldn't be parsed (e.g.
     *         due to invalid format)
     */
    Argument<?> parseArgument(String argument) throws IllegalArgumentException;

    /**
     * Fetch completions for a selector command argument.
     * 
     * @param selector The partial selector
     * @return Tab completions for the next part of the selector
     */
    List<String> complete(String selector);

}
