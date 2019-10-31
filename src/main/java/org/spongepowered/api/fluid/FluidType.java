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
package org.spongepowered.api.fluid;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.state.StateContainer;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * The functional equivalent of an {@link ItemType} or {@link BlockType},
 * except for fluids. Normally, the gameplay mechanics of fluids are entirely
 * dependent on the implementation of a fluid; however, they are representable
 * as {@link FluidStack}s, where a certain amount of a {@link FluidType} for
 * a specified volume "exists" within a {@link Keys#FLUID_TANK_CONTENTS Fluid Tank Value}.
 *
 * <p>Normally, {@link Keys#FLUID_TANK_CONTENTS} can be either retrieved from
 * either a {@link BlockState} or {@link BlockEntity} that specifically handles
 * fluids. Depending on the implementation, a fluid stack may be used differently
 * than how vanilla implementations handle them.</p>
 */
@CatalogedBy(FluidTypes.class)
public interface FluidType extends StateContainer<FluidState>, ValueContainer, CatalogType {

}
