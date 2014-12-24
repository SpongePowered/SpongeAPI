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
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.effect.Particle;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.hanging.art.Art;
import org.spongepowered.api.entity.living.meta.DyeColor;
import org.spongepowered.api.entity.living.meta.HorseColor;
import org.spongepowered.api.entity.living.meta.HorseStyle;
import org.spongepowered.api.entity.living.meta.HorseVariant;
import org.spongepowered.api.entity.living.meta.OcelotType;
import org.spongepowered.api.entity.living.meta.RabbitType;
import org.spongepowered.api.entity.living.meta.SkeletonType;
import org.spongepowered.api.entity.living.villager.Career;
import org.spongepowered.api.entity.living.villager.Profession;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStackBuilder;
import org.spongepowered.api.item.merchant.TradeOfferBuilder;
import org.spongepowered.api.potion.PotionEffectBuilder;
import org.spongepowered.api.potion.PotionEffectType;
import org.spongepowered.api.world.Environment;
import org.spongepowered.api.world.biome.BiomeType;

import java.util.Collection;
import java.util.List;

/**
 * Provides an easy way to retrieve types from a {@link Game}.
 *
 * <p>Note that the registries may be in flux, especially during game
 * initialization. These will be accurate for the time they are called, however
 * they may change at a later point. Do not assume that the contents of a list
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
     * Gets a list of all available {@link BlockType}s.
     *
     * @return A list containing all block types in registry
     */
    List<BlockType> getBlocks();
 
    /**
     * Gets an {@link ItemType} by its identifier.
     *
     * @param id The id to look up
     * @return The item or Optional.absent() if not found
     */
    Optional<ItemType> getItem(String id);
 
    /**
     * Gets a list of all available {@link ItemType}s.
     *
     * @return A list containing all item types in registry
     */
    List<ItemType> getItems();

    /**
     * Gets a {@link BiomeType} by its identifier.
     *
     * @param id The id to look up
     * @return The biome or Optional.absent() if not found
     */
    Optional<BiomeType> getBiome(String id);

    /**
     * Gets a list of all available {@link BiomeType}s.
     *
     * @return A list containing all biome types
     */
    List<BiomeType> getBiomes();

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
     * Gets a {@link Particle} by id.
     *
     * @param id The particle id
     * @return The corresponding particle or Optional.absent() if not found
     */
    Optional<Particle> getParticle(String id);

    /**
     * Gets a list of all available {@link Particle}s.
     *
     * @return A list containing all item types in registry
     */
    List<Particle> getParticles();

    /**
     * Gets an {@link EntityType} by its identifier.
     *
     * @param id The id to look up
     * @return The entity type or Optional.absent() if not found
     */
    Optional<EntityType> getEntity(String id);

    /**
     * Gets a list of all available {@link EntityType}s.
     *
     * @return A list containing all item types in registry
     */
    List<EntityType> getEntities();

    /**
     * Gets an {@link Art} by its identifier.
     *
     * @param id The id to look up
     * @return The art piece or Optional.absent() if not found
     */
    Optional<Art> getArt(String id);

    /**
     * Gets a list of all available {@link Art} pieces.
     *
     * @return A list of all available art pieces
     */
    List<Art> getArts();

    /**
     * Gets an {@link DyeColor} by its identifier.
     *
     * @param id The id to look up
     * @return The dye color or Optional.absent() if not found
     */
    Optional<DyeColor> getDye(String id);

    /**
     * Gets a list of all available {@link DyeColor}s.
     *
     * @return A list containing all item types in registry
     */
    List<DyeColor> getDyes();

    /**
     * Gets an {@link HorseColor} by its identifier.
     *
     * @param id The id to look up
     * @return The horse color or Optional.absent() if not found
     */
    Optional<HorseColor> getHorseColor(String id);

    /**
     * Gets a list of all available {@link HorseColor}s.
     *
     * @return A list containing all item types in registry
     */
    List<HorseColor> getHorseColors();

    /**
     * Gets an {@link HorseStyle} by its identifier.
     *
     * @param id The id to look up
     * @return The horse style or Optional.absent() if not found
     */
    Optional<HorseStyle> getHorseStyle(String id);

    /**
     * Gets a list of all available {@link HorseStyle}s.
     *
     * @return A list containing all item types in registry
     */
    List<HorseStyle> getHorseStyles();

    /**
     * Gets an {@link HorseVariant} by its identifier.
     *
     * @param id The id to look up
     * @return The horse variant or Optional.absent() if not found
     */
    Optional<HorseVariant> getHorseVariant(String id);

    /**
     * Gets a list of all available {@link HorseVariant}s.
     *
     * @return A list containing all item types in registry
     */
    List<HorseVariant> getHorseVariants();

    /**
     * Gets an {@link OcelotType} by its identifier.
     *
     * @param id The id to look up
     * @return The ocelot type or Optional.absent() if not found
     */
    Optional<OcelotType> getOcelotType(String id);

    /**
     * Gets a list of all available {@link OcelotType}s.
     *
     * @return A list containing all item types in registry
     */
    List<OcelotType> getOcelotTypes();

    /**
     * Gets an {@link RabbitType} by its identifier.
     *
     * @param id The id to look up
     * @return The rabbit type or Optional.absent() if not found
     */
    Optional<RabbitType> getRabbitType(String id);

    /**
     * Gets a list of all available {@link RabbitType}s.
     *
     * @return A list containing all item types in registry
     */
    List<RabbitType> getRabbitTypes();

    /**
     * Gets an {@link SkeletonType} by its identifier.
     *
     * @param id The id to look up
     * @return The skeleton type or Optional.absent() if not found
     */
    Optional<SkeletonType> getSkeletonType(String id);

    /**
     * Gets a list of all available {@link SkeletonType}s.
     *
     * @return A list containing all item types in registry
     */
    List<SkeletonType> getSkeletonTypes();

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
     * @return A list of all villager careers
     */
    List<Career> getCareers();

    /**
     * Gets all available villager {@link Career}s for the given profession.
     *
     * @param profession The villager profession to list careers from
     * @return A list of all villager careers associated with the profession
     */
    List<Career> getCareers(Profession profession);

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
     * @return A list of all villager professions
     */
    List<Profession> getProfessions();

    /**
     * Gets a list of all available {@link GameMode}s.
     *
     * @return A list containing all item types in registry
     */
    // TODO: GameMode from string? Should add 'String getId()' to GameMode if so.
    List<GameMode> getGameModes();

    /**
     * Gets a list of all available {@link PotionEffectType}s.
     *
     * @return A list containing all item types in registry
     */
    // TODO: PotionEffectType from string? Should add 'String getId()' to PotionEffectType if so.
    List<PotionEffectType> getPotionEffects();

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
     * @return A list of all enchantments
     */
    List<Enchantment> getEnchantments();

    /**
     * Gets a {@link Collection} of the default GameRules.
     *
     * @return The default GameRules.
     */
    Collection<String> getDefaultGameRules();

    /**
     * Gets the {@link Environment} with the provided name. 
     *
     * @param name The name of the environment
     * @return The {@link Environment} with the given name or Optional.absent() if not found
     */
    Optional<Environment> getEnvironment(String name);

    /**
     * Gets the {@link Environment} with the provided id. 
     *
     * @param dimensionId The name of the environment
     * @return The {@link Environment} with the given dimensionId or Optional.absent() if not found
     */
    Optional<Environment> getEnvironment(int dimensionId);

    /**
     * Gets a {@link List} of all possible {@link Environment}s.
     *
     * @return The environment list
     */
    List<Environment> getEnvironments();

}
