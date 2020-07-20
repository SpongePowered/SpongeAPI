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
package org.spongepowered.api.adventure;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

import java.util.Optional;
import java.util.Set;

/**
 * A registry for Adventure types.
 */
public interface AdventureRegistry {
    /**
     * Gets the registry of {@link TextDecoration}s.
     *
     * @return The registry
     */
    OfType<TextDecoration> getDecorations();

    /**
     * Gets the registry of {@link NamedTextColor}s.
     *
     * @return The registry
     */
    OfType<NamedTextColor> getNamedColors();

    /**
     * Gets the registry of {@link ClickEvent.Action}s.
     *
     * @return The registry
     */
    OfType<ClickEvent.Action> getClickEventActions();

    /**
     * Gets the registry of {@link HoverEvent.Action}s.
     *
     * @return The registry
     */
    OfType<HoverEvent.Action<?>> getHoverEventActions();

    /**
     * Gets the registry of {@link BossBar.Color}s.
     *
     * @return The registry
     */
    OfType<BossBar.Color> getBossBarColors();

    /**
     * Gets the registry of {@link BossBar.Overlay}s.
     *
     * @return The registry
     */
    OfType<BossBar.Overlay> getBossBarOverlays();

    /**
     * Gets the registry of {@link BossBar.Flag}s.
     *
     * @return The registry
     */
    OfType<BossBar.Flag> getBossBarFlags();

    /**
     * Gets the registry of {@link Sound.Source}s.
     *
     * @return The registry
     */
    OfType<Sound.Source> getSoundSources();

    /**
     * A registry for an Adventure type.
     *
     * @param <T> The type
     */
    interface OfType<T> {
        /**
         * Gets the key for a value.
         *
         * @param value the value
         * @return the key
         */
        String getKey(final T value);

        /**
         * Gets a value by its key.
         *
         * @param key the key
         * @return the value
         */
        Optional<T> getValue(final String key);

        /**
         * Gets the keys.
         *
         * @return the keys
         */
        Set<String> keys();
    }
}
