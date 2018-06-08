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
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.block.DecayableData;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.Value;

/**
 * An {@link ImmutableDataManipulator} for the "decayable" state of a
 * {@link BlockState}. Usually applicable for {@link BlockTypes#OAK_LEAVES}.
 */
public interface ImmutableDecayableData extends ImmutableDataManipulator<ImmutableDecayableData, DecayableData> {

    /**
     * Gets the {@link BoundedValue.Immutable} for the distance at which
     * the {@link BlockState} can start to decay.
     *
     * @return The immutable value for the decay distance
     * @see Keys#DECAY_DISTANCE
     */
    BoundedValue.Immutable<Value.Immutable> distance();

    /**
     * Gets the {@link Value} for whether the {@link BlockState} state is
     * persistent and will be prevented from decaying.
     *
     * @return The immutable value for the persistent state
     * @see Keys#PERSISTENT
     */
    Value.Immutable<Boolean> persistent();
}
