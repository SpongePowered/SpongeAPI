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
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.World;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents an explosion in a {@link World}.
 */
public interface Explosion {

    /**
     * Gets the world the explosion will occur in.
     *
     * @return The world
     */
    World getWorld();

    /**
     * Sets the world the explosion will occur in.
     *
     * @param world The world
     */
    void setWorld(World world);

    /**
     * Gets the source {@link Explosive} of the explosion.
     *
     * @return The source explosive or null if there is no source
     */
    Optional<Explosive> getSourceExplosive();

    /**
     * Sets the source explosive of the explosion.
     *
     * @param source The source explosive
     */
    void setSourceExplosive(@Nullable Explosive source);

    /**
     * Gets the radius of the explosion.
     *
     * @return The radius
     */
    float getRadius();

    /**
     * Sets the radius of the explosion.
     *
     * @param radius The radius
     */
    void setRadius(float radius);

    /**
     * Gets a copy of the explosion's origin.
     *
     * @return A copy of the origin
     */
    Vector3d getOrigin();

    /**
     * Sets the origin of the explosion.
     *
     * @param origin The origin
     */
    void setOrigin(Vector3d origin);

    /**
     * Gets whether the affected blocks have a chance to catch on fire.
     *
     * @return Whether the affected blocks can catch on fire
     */
    boolean canCauseFire();

    /**
     * Sets whether the affected blocks have a chance to catch on fire.
     *
     * @param fire Whether the affected blocks can catch on fire
     */
    void canCauseFire(boolean fire);

    /**
     * Gets whether the explosion will play a smoke effect.
     *
     * @return Whether the explosion will play smoke
     */
    boolean shouldPlaySmoke();

    /**
     * Sets whether the explosion will show smoke to the client
     *
     * @param smoke Whether the explosion will play smoke
     */
    void canPlaySmoke(boolean smoke);

    /**
     * Gets whether the affected blocks should be destroyed on explosion.
     *
     * @return Whether the affected blocks should be destroyed
     */
    boolean shouldBreakBlocks();

    /**
     * If true, blocks will be set to BlockTypes.AIR and items dropped.
     * If false, blocks will be unaffected.
     *
     * @param destroy Whether the affected blocks should be destroyed
     */
    void shouldBreakBlocks(boolean destroy);
    /**
     * A builder for {@link Explosion}.
     */
    interface Builder extends ResettableBuilder {

        /**
         * Sets the {@link World} the explosion will occur in.
         *
         * @param world The world
         * @return The builder, for chaining
         */
        Builder world(World world);

        /**
         * Sets the source explosive of the explosion.
         *
         * @param source The source entity
         * @return The builder, for chaining
         */
        Builder sourceExplosive(@Nullable Explosive source);

        /**
         * Sets the radius of the explosion.
         *
         * @param radius The radius
         * @return The builder, for chaining
         */
        Builder radius(float radius);

        /**
         * Sets the origin of the explosion.
         *
         * @param origin The origin
         * @return The builder, for chaining
         */
        Builder origin(Vector3d origin);

        /**
         * Sets whether the affected blocks have a chance to catch on fire.
         *
         * @param fire Whether the affected blocks can catch on fire
         * @return The builder, for chaining
         */
        Builder canCauseFire(boolean fire);

        /**
         * Sets whether the affected blocks should be destroyed on explosion.
         *
         * @param destroy Whether the affected blocks should be destroyed
         * @return The builder, for chaining
         */
        Builder shouldBreakBlocks(boolean destroy);

        @Override
        ResettableBuilder reset();

        /**
         * Attempts to create a {@link Explosion} from the specified parameters.
         *
         * @throws IllegalArgumentException If any builder parameter is invalid
         * @return The explosion, if successful
         */
        Explosion build() throws IllegalArgumentException;

    }
}
