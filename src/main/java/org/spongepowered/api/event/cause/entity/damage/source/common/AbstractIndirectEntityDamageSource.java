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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.IndirectEntityDamageSource;

import java.util.Objects;

public abstract class AbstractIndirectEntityDamageSource implements IndirectEntityDamageSource {

    private final DamageType apiDamageType;
    private final boolean absolute;
    private final boolean bypassesArmor;
    private final boolean scales;
    private final boolean explosive;
    private final boolean magic;
    private final boolean creative;
    private final double exhaustion;
    private final Entity source;
    private final Entity indirect;

    protected AbstractIndirectEntityDamageSource(AbstractIndirectEntityDamageSourceBuilder<?, ?> builder) {
        this.apiDamageType = Objects.requireNonNull(builder.damageType, "DamageType cannot be null!");
        this.absolute = builder.absolute;
        this.bypassesArmor = builder.bypasses;
        this.scales = builder.scales;
        this.explosive = builder.explosion;
        this.magic = builder.magical;
        this.creative = builder.creative;
        if (builder.exhaustion != null) {
            this.exhaustion = builder.exhaustion;
        } else if (this.absolute || this.bypassesArmor) {
            this.exhaustion = 0.0;
        } else {
            this.exhaustion = 0.1;
        }
        this.source = Objects.requireNonNull(builder.sourceEntity, "Entity source cannot be null!");
        this.indirect = Objects.requireNonNull(builder.indirect, "Indirect source cannot be null!");
    }

    @Override
    public Entity getSource() {
        return this.source;
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

    @Override
    public Entity getIndirectSource() {
        return this.indirect;
    }

    @Override
    public double getExhaustion() {
        return this.exhaustion;
    }

    @SuppressWarnings("unchecked")
    public abstract static class AbstractIndirectEntityDamageSourceBuilder<T extends IndirectEntityDamageSource,
            B extends IndirectEntityDamageSource.AbstractBuilder<T, B>>
            extends AbstractEntityDamageSource.AbstractEntityDamageSourceBuilder<T, B>
            implements IndirectEntityDamageSource.AbstractBuilder<T, B> {

        protected Entity sourceEntity;
        protected Entity indirect;

        @Override
        public B entity(Entity entity) {
            this.sourceEntity = Objects.requireNonNull(entity, "Entity source cannot be null!");
            return (B) this;
        }


        @Override
        public B proxySource(Entity projectile) {
            this.indirect = Objects.requireNonNull(projectile);
            return (B) this;
        }

        @Override
        public B reset() {
            super.reset();
            this.sourceEntity = null;
            this.indirect = null;
            return (B) this;
        }
    }
}
