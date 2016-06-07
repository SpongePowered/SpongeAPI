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
package org.spongepowered.api.world.gen.type;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.gen.PopulatorObject;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents the various types of trees which may be spawned into the world.
 */
@CatalogedBy(BiomeTreeTypes.class)
public interface BiomeTreeType extends CatalogType {

    /**
     * Gets the {@link PopulatorObject} which is used to generate this tree into
     * the world.
     * 
     * @return The populator object
     */
    PopulatorObject getPopulatorObject();

    /**
     * Sets the {@link PopulatorObject} which is used to generate this tree into
     * the world.
     * 
     * @param object The new populator object
     */
    void setPopulatorObject(PopulatorObject object);

    /**
     * Gets whether this tree type has a larger equivalent.
     * 
     * @return Has large equivalent
     */
    boolean hasLargeEquivalent();

    /**
     * Gets the {@link PopulatorObject} which is used to generate the larger
     * equivalent of this tree into the world.
     * 
     * @return The populator object
     */
    Optional<PopulatorObject> getLargePopulatorObject();

    /**
     * Sets the {@link PopulatorObject} which is used to generate the larger
     * equivalent of this tree into the world.
     * 
     * @param object The new populator object
     */
    void setLargePopulatorObject(@Nullable PopulatorObject object);

}
