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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.setting.Setting;
import org.spongepowered.api.setting.type.SettingType;
import org.spongepowered.api.setting.value.SettingValue;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A simple implementation of a {@link Setting}.
 *
 * @param <T> The value type of this setting
 */
public class SimpleSetting<T> implements Setting<T> {

    protected final String id;
    protected final Collection<String> aliases;
    protected final SettingType<T, SettingValue<T>> type;
    protected final Text name;
    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    protected final Optional<T> defaultValue;

    @SuppressWarnings("ConstantConditions")
    public SimpleSetting(String id, Collection<String> aliases, SettingType<T, SettingValue<T>> type, Text name, @Nullable T defaultValue) {
        this.id = checkNotNull(id, "id");
        this.aliases = checkNotNull(aliases, "aliases");
        this.type = checkNotNull(type, "type");
        this.name = checkNotNull(name, "name");
        this.defaultValue = Optional.ofNullable(defaultValue);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Collection<String> getAliases() {
        return this.aliases;
    }

    @Override
    public Text getName(@Nullable MessageReceiver receiver) {
        return this.name;
    }

    @Override
    public SettingType<T, SettingValue<T>> getType() {
        return this.type;
    }

    @Override
    public Optional<T> getDefaultValue() {
        return this.defaultValue;
    }

}
