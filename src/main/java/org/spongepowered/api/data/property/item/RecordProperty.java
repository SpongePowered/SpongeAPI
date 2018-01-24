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
package org.spongepowered.api.data.property.item;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.property.AbstractProperty;
import org.spongepowered.api.effect.sound.record.RecordType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * A {@link RecordProperty} used to retrieve a {@link RecordType}
 * from a {@link ItemType} or {@link ItemStack}.
 */
public final class RecordProperty extends AbstractProperty<String, RecordType> {

    /**
     * Constructs a new record property with the specified record type.
     *
     * @param instrument The record type the record plays
     */
    public RecordProperty(RecordType instrument) {
        super(checkNotNull(instrument, "instrument"));
    }

    @Override
    public int compareTo(Property<?, ?> o) {
        if (!(o instanceof RecordProperty)) {
            return -1;
        }
        return getValue().getId().compareTo(((RecordProperty) o).getValue().getId());
    }
}
