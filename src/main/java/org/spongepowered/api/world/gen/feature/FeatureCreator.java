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
package org.spongepowered.api.world.gen.feature;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.ProtoWorld;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.GenerationRegion;
import org.spongepowered.api.world.gen.WorldGenerator;

import java.util.Random;

public interface FeatureCreator<C> {

    /**
     * Places what would be considered the "feature" centered at the origin
     * position in the provided {@link ProtoWorld}. The world is not guaranteed
     * to be an active {@link World}, as it can be a {@link GenerationRegion}
     * for chunk generation. The configuration object is used to determine
     * various feature options, potentially exposed by the feature itself.
     *
     * @param world The world region where the feature is to be placed
     * @param generator The generator
     * @param random The random number provider
     * @param origin The origin point of the feature
     * @param config The config object for configuring the feature to be placed
     * @return True
     */
    boolean place(ProtoWorld<?> world, WorldGenerator<?> generator, Random random, Vector3i origin, C config);

}
