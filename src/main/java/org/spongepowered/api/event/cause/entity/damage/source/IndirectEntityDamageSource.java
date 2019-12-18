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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;

public interface IndirectEntityDamageSource extends EntityDamageSource {

    /**
     * Creates a new {@link Builder} for constructing
     * {@link IndirectEntityDamageSource}s.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link Entity} that is indirectly using the {@link #getSource()}
     * to cause damage.
     *
     * @return The indirect source
     */
    Entity getIndirectSource();

    interface Builder extends AbstractBuilder<IndirectEntityDamageSource, Builder> {

    }

    interface AbstractBuilder<T extends IndirectEntityDamageSource, B extends AbstractBuilder<T, B>> extends EntityDamageSourceBuilder<T, B> {

        /**
         * Sets the {@link Entity} that is indirectly damaging.
         *
         * @param proxy The indirect entity
         * @return This builder, for chaining
         */
        B proxySource(Entity proxy);

    }
}
