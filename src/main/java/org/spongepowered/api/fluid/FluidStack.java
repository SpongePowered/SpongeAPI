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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.api.data.SerializableDataHolderBuilder;
import org.spongepowered.api.item.ItemTypes;

/**
 * Represents a stack of a particular {@link FluidType} and
 * volume measured in "milliBuckets" where <code>1000</code>mB is equal to
 * 1 {@link ItemTypes#BUCKET}.
 */
public interface FluidStack extends SerializableDataHolder.Mutable {

    /**
     * Creates a new {@link Builder} to make fluid stacks.
     *
     * @return The newly created builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link FluidType} for this fluid stack.
     *
     * @return The fluid type of this stack
     */
    FluidType getFluid();

    /**
     * Gets the "volume" of this {@link FluidStack}.
     *
     * <p>Note that the volume is measured in "milli buckets", otherwise read
     * as {@code mB}. The scaling is as follows: 1 bucket = 1000mB, whereas 1
     * block usually equals 1000mB.</p>
     *
     * @return The volume in milli buckets
     */
    int getVolume();

    /**
     * Sets the desired volume for this stack.
     *
     * <p>Note that the volume is measured in "milli buckets", otherwise read
     * as {@code mB}. The scaling is as follows: 1 bucket = 1000mB, whereas 1
     * block usually equals 1000mB.</p>
     *
     * @param volume The volume to set
     * @return This fluid stack
     */
    FluidStack setVolume(int volume);

    /**
     * Creates a snapshot of this {@link FluidStack}.
     *
     * @return The fluid stack snapshot
     */
    FluidStackSnapshot createSnapshot();

    @Override
    FluidStack copy();

    interface Builder extends SerializableDataHolderBuilder.Mutable<FluidStack, Builder> {

        /**
         * Sets the {@link FluidType} to use to build the {@link FluidStack}.
         *
         * @param fluidType The fluid type
         * @return This builder, for chaining
         */
        Builder fluid(FluidType fluidType);

        /**
         * Sets the desired volume of the {@link FluidStack}.
         *
         * <p>Note that the volume is measured in "milli buckets", otherwise
         * read as {@code mB}. The scaling is as follows: 1 bucket = 1000mB,
         * whereas 1 block usually equals 1000mB.</p>
         *
         * @param volume The volume
         * @return This builder, for chaining
         */
        Builder volume(int volume);

        /**
         * Builds a new {@link FluidStack} based on the desired volume and
         * {@link FluidType}. If either are not set (invalid), an
         * {@link IllegalStateException} may be thrown.
         *
         * @return The newly created fluid stack
         */
        @Override
        FluidStack build();

        /**
         * Resets and fills this builder with all the information from the
         * provided {@link FluidStackSnapshot}.
         *
         * @param fluidStackSnapshot The fluid stack snapshot to copy data from
         * @return This builder, for chaining
         */
        Builder from(FluidStackSnapshot fluidStackSnapshot);
    }

}
