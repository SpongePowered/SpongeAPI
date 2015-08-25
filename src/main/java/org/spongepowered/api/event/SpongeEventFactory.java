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
package org.spongepowered.api.event;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockTransaction;
import org.spongepowered.api.block.tileentity.Sign;
import org.spongepowered.api.block.tileentity.carrier.BrewingStand;
import org.spongepowered.api.block.tileentity.carrier.Furnace;
import org.spongepowered.api.block.tileentity.carrier.TileEntityCarrier;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableBrewingData;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableFurnaceData;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.SignData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityInteractionType;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.action.MessageEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.source.block.BlockBreakBlockEvent;
import org.spongepowered.api.event.source.block.BlockBurnBlockEvent;
import org.spongepowered.api.event.source.block.BlockChangeBlockEvent;
import org.spongepowered.api.event.source.block.BlockDispenseItemEvent;
import org.spongepowered.api.event.source.block.BlockHarvestBlockEvent;
import org.spongepowered.api.event.source.block.BlockIgniteBlockEvent;
import org.spongepowered.api.event.source.block.BlockInteractBlockEvent;
import org.spongepowered.api.event.source.block.BlockMoveBlockEvent;
import org.spongepowered.api.event.source.block.BlockPlaceBlockEvent;
import org.spongepowered.api.event.source.block.BlockSpreadBlockEvent;
import org.spongepowered.api.event.source.block.BlockUpdateBlockPowerEvent;
import org.spongepowered.api.event.source.block.BlockUpdateNeighborBlockEvent;
import org.spongepowered.api.event.source.block.tileentity.BrewingStandBrewItemsEvent;
import org.spongepowered.api.event.source.block.tileentity.FurnaceConsumeFuelEvent;
import org.spongepowered.api.event.source.block.tileentity.FurnaceSmeltItemEvent;
import org.spongepowered.api.event.source.command.SendCommandEvent;
import org.spongepowered.api.event.source.command.TabCompleteCommandEvent;
import org.spongepowered.api.event.source.entity.EntityBreakBlockEvent;
import org.spongepowered.api.event.source.entity.EntityBreedWithEntityEvent;
import org.spongepowered.api.event.source.entity.EntityChangeBlockEvent;
import org.spongepowered.api.event.source.entity.EntityCollideBlockEvent;
import org.spongepowered.api.event.source.entity.EntityCollideEntityEvent;
import org.spongepowered.api.event.source.entity.EntityDropItemEvent;
import org.spongepowered.api.event.source.entity.EntityHarvestBlockEvent;
import org.spongepowered.api.event.source.entity.EntityInteractBlockEvent;
import org.spongepowered.api.event.source.entity.EntityInteractEntityEvent;
import org.spongepowered.api.event.source.entity.EntityPickupItemEvent;
import org.spongepowered.api.event.source.entity.EntityPlaceBlockEvent;
import org.spongepowered.api.event.source.entity.living.human.HumanSleepEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerBreakBlockEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerCastFishingLineEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerChangeBlockEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerChangeSignEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerChangeStatisticEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerChatEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerDropItemEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerHarvestBlockEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerHookEntityEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerInteractBlockEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerInteractEntityEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerJoinEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerPickupItemEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerPlaceBlockEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerQuitEvent;
import org.spongepowered.api.event.source.entity.living.player.PlayerRetractFishingLineEvent;
import org.spongepowered.api.event.source.game.state.GameStateEvent;
import org.spongepowered.api.event.source.network.GameClientAuthEvent;
import org.spongepowered.api.event.source.network.GameClientConnectEvent;
import org.spongepowered.api.event.source.plugin.PluginForceChunkEvent;
import org.spongepowered.api.event.source.rcon.RconLoginEvent;
import org.spongepowered.api.event.source.rcon.RconQuitEvent;
import org.spongepowered.api.event.source.server.ServerCreateWorldEvent;
import org.spongepowered.api.event.source.server.ServerLoadWorldEvent;
import org.spongepowered.api.event.source.server.ServerUnloadWorldEvent;
import org.spongepowered.api.event.source.world.WorldDecayBlockEvent;
import org.spongepowered.api.event.source.world.WorldExplosionEvent;
import org.spongepowered.api.event.source.world.WorldGrowBlockEvent;
import org.spongepowered.api.event.source.world.WorldOnExplosionEvent;
import org.spongepowered.api.event.source.world.WorldPostGenerateChunkEvent;
import org.spongepowered.api.event.source.world.WorldPostPopulateChunkEvent;
import org.spongepowered.api.event.source.world.WorldPreExplosionEvent;
import org.spongepowered.api.event.source.world.WorldPreGenerateChunkEvent;
import org.spongepowered.api.event.source.world.WorldPrePopulateChunkEvent;
import org.spongepowered.api.event.source.world.WorldTickBlockEvent;
import org.spongepowered.api.event.target.block.ChangeBlockEvent;
import org.spongepowered.api.event.target.block.HarvestBlockEvent;
import org.spongepowered.api.event.target.entity.CollideEntityEvent;
import org.spongepowered.api.event.target.entity.ConstructEntityEvent;
import org.spongepowered.api.event.target.entity.DestructEntityEvent;
import org.spongepowered.api.event.target.entity.DismountEntityEvent;
import org.spongepowered.api.event.target.entity.DisplaceEntityEvent;
import org.spongepowered.api.event.target.entity.HarvestEntityEvent;
import org.spongepowered.api.event.target.entity.LeashEntityEvent;
import org.spongepowered.api.event.target.entity.MountEntityEvent;
import org.spongepowered.api.event.target.entity.MoveEntityEvent;
import org.spongepowered.api.event.target.entity.SpawnEntityEvent;
import org.spongepowered.api.event.target.entity.TameEntityEvent;
import org.spongepowered.api.event.target.entity.TargetEntityEvent;
import org.spongepowered.api.event.target.entity.TeleportEntityEvent;
import org.spongepowered.api.event.target.entity.UnleashEntityEvent;
import org.spongepowered.api.event.target.entity.living.TargetLivingEvent;
import org.spongepowered.api.event.target.entity.living.player.ChangePlayerGameModeEvent;
import org.spongepowered.api.event.target.entity.living.player.HarvestPlayerEvent;
import org.spongepowered.api.event.target.entity.living.player.MovePlayerEvent;
import org.spongepowered.api.event.target.entity.living.player.RespawnPlayerEvent;
import org.spongepowered.api.event.target.entity.projectile.LaunchProjectileEvent;
import org.spongepowered.api.event.target.server.PingServerEvent;
import org.spongepowered.api.event.target.world.ChangeWorldGameRuleEvent;
import org.spongepowered.api.event.target.world.ChangeWorldWeatherEvent;
import org.spongepowered.api.event.target.world.CreateWorldEvent;
import org.spongepowered.api.event.target.world.chunk.LoadChunkEvent;
import org.spongepowered.api.event.target.world.chunk.UnforcedChunkEvent;
import org.spongepowered.api.event.target.world.chunk.UnloadChunkEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.type.TileEntityInventory;
import org.spongepowered.api.network.RemoteConnection;
import org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.status.StatusClient;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.source.RconSource;
import org.spongepowered.api.util.event.factory.ClassGeneratorProvider;
import org.spongepowered.api.util.event.factory.EventFactory;
import org.spongepowered.api.util.event.factory.EventFactoryPlugin;
import org.spongepowered.api.util.event.factory.NullPolicy;
import org.spongepowered.api.util.event.factory.plugin.AccessorModifierEventFactoryPlugin;
import org.spongepowered.api.util.event.factory.plugin.AnnotationEventFactoryPlugin;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldCreationSettings;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.WeatherUniverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Generates Sponge event implementations.
 */
public final class SpongeEventFactory {

    private static final ClassGeneratorProvider factoryProvider;
    private static final LoadingCache<Class<?>, EventFactory<?>> factories;
    private static final List<EventFactoryPlugin> plugins = new ArrayList<EventFactoryPlugin>();

    static {
        factoryProvider = new ClassGeneratorProvider("org.spongepowered.api.event.impl");
        factoryProvider.setNullPolicy(NullPolicy.NON_NULL_BY_DEFAULT);

        plugins.add(0, new AnnotationEventFactoryPlugin());

        plugins.add(0, new AccessorModifierEventFactoryPlugin("org.spongepowered.api.event.impl.base"));
        factories = CacheBuilder.newBuilder()
                .build(
                        new CacheLoader<Class<?>, EventFactory<?>>() {
                            @Override
                            public EventFactory<?> load(Class<?> type) {
                                return factoryProvider.create(type, getBaseClass(type));
                            }
                        });
    }

    private SpongeEventFactory() {
    }

    private static Class<?> getBaseClass(Class<?> event) {
        Class<?> superClass = null;
        for (EventFactoryPlugin plugin : plugins) {
            superClass = plugin.resolveSuperClassFor(event, superClass, factoryProvider.getClassLoader());
        }
        return superClass;
    }

    /**
     * Adds an {@link EventFactoryPlugin} to the chain of plugins.
     *
     * <p>The plugin chain is in LIFO order.</p>
     *
     * @param plugin The {@link EventFactoryPlugin} to add to the chain
     */
    public static void addEventFactoryPlugin(EventFactoryPlugin plugin) {
        plugins.add(0, plugin);
    }

    /**
     * Creates an event class from an interface and a map of property names to values.
     *
     * @param type The event interface to generate a class for
     * @param values The map of property names to values
     * @param <T> The type of event to be created
     * @return The generated event class.
     */
    @SuppressWarnings("unchecked")
    public static <T> T createEvent(Class<T> type, Map<String, Object> values) {
        return (T) factories.getUnchecked(type).apply(values);
    }

    /**
     * Creates a new {@link GameStateEvent} of the given type.
     *
     * @param type The type of the state event
     * @param game The game instance for this {@link GameEvent}
     * @param <T> The type of the state event
     * @return A new instance of the event
     */
    public static <T extends GameStateEvent> T createState(Class<T> type, Game game) {
        Map<String, Object> values = Maps.newHashMapWithExpectedSize(1);
        values.put("game", game);
        return createEvent(type, values);
    }

    /**
     * Creates a new {@link BlockBreakBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static BlockBreakBlockEvent createBlockBreakBlock(Game game, Cause cause, Location<World> location, BlockSnapshot replacementBlock, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockBreakBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockBurnBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockBurnBlockEvent createBlockBurnBlock(Game game, Cause cause, Location<World> location, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockBurnBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockChangeBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockChangeBlockEvent createBlockChangeBlock(Game game, Cause cause, Location<World> location, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockChangeBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockDispenseItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param velocity The velocity to dispense the item at
     * @param dispensedItem The item to dispense from the block
     * @return A new instance of the event
     */
    public static BlockDispenseItemEvent createBlockDispenseItem(Game game, Cause cause, Location<World> location, Vector3d velocity, ItemStack dispensedItem) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("velocity", velocity);
        values.put("dispensedItem", dispensedItem);
        return createEvent(BlockDispenseItemEvent.class, values);
    }

    /**
     * Creates a new {@link BlockHarvestBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param droppedItems The items to drop
     * @param dropChance The chance the items will drop, see
     *        {@link HarvestBlockEvent#setDropChance(float)}
     * @return A new instance of the event
     */
    public static BlockHarvestBlockEvent createBlockHarvestBlock(Game game, Cause cause, Location<World> location, Collection<ItemStack> droppedItems, float dropChance) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("droppedItems", droppedItems);
        values.put("dropChance", dropChance);
        return createEvent(BlockHarvestBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockIgniteBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @return A new instance of the event
     */
    public static BlockIgniteBlockEvent createBlockIgniteBlock(Game game, Cause cause, Location<World> location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        return createEvent(BlockIgniteBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockInteractBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param side The face interacted with as a direction
     * @return A new instance of the event
     */
    public static BlockInteractBlockEvent createBlockInteractBlock(Game game, Cause cause, Location<World> location, Direction side) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("side", side);
        return createEvent(BlockInteractBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockMoveBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param locations The locations
     * @return A new instance of the event
     */
    public static BlockMoveBlockEvent createBlockMoveBlock(Game game, Cause cause, List<Location<World>> locations) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("locations", locations);
        return createEvent(BlockMoveBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockPlaceBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location the location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockPlaceBlockEvent createBlockPlaceBlock(Game game, Cause cause, Location<World> location, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockPlaceBlockEvent.class, values);
    }

    /**
     * Creates a new {@link WorldTickBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @return A new instance of the event
     */
    public static WorldTickBlockEvent createWorldTickBlock(Game game, Cause cause, Location<World> location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetLocation", location);
        values.put("targetBlock", location.getBlock());
        values.put("world", location.getExtent());
        return createEvent(WorldTickBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockUpdateNeighborBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param location The location
     * @param locations The locations affected
     * @return A new instance of the event
     */
    public static BlockUpdateNeighborBlockEvent createBlockUpdateNeighborBlock(Game game, ImmutableList<BlockTransaction> transactions, Map<Direction, Location<World>> directions, Map<Direction, Location<World>> relatives, Map<Direction, BlockSnapshot> snapshotRelatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("transactions", transactions);
        values.put("directions", directions);
        values.put("relatives", relatives);
        values.put("snapshotRelatives", snapshotRelatives);
        return createEvent(BlockUpdateNeighborBlockEvent.class, values);
    }

    /**
     * Create a new {@link BlockUpdateBlockPowerEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param locations The affected locations
     * @param oldCurrent The previous signal strength of the redstone
     * @param newCurrent The updated signal strength of the redstone
     * @return A new instance of the event
     */
    public static BlockUpdateBlockPowerEvent createBlockUpdateBlockPower(Game game, Cause cause, Location<World> location,
            List<Location<World>> locations, int oldCurrent, int newCurrent) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("locations", locations);
        values.put("oldSignalStrength", oldCurrent);
        values.put("newSignalStrength", newCurrent);
        return createEvent(BlockUpdateBlockPowerEvent.class, values);
    }

    /**
     * Creates a new {@link WorldGrowBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static WorldGrowBlockEvent createWorldGrowBlock(Game game, Cause cause, Location<World> location, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(WorldGrowBlockEvent.class, values);
    }

    /**
     * Creates a new {@link BlockSpreadBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param locations The affected locations
     * @return A new instance of the event
     */
     public static BlockSpreadBlockEvent createBlockSpreadBlock(Game game, Cause cause, Location<World> location, List<Location<World>> locations) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("locations", locations);
        return createEvent(BlockSpreadBlockEvent.class, values);
     }

    /**
     * Creates a new {@link EntityBreakBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static EntityBreakBlockEvent createEntityBreakBlock(Game game, Cause cause, Entity entity, Location<World> location, BlockSnapshot replacementBlock,
            int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        values.put("exp", exp);
        return createEvent(EntityBreakBlockEvent.class, values);
    }


    /**
     * Creates a new {@link DestructEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @param snapshot The entity snapshot
     * @return A new instance of the event
     */
    public static DestructEntityEvent createDestructEntity(Game game, Entity targetEntity, Transform<World> targetTransform, EntitySnapshot snapshot) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        values.put("snapshot", snapshot);
        return createEvent(DestructEntityEvent.class, values);
    }

    /**
     * Creates a new {@link EntityBreedWithEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param parent The parent of the entity
     * @param otherParent The other parent of the entity
     * @return A new instance of the event
     */
    public static EntityBreedWithEntityEvent createEntityBreedWithEntity(Game game, Ageable entity, Ageable parent, Ageable otherParent) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("parent", parent);
        values.put("otherParent", otherParent);
        return createEvent(EntityBreedWithEntityEvent.class, values);
    }

    /**
     * Creates a new {@link EntityChangeBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static EntityChangeBlockEvent createEntityChangeBlock(Game game, Cause cause, Entity entity, Location<World> location,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(EntityChangeBlockEvent.class, values);
    }

    /**
     * Creates a new {@link CollideEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @return A new instance of the event
     */
    public static CollideEntityEvent createCollideEntity(Game game, Cause cause, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        return createEvent(CollideEntityEvent.class, values);
    }

    /**
     * Creates a new {@link EntityCollideBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param location The location
     * @return A new instance of the event
     */
    public static EntityCollideBlockEvent createEntityCollideBlock(Game game, Cause cause, Entity entity, Location<World> location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        return createEvent(EntityCollideBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityCollideEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param collided The entity that was collided with
     * @return A new instance of the event
     */
    public static EntityCollideEntityEvent createEntityCollideEntity(Game game, Cause cause, Entity entity, Entity collided) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("collided", collided);
        return createEvent(EntityCollideEntityEvent.class, values);
    }

    /**
     * Creates a new {@link HarvestEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param location The location
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static HarvestEntityEvent createHarvestEntity(Game game, Cause cause, Entity entity, Location<World> location, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("location", location);
        values.put("exp", exp);
        return createEvent(HarvestEntityEvent.class, values);
    }

    /**
     * Creates a new {@link DismountEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param dismounted The entity being dismounted from
     * @return A new instance of the event
     */
    public static DismountEntityEvent createDismountEntity(Game game, Entity entity, Entity dismounted) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("dismounted", dismounted);
        return createEvent(DismountEntityEvent.class, values);
    }

    /**
     * Creates a new {@link DisplaceEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param oldLocation The previous location
     * @param newLocation The new location
     * @param rotation The rotation the entity is facing
     * @return A new instance of the event
     */
    public static DisplaceEntityEvent createDisplaceEntity(Game game, Entity entity,
            Location<World> oldLocation, Location<World> newLocation, Vector3d rotation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("rotation", rotation);
        return createEvent(DisplaceEntityEvent.class, values);
    }

    /**
     * Creates a new {@link EntityDropItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of this event
     * @param entity The entity
     * @param droppedItems The items to drop
     * @return A new instance of the event
     */
    public static EntityDropItemEvent createEntityDropItem(Game game, Cause cause, Entity entity, Collection<ItemStack> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("droppedItems", droppedItems);
        return createEvent(EntityDropItemEvent.class, values);
    }

    /**
     * Creates a new {@link EntityHarvestBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param location The location
     * @param droppedItems The items to drop
     * @param dropChance The chance the items will drop, see
     *        {@link HarvestBlockEvent#setDropChance(float)}
     * @return A new instance of the event
     */
    public static EntityHarvestBlockEvent createEntityHarvestBlock(Game game, Cause cause, Entity entity, Location<World> location,
            Collection<ItemStack> droppedItems, float dropChance) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("droppedItems", droppedItems);
        values.put("dropChance", dropChance);
        return createEvent(EntityHarvestBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityInteractBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param sourceEntity The source entity
     * @param sourceLocation The source location
     * @param targetLocation The target location
     * @param targetSide The target side of the block affected
     * @return A new instance of the event
     */
    public static EntityInteractBlockEvent createEntityInteractBlock(Game game, Cause cause, Entity sourceEntity, Location<World> sourceLocation, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);        
        values.put("sourceLocation", sourceLocation);
        values.put("targetLocation", targetLocation);
        values.put("targetBlock",  targetLocation.getBlock());
        values.put("targetSide", targetSide);
        return createEvent(EntityInteractBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityInteractEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
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
     * Creates a new {@link HumanSleepEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The human entity
     * @param transform The human transform
     * @param bed The bed
     * @return A new instance of the event
     */
    public static HumanSleepEvent createHumanSleep(Game game, Human entity, Transform<World> transform, Location<World> bed) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("transform", transform);
        values.put("bed", bed);
        return createEvent(HumanSleepEvent.class, values);
    }

    /**
     * Creates a new {@link LeashEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param leashHolder The entity holding the leash
     * @return A new instance of the event
     */
    public static LeashEntityEvent createLeashEntity(Game game, Entity entity, Entity leashHolder) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("leashHolder", leashHolder);
        return createEvent(LeashEntityEvent.class, values);
    }

    /**
     * Creates a new {@link LeashEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param leashHolder The entity holding the leash
     * @return A new instance of the event
     */
    public static UnleashEntityEvent createUnleashEntity(Game game, Entity entity, Entity leashHolder) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("leashHolder", leashHolder);
        return createEvent(UnleashEntityEvent.class, values);
    }

    /**
     * Creates a new {@link MountEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param vehicle The entity being mounted
     * @return A new instance of the event
     */
    public static MountEntityEvent createMountEntity(Game game, Entity entity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("vehicle", vehicle);
        return createEvent(MountEntityEvent.class, values);
    }

    /**
     * Creates a new {@link MoveEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @return A new instance of the event
     */
    public static MoveEntityEvent createMoveEntity(Game game, Entity entity,
            Location<World> oldLocation, Location<World> newLocation, Vector3d rotation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("rotation", rotation);
        return createEvent(MoveEntityEvent.class, values);
    }

    /**
     * Creates a new {@link EntityPickupItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param items The items that will be picked up
     * @param inventory The inventory involved with the event
     * @return A new instance of the event
     */
    public static EntityPickupItemEvent createEntityPickupItem(Game game, Entity entity, Collection<Entity> items, Inventory inventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("items", items);
        values.put("inventory", inventory);
        return createEvent(EntityPickupItemEvent.class, values);
    }

    /**
     * Creates a new {@link EntityPlaceBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static EntityPlaceBlockEvent createEntityPlaceBlock(Game game, Cause cause, Entity entity, Location<World> location,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("entity", entity);
        values.put("replacementBlock", replacementBlock);
        return createEvent(EntityPlaceBlockEvent.class, values);
    }

    /**
     * Creates a new {@link TargetEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param targetEntity The target entity
     * @param targetTransform The target transform
     * @return A new instance of the event
     */
    public static TargetEntityEvent createTargetEntity(Game game, Entity targetEntity, Transform<World> targetTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return createEvent(TargetEntityEvent.class, values);
    }

    /**
     * Creates a new {@link TargetLivingEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param targetEntity The target living entity
     * @param targetTransform The target transform
     * @return A new instance of the event
     */
    public static TargetLivingEvent createTargetLivingy(Game game, Entity targetEntity, Transform<World> targetTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return createEvent(TargetLivingEvent.class, values);
    }
    /**
     * Creates a new {@link SpawnEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param location The location
     * @return A new instance of the event
     */
    public static SpawnEntityEvent createSpawnEntity(Game game, Entity targetEntity, Transform<World> targetTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("targetTransform", targetTransform);
        return createEvent(SpawnEntityEvent.class, values);
    }

    /**
     * Creates a new {@link ConstructEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @return A new instance of the event
     */
    public static ConstructEntityEvent createConstructEntity(Game game, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        return createEvent(ConstructEntityEvent.class, values);
    }

    /**
     * Creates a new {@link TameEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param tamer The tamer that has tamed the entity
     * @return A new instance of the event
     */
    public static TameEntityEvent createTameEntity(Game game, Entity entity, Tamer tamer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("tamer", tamer);
        return createEvent(TameEntityEvent.class, values);
    }

    /**
     * Creates a new {@link TeleportEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @param keepsVelocity Whether the entity will maintain velocity
     * @return A new instance of the event
     */
    public static TeleportEntityEvent createTeleportEntity(Game game, Cause cause, Entity entity, Location<World> oldLocation, Location<World> newLocation,
            Vector3d rotation, boolean keepsVelocity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("rotation", rotation);
        values.put("keepsVelocity", keepsVelocity);
        return createEvent(TeleportEntityEvent.class, values);
    }

    /**
     * Creates a new {@link LaunchProjectileEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
     * @param source The projectile source
     * @return A new instance of the event
     */
    public static LaunchProjectileEvent createLaunchProjectile(Game game, Cause cause, Projectile entity, ProjectileSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("launchedProjectile", entity);
        values.put("source", Optional.fromNullable(source));
        return createEvent(LaunchProjectileEvent.class, values);
    }

    /**
     * Creates a new {@link SendCommandEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param arguments The arguments provided
     * @param source The source of the command
     * @param command The command name
     * @param result The result of the command
     * @return A new instance of the event
     */
    public static SendCommandEvent createSendCommand(Game game, String arguments, CommandSource source, String command, CommandResult result) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("arguments", arguments);
        values.put("source", source);
        values.put("command", command);
        values.put("result", result);
        return createEvent(SendCommandEvent.class, values);
    }

    /**
     * Creates a new {@link TabCompleteCommandEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param arguments The arguments provided
     * @param source The source of the command
     * @param command The command name
     * @param suggestions The list of suggestion. Must be mutable.
     * @return A new instance of the event
     */
    public static TabCompleteCommandEvent createTabCompleteCommand(Game game, String arguments, CommandSource source, String command,
            List<String> suggestions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("arguments", arguments);
        values.put("source", source);
        values.put("command", command);
        values.put("suggestions", suggestions);
        return createEvent(TabCompleteCommandEvent.class, values);
    }


    /**
     * Creates a new {@link MessageEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param source The source of the message
     * @param message The message to say
     * @param sink The destination for the message
     * @return A new instance of the event
     */
    public static MessageEvent createMessage(Game game, CommandSource source, Text message, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        values.put("message", message);
        values.put("newMessage", message);
        values.put("sink", sink);
        return createEvent(MessageEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerBreakBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The player
     * @param transform The transform
     * @param transactions The block transactions
     * @return A new instance of the event
     */
    public static PlayerBreakBlockEvent createPlayerBreakBlock(Game game, Cause cause, Player entity, Transform<World> transform, ImmutableList<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("transform", entity);
        values.put("transactions", transactions);
        return createEvent(PlayerBreakBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerCastFishingLineEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param fishHook The {@link FishHook} effected by this event
     * @return A new instance of the event
     */
    public static PlayerCastFishingLineEvent createPlayerCastFishingLine(Game game, Player entity, FishHook fishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("fishHook", fishHook);
        return createEvent(PlayerCastFishingLineEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerHookEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param fishHook The {@link FishHook} affected by this event
     * @param caughtEntity The {@link Entity} caught by the player, can be null
     * @return A new instance of the event
     */
    public static PlayerHookEntityEvent createPlayerHookEntity(Game game, Player entity, FishHook fishHook, Entity caughtEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", Optional.fromNullable(caughtEntity));
        return createEvent(PlayerHookEntityEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerRetractFishingLineEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param fishHook The {@link FishHook} affected by this event
     * @param caughtItem The {@link ItemStack} caught by the player, can be null
     * @param caughtEntity The {@link Entity} caught by the player, can be null
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static PlayerRetractFishingLineEvent createPlayerRetractFishingLine(Game game, Player entity, FishHook fishHook, ItemStack caughtItem,
            Entity caughtEntity, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", Optional.fromNullable(caughtEntity));
        values.put("caughtItem", Optional.fromNullable(caughtItem));
        values.put("exp", exp);
        return createEvent(PlayerRetractFishingLineEvent.class, values);
    }

    /**
     * Creates a new {@link ChangeBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param transactions The block transactions
     * @return A new instance of the event
     */
    public static ChangeBlockEvent createPlayerChangeBlock(Game game, Cause cause, ImmutableList<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return createEvent(ChangeBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChangeBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The player
     * @param blockFace The face of the block the player was changing
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static PlayerChangeBlockEvent createPlayerChangeBlock(Game game, Cause cause, Player entity, Direction blockFace, Location<World> location,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("blockFace", blockFace);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(PlayerChangeBlockEvent.class, values);
    }

    /**
     * Creates a new {@link ChangePlayerGameModeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param newGameMode The game mode to change to
     * @param oldGameMode The Player's old game mode
     * @return A new instance of the event
     */
    public static ChangePlayerGameModeEvent createChangePlayerGameMode(Game game, Player entity, GameMode newGameMode, GameMode oldGameMode) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("newGameMode", newGameMode);
        values.put("oldGameMode", oldGameMode);
        return createEvent(ChangePlayerGameModeEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChatEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param message The message to say
     * @param unformattedMessage The unformatted message
     * @param sink The destination for the message
     * @return A new instance of the event
     */
    public static PlayerChatEvent createPlayerChat(Game game, Player entity, Text message, Text unformattedMessage, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("source", entity);
        values.put("user", entity);
        values.put("message", message);
        values.put("newMessage", message);
        values.put("unformattedMessage", unformattedMessage);
        values.put("sink", sink);
        return createEvent(PlayerChatEvent.class, values);
    }

    /**
     * Creates a new {@link HarvestPlayerEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The player
     * @param location The location of death
     * @param message The message to show to the player because they died
     * @param sink The destination for the message
     * @param exp The experience to give, or take for negative values
     * @param newExperience The new experience the player will have towards the next level
     * @param newLevel The new level the player will have after death
     * @param keepsLevel Whether the player keeps all of their exp on death
     * @param keepsInventory Whether the player should keep inventory
     * @return A new instance of the event
     */
    public static HarvestPlayerEvent createHarvestPlayer(Game game, Cause cause, Player entity, Location<World> location, Text message, MessageSink sink,
            int exp, int newExperience, int newLevel, boolean keepsLevel, boolean keepsInventory) {

        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("source", entity);
        values.put("user", entity);
        values.put("location", location);
        values.put("message", message);
        values.put("newMessage", message);
        values.put("sink", sink);
        values.put("exp", exp);
        values.put("newExperience", newExperience);
        values.put("newLevel", newLevel);
        values.put("keepsLevel", keepsLevel);
        values.put("keepsInventory", keepsInventory);
        return createEvent(HarvestPlayerEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerDropItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param cause The cause of the event
     * @param droppedItems The items to drop
     * @return A new instance of the event
     */
    public static PlayerDropItemEvent createPlayerDropItem(Game game, Player entity, Cause cause, Collection<ItemStack> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("droppedItems", droppedItems);
        return createEvent(PlayerDropItemEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerHarvestBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The player
     * @param location The location
     * @param droppedItems The items to drop
     * @param dropChance The chance the items will drop, see
     *        {@link HarvestBlockEvent#setDropChance(float)}
     * @param silkTouch Whether the player is harvesting with silk touch
     * @return A new instance of the event
     */
    public static PlayerHarvestBlockEvent createPlayerHarvestBlock(Game game, Cause cause, Player entity, Location<World> location,
            Collection<ItemStack> droppedItems, float dropChance, boolean silkTouch) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
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
     * @param entity The player
     * @param location The location
     * @param side The face interacted with as a direction
     * @param interactionType The type of interaction used
     * @param clickedPosition The clicked position
     * @return A new instance of the event
     */
    public static PlayerInteractBlockEvent createPlayerInteractBlock(Game game, Cause cause, Player entity, Location<World> location, Direction side,
            EntityInteractionType interactionType, @Nullable Vector3d clickedPosition) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("side", side);
        values.put("interactionType", interactionType);
        values.put("clickedPosition", Optional.fromNullable(clickedPosition));
        return createEvent(PlayerInteractBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerInteractEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param targetEntity The entity being interacted with
     * @param interactionType The type of interaction used
     * @param clickedPosition The clicked position
     * @return A new instance of the event
     */
    public static PlayerInteractEntityEvent createPlayerInteractEntity(Game game, Player entity, Entity targetEntity,
            EntityInteractionType interactionType, @Nullable Vector3d clickedPosition) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("targetEntity", targetEntity);
        values.put("interactionType", interactionType);
        values.put("clickedPosition", Optional.fromNullable(clickedPosition));
        return createEvent(PlayerInteractEntityEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerJoinEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param location The location of where the player is joining
     * @param message The message displayed when the player joins
     * @param sink The destination for the message
     * @return A new instance of the event
     */
    public static PlayerJoinEvent createPlayerJoin(Game game, Player entity, Location<World> location, Text message, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("source", entity);
        values.put("location", location);
        values.put("message", message);
        values.put("newMessage", message);
        values.put("sink" ,sink);
        return createEvent(PlayerJoinEvent.class, values);
    }

    /**
     * Creates a new {@link MovePlayerEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @return A new instance of the event
     */
    public static MovePlayerEvent createMovePlayer(Game game, Player entity, Transform<World> oldTransform, Transform<World> newTransform, Transform<World> targetTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", entity);
        values.put("oldTransform", oldTransform);
        values.put("newTransform", newTransform);
        values.put("targetTransform", targetTransform);
        return createEvent(MovePlayerEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerPickupItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param items The items that will be picked up
     * @param inventory The inventory involved with the event
     * @return A new instance of the event
     */
    public static PlayerPickupItemEvent createPlayerPickupItem(Game game, Player entity, Collection<Entity> items, Inventory inventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("items", items);
        values.put("inventory", inventory);
        return createEvent(PlayerPickupItemEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerPlaceBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The player
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @param blockFace The face the block was placed
     * @return A new instance of the event
     */
    public static PlayerPlaceBlockEvent createPlayerPlaceBlock(Game game, Cause cause, Player entity, Location<World> location,
            BlockSnapshot replacementBlock, Direction blockFace) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        values.put("blockFace", blockFace);
        return createEvent(PlayerPlaceBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerQuitEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param message The message to display to the player because they quit
     * @param sink The destination for the message
     * @return A new instance of the event
     */
    public static PlayerQuitEvent createPlayerQuit(Game game, Player entity, Text message, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("source", entity);
        values.put("user", entity);
        values.put("message", message);
        values.put("newMessage", message);
        values.put("sink", sink);
        return createEvent(PlayerQuitEvent.class, values);
    }

    /**
     * Creates a new {@link RespawnPlayerEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param bedSpawn Whether this respawn is to a bed
     * @param respawnLocation The location the player will spawn in
     * @return A new instance of the event
     */
    public static RespawnPlayerEvent createRespawnPlayer(Game game, Player entity, Location<World> respawnLocation, boolean bedSpawn) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("respawnLocation", respawnLocation);
        values.put("newRespawnLocation", respawnLocation);
        values.put("bedSpawn", bedSpawn);
        return createEvent(RespawnPlayerEvent.class, values);
    }

    /**
     * Creates a new {@link AchievementEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param achievement The achievement being added to the player
     * @return A new instance of the event
     */
     /* TODO
     public static AchievementEvent createAchievement(Game game, Player entity, Achievement achievement) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("achievement", achievement);
        return createEvent(AchievementEvent.class, values);
    }*/

    /**
     * Creates a new {@link PlayerChangeStatisticEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param changedStatistic Any statistics changed by this event
     * @param oldValue The old value of the statistic
     * @param newValue The new value of the statistic
     * @return A new instance of the event
     */
    public static PlayerChangeStatisticEvent createPlayerChangeStatistic(Game game, Player entity, Statistic changedStatistic, long newValue,
            long oldValue) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("changedStatistic", changedStatistic);
        values.put("newValue", newValue);
        values.put("oldValue", oldValue);
        return createEvent(PlayerChangeStatisticEvent.class, values);
    }

    /**
     * Creates a new {@link ChangeWorldWeatherEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param weatherUniverse The universe the weather changed in
     * @param initialWeather The previous weather
     * @param resultingWeather The weather to change to
     * @param duration The lenfth of the resulting weather, in ticks
     * @return A new instance of the event
     */
    public static ChangeWorldWeatherEvent createChangeWorldWeather(Game game, WeatherUniverse weatherUniverse, Weather initialWeather,
            Weather resultingWeather, int duration) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("weatherUniverse", weatherUniverse);
        values.put("initialWeather", initialWeather);
        values.put("resultingWeather", resultingWeather);
        values.put("duration", duration);
        return createEvent(ChangeWorldWeatherEvent.class, values);
    }

    /**
     * Creates a new {@link PluginForceChunkEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param ticket The ticket that will load the chunk
     * @param chunkCoords The coordinates of the chunk being added
     * @return A new instance of the event
     */
    public static PluginForceChunkEvent createPluginForceChunk(Game game, LoadingTicket ticket, Vector3i chunkCoords) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("ticket", ticket);
        values.put("chunkCoords", chunkCoords);
        return createEvent(PluginForceChunkEvent.class, values);
    }

    /**
     * Creates a new {@link LoadChunkEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static LoadChunkEvent createLoadChunk(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(LoadChunkEvent.class, values);
    }

    /**
     * Creates a new {@link WorldPostGenerateChunkEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static WorldPostGenerateChunkEvent createWorldPostGenerateChunk(Game game, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return createEvent(WorldPostGenerateChunkEvent.class, values);
    }

    /**
     * Creates a new {@link WorldPostPopulateChunkEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static WorldPostPopulateChunkEvent createWorldPostPopulateChunk(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(WorldPostPopulateChunkEvent.class, values);
    }

    /**
     * Creates a new {@link WorldPreGenerateChunkEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static WorldPreGenerateChunkEvent createWorldPreGenerateChunk(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(WorldPreGenerateChunkEvent.class, values);
    }

    /**
     * Creates a new {@link WorldPrePopulateChunkEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @param pendingPopulators All populator's that will populate the chunk
     * @return A new instance of the event
     */
    public static WorldPrePopulateChunkEvent createWorldPrePopulateChunk(Game game, Chunk chunk, List<Populator> pendingPopulators) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        values.put("pendingPopulators", pendingPopulators);
        return createEvent(WorldPrePopulateChunkEvent.class, values);
    }

    /**
     * Creates a new {@link UnforcedChunkEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param ticket The ticket the chunk was removed from
     * @param chunkCoords The coordinates of the removed chunk*
     * @return A new instance of the event
     */
    public static UnforcedChunkEvent createUnforcedChunk(Game game, LoadingTicket ticket, Vector3i chunkCoords) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("ticket", ticket);
        values.put("chunkCoords", chunkCoords);
        return createEvent(UnforcedChunkEvent.class, values);
    }

    /**
     * Creates a new {@link UnloadChunkEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param chunk The chunk involved in this event
     * @return A new instance of the event
     */
    public static UnloadChunkEvent createUnloadChunk(Game game, Chunk chunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("chunk", chunk);
        return createEvent(UnloadChunkEvent.class, values);
    }

    /**
     * Creates a new {@link ChangeWorldGameRuleEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param world The world involved in this event
     * @param name The name of the game rule
     * @param oldValue The previous value for the rule
     * @param newValue The new value for the rule
     * @return A new instance of the event
     */
    public static ChangeWorldGameRuleEvent createChangeWorldGameRule(Game game, World world, String name, String oldValue, String newValue) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", world);
        values.put("name", name);
        values.put("oldValue", oldValue);
        values.put("newValue", newValue);
        return createEvent(ChangeWorldGameRuleEvent.class, values);
    }

    /**
     * Creates a new {@link CreateWorldEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param properties The properties of the new world
     * @param settings The creation settings
     * @return A new instance of the event
     */
    public static ServerCreateWorldEvent createServerCreateWorld(Game game, WorldProperties properties, WorldCreationSettings settings) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Cause.of(game.getServer()));
        values.put("worldProperties", properties);
        values.put("worldCreationSettings", settings);
        return createEvent(ServerCreateWorldEvent.class, values);
    }

    /**
     * Creates a new {@link ServerLoadWorldEvent}.
     *
     * @param cause The cause
     * @param game The game instance for this {@link GameEvent}
     * @param world The world involved in this event
     * @return A new instance of the event
     */
    public static ServerLoadWorldEvent createServerLoadWorld(Game game, World world) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Cause.of(game.getServer()));
        values.put("world", world);
        return createEvent(ServerLoadWorldEvent.class, values);
    }

    /**
     * Creates a new {@link ServerUnloadWorldEvent}.
     *
     * @param cause The cause
     * @param game The game instance for this {@link GameEvent}
     * @param world The world involved in this event
     * @return A new instance of the event
     */
    public static ServerUnloadWorldEvent createServerUnloadWorld(Game game, World world) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Cause.of(game.getServer()));
        values.put("world", world);
        return createEvent(ServerUnloadWorldEvent.class, values);
    }

    /**
     * Creates a new {@link PingServerEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param client The client that is pinging the server
     * @param response The response to send to the client
     * @return A new instance of the event
     */
    public static PingServerEvent createPingServer(Game game, StatusClient client, PingServerEvent.Response response) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("client", client);
        values.put("response", response);
        return createEvent(PingServerEvent.class, values);
    }

    /**
     * Creates a new {@link BrewingStandBrewItemsEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause
     * @param brewingStand The {@link BrewingStand} involved in this event
     * @param sourceItems The {@link ItemStack}s being modified
     * @param fuelSource The {@link ItemStack} used as the reagent to modify the source items
     * @param brewedItems The {@link ItemStack}s produced as a result
     * @param inventory The inventory of the brewing stand
     * @param data The brewing stand data
     * @param location The location
     * @return A new instance of the event
     */
    public static BrewingStandBrewItemsEvent createBrewingStandBrewItems(Game game, Cause cause, BrewingStand brewingStand, ImmutableBrewingData data,
            List<ItemStack> sourceItems, ItemStack fuelSource, List<ItemStack> brewedItems, TileEntityInventory<TileEntityCarrier> inventory,
            Location<World> location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("tile", brewingStand);
        values.put("sourceItems", sourceItems);
        values.put("fuelSource", fuelSource);
        values.put("brewedItems", brewedItems);
        values.put("results", brewedItems);
        values.put("inventory", inventory);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("currentData", data);
        return createEvent(BrewingStandBrewItemsEvent.class, values);
    }

    /**
     * Creates a new {@link FurnaceConsumeFuelEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause
     * @param furnace The {@link Furnace} involved in this event
     * @param burnedItem The {@link ItemStack} consumed for fuel
     * @param remainingFuel The {@link ItemStack} representing the remaining fuel, can be null
     * @param inventory The inventory of the furnace
     * @param data The furnace data
     * @param location The location
     * @return A new instance of the event
     */
    public static FurnaceConsumeFuelEvent createFurnaceConsumeFuel(Game game, Cause cause, Furnace furnace, ImmutableFurnaceData data,
            ItemStack burnedItem, ItemStack remainingFuel, TileEntityInventory<TileEntityCarrier> inventory, Location<World> location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("tile", furnace);
        values.put("burnedItem", burnedItem);
        values.put("remainingFuel", Optional.fromNullable(remainingFuel));
        values.put("result", Optional.fromNullable(remainingFuel));
        values.put("inventory", inventory);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("currentData", data);
        return createEvent(FurnaceConsumeFuelEvent.class, values);
    }

    /**
     * Creates a new {@link FurnaceSmeltItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause
     * @param furnace The {@link Furnace} involved in this event
     * @param cookedItem The {@link ItemStack} resulting from smelting the source item
     * @param sourceItem The {@link ItemStack} smelted to create the cooked item
     * @param inventory The inventory of the furnace
     * @param data The furnace data
     * @param location The location
     * @return A new instance of the event
     */
    public static FurnaceSmeltItemEvent createFurnaceSmeltItem(Game game, Cause cause, Furnace furnace, ImmutableFurnaceData data, ItemStack
            cookedItem, ItemStack sourceItem, TileEntityInventory<TileEntityCarrier> inventory, Location<World> location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("tile", furnace);
        values.put("cookedItem", cookedItem);
        values.put("sourceItem", sourceItem);
        values.put("result", Optional.fromNullable(cookedItem));
        values.put("inventory", inventory);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("currentData", data);
        return createEvent(FurnaceSmeltItemEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChangeSignEvent}.
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause
     * @param sign The {@link Sign}
     * @param currentData The current sign data
     * @param newData The new sign data
     * @return A new instance of the event
     */
    public static PlayerChangeSignEvent createPlayerChangeSign(Game game, Cause cause, Sign sign, ImmutableSignData currentData, SignData newData) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("tile", sign);
        values.put("currentData", currentData);
        values.put("newData", newData);
        return createEvent(PlayerChangeSignEvent.class, values);
    }

    /**
     * Creates a new {@link RconLoginEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param source The {@link RconSource} that caused this event
     * @return A new instance of the event
     */
    public static RconLoginEvent createRconLogin(Game game, RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        return createEvent(RconLoginEvent.class, values);
    }

    /**
     * Creates a new {@link RconQuitEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param source The {@link RconSource} that caused this event
     * @return A new instance of the event
     */
    public static RconQuitEvent createRconQuit(Game game, RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        return createEvent(RconQuitEvent.class, values);
    }

    /**
     * Creates a new {@link GameClientConnectEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param connection The connection info of the client
     * @param profile The profile of the client attempting to connect
     * @param disconnectMessage The message to show to the client if the event
     *        is cancelled
     * @param disconnectCause The cause for disconnected if the event is cancelled
     * @return A new instance of the event
     */
    public static GameClientConnectEvent createGameClientConnect(Game game, RemoteConnection connection, GameProfile profile,
            @Nullable Text disconnectMessage, @Nullable Cause disconnectCause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("connection", connection);
        values.put("profile", profile);
        values.put("disconnectMessage", Optional.fromNullable(disconnectMessage));
        values.put("disconnectCause", Optional.fromNullable(disconnectCause));
        return createEvent(GameClientConnectEvent.class, values);
    }

    /**
     * Creates a new {@link GameClientAuthEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param connection The connection info of the client
     * @param profile The profile of the client attempting to connect
     * @param disconnectMessage The message to show to the client if the event
     *        is cancelled
     * @param disconnectCause The cause for disconnected if the event is cancelled
     * @return A new instance of the event
     */
    public static GameClientAuthEvent createGameClientAuth(Game game, RemoteConnection connection, GameProfile profile,
            @Nullable Text disconnectMessage, @Nullable Cause disconnectCause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("connection", connection);
        values.put("profile", profile);
        values.put("disconnectMessage", Optional.fromNullable(disconnectMessage));
        values.put("disconnectCause", Optional.fromNullable(disconnectCause));
        return createEvent(GameClientAuthEvent.class, values);
    }

    /**
     * Creates a new {@link WorldDecayBlockEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static WorldDecayBlockEvent createWorldDecayBlock(Game game, Cause cause, World world, ImmutableList<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("world", world);
        values.put("transactions", transactions);
        return createEvent(WorldDecayBlockEvent.class, values);
    }

    /**
     * Creates a new {@link WorldExplosionEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param explosion The explosion
     * @return A new instance of the event
     */
    public static WorldExplosionEvent createWorldExplosion(Game game, Explosion explosion) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", explosion.getWorld());
        values.put("explosion", explosion);
        return createEvent(WorldExplosionEvent.class, values);
    }

    /**
     * Creates a new {@link WorldPreExplosionEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param explosion The explosion
     * @return A new instance of the event
     */
    public static WorldPreExplosionEvent createWorldPreExplosion(Game game, Explosion explosion) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("world", explosion.getWorld());
        values.put("explosion", explosion);
        return createEvent(WorldPreExplosionEvent.class, values);
    }

    /**
     * Creates a new {@link WorldOnExplosionEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param explosion The explosion
     * @param locations The affected locations
     * @param entities The affected entities
     * @return A new instance of the event
     */
    public static WorldOnExplosionEvent createWorldOnExplosion(Game game, Cause cause, Explosion explosion, List<Location<World>> locations,
            List<Entity> entities) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("world", explosion.getWorld());
        values.put("explosion", explosion);
        values.put("locations", locations);
        values.put("originalLocations", ImmutableList.copyOf(locations));
        values.put("entities", entities);
        values.put("originalEntities", ImmutableList.copyOf(entities));
        return createEvent(WorldOnExplosionEvent.class, values);
    }
}
