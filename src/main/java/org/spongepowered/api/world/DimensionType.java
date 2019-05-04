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
package org.spongepowered.api.world;

import org.spongepowered.api.NamedCatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.NamedCatalogBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.storage.WorldProperties;

/**
 * Represents a type of {@link Dimension}.
 */
@CatalogedBy(DimensionTypes.class)
public interface DimensionType extends NamedCatalogType {

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Returns the {@link Dimension}'s class for this {@link DimensionType}.
     *
     * <p>This is used to determine how a {@link WorldProperties} loaded as a {@link World}
     * will be generated, simulated, and represented to game clients.</p>
     *
     * @return The dimension class
     */
    Class<? extends Dimension> getDimensionClass();

    /**
     * Gets the name of the directory that a {@link WorldProperties} once created by the
     * {@link WorldManager} will be found in.
     *
     * @return The directory name
     */
    String getDirectoryName();

    /**
     * Gets the default name that a {@link WorldProperties} created by the
     * {@link WorldManager} using this {@link DimensionType} will have.
     *
     * @return The default world name
     */
    @Override
    String getName();

    /**
     * Returns if this {@link DimensionType} has skylight.
     *
     * @return Whether it has skylight
     */
    boolean hasSkylight();

    interface Builder extends NamedCatalogBuilder<DimensionType, Builder>, CopyableBuilder<DimensionType, Builder> {

        default Builder dimension(DimensionType type) {
            this.dimension(type.getDimensionClass());
            return this;
        }

        Builder dimension(Class<? extends Dimension> dimension);

        Builder directory(String directoryName);

        Builder skylight(boolean skylight);
    }
}
