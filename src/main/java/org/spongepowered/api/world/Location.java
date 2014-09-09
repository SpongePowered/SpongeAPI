/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.world;

public interface Location {
	/**
     * Gets the x coordinate of this location as it appears in the
     * {@link World}.
     *
     * @return X coordinate
     */
    public int getX();

    /**
     * Gets the y coordinate of this location as it appears in the
     * {@link World}.
     *
     * @return Y coordinate
     */
    public int getY();
    
    /**
     * Gets the z coordinate of this location as it appears in the
     * {@link World}.
     *
     * @return Z coordinate
     */
    public int getZ();
    
    /**
     *  Gets the {@link Block} at this location.
     *  
     *  @return the block at this location
     */
    public Block getBlock();
    
    /**
     * Gets the {@link World} this location is in.
     * 
     * @return the world this location is in
     */
    public World getWord();
}
