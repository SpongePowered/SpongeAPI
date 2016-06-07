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
package org.spongepowered.api.event.cause.entity.spawn.common;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.event.cause.entity.spawn.BlockSpawnCause;
import org.spongepowered.api.event.cause.entity.spawn.BlockSpawnCause.BlockSpawnCauseBuilder;
import org.spongepowered.api.event.cause.entity.spawn.EntitySpawnCause;

@SuppressWarnings("unchecked")
public abstract class AbstractBlockSpawnCauseBuilder<T extends BlockSpawnCause, B extends BlockSpawnCauseBuilder<T, B>>
        extends AbstractSpawnCauseBuilder<T, B> implements BlockSpawnCauseBuilder<T, B> {

    protected BlockSnapshot blockSnapshot;

    protected AbstractBlockSpawnCauseBuilder() {

    }

    @Override
    public B block(BlockSnapshot blockSnapshot) {
        this.blockSnapshot = checkNotNull(blockSnapshot, "BlockSnapshot cannot be null!");
        return (B) this;
    }

    @Override
    public B from(T value) {
        this.spawnType = checkNotNull(value, "SpawnCause cannot be null!").getType();
        this.blockSnapshot = value.getBlockSnapshot();
        return (B) this;
    }

    @Override
    public B reset() {
        super.reset();
        this.blockSnapshot = null;
        return (B) this;
    }
}
