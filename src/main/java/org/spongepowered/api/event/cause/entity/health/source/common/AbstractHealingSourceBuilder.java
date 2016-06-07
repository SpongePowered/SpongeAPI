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

import org.spongepowered.api.event.cause.entity.health.HealingType;
import org.spongepowered.api.event.cause.entity.health.source.HealingSource;

@SuppressWarnings("unchecked")
public abstract class AbstractHealingSourceBuilder<T extends HealingSource, B extends HealingSource.HealingSourceBuilder<T, B>> implements
        HealingSource.HealingSourceBuilder<T, B> {

    protected boolean scales = false;
    protected boolean magical = false;
    protected HealingType healingType = null;

    @Override
    public B scalesWithDifficulty() {
        this.scales = true;
        return (B) this;
    }

    @Override
    public B magical() {
        this.magical = true;
        return (B) this;
    }

    @Override
    public B type(HealingType healingType) {
        this.healingType = checkNotNull(healingType, "Healingtype cannot be null!");
        return (B) this;
    }

    @Override
    public B from(T value) {
        reset();
        this.scales = value.isDifficultyScaled();
        this.magical = value.isMagic();
        this.healingType = value.getHealingType();
        return (B) this;
    }

    @Override
    public B reset() {
        this.scales = false;
        this.magical = false;
        this.healingType = null;
        return (B) this;
    }
}
