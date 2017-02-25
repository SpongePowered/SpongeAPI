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
package org.spongepowered.api.setting.value;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * An {@link Enum} setting value.
 */
public class EnumSettingValue<T extends Enum<T>> implements CycleableSettingValue<T> {

    private final Class<T> enumClass;
    @Nullable private T value;

    public EnumSettingValue(Class<T> enumClass, @Nullable T value) {
        this.enumClass = checkNotNull(enumClass, "enum class");
        this.value = value;
    }

    @Override
    public Optional<T> get() {
        return Optional.ofNullable(this.value);
    }

    @Override
    public void set(@Nullable T value) {
        this.value = value;
    }

    @Override
    public String serialize() {
        return this.value == null ? "" : this.value.name();
    }

    @Override
    public T cycleNext() {
        T[] constants = this.enumClass.getEnumConstants();

        int index;
        if (this.value == null) {
            index = 0;
        } else {
            index = this.value.ordinal() + 1;
            if (index >= constants.length) {
                index = 0;
            }
        }

        return constants[index];
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("enumClass", this.enumClass)
                .add("value", this.value)
                .toString();
    }

}
