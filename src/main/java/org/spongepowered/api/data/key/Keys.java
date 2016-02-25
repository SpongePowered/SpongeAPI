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
import org.spongepowered.api.block.tileentity.CommandBlock;
import org.spongepowered.api.data.manipulator.mutable.*;
import org.spongepowered.api.data.manipulator.mutable.block.*;
import org.spongepowered.api.data.manipulator.mutable.entity.*;
import org.spongepowered.api.data.manipulator.mutable.item.*;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.type.*;
import org.spongepowered.api.data.value.immutable.ImmutableBoundedValue;
import org.spongepowered.api.data.value.mutable.*;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.entity.vehicle.minecart.MinecartCommandBlock;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
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
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * An enumeration of known {@link Key}s used throughout the API.
 */
public final class Keys {
    
    // SORTFIELDS:ON

    public static final Key<SetValue<Achievement>> ACHIEVEMENTS = null;

    /**
     * Represents the {@link Key} for the "affecting spawning" state of
     * {@link Player}s.
     *
     * @see AffectsSpawningData#affectsSpawning()
     */
    public static final Key<Value<Boolean>> AFFECTS_SPAWNING = null;

    public static final Key<MutableBoundedValue<Integer>> AGE = null;

    public static final Key<Value<Boolean>> AI_ENABLED = null;

    public static final Key<MutableBoundedValue<Integer>> ANGER = null;

    public static final Key<Value<Boolean>> ANGRY = null;

    public static final Key<Value<Art>> ART = null;

    /**
     * Represents the {@link Key} for representing whether a {@link BlockState}
     * is "attached" to another block.
     *
     * @see AttachedData#attached()
     */
    public static final Key<Value<Boolean>> ATTACHED = null;

    public static final Key<MutableBoundedValue<Double>> ATTACK_DAMAGE = null;

    /**
     * Represents the {@link Key} for representing the {@link Axis} direction
     * of a {@link BlockState}.
     *
     * @see AxisData#type()
     */
    public static final Key<Value<Axis>> AXIS = null;

    public static final Key<Value<DyeColor>> BANNER_BASE_COLOR = null;

    public static final Key<PatternListValue> BANNER_PATTERNS = null;

    public static final Key<MutableBoundedValue<Float>> BASE_SIZE = null;

    public static final Key<Value<EntitySnapshot>> BASE_VEHICLE = null;

    public static final Key<OptionalValue<PotionEffectType>> BEACON_PRIMARY_EFFECT = null;

    public static final Key<OptionalValue<PotionEffectType>> BEACON_SECONDARY_EFFECT = null;

    /**
     * Represents the {@link Key} for representing the {@link BigMushroomType}
     * of a {@link BlockState}.
     *
     * @see BigMushroomData#type()
     */
    public static final Key<Value<BigMushroomType>> BIG_MUSHROOM_TYPE = null;

    public static final Key<MapValue<BodyPart, Vector3d>> BODY_ROTATIONS = null;

    public static final Key<Value<Text>> BOOK_AUTHOR = null;

    public static final Key<ListValue<Text>> BOOK_PAGES = null;

    public static final Key<SetValue<BlockType>> BREAKABLE_BLOCK_TYPES = null;

    /**
     * Represents the {@link Key} for representing the {@link BrickType}
     * of a {@link BlockState}.
     *
     * @see BrickData#type()
     */
    public static final Key<Value<BrickType>> BRICK_TYPE = null;

    public static final Key<Value<Boolean>> CAN_BREED = null;

    public static final Key<Value<Boolean>> CAN_DROP_AS_ITEM = null;

    public static final Key<Value<Boolean>> CAN_FLY = null;

    public static final Key<Value<Boolean>> CAN_GRIEF = null;

    public static final Key<Value<Boolean>> CAN_PLACE_AS_BLOCK = null;

    public static final Key<Value<Career>> CAREER = null;

    public static final Key<Value<Vector3d>> CHEST_ROTATION = null;

    public static final Key<Value<CoalType>> COAL_TYPE = null;

    public static final Key<Value<Color>> COLOR = null;

    /**
     * Represents a key for the stored command, mostly related to
     * {@link CommandBlock}s and {@link MinecartCommandBlock}s.
     *
     * @see CommandData#storedCommand()
     */
    public static final Key<Value<String>> COMMAND = null;

    /**
     * Represents the {@link Key} for representing the {@link ComparatorType}
     * of a {@link BlockState}.
     *
     * @see ComparatorData#type()
     */
    public static final Key<Value<ComparatorType>> COMPARATOR_TYPE = null;

    /**
     * Represents the {@link Key} for representing the connected directions
     * of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedDirections()
     */
    public static final Key<SetValue<Direction>> CONNECTED_DIRECTIONS = null;

    /**
     * Represents the {@link Key} for representing the "connected to the east"
     * of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedEast()
     */
    public static final Key<Value<Boolean>> CONNECTED_EAST = null;

    /**
     * Represents the {@link Key} for representing the "connected to the north"
     * state of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedNorth()
     */
    public static final Key<Value<Boolean>> CONNECTED_NORTH = null;

    /**
     * Represents the {@link Key} for representing the "connected to the south"
     * state of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedSouth()
     */
    public static final Key<Value<Boolean>> CONNECTED_SOUTH = null;

    /**
     * Represents the {@link Key} for representing the "connected to the west"
     * state of a {@link BlockState}.
     *
     * @see ConnectedDirectionData#connectedWest()
     */
    public static final Key<Value<Boolean>> CONNECTED_WEST = null;

    public static final Key<MutableBoundedValue<Integer>> CONTAINED_EXPERIENCE = null;

    public static final Key<Value<CookedFish>> COOKED_FISH = null;

    public static final Key<MutableBoundedValue<Integer>> COOLDOWN = null;

    public static final Key<Value<Boolean>> CREEPER_CHARGED = null;

    public static final Key<Value<Boolean>> CRITICAL_HIT = null;

    /**
     * Represents the {@link Key} for the "custom name visible" state
     * of an {@link Entity}.
     *
     * @see CustomNameVisibleData#customNameVisible()
     */
    public static final Key<Value<Boolean>> CUSTOM_NAME_VISIBLE = null;

    public static final Key<MapValue<EntityType, Double>> DAMAGE_ENTITY_MAP = null;

    /**
     * Represents the {@link Key} for representing the "decayable" state
     * of a {@link BlockState}.
     *
     * @see DecayableData#decayable()
     */
    public static final Key<Value<Boolean>> DECAYABLE = null;

    public static final Key<MutableBoundedValue<Integer>> DELAY = null;

    /**
     * Represents the {@link Key} for representing the {@link Direction}
     * of a {@link BlockState}.
     *
     * @see DirectionalData#direction()
     */
    public static final Key<Value<Direction>> DIRECTION = null;

    /**
     * Represents the {@link Key} for representing the {@link DirtType}
     * of a {@link BlockState}.
     *
     * @see DirtData#type()
     */
    public static final Key<Value<DirtType>> DIRT_TYPE = null;

    /**
     * Represents the {@link Key} for representing the "disarmed" state
     * of a {@link BlockState}.
     *
     * @see DisarmedData#disarmed()
     */
    public static final Key<Value<Boolean>> DISARMED = null;

    /**
     * Represents the {@link Key} for representing the {@link DisguisedBlockType}
     * of a {@link BlockState}.
     *
     * @see DisguisedBlockData#type()
     */
    public static final Key<Value<DisguisedBlockType>> DISGUISED_BLOCK_TYPE = null;

    public static final Key<Value<Text>> DISPLAY_NAME = null;

    /**
     * Represents the {@link Key} for representing the {@link DoublePlantType}
     * of a {@link BlockState}.
     *
     * @see DoublePlantData#type()
     */
    public static final Key<Value<DoublePlantType>> DOUBLE_PLANT_TYPE = null;

    public static final Key<Value<DyeColor>> DYE_COLOR = null;

    public static final Key<Value<Boolean>> ELDER_GUARDIAN = null;

    public static final Key<MutableBoundedValue<Double>> EXHAUSTION = null;

    public static final Key<ImmutableBoundedValue<Integer>> EXPERIENCE_FROM_START_OF_LEVEL = null;

    public static final Key<MutableBoundedValue<Integer>> EXPERIENCE_LEVEL = null;

    public static final Key<MutableBoundedValue<Integer>> EXPERIENCE_SINCE_LEVEL = null;

    public static final Key<MutableBoundedValue<Integer>> EXPIRATION_TICKS = null;

    public static final Key<MutableBoundedValue<Integer>> EXPLOSIVE_RADIUS = null;

    /**
     * Represents the {@link Key} for representing the {@link BigMushroomType}
     * of a {@link BlockState}.
     *
     * @see ExtendedData#extended()
     */
    public static final Key<Value<Boolean>> EXTENDED = null;

    public static final Key<Value<Boolean>> FALLING_BLOCK_CAN_HURT_ENTITIES = null;

    public static final Key<Value<BlockState>> FALLING_BLOCK_STATE = null;

    public static final Key<MutableBoundedValue<Double>> FALL_DAMAGE_PER_BLOCK = null;

    /**
     * Represents the {@link Key} for representing the distance an entity has
     * fallen.
     *
     * @see FallDistanceData#fallDistance()
     */
    public static final Key<MutableBoundedValue<Float>> FALL_DISTANCE = null;

    public static final Key<Value<Integer>> FALL_TIME = null;

    /**
     * Represents the {@link Key} for representing the "filled" state
     * of a {@link BlockState}.
     *
     * @see FilledData#filled()
     */
    public static final Key<Value<Boolean>> FILLED = null;

    public static final Key<ListValue<FireworkEffect>> FIREWORK_EFFECTS = null;

    public static final Key<MutableBoundedValue<Integer>> FIREWORK_FLIGHT_MODIFIER = null;

    public static final Key<MutableBoundedValue<Integer>> FIRE_DAMAGE_DELAY = null;

    public static final Key<MutableBoundedValue<Integer>> FIRE_TICKS = null;

    public static final Key<Value<Instant>> FIRST_DATE_PLAYED = null;

    public static final Key<Value<Fish>> FISH_TYPE = null;

    /**
    /**
     * Represents the {@link Key} for representing the
     * {@link FluidStackSnapshot} contained within an item container. Item
     * containers may include buckets and other mod added items.
     */
    public static final Key<Value<FluidStackSnapshot>> FLUID_ITEM_STACK = null;

    /**
     * Represents the {@link Key} for representing the "fluid level" state
     * of a {@link BlockState}.
     *
     * @see FluidLevelData#level()
     */
    public static final Key<MutableBoundedValue<Integer>> FLUID_LEVEL = null;

    /**
     * Represents the {@link Key} for representing the directional tank
     * information
     */
    public static final Key<MapValue<Direction, List<FluidStackSnapshot>>> FLUID_TANK_CONTENTS = null;

    public static final Key<Value<Double>> FLYING_SPEED = null;

    public static final Key<MutableBoundedValue<Integer>> FOOD_LEVEL = null;

    public static final Key<MutableBoundedValue<Integer>> FUSE_DURATION = null;

    public static final Key<Value<GameMode>> GAME_MODE = null;

    public static final Key<MutableBoundedValue<Integer>> GENERATION = null;

    public static final Key<Value<GoldenApple>> GOLDEN_APPLE_TYPE = null;

    /**
     * Represents the {@link Key} for representing the "growth stage" state
     * of a {@link BlockState}.
     *
     * @see GrowthData#growthStage()
     */
    public static final Key<MutableBoundedValue<Integer>> GROWTH_STAGE = null;

    public static final Key<Value<Vector3d>> HEAD_ROTATION = null;

    public static final Key<MutableBoundedValue<Double>> HEALTH = null;

    public static final Key<MutableBoundedValue<Double>> HEALTH_SCALE = null;

    public static final Key<MutableBoundedValue<Float>> HEIGHT = null;

    public static final Key<MutableBoundedValue<Integer>> HELD_EXPERIENCE = null;

    /**
     * Represents the {@link Key} for representing the "attributes hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideAttributes()
     */
    public static final Key<Value<Boolean>> HIDE_ATTRIBUTES = null;

    /**
     * Represents the {@link Key} for representing the "can destroy hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideCanDestroy()
     */
    public static final Key<Value<Boolean>> HIDE_CAN_DESTROY = null;

    /**
     * Represents the {@link Key} for representing the "can place hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideCanPlace()
     */
    public static final Key<Value<Boolean>> HIDE_CAN_PLACE = null;

    /**
     * Represents the {@link Key} for representing the "enchantments hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideEnchantments()
     */
    public static final Key<Value<Boolean>> HIDE_ENCHANTMENTS = null;

    /**
     * Represents the {@link Key} for representing the "miscellaneous hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideMiscellaneous()
     */
    public static final Key<Value<Boolean>> HIDE_MISCELLANEOUS = null;

    /**
     * Represents the {@link Key} for representing the "unbreakable hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideUnbreakable()
     */
    public static final Key<Value<Boolean>> HIDE_UNBREAKABLE = null;

    /**
     * Represents the {@link Key} for representing the {@link Hinge}
     * of a {@link BlockState}.
     *
     * @see HingeData#type()
     */
    public static final Key<Value<Hinge>> HINGE_POSITION = null;

    public static final Key<Value<HorseColor>> HORSE_COLOR = null;

    public static final Key<Value<HorseStyle>> HORSE_STYLE = null;

    public static final Key<Value<HorseVariant>> HORSE_VARIANT = null;

    public static final Key<Value<Boolean>> INVISIBILITY_IGNORES_COLLISION = null;

    /**
     *
     */
    public static final Key<Value<Boolean>> INVISIBILITY_PREVENTS_TARGETING = null;

    /**
     * Represents the {@link Key} for representing the "invisible" state
     * of an {@link Entity}.
     */
    public static final Key<Value<Boolean>> INVISIBLE = null;

    public static final Key<MutableBoundedValue<Integer>> INVULNERABILITY = null;

    public static final Key<MutableBoundedValue<Integer>> INVULNERABILITY_TICKS = null;

    /**
     * Represents the {@link Key} for representing the "in-wall" state of
     * {@link BlockTypes#FENCE}s.
     *
     * @see InWallData#inWall()
     */
    public static final Key<Value<Boolean>> IN_WALL = null;

    public static final Key<Value<Boolean>> IS_AFLAME = null;

    public static final Key<Value<Boolean>> IS_FLYING = null;

    public static final Key<Value<Boolean>> IS_PLAYING = null;

    public static final Key<Value<Boolean>> IS_SCREAMING = null;

    public static final Key<Value<Boolean>> IS_SHEARED = null;

    public static final Key<Value<Boolean>> IS_SITTING = null;

    public static final Key<Value<Boolean>> IS_SLEEPING = null;

    public static final Key<Value<Boolean>> IS_SNEAKING = null;

    /**
     * Represents the {@link Key} for representing the "splash" state of a
     * {@link ItemTypes#POTION}.
     *
     * @see SplashPotionData#splash()
     */
    public static final Key<Value<Boolean>> IS_SPLASH_POTION = null;

    public static final Key<Value<Boolean>> IS_SPRINTING = null;

    public static final Key<Value<Boolean>> IS_VILLAGER_ZOMBIE = null;

    public static final Key<Value<Boolean>> IS_WET = null;

    public static final Key<Value<BlockState>> ITEM_BLOCKSTATE = null;

    public static final Key<MutableBoundedValue<Integer>> ITEM_DURABILITY = null;

    public static final Key<ListValue<ItemEnchantment>> ITEM_ENCHANTMENTS = null;

    public static final Key<ListValue<Text>> ITEM_LORE = null;

    public static final Key<MutableBoundedValue<Integer>> KNOCKBACK_STRENGTH = null;

    public static final Key<OptionalValue<Living>> LAST_ATTACKER = null;

    public static final Key<OptionalValue<Text>> LAST_COMMAND_OUTPUT = null;

    public static final Key<OptionalValue<Double>> LAST_DAMAGE = null;

    public static final Key<Value<Instant>> LAST_DATE_PLAYED = null;

    /**
     * Represents the {@link Key} for representing the "layer" value of
     * {@link BlockTypes#SNOW_LAYER} and other possible layered blocks.
     *
     * @see LayeredData#layer()
     */
    public static final Key<MutableBoundedValue<Integer>> LAYER = null;

    public static final Key<Value<EntitySnapshot>> LEASH_HOLDER = null;

    public static final Key<Value<Vector3d>> LEFT_ARM_ROTATION = null;

    public static final Key<Value<Vector3d>> LEFT_LEG_ROTATION = null;

    public static final Key<Value<String>> LOCK_TOKEN = null;

    public static final Key<Value<LogAxis>> LOG_AXIS = null;

    public static final Key<MutableBoundedValue<Integer>> MAX_AIR = null;

    public static final Key<MutableBoundedValue<Integer>> MAX_BURN_TIME = null;

    public static final Key<MutableBoundedValue<Integer>> MAX_COOK_TIME = null;

    public static final Key<MutableBoundedValue<Double>> MAX_FALL_DAMAGE = null;

    public static final Key<MutableBoundedValue<Double>> MAX_HEALTH = null;

    /**
     * Represents the {@link Key} for representing the "moisture" state of
     * {@link BlockTypes#FARMLAND}.
     *
     * @see MoistureData#moisture()
     */
    public static final Key<MutableBoundedValue<Integer>> MOISTURE = null;

    public static final Key<Value<NotePitch>> NOTE_PITCH = null;

    /**
     * Represents the {@link Key} for representing the "occupied" state of
     * {@link BlockTypes#BED}.
     *
     * @see OccupiedData#occupied()
     */
    public static final Key<Value<Boolean>> OCCUPIED = null;

    public static final Key<Value<OcelotType>> OCELOT_TYPE = null;

    /**
     * Represents the {@link Key} for representing a block's offset when inside
     * a {@link Minecart}.
     *
     * @see MinecartBlockData#offset()
     */
    public static final Key<Value<Integer>> OFFSET = null;

    /**
     * Represents the {@link Key} for representing the "open" state of
     * various door typed blocks.
     *
     * @see OpenData#open()
     */
    public static final Key<Value<Boolean>> OPEN = null;

    public static final Key<MutableBoundedValue<Integer>> PASSED_BURN_TIME = null;

    public static final Key<MutableBoundedValue<Integer>> PASSED_COOK_TIME = null;

    public static final Key<Value<EntitySnapshot>> PASSENGER = null;

    public static final Key<Value<Boolean>> PERSISTS = null;

    public static final Key<Value<Boolean>> PIG_SADDLE = null;

    /**
     * Represents the {@link Key} for representing the {@link PistonType}
     * of a {@link BlockTypes#PISTON}.
     *
     * @see PistonData#type()
     */
    public static final Key<Value<PistonType>> PISTON_TYPE = null;

    public static final Key<SetValue<BlockType>> PLACEABLE_BLOCKS = null;

    /**
     * Represents the {@link Key} for representing the {@link PlantType}
     * of a {@link BlockState}.
     *
     * @see PlantData#type()
     */
    public static final Key<Value<PlantType>> PLANT_TYPE = null;

    public static final Key<Value<Boolean>> PLAYER_CREATED = null;

    /**
     * Represents the {@link Key} for representing the {@link PortionType}
     * of a {@link BlockState}.
     *
     * @see PortionData#type()
     */
    public static final Key<Value<PortionType>> PORTION_TYPE = null;

    public static final Key<ListValue<PotionEffect>> POTION_EFFECTS = null;

    /**
     * Represents the {@link Key} for representing the "power" state
     * of a {@link BlockState}.
     *
     * @see RedstonePoweredData#power()
     */
    public static final Key<MutableBoundedValue<Integer>> POWER = null;

    /**
     * Represents the {@link Key} for representing the "powered" state
     * of a {@link BlockState}.
     *
     * @see PoweredData#powered()
     */
    public static final Key<Value<Boolean>> POWERED = null;

    /**
     * Represents the {@link Key} for representing the {@link PrismarineType}
     * of a {@link BlockState}.
     *
     * @see PrismarineData#type()
     */
    public static final Key<Value<PrismarineType>> PRISMARINE_TYPE = null;

    /**
     * Represents the {@link Key} for representing the {@link QuartzType}
     * of a {@link BlockState}.
     *
     * @see QuartzData#type()
     */
    public static final Key<Value<QuartzType>> QUARTZ_TYPE = null;

    public static final Key<Value<RabbitType>> RABBIT_TYPE = null;

    /**
     * Represents the {@link Key} for representing the {@link RailDirection}
     * of a {@link BlockState}.
     *
     * @see RailDirectionData#type()
     */
    public static final Key<Value<RailDirection>> RAIL_DIRECTION = null;

    public static final Key<MutableBoundedValue<Integer>> REMAINING_AIR = null;

    public static final Key<MutableBoundedValue<Integer>> REMAINING_BREW_TIME = null;

    /**
     * Represents the {@link Key} for representing the {@link BlockState}
     * inside a {@link Minecart}.
     *
     * @see MinecartBlockData#block()
     */
    public static final Key<Value<BlockState>> REPRESENTED_BLOCK = null;

    public static final Key<Value<ItemStackSnapshot>> REPRESENTED_ITEM = null;

    public static final Key<Value<GameProfile>> REPRESENTED_PLAYER = null;

    public static final Key<MapValue<UUID, Vector3d>> RESPAWN_LOCATIONS = null;

    public static final Key<Value<Vector3d>> RIGHT_ARM_ROTATION = null;

    public static final Key<Value<Vector3d>> RIGHT_LEG_ROTATION = null;

    public static final Key<Value<Rotation>> ROTATION = null;

    /**
     * Represents the {@link Key} for representing the {@link SandstoneType}
     * of a {@link BlockState}.
     *
     * @see SandstoneData#type()
     */
    public static final Key<Value<SandstoneType>> SANDSTONE_TYPE = null;

    /**
     * Represents the {@link Key} for representing the {@link SandType}
     * of a {@link BlockState}.
     *
     * @see SandData#type()
     */
    public static final Key<Value<SandType>> SAND_TYPE = null;

    public static final Key<MutableBoundedValue<Double>> SATURATION = null;

    public static final Key<MutableBoundedValue<Float>> SCALE = null;

    /**
     * Represents the {@link Key} for representing the "seamless" state
     * of a {@link BlockState}.
     *
     * @see SeamlessData#seamless()
     */
    public static final Key<Value<Boolean>> SEAMLESS = null;

    /**
     * Represents the {@link Key} for representing the "should drop" state
     * of a {@link BlockState}.
     *
     * @see DropData#willDrop()
     */
    public static final Key<Value<Boolean>> SHOULD_DROP = null;

    /**
     * Represents the {@link Key} for representing the {@link ShrubType}
     * of a {@link BlockState}.
     *
     * @see ShrubData#type()
     */
    public static final Key<Value<ShrubType>> SHRUB_TYPE = null;

    public static final Key<ListValue<Text>> SIGN_LINES = null;

    public static final Key<Value<SkeletonType>> SKELETON_TYPE = null;

    public static final Key<Value<UUID>> SKIN_UNIQUE_ID = null;

    public static final Key<Value<SkullType>> SKULL_TYPE = null;

    /**
     * Represents the {@link Key} for representing the {@link SlabType}
     * of a {@link BlockState}.
     *
     * @see SlabData#type()
     */
    public static final Key<Value<SlabType>> SLAB_TYPE = null;

    public static final Key<MutableBoundedValue<Integer>> SLIME_SIZE = null;

    /**
     * Represents the {@link Key} for representing the "snowed" state
     * of a {@link BlockState}.
     *
     * @see SnowedData#hasSnow()
     */
    public static final Key<Value<Boolean>> SNOWED = null;

    public static final Key<Value<EntityType>> SPAWNABLE_ENTITY_TYPE = null;

    public static final Key<WeightedCollectionValue<EntitySnapshot>> SPAWNER_ENTITIES = null;

    public static final Key<MutableBoundedValue<Short>> SPAWNER_MAXIMUM_DELAY = null;

    public static final Key<MutableBoundedValue<Short>> SPAWNER_MAXIMUM_NEARBY_ENTITIES = null;

    public static final Key<MutableBoundedValue<Short>> SPAWNER_MINIMUM_DELAY = null;

    public static final Key<MobSpawnerData.NextEntityToSpawnValue> SPAWNER_NEXT_ENTITY_TO_SPAWN = null;

    public static final Key<MutableBoundedValue<Short>> SPAWNER_REMAINING_DELAY = null;

    public static final Key<MutableBoundedValue<Short>> SPAWNER_REQUIRED_PLAYER_RANGE = null;

    public static final Key<MutableBoundedValue<Short>> SPAWNER_SPAWN_COUNT = null;

    public static final Key<MutableBoundedValue<Short>> SPAWNER_SPAWN_RANGE = null;

    /**
     * Represents the {@link Key} for representing the {@link StairShape}
     * of a {@link BlockState}.
     *
     * @see StairShapeData#type()
     */
    public static final Key<Value<StairShape>> STAIR_SHAPE = null;

    public static final Key<MapValue<Statistic, Long>> STATISTICS = null;

    /**
     * Represents the {@link Key} for representing the {@link StoneType}
     * of a {@link BlockState}.
     *
     * @see StoneData#type()
     */
    public static final Key<Value<StoneType>> STONE_TYPE = null;

    public static final Key<ListValue<ItemEnchantment>> STORED_ENCHANTMENTS = null;

    /**
     * Represents the {@link Key} for representing the amount of "stuck arrows"
     * in {@link Living} entities.
     *
     * @see StuckArrowsData#stuckArrows()
     */
    public static final Key<MutableBoundedValue<Integer>> STUCK_ARROWS = null;

    /**
     * Reprsents a key for the amount of successful executions of a command
     * stored in a {@link CommandBlock} or {@link MinecartCommandBlock}.
     *
     * @see CommandData#successCount()
     */
    public static final Key<MutableBoundedValue<Integer>> SUCCESS_COUNT = null;

    /**
     * Represents the {@link Key} for representing the "suspended" state
     * of a {@link BlockState}.
     *
     * @see SuspendedData#suspended()
     */
    public static final Key<Value<Boolean>> SUSPENDED = null;

    public static final Key<OptionalValue<UUID>> TAMED_OWNER = null;

    public static final Key<Value<Vector3d>> TARGETED_LOCATION = null;

    public static final Key<MutableBoundedValue<Integer>> TOTAL_EXPERIENCE = null;

    public static final Key<Value<Boolean>> TRACKS_OUTPUT = null;

    public static final Key<ListValue<TradeOffer>> TRADE_OFFERS = null;

    /**
     * Represents the {@link Key} for representing the {@link TreeType}
     * of a {@link BlockState}.
     *
     * @see TreeData#type()
     */
    public static final Key<Value<TreeType>> TREE_TYPE = null;

    public static final Key<Value<Boolean>> UNBREAKABLE = null;

    public static final Key<Value<EntitySnapshot>> VEHICLE = null;

    public static final Key<Value<Vector3d>> VELOCITY = null;

    public static final Key<Value<Double>> WALKING_SPEED = null;

    public static final Key<Value<WallType>> WALL_TYPE = null;

    public static final Key<Value<Boolean>> WILL_SHATTER = null;

    public static final Key<MapValue<Direction, WireAttachmentType>> WIRE_ATTACHMENTS = null;

    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_EAST = null;

    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_NORTH = null;

    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_SOUTH = null;

    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_WEST = null;

    // SORTFIELDS:OFF

    private Keys() {}
}
