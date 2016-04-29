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
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nullable;

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
         * Sets the {@link KeyCategory} of the key binding, when {@code null}
         * is specified then will the builder default to the category
         * {@link KeyCategories#MISC}.
         *
         * @param category The category
         * @return This builder for chaining
         */
        Builder category(@Nullable KeyCategory category);

        /**
         * Sets the identifier of the category.
         *
         * @param identifier The identifier
         * @return This builder for chaining
         */
        Builder id(String identifier);

        /**
         * Sets the display name (the one that will be shown on the
         * client) of the key binding.
         *
         * @param displayName The display name
         * @return This builder for chaining
         */
        Builder displayName(Text displayName);

        /**
         * Builds a new instanceof of a {@link KeyBinding}.
         *
         * @return The key binding
         * @throws IllegalStateException If the key binding is not completed
         */
        KeyBinding build();
    }
}
