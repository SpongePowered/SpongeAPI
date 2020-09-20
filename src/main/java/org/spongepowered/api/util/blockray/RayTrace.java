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
package org.spongepowered.api.util.blockray;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.util.AABB;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3d;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Builds a set of parameters to define a ray trace that traces from a source
 * position to a target position (or in a specified direction), subject to the
 * supplied constraints.
 *
 * <p>A ray trace will check supplied predicates in the following order in the
 * case where multiple predicates should be checked:</p>
 *
 * <ol>
 *    <li>{@link #continueWhileLocation(Predicate)} -- called when the boundary
 *    between two blocks is crossed, checking if the {@link ServerLocation} the
 *    ray is crossing in to is valid, regardless of what the ray has otherwise
 *    hit.</li>
 *    <li>{@link #select(Predicate)} -- called when the {@link AABB} of
 *    {@code T} is crossed by the ray trace, for {@link LocatableBlock}s this
 *    is called directly after {@link #continueWhileLocation(Predicate)}. This
 *    is the only predicate that can return a result, <strong>any</strong> .</li>
 *    <li>{@link #continueWhileBlock(Predicate)} -- called if no selection was
 *    returned (if appropriate), checks the {@link LocatableBlock} the ray is
 *    entering. All predicates should return {@code true} if the ray should
 *    continue to trace through the block.</li>
 *    <li>{@link #continueWhileEntity(Predicate)} -- called if no selection was
 *    returned (if appropriate), checks the {@link Entity} the ray has struck.
 *    All predicates should return {@code true} if the ray should continue to
 *    trace through the entity.</li>
 * </ol>
 *
 * @param <T> The type of {@link Locatable} that this ray trace will attempt to
 *            select
 */
public interface RayTrace<T extends Locatable> {

    /**
     * Creates a {@link RayTrace} that will attempt to select a
     * {@link LocatableBlock}.
     *
     * @return The ray trace builder.
     */
    static RayTrace<LocatableBlock> block() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).blockRayTrace();
    }

    /**
     * Creates a {@link RayTrace} that will attempt to select an {@link Entity}.
     *
     * @return The ray trace builder.
     */
    static RayTrace<Entity> entity() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).entityRayTrace();
    }

    /**
     * Returns a {@link Predicate} for use in
     * {@link #continueWhileLocation(Predicate)} that only allows a trace to
     * continue if the {@link LocatableBlock} at the given position is air.
     *
     * @return The predicate
     */
    static Predicate<LocatableBlock> onlyAir() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).onlyAir();
    }

    /**
     * Returns a {@link Predicate} for use in {@link #select(Predicate)} that
     * selects non-air blocks.
     *
     * @return The predicate
     */
    static Predicate<LocatableBlock> nonAir() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).notAir();
    }

    /**
     * Sets the {@link ServerWorld} to perform the ray trace in.
     *
     * @param serverWorld The {@link ServerWorld}
     * @return This, for chaining
     */
    RayTrace<T> world(ServerWorld serverWorld);

    /**
     * Sets the {@link Vector3d position} to trace from, based on the supplied
     * {@link Entity}'s {@link Entity#getPosition() position}.
     *
     * <p>This will use {@link Entity#getPosition()} to determine the entity
     * position. This may be unexpected if you wish to ray trace along the line
     * of sight of the entity. In this scenario, use
     * {@link #sourceEyePosition(Living)} instead.</p>
     *
     * @param entity The {@link Entity}
     * @return This, for chaining
     */
    default RayTrace<T> sourcePosition(final Entity entity) {
        return this.sourcePosition(entity.getPosition());
    }

    /**
     * Sets the {@link Vector3d position} to trace from, based on the supplied
     * {@link Entity}'s {@link Keys#EYE_POSITION eye position}.
     *
     * <p>If {@link Keys#EYE_POSITION} does not exist, this will throw an
     * {@link IllegalArgumentException} instead.</p>
     *
     * @param entity The {@link Living}
     * @return This, for chaining
     */
    RayTrace<T> sourceEyePosition(Living entity);

    /**
     * Sets the {@link Vector3d} position to trace from.
     *
     * @param sourcePosition The {@link Vector3d}
     * @return This, for chaining
     */
    RayTrace<T> sourcePosition(Vector3d sourcePosition);

    /**
     * Sets the direction to trace in.
     *
     * <p>If {@link #continueUntil(Vector3d)} is set, this will be unset.</p>
     *
     * @param direction The {@link Vector3d}
     * @return This, for chaining
     */
    RayTrace<T> direction(Vector3d direction);

    /**
     * Sets the direction to trace in, based on the direction the
     * {@link Living#getHeadDirection() direction} the supplied {@link Living}
     * is currently looking.
     *
     * <p>If {@link #continueUntil(Vector3d)} is set, this will be unset.</p>
     *
     * @param entity The {@link Living}
     * @return This, for chaining
     */
    default RayTrace<T> direction(final Living entity) {
        return this.direction(entity.getHeadDirection());
    }

    /**
     * Sets how far this trace will look to find a match, passing all other
     * constraints, before returning no results.
     *
     * <p>This defaults to a distance of 30. This will be ignored if a specific
     * position is set via {@link #continueUntil(Vector3d)}.</p>
     *
     * @return This, for chaining
     */
    RayTrace<T> limit(int distance);

    /**
     * Sets the {@link Vector3d} position where a ray trace should end.
     *
     * <p>If {@link #direction(Living)} or {@link #direction(Vector3d)} is set,
     * this will be unset and any limit set via {@link #limit(int)} will be
     * ignored.</p>
     *
     * @param endPosition The position
     * @return This, for chaining
     */
    RayTrace<T> continueUntil(Vector3d endPosition);

    /**
     * Provides a {@link Predicate} that allows a consumer to determine whether
     * a given {@link ServerLocation} should allow the trace to succeed. The
     * predicate should return {@code true} if the trace should proceed.
     *
     * <p>This predicate will be checked when the boundary between two
     * {@link LocatableBlock}s is crossed.</p>
     *
     * @param predicate The predicate to check
     * @return This, for chaining
     */
    RayTrace<T> continueWhileLocation(Predicate<ServerLocation> predicate);

    /**
     * Provides a {@link Predicate} that allows a consumer to determine whether
     * a given {@link LocatableBlock} (which has <em>not</em> been selected by
     * the predicate provided in {@link #select(Predicate)} should allow the
     * trace to proceed.
     *
     * <p>For example, if a trace is for {@link LocatableBlock}s, you may only
     * want to continue the trace if it travels through air (generally used for
     * line of sight purposes). In this case, the predicate may look like this:
     * </p>
     *
     * <pre>
     * block -> {
     *   final BlockType type = block.getBlockState().getType();
     *   return type == BlockTypes.AIR.get() ||
     *          type == BlockTypes.CAVE_AIR.get() ||
     *          type == BlockTypes.VOID_AIR.get();
     * }
     * </pre>
     *
     * <p>If this is not supplied, this defaults to always returning
     * {@code true}.</p>
     *
     * @param predicate The predicate to check
     * @return This, for chaining
     */
    RayTrace<T> continueWhileBlock(Predicate<LocatableBlock> predicate);

    /**
     * Provides a {@link Predicate} that allows a consumer to determine whether
     * a given {@link Entity} (which has <em>not</em> been selected by
     * the predicate provided in {@link #select(Predicate)} should allow the
     * trace to proceed.
     *
     * <p>If this is not supplied, this will default to true, and if this is not
     * an {@link Entity} based ray trace, no entity ray trace calculations will
     * be performed.</p>
     *
     * @param predicate The predicate
     * @return This, for chaining
     */
    RayTrace<T> continueWhileEntity(Predicate<Entity> predicate);

    /**
     * Determines the condition in which a {@link Locatable} hit will be
     * considered successful.
     *
     * <p>For example, if this ray trace is {@link LocatableBlock} specific and
     * you want to obtain the first non-air block, the predicate might look
     * something like this:</p>
     *
     * <pre>
     * block -> {
     *   final BlockType type = block.getBlockState().getType();
     *   return !(type == BlockTypes.AIR.get() &&
     *          type == BlockTypes.CAVE_AIR.get() &&
     *          type == BlockTypes.VOID_AIR.get());
     * }
     * </pre>
     *
     * <p>Given the other supplied conditions, if this supplied predicate
     * returns {@code true}, the first hit will be returned as a
     * {@link Locatable}.</p>
     *
     * <p>If multiple predicates are provided, they will be combined using
     * {@link Predicate#or(Predicate)}.</p>
     *
     * <p>A selection will happen before any predicate supplied to
     * {@link #continueWhileBlock(Predicate)}, but after any
     * {@link #continueWhileLocation(Predicate)} is processed.</p>
     *
     * @param filter The filter to use to determine whether to return a
     *      {@link RayTraceResult}
     * @return This, for chaining.
     */
    RayTrace<T> select(Predicate<T> filter);

    /**
     * Executes this ray trace and returns a {@link RayTraceResult} containing
     * the {@link Locatable} if successful.
     *
     * @return The {@link RayTraceResult}, if any.
     */
    Optional<RayTraceResult<T>> execute();

    /**
     * Resets this object to its original state.
     *
     * @return This, for chaining.
     */
    RayTrace<T> reset();

    /**
     * Creates relevant objects for ray tracing.
     */
    interface Factory {

        /**
         * @see RayTrace#entity()
         */
        RayTrace<Entity> entityRayTrace();

        /**
         * @see RayTrace#block()
         */
        RayTrace<LocatableBlock> blockRayTrace();

        /**
         * @see RayTrace#onlyAir()
         */
        Predicate<LocatableBlock> onlyAir();

        /**
         * @see RayTrace#nonAir()
         */
        Predicate<LocatableBlock> notAir();

    }

}
