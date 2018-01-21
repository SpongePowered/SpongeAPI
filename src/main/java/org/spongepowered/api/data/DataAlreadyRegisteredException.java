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

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;

import javax.annotation.Nullable;

public class DataAlreadyRegisteredException extends DataException {

    private static final long serialVersionUID = 6644721737729647869L;
    @Nullable private final Class<? extends DataManipulator<?, ?>> manipulatorClass;
    @Nullable private final Class<? extends ImmutableDataManipulator<?, ?>> immutableManipulatorClass;
    @Nullable private final DataManipulatorBuilder<?, ?> builder;


    /**
     * Constructs a new data already registered exception.
     *
     * @param manipulatorClass The manipulator class
     * @param immutableManipulatorClass The immutable manipulator class
     * @param builder The data manipulator builder
     */
    public DataAlreadyRegisteredException(@Nullable Class<? extends DataManipulator<?, ?>> manipulatorClass,
        @Nullable Class<? extends ImmutableDataManipulator<?, ?>> immutableManipulatorClass,
        @Nullable DataManipulatorBuilder<?, ?> builder) {
        this.manipulatorClass = manipulatorClass;
        this.immutableManipulatorClass = immutableManipulatorClass;
        this.builder = builder;
    }

    /**
     * Constructs a new data already registered exception with a message.
     *
     * @param message The message to send with the exception
     * @param manipulatorClass The manipulator class
     * @param immutableManipulatorClass The immutable manipulator class
     * @param builder The data manipulator builder
     */
    public DataAlreadyRegisteredException(String message,
        @Nullable Class<? extends DataManipulator<?, ?>> manipulatorClass,
        @Nullable Class<? extends ImmutableDataManipulator<?, ?>> immutableManipulatorClass,
        @Nullable DataManipulatorBuilder<?, ?> builder) {
        super(message);
        this.manipulatorClass = manipulatorClass;
        this.immutableManipulatorClass = immutableManipulatorClass;
        this.builder = builder;
    }

    /**
     * Constructs a new data already registered exception with a message and
     * a throwable cause.
     *
     * @param message The message to send with the exception
     * @param cause The cause of the exception
     * @param manipulatorClass The manipulator class
     * @param immutableManipulatorClass The immutable manipulator class
     * @param builder The data manipulator builder
     */
    public DataAlreadyRegisteredException(String message, Throwable cause,
        @Nullable Class<? extends DataManipulator<?, ?>> manipulatorClass,
        @Nullable Class<? extends ImmutableDataManipulator<?, ?>> immutableManipulatorClass,
        @Nullable DataManipulatorBuilder<?, ?> builder) {
        super(message, cause);
        this.manipulatorClass = manipulatorClass;
        this.immutableManipulatorClass = immutableManipulatorClass;
        this.builder = builder;
    }

    /**
     * Constructs a new data already registered exception with
     * a throwable cause.
     *
     * @param cause The cause of the exception
     * @param manipulatorClass The manipulator class
     * @param immutableManipulatorClass The immutable manipulator class
     * @param builder The data manipulator builder
     */
    public DataAlreadyRegisteredException(Throwable cause,
        @Nullable Class<? extends DataManipulator<?, ?>> manipulatorClass,
        @Nullable Class<? extends ImmutableDataManipulator<?, ?>> immutableManipulatorClass,
        @Nullable DataManipulatorBuilder<?, ?> builder) {
        super(cause);
        this.manipulatorClass = manipulatorClass;
        this.immutableManipulatorClass = immutableManipulatorClass;
        this.builder = builder;
    }

    /**
     * Gets the related data manipulator class.
     *
     * @return The manipulator class
     */
    @Nullable
    public Class<? extends DataManipulator<?, ?>> getManipulatorClass() {
        return this.manipulatorClass;
    }

    /**
     * Gets the related immutable data manipulator class.
     *
     * @return The immutable manipulator class
     */
    @Nullable
    public Class<? extends ImmutableDataManipulator<?, ?>> getImmutableManipulatorClass() {
        return this.immutableManipulatorClass;
    }

    /**
     * Gets the related data manipulator builder.
     *
     * @return The data manipulator builder
     */
    @Nullable
    public DataManipulatorBuilder<?, ?> getBuilder() {
        return this.builder;
    }
}
