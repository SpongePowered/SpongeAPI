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
package org.spongepowered.api.item.enchantment;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of known {@link EnchantmentType}s.
 *
 * <p>In vanilla the minimum level of these is 1, while the max levels vary.</p>
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class EnchantmentTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Increases regular underwater mining speed.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> AQUA_AFFINITY = EnchantmentTypes.key(ResourceKey.minecraft("aqua_affinity"));

    /**
     * Increases damages and causes slowness for a variable amount of time
     * depending on the level to "arthropod" mobs. In vanilla this includes
     * spiders, cave spiders, silverfish, and endermites.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> BANE_OF_ARTHROPODS = EnchantmentTypes.key(ResourceKey.minecraft("bane_of_arthropods"));

    /**
     * Prevents removal of the cursed items that reside in the armor slots.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> BINDING_CURSE = EnchantmentTypes.key(ResourceKey.minecraft("binding_curse"));

    /**
     * Reduces explosion damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> BLAST_PROTECTION = EnchantmentTypes.key(ResourceKey.minecraft("blast_protection"));

    public static final DefaultedRegistryReference<EnchantmentType> CHANNELING = EnchantmentTypes.key(ResourceKey.minecraft("channeling"));

    /**
     * Increases underwater movement speed.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> DEPTH_STRIDER = EnchantmentTypes.key(ResourceKey.minecraft("depth_strider"));

    /**
     * Increases mining speed.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> EFFICIENCY = EnchantmentTypes.key(ResourceKey.minecraft("efficiency"));

    /**
     * Reduces fall damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> FEATHER_FALLING = EnchantmentTypes.key(ResourceKey.minecraft("feather_falling"));

    /**
     * Sets the target on fire.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> FIRE_ASPECT = EnchantmentTypes.key(ResourceKey.minecraft("fire_aspect"));

    /**
     * Reduces fire damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> FIRE_PROTECTION = EnchantmentTypes.key(ResourceKey.minecraft("fire_protection"));

    /**
     * Sets your shot arrows on fire.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> FLAME = EnchantmentTypes.key(ResourceKey.minecraft("flame"));

    /**
     * Increases block drops.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> FORTUNE = EnchantmentTypes.key(ResourceKey.minecraft("fortune"));

    /**
     * Creates frosted ice blocks when walking over water.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> FROST_WALKER = EnchantmentTypes.key(ResourceKey.minecraft("frost_walker"));

    public static final DefaultedRegistryReference<EnchantmentType> IMPALING = EnchantmentTypes.key(ResourceKey.minecraft("impaling"));

    /**
     * Causing shooting arrows to not consume regular arrows.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> INFINITY = EnchantmentTypes.key(ResourceKey.minecraft("infinity"));

    /**
     * Increases attack knockback.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> KNOCKBACK = EnchantmentTypes.key(ResourceKey.minecraft("knockback"));

    /**
     * Causes mobs drop more loot.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> LOOTING = EnchantmentTypes.key(ResourceKey.minecraft("looting"));

    public static final DefaultedRegistryReference<EnchantmentType> LOYALTY = EnchantmentTypes.key(ResourceKey.minecraft("loyalty"));

    /**
     * Increases luck while fishing.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> LUCK_OF_THE_SEA = EnchantmentTypes.key(ResourceKey.minecraft("luck_of_the_sea"));

    /**
     * Increases rate of fish biting your hook while fishing.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> LURE = EnchantmentTypes.key(ResourceKey.minecraft("lure"));

    /**
     * Repair item durability with experience.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> MENDING = EnchantmentTypes.key(ResourceKey.minecraft("mending"));

    public static final DefaultedRegistryReference<EnchantmentType> MULTISHOT = EnchantmentTypes.key(ResourceKey.minecraft("multishot"));

    public static final DefaultedRegistryReference<EnchantmentType> PIERCING = EnchantmentTypes.key(ResourceKey.minecraft("piercing"));

    /**
     * Increases shot arrow damage.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> POWER = EnchantmentTypes.key(ResourceKey.minecraft("power"));

    /**
     * Reduces projectile damage you take, for example from arrows, ghasts,
     * blaze fire charges, and similar in vanilla.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> PROJECTILE_PROTECTION = EnchantmentTypes.key(ResourceKey.minecraft("projectile_protection"));

    /**
     * Reduces all damage, outside of a few sources that bypass armor, such as
     * the void, the kill command, and hunger damage in vanilla.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> PROTECTION = EnchantmentTypes.key(ResourceKey.minecraft("protection"));

    /**
     * Increases knockback by shot arrows.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> PUNCH = EnchantmentTypes.key(ResourceKey.minecraft("punch"));

    public static final DefaultedRegistryReference<EnchantmentType> QUICK_CHARGE = EnchantmentTypes.key(ResourceKey.minecraft("quick_charge"));

    /**
     * Extends underwater breathing time.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> RESPIRATION = EnchantmentTypes.key(ResourceKey.minecraft("respiration"));

    public static final DefaultedRegistryReference<EnchantmentType> RIPTIDE = EnchantmentTypes.key(ResourceKey.minecraft("riptide"));

    /**
     * Increases melee damage.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> SHARPNESS = EnchantmentTypes.key(ResourceKey.minecraft("sharpness"));

    /**
     * Allows collection of blocks that are normally unobtainable, such as
     * diamond ore, cocoa, mycelium, and similar in vanilla.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> SILK_TOUCH = EnchantmentTypes.key(ResourceKey.minecraft("silk_touch"));

    /**
     * Increases damage to "undead" mobs. In vanilla this includes skeletons,
     * skeletons, zombies, withers, wither skeletons, zombie pigmen,
     * skeleton horses and zombie horses.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> SMITE = EnchantmentTypes.key(ResourceKey.minecraft("smite"));

    public static final DefaultedRegistryReference<EnchantmentType> SOUL_SPEED = EnchantmentTypes.key(ResourceKey.minecraft("soul_speed"));

    /**
     * Increases the damage of the sweeping attack.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> SWEEPING = EnchantmentTypes.key(ResourceKey.minecraft("sweeping"));

    /**
     * Attackers are damaged when they deal damage to the wearer.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> THORNS = EnchantmentTypes.key(ResourceKey.minecraft("thorns"));

    /**
     * Increases effective durability.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> UNBREAKING = EnchantmentTypes.key(ResourceKey.minecraft("unbreaking"));

    /**
     * Causes the item to disappear on death.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final DefaultedRegistryReference<EnchantmentType> VANISHING_CURSE = EnchantmentTypes.key(ResourceKey.minecraft("vanishing_curse"));


    // SORTFIELDS:OFF

    // @formatter:on

    private EnchantmentTypes() {
    }

    private static DefaultedRegistryReference<EnchantmentType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.ENCHANTMENT_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
