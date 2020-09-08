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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of known {@link EnchantmentType}s.
 *
 * <p>In vanilla the minimum level of these is 1, while the max levels vary.</p>
 */
public final class EnchantmentTypes {

    // SORTFIELDS:ON

    /**
     * Increases regular underwater mining speed.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final Supplier<EnchantmentType> AQUA_AFFINITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "aqua_affinity");

    /**
     * Increases damages and causes slowness for a variable amount of time
     * depending on the level to "arthropod" mobs. In vanilla this includes
     * spiders, cave spiders, silverfish, and endermites.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final Supplier<EnchantmentType> BANE_OF_ARTHROPODS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "bane_of_arthropods");

    /**
     * Prevents removal of the cursed items that reside in the armor slots.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final Supplier<EnchantmentType> BINDING_CURSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "binding_curse");

    /**
     * Reduces explosion damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final Supplier<EnchantmentType> BLAST_PROTECTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "blast_protection");

    /**
     * Increases underwater movement speed.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> DEPTH_STRIDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "depth_strider");

    /**
     * Increases mining speed.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final Supplier<EnchantmentType> EFFICIENCY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "efficiency");

    /**
     * Reduces fall damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final Supplier<EnchantmentType> FEATHER_FALLING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "feather_falling");

    /**
     * Sets the target on fire.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final Supplier<EnchantmentType> FIRE_ASPECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "fire_aspect");

    /**
     * Reduces fire damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final Supplier<EnchantmentType> FIRE_PROTECTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "fire_protection");

    /**
     * Sets your shot arrows on fire.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final Supplier<EnchantmentType> FLAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "flame");

    /**
     * Increases block drops.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> FORTUNE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "fortune");

    /**
     * Creates frosted ice blocks when walking over water.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final Supplier<EnchantmentType> FROST_WALKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "frost_walker");

    /**
     * Causing shooting arrows to not consume regular arrows.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final Supplier<EnchantmentType> INFINITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "infinity");

    /**
     * Increases attack knockback.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final Supplier<EnchantmentType> KNOCKBACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "knockback");

    /**
     * Causes mobs drop more loot.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> LOOTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "looting");

    /**
     * Increases luck while fishing.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> LUCK_OF_THE_SEA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "luck_of_the_sea");

    /**
     * Increases rate of fish biting your hook while fishing.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> LURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "lure");

    /**
     * Repair item durability with experience.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final Supplier<EnchantmentType> MENDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "mending");

    /**
     * Increases shot arrow damage.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final Supplier<EnchantmentType> POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "power");

    /**
     * Reduces projectile damage you take, for example from arrows, ghasts,
     * blaze fire charges, and similar in vanilla.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final Supplier<EnchantmentType> PROJECTILE_PROTECTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "projectile_protection");

    /**
     * Reduces all damage, outside of a few sources that bypass armor, such as
     * the void, the kill command, and hunger damage in vanilla.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final Supplier<EnchantmentType> PROTECTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "protection");

    /**
     * Increases knockback by shot arrows.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final Supplier<EnchantmentType> PUNCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "punch");

    /**
     * Extends underwater breathing time.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> RESPIRATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "respiration");

    /**
     * Increases melee damage.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final Supplier<EnchantmentType> SHARPNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "sharpness");

    /**
     * Allows collection of blocks that are normally unobtainable, such as
     * diamond ore, cocoa, mycelium, and similar in vanilla.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final Supplier<EnchantmentType> SILK_TOUCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "silk_touch");

    /**
     * Increases damage to "undead" mobs. In vanilla this includes skeletons,
     * skeletons, zombies, withers, wither skeletons, zombie pigmen,
     * skeleton horses and zombie horses.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final Supplier<EnchantmentType> SMITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "smite");

    /**
     * Increases the damage of the sweeping attack.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> SWEEPING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "sweeping");

    /**
     * Attackers are damaged when they deal damage to the wearer.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> THORNS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "thorns");

    /**
     * Increases effective durability.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final Supplier<EnchantmentType> UNBREAKING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "unbreaking");

    /**
     * Causes the item to disappear on death.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final Supplier<EnchantmentType> VANISHING_CURSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnchantmentType.class, "vanishing_curse");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private EnchantmentTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }


}
