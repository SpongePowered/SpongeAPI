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

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.block.entity.BlockEntityArchetype;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.meta.BannerPatternLayer;
import org.spongepowered.api.data.type.ArtType;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.type.CatType;
import org.spongepowered.api.data.type.ComparatorMode;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.Hinge;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.LlamaType;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.ParrotType;
import org.spongepowered.api.data.type.PickupRule;
import org.spongepowered.api.data.type.PistonType;
import org.spongepowered.api.data.type.PortionType;
import org.spongepowered.api.data.type.Profession;
import org.spongepowered.api.data.type.RabbitType;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SlabPortion;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.type.TropicalFishShape;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.data.type.WoodType;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.SetValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.WeightedCollectionValue;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.attribute.AttributeOperation;
import org.spongepowered.api.entity.attribute.ModifierTemplate;
import org.spongepowered.api.entity.attribute.type.AttributeType;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.fluid.FluidStack;
import org.spongepowered.api.fluid.FluidStackSnapshot;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.item.FireworkEffect;
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
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.util.weighted.WeightedSerializableObject;
import org.spongepowered.api.util.weighted.WeightedTable;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@SuppressWarnings({"unused", "UnstableApiUsage"})
public final class TypeTokens {

    // SORTFIELDS:ON

    public static final TypeToken<AttributeOperation> ATTRIBUTE_OPERATION_TOKEN = new TypeToken<AttributeOperation>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<AttributeOperation>> ATTRIBUTE_OPERATION_VALUE_TOKEN = new TypeToken<Value<AttributeOperation>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<AttributeType> ATTRIBUTE_TYPE_TOKEN = new TypeToken<AttributeType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<AttributeType>> ATTRIBUTE_TYPE_VALUE_TOKEN = new TypeToken<Value<AttributeType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ArtType> ART_TYPE_TOKEN = new TypeToken<ArtType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ArtType>> ART_TYPE_VALUE_TOKEN = new TypeToken<Value<ArtType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Axis> AXIS_TOKEN = new TypeToken<Axis>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Axis>> AXIS_VALUE_TOKEN = new TypeToken<Value<Axis>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BlockEntityArchetype> BLOCK_ENTITY_ARCHETYPE_TOKEN = new TypeToken<BlockEntityArchetype>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BlockEntity> BLOCK_ENTITY_TOKEN = new TypeToken<BlockEntity>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BlockSnapshot> BLOCK_SNAPSHOT_TOKEN = new TypeToken<BlockSnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BlockState> BLOCK_STATE_TOKEN = new TypeToken<BlockState>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<BlockState>> BLOCK_STATE_VALUE_TOKEN = new TypeToken<Value<BlockState>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Boolean> BOOLEAN_TOKEN = new TypeToken<Boolean>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Boolean>> BOOLEAN_VALUE_TOKEN = new TypeToken<Value<Boolean>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BoundedValue<Double>> BOUNDED_DOUBLE_VALUE_TOKEN = new TypeToken<BoundedValue<Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BoundedValue<Integer>> BOUNDED_INTEGER_VALUE_TOKEN = new TypeToken<BoundedValue<Integer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BoundedValue<Short>> BOUNDED_SHORT_VALUE_TOKEN = new TypeToken<BoundedValue<Short>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<CatType> CAT_TYPE_TOKEN = new TypeToken<CatType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<CatType>> CAT_TYPE_VALUE_TOKEN = new TypeToken<Value<CatType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Color> COLOR_TOKEN = new TypeToken<Color>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Color>> COLOR_VALUE_TOKEN = new TypeToken<Value<Color>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ComparatorMode> COMPARATOR_MODE_TOKEN = new TypeToken<ComparatorMode>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ComparatorMode>> COMPARATOR_MODE_VALUE_TOKEN = new TypeToken<Value<ComparatorMode>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Direction> DIRECTION_TOKEN = new TypeToken<Direction>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Direction>> DIRECTION_VALUE_TOKEN = new TypeToken<Value<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Double> DOUBLE_TOKEN = new TypeToken<Double>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Double>> DOUBLE_VALUE_TOKEN = new TypeToken<Value<Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<DyeColor> DYE_COLOR_TOKEN = new TypeToken<DyeColor>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<DyeColor>> DYE_COLOR_VALUE_TOKEN = new TypeToken<Value<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<EntityArchetype> ENTITY_ARCHETYPE_TOKEN = new TypeToken<EntityArchetype>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<EntitySnapshot> ENTITY_SNAPSHOT_TOKEN = new TypeToken<EntitySnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<EntitySnapshot>> ENTITY_SNAPSHOT_VALUE_TOKEN = new TypeToken<Value<EntitySnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Entity> ENTITY_TOKEN = new TypeToken<Entity>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<EntityType<?>, Double>> ENTITY_TYPE_DOUBLE_MAP_TOKEN = new TypeToken<Map<EntityType<?>, Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<EntityType<?>, Double>> ENTITY_TYPE_DOUBLE_MAP_VALUE_TOKEN = new TypeToken<MapValue<EntityType<?>, Double>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<EntityType<?>> ENTITY_TYPE_TOKEN = new TypeToken<EntityType<?>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<EntityType<?>>> ENTITY_TYPE_VALUE_TOKEN = new TypeToken<Value<EntityType<?>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Float> FLOAT_TOKEN = new TypeToken<Float>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<BoundedValue<Float>> FLOAT_VALUE_TOKEN = new TypeToken<BoundedValue<Float>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<FluidStack> FLUID_STACK_TOKEN = new TypeToken<FluidStack>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<FluidState> FLUID_STATE_TOKEN = new TypeToken<FluidState>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<FluidStackSnapshot> FLUID_TOKEN = new TypeToken<FluidStackSnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<FluidStackSnapshot>> FLUID_VALUE_TOKEN = new TypeToken<Value<FluidStackSnapshot>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<GameMode> GAME_MODE_TOKEN = new TypeToken<GameMode>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<GameMode>> GAME_MODE_VALUE_TOKEN = new TypeToken<Value<GameMode>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<GameProfile> GAME_PROFILE_TOKEN = new TypeToken<GameProfile>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<GameProfile>> GAME_PROFILE_VALUE_TOKEN = new TypeToken<Value<GameProfile>>() {private static final long serialVersionUID = -1;};

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

    public static final TypeToken<ItemStackSnapshot> ITEM_STACK_SNAPSHOT_TOKEN = new TypeToken<ItemStackSnapshot>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ItemStack> ITEM_STACK_TOKEN = new TypeToken<ItemStack>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<BannerPatternLayer>> LIST_BANNER_PATTERN_LAYER_TOKEN = new TypeToken<List<BannerPatternLayer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<BannerPatternLayer>> LIST_BANNER_PATTERN_LAYER_VALUE_TOKEN = new TypeToken<ListValue<BannerPatternLayer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<? extends DataSerializable>> LIST_DATA_SERIALIZEABLE_TOKEN = new TypeToken<List<? extends DataSerializable>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<DyeColor>> LIST_DYE_COLOR_TOKEN = new TypeToken<List<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<DyeColor>> LIST_DYE_COLOR_VALUE_TOKEN = new TypeToken<ListValue<DyeColor>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<Enchantment>> LIST_ENCHANTMENT_TOKEN = new TypeToken<List<Enchantment>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<Enchantment>> LIST_ENCHANTMENT_VALUE_TOKEN = new TypeToken<ListValue<Enchantment>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<FireworkEffect>> LIST_FIREWORK_TOKEN = new TypeToken<List<FireworkEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<PotionEffect>> LIST_POTION_TOKEN = new TypeToken<List<PotionEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<PotionEffect>> LIST_POTION_VALUE_TOKEN = new TypeToken<ListValue<PotionEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<String>> LIST_STRING_VALUE_TOKEN = new TypeToken<ListValue<String>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<Text>> LIST_TEXT_TOKEN = new TypeToken<List<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<Text>> LIST_TEXT_VALUE_TOKEN = new TypeToken<ListValue<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<List<TradeOffer>> LIST_TRADE_OFFER_TOKEN = new TypeToken<List<TradeOffer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<FireworkEffect>> LIST_VALUE_FIREWORK_TOKEN = new TypeToken<ListValue<FireworkEffect>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ListValue<TradeOffer>> LIST_VALUE_TRADE_OFFER_TOKEN = new TypeToken<ListValue<TradeOffer>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<LlamaType> LLAMA_TYPE_TOKEN = new TypeToken<LlamaType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<LlamaType>> LLAMA_TYPE_VALUE_TOKEN = new TypeToken<Value<LlamaType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Long> LONG_TOKEN = new TypeToken<Long>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Long>> LONG_VALUE_TOKEN = new TypeToken<Value<Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_TOKEN = new TypeToken<Map<BodyPart, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_VALUE_TOKEN = new TypeToken<MapValue<BodyPart, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_TOKEN = new TypeToken<Map<Direction, List<FluidStackSnapshot>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_VALUE_TOKEN = new TypeToken<MapValue<Direction, List<FluidStackSnapshot>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<UUID, Vector3d>> MAP_UUID_VECTOR3D_TOKEN = new TypeToken<Map<UUID, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<UUID, Vector3d>> MAP_UUID_VECTOR3D_VALUE_TOKEN = new TypeToken<MapValue<UUID, Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ModifierTemplate> MODIFIER_TEMPLATE_TOKEN = new TypeToken<ModifierTemplate>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ModifierTemplate>> MODIFIER_TEMPLATE_VALUE_TOKEN = new TypeToken<Value<ModifierTemplate>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<NotePitch> NOTE_TOKEN = new TypeToken<NotePitch>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<NotePitch>> NOTE_VALUE_TOKEN = new TypeToken<Value<NotePitch>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Object> OBJECT = TypeToken.of(Object.class);

    public static final TypeToken<ParrotType> PARROT_TYPE_TOKEN = new TypeToken<ParrotType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ParrotType>> PARROT_TYPE_VALUE_TOKEN = new TypeToken<Value<ParrotType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ParticleType> PARTICLE_TYPE_TOKEN = new TypeToken<ParticleType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ParticleType>> PARTICLE_TYPE_VALUE_TOKEN = new TypeToken<Value<ParticleType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PickupRule> PICKUP_TOKEN = new TypeToken<PickupRule>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PickupRule>> PICKUP_VALUE_TOKEN = new TypeToken<Value<PickupRule>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PistonType> PISTON_TYPE_TOKEN = new TypeToken<PistonType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PistonType>> PISTON_TYPE_VALUE_TOKEN = new TypeToken<Value<PistonType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PortionType> PORTION_TOKEN = new TypeToken<PortionType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PortionType>> PORTION_VALUE_TOKEN = new TypeToken<Value<PortionType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PotionEffectType> POTION_EFFECT_TYPE_TOKEN = new TypeToken<PotionEffectType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<PotionType> POTION_TOKEN = new TypeToken<PotionType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<PotionType>> POTION_VALUE_TOKEN = new TypeToken<Value<PotionType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Profession> PROFESSION_TOKEN = new TypeToken<Profession>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Profession>> PROFESSION_VALUE_TOKEN = new TypeToken<Value<Profession>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<ProfileProperty> PROFILE_PROPERTY_TOKEN = new TypeToken<ProfileProperty>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<ProfileProperty>> PROFILE_PROPERTY_VALUE_TOKEN = new TypeToken<Value<ProfileProperty>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<RabbitType> RABBIT_TYPE_TOKEN = new TypeToken<RabbitType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<RabbitType>> RABBIT_TYPE_VALUE_TOKEN = new TypeToken<Value<RabbitType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<RailDirection> RAIL_TOKEN = new TypeToken<RailDirection>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<RailDirection>> RAIL_VALUE_TOKEN = new TypeToken<Value<RailDirection>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Rotation> ROTATION_TOKEN = new TypeToken<Rotation>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Rotation>> ROTATION_VALUE_TOKEN = new TypeToken<Value<Rotation>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Set<BlockType>> SET_BLOCK_TOKEN = new TypeToken<Set<BlockType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SetValue<BlockType>> SET_BLOCK_VALUE_TOKEN = new TypeToken<SetValue<BlockType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Set<Direction>> SET_DIRECTION_TOKEN = new TypeToken<Set<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SetValue<Direction>> SET_DIRECTION_VALUE_TOKEN = new TypeToken<SetValue<Direction>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SetValue<EquipmentType>> SET_EQUIPMENT_TYPE_TOKEN = new TypeToken<SetValue<EquipmentType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Set<String>> SET_STRING_TOKEN = new TypeToken<Set<String>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SetValue<String>> SET_STRING_VALUE_TOKEN = new TypeToken<SetValue<String>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Short> SHORT_TOKEN = new TypeToken<Short>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<SlabPortion> SLAB_PORTION_TOKEN = new TypeToken<SlabPortion>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<SlabPortion>> SLAB_PORTION_VALUE_TOKEN = new TypeToken<Value<SlabPortion>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<StairShape> STAIR_TOKEN = new TypeToken<StairShape>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<StairShape>> STAIR_VALUE_TOKEN = new TypeToken<Value<StairShape>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Statistic, Long>> STATISTIC_MAP_TOKEN = new TypeToken<Map<Statistic, Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<Statistic, Long>> STATISTIC_MAP_VALUE_TOKEN = new TypeToken<MapValue<Statistic, Long>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<String> STRING_TOKEN = new TypeToken<String>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<String>> STRING_VALUE_TOKEN = new TypeToken<Value<String>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<StructureMode> STRUCTURE_MODE_TOKEN = new TypeToken<StructureMode>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<StructureMode>> STRUCTURE_MODE_VALUE_TOKEN = new TypeToken<Value<StructureMode>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Text> TEXT_TOKEN = new TypeToken<Text>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Text>> TEXT_VALUE_TOKEN = new TypeToken<Value<Text>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<TropicalFishShape> TROPICAL_FISH_SHAPE_TOKEN = new TypeToken<TropicalFishShape>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<TropicalFishShape>> TROPICAL_FISH_SHAPE_VALUE_TOKEN = new TypeToken<Value<TropicalFishShape>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<User> USER_TOKEN = new TypeToken<User>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<UUID> UUID_TOKEN = new TypeToken<UUID>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<UUID>> UUID_VALUE_TOKEN = new TypeToken<Value<UUID>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Vector3d> VECTOR_3D_TOKEN = new TypeToken<Vector3d>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Vector3d>> VECTOR_3D_VALUE_TOKEN = new TypeToken<Value<Vector3d>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Vector3i> VECTOR_3I_TOKEN = new TypeToken<Vector3i>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<Vector3i>> VECTOR_3I_VALUE_TOKEN = new TypeToken<Value<Vector3i>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WeightedCollectionValue<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_COLLECTION_VALUE_TOKEN = new TypeToken<WeightedCollectionValue<EntityArchetype>> () {private static final long serialVersionUID = -1;};

    public static final TypeToken<WeightedTable<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TABLE_TOKEN = new TypeToken<WeightedTable<EntityArchetype>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WeightedSerializableObject<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TOKEN = new TypeToken<WeightedSerializableObject<EntityArchetype>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<WeightedSerializableObject<EntityArchetype>>> WEIGHTED_ENTITY_ARCHETYPE_VALUE_TOKEN = new TypeToken<Value<WeightedSerializableObject<EntityArchetype>>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Map<Direction, WireAttachmentType>> WIRE_ATTACHMENT_MAP_TOKEN = new TypeToken<Map<Direction, WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<MapValue<Direction, WireAttachmentType>> WIRE_ATTACHMENT_MAP_VALUE_TOKEN = new TypeToken<MapValue<Direction, WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WireAttachmentType> WIRE_ATTACHMENT_TYPE_TOKEN = new TypeToken<WireAttachmentType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<WireAttachmentType>> WIRE_ATTACHMENT_TYPE_VALUE_TOKEN = new TypeToken<Value<WireAttachmentType>>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<WoodType> WOOD_TYPE_TOKEN = new TypeToken<WoodType>() {private static final long serialVersionUID = -1;};

    public static final TypeToken<Value<WoodType>> WOOD_TYPE_VALUE_TOKEN = new TypeToken<Value<WoodType>>() {private static final long serialVersionUID = -1;};

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private TypeTokens() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
