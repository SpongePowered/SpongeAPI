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
package org.spongepowered.api.data.type;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackLike;
import org.spongepowered.api.tag.Tag;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Represents an action an {@link ItemStack} can apply to {@link Living} in different circumstances.
 *
 * @see Keys#CONSUME_ACTIONS
 * @see Keys#DEATH_PROTECTION_ACTIONS
 */
public interface ItemAction {

    static ApplyEffects applyEffects(final Collection<PotionEffect> effects) {
        return ItemAction.applyEffects(1.0D, effects);
    }

    static ApplyEffects applyEffects(final PotionEffect... effects) {
        return ItemAction.applyEffects(1.0D, effects);
    }

    static ApplyEffects applyEffects(final double chance, final Collection<PotionEffect> effects) {
        return ItemAction.factory().applyEffects(chance, List.copyOf(effects));
    }

    static ApplyEffects applyEffects(final double chance, final PotionEffect... effects) {
        return ItemAction.factory().applyEffects(chance, List.of(effects));
    }

    static RemoveEffects removeEffects(final Collection<PotionEffectType> effectTypes) {
        return ItemAction.factory().removeEffects(Set.copyOf(effectTypes));
    }

    static RemoveEffects removeEffects(final PotionEffectType... effectTypes) {
        return ItemAction.factory().removeEffects(Set.of(effectTypes));
    }

    @SafeVarargs
    static RemoveEffects removeEffects(final Supplier<PotionEffectType>... effectTypes) {
        return ItemAction.factory().removeEffects(Arrays.stream(effectTypes).map(Supplier::get).collect(Collectors.toSet()));
    }

    static RemoveEffects removeEffects(final Tag<PotionEffectType> effectTypeTag) {
        return ItemAction.factory().removeEffects(effectTypeTag);
    }

    static ClearEffects clearEffects() {
        return ItemAction.factory().clearEffects();
    }

    static PlaySound playSound(final SoundType soundType) {
        return ItemAction.factory().playSound(soundType);
    }

    static PlaySound playSound(final Supplier<SoundType> soundType) {
        return ItemAction.factory().playSound(soundType.get());
    }

    static TeleportRandomly teleportRandomly(final double distance) {
        return ItemAction.factory().teleportRandomly(distance);
    }

    private static Factory factory() {
        return Sponge.game().factoryProvider().provide(Factory.class);
    }

    /**
     * Returns the type of this effect.
     * @return The type of this effect
     */
    ItemActionType type();

    /**
     * Tries to apply this effect and returns whether it was successfully applied.
     * The definition of success is purely left up to the implementation.
     *
     * @param entity The entity to apply effect to
     * @param stack The item to apply effect with
     * @return true if effect was successfully applied
     */
    boolean apply(Living entity, ItemStackLike stack);

    /**
     * Applies this effect with {@link ItemStack#empty()}.
     *
     * @param entity The entity to apply effect to
     * @return true if effect was successfully applied
     * @see #apply(Living, ItemStackLike)
     */
    default boolean apply(final Living entity) {
        return this.apply(entity, ItemStack.empty());
    }

    /**
     * Applies {@link PotionEffect}s with chance.
     */
    interface ApplyEffects extends ItemAction {
        /**
         * Returns the probability for effects to be applied.
         * @return The probability for effects to be applied
         */
        double chance();

        /**
         * Returns {@link PotionEffect}s that will be applied.
         * @return {@link PotionEffect}s that will be applied
         */
        List<PotionEffect> effects();
    }

    /**
     * Removes {@link PotionEffect}s with matching {@link PotionEffectType}s.
     */
    interface RemoveEffects extends ItemAction {
        /**
         * Returns {@link PotionEffectType}s that will be removed.
         * @return {@link PotionEffectType}s that will be removed
         */
        Set<PotionEffectType> effectTypes();
    }

    /**
     * Clears all {@link PotionEffect}s.
     */
    interface ClearEffects extends ItemAction {
    }

    /**
     * Plays {@link SoundType}.
     */
    interface PlaySound extends ItemAction {
        /**
         * Returns the {@link SoundType} to be played.
         * @return The {@link SoundType}
         */
        SoundType soundType();
    }

    /**
     * Teleports randomly within maximum distance.
     */
    interface TeleportRandomly extends ItemAction {
        /**
         * Returns the maximum distance entity can be teleported.
         * @return The maximum distance entity can be teleported
         */
        double distance();
    }

    interface Factory {

        ApplyEffects applyEffects(double chance, List<PotionEffect> effects);

        RemoveEffects removeEffects(Set<PotionEffectType> effectTypes);

        RemoveEffects removeEffects(Tag<PotionEffectType> effectTypeTag);

        ClearEffects clearEffects();

        PlaySound playSound(SoundType soundType);

        TeleportRandomly teleportRandomly(double distance);
    }
}
