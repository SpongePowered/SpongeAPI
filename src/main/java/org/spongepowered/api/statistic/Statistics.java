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

    public static final Supplier<Statistic.Type> ANIMALS_BRED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "ANIMALS_BRED");

    public static final Supplier<Statistic.Type> ARMOR_CLEANED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "ARMOR_CLEANED");

    public static final Supplier<Statistic.Type> AVIATE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "AVIATE_ONE_CM");

    public static final Supplier<Statistic.Type> BANNER_CLEANED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "BANNER_CLEANED");

    public static final Supplier<Statistic.Type> BEACON_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "BEACON_INTERACTION");

    public static final Supplier<Statistic.Type> BOAT_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "BOAT_ONE_CM");

    public static final Supplier<Statistic.Type> BREWINGSTAND_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "BREWINGSTAND_INTERACTION");

    public static final Supplier<Statistic.Type> CAKE_SLICES_EATEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "CAKE_SLICES_EATEN");

    public static final Supplier<Statistic.Type> CAULDRON_FILLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "CAULDRON_FILLED");

    public static final Supplier<Statistic.Type> CAULDRON_USED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "CAULDRON_USED");

    public static final Supplier<Statistic.Type> CHEST_OPENED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "CHEST_OPENED");

    public static final Supplier<Statistic.Type> CLIMB_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "CLIMB_ONE_CM");

    public static final Supplier<Statistic.Type> CRAFTING_TABLE_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "CRAFTING_TABLE_INTERACTION");

    public static final Supplier<Statistic.Type> CROUCH_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "CROUCH_ONE_CM");

    public static final Supplier<Statistic.Type> DAMAGE_DEALT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "DAMAGE_DEALT");

    public static final Supplier<Statistic.Type> DAMAGE_TAKEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "DAMAGE_TAKEN");

    public static final Supplier<Statistic.Type> DEATHS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "DEATHS");

    public static final Supplier<Statistic.Type> DISPENSER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "DISPENSER_INSPECTED");

    public static final Supplier<Statistic.Type> DIVE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "DIVE_ONE_CM");

    public static final Supplier<Statistic.Type> DROP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "DROP");

    public static final Supplier<Statistic.Type> DROPPER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "DROPPER_INSPECTED");

    public static final Supplier<Statistic.Type> ENDERCHEST_OPENED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "ENDERCHEST_OPENED");

    public static final Supplier<Statistic.Type> FALL_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "FALL_ONE_CM");

    public static final Supplier<Statistic.Type> FISH_CAUGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "FISH_CAUGHT");

    public static final Supplier<Statistic.Type> FLOWER_POTTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "FLOWER_POTTED");

    public static final Supplier<Statistic.Type> FURNACE_INTERACTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "FURNACE_INTERACTION");

    public static final Supplier<Statistic.Type> HOPPER_INSPECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "HOPPER_INSPECTED");

    public static final Supplier<Statistic.Type> HORSE_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "HORSE_ONE_CM");

    public static final Supplier<Statistic.Type> ITEM_ENCHANTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "ITEM_ENCHANTED");

    public static final Supplier<Statistic.Type> JUMP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "JUMP");

    public static final Supplier<Statistic.Type> LEAVE_GAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "LEAVE_GAME");

    public static final Supplier<Statistic.Type> MINECART_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "MINECART_ONE_CM");

    public static final Supplier<Statistic.Type> MOB_KILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "MOB_KILLS");

    public static final Supplier<Statistic.Type> NOTEBLOCK_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "NOTEBLOCK_PLAYED");

    public static final Supplier<Statistic.Type> NOTEBLOCK_TUNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "NOTEBLOCK_TUNED");

    public static final Supplier<Statistic.Type> OPEN_SHULKER_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "OPEN_SHULKER_BOX");

    public static final Supplier<Statistic.Type> PIG_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "PIG_ONE_CM");

    public static final Supplier<Statistic.Type> PLAYER_KILLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "PLAYER_KILLS");

    public static final Supplier<Statistic.Type> RECORD_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "RECORD_PLAYED");

    public static final Supplier<Statistic.Type> SLEEP_IN_BED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "SLEEP_IN_BED");

    public static final Supplier<Statistic.Type> SNEAK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "SNEAK_TIME");

    public static final Supplier<Statistic.Type> SPRINT_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "SPRINT_ONE_CM");

    public static final Supplier<Statistic.Type> SWIM_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "SWIM_ONE_CM");

    public static final Supplier<Statistic.Type> TALKED_TO_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "TALKED_TO_VILLAGER");

    public static final Supplier<Statistic.Type> TIME_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "TIME_PLAYED");

    public static final Supplier<Statistic.Type> TIME_SINCE_DEATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "TIME_SINCE_DEATH");

    public static final Supplier<Statistic.Type> TRADED_WITH_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "TRADED_WITH_VILLAGER");

    public static final Supplier<Statistic.Type> TRAPPED_CHEST_TRIGGERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "TRAPPED_CHEST_TRIGGERED");

    public static final Supplier<Statistic.Type> WALK_ONE_CM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Statistic.Type.class, "WALK_ONE_CM");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private Statistics() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
