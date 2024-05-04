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
package org.spongepowered.api.tag;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * <!-- This file is automatically generated. Any manual changes will be overwritten. -->
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class EntityTypeTags {

    public static final Tag<EntityType<?>> ARROWS = EntityTypeTags.key(ResourceKey.minecraft("arrows"));

    public static final Tag<EntityType<?>> AXOLOTL_ALWAYS_HOSTILES = EntityTypeTags.key(ResourceKey.minecraft("axolotl_always_hostiles"));

    public static final Tag<EntityType<?>> AXOLOTL_HUNT_TARGETS = EntityTypeTags.key(ResourceKey.minecraft("axolotl_hunt_targets"));

    public static final Tag<EntityType<?>> BEEHIVE_INHABITORS = EntityTypeTags.key(ResourceKey.minecraft("beehive_inhabitors"));

    public static final Tag<EntityType<?>> CAN_BREATHE_UNDER_WATER = EntityTypeTags.key(ResourceKey.minecraft("can_breathe_under_water"));

    public static final Tag<EntityType<?>> DISMOUNTS_UNDERWATER = EntityTypeTags.key(ResourceKey.minecraft("dismounts_underwater"));

    public static final Tag<EntityType<?>> FALL_DAMAGE_IMMUNE = EntityTypeTags.key(ResourceKey.minecraft("fall_damage_immune"));

    public static final Tag<EntityType<?>> FREEZE_HURTS_EXTRA_TYPES = EntityTypeTags.key(ResourceKey.minecraft("freeze_hurts_extra_types"));

    public static final Tag<EntityType<?>> FREEZE_IMMUNE_ENTITY_TYPES = EntityTypeTags.key(ResourceKey.minecraft("freeze_immune_entity_types"));

    public static final Tag<EntityType<?>> FROG_FOOD = EntityTypeTags.key(ResourceKey.minecraft("frog_food"));

    public static final Tag<EntityType<?>> IMPACT_PROJECTILES = EntityTypeTags.key(ResourceKey.minecraft("impact_projectiles"));

    public static final Tag<EntityType<?>> NON_CONTROLLING_RIDER = EntityTypeTags.key(ResourceKey.minecraft("non_controlling_rider"));

    public static final Tag<EntityType<?>> POWDER_SNOW_WALKABLE_MOBS = EntityTypeTags.key(ResourceKey.minecraft("powder_snow_walkable_mobs"));

    public static final Tag<EntityType<?>> RAIDERS = EntityTypeTags.key(ResourceKey.minecraft("raiders"));

    public static final Tag<EntityType<?>> SKELETONS = EntityTypeTags.key(ResourceKey.minecraft("skeletons"));

    public static final Tag<EntityType<?>> UNDEAD = EntityTypeTags.key(ResourceKey.minecraft("undead"));

    public static final Tag<EntityType<?>> ZOMBIES = EntityTypeTags.key(ResourceKey.minecraft("zombies"));

    private EntityTypeTags() {
    }

    private static Tag<EntityType<?>> key(final ResourceKey key) {
        return Tag.of(RegistryTypes.ENTITY_TYPE, key);
    }
}
