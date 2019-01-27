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

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.tileentity.EnchantmentTable;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.mutable.ColoredData;
import org.spongepowered.api.data.manipulator.mutable.DisplayNameData;
import org.spongepowered.api.data.manipulator.mutable.DyeableData;
import org.spongepowered.api.data.manipulator.mutable.FireworkEffectData;
import org.spongepowered.api.data.manipulator.mutable.FireworkRocketData;
import org.spongepowered.api.data.manipulator.mutable.PotionEffectData;
import org.spongepowered.api.data.manipulator.mutable.PotionTypeData;
import org.spongepowered.api.data.manipulator.mutable.TargetedLocationData;
import org.spongepowered.api.data.manipulator.mutable.item.BlockItemData;
import org.spongepowered.api.data.manipulator.mutable.item.BreakableData;
import org.spongepowered.api.data.manipulator.mutable.item.CoalData;
import org.spongepowered.api.data.manipulator.mutable.item.CookedFishData;
import org.spongepowered.api.data.manipulator.mutable.item.DurabilityData;
import org.spongepowered.api.data.manipulator.mutable.item.EnchantmentData;
import org.spongepowered.api.data.manipulator.mutable.item.FishData;
import org.spongepowered.api.data.manipulator.mutable.item.GenerationData;
import org.spongepowered.api.data.manipulator.mutable.item.GoldenAppleData;
import org.spongepowered.api.data.manipulator.mutable.item.InventoryItemData;
import org.spongepowered.api.data.manipulator.mutable.item.LoreData;
import org.spongepowered.api.data.manipulator.mutable.item.MapItemData;
import org.spongepowered.api.data.manipulator.mutable.item.PagedData;
import org.spongepowered.api.data.manipulator.mutable.item.PlaceableData;
import org.spongepowered.api.data.manipulator.mutable.item.SpawnableData;
import org.spongepowered.api.data.manipulator.mutable.item.StoredEnchantmentData;
import org.spongepowered.api.data.type.CoalType;
import org.spongepowered.api.data.type.CookedFish;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.Fish;
import org.spongepowered.api.data.type.GoldenApple;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.item.potion.PotionType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;

/**
 * An enumeration of known {@link DataManipulator}s applicable to
 * {@link ItemStack}s.
 */
public final class CatalogItemData {

    /**
     * Represents the {@link BlockState} that the item is representing.
     */
    public static final Class<BlockItemData> BLOCK_ITEM_DATA = BlockItemData.class;
    /**
     * Signifies that the item can break specific blocks under conditions of
     * specific game modes and such.
     */
    public static final Class<BreakableData> BREAKABLE_DATA = BreakableData.class;
    /**
     * Represents a limitation on the "cloneability" of an item. Usually
     * applicable to {@link ItemTypes#WRITTEN_BOOK}.
     */
    public static final Class<GenerationData> CLONEABLE_DATA = GenerationData.class;
    /**
     * Represents the {@link CoalType} of an {@link ItemTypes#COAL}.
     */
    public static final Class<CoalData> COAL_ITEM_DATA = CoalData.class;
    /**
     * Signifies that an item is rendered by a specific {@link Color}.
     * Usually applicable to {@link ItemTypes#LEATHER_BOOTS} and other leather
     * armors.
     */
    public static final Class<ColoredData> COLORED_ITEM_DATA = ColoredData.class;
    /**
     * Represents the {@link CookedFish} type of a
     * {@link ItemTypes#COOKED_FISH}.
     */
    public static final Class<CookedFishData> COOKED_FISH_ITEM_DATA = CookedFishData.class;
    /**
     * Signifies that an item has a custom name.
     */
    public static final Class<DisplayNameData> DISPLAY_NAME_DATA = DisplayNameData.class;
    /**
     * Signifies that an item is "damageable" and has limited uses. Usually
     * applicable to all armor, tools, and weapons.
     */
    public static final Class<DurabilityData> DURABILITY_DATA = DurabilityData.class;
    /**
     * Represents the {@link DyeColor} information for a dye related item.
     */
    public static final Class<DyeableData> DYEABLE_DATA = DyeableData.class;
    /**
     * Signifies that an item has {@link Enchantment}s applied to it.
     */
    public static final Class<EnchantmentData> ENCHANTMENT_DATA = EnchantmentData.class;
    /**
     * Represents the {@link FireworkEffect}s of {@link ItemTypes#FIREWORKS}
     * or a {@link ItemTypes#FIREWORK_CHARGE}.
     */
    public static final Class<FireworkEffectData> FIREWORK_EFFECT_DATA = FireworkEffectData.class;
    /**
     * Represents the flight time of {@link ItemTypes#FIREWORKS}.
     */
    public static final Class<FireworkRocketData> FIREWORK_ROCKET_DATA = FireworkRocketData.class;
    /**
     * Represents the {@link Fish} type of a {@link ItemTypes#FISH}.
     */
    public static final Class<FishData> FISH_DATA = FishData.class;
    /**
     * Represents the {@link GoldenApple} type of a
     * {@link ItemTypes#GOLDEN_APPLE}.
     */
    public static final Class<GoldenAppleData> GOLDEN_APPLE_ITEM_DATA = GoldenAppleData.class;
    /**
     * Signifies that an item has an {@link Inventory} attached to it. Usually
     * applicable to {@link ItemTypes#CHEST}
     */
    public static final Class<InventoryItemData> INVENTORY_ITEM_DATA = InventoryItemData.class;
    /**
     * Signifies that an item has extra {@link Text}s associated to its
     * tag information on hover.
     */
    public static final Class<LoreData> LORE_DATA = LoreData.class;
    /**
     * Represents the various information of a {@link ItemTypes#MAP}.
     */
    public static final Class<MapItemData> MAP_ITEM_DATA = MapItemData.class;
    /**
     * Signifies that an item has "pages" of {@link Text}. Usually applicable
     * to {@link ItemTypes#BOOK}s.
     */
    public static final Class<PagedData> PAGED_DATA = PagedData.class;
    /**
     * Signifies that an item can be placed.
     */
    public static final Class<PlaceableData> PLACEABLE_DATA = PlaceableData.class;
    /**
     * Signifies that an item can have {@link PotionEffect}s applied upon
     * use. Usually applicable to {@link ItemTypes#POTION}s.
     */
    public static final Class<PotionEffectData> POTION_EFFECT_DATA = PotionEffectData.class;
    /**
     * Signifies that an item can have {@link PotionType}.
     * Usually applicable to {@link ItemTypes#POTION}s.
     */
    public static final Class<PotionTypeData> POTION_TYPE_DATA = PotionTypeData.class;
    /**
     * Represents the {@link EntityType} that can be spawned upon use.
     * Usually applicable to {@link ItemTypes#SPAWN_EGG}.
     */
    public static final Class<SpawnableData> SPAWNABLE_DATA = SpawnableData.class;
    /**
     * Signifies that there are stored {@link Enchantment}s available on the
     * item such that they can be used to enchant another item within an
     * {@link EnchantmentTable}.
     */
    public static final Class<StoredEnchantmentData> STORED_ENCHANTMENT_DATA = StoredEnchantmentData.class;
    /**
     * Signifies that an item is "pointing" to a particular location. Usually
     * applicable to {@link ItemTypes#COMPASS}.
     */
    public static final Class<TargetedLocationData> TARGETED_LOCATION_DATA = TargetedLocationData.class;

    private CatalogItemData() {
    }

}
