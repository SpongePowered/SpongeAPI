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
import org.spongepowered.api.block.entity.Jukebox;
import org.spongepowered.api.block.entity.Lectern;
import org.spongepowered.api.block.entity.MobSpawner;
import org.spongepowered.api.block.entity.Piston;
import org.spongepowered.api.block.entity.Sign;
import org.spongepowered.api.block.entity.StructureBlock;
import org.spongepowered.api.block.entity.carrier.Beacon;
import org.spongepowered.api.block.entity.carrier.BrewingStand;
import org.spongepowered.api.block.entity.carrier.CarrierBlockEntity;
import org.spongepowered.api.block.entity.carrier.Hopper;
import org.spongepowered.api.block.entity.carrier.furnace.FurnaceBlockEntity;
import org.spongepowered.api.boss.ServerBossBar;
import org.spongepowered.api.data.meta.BannerPatternLayer;
import org.spongepowered.api.data.type.ArmorMaterial;
import org.spongepowered.api.data.type.ArtType;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.type.BodyParts;
import org.spongepowered.api.data.type.CatType;
import org.spongepowered.api.data.type.ChestAttachmentType;
import org.spongepowered.api.data.type.ComparatorMode;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.FoxType;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.DoorHinge;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.LlamaType;
import org.spongepowered.api.data.type.MatterState;
import org.spongepowered.api.data.type.MooshroomType;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.PandaGene;
import org.spongepowered.api.data.type.PandaGenes;
import org.spongepowered.api.data.type.ParrotType;
import org.spongepowered.api.data.type.PhantomPhase;
import org.spongepowered.api.data.type.PickupRule;
import org.spongepowered.api.data.type.PistonType;
import org.spongepowered.api.data.type.PortionType;
import org.spongepowered.api.data.type.ProfessionType;
import org.spongepowered.api.data.type.RabbitType;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SlabPortion;
import org.spongepowered.api.data.type.SpellType;
import org.spongepowered.api.data.type.SpellTypes;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.type.AttachmentSurface;
import org.spongepowered.api.data.type.ToolType;
import org.spongepowered.api.data.type.TropicalFishShape;
import org.spongepowered.api.data.type.VillagerType;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.data.type.WoodType;
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
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.effect.sound.music.MusicDisc;
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
import org.spongepowered.api.entity.living.aquatic.fish.school.TropicalFish;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.golem.Shulker;
import org.spongepowered.api.entity.living.monster.Blaze;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Endermite;
import org.spongepowered.api.entity.living.monster.Patroller;
import org.spongepowered.api.entity.living.monster.Phantom;
import org.spongepowered.api.entity.living.monster.Vex;
import org.spongepowered.api.entity.living.monster.boss.Boss;
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
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.ShulkerBullet;
import org.spongepowered.api.entity.projectile.arrow.Arrow;
import org.spongepowered.api.entity.projectile.arrow.ArrowEntity;
import org.spongepowered.api.entity.projectile.explosive.FireworkRocket;
import org.spongepowered.api.entity.projectile.explosive.WitherSkull;
import org.spongepowered.api.entity.projectile.explosive.fireball.FireballEntity;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.BlockOccupiedMinecart;
import org.spongepowered.api.entity.vehicle.minecart.CommandBlockMinecart;
import org.spongepowered.api.entity.vehicle.minecart.FurnaceMinecart;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartEntity;
import org.spongepowered.api.entity.weather.LightningBolt;
import org.spongepowered.api.entity.weather.WeatherEffect;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSources;
import org.spongepowered.api.fluid.FluidStackSnapshot;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.slot.EquipmentSlot;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.item.potion.PotionType;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.property.ProfileProperty;
import org.spongepowered.api.projectile.source.ProjectileSource;
import org.spongepowered.api.raid.RaidWave;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.RespawnLocation;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.util.weighted.WeightedSerializableObject;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.Weathers;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;
import org.spongepowered.plugin.PluginContainer;

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
     * The {@link PotionEffectTypes#ABSORPTION} amount of a {@link Living} entity.
     */
    public static final Supplier<Key<Value<Double>>> ABSORPTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ABSORPTION");

    /**
     * The acceleration of a {@link DamagingProjectile}.
     */
    public static final Supplier<Key<Value<Vector3d>>> ACCELERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ACCELERATION");

    /**
     * The item a {@link Living} entity is currently using.
     * For example a player eating a food or blocking with a shield.
     *
     * <p>If there is no item, the snapshot will be empty. You can check this
     * with {@link ItemStackSnapshot#isEmpty()}.</p>
     */
    public static final Supplier<Key<Value<ItemStackSnapshot>>> ACTIVE_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ACTIVE_ITEM");

    /**
     * Whether a {@link Player}s affects spawning.
     *
     * <p>A {@link Player} who does not affect spawning will be treated as a
     * spectator in regards to spawning. A {@link MobSpawner} will not be
     * activated by his presence and mobs around him may naturally despawn
     * if there is no other Player around who affects spawning.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> AFFECTS_SPAWNING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AFFECTS_SPAWNING");

    /**
     * The age (in ticks) of an entity.
     * e.g. The age of an {@link AreaEffectCloud}.
     * <p>Note that in vanilla this value is not persisted for most entities.</p>
     */
    public static final Supplier<Key<Value<Integer>>> AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AGE");

    /**
     * The modifier to {@link Keys#VELOCITY} of a {@link Minecart} while airborne.
     */
    public static final Supplier<Key<Value<Vector3d>>> AIRBORNE_VELOCITY_MODIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AIRBORNE_VELOCITY_MODIFIER");

    /**
     * The anger level of a {@link ZombiePigman}.
     *
     * <p>Unlike {@link Keys#IS_ANGRY}, the aggressiveness represented by this key may
     * fade over time and the entity will become peaceful again once its anger
     * reaches its minimum.</p>
     */
    public static final Supplier<Key<Value<Integer>>> ANGER_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ANGER_LEVEL");

    /**
     * The set of {@link PotionEffect}s applied on use of an {@link ItemStack}.
     * Readonly
     */
    public static final Supplier<Key<SetValue<PotionEffect>>> APPLICABLE_POTION_EFFECTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "APPLICABLE_POTION_EFFECTS");

    /**
     * The enchantments applied to an {@link ItemStack}.
     *
     * <p>This data is usually applicable to all types of armor, weapons and
     * tools. Enchantments that are only stored on an item stack in order to
     * be transferred to another item (like on
     * {@link ItemTypes#ENCHANTED_BOOK}s) use the {@link #STORED_ENCHANTMENTS}
     * key instead.)</p>
     */
    public static final Supplier<Key<ListValue<Enchantment>>> APPLIED_ENCHANTMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "APPLIED_ENCHANTMENTS");

    /**
     * The {@link ArmorMaterial} of an armor {@link ItemStack}.
     * Readonly
     */
    public static final Supplier<Key<Value<ArmorMaterial>>> ARMOR_MATERIAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ARMOR_MATERIAL");

    /**
     * The type of {@link ArtType} shown by {@link Painting}s.
     */
    public static final Supplier<Key<Value<ArtType>>> ART_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ART_TYPE");

    /**
     * The attachment {@link AttachmentSurface} of a button or lever {@link BlockState}
     */
    public static final Supplier<Key<Value<AttachmentSurface>>> ATTACHMENT_SURFACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACHMENT_SURFACE");

    /**
     * The damage dealt by an {@link ArrowEntity} on impact.
     */
    public static final Supplier<Key<Value<Double>>> ATTACK_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACK_DAMAGE");

    /**
     * The time of a {@link Ravager} is considered attacking.
     */
    public static final Supplier<Key<Value<Integer>>> ATTACK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACK_TIME");

    /**
     * The author of a {@link ItemTypes#WRITTEN_BOOK} {@link ItemStack}.
     */
    public static final Supplier<Key<Value<Text>>> AUTHOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AUTHOR");

    /**
     * The {@link Axis} direction of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<Axis>>> AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "AXIS");

    /**
     * The ticks until a {@link Ageable} turns into an adult.
     */
    public static final Supplier<Key<Value<Integer>>> BABY_TICKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BABY_TICKS");

    /**
     * The {@link BannerPatternLayer}s of a {@link Banner}.
     */
    public static final Supplier<Key<ListValue<BannerPatternLayer>>> BANNER_PATTERN_LAYERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BANNER_PATTERN_LAYERS");

    /**
     * The width of the physical form of an {@link Entity}.
     *
     * <p>Together with {@link #HEIGHT} and {@link #SCALE} this defines
     * the size of an {@link Entity}.</p>
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> BASE_SIZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BASE_SIZE");

    /**
     * The base vehicle a passenger is riding at the moment.
     * This may be different from {@link Keys#VEHICLE} as the
     * vehicle an {@link Entity} is riding may itself be the passenger of
     * another vehicle.
     * Readonly
     */
    public static final Supplier<Key<Value<Entity>>> BASE_VEHICLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BASE_VEHICLE");

    /**
     * The target entity of a {@link Guardian} beam.
     */
    public static final Supplier<Key<Value<Living>>> BEAM_TARGET_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BEAM_TARGET_ENTITY");

    /**
     * The default temperature of a biome at a specific {@link ServerLocation}.
     * For the exact block temperature see {@link #BLOCK_TEMPERATURE}.
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> BIOME_TEMPERATURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BIOME_TEMPERATURE");

    /**
     * The blast resistance of a {@link BlockState}.
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> BLAST_RESISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BLAST_RESISTANCE");

    /**
     * The amount of light that is emitted by the surrounding blocks at a block {@link ServerLocation}.
     * The value scales normally from 0 to 1.
     * <p>In vanilla minecraft is this value in steps of 1/15 from 0 to 1.</p>
     * <p>For the skylight see {@link #SKY_LIGHT}.</p>
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> BLOCK_LIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BLOCK_LIGHT");

    /**
     * The {@link BlockState} of a {@link BlockOccupiedMinecart} or {@link FallingBlock}.
     */
    public static final Supplier<Key<Value<BlockState>>> BLOCK_STATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BLOCK_STATE");

    /**
     * The temperature at a specific {@link ServerLocation}.
     * For the default biome temperature see {@link #BIOME_TEMPERATURE}.
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> BLOCK_TEMPERATURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BLOCK_TEMPERATURE");

    /**
     * The rotation of specific body parts of a {@link ArmorStand} or {@link Living}.
     *
     * <p>This value provides a mapping, effectively combining the data
     * referenced by {@link #HEAD_ROTATION}, {@link #CHEST_ROTATION},
     * {@link #RIGHT_ARM_ROTATION}, {@link #LEFT_ARM_ROTATION},
     * {@link #RIGHT_LEG_ROTATION}, and {@link #LEFT_LEG_ROTATION}.</p>
     */
    public static final Supplier<Key<MapValue<BodyPart, Vector3d>>> BODY_ROTATIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BODY_ROTATIONS");

    /**
     * The {@link ServerBossBar} displayed to the client by a {@link Boss}.
     * Readonly but mutable?
     */
    public static final Supplier<Key<Value<ServerBossBar>>> BOSS_BAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BOSS_BAR");

    /**
     * The {@link BlockType}s able to be broken by an {@link ItemStack}.
     */
    public static final Supplier<Key<SetValue<BlockType>>> BREAKABLE_BLOCK_TYPES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BREAKABLE_BLOCK_TYPES");

    /**
     * The current breeder of an {@link Animal}, usually a {@link Player}s UUID.
     */
    public static final Supplier<Key<Value<UUID>>> BREEDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BREEDER");

    /**
     * The ticks until an {@link Animal} can breed again. Also see {@link #CAN_BREED}.
     */
    public static final Supplier<Key<Value<Integer>>> BREEDING_COOLDOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BREEDING_COOLDOWN");

    /**
     * The burntime of an {@link ItemStack} fuel in a furnace.
     * See {@link #FUEL} for the time
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> BURN_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "BURN_TIME");

    /**
     * Whether an {@link Animal} can breed.
     * In Vanilla, animals can breed if their {@link Keys#BREEDING_COOLDOWN} is equal to 0.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_BREED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_BREED");

    /**
     * Whether a {@link FallingBlock} can drop as an item.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_DROP_AS_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_DROP_AS_ITEM");

    /**
     * Whether a {@link Humanoid} can fly.
     *
     * <p>For a {@link Player} this means they are able to toggle flight mode
     * by double-tapping the jump button.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_FLY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_FLY");

    /**
     * Whether a {@link Living} entity may change blocks.
     * This mostly applies to {@link Enderman} or
     * {@link Creeper}s, but also to some projectiles like {@link FireballEntity}s or {@link WitherSkull}.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_GRIEF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_GRIEF");

    /**
     * The set of harvestable {@link BlockType}s with an {@link ItemStack}. {@link #EFFICIENCY}
     * Readonly
     */
    public static final Supplier<Key<SetValue<BlockType>>> CAN_HARVEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_HARVEST");

    /**
     * Whether a {@link FallingBlock} will damage an {@link Entity} it lands on.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_HURT_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_HURT_ENTITIES");

    /**
     * Whether a {@link Raider} can join a raid.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_JOIN_RAID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_JOIN_RAID");

    /**
     * Whether a {@link Boat} can move on land.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_MOVE_ON_LAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_MOVE_ON_LAND");

    /**
     * Whether a {@link FallingBlock} will place itself upon landing.
     */
    public static final Supplier<Key<Value<Boolean>>> CAN_PLACE_AS_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAN_PLACE_AS_BLOCK");

    /**
     * The current casting time of a {@link Spellcaster}.
     */
    public static final Supplier<Key<Value<Integer>>> CASTING_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CASTING_TIME");

    /**
     * The type of a {@link Cat}.
     */
    public static final Supplier<Key<Value<CatType>>> CAT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CAT_TYPE");

    /**
     * The attachment of a {@link BlockTypes#CHEST} or {@link BlockTypes#TRAPPED_CHEST} {@link BlockState}.
     */
    public static final Supplier<Key<Value<ChestAttachmentType>>> CHEST_ATTACHMENT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CHEST_ATTACHMENT_TYPE");

    /**
     * The rotation of the {@link BodyParts#CHEST}.
     */
    public static final Supplier<Key<Value<Vector3d>>> CHEST_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CHEST_ROTATION");

    /**
     * The {@link Color} of an {@link ItemStack}
     * <p>
     *     e.g. {@link ItemTypes#LEATHER_CHESTPLATE} or {@link ItemTypes#POTION} custom color
     * </p>
     * or an {@link AreaEffectCloud}.
     */
    public static final Supplier<Key<Value<Color>>> COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "COLOR");

    /**
     * A command stored in a {@link CommandBlock} or {@link CommandBlockMinecart}.
     */
    public static final Supplier<Key<Value<String>>> COMMAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "COMMAND");

    /**
     * The {@link ComparatorMode} of a {@link BlockTypes#COMPARATOR} {@link BlockState}.
     */
    public static final Supplier<Key<Value<ComparatorMode>>> COMPARATOR_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "COMPARATOR_MODE");

    /**
     * The connected directions of a {@link BlockState}.
     * <p>
     *     e.g. {@link BlockTypes#GLASS_PANE}, {@link BlockTypes#IRON_BARS}, {@link BlockTypes#CHEST},
     * </p>
     */
    public static final Supplier<Key<SetValue<Direction>>> CONNECTED_DIRECTIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CONNECTED_DIRECTIONS");

    /**
     * The container {@link ItemType} of an {@link ItemStack}.
     * e.g. {@link ItemTypes#BUCKET} for a {@link ItemTypes#WATER_BUCKET} stack.
     * Readonly
     */
    public static final Supplier<Key<Value<ItemType>>> CONTAINER_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CONTAINER_ITEM");

    /**
     * The amount of ticks a {@link Hopper} has to wait before transferring the next item. (in Vanilla this is 8 ticks)
     * or
     * The amount of ticks a {@link EndGateway} has to wait for the next teleportation.
     */
    public static final Supplier<Key<Value<Integer>>> COOLDOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "COOLDOWN");

    /**
     * The creator, usually of an {@link Entity}. It is up to the implementation to define.
     */
    public static final Supplier<Key<Value<UUID>>> CREATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CREATOR");

    /**
     * The current {@link SpellType} a {@link Spellcaster} is casting.
     */
    public static final Supplier<Key<Value<SpellType>>> CURRENT_SPELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CURRENT_SPELL");

    /**
     * The damage dealt towards entities of a specific {@link EntityType} by a {@link DamagingProjectile}.
     *
     * <p>Note that in events, the damage defined for the provided
     * {@link EntityType} will take priority over the "default" damage as
     * defined from {@link DamagingProjectile#attackDamage()}.</p>
     *
     * <p>Types not present in this mapping will be
     * dealt damage to according to {@link #ATTACK_DAMAGE}.</p>
     */
    public static final Supplier<Key<MapValue<EntityType<?>, Double>>> CUSTOM_ATTACK_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "CUSTOM_ATTACK_DAMAGE");

    /**
     * The damage absorbed by an armor {@link ItemStack}.
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> DAMAGE_ABSORPTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DAMAGE_ABSORPTION");

    /**
     * How much damage a {@link FallingBlock} deals to {@link Living} entities
     * it hits per block fallen.
     *
     * <p>This damage is capped by {@link #MAX_FALL_DAMAGE}.</p>
     */
    public static final Supplier<Key<Value<Double>>> DAMAGE_PER_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DAMAGE_PER_BLOCK");

    /**
     * The distance at which a {@link BlockState} will decay.
     * This usually applies to leaves, for example {@link BlockTypes#OAK_LEAVES}.
     */
    public static final Supplier<Key<Value<Integer>>> DECAY_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DECAY_DISTANCE");

    /**
     * The modifier to {@link Keys#VELOCITY} of a {@link Minecart} while derailed.
     */
    public static final Supplier<Key<Value<Vector3d>>> DERAILED_VELOCITY_MODIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DERAILED_VELOCITY_MODIFIER");

    /**
     * The despawn delay (in ticks) of a {@link Item}, {@link Endermite}, {@link Weather} {@link TraderLlama} or.
     */
    public static final Supplier<Key<Value<Integer>>> DESPAWN_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DESPAWN_DELAY");

    /**
     * The detonator of a {@link PrimedTNT}.
     */
    public static final Supplier<Key<Value<Living>>> DETONATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DETONATOR");

    /**
     * The {@link Direction} a {@link BlockState}, {@link Hanging}, or {@link Shulker} is facing or the
     * heading of a {@link ShulkerBullet}.
     */
    public static final Supplier<Key<Value<Direction>>> DIRECTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DIRECTION");

    /**
     * The display name of an {@link Entity}, {@link ItemStack} or {@link BlockEntity}.
     *
     * <p>On a {@link ItemTypes#WRITTEN_BOOK} item this will also set the title
     * of the book.</p>
     */
    public static final Supplier<Key<Value<Text>>> DISPLAY_NAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DISPLAY_NAME");

    /**
     * The dominant {@link HandPreference} of an {@link Agent} entity.
     *
     * <p><em>NOTE:</em> For {@link Player}s is this key read-only, the
     * {@link HandPreference} of a player can not be changed server-side.</p>
     */
    public static final Supplier<Key<Value<HandPreference>>> DOMINANT_HAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DOMINANT_HAND");

    /**
     * The {@link DoorHinge} of a door {@link BlockState}.
     */
    public static final Supplier<Key<Value<DoorHinge>>> DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DOOR_HINGE");

    /**
     * Whether exact teleport location should be used with a {@link EndGateway}.
     */
    public static final Supplier<Key<Value<Boolean>>> DO_EXACT_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DO_EXACT_TELEPORT");

    /**
     * The remaining duration (in ticks) of an {@link AreaEffectCloud}.
     */
    public static final Supplier<Key<Value<Integer>>> DURATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DURATION");

    /**
     * The amount of ticks the duration of an {@link AreaEffectCloud}
     * is increased or reduced when it applies its effect.
     */
    public static final Supplier<Key<Value<Integer>>> DURATION_ON_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DURATION_ON_USE");

    /**
     * The color of a dyeable {@link BlockState}, {@link ItemStack} or entity like {@link Cat}s.
     * or
     * The base {@link DyeColor} of a {@link Banner} or {@link TropicalFish}.
     */
    public static final Supplier<Key<Value<DyeColor>>> DYE_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "DYE_COLOR");

    /**
     * The time a {@link Panda} has been eating (in ticks)
     */
    public static final Supplier<Key<Value<Integer>>> EATING_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EATING_TIME");

    /**
     * The efficiency of an {@link ItemStack} tool. Affects mining speed of supported materials. {@link #CAN_HARVEST}
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> EFFICIENCY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EFFICIENCY");

    /**
     * The time (in ticks) until a {@link Chicken} lays an {@link ItemTypes#EGG}.
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
     * The age (in ticks) of an {@link EndGateway}
     */
    public static final Supplier<Key<Value<Long>>> END_GATEWAY_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "END_GATEWAY_AGE");

    /**
     * The {@link EquipmentType} that the target inventory supports. This usually applies to {@link EquipmentSlot}s.
     * or
     * The {@link EquipmentType} of an {@link ItemStack}
     * Readonly
     */
    public static final Supplier<Key<Value<EquipmentType>>> EQUIPMENT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EQUIPMENT_TYPE");

    /**
     * The current level of exhaustion of a {@link Humanoid}.
     *
     * <p>When the exhaustion level reaches 0, saturation is usually diminished
     * such that saturation is decreased and then exhaustion is reset to the
     * maximum. This type of effect occurs over time and can be modified by
     * movements and actions performed by the {@link Humanoid}.</p>
     */
    public static final Supplier<Key<Value<Double>>> EXHAUSTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXHAUSTION");

    /**
     * The amount of experience a {@link Player} has or an {@link ExperienceOrb} contains.
     */
    public static final Supplier<Key<Value<Integer>>> EXPERIENCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPERIENCE");

    /**
     * The total experience a {@link Player} requires to advance from his current level to the next one.
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> EXPERIENCE_FROM_START_OF_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPERIENCE_FROM_START_OF_LEVEL");

    /**
     * The current level a {@link Player} has.
     */
    public static final Supplier<Key<Value<Integer>>> EXPERIENCE_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPERIENCE_LEVEL");

    /**
     * The amount of experience a {@link Player} has collected towards the next level.
     */
    public static final Supplier<Key<Value<Integer>>> EXPERIENCE_SINCE_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPERIENCE_SINCE_LEVEL");

    /**
     * The radius of the {@link Explosion} to be created by detonating an {@link Explosive}.
     *
     * <p>May be absent if the explosion radius is unknown because it is either
     * determined randomly at the time of the explosion or computed from the
     * context in which the {@link Explosive} explodes.</p>
     */
    public static final Supplier<Key<Value<Integer>>> EXPLOSION_RADIUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EXPLOSION_RADIUS");

    /**
     * The eye height of an {@link Entity}.
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> EYE_HEIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EYE_HEIGHT");

    /**
     * The eye position of an {@link Entity}.
     * Readonly
     */
    public static final Supplier<Key<Value<Vector3d>>> EYE_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "EYE_POSITION");

    /**
     * The distance an {@link Living} has fallen.
     */
    public static final Supplier<Key<Value<Double>>> FALL_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FALL_DISTANCE");

    /**
     * The amount of ticks a {@link FallingBlock} has been falling for.
     */
    public static final Supplier<Key<Value<Integer>>> FALL_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FALL_TIME");

    /**
     * The {@link FireworkEffect}s of a
     * {@link ItemTypes#FIREWORK_STAR}, {@link ItemTypes#FIREWORK_ROCKET} {@link ItemStack} or a
     * {@link FireworkRocket}.
     */
    public static final Supplier<Key<ListValue<FireworkEffect>>> FIREWORK_EFFECTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIREWORK_EFFECTS");

    /**
     * The flight duration of a {@link FireworkRocket}
     *
     * <p>The duration is tiered and will stay partially random. A rocket will
     * fly for roughly {@code modifier * 10 + (random number from 0 to 13)}
     * ticks in Vanilla Minecraft.</p>
     */
    public static final Supplier<Key<Value<Integer>>> FIREWORK_FLIGHT_MODIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIREWORK_FLIGHT_MODIFIER");

    /**
     * The delay in ticks until the {@link Entity} will be damaged by the fire.
     */
    public static final Supplier<Key<Value<Integer>>> FIRE_DAMAGE_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIRE_DAMAGE_DELAY");

    /**
     * The amount of ticks an {@link Entity} is still burning.
     */
    public static final Supplier<Key<Value<Integer>>> FIRE_TICKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIRE_TICKS");

    /**
     * The time a {@link User} first joined on the Server.
     */
    public static final Supplier<Key<Value<Instant>>> FIRST_DATE_JOINED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIRST_DATE_JOINED");

    /**
     * A {@link Fox fox's} first trusted {@link UUID}, usually a {@link Player}.
     */
    public static final Supplier<Key<Value<UUID>>> FIRST_TRUSTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FIRST_TRUSTED");

    /**
     * The {@link FluidStackSnapshot} contained within an item container.
     * Item containers may include buckets and other mod added items.
     * See {@link #CONTAINER_ITEM}
     */
    public static final Supplier<Key<Value<FluidStackSnapshot>>> FLUID_ITEM_STACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FLUID_ITEM_STACK");

    /**
     * The fluid level of a liquid {@link BlockState}.
     */
    public static final Supplier<Key<Value<Integer>>> FLUID_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FLUID_LEVEL");

    /**
     * The directional tank information.
     * TODO dataholder? cauldron blockstate? modded?
     */
    public static final Supplier<Key<MapValue<Direction, List<FluidStackSnapshot>>>> FLUID_TANK_CONTENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FLUID_TANK_CONTENTS");

    /**
     * The speed at which an {@link Player} flies.
     */
    public static final Supplier<Key<Value<Double>>> FLYING_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FLYING_SPEED");

    /**
     * The food level of a {@link Humanoid}.
     *
     * <p>For a {@link Humanoid}, food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the humanoid may heal. If the food level is at 0,
     * the humanoid may starve.</p>
     */
    public static final Supplier<Key<Value<Integer>>> FOOD_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FOOD_LEVEL");

    /**
     * The type of a {@link Fox}.
     */
    public static final Supplier<Key<Value<FoxType>>> FOX_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FOX_TYPE");

    /**
     * Represents the {@link Key} for the amount of fuel left in a {@link BrewingStand} or {@link FurnaceBlockEntity} or {@link FurnaceMinecart}
     *
     * <p>One {@link ItemTypes#BLAZE_POWDER} adds 20 fuel to the brewing stand.</p>
     * <p>The fuel value corresponds with the number of batches of potions that can be brewed.</p>
     *
     * <p>See {@link #BURN_TIME} for the burn time added by a fuel {@link ItemStack} to a furnace</p>
     */
    public static final Supplier<Key<Value<Integer>>> FUEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FUEL");

    /**
     * The time (in ticks) a {@link FusedExplosive}'s fuse will burn before the explosion.
     */
    public static final Supplier<Key<Value<Integer>>> FUSE_DURATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "FUSE_DURATION");

    /**
     * The {@link GameMode} a {@link Humanoid} has.
     */
    public static final Supplier<Key<Value<GameMode>>> GAME_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "GAME_MODE");

    /**
     * The player represented by a
     * {@link BlockTypes#PLAYER_HEAD} (and {@link BlockTypes#PLAYER_WALL_HEAD}) {@link BlockState}
     * or a {@link ItemTypes#PLAYER_HEAD} {@link ItemStack}.
     */
    public static final Supplier<Key<Value<GameProfile>>> GAME_PROFILE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "GAME_PROFILE");

    /**
     * The generation of a {@link ItemTypes#WRITTEN_BOOK} {@link ItemStack}.
     * Depending on the book's generation it may be impossible to copy it.
     */
    public static final Supplier<Key<Value<Integer>>> GENERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "GENERATION");

    /**
     * The "growth stage" state of a {@link BlockState}.
     * e.g. {@link BlockTypes#CACTUS} or {@link BlockTypes#WHEAT} etc.
     */
    public static final Supplier<Key<Value<Integer>>> GROWTH_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "GROWTH_STAGE");

    /**
     * The hardness of a {@link BlockState}s {@link BlockType}.
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> HARDNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HARDNESS");

    /**
     * Whether an {@link ArmorStand}'s arms are visible.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_ARMS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_ARMS");

    /**
     * Whether an {@link ArmorStand} has a visible base plate.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_BASE_PLATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_BASE_PLATE");

    /**
     * Whether a {@link PackHorse} has a chest.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_CHEST");

    /**
     *Whether a {@link Turtle} currently has an egg.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_EGG");

    /**
     * Whether a {@link Dolphin} has a fish.
     * <p>
     *     Dolphins will navigate to a treasure (if a structure that provides one is nearby)
     *     if they have been given a fish.
     * </p>
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_FISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_FISH");

    /**
     * Whether an {@link ArmorStand} is a "marker" stand.
     *
     * <p>If {@code true}, the armor stand's bounding box is near
     * impossible to see, and the armor stand can no longer be
     * interacted with.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_MARKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_MARKER");

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#DOWN} direction. See {@link #PORES}.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_PORES_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_PORES_DOWN");

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#EAST} direction. See {@link #PORES}.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_PORES_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_PORES_EAST");

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#NORTH} direction. See {@link #PORES}.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_PORES_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_PORES_NORTH");

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#SOUTH} direction. See {@link #PORES}.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_PORES_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_PORES_SOUTH");

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#UP} direction. See {@link #PORES}.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_PORES_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_PORES_UP");

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#WEST} direction. See {@link #PORES}.
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_PORES_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_PORES_WEST");

    /**
     * Whether a server player has viewed the credits.
     *
     * <p>The credits are displayed the first time a player returns to the overworld safely using an end portal.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> HAS_VIEWED_CREDITS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HAS_VIEWED_CREDITS");

    /**
     * The rotation of a {@link Living}'s or {@link ArmorStand}'s head.
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
     * The {@link EnderCrystal} currently healing an {@link EnderDragon}.
     */
    public static final Supplier<Key<Value<EnderCrystal>>> HEALING_CRYSTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEALING_CRYSTAL");

    /**
     * A {@link Living}'s or {@link EnderCrystal}'s current health.
     *
     * <p>The range of the health depends on the object on which this
     * method is defined. For {@link Player Players} in Minecraft, the nominal range is
     * between 0 and 20, inclusive, but the range can be adjusted.</p>
     *
     * <p>Convention dictates that health does not fall below 0 but this
     * convention may be broken.</p>
     */
    public static final Supplier<Key<Value<Double>>> HEALTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEALTH");

    /**
     * How much health a half-heart on a {@link Player}'s GUI will stand for.
     * TODO wrong javadocs @gabizou?
     */
    public static final Supplier<Key<Value<Double>>> HEALTH_SCALE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEALTH_SCALE");

    /**
     * The height of the physical form of an {@link Entity}.
     *
     * <p>Together with {@link #BASE_SIZE} and {@link #SCALE} this defines the size of an
     * {@link Entity}.</p>
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> HEIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HEIGHT");

    /**
     * The {@link ItemType} a {@link BlockState} represents.
     * Readonly
     */
    public static final Supplier<Key<Value<ItemType>>> HELD_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HELD_ITEM");

    /**
     * The hidden {@link PandaGene gene} of a {@link Panda}.
     */
    public static final Supplier<Key<Value<PandaGene>>> HIDDEN_GENE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDDEN_GENE");

    /**
     * Whether the attributes of an {@link ItemStack} are hidden.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_ATTRIBUTES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_ATTRIBUTES");

    /**
     * Whether the {@link #BREAKABLE_BLOCK_TYPES} of an {@link ItemStack} are hidden.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_CAN_DESTROY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_CAN_DESTROY");

    /**
     * Whether the {@link #PLACEABLE_BLOCK_TYPES} of an {@link ItemStack} are hidden.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_CAN_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_CAN_PLACE");

    /**
     * Whether the {@link #APPLIED_ENCHANTMENTS} of an {@link ItemStack} are hidden.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_ENCHANTMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_ENCHANTMENTS");

    /**
     * Whether miscellaneous values of an {@link ItemStack} are hidden.
     * e.g. potion effects or shield pattern info
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_MISCELLANEOUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_MISCELLANEOUS");

    /**
     * Whether {@link #IS_UNBREAKABLE} state of an {@link ItemStack} is hidden.
     */
    public static final Supplier<Key<Value<Boolean>>> HIDE_UNBREAKABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HIDE_UNBREAKABLE");

    /**
     * The {@link Vector3i position} where a {@link Turtle} lays {@link BlockTypes#TURTLE_EGG eggs}.
     */
    public static final Supplier<Key<Value<Vector3i>>> HOME_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HOME_POSITION");

    /**
     * The {@link HorseColor} of a {@link Horse}.
     */
    public static final Supplier<Key<Value<HorseColor>>> HORSE_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HORSE_COLOR");

    /**
     * The {@link HorseStyle} of a {@link Horse}.
     */
    public static final Supplier<Key<Value<HorseStyle>>> HORSE_STYLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "HORSE_STYLE");

    /**
     * Whether an {@link Item} will not despawn for an infinite time.
     */
    public static final Supplier<Key<Value<Boolean>>> INFINITE_DESPAWN_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INFINITE_DESPAWN_DELAY");

    /**
     * Whether an {@link Item} has an infinite pickup delay.
     */
    public static final Supplier<Key<Value<Boolean>>> INFINITE_PICKUP_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INFINITE_PICKUP_DELAY");

    /**
     * The {@link InstrumentType} of a {@link BlockTypes#NOTE_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<Value<InstrumentType>>> INSTRUMENT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INSTRUMENT_TYPE");

    /**
     * Whether a {@link BlockTypes#DAYLIGHT_DETECTOR} {@link BlockState} is inverted.
     */
    public static final Supplier<Key<Value<Boolean>>> INVERTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INVERTED");

    /**
     * The amount of ticks an {@link Entity} will remain invulnerable for.
     */
    public static final Supplier<Key<Value<Integer>>> INVULNERABILITY_TICKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INVULNERABILITY_TICKS");

    /**
     * Whether an {@link Entity} is invulnerable.
     *
     * <p>This does not protect from the void, players in creative mode,
     * and manual killing like the /kill command.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> INVULNERABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "INVULNERABLE");

    /**
     * Whether a fence gate {@link BlockState} is in a wall.
     */
    public static final Supplier<Key<Value<Boolean>>> IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IN_WALL");

    /**
     * Whether an {@link Ageable} is considered an adult.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ADULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ADULT");

    /**
     * Whether a {@link Blaze} is currently burning.
     *
     * <p>Unlike {@link Keys#FIRE_TICKS}, the burning effect will not damage
     * the burning entity.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_AFLAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_AFLAME");

    /**
     * Whether an {@link Agent}s AI is enabled.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_AI_ENABLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_AI_ENABLED");

    /**
     * Whether an entity is currently aggressive.
     * e.g. {@link Wolf wolves} or {@link ZombiePigman}
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ANGRY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ANGRY");

    /**
     * Whether a {@link BlockState} is "attached" to another block.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ATTACHED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ATTACHED");

    /**
     * Whether an entity is begging for food.
     * e.g. {@link Cat cats} or tamed {@link Wolf wolves}
     */
    public static final Supplier<Key<Value<Boolean>>> IS_BEGGING_FOR_FOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_BEGGING_FOR_FOOD");

    /**
     * Whether {@link Raider}s are currently celebrating.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CELEBRATING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CELEBRATING");

    /**
     * Whether a {@link Creeper} is charged.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CHARGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CHARGED");

    /**
     * Whether a {@link Pillager} is charging it's crossbow.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CHARGING_CROSSBOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CHARGING_CROSSBOW");

    /**
     * Whether a {@link Spider} is currently climbing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CLIMBING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CLIMBING");

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#EAST}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CONNECTED_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CONNECTED_EAST");

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#NORTH}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CONNECTED_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CONNECTED_NORTH");

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#SOUTH}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CONNECTED_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CONNECTED_SOUTH");

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#UP}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CONNECTED_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CONNECTED_UP");

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#WEST}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CONNECTED_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CONNECTED_WEST");

    /**
     * Whether an {@link Arrow} will cause a critical hit.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CRITICAL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CRITICAL_HIT");

    /**
     * Whether a {@link Fox} is currently crouching.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CROUCHING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CROUCHING");

    /**
     * Whether a custom name is visible on an {@link Entity}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_CUSTOM_NAME_VISIBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_CUSTOM_NAME_VISIBLE");

    /**
     * Whether a {@link Fox} is currently defending.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_DEFENDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_DEFENDING");

    /**
     * Whether a {@link BlockState} is disarmed.
     * e.g. {@link BlockTypes#TRIPWIRE}s and {@link BlockTypes#TRIPWIRE_HOOK}s.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_DISARMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_DISARMED");

    /**
     * Whether an entity is eating.
     * e.g. {@link Panda}
     */
    public static final Supplier<Key<Value<Boolean>>> IS_EATING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_EATING");

    /**
     * Whether a {@link WeatherEffect} like {@link LightningBolt} is harmful to other {@link Entity entities}.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_EFFECT_ONLY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_EFFECT_ONLY");

    /**
     * Whether a {@link Player} is flying with an {@link ItemTypes#ELYTRA}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ELYTRA_FLYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ELYTRA_FLYING");

    /**
     * Whether a piston {@link BlockState} is currently extended.
     * TODO {@link Piston}?
     */
    public static final Supplier<Key<Value<Boolean>>> IS_EXTENDED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_EXTENDED");

    /**
     * Whether a {@link Fox} is currently faceplanted.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_FACEPLANTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_FACEPLANTED");

    /**
     * Whether a {@link BlockState} is filled.
     * <p>e.g. {@link BlockTypes#END_PORTAL_FRAME}s.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_FILLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_FILLED");

    /**
     * Whether a {@link BlockState} is flammable.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_FLAMMABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_FLAMMABLE");

    /**
     * Whether an {@link Entity} is flying. TODO only player?
     *
     * <p>This key only tells whether an entity is flying at the moment. On a
     * {@link Player} it does not necessarily mean that the player may toggle
     * freely between flying and walking. To check whether a player may switch
     * his flying state, check {@link #CAN_FLY}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_FLYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_FLYING");

    /**
     * Whether an entity is frightened.
     *
     * <p>In vanilla, {@link Panda}s that have a {@link Panda#knownGene()}
     * of {@link PandaGenes#WORRIED} and are in a {@link ServerWorld world} whose {@link Weather} is currently a
     * {@link Weathers#THUNDER_STORM} are considered "frightened".</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_FRIGHTENED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_FRIGHTENED");

    /**
     * Whether the block at the {@link ServerLocation} is a full block.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_FULL_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_FULL_BLOCK");

    /**
     * Whether an {@link Entity} has a glowing outline.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_GLOWING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_GLOWING");

    /**
     * Whether {@link Turtle} is proceeding to it's {@link Vector3i home position}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_GOING_HOME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_GOING_HOME");

    /**
     * Whether something is affected by gravity.
     * e.g. {@link Entity}s and {@link BlockState}s
     * Readonly(BlockState.class)
     */
    public static final Supplier<Key<Value<Boolean>>> IS_GRAVITY_AFFECTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_GRAVITY_AFFECTED");

    /**
     * Whether a {@link Cat} is hissing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_HISSING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_HISSING");

    /**
     * Whether a {@link Ravager} is immobilized.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_IMMOBILIZED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_IMMOBILIZED");

    /**
     * Whether a {@link ServerLocation} is indirectly powered.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_INDIRECTLY_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_INDIRECTLY_POWERED");

    /**
     * Whether a {@link Fox} is currently interested in something.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_INTERESTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_INTERESTED");

    /**
     * Whether an {@link Entity} is currently invisible.
     * This will only simply render the entity as vanished,
     * but not prevent any entity updates being sent to clients.
     * To fully "vanish" an {@link Entity}, use {@link #VANISH}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_INVISIBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_INVISIBLE");

    /**
     * Whether a {@link Boat} is currently in {@link BlockTypes#WATER}.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_IN_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_IN_WATER");

    /**
     * Whether a {@link Vindicator} is exhibiting "johnny" behavior.
     *
     * @see <a href="https://minecraft.gamepedia.com/Vindicator#Behavior">
     * The Minecraft Wiki for more information about "johnny" behavior</a>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_JOHNNY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_JOHNNY");

    /**
     * Whether a {@link Turtle} is currently digging to lay an egg.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_LAYING_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_LAYING_EGG");

    /**
     * Whether a {@link Patroller} is the leader.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_LEADER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_LEADER");

    /**
     * Whether a {@link BlockState} is lit.
     * e.g. {@link BlockTypes#FURNACE}, {@link BlockTypes#CAMPFIRE}
     * or {@link BlockTypes#REDSTONE_TORCH}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_LIT");

    /**
     *Whether a {@link Cat} is lying down.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_LYING_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_LYING_DOWN");

    /**
     * Whether a {@link Panda} is lying on it's back.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_LYING_ON_BACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_LYING_ON_BACK");

    /**
     * Whether a bed {@link BlockState} is occupied.
     * e.g. {@link BlockTypes#WHITE_BED}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_OCCUPIED");

    /**
     * Whether a {@link Minecart} is on it's rail
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ON_RAIL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ON_RAIL");

    /**
     * Whether a door/fencegate/trapdoor {@link BlockState} is open.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_OPEN");

    /**
     * Whether a {@link BlockState} is passable (can be walked through).
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_PASSABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PASSABLE");

    /**
     * Whether a {@link Patroller} is currently patrolling.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_PATROLLING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PATROLLING");

    /**
     * Whether an {@link Entity} or leaves {@link BlockState} will
     * be prevented from despawning/decaying.
     *
     * <p>In Vanilla, entities may despawn if the player moves too far from
     * them. A persisting entity will not be removed due to no players being
     * near it.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PERSISTENT");

    /**
     * Whether players are prevented from placing
     * items from an equipment slot on an {@link ArmorStand}
     */
    public static final Supplier<Key<MapValue<EquipmentType, Boolean>>> IS_PLACING_DISABLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PLACING_DISABLED");

    /**
     * Whether a {@link IronGolem} has been created by a {@link Player}.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_PLAYER_CREATED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PLAYER_CREATED");

    /**
     * Whether a {@link Fox} is currently pouncing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_POUNCING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_POUNCING");

    /**
     * Whether a {@link BlockState} is powered.
     *
     * <p>Applies to blocks that may be powered in order to emit a
     * Redstone signal of consistently maximum strength, such as
     * {@link BlockTypes#LEVER}, {@link BlockTypes#OAK_BUTTON},
     * {@link BlockTypes#OAK_PRESSURE_PLATE}, and their stone
     * counterparts.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_POWERED");

    /**
     * Whether a {@link FusedExplosive} is currently primed.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_PRIMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PRIMED");

    /**
     * Whether a {@link Cat} is purring.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_PURRING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_PURRING");

    /**
     * Whether a {@link Cat} is relaxed.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_RELAXED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_RELAXED");

    /**
     * Whether a {@link BlockState} can be replaced by a player without breaking it first.
     * e.g. {@link BlockTypes#WATER}
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_REPLACEABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_REPLACEABLE");

    /**
     * Whether a {@link Ravager} is roaring.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ROARING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ROARING");

    /**
     * Whether a {@link Panda} is rolling around.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_ROLLING_AROUND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_ROLLING_AROUND");

    /**
     * Whether an entity is saddled.
     * e.g. {@link Horse}s and {@link Pig}s
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SADDLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SADDLED");

    /**
     * Whether an {@link Enderman} is screaming.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SCREAMING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SCREAMING");

    /**
     * Whether a {@link Sheep} is sheared.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SHEARED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SHEARED");

    /**
     * Whether an {@link Entity} is silent.
     *
     * <p>A silent entity will not emit sounds or make noises.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SILENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SILENT");

    /**
     * Whether a {@link Wolf}, {@link Cat}, {@link Panda}, or {@link Fox} is sitting.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SITTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SITTING");

    /**
     * Whether a {@link Bat}, {@link Fox} or {@link Player} is sleeping.
     *
     * <p>If a player is considered sleeping as per this data value, the player does
     * not need to be in bed in order for the other players to be able to
     * advance through the night by going to bed.</p>
     * Readonly(Player.class)
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SLEEPING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SLEEPING");

    /**
     * Whether a {@link Player Player's} sleeping status is ignored when checking whether to
     * skip the night due to players sleeping. The time in a world will be
     * advanced to day if all players in it either are sleeping or are set to ignore.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SLEEPING_IGNORED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SLEEPING_IGNORED");

    /**
     * Whether an {@link ArmorStand} is small.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SMALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SMALL");

    /**
     * Whether an {@link Entity} is sneaking.
     *
     * <p>Sneaking entities generally move slower and do not make walking
     * sounds.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SNEAKING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SNEAKING");

    /**
     * Whether a {@link Panda} is sneezing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SNEEZING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SNEEZING");

    /**
     * Whether a {@link BlockTypes#DIRT} {@link BlockState} is snowy.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SNOWY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SNOWY");

    /**
     * Whether a {@link BlockState} is solid.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SOLID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SOLID");

    /**
     * Whether an {@link Entity} is sprinting.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SPRINTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SPRINTING");

    /**
     * Whether a {@link PolarBear} is currently standing.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_STANDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_STANDING");

    /**
     * Whether a {@link Ravager} is stunned.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_STUNNED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_STUNNED");

    /**
     * Whether a {@link BlockState} is a surrogate block for a block that was provided in an environment
     * (almost always modded), that the block type provider no longer exists.
     * If true this may indicate that the surrogate block functions differently than the original block.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_SURROGATE_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_SURROGATE_BLOCK");

    /**
     * Whether players are prevented from taking
     * items from an equipment slot on an {@link ArmorStand}
     */
    public static final Supplier<Key<MapValue<EquipmentType, Boolean>>> IS_TAKING_DISABLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_TAKING_DISABLED");

    /**
     * Whether a {@link TameableAnimal} is currently tamed
     */
    public static final Supplier<Key<Value<Boolean>>> IS_TAMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_TAMED");

    /**
     * Whether a {@link Trader} is currently trading with a {@link Player}.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> IS_TRADING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_TRADING");

    /**
     * Whether a {@link Turtle} is currently traveling.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_TRAVELING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_TRAVELING");

    /**
     * Whether an {@link Ocelot} is currently trusting of {@link Player}s.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_TRUSTING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_TRUSTING");

    /**
     * Whether an {@link ItemStack} or {@link BlockState} is unbreakable.
     *
     * <p>Setting this to {@code true} will prevent the item stack's
     * {@link #ITEM_DURABILITY} from changing.</p>
     * Readonly(BlockState.class)
     */
    public static final Supplier<Key<Value<Boolean>>> IS_UNBREAKABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_UNBREAKABLE");

    /**
     * Whether a {@link Panda} is unhappy.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_UNHAPPY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_UNHAPPY");

    /**
     * Whehter a {@link BlockState} is waterlogged.
     */
    public static final Supplier<Key<Value<Boolean>>> IS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_WATERLOGGED");

    /**
     * Whether an {@link Entity} like {@link Wolf} or a
     * {@link BlockState} of {@link BlockTypes#SPONGE} is wet.
     * Readonly(Entity.class) except Wolf
     */
    public static final Supplier<Key<Value<Boolean>>> IS_WET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "IS_WET");

    /**
     * The durability of an {@link ItemStack}. {@link #MAX_DURABILITY}
     */
    public static final Supplier<Key<Value<Integer>>> ITEM_DURABILITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ITEM_DURABILITY");

    /**
     * The {@link ItemStackSnapshot item} in an
     * {@link Item}, {@link ItemFrame}, {@link Jukebox}, {@link Lectern} or
     * {@link Potion}.
     */
    public static final Supplier<Key<Value<ItemStackSnapshot>>> ITEM_STACK_SNAPSHOT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ITEM_STACK_SNAPSHOT");

    /**
     * The knockback strength applied by an {@link ArrowEntity}.
     *
     * <p>For the knockback provided by hits with a weapon according to the
     * enchantment of the same name, see {@link #APPLIED_ENCHANTMENTS}.</p>
     */
    public static final Supplier<Key<Value<Double>>> KNOCKBACK_STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "KNOCKBACK_STRENGTH");

    /**
     * The known {@link PandaGene gene} of a {@link Panda}.
     */
    public static final Supplier<Key<Value<PandaGene>>> KNOWN_GENE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "KNOWN_GENE");

    /**
     * The last attacking {@link Entity} of a {@link Living}.
     */
    public static final Supplier<Key<Value<Entity>>> LAST_ATTACKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAST_ATTACKER");

    /**
     * The output yielded by the last command of a {@link CommandBlock} or {@link CommandBlockMinecart}.
     */
    public static final Supplier<Key<Value<Text>>> LAST_COMMAND_OUTPUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAST_COMMAND_OUTPUT");

    /**
     * The last damage a {@link Living} received.
     */
    public static final Supplier<Key<Value<Double>>> LAST_DAMAGE_RECEIVED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAST_DAMAGE_RECEIVED");

    /**
     * The last time a {@link User} joined on the server.
     */
    public static final Supplier<Key<Value<Instant>>> LAST_DATE_JOINED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAST_DATE_JOINED");

    /**
     * The last time a {@link User} has been playing on the server.
     */
    public static final Supplier<Key<Value<Instant>>> LAST_DATE_PLAYED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAST_DATE_PLAYED");

    /**
     * The amount of layers a {@link BlockState} has.
     * e.g. {@link BlockTypes#SNOW}, {@link BlockTypes#CAKE}
     */
    public static final Supplier<Key<Value<Integer>>> LAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LAYER");

    /**
     * The holder of a leashed {@link Agent}
     * e.g. a {@link Player} or {@link LeashKnot}.
     * <p>Usually, a {@link LeashKnot} will always exist so long as there is
     * a leashed {@link Entity} attached. If the leash is broken, the leash
     * hitch is removed.</p>
     */
    public static final Supplier<Key<Value<Entity>>> LEASH_HOLDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LEASH_HOLDER");

    /**
     * The rotation of an {@link ArmorStand}'s left arm.
     */
    public static final Supplier<Key<Value<Vector3d>>> LEFT_ARM_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LEFT_ARM_ROTATION");

    /**
     * The rotation of an {@link ArmorStand}'s left leg.
     */
    public static final Supplier<Key<Value<Vector3d>>> LEFT_LEG_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LEFT_LEG_ROTATION");

    /**
     * The amount of ticks till a {@link Vex} starts
     * taking damage due to living too long.
     *
     * <p>When this value hits 0 or lower, the Vex will receive damage and
     * then the value will set back to 20 until the Vex dies.</p>
     *
     * <p>If the Vex was summoned by a player, this value will be pegged at 0
     * and the Vex will not take any damage.</p>
     */
    public static final Supplier<Key<Value<Integer>>> LIFE_TICKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LIFE_TICKS");

    /**
     * The amount of light that emitted by a {@link BlockState}.
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> LIGHT_EMISSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LIGHT_EMISSION");

    /**
     * A {@link Llama}'s {@link LlamaType}.
     */
    public static final Supplier<Key<Value<LlamaType>>> LLAMA_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LLAMA_TYPE");

    /**
     * The token used to lock a {@link CarrierBlockEntity}. Or the token on an {@link ItemStack} to unlock it.
     */
    public static final Supplier<Key<Value<String>>> LOCK_TOKEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LOCK_TOKEN");

    /**
     * The displayed description ("lore") text of an {@link ItemStack}.
     *
     * <p>The lore text is usually displayed when the player hovers his cursor
     * over the stack. For the contents of a book see {@link #PAGES}
     * instead.</p>
     */
    public static final Supplier<Key<ListValue<Text>>> LORE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "LORE");

    /**
     * The matter state of a {@link BlockState}
     * Readonly
     */
    public static final Supplier<Key<Value<MatterState>>> MATTER_STATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MATTER_STATE");

    /**
     * The maximum air supply a {@link Living} may have.
     *
     * <p>For the current amount of air, check {@link #REMAINING_AIR}.</p>
     */
    public static final Supplier<Key<Value<Integer>>> MAX_AIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_AIR");

    /**
     * The maximum amount of ticks a {@link FurnaceBlockEntity}
     * can burn with the currently used fuel item.
     */
    public static final Supplier<Key<Value<Integer>>> MAX_BURN_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_BURN_TIME");

    /**
     * The total time the current {@link ItemStack} in a
     * {@link FurnaceBlockEntity} has to be cooked.
     */
    public static final Supplier<Key<Value<Integer>>> MAX_COOK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_COOK_TIME");

    /**
     * The maximum durability of an {@link ItemStack}. {@link #ITEM_DURABILITY}
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> MAX_DURABILITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_DURABILITY");

    /**
     * The maximum damage a {@link FallingBlock} can deal.
     */
    public static final Supplier<Key<Value<Integer>>> MAX_FALL_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_FALL_DAMAGE");

    /**
     * The maximum health of a {@link Living}.
     *
     * <p>The maximum health set here may affect the attribute increasing
     * health points. The base health should be minded that it may be lower
     * than the total maximum health of the entity.</p>
     */
    public static final Supplier<Key<Value<Double>>> MAX_HEALTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_HEALTH");

    /**
     * The maximum number of entities around a {@link MobSpawner}.
     * A spawner will not spawn entities if there are more
     * entities around than this value permits.
     */
    public static final Supplier<Key<Value<Integer>>> MAX_NEARBY_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_NEARBY_ENTITIES");

    /**
     * The maximum amount of ticks between two
     * batches of entities spawned by a {@link MobSpawner}.
     */
    public static final Supplier<Key<Value<Integer>>> MAX_SPAWN_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_SPAWN_DELAY");

    /**
     * The max speed of a {@link Boat}. In vanilla, this is 0.4
     */
    public static final Supplier<Key<Value<Double>>> MAX_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_SPEED");

    /**
     * The maximum stack size of slots in an inventory. For most vanilla inventories this is 64.
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> MAX_STACK_SIZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MAX_STACK_SIZE");

    /**
     * The represented block's offset of a {@link MinecartEntity}.
     */
    public static final Supplier<Key<Value<Integer>>> MINECART_BLOCK_OFFSET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MINECART_BLOCK_OFFSET");

    /**
     * The minimum amount of ticks between two
     * batches of entities spawned by a {@link MobSpawner}.
     */
    public static final Supplier<Key<Value<Integer>>> MIN_SPAWN_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MIN_SPAWN_DELAY");

    /**
     * The moisture value of a {@link BlockTypes#FARMLAND} {@link BlockState}.
     */
    public static final Supplier<Key<Value<Integer>>> MOISTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MOISTURE");

    /**
     * The type of a {@link Mooshroom}.
     */
    public static final Supplier<Key<Value<MooshroomType>>> MOOSHROOM_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MOOSHROOM_TYPE");

    /**
     * The type of {@link MusicDisc} an {@link ItemStack} holds.
     */
    public static final Supplier<Key<Value<MusicDisc>>> MUSIC_DISC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "MUSIC_DISC");

    /**
     * The next entity that will be spawned by a {@link MobSpawner}.
     *
     * <p>Normally the entities to be spawned are determined by a random value
     * applied to the {@link #SPAWNABLE_ENTITIES} weighted collection. If this
     * value exists, it will override the random spawn with a definite one.</p>
     */
    public static final Supplier<Key<Value<WeightedSerializableObject<EntityArchetype>>>> NEXT_ENTITY_TO_SPAWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "NEXT_ENTITY_TO_SPAWN");

    /**
     * The pitch of a {@link BlockTypes#NOTE_BLOCK} {@link BlockState}.
     */
    public static final Supplier<Key<Value<NotePitch>>> NOTE_PITCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "NOTE_PITCH");

    /**
     * The notifier, usually of an {@link Entity}. It is up to the implementation to define.
     */
    public static final Supplier<Key<Value<UUID>>> NOTIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "NOTIFIER");

    /**
     * The deceleration a {@link Boat} while it has {@link Keys#PASSENGERS}.
     */
    public static final Supplier<Key<Value<Double>>> OCCUPIED_DECELERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "OCCUPIED_DECELERATION");

    /**
     * Whether an {@link Entity} is currently considered to be on the ground.
     * Readonly
     */
    public static final Supplier<Key<Value<Boolean>>> ON_GROUND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ON_GROUND");

    /**
     * The content of a {@link ItemTypes#WRITTEN_BOOK} {@link ItemStack}.
     *
     * <p>Use {@link Keys#PLAIN_PAGES} if you wish to inspect the contents
     * of a {@link ItemTypes#WRITABLE_BOOK}.</p>
     */
    public static final Supplier<Key<ListValue<Text>>> PAGES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PAGES");

    /**
     * The {@link ParrotType type} of a {@link Parrot}.
     */
    public static final Supplier<Key<Value<ParrotType>>> PARROT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PARROT_TYPE");

    /**
     * The particle type of an {@link AreaEffectCloud}.
     *
     * <p>Only a few {@link ParticleOption}s will be usable for this
     * effect for specific {@link ParticleType}s and not every
     * {@link ParticleType} will be applicable.</p>
     */
    public static final Supplier<Key<Value<ParticleEffect>>> PARTICLE_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PARTICLE_EFFECT");

    /**
     * The amount of ticks a {@link FurnaceBlockEntity} has
     * been cooking the current item for.
     *
     * <p>Once this value reaches the {@link #MAX_COOK_TIME}, the
     * item will be finished cooking.</p>
     */
    public static final Supplier<Key<Value<Integer>>> PASSED_COOK_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PASSED_COOK_TIME");

    /**
     * The entities that act as passengers for an {@link Entity}.
     *
     * <p>For example, a {@link Player} riding on a {@link Horse} or a
     * {@link Pig} would be considered its passenger.</p>
     */
    public static final Supplier<Key<ListValue<Entity>>> PASSENGERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PASSENGERS");

    /**
     * A {@link TropicalFish}'s pattern color.
     */
    public static final Supplier<Key<Value<DyeColor>>> PATTERN_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PATTERN_COLOR");

    /**
     * The {@link PhantomPhase phase} of a {@link Phantom}.
     */
    public static final Supplier<Key<Value<PhantomPhase>>> PHANTOM_PHASE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PHANTOM_PHASE");

    /**
     * The pickup delay (in ticks) of an {@link Item}.
     */
    public static final Supplier<Key<Value<Integer>>> PICKUP_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PICKUP_DELAY");

    /**
     * The {@link PickupRule} of an {@link ArrowEntity}.
     */
    public static final Supplier<Key<Value<PickupRule>>> PICKUP_RULE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PICKUP_RULE");

    /**
     * The piston type of a piston {@link BlockState} TODO dataholder {@link Piston}.
     */
    public static final Supplier<Key<Value<PistonType>>> PISTON_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PISTON_TYPE");

    /**
     * The block types an {@link ItemStack} may be placed on.
     */
    public static final Supplier<Key<SetValue<BlockType>>> PLACEABLE_BLOCK_TYPES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PLACEABLE_BLOCK_TYPES");

    /**
     * The content of a {@link ItemTypes#WRITABLE_BOOK} {@link ItemStack}.
     *
     * <p>Use {@link Keys#PAGES} if you wish to get the contents of a
     * {@link ItemTypes#WRITTEN_BOOK}</p>
     */
    public static final Supplier<Key<ListValue<String>>> PLAIN_PAGES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PLAIN_PAGES");

    /**
     * The plugin that created an {@link Inventory}
     */
    public static final Supplier<Key<Value<PluginContainer>>> PLUGIN_CONTAINER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PLUGIN_CONTAINER");

    /**
     * The pore sides of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     * See {@link #HAS_PORES_UP}, {@link #HAS_PORES_DOWN}, {@link #HAS_PORES_NORTH}, {@link #HAS_PORES_EAST}, {@link #HAS_PORES_SOUTH}, {@link #HAS_PORES_WEST}.
     */
    public static final Supplier<Key<SetValue<Direction>>> PORES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PORES");

    /**
     * The {@link PortionType} of a {@link BlockState}.
     * e.g. {@link BlockTypes#OAK_DOOR}, {@link BlockTypes#ROSE_BUSH} or {@link BlockTypes#WHITE_BED}
     * For slabs use {@link #SLAB_PORTION} instead
     */
    public static final Supplier<Key<Value<PortionType>>> PORTION_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PORTION_TYPE");

    /**
     * The potential max speed of a {@link Minecart}.
     */
    public static final Supplier<Key<Value<Double>>> POTENTIAL_MAX_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POTENTIAL_MAX_SPEED");

    /**
     * The potion effects that are present on an {@link Entity}
     * <p>or applied by an {@link AreaEffectCloud} or {@link ArrowEntity}</p>
     * <p>or stored on an {@link ItemStack}.</p>
     */
    public static final Supplier<Key<ListValue<PotionEffect>>> POTION_EFFECTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POTION_EFFECTS");

    /**
     * The potion type of an {@link ItemStack}.
     */
    public static final Supplier<Key<Value<PotionType>>> POTION_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POTION_TYPE");

    /**
     * The signal power of a {@link BlockState}.
     *
     * <p>Applies to blocks that may emit a Redstone signal of variable
     * strength, such as {@link BlockTypes#REDSTONE_WIRE},
     * {@link BlockTypes#DAYLIGHT_DETECTOR},
     * {@link BlockTypes#LIGHT_WEIGHTED_PRESSURE_PLATE} etc.</p>
     */
    public static final Supplier<Key<Value<Integer>>> POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "POWER");

    /**
     * A {@link Beacon}'s primary effect.
     */
    public static final Supplier<Key<Value<PotionEffectType>>> PRIMARY_POTION_EFFECT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PRIMARY_POTION_EFFECT_TYPE");

    /**
     * The {@link Villager} or {@link ZombieVillager}'s {@link ProfessionType}.
     */
    public static final Supplier<Key<Value<ProfessionType>>> PROFESSION_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PROFESSION_TYPE");

    /**
     * The {@link Villager} or {@link ZombieVillager}'s {@link ProfessionType} level.
     */
    public static final Supplier<Key<Value<Integer>>> PROFESSION_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "PROFESSION_LEVEL");

    /**
     * The type of a {@link Rabbit}.
     */
    public static final Supplier<Key<Value<RabbitType>>> RABBIT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RABBIT_TYPE");

    /**
     * The radius of an {@link AreaEffectCloud}.
     */
    public static final Supplier<Key<Value<Double>>> RADIUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RADIUS");

    /**
     * The amount the radius of an
     * {@link AreaEffectCloud} grows or shrinks each time it applies its
     * effect.
     */
    public static final Supplier<Key<Value<Double>>> RADIUS_ON_USE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RADIUS_ON_USE");

    /**
     * The amount the radius of an
     * {@link AreaEffectCloud} grows or shrinks per tick.
     */
    public static final Supplier<Key<Value<Double>>> RADIUS_PER_TICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RADIUS_PER_TICK");

    /**
     * The wave number of a raid a {@link Raider} is in.
     * Readonly but mutable
     */
    public static final Supplier<Key<Value<RaidWave>>> RAID_WAVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RAID_WAVE");

    /**
     * The {@link RailDirection} of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<RailDirection>>> RAIL_DIRECTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RAIL_DIRECTION");

    /**
     * The delay (in ticks) after which an
     * {@link AreaEffectCloud} will reapply its effect on a previously
     * affected {@link Entity}.
     */
    public static final Supplier<Key<Value<Integer>>> REAPPLICATION_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REAPPLICATION_DELAY");

    /**
     * The redstone delay on a {@link BlockTypes#REPEATER} {@link BlockState}.
     */
    public static final Supplier<Key<Value<Integer>>> REDSTONE_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REDSTONE_DELAY");

    /**
     * The amount of air a {@link Living} has left.
     */
    public static final Supplier<Key<Value<Integer>>> REMAINING_AIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REMAINING_AIR");

    /**
     * The remaining amount of ticks the current brewing
     * process of a {@link BrewingStand} will take.
     *
     * <p>If nothing is being brewed, the remaining brew time will be 0.</p>
     */
    public static final Supplier<Key<Value<Integer>>> REMAINING_BREW_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REMAINING_BREW_TIME");

    /**
     * Represents the {@link Key} for the remaining number of ticks to pass
     * before another attempt to spawn entities is made by a {@link MobSpawner}.
     */
    public static final Supplier<Key<Value<Integer>>> REMAINING_SPAWN_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REMAINING_SPAWN_DELAY");

    /**
     * The amount of food a food {@link ItemStack} restores when eaten.
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> REPLENISHED_FOOD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REPLENISHED_FOOD");

    /**
     * The amount of saturation a food {@link ItemStack} provides when eaten.
     * Readonly
     */
    public static final Supplier<Key<Value<Double>>> REPLENISHED_SATURATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REPLENISHED_SATURATION");

    /**
     * The {@link InstrumentType} of a {@link BlockState} when placed under a {@link BlockTypes#NOTE_BLOCK}.
     * Readonly
     */
    public static final Supplier<Key<Value<InstrumentType>>> REPRESENTED_INSTRUMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REPRESENTED_INSTRUMENT");

    /**
     * How close a {@link Player} has to be around the {@link MobSpawner}
     * in order for it to attempt to spawn entities.
     */
    public static final Supplier<Key<Value<Double>>> REQUIRED_PLAYER_RANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "REQUIRED_PLAYER_RANGE");

    /**
     * The spawn locations a {@link Player}
     * may have for various worlds based on {@link UUID} of the world.
     */
    public static final Supplier<Key<MapValue<UUID, RespawnLocation>>> RESPAWN_LOCATIONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RESPAWN_LOCATIONS");

    /**
     * The rotation of an {@link ArmorStand}'s right arm.
     */
    public static final Supplier<Key<Value<Vector3d>>> RIGHT_ARM_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RIGHT_ARM_ROTATION");

    /**
     * The rotation of an {@link ArmorStand}'s right leg.
     */
    public static final Supplier<Key<Value<Vector3d>>> RIGHT_LEG_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "RIGHT_LEG_ROTATION");

    /**
     * The time a {@link Ravager} is roaring.
     */
    public static final Supplier<Key<Value<Integer>>> ROARING_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ATTACK_TIME");

    /**
     * The {@link Rotation} of an {@link ItemFrame}.
     */
    public static final Supplier<Key<Value<Rotation>>> ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "ROTATION");

    /**
     * The current saturation of a {@link Player}.
     *
     * <p>When the saturation level reaches 0, the food level is usually
     * diminished such that the food level is decreased by 1, then
     * saturation is reset to the maximum value. This type of effect occurs
     * over time and can be modified by movements and actions performed by the
     * {@link Player}.</p>
     */
    public static final Supplier<Key<Value<Double>>> SATURATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SATURATION");

    /**
     * The "scale" for the size of an {@link Entity}.
     *
     * <p>Together with {@link #BASE_SIZE} and {@link #HEIGHT} this defines the size of an {@link Entity}.</p>
     */
    public static final Supplier<Key<Value<Double>>> SCALE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SCALE");

    /**
     * The scoreboard tags applied to an {@link Entity}.
     *
     * @see <a href="https://minecraft.gamepedia.com/Scoreboard#Tags">
     * https://minecraft.gamepedia.com/Scoreboard#Tags</a>
     */
    public static final Supplier<Key<SetValue<String>>> SCOREBOARD_TAGS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SCOREBOARD_TAGS");

    /**
     * A {@link Beacon}'s secondary effect.
     */
    public static final Supplier<Key<Value<PotionEffectType>>> SECONDARY_POTION_EFFECT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SECONDARY_POTION_EFFECT_TYPE");

    /**
     * A {@link Fox fox's} second trusted {@link UUID}, usually a {@link Player}.
     */
    public static final Supplier<Key<Value<UUID>>> SECOND_TRUSTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SECOND_TRUSTED");

    /**
     * The shooter of a {@link Projectile}.
     */
    public static final Supplier<Key<Value<ProjectileSource>>> SHOOTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SHOOTER");

    /**
     * Whether a {@link EnderCrystal} should show it's bottom bedrock platform.
     */
    public static final Supplier<Key<Value<Boolean>>> SHOW_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SHOW_BOTTOM");

    /**
     * The lines displayed on a {@link Sign}.
     */
    public static final Supplier<Key<ListValue<Text>>> SIGN_LINES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SIGN_LINES");

    /**
     * The size of a {@link Slime}.
     * or
     * The size of a {@link Phantom}. In vanilla, this ranges between 0 and 64.
     */
    public static final Supplier<Key<Value<Integer>>> SIZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SIZE");

    /**
     * The skin of a {@link Humanoid}.
     *
     * <p>Skins can only be manipulated by supplying the UUID of a player
     * having that skin. The binary skin data is signed by Mojang so fully
     * customized skins are not possible.</p>
     * Readonly(Player.class)
     */
    public static final Supplier<Key<Value<ProfileProperty>>> SKIN_PROFILE_PROPERTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SKIN_PROFILE_PROPERTY");

    /**
     * The "moisture" state of a {@link Dolphin}.
     *
     * <p>
     *     Vanilla sets the dolphin's skin moisture to 2400 so long as the entity
     *     is in water, being rained on, or in a bubble column. If not, the dolphin
     *     will loose 1 moisture per tick. Once this value is 0 or below, the dolphin
     *     will be damaged via {@link DamageSources#DRYOUT} with a value of 1 per tick
     *     until death.
     * </p>
     */
    public static final Supplier<Key<Value<Integer>>> SKIN_MOISTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SKIN_MOISTURE");

    /**
     * The skylight value at a {@link ServerLocation}.
     * For the blocklight see {@link #BLOCK_LIGHT}.
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> SKY_LIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SKY_LIGHT");

    /**
     * The {@link SlabPortion} of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<SlabPortion>>> SLAB_PORTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SLAB_PORTION");

    /**
     * The index of a {@link Slot} in an {@link Inventory}
     * Readonly
     */
    public static final Supplier<Key<Value<Integer>>> SLOT_INDEX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SLOT_INDEX");

    /**
     * The position of a {@link Slot} within a {@link GridInventory}.
     * Readonly
     */
    public static final Supplier<Key<Value<Vector2i>>> SLOT_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SLOT_POSITION");

    /**
     * The side of a particular {@link Slot}, for use in querying "sided inventories".
     * Readonly
     */
    public static final Supplier<Key<Value<Direction>>> SLOT_SIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SLOT_SIDE");

    /**
     * Whether a {@link Minecart} slows down when it has no {@link Keys#PASSENGERS}.
     */
    public static final Supplier<Key<Value<Boolean>>> SLOWS_UNOCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SLOWS_UNOCCUPIED");

    /**
     * The time a {@link Panda} has been sneezing (in ticks)
     */
    public static final Supplier<Key<Value<Integer>>> SNEEZING_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SNEEZING_TIME");

    /**
     * The list of {@link EntityArchetype}s able to be spawned by a {@link MobSpawner}.
     */
    public static final Supplier<Key<WeightedCollectionValue<EntityArchetype>>> SPAWNABLE_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWNABLE_ENTITIES");

    /**
     * How many entities a {@link MobSpawner} has spawned so far.
     */
    public static final Supplier<Key<Value<Integer>>> SPAWN_COUNT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWN_COUNT");

    /**
     * How far away from the {@link MobSpawner} the entities spawned by it may appear.
     */
    public static final Supplier<Key<Value<Double>>> SPAWN_RANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPAWN_RANGE");

    /**
     * The {@link Entity target} of the spectator camera of a {@link Player}.
     */
    public static final Supplier<Key<Value<Entity>>> SPECTATOR_TARGET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SPECTATOR_TARGET");

    /**
     * The {@link StairShape} of a {@link BlockState}.
     */
    public static final Supplier<Key<Value<StairShape>>> STAIR_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STAIR_SHAPE");

    /**
     * The {@link Statistic}s of a {@link Player}.
     */
    public static final Supplier<Key<MapValue<Statistic, Long>>> STATISTICS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STATISTICS");

    /**
     * The enchantments stored on an {@link ItemStack}.
     *
     * <p>Stored enchantments are meant to be transferred. Usually this key
     * applies to {@link ItemTypes#ENCHANTED_BOOK} {@link ItemStack}s. Enchantments
     * affecting the item stack are retrieved via {@link #APPLIED_ENCHANTMENTS}
     * instead.</p>
     */
    public static final Supplier<Key<ListValue<Enchantment>>> STORED_ENCHANTMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STORED_ENCHANTMENTS");

    /**
     * A {@link Llama}s carrying strength. The higher the strength,
     * the more items it can carry (effectively the size of inventory).
     */
    public static final Supplier<Key<Value<Integer>>> STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRENGTH");

    /**
     * The author of a structure from a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<String>>> STRUCTURE_AUTHOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_AUTHOR");

    /**
     * Whether a {@link StructureBlock} should
     * ignore entities when saving a structure.
     */
    public static final Supplier<Key<Value<Boolean>>> STRUCTURE_IGNORE_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_IGNORE_ENTITIES");

    /**
     * The integrity of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Double>>> STRUCTURE_INTEGRITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_INTEGRITY");

    /**
     * The mode of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<StructureMode>>> STRUCTURE_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_MODE");

    /**
     * The position of a {@link StructureBlock}.
     */
    public static final Supplier<Key<Value<Vector3i>>> STRUCTURE_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_POSITION");

    /**
     * Whether a {@link StructureBlock} is powered.
     */
    public static final Supplier<Key<Value<Boolean>>> STRUCTURE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_POWERED");

    /**
     * The seed of a {@link StructureBlock}
     */
    public static final Supplier<Key<Value<Long>>> STRUCTURE_SEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_SEED");

    /**
     * Whether a
     * {@link StructureBlock} should make all {@link BlockTypes#AIR},
     * {@link BlockTypes#CAVE_AIR}, {@link BlockTypes#STRUCTURE_VOID} visible.
     */
    public static final Supplier<Key<Value<Boolean>>> STRUCTURE_SHOW_AIR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_SHOW_AIR");

    /**
     * Whether a {@link StructureBlock} shows the bounding box.
     */
    public static final Supplier<Key<Value<Boolean>>> STRUCTURE_SHOW_BOUNDING_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_SHOW_BOUNDING_BOX");

    /**
     * The size of a {@link StructureBlock}s structure.
     */
    public static final Supplier<Key<Value<Vector3i>>> STRUCTURE_SIZE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STRUCTURE_SIZE");

    /**
     * The amount of "stuck arrows" in a {@link Living}.
     */
    public static final Supplier<Key<Value<Integer>>> STUCK_ARROWS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STUCK_ARROWS");

    /**
     * The time (in ticks) a {@link Ravager} is stunned.
     */
    public static final Supplier<Key<Value<Integer>>> STUNNED_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "STUNNED_TIME");

    /**
     * The amount of successful executions of a command
     * stored in a {@link CommandBlock} or {@link CommandBlockMinecart}.
     */
    public static final Supplier<Key<Value<Integer>>> SUCCESS_COUNT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SUCCESS_COUNT");

    /**
     * Whether a {@link BlockState} is suspended.
     */
    public static final Supplier<Key<Value<Boolean>>> SUSPENDED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SUSPENDED");

    /**
     * The swiftness of a {@link Minecart}.
     */
    public static final Supplier<Key<Value<Double>>> SWIFTNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "SWIFTNESS");

    /**
     * The tamer of a {@link TameableAnimal} or {@link HorseEntity}.
     */
    public static final Supplier<Key<Value<UUID>>> TAMER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TAMER");

    /**
     * The targeted entity either by an {@link Agent} and it's
     * {@link GoalExecutorTypes#TARGET} selector or by a {@link FishingBobber} or {@link ShulkerBullet}.
     */
    public static final Supplier<Key<Value<Entity>>> TARGET_ENTITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TARGET_ENTITY");

    /**
     * A target location.
     * e.g. An {@link EyeOfEnder} target or a {@link Player}'s compass.
     */
    public static final Supplier<Key<Value<Vector3d>>> TARGET_LOCATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TARGET_LOCATION");

    /**
     * A target block position.
     * e.g. A {@link Patroller}'s patrol target,
     * the travel position of a {@link Turtle},
     * the exit portal position of a {@link EndGateway} or
     * an {@link EnderCrystal}'s beam target.
     */
    public static final Supplier<Key<Value<Vector3i>>> TARGET_POSITION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TARGET_POSITION");

    /**
     * The remaining fuse time in ticks of a {@link FusedExplosive}.
     * This value may be set to an arbitrary value
     * if the explosive is not primed.
     */
    public static final Supplier<Key<Value<Integer>>> TICKS_REMAINING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TICKS_REMAINING");

    /**
     * The {@link ToolType} of an {@link ItemStack} tool.
     * Readonly
     */
    public static final Supplier<Key<Value<ToolType>>> TOOL_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TOOL_TYPE");

    /**
     * Whether a {@link CommandBlock} does track its output.
     *
     * <p>If this is set, the output of the most recent execution can be
     * retrieved using {@link #LAST_COMMAND_OUTPUT}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> TRACKS_OUTPUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TRACKS_OUTPUT");

    /**
     * Tge {@link TradeOffer}s offered by a {@link Trader}.
     */
    public static final Supplier<Key<ListValue<TradeOffer>>> TRADE_OFFERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TRADE_OFFERS");

    /**
     * Whether an {@link Entity} is transient.
     * This prevents the entity from being saved to disk.
     */
    public static final Supplier<Key<Value<Boolean>>> TRANSIENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TRANSIENT");

    /**
     * A {@link TropicalFish}'s shape.
     */
    public static final Supplier<Key<Value<TropicalFishShape>>> TROPICAL_FISH_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "TROPICAL_FISH_SHAPE");

    /**
     * The time a {@link Panda} has been unhappy (in ticks)
     */
    public static final Supplier<Key<Value<Integer>>> UNHAPPY_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "UNHAPPY_TIME");

    /**
     * The {@link UUID} of a custom inventory.
     */
    public static final Supplier<Key<Value<UUID>>> UNIQUE_ID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "UNIQUE_ID");

    /**
     * The deceleration a {@link Boat} while it does not have {@link Keys#PASSENGERS}.
     */
    public static final Supplier<Key<Value<Double>>> UNOCCUPIED_DECELERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "UNOCCUPIED_DECELERATION");

    /**
     * Whether a {@link BlockTypes#TNT} {@link BlockState} is unstable.
     */
    public static final Supplier<Key<Value<Boolean>>> UNSTABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "UNSTABLE");

    /**
     * Whether changes to {@link Keys#SKIN_PROFILE_PROPERTY} should
     * be reflected in an entitie's {@link GameProfile}.
     */
    public static final Supplier<Key<Value<Boolean>>> UPDATE_GAME_PROFILE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "UPDATE_GAME_PROFILE");

    /**
     * Whether an {@link Entity} is vanished.
     *
     * <p>The presence of a vanished entity will not be made known to a client;
     * no packets pertaining to this entity are sent. Client-side, this entity
     * will cease to exist. Server-side it may still be targeted by hostile
     * entities or collide with other entities.</p>
     *
     * <p>Vanishing an {@link Entity} ridden by other entities (see
     * {@link #PASSENGERS} will cause problems.</p>
     * <p>
     */
    public static final Supplier<Key<Value<Boolean>>> VANISH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VANISH");

    /**
     * Whether an {@link Entity} ignores collision with other entities.
     *
     * <p>This state will be ignored if the {@link Entity} is not also
     * vanished as per {@link #VANISH}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> VANISH_IGNORES_COLLISION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VANISH_IGNORES_COLLISION");

    /**
     * Whether an {@link Entity} can be targeted for attack by another entity.
     * This prevents neither {@link Player}s from attacking the entity nor
     * will it be protected from untargeted damage like fire or explosions.
     *
     * <p>This state will be ignored if the {@link Entity} is not also
     * vanished as per {@link #VANISH}.}.</p>
     */
    public static final Supplier<Key<Value<Boolean>>> VANISH_PREVENTS_TARGETING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VANISH_PREVENTS_TARGETING");

    /**
     * The vehicle an {@link Entity} is riding.
     *
     * <p>Vehicles may be nested as a vehicle might itself ride another entity.
     * To get the vehicle on bottom, use {@link Keys#BASE_VEHICLE}.</p>
     */
    public static final Supplier<Key<Value<Entity>>> VEHICLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VEHICLE");

    /**
     * The velocity of an {@link Entity}.
     */
    public static final Supplier<Key<Value<Vector3d>>> VELOCITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VELOCITY");

    /**
     * The type of a {@link Villager} or {@link ZombieVillager}.
     */
    public static final Supplier<Key<Value<VillagerType>>> VILLAGER_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "VILLAGER_TYPE");

    /**
     * The duration in ticks after which an
     * {@link AreaEffectCloud} will begin to apply its effect to entities.
     */
    public static final Supplier<Key<Value<Integer>>> WAIT_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WAIT_TIME");

    /**
     * The base speed at which a {@link Player} or {@link Living} walks.
     */
    public static final Supplier<Key<Value<Double>>> WALKING_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WALKING_SPEED");

    /**
     * Whether a thrown {@link EyeOfEnder} will shatter.
     */
    public static final Supplier<Key<Value<Boolean>>> WILL_SHATTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WILL_SHATTER");

    /**
     * The {@link WireAttachmentType}s of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState} for its neighboring blocks.
     */
    public static final Supplier<Key<MapValue<Direction, WireAttachmentType>>> WIRE_ATTACHMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENTS");

    /**
     * The {@link WireAttachmentType} of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState}
     * for its neighboring block to the {@link Direction#EAST}.
     */
    public static final Supplier<Key<Value<WireAttachmentType>>> WIRE_ATTACHMENT_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENT_EAST");

    /**
     * The {@link WireAttachmentType} of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState}
     * for its neighboring block to the {@link Direction#NORTH}.
     */
    public static final Supplier<Key<Value<WireAttachmentType>>> WIRE_ATTACHMENT_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENT_NORTH");

    /**
     * The {@link WireAttachmentType} of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState}
     * for its neighboring block to the {@link Direction#SOUTH}.
     */
    public static final Supplier<Key<Value<WireAttachmentType>>> WIRE_ATTACHMENT_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENT_SOUTH");

    /**
     * The {@link WireAttachmentType} of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState}
     * for its neighboring block to the {@link Direction#WEST}.
     */
    public static final Supplier<Key<Value<WireAttachmentType>>> WIRE_ATTACHMENT_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WIRE_ATTACHMENT_WEST");

    /**
     * The entities targeted by the three {@link Wither} heads. In vanilla the wither only targets {@link Living}. {@code null} for no target entity.
     */
    public static final Supplier<Key<ListValue<Entity>>> WITHER_TARGETS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WITHER_TARGETS");

    /**
     * The {@link Sheep} who is being targeted by the {@link SpellTypes#WOLOLO}
     * spell being casted by an {@link Evoker}
     */
    public static final Supplier<Key<Value<Sheep>>> WOLOLO_TARGET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WOLOLO_TARGET");

    /**
     * The {@link WoodType} of a {@link Boat}.
     * TODO BlockState dataholders?
     */
    public static final Supplier<Key<Value<WoodType>>> WOOD_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Key.class, "WOOD_TYPE");

    // SORTFIELDS:OFF

    private Keys() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
