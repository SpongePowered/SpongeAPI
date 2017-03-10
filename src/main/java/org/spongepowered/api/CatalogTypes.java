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

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.tileentity.TileEntityType;
import org.spongepowered.api.boss.BossBarColor;
import org.spongepowered.api.boss.BossBarOverlay;
import org.spongepowered.api.data.persistence.DataFormat;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.data.type.*;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.effect.particle.ParticleOption;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.sound.SoundCategory;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.ai.GoalType;
import org.spongepowered.api.entity.ai.task.AITaskType;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.event.cause.entity.damage.DamageModifierType;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.dismount.DismountType;
import org.spongepowered.api.event.cause.entity.health.HealingType;
import org.spongepowered.api.event.cause.entity.health.HealthModifierType;
import org.spongepowered.api.event.cause.entity.spawn.SpawnType;
import org.spongepowered.api.event.cause.entity.teleport.TeleportType;
import org.spongepowered.api.extra.fluid.FluidType;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.FireworkShape;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.InventoryArchetype;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.scoreboard.CollisionRule;
import org.spongepowered.api.scoreboard.Visibility;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayMode;
import org.spongepowered.api.service.economy.transaction.TransactionType;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.StatisticType;
import org.spongepowered.api.statistic.achievement.Achievement;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.chat.ChatVisibility;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.selector.SelectorType;
import org.spongepowered.api.util.ban.BanType;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.GeneratorType;
import org.spongepowered.api.world.PortalAgentType;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.WorldArchetype;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.gen.PopulatorObject;
import org.spongepowered.api.world.gen.PopulatorType;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.gen.type.BiomeTreeType;
import org.spongepowered.api.world.gen.type.MushroomType;
import org.spongepowered.api.world.schematic.BlockPaletteType;
import org.spongepowered.api.world.weather.Weather;

/**
 * Enumeration of all known {@link CatalogType}s for autocompletion when using the
 * {@link GameRegistry#getType(Class, String)} and
 * {@link GameRegistry#getAllOf(Class)}.
 */
public final class CatalogTypes {

    // SORTFIELDS:ON

    public static final Class<Achievement> ACHIEVEMENT = Achievement.class;

    public static final Class<AITaskType> AI_TASK_TYPE = AITaskType.class;

    public static final Class<ArmorType> ARMOR_TYPE = ArmorType.class;

    public static final Class<Art> ART = Art.class;

    public static final Class<BannerPatternShape> BANNER_PATTERN_SHAPE = BannerPatternShape.class;

    public static final Class<BanType> BAN_TYPE = BanType.class;

    public static final Class<BigMushroomType> BIG_MUSHROOM_TYPE = BigMushroomType.class;

    public static final Class<BiomeTreeType> BIOME_TREE_TYPE = BiomeTreeType.class;

    public static final Class<BiomeType> BIOME_TYPE = BiomeType.class;

    public static final Class<BlockPaletteType> BLOCK_PALETTE_TYPE = BlockPaletteType.class;

    public static final Class<BlockType> BLOCK_TYPE = BlockType.class;

    public static final Class<BodyPart> BODY_PART = BodyPart.class;

    public static final Class<BossBarColor> BOSS_BAR_COLOR = BossBarColor.class;

    public static final Class<BossBarOverlay> BOSS_BAR_OVERLAY = BossBarOverlay.class;

    public static final Class<BrickType> BRICK_TYPE = BrickType.class;

    public static final Class<Career> CAREER = Career.class;

    public static final Class<ChatType> CHAT_TYPE = ChatType.class;

    public static final Class<ChatVisibility> CHAT_VISIBILITY = ChatVisibility.class;

    public static final Class<CoalType> COAL_TYPE = CoalType.class;

    public static final Class<CollisionRule> COLLISION_RULE = CollisionRule.class;

    public static final Class<ComparatorType> COMPARISON_TYPE = ComparatorType.class;

    public static final Class<CookedFish> COOKED_FISH = CookedFish.class;

    public static final Class<Criterion> CRITERION = Criterion.class;

    public static final Class<DamageModifierType> DAMAGE_MODIFIER_TYPE = DamageModifierType.class;

    public static final Class<DamageType> DAMAGE_TYPE = DamageType.class;

    public static final Class<DataFormat> DATA_FORMAT = DataFormat.class;

    public static final Class<DataTranslator> DATA_TRANSLATOR = DataTranslator.class;

    public static final Class<Difficulty> DIFFICULTY = Difficulty.class;

    public static final Class<DimensionType> DIMENSION_TYPE = DimensionType.class;

    public static final Class<DirtType> DIRT_TYPE = DirtType.class;

    public static final Class<DisguisedBlockType> DISGUISED_BLOCK_TYPE = DisguisedBlockType.class;

    public static final Class<DismountType> DISMOUNT_TYPE = DismountType.class;

    public static final Class<DisplaySlot> DISPLAY_SLOT = DisplaySlot.class;

    public static final Class<DoublePlantType> DOUBLE_PLANT_TYPE = DoublePlantType.class;

    /**
     * @deprecated Use {@link #DOUBLE_PLANT_TYPE}.
     */
    @Deprecated
    public static final Class<DoublePlantType> DOUBLE_SIZE_PLANT_TYPE = DOUBLE_PLANT_TYPE;

    public static final Class<DyeColor> DYE_COLOR = DyeColor.class;

    public static final Class<Enchantment> ENCHANTMENT = Enchantment.class;

    public static final Class<EntityType> ENTITY_TYPE = EntityType.class;

    public static final Class<EquipmentType> EQUIPMENT_TYPE = EquipmentType.class;

    public static final Class<FireworkShape> FIREWORK_SHAPE = FireworkShape.class;

    public static final Class<Fish> FISH = Fish.class;

    public static final Class<FluidType> FLUID_TYPE = FluidType.class;

    public static final Class<GameMode> GAME_MODE = GameMode.class;

    public static final Class<GeneratorType> GENERATOR_TYPE = GeneratorType.class;

    public static final Class<GoalType> GOAL_TYPE = GoalType.class;

    public static final Class<GoldenApple> GOLDEN_APPLE = GoldenApple.class;

    public static final Class<HandPreference> HAND_PREFERENCE = HandPreference.class;

    public static final Class<HandType> HAND_TYPE = HandType.class;

    public static final Class<HealingType> HEALING_TYPE = HealingType.class;

    public static final Class<HealthModifierType> HEALTH_MODIFIER_TYPE = HealthModifierType.class;

    public static final Class<Hinge> HINGE = Hinge.class;

    public static final Class<HorseColor> HORSE_COLOR = HorseColor.class;

    public static final Class<HorseStyle> HORSE_STYLE = HorseStyle.class;

    @Deprecated public static final Class<HorseVariant> HORSE_VARIANT = HorseVariant.class;
    public static final Class<InstrumentType> INSTRUMENT_TYPE = InstrumentType.class;

    public static final Class<InventoryArchetype> INVENTORY_ARCHETYPE = InventoryArchetype.class;

    public static final Class<ItemType> ITEM_TYPE = ItemType.class;

    public static final Class<LlamaVariant> LLAMA_VARIANT = LlamaVariant.class;

    public static final Class<LogAxis> LOG_AXIS = LogAxis.class;

    public static final Class<MushroomType> MUSHROOM_TYPE = MushroomType.class;

    public static final Class<NotePitch> NOTE_PITCH = NotePitch.class;

    public static final Class<ObjectiveDisplayMode> OBJECTIVE_DISPLAY_MODE = ObjectiveDisplayMode.class;

    public static final Class<OcelotType> OCELOT_TYPE = OcelotType.class;

    public static final Class<ParticleOption> PARTICLE_OPTION = ParticleOption.class;

    public static final Class<ParticleType> PARTICLE_TYPE = ParticleType.class;

    public static final Class<PickupRule> PICKUP_RULE = PickupRule.class;

    public static final Class<PistonType> PISTON_TYPE = PistonType.class;

    public static final Class<PlantType> PLANT_TYPE = PlantType.class;

    public static final Class<PopulatorObject> POPULATOR_OBJECT = PopulatorObject.class;

    public static final Class<PopulatorType> POPULATOR_TYPE = PopulatorType.class;

    public static final Class<PortalAgentType> PORTAL_AGENT_TYPE = PortalAgentType.class;

    public static final Class<PortionType> PORTION_TYPE = PortionType.class;

    public static final Class<PotionEffectType> POTION_EFFECT_TYPE = PotionEffectType.class;

    public static final Class<PrismarineType> PRISMARINE_TYPE = PrismarineType.class;

    public static final Class<Profession> PROFESSION = Profession.class;

    public static final Class<QuartzType> QUARTZ_TYPE = QuartzType.class;

    public static final Class<RabbitType> RABBIT_TYPE = RabbitType.class;

    public static final Class<RailDirection> RAIL_DIRECTION = RailDirection.class;

    public static final Class<Rotation> ROTATION = Rotation.class;

    public static final Class<SandstoneType> SANDSTONE_TYPE = SandstoneType.class;

    public static final Class<SandType> SAND_TYPE = SandType.class;

    public static final Class<SelectorType> SELECTOR_TYPE = SelectorType.class;

    public static final Class<SerializationBehavior> SERIALIZATION_BEHAVIOR = SerializationBehavior.class;

    public static final Class<ShrubType> SHRUB_TYPE = ShrubType.class;

    @Deprecated public static final Class<SkeletonType> SKELETON_TYPE = SkeletonType.class;
    public static final Class<SkinPart> SKIN_PART = SkinPart.class;

    public static final Class<SkullType> SKULL_TYPE = SkullType.class;

    public static final Class<SlabType> SLAB_TYPE = SlabType.class;

    public static final Class<SoundCategory> SOUND_CATEGORY = SoundCategory.class;

    public static final Class<SoundType> SOUND_TYPE = SoundType.class;

    public static final Class<SpawnType> SPAWN_TYPE = SpawnType.class;

    public static final Class<StairShape> STAIR_SHAPE = StairShape.class;

    public static final Class<Statistic> STATISTIC = Statistic.class;

    public static final Class<StatisticType> STATISTIC_TYPE = StatisticType.class;

    public static final Class<StoneType> STONE_TYPE = StoneType.class;

    public static final Class<TeleportType> TELEPORT_TYPE = TeleportType.class;

    public static final Class<TextColor> TEXT_COLOR = TextColor.class;

    public static final Class<TextStyle> TEXT_STYLE = TextStyle.class;

    public static final Class<TileEntityType> TILE_ENTITY_TYPE = TileEntityType.class;

    public static final Class<ToolType> TOOL_TYPE = ToolType.class;

    public static final Class<TransactionType> TRANSACTION_TYPE = TransactionType.class;

    public static final Class<TreeType> TREE_TYPE = TreeType.class;

    public static final Class<Visibility> VISIBILITY = Visibility.class;

    public static final Class<WallType> WALL_TYPE = WallType.class;

    public static final Class<Weather> WEATHER = Weather.class;

    public static final Class<WireAttachmentType> WIRE_ATTACHMENT_TYPE = WireAttachmentType.class;

    public static final Class<WorldArchetype> WORLD_ARCHETYPE = WorldArchetype.class;

    public static final Class<WorldGeneratorModifier> WORLD_GENERATOR_MODIFIER = WorldGeneratorModifier.class;

    // SORTFIELDS:OFF

    private CatalogTypes() {
    }
}
