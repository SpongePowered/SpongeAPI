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

import org.spongepowered.api.attribute.AttributeModifier;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.tileentity.EnchantmentTable;
import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.component.base.AttributeComponent;
import org.spongepowered.api.data.component.base.ColoredComponent;
import org.spongepowered.api.data.component.base.DisplayNameComponent;
import org.spongepowered.api.data.component.base.DyeableComponent;
import org.spongepowered.api.data.component.base.FireworkComponent;
import org.spongepowered.api.data.component.base.PotionEffectComponent;
import org.spongepowered.api.data.component.base.TargetedLocationComponent;
import org.spongepowered.api.data.component.item.BlockItemComponent;
import org.spongepowered.api.data.component.item.BreakableComponent;
import org.spongepowered.api.data.component.item.CoalItemComponent;
import org.spongepowered.api.data.component.item.CookedFishItemComponent;
import org.spongepowered.api.data.component.item.DurabilityComponent;
import org.spongepowered.api.data.component.item.EnchantmentComponent;
import org.spongepowered.api.data.component.item.FishComponent;
import org.spongepowered.api.data.component.item.GenerationComponent;
import org.spongepowered.api.data.component.item.GoldenAppleItemComponent;
import org.spongepowered.api.data.component.item.InventoryComponent;
import org.spongepowered.api.data.component.item.LoreComponent;
import org.spongepowered.api.data.component.item.MapItemComponent;
import org.spongepowered.api.data.component.item.PagedComponent;
import org.spongepowered.api.data.component.item.PlaceableComponent;
import org.spongepowered.api.data.component.item.SpawnableComponent;
import org.spongepowered.api.data.component.item.StoredEnchantmentComponent;
import org.spongepowered.api.data.type.CoalType;
import org.spongepowered.api.data.type.CookedFish;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.Fish;
import org.spongepowered.api.data.type.GoldenApple;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.text.Text;

import java.awt.Color;

/**
 * An enumeration of known {@link Component}s applicable to
 * {@link ItemStack}s.
 */
public final class CatalogItemData {

    /**
     * Signifies that an item contains {@link AttributeModifier}s. The modifiers
     * may affect any entity that is "holding" the owning item.
     */
    public static final Class<AttributeComponent> ATTRIBUTE_COMPONENT = AttributeComponent.class;
    /**
     * Represents the {@link BlockState} that the item is representing.
     */
    public static final Class<BlockItemComponent> BLOCK_ITEM_COMPONENT = BlockItemComponent.class;
    /**
     * Signifies that the item can break specific blocks under conditions of
     * specific game modes and such.
     */
    public static final Class<BreakableComponent> BREAKABLE_COMPONENT = BreakableComponent.class;
    /**
     * Represents a limitation on the "cloneability" of an item. Usually
     * applicable to {@link ItemTypes#WRITTEN_BOOK}.
     */
    public static final Class<GenerationComponent> CLONEABLE_COMPONENT = GenerationComponent.class;
    /**
     * Represents the {@link CoalType} of an {@link ItemTypes#COAL}.
     */
    public static final Class<CoalItemComponent> COAL_ITEM_COMPONENT = CoalItemComponent.class;
    /**
     * Signifies that an item is rendered by a specific {@link Color}.
     * Usually applicable to {@link ItemTypes#LEATHER_BOOTS} and other leather
     * armors.
     */
    public static final Class<ColoredComponent> COLORED_ITEM_COMPONENT = ColoredComponent.class;
    /**
     * Represents the {@link CookedFish} type of a
     * {@link ItemTypes#COOKED_FISH}.
     */
    public static final Class<CookedFishItemComponent> COOKED_FISH_ITEM_COMPONENT = CookedFishItemComponent.class;
    /**
     * Signifies that an item has a custom name.
     */
    public static final Class<DisplayNameComponent> DISPLAY_NAME_COMPONENT = DisplayNameComponent.class;
    /**
     * Signifies that an item is "damageable" and has limited uses. Usually
     * applicable to all armor, tools, and weapons.
     */
    public static final Class<DurabilityComponent> DURABILITY_COMPONENT = DurabilityComponent.class;
    /**
     * Represents the {@link DyeColor} information for a dye related item.
     */
    public static final Class<DyeableComponent> DYEABLE_COMPONENT = DyeableComponent.class;
    /**
     * Signifies that an item has {@link Enchantment}s applied to it.
     */
    public static final Class<EnchantmentComponent> ENCHANTMENT_COMPONENT = EnchantmentComponent.class;
    /**
     * Represents the {@link FireworkEffect}s of a firework.
     */
    public static final Class<FireworkComponent> FIREWORK_COMPONENT = FireworkComponent.class;
    /**
     * Represents the {@link Fish} type of a {@link ItemTypes#FISH}.
     */
    public static final Class<FishComponent> FISH_COMPONENT = FishComponent.class;
    /**
     * Represents the {@link GoldenApple} type of a
     * {@link ItemTypes#GOLDEN_APPLE}.
     */
    public static final Class<GoldenAppleItemComponent> GOLDEN_APPLE_ITEM_COMPONENT = GoldenAppleItemComponent.class;
    /**
     * Signifies that an item has an {@link Inventory} attached to it. Usually
     * applicable to {@link ItemTypes#CHEST}
     */
    public static final Class<InventoryComponent> INVENTORY_ITEM_COMPONENT = InventoryComponent.class;
    /**
     * Signifies that an item has extra {@link Text}s associated to its
     * tag information on hover.
     */
    public static final Class<LoreComponent> LORE_COMPONENT = LoreComponent.class;
    /**
     * Represents the various information of a {@link ItemTypes#MAP}.
     */
    public static final Class<MapItemComponent> MAP_ITEM_COMPONENT = MapItemComponent.class;
    /**
     * Signifies that an item has "pages" of {@link Text}. Usually applicable
     * to {@link ItemTypes#BOOK}s.
     */
    public static final Class<PagedComponent> PAGED_COMPONENT = PagedComponent.class;
    /**
     * Signifies that an item can be placed.
     */
    public static final Class<PlaceableComponent> PLACEABLE_COMPONENT = PlaceableComponent.class;
    /**
     * Signifies that an item can have {@link PotionEffect}s applied upon
     * use. Usually applicable to {@link ItemTypes#POTION}s.
     */
    public static final Class<PotionEffectComponent> POTION_EFFECT_COMPONENT = PotionEffectComponent.class;
    /**
     * Represents the {@link EntityType} that can be spawned upon use.
     * Usually applicable to {@link ItemTypes#SPAWN_EGG}.
     */
    public static final Class<SpawnableComponent> SPAWNABLE_COMPONENT = SpawnableComponent.class;
    /**
     * Signifies that there are stored {@link Enchantment}s available on the
     * item such that they can be used to enchant another item within an
     * {@link EnchantmentTable}.
     */
    public static final Class<StoredEnchantmentComponent> STORED_ENCHANTMENT_COMPONENT = StoredEnchantmentComponent.class;
    /**
     * Signifies that an item is "pointing" to a particular location. Usually
     * applicable to {@link ItemTypes#COMPASS}.
     */
    public static final Class<TargetedLocationComponent> TARGETED_LOCATION_COMPONENT = TargetedLocationComponent.class;

    private CatalogItemData() {
    }

}
