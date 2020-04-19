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
package org.spongepowered.api.effect.sound;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.effect.PlayableEffect;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents an effect that can be used to stop {@link SoundEffect}s.
 */
public interface StopSoundEffects extends PlayableEffect, DataSerializable {

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects.
     *
     * @return The stop sound effects
     */
    static StopSoundEffects all() {
        return builder().build();
    }

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects
     * with the given {@link SoundType} played in the given {@link SoundCategory}.
     *
     * @param type The sound type
     * @param category The sound category
     * @return The stop sound effects
     */
    static StopSoundEffects withTypeAndCategory(Supplier<? extends SoundType> type, Supplier<? extends SoundCategory> category) {
        return builder().withType(type).withCategory(category).build();
    }

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects
     * with the given {@link SoundType} played in the given {@link SoundCategory}.
     *
     * @param type The sound type
     * @param category The sound category
     * @return The stop sound effects
     */
    static StopSoundEffects withTypeAndCategory(Supplier<? extends SoundType> type, SoundCategory category) {
        return builder().withType(type).withCategory(category).build();
    }

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects
     * with the given {@link SoundType} played in the given {@link SoundCategory}.
     *
     * @param type The sound type
     * @param category The sound category
     * @return The stop sound effects
     */
    static StopSoundEffects withTypeAndCategory(SoundType type, Supplier<? extends SoundCategory> category) {
        return builder().withType(type).withCategory(category).build();
    }

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects
     * with the given {@link SoundType} played in the given {@link SoundCategory}.
     *
     * @param type The sound type
     * @param category The sound category
     * @return The stop sound effects
     */
    static StopSoundEffects withTypeAndCategory(SoundType type, SoundCategory category) {
        return builder().withType(type).withCategory(category).build();
    }

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects
     * with the given {@link SoundType}.
     *
     * @param type The sound type
     * @return The stop sound effects
     */
    static StopSoundEffects withType(Supplier<? extends SoundType> type) {
        return builder().withType(type).build();
    }

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects
     * with the given {@link SoundType}.
     *
     * @param type The sound type
     * @return The stop sound effects
     */
    static StopSoundEffects withType(SoundType type) {
        return builder().withType(type).build();
    }

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects
     * played in the given {@link SoundCategory}.
     *
     * @param category The sound category
     * @return The stop sound effects
     */
    static StopSoundEffects withCategory(Supplier<? extends SoundCategory> category) {
        return builder().withCategory(category).build();
    }

    /**
     * Constructs a {@link StopSoundEffects} that stops all sound effects
     * played in the given {@link SoundCategory}.
     *
     * @param category The sound category
     * @return The stop sound effects
     */
    static StopSoundEffects withCategory(SoundCategory category) {
        return builder().withCategory(category).build();
    }

    /**
     * Constructs a new stop sounds effects {@link Builder}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    Optional<SoundType> getType();

    Optional<SoundCategory> getCategory();

    interface Builder extends ResettableBuilder<StopSoundEffects, Builder>, DataBuilder<StopSoundEffects> {

        default Builder withCategory(@Nullable Supplier<? extends SoundCategory> category) {
            return this.withCategory(category == null ? null : category.get());
        }

        Builder withCategory(@Nullable SoundCategory category);

        default Builder withType(@Nullable Supplier<? extends SoundType> type) {
            return this.withType(type == null ? null : type.get());
        }

        Builder withType(@Nullable SoundType type);

        StopSoundEffects build();
    }
}
