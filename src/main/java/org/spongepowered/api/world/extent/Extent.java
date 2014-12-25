/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Optional;

/**
 * Contains blocks, entities, and possibly other game objects.
 */
public interface Extent extends BlockVolume, EntityUniverse, BiomeVolume {

	/**
	 * Get the parent Extent. Returns {@code Optional.absent()} if this is a
	 * World instance.
	 * <p>
	 * This method should always recursively find its way to a root World.
	 * 
	 * @return the parent Extent
	 */
	Optional<Extent> getParent();

	/**
	 * Get the origin of this Extent relative to its parent. Returns
	 * {@code Vector3d.ZERO} if this is an instance of World.
	 * 
	 * @return the relative origin
	 */
	Vector3d getOrigin();
}
