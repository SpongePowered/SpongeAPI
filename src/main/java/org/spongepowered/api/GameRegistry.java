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

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.meta.BannerPatternShape;
import org.spongepowered.api.block.meta.NotePitch;
import org.spongepowered.api.block.meta.SkullType;
import org.spongepowered.api.effect.particle.ParticleEffectBuilder;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.sound.SoundType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.hanging.art.Art;
import org.spongepowered.api.entity.living.animal.DyeColor;
import org.spongepowered.api.entity.living.animal.HorseColor;
import org.spongepowered.api.entity.living.animal.HorseStyle;
import org.spongepowered.api.entity.living.animal.HorseVariant;
import org.spongepowered.api.entity.living.animal.OcelotType;
import org.spongepowered.api.entity.living.animal.RabbitType;
import org.spongepowered.api.entity.living.monster.SkeletonType;
import org.spongepowered.api.entity.living.villager.Career;
import org.spongepowered.api.entity.living.villager.Profession;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStackBuilder;
import org.spongepowered.api.item.merchant.TradeOfferBuilder;
import org.spongepowered.api.item.recipe.RecipeRegistry;
import org.spongepowered.api.potion.PotionEffectBuilder;
import org.spongepowered.api.potion.PotionEffectType;
import org.spongepowered.api.stats.EntityStatistic;
import org.spongepowered.api.stats.EntityStatisticType;
import org.spongepowered.api.stats.GroupedStatistic;
import org.spongepowered.api.stats.ItemStatistic;
import org.spongepowered.api.stats.ItemStatisticType;
import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.stats.StatisticType;
import org.spongepowered.api.stats.StatisticUnit;
import org.spongepowered.api.stats.Statistics;
import org.spongepowered.api.stats.TeamStatistic;
import org.spongepowered.api.stats.TeamStatisticType;
import org.spongepowered.api.status.Favicon;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.biome.BiomeType;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
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
     * Gets the {@link Statistic} with the specified id.
     *
     * @param id The id of the statistic to return
     * @return The statistic with the given id or Optional.absent() if not found
     */
    Optional<? extends Statistic> getStatistic(String id);

    /**
     * Gets the {@link Statistic} for the given {@link EntityStatisticType} and
     * {@link EntityType}.
     *
     * @param statisticType The type of statistic to return
     * @param entityType The entity type for the statistic to return
     * @return The entity statistic matching the filter or Optional.absent() if
     *         not found
     */
    Optional<? extends EntityStatistic> getEntityStatistic(EntityStatisticType statisticType, EntityType entityType);

    /**
     * Gets the {@link Statistic} for the given {@link ItemStatisticType} and
     * {@link ItemType}.
     *
     * @param statisticType The type of statistic to return
     * @param itemType The item type for the statistic to return
     * @return The item statistic matching the filter or Optional.absent() if
     *         not found
     */
    Optional<? extends ItemStatistic> getItemStatistic(ItemStatisticType statisticType, ItemType itemType);

    /**
     * Gets the {@link Statistic} for the given {@link TeamStatisticType} and
     * team's {@link TextColor}.
     *
     * @param statisticType The type of statistic to return
     * @param teamColor The team's color for the statistic to return
     * @return The team statistic matching the filter or Optional.absent() if
     *         not found
     */
    Optional<? extends TeamStatistic> getTeamStatistic(TeamStatisticType statisticType, TextColor teamColor);

    /**
     * Gets a list of all available {@link Statistic}s that are not grouped.
     *
     * @return An immutable collection containing all statistics in registry
     *         that are not grouped
     * @see Statistics
     */
    Collection<? extends Statistic> getSimpleStatistics();

    /**
     * Gets a list of all available {@link GroupedStatistic}s with the given
     * {@link StatisticType}.
     *
     * @param statisticType The statisticType to return
     * @return An immutable collection containing all statistics in registry
     */
    Collection<? extends GroupedStatistic> getStatistics(StatisticType statisticType);

    /**
     * Gets a collection of all available {@link Statistic}s.
     *
     * @return An immutable collection containing all statistics in registry
     */
    Collection<? extends Statistic> getStatistics();

    /**
     * Registers a new simple {@link Statistic}.
     *
     * <p>
     * <b>Note:</b> Manually registered statistics have to be registered every
     * time the server starts, otherwise the value may be dropped. In addition
     * to that the value is not increased automatically so the plugin which
     * registered it has to increase the value on its own.
     * </p>
     *
     * @param id The id for the new statistic
     * @param unit The unit for the new statistic
     * @return The newly created or the existing statistic with the given id and
     *         unit
     * @throws IllegalArgumentException If a statistic with the given id already
     *             exists, but has a different unit
     * @throws IllegalArgumentException If subId contains invalid characters or
     *             starts or ends with a grouping char (usually '.')
     */
    Statistic registerSimpleStatistic(String id, StatisticUnit unit) throws IllegalArgumentException;

    /**
     * Registers a new {@link GroupedStatistic}. In order to create a new
     * instance of a grouped statistic, it is required to pass all required
     * information to initialize it. For more information which data are
     * required for the {@link StatisticType} see the different extending
     * interfaces and
     * {@link #registerStatisticType(String, StatisticUnit, Function, Class...)}
     * .
     *
     * <p>
     * <b>Note:</b> Manually registered statistics have to be registered every
     * time the server starts, otherwise the value may be dropped. In addition
     * to that the value is not increased automatically so the plugin which
     * registered it has to increase the value on its own.
     * </p>
     *
     * @param type The type for the new statistic
     * @param subId The id for the new statistic appended to the id of the
     *            statistic type
     * @param data The data that are required to create an instance of the
     *            specific statistic instance
     * @return The newly created or the existing statistic with the given id,
     *         unit and data
     * @throws IllegalArgumentException If a statistic with the given sub id
     *             already exists, but has a different unit or different data
     *             values
     * @throws IllegalArgumentException If subId contains invalid characters or
     *             starts or ends with a grouping char (usually '.') or data is
     *             missing some required values
     */
    Statistic registerGroupedStatistic(StatisticType type, String subId, Map<String, ?> data) throws IllegalArgumentException;

    /**
     * Registers a new {@link StatisticType} extending the given classes. All
     * getter methods are mapped to the according camel case data key.
     *
     * @param baseId The base id for all future {@link GroupedStatistic}
     *            connected to this type
     * @param unit The unit for the new statistic type
     * @param interfaces The interfaces this statistic type should implement
     * @return The newly created statistic type which implements the given
     *         interfaces
     * @throws IllegalArgumentException If a statistic type with the given base
     *             id already exists, but has a different unit or different
     *             classes
     * @throws IllegalArgumentException If baseId contains invalid characters or
     *             starts or ends with a grouping char (usually '.') or the
     *             provided classes are not supported
     */
    StatisticType registerStatisticType(String baseId, StatisticUnit unit, Class<? extends StatisticType>... interfaces) throws IllegalArgumentException;

    /**
     * Registers a new {@link StatisticType} extending the given classes. The
     * getter methods are mapped using the provided {@link Function}. If the
     * function returns null, then the camel case data key is used.
     *
     * @param baseId The base id for all future {@link GroupedStatistic}
     *            connected to this type
     * @param unit The unit for the new statistic type
     * @param methodMapper The method mapper that maps the interfaces' methods
     *            to data keys
     * @param interfaces The interfaces this statistic type should implement
     * @return The newly created statistic type which implements the given
     *         interfaces
     * @throws IllegalArgumentException If a statistic type with the given base
     *             id already exists, but has a different unit or different
     *             classes
     * @throws IllegalArgumentException If baseId contains invalid characters or
     *             starts or ends with a grouping char (usually '.') or the
     *             provided classes are not supported
     */
    StatisticType registerStatisticType(String baseId, StatisticUnit unit, Function<Method, String> methodMapper, Class<? extends StatisticType>... interfaces) throws IllegalArgumentException;;

    /**
     * Gets the {@link StatisticUnit} with the specified name.
     *
     * @param name The name of the statistic unit to return
     * @return The statistic unit with the given name or Optional.absent() if
     *         not found
     */
    Optional<? extends StatisticUnit> getStatisticUnit(String name);

    /**
     * Gets a collection of all available {@link StatisticUnit}s.
     *
     * @return An immutable collection containing all statistics units in
     *         registry
     */
    Collection<? extends StatisticUnit> getStatisticUnits();

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

}
