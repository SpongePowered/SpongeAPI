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

import com.google.common.base.Optional;
import org.spongepowered.api.attribute.Attribute;
import org.spongepowered.api.attribute.AttributeBuilder;
import org.spongepowered.api.attribute.AttributeCalculator;
import org.spongepowered.api.attribute.AttributeModifierBuilder;
import org.spongepowered.api.attribute.Operation;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.tile.TileEntityType;
import org.spongepowered.api.block.tile.data.BannerPatternShape;
import org.spongepowered.api.block.tile.data.NotePitch;
import org.spongepowered.api.block.tile.data.SkullType;
import org.spongepowered.api.effect.particle.ParticleEffectBuilder;
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
import org.spongepowered.api.item.FireworkEffectBuilder;
import org.spongepowered.api.item.Fish;
import org.spongepowered.api.item.GoldenApple;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStackBuilder;
import org.spongepowered.api.item.merchant.TradeOfferBuilder;
import org.spongepowered.api.item.recipe.RecipeRegistry;
import org.spongepowered.api.potion.PotionEffectBuilder;
import org.spongepowered.api.potion.PotionEffectType;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.stats.BlockStatistic;
import org.spongepowered.api.stats.EntityStatistic;
import org.spongepowered.api.stats.ItemStatistic;
import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.stats.StatisticBuilder;
import org.spongepowered.api.stats.StatisticFormat;
import org.spongepowered.api.stats.StatisticGroup;
import org.spongepowered.api.stats.TeamStatistic;
import org.spongepowered.api.stats.achievement.Achievement;
import org.spongepowered.api.stats.achievement.AchievementBuilder;
import org.spongepowered.api.status.Favicon;
import org.spongepowered.api.text.chat.ChatType;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.selector.ArgumentType;
import org.spongepowered.api.text.selector.SelectorType;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.biome.BiomeType;
import org.spongepowered.api.world.difficulty.Difficulty;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Locale;
import java.util.UUID;

/**
 * Provides an easy way to retrieve types from a {@link Game}.
 *
 * <p>Note that the registries may be in flux, especially during game
 * initialization. These will be accurate for the time they are called, however
 * they may change at a later point. Do not assume that the contents of a collection
 * will be all the entries that will exist.</p>
 *
 * <p>Some of the returned instances my become incorrect if they are later
 * overwritten. However, this should occur prior to
 * {@link GameState#POST_INITIALIZATION}.</p>
 */
public interface GameRegistry {

    /**
     * Gets a {@link BlockType} by its identifier.
     *
     * @param id The id to look up
     * @return The block or Optional.absent() if not found
     */
    Optional<BlockType> getBlock(String id);

    /**
     * Gets a collection of all available {@link BlockType}s.
     *
     * @return A collection containing all block types in registry
     */
    Collection<BlockType> getBlocks();

    /**
     * Gets an {@link ItemType} by its identifier.
     *
     * @param id The id to look up
     * @return The item or Optional.absent() if not found
     */
    Optional<ItemType> getItem(String id);

    /**
     * Gets a collection of all available {@link ItemType}s.
     *
     * @return A collection containing all item types in registry
     */
    Collection<ItemType> getItems();

    /**
     * Gets a {@link TileEntityType} by its identifier.
     *
     * @param id The id to look up
     * @return The tile entity type or Optional.absent() if not found
     */
    Optional<TileEntityType> getTileEntityType(String id);

    /**
     * Gets a collection of all available {@link TileEntityType}s.
     *
     * @return A collection containing all tile entity types in registry
     */
    Collection<TileEntityType> getTileEntityTypes();

    /**
     * Gets a {@link BiomeType} by its identifier.
     *
     * @param id The id to look up
     * @return The biome or Optional.absent() if not found
     */
    Optional<BiomeType> getBiome(String id);

    /**
     * Gets a collection of all available {@link BiomeType}s.
     *
     * @return A collection containing all biome types
     */
    Collection<BiomeType> getBiomes();

    /**
     * Get an item stack builder.
     *
     * @return The item stack builder
     */
    ItemStackBuilder getItemBuilder();

    /**
     * Get a trade offer builder.
     *
     * @return The trade offer builder
     */
    TradeOfferBuilder getTradeOfferBuilder();

    /**
     * Get a potion effect builder.
     *
     * @return The potion effect builder
     */
    PotionEffectBuilder getPotionEffectBuilder();

    /**
     * Gets a {@link ParticleType} by name.
     *
     * @param name The particle name
     * @return The corresponding particle or Optional.absent() if not found
     */
    Optional<ParticleType> getParticleType(String name);

    /**
     * Gets a collection of all available {@link ParticleType}s.
     *
     * @return A collection containing all particle types in registry
     */
    Collection<ParticleType> getParticleTypes();

    /**
     * Gets a new particle builder for the {@link ParticleType}.
     *
     * @param particle The particle type
     * @return The particle effect builder
     */
    ParticleEffectBuilder getParticleEffectBuilder(ParticleType particle);

    /**
     * Gets a {@link SoundType} by name.
     *
     * @param name The sound name
     * @return The sound or Optional.absent() if not found
     */
    Optional<SoundType> getSound(String name);

    /**
     * Gets a collection of all known {@link SoundType}s.
     *
     * @return A collection containing all sounds in the registry
     */
    Collection<SoundType> getSounds();

    /**
     * Gets an {@link EntityType} by its identifier.
     *
     * @param id The id to look up
     * @return The entity type or Optional.absent() if not found
     */
    Optional<EntityType> getEntity(String id);

    /**
     * Gets a collection of all available {@link EntityType}s.
     *
     * @return A collection containing all entity types in registry
     */
    Collection<EntityType> getEntities();

    /**
     * Gets an {@link Art} by its identifier.
     *
     * @param id The id to look up
     * @return The art piece or Optional.absent() if not found
     */
    Optional<Art> getArt(String id);

    /**
     * Gets a collection of all available {@link Art} pieces.
     *
     * @return A collection of all available art pieces
     */
    Collection<Art> getArts();

    /**
     * Gets a {@link DyeColor} by its identifier.
     *
     * @param id The id to look up
     * @return The dye color or Optional.absent() if not found
     */
    Optional<DyeColor> getDye(String id);

    /**
     * Gets a collection of all available {@link DyeColor}s.
     *
     * @return A collection containing all dyes in registry
     */
    Collection<DyeColor> getDyes();

    /**
     * Gets a {@link HorseColor} by its identifier.
     *
     * @param id The id to look up
     * @return The horse color or Optional.absent() if not found
     */
    Optional<HorseColor> getHorseColor(String id);

    /**
     * Gets a collection of all available {@link HorseColor}s.
     *
     * @return A collection containing all horse colors in registry
     */
    Collection<HorseColor> getHorseColors();

    /**
     * Gets a {@link HorseStyle} by its identifier.
     *
     * @param id The id to look up
     * @return The horse style or Optional.absent() if not found
     */
    Optional<HorseStyle> getHorseStyle(String id);

    /**
     * Gets a collection of all available {@link HorseStyle}s.
     *
     * @return A collection containing all horse styles in registry
     */
    Collection<HorseStyle> getHorseStyles();

    /**
     * Gets a {@link HorseVariant} by its identifier.
     *
     * @param id The id to look up
     * @return The horse variant or Optional.absent() if not found
     */
    Optional<HorseVariant> getHorseVariant(String id);

    /**
     * Gets a collection of all available {@link HorseVariant}s.
     *
     * @return A collection containing all horse variants in registry
     */
    Collection<HorseVariant> getHorseVariants();

    /**
     * Gets an {@link OcelotType} by its identifier.
     *
     * @param id The id to look up
     * @return The ocelot type or Optional.absent() if not found
     */
    Optional<OcelotType> getOcelotType(String id);

    /**
     * Gets a collection of all available {@link OcelotType}s.
     *
     * @return A collection containing all ocelot types in registry
     */
    Collection<OcelotType> getOcelotTypes();

    /**
     * Gets a {@link RabbitType} by its identifier.
     *
     * @param id The id to look up
     * @return The rabbit type or Optional.absent() if not found
     */
    Optional<RabbitType> getRabbitType(String id);

    /**
     * Gets a collection of all available {@link RabbitType}s.
     *
     * @return A collection containing all rabbit types in registry
     */
    Collection<RabbitType> getRabbitTypes();

    /**
     * Gets a {@link SkeletonType} by its identifier.
     *
     * @param id The id to look up
     * @return The skeleton type or Optional.absent() if not found
     */
    Optional<SkeletonType> getSkeletonType(String id);

    /**
     * Gets a collection of all available {@link SkeletonType}s.
     *
     * @return A collection containing all skeleton types in registry
     */
    Collection<SkeletonType> getSkeletonTypes();

    /**
     * Gets the villager {@link Career} with the specified id.
     *
     * @param id The id of the career to return
     * @return The career with the given id or Optional.absent() if not found
     */
    Optional<Career> getCareer(String id);

    /**
     * Gets all available villager {@link Career}s.
     *
     * @return A collection of all villager careers
     */
    Collection<Career> getCareers();

    /**
     * Gets all available villager {@link Career}s for the given profession.
     *
     * @param profession The villager profession to collection careers from
     * @return A collection of all villager careers associated with the profession
     */
    Collection<Career> getCareers(Profession profession);

    /**
     * Gets the villager {@link Profession} with the specified id.
     *
     * @param id The id of the profession to return
     * @return The profession with the given id or Optional.absent() if not found
     */
    Optional<Profession> getProfession(String id);

    /**
     * Gets all available villager {@link Profession}s.
     *
     * @return A collection of all villager professions
     */
    Collection<Profession> getProfessions();

    /**
     * Gets a collection of all available {@link GameMode}s.
     *
     * @return A collection containing all game modes in registry
     */
    // TODO: GameMode from string? Should add 'String getId()' to GameMode if so.
    Collection<GameMode> getGameModes();

    /**
     * Gets a collection of all available {@link PotionEffectType}s.
     *
     * @return A collection containing all potion effect types in registry
     */
    // TODO: PotionEffectType from string? Should add 'String getId()' to PotionEffectType if so.
    Collection<PotionEffectType> getPotionEffects();

    /**
     * Gets the {@link Enchantment} with the specified id.
     *
     * @param id The id of the enchantment to return
     * @return The enchantment with the given id or Optional.absent() if not found
     */
    Optional<Enchantment> getEnchantment(String id);

    /**
     * Gets all available {@link Enchantment}s.
     *
     * @return A collection of all enchantments
     */
    Collection<Enchantment> getEnchantments();

    /**
     * Gets a {@link Collection} of the default GameRules.
     *
     * @return The default GameRules.
     */
    Collection<String> getDefaultGameRules();

    /**
     * Gets the {@link Statistic} with the specified internal name.
     *
     * @param name The name of the statistic to return
     * @return The statistic or Optional.absent() if not found
     */
    Optional<Statistic> getStatistic(String name);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link EntityType}. If the statistic group is not a valid
     * {@link EntityStatistic} group then {@link Optional#absent()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param entityType The entity type for the statistic to return
     * @return The entity statistic or Optional.absent() if not found
     */
    Optional<EntityStatistic> getEntityStatistic(StatisticGroup statisticGroup, EntityType entityType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link ItemType}. If the statistic group is not a valid
     * {@link ItemStatistic} group then {@link Optional#absent()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param itemType The item type for the statistic to return
     * @return The item statistic or Optional.absent() if not found
     */
    Optional<ItemStatistic> getItemStatistic(StatisticGroup statisticGroup, ItemType itemType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * {@link BlockType}. If the statistic group is not a valid
     * {@link BlockStatistic} group then {@link Optional#absent()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param blockType The block type for the statistic to return
     * @return The block statistic or Optional.absent() if not found
     */
    Optional<BlockStatistic> getBlockStatistic(StatisticGroup statisticGroup, BlockType blockType);

    /**
     * Gets the {@link Statistic} for the given {@link StatisticGroup} and
     * team's {@link TextColor}. If the {@link StatisticGroup} is not a valid
     * {@link TeamStatistic} group then {@link Optional#absent()} will be
     * returned.
     *
     * @param statisticGroup The type of statistic to return
     * @param teamColor The team's color for the statistic to return
     * @return The team statistic or Optional.absent() if not found
     */
    Optional<TeamStatistic> getTeamStatistic(StatisticGroup statisticGroup, TextColor teamColor);

    /**
     * Gets a list of all available {@link Statistic}s which belong to the given
     * {@link StatisticGroup}.
     *
     * @param statisticGroup The statisticType to return
     * @return An immutable collection containing all statistics in the group
     */
    Collection<Statistic> getStatistics(StatisticGroup statisticGroup);

    /**
     * Gets a collection of all available {@link Statistic}s.
     *
     * @return An immutable collection containing all registered statistics
     */
    Collection<Statistic> getStatistics();

    /**
     * Creates a new {@link StatisticBuilder} which may be used to create custom
     * {@link Statistic}s.
     *
     * @return The newly created simple statistic builder
     */
    StatisticBuilder getStatisticBuilder();

    /**
     * Creates a new
     * {@link org.spongepowered.api.stats.StatisticBuilder.EntityStatisticBuilder}
     * which may be used to create custom {@link EntityStatistic}s.
     *
     * @return The newly created entity statistic builder
     */
    StatisticBuilder.EntityStatisticBuilder getEntityStatisticBuilder();

    /**
     * Creates a new
     * {@link org.spongepowered.api.stats.StatisticBuilder.BlockStatisticBuilder}
     * which may be used to create custom {@link BlockStatistic}s.
     *
     * @return The newly created block statistic builder
     */
    StatisticBuilder.BlockStatisticBuilder getBlockStatisticBuilder();

    /**
     * Creates a new
     * {@link org.spongepowered.api.stats.StatisticBuilder.ItemStatisticBuilder}
     * which may be used to create custom {@link ItemStatistic}s.
     *
     * @return The newly created item statistic builder
     */
    StatisticBuilder.ItemStatisticBuilder getItemStatisticBuilder();

    /**
     * Creates a new
     * {@link org.spongepowered.api.stats.StatisticBuilder.TeamStatisticBuilder}
     * which may be used to create custom {@link TeamStatistic}s.
     *
     * @return The newly created team statistic builder
     */
    StatisticBuilder.TeamStatisticBuilder getTeamStatisticBuilder();

    /**
     * Registers a custom statistic.
     *
     * @param stat The custom statistic
     */
    void registerStatistic(Statistic stat);

    /**
     * Gets the {@link StatisticFormat} with the specified name.
     *
     * @param name The name of the statistic format to return
     * @return The format or Optional.absent() if not found
     */
    Optional<StatisticFormat> getStatisticFormat(String name);

    /**
     * Gets a collection of all available {@link StatisticFormat}s.
     *
     * @return An immutable collection containing all available formats
     */
    Collection<StatisticFormat> getStatisticFormats();

    /**
     * Gets the {@link Achievement} with the specified internal name.
     *
     * @param name The name of the achievement
     * @return The achievement or Optional.absent() if not found
     */
    Optional<Achievement> getAchievement(String name);

    /**
     * Gets a collection of all available {@link Achievement}s.
     *
     * @return An immutable collection containing all available achievements
     */
    Collection<Achievement> getAchievements();

    /**
     * Creates a new {@link AchievementBuilder} which may be used to create
     * custom {@link Achievement}s.
     *
     * @return The newly created achievement builder
     */
    AchievementBuilder getAchievementBuilder();

    /**
     * Gets the {@link DimensionType} with the provided name.
     *
     * @param name The name of the dimension type
     * @return The {@link DimensionType} with the given name or Optional.absent() if not found
     */
    Optional<DimensionType> getDimensionType(String name);

    /**
     * Gets a {@link Collection} of all possible {@link DimensionType}s.
     *
     * @return The collection of all available {@link DimensionType}s
     */
    Collection<DimensionType> getDimensionTypes();

    /**
     * Gets the {@link Rotation} with the provided degrees.
     *
     * @param degrees The degrees of the rotation
     * @return The {@link Rotation} with the given degrees or Optional.absent() if not found
     */
    Optional<Rotation> getRotationFromDegree(int degrees);

    /**
     * Gets a {@link Collection} of all possible {@link Rotation}s.
     *
     * @return The collection of all available {@link Rotation}s
     */
    Collection<Rotation> getRotations();

    // TODO: Find a better place for these methods

    /**
     * Creates a new {@link GameProfile} using the specified unique identifier and name.
     *
     * @param uuid The unique identifier for the profile
     * @param name The name for the profile
     * @return The created profile
     */
    GameProfile createGameProfile(UUID uuid, String name);

    /**
     * Loads a {@link Favicon} from the specified encoded string. The format of
     * the input depends on the implementation.
     *
     * @param raw The encoded favicon
     * @return The loaded favicon
     * @throws IOException If the favicon couldn't be loaded
     */
    Favicon loadFavicon(String raw) throws IOException;

    /**
     * Loads a favicon from a specified {@link File}.
     *
     * @param file The favicon file
     * @return The loaded favicon from the file
     * @throws IOException If the favicon couldn't be loaded
     * @throws FileNotFoundException If the file doesn't exist
     */
    Favicon loadFavicon(File file) throws IOException;

    /**
     * Loads a favicon from a specified {@link URL}.
     *
     * @param url The favicon URL
     * @return The loaded favicon from the URL
     * @throws IOException If the favicon couldn't be loaded
     */
    Favicon loadFavicon(URL url) throws IOException;

    /**
     * Loads a favicon from a specified {@link InputStream}.
     *
     * @param in The favicon input stream
     * @return The loaded favicon from the input stream
     * @throws IOException If the favicon couldn't be loaded
     */
    Favicon loadFavicon(InputStream in) throws IOException;

    /**
     * Loads a favicon from a specified {@link BufferedImage}.
     *
     * @param image The favicon image
     * @return The loaded favicon from the image
     * @throws IOException If the favicon couldn't be loaded
     */
    Favicon loadFavicon(BufferedImage image) throws IOException;

    /**
     * Gets the {@link NotePitch} with the provided name.
     *
     * @param name The name of the note pitch
     * @return The {@link NotePitch} with the given name or Optional.absent() if not found
     */
    Optional<NotePitch> getNotePitch(String name);

    /**
     * Gets a {@link Collection} of all possible {@link NotePitch}s.
     *
     * @return The collection of all available {@link NotePitch}s
     */
    Collection<NotePitch> getNotePitches();

    /**
     * Gets the {@link SkullType} with the provided name.
     *
     * @param name The name of the skull type
     * @return The {@link SkullType} with the given name or Optional.absent() if not found
     */
    Optional<SkullType> getSkullType(String name);

    /**
     * Gets a {@link Collection} of all possible {@link SkullType}s.
     *
     * @return The collection of all available {@link SkullType}s
     */
    Collection<SkullType> getSkullTypes();

    /**
     * Gets the {@link BannerPatternShape} with the provided name.
     *
     * @param name The name of the BannerPatternShape
     * @return The {@link BannerPatternShape} with the given name or Optional.absent() if not found
     */
    Optional<BannerPatternShape> getBannerPatternShape(String name);

    /**
     * Gets the {@link BannerPatternShape} with the provided name.
     *
     * @param id The id of the BannerPatternShape
     * @return The {@link BannerPatternShape} with the given name or Optional.absent() if not found
     */
    Optional<BannerPatternShape> getBannerPatternShapeById(String id);

    /**
     * Gets a {@link Collection} of all possible {@link BannerPatternShape}s.
     *
     * @return The collection of all available {@link BannerPatternShape}s
     */
    Collection<BannerPatternShape> getBannerPatternShapes();

    /**
     * Retrieves the GameDictionary (item dictionary) for this GameRegistry.
     *
     * @return The item dictionary
     */
    GameDictionary getGameDictionary();

    /**
     * Retrieves the RecipeRegistry for this GameRegistry.
     *
     * @return The recipe registry
     */
    RecipeRegistry getRecipeRegistry();

    /**
     * Gets a collection of all available {@link Difficulty}s.
     *
     * @return A collection containing all Difficulties in registry
     */
    Collection<Difficulty> getDifficulties();

    /**
     * Gets a {@link Difficulty} by name.
     *
     * @param name The name of the difficulty
     * @return The difficulty with that name, or {@link Optional#absent()}
     */
    Optional<Difficulty> getDifficulty(String name);

    /**
     * Gets a collection of all available {@link EntityInteractionType}s.
     *
     * @return A collection of all available {@link EntityInteractionType}s
     */
    Collection<EntityInteractionType> getEntityInteractionTypes();

    /**
     * Gets an {@link EntityInteractionType} by name.
     *
     * @param name The name of the {@link EntityInteractionType}
     * @return The {@link EntityInteractionType} with that name, or {@link Optional#absent()}
     */
    Optional<EntityInteractionType> getEntityInteractionType(String name);

    /**
     * Gets an {@link Attribute} by name.
     *
     * @param name The name of the Attribute
     * @return The {@link Attribute} with the given name or
     *         {@link Optional#absent()} if not found
     */
    Optional<Attribute> getAttribute(String name);

    /**
     * Gets a {@link Collection} of all possible {@link Attribute}s.
     *
     * @return The collection of all available {@link Attribute}s
     */
    Collection<Attribute> getAttributes();

    /**
     * Gets an {@link Operation} by name.
     *
     * @param name The name of the Operation
     * @return The {@link Operation} with the given name or
     *         {@link Optional#absent()} if not found
     */
    Optional<Operation> getOperation(String name);

    /**
     * Gets a {@link Collection} of all possible {@link Operation}s.
     *
     * @return The collection of all available {@link Operation}s
     */
    Collection<Operation> getOperations();

    /**
     * Gets a new {@link AttributeModifierBuilder}.
     *
     * @return A new AttributeModifierBuilder
     */
    AttributeModifierBuilder getAttributeModifierBuilder();

    /**
     * Gets the {@link AttributeCalculator}.
     *
     * @return The {@link AttributeCalculator}
     */
    AttributeCalculator getAttributeCalculator();

    /**
     * Gets a new {@link AttributeBuilder}.
     *
     * @return A new AttributeBuilder
     */
    AttributeBuilder getAttributeBuilder();

    /**
     * Gets a {@link CoalType} by name.
     *
     * @param name The name of the coal type
     * @return The coal type or Optional.absent() if not found
     */
    Optional<CoalType> getCoalType(String name);

    /**
     * Gets a collection of all available {@link CoalType}s.
     *
     * @return A collection of all coal types
     */
    Collection<CoalType> getCoalTypes();

    /**
     * Gets a {@link Fish} by name.
     *
     * @param name The name of the fish type
     * @return The fish type or Optional.absent() if not found
     */
    Optional<Fish> getFishType(String name);

    /**
     * Gets a collection of all available {@link Fish} types.
     *
     * @return A collection of all fish types
     */
    Collection<Fish> getFishTypes();

    /**
     * Gets a {@link CookedFish} by name.
     *
     * @param name The name of the cooked fish type
     * @return The cooked fish type or Optional.absent() if not found
     */
    Optional<CookedFish> getCookedFishType(String name);

    /**
     * Gets a collection of all available {@link CookedFish}s.
     *
     * @return A collection of all cooked fish types
     */
    Collection<CookedFish> getCookedFishTypes();

    /**
     * Gets a {@link GoldenApple} by name.
     *
     * @param name The name of the golden apple type
     * @return The golden apple type or Optional.absent() if not found
     */
    Optional<GoldenApple> getGoldenAppleType(String name);

    /**
     * Gets a collection of all available {@link GoldenApple}s.
     *
     * @return A collection of all golden apple types
     */
    Collection<GoldenApple> getGoldenAppleTypes();

    /**
     * Gets a new {@link FireworkEffectBuilder}.
     *
     * @return A new firework effect builder
     */
    FireworkEffectBuilder getFireworkEffectBuilder();

    /**
     * Gets the {@link TextColor} with the provided name.
     *
     * @param name The name of the text color
     * @return The {@link TextColor} with the given name or Optional.absent() if not found
     */
    Optional<TextColor> getTextColor(String name);

    /**
     * Gets a {@link Collection} of all possible {@link TextColor}s.
     *
     * @return The collection of all available {@link TextColor}s
     */
    Collection<TextColor> getTextColors();

    /**
     * Gets the {@link TextStyle} with the provided name.
     *
     * @param name The name of the text style
     * @return The {@link TextStyle} with the given name or Optional.absent() if not found
     */
    Optional<TextStyle> getTextStyle(String name);

    /**
     * Gets a {@link Collection} of all possible {@link TextStyle}s.
     *
     * @return The collection of all available {@link TextStyle}s
     */
    Collection<TextStyle> getTextStyles();

    /**
     * Gets the {@link ChatType} with the provided name.
     *
     * @param name The name of the chat type
     * @return The {@link ChatType} with the given name or Optional.absent() if not found
     */
    Optional<ChatType> getChatType(String name);

    /**
     * Gets a {@link Collection} of all possible {@link TextStyle}s.
     *
     * @return The collection of all available {@link TextStyle}s
     */
    Collection<ChatType> getChatTypes();

    /**
     * Gets the {@link SelectorType} with the provided name.
     *
     * @param name The name of the selector type
     * @return The {@link SelectorType} with the given name or Optional.absent() if not found
     */
    Optional<SelectorType> getSelectorType(String name);

    /**
     * Gets a {@link Collection} of all possible {@link SelectorType}s.
     *
     * @return The list of all available {@link SelectorType}s
     */
    Collection<SelectorType> getSelectorTypes();

    /**
     * Gets the {@link ArgumentType} with the provided name.
     *
     * @param name The name of the argument type
     * @return The {@link ArgumentType} with the given name or Optional.absent() if not found
     */
    Optional<ArgumentType<?>> getArgumentType(String name);

    /**
     * Gets a {@link Collection} of all possible {@link ArgumentType}s.
     *
     * @return The list of all available {@link ArgumentType}s
     */
    Collection<ArgumentType<?>> getArgumentTypes();

    /**
     * Gets the {@link Locale} with the provided name.
     *
     * @param name The name of the locale
     * @return The {@link Locale} with the given name or Optional.absent() if not found
     */
    Optional<Locale> getLocale(String name);

    /**
     * Gets the {@link Locale} with the provided ID.
     *
     * @param id The ID of the locale
     * @return The {@link Locale} with the given ID or Optional.absent() if not found
     */
    Optional<Locale> getLocaleById(String id);

    /**
     * Gets a {@link Collection} of all possible {@link Locale}s.
     *
     * @return The collection of all available {@link Locale}s
     */
    Collection<Locale> getLocales();

    /**
     * Gets the {@link Translation} with the provided ID.
     *
     * @param id The ID of the translation
     * @return The {@link Translation} with the given ID or Optional.absent() if not found
     */
    Optional<Translation> getTranslationById(String id);

    /**
     * Gets a {@link ResourcePack} that's already been created by its ID.
     *
     * @param id The ID of the pack
     * @return The ResourcePack with the specified ID, or Optional.absent() if
     *         none could be found
     */
    Optional<ResourcePack> getById(String id);

}
