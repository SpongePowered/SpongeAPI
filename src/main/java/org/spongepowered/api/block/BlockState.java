/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.block;

/**
 * Interface that represents a particular block state of a block.
 *
 * Block states can can be various different types.
 */
public interface BlockState {

    /**
     * Gets if the block state is of type boolean.
     *
     * @return Whether it is of type boolean
     */
    boolean isBoolean();

    /**
     * Gets the value of the block state if it is of type boolean,
     * if not an exception is thrown.
     *
     * @throws BlockStateTypeException If block state isn't of type boolean
     * @return Value of the block state
     */
    boolean getAsBoolean();

    /**
     * Gets if the block state is of type int.
     *
     * @return Whether it is of type int
     */
    boolean isInt();

    /**
     * Gets the value of the block state if it is of type int,
     * if not an exception is thrown.
     *
     * @throws BlockStateTypeException If block state isn't of type int
     * @return Value of the block state
     */
    int getAsInt();

    /**
     * Gets if the block state is of type {@link String}.
     *
     * @return Whether it is of type {@link String}
     */
    boolean isString();

    /**
     * Gets the value of the block state if it is of type {@link String},
     * if not an exception is thrown.
     *
     * @throws BlockStateTypeException If block state isn't of type
     *     {@link String}
     * @return Value of the block state
     */
    String getAsString();

    /**
     * Gets if the block state is of type {@link Direction}.
     *
     * @return Whether it is of type {@link Direction}
     */
    boolean isDirection();

    /**
     * Gets the value of the block state if it is of type {@link Direction},
     * if not an exception is thrown.
     *
     * @throws BlockStateTypeException If block state isn't of type
     *     {@link Direction}
     * @return Value of the block state
     */
    Direction getAsDirection();

    /**
     * Gets if the block state is of type {@code type}.
     *
     * @param type Type to check if this is of {@code type}
     * @return Whether it is of type {@code type}
     */
    boolean isOfType(Class<?> type);

    // should this be able to return null?
    /**
     * Gets the value of the block state if it is of type of {@code type},
     * if not an exception is thrown.
     *
     * @param <T>  Type of value that will be returned
     * @param type Type of value that will be returned
     * @throws BlockStateTypeException If block state isn't of type
     *     {@link Direction}
     * @return Value of the block state
     */
    <T> T getAsType(Class<T> type);
}
