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
import org.spongepowered.api.util.CopyableBuilder;

/**
 * Noise Parameters for world generation.
 */
public interface NoiseConfig {

    /**
     * Returns the default vanilla overworld noise configuration parameters.
     *
     * @return the default vanilla overworld noise configuration parameters.
     */
    static NoiseConfig overworld() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworld();
    }

    /**
     * Returns the vanilla nether noise configuration parameters.
     *
     * @return the vanilla nether noise configuration parameters.
     */
    static NoiseConfig nether() {
        return Sponge.game().factoryProvider().provide(Factory.class).nether();
    }

    /**
     * Returns the vanilla end noise configuration parameters.
     *
     * @return the vanilla end noise configuration parameters.
     */
    static NoiseConfig end() {
        return Sponge.game().factoryProvider().provide(Factory.class).end();
    }

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * The minimum y coordinate where terrain starts generating.
     * <p>In vanilla the value is a multiple of 16 between -2048 and 2031.</p>
     *
     * @return the minimum y coordinate.
     */
    int minY();

    /**
     * The total height where terrain generates.
     * <p>In vanilla the value is a multiple of 16. Added to {@link #minY()} its value must not exceed 2032.</p>
     *
     * @return the total height.
     */
    int height();

    /**
     * The horizontal scaling of landmass.
     * <p>Higher values increase the distances</p>
     *
     * @return the horizontal scaling of landmass.
     */
    int horizontalSize();

    /**
     * The vertical scaling of landmass.
     * <p>Higher values increase the average height of the landmass</p>
     *
     * @return the vertical scaling of landmass.
     */
    int verticalSize();

    interface Builder extends org.spongepowered.api.util.Builder<NoiseConfig, Builder>, CopyableBuilder<NoiseConfig, Builder> {

        Builder minY(int minY);

        Builder height(int height);

        Builder horizontalSize(int horizontal);

        Builder verticalSize(int vertical);
    }

    interface Factory {

        /**
         * Returns the default vanilla overworld noise configuration parameters.
         *
         * @return the default vanilla overworld noise configuration parameters.
         */
        NoiseConfig overworld();

        /**
         * Returns the vanilla nether noise configuration parameters.
         *
         * @return the vanilla nether noise configuration parameters.
         */
        NoiseConfig nether();

        /**
         * Returns the vanilla end noise configuration parameters.
         *
         * @return the vanilla end noise configuration parameters.
         */
        NoiseConfig end();
    }
}
