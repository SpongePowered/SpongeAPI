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

import org.spongepowered.api.data.Property;
import org.spongepowered.api.util.Coerce;

import java.util.UUID;

/**
 * A property to uniquely identify an Inventory instance.
 */
public class Identifiable extends AbstractInventoryProperty<String, UUID> {

    /**
     * Creates an Identifiable with a random UUID.
     */
    public Identifiable() {
        this(UUID.randomUUID());
    }

    /**
     * Creates an Identifiable with given UUID.
     *
     * @param value The UUID
     */
    public Identifiable(UUID value) {
        super(value);
    }

    /**
     * Creates an Identifiable with given UUID.
     *
     * @param value The UUID
     * @param op The operator
     */
    public Identifiable(UUID value, Operator op) {
        super(value, op);
    }

    @Override
    public int compareTo(Property<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return this.getValue().toString().compareTo(Coerce.toString(other.getValue()));
    }
}
