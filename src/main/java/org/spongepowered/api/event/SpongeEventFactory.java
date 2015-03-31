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

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import org.spongepowered.api.Game;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.tile.carrier.BrewingStand;
import org.spongepowered.api.block.tile.carrier.Furnace;
import org.spongepowered.api.block.tile.carrier.TileEntityCarrier;
import org.spongepowered.api.block.tile.data.BrewingData;
import org.spongepowered.api.block.tile.data.FurnaceData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityInteractionType;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.entity.weather.Lightning;
import org.spongepowered.api.event.block.BlockBreakEvent;
import org.spongepowered.api.event.block.BlockBurnEvent;
import org.spongepowered.api.event.block.BlockChangeEvent;
import org.spongepowered.api.event.block.BlockDispenseEvent;
import org.spongepowered.api.event.block.BlockHarvestEvent;
import org.spongepowered.api.event.block.BlockIgniteEvent;
import org.spongepowered.api.event.block.BlockInteractEvent;
import org.spongepowered.api.event.block.BlockMoveEvent;
import org.spongepowered.api.event.block.BlockPlaceEvent;
import org.spongepowered.api.event.block.BlockRandomTickEvent;
import org.spongepowered.api.event.block.BlockUpdateEvent;
import org.spongepowered.api.event.block.FloraGrowEvent;
import org.spongepowered.api.event.block.FluidSpreadEvent;
import org.spongepowered.api.event.block.LeafDecayEvent;
import org.spongepowered.api.event.block.tile.BrewingStandBrewEvent;
import org.spongepowered.api.event.block.tile.FurnaceConsumeFuelEvent;
import org.spongepowered.api.event.block.tile.FurnaceSmeltItemEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.EntityBreakBlockEvent;
import org.spongepowered.api.event.entity.EntityChangeBlockEvent;
import org.spongepowered.api.event.entity.EntityChangeHealthEvent;
import org.spongepowered.api.event.entity.EntityCollisionEvent;
import org.spongepowered.api.event.entity.EntityCollisionWithBlockEvent;
import org.spongepowered.api.event.entity.EntityCollisionWithEntityEvent;
import org.spongepowered.api.event.entity.EntityConstructingEvent;
import org.spongepowered.api.event.entity.EntityDeathEvent;
import org.spongepowered.api.event.entity.EntityDismountEvent;
import org.spongepowered.api.event.entity.EntityDisplaceEvent;
import org.spongepowered.api.event.entity.EntityDropItemEvent;
import org.spongepowered.api.event.entity.EntityHarvestBlockEvent;
import org.spongepowered.api.event.entity.EntityInteractBlockEvent;
import org.spongepowered.api.event.entity.EntityInteractEntityEvent;
import org.spongepowered.api.event.entity.EntityInteractEvent;
import org.spongepowered.api.event.entity.EntityMountEvent;
import org.spongepowered.api.event.entity.EntityMoveEvent;
import org.spongepowered.api.event.entity.EntityPickUpItemEvent;
import org.spongepowered.api.event.entity.EntityPlaceBlockEvent;
import org.spongepowered.api.event.entity.EntitySpawnEvent;
import org.spongepowered.api.event.entity.EntityTameEvent;
import org.spongepowered.api.event.entity.EntityTeleportEvent;
import org.spongepowered.api.event.entity.EntityUpdateEvent;
import org.spongepowered.api.event.entity.ProjectileLaunchEvent;
import org.spongepowered.api.event.entity.player.PlayerBreakBlockEvent;
import org.spongepowered.api.event.entity.player.PlayerChangeBlockEvent;
import org.spongepowered.api.event.entity.player.PlayerChangeGameModeEvent;
import org.spongepowered.api.event.entity.player.PlayerChangeWorldEvent;
import org.spongepowered.api.event.entity.player.PlayerChatEvent;
import org.spongepowered.api.event.entity.player.PlayerDeathEvent;
import org.spongepowered.api.event.entity.player.PlayerDropItemEvent;
import org.spongepowered.api.event.entity.player.PlayerHarvestBlockEvent;
import org.spongepowered.api.event.entity.player.PlayerInteractBlockEvent;
import org.spongepowered.api.event.entity.player.PlayerInteractEntityEvent;
import org.spongepowered.api.event.entity.player.PlayerInteractEvent;
import org.spongepowered.api.event.entity.player.PlayerJoinEvent;
import org.spongepowered.api.event.entity.player.PlayerMoveEvent;
import org.spongepowered.api.event.entity.player.PlayerPickUpItemEvent;
import org.spongepowered.api.event.entity.player.PlayerPlaceBlockEvent;
import org.spongepowered.api.event.entity.player.PlayerQuitEvent;
import org.spongepowered.api.event.entity.player.PlayerUpdateEvent;
import org.spongepowered.api.event.entity.player.fishing.PlayerCastFishingLineEvent;
import org.spongepowered.api.event.entity.player.fishing.PlayerHookedEntityEvent;
import org.spongepowered.api.event.entity.player.fishing.PlayerRetractFishingLineEvent;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.event.server.StatusPingEvent;
import org.spongepowered.api.event.stats.AchievementEvent;
import org.spongepowered.api.event.stats.StatisticChangeEvent;
import org.spongepowered.api.event.weather.LightningStrikeEvent;
import org.spongepowered.api.event.weather.WeatherChangeEvent;
import org.spongepowered.api.event.world.ChunkForcedEvent;
import org.spongepowered.api.event.world.ChunkLoadEvent;
import org.spongepowered.api.event.world.ChunkPostGenerateEvent;
import org.spongepowered.api.event.world.ChunkPostPopulateEvent;
import org.spongepowered.api.event.world.ChunkPreGenerateEvent;
import org.spongepowered.api.event.world.ChunkPrePopulateEvent;
import org.spongepowered.api.event.world.ChunkUnforcedEvent;
import org.spongepowered.api.event.world.ChunkUnloadEvent;
import org.spongepowered.api.event.world.GameRuleChangeEvent;
import org.spongepowered.api.event.world.WorldLoadEvent;
import org.spongepowered.api.event.world.WorldUnloadEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.types.TileEntityInventory;
import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.stats.achievement.Achievement;
import org.spongepowered.api.status.StatusClient;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.event.factory.ClassGeneratorProvider;
import org.spongepowered.api.util.event.factory.EventFactory;
import org.spongepowered.api.util.event.factory.FactoryProvider;
import org.spongepowered.api.util.event.factory.NullPolicy;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.ChunkManager.LoadingTicket;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.WeatherUniverse;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Generates Sponge event implementations.
 */
public final class SpongeEventFactory {

    private static final FactoryProvider factoryProvider;
    private static final LoadingCache<Class<?>, EventFactory<?>> factories;

    static {
        factoryProvider = new ClassGeneratorProvider("org.spongepowered.api.event.impl");
        factoryProvider.setNullPolicy(NullPolicy.NON_NULL_BY_DEFAULT);

        factories = CacheBuilder.newBuilder()
                .build(
                        new CacheLoader<Class<?>, EventFactory<?>>() {
                            @Override
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

    /**
     * Creates a new {@link BlockBreakEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static BlockBreakEvent createBlockBreak(Game game, Cause cause, Location block, BlockSnapshot replacementBlock, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        values.put("exp", exp);
        return createEvent(BlockBreakEvent.class, values);
    }

    /**
     * Creates a new {@link BlockBurnEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockBurnEvent createBlockBurn(Game game, Cause cause, Location block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockBurnEvent.class, values);
    }

    /**
     * Creates a new {@link BlockChangeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockChangeEvent createBlockChange(Game game, Cause cause, Location block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockChangeEvent.class, values);
    }

    /**
     * Creates a new {@link BlockDispenseEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param velocity The velocity to dispense the item at
     * @param dispensedItem The item to dispense from the block
     * @return A new instance of the event
     */
    public static BlockDispenseEvent createBlockDispense(Game game, Cause cause, Location block, Vector3d velocity, ItemStack dispensedItem) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("velocity", velocity);
        values.put("dispensedItem", dispensedItem);
        return createEvent(BlockDispenseEvent.class, values);
    }

    /**
     * Creates a new {@link BlockHarvestEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param droppedItems The items to drop
     * @param dropChance The chance the items will drop, see
     *        {@link BlockHarvestEvent#setDropChance(float)}
     * @return A new instance of the event
     */
    public static BlockHarvestEvent createBlockHarvest(Game game, Cause cause, Location block, Collection<Item> droppedItems, float dropChance) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("droppedItems", droppedItems);
        values.put("dropChance", dropChance);
        return createEvent(BlockHarvestEvent.class, values);
    }

    /**
     * Creates a new {@link BlockIgniteEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @return A new instance of the event
     */
    public static BlockIgniteEvent createBlockIgnite(Game game, Cause cause, Location block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        return createEvent(BlockIgniteEvent.class, values);
    }

    /**
     * Creates a new {@link BlockInteractEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @return A new instance of the event
     */
    public static BlockInteractEvent createBlockInteract(Game game, Cause cause, Location block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        return createEvent(BlockInteractEvent.class, values);
    }

    /**
     * Creates a new {@link BlockMoveEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param blocks The blocks affected by this event
     * @return A new instance of the event
     */
    public static BlockMoveEvent createBlockMove(Game game, Cause cause, List<Location> blocks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("blocks", blocks);
        return createEvent(BlockMoveEvent.class, values);
    }

    /**
     * Creates a new {@link BlockPlaceEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockPlaceEvent createBlockPlace(Game game, Cause cause, Location block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockPlaceEvent.class, values);
    }

    /**
     * Creates a new {@link BlockRandomTickEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @return A new instance of the event
     */
    public static BlockRandomTickEvent createBlockRandomTick(Game game, Cause cause, Location block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        return createEvent(BlockRandomTickEvent.class, values);
    }

    /**
     * Creates a new {@link BlockUpdateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param affectedBlocks The blocks affeceted by the event
     * @return A new instance of the event
     */
    public static BlockUpdateEvent createBlockUpdate(Game game, Cause cause, Location block, Collection<Location> affectedBlocks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("affectedBlocks", affectedBlocks);
        return createEvent(BlockUpdateEvent.class, values);
    }

    /**
     * Creates a new {@link FloraGrowEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static FloraGrowEvent createFloraGrow(Game game, Cause cause, Location block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(FloraGrowEvent.class, values);
    }

    /**
     * Creates a new {@link FluidSpreadEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param blocks The blocks affected by this event
     * @return A new instance of the event
     */
    public static FluidSpreadEvent createFluidSpread(Game game, Cause cause, List<Location> blocks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("blocks", blocks);
        return createEvent(FluidSpreadEvent.class, values);
    }

    /**
     * Creates a new {@link LeafDecayEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static LeafDecayEvent createLeafDecay(Game game, Cause cause, Location block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(LeafDecayEvent.class, values);
    }

    /**
     * Creates a new {@link EntityBreakBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static EntityBreakBlockEvent createEntityBreakBlock(Game game, Cause cause, Entity entity, Location block, BlockSnapshot replacementBlock,
            int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        values.put("replacementBlock", replacementBlock);
        values.put("exp", exp);
        return createEvent(EntityBreakBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityChangeBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static EntityChangeBlockEvent createEntityChangeBlock(Game game, Cause cause, Entity entity, Location block,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        values.put("replacementBlock", replacementBlock);
        return createEvent(EntityChangeBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityChangeHealthEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param newHealth The entity's new health
     * @param oldHealth The entity's old health
     * @return A new instance of the event
     */
    public static EntityChangeHealthEvent createEntityChangeHealth(Game game, Cause cause, Entity entity, double newHealth, double oldHealth) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("newHealth", newHealth);
        values.put("oldHealth", oldHealth);
        return createEvent(EntityChangeHealthEvent.class, values);
    }

    /**
     * Creates a new {@link EntityCollisionEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @return A new instance of the event
     */
    public static EntityCollisionEvent createEntityCollision(Game game, Cause cause, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        return createEvent(EntityCollisionEvent.class, values);
    }

    /**
     * Creates a new {@link EntityCollisionWithBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param block The block affected by this event
     * @return A new instance of the event
     */
    public static EntityCollisionWithBlockEvent createEntityCollisionWithBlock(Game game, Cause cause, Entity entity, Location block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        return createEvent(EntityCollisionWithBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityCollisionWithEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param collided The entity that was collided with
     * @return A new instance of the event
     */
    public static EntityCollisionWithEntityEvent createEntityCollisionWithEntity(Game game, Cause cause, Entity entity, Entity collided) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("collided", collided);
        return createEvent(EntityCollisionWithEntityEvent.class, values);
    }

    /**
     * Creates a new {@link EntityDeathEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param location The location of death
     * @param droppedItems The items to drop
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static EntityDeathEvent createEntityDeath(Game game, Cause cause, Entity entity, Location location, Collection<Item> droppedItems,
            int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("droppedItems", droppedItems);
        values.put("location", location);
        values.put("exp", exp);
        return createEvent(EntityDeathEvent.class, values);
    }

    /**
     * Creates a new {@link EntityDismountEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param dismounted The entity being dismounted from
     * @return A new instance of the event
     */
    public static EntityDismountEvent createEntityDismount(Game game, Entity entity, Entity dismounted) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("dismounted", dismounted);
        return createEvent(EntityDismountEvent.class, values);
    }

    /**
     * Creates a new {@link EntityDisplaceEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @return A new instance of the event
     */
    public static EntityDisplaceEvent createEntityDisplace(Game game, Entity entity,
            Location oldLocation, Location newLocation, Vector3d rotation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("rotation", rotation);
        return createEvent(EntityDisplaceEvent.class, values);
    }

    /**
     * Creates a new {@link EntityDropItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param droppedItems The items to drop
     * @return A new instance of the event
     */
    public static EntityDropItemEvent createEntityDropItem(Game game, Entity entity, Collection<Item> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("droppedItems", droppedItems);
        return createEvent(EntityDropItemEvent.class, values);
    }

    /**
     * Creates a new {@link EntityHarvestBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param block The block affected by this event
     * @param droppedItems The items to drop
     * @param dropChance The chance the items will drop, see
     *        {@link BlockHarvestEvent#setDropChance(float)}
     * @return A new instance of the event
     */
    public static EntityHarvestBlockEvent createEntityHarvestBlock(Game game, Cause cause, Entity entity, Location block,
            Collection<Item> droppedItems, float dropChance) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        values.put("droppedItems", droppedItems);
        values.put("dropChance", dropChance);
        return createEvent(EntityHarvestBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityInteractBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param block The block affected by this event
     * @return A new instance of the event
     */
    public static EntityInteractBlockEvent createEntityInteractBlock(Game game, Cause cause, Entity entity, Location block) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        return createEvent(EntityInteractBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityInteractEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param targetEntity The entity being interacted with
     * @return A new instance of the event
     */
    public static EntityInteractEntityEvent createEntityInteractEntity(Game game, Entity entity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("targetEntity", targetEntity);
        return createEvent(EntityInteractEntityEvent.class, values);
    }

    /**
     * Creates a new {@link EntityInteractEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @return A new instance of the event
     */
    public static EntityInteractEvent createEntityInteract(Game game, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        return createEvent(EntityInteractEvent.class, values);
    }

    /**
     * Creates a new {@link EntityMountEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param vehicle The entity being mounted
     * @return A new instance of the event
     */
    public static EntityMountEvent createEntityMount(Game game, Entity entity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("vehicle", vehicle);
        return createEvent(EntityMountEvent.class, values);
    }

    /**
     * Creates a new {@link EntityMoveEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @return A new instance of the event
     */
    public static EntityMoveEvent createEntityMove(Game game, Entity entity,
            Location oldLocation, Location newLocation, Vector3d rotation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("rotation", rotation);
        return createEvent(EntityMoveEvent.class, values);
    }

    /**
     * Creates a new {@link EntityPickUpItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param items The items that will be picked up
     * @return A new instance of the event
     */
    public static EntityPickUpItemEvent createEntityPickUpItem(Game game, Entity entity, Collection<Entity> items) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("items", items);
        return createEvent(EntityPickUpItemEvent.class, values);
    }

    /**
     * Creates a new {@link EntityPlaceBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static EntityPlaceBlockEvent createEntityPlaceBlock(Game game, Cause cause, Entity entity, Location block,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", entity);
        values.put("replacementBlock", replacementBlock);
        return createEvent(EntityPlaceBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntitySpawnEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param location The location the entity will spawn at
     * @return A new instance of the event
     */
    public static EntitySpawnEvent createEntitySpawn(Game game, Entity entity, Location location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("location", location);
        return createEvent(EntitySpawnEvent.class, values);
    }

    /**
     * Creates a new {@link EntityConstructingEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @return A new instance of the event
     */
    public static EntityConstructingEvent createEntityConstructing(Game game, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        return createEvent(EntityConstructingEvent.class, values);
    }

    /**
     * Creates a new {@link EntityTameEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @param tamer The tamer that has tamed the entity
     * @return A new instance of the event
     */
    public static EntityTameEvent createEntityTame(Game game, Entity entity, Tamer tamer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("tamer", tamer);
        return createEvent(EntityTameEvent.class, values);
    }

    /**
     * Creates a new {@link EntityTeleportEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @param keepsVelocity Whether the entity will maintain velocity
     * @return A new instance of the event
     */
    public static EntityTeleportEvent createEntityTeleport(Game game, Cause cause, Entity entity, Location oldLocation, Location newLocation,
            Vector3d rotation, boolean keepsVelocity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("rotation", rotation);
        values.put("keepsVelocity", keepsVelocity);
        return createEvent(EntityTeleportEvent.class, values);
    }

    /**
     * Creates a new {@link EntityUpdateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity involved in this event
     * @return A new instance of the event
     */
    public static EntityUpdateEvent createEntityUpdate(Game game, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        return createEvent(EntityUpdateEvent.class, values);
    }

    /**
     * Creates a new {@link ProjectileLaunchEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity involved in this event
     * @param source The projectile source
     * @return A new instance of the event
     */
    public static ProjectileLaunchEvent createProjectileLaunch(Game game, Cause cause, Projectile entity, ProjectileSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("launchedProjectile", entity);
        values.put("source", Optional.fromNullable(source));
        return createEvent(ProjectileLaunchEvent.class, values);
    }

    /**
     * Creates a new {@link CommandEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param arguments The arguments provided
     * @param source The source of the command
     * @param command The command name
     * @return A new instance of the event
     */
    public static CommandEvent createCommand(Game game, String arguments, CommandSource source, String command) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("arguments", arguments);
        values.put("source", source);
        values.put("command", command);
        return createEvent(CommandEvent.class, values);
    }

    /**
     * Creates a new {@link MessageEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param source The source of the message
     * @param message The message to say
     * @return A new instance of the event
     */
    public static MessageEvent createMessage(Game game, CommandSource source, Text message) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        values.put("message", message);
        return createEvent(MessageEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerBreakBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param player The player involved in this event
     * @param direction The block direction the player was breaking
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static PlayerBreakBlockEvent createPlayerBreakBlock(Game game, Cause cause, Player player, Direction direction, Location block,
            BlockSnapshot replacementBlock, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("replacementBlock", replacementBlock);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("blockFaceDirection", direction);
        values.put("exp", exp);
        return createEvent(PlayerBreakBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerCastFishingLineEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param fishHook The {@link FishHook} effected by this event
     * @return A new instance of the event
     */
    public static PlayerCastFishingLineEvent createPlayerCastFishingLineEvent(Game game, Player player, FishHook fishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("fishHook", fishHook);
        return createEvent(PlayerCastFishingLineEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerHookedEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param fishHook The {@link FishHook} affected by this event
     * @param caughtEntity The {@link Entity} caught by the player, can be null
     * @return A new instance of the event
     */
    public static PlayerHookedEntityEvent createPlayerHookedEntityEvent(Game game, Player player, FishHook fishHook, Entity caughtEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", Optional.fromNullable(caughtEntity));
        return createEvent(PlayerHookedEntityEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerRetractFishingLineEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param fishHook The {@link FishHook} affected by this event
     * @param caughtItem The {@link ItemStack} caught by the player, can be null
     * @param caughtEntity The {@link Entity} caught by the player, can be null
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static PlayerRetractFishingLineEvent createPlayerRetractFishingLineEvent(Game game, Player player, FishHook fishHook, ItemStack caughtItem,
            Entity caughtEntity, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", Optional.fromNullable(caughtEntity));
        values.put("caughtItem", Optional.fromNullable(caughtItem));
        values.put("exp", exp);
        return createEvent(PlayerRetractFishingLineEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChangeBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param player The player involved in this event
     * @param direction The direction of the block the player was changing
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static PlayerChangeBlockEvent createPlayerChangeBlock(Game game, Cause cause, Player player, Direction direction, Location block,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("replacementBlock", replacementBlock);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("blockFaceDirection", direction);
        return createEvent(PlayerChangeBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChangeGameModeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param newGameMode The game mode to change to
     * @param oldGameMode The Player's old game mode
     * @return A new instance of the event
     */
    public static PlayerChangeGameModeEvent createPlayerChangeGameMode(Game game, Player player, GameMode newGameMode, GameMode oldGameMode) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("newGameMode", newGameMode);
        values.put("oldGameMode", oldGameMode);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        return createEvent(PlayerChangeGameModeEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChangeWorldEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param fromWorld The world the player was in
     * @param toWorld The world the player is changing to
     * @return A new instance of the event
     */
    public static PlayerChangeWorldEvent createPlayerChangeWorld(Game game, Player player, World fromWorld, World toWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("fromWorld", fromWorld);
        values.put("toWorld", toWorld);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        return createEvent(PlayerChangeWorldEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChatEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param source The source of the message
     * @param message The message to say
     * @return A new instance of the event
     */
    public static PlayerChatEvent createPlayerChat(Game game, Player player, CommandSource source, Text message) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("source", source);
        values.put("message", message);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        return createEvent(PlayerChatEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerDeathEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param player The player involved in this event
     * @param location The location of death
     * @param deathMessage The message to show to the player because they died
     * @param droppedItems The items to drop
     * @param exp The experience to give, or take for negative values
     * @param newExperience The new experience the player will have towards the next level
     * @param newLevel The new level the player will have after death
     * @param keepsLevel Whether the player keeps all of their exp on death
     * @param keepsInventory Whether the player should keep inventory
     * @return A new instance of the event
     */
    public static PlayerDeathEvent createPlayerDeath(Game game, Cause cause, Player player, Location location, Text deathMessage,
            Collection<Item> droppedItems, int exp, int newExperience, int newLevel, boolean keepsLevel, boolean keepsInventory) {

        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", player);
        values.put("deathMessage", deathMessage);
        values.put("player", player);
        values.put("user", player);
        values.put("location", location);
        values.put("human", player);
        values.put("living", player);
        values.put("droppedItems", droppedItems);
        values.put("exp", exp);
        values.put("newExperience", newExperience);
        values.put("newLevel", newLevel);
        values.put("keepsLevel", keepsLevel);
        values.put("keepsInventory", keepsInventory);
        return createEvent(PlayerDeathEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerDropItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param droppedItems The items to drop
     * @return A new instance of the event
     */
    public static PlayerDropItemEvent createPlayerDropItem(Game game, Player player, Collection<Item> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("droppedItems", droppedItems);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        return createEvent(PlayerDropItemEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerHarvestBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param player The player involved in this event
     * @param block The block affected by this event
     * @param droppedItems The items to drop
     * @param dropChance The chance the items will drop, see
     *        {@link BlockHarvestEvent#setDropChance(float)}
     * @param silkTouch Whether the player is harvesting with silk touch
     * @return A new instance of the event
     */
    public static PlayerHarvestBlockEvent createPlayerHarvestBlock(Game game, Cause cause, Player player, Location block,
            Collection<Item> droppedItems, float dropChance, boolean silkTouch) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("user", player);
        values.put("player", player);
        values.put("human", player);
        values.put("living", player);
        values.put("droppedItems", droppedItems);
        values.put("dropChance", dropChance);
        values.put("silkTouch", silkTouch);
        return createEvent(PlayerHarvestBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerInteractBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param player The player involved in this event
     * @param block The block affected by this event
     * @param interactionType The type of interaction used
     * @param location The location of the interaction
     * @return A new instance of the event
     */
    public static PlayerInteractBlockEvent createPlayerInteractBlock(Game game, Cause cause, Player player, Location block,
            EntityInteractionType interactionType, @Nullable Vector3d location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("human", player);
        values.put("living", player);
        values.put("interactionType", interactionType);
        values.put("player", player);
        values.put("user", player);
        values.put("clickedPosition", Optional.fromNullable(location));
        return createEvent(PlayerInteractBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerInteractEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param targetEntity The entity being interacted with
     * @param interactionType The type of interaction used
     * @param location The location of the targeted interaction
     * @return A new instance of the event
     */
    public static PlayerInteractEntityEvent createPlayerInteractEntity(Game game, Player player, Entity targetEntity,
            EntityInteractionType interactionType, @Nullable Vector3d location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("targetEntity", targetEntity);
        values.put("interactionType", interactionType);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("clickedPosition", Optional.fromNullable(location));
        return createEvent(PlayerInteractEntityEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerInteractEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param interactionType The type of interaction used
     * @param location The location of the interaction
     * @return A new instance of the event
     */
    public static PlayerInteractEvent createPlayerInteract(Game game, Player player, EntityInteractionType interactionType,
            @Nullable Vector3d location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("interactionType", interactionType);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("clickedPosition", Optional.fromNullable(location));
        return createEvent(PlayerInteractEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerJoinEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param joinMessage The message displayed when the player joins
     * @return A new instance of the event
     */
    public static PlayerJoinEvent createPlayerJoin(Game game, Player player, Text joinMessage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("joinMessage", joinMessage);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        return createEvent(PlayerJoinEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerMoveEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @return A new instance of the event
     */
    public static PlayerMoveEvent createPlayerMove(Game game, Player player, Location oldLocation, Location newLocation, Vector3d rotation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("rotation", rotation);
        return createEvent(PlayerMoveEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerPickUpItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param items The items that will be picked up
     * @return A new instance of the event
     */
    public static PlayerPickUpItemEvent createPlayerPickUpItem(Game game, Player player, Collection<Entity> items) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("items", items);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        return createEvent(PlayerPickUpItemEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerPlaceBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param player The player involved in this event
     * @param block The block affected by this event
     * @param replacementBlock The block that will replace the existing block
     * @param direction The direction the block was placed
     * @return A new instance of the event
     */
    public static PlayerPlaceBlockEvent createPlayerPlaceBlock(Game game, Cause cause, Player player, Location block,
            BlockSnapshot replacementBlock, Direction direction) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", block);
        values.put("entity", player);
        values.put("replacementBlock", replacementBlock);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        values.put("blockFaceDirection", direction);
        return createEvent(PlayerPlaceBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerQuitEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param quitMessage The message to display to the player because they quit
     * @return A new instance of the event
     */
    public static PlayerQuitEvent createPlayerQuit(Game game, Player player, Text quitMessage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("quitMessage", quitMessage);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        return createEvent(PlayerQuitEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerUpdateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @return A new instance of the event
     */
    public static PlayerUpdateEvent createPlayerUpdate(Game game, Player player) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("player", player);
        values.put("user", player);
        values.put("human", player);
        values.put("living", player);
        return createEvent(PlayerUpdateEvent.class, values);
    }

    /**
     * Creates a new {@link LightningStrikeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param weatherUniverse The volume the weather changed in
     * @param lightningStrike The lightning entity that struck
     * @param struckEntities The entities the lightning had struck
     * @param struckBlocks The blocks the lightning had struck
     * @return A new instance of the event
     */
    public static LightningStrikeEvent createLightningStrike(Game game, WeatherUniverse weatherUniverse, Lightning lightningStrike,
            List<Entity> struckEntities, List<Location> struckBlocks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("lightningStrike", lightningStrike);
        values.put("weatherUniverse", weatherUniverse);
        values.put("struckEntities", struckEntities);
        values.put("struckBlocks", struckBlocks);
        return createEvent(LightningStrikeEvent.class, values);
    }

    /**
     * Creates a new {@link AchievementEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param achievement The achievement being added to the player
     * @return A new instance of the event
     */
    public static AchievementEvent createAchievementEvent(Game game, Player player, Achievement achievement) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("living", player);
        values.put("human", player);
        values.put("player", player);
        values.put("user", player);
        values.put("achievement", achievement);
        return createEvent(AchievementEvent.class, values);
    }

    /**
     * Creates a new {@link StatisticChangeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param player The player involved in this event
     * @param changedStatistic Any statistics changed by this event
     * @param oldValue The old value of the statistic
     * @param newValue The new value of the statistic
     * @return A new instance of the event
     */
    public static StatisticChangeEvent createStatisticChangeEvent(Game game, Player player, Statistic changedStatistic,
                                                                  long newValue, long oldValue) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", player);
        values.put("living", player);
        values.put("human", player);
        values.put("player", player);
        values.put("user", player);
        values.put("changedStatistic", changedStatistic);
        values.put("newValue", newValue);
        values.put("oldValue", oldValue);
        return createEvent(StatisticChangeEvent.class, values);
    }

    /**
     * Creates a new {@link WeatherChangeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param weatherUniverse The volume the weather changed in
     * @param initialWeather The previous weather
     * @param resultingWeather The weather to change to
     * @return A new instance of the event
     */
    public static WeatherChangeEvent createWeatherChange(Game game, WeatherUniverse weatherUniverse, Weather initialWeather,
            Weather resultingWeather) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("initialWeather", initialWeather);
        values.put("weatherUniverse", weatherUniverse);
        values.put("resultingWeather", resultingWeather);
        return createEvent(WeatherChangeEvent.class, values);
    }

    /**
     * Creates a new {@link ChunkForcedEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param ticket The ticket that will load the chunk
     * @param chunkCoords The coordinates of the chunk being added
     * @return A new instance of the event
     */
    public static ChunkForcedEvent createChunkForced(Game game, LoadingTicket ticket, Vector3i chunkCoords) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("ticket", ticket);
        values.put("chunkCoords", chunkCoords);
        return createEvent(ChunkForcedEvent.class, values);
    }

    /**
     * Creates a new {@link ChunkLoadEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static ChunkLoadEvent createChunkLoad(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkLoadEvent.class, values);
    }

    /**
     * Creates a new {@link ChunkPostGenerateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static ChunkPostGenerateEvent createChunkPostGenerate(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkPostGenerateEvent.class, values);
    }

    /**
     * Creates a new {@link ChunkPostPopulateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static ChunkPostPopulateEvent createChunkPostPopulate(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkPostPopulateEvent.class, values);
    }

    /**
     * Creates a new {@link ChunkPreGenerateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static ChunkPreGenerateEvent createChunkPreGenerate(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkPreGenerateEvent.class, values);
    }

    /**
     * Creates a new {@link ChunkPrePopulateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @param pendingPopulators All populator's that will populate the chunk
     * @return A new instance of the event
     */
    public static ChunkPrePopulateEvent createChunkPrePopulate(Game game, Chunk chunk, Iterable<Populator> pendingPopulators) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        values.put("pendingPopulators", pendingPopulators);
        return createEvent(ChunkPrePopulateEvent.class, values);
    }

    /**
     * Creates a new {@link ChunkUnforcedEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunkCoords The coordinates of the removed chunk
     * @param ticket The ticket the chunk was removed from
     * @return A new instance of the event
     */
    public static ChunkUnforcedEvent createChunkUnforced(Game game, Vector3i chunkCoords, LoadingTicket ticket) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("ticket", ticket);
        values.put("chunkCoords", chunkCoords);
        return createEvent(ChunkUnforcedEvent.class, values);
    }

    /**
     * Creates a new {@link ChunkUnloadEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static ChunkUnloadEvent createChunkUnload(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(ChunkUnloadEvent.class, values);
    }

    /**
     * Creates a new {@link GameRuleChangeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param world The world involved in this event
     * @param name The name of the game rule
     * @param oldValue The previous value for the rule
     * @param newValue The new value for the rule
     * @return A new instance of the event
     */
    public static GameRuleChangeEvent createGameRuleChange(Game game, World world, String name, String oldValue, String newValue) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", world);
        values.put("newValue", newValue);
        values.put("name", name);
        values.put("oldValue", oldValue);
        return createEvent(GameRuleChangeEvent.class, values);
    }

    /**
     * Creates a new {@link WorldLoadEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param world The world involved in this event
     * @return A new instance of the event
     */
    public static WorldLoadEvent createWorldLoad(Game game, World world) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", world);
        return createEvent(WorldLoadEvent.class, values);
    }

    /**
     * Creates a new {@link WorldUnloadEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param world The world involved in this event
     * @return A new instance of the event
     */
    public static WorldUnloadEvent createWorldUnload(Game game, World world) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", world);
        return createEvent(WorldUnloadEvent.class, values);
    }

    /**
     * Creates a new {@link StatusPingEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param client The client that is pinging the server
     * @param response The response to send to the client
     * @return A new instance of the event
     */
    public static StatusPingEvent createStatusPing(Game game, StatusClient client, StatusPingEvent.Response response) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("client", client);
        values.put("response", response);
        return createEvent(StatusPingEvent.class, values);
    }

    /**
     * Creates a new {@link BrewingStandBrewEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param brewingStand The {@link BrewingStand} involved in this event
     * @param sourceItems The {@link ItemStack}s being modified
     * @param fuelSource The {@link ItemStack} used as the reagent to modify the source items
     * @param brewedItems The {@link ItemStack}s produced as a result
     * @param cause The cause
     * @param inventory The inventory of the brewing stand
     * @param blockLoc The location of the brewing stand
     * @param data The brewing stand data
     * @return A new instance of the event
     */
    public static BrewingStandBrewEvent createBrewingStandBrewEvent(Game game, BrewingStand brewingStand, BrewingData data,
                                                                    List<ItemStack> sourceItems, ItemStack fuelSource, List<ItemStack> brewedItems,
                                                                    Cause cause, TileEntityInventory<TileEntityCarrier> inventory,
                                                                    Location blockLoc) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("tile", brewingStand);
        values.put("brewingStand", brewingStand);
        values.put("sourceItems", sourceItems);
        values.put("fuelSource", fuelSource);
        values.put("brewedItems", brewedItems);
        values.put("results", brewedItems);
        values.put("inventory", inventory);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", blockLoc);
        values.put("currentData", data);
        return createEvent(BrewingStandBrewEvent.class, values);
    }

    /**
     * Creates a new {@link FurnaceConsumeFuelEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param furnace The {@link Furnace} involved in this event
     * @param burnedItem The {@link ItemStack} consumed for fuel
     * @param remainingFuel The {@link ItemStack} representing the remaining fuel, can be null
     * @param cause The cause
     * @param inventory The inventory of the furnace
     * @param loc The location of the furnace
     * @param data The furnace data
     * @return A new instance of the event
     */
    public static FurnaceConsumeFuelEvent createFurnaceConsumeFuelEvent(Game game, Furnace furnace, FurnaceData data, ItemStack burnedItem,
                                                                        ItemStack remainingFuel, Cause cause,
                                                                        TileEntityInventory<TileEntityCarrier> inventory, Location loc) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("tile", furnace);
        values.put("furnace", furnace);
        values.put("burnedItem", burnedItem);
        values.put("remainingFuel", Optional.fromNullable(remainingFuel));
        values.put("result", Optional.fromNullable(remainingFuel));
        values.put("inventory", inventory);
        values.put("cause", Optional.fromNullable(cause));
        values.put("block", loc);
        values.put("currentData", data);
        return createEvent(FurnaceConsumeFuelEvent.class, values);
    }

    /**
     * Creates a new {@link FurnaceSmeltItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param furnace The {@link Furnace} involved in this event
     * @param cookedItem The {@link ItemStack} resulting from smelting the source item
     * @param sourceItem The {@link ItemStack} smelted to create the cooked item
     * @param cause The cause
     * @param inventory The inventory of the furnace
     * @param loc The location of the furnace
     * @param data The furnace data
     * @return A new instance of the event
     */
    public static FurnaceSmeltItemEvent createFurnaceSmeltItemEvent(Game game, Furnace furnace, FurnaceData data, ItemStack cookedItem,
                                                                    ItemStack sourceItem, Cause cause,
                                                                    TileEntityInventory<TileEntityCarrier> inventory, Location loc) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("tile", furnace);
        values.put("furnace", furnace);
        values.put("cookedItem", cookedItem);
        values.put("sourceItem", sourceItem);
        values.put("result", Optional.fromNullable(cookedItem));
        values.put("cause", Optional.fromNullable(cause));
        values.put("inventory", inventory);
        values.put("block", loc);
        values.put("currentData", data);
        return createEvent(FurnaceSmeltItemEvent.class, values);
    }

}
