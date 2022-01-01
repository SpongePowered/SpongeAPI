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
package org.spongepowered.api.world.generation.config.noise;

import org.spongepowered.api.Sponge;

/**
 * Shapes the terrain generation.
 */
public interface Shaper {

    /**
     * Returns the vanilla overworld terrain shaper.
     *
     * @return the vanilla overworld terrain shaper.
     */
    static Shaper overworld() {
        return Sponge.game().factoryProvider().provide(Shaper.Factory.class).overworld(false);
    }

    /**
     * Returns the vanilla amplified overworld terrain shaper.
     *
     * @return the vanilla amplified overworld terrain shaper.
     */
    static Shaper amplified() {
        return Sponge.game().factoryProvider().provide(Shaper.Factory.class).overworld(true);
    }

    /**
     * Returns the vanilla cave overworld terrain shaper.
     *
     * @return the vanilla cave overworld terrain shaper.
     */
    static Shaper caves() {
        return Sponge.game().factoryProvider().provide(Shaper.Factory.class).caves();
    }

    /**
     * Returns the vanilla floating islands overworld terrain shaper.
     *
     * @return the vanilla floating islands overworld terrain shaper.
     */
    static Shaper floatingIslands() {
        return Sponge.game().factoryProvider().provide(Shaper.Factory.class).floatingIslands();
    }

    /**
     * Returns the vanilla nether terrain shaper.
     *
     * @return the vanilla nether terrain shaper.
     */
    static Shaper nether() {
        return Sponge.game().factoryProvider().provide(Shaper.Factory.class).nether();
    }

    /**
     * Returns the vanilla end terrain shaper.
     *
     * @return the vanilla end terrain shaper.
     */
    static Shaper end() {
        return Sponge.game().factoryProvider().provide(Shaper.Factory.class).end();
    }

    // TODO expose building Shaper in API using CubicSplines

    interface Factory {

        /**
         * Returns the vanilla overworld terrain shaper.
         *
         * @param amplified whether the shape amplified terrain
         *
         * @return the vanilla overworld terrain shaper.
         */
        Shaper overworld(boolean amplified);

        /**
         * Returns the vanilla cave overworld terrain shaper.
         *
         * @return the vanilla cave overworld terrain shaper.
         */
        Shaper caves();

        /**
         * Returns the vanilla floating islands overworld terrain shaper.
         *
         * @return the vanilla floating islands overworld terrain shaper.
         */
        Shaper floatingIslands();

        /**
         * Returns the vanilla nether terrain shaper.
         *
         * @return the vanilla nether terrain shaper.
         */
        Shaper nether();

        /**
         * Returns the vanilla end terrain shaper.
         *
         * @return the vanilla end terrain shaper.
         */
        Shaper end();
    }
}
