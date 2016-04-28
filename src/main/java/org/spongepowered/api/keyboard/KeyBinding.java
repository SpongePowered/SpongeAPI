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
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;

import javax.annotation.Nullable;

public interface KeyBinding extends CatalogType, Translatable {

    /**
     * Creates a new {@link Builder}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link KeyCategory} of this key binding.
     *
     * @return The category
     */
    KeyCategory getCategory();

    /**
     * Gets the default {@link KeyCode} of this key binding,
     * this may be absent if the binding isn't bound by default.
     *
     * @return The key code
     */
    Optional<KeyCode> getDefaultKeyCode();

    interface Builder extends ResettableBuilder<KeyBinding, Builder> {

        /**
         * Sets the {@link KeyCategory} of the key binding, when {@code null}
         * is specified then will the builder default to the category
         * {@link KeyCategories#MISC}.
         *
         * @param category The category
         * @return This builder for chaining
         */
        Builder category(@Nullable KeyCategory category);

        /**
         * Sets the default {@link KeyCode} of the key binding.
         *
         * @param keyCode The key code
         * @return This builder for chaining
         */
        Builder keyCode(@Nullable KeyCode keyCode);

        /**
         * Sets the identifier of the category.
         *
         * @param identifier The identifier
         * @return This builder for chaining
         */
        Builder identifier(String identifier);

        /**
         * Sets the display name (the one that will be shown on the
         * client) of the key binding.
         *
         * @param displayName The display name
         * @return This builder for chaining
         */
        Builder displayName(Text displayName);

        /**
         * Adds the handlers to the key binding. This will clear
         * the handlers that were applied previously.
         *
         * <p>The order the handlers are inserted matters, it will be the
         * order that they will be executed.</p>
         *
         * @param handler The handler
         * @param handlers The extra handler
         * @return This builder for chaining
         */
        Builder handlers(KeyInteractHandler handler, KeyInteractHandler... handlers);

        /**
         * Builds a new instanceof of a {@link KeyBinding} and registers it.
         *
         * @return The key binding
         * @throws IllegalStateException If the key binding is not completed or if
         * there already a key binding is registered with the identifier
         */
        KeyBinding buildAndRegister();
    }
}
