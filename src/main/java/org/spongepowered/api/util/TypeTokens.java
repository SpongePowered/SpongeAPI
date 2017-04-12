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
import org.spongepowered.api.data.type.*;
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
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.statistic.Statistic;
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

    public static final TypeToken<Art> ART_TOKEN = new TypeToken<Art>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Art>> ART_VALUE_TOKEN = new TypeToken<Value<Art>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Axis> AXIS_TOKEN = new TypeToken<Axis>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Axis>> AXIS_VALUE_TOKEN = new TypeToken<Value<Axis>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BlockState> BLOCK_TOKEN = new TypeToken<BlockState>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<BlockState>> BLOCK_VALUE_TOKEN = new TypeToken<Value<BlockState>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Boolean> BOOLEAN_TOKEN = new TypeToken<Boolean>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Boolean>> BOOLEAN_VALUE_TOKEN = new TypeToken<Value<Boolean>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableBoundedValue<Double>> BOUNDED_DOUBLE_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableBoundedValue<Integer>> BOUNDED_INTEGER_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Integer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableBoundedValue<Short>> BOUNDED_SHORT_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Short>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BrickType> BRICK_TOKEN = new TypeToken<BrickType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<BrickType>> BRICK_VALUE_TOKEN = new TypeToken<Value<BrickType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Career> CAREER_TOKEN = new TypeToken<Career>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Career>> CAREER_VALUE_TOKEN = new TypeToken<Value<Career>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<CoalType> COAL_TOKEN = new TypeToken<CoalType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<CoalType>> COAL_VALUE_TOKEN = new TypeToken<Value<CoalType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Color> COLOR_TOKEN = new TypeToken<Color>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Color>> COLOR_VALUE_TOKEN = new TypeToken<Value<Color>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ComparatorType> COMPARATOR_TOKEN = new TypeToken<ComparatorType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ComparatorType>> COMPARATOR_VALUE_TOKEN = new TypeToken<Value<ComparatorType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<CookedFish> COOKED_FISH_TOKEN = new TypeToken<CookedFish>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<CookedFish>> COOKED_FISH_VALUE_TOKEN = new TypeToken<Value<CookedFish>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Direction> DIRECTION_TOKEN = new TypeToken<Direction>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Direction>> DIRECTION_VALUE_TOKEN = new TypeToken<Value<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DirtType> DIRT_TOKEN = new TypeToken<DirtType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<DirtType>> DIRT_VALUE_TOKEN = new TypeToken<Value<DirtType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DisguisedBlockType> DISGUISED_BLOCK_TOKEN = new TypeToken<DisguisedBlockType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<DisguisedBlockType>> DISGUISED_BLOCK_VALUE_TOKEN = new TypeToken<Value<DisguisedBlockType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DoublePlantType> DOUBLE_PLANT_TOKEN = new TypeToken<DoublePlantType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<DoublePlantType>> DOUBLE_PLANT_VALUE_TOKEN = new TypeToken<Value<DoublePlantType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Double> DOUBLE_TOKEN = new TypeToken<Double>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Double>> DOUBLE_VALUE_TOKEN = new TypeToken<Value<Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DyeColor> DYE_COLOR_TOKEN = new TypeToken<DyeColor>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<DyeColor>> DYE_COLOR_VALUE_TOKEN = new TypeToken<Value<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<EntitySnapshot> ENTITY_TOKEN = new TypeToken<EntitySnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<EntityType, Double>> ENTITY_TYPE_DOUBLE_MAP_TOKEN = new TypeToken<Map<EntityType, Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<EntityType, Double>> ENTITY_TYPE_DOUBLE_MAP_VALUE_TOKEN = new TypeToken<MapValue<EntityType, Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<EntityType> ENTITY_TYPE_TOKEN = new TypeToken<EntityType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<EntityType>> ENTITY_TYPE_VALUE_TOKEN = new TypeToken<Value<EntityType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<EntitySnapshot>> ENTITY_VALUE_TOKEN = new TypeToken<Value<EntitySnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Fish> FISH_TOKEN = new TypeToken<Fish>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Fish>> FISH_VALUE_TOKEN = new TypeToken<Value<Fish>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Float> FLOAT_TOKEN = new TypeToken<Float>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableBoundedValue<Float>> FLOAT_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Float>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<FluidStackSnapshot> FLUID_TOKEN = new TypeToken<FluidStackSnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<FluidStackSnapshot>> FLUID_VALUE_TOKEN = new TypeToken<Value<FluidStackSnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<GameMode> GAME_MODE_TOKEN = new TypeToken<GameMode>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<GameMode>> GAME_MODE_VALUE_TOKEN = new TypeToken<Value<GameMode>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<GameProfile> GAME_PROFILE_TOKEN = new TypeToken<GameProfile>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<GameProfile>> GAME_PROFILE_VALUE_TOKEN = new TypeToken<Value<GameProfile>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<GoldenApple> GOLDEN_APPLE_TOKEN = new TypeToken<GoldenApple>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<GoldenApple>> GOLDEN_APPLE_VALUE_TOKEN = new TypeToken<Value<GoldenApple>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<HandPreference> HAND_PREFERENCE_TYPE_TOKEN = new TypeToken<HandPreference>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<HandPreference>> HAND_PREFERENCE_VALUE_TOKEN = new TypeToken<Value<HandPreference>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Hinge> HINGE_TOKEN = new TypeToken<Hinge>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Hinge>> HINGE_VALUE_TOKEN = new TypeToken<Value<Hinge>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<HorseColor> HORSE_COLOR_TOKEN = new TypeToken<HorseColor>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<HorseColor>> HORSE_COLOR_VALUE_TOKEN = new TypeToken<Value<HorseColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<HorseStyle> HORSE_STYLE_TOKEN = new TypeToken<HorseStyle>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<HorseStyle>> HORSE_STYLE_VALUE_TOKEN = new TypeToken<Value<HorseStyle>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Instant> INSTANT_TOKEN = new TypeToken<Instant>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Instant>> INSTANT_VALUE_TOKEN = new TypeToken<Value<Instant>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Integer> INTEGER_TOKEN = new TypeToken<Integer>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Integer>> INTEGER_VALUE_TOKEN = new TypeToken<Value<Integer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ItemStackSnapshot> ITEM_SNAPSHOT_TOKEN = new TypeToken<ItemStackSnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ItemStackSnapshot>> ITEM_SNAPSHOT_VALUE_TOKEN = new TypeToken<Value<ItemStackSnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<Living>> LAST_ATTACKER_TOKEN = new TypeToken<Optional<Living>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<OptionalValue<Living>> LAST_ATTACKER_VALUE_TOKEN = new TypeToken<OptionalValue<Living>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<DyeColor>> LIST_DYE_COLOR_TOKEN = new TypeToken<List<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<DyeColor>> LIST_DYE_COLOR_VALUE_TOKEN = new TypeToken<ListValue<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<FireworkEffect>> LIST_FIREWORK_TOKEN = new TypeToken<List<FireworkEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<ItemEnchantment>> LIST_ITEM_ENCHANTMENT_TOKEN = new TypeToken<List<ItemEnchantment>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<ItemEnchantment>> LIST_ITEM_ENCHANTMENT_VALUE_TOKEN = new TypeToken<ListValue<ItemEnchantment>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<PatternLayer>> LIST_PATTERN_TOKEN = new TypeToken<List<PatternLayer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<PatternLayer>> LIST_PATTERN_VALUE_TOKEN = new TypeToken<ListValue<PatternLayer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<PotionEffect>> LIST_POTION_TOKEN = new TypeToken<List<PotionEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<PotionEffect>> LIST_POTION_VALUE_TOKEN = new TypeToken<ListValue<PotionEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<Text>> LIST_TEXT_TOKEN = new TypeToken<List<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<Text>> LIST_TEXT_VALUE_TOKEN = new TypeToken<ListValue<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<TradeOffer>> LIST_TRADE_OFFER_TOKEN = new TypeToken<List<TradeOffer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<FireworkEffect>> LIST_VALUE_FIREWORK_TOKEN = new TypeToken<ListValue<FireworkEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<TradeOffer>> LIST_VALUE_TRADE_OFFER_TOKEN = new TypeToken<ListValue<TradeOffer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<LlamaVariant> LLAMA_VARIANT_TOKEN = new TypeToken<LlamaVariant>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<LlamaVariant>> LLAMA_VARIANT_VALUE_TOKEN = new TypeToken<Value<LlamaVariant>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<LogAxis> LOG_AXIS_TOKEN = new TypeToken<LogAxis>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<LogAxis>> LOG_AXIS_VALUE_TOKEN = new TypeToken<Value<LogAxis>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Long> LONG_TOKEN = new TypeToken<Long>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Long>> LONG_VALUE_TOKEN = new TypeToken<Value<Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_TOKEN = new TypeToken<Map<BodyPart, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_VALUE_TOKEN = new TypeToken<MapValue<BodyPart, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_TOKEN = new TypeToken<Map<Direction, List<FluidStackSnapshot>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_VALUE_TOKEN = new TypeToken<MapValue<Direction, List<FluidStackSnapshot>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<UUID, Vector3d>> MAP_UUID_VECTOR3D_TOKEN = new TypeToken<Map<UUID, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<UUID, Vector3d>> MAP_UUID_VECTOR3D_VALUE_TOKEN = new TypeToken<MapValue<UUID, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BigMushroomType> MUSHROOM_TOKEN = new TypeToken<BigMushroomType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<BigMushroomType>> MUSHROOM_VALUE_TOKEN = new TypeToken<Value<BigMushroomType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<NotePitch> NOTE_TOKEN = new TypeToken<NotePitch>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<NotePitch>> NOTE_VALUE_TOKEN = new TypeToken<Value<NotePitch>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<OcelotType> OCELOT_TOKEN = new TypeToken<OcelotType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<OcelotType>> OCELOT_VALUE_TOKEN = new TypeToken<Value<OcelotType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<PotionEffectType>> OPTIONAL_POTION_TOKEN = new TypeToken<Optional<PotionEffectType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<OptionalValue<PotionEffectType>> OPTIONAL_POTION_VALUE_TOKEN = new TypeToken<OptionalValue<PotionEffectType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<Profession>> OPTIONAL_PROFESSION_TOKEN = new TypeToken<Optional<Profession>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<OptionalValue<Profession>> OPTIONAL_PROFESSION_VALUE_TOKEN = new TypeToken<OptionalValue<Profession>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<Text>> OPTIONAL_TEXT_TOKEN = new TypeToken<Optional<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<OptionalValue<Text>> OPTIONAL_TEXT_VALUE_TOKEN = new TypeToken<OptionalValue<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<UUID>> OPTIONAL_UUID_TOKEN = new TypeToken<Optional<UUID>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<OptionalValue<UUID>> OPTIONAL_UUID_VALUE_TOKEN = new TypeToken<OptionalValue<UUID>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ParticleType> PARTICLE_TYPE_TOKEN = new TypeToken<ParticleType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ParticleType>> PARTICLE_TYPE_VALUE_TOKEN = new TypeToken<Value<ParticleType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PickupRule> PICKUP_TOKEN = new TypeToken<PickupRule>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PickupRule>> PICKUP_VALUE_TOKEN = new TypeToken<Value<PickupRule>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PistonType> PISTON_TOKEN = new TypeToken<PistonType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PistonType>> PISTON_VALUE_TOKEN = new TypeToken<Value<PistonType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PlantType> PLANT_TOKEN = new TypeToken<PlantType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PlantType>> PLANT_VALUE_TOKEN = new TypeToken<Value<PlantType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PortionType> PORTION_TOKEN = new TypeToken<PortionType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PortionType>> PORTION_VALUE_TOKEN = new TypeToken<Value<PortionType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PrismarineType> PRISMARINE_TOKEN = new TypeToken<PrismarineType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PrismarineType>> PRISMARINE_VALUE_TOKEN = new TypeToken<Value<PrismarineType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<QuartzType> QUARTZ_TOKEN = new TypeToken<QuartzType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<QuartzType>> QUARTZ_VALUE_TOKEN = new TypeToken<Value<QuartzType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<RabbitType> RABBIT_TOKEN = new TypeToken<RabbitType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<RabbitType>> RABBIT_VALUE_TOKEN = new TypeToken<Value<RabbitType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<RailDirection> RAIL_TOKEN = new TypeToken<RailDirection>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<RailDirection>> RAIL_VALUE_TOKEN = new TypeToken<Value<RailDirection>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Rotation> ROTATION_TOKEN = new TypeToken<Rotation>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Rotation>> ROTATION_VALUE_TOKEN = new TypeToken<Value<Rotation>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SandstoneType> SAND_STONE_TOKEN = new TypeToken<SandstoneType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<SandstoneType>> SAND_STONE_VALUE_TOKEN = new TypeToken<Value<SandstoneType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SandType> SAND_TOKEN = new TypeToken<SandType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<SandType>> SAND_VALUE_TOKEN = new TypeToken<Value<SandType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Set<BlockType>> SET_BLOCK_TOKEN = new TypeToken<Set<BlockType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SetValue<BlockType>> SET_BLOCK_VALUE_TOKEN = new TypeToken<SetValue<BlockType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Set<Direction>> SET_DIRECTION_TOKEN = new TypeToken<Set<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SetValue<Direction>> SET_DIRECTION_VALUE_TOKEN = new TypeToken<SetValue<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Short> SHORT_TOKEN = new TypeToken<Short>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ShrubType> SHRUB_TOKEN = new TypeToken<ShrubType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ShrubType>> SHRUB_VALUE_TOKEN = new TypeToken<Value<ShrubType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SkullType> SKULL_TOKEN = new TypeToken<SkullType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<SkullType>> SKULL_VALUE_TOKEN = new TypeToken<Value<SkullType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SlabType> SLAB_TOKEN = new TypeToken<SlabType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<SlabType>> SLAB_VALUE_TOKEN = new TypeToken<Value<SlabType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<StairShape> STAIR_TOKEN = new TypeToken<StairShape>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<StairShape>> STAIR_VALUE_TOKEN = new TypeToken<Value<StairShape>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Statistic, Long>> STATISTIC_MAP_TOKEN = new TypeToken<Map<Statistic, Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<Statistic, Long>> STATISTIC_MAP_VALUE_TOKEN = new TypeToken<MapValue<Statistic, Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<StoneType> STONE_TOKEN = new TypeToken<StoneType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<StoneType>> STONE_VALUE_TOKEN = new TypeToken<Value<StoneType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<String> STRING_TOKEN = new TypeToken<String>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<String>> STRING_VALUE_TOKEN = new TypeToken<Value<String>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<StructureMode> STRUCTURE_MODE_TOKEN = new TypeToken<StructureMode>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<StructureMode>> STRUCTURE_MODE_VALUE_TOKEN = new TypeToken<Value<StructureMode>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Text> TEXT_TOKEN = new TypeToken<Text>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Text>> TEXT_VALUE_TOKEN = new TypeToken<Value<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<TreeType> TREE_TOKEN = new TypeToken<TreeType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<TreeType>> TREE_VALUE_TOKEN = new TypeToken<Value<TreeType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<UUID> UUID_TOKEN = new TypeToken<UUID>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<UUID>> UUID_VALUE_TOKEN = new TypeToken<Value<UUID>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Vector3d> VECTOR_3D_TOKEN = new TypeToken<Vector3d>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Vector3d>> VECTOR_3D_VALUE_TOKEN = new TypeToken<Value<Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Vector3i> VECTOR_3I_TOKEN = new TypeToken<Vector3i>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Vector3i>> VECTOR_3I_VALUE_TOKEN = new TypeToken<Value<Vector3i>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WallType> WALL_TOKEN = new TypeToken<WallType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<WallType>> WALL_VALUE_TOKEN = new TypeToken<Value<WallType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WeightedCollectionValue<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_COLLECTION_VALUE_TOKEN = new TypeToken<WeightedCollectionValue<EntityArchetype>> () {private static final long serialVersionUID = -1;};

    public static final TypeToken<WeightedTable<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TABLE_TOKEN = new TypeToken<WeightedTable<EntityArchetype>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WeightedSerializableObject<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TOKEN = new TypeToken<WeightedSerializableObject<EntityArchetype>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<WeightedSerializableObject<EntityArchetype>>> WEIGHTED_ENTITY_ARCHETYPE_VALUE_TOKEN = new TypeToken<Value<WeightedSerializableObject<EntityArchetype>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Direction, WireAttachmentType>> WIRE_ATTACHMENT_MAP_TOKEN = new TypeToken<Map<Direction, WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<Direction, WireAttachmentType>> WIRE_ATTACHMENT_MAP_VALUE_TOKEN = new TypeToken<MapValue<Direction, WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WireAttachmentType> WIRE_ATTACHMENT_TYPE_TOKEN = new TypeToken<WireAttachmentType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<WireAttachmentType>> WIRE_ATTACHMENT_TYPE_VALUE_TOKEN = new TypeToken<Value<WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    // SORTFIELDS:OFF

    private TypeTokens() {
        throw new RuntimeException("Lolno");
    }

}
