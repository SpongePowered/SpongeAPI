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
import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.AdvancementType;
import org.spongepowered.api.advancement.criteria.trigger.Trigger;
import org.spongepowered.api.adventure.ResolveOperation;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.entity.BlockEntityType;
import org.spongepowered.api.block.transaction.Operation;
import org.spongepowered.api.command.parameter.managed.ValueParameter;
import org.spongepowered.api.command.parameter.managed.clientcompletion.ClientCompletionType;
import org.spongepowered.api.command.parameter.managed.operator.Operator;
import org.spongepowered.api.command.registrar.CommandRegistrarType;
import org.spongepowered.api.command.registrar.tree.CommandCompletionProvider;
import org.spongepowered.api.command.registrar.tree.CommandTreeNodeType;
import org.spongepowered.api.command.selector.SelectorSortAlgorithm;
import org.spongepowered.api.command.selector.SelectorType;
import org.spongepowered.api.data.persistence.DataFormat;
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
import org.spongepowered.api.data.type.ItemTier;
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
import org.spongepowered.api.event.cause.entity.DismountType;
import org.spongepowered.api.event.cause.entity.MovementType;
import org.spongepowered.api.event.cause.entity.SpawnType;
import org.spongepowered.api.event.cause.entity.damage.DamageModifierType;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.item.FireworkShape;
import org.spongepowered.api.item.ItemRarity;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.inventory.ContainerType;
import org.spongepowered.api.item.inventory.equipment.EquipmentGroup;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.menu.ClickType;
import org.spongepowered.api.item.inventory.query.QueryType;
import org.spongepowered.api.item.potion.PotionType;
import org.spongepowered.api.item.recipe.RecipeType;
import org.spongepowered.api.map.color.MapColorType;
import org.spongepowered.api.map.color.MapShade;
import org.spongepowered.api.map.decoration.MapDecorationType;
import org.spongepowered.api.map.decoration.orientation.MapDecorationOrientation;
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
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.chunk.ChunkState;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.gamerule.GameRule;
import org.spongepowered.api.world.generation.structure.Structure;
import org.spongepowered.api.world.portal.PortalType;
import org.spongepowered.api.world.schematic.PaletteType;
import org.spongepowered.api.world.server.TicketType;
import org.spongepowered.api.world.teleport.TeleportHelperFilter;
import org.spongepowered.api.world.weather.WeatherType;

import java.util.Objects;

/**
 * All {@link RegistryKey registries} provided by this API.
 */
public final class RegistryTypes {

    // @formatter:off

    public static final DefaultedRegistryType<ArtType> ART_TYPE = RegistryTypes.minecraftKeyInGame("motive");

    public static final DefaultedRegistryType<AttributeType> ATTRIBUTE_TYPE = RegistryTypes.minecraftKeyInGame("attribute");

    public static final RegistryType<Biome> BIOME = RegistryTypes.minecraftKey("worldgen/biome");

    public static final DefaultedRegistryType<BlockType> BLOCK_TYPE = RegistryTypes.minecraftKeyInGame("block");

    public static final DefaultedRegistryType<BlockEntityType> BLOCK_ENTITY_TYPE = RegistryTypes.minecraftKeyInGame("block_entity_type");

    public static final DefaultedRegistryType<ChunkState> CHUNK_STATE = RegistryTypes.minecraftKeyInGame("chunk_status");

    public static final DefaultedRegistryType<ContainerType> CONTAINER_TYPE = RegistryTypes.minecraftKeyInGame("menu");

    public static final DefaultedRegistryType<WorldType> WORLD_TYPE = RegistryTypes.minecraftKeyInServer("dimension_type");

    public static final DefaultedRegistryType<PotionEffectType> POTION_EFFECT_TYPE = RegistryTypes.minecraftKeyInGame("mob_effect");

    public static final DefaultedRegistryType<EnchantmentType> ENCHANTMENT_TYPE = RegistryTypes.minecraftKeyInGame("enchantment");

    public static final DefaultedRegistryType<EntityType<?>> ENTITY_TYPE = RegistryTypes.minecraftKeyInGame("entity_type");

    public static final DefaultedRegistryType<FluidType> FLUID_TYPE = RegistryTypes.minecraftKeyInGame("fluid");

    public static final DefaultedRegistryType<ItemType> ITEM_TYPE = RegistryTypes.minecraftKeyInGame("item");

    public static final DefaultedRegistryType<ParticleType> PARTICLE_TYPE = RegistryTypes.minecraftKeyInGame("particle_type");

    public static final DefaultedRegistryType<RecipeType<?>> RECIPE_TYPE = RegistryTypes.minecraftKeyInGame("recipe_type");

    public static final DefaultedRegistryType<SoundType> SOUND_TYPE = RegistryTypes.minecraftKeyInGame("sound_event");

    public static final DefaultedRegistryType<Statistic> STATISTIC = RegistryTypes.minecraftKeyInGame("custom_stat");

    public static final DefaultedRegistryType<StatisticCategory> STATISTIC_CATEGORY = RegistryTypes.minecraftKeyInGame("statistic_category");

    public static final DefaultedRegistryType<Structure> STRUCTURE = RegistryTypes.minecraftKeyInGame("worldgen/structure_feature");

    public static final DefaultedRegistryType<VillagerType> VILLAGER_TYPE = RegistryTypes.minecraftKeyInGame("villager_type");

    public static final DefaultedRegistryType<ProfessionType> PROFESSION_TYPE = RegistryTypes.minecraftKeyInGame("villager_profession");

    public static final DefaultedRegistryType<PotionType> POTION_TYPE = RegistryTypes.minecraftKeyInGame("potion");

    // ----

    public static final DefaultedRegistryType<AccountDeletionResultType> ACCOUNT_DELETION_RESULT_TYPE = RegistryTypes.spongeKeyInGame("account_deletion_result_type");

    public static final DefaultedRegistryType<AdvancementType> ADVANCEMENT_TYPE = RegistryTypes.spongeKeyInGame("advancement_type");

    public static final DefaultedRegistryType<ArmorMaterial> ARMOR_MATERIAL = RegistryTypes.spongeKeyInGame("armor_material");

    public static final DefaultedRegistryType<AttachmentSurface> ATTACHMENT_SURFACE = RegistryTypes.spongeKeyInGame("attachment_surface");

    public static final DefaultedRegistryType<AttributeOperation> ATTRIBUTE_OPERATION = RegistryTypes.spongeKeyInGame("attribute_operation");

    public static final DefaultedRegistryType<BanType> BAN_TYPE = RegistryTypes.spongeKeyInGame("ban_type");

    public static final DefaultedRegistryType<BannerPatternShape> BANNER_PATTERN_SHAPE = RegistryTypes.spongeKeyInGame("banner_pattern_shape");

    public static final DefaultedRegistryType<BoatType> BOAT_TYPE = RegistryTypes.spongeKeyInGame("boat_type");

    public static final DefaultedRegistryType<BodyPart> BODY_PART = RegistryTypes.spongeKeyInGame("body_part");

    public static final DefaultedRegistryType<BooleanStateProperty> BOOLEAN_STATE_PROPERTY = RegistryTypes.spongeKeyInGame("boolean_state_property");

    public static final DefaultedRegistryType<CatType> CAT_TYPE = RegistryTypes.spongeKeyInGame("cat_type");

    public static final DefaultedRegistryType<ValueParameter<?>> REGISTRY_KEYED_VALUE_PARAMETER = RegistryTypes.spongeKeyInGame("value_parameter");

    public static final DefaultedRegistryType<ChatVisibility> CHAT_VISIBILITY = RegistryTypes.spongeKeyInGame("chat_visibility");

    public static final DefaultedRegistryType<ChestAttachmentType> CHEST_ATTACHMENT_TYPE = RegistryTypes.spongeKeyInGame("chest_attachment_type");

    public static final DefaultedRegistryType<ChunkRegenerateFlag> CHUNK_REGENERATE_FLAG = RegistryTypes.spongeKeyInGame("chunk_regenerate_flag");

    public static final DefaultedRegistryType<ClickType<?>> CLICK_TYPE = RegistryTypes.spongeKeyInGame("click_type");

    public static final DefaultedRegistryType<ClientCompletionType> CLIENT_COMPLETION_TYPE = RegistryTypes.spongeKeyInGame("client_completion_type");

    public static final DefaultedRegistryType<CollisionRule> COLLISION_RULE = RegistryTypes.spongeKeyInGame("collision_rule");

    public static final DefaultedRegistryType<CommandCompletionProvider> COMMAND_COMPLETION_PROVIDER = RegistryTypes.spongeKeyInGame("command_completion_provider");

    public static final DefaultedRegistryType<CommandRegistrarType<?>> COMMAND_REGISTRAR_TYPE = RegistryTypes.spongeKeyInGame("command_registrar_type");

    public static final DefaultedRegistryType<CommandTreeNodeType<?>> COMMAND_TREE_NODE_TYPE = RegistryTypes.spongeKeyInGame("command_tree_node_type");

    public static final DefaultedRegistryType<ComparatorMode> COMPARATOR_MODE = RegistryTypes.spongeKeyInGame("comparator_mode");

    public static final DefaultedRegistryType<Criterion> CRITERION = RegistryTypes.spongeKeyInGame("criterion");

    public static final DefaultedRegistryType<Currency> CURRENCY = RegistryTypes.spongeKeyInGame("currency");

    public static final DefaultedRegistryType<DamageModifierType> DAMAGE_MODIFIER_TYPE = RegistryTypes.spongeKeyInGame("damage_modifier_type");

    public static final DefaultedRegistryType<DamageType> DAMAGE_TYPE = RegistryTypes.spongeKeyInGame("damage_type");

    public static final DefaultedRegistryType<DataFormat> DATA_FORMAT = RegistryTypes.spongeKeyInGame("data_format");

    public static final DefaultedRegistryType<Difficulty> DIFFICULTY = RegistryTypes.spongeKeyInGame("difficulty");

    public static final DefaultedRegistryType<DismountType> DISMOUNT_TYPE = RegistryTypes.minecraftKeyInGame("dismount_type");

    public static final DefaultedRegistryType<DisplaySlot> DISPLAY_SLOT = RegistryTypes.spongeKeyInGame("display_slot");

    public static final DefaultedRegistryType<DoorHinge> DOOR_HINGE = RegistryTypes.spongeKeyInGame("door_hinge");

    public static final DefaultedRegistryType<DragonPhaseType> DRAGON_PHASE_TYPE = RegistryTypes.spongeKeyInGame("dragon_phase_type");

    public static final DefaultedRegistryType<DyeColor> DYE_COLOR = RegistryTypes.spongeKeyInGame("dye_color");

    public static final DefaultedRegistryType<EnumStateProperty<?>> ENUM_STATE_PROPERTY = RegistryTypes.spongeKeyInGame("enum_state_property");

    public static final DefaultedRegistryType<EquipmentGroup> EQUIPMENT_GROUP = RegistryTypes.spongeKeyInGame("equipment_group");

    public static final DefaultedRegistryType<EquipmentType> EQUIPMENT_TYPE = RegistryTypes.spongeKeyInGame("equipment_type");

    public static final DefaultedRegistryType<FireworkShape> FIREWORK_SHAPE = RegistryTypes.spongeKeyInGame("firework_shape");

    public static final DefaultedRegistryType<FoxType> FOX_TYPE = RegistryTypes.spongeKeyInGame("fox_type");

    public static final DefaultedRegistryType<GameMode> GAME_MODE = RegistryTypes.spongeKeyInGame("game_mode");

    public static final DefaultedRegistryType<GameRule<?>> GAME_RULE = RegistryTypes.spongeKeyInGame("game_rule");

    public static final DefaultedRegistryType<GoalExecutorType> GOAL_EXECUTOR_TYPE = RegistryTypes.spongeKeyInGame("goal_executor_type");

    public static final DefaultedRegistryType<GoalType> GOAL_TYPE = RegistryTypes.spongeKeyInGame("goal_type");

    public static final DefaultedRegistryType<HandPreference> HAND_PREFERENCE = RegistryTypes.spongeKeyInGame("hand_preference");

    public static final DefaultedRegistryType<HandType> HAND_TYPE = RegistryTypes.spongeKeyInGame("hand_type");

    public static final DefaultedRegistryType<HeightType> HEIGHT_TYPE = RegistryTypes.spongeKeyInGame("height_type");

    public static final DefaultedRegistryType<HorseColor> HORSE_COLOR = RegistryTypes.spongeKeyInGame("horse_color");

    public static final DefaultedRegistryType<HorseStyle> HORSE_STYLE = RegistryTypes.spongeKeyInGame("horse_style");

    public static final DefaultedRegistryType<InstrumentType> INSTRUMENT_TYPE = RegistryTypes.spongeKeyInGame("instrument_type");

    public static final DefaultedRegistryType<IntegerStateProperty> INTEGER_STATE_PROPERTY = RegistryTypes.spongeKeyInGame("integer_state_property");

    public static final DefaultedRegistryType<ItemRarity> ITEM_RARITY = RegistryTypes.spongeKeyInGame("item_rarity");

    public static final DefaultedRegistryType<ItemTier> ITEM_TIER = RegistryTypes.spongeKeyInGame("item_tier");

    public static final DefaultedRegistryType<LightType> LIGHT_TYPE = RegistryTypes.spongeKeyInGame("light_type");

    public static final DefaultedRegistryType<LlamaType> LLAMA_TYPE = RegistryTypes.spongeKeyInGame("llama_type");

    public static final DefaultedRegistryType<MatterType> MATTER_TYPE = RegistryTypes.spongeKeyInGame("matter_type");

    public static final DefaultedRegistryType<Mirror> MIRROR = RegistryTypes.spongeKeyInGame("mirror");

    public static final DefaultedRegistryType<MooshroomType> MOOSHROOM_TYPE = RegistryTypes.spongeKeyInGame("mooshroom_type");

    public static final DefaultedRegistryType<MovementType> MOVEMENT_TYPE = RegistryTypes.spongeKeyInGame("movement_type");

    public static final DefaultedRegistryType<MusicDisc> MUSIC_DISC = RegistryTypes.spongeKeyInGame("music_disc");

    public static final DefaultedRegistryType<NotePitch> NOTE_PITCH = RegistryTypes.spongeKeyInGame("note_pitch");

    public static final DefaultedRegistryType<ObjectiveDisplayMode> OBJECTIVE_DISPLAY_MODE = RegistryTypes.spongeKeyInGame("objective_display_mode");

    public static final DefaultedRegistryType<Operator> OPERATOR = RegistryTypes.spongeKeyInGame("operator");

    public static final DefaultedRegistryType<Operation> OPERATION = RegistryTypes.spongeKeyInGame("operation");

    public static final DefaultedRegistryType<Orientation> ORIENTATION = RegistryTypes.spongeKeyInGame("orientation");

    public static final DefaultedRegistryType<PaletteType<?, ?>> PALETTE_TYPE = RegistryTypes.spongeKeyInGame("palette_type");

    public static final DefaultedRegistryType<PandaGene> PANDA_GENE = RegistryTypes.spongeKeyInGame("panda_gene");

    public static final DefaultedRegistryType<ParrotType> PARROT_TYPE = RegistryTypes.spongeKeyInGame("parrot_type");

    public static final DefaultedRegistryType<ParticleOption<?>> PARTICLE_OPTION = RegistryTypes.spongeKeyInGame("particle_option");

    public static final DefaultedRegistryType<PhantomPhase> PHANTOM_PHASE = RegistryTypes.spongeKeyInGame("phantom_phase");

    public static final DefaultedRegistryType<PickupRule> PICKUP_RULE = RegistryTypes.spongeKeyInGame("pickup_rule");

    public static final DefaultedRegistryType<PistonType> PISTON_TYPE = RegistryTypes.spongeKeyInGame("piston_type");

    public static final DefaultedRegistryType<PlaceholderParser> PLACEHOLDER_PARSER = RegistryTypes.spongeKeyInGame("placeholder_parser");

    public static final DefaultedRegistryType<PortalType> PORTAL_TYPE = RegistryTypes.spongeKeyInGame("portal_type");

    public static final DefaultedRegistryType<PortionType> PORTION_TYPE = RegistryTypes.spongeKeyInGame("portion_type");

    public static final DefaultedRegistryType<QueryType> QUERY_TYPE = RegistryTypes.spongeKeyInGame("query_type");

    public static final DefaultedRegistryType<RabbitType> RABBIT_TYPE = RegistryTypes.spongeKeyInGame("rabbit_type");

    public static final DefaultedRegistryType<RaidStatus> RAID_STATUS = RegistryTypes.spongeKeyInGame("raid_status");

    public static final DefaultedRegistryType<RailDirection> RAIL_DIRECTION = RegistryTypes.spongeKeyInGame("rail_direction");

    public static final DefaultedRegistryType<ResolveOperation> RESOLVE_OPERATION = RegistryTypes.spongeKeyInGame("resolve_operation");

    public static final DefaultedRegistryType<Rotation> ROTATION = RegistryTypes.spongeKeyInGame("rotation");

    public static final DefaultedRegistryType<SelectorSortAlgorithm> SELECTOR_SORT_ALGORITHM = RegistryTypes.spongeKeyInGame("selector_sort_algorithm");

    public static final DefaultedRegistryType<SelectorType> SELECTOR_TYPE = RegistryTypes.spongeKeyInGame("selector_type");

    public static final DefaultedRegistryType<SkinPart> SKIN_PART = RegistryTypes.spongeKeyInGame("skin_part");

    public static final DefaultedRegistryType<SlabPortion> SLAB_PORTION = RegistryTypes.spongeKeyInGame("slab_portion");

    public static final DefaultedRegistryType<SpawnType> SPAWN_TYPE = RegistryTypes.spongeKeyInGame("spawn_type");

    public static final DefaultedRegistryType<SpellType> SPELL_TYPE = RegistryTypes.spongeKeyInGame("spell_type");

    public static final DefaultedRegistryType<StairShape> STAIR_SHAPE = RegistryTypes.spongeKeyInGame("stair_shape");

    public static final DefaultedRegistryType<StructureMode> STRUCTURE_MODE = RegistryTypes.spongeKeyInGame("structure_mode");

    public static final DefaultedRegistryType<TaskPriority> TASK_PRIORITY = RegistryTypes.spongeKeyInGame("task_priority");

    public static final DefaultedRegistryType<TeleportHelperFilter> TELEPORT_HELPER_FILTER = RegistryTypes.spongeKeyInGame("teleport_helper_filter");

    public static final DefaultedRegistryType<TicketType<?>> TICKET_TYPE = RegistryTypes.spongeKeyInGame("ticket_type");

    public static final DefaultedRegistryType<TransactionType> TRANSACTION_TYPE = RegistryTypes.spongeKeyInGame("transaction_type");

    public static final DefaultedRegistryType<Trigger<?>> TRIGGER = RegistryTypes.spongeKeyInGame("trigger");

    public static final DefaultedRegistryType<TropicalFishShape> TROPICAL_FISH_SHAPE = RegistryTypes.spongeKeyInGame("tropical_fish_shape");

    public static final DefaultedRegistryType<Visibility> VISIBILITY = RegistryTypes.spongeKeyInGame("visibility");

    public static final DefaultedRegistryType<WeatherType> WEATHER_TYPE = RegistryTypes.spongeKeyInGame("weather_type");

    public static final DefaultedRegistryType<WireAttachmentType> WIRE_ATTACHMENT_TYPE = RegistryTypes.spongeKeyInGame("wire_attachment_type");

    public static final DefaultedRegistryType<MapColorType> MAP_COLOR_TYPE = RegistryTypes.spongeKeyInGame("map_color_type");

    public static final DefaultedRegistryType<MapDecorationOrientation> MAP_DECORATION_ORIENTATION = RegistryTypes.spongeKeyInGame("map_decoration_orientation");

    public static final DefaultedRegistryType<MapDecorationType> MAP_DECORATION_TYPE = RegistryTypes.spongeKeyInGame("map_decoration_type");

    public static final DefaultedRegistryType<MapShade> MAP_SHADE = RegistryTypes.spongeKeyInGame("map_shade");

    // @formatter:on

    private static <V> RegistryType<V> minecraftKey(final String key) {
        return RegistryType.of(RegistryRoots.MINECRAFT, ResourceKey.minecraft(Objects.requireNonNull(key, "key")));
    }

    private static <V> DefaultedRegistryType<V> minecraftKeyInGame(final String key) {
        return RegistryType.of(RegistryRoots.MINECRAFT, ResourceKey.minecraft(Objects.requireNonNull(key, "key"))).asDefaultedType(() -> Sponge.game().registries());
    }

    private static <V> DefaultedRegistryType<V> minecraftKeyInServer(final String key) {
        return RegistryType.of(RegistryRoots.MINECRAFT, ResourceKey.minecraft(Objects.requireNonNull(key, "key"))).asDefaultedType(() -> Sponge.server().registries());
    }

    private static <V> DefaultedRegistryType<V> spongeKeyInGame(final String key) {
        return RegistryType.of(RegistryRoots.SPONGE, ResourceKey.sponge(Objects.requireNonNull(key, "key"))).asDefaultedType(() -> Sponge.game().registries());
    }
}