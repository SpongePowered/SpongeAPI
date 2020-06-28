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
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.entity.MutableEntityVolume;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * A {@link Volume} that may contain several {@link EntityArchetype}s
 * such that they can be read, modified, and spawned into a {@link MutableEntityVolume}
 * via {@link MutableEntityVolume#spawnEntity(Entity)}. Note that this volume
 * does NOT guarantee immutability or thread safety. Utilize
 * {@link UnmodifiableEntityArchetypeVolume}s and possibly
 */
public interface ReadableEntityArchetypeVolume extends Volume {

    Collection<EntityArchetype> getEntityArchetypes();

    Collection<EntityArchetype> getEntityArchetypes(Predicate<EntityArchetype> filter);

    UnmodifiableEntityArchetypeVolume<?> asUnmodifiableEntityArchetypeVolume();

    ImmutableEntityArchetypeVolume asImmutableEntityArchetypeVolume();

}
