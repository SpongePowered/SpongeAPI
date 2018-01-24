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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

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
    public static final EnchantmentType AQUA_AFFINITY = DummyObjectProvider.createFor(EnchantmentType.class, "AQUA_AFFINITY");

    /**
     * Increases damages and causes slowness for a variable amount of time
     * depending on the level to "arthropod" mobs. In vanilla this includes
     * spiders, cave spiders, silverfish, and endermites.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final EnchantmentType BANE_OF_ARTHROPODS = DummyObjectProvider.createFor(EnchantmentType.class, "BANE_OF_ARTHROPODS");

    /**
     * Prevents removal of the cursed items that reside in the armor slots.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final EnchantmentType BINDING_CURSE = DummyObjectProvider.createFor(EnchantmentType.class, "BINDING_CURSE");

    /**
     * Reduces explosion damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final EnchantmentType BLAST_PROTECTION = DummyObjectProvider.createFor(EnchantmentType.class, "BLAST_PROTECTION");

    /**
     * Increases underwater movement speed.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType DEPTH_STRIDER = DummyObjectProvider.createFor(EnchantmentType.class, "DEPTH_STRIDER");

    /**
     * Increases mining speed.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final EnchantmentType EFFICIENCY = DummyObjectProvider.createFor(EnchantmentType.class, "EFFICIENCY");

    /**
     * Reduces fall damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final EnchantmentType FEATHER_FALLING = DummyObjectProvider.createFor(EnchantmentType.class, "FEATHER_FALLING");

    /**
     * Sets the target on fire.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final EnchantmentType FIRE_ASPECT = DummyObjectProvider.createFor(EnchantmentType.class, "FIRE_ASPECT");

    /**
     * Reduces fire damage.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final EnchantmentType FIRE_PROTECTION = DummyObjectProvider.createFor(EnchantmentType.class, "FIRE_PROTECTION");

    /**
     * Sets your shot arrows on fire.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final EnchantmentType FLAME = DummyObjectProvider.createFor(EnchantmentType.class, "FLAME");

    /**
     * Increases block drops.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType FORTUNE = DummyObjectProvider.createFor(EnchantmentType.class, "FORTUNE");

    /**
     * Creates frosted ice blocks when walking over water.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final EnchantmentType FROST_WALKER = DummyObjectProvider.createFor(EnchantmentType.class, "FROST_WALKER");

    /**
     * Causing shooting arrows to not consume regular arrows.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final EnchantmentType INFINITY = DummyObjectProvider.createFor(EnchantmentType.class, "INFINITY");

    /**
     * Increases attack knockback.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final EnchantmentType KNOCKBACK = DummyObjectProvider.createFor(EnchantmentType.class, "KNOCKBACK");

    /**
     * Causes mobs drop more loot.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType LOOTING = DummyObjectProvider.createFor(EnchantmentType.class, "LOOTING");

    /**
     * Increases luck while fishing.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType LUCK_OF_THE_SEA = DummyObjectProvider.createFor(EnchantmentType.class, "LUCK_OF_THE_SEA");

    /**
     * Increases rate of fish biting your hook while fishing.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType LURE = DummyObjectProvider.createFor(EnchantmentType.class, "LURE");

    /**
     * Repair item durability with experience.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final EnchantmentType MENDING = DummyObjectProvider.createFor(EnchantmentType.class, "MENDING");

    /**
     * Increases shot arrow damage.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final EnchantmentType POWER = DummyObjectProvider.createFor(EnchantmentType.class, "POWER");

    /**
     * Reduces projectile damage you take, for example from arrows, ghasts,
     * blaze fire charges, and similar in vanilla.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final EnchantmentType PROJECTILE_PROTECTION = DummyObjectProvider.createFor(EnchantmentType.class, "PROJECTILE_PROTECTION");

    /**
     * Reduces all damage, outside of a few sources that bypass armor, such as
     * the void, the kill command, and hunger damage in vanilla.
     *
     * <p>In vanilla the maximum level is 4.</p>
     */
    public static final EnchantmentType PROTECTION = DummyObjectProvider.createFor(EnchantmentType.class, "PROTECTION");

    /**
     * Increases knockback by shot arrows.
     *
     * <p>In vanilla the maximum level is 2.</p>
     */
    public static final EnchantmentType PUNCH = DummyObjectProvider.createFor(EnchantmentType.class, "PUNCH");

    /**
     * Extends underwater breathing time.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType RESPIRATION = DummyObjectProvider.createFor(EnchantmentType.class, "RESPIRATION");

    /**
     * Increases melee damage.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final EnchantmentType SHARPNESS = DummyObjectProvider.createFor(EnchantmentType.class, "SHARPNESS");

    /**
     * Allows collection of blocks that are normally unobtainable, such as
     * diamond ore, cocoa, mycelium, and similar in vanilla.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final EnchantmentType SILK_TOUCH = DummyObjectProvider.createFor(EnchantmentType.class, "SILK_TOUCH");

    /**
     * Increases damage to "undead" mobs. In vanilla this includes skeletons,
     * skeletons, zombies, withers, wither skeletons, zombie pigmen,
     * skeleton horses and zombie horses.
     *
     * <p>In vanilla the maximum level is 5.</p>
     */
    public static final EnchantmentType SMITE = DummyObjectProvider.createFor(EnchantmentType.class, "SMITE");

    /**
     * Increases the damage of the sweeping attack.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType SWEEPING = DummyObjectProvider.createFor(EnchantmentType.class, "SWEEPING");

    /**
     * Attackers are damaged when they deal damage to the wearer.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType THORNS = DummyObjectProvider.createFor(EnchantmentType.class, "THORNS");

    /**
     * Increases effective durability.
     *
     * <p>In vanilla the maximum level is 3.</p>
     */
    public static final EnchantmentType UNBREAKING = DummyObjectProvider.createFor(EnchantmentType.class, "UNBREAKING");

    /**
     * Causes the item to disappear on death.
     *
     * <p>In vanilla the maximum level is 1.</p>
     */
    public static final EnchantmentType VANISHING_CURSE = DummyObjectProvider.createFor(EnchantmentType.class, "VANISHING_CURSE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private EnchantmentTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }


}
