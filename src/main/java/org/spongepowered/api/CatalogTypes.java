/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import org.spongepowered.api.attribute.Attribute;
import org.spongepowered.api.attribute.Operation;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.tile.TileEntityType;
import org.spongepowered.api.block.tile.data.BannerPatternShape;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.EntityInteractionType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.hanging.art.Art;
import org.spongepowered.api.entity.living.animal.HorseColor;
import org.spongepowered.api.entity.living.animal.HorseStyle;
import org.spongepowered.api.entity.living.animal.HorseVariant;
import org.spongepowered.api.entity.living.animal.OcelotType;
import org.spongepowered.api.entity.living.animal.RabbitType;
import org.spongepowered.api.entity.living.monster.SkeletonType;
import org.spongepowered.api.entity.living.villager.Career;
import org.spongepowered.api.entity.living.villager.Profession;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.item.CoalType;
import org.spongepowered.api.item.CookedFish;
import org.spongepowered.api.item.DyeColor;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.FireworkShape;
import org.spongepowered.api.item.Fish;
import org.spongepowered.api.item.GoldenApple;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.potion.PotionEffectType;
import org.spongepowered.api.scoreboard.Visibility;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayMode;
import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.stats.StatisticFormat;
import org.spongepowered.api.stats.StatisticGroup;
import org.spongepowered.api.stats.achievement.Achievement;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.selector.SelectorType;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.GeneratorType;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.weather.Weather;

/**
 * Enumeration of all known {@link CatalogType}s for autocompletion when using the
 * {@link GameRegistry#getType(Class, String)} and {@link
 * GameRegistry#getAllOf(Class)}.
 */
public final class CatalogTypes {

    public static final Class<Achievement> ACHIEVEMENT = Achievement.class;
    public static final Class<Art> ART = Art.class;
    public static final Class<Attribute> ATTRIBUTE = Attribute.class;
    public static final Class<BannerPatternShape> BANNER_PATTERN_SHAPE = BannerPatternShape.class;
    public static final Class<BiomeType> BIOME_TYPE = BiomeType.class;
    public static final Class<BlockType> BLOCK_TYPE = BlockType.class;
    public static final Class<Career> CAREER = Career.class;
    public static final Class<ChatType> CHAT_TYPE = ChatType.class;
    public static final Class<CoalType> COAL_TYPE = CoalType.class;
    public static final Class<CookedFish> COOKED_FISH = CookedFish.class;
    public static final Class<Criterion> CRITERION = Criterion.class;
    public static final Class<Difficulty> DIFFICULTY = Difficulty.class;
    public static final Class<DimensionType> DIMENSION_TYPE = DimensionType.class;
    public static final Class<DyeColor> DYE_COLOR = DyeColor.class;
    public static final Class<Enchantment> ENCHANTMENT = Enchantment.class;
    public static final Class<EntityInteractionType> ENTITY_INTERACTION_TYPE = EntityInteractionType.class;
    public static final Class<EntityType> ENTITY_TYPE = EntityType.class;
    public static final Class<EquipmentType> EQUIPMENT_TYPE = EquipmentType.class;
    public static final Class<FireworkShape> FIREWORK_SHAPE = FireworkShape.class;
    public static final Class<Fish> FISH = Fish.class;
    public static final Class<GameMode> GAME_MODE = GameMode.class;
    public static final Class<GeneratorType> GENERATOR_TYPE = GeneratorType.class;
    public static final Class<GoldenApple> GOLDEN_APPLE = GoldenApple.class;
    public static final Class<HorseColor> HORSE_COLOR = HorseColor.class;
    public static final Class<HorseStyle> HORSE_STYLE = HorseStyle.class;
    public static final Class<HorseVariant> HORSE_VARIANT = HorseVariant.class;
    public static final Class<ItemType> ITEM_TYPE = ItemType.class;
    public static final Class<ObjectiveDisplayMode> OBJECTIVE_DISPLAY_MODE = ObjectiveDisplayMode.class;
    public static final Class<OcelotType> OCELOT_TYPE = OcelotType.class;
    public static final Class<Operation> OPERATION = Operation.class;
    public static final Class<ParticleType> PARTICLE_TYPE = ParticleType.class;
    public static final Class<PotionEffectType> POTION_EFFECT_TYPE = PotionEffectType.class;
    public static final Class<Profession> PROFESSION = Profession.class;
    public static final Class<RabbitType> RABBIT_TYPE = RabbitType.class;
    public static final Class<Rotation> ROTATION = Rotation.class;
    public static final Class<SelectorType> SELECTOR_TYPE = SelectorType.class;
    public static final Class<SkeletonType> SKELETON_TYPE = SkeletonType.class;
    public static final Class<SoundType> SOUND_TYPE = SoundType.class;
    public static final Class<Statistic> STATISTIC = Statistic.class;
    public static final Class<StatisticFormat> STATISTIC_FORMAT = StatisticFormat.class;
    public static final Class<StatisticGroup> STATISTIC_GROUP = StatisticGroup.class;
    public static final Class<TextColor> TEXT_COLOR = TextColor.class;
    public static final Class<TileEntityType> TILE_ENTITY_TYPE = TileEntityType.class;
    public static final Class<Visibility> VISIBILITY = Visibility.class;
    public static final Class<Weather> WEATHER = Weather.class;

    private CatalogTypes() {
    }
}
