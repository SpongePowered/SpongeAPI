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
package org.spongepowered.api.extra.fluid.data.manipulator.mutable;

import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
import org.spongepowered.api.extra.fluid.data.manipulator.immutable.ImmutableFluidItemData;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represented data for a {@link FluidStackSnapshot}, which may be owned by
 * various instances of {@link ItemStack}s, {@link TileEntity} instances,
 * and possibly {@link Entity} instances. Traditionally,
 * {@link ItemTypes#BUCKET}s will not have changeable instances of data without
 * changing the {@link ItemType}. Provided that a {@link TileEntity} contains
 * multiple fluids, it may have optionaly {@link FluidTankData} instead of
 * {@link FluidItemData}.
 */
public interface FluidItemData extends DataManipulator<FluidItemData, ImmutableFluidItemData> {

    /**
     * Gets the {@link FluidStackSnapshot} from the owner as a value.
     *
     * @return The value of the fluid stack snapshot
     *
     * @see Keys#FLUID_ITEM_STACK
     */
    Value<FluidStackSnapshot> fluid();

}
