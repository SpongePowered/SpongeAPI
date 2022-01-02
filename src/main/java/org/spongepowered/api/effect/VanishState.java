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
package org.spongepowered.api.effect;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;

/**
 * Represents the state of an {@link Entity}'s vanish state.
 * Accessible through {@link org.spongepowered.api.data.Keys#VANISH_STATE}
 */
public interface VanishState {

    /**
     * Gets a vanished state via {@link Factory#vanish()} with the following
     * defaults:
     * <ul>
     *     <li>{@link VanishState#invisible()} = {@code true}</li>
     *     <li>{@link VanishState#affectsMonsterSpawning()} = {@code false}</li>
     *     <li>{@link VanishState#untargetable()} = {@code true}</li>
     *     <li>{@link VanishState#createsSounds()} = {@code false}</li>
     *     <li>{@link VanishState#createsParticles()} = {@code false}</li>
     * </ul>
     *
     * @return A vanished state with the provided defaults
     */
    static VanishState vanished() {
        return Sponge.game().factoryProvider().provide(VanishState.Factory.class).vanished();
    }

    /**
     * A {@link VanishState} that is invisible with the following defaults:
     * <ul>
     *     <li>{@link VanishState#invisible()} = {@code false}</li>
     *     <li>{@link VanishState#affectsMonsterSpawning()} = {@code true}</li>
     *     <li>{@link VanishState#untargetable()} = {@code false}</li>
     *     <li>{@link VanishState#createsSounds()} = {@code true}</li>
     *     <li>{@link VanishState#createsParticles()} = {@code true}</li>
     * </ul>
     *
     * @return A visible state with the provided defaults
     */
    static VanishState unvanished() {
        return Sponge.game().factoryProvider().provide(VanishState.Factory.class).unvanished();
    }

    /**
     * Gets whether the state is visible. If an {@link Entity} is visible, then
     * other aspects of this state will be ignored, such as
     * {@link #ignoresCollisions()}, {@link #untargetable()}, etc.
     *
     * @return Whether the {@link Entity} is visible
     */
    boolean invisible();

    /**
     * Gets a vanished {@link VanishState state} with {@link #ignoresCollisions()}
     * and {@link #untargetable()} set to {@code true}. If the state is already
     * {@link #invisible()}, then the same state is returned.
     *
     * @return The vanished state
     */
    VanishState vanish();

    /**
     * Gets a visible state {@link VanishState} with {@link #ignoresCollisions()}
     * and {@link #untargetable()} set to {@code false}. If the state is already
     * {@link #invisible()} being {@code false}, then the same state is returned.
     *
     * @return The visible state
     */
    VanishState unvanish();

    /**
     * Gets if the {@link Entity} will ignore collisions. In cases where
     * {@link #invisible()} is {@code false}, this will return {@code false}.
     *
     * @return Whether collisions will be ignored
     */
    boolean ignoresCollisions();

    /**
     * If {@link #invisible()} returns true, this will return the
     * {@link VanishState} with the desired flag of
     * {@link #ignoresCollisions()}.
     *
     * @param ignoresCollisions Whether collisions will be ignored
     * @return The new VanishState, the value changed
     */
    VanishState ignoreCollisions(boolean ignoresCollisions);

    /**
     * Gets if the {@link Entity} will be untargetable by entity ai. In cases
     * where {@link #invisible()} is {@code false}, this will return
     * {@code false}.
     *
     * @return Whether the {@link Entity} will be untargetable
     */
    boolean untargetable();

    /**
     * If {@link #invisible()} returns true, this will return the
     * {@link VanishState} with the desired flag of
     * {@link #ignoresCollisions()}.
     *
     * @param untargetable Whether the entity can be targeted by AI
     * @return The new VanishState, the value changed
     */
    VanishState untargetable(boolean untargetable);

    /**
     * Gets if {@link #affectsMonsterSpawning()} returns {@code false}, the
     * vanished {@link Entity} will not spawn monsters or affect near by monster
     * spawners.
     * <p>Note that this flag works in conjunction with
     * {@link org.spongepowered.api.data.Keys#AFFECTS_SPAWNING} such that either
     * one being {@code false} will disable spawning.</p>
     *
     * @return Whether the {@link Entity} will affect monster spawning
     */
    boolean affectsMonsterSpawning();

    /**
     * If {@link #invisible()} returns true, this will return the
     * {@link VanishState} with the desired flag.
     * <p>Note that this flag works in conjunction with
     * {@link org.spongepowered.api.data.Keys#AFFECTS_SPAWNING} such that either
     * one being false will disable spawning.</p>
     *
     * @param affectsMonsterSpawning Whether the {@link Entity} will affect
     *      monster spawning
     * @return The new VanishState
     */
    VanishState affectMonsterSpawning(boolean affectsMonsterSpawning);

    /**
     * Gets if the {@link Entity} will produce sounds from various actions that
     * occur while {@link #invisible()} is {@code true}.
     *
     * @return Whether the {@link Entity} will produce sounds while invisible
     */
    boolean createsSounds();

    /**
     * If {@link #invisible()} returns true, this will return the
     * {@link VanishState} with the desired flag of
     * {@link #createsSounds()}.
     *
     * @param createSounds Whether the {@link Entity} will produce sounds
     * @return The new VanishState
     */
    VanishState createSounds(boolean createSounds);

    /**
     * Gets if the {@link Entity} will produce particles from various actions
     * that occur while {@link #invisible()} is {@code true}.
     *
     * @return Whether the {@link Entity} will produce particles while invisible
     */
    boolean createsParticles();

    /**
     * If {@link #invisible()} returns true, this will return the
     * {@link VanishState} with the desired flag of
     * {@link #createsParticles()}.
     *
     * @param createParticles Whether the {@link Entity} will produce particles
     * @return The new VanishState
     */
    VanishState createParticles(boolean createParticles);

    interface Factory {

        /**
         * Creates a {@link VanishState} that is invisible with the following
         * defaults:
         * <ul>
         *     <li>{@link VanishState#invisible()} = {@code true}</li>
         *     <li>{@link VanishState#affectsMonsterSpawning()} = {@code false}</li>
         *     <li>{@link VanishState#untargetable()} = {@code true}</li>
         *     <li>{@link VanishState#createsSounds()} = {@code false}</li>
         *     <li>{@link VanishState#createsParticles()} = {@code false}</li>
         * </ul>
         *
         * @return A newly created invisible {@link VanishState}
         */
        VanishState vanished();

        /**
         * A {@link VanishState} that is visible with the following defaults:
         * <ul>
         *     <li>{@link VanishState#invisible()} = {@code false}</li>
         *     <li>{@link VanishState#affectsMonsterSpawning()} = {@code true}</li>
         *     <li>{@link VanishState#untargetable()} = {@code false}</li>
         *     <li>{@link VanishState#createsSounds()} = {@code true}</li>
         *     <li>{@link VanishState#createsParticles()} = {@code true}</li>
         * </ul>
         *
         * @return A newly created visible {@link VanishState}
         */
        VanishState unvanished();
    }
}
