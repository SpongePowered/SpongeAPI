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
package org.spongepowered.api.world.volume;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.math.vector.Vector3d;

import java.util.Objects;

/**
 * The result of an intersection between a ray and an entity.
 */
public class EntityHit {

    private final Entity entity;
    private final Vector3d intersection;
    private final Vector3d normal;
    private final double distance;

    /**
     * Creates a new entity hit from the entity, the intersection point and
     * the normal.
     *
     * @param entity The intersected entity
     * @param intersection The intersection point
     * @param normal The intersection normal
     * @param distance The distance from the start to the intersection
     */
    public EntityHit(Entity entity, Vector3d intersection, Vector3d normal, double distance) {
        this.entity = Objects.requireNonNull(entity, "entity");
        this.intersection = Objects.requireNonNull(intersection, "intersection");
        this.normal = Objects.requireNonNull(normal, "normal");
        this.distance = distance;
    }

    /**
     * Gets the intersected entity.
     *
     * @return The intersected entity
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * Gets the intersection point.
     *
     * @return The point of intersection
     */
    public Vector3d getIntersection() {
        return this.intersection;
    }

    /**
     * Gets the intersection normal.
     *
     * @return The normal of intersection
     */
    public Vector3d getNormal() {
        return this.normal;
    }

    /**
     * Gets the distance from the start to the intersection.
     *
     * @return The distance from the start to the intersection
     */
    public double getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntityHit)) {
            return false;
        }
        final EntityHit entityHit = (EntityHit) other;
        return this.entity.equals(entityHit.entity) && this.intersection.equals(entityHit.intersection) && this.normal.equals(entityHit.normal)
                && this.distance == entityHit.distance;

    }

    @Override
    public int hashCode() {
        int result = this.entity.hashCode();
        result = 31 * result + this.intersection.hashCode();
        result = 31 * result + this.normal.hashCode();
        result = 31 * result + Double.hashCode(this.distance);
        return result;
    }

    @Override
    public String toString() {
        return "EntityHit(" + this.entity + " at " + this.intersection + " on " + this.normal + ")";
    }

}
