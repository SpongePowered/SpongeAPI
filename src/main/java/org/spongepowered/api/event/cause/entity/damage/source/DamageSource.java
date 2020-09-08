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
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.DamageTypes;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.difficulty.Difficulty;

import java.util.function.Supplier;

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

    /**
     * Creates a new {@link Builder builder} to build a {@link DamageSource}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link DamageType} of this source.
     *
     * @return The damage type
     */
    DamageType getType();

    /**
     * Gets whether this {@link DamageSource}'s damage is absolute and
     * will ignore potion effects and enchantments.
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

    /**
     * Gets whether this {@link DamageSource} is considered to damage creative, or
     * otherwise "normally unharmable" players. Usually associated with
     * {@link DamageTypes#VOID}.
     *
     * @return If this damage should affect creative players
     */
    boolean doesAffectCreative();

    /**
     * Gets whether this {@link DamageSource} is considered to be "fire" based,
     * can be from flames or blocks that are flaming, or the entity being on fire.
     * Usually is possible to bypass or ignore this damage if the owning entity has
     * {@link org.spongepowered.api.effect.potion.PotionEffectTypes#FIRE_RESISTANCE}
     * active.
     *
     * @return If this damage is considered fire
     */
    boolean isFire();

    /**
     * Gets the amount of exhaustion this {@link DamageSource} will
     * add to the entity, generally only to players.
     *
     * <p>In vanilla gameplay this is set to 0.1 by default and
     * overridden to 0 if the source is set to be absolute or
     * as overriding armor.</p>
     *
     * @return The increase in exhaustion
     */
    double getExhaustion();

    interface Builder extends DamageSourceBuilder<DamageSource, Builder> { }

    interface DamageSourceBuilder<T extends DamageSource, B extends DamageSourceBuilder<T, B>> extends CopyableBuilder<T, B> {

        /**
         * Sets this {@link DamageSource}'s damage to be considered "fire" damage.
         *
         * @return This builder
         */
        B fire();

        /**
         * Sets this {@link DamageSource}'s damage to be scaled
         * by {@link Difficulty}.
         *
         * @return This builder
         */
        B scalesWithDifficulty();

        /**
         * Sets this {@link DamageSource} as dealing damage that
         * bypasses armor modifiers.
         *
         * <p>This sets the exhaustion increase caused
         * by this source to 0. You can override this
         * with {@link #exhaustion(double)}.</p>
         *
         * @return This builder
         */
        B bypassesArmor();

        /**
         * Sets this {@link DamageSource} as an explosion.
         *
         * @return This builder
         */
        B explosion();


        /**
         * Sets whether this {@link DamageSource}'s damage is absolute and
         * will ignore potion effects and enchantments.
         *
         * <p>This sets the exhaustion increase caused
         * by this source to 0. You can override this
         * with {@link #exhaustion(double)}.</p>
         *
         * @return This builder
         */
        B absolute();

        /**
         * Sets this {@link DamageSource} as considered to be magical
         * damage. An example is potions.
         *
         * @return This builder
         */
        B magical();

        /**
         * Sets this {@link DamageSource} as considered to damage creative, or
         * otherwise "normally unharmable" players.
         *
         * @return This builder
         */
        B creative();

        /**
         * Sets the amount of exhaustion this {@link DamageSource} will
         * add to the entity, generally only to players.
         *
         * <p>In vanilla gameplay, the default is 0.1, unless if the damage
         * is absolute or bypasses armor, where the exhaustion gets set to 0.
         * This builder follows this mechanic, but if you set the exhaustion
         * through this method that will be overridden.</p>
         *
         * <p>If you don't set this exhaustion manually, calling
         * {@link #absolute()} or {@link #bypassesArmor()} will
         * set this 0 and if you don't this will default to 0.1.</p>
         *
         * @param exhaustion The amount of exhaustion to add to the entity
         * @return This builder
         */
        B exhaustion(double exhaustion);

        /**
         * Sets the {@link DamageType} of this source.
         *
         * <p>This is required to be set.</p>
         *
         * @param damageType The desired damage type
         * @return This builder
         */
        default B type(Supplier<? extends DamageType> damageType) {
            return this.type(damageType.get());
        }

        /**
         * Sets the {@link DamageType} of this source.
         *
         * <p>This is required to be set.</p>
         *
         * @param damageType The desired damage type
         * @return This builder
         */
        B type(DamageType damageType);

        /**
         * Builds an instance of this damage source, based on
         * the values you inputted into the builder.
         *
         * @return The resulting damage source
         * @throws IllegalStateException If a value required to be set
         *     is not set
         */
        T build() throws IllegalStateException;

    }
}
