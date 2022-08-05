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

import net.kyori.adventure.text.format.Style;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.DataPackEntryBuilder;

/**
 * A template for {@link ChatType chat types}.
 */
public interface ChatTypeTemplate extends DataPackEntry<ChatTypeTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the chat type
     *
     * @return The chat type
     */
    ChatType type();

    interface Builder extends DataPackEntryBuilder<ChatType, ChatTypeTemplate, Builder> {

        /**
         * Sets the translation key or custom format mask.
         *
         * @param translationKey The translation key or format mask
         * @return this builder, for chaining
         */
        Builder translationKey(String translationKey);

        /**
         * Sets the style.
         *
         * @param style The style
         * @return this builder, for chaining
         */
        Builder style(Style style);

        /**
         * Adds a sender parameter.
         *
         * @return this builder, for chaining
         */
        Builder addSender();

        /**
         * Adds a content parameter.
         *
         * @return this builder, for chaining
         */
        Builder addContent();

        /**
         * Adds a target parameter.
         *
         * @return this builder, for chaining
         */
        Builder addTarget();

    }
}
