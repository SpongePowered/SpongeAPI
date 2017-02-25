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
package org.spongepowered.api.setting;

import java.util.Collection;
import java.util.Optional;

/**
 * A setting registry.
 */
public interface SettingRegistry {

    /**
     * Determines if this registry contains the provided setting.
     *
     * @param setting The setting
     * @return {@code true} if this registry contains the setting,
     *     {@code false} otherwise
     */
    boolean contains(Setting<?> setting);

    /**
     * Finds a setting by its id or alias.
     *
     * @param string The search string
     * @return The setting, if present, {@link Optional#empty()} otherwise
     */
    default <T> Optional<Setting<T>> get(String string) {
        return this.get(string, true);
    }

    /**
     * Finds a setting.
     *
     * <p>If {@code aliases} is {@code false} aliases will be ignored, and
     * only the id will be matched against.</p>
     *
     * @param string The search string
     * @param aliases If aliases should be checked
     * @return The setting, if present, {@link Optional#empty()} otherwise
     */
    <T> Optional<Setting<T>> get(String string, boolean aliases);

    /**
     * Gets a collection of all registered settings.
     *
     * @return A collection of all registered settings
     */
    Collection<Setting<?>> getAll();

    /**
     * Registers a setting with this registry.
     *
     * @param setting The setting
     * @return This registry
     * @throws IllegalArgumentException If a setting is already registered
     *     with a matching id
     * @throws IllegalArgumentException If a setting is already registered
     *     with a matching alias
     */
    SettingRegistry register(Setting<?> setting);

    /**
     * Registers a setting with this registry.
     *
     * @param setting The setting
     * @return {@code true} if the setting was unregistered,
     *     {@code false} otherwise
     */
    boolean unregister(Setting<?> setting);

}
