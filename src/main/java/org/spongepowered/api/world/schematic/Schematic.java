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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.volume.archetype.ArchetypeVolume;
import org.spongepowered.api.world.volume.archetype.ArchetypeVolumeCreator;
import org.spongepowered.api.world.volume.archetype.entity.EntityArchetypeEntry;
import org.spongepowered.api.world.volume.archetype.entity.EntityArchetypeVolume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.block.entity.BlockEntityVolume;
import org.spongepowered.api.world.volume.game.LocationBaseDataHolder;
import org.spongepowered.math.vector.Vector3d;

import java.util.Collection;

/**
 * A special archetype volume designed to be persisted. Contains additional
 * metadata to assist with this persistence.
 */
public interface Schematic extends ArchetypeVolume, LocationBaseDataHolder.Mutable {

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
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Gets the {@link Palette} used by this schematic for serialization.
     *
     * @return The block palette
     */
    Palette<BlockState, BlockType> blockPalette();

    /**
     * Gets the {@link Palette Palette&lt;BiomeType&gt;} used by this schematic for serialization.
     *
     * @return The biome palette used for this schematic
     */
    Palette<Biome, Biome> biomePalette();

    /**
     * Gets any additional metadata attached to this schematic.
     * 
     * @return The additional metadata
     */
    DataView metadata();

    /**
     * A builder for {@link Schematic}s.
     */
    interface Builder extends org.spongepowered.api.util.Builder<Schematic, Builder>, CopyableBuilder<Schematic, Builder> {

        /**
         * Specifies an archetype volume for the world data of the schematic.
         * This is to take part of the schematic, so it should not be referenced
         * outside of the schematic, less modifications are going to be made
         * also affecting {@link #blockEntities(BlockEntityVolume) the block
         * entity volume}.
         *
         *
         * @param volume The archetype volume
         * @return This builder, for chaining
         */
        Builder blocks(BlockVolume volume);

        Builder blockEntities(BlockEntityVolume volume);

        Builder entities(EntityArchetypeVolume volume);

        /**
         * Specifies an extent view for the schematic to load its world data
         * from.
         *
         * @param volume The extent view
         * @return This builder, for chaining
         */
        Builder creator(ArchetypeVolumeCreator volume);

        Builder volume(ArchetypeVolume volume);

        /**
         * Specifies a palette for the schematic to use for serialization. This
         * overrides the {@link #blockPaletteType(PaletteType)} value.
         *
         * @param palette The palette to use for serialization
         * @return This builder, for chaining
         */
        Builder blockPalette(Palette<BlockState, BlockType> palette);

        /**
         * Specifies a palette for the schemtic to use for serialization. This
         * overrides the {@link #biomePaletteType(PaletteType)} value.
         *
         * @param palette The palette to use for serialization
         * @return This builder, for chaining
         */
        Builder biomePalette(Palette<Biome, Biome> palette);

        /**
         * Specifies the palette type to use if the {@link #blockPalette()} is not
         * specified.
         *
         * @param type The palette type
         * @return This builder, for chaining
         */
        Builder blockPaletteType(PaletteType<BlockState, BlockType> type);

        /**
         * Specifies the palette type to use for biomes if the {@link #biomePalette(Palette)}
         * is not specified.
         *
         * @param type The type of biome palette
         * @return This builder, for chaining
         */
        Builder biomePaletteType(PaletteType<Biome, Biome> type);

        Builder entity(EntityArchetype entityArchetype);

        Builder entity(EntityArchetype entityArchetype, Vector3d position);

        Builder entity(EntityArchetypeEntry entry);

        Builder entities(Collection<EntityArchetypeEntry> entities);

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
        @Override
        Schematic build() throws IllegalArgumentException;

    }
}
