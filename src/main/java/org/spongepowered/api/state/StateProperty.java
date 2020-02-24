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
package org.spongepowered.api.state;

import org.spongepowered.api.NamedCatalogType;
import org.spongepowered.api.block.BlockTypes;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents a possible state property in a {@link StateContainer}s {@link State}.
 * 
 * <p>A {@link State} can include zero or more {@link StateProperty}s. Each
 * {@link StateProperty} within a {@link State} is mapped to a value which
 * represents the current value at the time the {@link State} was taken.
 * </p>
 * 
 * <p>For example, a {@link BlockTypes#RED_BED} contains three possible
 * {@link StateProperty}s :</p>
 * 
 * <ul>
 *     <li>{@link EnumStateProperties#RED_BED_FACING}</li>
 *     <li>{@link BooleanStateProperties#RED_BED_OCCUPIED}</li>
 *     <li>{@link EnumStateProperties#RED_BED_PART}</li>
 * </ul>
 *
 * <p>If you query a {@link BlockTypes#RED_BED}'s {@link StateProperty} you have two
 * possible outcomes for each {@link StateProperty}. The
 * {@link BooleanStateProperties#RED_BED_OCCUPIED} has the following possible values:</p>
 * 
 * <ul>
 *     <li><code>true</code></li>
 *     <li><code>false</code></li>
 * </ul>
 *
 * <p>As 'OCCUPIED' is a {@link BooleanStateProperty}, it can only be <code>true</code>
 * or <code>false</code>.
 * The {@link EnumStateProperties#RED_BED_PART} has the following possible values:</p>
 * 
 * <ul>
 *     <li><code>HEAD</code></li>
 *     <li><code>FOOT</code></li>
 * </ul>
 * 
 * <p>To determine the current value of a {@link StateProperty}, you would call
 * {@link State#getStateProperty(StateProperty)}. To determine all possible
 * values of a {@link StateProperty}, you would call
 * {@link State#getStateProperties()}.</p>
 *
 * <p>As stated above, a {@link StateContainer} may not always have one or more
 * {@link StateProperty}s. An example of such a block is {@link BlockTypes#BOOKSHELF}.</p>
 */
public interface StateProperty<T extends Comparable<T>> extends NamedCatalogType {

    /**
     * Gets all possible values for a specific {@link StateProperty}. The
     * included values may not be in any particular order. The returned
     * {@link Collection} should be considered immutable.
     *
     * @return All possible values
     */
    Collection<T> getPossibleValues();

    /**
     * Gets the class type of the {@link StateProperty}'s values.
     *
     * @return The value class
     */
    Class<T> getValueClass();

    /**
     * Gets the {@link Predicate} used to determine valid values for this.
     * {@link StateProperty}. Any "value" that returns <code>true</code> when
     * {@link Predicate#test(Object)} is called is valid. The
     * {@link Predicate} is specific to this property.
     * 
     * @return The predicate
     */
    Predicate<T> getPredicate();

    /**
     * Attempts to parse the provided value as a value dictated possible by
     * this state property or {@link Optional#empty()} otherwise.
     *
     * @param value The value to parse
     * @return The actual value
     */
    Optional<T> parseValue(String value);
}
