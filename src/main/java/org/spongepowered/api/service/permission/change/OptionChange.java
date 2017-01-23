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
package org.spongepowered.api.service.permission.change;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents a change in option values.
 */
public class OptionChange {
    private final String option;
    private final String oldValue;
    private final String newValue;

    public OptionChange(String option, @Nullable String oldValue, @Nullable String newValue) {
        this.option = option;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * The option with a value being changed.
     *
     * @return The option
     */
    public String getOption() {
        return option;
    }

    /**
     * The old value of the option. {@link Optional#empty()} if the option has not been set before.
     *
     * @return The old value
     */
    public Optional<String> getOldValue() {
        return Optional.ofNullable(oldValue);
    }

    /**
     * The new value of the option. {@link Optional#empty()} if the permission will be unset.
     *
     * @return The new value
     */
    public Optional<String> getNewValue() {
        return Optional.ofNullable(newValue);
    }
}
