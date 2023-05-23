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

import io.leangen.geantyref.TypeToken;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.ResourceKey;
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
import org.spongepowered.api.data.meta.BannerPatternLayer;
import org.spongepowered.api.data.type.ArmorMaterial;
import org.spongepowered.api.data.type.ArtType;
import org.spongepowered.api.data.type.AttachmentSurface;
import org.spongepowered.api.data.type.BoatType;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.type.BodyParts;
import org.spongepowered.api.data.type.CatType;
import org.spongepowered.api.data.type.ChestAttachmentType;
import org.spongepowered.api.data.type.ComparatorMode;
import org.spongepowered.api.data.type.DoorHinge;
import org.spongepowered.api.data.type.DripstoneSegment;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.FoxType;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.ItemTier;
import org.spongepowered.api.data.type.LlamaType;
import org.spongepowered.api.data.type.MatterType;
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
import org.spongepowered.api.data.type.SculkSensorState;
import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.data.type.SlabPortion;
import org.spongepowered.api.data.type.SpellType;
import org.spongepowered.api.data.type.SpellTypes;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.type.Tilt;
import org.spongepowered.api.data.type.TropicalFishShape;
import org.spongepowered.api.data.type.VillagerType;
import org.spongepowered.api.data.type.WallConnectionState;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.SetValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.WeightedCollectionValue;
import org.spongepowered.api.effect.VanishState;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOption;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.entity.AreaEffectCloud;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.entity.EntityCategory;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.ai.goal.GoalExecutorTypes;
import org.spongepowered.api.entity.display.BillboardType;
import org.spongepowered.api.entity.display.DisplayEntity;
import org.spongepowered.api.entity.display.ItemDisplayType;
import org.spongepowered.api.entity.display.TextAlignment;
import org.spongepowered.api.entity.display.TextDisplay;
import org.spongepowered.api.entity.explosive.EndCrystal;
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
import org.spongepowered.api.entity.living.animal.horse.HorseLike;
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
import org.spongepowered.api.entity.living.monster.piglin.Piglin;
import org.spongepowered.api.entity.living.monster.raider.Raider;
import org.spongepowered.api.entity.living.monster.raider.Ravager;
import org.spongepowered.api.entity.living.monster.raider.illager.Pillager;
import org.spongepowered.api.entity.living.monster.raider.illager.Vindicator;
import org.spongepowered.api.entity.living.monster.raider.illager.spellcaster.Evoker;
import org.spongepowered.api.entity.living.monster.raider.illager.spellcaster.Spellcaster;
import org.spongepowered.api.entity.living.monster.slime.Slime;
import org.spongepowered.api.entity.living.monster.spider.Spider;
import org.spongepowered.api.entity.living.monster.zombie.ZombieVillager;
import org.spongepowered.api.entity.living.monster.zombie.ZombifiedPiglin;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.chat.ChatVisibility;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
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
import org.spongepowered.api.entity.vehicle.minecart.MinecartLike;
import org.spongepowered.api.entity.weather.LightningBolt;
import org.spongepowered.api.entity.weather.WeatherEffect;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSources;
import org.spongepowered.api.fluid.FluidStackSnapshot;
import org.spongepowered.api.fluid.FluidTypes;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.FireworkShape;
import org.spongepowered.api.item.ItemRarity;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.slot.EquipmentSlot;
import org.spongepowered.api.item.inventory.type.GridInventory;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.item.potion.PotionType;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.map.MapInfo;
import org.spongepowered.api.map.decoration.MapDecoration;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.property.ProfileProperty;
import org.spongepowered.api.projectile.source.ProjectileSource;
import org.spongepowered.api.raid.Raid;
import org.spongepowered.api.raid.RaidWave;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.tag.Tag;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.util.Range;
import org.spongepowered.api.util.RespawnLocation;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.util.Transform;
import org.spongepowered.api.util.orientation.Orientation;
import org.spongepowered.api.util.weighted.WeightedSerializableObject;
import org.spongepowered.api.world.DefaultWorldKeys;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.WorldTypeEffect;
import org.spongepowered.api.world.WorldTypes;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.biome.ambient.ParticleConfig;
import org.spongepowered.api.world.biome.ambient.SoundConfig;
import org.spongepowered.api.world.biome.climate.GrassColorModifier;
import org.spongepowered.api.world.biome.climate.Precipitation;
import org.spongepowered.api.world.biome.climate.TemperatureModifier;
import org.spongepowered.api.world.biome.spawner.NaturalSpawnCost;
import org.spongepowered.api.world.biome.spawner.NaturalSpawner;
import org.spongepowered.api.world.border.WorldBorder;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.generation.ChunkGenerator;
import org.spongepowered.api.world.generation.carver.Carver;
import org.spongepowered.api.world.generation.carver.CarvingStep;
import org.spongepowered.api.world.generation.config.WorldGenerationConfig;
import org.spongepowered.api.world.generation.feature.DecorationStep;
import org.spongepowered.api.world.generation.feature.PlacedFeature;
import org.spongepowered.api.world.portal.PortalType;
import org.spongepowered.api.world.portal.PortalTypes;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.server.WorldTemplate;
import org.spongepowered.api.world.server.storage.ServerWorldProperties;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.WeatherType;
import org.spongepowered.api.world.weather.WeatherTypes;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;
import org.spongepowered.plugin.PluginContainer;

import java.time.Instant;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * An enumeration of known {@link Key}s used throughout the API.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class Keys {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * The {@link PotionEffectTypes#ABSORPTION} amount of a {@link Living} entity.
     */
    public static final Key<Value<Double>> ABSORPTION = Keys.key(ResourceKey.sponge("absorption"), Double.class);

    /**
     * The acceleration of a {@link DamagingProjectile}.
     */
    public static final Key<Value<Vector3d>> ACCELERATION = Keys.key(ResourceKey.sponge("acceleration"), Vector3d.class);

    /**
     * The item a {@link Living} entity is currently using.
     * For example a player eating a food or blocking with a shield.
     *
     * <p>If there is no item, the snapshot will be empty. You can check this
     * with {@link ItemStackSnapshot#isEmpty()}.</p>
     */
    public static final Key<Value<ItemStackSnapshot>> ACTIVE_ITEM = Keys.key(ResourceKey.sponge("active_item"), ItemStackSnapshot.class);

    /**
     * Whether a {@link Player}s affects spawning.
     *
     * <p>A {@link Player} who does not affect spawning will be treated as a
     * spectator in regards to spawning. A {@link MobSpawner} will not be
     * activated by his presence and mobs around him may naturally despawn
     * if there is no other Player around who affects spawning.</p>
     */
    public static final Key<Value<Boolean>> AFFECTS_SPAWNING = Keys.key(ResourceKey.sponge("affects_spawning"), Boolean.class);

    /**
     * The age (in ticks) of an entity.
     * e.g. The age of an {@link AreaEffectCloud}.
     * <p>Note that in vanilla this value is not persisted for most entities.</p>
     */
    public static final Key<Value<Integer>> AGE = Keys.key(ResourceKey.sponge("age"), Integer.class);

    /**
     * The modifier to {@link Keys#VELOCITY} of a {@link Minecart} while airborne.
     */
    public static final Key<Value<Vector3d>> AIRBORNE_VELOCITY_MODIFIER = Keys.key(ResourceKey.sponge("airborne_velocity_modifier"), Vector3d.class);

    /**
     * The additional ambient sound settings in a {@link Biome}
     * Readonly
     */
    public static final Key<Value<SoundConfig.Additional>> AMBIENT_ADDITIONAL_SOUND = Keys.key(ResourceKey.sponge("ambient_additional_sound"), SoundConfig.Additional.class);

    /**
     * The ambient lightning of a {@link WorldType}.
     * <p>Affects ambient light effects in a {@link ServerWorld} of that type.</p>
     * <p>In Vanilla, the value will be between {@code 0.0} and {@code 1.0}</p>
     * Readonly
     */
    public static final Key<Value<Float>> AMBIENT_LIGHTING = Keys.key(ResourceKey.sponge("ambient_lighting"), Float.class);

    /**
     * The ambient mood settings in a {@link Biome}
     * Readonly
     */
    public static final Key<Value<SoundConfig.Mood>> AMBIENT_MOOD = Keys.key(ResourceKey.sponge("ambient_mood"), SoundConfig.Mood.class);

    /**
     * The ambient particle settings in a {@link Biome}
     * Readonly
     */
    public static final Key<Value<ParticleConfig>> AMBIENT_PARTICLE = Keys.key(ResourceKey.sponge("ambient_particle"), ParticleConfig.class);

    /**
     * The ambient sound in a {@link Biome}
     * Readonly
     */
    public static final Key<Value<SoundType>> AMBIENT_SOUND = Keys.key(ResourceKey.sponge("ambient_sound"), SoundType.class);

    /**
     * The anger level of a {@link ZombifiedPiglin}.
     *
     * <p>Unlike {@link Keys#IS_ANGRY}, the aggressiveness represented by this key may
     * fade over time and the entity will become peaceful again once its anger
     * reaches its minimum.</p>
     */
    public static final Key<Value<Integer>> ANGER_LEVEL = Keys.key(ResourceKey.sponge("anger_level"), Integer.class);

    /**
     * The set of {@link PotionEffect}s applied on use of an {@link ItemStack}.
     * Readonly
     */
    public static final Key<WeightedCollectionValue<PotionEffect>> APPLICABLE_POTION_EFFECTS = Keys.weightedKey(ResourceKey.sponge("applicable_potion_effects"), PotionEffect.class);

    /**
     * The enchantments applied to an {@link ItemStack}.
     *
     * <p>This data is usually applicable to all types of armor, weapons and
     * tools. Enchantments that are only stored on an item stack in order to
     * be transferred to another item (like on
     * {@link ItemTypes#ENCHANTED_BOOK}s) use the {@link #STORED_ENCHANTMENTS}
     * key instead.)</p>
     */
    public static final Key<ListValue<Enchantment>> APPLIED_ENCHANTMENTS = Keys.listKey(ResourceKey.sponge("applied_enchantments"), Enchantment.class);

    /**
     * The {@link ArmorMaterial} of an armor {@link ItemStack}.
     * Readonly
     */
    public static final Key<Value<ArmorMaterial>> ARMOR_MATERIAL = Keys.key(ResourceKey.sponge("armor_material"), ArmorMaterial.class);

    /**
     * The type of {@link ArtType} shown by {@link Painting}s.
     */
    public static final Key<Value<ArtType>> ART_TYPE = Keys.key(ResourceKey.sponge("art_type"), ArtType.class);

    /**
     * The attachment {@link AttachmentSurface} of a button or lever {@link BlockState}
     */
    public static final Key<Value<AttachmentSurface>> ATTACHMENT_SURFACE = Keys.key(ResourceKey.sponge("attachment_surface"), AttachmentSurface.class);

    /**
     * The damage dealt by an {@link ArrowEntity} on impact.
     */
    public static final Key<Value<Double>> ATTACK_DAMAGE = Keys.key(ResourceKey.sponge("attack_damage"), Double.class);

    /**
     * The time of a {@link Ravager} is considered attacking.
     */
    public static final Key<Value<Ticks>> ATTACK_TIME = Keys.key(ResourceKey.sponge("attack_time"), Ticks.class);

    /**
     * Remaining ticks of the auto spin attack a {@link Living} is doing.
     * @see #IS_AUTO_SPIN_ATTACK
     */
    public static final Key<Value<Ticks>> AUTO_SPIN_ATTACK_TICKS = Keys.key(ResourceKey.sponge("auto_spin_attack_ticks"), Ticks.class);

    /**
     * The author of a {@link ItemTypes#WRITTEN_BOOK} {@link ItemStack}.
     */
    public static final Key<Value<Component>> AUTHOR = Keys.key(ResourceKey.sponge("author"), Component.class);

    /**
     * The {@link Axis} direction of a {@link BlockState}.
     */
    public static final Key<Value<Axis>> AXIS = Keys.key(ResourceKey.sponge("axis"), Axis.class);

    /**
     * The ticks until a {@link Ageable} turns into an adult.
     */
    public static final Key<Value<Ticks>> BABY_TICKS = Keys.key(ResourceKey.sponge("baby_ticks"), Ticks.class);

    /**
     * The background music settings in a {@link Biome}
     * Readonly
     */
    public static final Key<Value<SoundConfig.BackgroundMusic>> BACKGROUND_MUSIC = Keys.key(ResourceKey.sponge("background_music"), SoundConfig.BackgroundMusic.class);

    /**
     * The {@link BannerPatternLayer}s of a {@link Banner}.
     */
    public static final Key<ListValue<BannerPatternLayer>> BANNER_PATTERN_LAYERS = Keys.listKey(ResourceKey.sponge("banner_pattern_layers"), BannerPatternLayer.class);

    /**
     * The width of the physical form of an {@link Entity}.
     *
     * <p>Together with {@link #HEIGHT} and {@link #SCALE} this defines
     * the size of an {@link Entity}.</p>
     * Readonly
     */
    public static final Key<Value<Double>> BASE_SIZE = Keys.key(ResourceKey.sponge("base_size"), Double.class);

    /**
     * The base vehicle a passenger is riding at the moment.
     * This may be different from {@link Keys#VEHICLE} as the
     * vehicle an {@link Entity} is riding may itself be the passenger of
     * another vehicle.
     * Readonly
     */
    public static final Key<Value<Entity>> BASE_VEHICLE = Keys.key(ResourceKey.sponge("base_vehicle"), Entity.class);

    /**
     * The target entity of a {@link Guardian} beam.
     */
    public static final Key<Value<Living>> BEAM_TARGET_ENTITY = Keys.key(ResourceKey.sponge("beam_target_entity"), Living.class);

    /**
     * Whether a {@link WorldType} allows using beds.
     * <p>When bed usage is not allowed beds will instead explode in a {@link ServerWorld world} of that type.</p>
     * <p>Also see {@link #RESPAWN_ANCHOR_USABLE}</p>
     * Readonly
     */
    public static final Key<Value<Boolean>> BEDS_USABLE = Keys.key(ResourceKey.sponge("beds_usable"), Boolean.class);

    /**
     * The {@link BillboardType} of a {@link DisplayEntity}.
     */
    public static final Key<Value<BillboardType>> BILLBOARD_TYPE = Keys.key(ResourceKey.sponge("billboard_type"), BillboardType.class);

    /**
     * The default temperature of a {@link Biome} or the biome at a specific {@link ServerLocation}.
     * For the exact block temperature see {@link #BLOCK_TEMPERATURE}.
     * Readonly
     */
    public static final Key<Value<Double>> BIOME_TEMPERATURE = Keys.key(ResourceKey.sponge("biome_temperature"), Double.class);

    /**
     * The blast resistance of a {@link BlockState}.
     * Readonly
     */
    public static final Key<Value<Double>> BLAST_RESISTANCE = Keys.key(ResourceKey.sponge("blast_resistance"), Double.class);

    /**
     * The amount of light that is emitted by the surrounding blocks at a block {@link ServerLocation}.
     * The value scales normally from 0 to 1.
     * <p>In vanilla minecraft is this value in steps of 1/15 from 0 to 1.</p>
     * <p>For the skylight see {@link #SKY_LIGHT}.</p>
     * Readonly
     * <p>
     * Or the blocklight override for a {@link DisplayEntity}.
     * </p>
     */
    public static final Key<Value<Integer>> BLOCK_LIGHT = Keys.key(ResourceKey.sponge("block_light"), Integer.class);

    /**
     * The {@link BlockState} of a {@link BlockOccupiedMinecart} or {@link FallingBlock}.
     */
    public static final Key<Value<BlockState>> BLOCK_STATE = Keys.key(ResourceKey.sponge("block_state"), BlockState.class);

    /**
     * The temperature at a specific {@link ServerLocation}.
     * For the default biome temperature see {@link #BIOME_TEMPERATURE}.
     * Readonly
     */
    public static final Key<Value<Double>> BLOCK_TEMPERATURE = Keys.key(ResourceKey.sponge("block_temperature"), Double.class);

    /**
     * The type of the boat.
     */
    public static final Key<Value<BoatType>> BOAT_TYPE = Keys.key(ResourceKey.sponge("boat_type"), BoatType.class);

    /**
     * The rotation of specific body parts of a {@link ArmorStand} or {@link Living}.
     *
     * <p>This value provides a mapping, effectively combining the data
     * referenced by {@link #HEAD_ROTATION}, {@link #CHEST_ROTATION},
     * {@link #RIGHT_ARM_ROTATION}, {@link #LEFT_ARM_ROTATION},
     * {@link #RIGHT_LEG_ROTATION}, and {@link #LEFT_LEG_ROTATION}.</p>
     */
    public static final Key<MapValue<BodyPart, Vector3d>> BODY_ROTATIONS = Keys.mapKey(ResourceKey.sponge("body_rotations"), BodyPart.class, Vector3d.class);

    /**
     * The {@link BossBar} displayed to the client by a {@link Boss}.
     * TODO Readonly but mutable?
     */
    public static final Key<Value<BossBar>> BOSS_BAR = Keys.key(ResourceKey.sponge("boss_bar"), BossBar.class);

    /**
     * The {@link BlockType}s able to be broken by an {@link ItemStack}.
     */
    public static final Key<SetValue<BlockType>> BREAKABLE_BLOCK_TYPES = Keys.setKey(ResourceKey.sponge("breakable_block_types"), BlockType.class);

    /**
     * The current breeder of an {@link Animal}, usually a {@link Player}s UUID.
     */
    public static final Key<Value<UUID>> BREEDER = Keys.key(ResourceKey.sponge("breeder"), UUID.class);

    /**
     * The ticks until an {@link Animal} can breed again. Also see {@link #CAN_BREED}.
     */
    public static final Key<Value<Ticks>> BREEDING_COOLDOWN = Keys.key(ResourceKey.sponge("breeding_cooldown"), Ticks.class);

    /**
     * The burntime of an {@link ItemStack} fuel in a furnace.
     * See {@link #FUEL} for the time
     * Readonly
     */
    public static final Key<Value<Integer>> BURN_TIME = Keys.key(ResourceKey.sponge("burn_time"), Integer.class);

    /**
     * Whether an {@link Animal} can breed.
     * In Vanilla, animals can breed if their {@link Keys#BREEDING_COOLDOWN} is equal to 0.
     */
    public static final Key<Value<Boolean>> CAN_BREED = Keys.key(ResourceKey.sponge("can_breed"), Boolean.class);

    /**
     * Whether a {@link FallingBlock} can drop as an item.
     */
    public static final Key<Value<Boolean>> CAN_DROP_AS_ITEM = Keys.key(ResourceKey.sponge("can_drop_as_item"), Boolean.class);

    /**
     * Whether a {@link Humanoid} can fly.
     *
     * <p>For a {@link Player} this means they are able to toggle flight mode
     * by double-tapping the jump button.</p>
     */
    public static final Key<Value<Boolean>> CAN_FLY = Keys.key(ResourceKey.sponge("can_fly"), Boolean.class);

    /**
     * Whether a {@link Living} entity may change blocks.
     * This mostly applies to {@link Enderman} or
     * {@link Creeper}s, but also to some projectiles like {@link FireballEntity}s or {@link WitherSkull}.
     */
    public static final Key<Value<Boolean>> CAN_GRIEF = Keys.key(ResourceKey.sponge("can_grief"), Boolean.class);

    /**
     * The set of harvestable {@link BlockType}s with an {@link ItemStack}. {@link #EFFICIENCY}
     * Readonly
     */
    public static final Key<SetValue<BlockType>> CAN_HARVEST = Keys.setKey(ResourceKey.sponge("can_harvest"), BlockType.class);

    /**
     * Whether a {@link FallingBlock} will damage an {@link Entity} it lands on.
     */
    public static final Key<Value<Boolean>> CAN_HURT_ENTITIES = Keys.key(ResourceKey.sponge("can_hurt_entities"), Boolean.class);

    /**
     * Whether a {@link Raider} can join a raid.
     */
    public static final Key<Value<Boolean>> CAN_JOIN_RAID = Keys.key(ResourceKey.sponge("can_join_raid"), Boolean.class);

    /**
     * Whether a {@link Boat} can move on land.
     */
    public static final Key<Value<Boolean>> CAN_MOVE_ON_LAND = Keys.key(ResourceKey.sponge("can_move_on_land"), Boolean.class);

    /**
     * Whether a {@link FallingBlock} will place itself upon landing.
     */
    public static final Key<Value<Boolean>> CAN_PLACE_AS_BLOCK = Keys.key(ResourceKey.sponge("can_place_as_block"), Boolean.class);

    /**
     * The number of candles within a candle block.
     */
    public static final Key<Value<Integer>> CANDLES = Keys.key(ResourceKey.sponge("candles"), Integer.class);

    /**
     * The carvers of a {@link Biome} used during world generation.
     * Readonly
     */
    public static final Key<MapValue<CarvingStep, List<Carver>>> CARVERS = Keys.mapKey(ResourceKey.sponge("carvers"), TypeToken.get(CarvingStep.class), new TypeToken<List<Carver>>() {});

    /**
     * The current casting time of a {@link Spellcaster}.
     */
    public static final Key<Value<Integer>> CASTING_TIME = Keys.key(ResourceKey.sponge("casting_time"), Integer.class);

    /**
     * The type of a {@link Cat}.
     */
    public static final Key<Value<CatType>> CAT_TYPE = Keys.key(ResourceKey.sponge("cat_type"), CatType.class);

    /**
     * Whether a {@link ServerPlayer} can will see colours sent in messages.
     */
    public static final Key<Value<Boolean>> CHAT_COLORS_ENABLED = Keys.key(ResourceKey.sponge("chat_colors_enabled"), Boolean.class);

    /**
     * The types of chat a {@link ServerPlayer} can see.
     */
    public static final Key<Value<ChatVisibility>> CHAT_VISIBILITY = Keys.key(ResourceKey.sponge("chat_visibility"), ChatVisibility.class);

    /**
     * The attachment of a {@link BlockTypes#CHEST} or {@link BlockTypes#TRAPPED_CHEST} {@link BlockState}.
     */
    public static final Key<Value<ChestAttachmentType>> CHEST_ATTACHMENT_TYPE = Keys.key(ResourceKey.sponge("chest_attachment_type"), ChestAttachmentType.class);

    /**
     * The rotation of the {@link BodyParts#CHEST}.
     */
    public static final Key<Value<Vector3d>> CHEST_ROTATION = Keys.key(ResourceKey.sponge("chest_rotation"), Vector3d.class);

    /**
     * The chunk generator of a {@link WorldTemplate}
     * Readonly
     */
    public static final Key<Value<ChunkGenerator>> CHUNK_GENERATOR = Keys.key(ResourceKey.sponge("chunk_generator"), ChunkGenerator.class);

    /**
     * The {@link Color} of an {@link ItemStack}
     * <p>
     *     e.g. {@link ItemTypes#LEATHER_CHESTPLATE} or {@link ItemTypes#POTION} custom color
     * </p>
     * or an {@link AreaEffectCloud}.
     */
    public static final Key<Value<Color>> COLOR = Keys.key(ResourceKey.sponge("color"), Color.class);

    /**
     * A command stored in a {@link CommandBlock} or {@link CommandBlockMinecart}.
     */
    public static final Key<Value<String>> COMMAND = Keys.key(ResourceKey.sponge("command"), String.class);

    /**
     * Whether commands can be run in a world of a {@link WorldTemplate} or {@link ServerWorldProperties}
     * Readonly
     */
    public static final Key<Value<Boolean>> COMMANDS = Keys.key(ResourceKey.sponge("commands"), Boolean.class);

    /**
     * The {@link ComparatorMode} of a {@link BlockTypes#COMPARATOR} {@link BlockState}.
     */
    public static final Key<Value<ComparatorMode>> COMPARATOR_MODE = Keys.key(ResourceKey.sponge("comparator_mode"), ComparatorMode.class);

    /**
     * The connected directions of a {@link BlockState}.
     * <p>
     *     e.g. {@link BlockTypes#GLASS_PANE}, {@link BlockTypes#IRON_BARS}, {@link BlockTypes#CHEST},
     * </p>
     */
    public static final Key<SetValue<Direction>> CONNECTED_DIRECTIONS = Keys.setKey(ResourceKey.sponge("connected_directions"), Direction.class);

    /**
     * The container {@link ItemType} of an {@link ItemStack}.
     * e.g. {@link ItemTypes#BUCKET} for a {@link ItemTypes#WATER_BUCKET} stack.
     * Readonly
     */
    public static final Key<Value<ItemType>> CONTAINER_ITEM = Keys.key(ResourceKey.sponge("container_item"), ItemType.class);

    /**
     * The amount of ticks a {@link Hopper} has to wait before transferring the next item. (in Vanilla this is 8 ticks)
     * or
     * The amount of ticks a {@link EndGateway} has to wait for the next teleportation.
     */
    public static final Key<Value<Ticks>> COOLDOWN = Keys.key(ResourceKey.sponge("cooldown"), Ticks.class);

    /**
     * The coordinate scale of a {@link WorldType} applied to the coordinates of a {@link ServerPlayer player}
     * when traveling in between {@link ServerWorld worlds}.
     * <p>
     * Best seen when transferring that player from one world to another (as the player's
     * coordinates will adjust to the scale of the destination world's).
     * </p>
     * Readonly
     */
    public static final Key<Value<Double>> COORDINATE_MULTIPLIER = Keys.key(ResourceKey.sponge("coordinate_multiplier"), Double.class);

    /**
     * Overrides whether a {@link WorldType} allows the {@link EnderDragon dragon} fight mechanic to spawn.
     * <p>By default, the dragon only spawns in the {@link DefaultWorldKeys#THE_END} world with {@link WorldTypes#THE_END} world type.</p>
     * Readonly
     */
    public static final Key<Value<Boolean>> CREATE_DRAGON_FIGHT = Keys.key(ResourceKey.sponge("create_dragon_fight"), Boolean.class);

    /**
     * The creator, usually of an {@link Entity}. It is up to the implementation to define.
     */
    public static final Key<Value<UUID>> CREATOR = Keys.key(ResourceKey.sponge("creator"), UUID.class);

    /**
     * The current {@link SpellType} a {@link Spellcaster} is casting.
     */
    public static final Key<Value<SpellType>> CURRENT_SPELL = Keys.key(ResourceKey.sponge("current_spell"), SpellType.class);

    /**
     * The damage dealt towards entities of a specific {@link EntityType} by a {@link ArrowEntity}.
     *
     * <p>Note that in events, the damage defined for the provided
     * {@link EntityType} will take priority over the "default" damage as
     * defined from {@link ArrowEntity#attackDamage()}.</p>
     *
     * <p>Types not present in this mapping will be
     * dealt damage to according to {@link #ATTACK_DAMAGE}.</p>
     */
    public static final Key<MapValue<EntityType<?>, Double>> CUSTOM_ATTACK_DAMAGE = Keys.mapKey(ResourceKey.sponge("custom_attack_damage"), new TypeToken<EntityType<?>>() {}, TypeToken.get(Double.class));

    /**
     * The resource pack model index of an {@link ItemStack}.
     *
     * <p>Resource packs can use the same index in their files to replace the
     * item model of an ItemStack.</p>
     */
    public static final Key<Value<Integer>> CUSTOM_MODEL_DATA = Keys.key(ResourceKey.sponge("custom_model_data"), Integer.class);

    /**
     * The custom name of an {@link Entity}, {@link ItemStack} or {@link BlockEntity}.
     * <p>If no custom name is set the dataholder may still have a {@link Keys#DISPLAY_NAME}</p>
     */
    public static final Key<Value<Component>> CUSTOM_NAME = Keys.key(ResourceKey.sponge("custom_name"), Component.class);

    /**
     * The damage absorbed by an armor {@link ItemStack}.
     * Readonly
     */
    public static final Key<Value<Double>> DAMAGE_ABSORPTION = Keys.key(ResourceKey.sponge("damage_absorption"), Double.class);

    /**
     * How much damage a {@link FallingBlock} deals to {@link Living} entities
     * it hits per block fallen.
     *
     * <p>This damage is capped by {@link #MAX_FALL_DAMAGE}.</p>
     */
    public static final Key<Value<Double>> DAMAGE_PER_BLOCK = Keys.key(ResourceKey.sponge("damage_per_block"), Double.class);

    /**
     * The distance at which a {@link BlockState} will decay.
     * This usually applies to leaves, for example {@link BlockTypes#OAK_LEAVES}.
     */
    public static final Key<Value<Integer>> DECAY_DISTANCE = Keys.key(ResourceKey.sponge("decay_distance"), Integer.class);

    /**
     * The modifier to {@link Keys#VELOCITY} of a {@link Minecart} while derailed.
     */
    public static final Key<Value<Vector3d>> DERAILED_VELOCITY_MODIFIER = Keys.key(ResourceKey.sponge("derailed_velocity_modifier"), Vector3d.class);

    /**
     * The despawn delay (in ticks) of a {@link Item}, {@link Endermite}, {@link WeatherType} {@link TraderLlama} or {@link EyeOfEnder}.
     */
    public static final Key<Value<Ticks>> DESPAWN_DELAY = Keys.key(ResourceKey.sponge("despawn_delay"), Ticks.class);

    /**
     * The destroy speed of a {@link BlockState}s {@link BlockType}.
     *
     * <p>This value is read-only.</p>
     */
    public static final Key<Value<Double>> DESTROY_SPEED = Keys.key(ResourceKey.sponge("destroy_speed"), Double.class);

    /**
     * The detonator of a {@link PrimedTNT}.
     */
    public static final Key<Value<Living>> DETONATOR = Keys.key(ResourceKey.sponge("detonator"), Living.class);

    /**
     * The {@link Direction} a {@link BlockState}, {@link Hanging}, or {@link Shulker} is facing or the
     * heading of a {@link ShulkerBullet}.
     */
    public static final Key<Value<Direction>> DIRECTION = Keys.key(ResourceKey.sponge("direction"), Direction.class);

    /**
     * The display name of an {@link Entity}, {@link ItemStack} or {@link BlockEntity}.
     *
     * <p>To change a display name set a {@link Keys#CUSTOM_NAME} instead.</p>
     * <p>On an {@link Entity}, this represents a combination of {@link Keys#CUSTOM_NAME} (if set), scoreboard info, and any click data.</p>
     * <p>On an {@link ItemStack}, this represents the {@link Keys#CUSTOM_NAME} or if not set the {@link ItemType}s translation.
     * <p>On a {@link BlockEntity}, this usually represents the name displayed in its {@link org.spongepowered.api.item.inventory.Container}
     * <p>On a {@link WorldTemplate} or {@link ServerWorldProperties}, this represents the display name of the corresponding {@link ServerWorld}</p>
     * <p>On a {@link TextDisplay} this is modifiable.</p>
     */
    public static final Key<Value<Component>> DISPLAY_NAME = Keys.key(ResourceKey.sponge("display_name"), Component.class);

    /**
     * The dominant {@link HandPreference} of an {@link Agent} entity.
     *
     * <p><em>NOTE:</em> For {@link Player}s is this key read-only, the
     * {@link HandPreference} of a player can not be changed server-side.</p>
     */
    public static final Key<Value<HandPreference>> DOMINANT_HAND = Keys.key(ResourceKey.sponge("dominant_hand"), HandPreference.class);

    /**
     * The {@link DoorHinge} of a door {@link BlockState}.
     */
    public static final Key<Value<DoorHinge>> DOOR_HINGE = Keys.key(ResourceKey.sponge("door_hinge"), DoorHinge.class);

    /**
     * Whether exact teleport location should be used with a {@link EndGateway}.
     */
    public static final Key<Value<Boolean>> DO_EXACT_TELEPORT = Keys.key(ResourceKey.sponge("do_exact_teleport"), Boolean.class);

    /**
     * The type of dripstone a certain {@link BlockTypes#DRIPSTONE_BLOCK} represents.
     */
    public static final Key<Value<DripstoneSegment>> DRIPSTONE_SEGMENT = Keys.key(ResourceKey.sponge("dripstone_segment"), DripstoneSegment.class);

    /**
     * The remaining duration (in ticks) of an {@link AreaEffectCloud}.
     */
    public static final Key<Value<Ticks>> DURATION = Keys.key(ResourceKey.sponge("duration"), Ticks.class);

    /**
     * The amount of ticks the duration of an {@link AreaEffectCloud}
     * is increased or reduced when it applies its effect.
     */
    public static final Key<Value<Ticks>> DURATION_ON_USE = Keys.key(ResourceKey.sponge("duration_on_use"), Ticks.class);

    /**
     * The color of a dyeable {@link BlockState}, {@link ItemStack} or entity like {@link Cat}s.
     * or
     * The base {@link DyeColor} of a {@link Banner} or {@link TropicalFish}.
     */
    public static final Key<Value<DyeColor>> DYE_COLOR = Keys.key(ResourceKey.sponge("dye_color"), DyeColor.class);

    /**
     * The time a {@link Panda} has been eating (in ticks)
     */
    public static final Key<Value<Ticks>> EATING_TIME = Keys.key(ResourceKey.sponge("eating_time"), Ticks.class);

    /**
     * The efficiency of an {@link ItemStack} tool. Affects mining speed of supported materials. {@link #CAN_HARVEST}
     * Readonly
     */
    public static final Key<Value<Double>> EFFICIENCY = Keys.key(ResourceKey.sponge("efficiency"), Double.class);

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
    public static final Key<Value<Ticks>> EGG_TIME = Keys.key(ResourceKey.sponge("egg_time"), Ticks.class);

    /**
     * The age (in ticks) of an {@link EndGateway}
     */
    public static final Key<Value<Ticks>> END_GATEWAY_AGE = Keys.key(ResourceKey.sponge("end_gateway_age"), Ticks.class);

    /**
     * The {@link EntityType entity type} of a spawn egg, which may be one of
     * several based on {@link ItemTypes#ZOMBIE_SPAWN_EGG}, etc. It is not
     * guaranteed that the type of entity is the same as the one that will be
     * spawned when used. It is likely unable to change the type of entity on
     * an {@link ItemStack}, but it is possible to change the
     * {@link EntityArchetype archetype} by using {@link #ENTITY_TO_SPAWN}.
     *
     * @see #ENTITY_TO_SPAWN
     */
    @SuppressWarnings("unchecked")
    public static final Key<Value<EntityType<?>>> ENTITY_TYPE = Keys.key(ResourceKey.sponge("entity_type"), (Class) EntityType.class);

    /**
     * The {@link EntityArchetype} to spawn from any spawn egg, such as a
     * {@link ItemTypes#ZOMBIE_SPAWN_EGG} or {@link ItemTypes#CREEPER_SPAWN_EGG}.
     * <p>The {@link #ENTITY_TYPE} is not guaranteed to be the same as the
     * {@link EntityArchetype#type()} returned, but the spawned entity will be
     * based on the {@link EntityArchetype} returned here.
     */
    public static final Key<Value<EntityArchetype>> ENTITY_TO_SPAWN = Keys.key(ResourceKey.sponge("entity_to_spawn"), EntityArchetype.class);

    /**
     * The {@link EquipmentType} that the target inventory supports. This usually applies to {@link EquipmentSlot}s.
     * or
     * The {@link EquipmentType} of an {@link ItemStack}
     * Readonly
     */
    public static final Key<Value<EquipmentType>> EQUIPMENT_TYPE = Keys.key(ResourceKey.sponge("equipment_type"), EquipmentType.class);

    /**
     * The current level of exhaustion of a {@link Humanoid}.
     *
     * <p>When the exhaustion level reaches 0, saturation is usually diminished
     * such that saturation is decreased and then exhaustion is reset to the
     * maximum. This type of effect occurs over time and can be modified by
     * movements and actions performed by the {@link Humanoid}.</p>
     */
    public static final Key<Value<Double>> EXHAUSTION = Keys.key(ResourceKey.sponge("exhaustion"), Double.class);

    /**
     * The amount of experience a {@link Player} has or an {@link ExperienceOrb} contains.
     */
    public static final Key<Value<Integer>> EXPERIENCE = Keys.key(ResourceKey.sponge("experience"), Integer.class);

    /**
     * The total experience a {@link Player} requires to advance from his current level to the next one.
     * Readonly
     */
    public static final Key<Value<Integer>> EXPERIENCE_FROM_START_OF_LEVEL = Keys.key(ResourceKey.sponge("experience_from_start_of_level"), Integer.class);

    /**
     * The current level a {@link Player} has.
     */
    public static final Key<Value<Integer>> EXPERIENCE_LEVEL = Keys.key(ResourceKey.sponge("experience_level"), Integer.class);

    /**
     * The amount of experience a {@link Player} has collected towards the next level.
     */
    public static final Key<Value<Integer>> EXPERIENCE_SINCE_LEVEL = Keys.key(ResourceKey.sponge("experience_since_level"), Integer.class);

    /**
     * The radius of the {@link Explosion} to be created by detonating an {@link Explosive}.
     *
     * <p>May be absent if the explosion radius is unknown because it is either
     * determined randomly at the time of the explosion or computed from the
     * context in which the {@link Explosive} explodes.</p>
     */
    public static final Key<Value<Integer>> EXPLOSION_RADIUS = Keys.key(ResourceKey.sponge("explosion_radius"), Integer.class);

    /**
     * The eye height of an {@link Entity}.
     * Readonly
     */
    public static final Key<Value<Double>> EYE_HEIGHT = Keys.key(ResourceKey.sponge("eye_height"), Double.class);

    /**
     * The eye position of an {@link Entity}.
     * Readonly
     */
    public static final Key<Value<Vector3d>> EYE_POSITION = Keys.key(ResourceKey.sponge("eye_position"), Vector3d.class);

    /**
     * The distance an {@link Entity} has fallen.
     */
    public static final Key<Value<Double>> FALL_DISTANCE = Keys.key(ResourceKey.sponge("fall_distance"), Double.class);

    /**
     * The amount of ticks a {@link FallingBlock} has been falling for.
     */
    public static final Key<Value<Ticks>> FALL_TIME = Keys.key(ResourceKey.sponge("fall_time"), Ticks.class);

    /**
     * The features to place during decoration steps during world generation for a {@link Biome}
     * Readonly
     */
    public static final Key<MapValue<DecorationStep, List<PlacedFeature>>> FEATURES = Keys.mapKey(ResourceKey.sponge("features"), TypeToken.get(DecorationStep.class), new TypeToken<List<PlacedFeature>>() {});

    /**
     * The {@link FireworkEffect}s of a
     * {@link ItemTypes#FIREWORK_STAR}, {@link ItemTypes#FIREWORK_ROCKET} {@link ItemStack} or a
     * {@link FireworkRocket}.
     */
    public static final Key<ListValue<FireworkEffect>> FIREWORK_EFFECTS = Keys.listKey(ResourceKey.sponge("firework_effects"), FireworkEffect.class);

    /**
     * The flight duration of a {@link FireworkRocket}
     *
     * <p>The duration is tiered and will stay partially random. A rocket will
     * fly for roughly {@code modifier * 10 + (random number from 0 to 13)}
     * ticks in Vanilla Minecraft.</p>
     */
    public static final Key<Value<Ticks>> FIREWORK_FLIGHT_MODIFIER = Keys.key(ResourceKey.sponge("firework_flight_modifier"), Ticks.class);

    public static final Key<Value<FireworkShape>> FIREWORK_SHAPE = Keys.key(ResourceKey.sponge("firework_shape"), FireworkShape.class);

    /**
     * The delay in ticks until the {@link Entity} will be damaged by the fire.
     */
    public static final Key<Value<Ticks>> FIRE_DAMAGE_DELAY = Keys.key(ResourceKey.sponge("fire_damage_delay"), Ticks.class);

    /**
     * The amount of ticks an {@link Entity} is still burning.
     */
    public static final Key<Value<Ticks>> FIRE_TICKS = Keys.key(ResourceKey.sponge("fire_ticks"), Ticks.class);

    /**
     * The time a {@link User} first joined on the Server.
     */
    public static final Key<Value<Instant>> FIRST_DATE_JOINED = Keys.key(ResourceKey.sponge("first_date_joined"), Instant.class);

    /**
     * A {@link Fox fox's} first trusted {@link UUID}, usually a {@link Player}.
     */
    public static final Key<Value<UUID>> FIRST_TRUSTED = Keys.key(ResourceKey.sponge("first_trusted"), UUID.class);

    /**
     * The fixed time in a {@link ServerWorld world} of a {@link WorldType}.
     * <p>If set the time is fixed at a particular {@link MinecraftDayTime} otherwise time flows freely.</p>
     * Readonly
     */
    public static final Key<Value<MinecraftDayTime>> FIXED_TIME = Keys.key(ResourceKey.sponge("fixed_time"), MinecraftDayTime.class);

    /**
     * The {@link FluidStackSnapshot} contained within an item container.
     * Item containers may include buckets and other mod added items.
     * See {@link #CONTAINER_ITEM}
     */
    public static final Key<Value<FluidStackSnapshot>> FLUID_ITEM_STACK = Keys.key(ResourceKey.sponge("fluid_item_stack"), FluidStackSnapshot.class);

    /**
     * The fluid level of a liquid {@link BlockState}.
     */
    public static final Key<Value<Integer>> FLUID_LEVEL = Keys.key(ResourceKey.sponge("fluid_level"), Integer.class);

    /**
     * The directional tank information.
     * TODO dataholder? cauldron blockstate? modded?
     */
    public static final Key<MapValue<Direction, List<FluidStackSnapshot>>> FLUID_TANK_CONTENTS = Keys.mapKey(ResourceKey.sponge("fluid_tank_contents"), TypeToken.get(Direction.class), new TypeToken<List<FluidStackSnapshot>>() {});

    /**
     * The speed at which an {@link Player} flies.
     */
    public static final Key<Value<Double>> FLYING_SPEED = Keys.key(ResourceKey.sponge("flying_speed"), Double.class);

    /**
     * The color of fog in a {@link Biome}.
     * Readonly
     */
    public static final Key<Value<Color>> FOG_COLOR = Keys.key(ResourceKey.sponge("fog_color"), Color.class);

    /**
     * The color override for foliage in a {@link Biome}.
     * <p>Such as {@link BlockTypes#OAK_LEAVES}, other leaves, {@link BlockTypes#VINE}</p>
     * <p>If not present foliage color is instead determined by {@link #BIOME_TEMPERATURE} and {@link #HUMIDITY}</p>
     * Readonly
     */
    public static final Key<Value<Color>> FOLIAGE_COLOR = Keys.key(ResourceKey.sponge("foliage_color"), Color.class);

    /**
     * The food level of a {@link Humanoid}.
     *
     * <p>For a {@link Humanoid}, food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the humanoid may heal. If the food level is at 0,
     * the humanoid may starve.</p>
     */
    public static final Key<Value<Integer>> FOOD_LEVEL = Keys.key(ResourceKey.sponge("food_level"), Integer.class);

    /**
     * The type of a {@link Fox}.
     */
    public static final Key<Value<FoxType>> FOX_TYPE = Keys.key(ResourceKey.sponge("fox_type"), FoxType.class);

    /**
     * Represents the {@link Key} for the amount of fuel left in a {@link BrewingStand} or {@link FurnaceBlockEntity} or {@link FurnaceMinecart}
     *
     * <p>One {@link ItemTypes#BLAZE_POWDER} adds 20 fuel to the brewing stand.</p>
     * <p>The fuel value corresponds with the number of batches of potions that can be brewed.</p>
     *
     * <p>See {@link #BURN_TIME} for the burn time added by a fuel {@link ItemStack} to a furnace</p>
     */
    public static final Key<Value<Integer>> FUEL = Keys.key(ResourceKey.sponge("fuel"), Integer.class);

    /**
     * The time (in ticks) a {@link FusedExplosive}'s fuse will burn before the explosion.
     */
    public static final Key<Value<Ticks>> FUSE_DURATION = Keys.key(ResourceKey.sponge("fuse_duration"), Ticks.class);

    /**
     * The {@link GameMode} a {@link Humanoid} or {@link ServerWorldProperties} or {@link WorldTemplate} has.
     */
    public static final Key<Value<GameMode>> GAME_MODE = Keys.key(ResourceKey.sponge("game_mode"), GameMode.class);

    /**
     * The player represented by a {@link BlockTypes#PLAYER_HEAD} (and {@link BlockTypes#PLAYER_WALL_HEAD})
     * {@link BlockState} or a {@link ItemTypes#PLAYER_HEAD} {@link ItemStack}.
     *
     * <p>The offered game profile will be set exactly, unlike in vanilla where the game profile will
     * be resolved automatically for properties (including textures). You can obtain a game profile with
     * properties using {@link org.spongepowered.api.profile.GameProfileManager#profile}.</p>
     */
    public static final Key<Value<GameProfile>> GAME_PROFILE = Keys.key(ResourceKey.sponge("game_profile"), GameProfile.class);

    /**
     * The generation of a {@link ItemTypes#WRITTEN_BOOK} {@link ItemStack}.
     * Depending on the book's generation it may be impossible to copy it.
     */
    public static final Key<Value<Integer>> GENERATION = Keys.key(ResourceKey.sponge("generation"), Integer.class);

    /**
     * The color override for grass in a {@link Biome}.
     * <p>Such as {@link BlockTypes#GRASS_BLOCK}, {@link BlockTypes#GRASS}, {@link BlockTypes#TALL_GRASS}, {@link BlockTypes#FERN}, {@link BlockTypes#LARGE_FERN}, {@link BlockTypes#SUGAR_CANE}</p>
     * <p>If not present grass color is instead determined by {@link #BIOME_TEMPERATURE} and {@link #HUMIDITY}</p>
     * Readonly
     */
    public static final Key<Value<Color>> GRASS_COLOR = Keys.key(ResourceKey.sponge("grass_color"), Color.class);

    /**
     * The grass color modifier in a {@link Biome}.
     * Readonly
     */
    public static final Key<Value<GrassColorModifier>> GRASS_COLOR_MODIFIER = Keys.key(ResourceKey.sponge("grass_color_modifier"), GrassColorModifier.class);

    /**
     * Whether a {@link org.spongepowered.api.block.entity.Sign.SignText} has glowing text (from dying
     * with {@link ItemTypes#GLOW_INK_SAC}). When using it on {@link Sign} this refers to the {@link #SIGN_FRONT_TEXT} only.
     */
    public static final Key<Value<Boolean>> GLOWING_TEXT = Keys.key(ResourceKey.sponge("glowing_text"), Boolean.class);

    /**
     * The "growth stage" state of a {@link BlockState}.
     * e.g. {@link BlockTypes#CACTUS} or {@link BlockTypes#WHEAT} etc.
     */
    public static final Key<Value<Integer>> GROWTH_STAGE = Keys.key(ResourceKey.sponge("growth_stage"), Integer.class);

    /**
     * Whether world of a {@link WorldTemplate} or {@link WorldProperties} is in hardcore mode.
     * Readonly
     */
    public static final Key<Value<Boolean>> HARDCORE = Keys.key(ResourceKey.sponge("hardcore"), Boolean.class);

    /**
     * Whether an {@link ArmorStand}'s arms are visible.
     */
    public static final Key<Value<Boolean>> HAS_ARMS = Keys.key(ResourceKey.sponge("has_arms"), Boolean.class);

    /**
     * Whether an {@link ArmorStand} has a visible base plate.
     */
    public static final Key<Value<Boolean>> HAS_BASE_PLATE = Keys.key(ResourceKey.sponge("has_base_plate"), Boolean.class);

    /**
     * Whether a {@link BlockTypes#CAVE_VINES} or
     * {@link BlockTypes#CAVE_VINES_PLANT} has glow berries.
     */
    public static final Key<Value<Boolean>> HAS_BERRIES = Keys.key(ResourceKey.sponge("has_berries"), Boolean.class);

    /**
     * Whether a {@link WorldType} generates a {@link ServerWorld world} with a ceiling at some
     * pre-determined y value composed of {@link BlockTypes#BEDROCK}. Most notable usage of
     * this is for the {@link WorldTypes#THE_NETHER type}.
     *
     * <p>In Vanilla, used in weather, map items, and respawning mechanics</p>
     * Readonly
     */
    public static final Key<Value<Boolean>> HAS_CEILING = Keys.key(ResourceKey.sponge("has_ceiling"), Boolean.class);

    /**
     * Whether a {@link PackHorse} has a chest.
     */
    public static final Key<Value<Boolean>> HAS_CHEST = Keys.key(ResourceKey.sponge("has_chest"), Boolean.class);

    /**
     * Whether the {@link TextDisplay} has a default background.
     */
    public static final Key<Value<Boolean>> HAS_DEFAULT_BACKGROUND = Keys.key(ResourceKey.sponge("has_default_background"), Boolean.class);

    /**
     *Whether a {@link Turtle} currently has an egg.
     */
    public static final Key<Value<Boolean>> HAS_EGG = Keys.key(ResourceKey.sponge("has_egg"), Boolean.class);

    /**
     * Whether a {@link Dolphin} has a fish.
     * <p>
     *     Dolphins will navigate to a treasure (if a structure that provides one is nearby)
     *     if they have been given a fish.
     * </p>
     */
    public static final Key<Value<Boolean>> HAS_FISH = Keys.key(ResourceKey.sponge("has_fish"), Boolean.class);

    /**
     * Whether an {@link ArmorStand} is a "marker" stand.
     *
     * <p>If {@code true}, the armor stand's bounding box is near
     * impossible to see, and the armor stand can no longer be
     * interacted with.</p>
     */
    public static final Key<Value<Boolean>> HAS_MARKER = Keys.key(ResourceKey.sponge("has_marker"), Boolean.class);

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#DOWN} direction. See {@link #PORES}.
     */
    public static final Key<Value<Boolean>> HAS_PORES_DOWN = Keys.key(ResourceKey.sponge("has_pores_down"), Boolean.class);

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#EAST} direction. See {@link #PORES}.
     */
    public static final Key<Value<Boolean>> HAS_PORES_EAST = Keys.key(ResourceKey.sponge("has_pores_east"), Boolean.class);

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#NORTH} direction. See {@link #PORES}.
     */
    public static final Key<Value<Boolean>> HAS_PORES_NORTH = Keys.key(ResourceKey.sponge("has_pores_north"), Boolean.class);

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#SOUTH} direction. See {@link #PORES}.
     */
    public static final Key<Value<Boolean>> HAS_PORES_SOUTH = Keys.key(ResourceKey.sponge("has_pores_south"), Boolean.class);

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#UP} direction. See {@link #PORES}.
     */
    public static final Key<Value<Boolean>> HAS_PORES_UP = Keys.key(ResourceKey.sponge("has_pores_up"), Boolean.class);

    /**
     * Whether a giant mushroom {@link BlockState} has pores on the {@link Direction#WEST} direction. See {@link #PORES}.
     */
    public static final Key<Value<Boolean>> HAS_PORES_WEST = Keys.key(ResourceKey.sponge("has_pores_west"), Boolean.class);

    /**
     * Whether a {@link WorldType} allows {@link Raid raids} to spawn.
     * <p>If true {@link ServerPlayer players} who have the {@link PotionEffectTypes#BAD_OMEN} effect
     * can cause a {@link Raid} while in a {@link ServerWorld world} of that type.</p>
     * Readonly
     */
    public static final Key<Value<Boolean>> HAS_RAIDS = Keys.key(ResourceKey.sponge("has_rais"), Boolean.class);

    /**
     * Whether the {@link ServerWorld world} of a {@link WorldType} will have global lighting, used
     * in game mechanics such as {@link Entity} spawning.
     * <p>In Vanilla, used in weather, lighting engine, and respawning mechanics</p>
     * Readonly
     */
    public static final Key<Value<Boolean>> HAS_SKYLIGHT = Keys.key(ResourceKey.sponge("has_skylight"), Boolean.class);

    /**
     * Whether the {@link TextDisplay} has a shadow.
     */
    public static final Key<Value<Boolean>> HAS_TEXT_SHADOW = Keys.key(ResourceKey.sponge("has_text_shadow"), Boolean.class);

    /**
     * Whether a server player has viewed the credits.
     *
     * <p>The credits are displayed the first time a player returns to the overworld safely using an end portal.</p>
     */
    public static final Key<Value<Boolean>> HAS_VIEWED_CREDITS = Keys.key(ResourceKey.sponge("has_viewed_credits"), Boolean.class);

    /**
     * The rotation of a {@link Living}'s or {@link ArmorStand}'s head.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul>
     *     <li>{@code x -> pitch}</li>
     * <li> {@code y -> yaw}</li>
     * <li>{@code z -> roll}</li>
     * </ul>
     *
     * <p>Note that the pitch will be the same x value returned by
     * {@link Entity#rotation()} and Minecraft does not currently support
     * head roll so the z value will always be zero.</p>
     */
    public static final Key<Value<Vector3d>> HEAD_ROTATION = Keys.key(ResourceKey.sponge("head_rotation"), Vector3d.class);

    /**
     * The {@link EndCrystal} currently healing an {@link EnderDragon}.
     */
    public static final Key<Value<EndCrystal>> HEALING_CRYSTAL = Keys.key(ResourceKey.sponge("healing_crystal"), EndCrystal.class);

    /**
     * A {@link Living}'s or {@link EndCrystal}'s current health.
     *
     * <p>The range of the health depends on the object on which this
     * method is defined. For {@link Player Players} in Minecraft, the nominal range is
     * between 0 and 20, inclusive, but the range can be adjusted.</p>
     *
     * <p>Convention dictates that health does not fall below 0 but this
     * convention may be broken.</p>
     */
    public static final Key<Value<Double>> HEALTH = Keys.key(ResourceKey.sponge("health"), Double.class);

    /**
     * The value a {@link ServerPlayer}s max-health (excluding absorption) in the GUI will scale to.
     * <p>Two health is equal to one heart displayed.</p>
     * <p>With scaling is disabled health automatically scales to {@link #MAX_HEALTH}</p>
     */
    public static final Key<Value<Double>> HEALTH_SCALE = Keys.key(ResourceKey.sponge("health_scale"), Double.class);

    /**
     * The height of the physical form of an {@link Entity}.
     *
     * <p>Together with {@link #BASE_SIZE} and {@link #SCALE} this defines the size of an
     * {@link Entity}.</p>
     * Readonly
     */
    public static final Key<Value<Double>> HEIGHT = Keys.key(ResourceKey.sponge("height"), Double.class);

    /**
     * The {@link ItemType} a {@link BlockState} represents.
     * Readonly
     */
    public static final Key<Value<ItemType>> HELD_ITEM = Keys.key(ResourceKey.sponge("held_item"), ItemType.class);

    /**
     * The hidden {@link PandaGene gene} of a {@link Panda}.
     */
    public static final Key<Value<PandaGene>> HIDDEN_GENE = Keys.key(ResourceKey.sponge("hidden_gene"), PandaGene.class);

    /**
     * Whether the attributes of an {@link ItemStack} are hidden.
     */
    public static final Key<Value<Boolean>> HIDE_ATTRIBUTES = Keys.key(ResourceKey.sponge("hide_attributes"), Boolean.class);

    /**
     * Whether the {@link #BREAKABLE_BLOCK_TYPES} of an {@link ItemStack} are hidden.
     */
    public static final Key<Value<Boolean>> HIDE_CAN_DESTROY = Keys.key(ResourceKey.sponge("hide_can_destroy"), Boolean.class);

    /**
     * Whether the {@link #PLACEABLE_BLOCK_TYPES} of an {@link ItemStack} are hidden.
     */
    public static final Key<Value<Boolean>> HIDE_CAN_PLACE = Keys.key(ResourceKey.sponge("hide_can_place"), Boolean.class);

    /**
     * Whether the {@link #APPLIED_ENCHANTMENTS} of an {@link ItemStack} are hidden.
     */
    public static final Key<Value<Boolean>> HIDE_ENCHANTMENTS = Keys.key(ResourceKey.sponge("hide_enchantments"), Boolean.class);

    /**
     * Whether miscellaneous values of an {@link ItemStack} are hidden.
     * e.g. potion effects or shield pattern info
     */
    public static final Key<Value<Boolean>> HIDE_MISCELLANEOUS = Keys.key(ResourceKey.sponge("hide_miscellaneous"), Boolean.class);

    /**
     * Whether {@link #IS_UNBREAKABLE} state of an {@link ItemStack} is hidden.
     */
    public static final Key<Value<Boolean>> HIDE_UNBREAKABLE = Keys.key(ResourceKey.sponge("hide_unbreakable"), Boolean.class);

    /**
     * The {@link Vector3i position} where a {@link Turtle} lays {@link BlockTypes#TURTLE_EGG eggs}.
     */
    public static final Key<Value<Vector3i>> HOME_POSITION = Keys.key(ResourceKey.sponge("home_position"), Vector3i.class);

    /**
     * The {@link HorseColor} of a {@link Horse}.
     */
    public static final Key<Value<HorseColor>> HORSE_COLOR = Keys.key(ResourceKey.sponge("horse_color"), HorseColor.class);

    /**
     * The {@link HorseStyle} of a {@link Horse}.
     */
    public static final Key<Value<HorseStyle>> HORSE_STYLE = Keys.key(ResourceKey.sponge("horse_style"), HorseStyle.class);

    /**
     * The humidity of a {@link Biome}.
     * Readonly
     */
    public static final Key<Value<Double>> HUMIDITY = Keys.key(ResourceKey.sponge("humidity"), Double.class);

    /**
     * The inaccuracy of an {@link ItemStack} that launches {@link Projectile}s.
     *
     * <p>An inaccuracy of 0 means perfect accuracy. Inaccuracy of 1 is the default for most vanilla items.</p>
     */
    public static final Key<Value<Double>> INACCURACY = Keys.key(ResourceKey.sponge("inaccuracy"), Double.class);

    /**
     * The tag to determine which {@link BlockType blocks} burn infinitely in a {@link ServerWorld world} of a {@link WorldType}.
     * Readonly
     */
    public static final Key<Value<Tag<BlockType>>> INFINIBURN = Keys.key(ResourceKey.sponge("infiniburn"), new TypeToken<Tag<BlockType>>() {});

    /**
     * Whether an {@link Item} will not despawn for an infinite time.
     */
    public static final Key<Value<Boolean>> INFINITE_DESPAWN_DELAY = Keys.key(ResourceKey.sponge("infinite_despawn_delay"), Boolean.class);

    /**
     * Whether an {@link Item} has an infinite pickup delay.
     */
    public static final Key<Value<Boolean>> INFINITE_PICKUP_DELAY = Keys.key(ResourceKey.sponge("infinite_pickup_delay"), Boolean.class);

    /**
     * Whether a world of a {@link ServerWorldProperties} was initialized.
     */
    public static final Key<Value<Boolean>> INITIALIZED = Keys.key(ResourceKey.sponge("initialized"), Boolean.class);

    /**
     * The {@link InstrumentType} of a {@link BlockTypes#NOTE_BLOCK} {@link BlockState}.
     */
    public static final Key<Value<InstrumentType>> INSTRUMENT_TYPE = Keys.key(ResourceKey.sponge("instrument_type"), InstrumentType.class);

    /**
     * The interpolation delay of a {@link DisplayEntity}
     */
    public static final Key<Value<Ticks>> INTERPOLATION_DELAY = Keys.key(ResourceKey.sponge("interpolation_delay"), Ticks.class);

    /**
     * The interpolation duration of a {@link DisplayEntity}
     */
    public static final Key<Value<Ticks>> INTERPOLATION_DURATION = Keys.key(ResourceKey.sponge("interpolation_duration"), Ticks.class);

    /**
     * Whether a {@link BlockTypes#DAYLIGHT_DETECTOR} {@link BlockState} is inverted.
     */
    public static final Key<Value<Boolean>> INVERTED = Keys.key(ResourceKey.sponge("inverted"), Boolean.class);

    /**
     * The amount of ticks an {@link Entity} will remain invulnerable for.
     */
    public static final Key<Value<Ticks>> INVULNERABILITY_TICKS = Keys.key(ResourceKey.sponge("invulnerability_ticks"), Ticks.class);

    /**
     * Whether an {@link Entity} is invulnerable.
     *
     * <p>This does not protect from the void, players in creative mode,
     * and manual killing like the /kill command.</p>
     */
    public static final Key<Value<Boolean>> INVULNERABLE = Keys.key(ResourceKey.sponge("invulnerable"), Boolean.class);

    /**
     * Whether a fence gate {@link BlockState} is in a wall.
     */
    public static final Key<Value<Boolean>> IN_WALL = Keys.key(ResourceKey.sponge("in_wall"), Boolean.class);

    /**
     * Whether an {@link Ageable} is considered an adult.
     */
    public static final Key<Value<Boolean>> IS_ADULT = Keys.key(ResourceKey.sponge("is_adult"), Boolean.class);

    /**
     * Whether a {@link Blaze} is currently burning.
     *
     * <p>Unlike {@link Keys#FIRE_TICKS}, the burning effect will not damage
     * the burning entity.</p>
     */
    public static final Key<Value<Boolean>> IS_AFLAME = Keys.key(ResourceKey.sponge("is_aflame"), Boolean.class);

    /**
     * Whether an {@link Agent}s AI is enabled.
     */
    public static final Key<Value<Boolean>> IS_AI_ENABLED = Keys.key(ResourceKey.sponge("is_ai_enabled"), Boolean.class);

    /**
     * Whether an entity is currently aggressive.
     * e.g. {@link Wolf wolves} or {@link ZombifiedPiglin}
     */
    public static final Key<Value<Boolean>> IS_ANGRY = Keys.key(ResourceKey.sponge("is_angry"), Boolean.class);

    /**
     * Whether a {@link BlockState} is "attached" to another block.
     */
    public static final Key<Value<Boolean>> IS_ATTACHED = Keys.key(ResourceKey.sponge("is_attached"), Boolean.class);

    /**
     * Whether a {@link Living} is doing an auto spin attack (doable with the {@link EnchantmentTypes#RIPTIDE} enchantment.)
     * @see #AUTO_SPIN_ATTACK_TICKS
     */
    public static final Key<Value<Boolean>> IS_AUTO_SPIN_ATTACK = Keys.key(ResourceKey.sponge("is_auto_spin_attack"), Boolean.class);

    /**
     * Whether an entity is begging for food.
     * e.g. {@link Cat cats} or tamed {@link Wolf wolves}
     */
    public static final Key<Value<Boolean>> IS_BEGGING_FOR_FOOD = Keys.key(ResourceKey.sponge("is_begging_for_food"), Boolean.class);

    /**
     * Whether {@link Raider}s are currently celebrating.
     */
    public static final Key<Value<Boolean>> IS_CELEBRATING = Keys.key(ResourceKey.sponge("is_celebrating"), Boolean.class);

    /**
     * Whether a {@link Creeper} is charged.
     */
    public static final Key<Value<Boolean>> IS_CHARGED = Keys.key(ResourceKey.sponge("is_charged"), Boolean.class);

    /**
     * Whether a {@link Pillager} is charging it's crossbow.
     */
    public static final Key<Value<Boolean>> IS_CHARGING_CROSSBOW = Keys.key(ResourceKey.sponge("is_charging_crossbow"), Boolean.class);

    /**
     * Whether a {@link Spider} is currently climbing.
     */
    public static final Key<Value<Boolean>> IS_CLIMBING = Keys.key(ResourceKey.sponge("is_climbing"), Boolean.class);

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#EAST}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Key<Value<Boolean>> IS_CONNECTED_EAST = Keys.key(ResourceKey.sponge("is_connected_east"), Boolean.class);

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#NORTH}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Key<Value<Boolean>> IS_CONNECTED_NORTH = Keys.key(ResourceKey.sponge("is_connected_north"), Boolean.class);

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#SOUTH}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Key<Value<Boolean>> IS_CONNECTED_SOUTH = Keys.key(ResourceKey.sponge("is_connected_south"), Boolean.class);

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#UP}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Key<Value<Boolean>> IS_CONNECTED_UP = Keys.key(ResourceKey.sponge("is_connected_up"), Boolean.class);

    /**
     * Whether a {@link BlockState} is connected to the {@link Direction#WEST}.
     * Also see {@link #CONNECTED_DIRECTIONS}.
     */
    public static final Key<Value<Boolean>> IS_CONNECTED_WEST = Keys.key(ResourceKey.sponge("is_connected_west"), Boolean.class);

    /**
     * Whether an {@link Arrow} will cause a critical hit.
     */
    public static final Key<Value<Boolean>> IS_CRITICAL_HIT = Keys.key(ResourceKey.sponge("is_critical_hit"), Boolean.class);

    /**
     * Whether a {@link Fox} is currently crouching.
     */
    public static final Key<Value<Boolean>> IS_CROUCHING = Keys.key(ResourceKey.sponge("is_crouching"), Boolean.class);

    /**
     * Whether a custom name is visible on an {@link Entity}.
     */
    public static final Key<Value<Boolean>> IS_CUSTOM_NAME_VISIBLE = Keys.key(ResourceKey.sponge("is_custom_name_visible"), Boolean.class);

    /**
     * Whether a {@link Fox} is currently defending.
     */
    public static final Key<Value<Boolean>> IS_DEFENDING = Keys.key(ResourceKey.sponge("is_defending"), Boolean.class);

    /**
     * Whether a {@link BlockState} is disarmed.
     * e.g. {@link BlockTypes#TRIPWIRE}s and {@link BlockTypes#TRIPWIRE_HOOK}s.
     */
    public static final Key<Value<Boolean>> IS_DISARMED = Keys.key(ResourceKey.sponge("is_disarmed"), Boolean.class);

    /**
     * Whether an entity is eating.
     * e.g. {@link Panda}
     */
    public static final Key<Value<Boolean>> IS_EATING = Keys.key(ResourceKey.sponge("is_eating"), Boolean.class);

    /**
     * Whether a {@link WeatherEffect} like {@link LightningBolt} is harmful to other {@link Entity entities}.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_EFFECT_ONLY = Keys.key(ResourceKey.sponge("is_effect_only"), Boolean.class);

    /**
     * Whether a {@link Player} is flying with an {@link ItemTypes#ELYTRA}.
     */
    public static final Key<Value<Boolean>> IS_ELYTRA_FLYING = Keys.key(ResourceKey.sponge("is_elytra_flying"), Boolean.class);

    /**
     * Whether a piston {@link BlockState} is currently extended.
     * TODO {@link Piston}?
     */
    public static final Key<Value<Boolean>> IS_EXTENDED = Keys.key(ResourceKey.sponge("is_extended"), Boolean.class);

    /**
     * Whether a {@link Fox} is currently faceplanted.
     */
    public static final Key<Value<Boolean>> IS_FACEPLANTED = Keys.key(ResourceKey.sponge("is_faceplanted"), Boolean.class);

    /**
     * Whether a {@link BlockState} is filled.
     * <p>e.g. {@link BlockTypes#END_PORTAL_FRAME}s.</p>
     */
    public static final Key<Value<Boolean>> IS_FILLED = Keys.key(ResourceKey.sponge("is_filled"), Boolean.class);

    /**
     * Whether a {@link BlockState} is flammable.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_FLAMMABLE = Keys.key(ResourceKey.sponge("is_flammable"), Boolean.class);

    /**
     * Whether an {@link Entity} is flying. TODO only player?
     *
     * <p>This key only tells whether an entity is flying at the moment. On a
     * {@link Player} it does not necessarily mean that the player may toggle
     * freely between flying and walking. To check whether a player may switch
     * his flying state, check {@link #CAN_FLY}.</p>
     */
    public static final Key<Value<Boolean>> IS_FLYING = Keys.key(ResourceKey.sponge("is_flying"), Boolean.class);

    /**
     * Whether an entity is frightened.
     *
     * <p>In vanilla, {@link Panda}s that have a {@link Panda#knownGene()}
     * of {@link PandaGenes#WORRIED} and are in a {@link ServerWorld world} whose {@link WeatherType} is currently a
     * {@link WeatherTypes#THUNDER} are considered "frightened".</p>
     */
    public static final Key<Value<Boolean>> IS_FRIGHTENED = Keys.key(ResourceKey.sponge("is_frightened"), Boolean.class);

    /**
     * Whether the block at the {@link ServerLocation} is a full block.
     */
    public static final Key<Value<Boolean>> IS_FULL_BLOCK = Keys.key(ResourceKey.sponge("is_full_block"), Boolean.class);

    /**
     * Whether an {@link Entity} has a glowing outline.
     */
    public static final Key<Value<Boolean>> IS_GLOWING = Keys.key(ResourceKey.sponge("is_glowing"), Boolean.class);

    /**
     * Whether {@link Turtle} is proceeding to it's {@link Vector3i home position}.
     */
    public static final Key<Value<Boolean>> IS_GOING_HOME = Keys.key(ResourceKey.sponge("is_going_home"), Boolean.class);

    /**
     * Whether something is affected by gravity.
     * e.g. {@link Entity}s and {@link BlockState}s
     * Readonly(BlockState.class)
     */
    public static final Key<Value<Boolean>> IS_GRAVITY_AFFECTED = Keys.key(ResourceKey.sponge("is_gravity_affected"), Boolean.class);

    /**
     * Whether a lantern block is hanging.
     */
    public static final Key<Value<Boolean>> IS_HANGING = Keys.key(ResourceKey.sponge("is_hanging"), Boolean.class);

    /**
     * Whether a {@link Cat} is hissing.
     */
    public static final Key<Value<Boolean>> IS_HISSING = Keys.key(ResourceKey.sponge("is_hissing"), Boolean.class);

    /**
     * Whether a {@link Ravager} is immobilized.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_IMMOBILIZED = Keys.key(ResourceKey.sponge("is_immobilized"), Boolean.class);

    /**
     * Whether a {@link ServerLocation} is indirectly powered.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_INDIRECTLY_POWERED = Keys.key(ResourceKey.sponge("is_indirectly_powered"), Boolean.class);

    /**
     * Whether a {@link Fox} is currently interested in something.
     */
    public static final Key<Value<Boolean>> IS_INTERESTED = Keys.key(ResourceKey.sponge("is_interested"), Boolean.class);

    /**
     * Whether an {@link Entity} is currently invisible.
     * This will only simply render the entity as vanished,
     * but not prevent any entity updates being sent to clients.
     * To fully "vanish" an {@link Entity}, use {@link #VANISH_STATE}.
     */
    public static final Key<Value<Boolean>> IS_INVISIBLE = Keys.key(ResourceKey.sponge("is_invisible"), Boolean.class);

    /**
     * Whether a {@link Boat} is currently in {@link BlockTypes#WATER}.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_IN_WATER = Keys.key(ResourceKey.sponge("is_in_water"), Boolean.class);

    /**
     * Whether a {@link Vindicator} is exhibiting "johnny" behavior.
     *
     * @see <a href="https://minecraft.gamepedia.com/Vindicator#Behavior">
     * The Minecraft Wiki for more information about "johnny" behavior</a>
     */
    public static final Key<Value<Boolean>> IS_JOHNNY = Keys.key(ResourceKey.sponge("is_johnny"), Boolean.class);

    /**
     * Whether a {@link Turtle} is currently digging to lay an egg.
     */
    public static final Key<Value<Boolean>> IS_LAYING_EGG = Keys.key(ResourceKey.sponge("is_laying_egg"), Boolean.class);

    /**
     * Whether a {@link Patroller} is the leader.
     */
    public static final Key<Value<Boolean>> IS_LEADER = Keys.key(ResourceKey.sponge("is_leader"), Boolean.class);

    /**
     * Whether a {@link BlockState} is lit.
     * e.g. {@link BlockTypes#FURNACE}, {@link BlockTypes#CAMPFIRE}
     * or {@link BlockTypes#REDSTONE_TORCH}.
     */
    public static final Key<Value<Boolean>> IS_LIT = Keys.key(ResourceKey.sponge("is_lit"), Boolean.class);

    /**
     * Whether a world of a {@link WorldTemplate} or {@link ServerWorldProperties} is supposed to be loaded at startup.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_LOAD_ON_STARTUP = Keys.key(ResourceKey.sponge("is_load_on_startup"), Boolean.class);

    /**
     * Whether a {@link Cat} is lying down.
     *
     * <p>In vanilla, a cat lies down near its owner when the owner goes to
     * sleep.</p>
     */
    public static final Key<Value<Boolean>> IS_LYING_DOWN = Keys.key(ResourceKey.sponge("is_lying_down"), Boolean.class);

    /**
     * Whether a {@link Panda} is lying on it's back.
     */
    public static final Key<Value<Boolean>> IS_LYING_ON_BACK = Keys.key(ResourceKey.sponge("is_lying_on_back"), Boolean.class);

    /**
     * Whether a bed {@link BlockState} is occupied.
     * e.g. {@link BlockTypes#WHITE_BED}.
     */
    public static final Key<Value<Boolean>> IS_OCCUPIED = Keys.key(ResourceKey.sponge("is_occupied"), Boolean.class);

    /**
     * Whether a {@link Minecart} is on it's rail
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_ON_RAIL = Keys.key(ResourceKey.sponge("is_on_rail"), Boolean.class);

    /**
     * Whether a door/fencegate/trapdoor {@link BlockState} is open.
     */
    public static final Key<Value<Boolean>> IS_OPEN = Keys.key(ResourceKey.sponge("is_open"), Boolean.class);

    /**
     * Whether a {@link BlockState} is passable (can be walked through).
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_PASSABLE = Keys.key(ResourceKey.sponge("is_passable"), Boolean.class);

    /**
     * Whether a {@link Patroller} is currently patrolling.
     */
    public static final Key<Value<Boolean>> IS_PATROLLING = Keys.key(ResourceKey.sponge("is_patrolling"), Boolean.class);

    /**
     * Whether an {@link Entity} or leaves {@link BlockState} will
     * be prevented from despawning/decaying.
     *
     * <p>In Vanilla, entities may despawn if the player moves too far from
     * them. A persisting entity will not be removed due to no players being
     * near it.</p>
     */
    public static final Key<Value<Boolean>> IS_PERSISTENT = Keys.key(ResourceKey.sponge("is_persistent"), Boolean.class);

    /**
     * Whether players are prevented from placing
     * items from an equipment slot on an {@link ArmorStand}
     */
    public static final Key<MapValue<EquipmentType, Boolean>> IS_PLACING_DISABLED = Keys.mapKey(ResourceKey.sponge("is_placing_disabled"), EquipmentType.class, Boolean.class);

    /**
     * Whether a {@link IronGolem} has been created by a {@link Player}.
     */
    public static final Key<Value<Boolean>> IS_PLAYER_CREATED = Keys.key(ResourceKey.sponge("is_player_created"), Boolean.class);

    /**
     * Whether a {@link Fox} is currently pouncing.
     */
    public static final Key<Value<Boolean>> IS_POUNCING = Keys.key(ResourceKey.sponge("is_pouncing"), Boolean.class);

    /**
     * Whether a {@link BlockState} is powered.
     *
     * <p>Applies to blocks that may be powered in order to emit a
     * Redstone signal of consistently maximum strength, such as
     * {@link BlockTypes#LEVER}, {@link BlockTypes#OAK_BUTTON},
     * {@link BlockTypes#OAK_PRESSURE_PLATE}, and their stone
     * counterparts.</p>
     */
    public static final Key<Value<Boolean>> IS_POWERED = Keys.key(ResourceKey.sponge("is_powered"), Boolean.class);

    /**
     * Whether a {@link FusedExplosive} is currently primed.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_PRIMED = Keys.key(ResourceKey.sponge("is_primed"), Boolean.class);

    /**
     * Whether a {@link Cat} is purring.
     */
    public static final Key<Value<Boolean>> IS_PURRING = Keys.key(ResourceKey.sponge("is_purring"), Boolean.class);

    /**
     * Whether a {@link Cat} is relaxed.
     *
     * <p>In vanilla, a cat relaxes before lying down.</p>
     */
    public static final Key<Value<Boolean>> IS_RELAXED = Keys.key(ResourceKey.sponge("is_relaxed"), Boolean.class);

    /**
     * Whether a {@link BlockState} can be replaced by a player without breaking it first.
     * e.g. {@link BlockTypes#WATER}
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_REPLACEABLE = Keys.key(ResourceKey.sponge("is_replaceable"), Boolean.class);

    /**
     * Whether a {@link Ravager} is roaring.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_ROARING = Keys.key(ResourceKey.sponge("is_roaring"), Boolean.class);

    /**
     * Whether a {@link Panda} is rolling around.
     */
    public static final Key<Value<Boolean>> IS_ROLLING_AROUND = Keys.key(ResourceKey.sponge("is_rolling_around"), Boolean.class);

    /**
     * Whether an entity is saddled.
     * e.g. {@link Horse}s and {@link Pig}s
     */
    public static final Key<Value<Boolean>> IS_SADDLED = Keys.key(ResourceKey.sponge("is_saddled"), Boolean.class);

    /**
     * Whether an {@link Enderman} is screaming.
     */
    public static final Key<Value<Boolean>> IS_SCREAMING = Keys.key(ResourceKey.sponge("is_screaming"), Boolean.class);

    /**
     * Whether a {@link Sheep} is sheared.
     */
    public static final Key<Value<Boolean>> IS_SHEARED = Keys.key(ResourceKey.sponge("is_sheared"), Boolean.class);

    /**
     * Whether an {@link Entity} is silent.
     *
     * <p>A silent entity will not emit sounds or make noises.</p>
     */
    public static final Key<Value<Boolean>> IS_SILENT = Keys.key(ResourceKey.sponge("is_silent"), Boolean.class);

    /**
     * Whether a {@link Wolf}, {@link Cat}, {@link Panda}, or {@link Fox} is sitting.
     */
    public static final Key<Value<Boolean>> IS_SITTING = Keys.key(ResourceKey.sponge("is_sitting"), Boolean.class);

    /**
     * Whether a {@link Bat}, {@link Fox} or {@link Player} is sleeping.
     *
     * <p>If a player is considered sleeping as per this data value, the player does
     * not need to be in bed in order for the other players to be able to
     * advance through the night by going to bed.</p>
     * Readonly(Player.class)
     */
    public static final Key<Value<Boolean>> IS_SLEEPING = Keys.key(ResourceKey.sponge("is_sleeping"), Boolean.class);

    /**
     * Whether a {@link Player Player's} sleeping status is ignored when checking whether to
     * skip the night due to players sleeping. The time in a world will be
     * advanced to day if all players in it either are sleeping or are set to ignore.
     */
    public static final Key<Value<Boolean>> IS_SLEEPING_IGNORED = Keys.key(ResourceKey.sponge("is_sleeping_ignored"), Boolean.class);

    /**
     * Whether an {@link ArmorStand} is small.
     */
    public static final Key<Value<Boolean>> IS_SMALL = Keys.key(ResourceKey.sponge("is_small"), Boolean.class);

    /**
     * Whether an {@link Entity} is sneaking.
     *
     * <p>Sneaking entities generally move slower and do not make walking
     * sounds.</p>
     */
    public static final Key<Value<Boolean>> IS_SNEAKING = Keys.key(ResourceKey.sponge("is_sneaking"), Boolean.class);

    /**
     * Whether a {@link Panda} is sneezing.
     */
    public static final Key<Value<Boolean>> IS_SNEEZING = Keys.key(ResourceKey.sponge("is_sneezing"), Boolean.class);

    /**
     * Whether a {@link BlockTypes#DIRT} {@link BlockState} is snowy.
     */
    public static final Key<Value<Boolean>> IS_SNOWY = Keys.key(ResourceKey.sponge("is_snowy"), Boolean.class);

    /**
     * Whether a {@link BlockState} is solid.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_SOLID = Keys.key(ResourceKey.sponge("is_solid"), Boolean.class);

    /**
     * Whether an {@link Entity} is sprinting.
     */
    public static final Key<Value<Boolean>> IS_SPRINTING = Keys.key(ResourceKey.sponge("is_sprinting"), Boolean.class);

    /**
     * Whether a {@link PolarBear} is currently standing.
     */
    public static final Key<Value<Boolean>> IS_STANDING = Keys.key(ResourceKey.sponge("is_standing"), Boolean.class);

    /**
     * Whether a {@link Ravager} is stunned.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_STUNNED = Keys.key(ResourceKey.sponge("is_stunned"), Boolean.class);

    /**
     * Whether a {@link BlockState} is a surrogate block for a block that was provided in an environment
     * (almost always modded), that the block type provider no longer exists.
     * If true this may indicate that the surrogate block functions differently than the original block.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_SURROGATE_BLOCK = Keys.key(ResourceKey.sponge("is_surrogate_block"), Boolean.class);

    /**
     * Whether players are prevented from taking
     * items from an equipment slot on an {@link ArmorStand}
     */
    public static final Key<MapValue<EquipmentType, Boolean>> IS_TAKING_DISABLED = Keys.mapKey(ResourceKey.sponge("is_taking_disabled"), EquipmentType.class, Boolean.class);

    /**
     * Whether a {@link TameableAnimal} is currently tamed
     */
    public static final Key<Value<Boolean>> IS_TAMED = Keys.key(ResourceKey.sponge("is_tamed"), Boolean.class);

    /**
     * Whether a {@link Trader} is currently trading with a {@link Player}.
     * Readonly
     */
    public static final Key<Value<Boolean>> IS_TRADING = Keys.key(ResourceKey.sponge("is_trading"), Boolean.class);

    /**
     * Whether a {@link Turtle} is currently traveling.
     */
    public static final Key<Value<Boolean>> IS_TRAVELING = Keys.key(ResourceKey.sponge("is_traveling"), Boolean.class);

    /**
     * Whether an {@link Ocelot} is currently trusting of {@link Player}s.
     */
    public static final Key<Value<Boolean>> IS_TRUSTING = Keys.key(ResourceKey.sponge("is_trusting"), Boolean.class);

    /**
     * Whether an {@link ItemStack} or {@link BlockState} is unbreakable.
     *
     * <p>Setting this to {@code true} will prevent the item stack's
     * {@link #ITEM_DURABILITY} from changing.</p>
     * Readonly(BlockState.class)
     */
    public static final Key<Value<Boolean>> IS_UNBREAKABLE = Keys.key(ResourceKey.sponge("is_unbreakable"), Boolean.class);

    /**
     * Whether a {@link Panda} is unhappy.
     */
    public static final Key<Value<Boolean>> IS_UNHAPPY = Keys.key(ResourceKey.sponge("is_unhappy"), Boolean.class);

    /**
     * Whehter a {@link BlockState} is waterlogged.
     */
    public static final Key<Value<Boolean>> IS_WATERLOGGED = Keys.key(ResourceKey.sponge("is_waterlogged"), Boolean.class);

    /**
     * Whether an {@link Entity} like {@link Wolf} is wet.
     * Readonly(Entity.class) except Wolf
     */
    public static final Key<Value<Boolean>> IS_WET = Keys.key(ResourceKey.sponge("is_wet"), Boolean.class);

    /**
     * The {@link ItemDisplayType display type} of a {@link org.spongepowered.api.entity.display.ItemDisplay}.
     */
    public static final Key<Value<ItemDisplayType>> ITEM_DISPLAY_TYPE = Keys.key(ResourceKey.sponge("item_display_type"), ItemDisplayType.class);

    /**
     * The durability of an {@link ItemStack}. {@link #MAX_DURABILITY}
     */
    public static final Key<Value<Integer>> ITEM_DURABILITY = Keys.key(ResourceKey.sponge("item_durability"), Integer.class);

    /**
     * The rarity of an item.
     */
    public static final Key<Value<ItemRarity>> ITEM_RARITY = Keys.key(ResourceKey.sponge("item_rarity"), ItemRarity.class);

    /**
     * The {@link ItemStackSnapshot item} in an
     * {@link Item}, {@link ItemFrame}, {@link Jukebox}, {@link Lectern} or
     * {@link Potion}.
     */
    public static final Key<Value<ItemStackSnapshot>> ITEM_STACK_SNAPSHOT = Keys.key(ResourceKey.sponge("item_stack_snapshot"), ItemStackSnapshot.class);

    /**
     * The knockback strength applied by an {@link ArrowEntity}.
     *
     * <p>For the knockback provided by hits with a weapon according to the
     * enchantment of the same name, see {@link #APPLIED_ENCHANTMENTS}.</p>
     */
    public static final Key<Value<Double>> KNOCKBACK_STRENGTH = Keys.key(ResourceKey.sponge("knockback_strength"), Double.class);

    /**
     * The known {@link PandaGene gene} of a {@link Panda}.
     */
    public static final Key<Value<PandaGene>> KNOWN_GENE = Keys.key(ResourceKey.sponge("known_gene"), PandaGene.class);

    /**
     * The last attacking {@link Entity} of a {@link Living}.
     */
    public static final Key<Value<Entity>> LAST_ATTACKER = Keys.key(ResourceKey.sponge("last_attacker"), Entity.class);

    /**
     * The output yielded by the last command of a {@link CommandBlock} or {@link CommandBlockMinecart}.
     */
    public static final Key<Value<Component>> LAST_COMMAND_OUTPUT = Keys.key(ResourceKey.sponge("last_command_output"), Component.class);

    /**
     * The last damage a {@link Living} received.
     */
    public static final Key<Value<Double>> LAST_DAMAGE_RECEIVED = Keys.key(ResourceKey.sponge("last_damage_received"), Double.class);

    /**
     * The last time a {@link User} joined on the server.
     */
    public static final Key<Value<Instant>> LAST_DATE_JOINED = Keys.key(ResourceKey.sponge("last_date_joined"), Instant.class);

    /**
     * The last time a {@link User} has been playing on the server.
     */
    public static final Key<Value<Instant>> LAST_DATE_PLAYED = Keys.key(ResourceKey.sponge("last_date_played"), Instant.class);

    /**
     * The amount of layers a {@link BlockState} has.
     * e.g. {@link BlockTypes#SNOW}, {@link BlockTypes#CAKE}
     */
    public static final Key<Value<Integer>> LAYER = Keys.key(ResourceKey.sponge("layer"), Integer.class);

    /**
     * The holder of a leashed {@link Agent}
     * e.g. a {@link Player} or {@link LeashKnot}.
     * <p>Usually, a {@link LeashKnot} will always exist so long as there is
     * a leashed {@link Entity} attached. If the leash is broken, the leash
     * hitch is removed.</p>
     */
    public static final Key<Value<Entity>> LEASH_HOLDER = Keys.key(ResourceKey.sponge("leash_holder"), Entity.class);

    /**
     * The rotation of an {@link ArmorStand}'s left arm.
     */
    public static final Key<Value<Vector3d>> LEFT_ARM_ROTATION = Keys.key(ResourceKey.sponge("left_arm_rotation"), Vector3d.class);

    /**
     * The rotation of an {@link ArmorStand}'s left leg.
     */
    public static final Key<Value<Vector3d>> LEFT_LEG_ROTATION = Keys.key(ResourceKey.sponge("left_leg_rotation"), Vector3d.class);

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
    public static final Key<Value<Ticks>> LIFE_TICKS = Keys.key(ResourceKey.sponge("life_ticks"), Ticks.class);

    /**
     * The amount of light that emitted by a {@link BlockState}.
     * Readonly
     */
    public static final Key<Value<Integer>> LIGHT_EMISSION = Keys.key(ResourceKey.sponge("light_emission"), Integer.class);

    /**
     * The maximum line width of a {@link TextDisplay}.
     */
    public static final Key<Value<Integer>> LINE_WIDTH = Keys.key(ResourceKey.sponge("line_width"), Integer.class);

    /**
     * A {@link Llama}'s {@link LlamaType}.
     */
    public static final Key<Value<LlamaType>> LLAMA_TYPE = Keys.key(ResourceKey.sponge("llama_type"), LlamaType.class);

    /**
     * A {@link ServerPlayer}'s client language.
     */
    public static final Key<Value<Locale>> LOCALE = Keys.key(ResourceKey.sponge("locale"), Locale.class);

    /**
     * The token used to lock a {@link CarrierBlockEntity}. Or the token on an {@link ItemStack} to unlock it.
     */
    public static final Key<Value<String>> LOCK_TOKEN = Keys.key(ResourceKey.sponge("lock_token"), String.class);

    /**
     * A lodestone location, used with {@link ItemTypes#COMPASS}.
     */
    public static final Key<Value<ServerLocation>> LODESTONE = Keys.key(ResourceKey.sponge("lodestone"), ServerLocation.class);

    /**
     * The displayed description ("lore") text of an {@link ItemStack}.
     *
     * <p>The lore text is usually displayed when the player hovers his cursor
     * over the stack. For the contents of a book see {@link #PAGES}
     * instead.</p>
     */
    public static final Key<ListValue<Component>> LORE = Keys.listKey(ResourceKey.sponge("lore"), Component.class);

    /**
     * Represents the {@link Key} for the {@link MapCanvas} of a map
     * for a {@link MapInfo}.
     * This contains the colors displayed on a map.
     *
     */
    public static final Key<Value<MapCanvas>> MAP_CANVAS = Keys.key(ResourceKey.sponge("map_canvas"), MapCanvas.class);

    /**
     * Represents the {@link Key} for the Set of {@link MapDecoration}s
     * for a {@link MapInfo}.
     *
     */
    public static final Key<SetValue<MapDecoration>> MAP_DECORATIONS = Keys.setKey(ResourceKey.sponge("map_decorations"), MapDecoration.class);

    /**
     * Represents the {@link Key} for the {@link MapInfo}
     * of an {@link ItemStack} of type {@link ItemTypes#FILLED_MAP}.
     * <p>
     * <b>Can be null if the ItemStack was made by a plugin and hasn't been offered a MapInfo yet.</b>
     */
    public static final Key<Value<MapInfo>> MAP_INFO = Keys.key(ResourceKey.sponge("map_info"), MapInfo.class);

    /**
     * Represents the {@link Key} for the centre x and z of where a
     * {@link MapInfo} represents.
     * This will be automatically centralised correctly.
     */
    public static final Key<Value<Vector2i>> MAP_LOCATION = Keys.key(ResourceKey.sponge("map_location"), Vector2i.class);

    /**
     * Represents the {@link Key} for whether a map updates from players
     * for a {@link MapInfo}.
     * By default this is false.
     * Can be used in combination with {@link Keys#MAP_CANVAS} to create
     * custom static map.
     * See <a href="https://minecraft.gamepedia.com/Map#Locking">Minecraft Wiki - Map Locking</a>
     */
    public static final Key<Value<Boolean>> MAP_LOCKED = Keys.key(ResourceKey.sponge("map_locked"), Boolean.class);

    /**
     * Represents the {@link Key} for the scale of a map
     * for a {@link MapInfo}.
     * @see <a href="https://minecraft.gamepedia.com/Map#Zoom_details">Minecraft Wiki - Zoom Details</a>
     */
    public static final Key<Value<Integer>> MAP_SCALE = Keys.key(ResourceKey.sponge("map_scale"), Integer.class);

    /**
     * Represents the {@link Key} for whether a {@link MapInfo}
     * tracks player positions.
     */
    public static final Key<Value<Boolean>> MAP_TRACKS_PLAYERS = Keys.key(ResourceKey.sponge("map_tracks_players"), Boolean.class);

    /**
     * Represents the {@link Key} for whether a {@link MapInfo} can track
     * a player from anywhere in the world.
     */
    public static final Key<Value<Boolean>> MAP_UNLIMITED_TRACKING = Keys.key(ResourceKey.sponge("map_unlimited_tracking"), Boolean.class);

    /**
     * Represents the {@link Key} for the {@link ResourceKey} of a {@link ServerWorld}.
     * {@link MapInfo}
     */
    public static final Key<Value<ResourceKey>> MAP_WORLD = Keys.key(ResourceKey.sponge("map_world"), ResourceKey.class);

    /**
     * The matter state of a {@link BlockState}
     * Readonly
     */
    public static final Key<Value<MatterType>> MATTER_TYPE = Keys.key(ResourceKey.sponge("matter_type"), MatterType.class);

    /**
     * The maximum air supply a {@link Living} may have.
     *
     * <p>For the current amount of air, check {@link #REMAINING_AIR}.</p>
     */
    public static final Key<Value<Integer>> MAX_AIR = Keys.key(ResourceKey.sponge("max_air"), Integer.class);

    /**
     * The maximum amount of ticks a {@link FurnaceBlockEntity}
     * can burn with the currently used fuel item.
     */
    public static final Key<Value<Ticks>> MAX_BURN_TIME = Keys.key(ResourceKey.sponge("max_burn_time"), Ticks.class);

    /**
     * The total time the current {@link ItemStack} in a
     * {@link FurnaceBlockEntity} has to be cooked.
     */
    public static final Key<Value<Ticks>> MAX_COOK_TIME = Keys.key(ResourceKey.sponge("max_cook_time"), Ticks.class);

    /**
     * The maximum durability of an {@link ItemStack}. {@link #ITEM_DURABILITY}
     * Readonly
     */
    public static final Key<Value<Integer>> MAX_DURABILITY = Keys.key(ResourceKey.sponge("max_durability"), Integer.class);

    /**
     * The maximum exhuastion of a {@link Humanoid}. Readonly.
     *
     * @see Keys#EXHAUSTION
     */
    public static final Key<Value<Double>> MAX_EXHAUSTION = Keys.key(ResourceKey.sponge("max_exhaustion"), Double.class);

    /**
     * The maximum damage a {@link FallingBlock} can deal.
     */
    public static final Key<Value<Double>> MAX_FALL_DAMAGE = Keys.key(ResourceKey.sponge("max_fall_damage"), Double.class);

    /**
     * The maximum food level of a {@link Humanoid}. Readonly.
     *
     * @see Keys#FOOD_LEVEL
     */
    public static final Key<Value<Integer>> MAX_FOOD_LEVEL = Keys.key(ResourceKey.sponge("max_food_level"), Integer.class);

    /**
     * The maximum health of a {@link Living}.
     *
     * <p>The maximum health set here may affect the attribute increasing
     * health points. The base health should be minded that it may be lower
     * than the total maximum health of the entity.</p>
     */
    public static final Key<Value<Double>> MAX_HEALTH = Keys.key(ResourceKey.sponge("max_health"), Double.class);

    /**
     * The maximum number of entities around a {@link MobSpawner}.
     * A spawner will not spawn entities if there are more
     * entities around than this value permits.
     */
    public static final Key<Value<Integer>> MAX_NEARBY_ENTITIES = Keys.key(ResourceKey.sponge("max_nearby_entities"), Integer.class);

    /**
     * The maximum saturation of a {@link Humanoid}. Readonly.
     *
     * @see Keys#SATURATION
     */
    public static final Key<Value<Double>> MAX_SATURATION = Keys.key(ResourceKey.sponge("max_saturation"), Double.class);

    /**
     * The maximum amount of ticks between two
     * batches of entities spawned by a {@link MobSpawner}.
     */
    public static final Key<Value<Ticks>> MAX_SPAWN_DELAY = Keys.key(ResourceKey.sponge("max_spawn_delay"), Ticks.class);

    /**
     * The max speed of a {@link Boat}. In vanilla, this is 0.4
     */
    public static final Key<Value<Double>> MAX_SPEED = Keys.key(ResourceKey.sponge("max_speed"), Double.class);

    /**
     * The maximum stack size of slots in an inventory. For most vanilla inventories this is 64.
     * Readonly
     */
    public static final Key<Value<Integer>> MAX_STACK_SIZE = Keys.key(ResourceKey.sponge("max_stack_size"), Integer.class);

    /**
     * The represented block's offset of a {@link MinecartLike}.
     */
    public static final Key<Value<Integer>> MINECART_BLOCK_OFFSET = Keys.key(ResourceKey.sponge("minecart_block_offset"), Integer.class);

    /**
     * The minimum amount of ticks between two
     * batches of entities spawned by a {@link MobSpawner}.
     */
    public static final Key<Value<Ticks>> MIN_SPAWN_DELAY = Keys.key(ResourceKey.sponge("min_spawn_delay"), Ticks.class);

    /**
     * The moisture value of a {@link BlockTypes#FARMLAND} {@link BlockState}.
     */
    public static final Key<Value<Integer>> MOISTURE = Keys.key(ResourceKey.sponge("moisture"), Integer.class);

    /**
     * The type of a {@link Mooshroom}.
     */
    public static final Key<Value<MooshroomType>> MOOSHROOM_TYPE = Keys.key(ResourceKey.sponge("mooshroom_type"), MooshroomType.class);

    /**
     * The type of {@link MusicDisc} an {@link ItemStack} holds.
     */
    public static final Key<Value<MusicDisc>> MUSIC_DISC = Keys.key(ResourceKey.sponge("music_disc"), MusicDisc.class);

    /**
     * The settings for entities that can naturally spawn in a {@link Biome}.
     * <p>See {@link #SPAWN_CHANCE} for the spawn chance during world generation</p>
     * Readonly
     */
    public static final Key<MapValue<EntityCategory, List<NaturalSpawner>>> NATURAL_SPAWNERS = Keys.mapKey(ResourceKey.sponge("natural_spawners"), TypeToken.get(EntityCategory.class), new TypeToken<List<NaturalSpawner>>() {});

    /**
     * The cost settings for {@link #NATURAL_SPAWNERS} in a {@link Biome}.
     * <p>This is an alternative to mob-cap</p>
     * Readonly
     */
    public static final Key<MapValue<EntityType<?>, NaturalSpawnCost>> NATURAL_SPAWNER_COST = Keys.mapKey(ResourceKey.sponge("natural_spawner_cost"), new TypeToken<EntityType<?>>() {}, TypeToken.get(NaturalSpawnCost.class));

    /**
     * Whether a {@link WorldType} is considered natural.
     * <p>Natural worlds allow
     * sleeping in beds and setting the respawn point,
     * {@link PortalTypes#NETHER} portals to spawn {@link ZombifiedPiglin} and
     * {@link ItemTypes#COMPASS} to work</p>
     * Readonly
     */
    public static final Key<Value<Boolean>> NATURAL_WORLD_TYPE = Keys.key(ResourceKey.sponge("natural_world_type"), Boolean.class);

    /**
     * The next entity that will be spawned by a {@link MobSpawner}.
     *
     * <p>Normally the entities to be spawned are determined by a random value
     * applied to the {@link #SPAWNABLE_ENTITIES} weighted collection. If this
     * value exists, it will override the random spawn with a definite one.</p>
     */
    public static final Key<Value<WeightedSerializableObject<EntityArchetype>>> NEXT_ENTITY_TO_SPAWN = Keys.key(ResourceKey.sponge("next_entity_to_spawn"), new TypeToken<WeightedSerializableObject<EntityArchetype>>() {});

    /**
     * The pitch of a {@link BlockTypes#NOTE_BLOCK} {@link BlockState}.
     */
    public static final Key<Value<NotePitch>> NOTE_PITCH = Keys.key(ResourceKey.sponge("note_pitch"), NotePitch.class);

    /**
     * The notifier, usually of an {@link Entity}. It is up to the implementation to define.
     */
    public static final Key<Value<UUID>> NOTIFIER = Keys.key(ResourceKey.sponge("notifier"), UUID.class);

    /**
     * The deceleration a {@link Boat} while it has {@link Keys#PASSENGERS}.
     */
    public static final Key<Value<Double>> OCCUPIED_DECELERATION = Keys.key(ResourceKey.sponge("occupied_deceleration"), Double.class);

    /**
     * Whether an {@link Entity} is currently considered to be on the ground.
     * Readonly
     */
    public static final Key<Value<Boolean>> ON_GROUND = Keys.key(ResourceKey.sponge("on_ground"), Boolean.class);

    /**
     * The opacity of a {@link TextDisplay}. 0 to 255
     */
    public static final Key<Value<Byte>> OPACITY = Keys.key(ResourceKey.sponge("opacity"), Byte.class);

    /**
     * The {@link Orientation} of an {@link ItemFrame}.
     */
    public static final Key<Value<Orientation>> ORIENTATION = Keys.key(ResourceKey.sponge("orientation"), Orientation.class);

    /**
     * The content of a {@link ItemTypes#WRITTEN_BOOK} {@link ItemStack}.
     *
     * <p>Use {@link Keys#PLAIN_PAGES} if you wish to inspect the contents
     * of a {@link ItemTypes#WRITABLE_BOOK}.</p>
     */
    public static final Key<ListValue<Component>> PAGES = Keys.listKey(ResourceKey.sponge("pages"), Component.class);

    /**
     * The {@link ParrotType type} of a {@link Parrot}.
     */
    public static final Key<Value<ParrotType>> PARROT_TYPE = Keys.key(ResourceKey.sponge("parrot_type"), ParrotType.class);

    /**
     * The particle type of an {@link AreaEffectCloud}.
     *
     * <p>Only a few {@link ParticleOption}s will be usable for this
     * effect for specific {@link ParticleType}s and not every
     * {@link ParticleType} will be applicable.</p>
     */
    public static final Key<Value<ParticleEffect>> PARTICLE_EFFECT = Keys.key(ResourceKey.sponge("particle_effect"), ParticleEffect.class);

    /**
     * The amount of ticks a {@link FurnaceBlockEntity} has
     * been cooking the current item for.
     *
     * <p>Once this value reaches the {@link #MAX_COOK_TIME}, the
     * item will be finished cooking.</p>
     */
    public static final Key<Value<Ticks>> PASSED_COOK_TIME = Keys.key(ResourceKey.sponge("passed_cook_time"), Ticks.class);

    /**
     * The entities that act as passengers for an {@link Entity}.
     *
     * <p>For example, a {@link Player} riding on a {@link Horse} or a
     * {@link Pig} would be considered its passenger.</p>
     */
    public static final Key<ListValue<Entity>> PASSENGERS = Keys.listKey(ResourceKey.sponge("passengers"), Entity.class);

    /**
     * A {@link TropicalFish}'s pattern color.
     */
    public static final Key<Value<DyeColor>> PATTERN_COLOR = Keys.key(ResourceKey.sponge("pattern_color"), DyeColor.class);

    /**
     * Whether spawn logic is performed on a world of a {@link WorldTemplate} or {@link ServerWorldProperties}
     * See {@link ServerWorldProperties#performsSpawnLogic()}.
     * Readonly
     */
    public static final Key<Value<Boolean>> PERFORM_SPAWN_LOGIC = Keys.key(ResourceKey.sponge("perform_spawn_logic"), Boolean.class);

    /**
     * The {@link PhantomPhase phase} of a {@link Phantom}.
     */
    public static final Key<Value<PhantomPhase>> PHANTOM_PHASE = Keys.key(ResourceKey.sponge("phantom_phase"), PhantomPhase.class);

    /**
     * The pickup delay (in ticks) of an {@link Item}.
     */
    public static final Key<Value<Ticks>> PICKUP_DELAY = Keys.key(ResourceKey.sponge("pickup_delay"), Ticks.class);

    /**
     * The {@link PickupRule} of an {@link ArrowEntity}.
     */
    public static final Key<Value<PickupRule>> PICKUP_RULE = Keys.key(ResourceKey.sponge("pickup_rule"), PickupRule.class);

    /**
     * Whether a {@link WorldType} is safe for {@link Piglin} to not transform
     * into {@link ZombifiedPiglin} over time in a {@link ServerWorld world} of that type
     * Readonly
     */
    public static final Key<Value<Boolean>> PIGLIN_SAFE = Keys.key(ResourceKey.sponge("piglin_safe"), Boolean.class);

    /**
     * The piston type of a piston {@link BlockState} TODO dataholder {@link Piston}.
     */
    public static final Key<Value<PistonType>> PISTON_TYPE = Keys.key(ResourceKey.sponge("piston_type"), PistonType.class);

    /**
     * The block types an {@link ItemStack} may be placed on.
     */
    public static final Key<SetValue<BlockType>> PLACEABLE_BLOCK_TYPES = Keys.setKey(ResourceKey.sponge("placeable_block_types"), BlockType.class);

    /**
     * The content of a {@link ItemTypes#WRITABLE_BOOK} {@link ItemStack}.
     *
     * <p>Use {@link Keys#PAGES} if you wish to get the contents of a
     * {@link ItemTypes#WRITTEN_BOOK}</p>
     */
    public static final Key<ListValue<String>> PLAIN_PAGES = Keys.listKey(ResourceKey.sponge("plain_pages"), String.class);

    /**
     * The plugin that created an {@link Inventory}
     */
    public static final Key<Value<PluginContainer>> PLUGIN_CONTAINER = Keys.key(ResourceKey.sponge("plugin_container"), PluginContainer.class);

    /**
     * The pore sides of a {@link BlockTypes#BROWN_MUSHROOM_BLOCK} or
     * {@link BlockTypes#RED_MUSHROOM_BLOCK} {@link BlockState}.
     * See {@link #HAS_PORES_UP}, {@link #HAS_PORES_DOWN}, {@link #HAS_PORES_NORTH}, {@link #HAS_PORES_EAST}, {@link #HAS_PORES_SOUTH}, {@link #HAS_PORES_WEST}.
     */
    public static final Key<SetValue<Direction>> PORES = Keys.setKey(ResourceKey.sponge("pores"), Direction.class);

    /**
     * The {@link PortionType} of a {@link BlockState}.
     * e.g. {@link BlockTypes#OAK_DOOR}, {@link BlockTypes#ROSE_BUSH} or {@link BlockTypes#WHITE_BED}
     * For slabs use {@link #SLAB_PORTION} instead
     */
    public static final Key<Value<PortionType>> PORTION_TYPE = Keys.key(ResourceKey.sponge("portion_type"), PortionType.class);

    /**
     * The potential max speed of a {@link Minecart}.
     */
    public static final Key<Value<Double>> POTENTIAL_MAX_SPEED = Keys.key(ResourceKey.sponge("potential_max_speed"), Double.class);

    /**
     * The potion effects that are present on an {@link Entity}
     * <p>or applied by an {@link AreaEffectCloud} or {@link ArrowEntity}</p>
     * <p>or stored on an {@link ItemStack}.</p>
     */
    public static final Key<ListValue<PotionEffect>> POTION_EFFECTS = Keys.listKey(ResourceKey.sponge("potion_effects"), PotionEffect.class);

    /**
     * The potion type of an {@link ItemStack}.
     */
    public static final Key<Value<PotionType>> POTION_TYPE = Keys.key(ResourceKey.sponge("potion_type"), PotionType.class);

    /**
     * The signal power of a {@link BlockState}.
     *
     * <p>Applies to blocks that may emit a Redstone signal of variable
     * strength, such as {@link BlockTypes#REDSTONE_WIRE},
     * {@link BlockTypes#DAYLIGHT_DETECTOR},
     * {@link BlockTypes#LIGHT_WEIGHTED_PRESSURE_PLATE} etc.</p>
     */
    public static final Key<Value<Integer>> POWER = Keys.key(ResourceKey.sponge("power"), Integer.class);

    /**
     * The default {@link Precipitation} type of a {@link Biome}. Readonly.
     */
    public static final Key<Value<Precipitation>> PRECIPITATION = Keys.key(ResourceKey.sponge("precipitation"), Precipitation.class);

    /**
     * Whether a {@link Biome} has {@link Precipitation}. Readonly.
     */
    public static final Key<Value<Boolean>> HAS_PRECIPITATION = Keys.key(ResourceKey.sponge("has_precipitation"), Boolean.class);

    /**
     * The previous {@link GameMode} of a {@link ServerPlayer}. Readonly.
     */
    public static final Key<Value<GameMode>> PREVIOUS_GAME_MODE = Keys.key(ResourceKey.sponge("previous_game_mode"), GameMode.class);

    /**
     * A {@link Beacon}'s primary effect.
     */
    public static final Key<Value<PotionEffectType>> PRIMARY_POTION_EFFECT_TYPE = Keys.key(ResourceKey.sponge("primary_potion_effect_type"), PotionEffectType.class);

    /**
     * The {@link Villager} or {@link ZombieVillager}'s {@link ProfessionType}.
     */
    public static final Key<Value<ProfessionType>> PROFESSION_TYPE = Keys.key(ResourceKey.sponge("profession_type"), ProfessionType.class);

    /**
     * The {@link Villager} or {@link ZombieVillager}'s {@link ProfessionType} level.
     */
    public static final Key<Value<Integer>> PROFESSION_LEVEL = Keys.key(ResourceKey.sponge("profession_level"), Integer.class);

    /**
     * Whether pvp combat is enabled in a world of a {@link WorldTemplate} or {@link ServerWorldProperties}
     * Readonly
     */
    public static final Key<Value<Boolean>> PVP = Keys.key(ResourceKey.sponge("pvp"), Boolean.class);

    /**
     * The type of a {@link Rabbit}.
     */
    public static final Key<Value<RabbitType>> RABBIT_TYPE = Keys.key(ResourceKey.sponge("rabbit_type"), RabbitType.class);

    /**
     * The radius of an {@link AreaEffectCloud}.
     */
    public static final Key<Value<Double>> RADIUS = Keys.key(ResourceKey.sponge("radius"), Double.class);

    /**
     * The amount the radius of an
     * {@link AreaEffectCloud} grows or shrinks each time it applies its
     * effect.
     */
    public static final Key<Value<Double>> RADIUS_ON_USE = Keys.key(ResourceKey.sponge("radius_on_use"), Double.class);

    /**
     * The amount the radius of an
     * {@link AreaEffectCloud} grows or shrinks per tick.
     */
    public static final Key<Value<Double>> RADIUS_PER_TICK = Keys.key(ResourceKey.sponge("radius_per_tick"), Double.class);

    /**
     * The wave number of a raid a {@link Raider} is in.
     * Readonly but mutable
     */
    public static final Key<Value<RaidWave>> RAID_WAVE = Keys.key(ResourceKey.sponge("raid_wave"), RaidWave.class);

    /**
     * The {@link RailDirection} of a {@link BlockState}.
     */
    public static final Key<Value<RailDirection>> RAIL_DIRECTION = Keys.key(ResourceKey.sponge("rail_direction"), RailDirection.class);

    /**
     * The delay (in ticks) after which an
     * {@link AreaEffectCloud} will reapply its effect on a previously
     * affected {@link Entity}.
     */
    public static final Key<Value<Ticks>> REAPPLICATION_DELAY = Keys.key(ResourceKey.sponge("reapplication_delay"), Ticks.class);

    /**
     * The redstone delay on a {@link BlockTypes#REPEATER} {@link BlockState}.
     */
    public static final Key<Value<Integer>> REDSTONE_DELAY = Keys.key(ResourceKey.sponge("redstone_delay"), Integer.class);

    /**
     * The amount of air a {@link Living} has left.
     */
    public static final Key<Value<Integer>> REMAINING_AIR = Keys.key(ResourceKey.sponge("remaining_air"), Integer.class);

    /**
     * The remaining amount of ticks the current brewing
     * process of a {@link BrewingStand} will take.
     *
     * <p>If nothing is being brewed, the remaining brew time will be 0.</p>
     */
    public static final Key<Value<Ticks>> REMAINING_BREW_TIME = Keys.key(ResourceKey.sponge("remaining_brew_time"), Ticks.class);

    /**
     * Represents the {@link Key} for the remaining number of ticks to pass
     * before another attempt to spawn entities is made by a {@link MobSpawner}.
     */
    public static final Key<Value<Ticks>> REMAINING_SPAWN_DELAY = Keys.key(ResourceKey.sponge("remaining_spawn_delay"), Ticks.class);

    /**
     * The amount of food a food {@link ItemStack} restores when eaten.
     * Readonly
     */
    public static final Key<Value<Integer>> REPLENISHED_FOOD = Keys.key(ResourceKey.sponge("replenished_food"), Integer.class);

    /**
     * The amount of saturation a food {@link ItemStack} provides when eaten.
     * Readonly
     */
    public static final Key<Value<Double>> REPLENISHED_SATURATION = Keys.key(ResourceKey.sponge("replenished_saturation"), Double.class);

    /**
     * The {@link InstrumentType} of a {@link BlockState} when placed under a {@link BlockTypes#NOTE_BLOCK}.
     * Readonly
     */
    public static final Key<Value<InstrumentType>> REPRESENTED_INSTRUMENT = Keys.key(ResourceKey.sponge("represented_instrument"), InstrumentType.class);

    /**
     * How close a {@link Player} has to be around the {@link MobSpawner}
     * in order for it to attempt to spawn entities.
     */
    public static final Key<Value<Double>> REQUIRED_PLAYER_RANGE = Keys.key(ResourceKey.sponge("required_player_range"), Double.class);

    /**
     * Whether a {@link WorldType} allows using {@link BlockTypes#RESPAWN_ANCHOR}s.
     * TODO check if true
     * <p>When respawn anchor usage is not allowed they will instead explode in a {@link ServerWorld world} of that type.</p>
     * <p>Also see {@link #BEDS_USABLE}</p>
     * Readonly
     */
    public static final Key<Value<Boolean>> RESPAWN_ANCHOR_USABLE = Keys.key(ResourceKey.sponge("respawn_anchor_usable"), Boolean.class);

    /**
     * The spawn locations a {@link Player}
     * may have for various worlds based on {@link UUID} of the world.
     */
    public static final Key<MapValue<ResourceKey, RespawnLocation>> RESPAWN_LOCATIONS = Keys.mapKey(ResourceKey.sponge("respawn_locations"), ResourceKey.class, RespawnLocation.class);

    /**
     * The rotation of an {@link ArmorStand}'s right arm.
     */
    public static final Key<Value<Vector3d>> RIGHT_ARM_ROTATION = Keys.key(ResourceKey.sponge("right_arm_rotation"), Vector3d.class);

    /**
     * The rotation of an {@link ArmorStand}'s right leg.
     */
    public static final Key<Value<Vector3d>> RIGHT_LEG_ROTATION = Keys.key(ResourceKey.sponge("right_leg_rotation"), Vector3d.class);

    /**
     * The time a {@link Ravager} is roaring.
     */
    public static final Key<Value<Ticks>> ROARING_TIME = Keys.key(ResourceKey.sponge("roaring_time"), Ticks.class);

    /**
     * The current saturation of a {@link Player}.
     *
     * <p>When the saturation level reaches 0, the food level is usually
     * diminished such that the food level is decreased by 1, then
     * saturation is reset to the maximum value. This type of effect occurs
     * over time and can be modified by movements and actions performed by the
     * {@link Player}.</p>
     */
    public static final Key<Value<Double>> SATURATION = Keys.key(ResourceKey.sponge("saturation"), Double.class);

    /**
     * The "scale" for the size of an {@link Entity}.
     *
     * <p>Together with {@link #BASE_SIZE} and {@link #HEIGHT} this defines the size of an {@link Entity}.</p>
     */
    public static final Key<Value<Double>> SCALE = Keys.key(ResourceKey.sponge("scale"), Double.class);

    /**
     * The scoreboard tags applied to an {@link Entity}.
     *
     * @see <a href="https://minecraft.gamepedia.com/Scoreboard#Tags">
     * https://minecraft.gamepedia.com/Scoreboard#Tags</a>
     */
    public static final Key<SetValue<String>> SCOREBOARD_TAGS = Keys.setKey(ResourceKey.sponge("scoreboard_tags"), String.class);

    /**
     * Whether a {@link WorldType} is considered scorching hot.
     * <p>Affects {@link BlockTypes#WATER}, {@link BlockTypes#WET_SPONGE} and flow of {@link FluidTypes#FLOWING_LAVA}</p>
     * Readonly
     */
    public static final Key<Value<Boolean>> SCORCHING = Keys.key(ResourceKey.sponge("scorching"), Boolean.class);

    /**
     * The triggering state of a {@link BlockTypes#SCULK_SENSOR}.
     */
    public static final Key<Value<SculkSensorState>> SCULK_SENSOR_STATE = Keys.key(ResourceKey.sponge("sculk_sensor_state"), SculkSensorState.class);

    /**
     * A {@link Beacon}'s secondary effect.
     */
    public static final Key<Value<PotionEffectType>> SECONDARY_POTION_EFFECT_TYPE = Keys.key(ResourceKey.sponge("secondary_potion_effect_type"), PotionEffectType.class);

    /**
     * A {@link Fox fox's} second trusted {@link UUID}, usually a {@link Player}.
     */
    public static final Key<Value<UUID>> SECOND_TRUSTED = Keys.key(ResourceKey.sponge("second_trusted"), UUID.class);

    /**
     * The seed of a {@link WorldTemplate}
     */
    public static final Key<Value<Long>> SEED = Keys.key(ResourceKey.sponge("structure_seed"), Long.class);

    /**
     * Whether {@link TextDisplay} are visible through blocks.
     */
    public static final Key<Value<Boolean>> SEE_THROUGH_BLOCKS = Keys.key(ResourceKey.sponge("see_through_blocks"), Boolean.class);

    /**
     * The {@link SerializationBehavior} of a {@link WorldTemplate} or {@link ServerWorldProperties}
     * Readonly
     */
    public static final Key<Value<SerializationBehavior>> SERIALIZATION_BEHAVIOR = Keys.key(ResourceKey.sponge("serialization_behavior"), SerializationBehavior.class);

    /**
     * The shadow radius of a {@link DisplayEntity}
     */
    public static final Key<Value<Double>> SHADOW_RADIUS = Keys.key(ResourceKey.sponge("shadow_radius"), Double.class);

    /**
     * The shadow strength duration of a {@link DisplayEntity}
     */
    public static final Key<Value<Double>> SHADOW_STRENGTH = Keys.key(ResourceKey.sponge("shadow_strength"), Double.class);

    /**
     * The shooter of a {@link Projectile}.
     */
    public static final Key<Value<ProjectileSource>> SHOOTER = Keys.key(ResourceKey.sponge("shooter"), ProjectileSource.class);

    /**
     * Whether a {@link EndCrystal} should show its bottom bedrock platform.
     */
    public static final Key<Value<Boolean>> SHOW_BOTTOM = Keys.key(ResourceKey.sponge("show_bottom"), Boolean.class);

    /**
     * The lines of a {@link org.spongepowered.api.block.entity.Sign.SignText}.
     * When using it on {@link Sign} this refers to the {@link #SIGN_FRONT_TEXT} only.
     */
    public static final Key<ListValue<Component>> SIGN_LINES = Keys.listKey(ResourceKey.sponge("sign_lines"), Component.class);

    public static final Key<Value<Sign.SignText>> SIGN_BACK_TEXT = Keys.key(ResourceKey.sponge("sign_back_text"), Sign.SignText.class);
    public static final Key<Value<Sign.SignText>> SIGN_FRONT_TEXT = Keys.key(ResourceKey.sponge("sign_front_text"), Sign.SignText.class);

    public static final Key<Value<Boolean>> SIGN_WAXED = Keys.key(ResourceKey.sponge("sign_waxed"), Boolean.class);

    /**
     * The size of a {@link Slime}.
     * or
     * The size of a {@link Phantom}. In vanilla, this ranges between 0 and 64.
     */
    public static final Key<Value<Integer>> SIZE = Keys.key(ResourceKey.sponge("size"), Integer.class);

    /**
     * The parts of a {@link ServerPlayer} skin that should be displayed.
     *
     * <p>This is a read-only value, set by the client.</p>
     */
    public static final Key<SetValue<SkinPart>> SKIN_PARTS = Keys.setKey(ResourceKey.sponge("skin_parts"), SkinPart.class);

    /**
     * The skin of a {@link Humanoid} or {@link ServerPlayer}.
     *
     * <p>Usable with {@link ProfileProperty#TEXTURES}</p>
     */
    public static final Key<Value<ProfileProperty>> SKIN_PROFILE_PROPERTY = Keys.key(ResourceKey.sponge("skin_profile_property"), ProfileProperty.class);

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
    public static final Key<Value<Integer>> SKIN_MOISTURE = Keys.key(ResourceKey.sponge("skin_moisture"), Integer.class);

    /**
     * The skylight value at a {@link ServerLocation}.
     * For the blocklight see {@link #BLOCK_LIGHT}.
     * Readonly
     * <p>
     * Or the skylight override for a {@link DisplayEntity}.
     * </p>
     */
    public static final Key<Value<Integer>> SKY_LIGHT = Keys.key(ResourceKey.sponge("sky_light"), Integer.class);

    /**
     * The color of the sky in a {@link Biome}.
     * Readonly
     */
    public static final Key<Value<Color>> SKY_COLOR = Keys.key(ResourceKey.sponge("sky_color"), Color.class);

    /**
     * The {@link SlabPortion} of a {@link BlockState}.
     */
    public static final Key<Value<SlabPortion>> SLAB_PORTION = Keys.key(ResourceKey.sponge("slab_portion"), SlabPortion.class);

    /**
     * The sleep timer of a {@link Player}.
     */
    public static final Key<Value<Integer>> SLEEP_TIMER = Keys.key(ResourceKey.sponge("sleep_timer"), Integer.class);

    /**
     * The index of a {@link Slot} in an {@link Inventory}
     * Readonly
     */
    public static final Key<Value<Integer>> SLOT_INDEX = Keys.key(ResourceKey.sponge("slot_index"), Integer.class);

    /**
     * The position of a {@link Slot} within a {@link GridInventory}.
     * Readonly
     */
    public static final Key<Value<Vector2i>> SLOT_POSITION = Keys.key(ResourceKey.sponge("slot_position"), Vector2i.class);

    /**
     * The side of a particular {@link Slot}, for use in querying "sided inventories".
     * Readonly
     */
    public static final Key<Value<Direction>> SLOT_SIDE = Keys.key(ResourceKey.sponge("slot_side"), Direction.class);

    /**
     * Whether a {@link Minecart} slows down when it has no {@link Keys#PASSENGERS}.
     */
    public static final Key<Value<Boolean>> SLOWS_UNOCCUPIED = Keys.key(ResourceKey.sponge("slows_unoccupied"), Boolean.class);

    /**
     * The time a {@link Panda} has been sneezing (in ticks)
     */
    public static final Key<Value<Ticks>> SNEEZING_TIME = Keys.key(ResourceKey.sponge("sneezing_time"), Ticks.class);

    /**
     * The list of {@link EntityArchetype}s able to be spawned by a {@link MobSpawner}.
     */
    public static final Key<WeightedCollectionValue<EntityArchetype>> SPAWNABLE_ENTITIES = Keys.weightedKey(ResourceKey.sponge("spawnable_entities"), EntityArchetype.class);

    /**
     * The chance for an entity to spawn in a {@link Biome} during world generation.
     * <p>Must be between 0 and 1</p>
     * <p>Also see {@link #NATURAL_SPAWNERS}</p>
     * Readonly
     */
    public static final Key<Value<Double>> SPAWN_CHANCE = Keys.key(ResourceKey.sponge("spawn_chance"), Double.class);

    /**
     * How many entities a {@link MobSpawner} has spawned so far.
     */
    public static final Key<Value<Integer>> SPAWN_COUNT = Keys.key(ResourceKey.sponge("spawn_count"), Integer.class);

    /**
     * The light level needed to block monster spawning in a {@link WorldType}.
     */
    public static final Key<Value<Integer>> SPAWN_LIGHT_LIMIT = Keys.key(ResourceKey.sponge("spawn_light_limit"), Integer.class);

    /**
     * The light level range needed to block monster spawning in a {@link WorldType}
     */
    public static final Key<Value<Range<Integer>>> SPAWN_LIGHT_RANGE = Keys.key(ResourceKey.sponge("spawn_light_range"), new TypeToken<Range<Integer>>() {});

    /**
     * The spawn position in a world of a {@link WorldTemplate} or {@link WorldProperties}
     * Readonly
     */
    public static final Key<Value<Vector3i>> SPAWN_POSITION = Keys.key(ResourceKey.sponge("spawn_position"), Vector3i.class);

    /**
     * How far away from the {@link MobSpawner} the entities spawned by it may appear.
     */
    public static final Key<Value<Double>> SPAWN_RANGE = Keys.key(ResourceKey.sponge("spawn_range"), Double.class);

    /**
     * The {@link Entity target} of the spectator camera of a {@link Player}.
     */
    public static final Key<Value<Entity>> SPECTATOR_TARGET = Keys.key(ResourceKey.sponge("spectator_target"), Entity.class);

    /**
     * The {@link StairShape} of a {@link BlockState}.
     */
    public static final Key<Value<StairShape>> STAIR_SHAPE = Keys.key(ResourceKey.sponge("stair_shape"), StairShape.class);

    /**
     * The {@link Statistic}s of a {@link Player}.
     */
    public static final Key<MapValue<Statistic, Long>> STATISTICS = Keys.mapKey(ResourceKey.sponge("statistics"), Statistic.class, Long.class);

    /**
     * The enchantments stored on an {@link ItemStack}.
     *
     * <p>Stored enchantments are meant to be transferred. Usually this key
     * applies to {@link ItemTypes#ENCHANTED_BOOK} {@link ItemStack}s. Enchantments
     * affecting the item stack are retrieved via {@link #APPLIED_ENCHANTMENTS}
     * instead.</p>
     */
    public static final Key<ListValue<Enchantment>> STORED_ENCHANTMENTS = Keys.listKey(ResourceKey.sponge("stored_enchantments"), Enchantment.class);

    /**
     * A {@link Llama}s carrying strength. The higher the strength,
     * the more items it can carry (effectively the size of inventory).
     */
    public static final Key<Value<Integer>> STRENGTH = Keys.key(ResourceKey.sponge("strength"), Integer.class);

    /**
     * The author of a structure from a {@link StructureBlock}.
     */
    public static final Key<Value<String>> STRUCTURE_AUTHOR = Keys.key(ResourceKey.sponge("structure_author"), String.class);

    /**
     * Whether a {@link StructureBlock} should
     * ignore entities when saving a structure.
     */
    public static final Key<Value<Boolean>> STRUCTURE_IGNORE_ENTITIES = Keys.key(ResourceKey.sponge("structure_ignore_entities"), Boolean.class);

    /**
     * The integrity of a {@link StructureBlock}.
     */
    public static final Key<Value<Double>> STRUCTURE_INTEGRITY = Keys.key(ResourceKey.sponge("structure_integrity"), Double.class);

    /**
     * The mode of a {@link StructureBlock}.
     */
    public static final Key<Value<StructureMode>> STRUCTURE_MODE = Keys.key(ResourceKey.sponge("structure_mode"), StructureMode.class);

    /**
     * The position of a {@link StructureBlock}.
     */
    public static final Key<Value<Vector3i>> STRUCTURE_POSITION = Keys.key(ResourceKey.sponge("structure_position"), Vector3i.class);

    /**
     * Whether a {@link StructureBlock} is powered.
     */
    public static final Key<Value<Boolean>> STRUCTURE_POWERED = Keys.key(ResourceKey.sponge("structure_powered"), Boolean.class);

    /**
     * The seed of a {@link StructureBlock}
     */
    public static final Key<Value<Long>> STRUCTURE_SEED = Keys.key(ResourceKey.sponge("structure_seed"), Long.class);

    /**
     * Whether a
     * {@link StructureBlock} should make all {@link BlockTypes#AIR},
     * {@link BlockTypes#CAVE_AIR}, {@link BlockTypes#STRUCTURE_VOID} visible.
     */
    public static final Key<Value<Boolean>> STRUCTURE_SHOW_AIR = Keys.key(ResourceKey.sponge("structure_show_air"), Boolean.class);

    /**
     * Whether a {@link StructureBlock} shows the bounding box.
     */
    public static final Key<Value<Boolean>> STRUCTURE_SHOW_BOUNDING_BOX = Keys.key(ResourceKey.sponge("structure_show_bounding_box"), Boolean.class);

    /**
     * The size of a {@link StructureBlock}s structure.
     */
    public static final Key<Value<Vector3i>> STRUCTURE_SIZE = Keys.key(ResourceKey.sponge("structure_size"), Vector3i.class);

    /**
     * The amount of "stuck arrows" in a {@link Living}.
     */
    public static final Key<Value<Integer>> STUCK_ARROWS = Keys.key(ResourceKey.sponge("stuck_arrows"), Integer.class);

    /**
     * The time (in ticks) a {@link Ravager} is stunned.
     */
    public static final Key<Value<Ticks>> STUNNED_TIME = Keys.key(ResourceKey.sponge("stunned_time"), Ticks.class);

    /**
     * The amount of successful executions of a command
     * stored in a {@link CommandBlock} or {@link CommandBlockMinecart}.
     */
    public static final Key<Value<Integer>> SUCCESS_COUNT = Keys.key(ResourceKey.sponge("success_count"), Integer.class);

    /**
     * Whether a {@link BlockState} is suspended.
     */
    public static final Key<Value<Boolean>> SUSPENDED = Keys.key(ResourceKey.sponge("suspended"), Boolean.class);

    /**
     * The swiftness of an {@link Entity} e.g. {@link Minecart}s.
     * <p>This is equivalent to the magnitude of the {@link #VELOCITY} vector</p>
     */
    public static final Key<Value<Double>> SWIFTNESS = Keys.key(ResourceKey.sponge("swiftness"), Double.class);

    /**
     * The tamer of a {@link TameableAnimal} or {@link HorseLike}.
     */
    public static final Key<Value<UUID>> TAMER = Keys.key(ResourceKey.sponge("tamer"), UUID.class);

    /**
     * The targeted entity either by an {@link Agent} and it's
     * {@link GoalExecutorTypes#TARGET} selector or by a {@link FishingBobber} or {@link ShulkerBullet}.
     */
    public static final Key<Value<Entity>> TARGET_ENTITY = Keys.key(ResourceKey.sponge("target_entity"), Entity.class);

    /**
     * A target location.
     * e.g. An {@link EyeOfEnder} target or a {@link Player}'s compass.
     */
    public static final Key<Value<Vector3d>> TARGET_LOCATION = Keys.key(ResourceKey.sponge("target_location"), Vector3d.class);

    /**
     * A target block position.
     * e.g. A {@link Patroller}'s patrol target,
     * the travel position of a {@link Turtle},
     * the exit portal position of a {@link EndGateway} or
     * an {@link EndCrystal}'s beam target.
     */
    public static final Key<Value<Vector3i>> TARGET_POSITION = Keys.key(ResourceKey.sponge("target_position"), Vector3i.class);

    /**
     * The {@link TemperatureModifier} of a {@link Biome}.
     * Readonly
     */
    public static final Key<Value<TemperatureModifier>> TEMPERATURE_MODIFIER = Keys.key(ResourceKey.sponge("temperature_modifier"), TemperatureModifier.class);

    /**
     * The {@link TextAlignment} of a {@link TextDisplay}.
     */
    public static final Key<Value<TextAlignment>> TEXT_ALIGNMENT = Keys.key(ResourceKey.sponge("text_alignment"), TextAlignment.class);

    /**
     * The background {@link java.awt.Color} of a {@link TextDisplay}.
     */
    public static final Key<Value<java.awt.Color>> TEXT_BACKGROUND_COLOR = Keys.key(ResourceKey.sponge("text_background_color"), java.awt.Color.class);

    /**
     * The remaining fuse time in ticks of a {@link FusedExplosive}.
     * This value may be set to an arbitrary value
     * if the explosive is not primed.
     */
    public static final Key<Value<Ticks>> TICKS_REMAINING = Keys.key(ResourceKey.sponge("ticks_remaining"), Ticks.class);

    /**
     * The tilt of a {@link BlockTypes#BIG_DRIPLEAF} block, as triggered by
     * player motion.
     */
    public static final Key<Value<Tilt>> TILT = Keys.key(ResourceKey.sponge("tilt"), Tilt.class);

    /**
     * The {@link ItemTier} of an {@link ItemStack} tool.
     * Readonly
     */
    public static final Key<Value<ItemTier>> TOOL_TYPE = Keys.key(ResourceKey.sponge("tool_type"), ItemTier.class);

    /**
     * Whether a {@link CommandBlock} does track its output.
     *
     * <p>If this is set, the output of the most recent execution can be
     * retrieved using {@link #LAST_COMMAND_OUTPUT}.</p>
     */
    public static final Key<Value<Boolean>> TRACKS_OUTPUT = Keys.key(ResourceKey.sponge("tracks_output"), Boolean.class);

    /**
     * The {@link TradeOffer}s offered by a {@link Trader} or a {@link org.spongepowered.api.item.inventory.type.ViewableInventory.Custom}
     */
    public static final Key<ListValue<TradeOffer>> TRADE_OFFERS = Keys.listKey(ResourceKey.sponge("trade_offers"), TradeOffer.class);

    /**
     * Whether an {@link Entity} is transient.
     * This prevents the entity from being saved to disk.
     * The rules for this are as follows...
     *   If the entity type says that it isn't transient then this key is readonly.
     *   If the entity type says that it is transient, then this key dictates the current state.
     */
    public static final Key<Value<Boolean>> TRANSIENT = Keys.key(ResourceKey.sponge("transient"), Boolean.class);

    /**
     * The {@link Transform} of a {@link DisplayEntity}
     */
    public static final Key<Value<Transform>> TRANSFORM = Keys.key(ResourceKey.sponge("transform"), Transform.class);

    /**
     * A {@link TropicalFish}'s shape.
     */
    public static final Key<Value<TropicalFishShape>> TROPICAL_FISH_SHAPE = Keys.key(ResourceKey.sponge("tropical_fish_shape"), TropicalFishShape.class);

    /**
     * The time a {@link Panda} has been unhappy (in ticks)
     */
    public static final Key<Value<Ticks>> UNHAPPY_TIME = Keys.key(ResourceKey.sponge("unhappy_time"), Ticks.class);

    /**
     * The {@link UUID} of a custom inventory.
     */
    public static final Key<Value<UUID>> UNIQUE_ID = Keys.key(ResourceKey.sponge("unique_id"), UUID.class);

    /**
     * The deceleration a {@link Boat} while it does not have {@link Keys#PASSENGERS}.
     */
    public static final Key<Value<Double>> UNOCCUPIED_DECELERATION = Keys.key(ResourceKey.sponge("unoccupied_deceleration"), Double.class);

    /**
     * Whether a {@link BlockTypes#TNT} {@link BlockState} is unstable.
     */
    public static final Key<Value<Boolean>> UNSTABLE = Keys.key(ResourceKey.sponge("unstable"), Boolean.class);

    /**
     * Whether a {@link BlockTypes#POINTED_DRIPSTONE} is facing up or down.
     *
     * <p>Only supports {@link Direction#UP} or {@link Direction#DOWN}</p>
     */
    public static final Key<Value<Direction>> UP_OR_DOWN = Keys.key(ResourceKey.sponge("up_or_down"), Direction.class);

    /**
     * Whether changes to {@link Keys#SKIN_PROFILE_PROPERTY} should
     * be reflected in an entity's {@link GameProfile}.
     */
    public static final Key<Value<Boolean>> UPDATE_GAME_PROFILE = Keys.key(ResourceKey.sponge("update_game_profile"), Boolean.class);

    /**
     * The {@link VanishState} of an {@link Entity}.
     *
     * <p>The presence of a vanished entity will not be made known to a client;
     * no packets pertaining to this entity are sent. Client-side, this entity
     * will cease to exist. Server-side it may still be targeted by hostile
     * entities or collide with other entities.</p>
     *
     * <p>Vanishing an {@link Entity} ridden by other entities (see
     * {@link #PASSENGERS} will cause problems.</p>
     */
    public static final Key<Value<VanishState>> VANISH_STATE = Keys.key(ResourceKey.sponge("vanish"), VanishState.class);

    /**
     * The vehicle an {@link Entity} is riding.
     *
     * <p>Vehicles may be nested as a vehicle might itself ride another entity.
     * To get the vehicle on bottom, use {@link Keys#BASE_VEHICLE}.</p>
     */
    public static final Key<Value<Entity>> VEHICLE = Keys.key(ResourceKey.sponge("vehicle"), Entity.class);

    /**
     * The velocity of an {@link Entity}.
     */
    public static final Key<Value<Vector3d>> VELOCITY = Keys.key(ResourceKey.sponge("velocity"), Vector3d.class);

    /**
     * The client view distance of a {@link ServerPlayer}
     * <p>or the view distance in a world of a {@link WorldTemplate} or {@link ServerWorldProperties}</p>
     *
     * <p>This value represents the radius (around the player) in
     * unit chunks.</p>
     * Readonly
     */
    public static final Key<Value<Integer>> VIEW_DISTANCE = Keys.key(ResourceKey.sponge("view_distance"), Integer.class);

    /**
     * The view range of a {@link DisplayEntity}
     */
    public static final Key<Value<Double>> VIEW_RANGE = Keys.key(ResourceKey.sponge("view_range"), Double.class);

    /**
     * The type of a {@link Villager} or {@link ZombieVillager}.
     */
    public static final Key<Value<VillagerType>> VILLAGER_TYPE = Keys.key(ResourceKey.sponge("villager_type"), VillagerType.class);

    /**
     * The duration in ticks after which an
     * {@link AreaEffectCloud} will begin to apply its effect to entities.
     */
    public static final Key<Value<Ticks>> WAIT_TIME = Keys.key(ResourceKey.sponge("wait_time"), Ticks.class);

    /**
     * The base speed at which a {@link Player} or {@link Living} walks.
     */
    public static final Key<Value<Double>> WALKING_SPEED = Keys.key(ResourceKey.sponge("walking_speed"), Double.class);

    /**
     * The connection state of a wall in all four cardinal directions (north, west, east, and south).
     * <p>See {@link BlockStateKeys#NORTH_WALL}, {@link BlockStateKeys#EAST_WALL},
     * {@link BlockStateKeys#SOUTH_WALL} or {@link BlockStateKeys#WEST_WALL} for the individual connections.
     * </p>
     */
    public static final Key<MapValue<Direction, WallConnectionState>> WALL_CONNECTION_STATES = Keys.mapKey(ResourceKey.sponge("wall_connection_states"), Direction.class, WallConnectionState.class);

    /**
     * The color of water in a {@link Biome}.
     * Readonly
     */
    public static final Key<Value<Color>> WATER_COLOR = Keys.key(ResourceKey.sponge("water_color"), Color.class);

    /**
     * The color of water fog in a {@link Biome}.
     * Readonly
     */
    public static final Key<Value<Color>> WATER_FOG_COLOR = Keys.key(ResourceKey.sponge("water_fog_color"), Color.class);

    /**
     * The weather of a {@link ServerWorldProperties}.
     */
    public static final Key<Value<Weather>> WEATHER = Keys.key(ResourceKey.sponge("weather"), Weather.class);

    /**
     * Whether a thrown {@link EyeOfEnder} will shatter.
     */
    public static final Key<Value<Boolean>> WILL_SHATTER = Keys.key(ResourceKey.sponge("will_shatter"), Boolean.class);

    /**
     * The {@link WireAttachmentType}s of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState} for its neighboring blocks.
     */
    public static final Key<MapValue<Direction, WireAttachmentType>> WIRE_ATTACHMENTS = Keys.mapKey(ResourceKey.sponge("wire_attachments"), Direction.class, WireAttachmentType.class);

    /**
     * The {@link WireAttachmentType} of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState}
     * for its neighboring block to the {@link Direction#EAST}.
     */
    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_EAST = Keys.key(ResourceKey.sponge("wire_attachment_east"), WireAttachmentType.class);

    /**
     * The {@link WireAttachmentType} of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState}
     * for its neighboring block to the {@link Direction#NORTH}.
     */
    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_NORTH = Keys.key(ResourceKey.sponge("wire_attachment_north"), WireAttachmentType.class);

    /**
     * The {@link WireAttachmentType} of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState}
     * for its neighboring block to the {@link Direction#SOUTH}.
     */
    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_SOUTH = Keys.key(ResourceKey.sponge("wire_attachment_south"), WireAttachmentType.class);

    /**
     * The {@link WireAttachmentType} of a {@link BlockTypes#REDSTONE_WIRE} {@link BlockState}
     * for its neighboring block to the {@link Direction#WEST}.
     */
    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_WEST = Keys.key(ResourceKey.sponge("wire_attachment_west"), WireAttachmentType.class);

    /**
     * The entities targeted by the three {@link Wither} heads. In vanilla the wither only targets {@link Living}. {@code null} for no target entity.
     */
    public static final Key<ListValue<Entity>> WITHER_TARGETS = Keys.listKey(ResourceKey.sponge("wither_targets"), Entity.class);

    /**
     * The {@link Sheep} who is being targeted by the {@link SpellTypes#WOLOLO}
     * spell being casted by an {@link Evoker}
     */
    public static final Key<Value<Sheep>> WOLOLO_TARGET = Keys.key(ResourceKey.sponge("wololo_target"), Sheep.class);

    /**
     * The world border of {@link WorldProperties}
     * Readonly
     */
    public static final Key<Value<WorldBorder>> WORLD_BORDER = Keys.key(ResourceKey.sponge("world_border"), WorldBorder.class);

    /**
     * The difficulty of a {@link WorldTemplate} or {@link WorldProperties}
     * Readonly
     */
    public static final Key<Value<Difficulty>> WORLD_DIFFICULTY = Keys.key(ResourceKey.sponge("world_difficulty"), Difficulty.class);

    /**
     * The minimum {@code Y} coordinate of a {@link WorldType}
     * <p>Blocks cannot exist at a lower {@code Y} value in a {@link ServerWorld} of that type</p>
     * <p>In vanilla this is a multiple of 16 between -2032 and 2016</p>
     * <p>Also see {@link #WORLD_HEIGHT}</p>
     * Readonly
     */
    public static final Key<Value<Integer>> WORLD_FLOOR = Keys.key(ResourceKey.sponge("world_floor"), Integer.class);

    /**
     * The world generation config of a {@link ServerWorldProperties}
     * Readonly
     */
    public static final Key<Value<WorldGenerationConfig>> WORLD_GEN_CONFIG = Keys.key(ResourceKey.sponge("world_gen_config"), WorldGenerationConfig.class);

    /**
     * The height of a {@link WorldType}
     * <p>In vanilla this is a multiple of 16 between 16 and 4064. {@code floor+height} may not be more than 2032</p>
     * <p>Also see {@link #WORLD_FLOOR}</p>
     * Readonly
     */
    public static final Key<Value<Integer>> WORLD_HEIGHT = Keys.key(ResourceKey.sponge("world_floor"), Integer.class);

    /**
     * The logical height of a {@link WorldType}
     * <p>Restricts teleportation via {@link ItemTypes#CHORUS_FRUIT} or {@link PortalType portal types}
     * or portal generation
     * to below the logical height.</p>
     * Readonly
     */
    public static final Key<Value<Integer>> WORLD_LOGICAL_HEIGHT = Keys.key(ResourceKey.sponge("world_logical_height"), Integer.class);

    /**
     * The {@link WorldType} of a {@link WorldTemplate} or {@link ServerWorldProperties}
     * Readonly
     */
    public static final Key<Value<WorldType>> WORLD_TYPE = Keys.key(ResourceKey.sponge("world_type"), WorldType.class);

    /**
     * The {@link WorldTypeEffect effect} of a {@link WorldType} that will play for a {@link ServerPlayer player}
     * in a {@link ServerWorld world} of this type.
     * Readonly
     */
    public static final Key<Value<WorldTypeEffect>> WORLD_TYPE_EFFECT = Keys.key(ResourceKey.sponge("world_type_effect"), WorldTypeEffect.class);

    // SORTFIELDS:OFF

    // @formatter:on

    private static <T> Key<Value<T>> key(final ResourceKey resourceKey, final TypeToken<T> token) {
        return Key.builder().key(resourceKey).elementType(token).build();
    }

    private static <T> Key<Value<T>> key(final ResourceKey resourceKey, final Class<T> type) {
        return Key.builder().key(resourceKey).elementType(type).build();
    }

    private static <T> Key<ListValue<T>> listKey(final ResourceKey resourceKey, final Class<T> elementType) {
        return Key.builder().key(resourceKey).listElementType(elementType).build();
    }

    private static <T> Key<ListValue<T>> listKey(final ResourceKey resourceKey, final TypeToken<T> elementType) {
        return Key.builder().key(resourceKey).listElementType(elementType).build();
    }

    private static <T> Key<SetValue<T>> setKey(final ResourceKey resourceKey, final Class<T> elementType) {
        return Key.builder().key(resourceKey).setElementType(elementType).build();
    }

    private static <T> Key<SetValue<T>> setKey(final ResourceKey resourceKey, final TypeToken<T> elementType) {
        return Key.builder().key(resourceKey).setElementType(elementType).build();
    }

    private static <K, V> Key<MapValue<K, V>> mapKey(final ResourceKey resourceKey, final Class<K> keyType, final Class<V> valueType) {
        return Key.builder().key(resourceKey).mapElementType(keyType, valueType).build();
    }

    private static <K, V> Key<MapValue<K, V>> mapKey(final ResourceKey resourceKey, final TypeToken<K> keyType, final TypeToken<V> valueType) {
        return Key.builder().key(resourceKey).mapElementType(keyType, valueType).build();
    }

    private static <T> Key<WeightedCollectionValue<T>> weightedKey(final ResourceKey resourceKey, final Class<T> elementType) {
        return Key.builder().key(resourceKey).weightedCollectionElementType(elementType).build();
    }

    private static <T> Key<WeightedCollectionValue<T>> weightedKey(final ResourceKey resourceKey, final TypeToken<T> elementType) {
        return Key.builder().key(resourceKey).weightedCollectionElementType(elementType).build();
    }

    private Keys() {
    }
}
