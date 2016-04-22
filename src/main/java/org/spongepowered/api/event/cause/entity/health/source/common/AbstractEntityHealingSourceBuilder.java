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
package org.spongepowered.api.event.cause.entity.health.source.common;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.health.source.EntityHealingSource;

public abstract class AbstractEntityHealingSourceBuilder<T extends EntityHealingSource,
        B extends EntityHealingSource.EntityHealingSourceBuilder<T, B>> extends AbstractHealingSourceBuilder<T, B>
        implements EntityHealingSource.EntityHealingSourceBuilder<T, B> {

    protected Entity entity;

    @SuppressWarnings("unchecked")
    @Override
    public B from(T value) {
        super.from(value);
        this.entity = value.getSource();
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public B reset() {
        super.reset();
        this.entity = null;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public B entity(Entity entity) {
        this.entity = checkNotNull(entity, "Entity cannot be null!");
        return (B) this;
    }
}
