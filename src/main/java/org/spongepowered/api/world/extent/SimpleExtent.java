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

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Collection;

import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.biome.Biome;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

/**
 * Simple implementation of Extent for the use of sub regions.
 */
public abstract class SimpleExtent implements Extent {

    private final Optional<Extent> parent;
    protected final Vector3d origin;

    public SimpleExtent(Extent parent, Vector3d origin) {
        checkNotNull(parent);
        checkNotNull(origin);
        this.parent = Optional.of(parent);
        this.origin = origin;
    }

    public SimpleExtent(World world, Vector3d origin) {
        this((Extent) world, origin);
    }

    public SimpleExtent(Extent parent, Vector3i origin) {
        this(parent, origin.toDouble());
    }

    public SimpleExtent(World world, Vector3i origin) {
        this(world, origin.toDouble());
    }

    @Override
    public BlockLoc getBlock(Vector3d position) {
        return this.getBlock(position.getFloorX(), position.getFloorY(), position.getFloorZ());
    }

    @Override
    public BlockLoc getBlock(int x, int y, int z) {
        Extent extent = this;
        do {
            x -= extent.getOrigin().getX();
            y -= extent.getOrigin().getY();
            z -= extent.getOrigin().getZ();
            extent = extent.getParent().get();
        } while (!(extent instanceof World));

        return ((World) extent).getBlock(x, y, z);
    }

    @Override
    public Collection<Entity> getEntities() {
        Extent extent = this;
        do {
            extent = extent.getParent().get();
        } while (!(extent instanceof World));

        return ((World) extent).getEntities();
    }

    @Override
    public Collection<Entity> getEntities(Predicate<Entity> filter) {
        Extent extent = this;
        do {
            extent = extent.getParent().get();
        } while (!(extent instanceof World));

        return ((World) extent).getEntities(filter);
    }

    @Override
    public Optional<Entity> createEntity(EntityType type, Vector3d position) {
        double x = position.getX(), y = position.getY(), z = position.getZ();
        Extent extent = this;
        do {
            x -= extent.getOrigin().getX();
            y -= extent.getOrigin().getY();
            z -= extent.getOrigin().getZ();
            extent = extent.getParent().get();
        } while (!(extent instanceof World));
        position = new Vector3d(x, y, z);

        return ((World) extent).createEntity(type, position);
    }

    @Override
    public Optional<Entity> createEntity(EntitySnapshot snapshot, Vector3d position) {
        double x = position.getX(), y = position.getY(), z = position.getZ();
        Extent extent = this;
        do {
            x -= extent.getOrigin().getX();
            y -= extent.getOrigin().getY();
            z -= extent.getOrigin().getZ();
            extent = extent.getParent().get();
        } while (!(extent instanceof World));
        position = new Vector3d(x, y, z);

        return ((World) extent).createEntity(snapshot, position);
    }

    @Override
    public Biome getBiome(Vector3d position) {
        double x = position.getX(), y = position.getY(), z = position.getZ();
        Extent extent = this;
        do {
            x -= extent.getOrigin().getX();
            y -= extent.getOrigin().getY();
            z -= extent.getOrigin().getZ();
            extent = extent.getParent().get();
        } while (!(extent instanceof World));
        position = new Vector3d(x, y, z);

        return ((World) extent).getBiome(position);
    }

    @Override
    public final Optional<Extent> getParent() {
        return parent;
    }

    @Override
    public final Vector3d getOrigin() {
        return this.origin;
    }

}
