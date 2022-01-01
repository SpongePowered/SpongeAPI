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

public interface SlideConfig {

    static SlideConfig of(final double target, final int size, final int offset) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(target, size, offset);
    }

    /**
     * The target value of the curve.
     * <p>See {@link NoiseConfig#topConfig()} and {@link NoiseConfig#bottomConfig()} for its effect.<p>
     * <p>Higher values produce larger effects.</p>
     *
     * @return the target value
     */
    double target();

    /**
     * The size of the affected area.
     *
     * @return the size
     */
    int size();

    /**
     * The offset of the affected area from the top or bottom of the world respectively.
     *
     * @return the offset
     */
    int offset();

    interface Factory {

        SlideConfig of(double target, int size, int offset);
    }
}
