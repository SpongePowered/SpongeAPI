/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.entity;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.explosive.PrimedTNT;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.LeashHitch;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.animal.Horse;
import org.spongepowered.api.entity.living.animal.Mooshroom;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.animal.Squid;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.complex.EnderDragon;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.golem.SnowGolem;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.living.monster.CaveSpider;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Ghast;
import org.spongepowered.api.entity.living.monster.Giant;
import org.spongepowered.api.entity.living.monster.Guardian;
import org.spongepowered.api.entity.living.monster.MagmaCube;
import org.spongepowered.api.entity.living.monster.Silverfish;
import org.spongepowered.api.entity.living.monster.Skeleton;
import org.spongepowered.api.entity.living.monster.Slime;
import org.spongepowered.api.entity.living.monster.Spider;
import org.spongepowered.api.entity.living.monster.Witch;
import org.spongepowered.api.entity.living.monster.Wither;
import org.spongepowered.api.entity.living.monster.Zombie;
import org.spongepowered.api.entity.living.monster.ZombiePigman;
import org.spongepowered.api.entity.living.villager.Villager;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.projectile.Arrow;
import org.spongepowered.api.entity.projectile.Egg;
import org.spongepowered.api.entity.projectile.EnderPearl;
import org.spongepowered.api.entity.projectile.EyeOfEnder;
import org.spongepowered.api.entity.projectile.Firework;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.entity.projectile.Snowball;
import org.spongepowered.api.entity.projectile.ThrownExpBottle;
import org.spongepowered.api.entity.projectile.ThrownPotion;
import org.spongepowered.api.entity.projectile.fireball.LargeFireball;
import org.spongepowered.api.entity.projectile.fireball.SmallFireball;
import org.spongepowered.api.entity.projectile.fireball.WitherSkull;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.MinecartCommandBlock;
import org.spongepowered.api.entity.vehicle.minecart.MinecartFurnace;
import org.spongepowered.api.entity.vehicle.minecart.MinecartHopper;
import org.spongepowered.api.entity.vehicle.minecart.MinecartMobSpawner;
import org.spongepowered.api.entity.vehicle.minecart.MinecartRideable;
import org.spongepowered.api.entity.vehicle.minecart.MinecartTNT;
import org.spongepowered.api.entity.weather.Lightning;
import org.spongepowered.api.entity.weather.WeatherEffect;

import com.google.common.base.Optional;

/**
 * A utility class to access all available {@link EntityType}s.
 */
public final class EntityTypes {
    private EntityTypes() {
    }

    /**
     * @see ArmorStand
     */
    public static final EntityType ARMOR_STAND = null;
    /**
     * @see Arrow
     */
    public static final EntityType ARROW = null;
    /**
     * @see Bat
     */
    public static final EntityType BAT = null;
    /**
     * @see Boat
     */
    public static final EntityType BOAT = null;
    /**
     * @see Blaze
     */
    public static final EntityType BLAZE = null;
    /**
     * @see CaveSpider
     */
    public static final EntityType CAVE_SPIDER = null;
    /**
     * @see Chicken
     */
    public static final EntityType CHICKEN = null;
    /**
     * @see Cow
     */
    public static final EntityType COW = null;
    /**
     * @see Creeper
     */
    public static final EntityType CREEPER = null;
    /**
     * @see Egg
     */
    public static final EntityType EGG = null;
    /**
     * @see Enderman
     */
    public static final EntityType ENDERMAN = null;
    /**
     * @see Endermite
     */
    public static final EntityType ENDERMITE = null;
    /**
     * @see EnderCrystal
     */
    public static final EntityType ENDER_CRYSTAL = null;
    /**
     * @see EnderDragon
     */
    public static final EntityType ENDER_DRAGON = null;
    /**
     * @see EnderDragonPart
     */
    public static final EntityType ENDER_DRAGON_PART = null;
    /**
     * @see EnderPearl
     */
    public static final EntityType ENDER_PEARL = null;
    /**
     * @see ExperienceOrb
     */
    public static final EntityType EXPERIENCE_ORB = null;
    /**
     * @see EyeOfEnder
     */
    public static final EntityType EYE_OF_ENDER = null;
    /**
     * @see FallingBlock
     */
    public static final EntityType FALLING_BLOCK = null;
    /**
     * @see FishHook
     */
    public static final EntityType FISH_HOOK = null;
    /**
     * @see Ghast
     */
    public static final EntityType GHAST = null;
    /**
     * @see Giant
     */
    public static final EntityType GIANT = null;
    /**
     * @see Guardian
     */
    public static final EntityType GUARDIAN = null;
    /**
     * @see Firework
     */
    public static final EntityType FIREWORK = null;
    /**
     * @see LargeFireball
     */
    public static final EntityType LARGE_FIREBALL = null;
    /**
     * @see LeashHitch
     */
    public static final EntityType LEASH_HITCH = null;
    /**
     * @see Horse
     */
    public static final EntityType HORSE = null;
    /**
     * @see IronGolem
     */
    public static final EntityType IRON_GOLEM = null;
    /**
     * @see Item
     */
    public static final EntityType ITEM = null;
    /**
     * @see ItemFrame
     */
    public static final EntityType ITEM_FRAME = null;
    /**
     * @see Lightning
     */
    public static final EntityType LIGHTNING = null;
    /**
     * @see MagmaCube
     */
    public static final EntityType MAGMA_CUBE = null;
    /**
     * @see MinecartRideable
     */
    public static final EntityType MINECART = null;
    /**
     * @see StorageMinecart
     */
    public static final EntityType MINECART_CHEST = null;
    /**
     * @see MinecartCommandBlock
     */
    public static final EntityType MINECART_COMMAND_BLOCK = null;
    /**
     * @see MinecartFurnace
     */
    public static final EntityType MINECART_FURNACE = null;
    /**
     * @see MinecartHopper
     */
    public static final EntityType MINECART_HOPPER = null;
    /**
     * @see MinecartMobSpawner
     */
    public static final EntityType MINECART_MOB_SPAWNER = null;
    /**
     * @see MinecartTNT
     */
    public static final EntityType MINECART_TNT = null;
    /**
     * @see Mooshroom
     */
    public static final EntityType MOOSHROOM = null;
    /**
     * @see Ocelot
     */
    public static final EntityType OCELOT = null;
    /**
     * @see Painting
     */
    public static final EntityType PAINTING = null;
    /**
     * @see Pig
     */
    public static final EntityType PIG = null;
    /**
     * @see Player
     */
    public static final EntityType PLAYER = null;
    /**
     * @see PrimedTNT
     */
    public static final EntityType PRIMED_TNT = null;
    /**
     * @see Sheep
     */
    public static final EntityType SHEEP = null;
    /**
     * @see Silverfish
     */
    public static final EntityType SILVERFISH = null;
    /**
     * @see Slime
     */
    public static final EntityType SLIME = null;
    /**
     * @see SmallFireball
     */
    public static final EntityType SMALL_FIREBALL = null;
    /**
     * @see Snowball
     */
    public static final EntityType SNOWBALL = null;
    /**
     * @see SnowGolem
     */
    public static final EntityType SNOW_GOLEM = null;
    /**
     * @see Skeleton
     */
    public static final EntityType SKELETON = null;
    /**
     * @see Squid
     */
    public static final EntityType SQUID = null;
    /**
     * @see Spider
     */
    public static final EntityType SPIDER = null;
    /**
     * @see ThrownExpBottle
     */
    public static final EntityType THROWN_EXP_BOTTLE = null;
    /**
     * @see ThrownPotion
     */
    public static final EntityType THROWN_POTION = null;
    /**
     * @see Villager
     */
    public static final EntityType VILLAGER = null;
    /**
     * @see WeatherEffect
     */
    public static final EntityType WEATHER_EFFECT = null;
    /**
     * @see Witch
     */
    public static final EntityType WITCH = null;
    /**
     * @see Wither
     */
    public static final EntityType WITHER = null;
    /**
     * @see WitherSkull
     */
    public static final EntityType WITHER_SKULL = null;
    /**
     * @see Wolf
     */
    public static final EntityType WOLF = null;
    /**
     * @see Zombie
     */
    public static final EntityType ZOMBIE = null;
    /**
     * @see ZombiePigman
     */
    public static final EntityType ZOMBIE_PIGMAN = null;

    /**
     * Gets all available {@link EntityType}s.
     *
     * @return A list of all entity types
     */
    public static List<EntityType> getValues() {
        return null;
    }

    /**
     * Gets the {@link EntityType} with the specified name.
     *
     * @param name The name of the entity types to return
     * @return The entity types with the given name, if available
     */
    public static Optional<EntityType> getEntityTypeByName(final String name) {
        checkArgument(name != null, "Cannot have a null entity type name!");
        return null;
    }

}
