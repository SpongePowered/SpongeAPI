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
package org.spongepowered.api.world.explosion;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.world.World;

import javax.annotation.Nullable;

/**
 * A builder for {@link Explosion}.
 */
public interface ExplosionBuilder {

    /**
     * Sets the {@link World} the explosion will occur in.
     *
     * @param world The world
     * @return This builder, for chaining
     */
    ExplosionBuilder world(World world);

    /**
     * Sets the source {@link Explosive} of the explosion.
     *
     * @param source The source explosive
     * @return This builder, for chaining
     */
    ExplosionBuilder sourceExplosive(@Nullable Explosive source);

    /**
     * Sets the radius of the explosion.
     *
     * @param radius The radius
     * @return This builder, for chaining
     */
    ExplosionBuilder radius(float radius);

    /**
     * Sets the origin of the explosion.
     *
     * @param origin The origin
     * @return This builder, for chaining
     */
    ExplosionBuilder origin(Vector3d origin);

    /**
     * Sets whether the affected blocks have a chance to catch on fire.
     *
     * @param fire Whether the affected blocks can catch on fire
     * @return This builder, for chaining
     */
    ExplosionBuilder canCauseFire(boolean fire);

    /**
     * Sets whether the explosion will show smoke to the client
     *
     * @param smoke Whether the explosion will show smoke
     * @return This builder, for chaining
     */
    ExplosionBuilder canPlaySmoke(boolean smoke);

    /**
     * Sets whether the affected blocks should be destroyed on explosion.
     *
     * @param destroy Whether the affected blocks should be destroyed
     * @return This builder, for chaining
     */
    ExplosionBuilder shouldBreakBlocks(boolean destroy);

    /**
     * Resets this builder to a clean state.
     *
     * @return This builder, for chaining
     */
    ExplosionBuilder reset();

    /**
     * Creates an {@link Explosion} from the specified parameters.
     *
     * @throws IllegalStateException If any builder parameter is invalid
     * @return The created explosion
     */
    Explosion build();

}
