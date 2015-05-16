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

package org.spongepowered.api.util.raytrace;

import com.flowpowered.math.vector.Vector3d;

/**
 * This {@link PositionConsumer} automatically aborts the execution after a
 * specified amount of visited blocks.
 */
public class LimitedPositionConsumer implements PositionConsumer {

    private final PositionConsumer consumer;
    private int left;

    /**
     * Creates a new LimitedPoistionConsumer that automatically aborts after the
     * specified amount of blocks.
     *
     * @param consumer The consumer that should receive a limited amount of
     *        blocks
     * @param amount The maximum amount of blocks this consumer will visit
     */
    public LimitedPositionConsumer(PositionConsumer consumer, int amount) {
        super();
        this.consumer = consumer;
        this.left = amount;
    }

    @Override
    public boolean apply(double posX, double posY, double posZ, Vector3d rayDirection) {
        if (this.consumer.apply(posX, posY, posZ, rayDirection)) {
            return this.left-- > 0;
        } else {
            return false;
        }
    }

}
