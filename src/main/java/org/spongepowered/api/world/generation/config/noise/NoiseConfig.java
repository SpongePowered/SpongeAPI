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

public interface NoiseConfig {

    static NoiseConfig overworld() {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).overworld();
    }

    static NoiseConfig nether() {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).nether();
    }

    static NoiseConfig end() {
        return Sponge.getGame().getFactoryProvider().provide(Factory.class).end();
    }

    static Builder builder() {
        return Sponge.getGame().getBuilderProvider().provide(Builder.class).reset();
    }

    int minY();

    int height();

    SamplingConfig samplingConfig();

    SlideConfig topConfig();

    SlideConfig bottomConfig();

    int horizontalSize();

    int verticalSize();

    double densityFactor();

    double densityOffset();

    boolean simplexForSurface();

    boolean randomizeDensityOffset();

    boolean amplified();

    interface Builder extends org.spongepowered.api.util.Builder<NoiseConfig, Builder>, CopyableBuilder<NoiseConfig, Builder> {

        Builder minY(int minY);

        Builder height(int height);

        Builder sampling(SamplingConfig sampling);

        Builder top(SlideConfig top);

        Builder bottom(SlideConfig bottom);

        Builder horizontalSize(int horizontal);

        Builder verticalSize(int vertical);

        Builder densityFactor(double densityFactor);

        Builder densityOffset(double densityOffset);

        Builder simplexForSurface(boolean simplex);

        Builder randomizeDensityOffset(boolean randomDensityOffset);

        Builder amplified(boolean amplified);
    }

    interface Factory {

        NoiseConfig overworld();

        NoiseConfig nether();

        NoiseConfig end();
    }
}
