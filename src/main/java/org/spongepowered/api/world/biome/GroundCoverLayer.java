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
package org.spongepowered.api.world.biome;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

import org.spongepowered.api.block.BlockState;

/**
 * Represents a layer of BlockStates specific to a biome which may be placed in
 * during generation.
 */
public class GroundCoverLayer {

    private BlockState state;
    private double depth;
    private double depthVariance;

    /**
     * Creates a new {@link GroundCoverLayer} with the given BlockState and a
     * base depth of 1.
     * 
     * @param type The BlockState of the layer
     */
    public GroundCoverLayer(BlockState type) {
        this(type, 1, 0);
    }

    /**
     * Creates a new {@link GroundCoverLayer} with the given BlockState and base
     * depth.
     * 
     * @param type The BlockState of the layer
     * @param depth The layer depth
     */
    public GroundCoverLayer(BlockState type, double depth) {
        this(type, depth, 0);
    }

    /**
     * Creates a new {@link GroundCoverLayer} with the given BlockState and
     * depth. The final depth of the layer will vary randomly between
     * {@code depth} and {@code depth+depthVariance} (both inclusive).
     * 
     * @param type The BlockState of the layer
     * @param depth The layer depth
     * @param depthVariance The depth variance
     */
    public GroundCoverLayer(BlockState type, double depth, double depthVariance) {
        checkArgument(depth >= 0, "Depth cannot be negative.");
        checkArgument(depthVariance >= 0, "Depth variance cannot be negative.");
        checkArgument(depthVariance != 0 || depth != 0, "Depth variance and depth cannot both be zero.");
        this.state = checkNotNull(type);
        this.depth = depth;
        this.depthVariance = depthVariance;
    }

    /**
     * Gets the {@link BlockState} for this layer.
     * 
     * @return The block state
     */
    public BlockState getState() {
        return this.state;
    }

    /**
     * Sets the {@link BlockState} for this layer.
     * 
     * @param state The new state
     */
    public void setState(BlockState state) {
        this.state = checkNotNull(state);
    }

    /**
     * Gets the base depth of this layer.
     * 
     * @return The base depth
     */
    public double getBaseDepth() {
        return this.depth;
    }

    /**
     * Sets the base depth of this layer.
     * 
     * @param depth The new base depth
     */
    public void setBaseDepth(double depth) {
        checkArgument(depth >= 0, "Depth cannot be negative.");
        checkArgument(this.depthVariance != 0 || depth != 0, "Depth variance and depth cannot both be zero.");
        this.depth = depth;
    }

    /**
     * Gets the possible variance of the depth of this layer.
     * 
     * @return The depth variance
     */
    public double getDepthVariance() {
        return this.depthVariance;
    }

    /**
     * Sets the possible variance of the depth of this layer.
     * 
     * @param variance The new depth variance
     */
    public void setDepthVariance(double variance) {
        checkArgument(variance >= 0, "Depth variance cannot be negative.");
        checkArgument(variance != 0 || this.depth != 0, "Depth variance and depth cannot both be zero.");
        this.depthVariance = variance;
    }

}
