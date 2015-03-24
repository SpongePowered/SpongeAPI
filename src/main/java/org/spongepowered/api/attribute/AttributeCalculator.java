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

package org.spongepowered.api.attribute;

import java.util.Collection;


public interface AttributeCalculator {

    /**
     * <p>
     * Calculates the value of an attribute given a base value and a set of
     * {@link Operation}s and modification values. The order of operation
     * evaluation will be decided according to a list sorted by each operations
     * {@link Operation#compareTo} method. Their
     * {@link Operation#changeValueImmediately()} will determine whether after
     * being evaluated, an operation's incrementation will be added to the value
     * immediately, or be summed with all other incrementations from the same
     * type of operation, then added.
     * </p>
     *
     * @param base The base value of the attribute
     * @param modifiers A collection of {@link AttributeModifier}s to be applied
     *        to the base value
     *
     * @return The modified value of the attribute
     */
    double calculateValue(double base, Collection<AttributeModifier> modifiers);

}
