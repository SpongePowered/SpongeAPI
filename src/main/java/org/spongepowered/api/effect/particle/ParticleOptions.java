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
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.Direction;
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
     *   <li>{@link ParticleTypes#BREAK_BLOCK}</li>
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
     * This option will change the direction of a particle.
     */
    public static final DefaultedRegistryReference<ParticleOption<Direction>> DIRECTION = ParticleOptions.key(ResourceKey.sponge("direction"));

//    /** TODO
//     * This option will modify the color of a particle. The only vanilla
//     * {@link ParticleType}s this option is applicable to is
//     * {@link ParticleTypes#FIREWORKS}.
//     *
//     * <p>The {@link List} may never be empty. Or a {@link IllegalArgumentException}
//     * will be thrown when applying.</p>
//     */
//    public static final Supplier<ParticleOption<List<FireworkEffect>>> FIREWORK_EFFECTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleOption.class, "firework_effects");

    /**
     * This option will affect the appearance of a particle. The only vanilla
     * {@link ParticleType} this option is applicable to are:
     *
     * <ul>
     *   <li>{@link ParticleTypes#BLOCK}</li>
     *   <li>{@link ParticleTypes#FALLING_DUST}</li>
     *   <li>{@link ParticleTypes#BREAK_BLOCK}</li>
     *   <li>{@link ParticleTypes#ITEM}</li>
     * </ul>
     */
    public static final DefaultedRegistryReference<ParticleOption<ItemStackSnapshot>> ITEM_STACK_SNAPSHOT = ParticleOptions.key(ResourceKey.sponge("item_stack_snapshot"));

//    /** TODO
//     * This option will affect the appearance of a particle. The only vanilla
//     * {@link ParticleType} this option is applicable to is
//     * {@link ParticleTypes#NOTE}.
//     */
//    public static final Supplier<ParticleOption<NotePitch>> NOTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleOption.class, "note");

    /**
     * This option will affect how all the particles are spread.
     */
    public static final DefaultedRegistryReference<ParticleOption<Vector3d>> OFFSET = ParticleOptions.key(ResourceKey.sponge("offset"));

    /**
     * This option will change the potion type of a particle. The only vanilla
     * {@link ParticleType}s this option is applicable to is
     * {@link ParticleTypes#SPLASH_POTION}.
     */
    public static final DefaultedRegistryReference<ParticleOption<PotionEffectType>> POTION_EFFECT_TYPE = ParticleOptions.key(ResourceKey.sponge("potion_effect_type"));

    /**
     * This option will affect the amount of particles that are spawned. The
     * minimum amount of particles is 1. The only vanilla {@link ParticleType}s
     * this option isn't applicable to are:
     *
     * <ul>
     *   <li>{@link ParticleTypes#BLOCK}</li>
     *   <li>{@link ParticleTypes#BREAK_EYE_OF_ENDER}</li>
     *   <li>{@link ParticleTypes#FIRE_SMOKE}</li>
     *   <li>{@link ParticleTypes#FIREWORK}</li>
     *   <li>{@link ParticleTypes#MOBSPAWNER_FLAMES}</li>
     *   <li>{@link ParticleTypes#SPLASH_POTION}</li>
     * </ul>
     *
     * <p>The quantity must be at least 1, or a {@link IllegalArgumentException}
     * will be thrown when applying.</p>
     */
    public static final DefaultedRegistryReference<ParticleOption<Integer>> QUANTITY = ParticleOptions.key(ResourceKey.sponge("quantity"));

//    /** TODO
//     * This option will change the scale of a particle. The only
//     * vanilla {@link ParticleType}s this option is applicable to are:
//     *
//     * <ul>
//     *   <li>{@link ParticleTypes#EXPLOSION}</li>
//     *   <li>{@link ParticleTypes#SWEEP_ATTACK}</li>
//     *   <li>{@link ParticleTypes#DUST}</li>
//     * </ul>
//     *
//     * <p>The scale may never be negative, or a {@link IllegalArgumentException}
//     * will be thrown when applying.</p>
//     */
//    public static final Supplier<ParticleOption<Double>> SCALE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleOption.class, "scale");

//    /** TODO
//     * This option will affect whether a particle type will have a lower
//     * velocity in the horizontal plane. The only vanilla {@link ParticleType}s
//     * that this option will affect are:
//     *
//     * <ul>
//     *   <li>{@link ParticleTypes#EFFECT}</li>
//     *   <li>{@link ParticleTypes#INSTANT_EFFECT}</li>
//     *   <li>{@link ParticleTypes#WITCH_MAGIC}</li>
//     * </ul>
//     *
//     * <p>These particle types don't have a configurable velocity (through
//     * {@link #VELOCITY}) in the horizontal plane.</p>
//     */
//    public static final Supplier<ParticleOption<Boolean>> SLOW_HORIZONTAL_VELOCITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleOption.class, "slow_horizontal_velocity");

    /**
     * This option will affect how most particles are moving.
     */
    public static final DefaultedRegistryReference<ParticleOption<Vector3d>> VELOCITY = ParticleOptions.key(ResourceKey.sponge("velocity"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ParticleOptions() {
    }

    private static <T> DefaultedRegistryReference<ParticleOption<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.PARTICLE_OPTION, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
