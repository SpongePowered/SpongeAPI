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
package org.spongepowered.api.data;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.CompositeValueStore;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Represents a transaction taking place where a {@link DataHolder} is
 * accepting {@link DataManipulator}s.
 */
public interface DataTransactionResult {

    /**
     * The type of transaction result.
     */
    enum Type {

        /**
         * The actual result of the operation is undefined, this probably
         * indicates that something went wrong with the operation that the
         * {@link DataManipulator} couldn't handle or didn't expect. The
         * state of the {@link DataManipulator} is undefined.
         */
        UNDEFINED,

        /**
         * The item data operation succeeded.
         */
        SUCCESS,

        /**
         * The {@link DataManipulator} operation failed for an
         * <em>expected</em> reason (such as the {@link DataManipulator} being
         * incompatible with the {@link DataHolder}. The condition of the
         * {@link DataManipulator} is unchanged.
         */
        FAILURE,

        /**
         * The {@link DataManipulator} operation failed because an
         * <em>unexpected</em> condition occurred. The state of the
         * {@link DataManipulator} is undefined.
         */
        ERROR,

        /**
         * An operation was cancelled by a third party (eg. a
         * {@link DataManipulator} event was cancelled). The condition of the
         * {@link DataManipulator} is unchanged.
         */
        CANCELLED,
        ;
    }

    /**
     * Get the type of result.
     *
     * @return the type of result
     */
    Type getType();

    /**
     * If any {@link BaseValue}s applied onto a {@link CompositeValueStore} were
     * successful, they'll be stored in the given list.
     *
     * @return An immutable list of the values successfully offered
     */
    ImmutableList<ImmutableValue<?>> getSuccessfulData();

    /**
     * If {@link Value}s were supplied to the operation, this
     * collection will return any {@link ImmutableValue}s which were rejected
     * by the target {@link DataHolder}.
     *
     * @return Any data that was rejected from the operation
     */
    ImmutableList<ImmutableValue<?>> getRejectedData();

    /**
     * If the operation replaced any {@link Value}s, this returns a collection
     * of the replaced {@link ImmutableValue}s.
     *
     * @return Any data that was replaced
     */
    ImmutableList<ImmutableValue<?>> getReplacedData();

}
