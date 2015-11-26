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
package org.spongepowered.api.event.cause.entity.damage.source;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.cause.entity.damage.DamageType;

public interface IndirectEntityDamageSource extends EntityDamageSource {

    /**
     * Gets the {@link Entity} that is indirectly using the {@link #getSource()}
     * to cause damage.
     *
     * @return The indirect source
     */
    Entity getIndirectSource();

    interface Builder extends EntityDamageSource.Builder {

        @Override
        Builder scalesWithDifficulty();

        @Override
        Builder bypassesArmor();

        @Override
        Builder explosion();

        @Override
        Builder absolute();

        @Override
        Builder magical();

        @Override
        Builder creative();

        @Override
        Builder entity(Entity entity);

        @Override
        Builder type(DamageType damageType);

        Builder proxySource(Entity projectile);

        @Override
        IndirectEntityDamageSource build() throws IllegalStateException;

        @Override
        Builder reset();
    }
}
