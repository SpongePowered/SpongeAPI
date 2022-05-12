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
package org.spongepowered.api.world.generation.biome;

import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.datapack.DataPackSerializable;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.EntityCategory;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.util.weighted.WeightedTable;
import org.spongepowered.api.world.generation.feature.PlacedFeature;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * A template for {@link org.spongepowered.api.world.biome.Biome}s
 * <p>Serialized into a data pack at {@code data/<namespace>/worldgen/biome/<value>.json}</p>
 */
public interface BiomeTemplate extends DataPackSerializable {

    // TODO Enum Biome.Precipitation
    interface Precipitation {

    }
    // TODO Enum Biome.BiomeCategory
    interface BiomeCategory {

    }

    // TODO Enum Biome.TemperatureModifier
    interface TemperatureModifier {

    }

    Precipitation precipitation();
    BiomeCategory category();
    float temperature(); // grass/foliage color - snow golem damage
    TemperatureModifier temperatureModifier();
    float downfall(); // grass/foliage color - >0.85 fire burnout faster
    Effects effects();
    Generation generation();
    MobSpawnSettings spawning();

    interface Effects {
        int fogColor();
        int waterColor();
        int waterFogColor();
        int skyColor();

        // Tree leaves, Vines
        Optional<Integer> foliageColor(); // if empty depends on humidity/temperature
        // Grass Blocks, Grass, Tall Grass, Ferns, Tall Ferns, Sugar Cane
        Optional<Integer> grassColor(); // if empty depends on humidity/temperature

        // TODO Enum BiomeSpecialEffects.GrassColorModifier
        interface GrassColorModifier {

        }

        GrassColorModifier grassColorModifier();
        Optional<AmbientParticleSettings> ambientParticle();
        Optional<SoundType> ambientSound();
        Optional<AmbientMoodSettings> ambientMood();
        Optional<AdditionsSound> additionsSound();
        Optional<BackgroundMusic> backgroundMusic();

        interface AmbientParticleSettings {
            float probability();
            ParticleOptions particleOptions(); // TODO check if API type is usable for this - net.minecraft.core.particles.ParticleOptions
        }

        interface AmbientMoodSettings {
            SoundType sound();
            int tickDelay();
            int blockSearchExtent(); // cubic range
            double offset();
        }

        interface AdditionsSound {
            SoundType sound();
            double tickChance();
        }

        interface BackgroundMusic {
            SoundType sound();
            int minDelay();
            int maxDelay();
            boolean replaceCurrentMusic();
        }


    }

    interface Generation {

        // TODO enum GenerationStep.Carving
        interface CarvingStep {

        }

        // TODO enum GenerationStep.Decoration
        interface DecorationStep {

        }

        // TODO ordered set?
        Map<CarvingStep, Set<ConfiguredCarver>> carvers();

        Map<DecorationStep, List<PlacedFeature>> features();
    }


    interface MobSpawnSettings {
        float creatureSpawnProbability();
        Map<EntityCategory, WeightedTable<Data>> spawners();
        Map<EntityType<?>, Cost> cost(); // alternative to mob-cap

        interface Data {
            EntityType<?> type();
            int min();
            int max();
        }

        interface Cost {
            double budget();
            double charge();
        }
    }


    // TODO see Vanilla Biome.BiomeBuilder
    interface Builder {

        // Biome.CODEC
        BiomeTemplate buildFromPack(DataView pack) throws IOException;
    }

}
