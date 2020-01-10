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
package org.spongepowered.api.statistic;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of all available {@link Statistic}s from the vanilla game.
 */
public final class Statistics {

    // SORTFIELDS:ON

    public static final Supplier<Statistic> ANIMALS_BRED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "ANIMALS_BRED");

    public static final Supplier<Statistic> ARMOR_CLEANED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "ARMOR_CLEANED");

    public static final Supplier<Statistic> AVIATE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "AVIATE_ONE_CM");

    public static final Supplier<Statistic> BANNER_CLEANED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "BANNER_CLEANED");

    public static final Supplier<Statistic> BEACON_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "BEACON_INTERACTION");

    public static final Supplier<Statistic> BOAT_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "BOAT_ONE_CM");

    public static final Supplier<Statistic> BREWINGSTAND_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "BREWINGSTAND_INTERACTION");

    public static final Supplier<Statistic> CAKE_SLICES_EATEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "CAKE_SLICES_EATEN");

    public static final Supplier<Statistic> CAULDRON_FILLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "CAULDRON_FILLED");

    public static final Supplier<Statistic> CAULDRON_USED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "CAULDRON_USED");

    public static final Supplier<Statistic> CHEST_OPENED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "CHEST_OPENED");

    public static final Supplier<Statistic> CLIMB_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "CLIMB_ONE_CM");

    public static final Supplier<Statistic> CRAFTING_TABLE_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "CRAFTING_TABLE_INTERACTION");

    public static final Supplier<Statistic> CROUCH_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "CROUCH_ONE_CM");

    public static final Supplier<Statistic> DAMAGE_DEALT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "DAMAGE_DEALT");

    public static final Supplier<Statistic> DAMAGE_TAKEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "DAMAGE_TAKEN");

    public static final Supplier<Statistic> DEATHS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "DEATHS");

    public static final Supplier<Statistic> DISPENSER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "DISPENSER_INSPECTED");

    public static final Supplier<Statistic> DIVE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "DIVE_ONE_CM");

    public static final Supplier<Statistic> DROP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "DROP");

    public static final Supplier<Statistic> DROPPER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "DROPPER_INSPECTED");

    public static final Supplier<Statistic> ENDERCHEST_OPENED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "ENDERCHEST_OPENED");

    public static final Supplier<Statistic> FALL_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "FALL_ONE_CM");

    public static final Supplier<Statistic> FISH_CAUGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "FISH_CAUGHT");

    public static final Supplier<Statistic> FLOWER_POTTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "FLOWER_POTTED");

    public static final Supplier<Statistic> FURNACE_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "FURNACE_INTERACTION");

    public static final Supplier<Statistic> HOPPER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "HOPPER_INSPECTED");

    public static final Supplier<Statistic> HORSE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "HORSE_ONE_CM");

    public static final Supplier<Statistic> ITEM_ENCHANTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "ITEM_ENCHANTED");

    public static final Supplier<Statistic> JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "JUMP");

    public static final Supplier<Statistic> LEAVE_GAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "LEAVE_GAME");

    public static final Supplier<Statistic> MINECART_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "MINECART_ONE_CM");

    public static final Supplier<Statistic> MOB_KILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "MOB_KILLS");

    public static final Supplier<Statistic> NOTEBLOCK_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "NOTEBLOCK_PLAYED");

    public static final Supplier<Statistic> NOTEBLOCK_TUNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "NOTEBLOCK_TUNED");

    public static final Supplier<Statistic> OPEN_SHULKER_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "OPEN_SHULKER_BOX");

    public static final Supplier<Statistic> PIG_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "PIG_ONE_CM");

    public static final Supplier<Statistic> PLAYER_KILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "PLAYER_KILLS");

    public static final Supplier<Statistic> RECORD_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "RECORD_PLAYED");

    public static final Supplier<Statistic> SLEEP_IN_BED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "SLEEP_IN_BED");

    public static final Supplier<Statistic> SNEAK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "SNEAK_TIME");

    public static final Supplier<Statistic> SPRINT_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "SPRINT_ONE_CM");

    public static final Supplier<Statistic> SWIM_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "SWIM_ONE_CM");

    public static final Supplier<Statistic> TALKED_TO_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "TALKED_TO_VILLAGER");

    public static final Supplier<Statistic> TIME_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "TIME_PLAYED");

    public static final Supplier<Statistic> TIME_SINCE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "TIME_SINCE_DEATH");

    public static final Supplier<Statistic> TRADED_WITH_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "TRADED_WITH_VILLAGER");

    public static final Supplier<Statistic> TRAPPED_CHEST_TRIGGERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "TRAPPED_CHEST_TRIGGERED");

    public static final Supplier<Statistic> WALK_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.class, "WALK_ONE_CM");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Statistics() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
