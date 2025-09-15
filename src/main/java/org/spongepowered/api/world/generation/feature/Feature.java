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


import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.datapack.DataPackSerializable;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.Builder;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

/**
 * Features include smaller objects placed in the world like trees, flowers, ore etc.
 * <p>Features are used in world generation as a part of {@link PlacedFeature placed features}</p>
 */
@CatalogedBy(Features.class)
public interface Feature extends DefaultedRegistryValue<Feature>, DataPackSerializable {

    /**
     * Creates a new {@link Builder} to create a {@link Feature}.
     *
     * @return The new builder
     */
    static Feature.Builder builder() {
        return Sponge.game().builderProvider().provide(Feature.Builder.class);
    }

    /**
     * Returns the feature type.
     *
     * @return The feature type
     */
    FeatureType type();

    /**
     * Returns the serialized feature configuration.
     * <p>Reconfigure a feature using {@link FeatureType#configure(DataView)}</p>
     *
     * @return The serialized feature configuration
     */
    DataView toContainer();

    /**
     * Places the feature at given position and world
     *
     * @param world The world
     * @param pos The position
     *
     * @return true when the feature was successfully placed
     */
    boolean place(ServerWorld world, Vector3i pos);

    /**
     * Places the feature at given location
     *
     * @param location The location
     *
     * @return true when the feature was successfully placed
     */
    boolean place(ServerLocation location);

    /**
     * A builder to create {@link Feature}s.
     */
    interface Builder extends org.spongepowered.api.util.Builder<Feature, Builder>, CopyableBuilder<Feature, Builder> {

        /**
         * Sets the given {@link FeatureType}.
         *
         * @param type The feature type
         * @return The builder, for chaining
         */
        Builder type(FeatureType type);
    }
}
