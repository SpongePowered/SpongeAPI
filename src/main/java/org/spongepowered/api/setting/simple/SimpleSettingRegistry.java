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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.Sets;
import org.spongepowered.api.setting.Setting;
import org.spongepowered.api.setting.SettingRegistry;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A simple implementation of a {@link SettingRegistry}.
 */
public class SimpleSettingRegistry implements SettingRegistry {

    protected final Set<Setting<?>> settings = Sets.newHashSet();
    protected final Set<Setting<?>> readOnlySettings = Collections.unmodifiableSet(this.settings);

    @Override
    public boolean contains(Setting<?> setting) {
        checkNotNull(setting, "setting");
        return this.settings.contains(setting);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Optional<Setting<T>> get(String string, boolean aliases) {
        checkNotNull(string, "string");
        checkArgument(Setting.ID_PATTERN.matcher(string).matches(), "search string does not match setting id pattern");

        for (Setting<?> setting : this.settings) {
            if (setting.getId().equalsIgnoreCase(string)) {
                return Optional.of((Setting<T>) setting);
            }
        }

        // Only check aliases if we're asked to
        if (aliases) {
            for (Setting<?> setting : this.settings) {
                for (String alias : setting.getAliases()) {
                    if (alias.equalsIgnoreCase(string)) {
                        return Optional.of((Setting<T>) setting);
                    }
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public Collection<Setting<?>> getAll() {
        return this.readOnlySettings;
    }

    @Override
    public SettingRegistry register(Setting<?> setting) {
        checkNotNull(setting, "setting");

        // Ensure there are no existing settings with the same id or aliases
        Collection<String> ids = this.settings.stream().flatMap(other -> other.getAliases().stream()).collect(Collectors.toSet());
        checkArgument(!ids.contains(setting.getId()), "a setting with id '%s' has already been registered", setting.getId());
        for (String alias : setting.getAliases()) {
            checkArgument(!ids.contains(alias), "a setting with id '%s' has already been registered", alias);
        }

        this.settings.add(setting);
        return this;
    }

    @Override
    public boolean unregister(Setting<?> setting) {
        checkNotNull(setting, "setting");
        return this.settings.remove(setting);
    }

}
