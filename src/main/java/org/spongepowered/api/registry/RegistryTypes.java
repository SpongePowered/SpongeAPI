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
import org.spongepowered.api.command.selector.SelectorSortAlgorithm;
import org.spongepowered.api.command.selector.SelectorType;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.persistence.DataFormat;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.data.type.ArmorMaterial;
import org.spongepowered.api.data.type.ArtType;
import org.spongepowered.api.data.type.AttachmentSurface;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.BoatType;
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
import org.spongepowered.api.data.type.ItemTier;
import org.spongepowered.api.data.type.TropicalFishShape;
import org.spongepowered.api.data.type.VillagerType;
import org.spongepowered.api.data.type.WireAttachmentType;
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
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.account.AccountDeletionResultType;
import org.spongepowered.api.service.economy.transaction.TransactionType;
import org.spongepowered.api.state.BooleanStateProperty;
import org.spongepowered.api.state.EnumStateProperty;
import org.spongepowered.api.state.IntegerStateProperty;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.StatisticCategory;
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
import org.spongepowered.api.world.portal.PortalType;
import org.spongepowered.api.world.schematic.PaletteType;
import org.spongepowered.api.world.teleport.TeleportHelperFilter;
import org.spongepowered.api.world.weather.Weather;

/**
 * All {@link RegistryKey registries} provided by this API.
 */
public final class RegistryTypes {

    // @formatter:off

    public static final RegistryType<ArtType> ART_TYPE = RegistryTypes.minecraftKey("motive");

    public static final RegistryType<AttributeType> ATTRIBUTE_TYPE = RegistryTypes.minecraftKey("attribute");

    public static final RegistryType<BiomeType> BIOME_TYPE = RegistryTypes.minecraftKey("worldgen/biome");

    public static final RegistryType<BlockType> BLOCK_TYPE = RegistryTypes.minecraftKey("block");

    public static final RegistryType<BlockEntityType> BLOCK_ENTITY_TYPE = RegistryTypes.minecraftKey("block_entity_type");

    public static final RegistryType<ChunkState> CHUNK_STATE = RegistryTypes.minecraftKey("chunk_status");

    public static final RegistryType<ContainerType> CONTAINER_TYPE = RegistryTypes.minecraftKey("menu");

    public static final RegistryType<DimensionType> DIMENSION_TYPE = RegistryTypes.minecraftKey("dimension_type");

    public static final RegistryType<PotionEffectType> POTION_EFFECT_TYPE = RegistryTypes.minecraftKey("mob_effect");

    public static final RegistryType<EnchantmentType> ENCHANTMENT_TYPE = RegistryTypes.minecraftKey("enchantment");

    public static final RegistryType<EntityType<?>> ENTITY_TYPE = RegistryTypes.minecraftKey("entity_type");

    public static final RegistryType<FluidType> FLUID_TYPE = RegistryTypes.minecraftKey("fluid");

    public static final RegistryType<ItemType> ITEM_TYPE = RegistryTypes.minecraftKey("item");

    public static final RegistryType<ParticleType> PARTICLE_TYPE = RegistryTypes.minecraftKey("particle_type");

    public static final RegistryType<RecipeType<?>> RECIPE_TYPE = RegistryTypes.minecraftKey("recipe_type");

    public static final RegistryType<SoundType> SOUND_TYPE = RegistryTypes.minecraftKey("sound_event");

    public static final RegistryType<Statistic> STATISTIC = RegistryTypes.minecraftKey("custom_stat");

    public static final RegistryType<StatisticCategory> STATISTIC_CATEGORY = RegistryTypes.minecraftKey("statistic_category");

    public static final RegistryType<VillagerType> VILLAGER_TYPE = RegistryTypes.minecraftKey("villager_type");

    // ----

    public static final RegistryType<AccountDeletionResultType> ACCOUNT_DELETION_RESULT_TYPE = RegistryTypes.spongeKey("account_deletion_result_type");

    public static final RegistryType<AdvancementType> ADVANCEMENT_TYPE = RegistryTypes.spongeKey("advancement_type");

    public static final RegistryType<ArmorMaterial> ARMOR_MATERIAL = RegistryTypes.spongeKey("armor_material");

    public static final RegistryType<AttachmentSurface> ATTACHMENT_SURFACE = RegistryTypes.spongeKey("attachment_surface");

    public static final RegistryType<AttributeOperation> ATTRIBUTE_OPERATION = RegistryTypes.spongeKey("attribute_operation");

    public static final RegistryType<BanType> BAN_TYPE = RegistryTypes.spongeKey("ban_type");

    public static final RegistryType<BannerPatternShape> BANNER_PATTERN_SHAPE = RegistryTypes.spongeKey("banner_pattern_shape");

    public static final RegistryType<BoatType> BOAT_TYPE = RegistryTypes.spongeKey("boat_type");

    public static final RegistryType<BodyPart> BODY_PART = RegistryTypes.spongeKey("body_part");

    public static final RegistryType<BooleanStateProperty> BOOLEAN_STATE_PROPERTY = RegistryTypes.spongeKey("boolean_state_property");

    public static final RegistryType<CatType> CAT_TYPE = RegistryTypes.spongeKey("cat_type");

    public static final RegistryType<CatalogedValueParameter<?>> CATALOGED_VALUE_PARAMETER = RegistryTypes.spongeKey("cataloged_value_parameter");

    public static final RegistryType<ChatVisibility> CHAT_VISIBILITY = RegistryTypes.spongeKey("chat_visibility");

    public static final RegistryType<ChestAttachmentType> CHEST_ATTACHMENT_TYPE = RegistryTypes.spongeKey("chest_attachment_type");

    public static final RegistryType<ChunkRegenerateFlag> CHUNK_REGENERATE_FLAG = RegistryTypes.spongeKey("chunk_regenerate_flag");

    public static final RegistryType<ClickType<?>> CLICK_TYPE = RegistryTypes.spongeKey("click_type");

    public static final RegistryType<ClientCompletionKey<?>> CLIENT_COMPLETION_KEY = RegistryTypes.spongeKey("client_completion_key");

    public static final RegistryType<ClientCompletionType> CLIENT_COMPLETION_TYPE = RegistryTypes.spongeKey("client_completion_type");

    public static final RegistryType<CollisionRule> COLLISION_RULE = RegistryTypes.spongeKey("collision_rule");

    public static final RegistryType<ComparatorMode> COMPARATOR_MODE = RegistryTypes.spongeKey("comparator_mode");

    public static final RegistryType<Criterion> CRITERION = RegistryTypes.spongeKey("criterion");

    public static final RegistryType<Currency> CURRENCY = RegistryTypes.spongeKey("currency");

    public static final RegistryType<DamageModifierType> DAMAGE_MODIFIER_TYPE = RegistryTypes.spongeKey("damage_modifier_type");

    public static final RegistryType<DamageType> DAMAGE_TYPE = RegistryTypes.spongeKey("damage_type");

    public static final RegistryType<DataFormat> DATA_FORMAT = RegistryTypes.spongeKey("data_format");

    public static final RegistryType<DataTranslator<?>> DATA_TRANSLATOR = RegistryTypes.spongeKey("data_translator");

    public static final RegistryType<Difficulty> DIFFICULTY = RegistryTypes.spongeKey("difficulty");

    public static final RegistryType<DismountType> DISMOUNT_TYPE = RegistryTypes.minecraftKey("dismount_type");

    public static final RegistryType<DisplaySlot> DISPLAY_SLOT = RegistryTypes.spongeKey("display_slot");

    public static final RegistryType<DoorHinge> DOOR_HINGE = RegistryTypes.spongeKey("door_hinge");

    public static final RegistryType<DragonPhaseType> DRAGON_PHASE_TYPE = RegistryTypes.spongeKey("dragon_phase_type");

    public static final RegistryType<DyeColor> DYE_COLOR = RegistryTypes.spongeKey("dye_color");

    public static final RegistryType<EnumStateProperty<?>> ENUM_STATE_PROPERTY = RegistryTypes.spongeKey("enum_state_property");

    public static final RegistryType<EquipmentGroup> EQUIPMENT_GROUP = RegistryTypes.spongeKey("equipment_group");

    public static final RegistryType<EquipmentType> EQUIPMENT_TYPE = RegistryTypes.spongeKey("equipment_type");

    public static final RegistryType<EventContextKey<?>> EVENT_CONTEXT_KEY = RegistryTypes.spongeKey("event_context_key");

    public static final RegistryType<FireworkShape> FIREWORK_SHAPE = RegistryTypes.spongeKey("firework_shape");

    public static final RegistryType<FoxType> FOX_TYPE = RegistryTypes.spongeKey("fox_type");

    public static final RegistryType<GameMode> GAME_MODE = RegistryTypes.spongeKey("game_mode");

    public static final RegistryType<GameRule<?>> GAME_RULE = RegistryTypes.spongeKey("game_rule");

    public static final RegistryType<GoalExecutorType> GOAL_EXECUTOR_TYPE = RegistryTypes.spongeKey("goal_executor_type");

    public static final RegistryType<GoalType> GOAL_TYPE = RegistryTypes.spongeKey("goal_type");

    public static final RegistryType<HandPreference> HAND_PREFERENCE = RegistryTypes.spongeKey("hand_preference");

    public static final RegistryType<HandType> HAND_TYPE = RegistryTypes.spongeKey("hand_type");

    public static final RegistryType<HeightType> HEIGHT_TYPE = RegistryTypes.spongeKey("height_type");

    public static final RegistryType<HorseColor> HORSE_COLOR = RegistryTypes.spongeKey("horse_color");

    public static final RegistryType<HorseStyle> HORSE_STYLE = RegistryTypes.spongeKey("horse_style");

    public static final RegistryType<InstrumentType> INSTRUMENT_TYPE = RegistryTypes.spongeKey("instrument_type");

    public static final RegistryType<IntegerStateProperty> INTEGER_STATE_PROPERTY = RegistryTypes.spongeKey("integer_state_property");

    public static final RegistryType<ItemTier> ITEM_TIER = RegistryTypes.spongeKey("item_tier");

    public static final RegistryType<Key<?>> KEY = RegistryTypes.spongeKey("key");

    public static final RegistryType<LightType> LIGHT_TYPE = RegistryTypes.spongeKey("light_type");

    public static final RegistryType<LlamaType> LLAMA_TYPE = RegistryTypes.spongeKey("llama_type");

    public static final RegistryType<MatterType> MATTER_TYPE = RegistryTypes.spongeKey("matter_type");

    public static final RegistryType<Mirror> MIRROR = RegistryTypes.spongeKey("mirror");

    public static final RegistryType<MooshroomType> MOOSHROOM_TYPE = RegistryTypes.spongeKey("mooshroom_type");

    public static final RegistryType<MovementType> MOVEMENT_TYPE = RegistryTypes.spongeKey("movement_type");

    public static final RegistryType<MusicDisc> MUSIC_DISC = RegistryTypes.spongeKey("music_disc");

    public static final RegistryType<NotePitch> NOTE_PITCH = RegistryTypes.spongeKey("note_pitch");

    public static final RegistryType<ObjectiveDisplayMode> OBJECTIVE_DISPLAY_MODE = RegistryTypes.spongeKey("objective_display_mode");

    public static final RegistryType<Operation> OPERATION = RegistryTypes.spongeKey("operation");

    public static final RegistryType<Orientation> ORIENTATION = RegistryTypes.spongeKey("orientation");

    public static final RegistryType<PaletteType<?>> PALETTE_TYPE = RegistryTypes.spongeKey("palette_type");

    public static final RegistryType<PandaGene> PANDA_GENE = RegistryTypes.spongeKey("panda_gene");

    public static final RegistryType<ParrotType> PARROT_TYPE = RegistryTypes.spongeKey("parrot_type");

    public static final RegistryType<ParticleOption<?>> PARTICLE_OPTION = RegistryTypes.spongeKey("particle_option");

    public static final RegistryType<PhantomPhase> PHANTOM_PHASE = RegistryTypes.spongeKey("phantom_phase");

    public static final RegistryType<PickupRule> PICKUP_RULE = RegistryTypes.spongeKey("pickup_rule");

    public static final RegistryType<PistonType> PISTON_TYPE = RegistryTypes.spongeKey("piston_type");

    public static final RegistryType<PlaceholderParser> PLACEHOLDER_PARSER = RegistryTypes.spongeKey("placeholder_parser");

    public static final RegistryType<PortalType> PORTAL_TYPE = RegistryTypes.spongeKey("portal_type");

    public static final RegistryType<PortionType> PORTION_TYPE = RegistryTypes.spongeKey("portion_type");

    public static final RegistryType<PotionType> POTION_TYPE = RegistryTypes.spongeKey("potion_type");

    public static final RegistryType<ProfessionType> PROFESSION_TYPE = RegistryTypes.spongeKey("profession_type");

    public static final RegistryType<RabbitType> RABBIT_TYPE = RegistryTypes.spongeKey("rabbit_type");

    public static final RegistryType<RaidStatus> RAID_STATUS = RegistryTypes.spongeKey("raid_status");

    public static final RegistryType<RailDirection> RAIL_DIRECTION = RegistryTypes.spongeKey("rail_direction");

    public static final RegistryType<Rotation> ROTATION = RegistryTypes.spongeKey("rotation");

    public static final RegistryType<SelectorSortAlgorithm> SELECTOR_SORT_ALGORITHM = RegistryTypes.spongeKey("selector_sort_algorithm");

    public static final RegistryType<SelectorType> SELECTOR_TYPE = RegistryTypes.spongeKey("selector_type");

    public static final RegistryType<SkinPart> SKIN_PART = RegistryTypes.spongeKey("skin_part");

    public static final RegistryType<SlabPortion> SLAB_PORTION = RegistryTypes.spongeKey("slab_portion");

    public static final RegistryType<SpawnType> SPAWN_TYPE = RegistryTypes.spongeKey("spawn_type");

    public static final RegistryType<SpellType> SPELL_TYPE = RegistryTypes.spongeKey("spell_type");

    public static final RegistryType<StairShape> STAIR_SHAPE = RegistryTypes.spongeKey("stair_shape");

    public static final RegistryType<StructureMode> STRUCTURE_MODE = RegistryTypes.spongeKey("structure_mode");

    public static final RegistryType<TaskPriority> TASK_PRIORITY = RegistryTypes.spongeKey("task_priority");

    public static final RegistryType<TeleportHelperFilter> TELEPORT_HELPER_FILTER = RegistryTypes.spongeKey("teleport_helper_filter");

    public static final RegistryType<TransactionType> TRANSACTION_TYPE = RegistryTypes.spongeKey("transaction_type");

    public static final RegistryType<Trigger<?>> TRIGGER = RegistryTypes.spongeKey("trigger");

    public static final RegistryType<TropicalFishShape> TROPICAL_FISH_SHAPE = RegistryTypes.spongeKey("tropical_fish_shape");

    public static final RegistryType<QueryType> QUERY_TYPE = RegistryTypes.spongeKey("query_type");

    public static final RegistryType<Visibility> VISIBILITY = RegistryTypes.spongeKey("visibility");

    public static final RegistryType<Weather> WEATHER = RegistryTypes.spongeKey("weather");

    public static final RegistryType<WireAttachmentType> WIRE_ATTACHMENT_TYPE = RegistryTypes.spongeKey("wire_attachment_type");

    public static final RegistryType<WorldArchetype> WORLD_ARCHETYPE = RegistryTypes.spongeKey("world_archetype");

    // @formatter:on

    private static <V> RegistryType<V> minecraftKey(final String key) {
        return RegistryType.of(RegistryRoots.MINECRAFT, ResourceKey.minecraft(key));
    }

    private static <V> RegistryType<V> spongeKey(final String key) {
        return RegistryType.of(RegistryRoots.SPONGE, ResourceKey.sponge(key));
    }
}
