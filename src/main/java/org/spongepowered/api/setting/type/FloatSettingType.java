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

import org.spongepowered.api.setting.value.NumberSettingValue;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A {@link Float} setting type.
 */
public class FloatSettingType implements SettingType<Float, NumberSettingValue<Float>> {

    protected FloatSettingType() {
    }

    @Override
    public String serialize(NumberSettingValue<Float> object) {
        return object.serialize();
    }

    @Override
    public Optional<NumberSettingValue<Float>> deserialize(String string) {
        checkNotNull(string, "string");

        try {
            float value = Float.parseFloat(string);
            return Optional.of(this.createValue(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Override
    public NumberSettingValue<Float> createValue(@Nullable Float value) {
        return new NumberSettingValue<>(value);
    }

}
