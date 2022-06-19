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
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.util.weighted.WeightedTable;
import org.spongepowered.api.world.generation.feature.PlacedFeature;
import org.spongepowered.api.world.generation.structure.Structure;
import org.spongepowered.api.world.server.ServerLocation;

import java.util.List;
import java.util.function.Function;

/**
 * A pool to generate {@link Structure structures} using jigsaw blocks.
 */
@CatalogedBy(JigsawPools.class)
public interface JigsawPool extends DefaultedRegistryValue {

    /**
     * Returns the fallback pool, used when the selec
     * e.g. {@link JigsawPools#EMPTY}
     *
     * @return The fallback pool.
     */
    JigsawPool fallback();

    WeightedTable<Element> elements();

    interface Element {

        Projection projection();

        boolean place(ServerLocation location);

    }

    interface Projection {

    }

    static Factory factory() {
        return Sponge.game().factoryProvider().provide(Factory.class);
    }

    interface Factory {

        Function<Projection, Element> legacy(ResourceKey template, ProcessorList processors);

        Function<Projection, Element> single(ResourceKey template, ProcessorList processors);

        Function<Projection, Element> feature(PlacedFeature feature);

        Function<Projection, Element> list(List<Function<Projection, Element>> elements);

        Function<Projection, Element> empty();

        Projection matchingTerrain();
        Projection rigid();

    }
}
