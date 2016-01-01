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
package org.spongepowered.api.data.manipulator.catalog;

import org.spongepowered.api.block.tileentity.Banner;
import org.spongepowered.api.block.tileentity.CommandBlock;
import org.spongepowered.api.block.tileentity.Comparator;
import org.spongepowered.api.block.tileentity.FlowerPot;
import org.spongepowered.api.block.tileentity.Jukebox;
import org.spongepowered.api.block.tileentity.MobSpawner;
import org.spongepowered.api.block.tileentity.Note;
import org.spongepowered.api.block.tileentity.Sign;
import org.spongepowered.api.block.tileentity.Skull;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.block.tileentity.carrier.Beacon;
import org.spongepowered.api.block.tileentity.carrier.BrewingStand;
import org.spongepowered.api.block.tileentity.carrier.Furnace;
import org.spongepowered.api.block.tileentity.carrier.Hopper;
import org.spongepowered.api.block.tileentity.carrier.TileEntityCarrier;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.mutable.CommandData;
import org.spongepowered.api.data.manipulator.mutable.DisplayNameData;
import org.spongepowered.api.data.manipulator.mutable.MobSpawnerData;
import org.spongepowered.api.data.manipulator.mutable.RepresentedItemData;
import org.spongepowered.api.data.manipulator.mutable.RepresentedPlayerData;
import org.spongepowered.api.data.manipulator.mutable.block.ComparatorData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.BannerData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.BeaconData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.BrewingStandData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.CooldownData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.FurnaceData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.LockableData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.NoteData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.SignData;
import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.profile.GameProfile;

/**
 * An enumeration of known vanilla {@link DataManipulator}s associated with
 * various {@link TileEntity}.
 */
public final class CatalogTileEntityData {

    /**
     * Represents the information for a {@link Banner} such as the
     * base color and {@link PatternLayer}s.
     */
    public static final Class<BannerData> BANNER_DATA = BannerData.class;
    /**
     * Represents the information for a {@link Beacon}.
     */
    public static final Class<BeaconData> BEACON_DATA = BeaconData.class;
    /**
     * Represents the information for a {@link BrewingStand}.
     */
    public static final Class<BrewingStandData> BREWING_DATA = BrewingStandData.class;
    /**
     * Represents the {@link CommandData} for a {@link CommandBlock}.
     */
    public static final Class<CommandData> COMMAND_DATA = CommandData.class;
    /**
     * Represents the {@link Comparator} data.
     */
    public static final Class<ComparatorData> COMPARISON_DATA = ComparatorData.class;
    /**
     * Represents an int cooldown for a {@link Hopper}.
     */
    public static final Class<CooldownData> COOLDOWN_DATA = CooldownData.class;
    /**
     * Represents the customizable display name for various
     * {@link TileEntityCarrier}s.
     */
    public static final Class<DisplayNameData> DISPLAY_NAME_DATA = DisplayNameData.class;
    /**
     * Represents the data for a {@link Furnace}.
     */
    public static final Class<FurnaceData> FURNACE_DATA = FurnaceData.class;
    /**
     * Represents the lock information for a {@link TileEntityCarrier}.
     */
    public static final Class<LockableData> LOCKABLE_DATA = LockableData.class;
    /**
     * Represents the {@link Note} data.
     */
    public static final Class<NoteData> NOTE_DATA = NoteData.class;
    /**
     * Represents data pertaining to a {@link GameProfile} for a tile entity.
     * Usually applicable to {@link Skull}s.
     */
    public static final Class<RepresentedPlayerData> REPRESENTED_PLAYER_DATA = RepresentedPlayerData.class;
    /**
     * Represents a {@link TileEntity} that acts on an {@link ItemStack}.
     * Usually applicable to {@link Jukebox}es and {@link FlowerPot}s.
     */
    public static final Class<RepresentedItemData> JUKEBOX_DATA = RepresentedItemData.class;
    /**
     * Represents a {@link Sign}s data.
     */
    public static final Class<SignData> SIGN_DATA = SignData.class;
    /**
     * Represents the data used by a {@link MobSpawner}.
     */
    public static final Class<MobSpawnerData> MOB_SPAWNER_DATA = MobSpawnerData.class;


    private CatalogTileEntityData() {
    }

}
