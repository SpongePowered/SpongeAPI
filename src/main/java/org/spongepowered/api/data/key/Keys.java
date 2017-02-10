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
package org.spongepowered.api.data.key;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.tileentity.*;
import org.spongepowered.api.block.tileentity.carrier.*;
import org.spongepowered.api.data.manipulator.mutable.*;
import org.spongepowered.api.data.manipulator.mutable.block.*;
import org.spongepowered.api.data.manipulator.mutable.entity.*;
import org.spongepowered.api.data.manipulator.mutable.item.*;
import org.spongepowered.api.data.manipulator.mutable.tileentity.*;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.property.entity.DominantHandProperty;
import org.spongepowered.api.data.type.*;
import org.spongepowered.api.data.value.immutable.ImmutableBoundedValue;
import org.spongepowered.api.data.value.mutable.*;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.*;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.entity.explosive.FusedExplosive;
import org.spongepowered.api.entity.hanging.ItemFrame;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.*;
import org.spongepowered.api.entity.living.animal.*;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.monster.*;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.projectile.DamagingProjectile;
import org.spongepowered.api.entity.projectile.EnderPearl;
import org.spongepowered.api.entity.projectile.EyeOfEnder;
import org.spongepowered.api.entity.projectile.Firework;
import org.spongepowered.api.entity.projectile.arrow.Arrow;
import org.spongepowered.api.entity.projectile.explosive.fireball.Fireball;
import org.spongepowered.api.entity.vehicle.minecart.CommandBlockMinecart;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.event.entity.SpawnEntityEvent.Spawner;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
import org.spongepowered.api.extra.fluid.data.manipulator.mutable.FluidItemData;
import org.spongepowered.api.extra.fluid.data.manipulator.mutable.FluidTankData;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.achievement.Achievement;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.RespawnLocation;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.weather.Weather;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * An enumeration of known {@link Key}s used throughout the API.
 */
public final class Keys {

    // SORTFIELDS:ON

    /**
     * Represents the {@link Key} for the {@link Achievement}s  earned by a
     * {@link Player}.
     *
     * @see AchievementData#achievements()
     */
    public static final Key<SetValue<Achievement>> ACHIEVEMENTS = KeyFactory.fake("ACHIEVEMENTS");

    /**
     * Represents the {@link Key} for the "affecting spawning" state of
     * {@link Player}s.
     *
     * <p>A {@link Player} who does not affect spawning will be treated as a
     * spectator in regards to spawning. A {@link MobSpawner} will not be
     * activated by his presence and mobs around him may naturally despawn
     * if there is no other Player around who affects spawning.</p>
     *
     * @see AffectsSpawningData#affectsSpawning()
     */
    public static final Key<Value<Boolean>> AFFECTS_SPAWNING = KeyFactory.fake("AFFECTS_SPAWNING");

    /**
     * Represents the {@link Key} for the age of any {@link Ageable} creature
     * in ticks.
     *
     * @see AgeableData#age()
     */
    public static final Key<MutableBoundedValue<Integer>> AGE = KeyFactory.fake("AGE");

    /**
     * Represents the {@link Key} for whether an {@link Agent}s AI is enabled.
     *
     * @see AgentData#aiEnabled()
     */
    public static final Key<Value<Boolean>> AI_ENABLED = KeyFactory.fake("AI_ENABLED");

    /**
     * Represents the {@link Key} for how angry an {@link Entity} is. This
     * applies mostly to {@link ZombiePigman}.
     *
     * <p>Unlike {@link #ANGRY}, the agressiveness represented by this key may
     * fade over time and the entity will become peaceful again once its anger
     * reaches its minimum.</p>
     *
     * @see AngerableData#angerLevel()
     */
    public static final Key<MutableBoundedValue<Integer>> ANGER = KeyFactory.fake("ANGER");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is currently
     * aggressive. This mostly applies to wolves.
     *
     * @see AggressiveData#aggressive()
     */
    public static final Key<Value<Boolean>> ANGRY = KeyFactory.fake("ANGRY");

    /**
     * Represents the {@link Key} for the age (in ticks) of an
     * {@link AreaEffectCloud} created by a lingering potion.
     *
     * @see AreaEffectCloudData#age()
     */
    public static final Key<MutableBoundedValue<Integer>> AREA_EFFECT_CLOUD_AGE = KeyFactory.fake("AREA_EFFECT_CLOUD_AGE");

    /**
     * Represents the {@link Key} for the color of an {@link AreaEffectCloud}
     * created by a lingering potion.
     *
     * @see AreaEffectCloudData#color()
     */
    public static final Key<Value<Color>> AREA_EFFECT_CLOUD_COLOR = KeyFactory.fake("AREA_EFFECT_CLOUD_COLOR");

    /**
     * Represents the {@link Key} for the maximum age (in ticks) of an
     * {@link AreaEffectCloud} created by a lingering potion.
     *
     * @see AreaEffectCloudData#duration()
     */
    public static final Key<MutableBoundedValue<Integer>> AREA_EFFECT_CLOUD_DURATION = KeyFactory.fake("AREA_EFFECT_CLOUD_DURATION");

    /**
     * Represents the {@link Key} for the amount of ticks the duration of an
     * {@link AreaEffectCloud} is increased or reduced when it applies its
     * effect.
     *
     * @see AreaEffectCloudData#durationOnUse()
     */
    public static final Key<MutableBoundedValue<Integer>> AREA_EFFECT_CLOUD_DURATION_ON_USE
            = KeyFactory.fake("AREA_EFFECT_CLOUD_DURATION_ON_USE");

    /**
     * Represents the {@link Key} for the particle type of an
     * {@link AreaEffectCloud} created by a lingering potion.
     *
     * @see AreaEffectCloudData#particleType()
     */
    public static final Key<Value<ParticleType>> AREA_EFFECT_CLOUD_PARTICLE_TYPE = KeyFactory.fake("AREA_EFFECT_CLOUD_PARTICLE_TYPE");

    /**
     * Represents the {@link Key} for the radius of an {@link AreaEffectCloud}.
     *
     * @see AreaEffectCloudData#radius()
     */
    public static final Key<MutableBoundedValue<Double>> AREA_EFFECT_CLOUD_RADIUS = KeyFactory.fake("AREA_EFFECT_CLOUD_RADIUS");

    /**
     * Represents the {@link Key} for the amount the radius of an
     * {@link AreaEffectCloud} grows or shrinks each time it applies its
     * effect.
     *
     * @see AreaEffectCloudData#radiusOnUse()
     */
    public static final Key<MutableBoundedValue<Double>> AREA_EFFECT_CLOUD_RADIUS_ON_USE = KeyFactory.fake("AREA_EFFECT_CLOUD_RADIUS_ON_USE");

    /**
     * Represents the {@link Key} for the amount the radius of an
     * {@link AreaEffectCloud} grows or shrinks per tick.
     *
     * @see AreaEffectCloudData#radiusOnUse()
     */
    public static final Key<MutableBoundedValue<Double>> AREA_EFFECT_CLOUD_RADIUS_PER_TICK
            = KeyFactory.fake("AREA_EFFECT_CLOUD_RADIUS_PER_TICK");

    /**
     * Represents the {@link Key} for the delay (in ticks) after which an
     * {@link AreaEffectCloud} will reapply its effect on a previously
     * affected {@link Entity}.
     *
     * @see AreaEffectCloudData#applicationDelay()
     */
    public static final Key<MutableBoundedValue<Integer>> AREA_EFFECT_CLOUD_REAPPLICATION_DELAY
            = KeyFactory.fake("AREA_EFFECT_CLOUD_REAPPLICATION_DELAY");

    /**
     * Represents the {@link Key} for the duration in ticks after which an
     * {@link AreaEffectCloud} will begin to apply its effect to entities.
     *
     * @see AreaEffectCloudData#waitTime()
     */
    public static final Key<MutableBoundedValue<Integer>> AREA_EFFECT_CLOUD_WAIT_TIME = KeyFactory.fake("AREA_EFFECT_CLOUD_WAIT_TIME");

    /**
     * Represents the {@link Key} for whether an {@link ArmorStand}'s arms are
     * visible.
     *
     * @see ArmorStandData#arms()
     */
    public static final Key<Value<Boolean>> ARMOR_STAND_HAS_ARMS = KeyFactory.fake("ARMOR_STAND_HAS_ARMS");

    /**
     * Represents the {@link Key} for whether an {@link ArmorStand} has a
     * visible base plate.
     *
     * @see ArmorStandData#basePlate()
     */
    public static final Key<Value<Boolean>> ARMOR_STAND_HAS_BASE_PLATE = KeyFactory.fake("ARMOR_STAND_HAS_BASE_PLATE");

    /**
     * Represents the {@link Key} for whether an {@link ArmorStand} is small.
     *
     * @see ArmorStandData#small()
     */
    public static final Key<Value<Boolean>> ARMOR_STAND_IS_SMALL = KeyFactory.fake("ARMOR_STAND_IS_SMALL");

    /**
     * Represents the {@link Key} for whether an {@link ArmorStand} has a
     * significantly smaller collision box in order to act as a marker.
     *
     * @see ArmorStandData#marker()
     */
    public static final Key<Value<Boolean>> ARMOR_STAND_MARKER = KeyFactory.fake("ARMOR_STAND_MARKER");

    /**
     * Represents the {@link Key} for the type of {@link Art} shown by
     * (usually) a {@link Painting}.
     *
     * @see ArtData
     */
    public static final Key<Value<Art>> ART = KeyFactory.fake("ART");

    /**
     * Represents the {@link Key} for representing whether a {@link BlockState}
     * is "attached" to another block.
     *
     * @see AttachedData#attached()
     */
    public static final Key<Value<Boolean>> ATTACHED = KeyFactory.fake("ATTACHED");

    /**
     * Represents the {@link Key} for the damage dealt by a
     * {@link DamagingProjectile}, e.g. an {@link Arrow}.
     *
     * @see DamagingData#damage()
     */
    public static final Key<MutableBoundedValue<Double>> ATTACK_DAMAGE = KeyFactory.fake("ATTACK_DAMAGE");

    /**
     * Represents the {@link Key} for representing the {@link Axis} direction
     * of a {@link BlockState}.
     *
     * @see AxisData
     */
    public static final Key<Value<Axis>> AXIS = KeyFactory.fake("AXIS");

    /**
     * Represents the {@link Key} for a {@link Banner}'s base {@link DyeColor}.
     *
     * @see BannerData#baseColor()
     */
    public static final Key<Value<DyeColor>> BANNER_BASE_COLOR = KeyFactory.fake("BANNER_BASE_COLOR");

    /**
     * Represents the {@link Key} for a {@link Banner}'s patterns.
     *
     * @see BannerData#patternsList()
     */
    public static final Key<PatternListValue> BANNER_PATTERNS = KeyFactory.fake("BANNER_PATTERNS");

    /**
     * Represents the {@link Key} for the width of the physical form of an
     * {@link Entity}.
     *
     * <p>Together with {@link #HEIGHT} this defines the size of an
     * {@link Entity}.</p>
     *
     * @see SizeData#base()
     */
    public static final Key<MutableBoundedValue<Float>> BASE_SIZE = KeyFactory.fake("BASE_SIZE");

    /**
     * Represents the {@link Key} for the base vehicle a passenger is riding
     * at the moment. This may be different from {@link Keys#VEHICLE} as the
     * vehicle an {@link Entity} is riding may itself be the passenger of
     * another vehicle.
     *
     * @see VehicleData#baseVehicle()
     */
    public static final Key<Value<EntitySnapshot>> BASE_VEHICLE = KeyFactory.fake("BASE_VEHICLE");

    /**
     * Represents the {@link Key} for a {@link Beacon}'s primary effect.
     *
     * @see BeaconData#primaryEffect()
     */
    public static final Key<OptionalValue<PotionEffectType>> BEACON_PRIMARY_EFFECT = KeyFactory.fake("BEACON_PRIMARY_EFFECT");

    /**
     * Represents the {@link Key} for a {@link Beacon}'s secondary effect.
     *
     * @see BeaconData#secondaryEffect()
     */
    public static final Key<OptionalValue<PotionEffectType>> BEACON_SECONDARY_EFFECT = KeyFactory.fake("BEACON_SECONDARY_EFFECT");

    /**
     * Represents the {@link Key} for representing the {@link BigMushroomType}
     * of a {@link BlockState}.
     *
     * @see BigMushroomData
     */
    public static final Key<Value<BigMushroomType>> BIG_MUSHROOM_TYPE = KeyFactory.fake("BIG_MUSHROOM_TYPE");

    /**
     * Represents the {@link Key} for the rotation of specific body parts.
     *
     * <p>This value provides a mapping, effectively combining the data
     * referenced by {@link #HEAD_ROTATION}, {@link #CHEST_ROTATION},
     * {@link #RIGHT_ARM_ROTATION}, {@link #LEFT_ARM_ROTATION},
     * {@link #RIGHT_LEG_ROTATION}, and {@link #LEFT_LEG_ROTATION}.</p>
     *
     * @see BodyPartRotationalData#partRotation()
     */
    public static final Key<MapValue<BodyPart, Vector3d>> BODY_ROTATIONS = KeyFactory.fake("BODY_ROTATIONS");

    /**
     * Represents the {@link Key} for the author of a
     * {@link ItemTypes#WRITTEN_BOOK}.
     *
     * @see AuthorData#author()
     */
    public static final Key<Value<Text>> BOOK_AUTHOR = KeyFactory.fake("BOOK_AUTHOR");

    /**
     * Represents the {@link Key} for the content of a
     * {@link ItemTypes#WRITTEN_BOOK}.
     *
     * @see PagedData#pages()
     */
    public static final Key<ListValue<Text>> BOOK_PAGES = KeyFactory.fake("BOOK_PAGES");

    /**
     * Represents the {@link Key} for the {@link BlockType}s able to be broken
     * by an item.
     *
     * @see BreakableData#breakable()
     */
    public static final Key<SetValue<BlockType>> BREAKABLE_BLOCK_TYPES = KeyFactory.fake("BREAKABLE_BLOCK_TYPES");

    /**
     * Represents the {@link Key} for representing the {@link BrickType}
     * of a {@link BlockState}.
     *
     * @see BrickData
     */
    public static final Key<Value<BrickType>> BRICK_TYPE = KeyFactory.fake("BRICK_TYPE");

    /**
     * Represents the {@link Key} for whether an {@link Entity} can breed.
     *
     * @see BreedableData#breedable()
     */
    public static final Key<Value<Boolean>> CAN_BREED = KeyFactory.fake("CAN_BREED");

    /**
     * Represents the {@link Key} for whether a {@link FallingBlock} can drop
     * as an item.
     *
     * @see FallingBlockData#canDropAsItem()
     */
    public static final Key<Value<Boolean>> CAN_DROP_AS_ITEM = KeyFactory.fake("CAN_DROP_AS_ITEM");

    /**
     * Represents the {@link Key} for whether a {@link Humanoid} can fly.
     *
     * <p>For a {@link Player} this means he is able to toggle flight mode by
     * double-tapping his jump button.</p>
     *
     * @see FlyingAbilityData#canFly()
     */
    public static final Key<Value<Boolean>> CAN_FLY = KeyFactory.fake("CAN_FLY");

    /**
     * Represents the {@link Key} for whether a {@link Living} entity may
     * change blocks. This mostly applies to {@link Enderman} or
     * {@link Creeper}s, but also to some projectiles like {@link Fireball}s.
     *
     * @see GriefingData#canGrief()
     */
    public static final Key<Value<Boolean>> CAN_GRIEF = KeyFactory.fake("CAN_GRIEF");

    /**
     * Represents the {@link Key} for whether a {@link FallingBlock} will place
     * itself upon landing.
     *
     * @see FallingBlockData#canPlaceAsBlock()
     */
    public static final Key<Value<Boolean>> CAN_PLACE_AS_BLOCK = KeyFactory.fake("CAN_PLACE_AS_BLOCK");

    /**
     * Represents the {@link Key} for the {@link Villager}'s {@link Career}.
     *
     * @see CareerData
     */
    public static final Key<Value<Career>> CAREER = KeyFactory.fake("CAREER");

    /**
     * Represents the {@link Key} for the rotation of the
     * {@link BodyParts#CHEST}.
     *
     * @see BodyPartRotationalData#bodyRotation()
     */
    public static final Key<Value<Vector3d>> CHEST_ROTATION = KeyFactory.fake("CHEST_ROTATION");

    /**
     * Represents the {@link Key} for the {@link CoalType} of an
     * {@link ItemStack} or {@link ItemStackSnapshot} of type
     * {@link ItemTypes#COAL}.
     *
     * @see CoalData
     */
    public static final Key<Value<CoalType>> COAL_TYPE = KeyFactory.fake("COAL_TYPE");

    /**
     * Represents the {@link Key} for the {@link Color} of an
     * {@link ItemStack}.
     *
     * @see ColoredData#color()
     */
    public static final Key<Value<Color>> COLOR = KeyFactory.fake("COLOR");

    /**
     * Represents a key for the stored command, mostly related to
     * {@link CommandBlock}s and {@link CommandBlockMinecart}s.
     *
     * @see CommandData#storedCommand()
     */
    public static final Key<Value<String>> COMMAND = KeyFactory.fake("COMMAND");

    /**
     * Represents the {@link Key} for representing the {@link ComparatorType}
     * of a {@link BlockState}.
     *
     * @see ComparatorData
     */
    public static final Key<Value<ComparatorType>> COMPARATOR_TYPE = KeyFactory.fake("COMPARATOR_TYPE");

    /**
     * Represents the {@link Key} for representing the connected directions
     * of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedDirections()
     */
    public static final Key<SetValue<Direction>> CONNECTED_DIRECTIONS = KeyFactory.fake("CONNECTED_DIRECTIONS");

    /**
     * Represents the {@link Key} for representing the "connected to the east"
     * of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedEast()
     */
    public static final Key<Value<Boolean>> CONNECTED_EAST = KeyFactory.fake("CONNECTED_EAST");

    /**
     * Represents the {@link Key} for representing the "connected to the north"
     * state of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedNorth()
     */
    public static final Key<Value<Boolean>> CONNECTED_NORTH = KeyFactory.fake("CONNECTED_NORTH");

    /**
     * Represents the {@link Key} for representing the "connected to the south"
     * state of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedSouth()
     */
    public static final Key<Value<Boolean>> CONNECTED_SOUTH = KeyFactory.fake("CONNECTED_SOUTH");

    /**
     * Represents the {@link Key} for representing the "connected to the west"
     * state of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedWest()
     */
    public static final Key<Value<Boolean>> CONNECTED_WEST = KeyFactory.fake("CONNECTED_WEST");

    /**
     * Represents the {@link Key} for the amount of experience points stored
     * by an {@link ExperienceOrb}.
     *
     * @see ExpOrbData#experience()
     */
    public static final Key<MutableBoundedValue<Integer>> CONTAINED_EXPERIENCE = KeyFactory.fake("CONTAINED_EXPERIENCE");

    /**
     * Represents the {@link Key} for the type of {@link CookedFish} an
     * {@link ItemStack} with {@link ItemTypes#COOKED_FISH} has.
     *
     * @see CookedFishData
     */
    public static final Key<Value<CookedFish>> COOKED_FISH = KeyFactory.fake("COOKED_FISH");

    /**
     * Represents the {@link Key} for the amount of ticks a {@link Hopper} has
     * to cool down before transferring the next item.
     *
     * @see CooldownData#cooldown()
     */
    public static final Key<MutableBoundedValue<Integer>> COOLDOWN = KeyFactory.fake("COOLDOWN");

    /**
     * Represents the {@link Key} for whether a {@link Creeper} is charged.
     *
     * @see ChargedData#charged()
     */
    public static final Key<Value<Boolean>> CREEPER_CHARGED = KeyFactory.fake("CREEPER_CHARGED");

    /**
     * Represents the {@link Key} for whether the next attack of an
     * {@link Entity} will be a critical hit.
     *
     * @see CriticalHitData#criticalHit()
     */
    public static final Key<Value<Boolean>> CRITICAL_HIT = KeyFactory.fake("CRITICAL_HIT");

    /**
     * Represents the {@link Key} for whether a custom name is visible on an
     * {@link Entity}.
     *
     * @see CustomNameVisibleData#customNameVisible()
     */
    public static final Key<Value<Boolean>> CUSTOM_NAME_VISIBLE = KeyFactory.fake("CUSTOM_NAME_VISIBLE");

    /**
     * Represents the {@link Key} for the damage dealt towards entities of a
     * specific {@link EntityType}. Types not present in this mapping will be
     * dealt damage to according to {@link #ATTACK_DAMAGE}.
     *
     * @see DamagingData#damageForEntity()
     */
    public static final Key<MapValue<EntityType, Double>> DAMAGE_ENTITY_MAP = KeyFactory.fake("DAMAGE_ENTITY_MAP");

    /**
     * Represents the {@link Key} for representing whether a {@link BlockState}
     * will decay. This usually applies to {@link BlockTypes#LEAVES}.
     *
     * @see DecayableData#decayable()
     */
    public static final Key<Value<Boolean>> DECAYABLE = KeyFactory.fake("DECAYABLE");

    /**
     * Represents the {@link Key} for the delay on a redstone repeater.
     *
     * @see DelayableData#delay()
     */
    public static final Key<MutableBoundedValue<Integer>> DELAY = KeyFactory.fake("DELAY");

    /**
     * Represents the {@link Key} for representing the despawn delay
     * of an {@link Item}.
     *
     * @see DespawnDelayData#delay()
     */
    public static final Key<MutableBoundedValue<Integer>> DESPAWN_DELAY = KeyFactory.fake("DESPAWN_DELAY");

    /**
     * Represents the {@link Key} for representing the {@link Direction}
     * of a {@link BlockState}.
     *
     * @see DirectionalData#direction()
     */
    public static final Key<Value<Direction>> DIRECTION = KeyFactory.fake("DIRECTION");

    /**
     * Represents the {@link Key} for representing the {@link DirtType}
     * of a {@link BlockState}.
     *
     * @see DirtData
     */
    public static final Key<Value<DirtType>> DIRT_TYPE = KeyFactory.fake("DIRT_TYPE");

    /**
     * Represents the {@link Key} for representing the "disarmed" state
     * of a {@link BlockState}. This usually applies to
     * {@link BlockTypes#TRIPWIRE}s and {@link BlockTypes#TRIPWIRE_HOOK}s.
     *
     * @see DisarmedData#disarmed()
     */
    public static final Key<Value<Boolean>> DISARMED = KeyFactory.fake("DISARMED");

    /**
     * Represents the {@link Key} for representing the {@link DisguisedBlockType}
     * of a {@link BlockState}.
     *
     * @see DisguisedBlockData
     */
    public static final Key<Value<DisguisedBlockType>> DISGUISED_BLOCK_TYPE = KeyFactory.fake("DISGUISED_BLOCK_TYPE");

    /**
     * Represents the {@link Key} for the display name of an {@link Entity},
     * {@link ItemStack} or {@link TileEntity}.
     *
     * <p>On a {@link ItemTypes#WRITTEN_BOOK} item this will also set the title
     * of the book.</p>
     *
     * @see DisplayNameData#displayName()
     */
    public static final Key<Value<Text>> DISPLAY_NAME = KeyFactory.fake("DISPLAY_NAME");

    /**
     * Represents the {@link Key} for representing the dominant {@link HandPreference}
     * of a {@link Living} entity.
     *
     * <p><em>NOTE:</em> Does not apply to {@link Player}s as their
     * {@link HandPreference} can not be changed server-side.
     * See {@link DominantHandProperty}.</p>
     *
     * @see DominantHandData#dominantHand()
     */
    public static final Key<Value<HandPreference>> DOMINANT_HAND = KeyFactory.fake("DOMINANT_HAND");

    /**
     * Represents the {@link Key} for representing the {@link DoublePlantType}
     * of a {@link BlockState}.
     *
     * @see DoublePlantData
     */
    public static final Key<Value<DoublePlantType>> DOUBLE_PLANT_TYPE = KeyFactory.fake("DOUBLE_PLANT_TYPE");

    /**
     * Represents the {@link Key} for the color of a dyeable block, item or
     * entity.
     *
     * @see DyeableData
     */
    public static final Key<Value<DyeColor>> DYE_COLOR = KeyFactory.fake("DYE_COLOR");

    /**
     * Represents the {@link Key} for whether a {@link Guardian} is an Elder Guardian.
     *
     * @see ElderData#elder()
     */
    public static final Key<Value<Boolean>> ELDER_GUARDIAN = KeyFactory.fake("ELDER_GUARDIAN");

    /**
     * Represents the {@link Key} for the current level of exhaustion of a
     * {@link Humanoid}.
     *
     * <p>Exhaustion will <em>decrease</em> on activities like walking, running
     * or jumping. Once it reaches 0, the {@link #SATURATION} will decrease and
     * the exhaustion level will be reset to its maximum.</p>
     *
     * @see FoodData#exhaustion()
     */
    public static final Key<MutableBoundedValue<Double>> EXHAUSTION = KeyFactory.fake("EXHAUSTION");

    /**
     * Represents the {@link Key} for the total experience a {@link Player}
     * requires to advance from his current level to the next one.
     *
     * @see ExperienceHolderData#getExperienceBetweenLevels()
     */
    public static final Key<ImmutableBoundedValue<Integer>> EXPERIENCE_FROM_START_OF_LEVEL = KeyFactory.fake("EXPERIENCE_FROM_START_OF_LEVEL");

    /**
     * Represents the {@link Key} for the current level a {@link Player} has.
     *
     * @see ExperienceHolderData#level()
     */
    public static final Key<MutableBoundedValue<Integer>> EXPERIENCE_LEVEL = KeyFactory.fake("EXPERIENCE_LEVEL");

    /**
     * Represents the {@link Key} for the amount of experience a {@link Player}
     * has collected towards the next level.
     *
     * @see ExperienceHolderData#experienceSinceLevel()
     */
    public static final Key<MutableBoundedValue<Integer>> EXPERIENCE_SINCE_LEVEL = KeyFactory.fake("EXPERIENCE_SINCE_LEVEL");

    /**
     * Represents the {@link Key} for after how many ticks an entity or
     * {@link Weather} will last before expiring.
     *
     * <p>Usually applies to {@link Endermite}s or {@link Item}s.</p>
     *
     * @see ExpirableData#expireTicks()
     */
    public static final Key<MutableBoundedValue<Integer>> EXPIRATION_TICKS = KeyFactory.fake("EXPIRATION_TICKS");

    /**
     * Represents the {@link Key} for the radius of the {@link Explosion} to
     * be created by detonating an {@link Explosive}.
     *
     * <p>May be absent if the explosion radius is unknown because it is either
     * determined randomly at the time of the explosion or computed from the
     * context in which the {@link Explosive} explodes.</p>
     *
     * @see ExplosionRadiusData#explosionRadius()
     */
    public static final Key<OptionalValue<Integer>> EXPLOSION_RADIUS = KeyFactory.fake("EXPLOSION_RADIUS");

    /**
     * Represents the {@link Key} for representing whether a {@link Piston} is
     * currently extended.
     *
     * @see ExtendedData#extended()
     */
    public static final Key<Value<Boolean>> EXTENDED = KeyFactory.fake("EXTENDED");

    /**
     * Represents the {@link Key} for whether a {@link FallingBlock} will
     * damage an {@link Entity} it lands on.
     *
     * @see FallingBlockData#canHurtEntities()
     */
    public static final Key<Value<Boolean>> FALLING_BLOCK_CAN_HURT_ENTITIES = KeyFactory.fake("FALLING_BLOCK_CAN_HURT_ENTITIES");

    /**
     * Represents the {@link Key} for the {@link BlockState} of a
     * {@link FallingBlock}.
     *
     * @see FallingBlockData#blockState()
     */
    public static final Key<Value<BlockState>> FALLING_BLOCK_STATE = KeyFactory.fake("FALLING_BLOCK_STATE");

    /**
     * Represents the {@link Key} for how much damage a {@link FallingBlock}
     * deals to {@link Living} entities it hits.
     *
     * <p>This damage is capped by {@link #MAX_FALL_DAMAGE}.</p>
     *
     * @see FallingBlockData#fallDamagePerBlock()
     */
    public static final Key<MutableBoundedValue<Double>> FALL_DAMAGE_PER_BLOCK = KeyFactory.fake("FALL_DAMAGE_PER_BLOCK");

    /**
     * Represents the {@link Key} for representing the distance an entity has
     * fallen.
     *
     * @see FallDistanceData#fallDistance()
     */
    public static final Key<MutableBoundedValue<Float>> FALL_DISTANCE = KeyFactory.fake("FALL_DISTANCE");

    /**
     * Represents the {@link Key} for the amount of ticks a
     * {@link FallingBlock} has been falling for.
     *
     * @see FallingBlockData#fallTime()
     */
    public static final Key<Value<Integer>> FALL_TIME = KeyFactory.fake("FALL_TIME");

    /**
     * Represents the {@link Key} for representing the "filled" state
     * of a {@link BlockState}.
     *
     * <p>Usually applies to {@link BlockTypes#END_PORTAL_FRAME}s.</p>
     *
     * @see FilledData#filled()
     */
    public static final Key<Value<Boolean>> FILLED = KeyFactory.fake("FILLED");

    /**
     * Represents the {@link Key} for the {@link FireworkEffect}s of a
     * {@link ItemTypes#FIREWORK_CHARGE}, {@link ItemTypes#FIREWORKS} or a
     * {@link Firework}.
     *
     * @see FireworkEffectData#effects()
     */
    public static final Key<ListValue<FireworkEffect>> FIREWORK_EFFECTS = KeyFactory.fake("FIREWORK_EFFECTS");

    /**
     * Represents the {@link Key} for the flight duration of a firework.
     *
     * <p>The duration is tiered and will stay partially random. A rocket will
     * fly for roughly {@code modifier * 10 + (random number from 0 to 13)}
     * ticks in Vanilla Minecraft.</p>
     *
     * @see FireworkRocketData#flightModifier()
     */
    public static final Key<MutableBoundedValue<Integer>> FIREWORK_FLIGHT_MODIFIER = KeyFactory.fake("FIREWORK_FLIGHT_MODIFIER");

    /**
     * Represents the {@link Key} for the delay in ticks until the
     * {@link Entity} will be damaged by the fire.
     *
     * @see IgniteableData#fireDelay()
     */
    public static final Key<MutableBoundedValue<Integer>> FIRE_DAMAGE_DELAY = KeyFactory.fake("FIRE_DAMAGE_DELAY");

    /**
     * Represents the {@link Key} for the amount of ticks an
     * {@link Entity} is still burning.
     *
     * @see IgniteableData#fireTicks()
     */
    public static final Key<MutableBoundedValue<Integer>> FIRE_TICKS = KeyFactory.fake("FIRE_TICKS");

    /**
     * Represents the {@link Key} for the time a {@link Player} first played
     * on the Server.
     *
     * @see JoinData#firstPlayed()
     */
    public static final Key<Value<Instant>> FIRST_DATE_PLAYED = KeyFactory.fake("FIRST_DATE_PLAYED");

    /**
     * Represents the {@link Key} for the {@link Fish} type an {@link Item} or
     * {@link ItemStack} may have.
     *
     * <p>Only for {@link ItemTypes#FISH}, for {@link ItemTypes#COOKED_FISH}
     * see {@link #COOKED_FISH}.</p>
     *
     * @see FishData
     */
    public static final Key<Value<Fish>> FISH_TYPE = KeyFactory.fake("FISH_TYPE");

    /**
     * Represents the {@link Key} for representing the
     * {@link FluidStackSnapshot} contained within an item container. Item
     * containers may include buckets and other mod added items.
     *
     * @see FluidItemData#fluid()
     */
    public static final Key<Value<FluidStackSnapshot>> FLUID_ITEM_STACK = KeyFactory.fake("FLUID_ITEM_STACK");

    /**
     * Represents the {@link Key} for representing the "fluid level" state
     * of a {@link BlockState}.
     *
     * @see FluidLevelData#level()
     */
    public static final Key<MutableBoundedValue<Integer>> FLUID_LEVEL = KeyFactory.fake("FLUID_LEVEL");

    /**
     * Represents the {@link Key} for representing the directional tank
     * information.
     *
     * @see FluidTankData#fluids()
     */
    public static final Key<MapValue<Direction, List<FluidStackSnapshot>>> FLUID_TANK_CONTENTS = KeyFactory.fake("FLUID_TANK_CONTENTS");

    /**
     * Represents the {@link Key} for the speed at which an entity flies.
     *
     * @see MovementSpeedData#flySpeed()
     */
    public static final Key<Value<Double>> FLYING_SPEED = KeyFactory.fake("FLYING_SPEED");

    /**
     * Represents the {@link Key} for the food level of a {@link Humanoid}.
     *
     * @see FoodData#foodLevel()
     */
    public static final Key<MutableBoundedValue<Integer>> FOOD_LEVEL = KeyFactory.fake("FOOD_LEVEL");

    /**
     * Represents the {@link Key} for the time a {@link FusedExplosive}'s fuse
     * will burn before the explosion.
     *
     * @see FuseData#fuseDuration()
     */
    public static final Key<Value<Integer>> FUSE_DURATION = KeyFactory.fake("FUSE_DURATION");

    /**
     * Represents the {@link Key} for the {@link GameMode} a {@link Humanoid}
     * has.
     *
     * @see GameModeData
     */
    public static final Key<Value<GameMode>> GAME_MODE = KeyFactory.fake("GAME_MODE");

    /**
     * Represents the {@link Key} for the generation of a
     * {@link ItemTypes#WRITTEN_BOOK}. Depending on the book's generation
     * it may be impossible to copy it.
     *
     * @see GenerationData#generation()
     */
    public static final Key<MutableBoundedValue<Integer>> GENERATION = KeyFactory.fake("GENERATION");

    /**
     * Represents the {@link Key} for representing whether an entity has a
     * glowing outline.
     *
     * @see GlowingData#glowing()
     */
    public static final Key<Value<Boolean>> GLOWING = KeyFactory.fake("GLOWING");

    /**
     * Represents the {@link Key} for the type of a
     * {@link ItemTypes#GOLDEN_APPLE}.
     *
     * @see GoldenAppleData
     */
    public static final Key<Value<GoldenApple>> GOLDEN_APPLE_TYPE = KeyFactory.fake("GOLDEN_APPLE_TYPE");

    /**
     * Represents the {@link Key} for representing the "growth stage" state
     * of a {@link BlockState}.
     *
     * @see GrowthData#growthStage()
     */
    public static final Key<MutableBoundedValue<Integer>> GROWTH_STAGE = KeyFactory.fake("GROWTH_STAGE");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is affected by
     * gravity.
     *
     * @see GravityData#gravity()
     */
    public static final Key<Value<Boolean>> HAS_GRAVITY = KeyFactory.fake("HAS_GRAVITY");

    /**
     * Represents the {@link Key} for the direction an entities head is
     * rotated to.
     *
     * @see BodyPartRotationalData#headDirection()
     */
    public static final Key<Value<Vector3d>> HEAD_ROTATION = KeyFactory.fake("HEAD_ROTATION");

    /**
     * Represents the {@link Key} for a {@link Living}'s current health.
     *
     * @see HealthData#health()
     */
    public static final Key<MutableBoundedValue<Double>> HEALTH = KeyFactory.fake("HEALTH");

    /**
     * Represents the {@link Key} for how much health a half-heart on a
     * {@link Player}'s GUI will stand for.
     *
     * @see HealthScalingData#healthScale()
     */
    public static final Key<MutableBoundedValue<Double>> HEALTH_SCALE = KeyFactory.fake("HEALTH_SCALE");

    /**
     * Represents the {@link Key} for the height of the physical form of an
     * {@link Entity}.
     *
     * <p>Together with {@link #BASE_SIZE} this defines the size of an
     * {@link Entity}.</p>
     *
     * @see SizeData#height()
     */
    public static final Key<MutableBoundedValue<Float>> HEIGHT = KeyFactory.fake("HEIGHT");

    /**
     * Represents the {@link Key} for the amount of experience points stored
     * by an {@link ExperienceOrb}.
     *
     * @deprecated Use {@link Keys#CONTAINED_EXPERIENCE} instead. This key has
     *     no effect and will be removed in a future release.
     */
    @Deprecated
    public static final Key<MutableBoundedValue<Integer>> HELD_EXPERIENCE = KeyFactory.fake("HELD_EXPERIENCE");

    /**
     * Represents the {@link Key} for representing the "attributes hidden"
     * state of an {@link ItemStack}.
     *
     * @see HideData#hideAttributes()
     */
    public static final Key<Value<Boolean>> HIDE_ATTRIBUTES = KeyFactory.fake("HIDE_ATTRIBUTES");

    /**
     * Represents the {@link Key} for representing the "can destroy hidden"
     * state of an {@link ItemStack}.
     *
     * @see HideData#hideCanDestroy()
     */
    public static final Key<Value<Boolean>> HIDE_CAN_DESTROY = KeyFactory.fake("HIDE_CAN_DESTROY");

    /**
     * Represents the {@link Key} for representing the "can place hidden"
     * state of an {@link ItemStack}.
     *
     * @see HideData#hideCanPlace()
     */
    public static final Key<Value<Boolean>> HIDE_CAN_PLACE = KeyFactory.fake("HIDE_CAN_PLACE");

    /**
     * Represents the {@link Key} for representing the "enchantments hidden"
     * state of an {@link ItemStack}.
     *
     * @see HideData#hideEnchantments()
     */
    public static final Key<Value<Boolean>> HIDE_ENCHANTMENTS = KeyFactory.fake("HIDE_ENCHANTMENTS");

    /**
     * Represents the {@link Key} for representing the "miscellaneous hidden"
     * state of an {@link ItemStack}.
     *
     * @see HideData#hideMiscellaneous()
     */
    public static final Key<Value<Boolean>> HIDE_MISCELLANEOUS = KeyFactory.fake("HIDE_MISCELLANEOUS");

    /**
     * Represents the {@link Key} for representing the "unbreakable hidden"
     * state of an {@link ItemStack}.
     *
     * @see HideData#hideUnbreakable()
     */
    public static final Key<Value<Boolean>> HIDE_UNBREAKABLE = KeyFactory.fake("HIDE_UNBREAKABLE");

    /**
     * Represents the {@link Key} for representing the {@link Hinge}
     * of a {@link BlockState}.
     *
     * @see HingeData
     */
    public static final Key<Value<Hinge>> HINGE_POSITION = KeyFactory.fake("HINGE_POSITION");

    /**
     * Represents the {@link Key} for the color of a {@link Horse}.
     *
     * <p>In Vanilla, this will have no effect unless {@link #HORSE_VARIANT}
     * is {@link HorseVariants#HORSE}.</p>
     *
     * @see HorseData#color()
     */
    public static final Key<Value<HorseColor>> HORSE_COLOR = KeyFactory.fake("HORSE_COLOR");

    /**
     * Represents the {@link Key} for the style of a {@link Horse}.
     *
     * <p>In Vanilla, this will have no effect unless {@link #HORSE_VARIANT}
     * is {@link HorseVariants#HORSE}.</p>
     *
     * @see HorseData#style()
     */
    public static final Key<Value<HorseStyle>> HORSE_STYLE = KeyFactory.fake("HORSE_STYLE");

    /**
     * Represents the {@link Key} for the variant of a {@link Horse}.
     *
     * @see HorseData#variant()
     */
    public static final Key<Value<HorseVariant>> HORSE_VARIANT = KeyFactory.fake("HORSE_VARIANT");

    /**
     * Represents the {@link Key} for whether an {@link Item} will not despawn
     * for an infinite time.
     *
     * @see DespawnDelayData#infinite()
     */
    public static final Key<Value<Boolean>> INFINITE_DESPAWN_DELAY = KeyFactory.fake("INFINITE_DESPAWN_DELAY");

    /**
     * Represents the {@link Key} for representing the "is infinite" state
     * of the pickup delay of an {@link Item}.
     *
     * @see PickupDelayData#infinite()
     */
    public static final Key<Value<Boolean>> INFINITE_PICKUP_DELAY = KeyFactory.fake("INFINITE_PICKUP_DELAY");

    /**
     * Represents the {@link Key} for representing the "vanish" state
     * of an {@link Entity}. This will only simply render the entity as
     * vanish, but not prevent any entity updates being sent to clients.
     * To fully "vanish" an {@link Entity}, use {@link #VANISH}.
     *
     * @see InvisibilityData#invisible()
     */
    public static final Key<Value<Boolean>> INVISIBLE = KeyFactory.fake("INVISIBLE");

    /**
     * Represents the {@link Key} for the amount of ticks an {@link Entity}
     * will remain invulnerable for.
     *
     * @see InvulnerabilityData#invulnerableTicks()
     */
    public static final Key<MutableBoundedValue<Integer>> INVULNERABILITY_TICKS = KeyFactory.fake("INVULNERABILITY_TICKS");

    /**
     * Represents the {@link Key} for representing the "in-wall" state of
     * {@link BlockTypes#FENCE}s.
     *
     * @see InWallData#inWall()
     */
    public static final Key<Value<Boolean>> IN_WALL = KeyFactory.fake("IN_WALL");

    /**
     * Represents the {@link Key} for whether a {@link Blaze} is currently
     * burning.
     *
     * <p>Unlike {@link #MAX_BURN_TIME}, the burning effect will not damage
     * the burning entity.</p>
     *
     * @see FlammableData#flammable()
     */
    public static final Key<Value<Boolean>> IS_AFLAME = KeyFactory.fake("IS_AFLAME");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is flying.
     *
     * <p>This key only tells whether an entity is flying at the moment. On a
     * {@link Player} it does not necessarily mean that the player may toggle
     * freely between flying and walking. To check whether a player may switch
     * his flying state, check {@link #CAN_FLY}.</p>
     *
     * @see FlyingData#flying()
     */
    public static final Key<Value<Boolean>> IS_FLYING = KeyFactory.fake("IS_FLYING");

    /**
     * Represents the {@link Key} for whether a {@link Villager} is playing.
     *
     * <p>In Vanilla, this only applies to villagers that are considered
     * "babies" according to {@link #AGE}.</p>
     *
     * @see PlayingData#playing()
     */
    public static final Key<Value<Boolean>> IS_PLAYING = KeyFactory.fake("IS_PLAYING");

    /**
     * Represents the {@link Key} for whether an {@link Enderman} is screaming.
     *
     * @see ScreamingData#screaming()
     */
    public static final Key<Value<Boolean>> IS_SCREAMING = KeyFactory.fake("IS_SCREAMING");

    /**
     * Represents the {@link Key} for whether a {@link Sheep} is sheared.
     *
     * @see ShearedData#sheared()
     */
    public static final Key<Value<Boolean>> IS_SHEARED = KeyFactory.fake("IS_SHEARED");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is silent.
     *
     * <p>A silent entity will not emit sounds or make noises.</p>
     *
     * @see SilentData#silent()
     */
    public static final Key<Value<Boolean>> IS_SILENT = KeyFactory.fake("IS_SILENT");

    /**
     * Represents the {@link Key} for whether a {@link Wolf} or {@link Ocelot}
     * is sitting.
     *
     * @see SittingData#sitting()
     */
    public static final Key<Value<Boolean>> IS_SITTING = KeyFactory.fake("IS_SITTING");

    /**
     * Represents the {@link Key} for whether a {@link Bat} or {@link Player}
     * is sleeping.
     *
     * <p>If a player is considered sleeping as per this data value, he does
     * not need to be in bed in order for the other players to be able to
     * advance through the night by going to bed.</p>
     *
     * @see SleepingData#sleeping()
     */
    public static final Key<Value<Boolean>> IS_SLEEPING = KeyFactory.fake("IS_SLEEPING");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is sneaking.
     *
     * <p>Sneaking entities generally move slower and do not make walking
     * sounds.</p>
     *
     * @see SneakingData#sneaking()
     */
    public static final Key<Value<Boolean>> IS_SNEAKING = KeyFactory.fake("IS_SNEAKING");

    /**
     * Represents the {@link Key} for whether an {@link Entity} is sprinting.
     *
     * @see SprintData#sprinting()
     */
    public static final Key<Value<Boolean>> IS_SPRINTING = KeyFactory.fake("IS_SPRINTING");

    /**
     * Represents the {@link Key} for whether a {@link Wolf}, a
     * {@link BlockState} of {@link BlockTypes#SPONGE} or an {@link ItemStack}
     * of {@link ItemTypes#SPONGE} is wet.
     *
     * @see WetData#wet()
     */
    public static final Key<Value<Boolean>> IS_WET = KeyFactory.fake("IS_WET");

    /**
     * Represents the {@link Key} for the {@link BlockState} represented by
     * an {@link ItemStack}.
     *
     * @see BlockItemData#state()
     */
    public static final Key<Value<BlockState>> ITEM_BLOCKSTATE = KeyFactory.fake("ITEM_BLOCKSTATE");

    /**
     * Represents the {@link Key} for the durability of an {@link ItemStack}.
     *
     * @see DurabilityData#durability()
     */
    public static final Key<MutableBoundedValue<Integer>> ITEM_DURABILITY = KeyFactory.fake("ITEM_DURABILITY");

    /**
     * Represents the {@link Key} for the enchantments applied to an
     * {@link ItemStack}.
     *
     * <p>This data is usually applicable to all types of armor, weapons and
     * tools. Enchantments that are only stored on an item stack in order to
     * be transferred to another item (like on
     * {@link ItemTypes#ENCHANTED_BOOK}s) use the {@link #STORED_ENCHANTMENTS}
     * key instead.</p>
     *
     * @see EnchantmentData#enchantments()
     */
    public static final Key<ListValue<ItemEnchantment>> ITEM_ENCHANTMENTS = KeyFactory.fake("ITEM_ENCHANTMENTS");

    /**
     * Represents the {@link Key} for the displayed decrption ("lore") text of
     * an {@link ItemStack}.
     *
     * <p>The lore text is usually displayed when the player hovers his cursor
     * over the stack. For the contents of a book see {@link #BOOK_PAGES}
     * instead.</p>
     *
     * @see LoreData#lore()
     */
    public static final Key<ListValue<Text>> ITEM_LORE = KeyFactory.fake("ITEM_LORE");

    /**
     * Represents the {@link Key} for the knockback strength applied by an
     * {@link Arrow}.
     *
     * <p>For the knockback provided by hits with a weapon according to the
     * enchantment of the same name, see {@link #ITEM_ENCHANTMENTS}.</p>
     *
     * @see KnockbackData#knockbackStrength()
     */
    public static final Key<MutableBoundedValue<Integer>> KNOCKBACK_STRENGTH = KeyFactory.fake("KNOCKBACK_STRENGTH");

    /**
     * Represents the {@link Key} for who last attacked an {@link Entity}.
     *
     * @see DamageableData#lastAttacker()
     */
    public static final Key<OptionalValue<Living>> LAST_ATTACKER = KeyFactory.fake("LAST_ATTACKER");

    /**
     * Represents the {@link Key} for the output yielded by the last command of
     * a {@link CommandBlock}.
     *
     * @see CommandData#lastOutput()
     */
    public static final Key<OptionalValue<Text>> LAST_COMMAND_OUTPUT = KeyFactory.fake("LAST_COMMAND_OUTPUT");

    /**
     * Represents the {@link Key} for the last amount of damage received by an
     * {@link Entity}.
     *
     * @see DamageableData#lastDamage()
     */
    public static final Key<OptionalValue<Double>> LAST_DAMAGE = KeyFactory.fake("LAST_DAMAGE");

    /**
     * Represents the {@link Key} for the last time a {@link User} has been
     * playing on the server.
     *
     * @see JoinData#lastPlayed()
     */
    public static final Key<Value<Instant>> LAST_DATE_PLAYED = KeyFactory.fake("LAST_DATE_PLAYED");

    /**
     * Represents the {@link Key} for representing the "layer" value of
     * {@link BlockTypes#SNOW_LAYER} and other possible layered blocks.
     *
     * @see LayeredData#layer()
     */
    public static final Key<MutableBoundedValue<Integer>> LAYER = KeyFactory.fake("LAYER");

    /**
     * Represents the {@link Key} for who holds the leash an {@link Entity} is
     * on.
     *
     * @see LeashData#leashHolder()
     * @deprecated The type of this key will change to
     *     {@code Key<Value<Entity>>} in a future release.
     */
    @Deprecated
    public static final Key<Value<EntitySnapshot>> LEASH_HOLDER = KeyFactory.fake("LEASH_HOLDER");

    /**
     * Represents the {@link Key} for the rotation of an {@link Entity}'s left
     * arm.
     *
     * @see BodyPartRotationalData#leftArmDirection()
     */
    public static final Key<Value<Vector3d>> LEFT_ARM_ROTATION = KeyFactory.fake("LEFT_ARM_ROTATION");

    /**
     * Represents the {@link Key} for the rotation of an {@link Entity}'s left
     * leg.
     *
     * @see BodyPartRotationalData#leftLegDirection()
     */
    public static final Key<Value<Vector3d>> LEFT_LEG_ROTATION = KeyFactory.fake("LEFT_LEG_ROTATION");

    /**
     * Represents the {@link Key} for the token used to lock a
     * {@link TileEntityCarrier}.
     *
     * @see LockableData#lockToken()
     */
    public static final Key<Value<String>> LOCK_TOKEN = KeyFactory.fake("LOCK_TOKEN");

    /**
     * Represents the {@link Key} for the axis of a {@link BlockTypes#LOG}.
     *
     * <p>It differs from {@link #AXIS} in that a log axis may also be
     * {@link LogAxes#NONE}.</p>
     *
     * @see LogAxisData
     */
    public static final Key<Value<LogAxis>> LOG_AXIS = KeyFactory.fake("LOG_AXIS");

    /**
     * Represents the {@link Key} for the maximum air supply a {@link Living}
     * may have.
     *
     * <p>For the current amount of air, check {@link #REMAINING_AIR}.</p>
     *
     * @see BreathingData#maxAir()
     */
    public static final Key<MutableBoundedValue<Integer>> MAX_AIR = KeyFactory.fake("MAX_AIR");

    /**
     * Represents the {@link Key} for the maximum amount of ticks a
     * {@link Furnace} can burn with the currently used fuel item.
     *
     * @see FurnaceData#maxBurnTime()
     */
    public static final Key<MutableBoundedValue<Integer>> MAX_BURN_TIME = KeyFactory.fake("MAX_BURN_TIME");

    /**
     * Represents the {@link Key} for the total time the current
     * {@link ItemStack} in a {@link Furnace} has to be cooked.
     *
     * @see FurnaceData#maxCookTime()
     */
    public static final Key<MutableBoundedValue<Integer>> MAX_COOK_TIME = KeyFactory.fake("MAX_COOK_TIME");

    /**
     * Represents the {@link Key} for the maximum damage a {@link FallingBlock}
     * can deal.
     *
     * @see FallingBlockData#maxFallDamage()
     */
    public static final Key<MutableBoundedValue<Double>> MAX_FALL_DAMAGE = KeyFactory.fake("MAX_FALL_DAMAGE");

    /**
     * Represents the {@link Key} for the maximum health of a {@link Living}.
     *
     * @see HealthData#maxHealth()
     */
    public static final Key<MutableBoundedValue<Double>> MAX_HEALTH = KeyFactory.fake("MAX_HEALTH");

    /**
     * Represents the {@link Key} for representing the "moisture" state of
     * {@link BlockTypes#FARMLAND}.
     *
     * @see MoistureData#moisture()
     */
    public static final Key<MutableBoundedValue<Integer>> MOISTURE = KeyFactory.fake("MOISTURE");

    /**
     * Represents the {@link Key} for the pitch of a {@link Note} block.
     *
     * @see NoteData#note()
     */
    public static final Key<Value<NotePitch>> NOTE_PITCH = KeyFactory.fake("NOTE_PITCH");

    /**
     * Represents the {@link Key} for representing the "occupied" state of
     * {@link BlockTypes#BED}.
     *
     * @see OccupiedData#occupied()
     */
    public static final Key<Value<Boolean>> OCCUPIED = KeyFactory.fake("OCCUPIED");

    /**
     * Represents the {@link Key} for the type of an {@link Ocelot}.
     *
     * @see OcelotData
     */
    public static final Key<Value<OcelotType>> OCELOT_TYPE = KeyFactory.fake("OCELOT_TYPE");

    /**
     * Represents the {@link Key} for representing a block's offset when inside
     * a {@link Minecart}.
     *
     * @see MinecartBlockData#offset()
     */
    public static final Key<Value<Integer>> OFFSET = KeyFactory.fake("OFFSET");

    /**
     * Represents the {@link Key} for representing the "open" state of
     * various door typed blocks.
     *
     * @see OpenData#open()
     */
    public static final Key<Value<Boolean>> OPEN = KeyFactory.fake("OPEN");

    /**
     * Represents the {@link Key} for the amount of ticks a {@link Furnace} has
     * already been burning with the current fuel item.
     *
     * <p>Once this value reaches the one of {@link #MAX_BURN_TIME}, the
     * furnace will require more fuel in order to keep burning.</p>
     *
     * @see FurnaceData#passedBurnTime()
     */
    public static final Key<MutableBoundedValue<Integer>> PASSED_BURN_TIME = KeyFactory.fake("PASSED_BURN_TIME");

    /**
     * Represents the {@link Key} for the amount of ticks a {@link Furnace} has
     * been cooking the current item for.
     *
     * <p>Once this value reaches the one of {@link #MAX_COOK_TIME}, the
     * item will be finished cooking.</p>
     *
     * @see FurnaceData#passedCookTime()
     */
    public static final Key<MutableBoundedValue<Integer>> PASSED_COOK_TIME = KeyFactory.fake("PASSED_COOK_TIME");

    /**
     * Represents the {@link Key} for the entities that act as passengers for
     * an {@link Entity}.
     *
     * <p>For example, a {@link Player} riding on a {@link Horse} or a
     * {@link Pig} would be considered its passenger.</p>
     *
     * @see PassengerData#passengers()
     */
    public static final Key<ListValue<EntitySnapshot>> PASSENGERS = KeyFactory.fake("PASSENGERS");

    /**
     * Represents the {@link Key} for whether an {@link Entity} will be
     * prevented from despawning.
     *
     * <p>In Vanilla, entities may despawn if the player moves too far from
     * them. A persisting entity will not be removed due to no players being
     * near it.</p>
     *
     * @see PersistingData#persists()
     */
    public static final Key<Value<Boolean>> PERSISTS = KeyFactory.fake("PERSISTS");

    /**
     * Represents the {@link Key} for representing the pickup delay
     * of an {@link Item}.
     *
     * @see PickupDelayData#delay()
     */
    public static final Key<MutableBoundedValue<Integer>> PICKUP_DELAY = KeyFactory.fake("PICKUP_DELAY");

    /**
     * Represents the {@link Key} for the "pickup rule" of an {@link Arrow}.
     *
     * @see PickupRuleData
     */
    public static final Key<Value<PickupRule>> PICKUP_RULE = KeyFactory.fake("PICKUP_RULE");

    /**
     * Represents the {@link Key} for whether a {@link Pig} is saddled.
     *
     * @see PigSaddleData#saddle()
     */
    public static final Key<Value<Boolean>> PIG_SADDLE = KeyFactory.fake("PIG_SADDLE");

    /**
     * Represents the {@link Key} for representing the {@link PistonType}
     * of a {@link BlockTypes#PISTON}.
     *
     * @see PistonData
     */
    public static final Key<Value<PistonType>> PISTON_TYPE = KeyFactory.fake("PISTON_TYPE");

    /**
     * Represents the {@link Key} for which block types an {@link ItemStack}
     * may be placed on.
     *
     * @see PlaceableData#placeable()
     */
    public static final Key<SetValue<BlockType>> PLACEABLE_BLOCKS = KeyFactory.fake("PLACEABLE_BLOCKS");

    /**
     * Represents the {@link Key} for representing the {@link PlantType}
     * of a {@link BlockState}.
     *
     * @see PlantData
     */
    public static final Key<Value<PlantType>> PLANT_TYPE = KeyFactory.fake("PLANT_TYPE");

    /**
     * Represents the {@link Key} for whether an {@link IronGolem} has been
     * created by a {@link Player}.
     *
     * @see PlayerCreatedData#playerCreated()
     */
    public static final Key<Value<Boolean>> PLAYER_CREATED = KeyFactory.fake("PLAYER_CREATED");

    /**
     * Represents the {@link Key} for representing the {@link PortionType}
     * of a {@link BlockState}.
     *
     * @see PortionData
     */
    public static final Key<Value<PortionType>> PORTION_TYPE = KeyFactory.fake("PORTION_TYPE");

    /**
     * Represents the {@link Key} for which potion effects are present on an
     * {@link Entity} or stored on an {@link ItemStack}.
     *
     * @see PotionEffectData#effects()
     */
    public static final Key<ListValue<PotionEffect>> POTION_EFFECTS = KeyFactory.fake("POTION_EFFECTS");

    /**
     * Represents the {@link Key} for representing the "power" state
     * of a {@link BlockState}.
     *
     * <p>Applies to blocks that may emit a Redstone signal of variable
     * strength, such as {@link BlockTypes#REDSTONE_WIRE},
     * {@link BlockTypes#DAYLIGHT_DETECTOR},
     * {@link BlockTypes#LIGHT_WEIGHTED_PRESSURE_PLATE} etc.</p>
     *
     * @see RedstonePoweredData#power()
     */
    public static final Key<MutableBoundedValue<Integer>> POWER = KeyFactory.fake("POWER");

    /**
     * Represents the {@link Key} for representing the "powered" state
     * of a {@link BlockState}.
     *
     * <p>Applies to blocks that may be powered in order to emit a
     * Redstone signal of consistently maximum strength, such as
     * {@link BlockTypes#LEVER}, {@link BlockTypes#WOODEN_BUTTON},
     * {@link BlockTypes#WOODEN_PRESSURE_PLATE}, and their stone
     * counterparts.</p>
     *
     * @see PoweredData#powered()
     */
    public static final Key<Value<Boolean>> POWERED = KeyFactory.fake("POWERED");

    /**
     * Represents the {@link Key} for representing the {@link PrismarineType}
     * of a {@link BlockState}.
     *
     * @see PrismarineData
     */
    public static final Key<Value<PrismarineType>> PRISMARINE_TYPE = KeyFactory.fake("PRISMARINE_TYPE");

    /**
     * Represents the {@link Key} for representing the {@link QuartzType}
     * of a {@link BlockState}.
     *
     * @see QuartzData
     */
    public static final Key<Value<QuartzType>> QUARTZ_TYPE = KeyFactory.fake("QUARTZ_TYPE");

    /**
     * Represents the {@link Key} for the type of a {@link Rabbit}.
     *
     * @see RabbitData
     */
    public static final Key<Value<RabbitType>> RABBIT_TYPE = KeyFactory.fake("RABBIT_TYPE");

    /**
     * Represents the {@link Key} for representing the {@link RailDirection}
     * of a {@link BlockState}.
     *
     * @see RailDirectionData
     */
    public static final Key<Value<RailDirection>> RAIL_DIRECTION = KeyFactory.fake("RAIL_DIRECTION");

    /**
     * Represents the {@link Key} for how much air a {@link Living} has left.
     *
     * @see BreathingData#remainingAir()
     */
    public static final Key<MutableBoundedValue<Integer>> REMAINING_AIR = KeyFactory.fake("REMAINING_AIR");

    /**
     * Represents the {@link Key} for how many more ticks the current brewing
     * process of a {@link BrewingStand} will take.
     *
     * <p>If nothing is being brewed, the remaining brew time will be 0.</p>
     *
     * @see BrewingStandData#remainingBrewTime()
     */
    public static final Key<MutableBoundedValue<Integer>> REMAINING_BREW_TIME = KeyFactory.fake("REMAINING_BREW_TIME");

    /**
     * Represents the {@link Key} for representing the {@link BlockState}
     * inside a {@link Minecart}.
     *
     * @see MinecartBlockData#block()
     */
    public static final Key<Value<BlockState>> REPRESENTED_BLOCK = KeyFactory.fake("REPRESENTED_BLOCK");

    /**
     * Represents the {@link Key} for the item displayed in an
     * {@link ItemFrame}.
     *
     * @see RepresentedItemData#item()
     */
    public static final Key<Value<ItemStackSnapshot>> REPRESENTED_ITEM = KeyFactory.fake("REPRESENTED_ITEM");

    /**
     * Represents the {@link Key} for the player represented by a
     * {@link BlockTypes#SKULL} block or a {@link ItemTypes#SKULL} item stack.
     *
     * <p>This will have no effect unless the {@link #SKULL_TYPE} is set to
     * {@link SkullTypes#PLAYER}.</p>
     *
     * @see RepresentedPlayerData#owner()
     */
    public static final Key<Value<GameProfile>> REPRESENTED_PLAYER = KeyFactory.fake("REPRESENTED_PLAYER");

    /**
     * Represents the {@link Key} for the spawn locations a {@link Player}
     * may have for various worlds based on {@link UUID} of the world.
     *
     * @see RespawnLocationData#respawnLocation()
     */
    public static final Key<MapValue<UUID, RespawnLocation>> RESPAWN_LOCATIONS = KeyFactory.fake("RESPAWN_LOCATIONS");

    /**
     * Represents the {@link Key} for the rotation of an {@link Entity}'s right
     * arm.
     *
     * @see BodyPartRotationalData#rightArmDirection()
     */
    public static final Key<Value<Vector3d>> RIGHT_ARM_ROTATION = KeyFactory.fake("RIGHT_ARM_ROTATION");

    /**
     * Represents the {@link Key} for the rotation of an {@link Entity}'s right
     * leg.
     *
     * @see BodyPartRotationalData#rightLegDirection()
     */
    public static final Key<Value<Vector3d>> RIGHT_LEG_ROTATION = KeyFactory.fake("RIGHT_LEG_ROTATION");

    /**
     * Represents the {@link Key} for the {@link Rotation} of a block or an
     * {@link ItemFrame}.
     *
     * @see RotationalData
     */
    public static final Key<Value<Rotation>> ROTATION = KeyFactory.fake("ROTATION");

    /**
     * Represents the {@link Key} for representing the {@link SandstoneType}
     * of a {@link BlockState}.
     *
     * @see SandstoneData
     */
    public static final Key<Value<SandstoneType>> SANDSTONE_TYPE = KeyFactory.fake("SANDSTONE_TYPE");

    /**
     * Represents the {@link Key} for representing the {@link SandType}
     * of a {@link BlockState}.
     *
     * @see SandData
     */
    public static final Key<Value<SandType>> SAND_TYPE = KeyFactory.fake("SAND_TYPE");

    /**
     * Represents the {@link Key} for the current saturation of a {@link Living}.
     *
     * <p>When the saturation reaches 0, the {@link #FOOD_LEVEL} will decrease
     * and the saturation will be reset to maximum.</p>
     *
     * @see FoodData#saturation()
     */
    public static final Key<MutableBoundedValue<Double>> SATURATION = KeyFactory.fake("SATURATION");

    /**
     * Represents the {@link Key} for the "scale" for the size of an
     * {@link Entity}.
     *
     * @see SizeData#scale()
     */
    public static final Key<MutableBoundedValue<Float>> SCALE = KeyFactory.fake("SCALE");

    /**
     * Represents the {@link Key} for representing the "seamless" state
     * of a {@link BlockState}.
     *
     * @see SeamlessData#seamless()
     */
    public static final Key<Value<Boolean>> SEAMLESS = KeyFactory.fake("SEAMLESS");

    /**
     * Represents the {@link Key} for representing the "should drop" state
     * of a {@link BlockState}.
     *
     * @see DropData#willDrop()
     */
    public static final Key<Value<Boolean>> SHOULD_DROP = KeyFactory.fake("SHOULD_DROP");

    /**
     * Represents the {@link Key} for representing the {@link ShrubType}
     * of a {@link BlockState}.
     *
     * @see ShrubData
     */
    public static final Key<Value<ShrubType>> SHRUB_TYPE = KeyFactory.fake("SHRUB_TYPE");

    /**
     * Represents the {@link Key} for the lines displayed on a {@link Sign}.
     *
     * @see SignData#lines()
     */
    public static final Key<ListValue<Text>> SIGN_LINES = KeyFactory.fake("SIGN_LINES");

    /**
     * Represents the {@link Key} for the type of a {@link Skeleton}.
     *
     * @see SkeletonData
     */
    public static final Key<Value<SkeletonType>> SKELETON_TYPE = KeyFactory.fake("SKELETON_TYPE");

    /**
     * Represents the {@link Key} for the skin of a {@link Humanoid}.
     *
     * <p>Skins can only be manipulated by supplying the UUID of a player
     * having that skin. The binary skin data is signed by Mojang so fully
     * customized skins are not possible.</p>
     *
     * @see SkinData#skinUniqueId()
     */
    public static final Key<Value<UUID>> SKIN_UNIQUE_ID = KeyFactory.fake("SKIN_UNIQUE_ID");

    /**
     * Represents the {@link Key} for the type of skull a block or item stack
     * has.
     *
     * @see SkullData
     */
    public static final Key<Value<SkullType>> SKULL_TYPE = KeyFactory.fake("SKULL_TYPE");

    /**
     * Represents the {@link Key} for representing the {@link SlabType}
     * of a {@link BlockState}.
     *
     * @see SlabData
     */
    public static final Key<Value<SlabType>> SLAB_TYPE = KeyFactory.fake("SLAB_TYPE");

    /**
     * Represents the {@link Key} for the size of a {@link Slime}.
     *
     * @see SlimeData#size()
     */
    public static final Key<MutableBoundedValue<Integer>> SLIME_SIZE = KeyFactory.fake("SLIME_SIZE");

    /**
     * Represents the {@link Key} for representing the "snowed" state
     * of a {@link BlockState}.
     *
     * @see SnowedData#hasSnow()
     */
    public static final Key<Value<Boolean>> SNOWED = KeyFactory.fake("SNOWED");

    /**
     * Represents the {@link Key} for the entity type spawned by an
     * {@link ItemStack} of the type {@link ItemTypes#SPAWN_EGG}.
     *
     * <p>For the type of entity spawned by a {@link Spawner}, see {@link #SPAWNER_ENTITIES}.</p>
     *
     * @see SpawnableData
     */
    public static final Key<Value<EntityType>> SPAWNABLE_ENTITY_TYPE = KeyFactory.fake("SPAWNABLE_ENTITY_TYPE");

    /**
     * Represents the {@link Key} for the list of entities able to be spawned
     * by a {@link Spawner}.
     *
     * @see MobSpawnerData#possibleEntitiesToSpawn()
     */
    public static final Key<WeightedCollectionValue<EntitySnapshot>> SPAWNER_ENTITIES = KeyFactory.fake("SPAWNER_ENTITIES");

    /**
     * Represents the {@link Key} for the maximum amount of ticks between two
     * batches of entities spawned by a {@link Spawner}.
     *
     * @see MobSpawnerData#maximumSpawnDelay()
     */
    public static final Key<MutableBoundedValue<Short>> SPAWNER_MAXIMUM_DELAY = KeyFactory.fake("SPAWNER_MAXIMUM_DELAY");

    /**
     * Represents the {@link Key} for the maximum number of entities around a
     * {@link Spawner}. A spawner will not spawn entities if there are more
     * entities around than this value permits.
     *
     * @see MobSpawnerData#maximumNearbyEntities()
     */
    public static final Key<MutableBoundedValue<Short>> SPAWNER_MAXIMUM_NEARBY_ENTITIES = KeyFactory.fake("SPAWNER_MAXIMUM_NEARBY_ENTITIES");

    /**
     * Represents the {@link Key} for the minimum amount of ticks between two
     * batches of entities spawned by a {@link Spawner}.
     *
     * @see MobSpawnerData#minimumSpawnDelay()
     */
    public static final Key<MutableBoundedValue<Short>> SPAWNER_MINIMUM_DELAY = KeyFactory.fake("SPAWNER_MINIMUM_DELAY");

    /**
     * Represents the {@link Key} for the next entity that will be spawned
     * by a {@link Spawner}.
     *
     * <p>Normally the entities to be spawned are determined by a random value
     * applied to the {@link #SPAWNER_ENTITIES} weighted collection. If this
     * value exists, it will override the random spawn with a definite one.</p>
     *
     * @see MobSpawnerData#nextEntityToSpawn()
     */
    public static final Key<MobSpawnerData.NextEntityToSpawnValue> SPAWNER_NEXT_ENTITY_TO_SPAWN = KeyFactory.fake("SPAWNER_NEXT_ENTITY_TO_SPAWN");

    /**
     * Represents the {@link Key} for the remaining number of ticks to pass
     * before another attempt to spawn entities is made by a {@link Spawner}.
     *
     * @see MobSpawnerData#remainingDelay()
     */
    public static final Key<MutableBoundedValue<Short>> SPAWNER_REMAINING_DELAY = KeyFactory.fake("SPAWNER_REMAINING_DELAY");

    /**
     * Represents the {@link Key} for how close a {@link Player} has to be
     * around the {@link Spawner} in order for it to attempt to spawn entities.
     *
     * @see MobSpawnerData#requiredPlayerRange()
     */
    public static final Key<MutableBoundedValue<Short>> SPAWNER_REQUIRED_PLAYER_RANGE = KeyFactory.fake("SPAWNER_REQUIRED_PLAYER_RANGE");

    /**
     * Represents the {@link Key} for how many entities a {@link Spawner} has
     * spawned so far.
     *
     * @see MobSpawnerData#spawnCount()
     */
    public static final Key<MutableBoundedValue<Short>> SPAWNER_SPAWN_COUNT = KeyFactory.fake("SPAWNER_SPAWN_COUNT");

    /**
     * Represents the {@link Key} for how far away from the {@link Spawner} the
     * entities spawned by it may appear.
     *
     * @see MobSpawnerData#spawnRange()
     */
    public static final Key<MutableBoundedValue<Short>> SPAWNER_SPAWN_RANGE = KeyFactory.fake("SPAWNER_SPAWN_RANGE");

    /**
     * Represents the {@link Key} for representing the {@link StairShape}
     * of a {@link BlockState}.
     *
     * @see StairShapeData
     */
    public static final Key<Value<StairShape>> STAIR_SHAPE = KeyFactory.fake("STAIR_SHAPE");

    /**
     * Represents the {@link Key} for the {@link Statistic}s of a {@link Player}.
     *
     * @see StatisticData#statistics()
     */
    public static final Key<MapValue<Statistic, Long>> STATISTICS = KeyFactory.fake("STATISTICS");

    /**
     * Represents the {@link Key} for representing the {@link StoneType}
     * of a {@link BlockState}.
     *
     * @see StoneData
     */
    public static final Key<Value<StoneType>> STONE_TYPE = KeyFactory.fake("STONE_TYPE");

    /**
     * Represents the {@link Key} for the enchantments stored on an
     * {@link ItemStack}.
     *
     * <p>Stored enchantments are meant to be transferred. Usually this key
     * applies to {@link ItemTypes#ENCHANTED_BOOK} stacks. Enchantments
     * affecting the item stack are retrieved via {@link #ITEM_ENCHANTMENTS}
     * instead.</p>
     *
     * @see StoredEnchantmentData#enchantments()
     */
    public static final Key<ListValue<ItemEnchantment>> STORED_ENCHANTMENTS = KeyFactory.fake("STORED_ENCHANTMENTS");

    /**
     * Represents the {@link Key} for representing the amount of "stuck arrows"
     * in {@link Living} entities.
     *
     * @see StuckArrowsData#stuckArrows()
     */
    public static final Key<MutableBoundedValue<Integer>> STUCK_ARROWS = KeyFactory.fake("STUCK_ARROWS");

    /**
     * Reprsents a key for the amount of successful executions of a command
     * stored in a {@link CommandBlock} or {@link CommandBlockMinecart}.
     *
     * @see CommandData#successCount()
     */
    public static final Key<MutableBoundedValue<Integer>> SUCCESS_COUNT = KeyFactory.fake("SUCCESS_COUNT");

    /**
     * Represents the {@link Key} for representing the "suspended" state
     * of a {@link BlockState}.
     */
    public static final Key<Value<Boolean>> SUSPENDED = KeyFactory.fake("SUSPENDED");

    /**
     * Represents the {@link Key} for the owner uuid of a tamed {@link Animal}.
     *
     * <p>Tamable animals in Vanilla may be a {@link Wolf}, an {@link Ocelot}
     * or a {@link Horse}.</p>
     *
     * @see TameableData#owner()
     */
    public static final Key<OptionalValue<UUID>> TAMED_OWNER = KeyFactory.fake("TAMED_OWNER");

    /**
     * Represents the {@link Key} for the location targeted by an
     * {@link EnderPearl} or a compass held by a {@link Player}.
     *
     * @see TargetedLocationData#target()
     */
    public static final Key<Value<Vector3d>> TARGETED_LOCATION = KeyFactory.fake("TARGETED_LOCATION");

    /**
     * Represents the {@link Key} for the remaining fuse time in ticks of a
     * {@link FusedExplosive}. This value may be set to an arbitrary value
     * if the explosive is not primed.
     *
     * @see FuseData#ticksRemaining()
     */
    public static final Key<Value<Integer>> TICKS_REMAINING = KeyFactory.fake("TICKS_REMAINING");

    /**
     * Represents the {@link Key} for the full amount of experience a
     * {@link Player} has.
     *
     * @see ExperienceHolderData#totalExperience()
     */
    public static final Key<MutableBoundedValue<Integer>> TOTAL_EXPERIENCE = KeyFactory.fake("TOTAL_EXPERIENCE");

    /**
     * Represents the {@link Key} for whether a {@link CommandBlock} does track
     * its output.
     *
     * <p>If this is set, the output of the most recent execution can be
     * retrieved using {@link #LAST_COMMAND_OUTPUT}.</p>
     *
     * @see CommandData#doesTrackOutput()
     */
    public static final Key<Value<Boolean>> TRACKS_OUTPUT = KeyFactory.fake("TRACKS_OUTPUT");

    /**
     * Represents the {@link Key} for the {@link TradeOffer}s offered by a
     * {@link Villager}.
     *
     * @see TradeOfferData#tradeOffers()
     */
    public static final Key<ListValue<TradeOffer>> TRADE_OFFERS = KeyFactory.fake("TRADE_OFFERS");

    /**
     * Represents the {@link Key} for representing the {@link TreeType}
     * of a {@link BlockState}.
     *
     * @see TreeData
     */
    public static final Key<Value<TreeType>> TREE_TYPE = KeyFactory.fake("TREE_TYPE");

    /**
     * Represents the {@link Key} for whether an {@link ItemStack} is unbreakable.
     *
     * <p>Setting this to {@code  true} will prevent the item stack's
     * {@link #ITEM_DURABILITY} from changing.</p>
     *
     * @see DurabilityData#unbreakable()
     */
    public static final Key<Value<Boolean>> UNBREAKABLE = KeyFactory.fake("UNBREAKABLE");

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
     *
     * @see Keys#VANISH
     */
    public static final Key<Value<Boolean>> VANISH = KeyFactory.fake("VANISH");

    /**
     * Represents the {@link Key} for whether an {@link Entity} ignores collision
     * with other entities.
     *
     * <p>This state will be ignored if the {@link Entity} is not also
     * vanished as per {@link #VANISH}.</p>
     *
     * @see InvisibilityData#ignoresCollisionDetection()
     */
    public static final Key<Value<Boolean>> VANISH_IGNORES_COLLISION = KeyFactory.fake("VANISH_IGNORES_COLLISION");


    /**
     * Represents the {@link Key} for
     * Gets the {@link Value} for whether an {@link Entity} can be targeted for
     * attack by another entity. This prevents neither {@link Player}s from
     * attacking the entity nor will it be protected from untargeted damage
     * like fire or explosions.
     *
     * <p>This state will be ignored if the {@link Entity} is not also
     * vanished as per {@link #VANISH}.}.</p>
     *
     * @see InvisibilityData#untargetable()
     */
    public static final Key<Value<Boolean>> VANISH_PREVENTS_TARGETING = KeyFactory.fake("VANISH_PREVENTS_TARGETING");

    /**
     * Represents the {@link Key} for the vehicle an {@link Entity} is riding.
     *
     * <p>Vehicles may be nested as a vehicle might itself ride another entity.
     * To get the vehicle on bottom, use {@link #BASE_VEHICLE}.</p>
     *
     * @see VehicleData#vehicle()
     */
    public static final Key<Value<EntitySnapshot>> VEHICLE = KeyFactory.fake("VEHICLE");

    /**
     * Represents the {@link Key} for the velocity of an {@link Entity}.
     *
     * @see VelocityData#velocity()
     */
    public static final Key<Value<Vector3d>> VELOCITY = KeyFactory.fake("VELOCITY");

    /**
     * Represents the {@link Key} for the profession of a {@link Zombie} whose
     * {@link #ZOMBIE_TYPE} is {@link ZombieTypes#VILLAGER}.
     *
     * @see ZombieData#profession()
     */
    public static final Key<OptionalValue<Profession>> VILLAGER_ZOMBIE_PROFESSION = KeyFactory.fake("VILLAGER_ZOMBIE_PROFESSION");

    /**
     * Represents the {@link Key} for the speed at which an entity walks.
     *
     * @see MovementSpeedData#walkSpeed()
     */
    public static final Key<Value<Double>> WALKING_SPEED = KeyFactory.fake("WALKING_SPEED");

    /**
     * Represents the {@link Key} for the type of
     * {@link BlockTypes#COBBLESTONE_WALL} blocks.
     *
     * @see WallData
     */
    public static final Key<Value<WallType>> WALL_TYPE = KeyFactory.fake("WALL_TYPE");

    /**
     * Represents the {@link Key} for whether a thrown {@link EyeOfEnder} will
     * shatter.
     *
     * @see ShatteringData#willShatter()
     */
    public static final Key<Value<Boolean>> WILL_SHATTER = KeyFactory.fake("WILL_SHATTER");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring blocks.
     *
     * @see WireAttachmentData#wireAttachments()
     */
    public static final Key<MapValue<Direction, WireAttachmentType>> WIRE_ATTACHMENTS = KeyFactory.fake("WIRE_ATTACHMENTS");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring block to the {@link Direction#EAST}.
     *
     * @see WireAttachmentData#wireAttachmentEast()
     */
    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_EAST = KeyFactory.fake("WIRE_ATTACHMENT_EAST");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring block to the {@link Direction#NORTH}.
     *
     * @see WireAttachmentData#wireAttachmentNorth()
     */
    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_NORTH = KeyFactory.fake("WIRE_ATTACHMENT_NORTH");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring block to the {@link Direction#SOUTH}.
     *
     * @see WireAttachmentData#wireAttachmentSouth()
     */
    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_SOUTH = KeyFactory.fake("WIRE_ATTACHMENT_SOUTH");

    /**
     * Represents the {@link Key} for how a {@link BlockTypes#REDSTONE_WIRE} is
     * connected to its neighboring block to the {@link Direction#WEST}.
     *
     * @see WireAttachmentData#wireAttachmentWest()
     */
    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_WEST = KeyFactory.fake("WIRE_ATTACHMENT_WEST");

    /**
     * Represents the {@link Key} for the type of a {@link Zombie}.
     *
     * @see ZombieData
     */
    public static final Key<Value<ZombieType>> ZOMBIE_TYPE = KeyFactory.fake("ZOMBIE_TYPE");

    // SORTFIELDS:OFF

    private Keys() {}
}
