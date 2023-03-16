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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.cause.entity.damage.DamageScaling;
import org.spongepowered.api.event.cause.entity.damage.DamageScalings;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.DamageTypes;
import org.spongepowered.api.tag.DamageTypeTags;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.math.vector.Vector3d;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * Represents a {@link Cause} for damage on the {@link Entity} being
 * damaged. Usually the {@link DamageSource} will have different properties
 * based on the {@link DamageType} and its ascociated {@link org.spongepowered.api.tag.Tag<DamageType> tags}
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
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Gets the {@link DamageType} of this source.
     *
     * @return The damage type
     */
    DamageType type();

    /**
     * Gets whether this {@link DamageSource}'s damage is absolute and
     * will ignore potion effects and enchantments.
     *
     * @return If this damage source deals absolute damage
     */
    @Deprecated
    default boolean isAbsolute() {
        return this.type().is(DamageTypeTags.BYPASSES_EFFECTS) && this.type().is(DamageTypeTags.BYPASSES_ENCHANTMENTS) ;
    }

    /**
     * Gets whether this {@link DamageSource} will deal damage that
     * bypasses any armor.
     *
     * @return True if this damage source bypasses armor
     */
    default boolean isBypassingArmor() {
        return this.type().is(DamageTypeTags.BYPASSES_ARMOR);
    }

    /**
     * Gets whether this {@link DamageSource}'s damage is scaled by
     * {@link Difficulty}.
     *
     * @return True if the damage from this source is scaled
     */
    default boolean isScaledByDifficulty() {
        final DamageScaling scaling = this.type().scaling();
        return !DamageScalings.NEVER.get().equals(scaling);
    }

    /**
     * Gets whether this {@link DamageSource} is an explosion.
     *
     * @return True if this damage source is an explosion
     */
    default boolean isExplosive() {
        return this.type().is(DamageTypeTags.IS_EXPLOSION);
    }

    /**
     * Gets whether this {@link DamageSource} is considered to be magical
     * damage, such as potions, or other sources.
     *
     * @return If this damage is magic based
     */
    default boolean isMagic() {
        // TODO replace with BYPASSES_EFFECTS/BYPASSES_RESISTANCE/BYPASS_ARMOR
        return this.type().equals(DamageTypes.MAGIC.get());
    }

    /**
     * Gets whether this {@link DamageSource} is considered to damage creative, or
     * otherwise "normally unharmable" players. Usually associated with
     * {@link DamageTypes#OUT_OF_WORLD}.
     *
     * @return If this damage should affect creative players
     */
    boolean doesAffectCreative(); // TODO?

    /**
     * Gets whether this {@link DamageSource} is considered to be "fire" based,
     * can be from flames or blocks that are flaming, or the entity being on fire.
     * Usually is possible to bypass or ignore this damage if the owning entity has
     * {@link org.spongepowered.api.effect.potion.PotionEffectTypes#FIRE_RESISTANCE}
     * active.
     *
     * @return If this damage is considered fire
     */
    default boolean isFire() {
        return this.type().is(DamageTypeTags.IS_FIRE);
    }

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
    default double exhaustion(){
        return this.type().exhaustion();
    }
    /**
     * Gets the {@link Entity} that is the source.
     * <p>
     * Note that a {@link org.spongepowered.api.entity.FallingBlock falling block entity} has some
     * additional information available as data including
     * - {@link org.spongepowered.api.data.Keys#DAMAGE_PER_BLOCK}
     * - {@link org.spongepowered.api.data.Keys#MAX_FALL_DAMAGE}
     * - {@link org.spongepowered.api.data.Keys#CAN_HURT_ENTITIES}
     * - {@link org.spongepowered.api.data.Keys#FALL_TIME}
     * - {@link org.spongepowered.api.data.Keys#CAN_DROP_AS_ITEM}
     * - {@link org.spongepowered.api.data.Keys#CAN_PLACE_AS_BLOCK}
     * </p>
     *
     * @return The entity source
     */
    Optional<Entity> source();

    /**
     * Gets the {@link Entity} that is indirectly using the {@link #source()}
     * to cause damage.
     *
     * @return The indirect source
     */
    Optional<Entity> indirectSource();

    Optional<Vector3d> position();

    /**
     * Gets the location of the {@link BlockSnapshot}.
     *
     * @return The location of the block
     */
    Optional<ServerLocation> location();

    /**
     * Gets the {@link BlockSnapshot} of the source.
     *
     * @return The block snapshot of the source
     */
    Optional<BlockSnapshot> blockSnapshot();


    interface Builder extends org.spongepowered.api.util.Builder<DamageSource, Builder>, CopyableBuilder<DamageSource, Builder> {

        /**
         * Sets the {@link DamageType} of this source.
         *
         * <p>This is required to be set.</p>
         *
         * @param damageType The desired damage type
         * @return This builder
         */
        default Builder type(Supplier<? extends DamageType> damageType) {
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
        Builder type(DamageType damageType);

        /**
         * Sets the {@link Entity} as the damage "source".
         *
         * @param entity The entity
         * @return This builder, for chaining
         */
        Builder entity(@Nullable Entity entity);

        /**
         * Sets the {@link Entity} that is indirectly damaging.
         *
         * @param proxy The indirect entity
         * @return This builder, for chaining
         */
        Builder indirectEntity(@Nullable Entity proxy);

        /**
         * Sets the {@link ServerLocation} to use as a "source".
         *
         * @param location The location of the block as the damage source
         * @return This builder, for chaining
         */
        Builder block(@Nullable ServerLocation location);

        /**
         * Sets the {@link BlockSnapshot} to act as the "damage source".
         *
         * @param blockSnapshot The block snapshot to use as the damage source
         * @return This builder, for chaining
         */
        Builder block(@Nullable BlockSnapshot blockSnapshot);

        /**
         * Builds an instance of this damage source, based on
         * the values you inputted into the builder.
         *
         * @return The resulting damage source
         * @throws IllegalStateException If a value required to be set
         *     is not set
         */
        @Override
        DamageSource build() throws IllegalStateException;
    }

    interface Factory {

        DamageSource drowning();

        DamageSource dryout();

        DamageSource falling();

        DamageSource fireTick();

        DamageSource generic();

        DamageSource magic();

        DamageSource starvation();

        DamageSource voidSource();

        DamageSource wither();
    }
}
