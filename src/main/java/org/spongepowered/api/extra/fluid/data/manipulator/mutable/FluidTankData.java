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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.extra.fluid.FluidStack;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
import org.spongepowered.api.extra.fluid.data.manipulator.immutable.ImmutableFluidTankData;
import org.spongepowered.api.util.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The primary definition of a "tank" is that at any given {@link Direction},
 * the {@link DataHolder} may have multiple {@link FluidStack}s existing within
 * itself. Granted, in most cases, the {@link Direction} doesn't quite matter as
 * the tank itself is just a single container containing multiple
 * {@link FluidStack}s, however, in some cases, mod added tanks may have
 * different tanks for different directions. Note that setting an empty
 * {@link List} of {@link FluidStackSnapshot}s to a {@link Direction} is the
 * functional equivalent to saying "remove all fluids from that direction".
 */
public interface FluidTankData extends MappedData<Direction, List<FluidStackSnapshot>, FluidTankData, ImmutableFluidTankData> {

    /**
     * Gets the {@link MapValue} of the various {@link FluidStackSnapshot}s
     * available from the owner. Note that a fluid tank may have multiple
     * {@link FluidStack}s differing based on {@link Direction}.
     *
     * @return The map value of direction to list of fluid snapshots
     * @see Keys#FLUID_TANK_CONTENTS
     */
    MapValue<Direction, List<FluidStackSnapshot>> fluids();

    /**
     * Gets the {@link List} of {@link FluidStackSnapshot}s at a defined
     * {@link Direction}.
     *
     * @param direction The direction
     * @return The list of fluid stack snapshots, if available
     */
    default Optional<List<FluidStackSnapshot>> fluidAtDirection(Direction direction) {
        MapValue<Direction, List<FluidStackSnapshot>> fluids = fluids();
        if (fluids.containsKey(checkNotNull(direction, "Direction was null!"))) {
            return Optional.of(new ArrayList<>(fluids.get().get(direction)));
        }
        return Optional.empty();
    }

}
