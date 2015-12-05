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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;

/**
 * An abstract implementation of {@link DamageSource} to allow plugins to create
 * their own damage sources without having to implement all the required methods.
 *
 * <p>Note that extending this class at the least is a requirement for custom
 * damage sources as not doing so will simply not work.</p>
 */
public abstract class AbstractDamageSource implements DamageSource {

    private final DamageType apiDamageType;
    private final boolean absolute;
    private final boolean bypassesArmor;
    private final boolean scales;
    private final boolean explosive;
    private final boolean magic;
    private final boolean creative;

    protected AbstractDamageSource(AbstractDamageSourceBuilder builder) {
        this.apiDamageType = checkNotNull(builder.damageType, "DamageType cannot be null!");
        this.absolute = builder.absolute;
        this.bypassesArmor = builder.bypassesArmor;
        this.scales = builder.scales;
        this.explosive = builder.explosive;
        this.magic = builder.magic;
        this.creative = builder.creative;
    }

    @Override
    public DamageType getType() {
        return this.apiDamageType;
    }

    @Override
    public boolean isAbsolute() {
        return this.absolute;
    }

    @Override
    public boolean isBypassingArmor() {
        return this.bypassesArmor;
    }

    @Override
    public boolean isScaledByDifficulty() {
        return this.scales;
    }

    @Override
    public boolean isExplosive() {
        return this.explosive;
    }

    @Override
    public boolean isMagic() {
        return this.magic;
    }

    @Override
    public boolean doesAffectCreative() {
        return this.creative;
    }

    public static abstract class AbstractDamageSourceBuilder implements DamageSource.Builder {

        private DamageType damageType;
        private boolean absolute;
        private boolean bypassesArmor;
        private boolean scales;
        private boolean explosive;
        private boolean magic;
        private boolean creative;

        @Override
        public Builder scalesWithDifficulty() {
            this.scales = true;
            return this;
        }

        @Override
        public Builder bypassesArmor() {
            this.bypassesArmor = true;
            return this;
        }

        @Override
        public Builder explosion() {
            this.explosive = true;
            return this;
        }

        @Override
        public Builder absolute() {
            this.absolute = true;
            return this;
        }

        @Override
        public Builder magical() {
            this.magic = true;
            return this;
        }

        @Override
        public Builder creative() {
            this.creative = true;
            return this;
        }

        @Override
        public Builder type(DamageType damageType) {
            this.damageType = checkNotNull(damageType, "DamageType cannot be null!");
            return this;
        }

        @Override
        public Builder reset() {
            this.damageType = null;
            this.absolute = false;
            this.bypassesArmor = false;
            this.explosive = false;
            this.magic = false;
            this.creative = false;
            return this;
        }
    }
}
