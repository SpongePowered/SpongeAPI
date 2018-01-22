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
package org.spongepowered.api.text.action;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Represents a {@link TextAction} that responds to shift-clicks.
 *
 * @param <R> the type of the result of the action
 */
public interface ShiftClickAction<R> extends TextAction<R> {

    @Override
    default void applyTo(Text.Builder builder) {
        builder.onShiftClick(this);
    }

    /**
     * Inserts some text into the chat prompt.
     */
    interface InsertText extends ShiftClickAction<String> {

        /**
         * Creates a new builder.
         *
         * @return A new builder
         */
        static Builder builder() {
            return Sponge.getRegistry().createBuilder(Builder.class);
        }

        /**
         * A builder for {@link InsertText} shift click actions.
         */
        interface Builder extends ResettableBuilder<InsertText, Builder> {

            /**
             * Sets the text to insert.
             *
             * @param text The text
             * @return This builder
             */
            Builder text(String text);

            /**
             * Builds the action.
             *
             * @return The built action
             */
            InsertText build();
        }
    }
}
