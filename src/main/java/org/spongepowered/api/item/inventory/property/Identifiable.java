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

import java.util.UUID;

/**
 * A property to uniquely identify an Inventory instance.
 */
public interface Identifiable extends InventoryProperty<String, UUID> {

    /**
     * Create an Identifiable with given UUID for use in queries.
     *
     * @param value The UUID
     * @return The new Identifiable
     */
    static Identifiable of(UUID value) {
        return builder().value(value).operator(Operator.EQUAL).build();
    }

    /**
     * Creates a new Identifiable with a random UUID and {@link Operator#DELEGATE} for use in custom build Inventories.
     *
     * @return The new Identifiable
     */
    static Identifiable random() {
        return builder().value(UUID.randomUUID()).operator(Operator.DELEGATE).build();
    }

    /**
     * Creates a new {@link Identifiable.Builder} to create {@link Identifiable}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Identifiable.Builder.class);
    }

    /**
     * Represents a builder class to create {@link Identifiable}s.
     */
    interface Builder extends InventoryProperty.Builder<UUID, Identifiable, Builder> {
    }

}
