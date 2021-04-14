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
package org.spongepowered.api.command.parameter.managed.operator;

import org.spongepowered.api.command.parameter.managed.standard.ResourceKeyedValueParameters;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents an operator that can be specified in a command.
 *
 * @see ResourceKeyedValueParameters#OPERATOR
 */
@CatalogedBy(Operators.class)
public interface Operator {

    /**
     * The string representation of this operator
     *
     * @return The representation
     */
    String asString();

    /**
     * An operator that can operate on two numbers and return a number.
     */
    interface Simple extends Operator {

        /**
         * Operates on two numbers, returning the result of the operation.
         *
         * @param first the first number to operate on
         * @param second the second number to operate on
         * @return the result of the operation
         */
        int apply(int first, int second);

        /**
         * Operates on two numbers, returning the result of the operation.
         *
         * @param first the first number to operate on
         * @param second the second number to operate on
         * @return the result of the operation
         */
        long apply(long first, long second);

        /**
         * Operates on two numbers, returning the result of the operation.
         *
         * @param first the first number to operate on
         * @param second the second number to operate on
         * @return the result of the operation
         */
        double apply(double first, double second);

    }

}
