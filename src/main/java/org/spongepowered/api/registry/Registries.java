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
package org.spongepowered.api.registry;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.advancement.AdvancementType;
import org.spongepowered.api.advancement.criteria.trigger.Trigger;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.entity.BlockEntityType;
import org.spongepowered.api.block.transaction.Operation;
import org.spongepowered.api.command.parameter.managed.clientcompletion.ClientCompletionType;
import org.spongepowered.api.command.parameter.managed.standard.CatalogedValueParameter;
import org.spongepowered.api.command.registrar.tree.ClientCompletionKey;
import org.spongepowered.api.command.selector.SelectorType;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataFormat;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.data.type.ArmorMaterial;
import org.spongepowered.api.data.type.ArtType;
import org.spongepowered.api.data.type.AttachmentSurface;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.type.CatType;
import org.spongepowered.api.data.type.ChestAttachmentType;
import org.spongepowered.api.data.type.ComparatorMode;
import org.spongepowered.api.data.type.DoorHinge;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.FoxType;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.LlamaType;
import org.spongepowered.api.data.type.MatterType;
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
import org.spongepowered.api.data.type.RaidStatus;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.data.type.SlabPortion;
import org.spongepowered.api.data.type.SpellType;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.type.ToolType;
import org.spongepowered.api.data.type.TropicalFishShape;
import org.spongepowered.api.data.type.VillagerType;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.data.type.WoodType;
import org.spongepowered.api.effect.particle.ParticleOption;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.ai.goal.GoalExecutorType;
import org.spongepowered.api.entity.ai.goal.GoalType;
import org.spongepowered.api.entity.attribute.AttributeOperation;
import org.spongepowered.api.entity.attribute.type.AttributeType;
import org.spongepowered.api.entity.living.monster.boss.dragon.phase.DragonPhaseType;
import org.spongepowered.api.entity.living.player.chat.ChatVisibility;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.event.EventContextKey;
import org.spongepowered.api.event.cause.entity.DismountType;
import org.spongepowered.api.event.cause.entity.MovementType;
import org.spongepowered.api.event.cause.entity.SpawnType;
import org.spongepowered.api.event.cause.entity.damage.DamageModifierType;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.item.FireworkShape;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.inventory.ContainerType;
import org.spongepowered.api.item.inventory.equipment.EquipmentGroup;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.menu.ClickType;
import org.spongepowered.api.item.inventory.query.QueryType;
import org.spongepowered.api.item.potion.PotionType;
import org.spongepowered.api.item.recipe.RecipeType;
import org.spongepowered.api.placeholder.PlaceholderParser;
import org.spongepowered.api.scheduler.TaskPriority;
import org.spongepowered.api.scoreboard.CollisionRule;
import org.spongepowered.api.scoreboard.Visibility;
import org.spongepowered.api.scoreboard.criteria.Criterion;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayMode;
import org.spongepowered.api.service.ban.BanType;
import org.spongepowered.api.service.economy.account.AccountDeletionResultType;
import org.spongepowered.api.service.economy.transaction.TransactionType;
import org.spongepowered.api.state.BooleanStateProperty;
import org.spongepowered.api.state.EnumStateProperty;
import org.spongepowered.api.state.IntegerStateProperty;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.util.mirror.Mirror;
import org.spongepowered.api.util.orientation.Orientation;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.ChunkRegenerateFlag;
import org.spongepowered.api.world.HeightType;
import org.spongepowered.api.world.LightType;
import org.spongepowered.api.world.WorldArchetype;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.chunk.ChunkState;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.dimension.DimensionType;
import org.spongepowered.api.world.gamerule.GameRule;
import org.spongepowered.api.world.gen.GeneratorModifierType;
import org.spongepowered.api.world.portal.PortalType;
import org.spongepowered.api.world.schematic.PaletteType;
import org.spongepowered.api.world.teleport.TeleportHelperFilter;
import org.spongepowered.api.world.weather.Weather;

/**
 * All {@link RegistryKey registries} provided by this API.
 */
public final class Registries {

    // @formatter:off

    public static final RegistryKey<Registry<ArtType>> ART_TYPE = Registries.minecraftKey("motive");

    public static final RegistryKey<Registry<AttributeType>> ATTRIBUTE_TYPE = Registries.minecraftKey("attribute");

    public static final RegistryKey<Registry<BiomeType>> BIOME_TYPE = Registries.minecraftKey("worldgen/biome");

    public static final RegistryKey<Registry<BlockType>> BLOCK_TYPE = Registries.minecraftKey("block");

    public static final RegistryKey<Registry<BlockEntityType>> BLOCK_ENTITY_TYPE = Registries.minecraftKey("block_entity_type");

    public static final RegistryKey<Registry<ChunkState>> CHUNK_STATE = Registries.minecraftKey("chunk_status");

    public static final RegistryKey<Registry<ContainerType>> CONTAINER_TYPE = Registries.minecraftKey("menu");

    public static final RegistryKey<Registry<DimensionType>> DIMENSION_TYPE = Registries.minecraftKey("dimension_type");

    public static final RegistryKey<Registry<PotionEffectType>> POTION_EFFECT_TYPE = Registries.minecraftKey("mob_effect");

    public static final RegistryKey<Registry<EnchantmentType>> ENCHANTMENT_TYPE = Registries.minecraftKey("enchantment");

    public static final RegistryKey<Registry<EntityType<?>>> ENTITY_TYPE = Registries.minecraftKey("entity_type");

    public static final RegistryKey<Registry<FluidType>> FLUID_TYPE = Registries.minecraftKey("fluid");

    public static final RegistryKey<Registry<ItemType>> ITEM_TYPE = Registries.minecraftKey("item");

    public static final RegistryKey<Registry<ParticleType>> PARTICLE_TYPE = Registries.minecraftKey("particle_type");

    public static final RegistryKey<Registry<RecipeType<?>>> RECIPE_TYPE = Registries.minecraftKey("recipe_type");

    public static final RegistryKey<Registry<SoundType>> SOUND_TYPE = Registries.minecraftKey("sound_event");

    public static final RegistryKey<Registry<Statistic>> STATISTIC = Registries.minecraftKey("custom_stat");

    public static final RegistryKey<Registry<VillagerType>> VILLAGER_TYPE = Registries.minecraftKey("villager_type");

    // ----

    public static final RegistryKey<Registry<AccountDeletionResultType>> ACCOUNT_DELETION_RESULT_TYPE = Registries.spongeKey("account_deletion_result_type");

    public static final RegistryKey<Registry<AdvancementType>> ADVANCEMENT_TYPE = Registries.spongeKey("advancement_type");

    public static final RegistryKey<Registry<ArmorMaterial>> ARMOR_MATERIAL = Registries.spongeKey("armor_material");

    public static final RegistryKey<Registry<AttachmentSurface>> ATTACHMENT_SURFACE = Registries.spongeKey("attachment_surface");

    public static final RegistryKey<Registry<AttributeOperation>> ATTRIBUTE_OPERATION = Registries.spongeKey("attribute_operation");

    public static final RegistryKey<Registry<BanType>> BAN_TYPE = Registries.spongeKey("ban_type");

    public static final RegistryKey<Registry<BannerPatternShape>> BANNER_PATTERN_SHAPE = Registries.spongeKey("banner_pattern_shape");

    public static final RegistryKey<Registry<BodyPart>> BODY_PART = Registries.spongeKey("body_part");

    public static final RegistryKey<Registry<BooleanStateProperty>> BOOLEAN_STATE_PROPERTY = Registries.spongeKey("boolean_state_property");

    public static final RegistryKey<Registry<CatType>> CAT_TYPE = Registries.spongeKey("cat_type");

    public static final RegistryKey<Registry<CatalogedValueParameter<?>>> CATALOGED_VALUE_PARAMETER = Registries.spongeKey("cataloged_value_parameter");

    public static final RegistryKey<Registry<ChatVisibility>> CHAT_VISIBILITY = Registries.spongeKey("chat_visibility");

    public static final RegistryKey<Registry<ChestAttachmentType>> CHEST_ATTACHMENT_TYPE = Registries.spongeKey("chest_attachment_type");

    public static final RegistryKey<Registry<ChunkRegenerateFlag>> CHUNK_REGENERATE_FLAG = Registries.spongeKey("chunk_regenerate_flag");

    public static final RegistryKey<Registry<ClickType<?>>> CLICK_TYPE = Registries.spongeKey("click_type");

    public static final RegistryKey<Registry<ClientCompletionKey<?>>> CLIENT_COMPLETION_KEY = Registries.spongeKey("client_completion_key");

    public static final RegistryKey<Registry<ClientCompletionType>> CLIENT_COMPLETION_TYPE = Registries.spongeKey("client_completion_type");

    public static final RegistryKey<Registry<CollisionRule>> COLLISION_RULE = Registries.spongeKey("collision_rule");

    public static final RegistryKey<Registry<ComparatorMode>> COMPARATOR_MODE = Registries.spongeKey("comparator_mode");

    public static final RegistryKey<Registry<Criterion>> CRITERION = Registries.spongeKey("criterion");

    public static final RegistryKey<Registry<DamageModifierType>> DAMAGE_MODIFIER_TYPE = Registries.spongeKey("damage_modifier_type");

    public static final RegistryKey<Registry<DamageType>> DAMAGE_TYPE = Registries.spongeKey("damage_type");

    public static final RegistryKey<Registry<DataFormat>> DATA_FORMAT = Registries.spongeKey("data_format");

    public static final RegistryKey<Registry<DataTranslator<?>>> DATA_TRANSLATOR = Registries.spongeKey("data_translator");

    public static final RegistryKey<Registry<Difficulty>> DIFFICULTY = Registries.spongeKey("difficulty");

    public static final RegistryKey<Registry<DismountType>> DISMOUNT_TYPE = Registries.minecraftKey("dismount_type");

    public static final RegistryKey<Registry<DisplaySlot>> DISPLAY_SLOT = Registries.spongeKey("display_slot");

    public static final RegistryKey<Registry<DoorHinge>> DOOR_HINGE = Registries.spongeKey("door_hinge");

    public static final RegistryKey<Registry<DragonPhaseType>> DRAGON_PHASE_TYPE = Registries.spongeKey("dragon_phase_type");

    public static final RegistryKey<Registry<DyeColor>> DYE_COLOR = Registries.spongeKey("dye_color");

    public static final RegistryKey<Registry<EnumStateProperty<?>>> ENUM_STATE_PROPERTY = Registries.spongeKey("enum_state_property");

    public static final RegistryKey<Registry<EquipmentGroup>> EQUIPMENT_GROUP = Registries.spongeKey("equipment_group");

    public static final RegistryKey<Registry<EquipmentType>> EQUIPMENT_TYPE = Registries.spongeKey("equipment_type");

    public static final RegistryKey<Registry<EventContextKey<?>>> EVENT_CONTEXT_KEY = Registries.spongeKey("event_context_key");

    public static final RegistryKey<Registry<FireworkShape>> FIREWORK_SHAPE = Registries.spongeKey("firework_shape");

    public static final RegistryKey<Registry<FoxType>> FOX_TYPE = Registries.spongeKey("fox_type");

    public static final RegistryKey<Registry<GameMode>> GAME_MODE = Registries.spongeKey("game_mode");

    public static final RegistryKey<Registry<GameRule<?>>> GAME_RULE = Registries.spongeKey("game_rule");

    public static final RegistryKey<Registry<GeneratorModifierType>> GENERATOR_MODIFIER_TYPE = Registries.spongeKey("generator_modifier_type");

    public static final RegistryKey<Registry<GoalExecutorType>> GOAL_EXECUTOR_TYPE = Registries.spongeKey("goal_executor_type");

    public static final RegistryKey<Registry<GoalType>> GOAL_TYPE = Registries.spongeKey("goal_type");

    public static final RegistryKey<Registry<HandPreference>> HAND_PREFERENCE = Registries.spongeKey("hand_preference");

    public static final RegistryKey<Registry<HandType>> HAND_TYPE = Registries.spongeKey("hand_type");

    public static final RegistryKey<Registry<HeightType>> HEIGHT_TYPE = Registries.spongeKey("height_type");

    public static final RegistryKey<Registry<HorseColor>> HORSE_COLOR = Registries.spongeKey("horse_color");

    public static final RegistryKey<Registry<HorseStyle>> HORSE_STYLE = Registries.spongeKey("horse_style");

    public static final RegistryKey<Registry<InstrumentType>> INSTRUMENT_TYPE = Registries.spongeKey("instrument_type");

    public static final RegistryKey<Registry<IntegerStateProperty>> INTEGER_STATE_PROPERTY = Registries.spongeKey("integer_state_property");

    public static final RegistryKey<Registry<Key<?>>> KEY = Registries.spongeKey("key");

    public static final RegistryKey<Registry<LightType>> LIGHT_TYPE = Registries.spongeKey("light_type");

    public static final RegistryKey<Registry<LlamaType>> LLAMA_TYPE = Registries.spongeKey("llama_type");

    public static final RegistryKey<Registry<MatterType>> MATTER_TYPE = Registries.spongeKey("matter_type");

    public static final RegistryKey<Registry<Mirror>> MIRROR = Registries.spongeKey("mirror");

    public static final RegistryKey<Registry<MooshroomType>> MOOSHROOM_TYPE = Registries.spongeKey("mooshroom_type");

    public static final RegistryKey<Registry<MovementType>> MOVEMENT_TYPE = Registries.spongeKey("movement_type");

    public static final RegistryKey<Registry<MusicDisc>> MUSIC_DISC = Registries.spongeKey("music_disc");

    public static final RegistryKey<Registry<NotePitch>> NOTE_PITCH = Registries.spongeKey("note_pitch");

    public static final RegistryKey<Registry<ObjectiveDisplayMode>> OBJECTIVE_DISPLAY_MODE = Registries.spongeKey("objective_display_mode");

    public static final RegistryKey<Registry<Operation>> OPERATION = Registries.spongeKey("operation");

    public static final RegistryKey<Registry<Orientation>> ORIENTATION = Registries.spongeKey("orientation");

    public static final RegistryKey<Registry<PaletteType<?>>> PALETTE_TYPE = Registries.spongeKey("palette_type");

    public static final RegistryKey<Registry<PandaGene>> PANDA_GENE = Registries.spongeKey("panda_gene");

    public static final RegistryKey<Registry<ParrotType>> PARROT_TYPE = Registries.spongeKey("parrot_type");

    public static final RegistryKey<Registry<ParticleOption<?>>> PARTICLE_OPTION = Registries.spongeKey("particle_option");

    public static final RegistryKey<Registry<PhantomPhase>> PHANTOM_PHASE = Registries.spongeKey("phantom_phase");

    public static final RegistryKey<Registry<PickupRule>> PICKUP_RULE = Registries.spongeKey("pickup_rule");

    public static final RegistryKey<Registry<PistonType>> PISTON_TYPE = Registries.spongeKey("piston_type");

    public static final RegistryKey<Registry<PlaceholderParser>> PLACEHOLDER_PARSER = Registries.spongeKey("placeholder_parser");

    public static final RegistryKey<Registry<PortalType>> PORTAL_TYPE = Registries.spongeKey("portal_type");

    public static final RegistryKey<Registry<PortionType>> PORTION_TYPE = Registries.spongeKey("portion_type");

    public static final RegistryKey<Registry<PotionType>> POTION_TYPE = Registries.spongeKey("potion_type");

    public static final RegistryKey<Registry<ProfessionType>> PROFESSION_TYPE = Registries.spongeKey("profession_type");

    public static final RegistryKey<Registry<RabbitType>> RABBIT_TYPE = Registries.spongeKey("rabbit_type");

    public static final RegistryKey<Registry<RaidStatus>> RAID_STATUS = Registries.spongeKey("raid_status");

    public static final RegistryKey<Registry<RailDirection>> RAIL_DIRECTION = Registries.spongeKey("rail_direction");

    public static final RegistryKey<Registry<Rotation>> ROTATION = Registries.spongeKey("rotation");

    public static final RegistryKey<Registry<SelectorType>> SELECTOR_TYPE = Registries.spongeKey("selector_type");

    public static final RegistryKey<Registry<SkinPart>> SKIN_PART = Registries.spongeKey("skin_part");

    public static final RegistryKey<Registry<SlabPortion>> SLAB_PORTION = Registries.spongeKey("slab_portion");

    public static final RegistryKey<Registry<SpawnType>> SPAWN_TYPE = Registries.spongeKey("spawn_type");

    public static final RegistryKey<Registry<SpellType>> SPELL_TYPE = Registries.spongeKey("spell_type");

    public static final RegistryKey<Registry<StairShape>> STAIR_SHAPE = Registries.spongeKey("stair_shape");

    public static final RegistryKey<Registry<StructureMode>> STRUCTURE_MODE = Registries.spongeKey("structure_mode");

    public static final RegistryKey<Registry<TaskPriority>> TASK_PRIORITY = Registries.spongeKey("task_priority");

    public static final RegistryKey<Registry<TeleportHelperFilter>> TELEPORT_HELPER_FILTER = Registries.spongeKey("teleport_helper_filter");

    public static final RegistryKey<Registry<ToolType>> TOOL_TYPE = Registries.spongeKey("tool_type");

    public static final RegistryKey<Registry<TransactionType>> TRANSACTION_TYPE = Registries.spongeKey("transaction_type");

    public static final RegistryKey<Registry<Trigger<?>>> TRIGGER = Registries.spongeKey("trigger");

    public static final RegistryKey<Registry<TropicalFishShape>> TROPICAL_FISH_SHAPE = Registries.spongeKey("tropical_fish_shape");

    public static final RegistryKey<Registry<QueryType>> QUERY_TYPE = Registries.spongeKey("query_type");

    public static final RegistryKey<Registry<Visibility>> VISIBILITY = Registries.spongeKey("visibility");

    public static final RegistryKey<Registry<Weather>> WEATHER = Registries.spongeKey("weather");

    public static final RegistryKey<Registry<WireAttachmentType>> WIRE_ATTACHMENT_TYPE = Registries.spongeKey("wire_attachment_type");

    public static final RegistryKey<Registry<WoodType>> WOOD_TYPE = Registries.spongeKey("wood_type");

    public static final RegistryKey<Registry<WorldArchetype>> WORLD_ARCHETYPE = Registries.spongeKey("world_archetype");

    // @formatter:on

    private static <V> RegistryKey<V> minecraftKey(final String key) {
        return RegistryKey.of(RegistryRoots.MINECRAFT, ResourceKey.minecraft(key));
    }

    private static <V> RegistryKey<V> spongeKey(final String key) {
        return RegistryKey.of(RegistryRoots.SPONGE, ResourceKey.sponge(key));
    }
}
