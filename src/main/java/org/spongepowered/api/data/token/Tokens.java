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
package org.spongepowered.api.data.token;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.attribute.AttributeModifier;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.type.Art;
import org.spongepowered.api.data.type.BigMushroomType;
import org.spongepowered.api.data.type.BrickType;
import org.spongepowered.api.data.type.Career;
import org.spongepowered.api.data.type.CoalType;
import org.spongepowered.api.data.type.Comparison;
import org.spongepowered.api.data.type.CookedFish;
import org.spongepowered.api.data.type.DirtType;
import org.spongepowered.api.data.type.DisguisedBlockType;
import org.spongepowered.api.data.type.DoubleSizePlantType;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.Fish;
import org.spongepowered.api.data.type.GoldenApple;
import org.spongepowered.api.data.type.Hinge;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.HorseVariant;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.OcelotType;
import org.spongepowered.api.data.type.PistonType;
import org.spongepowered.api.data.type.PortionType;
import org.spongepowered.api.data.type.PrismarineType;
import org.spongepowered.api.data.type.QuartzType;
import org.spongepowered.api.data.type.RabbitType;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SandType;
import org.spongepowered.api.data.type.SandstoneType;
import org.spongepowered.api.data.type.ShrubType;
import org.spongepowered.api.data.type.SkeletonType;
import org.spongepowered.api.data.type.SkullType;
import org.spongepowered.api.data.type.SlabType;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StoneType;
import org.spongepowered.api.data.type.TreeType;
import org.spongepowered.api.data.type.WallType;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.potion.PotionEffectType;
import org.spongepowered.api.statistic.achievement.Achievement;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.ban.Ban;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.util.weighted.WeightedCollection;
import org.spongepowered.api.util.weighted.WeightedEntity;
import org.spongepowered.api.world.Location;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public final class Tokens {

    private Tokens() {
    }

    // General
    public static final Token<Color> COLOR = null;
    public static final Token<Text> DISPLAY_NAME = null;
    public static final Token<DyeColor> DYE_COLOR = null;
    public static final BooleanToken IS_WET = null;
    public static final Token<GameProfile> OWNED = null;
    public static final Token<ItemStack> REPRESENTED_ITEM = null;
    public static final Token<Rotation> ROTATION = null;
    public static final BooleanToken SHOW_DISPLAY_NAME = null;
    public static final Token<SkullType> SKULL_TYPE = null;
    public static final Token<Location> TARGETED_LOCATION = null;

    // Block
    public static final BooleanToken ATTACHED = null;
    public static final Token<Axis> AXIS = null;
    public static final Token<BigMushroomType> BIG_MUSHROOM_TYPE = null;
    public static final Token<BrickType> BRICK_TYPE = null;
    public static final Token<Comparison> COMPARISON = null;
    public static final Token<List<Direction>> CONNECTED_DIRECTION = null;
    public static final BooleanToken DECAYABLE = null;
    public static final Token<Direction> DIRECTION = null;
    public static final Token<DirtType> DIRT_TYPE = null;
    public static final BooleanToken DISARMED = null;
    public static final Token<DisguisedBlockType> DISGUISED_BLOCK_TYPE = null;
    public static final Token<DoubleSizePlantType> DOUBLE_SIZE_PLANT_TYPE = null;
    public static final BooleanToken FILLED = null;
    public static final IntegerToken FLUID_LEVEL = null;
    public static final IntegerToken GROWTH_LEVEL = null;
    public static final Token<Hinge> HINGE = null;
    public static final BooleanToken IN_WALL = null;
    public static final Token<InstrumentType> INSTRUMENT_TYPE = null;
    public static final IntegerToken LAYER = null;
    public static final GetterToken<Integer> MAX_LAYERS = null;
    public static final IntegerToken MOISTURE = null;
    public static final GetterToken<Integer> MAX_MOISTURE = null;
    public static final BooleanToken NO_DROP = null;
    public static final BooleanToken OCCUPIED = null;
    public static final BooleanToken OPEN = null;
    public static final BooleanToken PISTON_EXTENDED = null;
    public static final Token<PistonType> PISTON_TYPE = null;
    public static final Token<PortionType> PORTION_TYPE = null;
    public static final BooleanToken POWERED = null;
    public static final Token<PrismarineType> PRISMARINE_TYPE = null;
    public static final Token<QuartzType> QUARTZ_TYPE = null;
    public static final Token<RailDirection> RAIL_DIRECTION = null;
    public static final IntegerToken REDSTONE_OUTPUT = null;
    public static final IntegerToken REDSTONE_POWER = null;
    public static final Token<SandType> SAND_TYPE = null;
    public static final Token<SandstoneType> SANDSTONE_TYPE = null;
    public static final BooleanToken SEAMLESS = null;
    public static final Token<ShrubType> SHRUB_TYPE = null;
    public static final Token<SlabType> SLAB_TYPE = null;
    public static final BooleanToken SNOWED = null;
    public static final Token<StairShape> STAIR_SHAPE = null;
    public static final Token<StoneType> STONE_TYPE = null;
    public static final BooleanToken SUSPENDED = null;
    public static final Token<TreeType> TREE_TYPE = null;
    public static final Token<WallType> WALL_TYPE = null;
    public static final Token<WireAttachmentType> WIRE_ATTACHMENT_TYPE = null;

    // Entity
    public static final Token<List<Achievement>> ACHIEVEMENTS = null;
    public static final BooleanToken AFLAME = null;
    public static final IntegerToken AGE = null;
    public static final IntegerToken AIR = null;
    public static final BooleanToken AI_ENABLED = null;
    public static final Token<Integer> ANGER = null;
    public static final Token<Art> ART = null;
    public static final Token<List<AttributeModifier>> ATTRIBUTE_MODIFIERS = null;
    public static final Token<List<Ban.User>> BANS = null;
    public static final GetterToken<Entity> BASE_VEHICLE = null;
    public static final GetterToken<Float> BASE_SIZE = null;
    public static final Token<BlockState> BLOCK_STATE = null;
    public static final GetterToken<Float> BOUNDING_BOX_SCALE = null;
    public static final BooleanToken BREEDABLE = null;
    public static final Token<Career> CAREER = null;
    public static final BooleanToken CHARGED = null;
    public static final BooleanToken CRITICAL_HIT = null;
    public static final BooleanToken CAN_PLACE = null;
    public static final BooleanToken CAN_DROP = null;
    public static final BooleanToken CAN_GRIEF = null;
    public static final Token<String> COMMAND = null;
    public static final DoubleToken DAMAGE = null;
    public static final DoubleToken DAMAGE_PER_BLOCK = null;
    public static final BooleanToken ELDER = null;
    public static final Token<WeightedCollection<WeightedEntity>> ENTITIES_TO_SPAWN = null;
    public static final DoubleToken EXHAUSTION = null;
    public static final IntegerToken EXPERIENCE_TO_GRANT = null;
    public static final IntegerToken EXPERIENCE_LEVEL = null;
    public static final IntegerToken EXPERIENCE_SINCE_LEVEL = null;
    public static final IntegerToken EXPLOSIVE_RADIUS = null;
    public static final GetterToken<Double> EYE_HEIGHT = null;
    public static final GetterToken<Vector3d> EYE_LOCATION = null;
    public static final DoubleToken FOOD_LEVEL = null;
    public static final IntegerToken FIRE_DELAY = null;
    public static final IntegerToken FIRE_TICKS = null;
    public static final Token<List<FireworkEffect>> FIREWORK_EFFECTS = null;
    public static final GetterToken<Date> FIRST_PLAYED = null;
    public static final IntegerToken FLIGHT_MODIFIER = null;
    public static final IntegerToken FUSE_DURATION = null;
    public static final Token<GameMode> GAME_MODE = null;
    public static final Token<Entity> HEALING_SOURCE = null;
    public static final BoundedToken<Double> HEALTH = null;
    public static final Token<HorseStyle> HORSE_STYLE = null;
    public static final Token<HorseColor> HORSE_COLOR = null;
    public static final Token<HorseVariant> HORSE_VARIANT = null;
    public static final GetterToken<Float> HEIGHT = null;
    public static final IntegerToken INVULNERABILITY_TICKS = null;
    public static final BooleanToken IS_SLEEPING = null;
    public static final BooleanToken IS_SNEAKING = null;
    public static final BooleanToken IS_AGGRESSIVE = null;
    public static final BooleanToken IS_FLYING = null;
    public static final BooleanToken IS_INVISIBLE = null;
    public static final BooleanToken IS_PLAYER_CREATED = null;
    public static final BooleanToken IS_PLAYING = null;
    public static final BooleanToken IS_SCREAMING = null;
    public static final BooleanToken IS_SHEARED = null;
    public static final BooleanToken IS_SITTING = null;
    public static final BooleanToken IS_VILLAGER_ZOMBIE = null;
    public static final BooleanToken IS_WHITELISTED = null;
    public static final IntegerToken KNOCKBACK_TOKEN = null;
    public static final GetterToken<Date> LAST_PLAYED = null;
    public static final Token<Living> LAST_ATTACKER = null;
    public static final DoubleToken LAST_DAMAGE = null;
    public static final Token<Entity> LEASH_HOLDER = null;
    public static final Token<List<Living>> LIVING_TARGETS = null;
    public static final GetterToken<Integer> MAX_AIR = null;
    public static final DoubleToken MAX_FALL_DAMAGE = null;
    public static final BoundedToken<Short> MAXIMUM_NEARBY_ENTITIES = null;
    public static final BoundedToken<Short> MAXIMUM_SPAWN_DELAY = null;
    public static final BoundedToken<Double> MAX_HEALTH = null;
    public static final BoundedToken<Short> MINIMUM_SPAWN_DELAY = null;
    public static final Token<OcelotType> OCELOT_TYPE = null;
    public static final BooleanToken OUTPUT_TRACKED = null;
    public static final Token<Entity> PASSENGER = null;
    public static final BooleanToken PERSISTS = null;
    public static final Token<List<PotionEffect>> POTION_EFFECTS = null;
    public static final Token<Text> PREVIOUS_OUTPUT = null;
    public static final Token<GameProfile> PROFILE = null;
    public static final Token<SkeletonType> SKELETON_TYPE = null;
    public static final Token<RabbitType> RABBIT_TYPE = null;
    public static final IntegerToken REMAINING_TICKS = null;
    public static final BoundedToken<Short> REQUIRED_PLAYER_RANGE = null;
    public static final Token<Location> RESPAWN_POINT = null;
    public static final Token<ItemStack> SADDLE = null;
    public static final DoubleToken SATURATION = null;
    public static final Token<UUID> SKIN_UUID = null;
    public static final IntegerToken SLIME_SIZE = null;
    public static final BoundedToken<Short> SPAWN_DELAY = null;
    public static final BoundedToken<Short> SPAWN_RANGE = null;
    public static final BoundedToken<Short> SPAWN_SUCCESS_COUNT = null;
    public static final IntegerToken SUCCESS_COUNT = null;
    public static final Token<Tamer> TAMER = null;
    public static final IntegerToken TOTAL_EXPERIENCE = null;
    public static final Token<List<TradeOffer>> TRADE_OFFERS = null;
    public static final Token<Vector3d> VELOCITY = null;
    public static final Token<Entity> VEHICLE = null;
    public static final BooleanToken WILL_SHATTER = null;

    // Items
    public static final Token<Text> BOOK_AUTHOR = null;
    public static final IntegerToken BOOK_GENERATION = null;
    public static final Token<List<Text>> BOOK_PAGES = null;
    public static final Token<Text> BOOK_TITLE = null;
    public static final Token<List<BlockType>> BREAKABLE_BLOCKS = null;
    public static final Token<CoalType> COAL_TYPE = null;
    public static final Token<CookedFish> COOKED_FISH = null;
    public static final IntegerToken DURABILITY = null;
    public static final Token<Fish> FISH = null;
    public static final Token<GoldenApple> GOLDEN_APPLE = null;
    public static final Token<List<Text>> ITEM_LORE = null;
    public static final GetterToken<Integer> MAX_BOOK_GENERATION = null;
    public static final GetterToken<Integer> MAX_DURABILITY = null;
    public static final Token<List<BlockType>> PLACEABLE_BLOCKS = null;
    public static final Token<BlockState> STORED_BLOCKSTATE = null;
    public static final Token<EntityType> SPAWNABLE_ENTITY = null;
    public static final BooleanToken UNBREAKABLE = null;

    // TileEntities
    public static final IntegerToken COOLDOWN = null;
    public static final Token<String> LOCK_TOKEN = null;
    public static final Token<NotePitch> NOTE_PITCH = null;
    public static final Token<PotionEffectType> PRIMARY_BEACON_EFFECT = null;
    public static final IntegerToken REMAINING_BREW_TIME = null;
    public static final IntegerToken REMAINING_FURNACE_BURN_TIME = null;
    public static final IntegerToken REMAINING_FURNACE_COOK_TIME = null;
    public static final Token<PotionEffectType> SECONDARY_BEACON_EFFECT = null;
    public static final Token<List<Text>> SIGN_TEXT = null;

}
