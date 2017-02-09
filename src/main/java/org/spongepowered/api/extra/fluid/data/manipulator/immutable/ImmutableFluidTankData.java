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
package org.spongepowered.api.extra.fluid.data.manipulator.immutable;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.extra.fluid.FluidStack;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
import org.spongepowered.api.extra.fluid.data.manipulator.mutable.FluidTankData;
import org.spongepowered.api.util.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ImmutableFluidTankData extends ImmutableMappedData<Direction, List<FluidStackSnapshot>, ImmutableFluidTankData, FluidTankData> {

    /**
     * Gets the {@link MapValue} of the various {@link FluidStackSnapshot}s
     * available from the owner. Note that a fluid tank may have multiple
     * {@link FluidStack}s differing based on {@link Direction}.
     *
     * @return The map value of direction to list of fluid snapshots
     */
    ImmutableMapValue<Direction, List<FluidStackSnapshot>> fluids();

    /**
     * Gets the {@link List} of {@link FluidStackSnapshot}s at a defined
     * {@link Direction}.
     *
     * @param direction The direction
     * @return The list of fluid stack snapshots, if available
     */
    default Optional<List<FluidStackSnapshot>> fluidAtDirection(Direction direction) {
        ImmutableMapValue<Direction, List<FluidStackSnapshot>> fluids = fluids();
        if (fluids.containsKey(checkNotNull(direction, "Direction was null!"))) {
            return Optional.of(new ArrayList<>(fluids.get().get(direction)));
        }
        return Optional.empty();
    }
}
