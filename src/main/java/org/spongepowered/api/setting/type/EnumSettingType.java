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
package org.spongepowered.api.setting.type;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableBiMap;
import org.spongepowered.api.setting.value.EnumSettingValue;

import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * An {@link Enum} setting type.
 */
public class EnumSettingType<T extends Enum<T>> implements SettingType<T, EnumSettingValue<T>> {

    private final Class<T> enumClass;
    private final Map<String, T> values;

    public EnumSettingType(Class<T> enumClass) {
        this.enumClass = checkNotNull(enumClass, "enum class");

        ImmutableBiMap.Builder<String, T> values = ImmutableBiMap.builder();
        for (T constant : this.enumClass.getEnumConstants()) {
            values.put(constant.name(), constant);
        }

        this.values = values.build();
    }

    @Override
    public String serialize(EnumSettingValue<T> object) {
        return object.serialize();
    }

    @Override
    public Optional<EnumSettingValue<T>> deserialize(String string) {
        checkNotNull(string, "string");

        return Optional.ofNullable(this.search(string)).map(this::createValue);
    }

    @Nullable
    private T search(String name) {
        for (Map.Entry<String, T> entry : this.values.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public EnumSettingValue<T> createValue(@Nullable T value) {
        return new EnumSettingValue<>(this.enumClass, value);
    }

}
