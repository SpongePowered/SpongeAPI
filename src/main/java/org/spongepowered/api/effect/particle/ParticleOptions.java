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
package org.spongepowered.api.effect.particle;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.math.vector.Vector3d;

/**
 * An enumeration of all possible {@link ParticleOption}s in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ParticleOptions {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * This option will affect the appearance of a particle. The only vanilla
     * {@link ParticleType}s that this option is applicable to are:
     *
     * <ul>
     *   <li>{@link ParticleTypes#BLOCK}</li>
     *   <li>{@link ParticleTypes#FALLING_DUST}</li>
     *   <li>{@link ParticleTypes#ITEM}</li>
     * </ul>
     */
    public static final DefaultedRegistryReference<ParticleOption<BlockState>> BLOCK_STATE = ParticleOptions.key(ResourceKey.sponge("block_state"));

    /**
     * This option will modify the color of a particle. The only vanilla
     * {@link ParticleType}s this option is applicable to are:
     *
     * <ul>
     *   <li>{@link ParticleTypes#AMBIENT_ENTITY_EFFECT}</li>
     *   <li>{@link ParticleTypes#ENTITY_EFFECT}</li>
     *   <li>{@link ParticleTypes#DUST}</li>
     * </ul>
     */
    public static final DefaultedRegistryReference<ParticleOption<Color>> COLOR = ParticleOptions.key(ResourceKey.sponge("color"));

    /**
     * This option will affect the delay of particles that are spawned.
     * The only vanilla {@link ParticleType}s this option isn't applicable to are:
     *
     * <ul>
     *   <li>{@link ParticleTypes#SHRIEK}</li>
     * </ul>
     */
    public static final DefaultedRegistryReference<ParticleOption<Integer>> DELAY = ParticleOptions.key(ResourceKey.sponge("delay"));

    /**
     * This option will change the direction of a particle.
     */
    public static final DefaultedRegistryReference<ParticleOption<Direction>> DIRECTION = ParticleOptions.key(ResourceKey.sponge("direction"));

    /**
     * This option will affect the appearance of a particle. The only vanilla
     * {@link ParticleType} this option is applicable to are:
     *
     * <ul>
     *   <li>{@link ParticleTypes#BLOCK}</li>
     *   <li>{@link ParticleTypes#FALLING_DUST}</li>
     *   <li>{@link ParticleTypes#ITEM}</li>
     * </ul>
     */
    public static final DefaultedRegistryReference<ParticleOption<ItemStackSnapshot>> ITEM_STACK_SNAPSHOT = ParticleOptions.key(ResourceKey.sponge("item_stack_snapshot"));

    /**
     * This option will affect how all the particles are spread.
     */
    public static final DefaultedRegistryReference<ParticleOption<Vector3d>> OFFSET = ParticleOptions.key(ResourceKey.sponge("offset"));

    /**
     * This option will change the potion type of a particle. The only vanilla
     * {@link ParticleType}s this option is applicable to is
     */
    public static final DefaultedRegistryReference<ParticleOption<PotionEffectType>> POTION_EFFECT_TYPE = ParticleOptions.key(ResourceKey.sponge("potion_effect_type"));

    /**
     * This option will affect the amount of particles that are spawned. The
     * minimum amount of particles is 1. The only vanilla {@link ParticleType}s
     * this option isn't applicable to are:
     *
     * <ul>
     *   <li>{@link ParticleTypes#BLOCK}</li>
     *   <li>{@link ParticleTypes#FIREWORK}</li>
     * </ul>
     *
     * <p>The quantity must be at least 1, or a {@link IllegalArgumentException}
     * will be thrown when applying.</p>
     */
    public static final DefaultedRegistryReference<ParticleOption<Integer>> QUANTITY = ParticleOptions.key(ResourceKey.sponge("quantity"));

    /**
     * This option will change the roll of a particle. The only
     * vanilla {@link ParticleType}s this option is applicable to is:
     *
     * <ul>
     *   <li>{@link ParticleTypes#SCULK_CHARGE}</li>
     * </ul>
     */
    public static final DefaultedRegistryReference<ParticleOption<Double>> ROLL = ParticleOptions.key(ResourceKey.sponge("roll"));

    /**
     * This option will change the scale of a particle. The only
     * vanilla {@link ParticleType}s this option is applicable to is:
     *
     * <ul>
     *   <li>{@link ParticleTypes#DUST}</li>
     * </ul>
     *
     * <p>The scale may never be negative, or a {@link IllegalArgumentException}
     * will be thrown when applying.</p>
     */
    public static final DefaultedRegistryReference<ParticleOption<Double>> SCALE = ParticleOptions.key(ResourceKey.sponge("scale"));

    /**
     * This option will change the color the transition particle will change to.
     * The only vanilla {@link ParticleType}s this option is applicable to is:
     *
     * <ul>
     *   <li>{@link ParticleTypes#DUST_COLOR_TRANSITION}</li>
     * </ul>
     */
    public static final DefaultedRegistryReference<ParticleOption<Color>> TO_COLOR = ParticleOptions.key(ResourceKey.sponge("to_color"));

    /**
     * This option will change the travel time of a particle.
     * The only vanilla {@link ParticleType}s this option is applicable to is:
     *
     * <ul>
     *   <li>{@link ParticleTypes#VIBRATION}</li>
     * </ul>
     */
    public static final DefaultedRegistryReference<ParticleOption<Ticks>> TRAVEL_TIME = ParticleOptions.key(ResourceKey.sponge("travel_time"));

    /**
     * This option will affect how most particles are moving.
     */
    public static final DefaultedRegistryReference<ParticleOption<Vector3d>> VELOCITY = ParticleOptions.key(ResourceKey.sponge("velocity"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ParticleOptions() {
    }

    public static Registry<ParticleOption<?>> registry() {
        return Sponge.game().registry(RegistryTypes.PARTICLE_OPTION);
    }

    private static <T> DefaultedRegistryReference<ParticleOption<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.PARTICLE_OPTION, location).asDefaultedReference(Sponge::game);
    }
}
