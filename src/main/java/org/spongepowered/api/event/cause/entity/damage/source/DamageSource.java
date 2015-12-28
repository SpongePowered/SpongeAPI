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
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.difficulty.Difficulty;

/**
 * Represents a {@link Cause} for damage on the {@link Entity} being
 * damaged. Usually the {@link DamageSource} will have different properties
 * based on the source of damage, such as {@link EntityDamageSource}s,
 * {@link BlockDamageSource}s, and {@link FallingBlockDamageSource}s.
 *
 * <p>Almost always, the {@link DamageSource} will be the first element in
 * the {@link Cause} of the event. Any additional modifiers that "aid" the
 * {@link Cause} of the event will be listed subsequently.</p>
 */
public interface DamageSource {

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link DamageType} of this source.
     *
     * @return The damage type
     */
    DamageType getType();

    /**
     * Gets whether this {@link DamageSource} can not be modified and the
     * damage is absolute.
     *
     * @return If this damage source deals absolute damage
     */
    boolean isAbsolute();

    /**
     * Gets whether this {@link DamageSource} will deal damage that
     * bypasses any armor.
     *
     * @return True if this damage source bypasses armor
     */
    boolean isBypassingArmor();

    /**
     * Gets whether this {@link DamageSource}'s damage is scaled by
     * {@link Difficulty}.
     *
     * @return True if the damage from this source is scaled
     */
    boolean isScaledByDifficulty();

    /**
     * Gets whether this {@link DamageSource} is an explosion.
     *
     * @return True if this damage source is an explosion
     */
    boolean isExplosive();

    /**
     * Gets whether this {@link DamageSource} is considered to be magical
     * damage, such as potions, or other sources.
     *
     * @return If this damage is magic based
     */
    boolean isMagic();

    boolean doesAffectCreative();

    interface Builder extends DamageSourceBuilder<DamageSource, Builder> { }

    interface DamageSourceBuilder<T extends DamageSource, B extends DamageSourceBuilder<T, B>> extends ResettableBuilder<T, B> {

        B scalesWithDifficulty();

        B bypassesArmor();

        B explosion();

        B absolute();

        B magical();

        B creative();

        B type(DamageType damageType);

        T build() throws IllegalStateException;

    }
}
