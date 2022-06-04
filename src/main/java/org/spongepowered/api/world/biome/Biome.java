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
package org.spongepowered.api.world.biome;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.EntityCategories;
import org.spongepowered.api.entity.EntityCategory;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.golem.SnowGolem;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.util.weighted.WeightedTable;
import org.spongepowered.api.world.biome.ambient.AdditionalAmbientSound;
import org.spongepowered.api.world.biome.ambient.AmbientMoodSettings;
import org.spongepowered.api.world.biome.ambient.AmbientParticleSettings;
import org.spongepowered.api.world.biome.ambient.BackgroundMusic;
import org.spongepowered.api.world.biome.climate.GrassColorModifier;
import org.spongepowered.api.world.biome.climate.Precipitation;
import org.spongepowered.api.world.biome.climate.TemperatureModifier;
import org.spongepowered.api.world.biome.spawner.NaturalSpawnCost;
import org.spongepowered.api.world.biome.spawner.NaturalSpawner;
import org.spongepowered.api.world.generation.biome.BiomeTemplate;
import org.spongepowered.api.world.generation.biome.CarvingStep;
import org.spongepowered.api.world.generation.biome.ConfiguredCarver;
import org.spongepowered.api.world.generation.biome.DecorationStep;
import org.spongepowered.api.world.generation.feature.PlacedFeature;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Represents a biome.
 */
@CatalogedBy(Biomes.class)
public interface Biome extends DataHolder {

    // Biome Climate

    /**
     * Gets the temperature of this biome.
     * <p>May influence grass and foliage color
     * and {@link SnowGolem} temperature damage</p>
     *
     * @return The temperature
     */
    default double temperature() {
        return this.require(Keys.BIOME_TEMPERATURE);
    }

    /**
     * Gets the humidity of this biome.
     * <p>May influence grass and foliage color
     * and {@link org.spongepowered.api.block.BlockTypes#FIRE} blocks burning out faster.</p>
     *
     * @return The humidity
     */
    default double humidity() {
        return this.require(Keys.HUMIDITY);
    }

    /**
     * Gets the type of precipitation in this biome.
     *
     * @return The type of precipitation
     */
    default Precipitation precipitation() {
        return this.require(Keys.PRECIPITATION);
    }

    /**
     * Gets the temperature modifier.
     *
     * @return The temperature modifier
     */
    default TemperatureModifier temperatureModifier() {
        return this.require(Keys.TEMPERATURE_MODIFIER);
    }

    // Biome Generation

    /**
     * Gets the carvers used in world generation.
     * <p>For more details see {@link ConfiguredCarver}</p>
     *
     * @return The carvers
     */
    default Map<CarvingStep, List<ConfiguredCarver<?, ?>>> carvers() {
        return this.require(Keys.CARVERS);
    }

    /**
     * Gets the features used in world generation.
     * <p>For more details see {@link PlacedFeature}</p>
     *
     * @return The features
     */
    default Map<DecorationStep, List<PlacedFeature>> features() {
        return this.require(Keys.FEATURES);
    }

    // Natural Spawning

    /**
     * Gets spawn chance during world generation.
     * <p>The entity to spawn is picked randomly from {@link #spawners()} of type {@link EntityCategories#CREATURE}</p>
     *
     * @return The spawn chance
     */
    default double generationSpawnChance() {
        return this.require(Keys.SPAWN_CHANCE);
    }

    /**
     * Gets the weighted natural spawn settings for each entity category.
     *
     * @return The weighted natural spawners
     */
    default Map<EntityCategory, WeightedTable<NaturalSpawner>> spawners() {
        return this.require(Keys.NATURAL_SPAWNERS);
    }

    /**
     * Gets the spawn costs.
     * <p>Alternative to the mob-cap</p>
     *
     * @return The spawn costs
     */
    default Map<EntityType<?>, NaturalSpawnCost> cost() {
        return this.require(Keys.NATURAL_SPAWNER_COST);
    }

    // Effects

    /**
     * Gets the fog color.
     *
     * @return The fog color
     */
    default Color fogColor() {
        return this.require(Keys.FOG_COLOR);
    }

    /**
     * Gets the water color.
     *
     * @return The water color
     */
    default Color waterColor() {
        return this.require(Keys.WATER_COLOR);
    }

    /**
     * Gets the water fog color.
     *
     * @return The water fog color
     */
    default Color waterFogColor() {
        return this.require(Keys.WATER_FOG_COLOR);
    }

    /**
     * Gets the sky color.
     *
     * @return The sky color
     */
    default Color skyColor() {
        return this.require(Keys.SKY_COLOR);
    }

    /**
     * Gets the foliage color override.
     *
     * @return The foliage color override
     */
    default Optional<Color> foliageColor() {
        return this.get(Keys.FOLIAGE_COLOR);
    }

    /**
     * Gets the grass color override.
     *
     * @return The grass color override
     */
    default Optional<Color> grassColor() {
        return this.get(Keys.GRASS_COLOR);
    }

    /**
     * Gets the grass color modifier.
     *
     * @return The grass color modifier
     */
    default GrassColorModifier grassColorModifier() {
        return this.require(Keys.GRASS_COLOR_MODIFIER);
    }

    /**
     * Gets the ambient particle settings.
     *
     * @return The ambient particle settings
     */
    default Optional<AmbientParticleSettings> ambientParticle() {
        return this.get(Keys.AMBIENT_PARTICLE);
    }

    /**
     * Gets the ambient sound.
     *
     * @return The ambient sound
     */
    default Optional<SoundType> ambientSound() {
        return this.get(Keys.AMBIENT_SOUND);
    }

    /**
     * Gets the ambient mood settings.
     *
     * @return The ambient mood settings
     */
    default Optional<AmbientMoodSettings> ambientMood() {
        return this.get(Keys.AMBIENT_MOOD);
    }

    /**
     * Gets the additional ambient sound settings.
     *
     * @return The additional ambient sound settings
     */
    default Optional<AdditionalAmbientSound> additionalAmbientSound() {
        return this.get(Keys.AMBIENT_ADDITIONAL_SOUND);
    }

    /**
     * Gets the background music settings.
     *
     * @return The background music settings
     */
    default Optional<BackgroundMusic> backgroundMusic() {
        return this.get(Keys.BACKGROUND_MUSIC);
    }


    /**
     * Returns the template for this biome if registered via datapack.
     *
     * @return The template
     */
    Optional<BiomeTemplate> asTemplate();

}
