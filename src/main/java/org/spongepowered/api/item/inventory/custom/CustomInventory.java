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
package org.spongepowered.api.item.inventory.custom;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.type.OrderedInventory;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * A CustomInventory is an inventory that has no backing in the world that is
 * created by plugins.
 */
public interface CustomInventory extends OrderedInventory, Identifiable {

    /**
     * Creates a new {@link Builder} to build a {@link CustomInventory}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }


    interface Builder extends ResettableBuilder<CustomInventory, Builder> {
        /**
         * Sets the title of the custom inventory, viewable by players looking
         * at the inventory.
         *
         * @param name The title
         * @return fluent pattern
         */
        Builder name(Translation name);

        /**
         * Sets the size of the custom inventory.
         *
         * @param size The size
         * @return fluent pattern
         */
        Builder size(int size);

        /**
         * Builds the inventory instance.
         *
         * @return A new custom inventory
         */
        CustomInventory build();

        // TODO add persistence methods
    }
}
