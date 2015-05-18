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
package org.spongepowered.api.data.component.catalog;

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.block.tileentity.Banner;
import org.spongepowered.api.block.tileentity.CommandBlock;
import org.spongepowered.api.block.tileentity.Comparator;
import org.spongepowered.api.block.tileentity.DaylightDetector;
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
import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.component.base.CommandComponent;
import org.spongepowered.api.data.component.base.DisplayNameComponent;
import org.spongepowered.api.data.component.base.MobSpawnerComponent;
import org.spongepowered.api.data.component.base.OwnableComponent;
import org.spongepowered.api.data.component.base.RepresentedItemComponent;
import org.spongepowered.api.data.component.block.ComparisonComponent;
import org.spongepowered.api.data.component.block.SignaledOutputComponent;
import org.spongepowered.api.data.component.tileentity.BannerComponent;
import org.spongepowered.api.data.component.tileentity.BeaconComponent;
import org.spongepowered.api.data.component.tileentity.BrewingComponent;
import org.spongepowered.api.data.component.tileentity.CooldownComponent;
import org.spongepowered.api.data.component.tileentity.FurnaceComponent;
import org.spongepowered.api.data.component.tileentity.LockableComponent;
import org.spongepowered.api.data.component.tileentity.NoteComponent;
import org.spongepowered.api.data.component.tileentity.SignComponent;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * An enumeration of known vanilla {@link Component}s associated with
 * various {@link TileEntity}.
 */
public final class CatalogTileEntityData {

    /**
     * Represents the information for a {@link Banner} such as the
     * base color and {@link BannerComponent.PatternLayer}s.
     */
    public static final Class<BannerComponent> BANNER_COMPONENT = BannerComponent.class;
    /**
     * Represents the information for a {@link Beacon}.
     */
    public static final Class<BeaconComponent> BEACON_COMPONENT = BeaconComponent.class;
    /**
     * Represents the information for a {@link BrewingStand}.
     */
    public static final Class<BrewingComponent> BREWING_COMPONENT = BrewingComponent.class;
    /**
     * Represents the {@link CommandComponent} for a {@link CommandBlock}.
     */
    public static final Class<CommandComponent> COMMAND_COMPONENT = CommandComponent.class;
    /**
     * Represents the {@link Comparator} data.
     */
    public static final Class<ComparisonComponent> COMPARISON_COMPONENT = ComparisonComponent.class;
    /**
     * Represents an int cooldown for a {@link Hopper}.
     */
    public static final Class<CooldownComponent> COOLDOWN_COMPONENT = CooldownComponent.class;
    /**
     * Represents the customizable display name for various
     * {@link TileEntityCarrier}s.
     */
    public static final Class<DisplayNameComponent> DISPLAY_NAME_COMPONENT = DisplayNameComponent.class;
    /**
     * Represents the data for a {@link Furnace}.
     */
    public static final Class<FurnaceComponent> FURNACE_COMPONENT = FurnaceComponent.class;
    /**
     * Represents the lock information for a {@link TileEntityCarrier}.
     */
    public static final Class<LockableComponent> LOCKABLE_COMPONENT = LockableComponent.class;
    /**
     * Represents the {@link Note} data.
     */
    public static final Class<NoteComponent> NOTE_COMPONENT = NoteComponent.class;
    /**
     * Represents data pertaining to a {@link GameProfile} for a tile entity.
     * Usually applicable to {@link Skull}s.
     */
    public static final Class<OwnableComponent> OWNABLE_COMPONENT = OwnableComponent.class;
    /**
     * Represents a {@link TileEntity} that acts on an {@link ItemStack}.
     * Usually applicable to {@link Jukebox}es and {@link FlowerPot}s.
     */
    public static final Class<RepresentedItemComponent> JUKEBOX_COMPONENT = RepresentedItemComponent.class;
    /**
     * Represents a {@link TileEntity} that is signaling a redstone output.
     * Usually applicable to {@link Comparator}s and {@link DaylightDetector}s.
     */
    public static final Class<SignaledOutputComponent> SIGNALED_OUTPUT_COMPONENT = SignaledOutputComponent.class;
    /**
     * Represents a {@link Sign}s data.
     */
    public static final Class<SignComponent> SIGN_COMPONENT = SignComponent.class;
    /**
     * Represents the data used by a {@link MobSpawner}.
     */
    public static final Class<MobSpawnerComponent> MOB_SPAWNER_COMPONENT = MobSpawnerComponent.class;


    private CatalogTileEntityData() {
    }

}
