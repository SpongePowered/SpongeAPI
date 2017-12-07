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
package org.spongepowered.api.data.property.common;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.property.NonnullAbstractProperty;
import org.spongepowered.api.data.type.TreeType;
import org.spongepowered.api.data.type.TreeTypes;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.util.Coerce;

import javax.annotation.Nullable;

/**
 * A property that can used to retrieve the {@link TreeType} from wood
 * based {@link BlockType}s or {@link ItemType}s.
 */
public final class TreeTypeProperty extends NonnullAbstractProperty<String, TreeType> {

    /**
     * Constructs a new {@link TreeTypeProperty} with
     * the specified {@link TreeType}.
     *
     * @param value The tree type
     */
    public TreeTypeProperty(TreeType value) {
        super(value);
    }

    /**
     * Constructs a new {@link TreeTypeProperty} with
     * the specified {@link TreeType} and {@link Operator}.
     *
     * @param value The tree type
     * @param operator The operator
     */
    public TreeTypeProperty(TreeType value, Operator operator) {
        super(value, operator);
    }

    @Override
    public int compareTo(@Nullable Property<?, ?> o) {
        final TreeType other = Coerce.toPseudoEnum(o == null ? null : o.getValue(), TreeType.class, TreeTypes.class, TreeTypes.OAK);
        return getValue().getId().compareTo(o == null ? "" : other.getId());
    }
}
