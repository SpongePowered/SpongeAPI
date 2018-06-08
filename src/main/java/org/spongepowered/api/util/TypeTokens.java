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
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.Hinge;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.LlamaVariant;
import org.spongepowered.api.data.type.LogAxis;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.OcelotType;
import org.spongepowered.api.data.type.ParrotVariant;
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
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.data.value.mutable.MutableListValue;
import org.spongepowered.api.data.value.mutable.MutableMapValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.MutableValue;
import org.spongepowered.api.data.value.mutable.MutableOptionalValue;
import org.spongepowered.api.data.value.mutable.PatternMutableListValue;
import org.spongepowered.api.data.value.mutable.MutableSetValue;
import org.spongepowered.api.data.value.mutable.MutableWeightedCollectionValue;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.extra.fluid.FluidStackSnapshot;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.enchantment.Enchantment;
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

@SuppressWarnings("unused")
public final class TypeTokens {

    // SORTFIELDS:ON

    public static final TypeToken<Art> ART_TOKEN = new TypeToken<Art>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Art>> ART_VALUE_TOKEN = new TypeToken<MutableValue<Art>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Axis> AXIS_TOKEN = new TypeToken<Axis>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Axis>> AXIS_VALUE_TOKEN = new TypeToken<MutableValue<Axis>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BlockState> BLOCK_TOKEN = new TypeToken<BlockState>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<BlockState>> BLOCK_VALUE_TOKEN = new TypeToken<MutableValue<BlockState>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Boolean> BOOLEAN_TOKEN = new TypeToken<Boolean>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Boolean>> BOOLEAN_VALUE_TOKEN = new TypeToken<MutableValue<Boolean>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableBoundedValue<Double>> BOUNDED_DOUBLE_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableBoundedValue<Integer>> BOUNDED_INTEGER_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Integer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableBoundedValue<Short>> BOUNDED_SHORT_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Short>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BrickType> BRICK_TOKEN = new TypeToken<BrickType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<BrickType>> BRICK_VALUE_TOKEN = new TypeToken<MutableValue<BrickType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Career> CAREER_TOKEN = new TypeToken<Career>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Career>> CAREER_VALUE_TOKEN = new TypeToken<MutableValue<Career>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<CoalType> COAL_TOKEN = new TypeToken<CoalType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<CoalType>> COAL_VALUE_TOKEN = new TypeToken<MutableValue<CoalType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Color> COLOR_TOKEN = new TypeToken<Color>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Color>> COLOR_VALUE_TOKEN = new TypeToken<MutableValue<Color>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ComparatorType> COMPARATOR_TOKEN = new TypeToken<ComparatorType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<ComparatorType>> COMPARATOR_VALUE_TOKEN = new TypeToken<MutableValue<ComparatorType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<CookedFish> COOKED_FISH_TOKEN = new TypeToken<CookedFish>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<CookedFish>> COOKED_FISH_VALUE_TOKEN = new TypeToken<MutableValue<CookedFish>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Direction> DIRECTION_TOKEN = new TypeToken<Direction>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Direction>> DIRECTION_VALUE_TOKEN = new TypeToken<MutableValue<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DirtType> DIRT_TOKEN = new TypeToken<DirtType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<DirtType>> DIRT_VALUE_TOKEN = new TypeToken<MutableValue<DirtType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DisguisedBlockType> DISGUISED_BLOCK_TOKEN = new TypeToken<DisguisedBlockType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<DisguisedBlockType>> DISGUISED_BLOCK_VALUE_TOKEN = new TypeToken<MutableValue<DisguisedBlockType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DoublePlantType> DOUBLE_PLANT_TOKEN = new TypeToken<DoublePlantType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<DoublePlantType>> DOUBLE_PLANT_VALUE_TOKEN = new TypeToken<MutableValue<DoublePlantType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Double> DOUBLE_TOKEN = new TypeToken<Double>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Double>> DOUBLE_VALUE_TOKEN = new TypeToken<MutableValue<Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DyeColor> DYE_COLOR_TOKEN = new TypeToken<DyeColor>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<DyeColor>> DYE_COLOR_VALUE_TOKEN = new TypeToken<MutableValue<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<EntitySnapshot> ENTITY_TOKEN = new TypeToken<EntitySnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<EntityType, Double>> ENTITY_TYPE_DOUBLE_MAP_TOKEN = new TypeToken<Map<EntityType, Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableMapValue<EntityType, Double>> ENTITY_TYPE_DOUBLE_MAP_VALUE_TOKEN = new TypeToken<MutableMapValue<EntityType, Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<EntityType> ENTITY_TYPE_TOKEN = new TypeToken<EntityType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<EntityType>> ENTITY_TYPE_VALUE_TOKEN = new TypeToken<MutableValue<EntityType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<EntitySnapshot>> ENTITY_VALUE_TOKEN = new TypeToken<MutableValue<EntitySnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Fish> FISH_TOKEN = new TypeToken<Fish>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Fish>> FISH_VALUE_TOKEN = new TypeToken<MutableValue<Fish>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Float> FLOAT_TOKEN = new TypeToken<Float>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableBoundedValue<Float>> FLOAT_VALUE_TOKEN = new TypeToken<MutableBoundedValue<Float>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<FluidStackSnapshot> FLUID_TOKEN = new TypeToken<FluidStackSnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<FluidStackSnapshot>> FLUID_VALUE_TOKEN = new TypeToken<MutableValue<FluidStackSnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<GameMode> GAME_MODE_TOKEN = new TypeToken<GameMode>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<GameMode>> GAME_MODE_VALUE_TOKEN = new TypeToken<MutableValue<GameMode>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<GameProfile> GAME_PROFILE_TOKEN = new TypeToken<GameProfile>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<GameProfile>> GAME_PROFILE_VALUE_TOKEN = new TypeToken<MutableValue<GameProfile>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<GoldenApple> GOLDEN_APPLE_TOKEN = new TypeToken<GoldenApple>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<GoldenApple>> GOLDEN_APPLE_VALUE_TOKEN = new TypeToken<MutableValue<GoldenApple>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<HandPreference> HAND_PREFERENCE_TYPE_TOKEN = new TypeToken<HandPreference>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<HandPreference>> HAND_PREFERENCE_VALUE_TOKEN = new TypeToken<MutableValue<HandPreference>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Hinge> HINGE_TOKEN = new TypeToken<Hinge>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Hinge>> HINGE_VALUE_TOKEN = new TypeToken<MutableValue<Hinge>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<HorseColor> HORSE_COLOR_TOKEN = new TypeToken<HorseColor>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<HorseColor>> HORSE_COLOR_VALUE_TOKEN = new TypeToken<MutableValue<HorseColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<HorseStyle> HORSE_STYLE_TOKEN = new TypeToken<HorseStyle>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<HorseStyle>> HORSE_STYLE_VALUE_TOKEN = new TypeToken<MutableValue<HorseStyle>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Instant> INSTANT_TOKEN = new TypeToken<Instant>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Instant>> INSTANT_VALUE_TOKEN = new TypeToken<MutableValue<Instant>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Integer> INTEGER_TOKEN = new TypeToken<Integer>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Integer>> INTEGER_VALUE_TOKEN = new TypeToken<MutableValue<Integer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ItemStackSnapshot> ITEM_SNAPSHOT_TOKEN = new TypeToken<ItemStackSnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<ItemStackSnapshot>> ITEM_SNAPSHOT_VALUE_TOKEN = new TypeToken<MutableValue<ItemStackSnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<DyeColor>> LIST_DYE_COLOR_TOKEN = new TypeToken<List<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableListValue<DyeColor>> LIST_DYE_COLOR_VALUE_TOKEN = new TypeToken<MutableListValue<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<Enchantment>> LIST_ENCHANTMENT_TOKEN = new TypeToken<List<Enchantment>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableListValue<Enchantment>> LIST_ENCHANTMENT_VALUE_TOKEN = new TypeToken<MutableListValue<Enchantment>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<FireworkEffect>> LIST_FIREWORK_TOKEN = new TypeToken<List<FireworkEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<PatternLayer>> LIST_PATTERN_TOKEN = new TypeToken<List<PatternLayer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableListValue<PatternLayer>> LIST_PATTERN_VALUE_TOKEN = new TypeToken<MutableListValue<PatternLayer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<PotionEffect>> LIST_POTION_TOKEN = new TypeToken<List<PotionEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableListValue<PotionEffect>> LIST_POTION_VALUE_TOKEN = new TypeToken<MutableListValue<PotionEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<Text>> LIST_TEXT_TOKEN = new TypeToken<List<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableListValue<Text>> LIST_TEXT_VALUE_TOKEN = new TypeToken<MutableListValue<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<TradeOffer>> LIST_TRADE_OFFER_TOKEN = new TypeToken<List<TradeOffer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableListValue<FireworkEffect>> LIST_VALUE_FIREWORK_TOKEN = new TypeToken<MutableListValue<FireworkEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableListValue<TradeOffer>> LIST_VALUE_TRADE_OFFER_TOKEN = new TypeToken<MutableListValue<TradeOffer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<LlamaVariant> LLAMA_VARIANT_TOKEN = new TypeToken<LlamaVariant>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<LlamaVariant>> LLAMA_VARIANT_VALUE_TOKEN = new TypeToken<MutableValue<LlamaVariant>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<LogAxis> LOG_AXIS_TOKEN = new TypeToken<LogAxis>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<LogAxis>> LOG_AXIS_VALUE_TOKEN = new TypeToken<MutableValue<LogAxis>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Long> LONG_TOKEN = new TypeToken<Long>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Long>> LONG_VALUE_TOKEN = new TypeToken<MutableValue<Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_TOKEN = new TypeToken<Map<BodyPart, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableMapValue<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_VALUE_TOKEN = new TypeToken<MutableMapValue<BodyPart, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_TOKEN = new TypeToken<Map<Direction, List<FluidStackSnapshot>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableMapValue<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_VALUE_TOKEN = new TypeToken<MutableMapValue<Direction, List<FluidStackSnapshot>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<UUID, Vector3d>> MAP_UUID_VECTOR3D_TOKEN = new TypeToken<Map<UUID, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableMapValue<UUID, Vector3d>> MAP_UUID_VECTOR3D_VALUE_TOKEN = new TypeToken<MutableMapValue<UUID, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BigMushroomType> MUSHROOM_TOKEN = new TypeToken<BigMushroomType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<BigMushroomType>> MUSHROOM_VALUE_TOKEN = new TypeToken<MutableValue<BigMushroomType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<NotePitch> NOTE_TOKEN = new TypeToken<NotePitch>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<NotePitch>> NOTE_VALUE_TOKEN = new TypeToken<MutableValue<NotePitch>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<OcelotType> OCELOT_TOKEN = new TypeToken<OcelotType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<OcelotType>> OCELOT_VALUE_TOKEN = new TypeToken<MutableValue<OcelotType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<Double>> OPTIONAL_DOUBLE_TOKEN = new TypeToken<Optional<Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableOptionalValue<Double>> OPTIONAL_DOUBLE_VALUE_TOKEN = new TypeToken<MutableOptionalValue<Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<EntitySnapshot>> OPTIONAL_ENTITY_SNAPSHOT_TOKEN = new TypeToken<Optional<EntitySnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableOptionalValue<EntitySnapshot>> OPTIONAL_ENTITY_SNAPSHOT_VALUE_TOKEN = new TypeToken<MutableOptionalValue<EntitySnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<PotionEffectType>> OPTIONAL_POTION_TOKEN = new TypeToken<Optional<PotionEffectType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableOptionalValue<PotionEffectType>> OPTIONAL_POTION_VALUE_TOKEN = new TypeToken<MutableOptionalValue<PotionEffectType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<Profession>> OPTIONAL_PROFESSION_TOKEN = new TypeToken<Optional<Profession>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableOptionalValue<Profession>> OPTIONAL_PROFESSION_VALUE_TOKEN = new TypeToken<MutableOptionalValue<Profession>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<Text>> OPTIONAL_TEXT_TOKEN = new TypeToken<Optional<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableOptionalValue<Text>> OPTIONAL_TEXT_VALUE_TOKEN = new TypeToken<MutableOptionalValue<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Optional<UUID>> OPTIONAL_UUID_TOKEN = new TypeToken<Optional<UUID>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableOptionalValue<UUID>> OPTIONAL_UUID_VALUE_TOKEN = new TypeToken<MutableOptionalValue<UUID>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ParrotVariant> PARROT_VARIANT_TOKEN = new TypeToken<ParrotVariant>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<ParrotVariant>> PARROT_VARIANT_VALUE_TOKEN = new TypeToken<MutableValue<ParrotVariant>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ParticleType> PARTICLE_TYPE_TOKEN = new TypeToken<ParticleType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<ParticleType>> PARTICLE_TYPE_VALUE_TOKEN = new TypeToken<MutableValue<ParticleType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PatternMutableListValue> PATTERN_LIST_VALUE_TOKEN = new TypeToken<PatternMutableListValue>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PickupRule> PICKUP_TOKEN = new TypeToken<PickupRule>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<PickupRule>> PICKUP_VALUE_TOKEN = new TypeToken<MutableValue<PickupRule>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PistonType> PISTON_TOKEN = new TypeToken<PistonType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<PistonType>> PISTON_VALUE_TOKEN = new TypeToken<MutableValue<PistonType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PlantType> PLANT_TOKEN = new TypeToken<PlantType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<PlantType>> PLANT_VALUE_TOKEN = new TypeToken<MutableValue<PlantType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PortionType> PORTION_TOKEN = new TypeToken<PortionType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<PortionType>> PORTION_VALUE_TOKEN = new TypeToken<MutableValue<PortionType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PrismarineType> PRISMARINE_TOKEN = new TypeToken<PrismarineType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<PrismarineType>> PRISMARINE_VALUE_TOKEN = new TypeToken<MutableValue<PrismarineType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<QuartzType> QUARTZ_TOKEN = new TypeToken<QuartzType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<QuartzType>> QUARTZ_VALUE_TOKEN = new TypeToken<MutableValue<QuartzType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<RabbitType> RABBIT_TOKEN = new TypeToken<RabbitType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<RabbitType>> RABBIT_VALUE_TOKEN = new TypeToken<MutableValue<RabbitType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<RailDirection> RAIL_TOKEN = new TypeToken<RailDirection>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<RailDirection>> RAIL_VALUE_TOKEN = new TypeToken<MutableValue<RailDirection>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Rotation> ROTATION_TOKEN = new TypeToken<Rotation>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Rotation>> ROTATION_VALUE_TOKEN = new TypeToken<MutableValue<Rotation>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SandstoneType> SAND_STONE_TOKEN = new TypeToken<SandstoneType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<SandstoneType>> SAND_STONE_VALUE_TOKEN = new TypeToken<MutableValue<SandstoneType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SandType> SAND_TOKEN = new TypeToken<SandType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<SandType>> SAND_VALUE_TOKEN = new TypeToken<MutableValue<SandType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Set<BlockType>> SET_BLOCK_TOKEN = new TypeToken<Set<BlockType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableSetValue<BlockType>> SET_BLOCK_VALUE_TOKEN = new TypeToken<MutableSetValue<BlockType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Set<Direction>> SET_DIRECTION_TOKEN = new TypeToken<Set<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableSetValue<Direction>> SET_DIRECTION_VALUE_TOKEN = new TypeToken<MutableSetValue<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Short> SHORT_TOKEN = new TypeToken<Short>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ShrubType> SHRUB_TOKEN = new TypeToken<ShrubType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<ShrubType>> SHRUB_VALUE_TOKEN = new TypeToken<MutableValue<ShrubType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SkullType> SKULL_TOKEN = new TypeToken<SkullType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<SkullType>> SKULL_VALUE_TOKEN = new TypeToken<MutableValue<SkullType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SlabType> SLAB_TOKEN = new TypeToken<SlabType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<SlabType>> SLAB_VALUE_TOKEN = new TypeToken<MutableValue<SlabType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<StairShape> STAIR_TOKEN = new TypeToken<StairShape>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<StairShape>> STAIR_VALUE_TOKEN = new TypeToken<MutableValue<StairShape>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Statistic, Long>> STATISTIC_MAP_TOKEN = new TypeToken<Map<Statistic, Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableMapValue<Statistic, Long>> STATISTIC_MAP_VALUE_TOKEN = new TypeToken<MutableMapValue<Statistic, Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<StoneType> STONE_TOKEN = new TypeToken<StoneType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<StoneType>> STONE_VALUE_TOKEN = new TypeToken<MutableValue<StoneType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<String> STRING_TOKEN = new TypeToken<String>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<String>> STRING_VALUE_TOKEN = new TypeToken<MutableValue<String>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<StructureMode> STRUCTURE_MODE_TOKEN = new TypeToken<StructureMode>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<StructureMode>> STRUCTURE_MODE_VALUE_TOKEN = new TypeToken<MutableValue<StructureMode>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Text> TEXT_TOKEN = new TypeToken<Text>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Text>> TEXT_VALUE_TOKEN = new TypeToken<MutableValue<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<TreeType> TREE_TOKEN = new TypeToken<TreeType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<TreeType>> TREE_VALUE_TOKEN = new TypeToken<MutableValue<TreeType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<UUID> UUID_TOKEN = new TypeToken<UUID>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<UUID>> UUID_VALUE_TOKEN = new TypeToken<MutableValue<UUID>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Vector3d> VECTOR_3D_TOKEN = new TypeToken<Vector3d>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Vector3d>> VECTOR_3D_VALUE_TOKEN = new TypeToken<MutableValue<Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Vector3i> VECTOR_3I_TOKEN = new TypeToken<Vector3i>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<Vector3i>> VECTOR_3I_VALUE_TOKEN = new TypeToken<MutableValue<Vector3i>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WallType> WALL_TOKEN = new TypeToken<WallType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<WallType>> WALL_VALUE_TOKEN = new TypeToken<MutableValue<WallType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableWeightedCollectionValue<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_COLLECTION_VALUE_TOKEN = new TypeToken<MutableWeightedCollectionValue<EntityArchetype>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WeightedTable<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TABLE_TOKEN = new TypeToken<WeightedTable<EntityArchetype>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WeightedSerializableObject<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TOKEN = new TypeToken<WeightedSerializableObject<EntityArchetype>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<WeightedSerializableObject<EntityArchetype>>> WEIGHTED_ENTITY_ARCHETYPE_VALUE_TOKEN = new TypeToken<MutableValue<WeightedSerializableObject<EntityArchetype>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Direction, WireAttachmentType>> WIRE_ATTACHMENT_MAP_TOKEN = new TypeToken<Map<Direction, WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableMapValue<Direction, WireAttachmentType>> WIRE_ATTACHMENT_MAP_VALUE_TOKEN = new TypeToken<MutableMapValue<Direction, WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WireAttachmentType> WIRE_ATTACHMENT_TYPE_TOKEN = new TypeToken<WireAttachmentType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MutableValue<WireAttachmentType>> WIRE_ATTACHMENT_TYPE_VALUE_TOKEN = new TypeToken<MutableValue<WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private TypeTokens() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
