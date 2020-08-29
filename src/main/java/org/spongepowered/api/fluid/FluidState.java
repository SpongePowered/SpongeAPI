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
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.SerializableDataHolderBuilder;
import org.spongepowered.api.state.State;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.schematic.Schematic;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Represents a particular "state" that can exist at a {@link ServerLocation} with
 * a particular {@link BlockType} and various {@link org.spongepowered.api.data.value.Value.Immutable}s defining
 * the information for the "block". Note that normally, there may exist only
 * a single instance of a particular {@link FluidState} as they are immutable,
 * a particular instance may be cached for various uses.
 */
public interface FluidState extends State<FluidState> {

    /**
     * Creates a new {@link Builder} for building {@link FluidState}s.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    static FluidState fromString(final String id) {
        Objects.requireNonNull(id);
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(FluidState.Builder.class).fromString(id).build();
    }

    /**
     * Gets the {@link BlockState} that best represents this {@link FluidState}.
     *
     * <p>The type does not include location based information such as tanks
     * or inventories. This is simply a block state that can be used for volumes
     * such as {@link Schematic}s or {@link World}s that are serialized and
     * deserialized.</p>
     *
     * @return The type of block
     */
    BlockState getBlock();

    /**
     * Gets the parent {@link FluidType} that this state is based on. Much
     * like {@link BlockType} versus {@link BlockState}s, there can be
     * many to one relationships between the two.
     *
     * @return The fluid type
     */
    FluidType getType();

    boolean isEmpty();

    /**
     * An {@link org.spongepowered.api.data.DataHolderBuilder.Immutable} for a {@link FluidState}. Just like the
     * {@link org.spongepowered.api.data.DataHolderBuilder.Immutable}, the {@link DataManipulator}s passed in to
     * create a {@link FluidState} are copied on creation.
     *
     * <p>Note that upon creation, the {@link FluidType} must be set for validation
     * of {@link DataManipulator}s, otherwise exceptions may be thrown.</p>
     */
    interface Builder extends State.Builder<FluidState, Builder> {

        /**
         * Sets the {@link FluidType} for the {@link FluidState} to build.
         *
         * @param fluidType The fluid type
         * @return This builder, for chaining
         */
        default Builder fluid(Supplier<? extends FluidType> fluidType) {
            return this.fluid(fluidType.get());
        }

        /**
         * Sets the {@link FluidType} for the {@link FluidState} to build.
         *
         * @param fluidType The fluid type
         * @return This builder, for chaining
         */
        Builder fluid(FluidType fluidType);
    }

}
