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
package org.spongepowered.api.data.manipulator.immutable.block;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.block.WireAttachmentData;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.data.value.immutable.ImmutableMapValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.util.Direction;

/**
 * An {@link ImmutableDataManipulator} that handles the
 * {@link ImmutableMapValue} of {@link Direction} to {@link WireAttachmentType}
 * for a {@link BlockState}. Usually applicable to
 * {@link BlockTypes#REDSTONE_WIRE} and {@link BlockTypes#TRIPWIRE}.
 */
public interface ImmutableWireAttachmentData extends ImmutableDataManipulator<ImmutableWireAttachmentData, WireAttachmentData> {

    /**
     * Gets the current {@link ImmutableMapValue} for the available
     * {@link Direction}s and associated{@link WireAttachmentType}s.
     *
     * @return The immutable map value for the directions and their associated
     *     wire attachment types
     */
    ImmutableMapValue<Direction, WireAttachmentType> wireAttachments();

    /**
     * Gets the {@link ImmutableValue} for the {@link Direction#NORTH}'s
     * {@link WireAttachmentType}.
     *
     * @return The value for the northern wire attachment type
     */
    ImmutableValue<WireAttachmentType> wireAttachmentNorth();

    /**
     * Gets the {@link ImmutableValue} for the {@link Direction#SOUTH}'s
     * {@link WireAttachmentType}.
     *
     * @return The value for the southern wire attachment type
     */
    ImmutableValue<WireAttachmentType> wireAttachmentSouth();

    /**
     * Gets the {@link ImmutableValue} for the {@link Direction#EAST}'s
     * {@link WireAttachmentType}.
     *
     * @return The value for the eastern wire attachment type
     */
    ImmutableValue<WireAttachmentType> wireAttachmentEast();

    /**
     * Gets the {@link ImmutableValue} for the {@link Direction#WEST}'s
     * {@link WireAttachmentType}.
     *
     * @return The value for the western wire attachment type
     */
    ImmutableValue<WireAttachmentType> wireAttachmentWest();



}
