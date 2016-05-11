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
package org.spongepowered.api.world.schematic;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.extent.ArchetypeVolume;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.extent.worker.MutableBlockVolumeWorker;

/**
 * A special archetype volume designed to be persisted. Contains additional
 * metadata to assist with this persistence.
 */
public interface Schematic extends ArchetypeVolume {

    public static final String METADATA_NAME = "Name";
    public static final String METADATA_AUTHOR = "Author";
    public static final String METADATA_DATE = "Date";
    public static final String METADATA_REQUIRED_MODS = "RequiredMods";

    /**
     * Gets a new builder for schematics.
     * 
     * @return The new builder
     */
    public static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link Palette} used by this schematic for serialization.
     * 
     * @return The palette
     */
    Palette getPalette();

    /**
     * Gets any additional metadata attached to this schematic.
     * 
     * @return The additional metadata
     */
    DataView getMetadata();

    @Override
    MutableBlockVolumeWorker<Schematic> getBlockWorker();

    /**
     * A builder for {@link Schematic}s.
     */
    public static interface Builder extends ResettableBuilder<Schematic, Builder> {

        /**
         * Specifies an archetype volume for the world data of the schematic.
         * 
         * <p>If purely creating a schematic it is recommended to instead use
         * the {@link #volume(Extent)} method and pass in an extent view (See
         * {@link Extent#getExtentView}) of the area to prevent creating
         * multiple copies of the world data.</p>
         * 
         * @param volume The archetype volume
         * @return This builder, for chaining
         */
        Builder volume(ArchetypeVolume volume);

        /**
         * Specifies an extent view for the schematic to load its world data
         * from.
         * 
         * @param volume The extent view
         * @return This builder, for chaining
         */
        Builder volume(Extent volume);

        /**
         * Specifies a palette for the schematic to use for serialization. This
         * overrides the {@link #paletteType} value.
         * 
         * @param palette The palette to use for serialization
         * @return This builder, for chaining
         */
        Builder palette(Palette palette);

        /**
         * Specifies the palette type to use if the {@link #palette} is not
         * specified.
         * 
         * @param type The palette type
         * @return This builder, for chaining
         */
        Builder paletteType(PaletteType type);

        /**
         * Specifies the origin of the schematic's area relative to the minimum
         * point of the passed in volume.
         * 
         * @param origin The origin
         * @return This builder, for chaining
         */
        Builder origin(Vector3i origin);

        /**
         * Specifies whether this schematic should store entity data.
         * 
         * @param state If entities should be stored
         * @return This builder, for chaining
         */
        Builder storeEntities(boolean state);

        /**
         * Specifies the metadata container.
         * 
         * @param metadata The metadata container
         * @return This builder, for chaining
         */
        Builder metadata(DataView metadata);

        /**
         * Specifies a metadata value which will be included in the metadata of
         * the schematic.
         * 
         * @param key The metadata key
         * @param value The value
         * @return This builder, for chaining
         */
        Builder metaValue(String key, Object value);

        /**
         * Constructs a new {@link Schematic} from this builder.
         *
         * @return The new schematic
         * @throws IllegalArgumentException If any required data was not
         *         specified
         */
        Schematic build() throws IllegalArgumentException;

    }
}
