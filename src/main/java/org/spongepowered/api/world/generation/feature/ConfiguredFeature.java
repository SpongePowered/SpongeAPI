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
package org.spongepowered.api.world.generation.feature;


import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

/**
 * Configured Features include smaller objects placed in the world like trees, flowers, ore etc.
 * <p>configured features are used in world generation as a part of {@link PlacedFeature}s</p>
 * <p>Serialized into a data pack at {@code data/<namespace>/worldgen/configured_feature/<value>.json}</p>
 */
@CatalogedBy(ConfiguredFeatures.class)
public interface ConfiguredFeature<F extends Feature<FC>, FC extends FeatureConfig> extends DefaultedRegistryValue {

    F feature();

    FC config();

    boolean place(ServerWorld world, Vector3i pos);

}
