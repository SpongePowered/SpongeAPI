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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource;
import org.spongepowered.api.event.cause.entity.damage.source.IndirectEntityDamageSource;

public abstract class AbstractIndirectEntityDamageSource implements IndirectEntityDamageSource {

    private final DamageType apiDamageType;
    private final boolean absolute;
    private final boolean bypassesArmor;
    private final boolean scales;
    private final boolean explosive;
    private final boolean magic;
    private final boolean creative;
    private final Entity source;
    private final Entity indirect;

    protected AbstractIndirectEntityDamageSource(AbstractIndirectEntityDamageSourceBuilder<?, ?> builder) {
        this.apiDamageType = checkNotNull(builder.damageType, "DamageType cannot be null!");
        this.absolute = builder.absolute;
        this.bypassesArmor = builder.bypasses;
        this.scales = builder.scales;
        this.explosive = builder.explosion;
        this.magic = builder.magical;
        this.creative = builder.creative;
        this.source = checkNotNull(builder.source, "Entity source cannot be null!");
        this.indirect = checkNotNull(builder.indirect, "Indirect source cannot be null!");
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

    @SuppressWarnings("unchecked")
    public static abstract class AbstractIndirectEntityDamageSourceBuilder<T extends IndirectEntityDamageSource, B extends AbstractIndirectEntityDamageSourceBuilder<T, B>>
        extends AbstractEntityDamageSource.AbstractEntityDamageSourceBuilder<T,
        B> implements IndirectEntityDamageSource.AbstractBuilder<T, B> {

        Entity source;
        Entity indirect;

        @Override
        public B entity(Entity entity) {
            this.source = checkNotNull(entity, "Entity source cannot be null!");
            return (B) this;
        }


        @Override
        public B proxySource(Entity projectile) {
            this.indirect = checkNotNull(projectile);
            return (B) this;
        }

        @Override
        public B reset() {
            super.reset();
            this.source = null;
            this.indirect = null;
            return (B) this;
        }
    }
}
