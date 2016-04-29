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
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.List;

/**
 * Represents a key category. This is a sub list in the keys
 * window of the Minecraft client.
 */
@CatalogedBy(KeyCategories.class)
public interface KeyCategory extends CatalogType {

    /**
     * Creates a new {@link Builder}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets all the {@link KeyBinding}s that are added to this
     * category.
     *
     * @return The bindings
     */
    List<KeyBinding> getBindings();

    /**
     * Gets the title of this key category.
     *
     * @return The title
     */
    Text getTitle();

    interface Builder extends ResettableBuilder<KeyCategory, Builder> {

        /**
         * Sets the title of the category.
         *
         * @param title The title
         * @return This builder for chaining
         */
        Builder title(Text title);

        /**
         * Sets the identifier of the category.
         *
         * @param identifier The identifier
         * @return This builder for chaining
         */
        Builder id(String identifier);

        /**
         * Builds a new instanceof of a {@link KeyCategory}.
         *
         * @return The key category
         * @throws IllegalStateException If the key category is not completed
         */
        KeyCategory build();
    }
}
