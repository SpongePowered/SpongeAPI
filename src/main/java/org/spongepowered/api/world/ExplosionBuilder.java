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
package org.spongepowered.api.world;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;

import javax.annotation.Nullable;

/**
 * A builder for {@link Explosion}.
 */
public interface ExplosionBuilder {

    /**
     * Sets the world the explosion will occur in.
     *
     * @param world The world
     * @return The builder, for chaining
     */
    ExplosionBuilder world(World world);

    /**
     * Sets the source entity of the explosion.
     *
     * @param source The source entity
     * @return The builder, for chaining
     */
    ExplosionBuilder sourceEntity(@Nullable Entity source);

    /**
     * Sets the radius of the explosion.
     *
     * @param radius The radius
     * @return The builder, for chaining
     */
    ExplosionBuilder radius(float radius);

    /**
     * Sets the origin of the explosion.
     *
     * @param origin The origin
     * @return The builder, for chaining
     */
    ExplosionBuilder origin(Vector3d origin);

    /**
     * Sets whether the affected blocks have a chance to catch on fire.
     *
     * @param fire Whether the affected blocks can catch on fire
     * @return The builder, for chaining
     */
    ExplosionBuilder canCauseFire(boolean fire);

    /**
     * Sets whether the affected blocks should be destroyed on explosion.
     *
     * @param destroy Whether the affected blocks should be destroyed
     * @return The builder, for chaining
     */
    ExplosionBuilder shouldBreakBlocks(boolean destroy);

    /**
     * Resets this builder to a clean state.
     *
     * @return This builder, for chaining
     */
    ExplosionBuilder reset();

    /**
     * Attempts to create a {@link Explosion} from the specified parameters.
     *
     * @return The explosion, if successful
     */
    Optional<Explosion> build();

}
