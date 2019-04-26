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
package org.spongepowered.api.item.inventory.property;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.InventoryProperty;

/**
 * A property to define which GUI should be opened on the client
 * for the inventory.
 */
public interface GuiIdProperty extends InventoryProperty<String, GuiId> {

    /**
     * Creates a GuiIdProperty.
     *
     * @param value The GuiId
     * @return The created GuiIdProperty
     */
    static GuiIdProperty of(GuiId value) {
        return builder().value(value).operator(Operator.EQUAL).build();
    }

    /**
     * Creates a new {@link GuiIdProperty.Builder} to create {@link GuiIdProperty}s.
     *
     * @return The new builder
     */
    static GuiIdProperty.Builder builder() {
        return Sponge.getRegistry().createBuilder(GuiIdProperty.Builder.class);
    }

    /**
     * Represents a builder class to create {@link GuiIdProperty}s.
     */
    interface Builder extends InventoryProperty.Builder<GuiId, GuiIdProperty, Builder> {
    }
}
