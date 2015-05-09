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
package org.spongepowered.api.util;

import com.flowpowered.math.vector.Vectord;
import com.flowpowered.math.vector.Vectorf;
import com.flowpowered.math.vector.Vectori;

/**
 * An exception thrown when a position in outside of its expected bounds.
 */
public class PositionOutOfBoundsException extends RuntimeException {
    private static final long serialVersionUID = 1;

    /**
     * Constructs the exception from int coordinate vectors.
     *
     * @param position The out-of-bounds position
     * @param min The minimum acceptable bound
     * @param max The maximum acceptable bound
     */
    public PositionOutOfBoundsException(Vectori position, Vectori min, Vectori max) {
        this(position.toString(), min.toString(), max.toString());
    }

    /**
     * Constructs the exception from float coordinate vectors.
     *
     * @param position The out-of-bounds position
     * @param min The minimum acceptable bound
     * @param max The maximum acceptable bound
     */
    public PositionOutOfBoundsException(Vectorf position, Vectorf min, Vectorf max) {
        this(position.toString(), min.toString(), max.toString());
    }

    /**
     * Constructs the exception from double coordinate vectors.
     *
     * @param position The out-of-bounds position
     * @param min The minimum acceptable bound
     * @param max The maximum acceptable bound
     */
    public PositionOutOfBoundsException(Vectord position, Vectord min, Vectord max) {
        this(position.toString(), min.toString(), max.toString());
    }

    private PositionOutOfBoundsException(String position, String min, String max) {
        super("Position if out of bounds: expected in range " + min + " to " + max + " but got " + position);
    }
}
