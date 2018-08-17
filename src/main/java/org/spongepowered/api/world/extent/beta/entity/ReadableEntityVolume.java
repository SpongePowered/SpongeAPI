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
package org.spongepowered.api.world.extent.beta.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.extent.beta.Volume;
import org.spongepowered.api.world.extent.beta.block.ReadableBlockVolume;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public interface ReadableEntityVolume extends Volume, ReadableBlockVolume {

    /**
     * Gets the entity whose {@link UUID} matches the provided id, possibly
     * returning no entity if the entity is not loaded or non-existent.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method may return no entity if the entity is not
     * loaded.</p>
     *
     * @param uuid The unique id
     * @return An entity, if available
     */
    Optional<Entity> getEntity(UUID uuid);

    /**
     * Return a collection of entities contained within this universe, possibly
     * only returning entities only in loaded areas.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method will only return entities within those loaded
     * parts.</p>
     *
     * @return A collection of entities
     */
    Collection<Entity> getEntities();

    /**
     * Return a collection of entities contained within this universe, possibly
     * only returning entities only in loaded areas. The returned entities are
     * filtered by the given {@link Predicate} before being returned.
     *
     * <p>For world implementations, only some parts of the world is usually
     * loaded, so this method will only return entities within those loaded
     * parts.</p>
     *
     * @param filter The filter to apply to the returned entities
     * @return A collection of filtered entities
     */
    Collection<Entity> getEntities(Predicate<Entity> filter);

    UnmodifiableEntityVolume<?> asUnmodifiableEntityVolume();

    ImmutableEntityVolume asImmutableEntityVolume();

}
