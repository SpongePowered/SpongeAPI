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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Result;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.CauseTracked;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Raised when entities are spawned.
 */
public class EntitySpawnEvent extends AbstractEventEntity implements CauseTracked {

    private final Cause cause;
    private Result result = Result.DEFAULT;

    /**
     * Create a new instance.
     *
     * @param entities A list of entities
     * @param cause The cause
     */
    public EntitySpawnEvent(List<Entity> entities, Cause cause) {
        super(entities);
        checkNotNull(cause);
        this.cause = cause;
    }

    @Override
    public Cause getCause() {
        return cause;
    }

    @Override
    public boolean isCancellable() {
        return true;
    }

    @Override
    public Result getResult() {
        return result;
    }

    @Override
    public void setResult(Result result) {
        checkNotNull(result);
        this.result = result;
    }

}
