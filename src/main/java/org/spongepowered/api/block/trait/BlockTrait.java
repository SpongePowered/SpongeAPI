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
package org.spongepowered.api.block.trait;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents a possible trait in a {@link BlockType}s {@link BlockState}.
 * 
 * <p>A {@link BlockState} can include zero or more {@link BlockTrait}s. Each
 * {@link BlockTrait} within a {@link BlockState} is mapped to a value which
 * represents the current value at the time the {@link BlockState} was taken.
 * </p>
 * 
 * <p>For example, a {@link BlockTypes#BED} contains three possible
 * {@link BlockTrait}s :</p>
 * 
 * <ul>
 *     <li>{@link EnumTraits#BED_FACING}</li>
 *     <li>{@link BooleanTraits#BED_OCCUPIED}</li>
 *     <li>{@link EnumTraits#BED_PART}</li>
 * </ul>
 *
 * <p>If you query a {@link BlockTypes#BED}'s {@link BlockTrait} you have two
 * possible outcomes for each {@link BlockTrait}. The
 * {@link BooleanTraits#BED_OCCUPIED} has the following possible values :</p>
 * 
 * <ul>
 *     <li><code>true</code></li>
 *     <li><code>false</code></li>
 * </ul>
 *
 * <p>As 'OCCUPIED' is a {@link BooleanTrait}, it can only be <code>true</code>
 * or <code>false</code>.
 * The {@link EnumTraits#BED_PART} has the following possible values :</p>
 * 
 * <ul>
 *     <li><code>HEAD</code></li>
 *     <li><code>FOOT</code></li>
 * </ul>
 * 
 * <p>To determine the current value of a {@link BlockTrait}, you would call
 * {@link BlockState#getTraitValue(BlockTrait)}. To determine all possible
 * values of a {@link BlockTrait}, you would call
 * {@link BlockType#getTraits()}.</p>
 *
 * <p>As stated above, a {@link BlockType} may not always have one or more
 * {@link BlockTrait}s. An example of such a block is
 * {@link BlockTypes#BOOKSHELF}.</p>
 *
 */
public interface BlockTrait<T extends Comparable<T>> extends CatalogType {

    /**
     * Gets the name of this {@link BlockTrait}.
     *
     * @return The trait name
     */
    @Override
    String getName();

    /**
     * Gets all possible values for a specific {@link BlockTrait}. The
     * included values may not be in any particular order. The returned
     * {@link Collection} should be considered immutable.
     *
     * @return All possible values
     */
    Collection<T> getPossibleValues();

    /**
     * Gets the class type of the {@link BlockTrait}'s values.
     *
     * @return The value class
     */
    Class<T> getValueClass();

    /**
     * Gets the {@link Predicate} used to determine valid values for this.
     * {@link BlockTrait}. Any "value" that returns <code>true</code> when
     * {@link Predicate#test(Object)} is called is valid. The
     * {@link Predicate} is specific to this trait.
     * 
     * @return The predicate
     */
    Predicate<T> getPredicate();

    /**
     * Attempts to parse the provided value as a value dictated possible by this trait or {@link Optional#empty()} otherwise.
     *
     * @param value The value to parse
     * @return The actual value
     */
    Optional<T> parseValue(String value);
}
