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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.World;

import java.util.Optional;

/**
 * Represents an explosion in a {@link World}.
 */
public interface Explosion extends Locatable {

    /**
     * Creates a new {@link Builder} to build a {@link Explosion}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the source {@link Explosive} of the explosion.
     *
     * @return The source explosive or null if there is no source
     */
    Optional<Explosive> getSourceExplosive();

    /**
     * Gets the radius of the explosion.
     *
     * @return The radius
     */
    float getRadius();

    /**
     * Gets whether the affected blocks have a chance to catch on fire.
     *
     * @return Whether the affected blocks can catch on fire
     */
    boolean canCauseFire();

    /**
     * Gets whether the explosion will play a smoke effect.
     *
     * @return Whether the explosion will play smoke
     */
    boolean shouldPlaySmoke();

    /**
     * Gets whether the affected blocks should be destroyed on explosion.
     *
     * @return Whether the affected blocks should be destroyed
     */
    boolean shouldBreakBlocks();

    /**
     * Gets whether this explosion will damage entities.
     *
     * @return Whether the explosion will damage entities
     */
    boolean shouldDamageEntities();

    /**
     * Gets a value that indicates the relative strength of an explosion.
     *
     * @return The resolution of the explosion.
     */
    default int getResolution() {
        return 16;
    }

    /**
     * Gets an indication of the randomness of the form of the explosion.
     *
     * <p>This value indicates how close to being symmetrical the explosion is.
     * A value of zero indicates a completely symmetrical blast (in all three
     * dimensions). A larger value indicates a lower likelihood of symmetry. A
     * value of one indicates the platform default.</p>
     *
     * <p>Note, this is a hint to the implementation. Implementations may not
     * provide the means to produce semi-random form explosions.</p>
     *
     * @return The potential randomness of the form of the explosion.
     */
    default float getRandomness() {
        return 1;
    }

    /**
     * Gets the relative strength of the knockback applied to nearby
     * objects that can be knocked back.
     *
     * <p>Note that the default behavior and strength is not defined here. A
     * return value of 1 simply indicates the default behavior which is
     * implementation dependent.</p>
     *
     * @return The multiple by which the knockback of entities will be changed
     */
    default double getKnockback() {
        return 1;
    }

    /**
     * A builder for {@link Explosion}.
     */
    interface Builder extends CopyableBuilder<Explosion, Builder> {

        /**
         * Sets the location origin of the explosion.
         *
         * @param location Origin of explosion
         * @return The builder, for chaining
         */
        Builder location(ServerLocation location);

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
         * Sets whether the affected blocks have a chance to catch on fire.
         *
         * @param fire Whether the affected blocks can catch on fire
         * @return The builder, for chaining
         */
        Builder canCauseFire(boolean fire);

        /**
         * Sets whether the explosion will damage entities nearby.
         *
         * @param damage Whether the explosion will damage entities
         * @return This builder, for chaining
         */
        Builder shouldDamageEntities(boolean damage);

        /**
         * Sets whether the explosion will have smoke particles.
         *
         * @param smoke Whether the explosion will have smoke particles
         * @return This builder, for chaining
         */
        Builder shouldPlaySmoke(boolean smoke);

        /**
         * Sets whether the affected blocks should be destroyed on explosion.
         *
         * @param destroy Whether the affected blocks should be destroyed
         * @return The builder, for chaining
         */
        Builder shouldBreakBlocks(boolean destroy);

        /**
         * Sets the resolution of the explosion.
         *
         * @param resolution The desired resolution of the explosion
         * @return The builder, for chaining
         */
        default Builder resolution(int resolution) {
            return this;
        }

        /**
         * Indicates the desired randomness of the form of the explosion.
         *
         * <p>This value indicates how close to being symmetrical the explosion is.
         * A value of zero indicates a completely symmetrical blast (in all three
         * dimensions). A larger value indicates a lower likelihood of symmetry. A
         * value of one indicates the platform default.</p>
         *
         * <p>Note, this is a hint to the implementation. Implementations may not
         * provide the means to produce semi-random form explosions.</p>
         *
         * @return This builder, for chaining
         */
        default Builder randomness(float randomness) {
            return this;
        }

        /**
         * Sets the relative strength of the knockback applied to nearby
         * objects that can be knocked back.
         *
         * <p>Note that the default behavior and strength is not defined here. A
         * return value of 1 simply indicates the default behavior which is
         * implementation dependent.</p>
         *
         * @param knockback The knockback multiple
         * @return This builder, for chaining
         */
        default Builder knockback(double knockback) {
            return this;
        }

        /**
         * Attempts to create a {@link Explosion} from the specified parameters.
         *
         * @return The explosion, if successful
         * @throws IllegalArgumentException If any builder parameter is invalid
         */
        Explosion build() throws IllegalArgumentException;

    }
}
