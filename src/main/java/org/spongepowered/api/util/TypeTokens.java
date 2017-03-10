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
package org.spongepowered.api.util;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.reflect.TypeToken;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.meta.PatternLayer;
import org.spongepowered.api.data.type.Art;
import org.spongepowered.api.data.type.BigMushroomType;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.type.BrickType;
import org.spongepowered.api.data.type.Career;
import org.spongepowered.api.data.type.CoalType;
import org.spongepowered.api.data.type.ComparatorType;
import org.spongepowered.api.data.type.CookedFish;
import org.spongepowered.api.data.type.DirtType;
import org.spongepowered.api.data.type.DisguisedBlockType;
import org.spongepowered.api.data.type.DoublePlantType;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.Fish;
import org.spongepowered.api.data.type.GoldenApple;
import org.spongepowered.api.data.type.Hinge;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.LogAxis;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.OcelotType;
import org.spongepowered.api.data.type.PickupRule;
import org.spongepowered.api.data.type.PistonType;
import org.spongepowered.api.data.type.PlantType;
import org.spongepowered.api.data.type.PortionType;
import org.spongepowered.api.data.type.PrismarineType;
import org.spongepowered.api.data.type.Profession;
import org.spongepowered.api.data.type.QuartzType;
import org.spongepowered.api.data.type.RabbitType;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SandType;
import org.spongepowered.api.data.type.SandstoneType;
import org.spongepowered.api.data.type.ShrubType;
import org.spongepowered.api.data.type.SkullType;
import org.spongepowered.api.data.type.SlabType;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StoneType;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.type.TreeType;
import org.spongepowered.api.data.type.WallType;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.data.value.mutable.WeightedCollectionValue;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.achievement.Achievement;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.util.weighted.WeightedSerializableObject;
import org.spongepowered.api.util.weighted.WeightedTable;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@SuppressWarnings("deprecation")
public class TypeTokens {

    // SORTFIELDS:ON

    public static final TypeToken<Set<Achievement>> ACHIEVEMENT_SET_TOKEN = new TypeToken<Set<Achievement>>() {};

    public static final TypeToken<SetValue<Achievement>> ACHIEVEMENT_SET_VALUE_TOKEN = new TypeToken<SetValue<Achievement>>() {};

    public static final TypeToken<Art> ART_TOKEN = new TypeToken<Art>() {};

    public static final TypeToken<Value<Art>> ART_VALUE_TOKEN = new TypeToken<Value<Art>>() {};

    public static final TypeToken<Axis> AXIS_TOKEN = new TypeToken<Axis>() {};

    public static final TypeToken<Value<Axis>> AXIS_VALUE_TOKEN = new TypeToken<Value<Axis>>() {};

    public static final TypeToken<BlockState> BLOCK_TOKEN = new TypeToken<BlockState>() {};

    public static final TypeToken<Value<BlockState>> BLOCK_VALUE_TOKEN = new TypeToken<Value<BlockState>>() {};

    public static final TypeToken<Boolean> BOOLEAN_TOKEN = new TypeToken<Boolean>() {};

    public static final TypeToken<Value<Boolean>> BOOLEAN_VALUE_TOKEN = new TypeToken<Value<Boolean>>() {};

    public static final TypeToken<MutableBoundedValue<Double>> BOUNDED_DOUBLE_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Double>>() {};

    public static final TypeToken<MutableBoundedValue<Integer>> BOUNDED_INTEGER_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Integer>>() {};

    public static final TypeToken<MutableBoundedValue<Short>> BOUNDED_SHORT_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Short>>() {};

    public static final TypeToken<BrickType> BRICK_TOKEN = new TypeToken<BrickType>() {};

    public static final TypeToken<Value<BrickType>> BRICK_VALUE_TOKEN = new TypeToken<Value<BrickType>>() {};

    public static final TypeToken<Career> CAREER_TOKEN = new TypeToken<Career>() {};

    public static final TypeToken<Value<Career>> CAREER_VALUE_TOKEN = new TypeToken<Value<Career>>() {};

    public static final TypeToken<CoalType> COAL_TOKEN = new TypeToken<CoalType>() {};

    public static final TypeToken<Value<CoalType>> COAL_VALUE_TOKEN = new TypeToken<Value<CoalType>>() {};

    public static final TypeToken<Color> COLOR_TOKEN = new TypeToken<Color>() {};

    public static final TypeToken<Value<Color>> COLOR_VALUE_TOKEN = new TypeToken<Value<Color>>() {};

    public static final TypeToken<ComparatorType> COMPARATOR_TOKEN = new TypeToken<ComparatorType>() {};

    public static final TypeToken<Value<ComparatorType>> COMPARATOR_VALUE_TOKEN = new TypeToken<Value<ComparatorType>>() {};

    public static final TypeToken<CookedFish> COOKED_FISH_TOKEN = new TypeToken<CookedFish>() {};

    public static final TypeToken<Value<CookedFish>> COOKED_FISH_VALUE_TOKEN = new TypeToken<Value<CookedFish>>() {};

    public static final TypeToken<Direction> DIRECTION_TOKEN = new TypeToken<Direction>() {};

    public static final TypeToken<Value<Direction>> DIRECTION_VALUE_TOKEN = new TypeToken<Value<Direction>>() {};

    public static final TypeToken<DirtType> DIRT_TOKEN = new TypeToken<DirtType>() {};

    public static final TypeToken<Value<DirtType>> DIRT_VALUE_TOKEN = new TypeToken<Value<DirtType>>() {};

    public static final TypeToken<DisguisedBlockType> DISGUISED_BLOCK_TOKEN = new TypeToken<DisguisedBlockType>() {};

    public static final TypeToken<Value<DisguisedBlockType>> DISGUISED_BLOCK_VALUE_TOKEN = new TypeToken<Value<DisguisedBlockType>>() {};

    public static final TypeToken<DoublePlantType> DOUBLE_PLANT_TOKEN = new TypeToken<DoublePlantType>() {};

    public static final TypeToken<Value<DoublePlantType>> DOUBLE_PLANT_VALUE_TOKEN = new TypeToken<Value<DoublePlantType>>() {};

    public static final TypeToken<Double> DOUBLE_TOKEN = new TypeToken<Double>() {};

    public static final TypeToken<Value<Double>> DOUBLE_VALUE_TOKEN = new TypeToken<Value<Double>>() {};

    public static final TypeToken<DyeColor> DYE_COLOR_TOKEN = new TypeToken<DyeColor>() {};

    public static final TypeToken<Value<DyeColor>> DYE_COLOR_VALUE_TOKEN = new TypeToken<Value<DyeColor>>() {};

    public static final TypeToken<EntitySnapshot> ENTITY_TOKEN = new TypeToken<EntitySnapshot>() {};

    public static final TypeToken<EntityType> ENTITY_TYPE_TOKEN = new TypeToken<EntityType>() {};

    public static final TypeToken<Value<EntityType>> ENTITY_TYPE_VALUE_TOKEN = new TypeToken<Value<EntityType>>() {};

    public static final TypeToken<Value<EntitySnapshot>> ENTITY_VALUE_TOKEN = new TypeToken<Value<EntitySnapshot>>() {};

    public static final TypeToken<Fish> FISH_TOKEN = new TypeToken<Fish>() {};

    public static final TypeToken<Value<Fish>> FISH_VALUE_TOKEN = new TypeToken<Value<Fish>>() {};

    public static final TypeToken<Float> FLOAT_TOKEN = new TypeToken<Float>() {};

    public static final TypeToken<MutableBoundedValue<Float>> FLOAT_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Float>>() {};

    public static final TypeToken<FluidStackSnapshot> FLUID_TOKEN = new TypeToken<FluidStackSnapshot>() {};

    public static final TypeToken<Value<FluidStackSnapshot>> FLUID_VALUE_TOKEN = new TypeToken<Value<FluidStackSnapshot>>() {};

    public static final TypeToken<GameMode> GAME_MODE_TOKEN = new TypeToken<GameMode>() {};

    public static final TypeToken<Value<GameMode>> GAME_MODE_VALUE_TOKEN = new TypeToken<Value<GameMode>>() {};

    public static final TypeToken<GameProfile> GAME_PROFILE_TOKEN = new TypeToken<GameProfile>() {};

    public static final TypeToken<Value<GameProfile>> GAME_PROFILE_VALUE_TOKEN = new TypeToken<Value<GameProfile>>() {};

    public static final TypeToken<GoldenApple> GOLDEN_APPLE_TOKEN = new TypeToken<GoldenApple>() {};

    public static final TypeToken<Value<GoldenApple>> GOLDEN_APPLE_VALUE_TOKEN = new TypeToken<Value<GoldenApple>>() {};

    public static final TypeToken<Hinge> HINGE_TOKEN = new TypeToken<Hinge>() {};

    public static final TypeToken<Value<Hinge>> HINGE_VALUE_TOKEN = new TypeToken<Value<Hinge>>() {};

    public static final TypeToken<HorseColor> HORSE_COLOR_TOKEN = new TypeToken<HorseColor>() {};

    public static final TypeToken<Value<HorseColor>> HORSE_COLOR_VALUE_TOKEN = new TypeToken<Value<HorseColor>>() {};

    public static final TypeToken<HorseStyle> HORSE_STYLE_TOKEN = new TypeToken<HorseStyle>() {};

    public static final TypeToken<Value<HorseStyle>> HORSE_STYLE_VALUE_TOKEN = new TypeToken<Value<HorseStyle>>() {};

    public static final TypeToken<org.spongepowered.api.data.type.HorseVariant> HORSE_VARIANT_TOKEN = new TypeToken<org.spongepowered.api.data.type.HorseVariant>() {};

    public static final TypeToken<Value<org.spongepowered.api.data.type.HorseVariant>> HORSE_VARIANT_VALUE_TOKEN = new TypeToken<Value<org.spongepowered.api.data.type.HorseVariant>>() {};

    public static final TypeToken<Instant> INSTANT_TOKEN = new TypeToken<Instant>() {};

    public static final TypeToken<Value<Instant>> INSTANT_VALUE_TOKEN = new TypeToken<Value<Instant>>() {};

    public static final TypeToken<Integer> INTEGER_TOKEN = new TypeToken<Integer>() {};

    public static final TypeToken<Value<Integer>> INTEGER_VALUE_TOKEN = new TypeToken<Value<Integer>>() {};

    public static final TypeToken<ItemStackSnapshot> ITEM_SNAPSHOT_TOKEN = new TypeToken<ItemStackSnapshot>() {};

    public static final TypeToken<Value<ItemStackSnapshot>> ITEM_SNAPSHOT_VALUE_TOKEN = new TypeToken<Value<ItemStackSnapshot>>() {};

    public static final TypeToken<List<DyeColor>> LIST_DYE_COLOR_TOKEN = new TypeToken<List<DyeColor>>() {};

    public static final TypeToken<ListValue<DyeColor>> LIST_DYE_COLOR_VALUE_TOKEN = new TypeToken<ListValue<DyeColor>>() {};

    public static final TypeToken<List<FireworkEffect>> LIST_FIREWORK_TOKEN = new TypeToken<List<FireworkEffect>>() {};

    public static final TypeToken<List<ItemEnchantment>> LIST_ITEM_ENCHANTMENT_TOKEN = new TypeToken<List<ItemEnchantment>>() {};

    public static final TypeToken<ListValue<ItemEnchantment>> LIST_ITEM_ENCHANTMENT_VALUE_TOKEN = new TypeToken<ListValue<ItemEnchantment>>() {};

    public static final TypeToken<List<PatternLayer>> LIST_PATTERN_TOKEN = new TypeToken<List<PatternLayer>>() {};

    public static final TypeToken<ListValue<PatternLayer>> LIST_PATTERN_VALUE_TOKEN = new TypeToken<ListValue<PatternLayer>>() {};

    public static final TypeToken<List<PotionEffect>> LIST_POTION_TOKEN = new TypeToken<List<PotionEffect>>() {};

    public static final TypeToken<ListValue<PotionEffect>> LIST_POTION_VALUE_TOKEN = new TypeToken<ListValue<PotionEffect>>() {};

    public static final TypeToken<List<Text>> LIST_TEXT_TOKEN = new TypeToken<List<Text>>() {};

    public static final TypeToken<ListValue<Text>> LIST_TEXT_VALUE_TOKEN = new TypeToken<ListValue<Text>>() {};

    public static final TypeToken<List<TradeOffer>> LIST_TRADE_OFFER_TOKEN = new TypeToken<List<TradeOffer>>() {};

    public static final TypeToken<ListValue<FireworkEffect>> LIST_VALUE_FIREWORK_TOKEN = new TypeToken<ListValue<FireworkEffect>>() {};

    public static final TypeToken<ListValue<TradeOffer>> LIST_VALUE_TRADE_OFFER_TOKEN = new TypeToken<ListValue<TradeOffer>>() {};

    public static final TypeToken<LogAxis> LOG_AXIS_TOKEN = new TypeToken<LogAxis>() {};

    public static final TypeToken<Value<LogAxis>> LOG_AXIS_VALUE_TOKEN = new TypeToken<Value<LogAxis>>() {};

    public static final TypeToken<Long> LONG_TOKEN = new TypeToken<Long>() {};

    public static final TypeToken<Value<Long>> LONG_VALUE_TOKEN = new TypeToken<Value<Long>>() {};

    public static final TypeToken<Map<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_TOKEN = new TypeToken<Map<BodyPart, Vector3d>>() {};

    public static final TypeToken<MapValue<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_VALUE_TOKEN = new TypeToken<MapValue<BodyPart, Vector3d>>() {};

    public static final TypeToken<Map<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_TOKEN = new TypeToken<Map<Direction, List<FluidStackSnapshot>>>() {};

    public static final TypeToken<MapValue<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_VALUE_TOKEN = new TypeToken<MapValue<Direction, List<FluidStackSnapshot>>>() {};

    public static final TypeToken<Map<UUID, Vector3d>> MAP_UUID_VECTOR3D_TOKEN = new TypeToken<Map<UUID, Vector3d>>() {};

    public static final TypeToken<MapValue<UUID, Vector3d>> MAP_UUID_VECTOR3D_VALUE_TOKEN = new TypeToken<MapValue<UUID, Vector3d>>() {};

    public static final TypeToken<BigMushroomType> MUSHROOM_TOKEN = new TypeToken<BigMushroomType>() {};

    public static final TypeToken<Value<BigMushroomType>> MUSHROOM_VALUE_TOKEN = new TypeToken<Value<BigMushroomType>>() {};

    public static final TypeToken<NotePitch> NOTE_TOKEN = new TypeToken<NotePitch>() {};

    public static final TypeToken<Value<NotePitch>> NOTE_VALUE_TOKEN = new TypeToken<Value<NotePitch>>() {};

    public static final TypeToken<OcelotType> OCELOT_TOKEN = new TypeToken<OcelotType>() {};

    public static final TypeToken<Value<OcelotType>> OCELOT_VALUE_TOKEN = new TypeToken<Value<OcelotType>>() {};

    public static final TypeToken<Optional<PotionEffectType>> OPTIONAL_POTION_TOKEN = new TypeToken<Optional<PotionEffectType>>() {};

    public static final TypeToken<OptionalValue<PotionEffectType>> OPTIONAL_POTION_VALUE_TOKEN = new TypeToken<OptionalValue<PotionEffectType>>() {};

    public static final TypeToken<Optional<Profession>> OPTIONAL_PROFESSION_TOKEN = new TypeToken<Optional<Profession>>() {};

    public static final TypeToken<OptionalValue<Profession>> OPTIONAL_PROFESSION_VALUE_TOKEN = new TypeToken<OptionalValue<Profession>>() {};

    public static final TypeToken<Optional<Text>> OPTIONAL_TEXT_TOKEN = new TypeToken<Optional<Text>>() {};

    public static final TypeToken<OptionalValue<Text>> OPTIONAL_TEXT_VALUE_TOKEN = new TypeToken<OptionalValue<Text>>() {};

    public static final TypeToken<Optional<UUID>> OPTIONAL_UUID_TOKEN = new TypeToken<Optional<UUID>>() {};

    public static final TypeToken<OptionalValue<UUID>> OPTIONAL_UUID_VALUE_TOKEN = new TypeToken<OptionalValue<UUID>>() {};

    public static final TypeToken<ParticleType> PARTICLE_TYPE_TOKEN = new TypeToken<ParticleType>() {};

    public static final TypeToken<Value<ParticleType>> PARTICLE_TYPE_VALUE_TOKEN = new TypeToken<Value<ParticleType>>() {};

    public static final TypeToken<PickupRule> PICKUP_TOKEN = new TypeToken<PickupRule>() {};

    public static final TypeToken<Value<PickupRule>> PICKUP_VALUE_TOKEN = new TypeToken<Value<PickupRule>>() {};

    public static final TypeToken<PistonType> PISTON_TOKEN = new TypeToken<PistonType>() {};

    public static final TypeToken<Value<PistonType>> PISTON_VALUE_TOKEN = new TypeToken<Value<PistonType>>() {};

    public static final TypeToken<PlantType> PLANT_TOKEN = new TypeToken<PlantType>() {};

    public static final TypeToken<Value<PlantType>> PLANT_VALUE_TOKEN = new TypeToken<Value<PlantType>>() {};

    public static final TypeToken<PortionType> PORTION_TOKEN = new TypeToken<PortionType>() {};

    public static final TypeToken<Value<PortionType>> PORTION_VALUE_TOKEN = new TypeToken<Value<PortionType>>() {};

    public static final TypeToken<PrismarineType> PRISMARINE_TOKEN = new TypeToken<PrismarineType>() {};

    public static final TypeToken<Value<PrismarineType>> PRISMARINE_VALUE_TOKEN = new TypeToken<Value<PrismarineType>>() {};

    public static final TypeToken<QuartzType> QUARTZ_TOKEN = new TypeToken<QuartzType>() {};

    public static final TypeToken<Value<QuartzType>> QUARTZ_VALUE_TOKEN = new TypeToken<Value<QuartzType>>() {};

    public static final TypeToken<RabbitType> RABBIT_TOKEN = new TypeToken<RabbitType>() {};

    public static final TypeToken<Value<RabbitType>> RABBIT_VALUE_TOKEN = new TypeToken<Value<RabbitType>>() {};

    public static final TypeToken<RailDirection> RAIL_TOKEN = new TypeToken<RailDirection>() {};

    public static final TypeToken<Value<RailDirection>> RAIL_VALUE_TOKEN = new TypeToken<Value<RailDirection>>() {};

    public static final TypeToken<Rotation> ROTATION_TOKEN = new TypeToken<Rotation>() {};

    public static final TypeToken<Value<Rotation>> ROTATION_VALUE_TOKEN = new TypeToken<Value<Rotation>>() {};

    public static final TypeToken<SandstoneType> SAND_STONE_TOKEN = new TypeToken<SandstoneType>() {};

    public static final TypeToken<Value<SandstoneType>> SAND_STONE_VALUE_TOKEN = new TypeToken<Value<SandstoneType>>() {};

    public static final TypeToken<SandType> SAND_TOKEN = new TypeToken<SandType>() {};

    public static final TypeToken<Value<SandType>> SAND_VALUE_TOKEN = new TypeToken<Value<SandType>>() {};

    public static final TypeToken<Set<BlockType>> SET_BLOCK_TOKEN = new TypeToken<Set<BlockType>>() {};

    public static final TypeToken<SetValue<BlockType>> SET_BLOCK_VALUE_TOKEN = new TypeToken<SetValue<BlockType>>() {};

    public static final TypeToken<Set<Direction>> SET_DIRECTION_TOKEN = new TypeToken<Set<Direction>>() {};

    public static final TypeToken<SetValue<Direction>> SET_DIRECTION_VALUE_TOKEN = new TypeToken<SetValue<Direction>>() {};

    public static final TypeToken<Short> SHORT_TOKEN = new TypeToken<Short>() {};

    public static final TypeToken<ShrubType> SHRUB_TOKEN = new TypeToken<ShrubType>() {};

    public static final TypeToken<Value<ShrubType>> SHRUB_VALUE_TOKEN = new TypeToken<Value<ShrubType>>() {};

    public static final TypeToken<org.spongepowered.api.data.type.SkeletonType> SKELETON_TOKEN = new TypeToken<org.spongepowered.api.data.type.SkeletonType>() {};

    public static final TypeToken<Value<org.spongepowered.api.data.type.SkeletonType>> SKELETON_VALUE_TOKEN = new TypeToken<Value<org.spongepowered.api.data.type.SkeletonType>>() {};

    public static final TypeToken<SkullType> SKULL_TOKEN = new TypeToken<SkullType>() {};

    public static final TypeToken<Value<SkullType>> SKULL_VALUE_TOKEN = new TypeToken<Value<SkullType>>() {};

    public static final TypeToken<SlabType> SLAB_TOKEN = new TypeToken<SlabType>() {};

    public static final TypeToken<Value<SlabType>> SLAB_VALUE_TOKEN = new TypeToken<Value<SlabType>>() {};

    public static final TypeToken<StairShape> STAIR_TOKEN = new TypeToken<StairShape>() {};

    public static final TypeToken<Value<StairShape>> STAIR_VALUE_TOKEN = new TypeToken<Value<StairShape>>() {};

    public static final TypeToken<Map<Statistic, Long>> STATISTIC_MAP_TOKEN = new TypeToken<Map<Statistic, Long>>() {};

    public static final TypeToken<MapValue<Statistic, Long>> STATISTIC_MAP_VALUE_TOKEN = new TypeToken<MapValue<Statistic, Long>>() {};

    public static final TypeToken<StoneType> STONE_TOKEN = new TypeToken<StoneType>() {};

    public static final TypeToken<Value<StoneType>> STONE_VALUE_TOKEN = new TypeToken<Value<StoneType>>() {};

    public static final TypeToken<String> STRING_TOKEN = new TypeToken<String>() {};

    public static final TypeToken<Value<String>> STRING_VALUE_TOKEN = new TypeToken<Value<String>>() {};

    public static final TypeToken<StructureMode> STRUCTURE_MODE_TOKEN = new TypeToken<StructureMode>() {};

    public static final TypeToken<Value<StructureMode>> STRUCTURE_MODE_VALUE_TOKEN = new TypeToken<Value<StructureMode>>() {};

    public static final TypeToken<Text> TEXT_TOKEN = new TypeToken<Text>() {};

    public static final TypeToken<Value<Text>> TEXT_VALUE_TOKEN = new TypeToken<Value<Text>>() {};

    public static final TypeToken<TreeType> TREE_TOKEN = new TypeToken<TreeType>() {};

    public static final TypeToken<Value<TreeType>> TREE_VALUE_TOKEN = new TypeToken<Value<TreeType>>() {};

    public static final TypeToken<UUID> UUID_TOKEN = new TypeToken<UUID>() {};

    public static final TypeToken<Value<UUID>> UUID_VALUE_TOKEN = new TypeToken<Value<UUID>>() {};

    public static final TypeToken<Vector3d> VECTOR_3D_TOKEN = new TypeToken<Vector3d>() {};

    public static final TypeToken<Value<Vector3d>> VECTOR_3D_VALUE_TOKEN = new TypeToken<Value<Vector3d>>() {};

    public static final TypeToken<Vector3i> VECTOR_3I_TOKEN = new TypeToken<Vector3i>() {};

    public static final TypeToken<Value<Vector3i>> VECTOR_3I_VALUE_TOKEN = new TypeToken<Value<Vector3i>>() {};

    public static final TypeToken<WallType> WALL_TOKEN = new TypeToken<WallType>() {};

    public static final TypeToken<Value<WallType>> WALL_VALUE_TOKEN = new TypeToken<Value<WallType>>() {};

    public static final TypeToken<WeightedCollectionValue<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_COLLECTION_VALUE_TOKEN = new TypeToken<WeightedCollectionValue<EntityArchetype>> () {};

    public static final TypeToken<WeightedTable<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TABLE_TOKEN = new TypeToken<WeightedTable<EntityArchetype>>() {};

    public static final TypeToken<WeightedSerializableObject<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TOKEN = new TypeToken<WeightedSerializableObject<EntityArchetype>>() {};

    public static final TypeToken<Value<WeightedSerializableObject<EntityArchetype>>> WEIGHTED_ENTITY_ARCHETYPE_VALUE_TOKEN = new TypeToken<Value<WeightedSerializableObject<EntityArchetype>>>() {};

    public static final TypeToken<org.spongepowered.api.data.type.ZombieType> ZOMBIE_TYPE_TOKEN = new TypeToken<org.spongepowered.api.data.type.ZombieType>() {};

    public static final TypeToken<Value<org.spongepowered.api.data.type.ZombieType>> ZOMBIE_TYPE_VALUE_TOKEN = new TypeToken<Value<org.spongepowered.api.data.type.ZombieType>>() {};

    // SORTFIELDS:OFF

    private TypeTokens() {
        throw new RuntimeException("Lolno");
    }

}
