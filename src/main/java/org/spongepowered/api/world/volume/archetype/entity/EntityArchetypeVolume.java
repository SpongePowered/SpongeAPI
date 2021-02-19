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
package org.spongepowered.api.world.volume.archetype.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.world.volume.ImmutableVolume;
import org.spongepowered.api.world.volume.MutableVolume;
import org.spongepowered.api.world.volume.UnmodifiableVolume;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.block.BlockVolume;
import org.spongepowered.api.world.volume.entity.EntityVolume;
import org.spongepowered.api.world.volume.stream.StreamOptions;
import org.spongepowered.api.world.volume.stream.VolumeStream;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * A {@link Volume} that may contain several {@link EntityArchetype}s
 * such that they can be read, modified, and spawned into a {@link EntityVolume.Mutable}
 * via {@link EntityVolume.Mutable#spawnEntity(Entity)}. Note that this volume
 * does NOT guarantee immutability or thread safety. Utilize
 * {@link Unmodifiable}s and possibly
 */
public interface EntityArchetypeVolume extends Volume {

    Collection<EntityArchetype> entityArchetypes();

    Collection<EntityArchetypeEntry> entityArchetypesByPosition();

    Collection<EntityArchetype> entityArchetypes(Predicate<EntityArchetype> filter);

    interface Streamable<B extends Streamable<B>> extends EntityArchetypeVolume {

        /**
         * Gets a {@link VolumeStream}&lt;{@code B, }{@link EntityArchetype}&gt;
         * from this volume such that the {@code min} and {@code max} are contained
         * within this volume.
         *
         * @param min The minimum coordinate set
         * @param max The maximum coordinate set
         * @param options The options to construct the stream
         * @return The volume stream
         */
        VolumeStream<B, EntityArchetype> entityArchetypeStream(Vector3i min, Vector3i max, StreamOptions options);

        /**
         * Gets a {@link Stream}&lt;{@link EntityArchetypeEntry}&gt; from this
         * volume such that possibly multiple {@link EntityArchetype EntityArchetypes}
         * can exist at the same {@link Vector3d coordinate} position. A more precise
         * variation of {@link #entityArchetypeStream(Vector3i, Vector3i, StreamOptions)}
         * that populates the entire stream of existing archetypes, regardless of position.
         * <p>Note that it may be possible the archetypes are returned as copies in the case
         * of an {@link Immutable immutable volume}. It is advisable that
         * mutating the returned archetypes are destined for submission to either a
         * {@link Mutable} or being applied to an {@link EntityVolume.Mutable}
         * directly after the fact.
         *
         * @return The stream
         */
        Stream<EntityArchetypeEntry> entitiesByPosition();

    }

    interface Unmodifiable<U extends Unmodifiable<U>> extends EntityArchetypeVolume,
        UnmodifiableVolume, BlockVolume.Unmodifiable<U>, Streamable<U> {

    }

    interface Mutable<M extends Mutable<M>> extends Streamable<M>, MutableVolume {

        default void addEntity(final EntityArchetype archetype, final Vector3d position) {
            this.addEntity(EntityArchetypeEntry.of(
                Objects.requireNonNull(archetype, "EntityArchetype cannot be null"),
                Objects.requireNonNull(position, "Position cannot be null")
            ));
        }

        void addEntity(EntityArchetypeEntry entry);

    }

    interface Immutable extends Unmodifiable<Immutable>, ImmutableVolume {

    }
}
