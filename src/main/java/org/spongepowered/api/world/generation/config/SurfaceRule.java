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
package org.spongepowered.api.world.generation.config;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.world.biome.Biome;

import java.util.List;

/**
 * SurfaceRules define how terrain surface is modified.
 */
public interface SurfaceRule {

    /**
     * Returns the surface rules for the vanilla overworld.
     *
     * @return the surface rules
     */
    static SurfaceRule overworld() {
        return Sponge.game().factoryProvider().provide(SurfaceRule.Factory.class).overworld();
    }

    /**
     * Returns the surface rules for a vanilla like overworld.
     *
     * @param nearSurface whether to only apply most surface rules to the surface of the world
     * @param bedrockRoof whether to place a bedrock roof
     * @param bedrockFloor whether to place a bedrock floor
     *
     * @return the custom surface rules
     */
    static SurfaceRule overworldLike(final boolean nearSurface, final boolean bedrockRoof, final boolean bedrockFloor) {
        return Sponge.game().factoryProvider().provide(SurfaceRule.Factory.class).overworldLike(nearSurface, bedrockRoof, bedrockFloor);
    }

    /**
     * Returns the surface rules for the vanilla nether.
     *
     * @return the surface rules.
     */
    static SurfaceRule nether() {
        return Sponge.game().factoryProvider().provide(SurfaceRule.Factory.class).nether();
    }

    /**
     * Returns the surface rules for the vanilla end.
     *
     * @return the surface rules.
     */
    static SurfaceRule end() {
        return Sponge.game().factoryProvider().provide(SurfaceRule.Factory.class).end();
    }

    /**
     * An anchor point for a vertical position used in some {@link SurfaceRule.Condition surface rule conditions}
     */
    interface VerticalAnchor {

    }

    /**
     * A condition for {@link SurfaceRule surface rules}
     */
    interface Condition {
        SurfaceRule then(SurfaceRule rule);

        Condition not();
    }

    interface Factory {

        /**
         * Returns the surface rules for the vanilla overworld.
         *
         * @return the surface rules
         */
        SurfaceRule overworld();

        /**
         * Returns the surface rules for a vanilla like overworld.
         *
         * @param nearSurface whether to only apply most surface rules to the surface of the world
         * @param bedrockRoof whether to place a bedrock roof
         * @param bedrockFloor whether to place a bedrock floor
         *
         * @return the custom surface rules
         */
        SurfaceRule overworldLike(boolean nearSurface, boolean bedrockRoof, boolean bedrockFloor);

        /**
         * Returns the surface rules for the vanilla nether.
         *
         * @return the surface rules.
         */
        SurfaceRule nether();

        /**
         * Returns the surface rules for the vanilla end.
         *
         * @return the surface rules.
         */
        SurfaceRule end();

        /**
         * Returns the surface rule for a list of surface rules of which only the first successful rule is applied.
         *
         * @param surfaceRules The surface rules
         * @return the surface rule
         */
        SurfaceRule firstOf(List<SurfaceRule> surfaceRules);

        /**
         * Returns the surface rule for a list of surface rules of which only the first successful rule is applied.
         *
         * @param surfaceRules The surface rules
         * @return the surface rule
         */
        SurfaceRule firstOf(SurfaceRule... surfaceRules);

        /**
         * Returns the badlands surface rule.
         *
         * @return The surface rule
         */
        SurfaceRule badlands();

        /**
         * Returns the surface rule for setting a {@link BlockState}.
         *
         * @param blockState The block state
         * @return the surface rule
         */
        SurfaceRule block(BlockState blockState);

        /**
         * Returns a conditional surface rule.
         *
         * @param conditions The conditions
         * @param rule The surface rule to conditionally apply
         * @return the surface rule
         */
        SurfaceRule test(List<Condition> conditions, SurfaceRule rule);

        /**
         * Returns a conditional surface rule.
         *
         * @param condition The condition
         * @param rule The surface rule to conditionally apply
         * @return the surface rule
         */
        SurfaceRule test(Condition condition, SurfaceRule rule);

        /**
         * Returns the inverted surface condition.
         *
         * @param condition The surface condition to invert
         * @return The inverted surface condition
         */
        Condition not(Condition condition);

        /**
         * Returns the surface condition to check for liquid depth
         *
         * @param offset The offset
         * @param depthMultiplier The depth multiplier
         * @return The surface condition
         */
        Condition liquidDepth(int offset, int depthMultiplier);

        /**
         * Returns the surface condition to check for liquid depth from the nearest surface.
         *
         * @param offset The offset
         * @param depthMultiplier The depth multiplier
         * @return The surface condition
         */
        Condition liquidDepthFromSurface(int offset, int depthMultiplier);

        /**
         * Returns the surface condition for biomes
         *
         * @param biomes The list of biomes
         *
         * @return The surface condition
         */
        Condition biome(List<RegistryReference<Biome>> biomes);

        /**
         * Returns the surface condition for blocks near to the surface of the world.
         *
         * @return The surface condition
         */
        Condition nearSurface();

        /**
         * Returns the surface condition for holes.
         * TODO surface depth <= 0?
         *
         * @return The surface condition
         */
        Condition hole();

        /**
         * Returns the surface condition to select blocks in a vertical gradient.
         *
         * @param randomSource The random source
         * @param fromY the lowest block
         * @param toY the highest block
         *
         * @return The surface condition
         */
        Condition verticalGradient(String randomSource, int fromY, int toY);

        /**
         * Returns the surface condition to select blocks in a vertical gradient.
         * @param randomSource The random source
         * @param fromY the lowest block
         * @param toY the highest block
         * @return The surface condition
         */
        Condition verticalGradient(String randomSource, VerticalAnchor fromY, VerticalAnchor toY);

        /**
         * Returns the surface condition for steep inclines.
         *
         * @return The surface condition
         */
        Condition steep();

        /**
         * Returns the surface condition to check for blocks on floor surfaces.
         *
         * @return The surface condition
         */
        Condition onFloor();

        /**
         * Returns the surface condition to check for blocks under floor surfaces.
         * @param depth The depth
         * @return The surface condition
         */
        Condition underFloor(int depth);

        /**
         * Returns the surface condition to check for blocks around floor surfaces.
         * @param offset The offset
         * @param useDepth Whether to use depth
         * @param secondaryDepth The secondary depth. 0 to disable.
         * @return The surface condition
         */
        Condition floor(int offset, boolean useDepth, int secondaryDepth);

        /**
         * Returns the surface condition to check for blocks on ceiling surfaces.
         *
         * @return The surface condition
         */
        Condition onCeiling();

        /**
         * Returns the surface condition to check for blocks under ceiling surfaces.
         *
         * @param depth The depth
         * @return The surface condition
         */
        Condition underCeiling(int depth);

        /**
         * Returns the surface condition to check for blocks around ceiling surfaces.
         *
         * @param offset The offset
         * @param useDepth Whether to use depth
         * @param secondaryDepth The secondary depth. 0 to disable.
         * @return The surface condition
         */
        Condition ceiling(int offset, boolean useDepth, int secondaryDepth);

        /**
         * Returns the surface condition to check for temperatures allowing snowfall.
         *
         * @return The surface condition
         */
        Condition snowyTemperature();

        /**
         * Returns the surface condition to check for blocks above a y coordinate
         *
         * @param anchor The lowest block position
         * @param depthMultiplier The multiplier to apply to the surface noise
         * @return The surface condition
         */
        Condition blockAbove(VerticalAnchor anchor, int depthMultiplier);

        /**
         * Returns the surface condition to check for surface blocks above a y coordinate
         *
         * @param anchor The lowest block position
         * @param depthMultiplier The multiplier to apply to the surface noise
         * @return The surface condition
         */
        Condition surfaceAbove(VerticalAnchor anchor, int depthMultiplier);

        /**
         * TODO NOISE_REGISTRY NormalNoise.NoiseParameters
         * @param noiseParam
         * @param min
         * @param max
         * @return
         */
        Condition noiseThreshold(ResourceKey noiseParam, double min, double max);

        /**
         * Returns an {@link VerticalAnchor} at given y position.
         *
         * @param y The y position
         * @return The anchor
         */
        VerticalAnchor absolute(int y);

        /**
         * Returns an {@link VerticalAnchor} at the top of the world.
         *
         * @return The anchor
         */
        VerticalAnchor top();

        /**
         * Returns an {@link VerticalAnchor} below the top of the world.
         *
         * @param blocks The amount of block below the top of the world
         * @return The anchor
         */
        VerticalAnchor belowTop(int blocks);

        /**
         * Returns an {@link VerticalAnchor} at the bottom of the world.
         *
         * @return The anchor
         */
        VerticalAnchor bottom();

        /**
         * Returns an {@link VerticalAnchor} above the bottom of the world.
         *
         * @param blocks The amount of block above the bottom of the world
         * @return The anchor
         */
        VerticalAnchor aboveBottom(int blocks);
    }
}
