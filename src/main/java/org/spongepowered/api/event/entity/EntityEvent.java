/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.event.entity;

import com.google.common.base.Predicate;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.GameEvent;

import java.util.List;

/**
 * An event that whose targets happen to be an entity.
 */
public interface EntityEvent extends GameEvent {

    /**
     * Get a list of affected entities.
     *
     * <p>The list of entities is immutable if {@link #isCancellable()}
     * is {@code false}. Otherwise, the effect of removing an entity from
     * the list is dependent on the event, though it may "cancel" the event
     * for the removed entity (i.e. if it's a spawn entity event, then the
     * entity would not be spawned).</p>
     *
     * @return An list of entities
     */
    List<Entity> getEntities();

    /**
     * Apply the given predicate to the list of entities.
     *
     * <p>The given predicate should return {@code true} by default, and
     * return {@code false} to remove the entity from the list
     * of entities (if the list mutable -- see {@link #getEntities()}
     * for more information).</p>
     *
     * @param predicate A predicate that returns false to remove the given entity
     */
    void filter(Predicate<Entity> predicate);

}
