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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.type.NotePitch;

/**
 * Represents a particle effect that uses a note value.
 */
public interface NoteParticle extends ParticleEffect {

    /**
     * Creates a new {@link Builder} to build a {@link NoteParticle}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }


    /**
     * Gets the note value of the particle effect.
     *
     * <p>The value scales between 0 and 24.</p>
     *
     * @return The note value
     */
    NotePitch getNote();

    /**
     * Represents a particle builder to create a {@link NoteParticle}.
     */
    interface Builder extends ParticleEffect.ParticleBuilder<NoteParticle, ParticleType.Note, Builder> {

        /**
         * Sets the note value of the particle effect.
         *
         * <p>The value scales between 0 and 24.</p>
         * <p>The default note value is retrieved from the note particle type,
         * by using {@link ParticleType.Note#getDefaultNote()}.</p>
         *
         * @param note The note
         * @return This builder
         */
        Builder note(NotePitch note);

    }
}
