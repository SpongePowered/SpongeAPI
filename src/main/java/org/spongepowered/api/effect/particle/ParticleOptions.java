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

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link ParticleOption}s in vanilla minecraft.
 */
public final class ParticleOptions {

    // SORTFIELDS:ON

    /**
     * This option will affect the appearance of a particle, the only
     * vanilla {@link ParticleType}s that this option will affect are
     * {@link ParticleTypes#ITEM_CRACK}, {@link ParticleTypes#BLOCK_CRACK}
     * and {@link ParticleTypes#BLOCK_DUST}.
     */
    public static final ParticleOption<BlockState> BLOCK_STATE = dummy("BLOCK_STATE");

    /**
     * This option will modify the color of a particle, the only
     * vanilla {@link ParticleType}s that this option will affect are
     * {@link ParticleTypes#MOB_SPELL}, {@link ParticleTypes#AMBIENT_MOB_SPELL}
     * and {@link ParticleTypes#REDSTONE_DUST}.
     */
    public static final ParticleOption<Color> COLOR = dummy("COLOR");

    /**
     * This option will affect the amount of particles that are spawned. The
     * minimum amount of particles is 1.
     */
    public static final ParticleOption<Integer> QUANTITY = dummy("QUANTITY");

    /**
     * This option will affect the appearance of a particle, the only
     * vanilla {@link ParticleType} that this option will affect is
     * {@link ParticleTypes#ITEM_CRACK}.
     */
    public static final ParticleOption<ItemStackSnapshot> ITEM_STACK_SNAPSHOT = dummy("ITEM_STACK_SNAPSHOT");

    public static final ParticleOption<NotePitch> NOTE = dummy("NOTE");

    /**
     * This option will affect how all the particles are spread.
     */
    public static final ParticleOption<Vector3d> OFFSET = dummy("OFFSET");

    /**
     * This option will change the potion type of a particle, the only
     * vanilla {@link ParticleType}s that this option will affect is
     * {@link ParticleTypes#SPLASH_POTION}.
     */
    public static final ParticleOption<PotionEffectType> POTION_EFFECT_TYPE = dummy("POTION_EFFECT_TYPE");

    /**
     * This option will change the scale of a particle, the only
     * vanilla {@link ParticleType}s that this option will affect are
     * {@link ParticleTypes#LARGE_EXPLOSION} and
     * {@link ParticleTypes#SWEEP_ATTACK}.
     */
    public static final ParticleOption<Double> SCALE = dummy("SCALE");

    /**
     * This option will affect whether a particle type will have a lower
     * velocity in the horizontal plane. The only vanilla {@link ParticleType}s
     * that this option will affect are:
     * <ul>
     *   <li>{@link ParticleTypes#SPELL}</li>
     *   <li>{@link ParticleTypes#INSTANT_SPELL}</li>
     *   <li>{@link ParticleTypes#WITCH_SPELL}</li>
     * <ul/>
     * These particle types don't have a configurable velocity
     * (through {@link #VELOCITY}) in the horizontal plane.
     */
    public static final ParticleOption<Boolean> SLOW_HORIZONTAL_VELOCITY = dummy("SLOW_HORIZONTAL_VELOCITY");

    /**
     * This option will affect how all the particles are moving.
     */
    public static final ParticleOption<Vector3d> VELOCITY = dummy("VELOCITY");

    // SORTFIELDS:OFF

    @SuppressWarnings("unchecked")
    private static <V> ParticleOption<V> dummy(String name) {
        return DummyObjectProvider.createFor(ParticleOption.class, name);
    }

    private ParticleOptions() {
    }

}
