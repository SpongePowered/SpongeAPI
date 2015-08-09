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
import com.google.common.collect.Maps;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
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
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.living.Ageable;
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
import org.spongepowered.api.event.block.BlockRedstoneUpdateEvent;
import org.spongepowered.api.event.block.BlockUpdateEvent;
import org.spongepowered.api.event.block.FloraGrowEvent;
import org.spongepowered.api.event.block.FluidSpreadEvent;
import org.spongepowered.api.event.block.LeafDecayEvent;
import org.spongepowered.api.event.block.tileentity.BrewingStandBrewEvent;
import org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent;
import org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent;
import org.spongepowered.api.event.block.tileentity.SignChangeEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.entity.EntityBreakBlockEvent;
import org.spongepowered.api.event.entity.EntityBreedEvent;
import org.spongepowered.api.event.entity.EntityChangeBlockEvent;
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
import org.spongepowered.api.event.entity.EntityLeashEvent;
import org.spongepowered.api.event.entity.EntityMountEvent;
import org.spongepowered.api.event.entity.EntityMoveEvent;
import org.spongepowered.api.event.entity.EntityPickUpItemEvent;
import org.spongepowered.api.event.entity.EntityPlaceBlockEvent;
import org.spongepowered.api.event.entity.EntitySpawnEvent;
import org.spongepowered.api.event.entity.EntityTameEvent;
import org.spongepowered.api.event.entity.EntityTeleportEvent;
import org.spongepowered.api.event.entity.EntityUnleashEvent;
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
import org.spongepowered.api.event.entity.player.PlayerRespawnEvent;
import org.spongepowered.api.event.entity.player.PlayerUpdateEvent;
import org.spongepowered.api.event.entity.player.fishing.PlayerCastFishingLineEvent;
import org.spongepowered.api.event.entity.player.fishing.PlayerHookedEntityEvent;
import org.spongepowered.api.event.entity.player.fishing.PlayerRetractFishingLineEvent;
import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.event.message.CommandSuggestionsEvent;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.event.network.GameClientAuthEvent;
import org.spongepowered.api.event.network.GameClientConnectEvent;
import org.spongepowered.api.event.rcon.RconLoginEvent;
import org.spongepowered.api.event.rcon.RconQuitEvent;
import org.spongepowered.api.event.server.StatusPingEvent;
import org.spongepowered.api.event.state.StateEvent;
import org.spongepowered.api.event.statistic.AchievementEvent;
import org.spongepowered.api.event.statistic.StatisticChangeEvent;
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
import org.spongepowered.api.event.world.WorldCreateEvent;
import org.spongepowered.api.event.world.WorldLoadEvent;
import org.spongepowered.api.event.world.WorldUnloadEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.type.TileEntityInventory;
import org.spongepowered.api.network.RemoteConnection;
import org.spongepowered.api.service.world.ChunkLoadService.LoadingTicket;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.achievement.Achievement;
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
     * Creates a new {@link StateEvent} of the given type.
     *
     * @param type The type of the state event
     * @param game The game instance for this {@link GameEvent}
     * @param <T> The type of the state event
     * @return A new instance of the event
     */
    public static <T extends StateEvent> T createState(Class<T> type, Game game) {
        Map<String, Object> values = Maps.newHashMapWithExpectedSize(1);
        values.put("game", game);
        return createEvent(type, values);
    }

    /**
     * Creates a new {@link BlockBreakEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static BlockBreakEvent createBlockBreak(Game game, Cause cause, Location location, BlockSnapshot replacementBlock,
            int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        values.put("exp", exp);
        return createEvent(BlockBreakEvent.class, values);
    }

    /**
     * Creates a new {@link BlockBurnEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockBurnEvent createBlockBurn(Game game, Cause cause, Location location, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockBurnEvent.class, values);
    }

    /**
     * Creates a new {@link BlockChangeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockChangeEvent createBlockChange(Game game, Cause cause, Location location, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockChangeEvent.class, values);
    }

    /**
     * Creates a new {@link BlockDispenseEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param velocity The velocity to dispense the item at
     * @param dispensedItem The item to dispense from the block
     * @return A new instance of the event
     */
    public static BlockDispenseEvent createBlockDispense(Game game, Cause cause, Location location, Vector3d velocity, ItemStack
            dispensedItem) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("velocity", velocity);
        values.put("dispensedItem", dispensedItem);
        return createEvent(BlockDispenseEvent.class, values);
    }

    /**
     * Creates a new {@link BlockHarvestEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param droppedItems The items to drop
     * @param dropChance The chance the items will drop, see
     *        {@link BlockHarvestEvent#setDropChance(float)}
     * @return A new instance of the event
     */
    public static BlockHarvestEvent createBlockHarvest(Game game, Cause cause, Location location, Collection<ItemStack>
            droppedItems, float dropChance) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("droppedItems", droppedItems);
        values.put("dropChance", dropChance);
        return createEvent(BlockHarvestEvent.class, values);
    }

    /**
     * Creates a new {@link BlockIgniteEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @return A new instance of the event
     */
    public static BlockIgniteEvent createBlockIgnite(Game game, Cause cause, Location location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        return createEvent(BlockIgniteEvent.class, values);
    }

    /**
     * Creates a new {@link BlockInteractEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param side The face interacted with as a direction
     * @return A new instance of the event
     */
    public static BlockInteractEvent createBlockInteract(Game game, Cause cause, Location location, Direction side) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("side", side);
        return createEvent(BlockInteractEvent.class, values);
    }

    /**
     * Creates a new {@link BlockMoveEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param locations The locations
     * @return A new instance of the event
     */
    public static BlockMoveEvent createBlockMove(Game game, Cause cause, List<Location> locations) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("locations", locations);
        return createEvent(BlockMoveEvent.class, values);
    }

    /**
     * Creates a new {@link BlockPlaceEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location the location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static BlockPlaceEvent createBlockPlace(Game game, Cause cause, Location location, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(BlockPlaceEvent.class, values);
    }

    /**
     * Creates a new {@link BlockRandomTickEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @return A new instance of the event
     */
    public static BlockRandomTickEvent createBlockRandomTick(Game game, Cause cause, Location location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        return createEvent(BlockRandomTickEvent.class, values);
    }

    /**
     * Creates a new {@link BlockUpdateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param locations The locations affected
     * @return A new instance of the event
     */
    public static BlockUpdateEvent createBlockUpdate(Game game, Cause cause, Location location, List<Location> locations) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("locations", locations);
        return createEvent(BlockUpdateEvent.class, values);
    }

    /**
     * Create a new {@link BlockRedstoneUpdateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param locations The affected locations
     * @param oldCurrent The previous signal strength of the redstone
     * @param newCurrent The updated signal strength of the redstone
     * @return A new instance of the event
     */
    public static BlockRedstoneUpdateEvent createBlockRedstoneUpdate(Game game, Cause cause, Location location, List<Location> locations
            , int oldCurrent, int newCurrent) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("locations", locations);
        values.put("oldSignalStrength", oldCurrent);
        values.put("newSignalStrength", newCurrent);
        return createEvent(BlockRedstoneUpdateEvent.class, values);
    }

    /**
     * Creates a new {@link FloraGrowEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static FloraGrowEvent createFloraGrow(Game game, Cause cause, Location location, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(FloraGrowEvent.class, values);
    }

    /**
     * Creates a new {@link FluidSpreadEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param locations The affected locations
     * @return A new instance of the event
     */
    public static FluidSpreadEvent createFluidSpread(Game game, Cause cause, Location location, List<Location> locations) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("locations", locations);
        return createEvent(FluidSpreadEvent.class, values);
    }

    /**
     * Creates a new {@link LeafDecayEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param location The location
     * @param block The block
     * @param replacementBlock The block that will replace the existing block
     * @return A new instance of the event
     */
    public static LeafDecayEvent createLeafDecay(Game game, Cause cause, Location location, BlockState block, BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", block);
        values.put("replacementBlock", replacementBlock);
        return createEvent(LeafDecayEvent.class, values);
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
    public static EntityBreakBlockEvent createEntityBreakBlock(Game game, Cause cause, Entity entity, Location location,
            BlockSnapshot replacementBlock, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        values.put("exp", exp);
        return createEvent(EntityBreakBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityBreedEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param parent The parent of the entity
     * @param otherParent The other parent of the entity
     * @return A new instance of the event
     */
    public static EntityBreedEvent createEntityBreed(Game game, Ageable entity, Ageable parent, Ageable otherParent) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("parent", parent);
        values.put("otherParent", otherParent);
        return createEvent(EntityBreedEvent.class, values);
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
    public static EntityChangeBlockEvent createEntityChangeBlock(Game game, Cause cause, Entity entity, Location location,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(EntityChangeBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityCollisionEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
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
     * @param entity The entity
     * @param location The location
     * @return A new instance of the event
     */
    public static EntityCollisionWithBlockEvent createEntityCollisionWithBlock(Game game, Cause cause, Entity entity, Location location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        return createEvent(EntityCollisionWithBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntityCollisionWithEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause of the event, can be null
     * @param entity The entity
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
     * @param entity The entity
     * @param location The location
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static EntityDeathEvent createEntityDeath(Game game, Cause cause, Entity entity, Location location, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("location", location);
        values.put("exp", exp);
        return createEvent(EntityDeathEvent.class, values);
    }

    /**
     * Creates a new {@link EntityDismountEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
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
     * @param entity The entity
     * @param oldLocation The previous location
     * @param newLocation The new location
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
     * @param cause The cause of this event
     * @param entity The entity
     * @param droppedItems The items to drop
     * @return A new instance of the event
     */
    public static EntityDropItemEvent createEntityDropItem(Game game, Cause cause, Entity entity, Collection<ItemStack> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
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
     *        {@link BlockHarvestEvent#setDropChance(float)}
     * @return A new instance of the event
     */
    public static EntityHarvestBlockEvent createEntityHarvestBlock(Game game, Cause cause, Entity entity, Location location,
            Collection<ItemStack> droppedItems, float dropChance) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
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
     * @param entity The entity
     * @param location The location
     * @param side The side of the block affected
     * @return A new instance of the event
     */
    public static EntityInteractBlockEvent createEntityInteractBlock(Game game, Cause cause, Entity entity, Location location, Direction side) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);        
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("side", side);
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
     * Creates a new {@link EntityInteractEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @return A new instance of the event
     */
    public static EntityInteractEvent createEntityInteract(Game game, Entity entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        return createEvent(EntityInteractEvent.class, values);
    }

    /**
     * Creates a new {@link EntityLeashEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param leashHolder The entity holding the leash
     * @return A new instance of the event
     */
    public static EntityLeashEvent createEntityLeash(Game game, Entity entity, Entity leashHolder) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("leashHolder", leashHolder);
        return createEvent(EntityLeashEvent.class, values);
    }

    /**
     * Creates a new {@link EntityLeashEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param leashHolder The entity holding the leash
     * @return A new instance of the event
     */
    public static EntityUnleashEvent createEntityUnleash(Game game, Entity entity, Entity leashHolder) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("leashHolder", leashHolder);
        return createEvent(EntityUnleashEvent.class, values);
    }

    /**
     * Creates a new {@link EntityMountEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
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
     * @param entity The entity
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @return A new instance of the event
     */
    public static EntityMoveEvent createEntityMove(Game game, Entity entity, Location oldLocation, Location newLocation, Vector3d rotation) {
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
     * @param entity The entity
     * @param items The items that will be picked up
     * @param inventory The inventory involved with the event
     * @return A new instance of the event
     */
    public static EntityPickUpItemEvent createEntityPickUpItem(Game game, Entity entity, Collection<Entity> items, Inventory inventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("items", items);
        values.put("inventory", inventory);
        return createEvent(EntityPickUpItemEvent.class, values);
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
    public static EntityPlaceBlockEvent createEntityPlaceBlock(Game game, Cause cause, Entity entity, Location location,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("entity", entity);
        values.put("replacementBlock", replacementBlock);
        return createEvent(EntityPlaceBlockEvent.class, values);
    }

    /**
     * Creates a new {@link EntitySpawnEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The entity
     * @param location The location
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
     * @param entity The entity
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
     * @param entity The entity
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
     * @param entity The entity
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
     * @param entity The entity
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
     * @param entity The entity
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
     * @param result The result of the command
     * @return A new instance of the event
     */
    public static CommandEvent createCommand(Game game, String arguments, CommandSource source, String command, CommandResult result) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("arguments", arguments);
        values.put("source", source);
        values.put("command", command);
        values.put("result", result);
        return createEvent(CommandEvent.class, values);
    }

    /**
     * Creates a new {@link CommandSuggestionsEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param arguments The arguments provided
     * @param source The source of the command
     * @param command The command name
     * @param suggestions The list of suggestion. Must be mutable.
     * @return A new instance of the event
     */
    public static CommandSuggestionsEvent createCommandSuggestions(Game game, String arguments, CommandSource source, String command,
            List<String> suggestions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("arguments", arguments);
        values.put("source", source);
        values.put("command", command);
        values.put("suggestions", suggestions);
        return createEvent(CommandSuggestionsEvent.class, values);
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
     * @param blockFace The block face the player was breaking
     * @param location The location
     * @param replacementBlock The block that will replace the existing block
     * @param exp The experience to give, or take for negative values
     * @return A new instance of the event
     */
    public static PlayerBreakBlockEvent createPlayerBreakBlock(Game game, Cause cause, Player entity, Direction blockFace, Location location,
            BlockSnapshot replacementBlock, int exp) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("user", entity);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        values.put("blockFace", blockFace);
        values.put("exp", exp);
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
    public static PlayerCastFishingLineEvent createPlayerCastFishingLineEvent(Game game, Player entity, FishHook fishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("fishHook", fishHook);
        return createEvent(PlayerCastFishingLineEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerHookedEntityEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param fishHook The {@link FishHook} affected by this event
     * @param caughtEntity The {@link Entity} caught by the player, can be null
     * @return A new instance of the event
     */
    public static PlayerHookedEntityEvent createPlayerHookedEntityEvent(Game game, Player entity, FishHook fishHook, Entity caughtEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("fishHook", fishHook);
        values.put("caughtEntity", Optional.fromNullable(caughtEntity));
        return createEvent(PlayerHookedEntityEvent.class, values);
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
    public static PlayerRetractFishingLineEvent createPlayerRetractFishingLineEvent(Game game, Player entity, FishHook fishHook, ItemStack caughtItem,
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
    public static PlayerChangeBlockEvent createPlayerChangeBlock(Game game, Cause cause, Player entity, Direction blockFace, Location location,
            BlockSnapshot replacementBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("entity", entity);
        values.put("user", entity);
        values.put("blockFace", blockFace);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("replacementBlock", replacementBlock);
        return createEvent(PlayerChangeBlockEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChangeGameModeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param newGameMode The game mode to change to
     * @param oldGameMode The Player's old game mode
     * @return A new instance of the event
     */
    public static PlayerChangeGameModeEvent createPlayerChangeGameMode(Game game, Player entity, GameMode newGameMode, GameMode oldGameMode) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("newGameMode", newGameMode);
        values.put("oldGameMode", oldGameMode);
        return createEvent(PlayerChangeGameModeEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerChangeWorldEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param fromWorld The world the player was in
     * @param toWorld The world the player is changing to
     * @return A new instance of the event
     */
    public static PlayerChangeWorldEvent createPlayerChangeWorld(Game game, Player entity, World fromWorld, World toWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("fromWorld", fromWorld);
        values.put("toWorld", toWorld);
        return createEvent(PlayerChangeWorldEvent.class, values);
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
     * Creates a new {@link PlayerDeathEvent}.
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
    public static PlayerDeathEvent createPlayerDeath(Game game, Cause cause, Player entity, Location location, Text message, MessageSink sink,
            int exp, int newExperience, int newLevel, boolean keepsLevel, boolean keepsInventory) {

        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
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
        return createEvent(PlayerDeathEvent.class, values);
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
        values.put("cause", Optional.fromNullable(cause));
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
     *        {@link BlockHarvestEvent#setDropChance(float)}
     * @param silkTouch Whether the player is harvesting with silk touch
     * @return A new instance of the event
     */
    public static PlayerHarvestBlockEvent createPlayerHarvestBlock(Game game, Cause cause, Player entity, Location location,
            Collection<ItemStack> droppedItems, float dropChance, boolean silkTouch) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
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
    public static PlayerInteractBlockEvent createPlayerInteractBlock(Game game, Cause cause, Player entity, Location location, Direction side,
            EntityInteractionType interactionType, @Nullable Vector3d clickedPosition) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
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
     * Creates a new {@link PlayerInteractEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param interactionType The type of interaction used
     * @param location The location of the interaction
     * @return A new instance of the event
     */
    public static PlayerInteractEvent createPlayerInteract(Game game, Player entity, EntityInteractionType interactionType,
            @Nullable Vector3d location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("interactionType", interactionType);
        values.put("clickedPosition", Optional.fromNullable(location));
        return createEvent(PlayerInteractEvent.class, values);
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
    public static PlayerJoinEvent createPlayerJoin(Game game, Player entity, Location location, Text message, MessageSink sink) {
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
     * Creates a new {@link PlayerMoveEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param oldLocation The previous location of the entity
     * @param newLocation The new location of the entity
     * @param rotation The rotation the entity is facing
     * @return A new instance of the event
     */
    public static PlayerMoveEvent createPlayerMove(Game game, Player entity, Location oldLocation, Location newLocation, Vector3d rotation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("oldLocation", oldLocation);
        values.put("newLocation", newLocation);
        values.put("rotation", rotation);
        return createEvent(PlayerMoveEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerPickUpItemEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param items The items that will be picked up
     * @param inventory The inventory involved with the event
     * @return A new instance of the event
     */
    public static PlayerPickUpItemEvent createPlayerPickUpItem(Game game, Player entity, Collection<Entity> items, Inventory inventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("items", items);
        values.put("inventory", inventory);
        return createEvent(PlayerPickUpItemEvent.class, values);
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
    public static PlayerPlaceBlockEvent createPlayerPlaceBlock(Game game, Cause cause, Player entity, Location location,
            BlockSnapshot replacementBlock, Direction blockFace) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
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
     * Creates a new {@link PlayerRespawnEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param bedSpawn Whether this respawn is to a bed
     * @param respawnLocation The location the player will spawn in
     * @return A new instance of the event
     */
    public static PlayerRespawnEvent createPlayerRespawn(Game game, Player entity, Location respawnLocation, boolean bedSpawn) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("respawnLocation", respawnLocation);
        values.put("newRespawnLocation", respawnLocation);
        values.put("bedSpawn", bedSpawn);
        return createEvent(PlayerRespawnEvent.class, values);
    }

    /**
     * Creates a new {@link PlayerUpdateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @return A new instance of the event
     */
    public static PlayerUpdateEvent createPlayerUpdate(Game game, Player entity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        return createEvent(PlayerUpdateEvent.class, values);
    }

    /**
     * Creates a new {@link LightningStrikeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param weatherUniverse The universe the weather changed in
     * @param entity The lightning strike
     * @param entities The affected entities
     * @param locations The affected locations
     * @return A new instance of the event
     */
    public static LightningStrikeEvent createLightningStrike(Game game, Cause cause, WeatherUniverse weatherUniverse, Lightning entity, List<Entity>
            entities,
            List<Location> locations) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("weatherUniverse", weatherUniverse);
        values.put("entity", entity);
        values.put("entities", entities);
        values.put("locations", locations);
        return createEvent(LightningStrikeEvent.class, values);
    }

    /**
     * Creates a new {@link AchievementEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param achievement The achievement being added to the player
     * @return A new instance of the event
     */
    public static AchievementEvent createAchievement(Game game, Player entity, Achievement achievement) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("achievement", achievement);
        return createEvent(AchievementEvent.class, values);
    }

    /**
     * Creates a new {@link StatisticChangeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param entity The player
     * @param changedStatistic Any statistics changed by this event
     * @param oldValue The old value of the statistic
     * @param newValue The new value of the statistic
     * @return A new instance of the event
     */
    public static StatisticChangeEvent createStatisticChangeEvent(Game game, Player entity, Statistic changedStatistic,
                                                                  long newValue, long oldValue) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("entity", entity);
        values.put("user", entity);
        values.put("changedStatistic", changedStatistic);
        values.put("newValue", newValue);
        values.put("oldValue", oldValue);
        return createEvent(StatisticChangeEvent.class, values);
    }

    /**
     * Creates a new {@link WeatherChangeEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param weatherUniverse The universe the weather changed in
     * @param initialWeather The previous weather
     * @param resultingWeather The weather to change to
     * @param duration The lenfth of the resulting weather, in ticks
     * @return A new instance of the event
     */
    public static WeatherChangeEvent createWeatherChange(Game game, WeatherUniverse weatherUniverse, Weather initialWeather,
            Weather resultingWeather, int duration) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("weatherUniverse", weatherUniverse);
        values.put("initialWeather", initialWeather);
        values.put("resultingWeather", resultingWeather);
        values.put("duration", duration);
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
    public static ChunkPrePopulateEvent createChunkPrePopulate(Game game, Chunk chunk, List<Populator> pendingPopulators) {
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
     * @param ticket The ticket the chunk was removed from
     * @param chunkCoords The coordinates of the removed chunk*
     * @return A new instance of the event
     */
    public static ChunkUnforcedEvent createChunkUnforced(Game game, LoadingTicket ticket, Vector3i chunkCoords) {
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
        values.put("name", name);
        values.put("oldValue", oldValue);
        values.put("newValue", newValue);
        return createEvent(GameRuleChangeEvent.class, values);
    }

    /**
     * Creates a new {@link WorldCreateEvent}.
     *
     * @param game The game instance for this {@link GameEvent}
     * @param properties The properties of the new world
     * @param settings The creation settings
     * @return A new instance of the event
     */
    public static WorldCreateEvent createWorldCreate(Game game, WorldProperties properties, WorldCreationSettings settings) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("worldProperties", properties);
        values.put("worldCreationSettings", settings);
        return createEvent(WorldCreateEvent.class, values);
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
     * @param data The brewing stand data
     * @param location The location
     * @return A new instance of the event
     */
    public static BrewingStandBrewEvent createBrewingStandBrew(Game game, BrewingStand brewingStand, ImmutableBrewingData data,
                                                                    List<ItemStack> sourceItems, ItemStack fuelSource, List<ItemStack> brewedItems,
                                                                    Cause cause, TileEntityInventory<TileEntityCarrier> inventory,
                                                                    Location location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("tile", brewingStand);
        values.put("sourceItems", sourceItems);
        values.put("fuelSource", fuelSource);
        values.put("brewedItems", brewedItems);
        values.put("results", brewedItems);
        values.put("inventory", inventory);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
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
     * @param data The furnace data
     * @param location The location
     * @return A new instance of the event
     */
    public static FurnaceConsumeFuelEvent createFurnaceConsumeFuel(Game game, Furnace furnace, ImmutableFurnaceData data, ItemStack burnedItem,
                                                                   ItemStack remainingFuel, Cause cause,
                                                                   TileEntityInventory<TileEntityCarrier> inventory, Location location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("tile", furnace);
        values.put("burnedItem", burnedItem);
        values.put("remainingFuel", Optional.fromNullable(remainingFuel));
        values.put("result", Optional.fromNullable(remainingFuel));
        values.put("inventory", inventory);
        values.put("cause", Optional.fromNullable(cause));
        values.put("location", location);
        values.put("block", location.getBlock());
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
     * @param data The furnace data
     * @param location The location
     * @return A new instance of the event
     */
    public static FurnaceSmeltItemEvent createFurnaceSmeltItem(Game game, Furnace furnace, ImmutableFurnaceData data, ItemStack cookedItem,
                                                               ItemStack sourceItem, Cause cause, TileEntityInventory<TileEntityCarrier> inventory,
                                                               Location location) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("tile", furnace);
        values.put("cookedItem", cookedItem);
        values.put("sourceItem", sourceItem);
        values.put("result", Optional.fromNullable(cookedItem));
        values.put("cause", Optional.fromNullable(cause));
        values.put("inventory", inventory);
        values.put("location", location);
        values.put("block", location.getBlock());
        values.put("currentData", data);
        return createEvent(FurnaceSmeltItemEvent.class, values);
    }

    /**
     * Creates a new {@link SignChangeEvent}.
     * @param game The game instance for this {@link GameEvent}
     * @param cause The cause
     * @param sign The {@link Sign}
     * @param currentData The current sign data
     * @param newData The new sign data
     * @return A new instance of the event
     */
    public static SignChangeEvent createSignChange(Game game, Cause cause, Sign sign, ImmutableSignData currentData, SignData newData) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", Optional.fromNullable(cause));
        values.put("tile", sign);
        values.put("currentData", currentData);
        values.put("newData", newData);
        return createEvent(SignChangeEvent.class, values);
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
    public static GameClientConnectEvent createClientConnect(Game game, RemoteConnection connection, GameProfile profile,
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
    public static GameClientAuthEvent createClientAuth(Game game, RemoteConnection connection, GameProfile profile,
            @Nullable Text disconnectMessage, @Nullable Cause disconnectCause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("connection", connection);
        values.put("profile", profile);
        values.put("disconnectMessage", Optional.fromNullable(disconnectMessage));
        values.put("disconnectCause", Optional.fromNullable(disconnectCause));
        return createEvent(GameClientAuthEvent.class, values);
    }

}
