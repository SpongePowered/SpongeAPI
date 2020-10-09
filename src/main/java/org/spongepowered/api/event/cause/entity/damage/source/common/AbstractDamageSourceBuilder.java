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
package org.spongepowered.api.event.cause.entity.damage.source.common;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;

import java.util.Objects;

@SuppressWarnings("unchecked")
public abstract class AbstractDamageSourceBuilder<T extends DamageSource, B extends DamageSource.DamageSourceBuilder<T, B>>
    implements DamageSource.DamageSourceBuilder<T, B> {

    protected boolean scales = false;
    protected boolean bypasses = false;
    protected boolean explosion = false;
    protected boolean absolute = false;
    protected boolean magical = false;
    protected boolean creative = false;
    protected boolean fire = false;
    @Nullable protected Double exhaustion = null;
    protected DamageType damageType = null;

    @Override
    public B fire() {
        this.fire = true;
        return (B) this;
    }

    @Override
    public B scalesWithDifficulty() {
        this.scales = true;
        return (B) this;
    }

    @Override
    public B bypassesArmor() {
        this.bypasses = true;
        return (B) this;
    }

    @Override
    public B explosion() {
        this.explosion = true;
        return (B) this;
    }

    @Override
    public B absolute() {
        this.absolute = true;
        return (B) this;
    }

    @Override
    public B magical() {
        this.magical = true;
        return (B) this;
    }

    @Override
    public B creative() {
        this.creative = true;
        return (B) this;
    }

    @Override
    public B exhaustion(final double exhaustion) {
        this.exhaustion = exhaustion;
        return (B) this;
    }

    @Override
    public B type(final DamageType damageType) {
        this.damageType = Objects.requireNonNull(damageType, "DamageType cannot be null!");
        return (B) this;
    }

    @Override
    public B from(final T value) {
        reset();
        this.scales = value.isScaledByDifficulty();
        this.absolute = value.isAbsolute();
        this.bypasses = value.isBypassingArmor();
        this.explosion = value.isExplosive();
        this.creative = value.doesAffectCreative();
        this.magical = value.isMagic();
        this.exhaustion = value.getExhaustion();
        this.damageType = value.getType();
        return (B) this;
    }

    @Override
    public B reset() {
        this.scales = false;
        this.bypasses = false;
        this.explosion = false;
        this.absolute = false;
        this.magical = false;
        this.creative = false;
        this.exhaustion = null;
        this.damageType = null;
        return (B) this;
    }
}
