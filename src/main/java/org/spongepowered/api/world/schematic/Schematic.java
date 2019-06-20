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

import com.flowpowered.math.vector.Vector3d;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ListMultimap;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.extent.ArchetypeVolume;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.extent.MutableBiomeVolume;
import org.spongepowered.api.world.extent.worker.MutableBlockVolumeWorker;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * A special archetype volume designed to be persisted. Contains additional
 * metadata to assist with this persistence.
 */
public interface Schematic extends ArchetypeVolume {

    String METADATA_NAME = "Name";
    String METADATA_AUTHOR = "Author";
    String METADATA_DATE = "Date";
    String METADATA_REQUIRED_MODS = "RequiredMods";

    /**
     * Gets a new builder for schematics.
     * 
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link BlockPalette} used by this schematic for serialization.
     * 
     * @return The palette
     */
    @Deprecated
    BlockPalette getPalette();

    /**
     * Gets the {@link BlockPalette} used by this schematic for serialization.
     *
     * @return The block palette
     */
    @SuppressWarnings("deprecation")
    default Palette<BlockState> getBlockPalette() {
        return getPalette();
    }

    /**
     * Gets the {@link Palette Palette<BiomeType>} used by this schematic for serialization.
     *
     * @return The biome palette used for this schematic
     */
    default Palette<BiomeType> getBiomePalette() {
        return PaletteTypes.GLOBAL_BIOMES.create();
    }

    /**
     * Gets any additional metadata attached to this schematic.
     * 
     * @return The additional metadata
     */
    DataView getMetadata();

    @Override
    MutableBlockVolumeWorker<Schematic> getBlockWorker();

    /**
     * Gets the {@link MutableBiomeVolume} of this schematic. As biomes are
     * {@link Optional optionally} included and not required, they may be
     * optionally excluded. If the schematic would contain them, they will be
     * present during deserialization via {@link DataTranslator}.
     *
     * @return The biomes volume, if they're included
     */
    default Optional<MutableBiomeVolume> getBiomes() {
        return Optional.empty();
    }

    @Override
    default ListMultimap<Vector3d, EntityArchetype> getEntitiesByPosition() {
        return ImmutableListMultimap.of();
    }

    @Override
    default Collection<EntityArchetype> getEntityArchetypes() {
        return Collections.emptyList();
    }


    /**
     * A builder for {@link Schematic}s.
     */
    interface Builder extends ResettableBuilder<Schematic, Builder> {

        /**
         * Specifies an archetype volume for the world data of the schematic.
         * 
         * <p>If purely creating a schematic it is recommended to instead use
         * the {@link #volume(Extent)} method and pass in an extent view (See
         * {@link Extent#getExtentView}) of the volume to prevent creating
         * multiple copies of the world data. Likewise, if {@link BiomeType}s
         * are needed to be copied, only {@link #volume(Extent)} will support
         * copying the {@link BiomeType}s at the desired positions. This also
         * has the same limit for capturing {@link EntityArchetype}s, unless
         * otherwise manually placed in with {@link #entity(EntityArchetype)}.
         * </p>
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
         * @deprecated Use {@link #blockPalette(Palette)}
         */
        @Deprecated
        Builder palette(BlockPalette palette);

        /**
         * Specifies a palette for the schematic to use for serialization. This
         * overrides the {@link #paletteType} value.
         *
         * @param palette The palette to use for serialization
         * @return This builder, for chaining
         */
        @SuppressWarnings("deprecation")
        default Builder blockPalette(Palette<BlockState> palette) {
            return palette((BlockPalette) palette);
        }

        /**
         * Specifies a palette for the schemtic to use for serialization.
         *
         * @param palette The palette to use for serialization
         * @return This builder, for chaining
         */
        default Builder biomePalette(Palette<BiomeType> palette) {
            return this;
        }

        /**
         * Specifies the palette type to use if the {@link #palette} is not
         * specified.
         * 
         * @param type The palette type
         * @return This builder, for chaining
         * @deprecated Use {@link #blockPaletteType(PaletteType)}
         */
        @Deprecated
        Builder paletteType(BlockPaletteType type);

        /**
         * Specifies the palette type to use if the {@link #palette} is not
         * specified.
         *
         * @param type The palette type
         * @return This builder, for chaining
         */
        @SuppressWarnings("deprecation")
        default Builder blockPaletteType(PaletteType<BlockState> type) {
            return paletteType((BlockPaletteType) type);
        }

        /**
         * Specifies the palette type to use for biomes if the {@link #biomePalette(Palette)}
         * is not specified.
         *
         * @param type The type of biome palette
         * @return This builder, for chaining
         */
        default Builder biomePaletteType(PaletteType<BiomeType> type) {
            return this;
        }

        default Builder entity(EntityArchetype entityArchetype) {
            if (!entityArchetype.getEntityData().contains(Queries.POSITION_X, Queries.POSITION_Y, Queries.POSITION_Z)) {
                throw new IllegalArgumentException("EntityArchetype is missing position information!");
            }
            return this;
        }

        default Builder entity(EntityArchetype entityArchetype, Vector3d position) {
            return this;
        }

        default Builder entities(Collection<EntityArchetype> entities) {
            return this;
        }

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
