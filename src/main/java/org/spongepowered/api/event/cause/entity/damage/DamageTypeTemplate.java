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
package org.spongepowered.api.event.cause.entity.damage;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.util.DataPackEntryBuilder;

/**
 * A template for {@link DamageType damage types}.
 */

public interface DamageTypeTemplate extends DataPackEntry<DamageTypeTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    /**
     * Returns the damage type
     *
     * @return the damage type
     */
    DamageType type();


    interface Builder extends DataPackEntryBuilder<DamageType, DamageTypeTemplate, Builder> {

        /**
         * Sets the name of the {@link DamageType}.
         * Used as part of the death message translation key.
         * TODO falling/intentional game design?
         *
         * @param name The name
         *
         * @return This builder, for chaining
         */
        Builder name(String name);

        /**
         * Sets damage scaling
         *
         * @param scaling the daamge scaling
         *
         * @return This builder
         */
        Builder scaling(DamageScaling scaling);

        /**
         * Sets damage effects
         *
         * @param effect the damage effect
         *
         * @return This builder
         */
        Builder effect(DamageEffect effect);

        /**
         * Sets the amount of exhaustion a {@link DamageSource} of this type will
         * add to the entity, generally only to players.
         *
         * TODO check if this is still correct
         * <p>In vanilla gameplay, the default is 0.1, unless if the damage
         * is absolute or bypasses armor, where the exhaustion gets set to 0.
         * </p>
         *
         * @param exhaustion The amount of exhaustion to add to the entity
         * @return This builder
         */
        Builder exhaustion(double exhaustion);

    }

}
