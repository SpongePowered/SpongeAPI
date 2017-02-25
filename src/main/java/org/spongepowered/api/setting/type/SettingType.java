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

import org.spongepowered.api.setting.Setting;
import org.spongepowered.api.setting.value.SettingValue;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A type of {@link Setting}.
 *
 * <p>Setting types are immutable.</p>
 *
 * @param <T> The type of value this setting type represents
 */
public interface SettingType<T, V extends SettingValue<T>> {

    /**
     * Gets a string representation of the provided object
     *
     * @param object The object to serialize
     * @return The string representation of the object
     */
    String serialize(V object);

    /**
     * Gets a {@link T} from a raw string.
     *
     * @param string The raw string to parse into {@link T}
     * @return The parsed value, if present, or {@link Optional#empty()}
     */
    Optional<V> deserialize(String string);

    /**
     * Create a {@link V} for the provided value.
     *
     * @param value The value
     * @return The setting value
     */
    V createValue(@Nullable T value);

}
