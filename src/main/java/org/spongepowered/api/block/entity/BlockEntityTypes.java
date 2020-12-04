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
package org.spongepowered.api.block.entity;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all {@link BlockEntityType}s in vanilla Minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class BlockEntityTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<BlockEntityType> BANNER = BlockEntityTypes.key(ResourceKey.sponge("banner"));

    public static final DefaultedRegistryReference<BlockEntityType> BARREL = BlockEntityTypes.key(ResourceKey.sponge("barrel"));

    public static final DefaultedRegistryReference<BlockEntityType> BEACON = BlockEntityTypes.key(ResourceKey.sponge("beacon"));

    public static final DefaultedRegistryReference<BlockEntityType> BED = BlockEntityTypes.key(ResourceKey.sponge("bed"));

    public static final DefaultedRegistryReference<BlockEntityType> BEEHIVE = BlockEntityTypes.key(ResourceKey.sponge("beehive"));

    public static final DefaultedRegistryReference<BlockEntityType> BELL = BlockEntityTypes.key(ResourceKey.sponge("bell"));

    public static final DefaultedRegistryReference<BlockEntityType> BLAST_FURNACE = BlockEntityTypes.key(ResourceKey.sponge("blast_furnace"));

    public static final DefaultedRegistryReference<BlockEntityType> BREWING_STAND = BlockEntityTypes.key(ResourceKey.sponge("brewing_stand"));

    public static final DefaultedRegistryReference<BlockEntityType> CAMPFIRE = BlockEntityTypes.key(ResourceKey.sponge("campfire"));

    public static final DefaultedRegistryReference<BlockEntityType> CHEST = BlockEntityTypes.key(ResourceKey.sponge("chest"));

    public static final DefaultedRegistryReference<BlockEntityType> COMMAND_BLOCK = BlockEntityTypes.key(ResourceKey.sponge("command_block"));

    public static final DefaultedRegistryReference<BlockEntityType> COMPARATOR = BlockEntityTypes.key(ResourceKey.sponge("comparator"));

    public static final DefaultedRegistryReference<BlockEntityType> CONDUIT = BlockEntityTypes.key(ResourceKey.sponge("conduit"));

    public static final DefaultedRegistryReference<BlockEntityType> DAYLIGHT_DETECTOR = BlockEntityTypes.key(ResourceKey.sponge("daylight_detector"));

    public static final DefaultedRegistryReference<BlockEntityType> DISPENSER = BlockEntityTypes.key(ResourceKey.sponge("dispenser"));

    public static final DefaultedRegistryReference<BlockEntityType> DROPPER = BlockEntityTypes.key(ResourceKey.sponge("dropper"));

    public static final DefaultedRegistryReference<BlockEntityType> ENCHANTMENT_TABLE = BlockEntityTypes.key(ResourceKey.sponge("enchantment_table"));

    public static final DefaultedRegistryReference<BlockEntityType> ENDER_CHEST = BlockEntityTypes.key(ResourceKey.sponge("ender_chest"));

    public static final DefaultedRegistryReference<BlockEntityType> END_GATEWAY = BlockEntityTypes.key(ResourceKey.sponge("end_gateway"));

    public static final DefaultedRegistryReference<BlockEntityType> END_PORTAL = BlockEntityTypes.key(ResourceKey.sponge("end_portal"));

    public static final DefaultedRegistryReference<BlockEntityType> FURNACE = BlockEntityTypes.key(ResourceKey.sponge("furnace"));

    public static final DefaultedRegistryReference<BlockEntityType> HOPPER = BlockEntityTypes.key(ResourceKey.sponge("hopper"));

    public static final DefaultedRegistryReference<BlockEntityType> JIGSAW = BlockEntityTypes.key(ResourceKey.sponge("jigsaw"));

    public static final DefaultedRegistryReference<BlockEntityType> JUKEBOX = BlockEntityTypes.key(ResourceKey.sponge("jukebox"));

    public static final DefaultedRegistryReference<BlockEntityType> LECTERN = BlockEntityTypes.key(ResourceKey.sponge("lectern"));

    public static final DefaultedRegistryReference<BlockEntityType> MOB_SPAWNER = BlockEntityTypes.key(ResourceKey.sponge("mob_spawner"));

    public static final DefaultedRegistryReference<BlockEntityType> PISTON = BlockEntityTypes.key(ResourceKey.sponge("piston"));

    public static final DefaultedRegistryReference<BlockEntityType> SHULKER_BOX = BlockEntityTypes.key(ResourceKey.sponge("shulker_box"));

    public static final DefaultedRegistryReference<BlockEntityType> SIGN = BlockEntityTypes.key(ResourceKey.sponge("sign"));

    public static final DefaultedRegistryReference<BlockEntityType> SKULL = BlockEntityTypes.key(ResourceKey.sponge("skull"));

    public static final DefaultedRegistryReference<BlockEntityType> SMOKER = BlockEntityTypes.key(ResourceKey.sponge("smoker"));

    public static final DefaultedRegistryReference<BlockEntityType> STRUCTURE = BlockEntityTypes.key(ResourceKey.sponge("structure"));

    public static final DefaultedRegistryReference<BlockEntityType> TRAPPED_CHEST = BlockEntityTypes.key(ResourceKey.sponge("trapped_chest"));

    // SORTFIELDS:OFF

    // @formatter:on

    private BlockEntityTypes() {
    }

    private static DefaultedRegistryReference<BlockEntityType> key(final ResourceKey location) {
        return RegistryKey.<BlockEntityType>of(Registries.BLOCK_ENTITY_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
