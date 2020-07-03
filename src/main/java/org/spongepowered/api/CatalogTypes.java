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
package org.spongepowered.api;

import org.spongepowered.api.advancement.Advancement;
import org.spongepowered.api.advancement.AdvancementTree;
import org.spongepowered.api.advancement.AdvancementType;
import org.spongepowered.api.advancement.criteria.trigger.Trigger;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.entity.BlockEntityType;
import org.spongepowered.api.boss.BossBarColor;
import org.spongepowered.api.boss.BossBarOverlay;
import org.spongepowered.api.data.persistence.DataFormat;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.data.type.*;
import org.spongepowered.api.effect.particle.ParticleOption;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.sound.SoundCategory;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.effect.sound.music.MusicDisc;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.ai.goal.GoalExecutorType;
import org.spongepowered.api.entity.ai.goal.GoalType;
import org.spongepowered.api.entity.attribute.AttributeOperation;
import org.spongepowered.api.entity.attribute.ModifierTemplate;
import org.spongepowered.api.entity.attribute.type.AttributeType;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.event.cause.EventContextKey;
import org.spongepowered.api.event.cause.entity.damage.DamageModifierType;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.dismount.DismountType;
import org.spongepowered.api.event.cause.entity.spawn.SpawnType;
import org.spongepowered.api.event.cause.entity.teleport.TeleportType;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.item.FireworkShape;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.inventory.ContainerType;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.item.inventory.equipment.HeldEquipmentType;
import org.spongepowered.api.item.inventory.equipment.WornEquipmentType;
import org.spongepowered.api.item.inventory.query.QueryType;
import org.spongepowered.api.item.recipe.crafting.CraftingRecipe;
import org.spongepowered.api.registry.CatalogRegistry;
import org.spongepowered.api.registry.GameRegistry;
import org.spongepowered.api.scoreboard.CollisionRule;
import org.spongepowered.api.scoreboard.Visibility;
import org.spongepowered.api.scoreboard.criteria.Criterion;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayMode;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.transaction.TransactionType;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.StatisticCategory;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.chat.ChatVisibility;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.selector.SelectorType;
import org.spongepowered.api.text.serializer.TextSerializer;
import org.spongepowered.api.util.ban.BanType;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.dimension.DimensionType;
import org.spongepowered.api.world.gen.GeneratorType;
import org.spongepowered.api.world.teleport.PortalAgentType;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.WorldArchetype;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.biome.VirtualBiomeType;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.teleport.TeleportHelperFilter;
import org.spongepowered.api.world.weather.Weather;

/**
 * Enumeration of all known {@link CatalogType}s for autocompletion when using
 * the {@link GameRegistry} to retrieve specific types or all of a certain type.
 *
 * <p>These are generally useful for {@link CatalogRegistry#get(Class, CatalogKey)}
 * and {@link CatalogRegistry#getAllOf(Class)}.</p>
 */
@SuppressWarnings({"rawtypes", "unused"})
public final class CatalogTypes {

    // SORTFIELDS:ON

    public static final Class<Advancement> ADVANCEMENT = Advancement.class;

    public static final Class<AdvancementTree> ADVANCEMENT_TREE = AdvancementTree.class;

    public static final Class<AdvancementType> ADVANCEMENT_TYPE = AdvancementType.class;

    public static final Class<ArtType> ART_TYPE = ArtType.class;

    public static final Class<AttributeOperation> ATTRIBUTE_OPERATION = AttributeOperation.class;

    public static final Class<AttributeType> ATTRIBUTE_TYPE = AttributeType.class;

    public static final Class<BannerPatternShape> BANNER_PATTERN_SHAPE = BannerPatternShape.class;

    public static final Class<BanType> BAN_TYPE = BanType.class;

    public static final Class<BiomeType> BIOME_TYPE = BiomeType.class;

    public static final Class<BlockEntityType> BLOCK_ENTITY_TYPE = BlockEntityType.class;

    public static final Class<BlockType> BLOCK_TYPE = BlockType.class;

    public static final Class<BodyPart> BODY_PART = BodyPart.class;

    public static final Class<BossBarColor> BOSS_BAR_COLOR = BossBarColor.class;

    public static final Class<BossBarOverlay> BOSS_BAR_OVERLAY = BossBarOverlay.class;

    public static final Class<CatType> CAT_TYPE = CatType.class;

    public static final Class<ChatType> CHAT_TYPE = ChatType.class;

    public static final Class<ChatVisibility> CHAT_VISIBILITY = ChatVisibility.class;

    public static final Class<CollisionRule> COLLISION_RULE = CollisionRule.class;

    public static final Class<ComparatorMode> COMPARISON_MODE = ComparatorMode.class;

    public static final Class<ContainerType> CONTAINER_TYPE = ContainerType.class;

    public static final Class<CraftingRecipe> CRAFTING_RECIPES = CraftingRecipe.class;

    public static final Class<Criterion> CRITERION = Criterion.class;

    public static final Class<Currency> CURRENCY = Currency.class;

    public static final Class<DamageModifierType> DAMAGE_MODIFIER_TYPE = DamageModifierType.class;

    public static final Class<DamageType> DAMAGE_TYPE = DamageType.class;

    public static final Class<DataFormat> DATA_FORMAT = DataFormat.class;

    public static final Class<DataTranslator> DATA_TRANSLATOR = DataTranslator.class;

    public static final Class<Difficulty> DIFFICULTY = Difficulty.class;

    public static final Class<DimensionType> DIMENSION_TYPE = DimensionType.class;

    public static final Class<DismountType> DISMOUNT_TYPE = DismountType.class;

    public static final Class<DisplaySlot> DISPLAY_SLOT = DisplaySlot.class;

    public static final Class<DyeColor> DYE_COLOR = DyeColor.class;

    public static final Class<EnchantmentType> ENCHANTMENT_TYPE = EnchantmentType.class;

    public static final Class<EntityType> ENTITY_TYPE = EntityType.class;

    public static final Class<EquipmentType> EQUIPMENT_TYPE = EquipmentType.class;

    public static final Class<EventContextKey> EVENT_CONTEXT_KEY = EventContextKey.class;

    public static final Class<FireworkShape> FIREWORK_SHAPE = FireworkShape.class;

    public static final Class<FluidType> FLUID_TYPE = FluidType.class;

    public static final Class<FoxType> FOX_TYPE = FoxType.class;

    public static final Class<GameMode> GAME_MODE = GameMode.class;

    public static final Class<GeneratorType> GENERATOR_TYPE = GeneratorType.class;

    public static final Class<GoalExecutorType> GOAL_EXECUTOR_TYPE = GoalExecutorType.class;

    public static final Class<GoalType> GOAL_TYPE = GoalType.class;

    public static final Class<HandPreference> HAND_PREFERENCE = HandPreference.class;

    public static final Class<HandType> HAND_TYPE = HandType.class;

    public static final Class<HeldEquipmentType> HELD_EQUIPMENT_TYPE = HeldEquipmentType.class;

    public static final Class<Hinge> HINGE = Hinge.class;

    public static final Class<HorseColor> HORSE_COLOR = HorseColor.class;

    public static final Class<HorseStyle> HORSE_STYLE = HorseStyle.class;

    public static final Class<InstrumentType> INSTRUMENT_TYPE = InstrumentType.class;

    public static final Class<ItemType> ITEM_TYPE = ItemType.class;

    public static final Class<LlamaType> LLAMA_TYPE = LlamaType.class;

    public static final Class<ModifierTemplate> MODIFIER_TEMPLATE = ModifierTemplate.class;

    public static final Class<MooshroomType> MOOSHROOM_TYPE = MooshroomType.class;

    public static final Class<MusicDisc> MUSIC_DISC = MusicDisc.class;

    public static final Class<NotePitch> NOTE_PITCH = NotePitch.class;

    public static final Class<ObjectiveDisplayMode> OBJECTIVE_DISPLAY_MODE = ObjectiveDisplayMode.class;

    public static final Class<PandaGene> PANDA_GENE = PandaGene.class;

    public static final Class<ParrotType> PARROT_TYPE = ParrotType.class;

    public static final Class<ParticleOption> PARTICLE_OPTION = ParticleOption.class;

    public static final Class<ParticleType> PARTICLE_TYPE = ParticleType.class;

    public static final Class<PickupRule> PICKUP_RULE = PickupRule.class;

    public static final Class<PistonType> PISTON_TYPE = PistonType.class;

    public static final Class<PortalAgentType> PORTAL_AGENT_TYPE = PortalAgentType.class;

    public static final Class<PortionType> PORTION_TYPE = PortionType.class;

    public static final Class<PotionEffectType> POTION_EFFECT_TYPE = PotionEffectType.class;

    public static final Class<Profession> PROFESSION = Profession.class;

    public static final Class<QueryType> QUERY_TYPE = QueryType.class;

    public static final Class<RabbitType> RABBIT_TYPE = RabbitType.class;

    public static final Class<RailDirection> RAIL_DIRECTION = RailDirection.class;

    public static final Class<Rotation> ROTATION = Rotation.class;

    public static final Class<SelectorType> SELECTOR_TYPE = SelectorType.class;

    public static final Class<SerializationBehavior> SERIALIZATION_BEHAVIOR = SerializationBehavior.class;

    public static final Class<SkinPart> SKIN_PART = SkinPart.class;

    public static final Class<SlabPortion> SLAB_PORTION = SlabPortion.class;

    public static final Class<SoundCategory> SOUND_CATEGORY = SoundCategory.class;

    public static final Class<SoundType> SOUND_TYPE = SoundType.class;

    public static final Class<SpawnType> SPAWN_TYPE = SpawnType.class;

    public static final Class<StairShape> STAIR_SHAPE = StairShape.class;

    public static final Class<Statistic> STATISTIC = Statistic.class;

    public static final Class<StatisticCategory> STATISTIC_CATEGORY = StatisticCategory.class;

    public static final Class<TeleportHelperFilter> TELEPORT_HELPER_FILTER = TeleportHelperFilter.class;

    public static final Class<TeleportType> TELEPORT_TYPE = TeleportType.class;

    public static final Class<TextColor> TEXT_COLOR = TextColor.class;

    public static final Class<TextSerializer> TEXT_SERIALIZER = TextSerializer.class;

    public static final Class<TextStyle> TEXT_STYLE = TextStyle.class;

    public static final Class<ToolType> TOOL_TYPE = ToolType.class;

    public static final Class<TransactionType> TRANSACTION_TYPE = TransactionType.class;

    public static final Class<Trigger> TRIGGER = Trigger.class;

    public static final Class<TropicalFishShape> TROPICAL_FISH_SHAPE = TropicalFishShape.class;

    public static final Class<VirtualBiomeType> VIRTUAL_BIOME_TYPE = VirtualBiomeType.class;

    public static final Class<Visibility> VISIBILITY = Visibility.class;

    public static final Class<Weather> WEATHER = Weather.class;

    public static final Class<WireAttachmentType> WIRE_ATTACHMENT_TYPE = WireAttachmentType.class;

    public static final Class<WoodType> WOOD_TYPE = WoodType.class;

    public static final Class<WorldArchetype> WORLD_ARCHETYPE = WorldArchetype.class;

    public static final Class<WornEquipmentType> WORN_EQUIPMENT_TYPE = WornEquipmentType.class;

    // SORTFIELDS:OFF

    private CatalogTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
