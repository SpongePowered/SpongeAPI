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
package org.spongepowered.api.setting.simple;

import org.spongepowered.api.setting.Setting;
import org.spongepowered.api.setting.SettingManager;
import org.spongepowered.api.setting.SettingRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;

public class SimpleSettingManager implements SettingManager {

    protected final Map<Setting<?>, Object> values = new HashMap<>();
    protected final SettingRegistry registry;

    public SimpleSettingManager(SettingRegistry registry) {
        this.registry = registry;
    }

    @Override
    public <T> boolean hasValue(Setting<T> setting) {
        return this.values.containsKey(setting);
    }

    @Override
    public <T> Optional<T> getValue(Setting<T> setting) {
        @Nullable final T value = (T) this.values.get(setting);
        if (value == null) {
            return setting.getDefaultValue();
        }
        return Optional.of(value);
    }

    @Override
    public <T> void setValue(Setting<T> setting, @Nullable T value) {
        if (value == null) {
            this.values.remove(setting);
            return;
        }

        this.values.put(setting, value);
    }
}
