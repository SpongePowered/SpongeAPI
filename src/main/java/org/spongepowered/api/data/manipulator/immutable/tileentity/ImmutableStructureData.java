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
package org.spongepowered.api.data.manipulator.immutable.tileentity;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.tileentity.Structure;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.tileentity.StructureData;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.value.Value;

/**
 * An {@link ImmutableDataManipulator} representing the {@link Structure}.
 */
public interface ImmutableStructureData extends ImmutableDataManipulator<ImmutableStructureData, StructureData> {

    /**
     * Gets the {@link Value.Immutable} for the author of the {@link Structure}.
     *
     * @return The value for the author
     */
    Value.Immutable.Single<String> author();

    /**
     * Gets the {@link Value.Immutable} for the ignore entities state of the {@link Structure}.
     *
     * @return The value for the ignore entities state
     */
    Value.Immutable.Single<Boolean> ignoreEntities();

    /**
     * Gets the {@link Value.Immutable} for the integrity of the {@link Structure}.
     *
     * @return The value for the integrity
     */
    Value.Immutable.Single<Float> integrity();

    /**
     * Gets the {@link Value.Immutable} for the mode of the {@link Structure}.
     *
     * @return The value for the mode
     */
    Value.Immutable.Single<StructureMode> mode();

    /**
     * Gets the {@link Value.Immutable} for the position of the {@link Structure}.
     *
     * @return The value for the position
     */
    Value.Immutable.Single<Vector3i> position();

    /**
     * Gets the {@link Value.Immutable} for the powered state of the {@link Structure}.
     *
     * @return The value for the powered state
     */
    Value.Immutable.Single<Boolean> powered();

    /**
     * Gets the {@link Value.Immutable} for the seed of the {@link Structure}.
     *
     * @return The value for the seed
     */
    Value.Immutable.Single<Long> seed();

    /**
     * Gets the {@link Value.Immutable} for the show air state of the {@link Structure}.
     *
     * @return The value for the show air state
     */
    Value.Immutable.Single<Boolean> showAir();

    /**
     * Gets the {@link Value.Immutable} for the show bounding box state of the {@link Structure}.
     *
     * @return The value for the show bounding box state
     */
    Value.Immutable.Single<Boolean> showBoundingBox();

    /**
     * Gets the {@link Value.Immutable} for the size of the {@link Structure}.
     *
     * @return The value for the size
     */
    Value.Immutable.Single<Vector3i> size();

}
