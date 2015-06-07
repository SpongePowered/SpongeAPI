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

import com.google.common.base.Optional;
import org.spongepowered.api.data.DataManipulatorRegistry;
import org.spongepowered.api.data.ImmutableDataRegistry;
import org.spongepowered.api.data.type.Career;
import org.spongepowered.api.data.type.Profession;
import org.spongepowered.api.util.factory.Factory;
import org.spongepowered.api.item.recipe.RecipeRegistry;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.status.Favicon;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
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
     * Attempts to retrieve the specific type of {@link CatalogType} based on
     * the string id given.
     *
     * <p>Some types may not be available for various reasons including but not
     * restricted to: mods adding custom types, plugins providing custom types,
     * game version changes.</p>
     *
     * @param typeClass The class of the type of {@link CatalogType}
     * @param id The string id of the catalog type
     * @param <T> The type of catalog type
     * @return The found catalog type, if available
     */
    <T extends CatalogType> Optional<T> getType(Class<T> typeClass, String id);

    /**
     * Gets a collection of all available found specific types of
     * {@link CatalogType} requested.
     *
     * <p>The presented {@link CatalogType}s may not exist in default catalogs
     * due to various reasons including but not restricted to: mods, plugins,
     * game changes.</p>
     *
     * @param typeClass The class of {@link CatalogType}
     * @param <T> The type of {@link CatalogType}
     * @return A collection of all known types of the requested catalog type
     */
    <T extends CatalogType> Collection<T> getAllOf(Class<T> typeClass);

    /**
     * Gets an instance of the provided {@link Factory} class.
     *
     * @param factoryClass The class of the type of {@link Factory}
     * @param <T> The type of {@link Factory}
     * @return An instance of the requested factory type
     */
    <T extends Factory> T getFactory(Class<T> factoryClass);

    /**
     * Gets all available villager {@link Career}s for the given profession.
     *
     * @param profession The villager profession to collection careers from
     * @return A collection of all villager careers associated with the profession
     */
    Collection<Career> getCareers(Profession profession);

    /**
     * Gets a {@link Collection} of the default GameRules.
     *
     * @return The default GameRules.
     */
    Collection<String> getDefaultGameRules();



    /**
     * Gets the {@link Rotation} with the provided degrees.
     *
     * @param degrees The degrees of the rotation
     * @return The {@link Rotation} with the given degrees or Optional.absent() if not found
     */
    Optional<Rotation> getRotationFromDegree(int degrees);

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
     * Retrieves the {@link DataManipulatorRegistry} for this {@link GameRegistry}.
     *
     * @return The manipulator registry
     */
    DataManipulatorRegistry getManipulatorRegistry();

    /**
     * Retrieves the {@link ImmutableDataRegistry} for this {@link GameRegistry}.
     *
     * @return The immutable data registry
     */
    ImmutableDataRegistry getImmutableDataRegistry();

    /**
     * Gets a {@link ResourcePack} that's already been created by its ID.
     *
     * @param id The ID of the pack
     * @return The ResourcePack with the specified ID, or Optional.absent() if
     *         none could be found
     */
    Optional<ResourcePack> getById(String id);

    /**
     * Gets a {@link DisplaySlot} which displays only for teams
     * with the provided color.
     *
     * @param color The color for the display slot
     * @return The {@link DisplaySlot} with the provided color, or Optional.absent() if not found
     */
    Optional<DisplaySlot> getDisplaySlotForColor(TextColor color);

    /**
     * Registers a {@link WorldGeneratorModifier}, so that the server is able to
     * use it for modifying the world generator of a new world.
     *
     * @param modifier The modifier to register
     */
    void registerWorldGeneratorModifier(WorldGeneratorModifier modifier);

    /**
     * Gets the {@link Translation} with the provided ID.
     *
     * @param id The ID of the translation
     * @return The {@link Translation} with the given ID or Optional.absent() if not found
     */
    Optional<Translation> getTranslationById(String id);
}
