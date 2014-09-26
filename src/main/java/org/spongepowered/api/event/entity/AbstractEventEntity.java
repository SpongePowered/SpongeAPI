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
import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * An abstract implementation of entity events.
 */
public abstract class AbstractEventEntity implements EntityEvent {

    private final Game game;
    private final List<Entity> entities;

    /**
     * Create a new instance.
     *
     * @param game The game
     * @param entities A list of entities
     */
    public AbstractEventEntity(Game game, List<Entity> entities) {
        checkNotNull(game);
        checkNotNull(entities);
        this.game = game;
        this.entities = entities;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public List<Entity> getEntities() {
        return isCancellable() ? entities : Collections.unmodifiableList(entities);
    }

    @Override
    public void filter(Predicate<Entity> predicate) {
        Iterator<Entity> it = entities.iterator();
        boolean canRemove = isCancellable();
        while (it.hasNext()) {
            if (!predicate.apply(it.next()) && canRemove) {
                it.remove();
            }
        }
    }

}
