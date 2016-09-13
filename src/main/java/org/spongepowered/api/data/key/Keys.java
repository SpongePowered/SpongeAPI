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
import org.spongepowered.api.entity.projectile.arrow.Arrow;
import org.spongepowered.api.util.RespawnLocation;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.vehicle.minecart.CommandBlockMinecart;
import org.spongepowered.api.entity.vehicle.minecart.Minecart;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
import org.spongepowered.api.item.FireworkEffect;
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

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * An enumeration of known {@link Key}s used throughout the API.
 */
public final class Keys {

    // SORTFIELDS:ON

    public static final Key<SetValue<Achievement>> ACHIEVEMENTS = KeyFactory.fake("ACHIEVEMENTS");

    /**
     * Represents the {@link Key} for the "affecting spawning" state of
     * {@link Player}s.
     *
     * @see AffectsSpawningData#affectsSpawning()
     */
    public static final Key<Value<Boolean>> AFFECTS_SPAWNING = KeyFactory.fake("AFFECTS_SPAWNING");

    public static final Key<MutableBoundedValue<Integer>> AGE = KeyFactory.fake("AGE");

    public static final Key<Value<Boolean>> AI_ENABLED = KeyFactory.fake("AI_ENABLED");

    public static final Key<MutableBoundedValue<Integer>> ANGER = KeyFactory.fake("ANGER");

    public static final Key<Value<Boolean>> ANGRY = KeyFactory.fake("ANGRY");

    public static final Key<Value<Boolean>> ARMOR_STAND_HAS_ARMS = KeyFactory.fake("ARMOR_STAND_HAS_ARMS");

    public static final Key<Value<Boolean>> ARMOR_STAND_HAS_BASE_PLATE = KeyFactory.fake("ARMOR_STAND_HAS_BASE_PLATE");

    public static final Key<Value<Boolean>> ARMOR_STAND_HAS_GRAVITY = KeyFactory.fake("ARMOR_STAND_HAS_GRAVITY");

    public static final Key<Value<Boolean>> ARMOR_STAND_IS_SMALL = KeyFactory.fake("ARMOR_STAND_IS_SMALL");

    public static final Key<Value<Boolean>> ARMOR_STAND_MARKER = KeyFactory.fake("ARMOR_STAND_MARKER");

    public static final Key<Value<Art>> ART = KeyFactory.fake("ART");

    /**
     * Represents the {@link Key} for representing whether a {@link BlockState}
     * is "attached" to another block.
     *
     * @see AttachedData#attached()
     */
    public static final Key<Value<Boolean>> ATTACHED = KeyFactory.fake("ATTACHED");

    public static final Key<MutableBoundedValue<Double>> ATTACK_DAMAGE = KeyFactory.fake("ATTACK_DAMAGE");

    /**
     * Represents the {@link Key} for representing the {@link Axis} direction
     * of a {@link BlockState}.
     *
     * @see AxisData#type()
     */
    public static final Key<Value<Axis>> AXIS = KeyFactory.fake("AXIS");

    public static final Key<Value<DyeColor>> BANNER_BASE_COLOR = KeyFactory.fake("BANNER_BASE_COLOR");

    public static final Key<PatternListValue> BANNER_PATTERNS = KeyFactory.fake("BANNER_PATTERNS");

    public static final Key<MutableBoundedValue<Float>> BASE_SIZE = KeyFactory.fake("BASE_SIZE");

    public static final Key<Value<EntitySnapshot>> BASE_VEHICLE = KeyFactory.fake("BASE_VEHICLE");

    public static final Key<OptionalValue<PotionEffectType>> BEACON_PRIMARY_EFFECT = KeyFactory.fake("BEACON_PRIMARY_EFFECT");

    public static final Key<OptionalValue<PotionEffectType>> BEACON_SECONDARY_EFFECT = KeyFactory.fake("BEACON_SECONDARY_EFFECT");

    /**
     * Represents the {@link Key} for representing the {@link BigMushroomType}
     * of a {@link BlockState}.
     *
     * @see BigMushroomData#type()
     */
    public static final Key<Value<BigMushroomType>> BIG_MUSHROOM_TYPE = KeyFactory.fake("BIG_MUSHROOM_TYPE");

    public static final Key<MapValue<BodyPart, Vector3d>> BODY_ROTATIONS = KeyFactory.fake("BODY_ROTATIONS");

    public static final Key<Value<Text>> BOOK_AUTHOR = KeyFactory.fake("BOOK_AUTHOR");

    public static final Key<ListValue<Text>> BOOK_PAGES = KeyFactory.fake("BOOK_PAGES");

    public static final Key<SetValue<BlockType>> BREAKABLE_BLOCK_TYPES = KeyFactory.fake("BREAKABLE_BLOCK_TYPES");

    /**
     * Represents the {@link Key} for representing the {@link BrickType}
     * of a {@link BlockState}.
     *
     * @see BrickData#type()
     */
    public static final Key<Value<BrickType>> BRICK_TYPE = KeyFactory.fake("BRICK_TYPE");

    public static final Key<Value<Boolean>> CAN_BREED = KeyFactory.fake("CAN_BREED");

    public static final Key<Value<Boolean>> CAN_DROP_AS_ITEM = KeyFactory.fake("CAN_DROP_AS_ITEM");

    public static final Key<Value<Boolean>> CAN_FLY = KeyFactory.fake("CAN_FLY");

    public static final Key<Value<Boolean>> CAN_GRIEF = KeyFactory.fake("CAN_GRIEF");

    public static final Key<Value<Boolean>> CAN_PLACE_AS_BLOCK = KeyFactory.fake("CAN_PLACE_AS_BLOCK");

    public static final Key<Value<Career>> CAREER = KeyFactory.fake("CAREER");

    public static final Key<Value<Vector3d>> CHEST_ROTATION = KeyFactory.fake("CHEST_ROTATION");

    public static final Key<Value<CoalType>> COAL_TYPE = KeyFactory.fake("COAL_TYPE");

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
     * @see ComparatorData#type()
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

    public static final Key<MutableBoundedValue<Integer>> CONTAINED_EXPERIENCE = KeyFactory.fake("CONTAINED_EXPERIENCE");

    public static final Key<Value<CookedFish>> COOKED_FISH = KeyFactory.fake("COOKED_FISH");

    public static final Key<MutableBoundedValue<Integer>> COOLDOWN = KeyFactory.fake("COOLDOWN");

    public static final Key<Value<Boolean>> CREEPER_CHARGED = KeyFactory.fake("CREEPER_CHARGED");

    public static final Key<Value<Boolean>> CRITICAL_HIT = KeyFactory.fake("CRITICAL_HIT");

    /**
     * Represents the {@link Key} for the "custom name visible" state
     * of an {@link Entity}.
     *
     * @see CustomNameVisibleData#customNameVisible()
     */
    public static final Key<Value<Boolean>> CUSTOM_NAME_VISIBLE = KeyFactory.fake("CUSTOM_NAME_VISIBLE");

    public static final Key<MapValue<EntityType, Double>> DAMAGE_ENTITY_MAP = KeyFactory.fake("DAMAGE_ENTITY_MAP");

    /**
     * Represents the {@link Key} for representing the "decayable" state
     * of a {@link BlockState}.
     *
     * @see DecayableData#decayable()
     */
    public static final Key<Value<Boolean>> DECAYABLE = KeyFactory.fake("DECAYABLE");

    public static final Key<MutableBoundedValue<Integer>> DELAY = KeyFactory.fake("DELAY");

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
     * @see DirtData#type()
     */
    public static final Key<Value<DirtType>> DIRT_TYPE = KeyFactory.fake("DIRT_TYPE");

    /**
     * Represents the {@link Key} for representing the "disarmed" state
     * of a {@link BlockState}.
     *
     * @see DisarmedData#disarmed()
     */
    public static final Key<Value<Boolean>> DISARMED = KeyFactory.fake("DISARMED");

    /**
     * Represents the {@link Key} for representing the {@link DisguisedBlockType}
     * of a {@link BlockState}.
     *
     * @see DisguisedBlockData#type()
     */
    public static final Key<Value<DisguisedBlockType>> DISGUISED_BLOCK_TYPE = KeyFactory.fake("DISGUISED_BLOCK_TYPE");

    public static final Key<Value<Text>> DISPLAY_NAME = KeyFactory.fake("DISPLAY_NAME");

    /**
     * Represents the {@link Key} for representing the dominant {@link HandType}
     * of a {@link Living} entity.
     *
     * @see DominantHandData#dominantHand()
     */
    public static final Key<Value<HandType>> DOMINANT_HAND = KeyFactory.fake("DOMINANT_HAND");

    /**
     * Represents the {@link Key} for representing the {@link DoublePlantType}
     * of a {@link BlockState}.
     *
     * @see DoublePlantData#type()
     */
    public static final Key<Value<DoublePlantType>> DOUBLE_PLANT_TYPE = KeyFactory.fake("DOUBLE_PLANT_TYPE");

    public static final Key<Value<DyeColor>> DYE_COLOR = KeyFactory.fake("DYE_COLOR");

    public static final Key<Value<Boolean>> ELDER_GUARDIAN = KeyFactory.fake("ELDER_GUARDIAN");

    public static final Key<MutableBoundedValue<Double>> EXHAUSTION = KeyFactory.fake("EXHAUSTION");

    public static final Key<ImmutableBoundedValue<Integer>> EXPERIENCE_FROM_START_OF_LEVEL = KeyFactory.fake("EXPERIENCE_FROM_START_OF_LEVEL");

    public static final Key<MutableBoundedValue<Integer>> EXPERIENCE_LEVEL = KeyFactory.fake("EXPERIENCE_LEVEL");

    public static final Key<MutableBoundedValue<Integer>> EXPERIENCE_SINCE_LEVEL = KeyFactory.fake("EXPERIENCE_SINCE_LEVEL");

    public static final Key<MutableBoundedValue<Integer>> EXPIRATION_TICKS = KeyFactory.fake("EXPIRATION_TICKS");

    public static final Key<OptionalValue<Integer>> EXPLOSION_RADIUS = KeyFactory.fake("EXPLOSION_RADIUS");

    /**
     * Represents the {@link Key} for representing the {@link BigMushroomType}
     * of a {@link BlockState}.
     *
     * @see ExtendedData#extended()
     */
    public static final Key<Value<Boolean>> EXTENDED = KeyFactory.fake("EXTENDED");

    public static final Key<Value<Boolean>> FALLING_BLOCK_CAN_HURT_ENTITIES = KeyFactory.fake("FALLING_BLOCK_CAN_HURT_ENTITIES");

    public static final Key<Value<BlockState>> FALLING_BLOCK_STATE = KeyFactory.fake("FALLING_BLOCK_STATE");

    public static final Key<MutableBoundedValue<Double>> FALL_DAMAGE_PER_BLOCK = KeyFactory.fake("FALL_DAMAGE_PER_BLOCK");

    /**
     * Represents the {@link Key} for representing the distance an entity has
     * fallen.
     *
     * @see FallDistanceData#fallDistance()
     */
    public static final Key<MutableBoundedValue<Float>> FALL_DISTANCE = KeyFactory.fake("FALL_DISTANCE");

    public static final Key<Value<Integer>> FALL_TIME = KeyFactory.fake("FALL_TIME");

    /**
     * Represents the {@link Key} for representing the "filled" state
     * of a {@link BlockState}.
     *
     * @see FilledData#filled()
     */
    public static final Key<Value<Boolean>> FILLED = KeyFactory.fake("FILLED");

    public static final Key<ListValue<FireworkEffect>> FIREWORK_EFFECTS = KeyFactory.fake("FIREWORK_EFFECTS");

    public static final Key<MutableBoundedValue<Integer>> FIREWORK_FLIGHT_MODIFIER = KeyFactory.fake("FIREWORK_FLIGHT_MODIFIER");

    public static final Key<MutableBoundedValue<Integer>> FIRE_DAMAGE_DELAY = KeyFactory.fake("FIRE_DAMAGE_DELAY");

    public static final Key<MutableBoundedValue<Integer>> FIRE_TICKS = KeyFactory.fake("FIRE_TICKS");

    public static final Key<Value<Instant>> FIRST_DATE_PLAYED = KeyFactory.fake("FIRST_DATE_PLAYED");

    public static final Key<Value<Fish>> FISH_TYPE = KeyFactory.fake("FISH_TYPE");

    /**
    /**
     * Represents the {@link Key} for representing the
     * {@link FluidStackSnapshot} contained within an item container. Item
     * containers may include buckets and other mod added items.
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
     * information
     */
    public static final Key<MapValue<Direction, List<FluidStackSnapshot>>> FLUID_TANK_CONTENTS = KeyFactory.fake("FLUID_TANK_CONTENTS");

    public static final Key<Value<Double>> FLYING_SPEED = KeyFactory.fake("FLYING_SPEED");

    public static final Key<MutableBoundedValue<Integer>> FOOD_LEVEL = KeyFactory.fake("FOOD_LEVEL");

    public static final Key<Value<Integer>> FUSE_DURATION = KeyFactory.fake("FUSE_DURATION");

    public static final Key<Value<GameMode>> GAME_MODE = KeyFactory.fake("GAME_MODE");

    public static final Key<MutableBoundedValue<Integer>> GENERATION = KeyFactory.fake("GENERATION");

    /**
     * Represents the {@link Key} for representing whether an entity has a
     * glowing outline.
     *
     * @see GlowingData#glowing()
     */
    public static final Key<Value<Boolean>> GLOWING = KeyFactory.fake("GLOWING");

    public static final Key<Value<GoldenApple>> GOLDEN_APPLE_TYPE = KeyFactory.fake("GOLDEN_APPLE_TYPE");

    /**
     * Represents the {@link Key} for representing the "growth stage" state
     * of a {@link BlockState}.
     *
     * @see GrowthData#growthStage()
     */
    public static final Key<MutableBoundedValue<Integer>> GROWTH_STAGE = KeyFactory.fake("GROWTH_STAGE");

    public static final Key<Value<Vector3d>> HEAD_ROTATION = KeyFactory.fake("HEAD_ROTATION");

    public static final Key<MutableBoundedValue<Double>> HEALTH = KeyFactory.fake("HEALTH");

    public static final Key<MutableBoundedValue<Double>> HEALTH_SCALE = KeyFactory.fake("HEALTH_SCALE");

    public static final Key<MutableBoundedValue<Float>> HEIGHT = KeyFactory.fake("HEIGHT");

    public static final Key<MutableBoundedValue<Integer>> HELD_EXPERIENCE = KeyFactory.fake("HELD_EXPERIENCE");

    /**
     * Represents the {@link Key} for representing the "attributes hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideAttributes()
     */
    public static final Key<Value<Boolean>> HIDE_ATTRIBUTES = KeyFactory.fake("HIDE_ATTRIBUTES");

    /**
     * Represents the {@link Key} for representing the "can destroy hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideCanDestroy()
     */
    public static final Key<Value<Boolean>> HIDE_CAN_DESTROY = KeyFactory.fake("HIDE_CAN_DESTROY");

    /**
     * Represents the {@link Key} for representing the "can place hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideCanPlace()
     */
    public static final Key<Value<Boolean>> HIDE_CAN_PLACE = KeyFactory.fake("HIDE_CAN_PLACE");

    /**
     * Represents the {@link Key} for representing the "enchantments hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideEnchantments()
     */
    public static final Key<Value<Boolean>> HIDE_ENCHANTMENTS = KeyFactory.fake("HIDE_ENCHANTMENTS");

    /**
     * Represents the {@link Key} for representing the "miscellaneous hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideMiscellaneous()
     */
    public static final Key<Value<Boolean>> HIDE_MISCELLANEOUS = KeyFactory.fake("HIDE_MISCELLANEOUS");

    /**
     * Represents the {@link Key} for representing the "unbreakable hidden"
     * state of a {@link ItemStack}.
     *
     * @see HideData#hideUnbreakable()
     */
    public static final Key<Value<Boolean>> HIDE_UNBREAKABLE = KeyFactory.fake("HIDE_UNBREAKABLE");

    /**
     * Represents the {@link Key} for representing the {@link Hinge}
     * of a {@link BlockState}.
     *
     * @see HingeData#type()
     */
    public static final Key<Value<Hinge>> HINGE_POSITION = KeyFactory.fake("HINGE_POSITION");

    public static final Key<Value<HorseColor>> HORSE_COLOR = KeyFactory.fake("HORSE_COLOR");

    public static final Key<Value<HorseStyle>> HORSE_STYLE = KeyFactory.fake("HORSE_STYLE");

    public static final Key<Value<HorseVariant>> HORSE_VARIANT = KeyFactory.fake("HORSE_VARIANT");

    /**
     * Represents the {@link Key} for representing the "vanish" state
     * of an {@link Entity}. This will only simply render the entity as
     * vanish, but not prevent any entity updates being sent to clients.
     * To fully "vanish" an {@link Entity}, use {@link #VANISH}.
     */
    public static final Key<Value<Boolean>> INVISIBLE = KeyFactory.fake("INVISIBLE");

    public static final Key<MutableBoundedValue<Integer>> INVULNERABILITY_TICKS = KeyFactory.fake("INVULNERABILITY_TICKS");

    /**
     * Represents the {@link Key} for representing the "in-wall" state of
     * {@link BlockTypes#FENCE}s.
     *
     * @see InWallData#inWall()
     */
    public static final Key<Value<Boolean>> IN_WALL = KeyFactory.fake("IN_WALL");

    public static final Key<Value<Boolean>> IS_AFLAME = KeyFactory.fake("IS_AFLAME");

    public static final Key<Value<Boolean>> IS_FLYING = KeyFactory.fake("IS_FLYING");

    public static final Key<Value<Boolean>> IS_PLAYING = KeyFactory.fake("IS_PLAYING");

    public static final Key<Value<Boolean>> IS_SCREAMING = KeyFactory.fake("IS_SCREAMING");

    public static final Key<Value<Boolean>> IS_SHEARED = KeyFactory.fake("IS_SHEARED");

    public static final Key<Value<Boolean>> IS_SILENT = KeyFactory.fake("IS_SILENT");

    public static final Key<Value<Boolean>> IS_SITTING = KeyFactory.fake("IS_SITTING");

    public static final Key<Value<Boolean>> IS_SLEEPING = KeyFactory.fake("IS_SLEEPING");

    public static final Key<Value<Boolean>> IS_SNEAKING = KeyFactory.fake("IS_SNEAKING");

    public static final Key<Value<Boolean>> IS_SPRINTING = KeyFactory.fake("IS_SPRINTING");

    public static final Key<Value<Boolean>> IS_WET = KeyFactory.fake("IS_WET");

    public static final Key<Value<BlockState>> ITEM_BLOCKSTATE = KeyFactory.fake("ITEM_BLOCKSTATE");

    public static final Key<MutableBoundedValue<Integer>> ITEM_DURABILITY = KeyFactory.fake("ITEM_DURABILITY");

    public static final Key<ListValue<ItemEnchantment>> ITEM_ENCHANTMENTS = KeyFactory.fake("ITEM_ENCHANTMENTS");

    public static final Key<ListValue<Text>> ITEM_LORE = KeyFactory.fake("ITEM_LORE");

    public static final Key<MutableBoundedValue<Integer>> KNOCKBACK_STRENGTH = KeyFactory.fake("KNOCKBACK_STRENGTH");

    public static final Key<OptionalValue<Living>> LAST_ATTACKER = KeyFactory.fake("LAST_ATTACKER");

    public static final Key<OptionalValue<Text>> LAST_COMMAND_OUTPUT = KeyFactory.fake("LAST_COMMAND_OUTPUT");

    public static final Key<OptionalValue<Double>> LAST_DAMAGE = KeyFactory.fake("LAST_DAMAGE");

    public static final Key<Value<Instant>> LAST_DATE_PLAYED = KeyFactory.fake("LAST_DATE_PLAYED");

    /**
     * Represents the {@link Key} for representing the "layer" value of
     * {@link BlockTypes#SNOW_LAYER} and other possible layered blocks.
     *
     * @see LayeredData#layer()
     */
    public static final Key<MutableBoundedValue<Integer>> LAYER = KeyFactory.fake("LAYER");

    public static final Key<Value<EntitySnapshot>> LEASH_HOLDER = KeyFactory.fake("LEASH_HOLDER");

    public static final Key<Value<Vector3d>> LEFT_ARM_ROTATION = KeyFactory.fake("LEFT_ARM_ROTATION");

    public static final Key<Value<Vector3d>> LEFT_LEG_ROTATION = KeyFactory.fake("LEFT_LEG_ROTATION");

    public static final Key<Value<String>> LOCK_TOKEN = KeyFactory.fake("LOCK_TOKEN");

    public static final Key<Value<LogAxis>> LOG_AXIS = KeyFactory.fake("LOG_AXIS");

    public static final Key<MutableBoundedValue<Integer>> MAX_AIR = KeyFactory.fake("MAX_AIR");

    public static final Key<MutableBoundedValue<Integer>> MAX_BURN_TIME = KeyFactory.fake("MAX_BURN_TIME");

    public static final Key<MutableBoundedValue<Integer>> MAX_COOK_TIME = KeyFactory.fake("MAX_COOK_TIME");

    public static final Key<MutableBoundedValue<Double>> MAX_FALL_DAMAGE = KeyFactory.fake("MAX_FALL_DAMAGE");

    public static final Key<MutableBoundedValue<Double>> MAX_HEALTH = KeyFactory.fake("MAX_HEALTH");

    /**
     * Represents the {@link Key} for representing the "moisture" state of
     * {@link BlockTypes#FARMLAND}.
     *
     * @see MoistureData#moisture()
     */
    public static final Key<MutableBoundedValue<Integer>> MOISTURE = KeyFactory.fake("MOISTURE");

    public static final Key<Value<NotePitch>> NOTE_PITCH = KeyFactory.fake("NOTE_PITCH");

    /**
     * Represents the {@link Key} for representing the "occupied" state of
     * {@link BlockTypes#BED}.
     *
     * @see OccupiedData#occupied()
     */
    public static final Key<Value<Boolean>> OCCUPIED = KeyFactory.fake("OCCUPIED");

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

    public static final Key<MutableBoundedValue<Integer>> PASSED_BURN_TIME = KeyFactory.fake("PASSED_BURN_TIME");

    public static final Key<MutableBoundedValue<Integer>> PASSED_COOK_TIME = KeyFactory.fake("PASSED_COOK_TIME");

    public static final Key<ListValue<EntitySnapshot>> PASSENGERS = KeyFactory.fake("PASSENGERS");

    public static final Key<Value<Boolean>> PERSISTS = KeyFactory.fake("PERSISTS");

    /**
     * Represents the {@link Key} for the "pickup rule" of an {@link Arrow}.
     *
     * @see PickupRuleData#type()
     */
    public static final Key<Value<PickupRule>> PICKUP_RULE = KeyFactory.fake("PICKUP_RULE");

    public static final Key<Value<Boolean>> PIG_SADDLE = KeyFactory.fake("PIG_SADDLE");

    /**
     * Represents the {@link Key} for representing the {@link PistonType}
     * of a {@link BlockTypes#PISTON}.
     *
     * @see PistonData#type()
     */
    public static final Key<Value<PistonType>> PISTON_TYPE = KeyFactory.fake("PISTON_TYPE");

    public static final Key<SetValue<BlockType>> PLACEABLE_BLOCKS = KeyFactory.fake("PLACEABLE_BLOCKS");

    /**
     * Represents the {@link Key} for representing the {@link PlantType}
     * of a {@link BlockState}.
     *
     * @see PlantData#type()
     */
    public static final Key<Value<PlantType>> PLANT_TYPE = KeyFactory.fake("PLANT_TYPE");

    public static final Key<Value<Boolean>> PLAYER_CREATED = KeyFactory.fake("PLAYER_CREATED");

    /**
     * Represents the {@link Key} for representing the {@link PortionType}
     * of a {@link BlockState}.
     *
     * @see PortionData#type()
     */
    public static final Key<Value<PortionType>> PORTION_TYPE = KeyFactory.fake("PORTION_TYPE");

    public static final Key<ListValue<PotionEffect>> POTION_EFFECTS = KeyFactory.fake("POTION_EFFECTS");

    /**
     * Represents the {@link Key} for representing the "power" state
     * of a {@link BlockState}.
     *
     * @see RedstonePoweredData#power()
     */
    public static final Key<MutableBoundedValue<Integer>> POWER = KeyFactory.fake("POWER");

    /**
     * Represents the {@link Key} for representing the "powered" state
     * of a {@link BlockState}.
     *
     * @see PoweredData#powered()
     */
    public static final Key<Value<Boolean>> POWERED = KeyFactory.fake("POWERED");

    /**
     * Represents the {@link Key} for representing the {@link PrismarineType}
     * of a {@link BlockState}.
     *
     * @see PrismarineData#type()
     */
    public static final Key<Value<PrismarineType>> PRISMARINE_TYPE = KeyFactory.fake("PRISMARINE_TYPE");

    /**
     * Represents the {@link Key} for representing the {@link QuartzType}
     * of a {@link BlockState}.
     *
     * @see QuartzData#type()
     */
    public static final Key<Value<QuartzType>> QUARTZ_TYPE = KeyFactory.fake("QUARTZ_TYPE");

    public static final Key<Value<RabbitType>> RABBIT_TYPE = KeyFactory.fake("RABBIT_TYPE");

    /**
     * Represents the {@link Key} for representing the {@link RailDirection}
     * of a {@link BlockState}.
     *
     * @see RailDirectionData#type()
     */
    public static final Key<Value<RailDirection>> RAIL_DIRECTION = KeyFactory.fake("RAIL_DIRECTION");

    public static final Key<MutableBoundedValue<Integer>> REMAINING_AIR = KeyFactory.fake("REMAINING_AIR");

    public static final Key<MutableBoundedValue<Integer>> REMAINING_BREW_TIME = KeyFactory.fake("REMAINING_BREW_TIME");

    /**
     * Represents the {@link Key} for representing the {@link BlockState}
     * inside a {@link Minecart}.
     *
     * @see MinecartBlockData#block()
     */
    public static final Key<Value<BlockState>> REPRESENTED_BLOCK = KeyFactory.fake("REPRESENTED_BLOCK");

    public static final Key<Value<ItemStackSnapshot>> REPRESENTED_ITEM = KeyFactory.fake("REPRESENTED_ITEM");

    public static final Key<Value<GameProfile>> REPRESENTED_PLAYER = KeyFactory.fake("REPRESENTED_PLAYER");

    /**
     * Represents the {@link Key} for the spawn locations a {@link Player}
     * may have for various worlds based on {@link UUID} of the world.
     */
    public static final Key<MapValue<UUID, RespawnLocation>> RESPAWN_LOCATIONS = KeyFactory.fake("RESPAWN_LOCATIONS");

    public static final Key<Value<Vector3d>> RIGHT_ARM_ROTATION = KeyFactory.fake("RIGHT_ARM_ROTATION");

    public static final Key<Value<Vector3d>> RIGHT_LEG_ROTATION = KeyFactory.fake("RIGHT_LEG_ROTATION");

    public static final Key<Value<Rotation>> ROTATION = KeyFactory.fake("ROTATION");

    /**
     * Represents the {@link Key} for representing the {@link SandstoneType}
     * of a {@link BlockState}.
     *
     * @see SandstoneData#type()
     */
    public static final Key<Value<SandstoneType>> SANDSTONE_TYPE = KeyFactory.fake("SANDSTONE_TYPE");

    /**
     * Represents the {@link Key} for representing the {@link SandType}
     * of a {@link BlockState}.
     *
     * @see SandData#type()
     */
    public static final Key<Value<SandType>> SAND_TYPE = KeyFactory.fake("SAND_TYPE");

    public static final Key<MutableBoundedValue<Double>> SATURATION = KeyFactory.fake("SATURATION");

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
     * @see ShrubData#type()
     */
    public static final Key<Value<ShrubType>> SHRUB_TYPE = KeyFactory.fake("SHRUB_TYPE");

    public static final Key<ListValue<Text>> SIGN_LINES = KeyFactory.fake("SIGN_LINES");

    public static final Key<Value<SkeletonType>> SKELETON_TYPE = KeyFactory.fake("SKELETON_TYPE");

    public static final Key<Value<UUID>> SKIN_UNIQUE_ID = KeyFactory.fake("SKIN_UNIQUE_ID");

    public static final Key<Value<SkullType>> SKULL_TYPE = KeyFactory.fake("SKULL_TYPE");

    /**
     * Represents the {@link Key} for representing the {@link SlabType}
     * of a {@link BlockState}.
     *
     * @see SlabData#type()
     */
    public static final Key<Value<SlabType>> SLAB_TYPE = KeyFactory.fake("SLAB_TYPE");

    public static final Key<MutableBoundedValue<Integer>> SLIME_SIZE = KeyFactory.fake("SLIME_SIZE");

    /**
     * Represents the {@link Key} for representing the "snowed" state
     * of a {@link BlockState}.
     *
     * @see SnowedData#hasSnow()
     */
    public static final Key<Value<Boolean>> SNOWED = KeyFactory.fake("SNOWED");

    public static final Key<Value<EntityType>> SPAWNABLE_ENTITY_TYPE = KeyFactory.fake("SPAWNABLE_ENTITY_TYPE");

    public static final Key<WeightedCollectionValue<EntitySnapshot>> SPAWNER_ENTITIES = KeyFactory.fake("SPAWNER_ENTITIES");

    public static final Key<MutableBoundedValue<Short>> SPAWNER_MAXIMUM_DELAY = KeyFactory.fake("SPAWNER_MAXIMUM_DELAY");

    public static final Key<MutableBoundedValue<Short>> SPAWNER_MAXIMUM_NEARBY_ENTITIES = KeyFactory.fake("SPAWNER_MAXIMUM_NEARBY_ENTITIES");

    public static final Key<MutableBoundedValue<Short>> SPAWNER_MINIMUM_DELAY = KeyFactory.fake("SPAWNER_MINIMUM_DELAY");

    public static final Key<MobSpawnerData.NextEntityToSpawnValue> SPAWNER_NEXT_ENTITY_TO_SPAWN = KeyFactory.fake("SPAWNER_NEXT_ENTITY_TO_SPAWN");

    public static final Key<MutableBoundedValue<Short>> SPAWNER_REMAINING_DELAY = KeyFactory.fake("SPAWNER_REMAINING_DELAY");

    public static final Key<MutableBoundedValue<Short>> SPAWNER_REQUIRED_PLAYER_RANGE = KeyFactory.fake("SPAWNER_REQUIRED_PLAYER_RANGE");

    public static final Key<MutableBoundedValue<Short>> SPAWNER_SPAWN_COUNT = KeyFactory.fake("SPAWNER_SPAWN_COUNT");

    public static final Key<MutableBoundedValue<Short>> SPAWNER_SPAWN_RANGE = KeyFactory.fake("SPAWNER_SPAWN_RANGE");

    /**
     * Represents the {@link Key} for representing the {@link StairShape}
     * of a {@link BlockState}.
     *
     * @see StairShapeData#type()
     */
    public static final Key<Value<StairShape>> STAIR_SHAPE = KeyFactory.fake("STAIR_SHAPE");

    public static final Key<MapValue<Statistic, Long>> STATISTICS = KeyFactory.fake("STATISTICS");

    /**
     * Represents the {@link Key} for representing the {@link StoneType}
     * of a {@link BlockState}.
     *
     * @see StoneData#type()
     */
    public static final Key<Value<StoneType>> STONE_TYPE = KeyFactory.fake("STONE_TYPE");

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

    public static final Key<OptionalValue<UUID>> TAMED_OWNER = KeyFactory.fake("TAMED_OWNER");

    public static final Key<Value<Vector3d>> TARGETED_LOCATION = KeyFactory.fake("TARGETED_LOCATION");

    public static final Key<Value<Integer>> TICKS_REMAINING = KeyFactory.fake("TICKS_REMAINING");

    public static final Key<MutableBoundedValue<Integer>> TOTAL_EXPERIENCE = KeyFactory.fake("TOTAL_EXPERIENCE");

    public static final Key<Value<Boolean>> TRACKS_OUTPUT = KeyFactory.fake("TRACKS_OUTPUT");

    public static final Key<ListValue<TradeOffer>> TRADE_OFFERS = KeyFactory.fake("TRADE_OFFERS");

    /**
     * Represents the {@link Key} for representing the {@link TreeType}
     * of a {@link BlockState}.
     *
     * @see TreeData#type()
     */
    public static final Key<Value<TreeType>> TREE_TYPE = KeyFactory.fake("TREE_TYPE");

    public static final Key<Value<Boolean>> UNBREAKABLE = KeyFactory.fake("UNBREAKABLE");

    /**
     * Represents the {@link Key} for representing the "vanish" state
     * of an {@link Entity}. If the state is {@code true}, the entity is
     * not only rendered invisible, but removed from being tracked by all
     * clients in the vincinity of the entity. In simpler terms, the entity
     * with a "vanish" state being {@code true} will not send any updates
     * to any clients. This may cause issues if the vanished entity is being
     * ridden by
     */
    public static final Key<Value<Boolean>> VANISH = KeyFactory.fake("VANISH");

    public static final Key<Value<Boolean>> VANISH_IGNORES_COLLISION = KeyFactory.fake("VANISH_IGNORES_COLLISION");

    /**
     *
     */
    public static final Key<Value<Boolean>> VANISH_PREVENTS_TARGETING = KeyFactory.fake("VANISH_PREVENTS_TARGETING");

    public static final Key<Value<EntitySnapshot>> VEHICLE = KeyFactory.fake("VEHICLE");

    public static final Key<Value<Vector3d>> VELOCITY = KeyFactory.fake("VELOCITY");

    public static final Key<Value<Profession>> VILLAGER_ZOMBIE_PROFESSION = KeyFactory.fake("VILLAGER_ZOMBIE_PROFESSION");

    public static final Key<Value<Double>> WALKING_SPEED = KeyFactory.fake("WALKING_SPEED");

    public static final Key<Value<WallType>> WALL_TYPE = KeyFactory.fake("WALL_TYPE");

    public static final Key<Value<Boolean>> WILL_SHATTER = KeyFactory.fake("WILL_SHATTER");

    public static final Key<MapValue<Direction, WireAttachmentType>> WIRE_ATTACHMENTS = KeyFactory.fake("WIRE_ATTACHMENTS");

    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_EAST = KeyFactory.fake("WIRE_ATTACHMENT_EAST");

    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_NORTH = KeyFactory.fake("WIRE_ATTACHMENT_NORTH");

    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_SOUTH = KeyFactory.fake("WIRE_ATTACHMENT_SOUTH");

    public static final Key<Value<WireAttachmentType>> WIRE_ATTACHMENT_WEST = KeyFactory.fake("WIRE_ATTACHMENT_WEST");

    // SORTFIELDS:OFF

    private Keys() {}
}
