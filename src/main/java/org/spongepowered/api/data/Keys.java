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
package org.spongepowered.api.data;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.entity.Banner;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.block.entity.CommandBlock;
import org.spongepowered.api.block.entity.EndGateway;
import org.spongepowered.api.block.entity.MobSpawner;
import org.spongepowered.api.block.entity.Piston;
import org.spongepowered.api.block.entity.Sign;
import org.spongepowered.api.block.entity.StructureBlock;
import org.spongepowered.api.block.entity.carrier.Beacon;
import org.spongepowered.api.block.entity.carrier.BrewingStand;
import org.spongepowered.api.block.entity.carrier.CarrierBlockEntity;
import org.spongepowered.api.block.entity.carrier.Hopper;
import org.spongepowered.api.block.entity.carrier.furnace.FurnaceBlockEntity;
import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.data.type.ArtType;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.type.BodyParts;
import org.spongepowered.api.data.type.CatType;
import org.spongepowered.api.data.type.ChestAttachmentType;
import org.spongepowered.api.data.type.ComparatorType;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.FoxType;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.Hinge;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.LlamaType;
import org.spongepowered.api.data.type.MatterState;
import org.spongepowered.api.data.type.MooshroomType;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.PandaGene;
import org.spongepowered.api.data.type.ParrotType;
import org.spongepowered.api.data.type.PickupRule;
import org.spongepowered.api.data.type.PortionType;
import org.spongepowered.api.data.type.Profession;
import org.spongepowered.api.data.type.RabbitType;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SlabPortion;
import org.spongepowered.api.data.type.SpellType;
import org.spongepowered.api.data.type.SpellTypes;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.type.Surface;
import org.spongepowered.api.data.type.VillagerType;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.data.type.WoodType;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.SetValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.WeightedCollectionValue;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOption;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.AreaEffectCloud;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.ai.goal.GoalExecutorTypes;
import org.spongepowered.api.entity.explosive.EnderCrystal;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.entity.explosive.fused.FusedExplosive;
import org.spongepowered.api.entity.explosive.fused.PrimedTNT;
import org.spongepowered.api.entity.hanging.Hanging;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.LeashKnot;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.ArmorStand;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Cat;
import org.spongepowered.api.entity.living.animal.Chicken;
import org.spongepowered.api.entity.living.animal.Fox;
import org.spongepowered.api.entity.living.animal.Ocelot;
import org.spongepowered.api.entity.living.animal.Panda;
import org.spongepowered.api.entity.living.animal.Parrot;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.entity.living.animal.PolarBear;
import org.spongepowered.api.entity.living.animal.Rabbit;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.animal.TameableAnimal;
import org.spongepowered.api.entity.living.animal.Turtle;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.animal.cow.Mooshroom;
import org.spongepowered.api.entity.living.animal.horse.Horse;
import org.spongepowered.api.entity.living.animal.horse.HorseEntity;
import org.spongepowered.api.entity.living.animal.horse.PackHorse;
import org.spongepowered.api.entity.living.animal.horse.llama.Llama;
import org.spongepowered.api.entity.living.animal.horse.llama.TraderLlama;
import org.spongepowered.api.entity.living.aquatic.Dolphin;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.golem.Shulker;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Endermite;
import org.spongepowered.api.entity.living.monster.Patroller;
import org.spongepowered.api.entity.living.monster.Phantom;
import org.spongepowered.api.entity.living.monster.boss.Wither;
import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.monster.guardian.Guardian;
import org.spongepowered.api.entity.living.monster.raider.Raider;
import org.spongepowered.api.entity.living.monster.raider.Ravager;
import org.spongepowered.api.entity.living.monster.raider.illager.Pillager;
import org.spongepowered.api.entity.living.monster.raider.illager.Vindicator;
import org.spongepowered.api.entity.living.monster.raider.illager.spellcaster.Evoker;
import org.spongepowered.api.entity.living.monster.raider.illager.spellcaster.Spellcaster;
import org.spongepowered.api.entity.living.monster.slime.Slime;
import org.spongepowered.api.entity.living.monster.spider.Spider;
import org.spongepowered.api.entity.living.monster.zombie.ZombiePigman;
import org.spongepowered.api.entity.living.monster.zombie.ZombieVillager;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.trader.Trader;
import org.spongepowered.api.entity.living.trader.Villager;
import org.spongepowered.api.entity.projectile.DamagingProjectile;
import org.spongepowered.api.entity.projectile.EyeOfEnder;
import org.spongepowered.api.entity.projectile.FishingBobber;
import org.spongepowered.api.entity.projectile.Potion;
import org.spongepowered.api.entity.projectile.ShulkerBullet;
import org.spongepowered.api.entity.projectile.arrow.ArrowEntity;
import org.spongepowered.api.entity.projectile.explosive.FireworkRocket;
import org.spongepowered.api.entity.projectile.explosive.fireball.FireballEntity;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.BlockOccupiedMinecart;
import org.spongepowered.api.entity.vehicle.minecart.CommandBlockMinecart;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartEntity;
import org.spongepowered.api.entity.weather.LightningBolt;
import org.spongepowered.api.entity.weather.WeatherEffect;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSources;
import org.spongepowered.api.fluid.FluidStackSnapshot;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.item.potion.PotionType;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.property.ProfileProperty;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.RespawnLocation;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.util.weighted.WeightedSerializableObject;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * An enumeration of known {@link Key}s used throughout the API.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class Keys {

    // SORTFIELDS:ON

    /**
     * Represents the {@link Key} for the absorption amount of any
     * {@link Living} entity.
     */
    public static final Supplier<Key<BoundedValue<Double>>> ABSORPTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ABSORPTION");

    /**
     * Represents the {@link Key} for the acceleration of a {@link FireballEntity}.
     */
    public static final Supplier<Key<Value<Vector3d>>> ACCELERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ACCELERATION");

    /**
     * Represents the {@link Key} for the item a {@link Living} is using.
     * For example a player eating a food or blocking with a shield.
     *
     * <p>If there is no item, the snapshot will be empty. You can check this
     * with {@link ItemStackSnapshot#isEmpty()}.</p>
     */
    public static final Supplier<Key<Value<ItemStackSnapshot>>> ACTIVE_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ACTIVE_ITEM");

    /**
     * Represents the {@link Key} for the "affecting spawning" state of
     * {@link Player}s.
     *
     * <p>A {@link Player} who does not affect spawning will be treated as a
     * spectator in regards to spawning. A {@link MobSpawner} will not be
     * activated by his presence and mobs around him may naturally despawn
     * if there is no other Player around who affects spawning.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> AFFECTS_SPAWNING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AFFECTS_SPAWNING");

    /**
     * Represents the {@link Key} for the age of any {@link Ageable entity}
     * in ticks.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> AGEABLE_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AGE");

    /**
     * Represents the {@link Key} for how angry a {@link ZombiePigman} is.
     *
     * <p>Unlike {@link Keys#IS_ANGRY}, the aggressiveness represented by this key may
     * fade over time and the entity will become peaceful again once its anger
     * reaches its minimum.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> ANGER_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ANGER");

    /**
     * Represents the {@link Key} for the age (in ticks) of an
     * {@link AreaEffectCloud} created by a lingering potion.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> AREA_EFFECT_CLOUD_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_AGE");

    /**
     * Represents the {@link Key} for the color of an {@link AreaEffectCloud}
     * created by a lingering potion.
     */
    public static final Supplier<Key<Value<Color>>> AREA_EFFECT_CLOUD_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_COLOR");

    /**
     * Represents the {@link Key} for the maximum age (in ticks) of an
     * {@link AreaEffectCloud} created by a lingering potion.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> AREA_EFFECT_CLOUD_DURATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_DURATION");

    /**
     * Represents the {@link Key} for the amount of ticks the duration of an
     * {@link AreaEffectCloud} is increased or reduced when it applies its
     * effect.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> AREA_EFFECT_CLOUD_DURATION_ON_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_DURATION_ON_USE");

    /**
     * Represents the {@link Key} for the particle type of an
     * {@link AreaEffectCloud} created by a lingering potion.
     *
     * <p>Only a few {@link ParticleOption}s will be usable for this
     * effect for specific {@link ParticleType}s and not every
     * {@link ParticleType} will be applicable.</p>
     */
    public static final Supplier<Key<Value<ParticleEffect>>> AREA_EFFECT_CLOUD_PARTICLE_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_PARTICLE_EFFECT");

    /**
     * Represents the {@link Key} for the radius of an {@link AreaEffectCloud}.
     */
    public static final Supplier<Key<BoundedValue<Double>>> AREA_EFFECT_CLOUD_RADIUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_RADIUS");

    /**
     * Represents the {@link Key} for the amount the radius of an
     * {@link AreaEffectCloud} grows or shrinks each time it applies its
     * effect.
     */
    public static final Supplier<Key<BoundedValue<Double>>> AREA_EFFECT_CLOUD_RADIUS_ON_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_RADIUS_ON_USE");

    /**
     * Represents the {@link Key} for the amount the radius of an
     * {@link AreaEffectCloud} grows or shrinks per tick.
     */
    public static final Supplier<Key<BoundedValue<Double>>> AREA_EFFECT_CLOUD_RADIUS_PER_TICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_RADIUS_PER_TICK");

    /**
     * Represents the {@link Key} for the delay (in ticks) after which an
     * {@link AreaEffectCloud} will reapply its effect on a previously
     * affected {@link Entity}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> AREA_EFFECT_CLOUD_REAPPLICATION_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_REAPPLICATION_DELAY");

    /**
     * Represents the {@link Key} for the duration in ticks after which an
     * {@link AreaEffectCloud} will begin to apply its effect to entities.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> AREA_EFFECT_CLOUD_WAIT_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AREA_EFFECT_CLOUD_WAIT_TIME");

    /**
     * Represents the {@link Key} for whether an {@link ArmorStand}'s arms are
     * visible.
     */
    public static final Supplier<Key<Value<Boolean>>> ARMOR_STAND_HAS_ARMS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ARMOR_STAND_HAS_ARMS");

    /**
     * Represents the {@link Key} for whether an {@link ArmorStand} has a
     * visible base plate.
     */
    public static final Supplier<Key<Value<Boolean>>> ARMOR_STAND_HAS_BASE_PLATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ARMOR_STAND_HAS_BASE_PLATE");

    /**
     * Represents the {@link Key} for if an {@link ArmorStand} is a "marker" stand.
     *
     * <p>If {@code true}, the armor stand's bounding box is near
     * impossible to see, and the armor stand can no longer be
     * interacted with.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> ARMOR_STAND_HAS_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ARMOR_STAND_HAS_MARKER");

    /**
     * Represents the {@link Key} for whether an {@link ArmorStand} is small.
     */
    public static final Supplier<Key<Value<Boolean>>> ARMOR_STAND_IS_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ARMOR_STAND_IS_SMALL");

    /**
     * Represents the {@link Key} for whether players are prevented from taking
     * items from an equipment slot on an {@link ArmorStand}
     */
    public static final Supplier<Key<SetValue<EquipmentType>>> ARMOR_STAND_PLACING_DISABLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ARMOR_STAND_PLACING_DISABLED");

    /**
     * Represents the {@link Key} for whether players are prevented from taking
     * items from an equipment slot on an {@link ArmorStand}
     */
    public static final Supplier<Key<SetValue<EquipmentType>>> ARMOR_STAND_TAKING_DISABLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ARMOR_STAND_TAKING_DISABLED");

    /**
     * Represents the {@link Key} for the type of {@link ArtType} shown by
     * (usually) a {@link Painting}.
     */
    public static final Supplier<Key<Value<ArtType>>> ART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ART");

    /**
     * Represents the {@link Key} for representing whether a {@link BlockState}
     * is "attached" to another block.
     */
    public static final Supplier<Key<Value<Boolean>>> ATTACHED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACHED");

    /**
     * Represents the {@link Key} for the attachment {@link Surface}
     * of a button or lever.
     */
    public static final Supplier<Key<Value<Surface>>> ATTACHMENT_SURFACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACHMENT_SURFACE");

    /**
     * Represents the {@link Key} for the damage dealt by a
     * {@link DamagingProjectile}, e.g. an {@link ArrowEntity}.
     */
    public static final Supplier<Key<BoundedValue<Double>>> ATTACK_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACK_DAMAGE");

    /**
     * Represents the {@link Key} for the time of a {@link Ravager} is considered attacking.
     */
    public static final Supplier<Key<Value<Integer>>> ATTACK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACK_TIME");

    /**
     * Represents the {@link Key} for representing the {@link Axis} direction
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Axis>>> AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AXIS");

    /**
     * Represents the {@link Key} for a {@link Banner}'s base {@link DyeColor}.
     */
    public static final Supplier<Key<Value<DyeColor>>> BANNER_BASE_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BANNER_BASE_COLOR");

    /**
     * Represents the {@link Key} for a {@link Banner}'s patterns.
     */
    public static final Supplier<Key<ListValue<PatternLayer>>> BANNER_PATTERNS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BANNER_PATTERNS");

    /**
     * Represents the {@link Key} for the width of the physical form of an
     * {@link Entity}.
     *
     * <p>Together with {@link #HEIGHT} this defines the size of an
     * {@link Entity}.</p>
     */
    public static final Supplier<Key<BoundedValue<Double>>> BASE_SIZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BASE_SIZE");

    /**
     * Represents the {@link Key} for the base vehicle a passenger is riding
     * at the moment. This may be different from {@link Keys#VEHICLE} as the
     * vehicle an {@link Entity} is riding may itself be the passenger of
     * another vehicle.
     */
    public static final Supplier<Key<Value<Entity>>> BASE_VEHICLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BASE_VEHICLE");

    /**
     * Represents the {@link Key} for a {@link Beacon}'s primary effect.
     */
    public static final Supplier<Key<Value<PotionEffectType>>> BEACON_PRIMARY_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BEACON_PRIMARY_EFFECT");

    /**
     * Represents the {@link Key} for a {@link Beacon}'s secondary effect.
     */
    public static final Supplier<Key<Value<PotionEffectType>>> BEACON_SECONDARY_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BEACON_SECONDARY_EFFECT");

    /**
     * Represents the {@link Key} for the {@link Living} who is being targeted by a
     * {@link Guardian}.
     */
    public static final Supplier<Key<Value<Living>>> BEAM_TARGET_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BEAM_TARGET_ENTITY");

    /**
     * Represents the {@link Key} for a {@link EnderCrystal}'s beam target.
     */
    public static final Supplier<Key<Value<Vector3i>>> BEAM_TARGET_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BEAM_TARGET_POSITION");

    /**
     * Represents the {@link Key} for the pore sides
     * of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<SetValue<Direction>>> BIG_MUSHROOM_PORES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIG_MUSHROOM_PORES");

    /**
     * Represents the {@link Key} for the {@link Direction#DOWN}
     * pores side of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> BIG_MUSHROOM_PORES_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIG_MUSHROOM_PORES_DOWN");

    /**
     * Represents the {@link Key} for the {@link Direction#EAST}
     * pores side of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> BIG_MUSHROOM_PORES_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIG_MUSHROOM_PORES_EAST");

    /**
     * Represents the {@link Key} for the {@link Direction#NORTH}
     * pores side of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> BIG_MUSHROOM_PORES_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIG_MUSHROOM_PORES_NORTH");

    /**
     * Represents the {@link Key} for the {@link Direction#SOUTH}
     * pores side of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> BIG_MUSHROOM_PORES_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIG_MUSHROOM_PORES_SOUTH");

    /**
     * Represents the {@link Key} for the {@link Direction#UP}
     * pores side of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> BIG_MUSHROOM_PORES_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIG_MUSHROOM_PORES_UP");

    /**
     * Represents the {@link Key} for the {@link Direction#WEST}
     * pores side of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> BIG_MUSHROOM_PORES_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIG_MUSHROOM_PORES_WEST");

    /**
     * Represents the {@link Key} for the temperature of a biome at a block location.
     */
    public static final Supplier<Key<Value<Double>>> BIOME_TEMPERATURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIOME_TEMPERATURE");

    /**
     * Represents the {@link Key} for the blast resistance of a block.
     */
    public static final Supplier<Key<Value<Double>>> BLAST_RESISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BLAST_RESISTANCE");

    /**
     * Represents the {@link Key} for the amount of light that is emitted by the
     * surrounding blocks at a block location. The value scales normally from 0 to 1.
     *
     * <p>In vanilla minecraft is this value in steps of 1/15 from 0 to 1.</p>
     */
    public static final Supplier<Key<Value<Double>>> BLOCK_LUMINANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BLOCK_LUMINANCE");

    /**
     * Represents the {@link Key} for the {@link BlockState} of a {@link BlockOccupiedMinecart} or {@link FallingBlock}.
     */
    public static final Supplier<Key<Value<BlockState>>> BLOCK_STATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BLOCK_STATE");

    /**
     * Represents the {@link Key} for if a {@link Boat} can move on land.
     */
    public static final Supplier<Key<Value<Boolean>>> BOAT_CAN_MOVE_ON_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BOAT_CAN_MOVE_ON_LAND");

    /**
     * Represents the {@link Key} for the max speed of a {@link Boat}. In vanilla, this is 0.4
     */
    public static final Supplier<Key<BoundedValue<Double>>> BOAT_MAX_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BOAT_MAX_SPEED");

    /**
     * Represents the {@link Key} for the deceleration a {@link Boat} while it has {@link Keys#PASSENGERS}.
     */
    public static final Supplier<Key<BoundedValue<Double>>> BOAT_OCCUPIED_DECELERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BOAT_OCCUPIED_DECELERATION");

    /**
     * Represents the {@link Key} for the deceleration a {@link Boat} while it does not have {@link Keys#PASSENGERS}.
     */
    public static final Supplier<Key<BoundedValue<Double>>> BOAT_UNOCCUPIED_DECELERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BOAT_UNOCCUPIED_DECELERATION");

    /**
     * Represents the {@link Key} for the rotation of specific body parts.
     *
     * <p>This value provides a mapping, effectively combining the data
     * referenced by {@link #HEAD_ROTATION}, {@link #CHEST_ROTATION},
     * {@link #RIGHT_ARM_ROTATION}, {@link #LEFT_ARM_ROTATION},
     * {@link #RIGHT_LEG_ROTATION}, and {@link #LEFT_LEG_ROTATION}.</p>
     */
    public static final Supplier<Key<MapValue<BodyPart, Vector3d>>> BODY_ROTATIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BODY_ROTATIONS");

    /**
     * Represents the {@link Key} for the author of a
     * {@link ItemTypes#WRITTEN_BOOK}.
     */
    public static final Supplier<Key<Value<Text>>> BOOK_AUTHOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BOOK_AUTHOR");

    /**
     * Represents the {@link Key} for the content of a
     * {@link ItemTypes#WRITTEN_BOOK}.
     *
     * <p>Use {@link Keys#PLAIN_BOOK_PAGES} if you wish to inspect the contents
     * of a {@link ItemTypes#WRITABLE_BOOK}.</p>
     */
    public static final Supplier<Key<ListValue<Text>>> BOOK_PAGES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BOOK_PAGES");

    /**
     * Represents the {@link Key} for the {@link BlockType}s able to be broken
     * by an item.
     */
    public static final Supplier<Key<SetValue<BlockType>>> BREAKABLE_BLOCK_TYPES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BREAKABLE_BLOCK_TYPES");

    /**
     * Represents the {@link Key} for the current breeder of an {@link Animal}, usually a {@link Player}.
     */
    public static final Supplier<Key<Value<UUID>>> BREEDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BREEDER");

    /**
     * Represents the {@link Key} for the breed time of an {@link Animal}.
     */
    public static final Supplier<Key<Value<Integer>>> BREED_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BREED_TIME");

    /**
     * Represents the {@link Key} for whether a {@link FallingBlock} can drop
     * as an item.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_DROP_AS_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_DROP_AS_ITEM");

    /**
     * Represents the {@link Key} for whether a {@link Humanoid} can fly.
     *
     * <p>For a {@link Player} this means he is able to toggle flight mode by
     * double-tapping his jump button.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_FLY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_FLY");

    /**
     * Represents the {@link Key} for whether a {@link Living} entity may
     * change blocks. This mostly applies to {@link Enderman} or
     * {@link Creeper}s, but also to some projectiles like {@link FireballEntity}s.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_GRIEF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_GRIEF");

    /**
     * Represents the {@link Key} for whether a {@link FallingBlock} will
     * damage an {@link Entity} it lands on.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_HURT_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_HURT_ENTITIES");

    /**
     * Represents the {@link Key} for if a {@link Raider} can join a raid.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_JOIN_RAID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_JOIN_RAID");

    /**
     * Represents the {@link Key} for whether a {@link FallingBlock} will place
     * itself upon landing.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_PLACE_AS_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_PLACE_AS_BLOCK");

    /**
     * Represents the {@link Key} for the current casting time of a {@link Spellcaster}.
     */
    public static final Supplier<Key<Value<Integer>>> CASTING_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CASTING_TIME");

    /**
     * Represents the {@link Key} for the type of a {@link Cat}.
     */
    public static final Supplier<Key<Value<CatType>>> CAT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAT_TYPE");

    /**
     * Represents the {@link Key} for the attachment of a {@link BlockTypes#CHEST}
     * or {@link BlockTypes#TRAPPED_CHEST}.
     */
    public static final Supplier<Key<Value<ChestAttachmentType>>> CHEST_ATTACHMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CHEST_ATTACHMENT");

    /**
     * Represents the {@link Key} for the rotation of the
     * {@link BodyParts#CHEST}.
     */
    public static final Supplier<Key<Value<Vector3d>>> CHEST_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CHEST_ROTATION");

    /**
     * Represents the {@link Key} for the {@link Color} of an
     * {@link ItemStack}.
     */
    public static final Supplier<Key<Value<Color>>> COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "COLOR");

    /**
     * Represents a key for the stored command, mostly related to
     * {@link CommandBlock}s and {@link CommandBlockMinecart}s.
     */
    public static final Supplier<Key<Value<String>>> COMMAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "COMMAND");

    /**
     * Represents the {@link Key} for representing the {@link ComparatorType}
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<ComparatorType>>> COMPARATOR_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "COMPARATOR_TYPE");

    /**
     * Represents the {@link Key} for representing the connected directions
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<SetValue<Direction>>> CONNECTED_DIRECTIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CONNECTED_DIRECTIONS");

    /**
     * Represents the {@link Key} for representing the "connected to the east"
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> CONNECTED_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CONNECTED_EAST");

    /**
     * Represents the {@link Key} for representing the "connected to the north"
     * state of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> CONNECTED_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CONNECTED_NORTH");

    /**
     * Represents the {@link Key} for representing the "connected to the south"
     * state of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> CONNECTED_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CONNECTED_SOUTH");

    /**
     * Represents the {@link Key} for representing the "connected to up"
     * state of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> CONNECTED_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CONNECTED_UP");

    /**
     * Represents the {@link Key} for representing the "connected to the west"
     * state of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> CONNECTED_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CONNECTED_WEST");

    /**
     * Represents the {@link Key} for the amount of ticks a {@link Hopper} has
     * to cool down before transferring the next item.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> COOLDOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "COOLDOWN");

    /**
     * Represents the {@link Key} for the creator, usually of an {@link Entity}. It is up to the implementation to define.
     */
    public static final Supplier<Key<Value<UUID>>> CREATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CREATOR");

    /**
     * Represents the {@link Key} for whether the next attack of an
     * {@link Entity} will be a critical hit.
     */
    public static final Supplier<Key<Value<Boolean>>> CRITICAL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CRITICAL_HIT");

    /**
     * Represents the {@link Key} of the current {@link SpellType} a {@link Spellcaster} is casting.
     */
    public static final Supplier<Key<Value<SpellType>>> CURRENT_SPELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CURRENT_SPELL");

    /**
     * Represents the {@link Key} for the damage dealt towards entities of a
     * specific {@link EntityType}.
     *
     * <p>Note that in events, the damage defined for the provided
     * {@link EntityType} will take priority over the "default" damage as
     * defined from {@link DamagingProjectile#attackDamage()}.</p>
     *
     * <p>Types not present in this mapping will be
     * dealt damage to according to {@link #ATTACK_DAMAGE}.</p>
     */
    public static final Supplier<Key<MapValue<EntityType<?>, Double>>> CUSTOM_ATTACK_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CUSTOM_ATTACK_DAMAGE_MAPPING");

    /**
     * Represents the {@link Key} for whether a custom name is visible on an
     * {@link Entity}.
     */
    public static final Supplier<Key<Value<Boolean>>> CUSTOM_NAME_VISIBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CUSTOM_NAME_VISIBLE");

    /**
     * Represents the {@link Key} for how much damage a {@link FallingBlock}
     * deals to {@link Living} entities it hits.
     *
     * <p>This damage is capped by {@link #MAX_FALL_DAMAGE}.</p>
     */
    public static final Supplier<Key<BoundedValue<Double>>> DAMAGE_PER_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DAMAGE_PER_BLOCK");

    /**
     * Represents the {@link Key} for representing at which distance a {@link BlockState}
     * will decay. This usually applies to leaves, for example {@link BlockTypes#OAK_LEAVES}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> DECAY_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DECAY_DISTANCE");

    /**
     * Represents the {@link Key} for the delay on a redstone repeater.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DELAY");

    /**
     * Represents the {@link Key} for representing the despawn delay of a {@link Item} or {@link TraderLlama}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> DESPAWN_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DESPAWN_DELAY");

    /**
     * Represents the {@link Key} for the detonator of a {@link PrimedTNT}.
     */
    public static final Supplier<Key<Value<Living>>> DETONATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DETONATOR");

    /**
     * Represents the {@link Key} for representing the {@link Direction} a {@link BlockState}, {@link Hanging}, or {@link Shulker} is facing or the
     * heading of a {@link ShulkerBullet}.
     */
    public static final Supplier<Key<Value<Direction>>> DIRECTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DIRECTION");

    /**
     * Represents the {@link Key} for representing the "disarmed" state
     * of a {@link BlockState}. This usually applies to
     * {@link BlockTypes#TRIPWIRE}s and {@link BlockTypes#TRIPWIRE_HOOK}s.
     */
    public static final Supplier<Key<Value<Boolean>>> DISARMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DISARMED");

    /**
     * Represents the {@link Key} for displaying the chest of a {@link PackHorse}.
     */
    public static final Supplier<Key<Value<Boolean>>> DISPLAY_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DISPLAY_CHEST");

    /**
     * Represents the {@link Key} for the display name of an {@link Entity},
     * {@link ItemStack} or {@link BlockEntity}.
     *
     * <p>On a {@link ItemTypes#WRITTEN_BOOK} item this will also set the title
     * of the book.</p>
     */
    public static final Supplier<Key<Value<Text>>> DISPLAY_NAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DISPLAY_NAME");

    /**
     * Represents the {@link Key} for representing the "got fish" state of a {@link Dolphin}.
     *
     * <p>
     *     Dolphins will navigate to a treasure (if a structure that provides one is nearby)
     *     if they have been given a fish.
     * </p>
     */
    public static final Supplier<Key<Value<Boolean>>> DOLPHIN_DOES_GOT_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DOLPHIN_DOES_GOT_FISH");

    /**
     * Represents the {@link Key} for representing the "moisture" state of a {@link Dolphin}.
     *
     * <p>
     *     Vanilla sets the dolphin's skin moisture to 2400 so long as the entity
     *     is in water, being rained on, or in a bubble column. If not, the dolphin
     *     will loose 1 moisture per tick. Once this value is 0 or below, the dolphin
     *     will be damaged via {@link DamageSources#DRYOUT} with a value of 1 per tick
     *     until death.
     * </p>
     */
    public static final Supplier<Key<Value<Integer>>> DOLPHIN_SKIN_MOISTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DOLPHIN_SKIN_MOISTURE");

    /**
     * Represents the {@link Key} for representing the dominant {@link HandPreference}
     * of a {@link Living} entity.
     *
     * <p><em>NOTE:</em> For {@link Player}s is this key read-only, the
     * {@link HandPreference} of a player can not be changed server-side.</p>
     */
    public static final Supplier<Key<Value<HandPreference>>> DOMINANT_HAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DOMINANT_HAND");

    /**
     * Represents the {@link Key} for the color of a dyeable block, item or
     * entity.
     */
    public static final Supplier<Key<Value<DyeColor>>> DYE_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DYE_COLOR");

    /**
     * Represents the {@link Key} for the time a {@link Panda} has been eating (in ticks)
     */
    public static final Supplier<Key<Value<Integer>>> EATING_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EATING_TIME");

    /**
     * Represents the {@link Key} for the time until a {@link Chicken} lays an {@link ItemTypes#EGG}.
     *
     * <p>
     *     Vanilla will calculate the egg timer by taking a random value between
     *     0 (inclusive) and 6000 (exclusive) and then add that by another 6000.
     *     This unit ends up being in ticks. Once the chicken lays the egg, this
     *     calculation is ran again.
     * </p>
     */
    public static final Supplier<Key<Value<Integer>>> EGG_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EGG_TIME");

    /**
     * Represents the {@link Key} for representing the age of
     * an {@link EndGateway}.
     */
    public static final Supplier<Key<Value<Long>>> END_GATEWAY_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "END_GATEWAY_AGE");

    /**
     * Represents the {@link Key} for representing the teleport cooldown of
     * an {@link EndGateway}.
     */
    public static final Supplier<Key<Value<Integer>>> END_GATEWAY_TELEPORT_COOLDOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "END_GATEWAY_TELEPORT_COOLDOWN");

    /**
     * Represents the {@link Key} for representing if the exact teleport location
     * should be used with a {@link EndGateway}.
     */
    public static final Supplier<Key<Value<Boolean>>> EXACT_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXACT_TELEPORT");

    /**
     * Represents the {@link Key} for the current level of exhaustion of a
     * {@link Humanoid}.
     *
     * <p>When the exhaustion level reaches 0, saturation is usually diminished
     * such that saturation is decreased and then exhaustion is reset to the
     * maximum. This type of effect occurs over time and can be modified by
     * movements and actions performed by the {@link Humanoid}.</p>
     */
    public static final Supplier<Key<BoundedValue<Double>>> EXHAUSTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXHAUSTION");

    /**
     * Represents the {@link Key} for representing the exit
     * portal {@link Vector3i location} of an {@link EndGateway}.
     */
    public static final Supplier<Key<Value<Vector3i>>> EXIT_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXIT_PORTAL");

    /**
     * Represents the {@link Key} for the amount of experience a {@link Player} has or an {@link ExperienceOrb} contains
     */
    public static final Supplier<Key<BoundedValue<Integer>>> EXPERIENCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPERIENCE");

    /**
     * Represents the {@link Key} for the total experience a {@link Player}
     * requires to advance from his current level to the next one.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> EXPERIENCE_FROM_START_OF_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPERIENCE_FROM_START_OF_LEVEL");

    /**
     * Represents the {@link Key} for the current level a {@link Player} has.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> EXPERIENCE_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPERIENCE_LEVEL");

    /**
     * Represents the {@link Key} for the amount of experience a {@link Player}
     * has collected towards the next level.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> EXPERIENCE_SINCE_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPERIENCE_SINCE_LEVEL");

    /**
     * Represents the {@link Key} for how long an {@link Endermite}, {@link Item}, or {@link Weather} will last before expiring.
     */
    public static final Supplier<Key<Value<Duration>>> EXPIRATION_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPIRATION_DELAY");

    /**
     * Represents the {@link Key} for the radius of the {@link Explosion} to
     * be created by detonating an {@link Explosive}.
     *
     * <p>May be absent if the explosion radius is unknown because it is either
     * determined randomly at the time of the explosion or computed from the
     * context in which the {@link Explosive} explodes.</p>
     */
    public static final Supplier<Key<Value<Integer>>> EXPLOSION_RADIUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPLOSION_RADIUS");

    /**
     * Represents the {@link Key} for representing whether a {@link Piston} is
     * currently extended.
     */
    public static final Supplier<Key<Value<Boolean>>> EXTENDED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXTENDED");

    /**
     * Represents the {@link Key} for the distance an entity has
     * fallen.
     */
    public static final Supplier<Key<BoundedValue<Double>>> FALL_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FALL_DISTANCE");

    /**
     * Represents the {@link Key} for the amount of ticks a {@link FallingBlock} has been falling for.
     */
    public static final Supplier<Key<Value<Integer>>> FALL_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FALL_TIME");

    /**
     * Represents the {@link Key} for representing the "filled" state
     * of a {@link BlockState}.
     *
     * <p>Usually applies to {@link BlockTypes#END_PORTAL_FRAME}s.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> FILLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FILLED");

    /**
     * Represents the {@link Key} for the {@link FireworkEffect}s of a
     * {@link ItemTypes#FIREWORK_STAR}, {@link ItemTypes#FIREWORK_ROCKET} or a
     * {@link FireworkRocket}.
     */
    public static final Supplier<Key<ListValue<FireworkEffect>>> FIREWORK_EFFECTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIREWORK_EFFECTS");

    /**
     * Represents the {@link Key} for the flight duration of a firework.
     *
     * <p>The duration is tiered and will stay partially random. A rocket will
     * fly for roughly {@code modifier * 10 + (random number from 0 to 13)}
     * ticks in Vanilla Minecraft.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> FIREWORK_FLIGHT_MODIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIREWORK_FLIGHT_MODIFIER");

    /**
     * Represents the {@link Key} for the delay in ticks until the
     * {@link Entity} will be damaged by the fire.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> FIRE_DAMAGE_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIRE_DAMAGE_DELAY");

    /**
     * Represents the {@link Key} for the amount of ticks an
     * {@link Entity} is still burning.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> FIRE_TICKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIRE_TICKS");

    /**
     * Represents the {@link Key} for the time a {@link Player} first played
     * on the Server.
     */
    public static final Supplier<Key<Value<Instant>>> FIRST_DATE_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIRST_DATE_PLAYED");

    /**
     * Represents the {@link Key} for a {@link Fox fox's} first trusted {@link UUID}, usually a {@link Player}.
     */
    public static final Supplier<Key<Value<UUID>>> FIRST_TRUSTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIRST_TRUSTED");

    /**
     * Represents the {@link Key} for representing the
     * {@link FluidStackSnapshot} contained within an item container. Item
     * containers may include buckets and other mod added items.
     */
    public static final Supplier<Key<Value<FluidStackSnapshot>>> FLUID_ITEM_STACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FLUID_ITEM_STACK");

    /**
     * Represents the {@link Key} for representing the "fluid level" state
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> FLUID_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FLUID_LEVEL");

    /**
     * Represents the {@link Key} for representing the directional tank
     * information.
     */
    public static final Supplier<Key<MapValue<Direction, List<FluidStackSnapshot>>>> FLUID_TANK_CONTENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FLUID_TANK_CONTENTS");

    /**
     * Represents the {@link Key} for the speed at which an entity flies.
     */
    public static final Supplier<Key<Value<Double>>> FLYING_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FLYING_SPEED");

    /**
     * Represents the {@link Key} for the food level of a {@link Humanoid}.
     *
     * <p>For a {@link Humanoid}, food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the humanoid may heal. If the food level is at 0,
     * the humanoid may starve.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> FOOD_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FOOD_LEVEL");

    /**
     * Represents the {@link Key} for the type of a {@link Fox}.
     */
    public static final Supplier<Key<Value<FoxType>>> FOX_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FOX_TYPE");

    /**
     * Represents the {@link Key} for the modifier to {@link Keys#VELOCITY} of a {@link Minecart} while airborne.
     */
    public static final Supplier<Key<Value<Duration>>> FURNACE_MINECART_FUEL_DURATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MINECART_FUEL_DURATION");

    /**
     * Represents the {@link Key} for the time a {@link FusedExplosive}'s fuse
     * will burn before the explosion.
     */
    public static final Supplier<Key<Value<Integer>>> FUSE_DURATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FUSE_DURATION");

    /**
     * Represents the {@link Key} for the {@link GameMode} a {@link Humanoid}
     * has.
     */
    public static final Supplier<Key<Value<GameMode>>> GAME_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "GAME_MODE");

    /**
     * Represents the {@link Key} for the generation of a
     * {@link ItemTypes#WRITTEN_BOOK}. Depending on the book's generation
     * it may be impossible to copy it.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> GENERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "GENERATION");

    /**
     * Represents the {@link Key} for representing whether an entity has a
     * glowing outline.
     */
    public static final Supplier<Key<Value<Boolean>>> GLOWING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "GLOWING");

    /**
     * Represents the {@link Key} for representing the "growth stage" state
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> GROWTH_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "GROWTH_STAGE");

    /**
     * Represents the {@link Key} for the hardness of something, usually a block.
     */
    public static final Supplier<Key<BoundedValue<Double>>> HARDNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HARDNESS");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is affected by
     * gravity.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_GRAVITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_GRAVITY");

    /**
     * Represents the {@link Key} for the rotation of a {@link Living Living's} head.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><li>{@code x -&gt; pitch</code></li><li> <code>y -&gt; yaw</code></li><li><code>z -&gt; roll
     * }</li></ul>
     *
     * <p>Note that the pitch will be the same x value returned by
     * {@link Entity#getRotation()} and Minecraft does not currently support
     * head roll so the z value will always be zero.</p>
     */
    public static final Supplier<Key<Value<Vector3d>>> HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEAD_ROTATION");

    /**
     * Represents the {@link Key} for the {@link EnderCrystal} currently healing an {@link EnderDragon}.
     */
    public static final Supplier<Key<Value<EnderCrystal>>> HEALING_CRYSTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEALING_CRYSTAL");

    /**
     * Represents the {@link Key} for a {@link Living}'s current health.
     *
     * <p>The range of the health depends on the object on which this
     * method is defined. For {@link Player Players} in Minecraft, the nominal range is
     * between 0 and 20, inclusive, but the range can be adjusted.</p>
     *
     * <p>Convention dictates that health does not follow below 0 but this
     * convention may be broken.</p>
     */
    public static final Supplier<Key<BoundedValue<Double>>> HEALTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEALTH");

    /**
     * Represents the {@link Key} for how much health a half-heart on a
     * {@link Player}'s GUI will stand for.
     */
    public static final Supplier<Key<BoundedValue<Double>>> HEALTH_SCALE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEALTH_SCALE");

    /**
     * Represents the {@link Key} for the height of the physical form of an
     * {@link Entity}.
     *
     * <p>Together with {@link #BASE_SIZE} this defines the size of an
     * {@link Entity}.</p>
     */
    public static final Supplier<Key<BoundedValue<Double>>> HEIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEIGHT");

    /**
     * Represents the {@link Key} for the hidden {@link PandaGene gene} of a {@link Panda}.
     */
    public static final Supplier<Key<Value<PandaGene>>> HIDDEN_GENE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDDEN_GENE");

    /**
     * Represents the {@link Key} for representing the "attributes hidden"
     * state of an {@link ItemStack}.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_ATTRIBUTES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_ATTRIBUTES");

    /**
     * Represents the {@link Key} for representing the "can destroy hidden"
     * state of an {@link ItemStack}.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_CAN_DESTROY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_CAN_DESTROY");

    /**
     * Represents the {@link Key} for representing the "can place hidden"
     * state of an {@link ItemStack}.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_CAN_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_CAN_PLACE");

    /**
     * Represents the {@link Key} for representing the "enchantments hidden"
     * state of an {@link ItemStack}.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_ENCHANTMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_ENCHANTMENTS");

    /**
     * Represents the {@link Key} for representing the "miscellaneous hidden"
     * state of an {@link ItemStack}.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_MISCELLANEOUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_MISCELLANEOUS");

    /**
     * Represents the {@link Key} for representing the "unbreakable hidden"
     * state of an {@link ItemStack}.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_UNBREAKABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_UNBREAKABLE");

    /**
     * Represents the {@link Key} for representing the {@link Hinge}
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Hinge>>> HINGE_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HINGE_POSITION");

    /**
     * Represents the {@link Key} for the style of a {@link Horse}.
     */
    public static final Supplier<Key<Value<HorseStyle>>> HORSE_STYLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HORSE_STYLE");

    /**
     * Represents the {@link Key} for the color of a {@link Horse}.
     */
    public static final Supplier<Key<Value<HorseColor>>> HORSE_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HORSE_COLOR");

    /**
     * Represents the {@link Key} for whether an {@link Item} will not despawn
     * for an infinite time.
     */
    public static final Supplier<Key<Value<Boolean>>> INFINITE_DESPAWN_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INFINITE_DESPAWN_DELAY");

    /**
     * Represents the {@link Key} for representing the "is infinite" state
     * of the pickup delay of an {@link Item}.
     */
    public static final Supplier<Key<Value<Boolean>>> INFINITE_PICKUP_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INFINITE_PICKUP_DELAY");

    /**
     * Represents the {@link Key} for the {@link InstrumentType}
     * of a {@link BlockTypes#NOTE_BLOCK}.
     */
    public static final Supplier<Key<Value<InstrumentType>>> INSTRUMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INSTRUMENT");

    /**
     * Represents the {@link Key} for the "inverted" state of
     * an {@link BlockTypes#DAYLIGHT_DETECTOR}.
     */
    public static final Supplier<Key<Value<Boolean>>> INVERTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INVERTED");

    /**
     * Represents the {@link Key} for representing the "vanish" state
     * of an {@link Entity}. This will only simply render the entity as
     * vanish, but not prevent any entity updates being sent to clients.
     * To fully "vanish" an {@link Entity}, use {@link #VANISH}.
     */
    public static final Supplier<Key<Value<Boolean>>> INVISIBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INVISIBLE");

    /**
     * Represents the {@link Key} for the amount of ticks an {@link Entity}
     * will remain invulnerable for.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> INVULNERABILITY_TICKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INVULNERABILITY_TICKS");

    /**
     * Represents the {@link Key} for representing if an {@link Entity}
     * is invulnerable or not.
     *
     * <p>This does not protect from the void, players in creative mode,
     * and manual killing like the /kill command.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> INVULNERABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INVULNERABLE");

    /**
     * Represents the {@link Key} for representing the "in-wall" state of
     * fences, for example {@link BlockTypes#OAK_FENCE}.
     */
    public static final Supplier<Key<Value<Boolean>>> IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IN_WALL");

    /**
     * Represents the {@link Key} for the state whether a {@link Ageable}
     * entity is considered an "adult" and may affect breeding capabilities.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ADULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ADULT");

    /**
     * Represents the {@link Key} for whether a {@link Blaze} is currently
     * burning.
     *
     * <p>Unlike {@link Keys#MAX_BURN_TIME}, the burning effect will not damage
     * the burning entity.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_AFLAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_AFLAME");

    /**
     * Represents the {@link Key} for whether an {@link Agent}s AI is enabled.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_AI_ENABLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_AI_ENABLED");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is currently
     * aggressive. This mostly applies to wolves.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ANGRY");

    /**
     * Represents the {@link Key} for if {@link Raider}s are currently celebrating.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CELEBRATING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CELEBRATING");

    /**
     * Represents the {@link Key} for whether a {@link Creeper} is charged.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CHARGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CREEPER_CHARGED");

    /**
     * Represents the {@link Key} for if a {@link Pillager} is charging it's crossbow.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CHARGING_CROSSBOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CHARGING_CROSSBOW");

    /**
     * Represents the {@link Key} for if a {@link Spider} is currently climbing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CLIMBING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CLIMBING");

    /**
     * Represents the {@link Key} for if a {@link Fox} is currently crouching.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CROUCHING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CROUCHING");

    /**
     * Represents the {@link Key} for if a {@link Fox} is currently defending.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_DEFENDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_DEFENDING");

    /**
     * Represents the {@link Key} for whether a {@link Player} is flying with an
     * {@link ItemTypes#ELYTRA}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ELYTRA_FLYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ELYTRA_FLYING");

    /**
     * Represents the {@link Key} for if a {@link Fox} is currently faceplanted.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_FACEPLANTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_FACEPLANTED");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is flying.
     *
     * <p>This key only tells whether an entity is flying at the moment. On a
     * {@link Player} it does not necessarily mean that the player may toggle
     * freely between flying and walking. To check whether a player may switch
     * his flying state, check {@link #CAN_FLY}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_FLYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_FLYING");

    /**
     * Represents the {@link Key} for if a {@link WeatherEffect} is harmful to other {@link Entity entities}.
     *
     * <p>
     *     For example, {@link LightningBolt bolts} of lighting will strike entities and damage them
     * </p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_HARMFUL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_WEATHER_EFFECT");

    /**
     * Represents the {@link Key} for if a {@link Fox} is currently interested in something.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_INTERESTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_INTERESTED");

    /**
     * Represents the {@link Key} for if a {@link Boat} is currently in {@link BlockTypes#WATER}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_IN_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_IN_WATER");

    /**
     * Represents the {@link Key} for whether a {@link Vindicator} is exhibiting
     * "johnny" behavior.
     *
     * @see <a href="https://minecraft.gamepedia.com/Vindicator#Behavior">
     * The Minecraft Wiki for more information about "johnny" behavior</a>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_JOHNNY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_JOHNNY");

    /**
     * Represents the {@link Key} for if a {@link Cat} is lying down.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_LYING_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_LYING_DOWN");

    /**
     * Represents the {@link Key} for if a {@link Panda} is lying on it's back.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_LYING_ON_BACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_LYING_ON_BACK");

    /**
     * Represents the {@link Key} for if a {@link IronGolem} has been created by a {@link Player}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_PLAYER_CREATED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PLAYER_CREATED");

    /**
     * Represents the {@link Key} for whether a {@link Villager} is playing.
     *
     * <p>In Vanilla, this only applies to villagers that are considered
     * "babies" according to {@link #AGEABLE_AGE}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_PLAYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PLAYING");

    /**
     * Represents the {@link Key} for if a {@link Fox} is currently pouncing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_POUNCING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_POUNCING");

    /**
     * Represents the {@link Key} for if a {@link Cat} is relaxed.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_RELAXED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RELAXED");

    /**
     * Represents the {@link Key} for if a {@link Panda} is rolling around.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ROLLING_AROUND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ROLLING_AROUND");

    /**
     * Represents the {@link Key} for whether a {@link Entity} is saddled.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SADDLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SADDLED");

    /**
     * Represents the {@link Key} for whether an {@link Enderman} is screaming.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SCREAMING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SCREAMING");

    /**
     * Represents the {@link Key} for whether a {@link Sheep} is sheared.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SHEARED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SHEARED");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is silent.
     *
     * <p>A silent entity will not emit sounds or make noises.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SILENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SILENT");

    /**
     * Represents the {@link Key} for whether a {@link Wolf}, {@link Cat}, {@link Panda}, or {@link Fox} is sitting.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SITTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SITTING");

    /**
     * Represents the {@link Key} for whether a {@link Bat}, {@link Fox} or {@link Player}
     * is sleeping.
     *
     * <p>If a player is considered sleeping as per this data value, he does
     * not need to be in bed in order for the other players to be able to
     * advance through the night by going to bed.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SLEEPING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SLEEPING");

    /**
     * Represents the {@link Key} for if a {@link Player Player's} sleeping status is ignored when checking whether to
     * skip the night due to players sleeping. The time in a world will be
     * advanced to day if all players in it either are sleeping or are set to ignore.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SLEEPING_IGNORED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SLEEPING_IGNORED");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is sneaking.
     *
     * <p>Sneaking entities generally move slower and do not make walking
     * sounds.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SNEAKING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SNEAKING");

    /**
     * Represents the {@link Key} for if a {@link Panda} is sneezing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SNEEZING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SNEEZING");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is sprinting.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SPRINTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SPRINTING");

    /**
     * Represents the {@link Key} for if a {@link PolarBear} is currently standing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_STANDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_STANDING");

    /**
     * Represents the {@link Key} for if a {@link TameableAnimal} is currently tamed
     */
    public static final Supplier<Key<Value<Boolean>>> IS_TAMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_TAMED");

    /**
     * Represents the {@link Key} for if a {@link Trader} is currently trading with a {@link Player}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_TRADING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_TRADING");

    /**
     * Represents the {@link Key} for if an {@link Ocelot} is currently trusting of {@link Player}s.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_TRUSTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_TRUSTING");

    /**
     * Represents the {@link Key} for whether an {@link ItemStack} is unbreakable.
     *
     * <p>Setting this to {@code  true} will prevent the item stack's
     * {@link #ITEM_DURABILITY} from changing.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_UNBREAKABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_UNBREAKABLE");

    /**
     * Represents the {@link Key} for whether a {@link Wolf}, a
     * {@link BlockState} of {@link BlockTypes#SPONGE} or an {@link ItemStack}
     * of {@link ItemTypes#SPONGE} is wet.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_WET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_WET");

    /**
     * Represents the {@link Key} for the durability of an {@link ItemStack}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> ITEM_DURABILITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ITEM_DURABILITY");

    /**
     * Represents the {@link Key} for the enchantments applied to an
     * {@link ItemStack}.
     *
     * <p>This data is usually applicable to all types of armor, weapons and
     * tools. Enchantments that are only stored on an item stack in order to
     * be transferred to another item (like on
     * {@link ItemTypes#ENCHANTED_BOOK}s) use the {@link #STORED_ENCHANTMENTS}
     * key instead.)</p>
     */
    public static final Supplier<Key<ListValue<Enchantment>>> ITEM_ENCHANTMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ITEM_ENCHANTMENTS");

    /**
     * Represents the {@link Key} for the displayed description ("lore") text
     * of an {@link ItemStack}.
     *
     * <p>The lore text is usually displayed when the player hovers his cursor
     * over the stack. For the contents of a book see {@link #BOOK_PAGES}
     * instead.</p>
     */
    public static final Supplier<Key<ListValue<Text>>> ITEM_LORE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ITEM_LORE");

    /**
     * Represents the {@link Key} for the {@link ItemStackSnapshot item} in an {@link Item}, {@link ItemFrame}, or {@link Potion}.
     */
    public static final Supplier<Key<Value<ItemStackSnapshot>>> ITEM_STACK_SNAPSHOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ITEM_STACK_SNAPSHOT");

    /**
     * Represents the {@link Key} for the knockback strength applied by an
     * {@link ArrowEntity}.
     *
     * <p>For the knockback provided by hits with a weapon according to the
     * enchantment of the same name, see {@link #ITEM_ENCHANTMENTS}.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> KNOCKBACK_STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "KNOCKBACK_STRENGTH");

    /**
     * Represents the {@link Key} for the known {@link PandaGene gene} of a {@link Panda}.
     */
    public static final Supplier<Key<Value<PandaGene>>> KNOWN_GENE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "KNOWN_GENE");

    /**
     * Represents the {@link Key} for the last attacking {@link Entity} of a {@link Living}.
     */
    public static final Supplier<Key<Value<Entity>>> LAST_ATTACKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAST_ATTACKER");

    /**
     * Represents the {@link Key} for the output yielded by the last command of
     * a {@link CommandBlock}.
     */
    public static final Supplier<Key<Value<Text>>> LAST_COMMAND_OUTPUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAST_COMMAND_OUTPUT");

    /**
     * Represents the {@link Key} for the last time a {@link User} has been
     * playing on the server.
     */
    public static final Supplier<Key<Value<Instant>>> LAST_DATE_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAST_DATE_PLAYED");

    /**
     * Represents the {@link Key} for representing the "layer" value of
     * {@link BlockTypes#SNOW} and other possible layered blocks.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> LAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAYER");

    /**
     * Represents the {@link Key} for if a {@link Patroller} is the leader.
     */
    public static final Supplier<Key<Value<Boolean>>> LEADER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LEADER");

    /**
     * Represents the {@link Key} for the leashed {@link Entity} of a {@link LeashKnot}.
     *
     * <p>Usually, a {@link LeashKnot} will always exist so long as there is
     * a leashed {@link Entity} attached. If the leash is broken, the leash
     * hitch is removed.</p>
     */
    public static final Supplier<Key<Value<Entity>>> LEASHED_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LEASHED_ENTITY");

    /**
     * Represents the {@link Key} for the rotation of an {@link Entity}'s left
     * arm.
     */
    public static final Supplier<Key<Value<Vector3d>>> LEFT_ARM_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LEFT_ARM_ROTATION");

    /**
     * Represents the {@link Key} for the rotation of an {@link Entity}'s left
     * leg.
     */
    public static final Supplier<Key<Value<Vector3d>>> LEFT_LEG_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LEFT_LEG_ROTATION");

    /**
     * Represents the {@link Key} of the amount of light that emitted by a light source,
     * usually blocks.
     */
    public static final Supplier<Key<Value<Integer>>> LIGHT_EMISSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LIGHT_EMISSION");

    /**
     * Represents the {@link Key} for the state that something is "lit",
     * for example a {@link BlockTypes#FURNACE} or {@link BlockTypes#REDSTONE_TORCH}.
     */
    public static final Supplier<Key<Value<Boolean>>> LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LIT");

    /**
     * Represents the {@link Key} for a {@link Llama}s carrying strength. The higher the strength,
     * the more items it can carry (effectively the size of inventory).
     */
    public static final Supplier<Key<BoundedValue<Integer>>> LLAMA_STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LLAMA_STRENGTH");

    /**
     * Represents the {@link Key} for a {@link Llama}'s {@link LlamaType}.
     */
    public static final Supplier<Key<Value<LlamaType>>> LLAMA_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LLAMA_TYPE");

    /**
     * Represents the {@link Key} for the token used to lock a
     * {@link CarrierBlockEntity}.
     */
    public static final Supplier<Key<Value<String>>> LOCK_TOKEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LOCK_TOKEN");

    /**
     * Represents the {@link Key} for the matter
     * state. Usually of a block.
     */
    public static final Supplier<Key<Value<MatterState>>> MATTER_STATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MATTER_STATE");

    /**
     * Represents the {@link Key} for the maximum air supply a {@link Living}
     * may have.
     *
     * <p>For the current amount of air, check {@link #REMAINING_AIR}.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> MAX_AIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_AIR");

    /**
     * Represents the {@link Key} for the maximum amount of ticks a
     * {@link FurnaceBlockEntity} can burn with the currently used fuel item.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> MAX_BURN_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_BURN_TIME");

    /**
     * Represents the {@link Key} for the total time the current
     * {@link ItemStack} in a {@link FurnaceBlockEntity} has to be cooked.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> MAX_COOK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_COOK_TIME");

    /**
     * Represents the {@link Key} for the maximum damage a {@link FallingBlock}
     * can deal.
     */
    public static final Supplier<Key<BoundedValue<Double>>> MAX_FALL_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_FALL_DAMAGE");

    /**
     * Represents the {@link Key} for the maximum health of a {@link Living}.
     *
     * <p>The maximum health set here may affect the attribute increasing
     * health points. The base health should be minded that it may be lower
     * than the total maximum health of the entity.</p>
     */
    public static final Supplier<Key<BoundedValue<Double>>> MAX_HEALTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_HEALTH");

    /**
     * Represents the {@link Key} for the modifier to {@link Keys#VELOCITY} of a {@link Minecart} while airborne.
     */
    public static final Supplier<Key<Value<Vector3d>>> MINECART_AIRBORNE_VELOCITY_MODIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MINECART_AIRBORNE_VELOCITY_MODIFIER");

    /**
     * Represents the {@link Key} for the modifier to {@link Keys#VELOCITY} of a {@link Minecart} while derailed.
     */
    public static final Supplier<Key<Value<Vector3d>>> MINECART_DERAILED_VELOCITY_MODIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MINECART_DERAILED_VELOCITY_MODIFIER");

    /**
     * Represents the {@link Key} for if a {@link Minecart} is on it's rail
     */
    public static final Supplier<Key<Value<Boolean>>> MINECART_IS_ON_RAIL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MINECART_IS_ON_RAIL");

    /**
     * Represents the {@link Key} for the potential max speed of a {@link Minecart}.
     */
    public static final Supplier<Key<BoundedValue<Double>>> MINECART_POTENTIAL_MAX_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MINECART_POTENTIAL_MAX_SPEED");

    /**
     * Represents the {@link Key} for if a {@link Minecart} slows down when it has now {@link Keys#PASSENGERS}.
     */
    public static final Supplier<Key<Value<Boolean>>> MINECART_SLOWS_UNOCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MINECART_SLOW_WHEN_EMPTY");

    /**
     * Represents the {@link Key} for the swiftness of a {@link Minecart}.
     */
    public static final Supplier<Key<BoundedValue<Double>>> MINECART_SWIFTNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MINECART_SWIFTNESS");

    /**
     * Represents the {@link Key} for representing the "moisture" state of {@link BlockTypes#FARMLAND}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> MOISTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MOISTURE");

    /**
     * Represents the {@link Key} for the type of a {@link Mooshroom}.
     */
    public static final Supplier<Key<Value<MooshroomType>>> MOOSHROOM_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MOOSHROOM_TYPE");

    /**
     * Represents the {@link Key} for the pitch of a {@link BlockTypes#NOTE_BLOCK}.
     */
    public static final Supplier<Key<Value<NotePitch>>> NOTE_PITCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "NOTE_PITCH");

    /**
     * Represents the {@link Key} for the notifier, usually of an {@link Entity}. It is up to the implementation to define.
     */
    public static final Supplier<Key<Value<UUID>>> NOTIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "NOTIFIER");

    /**
     * Represents the {@link Key} for representing the "occupied" state of
     * beds, for example {@link BlockTypes#WHITE_BED}.
     */
    public static final Supplier<Key<Value<Boolean>>> OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "OCCUPIED");

    /**
     * Represents the {@link Key} for representing a block's offset when inside
     * a {@link MinecartEntity}.
     */
    public static final Supplier<Key<Value<Integer>>> OFFSET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "OFFSET");

    /**
     * Represents the {@link Key} for if an {@link Entity} is currently considered to be on the ground or not.
     */
    public static final Supplier<Key<Value<Boolean>>> ON_GROUND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ON_GROUND");

    /**
     * Represents the {@link Key} for representing the "open" state of
     * various door typed blocks.
     */
    public static final Supplier<Key<Value<Boolean>>> OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "OPEN");

    /**
     * Represents the {@link ParrotType type} of a {@link Parrot}.
     */
    public static final Supplier<Key<Value<ParrotType>>> PARROT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PARROT_TYPE");

    /**
     * Represents the {@link Key} for the amount of ticks a {@link FurnaceBlockEntity} has
     * already been burning with the current fuel item.
     *
     * <p>Once this value reaches the one of {@link #MAX_BURN_TIME}, the
     * furnace will require more fuel in order to keep burning.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> PASSED_BURN_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PASSED_BURN_TIME");

    /**
     * Represents the {@link Key} for the amount of ticks a {@link FurnaceBlockEntity} has
     * been cooking the current item for.
     *
     * <p>Once this value reaches the one of {@link #MAX_COOK_TIME}, the
     * item will be finished cooking.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> PASSED_COOK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PASSED_COOK_TIME");

    /**
     * Represents the {@link Key} for the entities that act as passengers for
     * an {@link Entity}.
     *
     * <p>For example, a {@link Player} riding on a {@link Horse} or a
     * {@link Pig} would be considered its passenger.</p>
     */
    public static final Supplier<Key<ListValue<Entity>>> PASSENGERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PASSENGERS");

    /**
     * Represents the {@link Key} for if a {@link Patroller} is currently patrolling.
     */
    public static final Supplier<Key<Value<Boolean>>> PATROLLING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PATROLLING");

    /**
     * Represents the {@link Key} for whether an {@link Entity} or
     * {@link BlockState} will be prevented from despawning/decaying.
     *
     * <p>In Vanilla, entities may despawn if the player moves too far from
     * them. A persisting entity will not be removed due to no players being
     * near it.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PERSISTENT");

    /**
     * Represents the {@link Key} of the size of a {@link Phantom}. In vanilla, this ranges between 0 and 64.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> PHANTOM_SIZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class,"PHANTOM_SIZE");

    /**
     * Represents the {@link Key} for representing the pickup delay
     * of an {@link Item}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> PICKUP_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PICKUP_DELAY");

    /**
     * Represents the {@link Key} for the "pickup rule" of an {@link ArrowEntity}.
     */
    public static final Supplier<Key<Value<PickupRule>>> PICKUP_RULE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PICKUP_RULE");

    /**
     * Represents the {@link Key} for which block types an {@link ItemStack}
     * may be placed on.
     */
    public static final Supplier<Key<SetValue<BlockType>>> PLACEABLE_BLOCKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PLACEABLE_BLOCKS");

    /**
     * Represents the {@link Key} for the content of a
     * {@link ItemTypes#WRITABLE_BOOK}.
     *
     * <p>Use {@link Keys#BOOK_PAGES} if you wish to get the contents of a
     * {@link ItemTypes#WRITTEN_BOOK}</p>
     */
    public static final Supplier<Key<ListValue<String>>> PLAIN_BOOK_PAGES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PLAIN_BOOK_PAGES");

    /**
     * Represents the {@link Key} for representing the {@link PortionType}
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<PortionType>>> PORTION_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PORTION_TYPE");

    /**
     * Represents the {@link Key} for the color of an {@link ItemStack} potion.
     */
    public static final Supplier<Key<Value<Color>>> POTION_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POTION_COLOR");

    /**
     * Represents the {@link Key} for which potion effects are present on an
     * {@link Entity} or stored on an {@link ItemStack}.
     */
    public static final Supplier<Key<ListValue<PotionEffect>>> POTION_EFFECTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POTION_EFFECTS");

    /**
     * Represents the {@link Key} for representing the potion type of an {@link ItemStack}.
     */
    public static final Supplier<Key<Value<PotionType>>> POTION_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POTION_TYPE");

    /**
     * Represents the {@link Key} for representing the "power" state
     * of a {@link BlockState}.
     *
     * <p>Applies to blocks that may emit a Redstone signal of variable
     * strength, such as {@link BlockTypes#REDSTONE_WIRE},
     * {@link BlockTypes#DAYLIGHT_DETECTOR},
     * {@link BlockTypes#LIGHT_WEIGHTED_PRESSURE_PLATE} etc.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POWER");

    /**
     * Represents the {@link Key} for representing the "powered" state
     * of a {@link BlockState}.
     *
     * <p>Applies to blocks that may be powered in order to emit a
     * Redstone signal of consistently maximum strength, such as
     * {@link BlockTypes#LEVER}, {@link BlockTypes#OAK_BUTTON},
     * {@link BlockTypes#OAK_PRESSURE_PLATE}, and their stone
     * counterparts.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POWERED");

    /**
     * Represents the {@link Key} for if a {@link FusedExplosive} is currently primed.
     */
    public static final Supplier<Key<Value<Boolean>>> PRIMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PRIMED");

    /**
     * Represents the {@link Key} for the {@link Villager} or {@link ZombieVillager}'s {@link Profession}.
     */
    public static final Supplier<Key<Value<Profession>>> PROFESSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PROFESSION");

    /**
     * Represents the {@link Key} for the {@link Villager}'s {@link Profession} level.
     */
    public static final Supplier<Key<Value<Integer>>> PROFESSION_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PROFESSION_LEVEL");

    /**
     * Represents the {@link Key} for the type of a {@link Rabbit}.
     */
    public static final Supplier<Key<Value<RabbitType>>> RABBIT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RABBIT_TYPE");

    /**
     * Represents the {@link Key} for the wave number of a raid.
     */
    public static final Supplier<Key<Value<Integer>>> RAID_WAVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RAID_WAVE");

    /**
     * Represents the {@link Key} for representing the {@link RailDirection}
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<RailDirection>>> RAIL_DIRECTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RAIL_DIRECTION");

    /**
     * Represents the {@link Key} for how much air a {@link Living} has left.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> REMAINING_AIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REMAINING_AIR");

    /**
     * Represents the {@link Key} for how many more ticks the current brewing
     * process of a {@link BrewingStand} will take.
     *
     * <p>If nothing is being brewed, the remaining brew time will be 0.</p>
     */
    public static final Supplier<Key<BoundedValue<Integer>>> REMAINING_BREW_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REMAINING_BREW_TIME");

    /**
     * Represents the {@link Key} for the player represented by a
     * {@link BlockTypes#PLAYER_HEAD} (and {@link BlockTypes#PLAYER_WALL_HEAD})
     * block or a {@link ItemTypes#PLAYER_HEAD} item stack.
     */
    public static final Supplier<Key<Value<GameProfile>>> REPRESENTED_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REPRESENTED_PLAYER");

    /**
     * Represents the {@link Key} for the spawn locations a {@link Player}
     * may have for various worlds based on {@link UUID} of the world.
     */
    public static final Supplier<Key<MapValue<UUID, RespawnLocation>>> RESPAWN_LOCATIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RESPAWN_LOCATIONS");

    /**
     * Represents the {@link Key} for the rotation of an {@link Entity}'s right
     * arm.
     */
    public static final Supplier<Key<Value<Vector3d>>> RIGHT_ARM_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RIGHT_ARM_ROTATION");

    /**
     * Represents the {@link Key} for the rotation of an {@link Entity}'s right
     * leg.
     */
    public static final Supplier<Key<Value<Vector3d>>> RIGHT_LEG_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RIGHT_LEG_ROTATION");

    /**
     * Represents the {@link Key} for the time a {@link Ravager} is roaring.
     */
    public static final Supplier<Key<Value<Integer>>> ROARING_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACK_TIME");

    /**
     * Represents the {@link Key} for the {@link Rotation} of a block or an
     * {@link ItemFrame}.
     */
    public static final Supplier<Key<Value<Rotation>>> ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ROTATION");

    /**
     * Represents the {@link Key} for the current saturation of a {@link Living}.
     *
     * <p>When the saturation level reaches 0, the food level is usually
     * diminished such that the food level is decreased by 1, then
     * saturation is reset to the maximum value. This type of effect occurs
     * over time and can be modified by movements and actions performed by the
     * {@link Humanoid}.</p>
     */
    public static final Supplier<Key<BoundedValue<Double>>> SATURATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SATURATION");

    /**
     * Represents the {@link Key} for the "scale" for the size of an
     * {@link Entity}.
     */
    public static final Supplier<Key<BoundedValue<Double>>> SCALE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SCALE");

    /**
     * Represents the {@link Key} for a {@link Fox fox's} second trusted {@link UUID}, usually a {@link Player}.
     */
    public static final Supplier<Key<Value<UUID>>> SECOND_TRUSTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SECOND_TRUSTED");

    /**
     * Represents the {@link Key} for representing the "should drop" state
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> SHOULD_DROP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SHOULD_DROP");

    /**
     * Represents the {@link Key} for if a {@link EnderCrystal} should show it's bottom bedrock platform.
     */
    public static final Supplier<Key<Value<Boolean>>> SHOW_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SHOW_BOTTOM");

    /**
     * Represents the {@link Key} for the lines displayed on a {@link Sign}.
     */
    public static final Supplier<Key<ListValue<Text>>> SIGN_LINES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SIGN_LINES");

    /**
     * Represents the {@link Key} for the skin of a {@link Humanoid}.
     *
     * <p>Skins can only be manipulated by supplying the UUID of a player
     * having that skin. The binary skin data is signed by Mojang so fully
     * customized skins are not possible.</p>
     */
    public static final Supplier<Key<Value<ProfileProperty>>> SKIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SKIN");

    /**
     * Represents the {@link Key} for representing the {@link SlabPortion}
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<SlabPortion>>> SLAB_PORTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SLAB_PORTION");

    /**
     * Represents the {@link Key} for the size of a {@link Slime}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SLIME_SIZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SLIME_SIZE");

    /**
     * Represents the {@link Key} for the time a {@link Panda} has been sneezing (in ticks)
     */
    public static final Supplier<Key<Value<Integer>>> SNEEZING_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SNEEZING_TIME");

    /**
     * Represents the {@link Key} for representing the "snowed" state
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> SNOWED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SNOWED");

    /**
     * Represents the {@link Key} for the list of {@link EntityArchetype}s able
     * to be spawned by a {@link MobSpawner}.
     */
    public static final Supplier<Key<WeightedCollectionValue<EntityArchetype>>> SPAWNER_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_ENTITIES");

    /**
     * Represents the {@link Key} for the maximum amount of ticks between two
     * batches of entities spawned by a {@link MobSpawner}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SPAWNER_MAXIMUM_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_MAXIMUM_DELAY");

    /**
     * Represents the {@link Key} for the maximum number of entities around a
     * {@link MobSpawner}. A spawner will not spawn entities if there are more
     * entities around than this value permits.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SPAWNER_MAXIMUM_NEARBY_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_MAXIMUM_NEARBY_ENTITIES");

    /**
     * Represents the {@link Key} for the minimum amount of ticks between two
     * batches of entities spawned by a {@link MobSpawner}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SPAWNER_MINIMUM_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_MINIMUM_DELAY");

    /**
     * Represents the {@link Key} for the next entity that will be spawned
     * by a {@link MobSpawner}.
     *
     * <p>Normally the entities to be spawned are determined by a random value
     * applied to the {@link #SPAWNER_ENTITIES} weighted collection. If this
     * value exists, it will override the random spawn with a definite one.</p>
     */
    public static final Supplier<Key<Value<WeightedSerializableObject<EntityArchetype>>>> SPAWNER_NEXT_ENTITY_TO_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_NEXT_ENTITY_TO_SPAWN");

    /**
     * Represents the {@link Key} for the remaining number of ticks to pass
     * before another attempt to spawn entities is made by a {@link MobSpawner}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SPAWNER_REMAINING_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_REMAINING_DELAY");

    /**
     * Represents the {@link Key} for how close a {@link Player} has to be
     * around the {@link MobSpawner} in order for it to attempt to
     * spawn entities.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SPAWNER_REQUIRED_PLAYER_RANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_REQUIRED_PLAYER_RANGE");

    /**
     * Represents the {@link Key} for how many entities a {@link MobSpawner} has
     * spawned so far.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SPAWNER_SPAWN_COUNT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_SPAWN_COUNT");

    /**
     * Represents the {@link Key} for how far away from the
     * {@link MobSpawner} the entities spawned by it may appear.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SPAWNER_SPAWN_RANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNER_SPAWN_RANGE");

    /**
     * Represents the {@link Key} for the {@link Entity target} of the spectator camera of a {@link Player}.
     */
    public static final Supplier<Key<Value<Entity>>> SPECTATOR_TARGET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPECTATOR_TARGET");

    /**
     * Represents the {@link Key} for representing the {@link StairShape}
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<StairShape>>> STAIR_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STAIR_SHAPE");

    /**
     * Represents the {@link Key} for the {@link Statistic}s of a {@link Player}.
     */
    public static final Supplier<Key<MapValue<Statistic, Long>>> STATISTICS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STATISTICS");

    /**
     * Represents the {@link Key} for the enchantments stored on an
     * {@link ItemStack}.
     *
     * <p>Stored enchantments are meant to be transferred. Usually this key
     * applies to {@link ItemTypes#ENCHANTED_BOOK} stacks. Enchantments
     * affecting the item stack are retrieved via {@link #ITEM_ENCHANTMENTS}
     * instead.</p>
     */
    public static final Supplier<Key<ListValue<Enchantment>>> STORED_ENCHANTMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STORED_ENCHANTMENTS");

    /**
     * Represents the {@link Key} for representing the mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<String>>> STRUCTURE_AUTHOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_AUTHOR");

    /**
     * Represents the {@link Key} for representing the mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Boolean>>> STRUCTURE_IGNORE_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_IGNORE_ENTITIES");

    /**
     * Represents the {@link Key} for representing the mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Double>>> STRUCTURE_INTEGRITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_INTEGRITY");

    /**
     * Represents the {@link Key} for representing the mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<StructureMode>>> STRUCTURE_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_MODE");

    /**
     * Represents the {@link Key} for representing the position of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Vector3i>>> STRUCTURE_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_POSITION");

    /**
     * Represents the {@link Key} for representing the mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Boolean>>> STRUCTURE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_POWERED");

    /**
     * Represents the {@link Key} for representing the mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Long>>> STRUCTURE_SEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_SEED");

    /**
     * Represents the {@link Key} for representing the mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Boolean>>> STRUCTURE_SHOW_AIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_SHOW_AIR");

    /**
     * Represents the {@link Key} for representing the mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Boolean>>> STRUCTURE_SHOW_BOUNDING_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_SHOW_BOUNDING_BOX");

    /**
     * Represents the {@link Key} for representing the size of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Vector3i>>> STRUCTURE_SIZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_SIZE");

    /**
     * Represents the {@link Key} for representing the amount of "stuck arrows"
     * in {@link Living} entities.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> STUCK_ARROWS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STUCK_ARROWS");

    /**
     * Represents the {@link Key} for the time a {@link Ravager} is stunned.
     */
    public static final Supplier<Key<Value<Integer>>> STUNNED_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STUNNED_TIME");

    /**
     * Represents a key for the amount of successful executions of a command
     * stored in a {@link CommandBlock} or {@link CommandBlockMinecart}.
     */
    public static final Supplier<Key<BoundedValue<Integer>>> SUCCESS_COUNT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SUCCESS_COUNT");

    /**
     * Represents the {@link Key} for representing the "suspended" state
     * of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Boolean>>> SUSPENDED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SUSPENDED");

    /**
     * Represents the {@link Key} for representing the scoreboard tags applied
     * to an {@link Entity}.
     *
     * @see <a href="https://minecraft.gamepedia.com/Scoreboard#Tags">
     * https://minecraft.gamepedia.com/Scoreboard#Tags</a>
     */
    public static final Supplier<Key<SetValue<String>>> TAGS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TAGS");

    /**
     * Represents the {@link Key} for the tamer of a {@link TameableAnimal} or {@link HorseEntity}.
     */
    public static final Supplier<Key<Value<UUID>>> TAMER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TAMER");

    /**
     * Represents the {@link Key} for a {@link Wither}'s targets.
     */
    public static final Supplier<Key<ListValue<Living>>> TARGET_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TARGET_ENTITIES");

    /**
     * Represents the {@link Key} for a targeted entity either by an {@link Agent} and it's
     * {@link GoalExecutorTypes#TARGET} selector or by a {@link FishingBobber} or {@link ShulkerBullet}.
     */
    public static final Supplier<Key<Value<Entity>>> TARGET_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TARGET_ENTITY");

    /**
     * Represents the {@link Key} for the location targeted by an
     * {@link EyeOfEnder} or a {@link Player}'s compass.
     */
    public static final Supplier<Key<Value<Vector3d>>> TARGET_LOCATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TARGET_LOCATION");

    /**
     * Represents the {@link Key} for a {@link Vector3i} that is currently a target. Example usage is a {@link Patroller}'s patrol target.
     */
    public static final Supplier<Key<Value<Vector3i>>> TARGET_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TARGET_POSITION");

    /**
     * Represents the {@link Key} for the remaining fuse time in ticks of a
     * {@link FusedExplosive}. This value may be set to an arbitrary value
     * if the explosive is not primed.
     */
    public static final Supplier<Key<Value<Integer>>> TICKS_REMAINING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TICKS_REMAINING");

    /**
     * Represents the {@link Key} for whether a {@link CommandBlock} does track
     * its output.
     *
     * <p>If this is set, the output of the most recent execution can be
     * retrieved using {@link #LAST_COMMAND_OUTPUT}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> TRACKS_OUTPUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TRACKS_OUTPUT");

    /**
     * Represents the {@link Key} for the {@link TradeOffer}s offered by a
     * {@link Trader}.
     */
    public static final Supplier<Key<ListValue<TradeOffer>>> TRADE_OFFERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TRADE_OFFERS");

    /**
     * Represents the {@link Key} for if a {@link Turtle} currently has an egg.
     */
    public static final Supplier<Key<Value<Boolean>>> TURTLE_DOES_HAVE_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TURTLE_DOES_HAS_EGG");

    /**
     * Represents the {@link Key} for the {@link Vector3i position} where a {@link Turtle} lays {@link BlockTypes#TURTLE_EGG eggs}.
     */
    public static final Supplier<Key<Value<Vector3i>>> TURTLE_HOME_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TURTLE_HOME_POSITION");

    /**
     * Represents the {@link Key} for the if a {@link Turtle} is proceeding to it's {@link Vector3i home position}.
     */
    public static final Supplier<Key<Value<Boolean>>> TURTLE_IS_GOING_HOME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TURTLE_IS_GOING_HOME");

    /**
     * Represents the {@link Key} for if a {@link Turtle} is currently laying an egg.
     */
    public static final Supplier<Key<Value<Boolean>>> TURTLE_IS_LAYING_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TURTLE_IS_LAYING_EGG");

    /**
     * Represents the {@link Key} for if a {@link Turtle} is currently traveling.
     */
    public static final Supplier<Key<Value<Boolean>>> TURTLE_IS_TRAVELING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TURTLE_IS_TRAVELING");

    /**
     * Represents the {@link Key} for the {@link Vector3i position} where a {@link Turtle} travels to when it is not currently laying an egg.
     */
    public static final Supplier<Key<Value<Vector3i>>> TURTLE_TRAVELING_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TURTLE_TRAVELING_POSITION");

    /**
     * Represents the {@link Key} for the time a {@link Panda} has been unhappy (in ticks)
     */
    public static final Supplier<Key<Value<Integer>>> UNHAPPY_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "UNHAPPY_TIME");

    /**
     * Represents the {@link Key} for whether a TNT block is unstable.
     */
    public static final Supplier<Key<Value<Boolean>>> UNSTABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "UNSTABLE");

    /**
     * Represents the {@link Key} for whether or not changes to {@link Keys#SKIN} should
     * be reflected in an entitie's {@link GameProfile}.
     */
    public static final Supplier<Key<Value<Boolean>>> UPDATE_GAME_PROFILE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "UPDATE_GAME_PROFILE");

    /**
     * Gets the {@link Key} for the "vanish" state of an {@link Entity}.
     *
     * <p>The presence of a vanished entity will not be made known to a client;
     * no packets pertaining to this entity are sent. Client-side, this entity
     * will cease to exist. Server-side it may still be targeted by hostile
     * entities or collide with other entities.</p>
     *
     * <p>Vanishing an {@link Entity} ridden by other entities (see
     * {@link #PASSENGERS} will cause problems.</p>
     * <p>
     * #VANISH
     */
    public static final Supplier<Key<Value<Boolean>>> VANISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VANISH");

    /**
     * Represents the {@link Key} for whether an {@link Entity} ignores collision
     * with other entities.
     *
     * <p>This state will be ignored if the {@link Entity} is not also
     * vanished as per {@link #VANISH}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> VANISH_IGNORES_COLLISION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VANISH_IGNORES_COLLISION");

    /**
     * Represents the {@link Key} for
     * Gets the {@link Value} for whether an {@link Entity} can be targeted for
     * attack by another entity. This prevents neither {@link Player}s from
     * attacking the entity nor will it be protected from untargeted damage
     * like fire or explosions.
     *
     * <p>This state will be ignored if the {@link Entity} is not also
     * vanished as per {@link #VANISH}.}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> VANISH_PREVENTS_TARGETING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VANISH_PREVENTS_TARGETING");

    /**
     * Represents the {@link Key} for the vehicle an {@link Entity} is riding.
     *
     * <p>Vehicles may be nested as a vehicle might itself ride another entity.
     * To get the vehicle on bottom, use {@link Keys#BASE_VEHICLE}.</p>
     */
    public static final Supplier<Key<Value<Entity>>> VEHICLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VEHICLE");

    /**
     * Represents the {@link Key} for the velocity of an {@link Entity}.
     */
    public static final Supplier<Key<Value<Vector3d>>> VELOCITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VELOCITY");

    /**
     * Represents the {@link Key} for the type of a {@link Villager} or {@link ZombieVillager}.
     */
    public static final Supplier<Key<Value<VillagerType>>> VILLAGER_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VILLAGER_TYPE");

    /**
     * Represents the {@link Key} for the speed at which an entity walks.
     */
    public static final Supplier<Key<Value<Double>>> WALKING_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WALKING_SPEED");

    /**
     * Represents the {@link Key} for whether a thrown {@link EyeOfEnder} will
     * shatter.
     */
    public static final Supplier<Key<Value<Boolean>>> WILL_SHATTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WILL_SHATTER");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring blocks.
     */
    public static final Supplier<Key<MapValue<Direction, WireAttachmentType>>> WIRE_ATTACHMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENTS");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring block to the {@link Direction#EAST}.
     */
    public static final Supplier<Key<Value<WireAttachmentType>>> WIRE_ATTACHMENT_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENT_EAST");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring block to the {@link Direction#NORTH}.
     */
    public static final Supplier<Key<Value<WireAttachmentType>>> WIRE_ATTACHMENT_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENT_NORTH");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring block to the {@link Direction#SOUTH}.
     */
    public static final Supplier<Key<Value<WireAttachmentType>>> WIRE_ATTACHMENT_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENT_SOUTH");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring block to the {@link Direction#WEST}.
     */
    public static final Supplier<Key<Value<WireAttachmentType>>> WIRE_ATTACHMENT_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENT_WEST");

    /**
     * Represents the {@link Key} for the {@link Sheep} who is being targeted by the {@link SpellTypes#WOLOLO}
     * spell being casted by an {@link Evoker}
     */
    public static final Supplier<Key<Value<Sheep>>> WOLOLO_TARGET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WOLOLO_TARGET");

    /**
     * Represents the {@link Key} for the {@link WoodType} of a {@link Boat}.
     */
    public static final Supplier<Key<Value<WoodType>>> WOOD_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WOOD_TYPE");

    // SORTFIELDS:OFF

    // TODO: Convert missing properties to keys.

    private Keys() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
