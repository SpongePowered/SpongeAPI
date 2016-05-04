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
package org.spongepowered.api.text.dictionary;

import org.spongepowered.api.Sponge;

import java.util.Optional;

/**
 * A helper class to retrieve common dictionaries.
 */
public final class Dictionaries {

    private Dictionaries() {
    }

    /**
     * Gets the Minecraft dictionary.
     *
     * @return The Minecraft dictionary
     */
    // The Minecraft dictionary should always be available
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static MinecraftDictionary minecraft() {
        return Sponge.getServiceManager().provide(MinecraftDictionary.class).get();
    }

    /**
     * Gets the dictionary for the provided plugin.
     *
     * @param plugin The plugin instance
     * @return The dictionary, if present, {@link Optional#empty()} otherwise
     */
    public static Optional<Dictionary> plugin(Object plugin) {
        return Sponge.getPluginManager().fromInstance(plugin)
                .map(container -> container.getServiceManager().provide(Dictionary.class).orElse(null));
    }

    /**
     * Gets the Sponge dictionary.
     *
     * @return The Sponge dictionary
     */
    // The Sponge dictionary should always be available
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static SpongeDictionary sponge() {
        return Sponge.getServiceManager().provide(SpongeDictionary.class).get();
    }

}
