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
package org.spongepowered.api.world.volume.archetype;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.world.biome.WorkableBiomeVolume;
import org.spongepowered.api.world.volume.block.WorkableBlockVolume;
import org.spongepowered.api.world.volume.entity.WorkableEntityVolume;
import org.spongepowered.api.world.volume.tileentity.WorkableTileEntityVolume;

public interface ArchetypeVolumeCreator extends WorkableBlockVolume<ArchetypeVolumeCreator>,
    WorkableBiomeVolume<ArchetypeVolumeCreator>,
    WorkableEntityVolume<ArchetypeVolumeCreator>,
    WorkableTileEntityVolume<ArchetypeVolumeCreator>
{

    /**
     * Creates a new archetype volume from the specified section of this extent.
     * The archetype's volume will be shifted such that the position given in
     * the origin will be the origin of the volume.
     *
     * @param min The minimum point of the volume to copy
     * @param max The maximum point of the volume to copy
     * @param origin The eventual origin on the new archetype volume
     * @return The archetype volume
     */
    ArchetypeVolume createArchetypeVolume(Vector3i min, Vector3i max, Vector3i origin);

    @Override
    ArchetypeVolumeCreator getView(Vector3i newMin, Vector3i newMax);

}
