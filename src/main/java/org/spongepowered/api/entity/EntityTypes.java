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

import org.spongepowered.api.entity.explosive.PrimedTNT;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.LeashHitch;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.Squid;
import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.animal.Cow;
import org.spongepowered.api.entity.living.animal.Horse;
import org.spongepowered.api.entity.living.animal.Mooshroom;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.Rabbit;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.complex.EnderDragon;
import org.spongepowered.api.entity.living.complex.EnderDragonPart;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.golem.SnowGolem;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.living.monster.CaveSpider;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Endermite;
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
import org.spongepowered.api.entity.projectile.explosive.WitherSkull;
import org.spongepowered.api.entity.projectile.explosive.fireball.Fireball;
import org.spongepowered.api.entity.projectile.explosive.fireball.SmallFireball;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.MinecartChest;
import org.spongepowered.api.entity.vehicle.minecart.MinecartCommandBlock;
import org.spongepowered.api.entity.vehicle.minecart.MinecartFurnace;
import org.spongepowered.api.entity.vehicle.minecart.MinecartHopper;
import org.spongepowered.api.entity.vehicle.minecart.MinecartMobSpawner;
import org.spongepowered.api.entity.vehicle.minecart.MinecartRideable;
import org.spongepowered.api.entity.vehicle.minecart.MinecartTNT;
import org.spongepowered.api.entity.weather.Lightning;
import org.spongepowered.api.entity.weather.WeatherEffect;

/**
 * An enumeration of all possible {@link EntityType}s available in vanilla
 * minecraft.
 */
public final class EntityTypes {

    public static final EntityType<Item> DROPPED_ITEM = null;
    public static final EntityType<ExperienceOrb> EXPERIENCE_ORB = null;
    public static final EntityType<LeashHitch> LEASH_HITCH = null;
    public static final EntityType<Painting> PAINTING = null;
    public static final EntityType<Arrow> ARROW = null;
    public static final EntityType<Snowball> SNOWBALL = null;
    public static final EntityType<Fireball> FIREBALL = null;
    public static final EntityType<SmallFireball> SMALL_FIREBALL = null;
    public static final EntityType<EnderPearl> ENDER_PEARL = null;
    public static final EntityType<EyeOfEnder> EYE_OF_ENDER = null;
    public static final EntityType<ThrownExpBottle> THROWN_EXP_BOTTLE = null;
    public static final EntityType<ItemFrame> ITEM_FRAME = null;
    public static final EntityType<WitherSkull> WITHER_SKULL = null;
    public static final EntityType<PrimedTNT> PRIMED_TNT = null;
    public static final EntityType<FallingBlock> FALLING_BLOCK = null;
    public static final EntityType<Firework> FIREWORK = null;
    public static final EntityType<MinecartCommandBlock> COMMANDBLOCK_MINECART = null;
    public static final EntityType<ArmorStand> ARMOR_STAND = null;
    public static final EntityType<Boat> BOAT = null;
    public static final EntityType<MinecartRideable> RIDEABLE_MINECART = null;
    public static final EntityType<MinecartChest> CHESTED_MINECART = null;
    public static final EntityType<MinecartFurnace> FURNACE_MINECART = null;
    public static final EntityType<MinecartTNT> TNT_MINECART = null;
    public static final EntityType<MinecartHopper> HOPPER_MINECART = null;
    public static final EntityType<MinecartMobSpawner> MOB_SPAWNER_MINECART = null;
    public static final EntityType<Creeper> CREEPER = null;
    public static final EntityType<Skeleton> SKELETON = null;
    public static final EntityType<Spider> SPIDER = null;
    public static final EntityType<Giant> GIANT = null;
    public static final EntityType<Zombie> ZOMBIE = null;
    public static final EntityType<Slime> SLIME = null;
    public static final EntityType<Ghast> GHAST = null;
    public static final EntityType<ZombiePigman> PIG_ZOMBIE = null;
    public static final EntityType<Enderman> ENDERMAN = null;
    public static final EntityType<CaveSpider> CAVE_SPIDER = null;
    public static final EntityType<Silverfish> SILVERFISH = null;
    public static final EntityType<Blaze> BLAZE = null;
    public static final EntityType<MagmaCube> MAGMA_CUBE = null;
    public static final EntityType<EnderDragon> ENDER_DRAGON = null;
    public static final EntityType<Wither> WITHER = null;
    public static final EntityType<Bat> BAT = null;
    public static final EntityType<Witch> WITCH = null;
    public static final EntityType<Pig> PIG = null;
    public static final EntityType<Sheep> SHEEP = null;
    public static final EntityType<Cow> COW = null;
    public static final EntityType<Chicken> CHICKEN = null;
    public static final EntityType<Squid> SQUID = null;
    public static final EntityType<Wolf> WOLF = null;
    public static final EntityType<Mooshroom> MUSHROOM_COW = null;
    public static final EntityType<SnowGolem> SNOWMAN = null;
    public static final EntityType<Ocelot> OCELOT = null;
    public static final EntityType<IronGolem> IRON_GOLEM = null;
    public static final EntityType<Horse> HORSE = null;
    public static final EntityType<Villager> VILLAGER = null;
    public static final EntityType<EnderCrystal> ENDER_CRYSTAL = null;
    public static final EntityType<ThrownPotion> SPLASH_POTION = null;
    public static final EntityType<Egg> EGG = null;
    public static final EntityType<FishHook> FISHING_HOOK = null;
    public static final EntityType<Lightning> LIGHTNING = null;
    public static final EntityType<WeatherEffect> WEATHER = null;
    public static final EntityType<Player> PLAYER = null;
    public static final EntityType<EnderDragonPart> COMPLEX_PART = null;
    public static final EntityType<Guardian> GUARDIAN = null;
    public static final EntityType<Rabbit> RABBIT = null;
    public static final EntityType<Endermite> ENDERMITE = null;
    public static final EntityType<?> UNKNOWN = null;

    private EntityTypes() {
    }
}
