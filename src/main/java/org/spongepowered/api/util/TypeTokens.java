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

import io.leangen.geantyref.TypeToken;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.data.meta.BannerPatternLayer;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.type.ArmorMaterial;
import org.spongepowered.api.data.type.ArtType;
import org.spongepowered.api.data.type.AttachmentSurface;
import org.spongepowered.api.data.type.BoatType;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.type.CatType;
import org.spongepowered.api.data.type.ChestAttachmentType;
import org.spongepowered.api.data.type.ComparatorMode;
import org.spongepowered.api.data.type.DoorHinge;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.FoxType;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.LlamaType;
import org.spongepowered.api.data.type.MatterState;
import org.spongepowered.api.data.type.MooshroomType;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.PandaGene;
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
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StructureMode;
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
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityArchetype;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.attribute.AttributeOperation;
import org.spongepowered.api.entity.attribute.type.AttributeType;
import org.spongepowered.api.entity.explosive.EnderCrystal;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.fluid.FluidStackSnapshot;
import org.spongepowered.api.item.FireworkEffect;
import org.spongepowered.api.item.FireworkShape;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.item.potion.PotionType;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.property.ProfileProperty;
import org.spongepowered.api.projectile.source.ProjectileSource;
import org.spongepowered.api.raid.RaidWave;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.util.orientation.Orientation;
import org.spongepowered.api.util.weighted.WeightedSerializableObject;
import org.spongepowered.api.util.weighted.WeightedTable;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;
import org.spongepowered.plugin.PluginContainer;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

@SuppressWarnings({"unused"})
public final class TypeTokens {

    // SORTFIELDS:ON
    // @formatter:off

    public static final TypeToken<Value<ArmorMaterial>> ARMOR_MATERIAL_VALUE_TOKEN = new TypeToken<Value<ArmorMaterial>>() {};

    public static final TypeToken<Value<AttributeOperation>> ATTRIBUTE_OPERATION_VALUE_TOKEN = new TypeToken<Value<AttributeOperation>>() {};

    public static final TypeToken<Value<AttributeType>> ATTRIBUTE_TYPE_VALUE_TOKEN = new TypeToken<Value<AttributeType>>() {};

    public static final TypeToken<Value<ArtType>> ART_TYPE_VALUE_TOKEN = new TypeToken<Value<ArtType>>() {};

    public static final TypeToken<Value<AttachmentSurface>> ATTACHMENT_SURFACE_VALUE_TOKEN = new TypeToken<Value<AttachmentSurface>>() {};

    public static final TypeToken<Value<Axis>> AXIS_VALUE_TOKEN = new TypeToken<Value<Axis>>() {};

    public static final TypeToken<Value<BlockState>> BLOCK_STATE_VALUE_TOKEN = new TypeToken<Value<BlockState>>() {};

    public static final TypeToken<Value<BoatType>> BOAT_TYPE_VALUE_TOKEN = new TypeToken<Value<BoatType>>() {};

    public static final TypeToken<Value<Boolean>> BOOLEAN_VALUE_TOKEN = new TypeToken<Value<Boolean>>() {};

    public static final TypeToken<Value<BossBar>> BOSS_BAR_VALUE_TOKEN = new TypeToken<Value<BossBar>>() {};

    public static final TypeToken<Value<CatType>> CAT_TYPE_VALUE_TOKEN = new TypeToken<Value<CatType>>() {};

    public static final TypeToken<Value<ChestAttachmentType>> CHEST_ATTACHMENT_TYPE_VALUE_TOKEN = new TypeToken<Value<ChestAttachmentType>>() {};

    public static final TypeToken<Value<Color>> COLOR_VALUE_TOKEN = new TypeToken<Value<Color>>() {};

    public static final TypeToken<Consumer<CommandCause>> COMMAND_CAUSE_CONSUMER = new TypeToken<Consumer<CommandCause>>() {};

    public static final TypeToken<Value<ComparatorMode>> COMPARATOR_MODE_VALUE_TOKEN = new TypeToken<Value<ComparatorMode>>() {};

    public static final TypeToken<Value<Component>> COMPONENT_VALUE_TOKEN = new TypeToken<Value<Component>>() {};

    public static final TypeToken<Value<Direction>> DIRECTION_VALUE_TOKEN = new TypeToken<Value<Direction>>() {};

    public static final TypeToken<Value<DoorHinge>> DOOR_HINGE_VALUE_TOKEN = new TypeToken<Value<DoorHinge>>() {};

    public static final TypeToken<Value<Double>> DOUBLE_VALUE_TOKEN = new TypeToken<Value<Double>>() {};

    public static final TypeToken<Value<DyeColor>> DYE_COLOR_VALUE_TOKEN = new TypeToken<Value<DyeColor>>() {};

    public static final TypeToken<Value<EnderCrystal>> ENDER_CRYSTAL_VALUE_TOKEN = new TypeToken<Value<EnderCrystal>>() {};

    public static final TypeToken<Value<EntitySnapshot>> ENTITY_SNAPSHOT_VALUE_TOKEN = new TypeToken<Value<EntitySnapshot>>() {};

    public static final TypeToken<Value<Entity>> ENTITY_VALUE_TOKEN = new TypeToken<Value<Entity>>() {};

    public static final TypeToken<Map<EntityType<?>, Double>> MAP_ENTITY_TYPE_DOUBLE_TOKEN = new TypeToken<Map<EntityType<?>, Double>>() {};

    public static final TypeToken<MapValue<EntityType<?>, Double>> MAP_ENTITY_TYPE_DOUBLE_VALUE_TOKEN = new TypeToken<MapValue<EntityType<?>, Double>>() {};

    public static final TypeToken<Value<EntityType<?>>> ENTITY_TYPE_VALUE_TOKEN = new TypeToken<Value<EntityType<?>>>() {};

    public static final TypeToken<Value<EquipmentType>> EQUIPMENT_TYPE_VALUE_TOKEN = new TypeToken<Value<EquipmentType>>() {};

    public static final TypeToken<Value<FireworkShape>> FIREWORK_SHAPE_VALUE_TOKEN = new TypeToken<Value<FireworkShape>>() {};

    public static final TypeToken<Value<FluidStackSnapshot>> FLUID_STACK_SNAPSHOT_VALUE_TOKEN = new TypeToken<Value<FluidStackSnapshot>>() {};

    public static final TypeToken<Value<FoxType>> FOX_TYPE_VALUE_TOKEN = new TypeToken<Value<FoxType>>() {};

    public static final TypeToken<Value<GameMode>> GAME_MODE_VALUE_TOKEN = new TypeToken<Value<GameMode>>() {};

    public static final TypeToken<Value<GameProfile>> GAME_PROFILE_VALUE_TOKEN = new TypeToken<Value<GameProfile>>() {};

    public static final TypeToken<Value<HandPreference>> HAND_PREFERENCE_VALUE_TOKEN = new TypeToken<Value<HandPreference>>() {};

    public static final TypeToken<Value<HorseColor>> HORSE_COLOR_VALUE_TOKEN = new TypeToken<Value<HorseColor>>() {};

    public static final TypeToken<Value<HorseStyle>> HORSE_STYLE_VALUE_TOKEN = new TypeToken<Value<HorseStyle>>() {};

    public static final TypeToken<Value<Instant>> INSTANT_VALUE_TOKEN = new TypeToken<Value<Instant>>() {};

    public static final TypeToken<Value<InstrumentType>> INSTRUMENT_TYPE_VALUE_TOKEN = new TypeToken<Value<InstrumentType>>() {};

    public static final TypeToken<Value<Integer>> INTEGER_VALUE_TOKEN = new TypeToken<Value<Integer>>() {};

    public static final TypeToken<Value<ItemType>> ITEM_TYPE_VALUE_TOKEN = new TypeToken<Value<ItemType>>() {};

    public static final TypeToken<Value<ItemStackSnapshot>> ITEM_STACK_SNAPSHOT_VALUE_TOKEN = new TypeToken<Value<ItemStackSnapshot>>() {};

    public static final TypeToken<List<BannerPatternLayer>> LIST_BANNER_PATTERN_LAYER_TOKEN = new TypeToken<List<BannerPatternLayer>>() {};

    public static final TypeToken<ListValue<BannerPatternLayer>> LIST_BANNER_PATTERN_LAYER_VALUE_TOKEN = new TypeToken<ListValue<BannerPatternLayer>>() {};

    public static final TypeToken<List<Component>> LIST_COMPONENT_TOKEN = new TypeToken<List<Component>>() {};

    public static final TypeToken<ListValue<Component>> LIST_COMPONENT_VALUE_TOKEN = new TypeToken<ListValue<Component>>() {};

    public static final TypeToken<List<? extends DataSerializable>> LIST_DATA_SERIALIZABLE_TOKEN = new TypeToken<List<? extends DataSerializable>>() {};

    public static final TypeToken<List<DyeColor>> LIST_DYE_COLOR_TOKEN = new TypeToken<List<DyeColor>>() {};

    public static final TypeToken<ListValue<DyeColor>> LIST_DYE_COLOR_VALUE_TOKEN = new TypeToken<ListValue<DyeColor>>() {};

    public static final TypeToken<List<Enchantment>> LIST_ENCHANTMENT_TOKEN = new TypeToken<List<Enchantment>>() {};

    public static final TypeToken<ListValue<Enchantment>> LIST_ENCHANTMENT_VALUE_TOKEN = new TypeToken<ListValue<Enchantment>>() {};

    public static final TypeToken<List<Entity>> LIST_ENTITY_TOKEN = new TypeToken<List<Entity>>() {};

    public static final TypeToken<ListValue<Entity>> LIST_ENTITY_VALUE_TOKEN = new TypeToken<ListValue<Entity>>() {};

    public static final TypeToken<List<FireworkEffect>> LIST_FIREWORK_EFFECT_TOKEN = new TypeToken<List<FireworkEffect>>() {};

    public static final TypeToken<ListValue<FireworkEffect>> LIST_FIREWORK_EFFECT_VALUE_TOKEN = new TypeToken<ListValue<FireworkEffect>>() {};

    public static final TypeToken<List<PotionEffect>> LIST_POTION_EFFECT_TOKEN = new TypeToken<List<PotionEffect>>() {};

    public static final TypeToken<ListValue<PotionEffect>> LIST_POTION_EFFECT_VALUE_TOKEN = new TypeToken<ListValue<PotionEffect>>() {};

    public static final TypeToken<ListValue<String>> LIST_STRING_VALUE_TOKEN = new TypeToken<ListValue<String>>() {};

    public static final TypeToken<List<TradeOffer>> LIST_TRADE_OFFER_TOKEN = new TypeToken<List<TradeOffer>>() {};

    public static final TypeToken<ListValue<TradeOffer>> LIST_TRADE_OFFER_VALUE_TOKEN = new TypeToken<ListValue<TradeOffer>>() {};

    public static final TypeToken<Value<Living>> LIVING_VALUE_TOKEN = new TypeToken<Value<Living>>() {};

    public static final TypeToken<Value<LlamaType>> LLAMA_TYPE_VALUE_TOKEN = new TypeToken<Value<LlamaType>>() {};

    public static final TypeToken<Value<Long>> LONG_VALUE_TOKEN = new TypeToken<Value<Long>>() {};

    public static final TypeToken<Map<EquipmentType, Boolean>> MAP_EQUIPMENT_TYPE_BOOLEAN_TOKEN = new TypeToken<Map<EquipmentType, Boolean>>() {};

    public static final TypeToken<MapValue<EquipmentType, Boolean>> MAP_EQUIPMENT_TYPE_BOOLEAN_VALUE_TOKEN = new TypeToken<MapValue<EquipmentType, Boolean>>() {};

    public static final TypeToken<Map<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_TOKEN = new TypeToken<Map<BodyPart, Vector3d>>() {};

    public static final TypeToken<MapValue<BodyPart, Vector3d>> MAP_BODY_VECTOR3D_VALUE_TOKEN = new TypeToken<MapValue<BodyPart, Vector3d>>() {};

    public static final TypeToken<Map<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_STACK_SNAPSHOT_TOKEN = new TypeToken<Map<Direction, List<FluidStackSnapshot>>>() {};

    public static final TypeToken<MapValue<Direction, List<FluidStackSnapshot>>> MAP_DIRECTION_FLUID_STACK_SNAPSHOT_VALUE_TOKEN = new TypeToken<MapValue<Direction, List<FluidStackSnapshot>>>() {};

    public static final TypeToken<Map<UUID, RespawnLocation>> MAP_UUID_RESPAWN_LOCATION_TOKEN = new TypeToken<Map<UUID, RespawnLocation>>() {};

    public static final TypeToken<MapValue<UUID, RespawnLocation>> MAP_UUID_RESPAWN_LOCATION_VALUE_TOKEN = new TypeToken<MapValue<UUID, RespawnLocation>>() {};

    public static final TypeToken<Map<UUID, Vector3d>> MAP_UUID_VECTOR3D_TOKEN = new TypeToken<Map<UUID, Vector3d>>() {};

    public static final TypeToken<MapValue<UUID, Vector3d>> MAP_UUID_VECTOR3D_VALUE_TOKEN = new TypeToken<MapValue<UUID, Vector3d>>() {};

    public static final TypeToken<Value<MatterState>> MATTER_STATE_VALUE_TOKEN = new TypeToken<Value<MatterState>>() {};

    public static final TypeToken<Value<MooshroomType>> MOOSHROOM_TYPE_VALUE_TOKEN = new TypeToken<Value<MooshroomType>>() {};

    public static final TypeToken<Value<MusicDisc>> MUSIC_DISC_VALUE_TOKEN = new TypeToken<Value<MusicDisc>>() {};

    public static final TypeToken<Value<NotePitch>> NOTE_PITCH_VALUE_TOKEN = new TypeToken<Value<NotePitch>>() {};

    public static final TypeToken<Value<Orientation>> ORIENTATION_VALUE_TOKEN = new TypeToken<Value<Orientation>>() {};

    public static final TypeToken<Value<PandaGene>> PANDA_GENE_VALUE_TOKEN = new TypeToken<Value<PandaGene>>() {};

    public static final TypeToken<Value<ParrotType>> PARROT_TYPE_VALUE_TOKEN = new TypeToken<Value<ParrotType>>() {};

    public static final TypeToken<Value<ParticleEffect>> PARTICLE_EFFECT_VALUE_TOKEN = new TypeToken<Value<ParticleEffect>>() {};

    public static final TypeToken<Value<ParticleType>> PARTICLE_TYPE_VALUE_TOKEN = new TypeToken<Value<ParticleType>>() {};

    public static final TypeToken<Value<PhantomPhase>> PHANTOM_PHASE_VALUE_TOKEN = new TypeToken<Value<PhantomPhase>>() {};

    public static final TypeToken<Value<PickupRule>> PICKUP_RULE_VALUE_TOKEN = new TypeToken<Value<PickupRule>>() {};

    public static final TypeToken<Value<PistonType>> PISTON_TYPE_VALUE_TOKEN = new TypeToken<Value<PistonType>>() {};

    public static final TypeToken<Value<PluginContainer>> PLUGIN_CONTAINER_VALUE_TOKEN = new TypeToken<Value<PluginContainer>>() {};

    public static final TypeToken<Value<PortionType>> PORTION_TYPE_VALUE_TOKEN = new TypeToken<Value<PortionType>>() {};

    public static final TypeToken<Value<PotionEffectType>> POTION_EFFECT_TYPE_VALUE_TOKEN = new TypeToken<Value<PotionEffectType>>() {};

    public static final TypeToken<Value<PotionType>> POTION_TYPE_VALUE_TOKEN = new TypeToken<Value<PotionType>>() {};

    public static final TypeToken<Value<ProfessionType>> PROFESSION_VALUE_TOKEN = new TypeToken<Value<ProfessionType>>() {};

    public static final TypeToken<Value<ProfileProperty>> PROFILE_PROPERTY_VALUE_TOKEN = new TypeToken<Value<ProfileProperty>>() {};

    public static final TypeToken<Value<ProjectileSource>> PROJECTILE_SOURCE_VALUE_TOKEN = new TypeToken<Value<ProjectileSource>>() {};

    public static final TypeToken<Value<RabbitType>> RABBIT_TYPE_VALUE_TOKEN = new TypeToken<Value<RabbitType>>() {};

    public static final TypeToken<Value<RaidWave>> RAID_WAVE_VALUE_TOKEN = new TypeToken<Value<RaidWave>>() {};

    public static final TypeToken<Value<RailDirection>> RAIL_DIRECTION_VALUE_TOKEN = new TypeToken<Value<RailDirection>>() {};

    public static final TypeToken<Set<BlockType>> SET_BLOCK_TYPE_TOKEN = new TypeToken<Set<BlockType>>() {};

    public static final TypeToken<SetValue<BlockType>> SET_BLOCK_TYPE_VALUE_TOKEN = new TypeToken<SetValue<BlockType>>() {};

    public static final TypeToken<Set<Direction>> SET_DIRECTION_TOKEN = new TypeToken<Set<Direction>>() {};

    public static final TypeToken<SetValue<Direction>> SET_DIRECTION_VALUE_TOKEN = new TypeToken<SetValue<Direction>>() {};

    public static final TypeToken<Set<String>> SET_STRING_TOKEN = new TypeToken<Set<String>>() {};

    public static final TypeToken<SetValue<String>> SET_STRING_VALUE_TOKEN = new TypeToken<SetValue<String>>() {};

    public static final TypeToken<Value<Sheep>> SHEEP_VALUE_TOKEN = new TypeToken<Value<Sheep>>() {};

    public static final TypeToken<Value<SlabPortion>> SLAB_PORTION_VALUE_TOKEN = new TypeToken<Value<SlabPortion>>() {};

    public static final TypeToken<Value<SpellType>> SPELL_TYPE_VALUE_TOKEN = new TypeToken<Value<SpellType>>() {};

    public static final TypeToken<Value<StairShape>> STAIR_SHAPE_VALUE_TOKEN = new TypeToken<Value<StairShape>>() {};

    public static final TypeToken<Map<Statistic, Long>> MAP_STATISTIC_LONG_TOKEN = new TypeToken<Map<Statistic, Long>>() {};

    public static final TypeToken<MapValue<Statistic, Long>> MAP_STATISTIC_LONG_VALUE_TOKEN = new TypeToken<MapValue<Statistic, Long>>() {};

    public static final TypeToken<Value<String>> STRING_VALUE_TOKEN = new TypeToken<Value<String>>() {};

    public static final TypeToken<Value<StructureMode>> STRUCTURE_MODE_VALUE_TOKEN = new TypeToken<Value<StructureMode>>() {};

    public static final TypeToken<Value<ToolType>> TOOL_TYPE_VALUE_TOKEN = new TypeToken<Value<ToolType>>() {};

    public static final TypeToken<Value<TropicalFishShape>> TROPICAL_FISH_SHAPE_VALUE_TOKEN = new TypeToken<Value<TropicalFishShape>>() {};

    public static final TypeToken<Value<UUID>> UUID_VALUE_TOKEN = new TypeToken<Value<UUID>>() {};

    public static final TypeToken<Value<Vector2i>> VECTOR_2I_VALUE_TOKEN = new TypeToken<Value<Vector2i>>() {};

    public static final TypeToken<Value<Vector3d>> VECTOR_3D_VALUE_TOKEN = new TypeToken<Value<Vector3d>>() {};

    public static final TypeToken<Value<Vector3i>> VECTOR_3I_VALUE_TOKEN = new TypeToken<Value<Vector3i>>() {};

    public static final TypeToken<Value<VillagerType>> VILLAGER_TYPE_VALUE_TOKEN = new TypeToken<Value<VillagerType>>() {};

    public static final TypeToken<WeightedCollectionValue<PotionEffect>> WEIGHTED_POTION_EFFECT_COLLECTION_VALUE_TOKEN = new TypeToken<WeightedCollectionValue<PotionEffect>>() {};

    public static final TypeToken<WeightedCollectionValue<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_COLLECTION_VALUE_TOKEN = new TypeToken<WeightedCollectionValue<EntityArchetype>> () {};

    public static final TypeToken<WeightedTable<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TABLE_TOKEN = new TypeToken<WeightedTable<EntityArchetype>>() {};

    public static final TypeToken<WeightedSerializableObject<EntityArchetype>> WEIGHTED_ENTITY_ARCHETYPE_TOKEN = new TypeToken<WeightedSerializableObject<EntityArchetype>>() {};

    public static final TypeToken<Value<WeightedSerializableObject<EntityArchetype>>> WEIGHTED_ENTITY_ARCHETYPE_VALUE_TOKEN = new TypeToken<Value<WeightedSerializableObject<EntityArchetype>>>() {};

    public static final TypeToken<Map<Direction, WireAttachmentType>> MAP_DIRECTION_WIRE_ATTACHMENT_TOKEN = new TypeToken<Map<Direction, WireAttachmentType>>() {};

    public static final TypeToken<MapValue<Direction, WireAttachmentType>> MAP_DIRECTION_WIRE_ATTACHMENT_VALUE_TOKEN = new TypeToken<MapValue<Direction, WireAttachmentType>>() {};

    public static final TypeToken<Value<WireAttachmentType>> WIRE_ATTACHMENT_TYPE_VALUE_TOKEN = new TypeToken<Value<WireAttachmentType>>() {};

    public static final TypeToken<Value<WoodType>> WOOD_TYPE_VALUE_TOKEN = new TypeToken<Value<WoodType>>() {};

    // @formatter:on
    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private TypeTokens() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
