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

import com.google.common.base.Predicate;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;

import java.util.Collection;

/**
 * Represents a possible trait in a {@link BlockType}s {@link BlockState}.
 * 
 * <p>A {@link BlockState} can include 0 or more {@link BlockTrait}'s. Each
 * {@link BlockTrait} within a {@link BlockState} is mapped to a value which
 * represents the current value at the time the {@link BlockState} was taken.
 * </p>
 * 
 * <p>For example, a {@link BlockTypes#BED} contains 2 possible 
 * {@link BlockTrait}s :</p>
 * 
 * <ul>
 *     <li>OCCUPIED</li>
 *     <li>PART</li>
 * </ul>
 *
 * <p>If you query a {@link BlockTypes#BED}'s {@link BlockTrait}s you have 2
 * possible outcomes for each {@link BlockTrait}. The {@link BlockTrait}
 * 'OCCUPIED' has the following possible values :</p>
 * 
 * <ul>
 *     <li>TRUE</li>
 *     <li>FALSE</li>
 * </ul>
 *
 * <p>As 'OCCUPIED' is a {@link BooleanTrait}, it can only be TRUE or FALSE.
 * The {@link BlockTrait} PART has the following possible values :</p>
 * 
 * <ul>
 *     <li>HEAD</li>
 *     <li>FOOT</li>
 * </ul>
 * 
 * <p>To determine the current value of a {@link BlockTrait}, you would call
 * {@link BlockState#getTraitValue}. To determine all possible values of a
 * {@link BlockTrait}, you would call {@link BlockType#getTraits}.</p>
 *
 * <p>As stated above, a {@link BlockType} may not always have one or more
 * {@link BlockTrait}s. One example of such a block is 
 * {@link BlockTypes#BOOKSHELF}.</p>
 *
 */
public interface BlockTrait<T extends Comparable<T>> {

    /**
     * Gets the name of this {@link BlockTrait}.
     *
     * @return the trait name
     */
    String getName();

    /**
     * Gets all possible values for a specific {@link BlockTrait}. The
     * included values may not be in any particular order. The returned
     * {@link Collection} should be considered immutable.
     *
     * @return all possible values
     */
    Collection<T> getPossibleValues();

    /**
     * Gets the class type of the {@link BlockTrait}'s values.
     *
     * @return the value class
     */
    Class<T> getValueClass();

    /**
     * Gets the {@link Predicate} used to determine valid values
     * for this {@link BlockTrait}. Any "value" that returns
     * <code>true</code> when {@link Predicate#apply(Object)}
     * is called is valid. The {@link Predicate} is specific to this trait.
     * 
     * @return the predicate
     */
    Predicate<T> getPredicate();
}
