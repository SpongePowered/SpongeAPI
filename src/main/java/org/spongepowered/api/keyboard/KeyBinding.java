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
package org.spongepowered.api.keyboard;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.keyboard.InteractKeyEvent;
import org.spongepowered.api.event.keyboard.RegisterKeyBindingsEvent;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.function.Consumer;

/**
 * Represents a key binding, which a client may use to interact
 * with the server.
 *
 * <p>All the key bindings will by default be available for all the
 * {@link Player}s, you can modify this in the
 * {@link RegisterKeyBindingsEvent}.</p>
 */
public interface KeyBinding extends CatalogType {

    /**
     * Creates a new {@link Builder}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link KeyContext} of this key binding.
     *
     * @return The key context
     */
    KeyContext getContext();

    /**
     * Gets the {@link KeyCategory} of this key binding.
     *
     * @return The category
     */
    KeyCategory getCategory();

    /**
     * Gets the display name of this key binding.
     *
     * @return The display name
     */
    Text getDisplayName();

    interface Builder extends ResettableBuilder<KeyBinding, Builder> {

        /**
         * Sets the {@link KeyCategory} of the key binding, defaults
         * to {@link KeyCategories#MISC}.
         *
         * @param category The category
         * @return This builder for chaining
         */
        Builder category(KeyCategory category);

        /**
         * Sets the {@link KeyContext} of the key binding, defaults
         * to {@link KeyContexts#UNIVERSAL}.
         *
         * @param keyContext The key context
         * @return This builder for chaining
         */
        Builder context(KeyContext keyContext);

        /**
         * Sets the display name of the key binding (the one
         * that will be shown on the client).
         *
         * @param displayName The display name
         * @return This builder for chaining
         */
        Builder displayName(Text displayName);

        /**
         * Registers a listener for the specified {@link InteractKeyEvent}.
         *
         * @param type The type of the key interact event
         * @param listener The listener to register
         * @return This builder for chaining
         */
        <E extends InteractKeyEvent> Builder listener(Class<E> type, Consumer<E> listener);

        /**
         * Builds a new instanceof of a {@link KeyBinding}.
         *
         * @param plugin The plugin instance that owns the key binding and
         *               should be used to register the events
         * @param identifier The identifier
         * @return The key binding
         * @throws IllegalStateException If the key binding is not complete
         */
        KeyBinding build(Object plugin, String identifier);
    }
}
