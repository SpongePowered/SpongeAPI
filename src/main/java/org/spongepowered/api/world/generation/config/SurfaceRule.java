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

import org.spongepowered.api.Sponge;

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
     * @param abovePreliminarySurface
     * @param bedrockRoof whether to place a bedrock roof
     * @param bedrockFloor whether to place a bedrock floor
     *
     * @return the custom surface rules
     */
    static SurfaceRule overworldLike(boolean abovePreliminarySurface, boolean bedrockRoof, boolean bedrockFloor) {
        return Sponge.game().factoryProvider().provide(SurfaceRule.Factory.class).overworldLike(abovePreliminarySurface, bedrockRoof, bedrockFloor);
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

    // TODO Builder for custom surface rules
    // TODO expose vanilla provided rules for building more complex rules

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
         * @param abovePreliminarySurface
         * @param bedrockRoof whether to place a bedrock roof
         * @param bedrockFloor whether to place a bedrock floor
         *
         * @return the custom surface rules
         */
        SurfaceRule overworldLike(boolean abovePreliminarySurface, boolean bedrockRoof, boolean bedrockFloor);

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
    }
}
