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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.effect.PlayableEffect;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.function.Supplier;

/**
 * Represents a sound effect that can be played.
 */
public interface SoundEffect extends PlayableEffect, DataSerializable {

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param category The category
     * @param volume The volume
     * @param pitch The pitch
     * @return The sound effect
     */
    static SoundEffect of(SoundType type, SoundCategory category, double volume, double pitch) {
        return builder().type(type).category(category).volume(volume).pitch(pitch).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param category The category
     * @param volume The volume
     * @return The sound effect
     */
    static SoundEffect of(SoundType type, SoundCategory category, double volume) {
        return builder().type(type).category(category).volume(volume).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param category The category
     * @param volume The volume
     * @param pitch The pitch
     * @return The sound effect
     */
    static SoundEffect of(Supplier<? extends SoundType> type, SoundCategory category, double volume, double pitch) {
        return builder().type(type).category(category).volume(volume).pitch(pitch).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param category The category
     * @param volume The volume
     * @return The sound effect
     */
    static SoundEffect of(Supplier<? extends SoundType> type, SoundCategory category, double volume) {
        return builder().type(type).category(category).volume(volume).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param category The category
     * @param volume The volume
     * @param pitch The pitch
     * @return The sound effect
     */
    static SoundEffect of(Supplier<? extends SoundType> type, Supplier<? extends SoundCategory> category, double volume, double pitch) {
        return builder().type(type).category(category).volume(volume).pitch(pitch).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param category The category
     * @param volume The volume
     * @return The sound effect
     */
    static SoundEffect of(Supplier<? extends SoundType> type, Supplier<? extends SoundCategory> category, double volume) {
        return builder().type(type).category(category).volume(volume).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param category The category
     * @param volume The volume
     * @param pitch The pitch
     * @return The sound effect
     */
    static SoundEffect of(SoundType type, Supplier<? extends SoundCategory> category, double volume, double pitch) {
        return builder().type(type).category(category).volume(volume).pitch(pitch).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param category The category
     * @param volume The volume
     * @return The sound effect
     */
    static SoundEffect of(SoundType type, Supplier<? extends SoundCategory> category, double volume) {
        return builder().type(type).category(category).volume(volume).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param volume The volume
     * @param pitch The pitch
     * @return The sound effect
     */
    static SoundEffect of(SoundType type, double volume, double pitch) {
        return builder().type(type).volume(volume).pitch(pitch).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param volume The volume
     * @return The sound effect
     */
    static SoundEffect of(SoundType type, double volume) {
        return builder().type(type).volume(volume).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param volume The volume
     * @param pitch The pitch
     * @return The sound effect
     */
    static SoundEffect of(Supplier<? extends SoundType> type, double volume, double pitch) {
        return builder().type(type).volume(volume).pitch(pitch).build();
    }

    /**
     * Constructs a new {@link SoundEffect}.
     *
     * @param type The type
     * @param volume The volume
     * @return The sound effect
     */
    static SoundEffect of(Supplier<? extends SoundType> type, double volume) {
        return builder().type(type).volume(volume).build();
    }

    /**
     * Gets a new {@link SoundEffect} builder.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link SoundType} of the effect.
     *
     * @return The sound type
     */
    SoundType getType();

    /**
     * Gets the {@link SoundCategory} to play the sound in.
     *
     * @return The sound category
     */
    SoundCategory getCategory();

    /**
     * The volume to play the sound at, usually between 0 and 2.
     *
     * @return The volume
     */
    double getVolume();

    /**
     * The modulation of the sound to play at, usually between 0 and 2.
     *
     * @return The pitch
     */
    double getPitch();

    /**
     * A builder for {@link SoundEffect}s.
     */
    interface Builder extends ResettableBuilder<SoundEffect, Builder>, DataBuilder<SoundEffect> {

        /**
         * Sets the {@link SoundType} of the effect.
         *
         * @param type The sound type
         * @return This builder, for chaining
         */
        default Builder type(Supplier<? extends SoundType> type) {
            return this.type(type.get());
        }

        /**
         * Sets the {@link SoundType} of the effect.
         *
         * @param type The sound type
         * @return This builder, for chaining
         */
        Builder type(SoundType type);

        /**
         * Sets the {@link SoundCategory} to play the sound in.
         *
         * <p>Defaults to {@link SoundCategories#MASTER}.</p>
         *
         * @param category The sound category
         * @return This builder, for chaining
         */
        default Builder category(Supplier<? extends SoundCategory> category) {
            return this.category(category.get());
        }

        /**
         * Sets the {@link SoundCategory} to play the sound in.
         *
         * @param category The sound category
         * @return This builder, for chaining
         */
        Builder category(SoundCategory category);

        /**
         * Sets the volume to play the sound at, usually between 0 and 2.
         *
         * @param volume The volume
         * @return This builder, for chaining
         */
        Builder volume(double volume);

        /**
         * Sets the modulation of the sound to play at, usually between 0 and 2.
         *
         * <p>Defaults to 1.</p>
         *
         * @param pitch The pitch
         * @return This builder, for chaining
         */
        Builder pitch(double pitch);

        /**
         * Builds the {@link SoundEffect}.
         *
         * @return The sound effect
         */
        SoundEffect build();
    }
}
