/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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

/**
 * Represents the server.properties file
 */
public interface Properties {

    /**
     * Gets the generator-settings inside server.properties
     *
     * @return The generator settings
     */
    String getGeneratorSettings();

    /**
     * Gets the op-permission-level inside server.properties
     *
     * @return The op permission level
     */
    int getOpPermissionLevel();

    /**
     * Gets the level-name inside server.properties
     *
     * @return The level name
     */
    String getLevelName();

    /**
     * Gets the enable-query inside server.properties
     *
     * @return The boolean value of enable query
     */
    boolean getEnableQuery();

    /**
     * Gets the allow-flight inside server.properties
     *
     * @return the boolean value of allow flight
     */
    boolean getAllowFlight();

    /**
     * Gets the announce-player-achievements inside server.properties
     *
     * @return The boolean value of allow announce player achievements
     */
    boolean getAnnouncePlayerAchievements();

    /**
     * Gets the server-port inside server.properties
     *
     * @return The server port
     */
    int getServerPort();

    /**
     * Gets the level-type inside server.properties
     *
     * DEFAULT -  Standard world with hills, valleys, water, etc.
     * FLAT - A flat world with no features, meant for building.
     * LARGEBIOMES - Same as default but all biomes are larger
     * AMPLIFIED - Same as default but world-generation height limit is increased.
     * CUSTOMIZED - Generate a customized world in singleplayer and copy it to the server.(1.8)
     *
     * @return The level type
     */
    String getLevelType();

    /**
     * Gets the enable-rcon inside server.properties
     *
     * @return The boolean value of enable rcon
     */
    boolean getEnableRcon();

    /**
     * Gets the level-seed inside server.properties
     *
     * @return The level seed
     */
    String getLevelSeed();

    /**
     * Gets the force-gamemode inside server.properties
     *
     * @return The boolean value of allow force gamemode
     */
    boolean getForceGamemode();

    /**
     * Gets the server-ip inside server.properties
     *
     * @return The boolean value of server IP
     */
    String getServerIP();

    /**
     * Gets the max-build-height inside server.properties
     *
     * @return The max build height
     */
    int getMaxBuildHeight();

    /**
     * Gets the spawn-npcs inside server.properties
     *
     * @return The boolean value of spawn npcs
     */
    boolean getSpawnNpcs();

    /**
     * Gets the white-list inside server.properties
     *
     * @return The boolean value of whitelist enabled
     */
    boolean getWhitelist();

    /**
     * Gets the spawn-animals inside server.properties
     *
     * @return The boolean value of allow spawn animals
     */
    boolean getSpawnAnimals();

    /**
     * Gets the hardcore inside server.properties
     *
     * @return The boolean value of allow hardcore
     */
    boolean getHardcore();

    /**
     * Gets the snooper-enabled inside server.properties
     *
     * @return The boolean value of snooper enabled
     */
    boolean getSnooperEnabled();

    /**
     * Gets the online-mode inside server.properties
     *
     * @return The boolean value of allow online mode
     */
    boolean getOnlineMode();

    /**
     * Gets the resource-pack inside server.properties
     *
     * @return The URL of resource pack
     */
    String getResourcePack();

    /**
     * Gets the pvp inside server.properties
     *
     * @return The boolean value of allow pvp
     */
    boolean getPvp();

    /**
     * Gets the difficulty inside server.properties
     *
     * 0 - Peaceful.
     * 1 - Easy.
     * 2 - Normal.
     * 3 - Hard.
     *
     * @return The difficulty
     */
    int getDifficulty();

    /**
     * Gets the enable-command-block inside server.properties
     *
     * @return The boolean value of enable command block
     */
    boolean getEnableCommandBlock();

    /**
     * Gets the gamemode inside server.properties
     *
     * 0 - Survival.
     * 1 - Creative.
     * 2 - Adventure.
     * 3 - Spectate.(1.8)
     *
     * @return The gamemode
     */
    int getGamemode();

    /**
     * Gets the player-idle-timeout inside server.properties
     *
     * @return The player idle timeout
     */
    int getPlayerIdleTimeout();

    /**
     * Gets the max-players inside server.properties
     *
     * @return The max players
     */
    int getMaxPlayers();

    /**
     * Gets the spawn-monsters inside server.properties
     *
     * @return The boolean value of allow spawn monsters
     */
    boolean getSpawnMonsters();

    /**
     * Gets the generate-structures inside server.properties
     *
     * @return The boolean value of allow generate structures
     */
    boolean getGenerateStructures();

    /**
     * Gets the view-distance inside server.properties
     *
     * @return The view distance
     */
    int getViewDistance();

    /**
     * Gets the motd inside server.properties
     *
     * @return the motd
     */
    String getMotd();
}
