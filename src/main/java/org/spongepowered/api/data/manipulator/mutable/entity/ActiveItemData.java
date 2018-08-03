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
package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableActiveItemData;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

/**
 * A {@link DataManipulator} which allows access to the active item that a
 * {@link Living} may be using. For example this includes a food a player is
 * currently eating or a shield they are blocking with.
 *
 * <p>If there is no item, the snapshot will be empty. You can check this
 * with {@link ItemStackSnapshot#isEmpty()}.</p>
 */
public interface ActiveItemData extends DataManipulator<ActiveItemData, ImmutableActiveItemData> {

    /**
     * Gets the item stack snapshot of the item that is currently being used.
     *
     * <p>If there is no item, the snapshot will be empty. You can check this
     * with {@link ItemStackSnapshot#isEmpty()}.</p>
     *
     * @return The value of the snapshot of the item being used
     */
    Value<ItemStackSnapshot> activeItem();

}
