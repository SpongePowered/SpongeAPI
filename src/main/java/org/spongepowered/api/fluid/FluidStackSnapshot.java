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

public interface FluidStackSnapshot extends SerializableDataHolder.Immutable<FluidStackSnapshot> {

    /**
     * Creates a new {@link Builder} to build a new {@link FluidStackSnapshot}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link FluidType} of this snapshot.
     *
     * @return The fluid type
     */
    FluidType getFluid();

    /**
     * Gets the volume of this snapshot.
     *
     * <p>Note that the volume is measured in "milli buckets", otherwise read
     * as {@code mB}. The scaling is as follows: 1 bucket = 1000mB, whereas 1
     * block usually equals 1000mB.</p>
     *
     * @return The volume
     */
    int getVolume();

    /**
     * Creates a new {@link FluidStack} based on this snapshot.
     *
     * @return The newly created stack
     */
    FluidStack createStack();

    interface Builder extends SerializableDataHolderBuilder.Immutable<FluidStackSnapshot, Builder> {

        Builder fluid(FluidType fluidType);

        Builder volume(int volume);

        /**
         * Resets this builder and accepts all data from the incoming {@link FluidStack}.
         *
         * @param fluidStack The fluid stack to accept
         * @return This builder, for chaining
         */
        Builder from(FluidStack fluidStack);

    }

}
