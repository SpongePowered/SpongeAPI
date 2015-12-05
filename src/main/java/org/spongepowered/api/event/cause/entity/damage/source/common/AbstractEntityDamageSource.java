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

public abstract class AbstractEntityDamageSource extends AbstractDamageSource implements EntityDamageSource {

    private final Entity source;

    protected AbstractEntityDamageSource(AbstractEntityDamageSourceBuilder builder) {
        super(builder);
        this.source = checkNotNull(builder.source, "Entity source cannot be null!");
    }

    @Override
    public Entity getSource() {
        return this.source;
    }

    public static abstract class AbstractEntityDamageSourceBuilder extends AbstractDamageSourceBuilder implements EntityDamageSource.Builder {

        private Entity source;

        @Override
        public EntityDamageSource.Builder entity(Entity entity) {
            this.source = checkNotNull(entity, "Entity source cannot be null!");
            return this;
        }

        @Override
        public EntityDamageSource.Builder scalesWithDifficulty() {
            super.scalesWithDifficulty();
            return this;
        }

        @Override
        public EntityDamageSource.Builder bypassesArmor() {
            super.bypassesArmor();
            return this;
        }

        @Override
        public EntityDamageSource.Builder explosion() {
            super.explosion();
            return this;
        }

        @Override
        public EntityDamageSource.Builder absolute() {
            super.absolute();
            return this;
        }

        @Override
        public EntityDamageSource.Builder magical() {
            super.magical();
            return this;
        }

        @Override
        public EntityDamageSource.Builder creative() {
            super.creative();
            return this;
        }

        @Override
        public EntityDamageSource.Builder type(DamageType damageType) {
            super.type(damageType);
            return this;
        }

        @Override
        public EntityDamageSource.Builder reset() {
            super.reset();
            this.source = null;
            return this;
        }
    }
}
