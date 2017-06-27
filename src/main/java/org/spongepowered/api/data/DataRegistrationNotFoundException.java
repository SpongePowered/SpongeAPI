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
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;

import javax.annotation.Nullable;

public class DataRegistrationNotFoundException extends DataException {

    private static final long serialVersionUID = -1671720083547789746L;
    @Nullable private String registrationQuery;
    @Nullable private Class<? extends DataManipulator<?, ?>> manipulatorClass;
    @Nullable private Class<? extends ImmutableDataManipulator<?, ?>> immutableClass;

    public DataRegistrationNotFoundException() {
        super();
    }

    public DataRegistrationNotFoundException(String registrationQuery) {
        super(registrationQuery);
        this.registrationQuery = registrationQuery;
    }

    public DataRegistrationNotFoundException(String message, String registrationQuery) {
        super(message);
        this.registrationQuery = registrationQuery;
    }

    public DataRegistrationNotFoundException(String message,
        Class<? extends DataManipulator<?, ?>> manipulatorClass) {
        super(message);
        this.manipulatorClass = manipulatorClass;
    }

    public DataRegistrationNotFoundException(String message, Throwable cause,
        Class<? extends DataManipulator<?, ?>> manipulatorClass) {
        super(message, cause);
        this.manipulatorClass = manipulatorClass;
    }

    public DataRegistrationNotFoundException(String message,
        @Nullable Class<? extends DataManipulator<?, ?>> manipulatorClass,
        Class<? extends ImmutableDataManipulator<?, ?>> immutableClass) {
        super(message);
        this.manipulatorClass = manipulatorClass;
        this.immutableClass = immutableClass;
    }

    public DataRegistrationNotFoundException(String message, Throwable cause,
        @Nullable Class<? extends DataManipulator<?, ?>> manipulatorClass,
        Class<? extends ImmutableDataManipulator<?, ?>> immutableClass) {
        super(message, cause);
        this.manipulatorClass = manipulatorClass;
        this.immutableClass = immutableClass;
    }

    @Nullable
    public String getRegistrationQuery() {
        return this.registrationQuery;
    }

    @Nullable
    public Class<? extends DataManipulator<?, ?>> getManipulatorClass() {
        return this.manipulatorClass;
    }

    @Nullable
    public Class<? extends ImmutableDataManipulator<?, ?>> getImmutableClass() {
        return this.immutableClass;
    }
}
