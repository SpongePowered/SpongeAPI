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

package org.spongepowered.api.event;

import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

import org.spongepowered.api.Game;
import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityInteractionType;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.entity.weather.Lightning;
import org.spongepowered.api.event.block.*;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.*;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.event.player.*;
import org.spongepowered.api.event.weather.LightningStrikeEvent;
import org.spongepowered.api.event.weather.WeatherChangeEvent;
import org.spongepowered.api.event.world.*;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.message.Message;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.event.factory.ClassGeneratorProvider;
import org.spongepowered.api.util.event.factory.EventFactory;
import org.spongepowered.api.util.event.factory.FactoryProvider;
import org.spongepowered.api.util.event.factory.NullPolicy;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.ChunkManager.LoadingTicket;
import org.spongepowered.api.world.extent.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.WeatherVolume;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Generates Sponge event implementations.
 */
@SuppressWarnings("ConstantConditions")
public final class SpongeEventFactory {

    private static final FactoryProvider factoryProvider;
    private static final LoadingCache<Class<?>, EventFactory<?>> factories;

    static {
        factoryProvider = new ClassGeneratorProvider("org.spongepowered.api.event.impl");
        factoryProvider.setNullPolicy(NullPolicy.NON_NULL_BY_DEFAULT);

        factories = CacheBuilder.newBuilder()
                .build(
                        new CacheLoader<Class<?>, EventFactory<?>>() {
                            public EventFactory<?> load(Class<?> type) {
                                return factoryProvider.create(type, AbstractEvent.class);
                            }
                        });
    }

    private SpongeEventFactory() {
    }

    @SuppressWarnings("unchecked")
    private static <T> T createEvent(Class<T> type, Map<String, Object> values) {
        return (T) factories.getUnchecked(type).apply(values);
    }

    public static BlockBreakEvent createBlockBreak(Game game, Cause cause, BlockLoc block, BlockSnapshot replacementBlock, int exp, Collection<Item> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        values.put("exp", exp);
        values.put("droppedItems", droppedItems);
        return createEvent(BlockBreakEvent.class, values);
    }

    public static BlockBurnEvent createBlockBurn(Game game, Cause cause, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockBurnEvent.class, values);
    }

    public static BlockChangeEvent createBlockChange(Game game, Cause cause, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockChangeEvent.class, values);
    }

    public static BlockDispenseEvent createBlockDispense(Game game, Cause cause, BlockLoc block, Vector3d velocity, ItemStack dispensedItem) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("velocity", velocity);
        values.put("dispensedItem", dispensedItem);
        return createEvent(BlockDispenseEvent.class, values);
    }

    public static BlockIgniteEvent createBlockIgnite(Game game, Cause cause, BlockLoc block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        return createEvent(BlockIgniteEvent.class, values);
    }

    public static BlockInteractEvent createBlockInteract(Game game, Cause cause, BlockLoc block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        return createEvent(BlockInteractEvent.class, values);
    }

    public static BlockMoveEvent createBlockMove(Game game, Cause cause, List<BlockLoc> blocks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("blocks", blocks);
        return createEvent(BlockMoveEvent.class, values);
    }

    public static BlockPlaceEvent createBlockPlace(Game game, Cause cause, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockPlaceEvent.class, values);
    }

    public static BlockRandomTickEvent createBlockRandomTick(Game game, Cause cause, BlockLoc block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        return createEvent(BlockRandomTickEvent.class, values);
    }

    public static BlockUpdateEvent createBlockUpdate(Game game, Cause cause, BlockLoc block, BlockType causeBlockType) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("causeBlockType", causeBlockType);
        return createEvent(BlockUpdateEvent.class, values);
    }

    public static FloraGrowEvent createFloraGrow(Game game, Cause cause, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(FloraGrowEvent.class, values);
    }

    public static FluidSpreadEvent createFluidSpread(Game game, Cause cause, List<BlockLoc> blocks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("blocks", blocks);
        return createEvent(FluidSpreadEvent.class, values);
    }

    public static LeafDecayEvent createLeafDecay(Game game, Cause cause, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(LeafDecayEvent.class, values);
    }

    public static EntityBreakBlockEvent createEntityBreakBlock(Game game, Cause cause, Entity entity, BlockLoc block, BlockSnapshot replacementBlock, int exp, Collection<Item> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        values.put("replacementBlock", replacementBlock);
        values.put("exp", exp);
        values.put("droppedItems", droppedItems);
        return createEvent(EntityBreakBlockEvent.class, values);
    }

    public static EntityChangeBlockEvent createEntityChangeBlock(Game game, Cause cause, Entity entity, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        values.put("replacementBlock", replacementBlock);
        return createEvent(EntityChangeBlockEvent.class, values);
    }

    public static EntityChangeHealthEvent createEntityChangeHealth(Game game, Cause cause, Entity entity, double newHealth, double oldHealth) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("newHealth", newHealth);
        values.put("oldHealth", oldHealth);
        return createEvent(EntityChangeHealthEvent.class, values);
    }

    public static EntityCollisionEvent createEntityCollision(Game game, Cause cause, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        return createEvent(EntityCollisionEvent.class, values);
    }

    public static EntityCollisionWithBlockEvent createEntityCollisionWithBlock(Game game, Cause cause, Entity entity, BlockLoc block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        return createEvent(EntityCollisionWithBlockEvent.class, values);
    }

    public static EntityCollisionWithEntityEvent createEntityCollisionWithEntity(Game game, Cause cause, Entity entity, Entity collided) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("collided", collided);
        return createEvent(EntityCollisionWithEntityEvent.class, values);
    }

    public static EntityDeathEvent createEntityDeath(Game game, Cause cause, Entity entity, Collection<Item> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("droppedItems", droppedItems);
        return createEvent(EntityDeathEvent.class, values);
    }

    public static EntityDismountEvent createEntityDismount(Game game, Entity entity, Entity dismounted) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("dismounted", dismounted);
        return createEvent(EntityDismountEvent.class, values);
    }

    public static EntityDropItemEvent createEntityDropItem(Game game, Entity entity, Collection<ItemStack> droppedStacks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("droppedItems", droppedStacks);
        return createEvent(EntityDropItemEvent.class, values);
    }

    public static EntityInteractBlockEvent createEntityInteractBlock(Game game, Cause cause, Entity entity, BlockLoc block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        return createEvent(EntityInteractBlockEvent.class, values);
    }

    public static EntityInteractEntityEvent createEntityInteractEntity(Game game, Entity entity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("targetEntity", targetEntity);
        return createEvent(EntityInteractEntityEvent.class, values);
    }

    public static EntityInteractEvent createEntityInteract(Game game, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        return createEvent(EntityInteractEvent.class, values);
    }

    public static EntityMountEvent createEntityMount(Game game, Entity entity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("vehicle", vehicle);
        return createEvent(EntityMountEvent.class, values);
    }

    public static EntityMoveEvent createEntityMove(Game game, Entity entity, Location oldLocation, Location newLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        return createEvent(EntityMoveEvent.class, values);
    }

    public static EntityPickUpItemEvent createEntityPickUpItem(Game game, Entity entity, Collection<Entity> items) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("items", items);
        return createEvent(EntityPickUpItemEvent.class, values);
    }

    public static EntityPlaceBlockEvent createEntityPlaceBlock(Game game, Cause cause, Entity entity, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        values.put("replacementBlock", replacementBlock);
        return createEvent(EntityPlaceBlockEvent.class, values);
    }

    public static EntitySpawnEvent createEntitySpawn(Game game, Entity entity, Location location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("location", location);
        return createEvent(EntitySpawnEvent.class, values);
    }

    public static EntityTameEvent createEntityTame(Game game, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        return createEvent(EntityTameEvent.class, values);
    }

    public static EntityTeleportEvent createEntityTeleport(Game game, Cause cause, Entity entity, Location oldLocation, Location newLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        return createEvent(EntityTeleportEvent.class, values);
    }

    public static EntityUpdateEvent createEntityUpdate(Game game, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        return createEvent(EntityUpdateEvent.class, values);
    }

    public static ProjectileLaunchEvent createProjectileLaunch(Game game, Cause cause, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        return createEvent(ProjectileLaunchEvent.class, values);
    }

    public static CommandEvent createCommand(Game game, String arguments, CommandSource source, String command) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("arguments", arguments);
        values.put("source", source);
        values.put("command", command);
        return createEvent(CommandEvent.class, values);
    }

    public static MessageEvent createMessage(Game game, CommandSource source, String message) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        values.put("message", message);
        return createEvent(MessageEvent.class, values);
    }

    public static PlayerBreakBlockEvent createPlayerBreakBlock(Game game, Cause cause, Player player, BlockLoc block, BlockSnapshot replacementBlock, int exp, Collection<Item> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("replacementBlock", replacementBlock);
        values.put("exp", exp);
        values.put("player", player);
        values.put("droppedItems", droppedItems);
        return createEvent(PlayerBreakBlockEvent.class, values);
    }

    public static PlayerChangeBlockEvent createPlayerChangeBlock(Game game, Cause cause, Player player, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("replacementBlock", replacementBlock);
        values.put("player", player);
        return createEvent(PlayerChangeBlockEvent.class, values);
    }

    public static PlayerChangeGameModeEvent createPlayerChangeGameMode(Game game, Player player, GameMode newGameMode, GameMode oldGameMode) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("newGameMode", newGameMode);
        values.put("oldGameMode", oldGameMode);
        values.put("player", player);
        return createEvent(PlayerChangeGameModeEvent.class, values);
    }

    public static PlayerChangeWorldEvent createPlayerChangeWorld(Game game, Player player, World fromWorld, World toWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("fromWorld", fromWorld);
        values.put("toWorld", toWorld);
        values.put("player", player);
        return createEvent(PlayerChangeWorldEvent.class, values);
    }

    public static PlayerChatEvent createPlayerChat(Game game, Player player, CommandSource source, String message) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("source", source);
        values.put("message", message);
        values.put("player", player);
        return createEvent(PlayerChatEvent.class, values);
    }

    public static PlayerDeathEvent createPlayerDeath(Game game, Cause cause, Player player, Message deathMessage, Collection<Item> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", player);
        values.put("deathMessage", deathMessage);
        values.put("player", player);
        values.put("droppedItems", droppedItems);
        return createEvent(PlayerDeathEvent.class, values);
    }

    public static PlayerDropItemEvent createPlayerDropItem(Game game, Player player, Collection<ItemStack> droppedStacks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("droppedItems", droppedStacks);
        values.put("player", player);
        return createEvent(PlayerDropItemEvent.class, values);
    }

    public static PlayerInteractBlockEvent createPlayerInteractBlock(Game game, Cause cause, Player player, BlockLoc block, EntityInteractionType interactionType) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("interactionType", interactionType);
        values.put("player", player);
        return createEvent(PlayerInteractBlockEvent.class, values);
    }

    public static PlayerInteractEntityEvent createPlayerInteractEntity(Game game, Player player, Entity targetEntity, EntityInteractionType interactionType) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("targetEntity", targetEntity);
        values.put("interactionType", interactionType);
        values.put("player", player);
        return createEvent(PlayerInteractEntityEvent.class, values);
    }

    public static PlayerInteractEvent createPlayerInteract(Game game, Player player, EntityInteractionType interactionType) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("interactionType", interactionType);
        values.put("player", player);
        return createEvent(PlayerInteractEvent.class, values);
    }

    public static PlayerJoinEvent createPlayerJoin(Game game, Player player, Message joinMessage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("joinMessage", joinMessage);
        values.put("player", player);
        return createEvent(PlayerJoinEvent.class, values);
    }

    public static PlayerMoveEvent createPlayerMove(Game game, Player player, Location oldLocation, Location newLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("player", player);
        return createEvent(PlayerMoveEvent.class, values);
    }

    public static PlayerPickUpItemEvent createPlayerPickUpItem(Game game, Player player, Collection<Entity> items) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("items", items);
        values.put("player", player);
        return createEvent(PlayerPickUpItemEvent.class, values);
    }

    public static PlayerPlaceBlockEvent createPlayerPlaceBlock(Game game, Cause cause, Player player, BlockLoc block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("replacementBlock", replacementBlock);
        values.put("player", player);
        return createEvent(PlayerPlaceBlockEvent.class, values);
    }

    public static PlayerQuitEvent createPlayerQuit(Game game, Player player, Message quitMessage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("quitMessage", quitMessage);
        values.put("player", player);
        return createEvent(PlayerQuitEvent.class, values);
    }

    public static PlayerUpdateEvent createPlayerUpdate(Game game, Player player) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("player", player);
        return createEvent(PlayerUpdateEvent.class, values);
    }

    public static LightningStrikeEvent createLightningStrike(Game game, WeatherVolume weatherVolume, Lightning lightningStrike, List<Entity> struckEntities, List<BlockLoc> struckBlocks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("lightningStrike", lightningStrike);
        values.put("weatherVolume", weatherVolume);
        values.put("struckEntities", struckEntities);
        values.put("struckBlocks", struckBlocks);
        return createEvent(LightningStrikeEvent.class, values);
    }

    public static WeatherChangeEvent createWeatherChange(Game game, WeatherVolume weatherVolume, Weather initialWeather, Weather resultingWeather) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("initialWeather", initialWeather);
        values.put("weatherVolume", weatherVolume);
        values.put("resultingWeather", resultingWeather);
        return createEvent(WeatherChangeEvent.class, values);
    }

    public static ChunkForcedEvent createChunkForced(Game game, LoadingTicket ticket, Vector2i chunkCoords) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("ticket", ticket);
        values.put("chunkCoords", chunkCoords);
        return createEvent(ChunkForcedEvent.class, values);
    }

    public static ChunkLoadEvent createChunkLoad(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkLoadEvent.class, values);
    }

    public static ChunkPostGenerateEvent createChunkPostGenerate(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkPostGenerateEvent.class, values);
    }

    public static ChunkPostPopulateEvent createChunkPostPopulate(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkPostPopulateEvent.class, values);
    }

    public static ChunkPreGenerateEvent createChunkPreGenerate(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkPreGenerateEvent.class, values);
    }

    public static ChunkPrePopulateEvent createChunkPrePopulate(Game game, Chunk chunk, Iterable<Populator> pendingPopulators) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        values.put("pendingPopulators", pendingPopulators);
        return createEvent(ChunkPrePopulateEvent.class, values);
    }

    public static ChunkUnforcedEvent createChunkUnforced(Game game, Vector2i chunkCoords, LoadingTicket ticket) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("ticket", ticket);
        values.put("chunkCoords", chunkCoords);
        return createEvent(ChunkUnforcedEvent.class, values);
    }

    public static ChunkUnloadEvent createChunkUnload(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkUnloadEvent.class, values);
    }

    public static GameRuleChangeEvent createGameRuleChange(Game game, World world, String name, String oldValue, String newValue) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", world);
        values.put("newValue", newValue);
        values.put("name", name);
        values.put("oldValue", oldValue);
        return createEvent(GameRuleChangeEvent.class, values);
    }

    public static WorldLoadEvent createWorldLoad(Game game, World world) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", world);
        return createEvent(WorldLoadEvent.class, values);
    }

    public static WorldUnloadEvent createWorldUnload(Game game, World world) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", world);
        return createEvent(WorldUnloadEvent.class, values);
    }

}
