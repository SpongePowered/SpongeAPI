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
package org.spongepowered.api.world.generation.structure.jigsaw;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.generation.feature.PlacedFeature;
import org.spongepowered.api.world.generation.structure.SchematicTemplate;
import org.spongepowered.api.world.server.ServerLocation;

import java.util.List;
import java.util.function.Function;

/**
 * An element in a jigsaw pool.
 */
public interface JigsawPoolElement {

    static Factory factory() {
        return Sponge.game().factoryProvider().provide(Factory.class);
    }

    /**
     * Returns the projection used for placing.
     *
     * @return The projection used for placing
     */
    Projection projection();

    /**
     * Places the element at given location without structure blocks
     * and with water logging enabled
     *
     * @param location The location
     * @return true if the element was successfully placed
     */
    boolean place(ServerLocation location);

    /**
     * Places the element at given location with water logging enabled
     *
     * @param location The location
     * @param withStructureBlocks Whether to place the element with structure blocks
     *
     * @return true if the element was successfully placed
     */
    boolean place(ServerLocation location, boolean withStructureBlocks);

    /**
     * Places the element at given location.
     *
     * @param location The location
     * @param withStructureBlocks Whether to place the element with structure blocks
     * @param waterLogging Whether to apply water logging when placing the element in a liquid
     *
     * @return true if the element was successfully placed
     */
    boolean place(ServerLocation location, boolean withStructureBlocks, boolean waterLogging);

    /**
     * The projection for {@link JigsawPoolElement elements} in a {@link JigsawPool}.
     * <p>{@link Factory#matchingTerrain()} or {@link Factory#rigid()}</p>
     */
    interface Projection {

    }

    interface Factory {

        /**
         * Returns a function providing a legacy element.
         *
         * @param template The template key of a {@link SchematicTemplate}
         * @param processors The processor list
         * @return The function
         */
        Function<Projection, JigsawPoolElement> legacy(ResourceKey template, ProcessorList processors);

        /**
         * Returns a function providing a single element.
         *
         * @param template The template key of a {@link SchematicTemplate}
         * @param processors The processor list
         * @return The function
         */
        Function<Projection, JigsawPoolElement> single(ResourceKey template, ProcessorList processors);

        /**
         * Returns a function providing an element for a {@link PlacedFeature}.
         *
         * @param feature The placed feature
         * @return The function
         */
        Function<Projection, JigsawPoolElement> feature(PlacedFeature feature);

        /**
         * Returns a function providing a list of other elements.
         *
         * @param elements The list of functions providing the other elements
         * @return The function
         */
        Function<Projection, JigsawPoolElement> list(List<Function<Projection, JigsawPoolElement>> elements);

        /**
         * Returns a function providing an empty element.
         *
         * @return The function
         */
        Function<Projection, JigsawPoolElement> empty();

        /**
         * Returns a projection matching the terrain.
         *
         * @return The projection
         */
        Projection matchingTerrain();

        /**
         * Returns a rigid projection.
         *
         * @return The projection
         */
        Projection rigid();

    }
}
