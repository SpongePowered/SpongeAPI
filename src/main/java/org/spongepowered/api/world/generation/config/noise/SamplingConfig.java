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
 * Specifies how noise is sampled.
 */
public interface SamplingConfig {

    static SamplingConfig of(final double xzScale, final double xzFactor, final double yScale, final double yFactor) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(xzScale, xzFactor, yScale, yFactor);
    }

    /**
     * The noise scale on the x and z axis. Higher values result in more intricate horizontal shapes.
     *
     * @return the xz scale
     */
    double xzScale();

    /**
     * The noise smoothness in the horizontal axis.
     *
     * @return the xz factor.
     */
    double xzFactor();

    /**
     * The noise scale on the y axis. Higher values result in more intricate vertical shapes.
     *
     * @return the y scale
     */
    double yScale();

    /**
     * The noise smoothness in the vertical axis.
     * <p>The value can range from 0.001 to 1000.0</p>
     *
     * @return the xz factor.
     */
    double yFactor();

    interface Factory {

        SamplingConfig of(double xzScale, double xzFactor, double yScale, double yFactor);
    }
}
