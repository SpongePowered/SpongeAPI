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
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.Server;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTransaction;
import org.spongepowered.api.block.tileentity.CommandBlock;
import org.spongepowered.api.block.tileentity.Sign;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.block.tileentity.carrier.BrewingStand;
import org.spongepowered.api.block.tileentity.carrier.Furnace;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.SignData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.entity.weather.Lightning;
import org.spongepowered.api.event.action.ChangeExperienceEvent;
import org.spongepowered.api.event.action.ConnectionEvent;
import org.spongepowered.api.event.action.DisconnectEvent;
import org.spongepowered.api.event.action.InteractEvent;
import org.spongepowered.api.event.action.MessageEvent;
import org.spongepowered.api.event.block.AttackBlockEvent;
import org.spongepowered.api.event.block.BlockEvent;
import org.spongepowered.api.event.block.BreakBlockEvent;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.block.CollideBlockEvent;
import org.spongepowered.api.event.block.DecayBlockEvent;
import org.spongepowered.api.event.block.GrowBlockEvent;
import org.spongepowered.api.event.block.HarvestBlockEvent;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.block.MoveBlockEvent;
import org.spongepowered.api.event.block.NotifyNeighborBlockEvent;
import org.spongepowered.api.event.block.PlaceBlockEvent;
import org.spongepowered.api.event.block.TickBlockEvent;
import org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent;
import org.spongepowered.api.event.block.tileentity.BrewingStandEvent;
import org.spongepowered.api.event.block.tileentity.ChangeSignEvent;
import org.spongepowered.api.event.block.tileentity.CommandBlockEvent;
import org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent;
import org.spongepowered.api.event.block.tileentity.FurnaceEvent;
import org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent;
import org.spongepowered.api.event.block.tileentity.TargetTileEntityEvent;
import org.spongepowered.api.event.block.tileentity.TileEntityEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.cause.entity.health.HealthModifier;
import org.spongepowered.api.event.command.CommandSourceEvent;
import org.spongepowered.api.event.command.MessageSinkEvent;
import org.spongepowered.api.event.command.SendCommandEvent;
import org.spongepowered.api.event.command.TabCompleteCommandEvent;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;
import org.spongepowered.api.event.entity.AffectEntityEvent;
import org.spongepowered.api.event.entity.BreedEntityEvent;
import org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent;
import org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent;
import org.spongepowered.api.event.entity.CollideEntityEvent;
import org.spongepowered.api.event.entity.ConstructEntityEvent;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.entity.DismountEntityEvent;
import org.spongepowered.api.event.entity.DisplaceEntityEvent;
import org.spongepowered.api.event.entity.EntityEvent;
import org.spongepowered.api.event.entity.EntityPortalEvent;
import org.spongepowered.api.event.entity.ExpireEntityEvent;
import org.spongepowered.api.event.entity.FishingEvent;
import org.spongepowered.api.event.entity.HarvestEntityEvent;
import org.spongepowered.api.event.entity.HealEntityEvent;
import org.spongepowered.api.event.entity.IgniteEntityEvent;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.entity.LeashEntityEvent;
import org.spongepowered.api.event.entity.MountEntityEvent;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.entity.TameEntityEvent;
import org.spongepowered.api.event.entity.TargetEntityEvent;
import org.spongepowered.api.event.entity.UnleashEntityEvent;
import org.spongepowered.api.event.entity.item.ItemMergeItemEvent;
import org.spongepowered.api.event.entity.item.TargetItemEvent;
import org.spongepowered.api.event.entity.living.LivingEvent;
import org.spongepowered.api.event.entity.living.TargetLivingEvent;
import org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent;
import org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent;
import org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent;
import org.spongepowered.api.event.entity.living.human.HumanEvent;
import org.spongepowered.api.event.entity.living.human.HumanSleepEvent;
import org.spongepowered.api.event.entity.living.human.TargetHumanEvent;
import org.spongepowered.api.event.entity.living.player.KickPlayerEvent;
import org.spongepowered.api.event.entity.living.player.PlayerEvent;
import org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent;
import org.spongepowered.api.event.entity.living.player.RespawnPlayerEvent;
import org.spongepowered.api.event.entity.living.player.TargetPlayerEvent;
import org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent;
import org.spongepowered.api.event.entity.projectile.TargetProjectileEvent;
import org.spongepowered.api.event.game.state.GameAboutToStartServerEvent;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameLoadCompleteEvent;
import org.spongepowered.api.event.game.state.GamePostInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.event.game.state.GameStateEvent;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.event.inventory.BlockBrewEvent;
import org.spongepowered.api.event.inventory.BlockInventoryEvent;
import org.spongepowered.api.event.inventory.BulkItemResultEvent;
import org.spongepowered.api.event.inventory.ContainerEvent;
import org.spongepowered.api.event.inventory.DropItemStackEvent;
import org.spongepowered.api.event.inventory.InventoryClickEvent;
import org.spongepowered.api.event.inventory.InventoryCloseEvent;
import org.spongepowered.api.event.inventory.InventoryEvent;
import org.spongepowered.api.event.inventory.ItemResultEvent;
import org.spongepowered.api.event.inventory.PickUpItemEvent;
import org.spongepowered.api.event.inventory.UseItemStackEvent;
import org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent;
import org.spongepowered.api.event.inventory.viewer.ViewerEvent;
import org.spongepowered.api.event.inventory.viewer.ViewerOpenContainerEvent;
import org.spongepowered.api.event.network.BanIpEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.network.PardonIpEvent;
import org.spongepowered.api.event.plugin.PluginEvent;
import org.spongepowered.api.event.rcon.RconDisconnectEvent;
import org.spongepowered.api.event.rcon.RconEvent;
import org.spongepowered.api.event.rcon.RconLoginEvent;
import org.spongepowered.api.event.server.PingServerEvent;
import org.spongepowered.api.event.server.ServerEvent;
import org.spongepowered.api.event.server.channel.RegisterChannelEvent;
import org.spongepowered.api.event.server.channel.TargetChannelEvent;
import org.spongepowered.api.event.server.channel.UnRegisterChannelEvent;
import org.spongepowered.api.event.server.query.BasicQueryServerEvent;
import org.spongepowered.api.event.server.query.FullQueryServerEvent;
import org.spongepowered.api.event.server.query.QueryServerEvent;
import org.spongepowered.api.event.user.BanUserEvent;
import org.spongepowered.api.event.user.PardonUserEvent;
import org.spongepowered.api.event.user.TargetUserEvent;
import org.spongepowered.api.event.world.ChangeWorldGameRuleEvent;
import org.spongepowered.api.event.world.ChangeWorldWeatherEvent;
import org.spongepowered.api.event.world.ConstructPortalEvent;
import org.spongepowered.api.event.world.ConstructWorldEvent;
import org.spongepowered.api.event.world.LoadWorldEvent;
import org.spongepowered.api.event.world.UnloadWorldEvent;
import org.spongepowered.api.event.world.WorldEvent;
import org.spongepowered.api.event.world.WorldExplosionEvent;
import org.spongepowered.api.event.world.WorldGenerateChunkEvent;
import org.spongepowered.api.event.world.chunk.ChunkEvent;
import org.spongepowered.api.event.world.chunk.ForcedChunkEvent;
import org.spongepowered.api.event.world.chunk.LoadChunkEvent;
import org.spongepowered.api.event.world.chunk.PopulateChunkEvent;
import org.spongepowered.api.event.world.chunk.TargetChunkEvent;
import org.spongepowered.api.event.world.chunk.UnforcedChunkEvent;
import org.spongepowered.api.event.world.chunk.UnloadChunkEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.ItemStackTransaction;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;
import org.spongepowered.api.item.recipe.Recipe;
import org.spongepowered.api.network.RemoteConnection;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.service.world.ChunkLoadService;
import org.spongepowered.api.status.Favicon;
import org.spongepowered.api.status.StatusClient;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.ban.Ban;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;
import org.spongepowered.api.util.command.source.RconSource;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.TeleporterAgent;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldCreationSettings;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.weather.Weather;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Generates Sponge event implementations.
 * This class should only ever contain generated code.
 */
public final class SpongeEventFactory {
    private SpongeEventFactory() {
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.Event}.
     * 
     * @return A new event
     */
    public static Event createEvent() {
        Map<String, Object> values = Maps.newHashMap();
        return SpongeEventFactoryUtils.createEventImpl(Event.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.GameEvent}.
     * 
     * @param game The game
     * @return A new game event
     */
    public static GameEvent createGameEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.ChangeExperienceEvent}.
     * 
     * @param originalExperience The original experience
     * @param experience The experience
     * @return A new change experience event
     */
    public static ChangeExperienceEvent createChangeExperienceEvent(int originalExperience, int experience) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        return SpongeEventFactoryUtils.createEventImpl(ChangeExperienceEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.ConnectionEvent}.
     * 
     * @return A new connection event
     */
    public static ConnectionEvent createConnectionEvent() {
        Map<String, Object> values = Maps.newHashMap();
        return SpongeEventFactoryUtils.createEventImpl(ConnectionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.DisconnectEvent}.
     * 
     * @return A new disconnect event
     */
    public static DisconnectEvent createDisconnectEvent() {
        Map<String, Object> values = Maps.newHashMap();
        return SpongeEventFactoryUtils.createEventImpl(DisconnectEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.InteractEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @return A new interact event
     */
    public static InteractEvent createInteractEvent(Game game, Cause cause, Optional<Vector3d> interactionPoint) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        return SpongeEventFactoryUtils.createEventImpl(InteractEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.MessageEvent}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @return A new message event
     */
    public static MessageEvent createMessageEvent(Game game, Text originalMessage, Text message) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        return SpongeEventFactoryUtils.createEventImpl(MessageEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new attack block event
     */
    public static AttackBlockEvent createAttackBlockEvent(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(AttackBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity attack block event
     */
    public static AttackBlockEvent.SourceEntity createAttackBlockEventSourceEntity(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(AttackBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human attack block event
     */
    public static AttackBlockEvent.SourceHuman createAttackBlockEventSourceHuman(Game game, Cause cause, Optional<Vector3d> interactionPoint, Human sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(AttackBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living attack block event
     */
    public static AttackBlockEvent.SourceLiving createAttackBlockEventSourceLiving(Game game, Cause cause, Optional<Vector3d> interactionPoint, Living sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(AttackBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player attack block event
     */
    public static AttackBlockEvent.SourcePlayer createAttackBlockEventSourcePlayer(Game game, Cause cause, Optional<Vector3d> interactionPoint, Player sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(AttackBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block event
     */
    public static BlockEvent createBlockEvent(Game game, Cause cause, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return SpongeEventFactoryUtils.createEventImpl(BlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param transactions The transactions
     * @return A new break block event
     */
    public static BreakBlockEvent createBreakBlockEvent(Game game, Cause cause, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block break block event
     */
    public static BreakBlockEvent.SourceBlock createBreakBlockEventSourceBlock(Game game, Cause cause, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source entity break block event
     */
    public static BreakBlockEvent.SourceEntity createBreakBlockEventSourceEntity(Game game, Cause cause, Entity sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source human break block event
     */
    public static BreakBlockEvent.SourceHuman createBreakBlockEventSourceHuman(Game game, Cause cause, Human sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source living break block event
     */
    public static BreakBlockEvent.SourceLiving createBreakBlockEventSourceLiving(Game game, Cause cause, Living sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source player break block event
     */
    public static BreakBlockEvent.SourcePlayer createBreakBlockEventSourcePlayer(Game game, Cause cause, Player sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param transactions The transactions
     * @return A new change block event
     */
    public static ChangeBlockEvent createChangeBlockEvent(Game game, Cause cause, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block change block event
     */
    public static ChangeBlockEvent.SourceBlock createChangeBlockEventSourceBlock(Game game, Cause cause, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source entity change block event
     */
    public static ChangeBlockEvent.SourceEntity createChangeBlockEventSourceEntity(Game game, Cause cause, Entity sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source human change block event
     */
    public static ChangeBlockEvent.SourceHuman createChangeBlockEventSourceHuman(Game game, Cause cause, Human sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source living change block event
     */
    public static ChangeBlockEvent.SourceLiving createChangeBlockEventSourceLiving(Game game, Cause cause, Living sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source player change block event
     */
    public static ChangeBlockEvent.SourcePlayer createChangeBlockEventSourcePlayer(Game game, Cause cause, Player sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceWorld}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world change block event
     */
    public static ChangeBlockEvent.SourceWorld createChangeBlockEventSourceWorld(Game game, Cause cause, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new collide block event
     */
    public static CollideBlockEvent createCollideBlockEvent(Game game, Cause cause, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(CollideBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity collide block event
     */
    public static CollideBlockEvent.SourceEntity createCollideBlockEventSourceEntity(Game game, Cause cause, Entity sourceEntity, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(CollideBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human collide block event
     */
    public static CollideBlockEvent.SourceHuman createCollideBlockEventSourceHuman(Game game, Cause cause, Human sourceEntity, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(CollideBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living collide block event
     */
    public static CollideBlockEvent.SourceLiving createCollideBlockEventSourceLiving(Game game, Cause cause, Living sourceEntity, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(CollideBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player collide block event
     */
    public static CollideBlockEvent.SourcePlayer createCollideBlockEventSourcePlayer(Game game, Cause cause, Player sourceEntity, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(CollideBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.DecayBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param transactions The transactions
     * @return A new decay block event
     */
    public static DecayBlockEvent createDecayBlockEvent(Game game, Cause cause, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(DecayBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.DecayBlockEvent.SourceWorld}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world decay block event
     */
    public static DecayBlockEvent.SourceWorld createDecayBlockEventSourceWorld(Game game, Cause cause, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(DecayBlockEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.GrowBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param transactions The transactions
     * @return A new grow block event
     */
    public static GrowBlockEvent createGrowBlockEvent(Game game, Cause cause, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(GrowBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.GrowBlockEvent.SourceWorld}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world grow block event
     */
    public static GrowBlockEvent.SourceWorld createGrowBlockEventSourceWorld(Game game, Cause cause, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(GrowBlockEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent}.
     * 
     * @param game The game
     * @param originalDropChance The original drop chance
     * @param dropChance The drop chance
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalItemStacks The original item stacks
     * @param itemStacks The item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new harvest block event
     */
    public static HarvestBlockEvent createHarvestBlockEvent(Game game, float originalDropChance, float dropChance, int originalExperience, int experience, Collection<ItemStack> originalItemStacks, Collection<ItemStack> itemStacks, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalDropChance", originalDropChance);
        values.put("dropChance", dropChance);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("itemStacks", itemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(HarvestBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalDropChance The original drop chance
     * @param dropChance The drop chance
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalItemStacks The original item stacks
     * @param itemStacks The item stacks
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source block harvest block event
     */
    public static HarvestBlockEvent.SourceBlock createHarvestBlockEventSourceBlock(Game game, Cause cause, float originalDropChance, float dropChance, int originalExperience, int experience, Collection<ItemStack> originalItemStacks, Collection<ItemStack> itemStacks, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalDropChance", originalDropChance);
        values.put("dropChance", dropChance);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("itemStacks", itemStacks);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(HarvestBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalDropChance The original drop chance
     * @param dropChance The drop chance
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalItemStacks The original item stacks
     * @param itemStacks The item stacks
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source entity harvest block event
     */
    public static HarvestBlockEvent.SourceEntity createHarvestBlockEventSourceEntity(Game game, Cause cause, float originalDropChance, float dropChance, int originalExperience, int experience, Collection<ItemStack> originalItemStacks, Collection<ItemStack> itemStacks, Entity sourceEntity, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalDropChance", originalDropChance);
        values.put("dropChance", dropChance);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("itemStacks", itemStacks);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(HarvestBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalDropChance The original drop chance
     * @param dropChance The drop chance
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalItemStacks The original item stacks
     * @param itemStacks The item stacks
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source human harvest block event
     */
    public static HarvestBlockEvent.SourceHuman createHarvestBlockEventSourceHuman(Game game, Cause cause, float originalDropChance, float dropChance, int originalExperience, int experience, Collection<ItemStack> originalItemStacks, Collection<ItemStack> itemStacks, Human sourceEntity, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalDropChance", originalDropChance);
        values.put("dropChance", dropChance);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("itemStacks", itemStacks);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(HarvestBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalDropChance The original drop chance
     * @param dropChance The drop chance
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalItemStacks The original item stacks
     * @param itemStacks The item stacks
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source living harvest block event
     */
    public static HarvestBlockEvent.SourceLiving createHarvestBlockEventSourceLiving(Game game, Cause cause, float originalDropChance, float dropChance, int originalExperience, int experience, Collection<ItemStack> originalItemStacks, Collection<ItemStack> itemStacks, Living sourceEntity, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalDropChance", originalDropChance);
        values.put("dropChance", dropChance);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("itemStacks", itemStacks);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(HarvestBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalDropChance The original drop chance
     * @param dropChance The drop chance
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalItemStacks The original item stacks
     * @param itemStacks The item stacks
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source player harvest block event
     */
    public static HarvestBlockEvent.SourcePlayer createHarvestBlockEventSourcePlayer(Game game, Cause cause, float originalDropChance, float dropChance, int originalExperience, int experience, Collection<ItemStack> originalItemStacks, Collection<ItemStack> itemStacks, Player sourceEntity, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalDropChance", originalDropChance);
        values.put("dropChance", dropChance);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("itemStacks", itemStacks);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(HarvestBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new interact block event
     */
    public static InteractBlockEvent createInteractBlockEvent(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new attack interact block event
     */
    public static InteractBlockEvent.Attack createInteractBlockEventAttack(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Attack.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity attack interact block event
     */
    public static InteractBlockEvent.Attack.SourceEntity createInteractBlockEventAttackSourceEntity(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Attack.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human attack interact block event
     */
    public static InteractBlockEvent.Attack.SourceHuman createInteractBlockEventAttackSourceHuman(Game game, Cause cause, Optional<Vector3d> interactionPoint, Human sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Attack.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living attack interact block event
     */
    public static InteractBlockEvent.Attack.SourceLiving createInteractBlockEventAttackSourceLiving(Game game, Cause cause, Optional<Vector3d> interactionPoint, Living sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Attack.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Attack.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player attack interact block event
     */
    public static InteractBlockEvent.Attack.SourcePlayer createInteractBlockEventAttackSourcePlayer(Game game, Cause cause, Optional<Vector3d> interactionPoint, Player sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Attack.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source block interact block event
     */
    public static InteractBlockEvent.SourceBlock createInteractBlockEventSourceBlock(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity interact block event
     */
    public static InteractBlockEvent.SourceEntity createInteractBlockEventSourceEntity(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human interact block event
     */
    public static InteractBlockEvent.SourceHuman createInteractBlockEventSourceHuman(Game game, Cause cause, Optional<Vector3d> interactionPoint, Human sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living interact block event
     */
    public static InteractBlockEvent.SourceLiving createInteractBlockEventSourceLiving(Game game, Cause cause, Optional<Vector3d> interactionPoint, Living sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player interact block event
     */
    public static InteractBlockEvent.SourcePlayer createInteractBlockEventSourcePlayer(Game game, Cause cause, Optional<Vector3d> interactionPoint, Player sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new use interact block event
     */
    public static InteractBlockEvent.Use createInteractBlockEventUse(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Use.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source block use interact block event
     */
    public static InteractBlockEvent.Use.SourceBlock createInteractBlockEventUseSourceBlock(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Use.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity use interact block event
     */
    public static InteractBlockEvent.Use.SourceEntity createInteractBlockEventUseSourceEntity(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Use.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human use interact block event
     */
    public static InteractBlockEvent.Use.SourceHuman createInteractBlockEventUseSourceHuman(Game game, Cause cause, Optional<Vector3d> interactionPoint, Human sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Use.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living use interact block event
     */
    public static InteractBlockEvent.Use.SourceLiving createInteractBlockEventUseSourceLiving(Game game, Cause cause, Optional<Vector3d> interactionPoint, Living sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Use.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Use.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player use interact block event
     */
    public static InteractBlockEvent.Use.SourcePlayer createInteractBlockEventUseSourcePlayer(Game game, Cause cause, Optional<Vector3d> interactionPoint, Player sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Use.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.MoveBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param transactions The transactions
     * @return A new move block event
     */
    public static MoveBlockEvent createMoveBlockEvent(Game game, Cause cause, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(MoveBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.MoveBlockEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block move block event
     */
    public static MoveBlockEvent.SourceBlock createMoveBlockEventSourceBlock(Game game, Cause cause, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(MoveBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new notify neighbor block event
     */
    public static NotifyNeighborBlockEvent createNotifyNeighborBlockEvent(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new burn notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Burn createNotifyNeighborBlockEventBurn(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Burn.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block burn notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Burn.SourceBlock createNotifyNeighborBlockEventBurnSourceBlock(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Burn.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new ignite notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Ignite createNotifyNeighborBlockEventIgnite(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Ignite.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block ignite notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Ignite.SourceBlock createNotifyNeighborBlockEventIgniteSourceBlock(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Ignite.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new power notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Power createNotifyNeighborBlockEventPower(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Power.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block power notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Power.SourceBlock createNotifyNeighborBlockEventPowerSourceBlock(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Power.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.SourceBlock createNotifyNeighborBlockEventSourceBlock(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param spreadingBlock The spreading block
     * @return A new spread notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Spread createNotifyNeighborBlockEventSpread(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockState spreadingBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("spreadingBlock", spreadingBlock);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Spread.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param spreadingBlock The spreading block
     * @param transactions The transactions
     * @return A new source block spread notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Spread.SourceBlock createNotifyNeighborBlockEventSpreadSourceBlock(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BlockState spreadingBlock, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("spreadingBlock", spreadingBlock);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Spread.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param transactions The transactions
     * @return A new place block event
     */
    public static PlaceBlockEvent createPlaceBlockEvent(Game game, Cause cause, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block place block event
     */
    public static PlaceBlockEvent.SourceBlock createPlaceBlockEventSourceBlock(Game game, Cause cause, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source entity place block event
     */
    public static PlaceBlockEvent.SourceEntity createPlaceBlockEventSourceEntity(Game game, Cause cause, Entity sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source human place block event
     */
    public static PlaceBlockEvent.SourceHuman createPlaceBlockEventSourceHuman(Game game, Cause cause, Human sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source living place block event
     */
    public static PlaceBlockEvent.SourceLiving createPlaceBlockEventSourceLiving(Game game, Cause cause, Living sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source player place block event
     */
    public static PlaceBlockEvent.SourcePlayer createPlaceBlockEventSourcePlayer(Game game, Cause cause, Player sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.TickBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new tick block event
     */
    public static TickBlockEvent createTickBlockEvent(Game game, Cause cause, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(TickBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param brewedItems The brewed items
     * @param fuelSource The fuel source
     * @param inventory The inventory
     * @param results The results
     * @param sourceBlock The source block
     * @param sourceItems The source items
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new brewing stand brew items event
     */
    public static BrewingStandBrewItemsEvent createBrewingStandBrewItemsEvent(Game game, Cause cause, List<ItemStack> brewedItems, ItemStack fuelSource, Inventory inventory, List<ItemStack> results, BlockSnapshot sourceBlock, List<ItemStack> sourceItems, Location<World> sourceLocation, Optional<Direction> sourceSide, BrewingStand tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("brewedItems", brewedItems);
        values.put("fuelSource", fuelSource);
        values.put("inventory", inventory);
        values.put("results", results);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceItems", sourceItems);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return SpongeEventFactoryUtils.createEventImpl(BrewingStandBrewItemsEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingStandEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new brewing stand event
     */
    public static BrewingStandEvent createBrewingStandEvent(Game game, Cause cause, Inventory inventory, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BrewingStand tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return SpongeEventFactoryUtils.createEventImpl(BrewingStandEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent}.
     * 
     * @param game The game
     * @param originalText The original text
     * @param text The text
     * @param targetTile The target tile
     * @return A new change sign event
     */
    public static ChangeSignEvent createChangeSignEvent(Game game, ImmutableSignData originalText, SignData text, Sign targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("text", text);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceCommandSource}.
     * 
     * @param game The game
     * @param originalText The original text
     * @param text The text
     * @param source The source
     * @param targetTile The target tile
     * @return A new source command source change sign event
     */
    public static ChangeSignEvent.SourceCommandSource createChangeSignEventSourceCommandSource(Game game, ImmutableSignData originalText, SignData text, CommandSource source, Sign targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("text", text);
        values.put("source", source);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourceCommandSource.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalText The original text
     * @param text The text
     * @param sourceEntity The source entity
     * @param targetTile The target tile
     * @return A new source entity change sign event
     */
    public static ChangeSignEvent.SourceEntity createChangeSignEventSourceEntity(Game game, Cause cause, ImmutableSignData originalText, SignData text, Entity sourceEntity, Sign targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalText", originalText);
        values.put("text", text);
        values.put("sourceEntity", sourceEntity);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalText The original text
     * @param text The text
     * @param sourceEntity The source entity
     * @param targetTile The target tile
     * @return A new source human change sign event
     */
    public static ChangeSignEvent.SourceHuman createChangeSignEventSourceHuman(Game game, Cause cause, ImmutableSignData originalText, SignData text, Human sourceEntity, Sign targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalText", originalText);
        values.put("text", text);
        values.put("sourceEntity", sourceEntity);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalText The original text
     * @param text The text
     * @param sourceEntity The source entity
     * @param targetTile The target tile
     * @return A new source living change sign event
     */
    public static ChangeSignEvent.SourceLiving createChangeSignEventSourceLiving(Game game, Cause cause, ImmutableSignData originalText, SignData text, Living sourceEntity, Sign targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalText", originalText);
        values.put("text", text);
        values.put("sourceEntity", sourceEntity);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalText The original text
     * @param text The text
     * @param sourceEntity The source entity
     * @param targetTile The target tile
     * @return A new source player change sign event
     */
    public static ChangeSignEvent.SourcePlayer createChangeSignEventSourcePlayer(Game game, Cause cause, ImmutableSignData originalText, SignData text, Player sourceEntity, Sign targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalText", originalText);
        values.put("text", text);
        values.put("sourceEntity", sourceEntity);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.CommandBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new command block event
     */
    public static CommandBlockEvent createCommandBlockEvent(Game game, Cause cause, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, CommandBlock tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return SpongeEventFactoryUtils.createEventImpl(CommandBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceConsumeFuelEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param burnedItem The burned item
     * @param inventory The inventory
     * @param remainingFuel The remaining fuel
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace consume fuel event
     */
    public static FurnaceConsumeFuelEvent createFurnaceConsumeFuelEvent(Game game, Cause cause, ItemStack burnedItem, Inventory inventory, Optional<ItemStack> remainingFuel, Optional<ItemStack> result, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, Furnace tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("burnedItem", burnedItem);
        values.put("inventory", inventory);
        values.put("remainingFuel", remainingFuel);
        values.put("result", result);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return SpongeEventFactoryUtils.createEventImpl(FurnaceConsumeFuelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace event
     */
    public static FurnaceEvent createFurnaceEvent(Game game, Cause cause, Inventory inventory, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, Furnace tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return SpongeEventFactoryUtils.createEventImpl(FurnaceEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.FurnaceSmeltItemEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cookedItem The cooked item
     * @param inventory The inventory
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceItem The source item
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace smelt item event
     */
    public static FurnaceSmeltItemEvent createFurnaceSmeltItemEvent(Game game, Cause cause, ItemStack cookedItem, Inventory inventory, Optional<ItemStack> result, BlockSnapshot sourceBlock, ItemStack sourceItem, Location<World> sourceLocation, Optional<Direction> sourceSide, Furnace tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cookedItem", cookedItem);
        values.put("inventory", inventory);
        values.put("result", result);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceItem", sourceItem);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return SpongeEventFactoryUtils.createEventImpl(FurnaceSmeltItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.TargetTileEntityEvent}.
     * 
     * @param game The game
     * @param targetTile The target tile
     * @return A new target tile entity event
     */
    public static TargetTileEntityEvent createTargetTileEntityEvent(Game game, TileEntity targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(TargetTileEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.TileEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new tile entity event
     */
    public static TileEntityEvent createTileEntityEvent(Game game, Cause cause, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, TileEntity tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return SpongeEventFactoryUtils.createEventImpl(TileEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.CommandSourceEvent}.
     * 
     * @param game The game
     * @param source The source
     * @return A new command source event
     */
    public static CommandSourceEvent createCommandSourceEvent(Game game, CommandSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(CommandSourceEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @return A new message sink event
     */
    public static MessageSinkEvent createMessageSinkEvent(Game game, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.SourceCommandBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param source The source
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new source command block message sink event
     */
    public static MessageSinkEvent.SourceCommandBlock createMessageSinkEventSourceCommandBlock(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, CommandBlock source, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, CommandBlock tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("source", source);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("tile", tile);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.SourceCommandBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.SourceCommandSource}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param source The source
     * @return A new source command source message sink event
     */
    public static MessageSinkEvent.SourceCommandSource createMessageSinkEventSourceCommandSource(Game game, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, CommandSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.SourceCommandSource.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.SourceConsole}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param server The server
     * @param source The source
     * @return A new source console message sink event
     */
    public static MessageSinkEvent.SourceConsole createMessageSinkEventSourceConsole(Game game, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Server server, CommandSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("server", server);
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.SourceConsole.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param originalUnformattedMessage The original unformatted message
     * @param unformattedMessage The unformatted message
     * @param source The source
     * @param sourceEntity The source entity
     * @return A new source player message sink event
     */
    public static MessageSinkEvent.SourcePlayer createMessageSinkEventSourcePlayer(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Text originalUnformattedMessage, Text unformattedMessage, Player source, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("originalUnformattedMessage", originalUnformattedMessage);
        values.put("unformattedMessage", unformattedMessage);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.SourcePlugin}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param plugin The plugin
     * @return A new source plugin message sink event
     */
    public static MessageSinkEvent.SourcePlugin createMessageSinkEventSourcePlugin(Game game, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, PluginContainer plugin) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("plugin", plugin);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.SourcePlugin.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.SendCommandEvent}.
     * 
     * @param game The game
     * @param arguments The arguments
     * @param command The command
     * @param result The result
     * @param source The source
     * @return A new send command event
     */
    public static SendCommandEvent createSendCommandEvent(Game game, String arguments, String command, CommandResult result, CommandSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("arguments", arguments);
        values.put("command", command);
        values.put("result", result);
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(SendCommandEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.TabCompleteCommandEvent}.
     * 
     * @param game The game
     * @param arguments The arguments
     * @param command The command
     * @param source The source
     * @param tabCompletions The tab completions
     * @return A new tab complete command event
     */
    public static TabCompleteCommandEvent createTabCompleteCommandEvent(Game game, String arguments, String command, CommandSource source, List<String> tabCompletions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("arguments", arguments);
        values.put("command", command);
        values.put("source", source);
        values.put("tabCompletions", tabCompletions);
        return SpongeEventFactoryUtils.createEventImpl(TabCompleteCommandEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.data.ChangeDataHolderEvent}.
     * 
     * @param game The game
     * @param targetHolder The target holder
     * @return A new change data holder event
     */
    public static ChangeDataHolderEvent createChangeDataHolderEvent(Game game, DataHolder targetHolder) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetHolder", targetHolder);
        return SpongeEventFactoryUtils.createEventImpl(ChangeDataHolderEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange}.
     * 
     * @param game The game
     * @param endResult The end result
     * @param originalChanges The original changes
     * @param targetHolder The target holder
     * @return A new value change change data holder event
     */
    public static ChangeDataHolderEvent.ValueChange createChangeDataHolderEventValueChange(Game game, DataTransactionResult endResult, DataTransactionResult originalChanges, DataHolder targetHolder) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("endResult", endResult);
        values.put("originalChanges", originalChanges);
        values.put("targetHolder", targetHolder);
        return SpongeEventFactoryUtils.createEventImpl(ChangeDataHolderEvent.ValueChange.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AffectEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @return A new affect entity event
     */
    public static AffectEntityEvent createAffectEntityEvent(Game game, Cause cause, List<? extends Entity> entities, List<EntitySnapshot> entitySnapshots) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        return SpongeEventFactoryUtils.createEventImpl(AffectEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new breed entity event
     */
    public static BreedEntityEvent createBreedEntityEvent(Game game, Cause cause, Optional<Vector3d> interactionPoint, Ageable targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(BreedEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent.Breed}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param offspringEntity The offspring entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new breed breed entity event
     */
    public static BreedEntityEvent.Breed createBreedEntityEventBreed(Game game, Cause cause, Optional<Vector3d> interactionPoint, Ageable offspringEntity, Ageable sourceEntity, Ageable targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("offspringEntity", offspringEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(BreedEntityEvent.Breed.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent.FindMate}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalResult The original result
     * @param result The result
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param hasAllowResult The has allow result
     * @return A new find mate breed entity event
     */
    public static BreedEntityEvent.FindMate createBreedEntityEventFindMate(Game game, Cause cause, TristateResult.Result originalResult, TristateResult.Result result, Optional<Vector3d> interactionPoint, Ageable sourceEntity, Ageable targetEntity, boolean hasAllowResult) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalResult", originalResult);
        values.put("result", result);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("hasAllowResult", hasAllowResult);
        return SpongeEventFactoryUtils.createEventImpl(BreedEntityEvent.FindMate.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent}.
     * 
     * @param game The game
     * @param originalItemStack The original item stack
     * @param itemStack The item stack
     * @param inventory The inventory
     * @param targetEntity The target entity
     * @return A new change entity equipment event
     */
    public static ChangeEntityEquipmentEvent createChangeEntityEquipmentEvent(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<ItemStackTransaction> itemStack, Slot inventory, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalItemStack", originalItemStack);
        values.put("itemStack", itemStack);
        values.put("inventory", inventory);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHuman}.
     * 
     * @param game The game
     * @param originalItemStack The original item stack
     * @param itemStack The item stack
     * @param inventory The inventory
     * @param targetEntity The target entity
     * @return A new target human change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetHuman createChangeEntityEquipmentEventTargetHuman(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<ItemStackTransaction> itemStack, Slot inventory, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalItemStack", originalItemStack);
        values.put("itemStack", itemStack);
        values.put("inventory", inventory);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving}.
     * 
     * @param game The game
     * @param originalItemStack The original item stack
     * @param itemStack The item stack
     * @param inventory The inventory
     * @param targetEntity The target entity
     * @return A new target living change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetLiving createChangeEntityEquipmentEventTargetLiving(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<ItemStackTransaction> itemStack, Slot inventory, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalItemStack", originalItemStack);
        values.put("itemStack", itemStack);
        values.put("inventory", inventory);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param originalItemStack The original item stack
     * @param itemStack The item stack
     * @param inventory The inventory
     * @param targetEntity The target entity
     * @return A new target player change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetPlayer createChangeEntityEquipmentEventTargetPlayer(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<ItemStackTransaction> itemStack, Slot inventory, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalItemStack", originalItemStack);
        values.put("itemStack", itemStack);
        values.put("inventory", inventory);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent createChangeEntityPotionEffectEvent(Game game, Cause cause, List<PotionEffect> currentEffects, PotionEffect potionEffect, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityPotionEffectEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire}.
     * 
     * @param game The game
     * @param cause The cause
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new expire change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Expire createChangeEntityPotionEffectEventExpire(Game game, Cause cause, List<PotionEffect> currentEffects, PotionEffect potionEffect, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityPotionEffectEvent.Expire.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain}.
     * 
     * @param game The game
     * @param cause The cause
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new gain change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Gain createChangeEntityPotionEffectEventGain(Game game, Cause cause, List<PotionEffect> currentEffects, PotionEffect potionEffect, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityPotionEffectEvent.Gain.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove}.
     * 
     * @param game The game
     * @param cause The cause
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new remove change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Remove createChangeEntityPotionEffectEventRemove(Game game, Cause cause, List<PotionEffect> currentEffects, PotionEffect potionEffect, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityPotionEffectEvent.Remove.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new collide entity event
     */
    public static CollideEntityEvent createCollideEntityEvent(Game game, Cause cause, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity collide entity event
     */
    public static CollideEntityEvent.SourceEntity createCollideEntityEventSourceEntity(Game game, Cause cause, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human collide entity event
     */
    public static CollideEntityEvent.SourceHuman createCollideEntityEventSourceHuman(Game game, Cause cause, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living collide entity event
     */
    public static CollideEntityEvent.SourceLiving createCollideEntityEventSourceLiving(Game game, Cause cause, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player collide entity event
     */
    public static CollideEntityEvent.SourcePlayer createCollideEntityEventSourcePlayer(Game game, Cause cause, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ConstructEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetType The target type
     * @param transform The transform
     * @return A new construct entity event
     */
    public static ConstructEntityEvent createConstructEntityEvent(Game game, Cause cause, EntityType targetType, Transform<World> transform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetType", targetType);
        values.put("transform", transform);
        return SpongeEventFactoryUtils.createEventImpl(ConstructEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ConstructEntityEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @param targetType The target type
     * @param transform The transform
     * @return A new post construct entity event
     */
    public static ConstructEntityEvent.Post createConstructEntityEventPost(Game game, Cause cause, Entity targetEntity, EntityType targetType, Transform<World> transform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        values.put("targetType", targetType);
        values.put("transform", transform);
        return SpongeEventFactoryUtils.createEventImpl(ConstructEntityEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ConstructEntityEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetType The target type
     * @param transform The transform
     * @return A new pre construct entity event
     */
    public static ConstructEntityEvent.Pre createConstructEntityEventPre(Game game, Cause cause, EntityType targetType, Transform<World> transform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetType", targetType);
        values.put("transform", transform);
        return SpongeEventFactoryUtils.createEventImpl(ConstructEntityEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFinalDamage The original final damage
     * @param finalDamage The final damage
     * @param modifiers The modifiers
     * @param originalDamages The original damages
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param baseDamage The base damage
     * @param originalDamage The original damage
     * @return A new damage entity event
     */
    public static DamageEntityEvent createDamageEntityEvent(Game game, Cause cause, double originalFinalDamage, double finalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, Map<DamageModifier, Double> originalDamages, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity, double baseDamage, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("finalDamage", finalDamage);
        values.put("modifiers", modifiers);
        values.put("originalDamages", originalDamages);
        values.put("originalFunctions", originalFunctions);
        values.put("targetEntity", targetEntity);
        values.put("baseDamage", baseDamage);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFinalDamage The original final damage
     * @param finalDamage The final damage
     * @param modifiers The modifiers
     * @param originalDamages The original damages
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param baseDamage The base damage
     * @param originalDamage The original damage
     * @return A new source entity damage entity event
     */
    public static DamageEntityEvent.SourceEntity createDamageEntityEventSourceEntity(Game game, Cause cause, double originalFinalDamage, double finalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, Map<DamageModifier, Double> originalDamages, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity sourceEntity, Entity targetEntity, double baseDamage, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("finalDamage", finalDamage);
        values.put("modifiers", modifiers);
        values.put("originalDamages", originalDamages);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("baseDamage", baseDamage);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFinalDamage The original final damage
     * @param finalDamage The final damage
     * @param modifiers The modifiers
     * @param originalDamages The original damages
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param baseDamage The base damage
     * @param originalDamage The original damage
     * @return A new source human damage entity event
     */
    public static DamageEntityEvent.SourceHuman createDamageEntityEventSourceHuman(Game game, Cause cause, double originalFinalDamage, double finalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, Map<DamageModifier, Double> originalDamages, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Human sourceEntity, Entity targetEntity, double baseDamage, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("finalDamage", finalDamage);
        values.put("modifiers", modifiers);
        values.put("originalDamages", originalDamages);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("baseDamage", baseDamage);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFinalDamage The original final damage
     * @param finalDamage The final damage
     * @param modifiers The modifiers
     * @param originalDamages The original damages
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param baseDamage The base damage
     * @param originalDamage The original damage
     * @return A new source living damage entity event
     */
    public static DamageEntityEvent.SourceLiving createDamageEntityEventSourceLiving(Game game, Cause cause, double originalFinalDamage, double finalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, Map<DamageModifier, Double> originalDamages, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Living sourceEntity, Entity targetEntity, double baseDamage, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("finalDamage", finalDamage);
        values.put("modifiers", modifiers);
        values.put("originalDamages", originalDamages);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("baseDamage", baseDamage);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFinalDamage The original final damage
     * @param finalDamage The final damage
     * @param modifiers The modifiers
     * @param originalDamages The original damages
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param baseDamage The base damage
     * @param originalDamage The original damage
     * @return A new source player damage entity event
     */
    public static DamageEntityEvent.SourcePlayer createDamageEntityEventSourcePlayer(Game game, Cause cause, double originalFinalDamage, double finalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, Map<DamageModifier, Double> originalDamages, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Player sourceEntity, Entity targetEntity, double baseDamage, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("finalDamage", finalDamage);
        values.put("modifiers", modifiers);
        values.put("originalDamages", originalDamages);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("baseDamage", baseDamage);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DestructEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param source The source
     * @param targetEntity The target entity
     * @return A new destruct entity event
     */
    public static DestructEntityEvent createDestructEntityEvent(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, CommandSource source, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("source", source);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DestructEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new dismount entity event
     */
    public static DismountEntityEvent createDismountEntityEvent(Game game, Cause cause, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity dismount entity event
     */
    public static DismountEntityEvent.SourceEntity createDismountEntityEventSourceEntity(Game game, Cause cause, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human dismount entity event
     */
    public static DismountEntityEvent.SourceHuman createDismountEntityEventSourceHuman(Game game, Cause cause, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living dismount entity event
     */
    public static DismountEntityEvent.SourceLiving createDismountEntityEventSourceLiving(Game game, Cause cause, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player dismount entity event
     */
    public static DismountEntityEvent.SourcePlayer createDismountEntityEventSourcePlayer(Game game, Cause cause, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new displace entity event
     */
    public static DisplaceEntityEvent createDisplaceEntityEvent(Game game, Transform<World> fromTransform, Transform<World> toTransform, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new move displace entity event
     */
    public static DisplaceEntityEvent.Move createDisplaceEntityEventMove(Game game, Transform<World> fromTransform, Transform<World> toTransform, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Move.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetHuman}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new target human move displace entity event
     */
    public static DisplaceEntityEvent.Move.TargetHuman createDisplaceEntityEventMoveTargetHuman(Game game, Transform<World> fromTransform, Transform<World> toTransform, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Move.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetLiving}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new target living move displace entity event
     */
    public static DisplaceEntityEvent.Move.TargetLiving createDisplaceEntityEventMoveTargetLiving(Game game, Transform<World> fromTransform, Transform<World> toTransform, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Move.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetPlayer}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new target player move displace entity event
     */
    public static DisplaceEntityEvent.Move.TargetPlayer createDisplaceEntityEventMoveTargetPlayer(Game game, Transform<World> fromTransform, Transform<World> toTransform, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Move.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetHuman}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new target human displace entity event
     */
    public static DisplaceEntityEvent.TargetHuman createDisplaceEntityEventTargetHuman(Game game, Transform<World> fromTransform, Transform<World> toTransform, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetLiving}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new target living displace entity event
     */
    public static DisplaceEntityEvent.TargetLiving createDisplaceEntityEventTargetLiving(Game game, Transform<World> fromTransform, Transform<World> toTransform, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new target player displace entity event
     */
    public static DisplaceEntityEvent.TargetPlayer createDisplaceEntityEventTargetPlayer(Game game, Transform<World> fromTransform, Transform<World> toTransform, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @param teleporterAgent The teleporter agent
     * @param keepsVelocity The keeps velocity
     * @return A new teleport displace entity event
     */
    public static DisplaceEntityEvent.Teleport createDisplaceEntityEventTeleport(Game game, Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Entity targetEntity, TeleporterAgent teleporterAgent, boolean keepsVelocity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        values.put("teleporterAgent", teleporterAgent);
        values.put("keepsVelocity", keepsVelocity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Teleport.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @param teleporterAgent The teleporter agent
     * @param keepsVelocity The keeps velocity
     * @return A new target human teleport displace entity event
     */
    public static DisplaceEntityEvent.Teleport.TargetHuman createDisplaceEntityEventTeleportTargetHuman(Game game, Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Human targetEntity, TeleporterAgent teleporterAgent, boolean keepsVelocity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        values.put("teleporterAgent", teleporterAgent);
        values.put("keepsVelocity", keepsVelocity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Teleport.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @param teleporterAgent The teleporter agent
     * @param keepsVelocity The keeps velocity
     * @return A new target living teleport displace entity event
     */
    public static DisplaceEntityEvent.Teleport.TargetLiving createDisplaceEntityEventTeleportTargetLiving(Game game, Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Living targetEntity, TeleporterAgent teleporterAgent, boolean keepsVelocity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        values.put("teleporterAgent", teleporterAgent);
        values.put("keepsVelocity", keepsVelocity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Teleport.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetPlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @param teleporterAgent The teleporter agent
     * @param keepsVelocity The keeps velocity
     * @return A new target player teleport displace entity event
     */
    public static DisplaceEntityEvent.Teleport.TargetPlayer createDisplaceEntityEventTeleportTargetPlayer(Game game, Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Player targetEntity, TeleporterAgent teleporterAgent, boolean keepsVelocity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        values.put("teleporterAgent", teleporterAgent);
        values.put("keepsVelocity", keepsVelocity);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Teleport.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new entity event
     */
    public static EntityEvent createEntityEvent(Game game, Cause cause, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(EntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new entity portal event
     */
    public static EntityPortalEvent createEntityPortalEvent(Game game, Cause cause, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(EntityPortalEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent.Enter}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new enter entity portal event
     */
    public static EntityPortalEvent.Enter createEntityPortalEventEnter(Game game, Cause cause, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(EntityPortalEvent.Enter.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent.Exit}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new exit entity portal event
     */
    public static EntityPortalEvent.Exit createEntityPortalEventExit(Game game, Cause cause, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(EntityPortalEvent.Exit.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ExpireEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new expire entity event
     */
    public static ExpireEntityEvent createExpireEntityEvent(Game game, Cause cause, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ExpireEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ExpireEntityEvent.TargetItem}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target item expire entity event
     */
    public static ExpireEntityEvent.TargetItem createExpireEntityEventTargetItem(Game game, Cause cause, Item targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ExpireEntityEvent.TargetItem.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent}.
     * 
     * @param game The game
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @return A new fishing event
     */
    public static FishingEvent createFishingEvent(Game game, EntitySnapshot originalFishHook, FishHook fishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast}.
     * 
     * @param game The game
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @return A new cast fishing event
     */
    public static FishingEvent.Cast createFishingEventCast(Game game, EntitySnapshot originalFishHook, FishHook fishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param sourceEntity The source entity
     * @return A new source entity cast fishing event
     */
    public static FishingEvent.Cast.SourceEntity createFishingEventCastSourceEntity(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param sourceEntity The source entity
     * @return A new source human cast fishing event
     */
    public static FishingEvent.Cast.SourceHuman createFishingEventCastSourceHuman(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param sourceEntity The source entity
     * @return A new source living cast fishing event
     */
    public static FishingEvent.Cast.SourceLiving createFishingEventCastSourceLiving(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param sourceEntity The source entity
     * @return A new source player cast fishing event
     */
    public static FishingEvent.Cast.SourcePlayer createFishingEventCastSourcePlayer(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook}.
     * 
     * @param game The game
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param originalHookedEntity The original hooked entity
     * @param hookedEntity The hooked entity
     * @param targetEntity The target entity
     * @return A new hook fishing event
     */
    public static FishingEvent.Hook createFishingEventHook(Game game, EntitySnapshot originalFishHook, FishHook fishHook, EntitySnapshot originalHookedEntity, Optional<Entity> hookedEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("hookedEntity", hookedEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param originalHookedEntity The original hooked entity
     * @param hookedEntity The hooked entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity hook fishing event
     */
    public static FishingEvent.Hook.SourceEntity createFishingEventHookSourceEntity(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, EntitySnapshot originalHookedEntity, Optional<Entity> hookedEntity, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("hookedEntity", hookedEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param originalHookedEntity The original hooked entity
     * @param hookedEntity The hooked entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human hook fishing event
     */
    public static FishingEvent.Hook.SourceHuman createFishingEventHookSourceHuman(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, EntitySnapshot originalHookedEntity, Optional<Entity> hookedEntity, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("hookedEntity", hookedEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param originalHookedEntity The original hooked entity
     * @param hookedEntity The hooked entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living hook fishing event
     */
    public static FishingEvent.Hook.SourceLiving createFishingEventHookSourceLiving(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, EntitySnapshot originalHookedEntity, Optional<Entity> hookedEntity, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("hookedEntity", hookedEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param originalHookedEntity The original hooked entity
     * @param hookedEntity The hooked entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player hook fishing event
     */
    public static FishingEvent.Hook.SourcePlayer createFishingEventHookSourcePlayer(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, EntitySnapshot originalHookedEntity, Optional<Entity> hookedEntity, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("hookedEntity", hookedEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract}.
     * 
     * @param game The game
     * @param originalCaughtEntity The original caught entity
     * @param caughtEntity The caught entity
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param itemStackTransaction The item stack transaction
     * @return A new retract fishing event
     */
    public static FishingEvent.Retract createFishingEventRetract(Game game, Optional<EntitySnapshot> originalCaughtEntity, Optional<Entity> caughtEntity, int originalExperience, int experience, EntitySnapshot originalFishHook, FishHook fishHook, Optional<ItemStackTransaction> itemStackTransaction) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("caughtEntity", caughtEntity);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("itemStackTransaction", itemStackTransaction);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalCaughtEntity The original caught entity
     * @param caughtEntity The caught entity
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param itemStackTransaction The item stack transaction
     * @param sourceEntity The source entity
     * @return A new source entity retract fishing event
     */
    public static FishingEvent.Retract.SourceEntity createFishingEventRetractSourceEntity(Game game, Cause cause, Optional<EntitySnapshot> originalCaughtEntity, Optional<Entity> caughtEntity, int originalExperience, int experience, EntitySnapshot originalFishHook, FishHook fishHook, Optional<ItemStackTransaction> itemStackTransaction, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("caughtEntity", caughtEntity);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalCaughtEntity The original caught entity
     * @param caughtEntity The caught entity
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param itemStackTransaction The item stack transaction
     * @param sourceEntity The source entity
     * @return A new source human retract fishing event
     */
    public static FishingEvent.Retract.SourceHuman createFishingEventRetractSourceHuman(Game game, Cause cause, Optional<EntitySnapshot> originalCaughtEntity, Optional<Entity> caughtEntity, int originalExperience, int experience, EntitySnapshot originalFishHook, FishHook fishHook, Optional<ItemStackTransaction> itemStackTransaction, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("caughtEntity", caughtEntity);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalCaughtEntity The original caught entity
     * @param caughtEntity The caught entity
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param itemStackTransaction The item stack transaction
     * @param sourceEntity The source entity
     * @return A new source living retract fishing event
     */
    public static FishingEvent.Retract.SourceLiving createFishingEventRetractSourceLiving(Game game, Cause cause, Optional<EntitySnapshot> originalCaughtEntity, Optional<Entity> caughtEntity, int originalExperience, int experience, EntitySnapshot originalFishHook, FishHook fishHook, Optional<ItemStackTransaction> itemStackTransaction, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("caughtEntity", caughtEntity);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalCaughtEntity The original caught entity
     * @param caughtEntity The caught entity
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param itemStackTransaction The item stack transaction
     * @param sourceEntity The source entity
     * @return A new source player retract fishing event
     */
    public static FishingEvent.Retract.SourcePlayer createFishingEventRetractSourcePlayer(Game game, Cause cause, Optional<EntitySnapshot> originalCaughtEntity, Optional<Entity> caughtEntity, int originalExperience, int experience, EntitySnapshot originalFishHook, FishHook fishHook, Optional<ItemStackTransaction> itemStackTransaction, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("caughtEntity", caughtEntity);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @return A new harvest entity event
     */
    public static HarvestEntityEvent createHarvestEntityEvent(Game game, Cause cause, int originalExperience, int experience, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HarvestEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @return A new target human harvest entity event
     */
    public static HarvestEntityEvent.TargetHuman createHarvestEntityEventTargetHuman(Game game, Cause cause, int originalExperience, int experience, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HarvestEntityEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @return A new target living harvest entity event
     */
    public static HarvestEntityEvent.TargetLiving createHarvestEntityEventTargetLiving(Game game, Cause cause, int originalExperience, int experience, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HarvestEntityEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @param keepsInventory The keeps inventory
     * @param keepsLevel The keeps level
     * @param level The level
     * @return A new target player harvest entity event
     */
    public static HarvestEntityEvent.TargetPlayer createHarvestEntityEventTargetPlayer(Game game, Cause cause, int originalExperience, int experience, Player targetEntity, boolean keepsInventory, boolean keepsLevel, int level) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("targetEntity", targetEntity);
        values.put("keepsInventory", keepsInventory);
        values.put("keepsLevel", keepsLevel);
        values.put("level", level);
        return SpongeEventFactoryUtils.createEventImpl(HarvestEntityEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HealEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalHealingAmounts The original healing amounts
     * @param targetEntity The target entity
     * @param baseHealAmount The base heal amount
     * @param finalHealAmount The final heal amount
     * @param originalHealAmount The original heal amount
     * @return A new heal entity event
     */
    public static HealEntityEvent createHealEntityEvent(Game game, Cause cause, List<Tuple<HealthModifier, Function<? super Double, Double>>> modifiers, List<Tuple<HealthModifier, Function<? super Double, Double>>> originalFunctions, Map<HealthModifier, Double> originalHealingAmounts, Entity targetEntity, double baseHealAmount, double finalHealAmount, double originalHealAmount) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalHealingAmounts", originalHealingAmounts);
        values.put("targetEntity", targetEntity);
        values.put("baseHealAmount", baseHealAmount);
        values.put("finalHealAmount", finalHealAmount);
        values.put("originalHealAmount", originalHealAmount);
        return SpongeEventFactoryUtils.createEventImpl(HealEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.IgniteEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param fireTicks The fire ticks
     * @return A new ignite entity event
     */
    public static IgniteEntityEvent createIgniteEntityEvent(Game game, Entity targetEntity, int fireTicks) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("fireTicks", fireTicks);
        return SpongeEventFactoryUtils.createEventImpl(IgniteEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new interact entity event
     */
    public static InteractEntityEvent createInteractEntityEvent(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param originalDamage The original damage
     * @return A new attack interact entity event
     */
    public static InteractEntityEvent.Attack createInteractEntityEventAttack(Game game, Cause cause, Optional<Vector3d> interactionPoint, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("originalFunctions", originalFunctions);
        values.put("targetEntity", targetEntity);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param originalDamage The original damage
     * @return A new source entity attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourceEntity createInteractEntityEventAttackSourceEntity(Game game, Cause cause, Optional<Vector3d> interactionPoint, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity sourceEntity, Entity targetEntity, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param originalDamage The original damage
     * @return A new source human attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourceHuman createInteractEntityEventAttackSourceHuman(Game game, Cause cause, Optional<Vector3d> interactionPoint, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Human sourceEntity, Entity targetEntity, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLightning}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param originalDamage The original damage
     * @return A new source lightning attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourceLightning createInteractEntityEventAttackSourceLightning(Game game, Cause cause, Optional<Vector3d> interactionPoint, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Lightning sourceEntity, Entity targetEntity, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourceLightning.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param originalDamage The original damage
     * @return A new source living attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourceLiving createInteractEntityEventAttackSourceLiving(Game game, Cause cause, Optional<Vector3d> interactionPoint, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Living sourceEntity, Entity targetEntity, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param originalDamage The original damage
     * @return A new source player attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourcePlayer createInteractEntityEventAttackSourcePlayer(Game game, Cause cause, Optional<Vector3d> interactionPoint, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Player sourceEntity, Entity targetEntity, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetEntity The target entity
     * @return A new source block interact entity event
     */
    public static InteractEntityEvent.SourceBlock createInteractEntityEventSourceBlock(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity interact entity event
     */
    public static InteractEntityEvent.SourceEntity createInteractEntityEventSourceEntity(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human interact entity event
     */
    public static InteractEntityEvent.SourceHuman createInteractEntityEventSourceHuman(Game game, Cause cause, Optional<Vector3d> interactionPoint, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living interact entity event
     */
    public static InteractEntityEvent.SourceLiving createInteractEntityEventSourceLiving(Game game, Cause cause, Optional<Vector3d> interactionPoint, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player interact entity event
     */
    public static InteractEntityEvent.SourcePlayer createInteractEntityEventSourcePlayer(Game game, Cause cause, Optional<Vector3d> interactionPoint, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new use interact entity event
     */
    public static InteractEntityEvent.Use createInteractEntityEventUse(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Use.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity use interact entity event
     */
    public static InteractEntityEvent.Use.SourceEntity createInteractEntityEventUseSourceEntity(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Use.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human use interact entity event
     */
    public static InteractEntityEvent.Use.SourceHuman createInteractEntityEventUseSourceHuman(Game game, Cause cause, Optional<Vector3d> interactionPoint, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Use.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living use interact entity event
     */
    public static InteractEntityEvent.Use.SourceLiving createInteractEntityEventUseSourceLiving(Game game, Cause cause, Optional<Vector3d> interactionPoint, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Use.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player use interact entity event
     */
    public static InteractEntityEvent.Use.SourcePlayer createInteractEntityEventUseSourcePlayer(Game game, Cause cause, Optional<Vector3d> interactionPoint, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Use.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new leash entity event
     */
    public static LeashEntityEvent createLeashEntityEvent(Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity leash entity event
     */
    public static LeashEntityEvent.SourceEntity createLeashEntityEventSourceEntity(Game game, Cause cause, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human leash entity event
     */
    public static LeashEntityEvent.SourceHuman createLeashEntityEventSourceHuman(Game game, Cause cause, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living leash entity event
     */
    public static LeashEntityEvent.SourceLiving createLeashEntityEventSourceLiving(Game game, Cause cause, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player leash entity event
     */
    public static LeashEntityEvent.SourcePlayer createLeashEntityEventSourcePlayer(Game game, Cause cause, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MountEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new mount entity event
     */
    public static MountEntityEvent createMountEntityEvent(Game game, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("vehicle", vehicle);
        return SpongeEventFactoryUtils.createEventImpl(MountEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MountEntityEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new source entity mount entity event
     */
    public static MountEntityEvent.SourceEntity createMountEntityEventSourceEntity(Game game, Cause cause, Entity sourceEntity, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("vehicle", vehicle);
        return SpongeEventFactoryUtils.createEventImpl(MountEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MountEntityEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new source human mount entity event
     */
    public static MountEntityEvent.SourceHuman createMountEntityEventSourceHuman(Game game, Cause cause, Human sourceEntity, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("vehicle", vehicle);
        return SpongeEventFactoryUtils.createEventImpl(MountEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MountEntityEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new source living mount entity event
     */
    public static MountEntityEvent.SourceLiving createMountEntityEventSourceLiving(Game game, Cause cause, Living sourceEntity, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("vehicle", vehicle);
        return SpongeEventFactoryUtils.createEventImpl(MountEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MountEntityEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new source player mount entity event
     */
    public static MountEntityEvent.SourcePlayer createMountEntityEventSourcePlayer(Game game, Cause cause, Player sourceEntity, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("vehicle", vehicle);
        return SpongeEventFactoryUtils.createEventImpl(MountEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new spawn entity event
     */
    public static SpawnEntityEvent createSpawnEntityEvent(Game game, Cause cause, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new tame entity event
     */
    public static TameEntityEvent createTameEntityEvent(Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity tame entity event
     */
    public static TameEntityEvent.SourceEntity createTameEntityEventSourceEntity(Game game, Cause cause, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human tame entity event
     */
    public static TameEntityEvent.SourceHuman createTameEntityEventSourceHuman(Game game, Cause cause, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living tame entity event
     */
    public static TameEntityEvent.SourceLiving createTameEntityEventSourceLiving(Game game, Cause cause, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player tame entity event
     */
    public static TameEntityEvent.SourcePlayer createTameEntityEventSourcePlayer(Game game, Cause cause, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TargetEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target entity event
     */
    public static TargetEntityEvent createTargetEntityEvent(Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TargetEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new unleash entity event
     */
    public static UnleashEntityEvent createUnleashEntityEvent(Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity unleash entity event
     */
    public static UnleashEntityEvent.SourceEntity createUnleashEntityEventSourceEntity(Game game, Cause cause, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human unleash entity event
     */
    public static UnleashEntityEvent.SourceHuman createUnleashEntityEventSourceHuman(Game game, Cause cause, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living unleash entity event
     */
    public static UnleashEntityEvent.SourceLiving createUnleashEntityEventSourceLiving(Game game, Cause cause, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player unleash entity event
     */
    public static UnleashEntityEvent.SourcePlayer createUnleashEntityEventSourcePlayer(Game game, Cause cause, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.item.ItemMergeItemEvent}.
     * 
     * @param game The game
     * @param itemToMerge The item to merge
     * @param targetEntity The target entity
     * @return A new item merge item event
     */
    public static ItemMergeItemEvent createItemMergeItemEvent(Game game, Item itemToMerge, Item targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("itemToMerge", itemToMerge);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ItemMergeItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.item.TargetItemEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target item event
     */
    public static TargetItemEvent createTargetItemEvent(Game game, Item targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TargetItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.LivingEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new living event
     */
    public static LivingEvent createLivingEvent(Game game, Cause cause, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(LivingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.TargetLivingEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target living event
     */
    public static TargetLivingEvent createTargetLivingEvent(Game game, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TargetLivingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param sourceEntity The source entity
     * @param currentExperience The current experience
     * @return A new change human experience event
     */
    public static ChangeHumanExperienceEvent createChangeHumanExperienceEvent(Game game, Cause cause, int originalExperience, int experience, Human sourceEntity, int currentExperience) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("sourceEntity", sourceEntity);
        values.put("currentExperience", currentExperience);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanExperienceEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param currentExperience The current experience
     * @return A new target player change human experience event
     */
    public static ChangeHumanExperienceEvent.TargetPlayer createChangeHumanExperienceEventTargetPlayer(Game game, Cause cause, int originalExperience, int experience, Human sourceEntity, Player targetEntity, int currentExperience) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        values.put("currentExperience", currentExperience);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanExperienceEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalGameMode The original game mode
     * @param gameMode The game mode
     * @param targetEntity The target entity
     * @return A new change human game mode event
     */
    public static ChangeHumanGameModeEvent createChangeHumanGameModeEvent(Game game, Cause cause, GameMode originalGameMode, GameMode gameMode, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalGameMode", originalGameMode);
        values.put("gameMode", gameMode);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanGameModeEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalGameMode The original game mode
     * @param gameMode The game mode
     * @param targetEntity The target entity
     * @return A new target player change human game mode event
     */
    public static ChangeHumanGameModeEvent.TargetPlayer createChangeHumanGameModeEventTargetPlayer(Game game, Cause cause, GameMode originalGameMode, GameMode gameMode, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalGameMode", originalGameMode);
        values.put("gameMode", gameMode);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanGameModeEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent}.
     * 
     * @param game The game
     * @param originalLevel The original level
     * @param level The level
     * @param targetEntity The target entity
     * @return A new change human level event
     */
    public static ChangeHumanLevelEvent createChangeHumanLevelEvent(Game game, int originalLevel, int level, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalLevel", originalLevel);
        values.put("level", level);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanLevelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param originalLevel The original level
     * @param level The level
     * @param targetEntity The target entity
     * @return A new target player change human level event
     */
    public static ChangeHumanLevelEvent.TargetPlayer createChangeHumanLevelEventTargetPlayer(Game game, int originalLevel, int level, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalLevel", originalLevel);
        values.put("level", level);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanLevelEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new human event
     */
    public static HumanEvent createHumanEvent(Game game, Cause cause, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param sourceEntity The source entity
     * @return A new human sleep event
     */
    public static HumanSleepEvent createHumanSleepEvent(Game game, Cause cause, Location<World> bed, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.Enter}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param sourceEntity The source entity
     * @return A new enter human sleep event
     */
    public static HumanSleepEvent.Enter createHumanSleepEventEnter(Game game, Cause cause, Location<World> bed, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.Enter.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param sourceEntity The source entity
     * @return A new source player human sleep event
     */
    public static HumanSleepEvent.SourcePlayer createHumanSleepEventSourcePlayer(Game game, Cause cause, Location<World> bed, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.Enter}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param sourceEntity The source entity
     * @return A new enter source player human sleep event
     */
    public static HumanSleepEvent.SourcePlayer.Enter createHumanSleepEventSourcePlayerEnter(Game game, Cause cause, Location<World> bed, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.SourcePlayer.Enter.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StartSleeping}.
     * 
     * @param game The game
     * @param cause The cause
     * @param awokenPlayers The awoken players
     * @param bed The bed
     * @param ignoredPlayers The ignored players
     * @param sourceEntity The source entity
     * @return A new start sleeping source player human sleep event
     */
    public static HumanSleepEvent.SourcePlayer.StartSleeping createHumanSleepEventSourcePlayerStartSleeping(Game game, Cause cause, List<Player> awokenPlayers, Location<World> bed, List<Player> ignoredPlayers, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("awokenPlayers", awokenPlayers);
        values.put("bed", bed);
        values.put("ignoredPlayers", ignoredPlayers);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.SourcePlayer.StartSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StopSleeping}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param sourceEntity The source entity
     * @param spawnTransform The spawn transform
     * @return A new stop sleeping source player human sleep event
     */
    public static HumanSleepEvent.SourcePlayer.StopSleeping createHumanSleepEventSourcePlayerStopSleeping(Game game, Cause cause, Location<World> bed, Player sourceEntity, Optional<Transform<World>> spawnTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("sourceEntity", sourceEntity);
        values.put("spawnTransform", spawnTransform);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.SourcePlayer.StopSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StartSleeping}.
     * 
     * @param game The game
     * @param cause The cause
     * @param awokenPlayers The awoken players
     * @param bed The bed
     * @param ignoredPlayers The ignored players
     * @param sourceEntity The source entity
     * @return A new start sleeping human sleep event
     */
    public static HumanSleepEvent.StartSleeping createHumanSleepEventStartSleeping(Game game, Cause cause, List<Player> awokenPlayers, Location<World> bed, List<Player> ignoredPlayers, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("awokenPlayers", awokenPlayers);
        values.put("bed", bed);
        values.put("ignoredPlayers", ignoredPlayers);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.StartSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StopSleeping}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param sourceEntity The source entity
     * @param spawnTransform The spawn transform
     * @return A new stop sleeping human sleep event
     */
    public static HumanSleepEvent.StopSleeping createHumanSleepEventStopSleeping(Game game, Cause cause, Location<World> bed, Human sourceEntity, Optional<Transform<World>> spawnTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("sourceEntity", sourceEntity);
        values.put("spawnTransform", spawnTransform);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.StopSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.TargetHumanEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target human event
     */
    public static TargetHumanEvent createTargetHumanEvent(Game game, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TargetHumanEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.KickPlayerEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param targetEntity The target entity
     * @return A new kick player event
     */
    public static KickPlayerEvent createKickPlayerEvent(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(KickPlayerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new player event
     */
    public static PlayerEvent createPlayerEvent(Game game, Cause cause, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(PlayerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param pack The pack
     * @param sourceEntity The source entity
     * @param status The status
     * @return A new player resource pack status event
     */
    public static PlayerResourcePackStatusEvent createPlayerResourcePackStatusEvent(Game game, Cause cause, ResourcePack pack, Player sourceEntity, PlayerResourcePackStatusEvent.ResourcePackStatus status) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("pack", pack);
        values.put("sourceEntity", sourceEntity);
        values.put("status", status);
        return SpongeEventFactoryUtils.createEventImpl(PlayerResourcePackStatusEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.RespawnPlayerEvent}.
     * 
     * @param game The game
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @param bedSpawn The bed spawn
     * @return A new respawn player event
     */
    public static RespawnPlayerEvent createRespawnPlayerEvent(Game game, Transform<World> fromTransform, Transform<World> toTransform, Player targetEntity, boolean bedSpawn) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("targetEntity", targetEntity);
        values.put("bedSpawn", bedSpawn);
        return SpongeEventFactoryUtils.createEventImpl(RespawnPlayerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.TargetPlayerEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target player event
     */
    public static TargetPlayerEvent createTargetPlayerEvent(Game game, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TargetPlayerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param source The source
     * @param targetEntity The target entity
     * @return A new launch projectile event
     */
    public static LaunchProjectileEvent createLaunchProjectileEvent(Game game, Cause cause, Optional<ProjectileSource> source, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("source", source);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LaunchProjectileEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param source The source
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity launch projectile event
     */
    public static LaunchProjectileEvent.SourceEntity createLaunchProjectileEventSourceEntity(Game game, Cause cause, Optional<ProjectileSource> source, Entity sourceEntity, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LaunchProjectileEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param source The source
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human launch projectile event
     */
    public static LaunchProjectileEvent.SourceHuman createLaunchProjectileEventSourceHuman(Game game, Cause cause, Optional<ProjectileSource> source, Human sourceEntity, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LaunchProjectileEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param source The source
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living launch projectile event
     */
    public static LaunchProjectileEvent.SourceLiving createLaunchProjectileEventSourceLiving(Game game, Cause cause, Optional<ProjectileSource> source, Living sourceEntity, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LaunchProjectileEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param source The source
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player launch projectile event
     */
    public static LaunchProjectileEvent.SourcePlayer createLaunchProjectileEventSourcePlayer(Game game, Cause cause, Optional<ProjectileSource> source, Player sourceEntity, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LaunchProjectileEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.TargetProjectileEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target projectile event
     */
    public static TargetProjectileEvent createTargetProjectileEvent(Game game, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TargetProjectileEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameAboutToStartServerEvent}.
     * 
     * @param game The game
     * @return A new game about to start server event
     */
    public static GameAboutToStartServerEvent createGameAboutToStartServerEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameAboutToStartServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameConstructionEvent}.
     * 
     * @param game The game
     * @return A new game construction event
     */
    public static GameConstructionEvent createGameConstructionEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameConstructionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameInitializationEvent}.
     * 
     * @param game The game
     * @return A new game initialization event
     */
    public static GameInitializationEvent createGameInitializationEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameInitializationEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameLoadCompleteEvent}.
     * 
     * @param game The game
     * @return A new game load complete event
     */
    public static GameLoadCompleteEvent createGameLoadCompleteEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameLoadCompleteEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GamePostInitializationEvent}.
     * 
     * @param game The game
     * @return A new game post initialization event
     */
    public static GamePostInitializationEvent createGamePostInitializationEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GamePostInitializationEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GamePreInitializationEvent}.
     * 
     * @param game The game
     * @return A new game pre initialization event
     */
    public static GamePreInitializationEvent createGamePreInitializationEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GamePreInitializationEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStartedServerEvent}.
     * 
     * @param game The game
     * @return A new game started server event
     */
    public static GameStartedServerEvent createGameStartedServerEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameStartedServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStartingServerEvent}.
     * 
     * @param game The game
     * @return A new game starting server event
     */
    public static GameStartingServerEvent createGameStartingServerEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameStartingServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStateEvent}.
     * 
     * @param game The game
     * @return A new game state event
     */
    public static GameStateEvent createGameStateEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameStateEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppedServerEvent}.
     * 
     * @param game The game
     * @return A new game stopped server event
     */
    public static GameStoppedServerEvent createGameStoppedServerEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameStoppedServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppingServerEvent}.
     * 
     * @param game The game
     * @return A new game stopping server event
     */
    public static GameStoppingServerEvent createGameStoppingServerEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(GameStoppingServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.BlockBrewEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block brew event
     */
    public static BlockBrewEvent createBlockBrewEvent(Game game, Cause cause, Inventory inventory, Optional<ItemStack> result, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("result", result);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return SpongeEventFactoryUtils.createEventImpl(BlockBrewEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.BlockInventoryEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block inventory event
     */
    public static BlockInventoryEvent createBlockInventoryEvent(Game game, Cause cause, Inventory inventory, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return SpongeEventFactoryUtils.createEventImpl(BlockInventoryEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.BulkItemResultEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param results The results
     * @return A new bulk item result event
     */
    public static BulkItemResultEvent createBulkItemResultEvent(Game game, Inventory inventory, List<ItemStack> results) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("results", results);
        return SpongeEventFactoryUtils.createEventImpl(BulkItemResultEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.ContainerEvent}.
     * 
     * @param game The game
     * @param container The container
     * @return A new container event
     */
    public static ContainerEvent createContainerEvent(Game game, Container container) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        return SpongeEventFactoryUtils.createEventImpl(ContainerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @return A new drop item stack event
     */
    public static DropItemStackEvent createDropItemStackEvent(Game game, Cause cause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @return A new post drop item stack event
     */
    public static DropItemStackEvent.Post createDropItemStackEventPost(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block post drop item stack event
     */
    public static DropItemStackEvent.Post.SourceBlock createDropItemStackEventPostSourceBlock(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceEntity The source entity
     * @return A new source entity post drop item stack event
     */
    public static DropItemStackEvent.Post.SourceEntity createDropItemStackEventPostSourceEntity(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceEntity The source entity
     * @return A new source human post drop item stack event
     */
    public static DropItemStackEvent.Post.SourceHuman createDropItemStackEventPostSourceHuman(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceEntity The source entity
     * @return A new source living post drop item stack event
     */
    public static DropItemStackEvent.Post.SourceLiving createDropItemStackEventPostSourceLiving(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param sourceEntity The source entity
     * @return A new source player post drop item stack event
     */
    public static DropItemStackEvent.Post.SourcePlayer createDropItemStackEventPostSourcePlayer(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @return A new pre drop item stack event
     */
    public static DropItemStackEvent.Pre createDropItemStackEventPre(Game game, Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourceBlock createDropItemStackEventPreSourceBlock(Game game, Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceEntity The source entity
     * @return A new source entity pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourceEntity createDropItemStackEventPreSourceEntity(Game game, Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceEntity The source entity
     * @return A new source human pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourceHuman createDropItemStackEventPreSourceHuman(Game game, Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceEntity The source entity
     * @return A new source living pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourceLiving createDropItemStackEventPreSourceLiving(Game game, Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param sourceEntity The source entity
     * @return A new source player pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourcePlayer createDropItemStackEventPreSourcePlayer(Game game, Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block drop item stack event
     */
    public static DropItemStackEvent.SourceBlock createDropItemStackEventSourceBlock(Game game, Cause cause, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new source entity drop item stack event
     */
    public static DropItemStackEvent.SourceEntity createDropItemStackEventSourceEntity(Game game, Cause cause, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new source human drop item stack event
     */
    public static DropItemStackEvent.SourceHuman createDropItemStackEventSourceHuman(Game game, Cause cause, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new source living drop item stack event
     */
    public static DropItemStackEvent.SourceLiving createDropItemStackEventSourceLiving(Game game, Cause cause, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceEntity The source entity
     * @return A new source player drop item stack event
     */
    public static DropItemStackEvent.SourcePlayer createDropItemStackEventSourcePlayer(Game game, Cause cause, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryClickEvent}.
     * 
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @return A new inventory click event
     */
    public static InventoryClickEvent createInventoryClickEvent(Game game, Container container, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        values.put("viewer", viewer);
        return SpongeEventFactoryUtils.createEventImpl(InventoryClickEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryCloseEvent}.
     * 
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @return A new inventory close event
     */
    public static InventoryCloseEvent createInventoryCloseEvent(Game game, Container container, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        values.put("viewer", viewer);
        return SpongeEventFactoryUtils.createEventImpl(InventoryCloseEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @return A new inventory event
     */
    public static InventoryEvent createInventoryEvent(Game game, Inventory inventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        return SpongeEventFactoryUtils.createEventImpl(InventoryEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.ItemResultEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param result The result
     * @return A new item result event
     */
    public static ItemResultEvent createItemResultEvent(Game game, Inventory inventory, Optional<ItemStack> result) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("result", result);
        return SpongeEventFactoryUtils.createEventImpl(ItemResultEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @return A new pick up item event
     */
    public static PickUpItemEvent createPickUpItemEvent(Game game, Inventory inventory, Collection<Item> items) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("items", items);
        return SpongeEventFactoryUtils.createEventImpl(PickUpItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceBlock}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param items The items
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block pick up item event
     */
    public static PickUpItemEvent.SourceBlock createPickUpItemEventSourceBlock(Game game, Cause cause, Inventory inventory, Collection<Item> items, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        return SpongeEventFactoryUtils.createEventImpl(PickUpItemEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @return A new source entity pick up item event
     */
    public static PickUpItemEvent.SourceEntity createPickUpItemEventSourceEntity(Game game, Cause cause, Inventory inventory, Collection<Item> items, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(PickUpItemEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @return A new source human pick up item event
     */
    public static PickUpItemEvent.SourceHuman createPickUpItemEventSourceHuman(Game game, Cause cause, Inventory inventory, Collection<Item> items, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(PickUpItemEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @return A new source living pick up item event
     */
    public static PickUpItemEvent.SourceLiving createPickUpItemEventSourceLiving(Game game, Cause cause, Inventory inventory, Collection<Item> items, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(PickUpItemEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @return A new source player pick up item event
     */
    public static PickUpItemEvent.SourcePlayer createPickUpItemEventSourcePlayer(Game game, Cause cause, Inventory inventory, Collection<Item> items, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("inventory", inventory);
        values.put("items", items);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(PickUpItemEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @return A new use item stack event
     */
    public static UseItemStackEvent createUseItemStackEvent(Game game, Cause cause, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @return A new finish use item stack event
     */
    public static UseItemStackEvent.Finish createUseItemStackEventFinish(Game game, Cause cause, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source entity finish use item stack event
     */
    public static UseItemStackEvent.Finish.SourceEntity createUseItemStackEventFinishSourceEntity(Game game, Cause cause, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Finish.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source human finish use item stack event
     */
    public static UseItemStackEvent.Finish.SourceHuman createUseItemStackEventFinishSourceHuman(Game game, Cause cause, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Finish.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source living finish use item stack event
     */
    public static UseItemStackEvent.Finish.SourceLiving createUseItemStackEventFinishSourceLiving(Game game, Cause cause, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Finish.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source player finish use item stack event
     */
    public static UseItemStackEvent.Finish.SourcePlayer createUseItemStackEventFinishSourcePlayer(Game game, Cause cause, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Finish.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @return A new start use item stack event
     */
    public static UseItemStackEvent.Start createUseItemStackEventStart(Game game, Cause cause, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source entity start use item stack event
     */
    public static UseItemStackEvent.Start.SourceEntity createUseItemStackEventStartSourceEntity(Game game, Cause cause, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Start.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source human start use item stack event
     */
    public static UseItemStackEvent.Start.SourceHuman createUseItemStackEventStartSourceHuman(Game game, Cause cause, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Start.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source living start use item stack event
     */
    public static UseItemStackEvent.Start.SourceLiving createUseItemStackEventStartSourceLiving(Game game, Cause cause, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Start.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source player start use item stack event
     */
    public static UseItemStackEvent.Start.SourcePlayer createUseItemStackEventStartSourcePlayer(Game game, Cause cause, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Start.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @return A new stop use item stack event
     */
    public static UseItemStackEvent.Stop createUseItemStackEventStop(Game game, Cause cause, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source entity stop use item stack event
     */
    public static UseItemStackEvent.Stop.SourceEntity createUseItemStackEventStopSourceEntity(Game game, Cause cause, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Stop.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source human stop use item stack event
     */
    public static UseItemStackEvent.Stop.SourceHuman createUseItemStackEventStopSourceHuman(Game game, Cause cause, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Stop.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source living stop use item stack event
     */
    public static UseItemStackEvent.Stop.SourceLiving createUseItemStackEventStopSourceLiving(Game game, Cause cause, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Stop.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source player stop use item stack event
     */
    public static UseItemStackEvent.Stop.SourcePlayer createUseItemStackEventStopSourcePlayer(Game game, Cause cause, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Stop.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @return A new tick use item stack event
     */
    public static UseItemStackEvent.Tick createUseItemStackEventTick(Game game, Cause cause, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source entity tick use item stack event
     */
    public static UseItemStackEvent.Tick.SourceEntity createUseItemStackEventTickSourceEntity(Game game, Cause cause, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Tick.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source human tick use item stack event
     */
    public static UseItemStackEvent.Tick.SourceHuman createUseItemStackEventTickSourceHuman(Game game, Cause cause, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Tick.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source living tick use item stack event
     */
    public static UseItemStackEvent.Tick.SourceLiving createUseItemStackEventTickSourceLiving(Game game, Cause cause, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Tick.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source player tick use item stack event
     */
    public static UseItemStackEvent.Tick.SourcePlayer createUseItemStackEventTickSourcePlayer(Game game, Cause cause, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Tick.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent}.
     * 
     * @param game The game
     * @param container The container
     * @param inventory The inventory
     * @param recipe The recipe
     * @param resultTypes The result types
     * @param results The results
     * @param viewer The viewer
     * @return A new viewer craft item event
     */
    public static ViewerCraftItemEvent createViewerCraftItemEvent(Game game, Container container, CraftingInventory inventory, Recipe recipe, List<ItemType> resultTypes, List<ItemStack> results, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        values.put("inventory", inventory);
        values.put("recipe", recipe);
        values.put("resultTypes", resultTypes);
        values.put("results", results);
        values.put("viewer", viewer);
        return SpongeEventFactoryUtils.createEventImpl(ViewerCraftItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerEvent}.
     * 
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @return A new viewer event
     */
    public static ViewerEvent createViewerEvent(Game game, Container container, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        values.put("viewer", viewer);
        return SpongeEventFactoryUtils.createEventImpl(ViewerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerOpenContainerEvent}.
     * 
     * @param game The game
     * @param container The container
     * @param viewer The viewer
     * @return A new viewer open container event
     */
    public static ViewerOpenContainerEvent createViewerOpenContainerEvent(Game game, Container container, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("container", container);
        values.put("viewer", viewer);
        return SpongeEventFactoryUtils.createEventImpl(ViewerOpenContainerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.BanIpEvent}.
     * 
     * @param ban The ban
     * @return A new ban ip event
     */
    public static BanIpEvent createBanIpEvent(Ban.Ip ban) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("ban", ban);
        return SpongeEventFactoryUtils.createEventImpl(BanIpEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent}.
     * 
     * @param game The game
     * @param connection The connection
     * @param profile The profile
     * @return A new client connection event
     */
    public static ClientConnectionEvent createClientConnectionEvent(Game game, RemoteConnection connection, GameProfile profile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("connection", connection);
        values.put("profile", profile);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Auth}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @param connection The connection
     * @param profile The profile
     * @return A new auth client connection event
     */
    public static ClientConnectionEvent.Auth createClientConnectionEventAuth(Game game, Text originalMessage, Text message, RemoteConnection connection, GameProfile profile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("connection", connection);
        values.put("profile", profile);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.Auth.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Disconnect}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param connection The connection
     * @param profile The profile
     * @param targetEntity The target entity
     * @return A new disconnect client connection event
     */
    public static ClientConnectionEvent.Disconnect createClientConnectionEventDisconnect(Game game, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, RemoteConnection connection, GameProfile profile, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("connection", connection);
        values.put("profile", profile);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.Disconnect.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Join}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param connection The connection
     * @param profile The profile
     * @param targetEntity The target entity
     * @return A new join client connection event
     */
    public static ClientConnectionEvent.Join createClientConnectionEventJoin(Game game, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Transform<World> fromTransform, Transform<World> toTransform, RemoteConnection connection, GameProfile profile, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("connection", connection);
        values.put("profile", profile);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.Join.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Login}.
     * 
     * @param game The game
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param connection The connection
     * @param profile The profile
     * @return A new login client connection event
     */
    public static ClientConnectionEvent.Login createClientConnectionEventLogin(Game game, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, RemoteConnection connection, GameProfile profile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("connection", connection);
        values.put("profile", profile);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.Login.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.PardonIpEvent}.
     * 
     * @param ban The ban
     * @return A new pardon ip event
     */
    public static PardonIpEvent createPardonIpEvent(Ban.Ip ban) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("ban", ban);
        return SpongeEventFactoryUtils.createEventImpl(PardonIpEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.plugin.PluginEvent}.
     * 
     * @param game The game
     * @param plugin The plugin
     * @return A new plugin event
     */
    public static PluginEvent createPluginEvent(Game game, PluginContainer plugin) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("plugin", plugin);
        return SpongeEventFactoryUtils.createEventImpl(PluginEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.rcon.RconDisconnectEvent}.
     * 
     * @param source The source
     * @return A new rcon disconnect event
     */
    public static RconDisconnectEvent createRconDisconnectEvent(RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(RconDisconnectEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.rcon.RconEvent}.
     * 
     * @param source The source
     * @return A new rcon event
     */
    public static RconEvent createRconEvent(RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(RconEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.rcon.RconLoginEvent}.
     * 
     * @param source The source
     * @return A new rcon login event
     */
    public static RconLoginEvent createRconLoginEvent(RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(RconLoginEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.PingServerEvent}.
     * 
     * @param game The game
     * @param client The client
     * @param response The response
     * @param server The server
     * @return A new ping server event
     */
    public static PingServerEvent createPingServerEvent(Game game, StatusClient client, PingServerEvent.Response response, Server server) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("client", client);
        values.put("response", response);
        values.put("server", server);
        return SpongeEventFactoryUtils.createEventImpl(PingServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.PingServerEvent.Response}.
     * 
     * @param description The description
     * @param favicon The favicon
     * @param players The players
     * @param version The version
     * @return A new response ping server event
     */
    public static PingServerEvent.Response createPingServerEventResponse(Text description, Optional<Favicon> favicon, Optional<PingServerEvent.Response.Players> players, MinecraftVersion version) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("description", description);
        values.put("favicon", favicon);
        values.put("players", players);
        values.put("version", version);
        return SpongeEventFactoryUtils.createEventImpl(PingServerEvent.Response.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.PingServerEvent.Response.Players}.
     * 
     * @param profiles The profiles
     * @param max The max
     * @param online The online
     * @return A new players response ping server event
     */
    public static PingServerEvent.Response.Players createPingServerEventResponsePlayers(List<GameProfile> profiles, int max, int online) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("profiles", profiles);
        values.put("max", max);
        values.put("online", online);
        return SpongeEventFactoryUtils.createEventImpl(PingServerEvent.Response.Players.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ServerEvent}.
     * 
     * @param game The game
     * @param server The server
     * @return A new server event
     */
    public static ServerEvent createServerEvent(Game game, Server server) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("server", server);
        return SpongeEventFactoryUtils.createEventImpl(ServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.channel.RegisterChannelEvent}.
     * 
     * @param game The game
     * @param targetChannel The target channel
     * @return A new register channel event
     */
    public static RegisterChannelEvent createRegisterChannelEvent(Game game, String targetChannel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetChannel", targetChannel);
        return SpongeEventFactoryUtils.createEventImpl(RegisterChannelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.channel.RegisterChannelEvent.SourcePlugin}.
     * 
     * @param game The game
     * @param plugin The plugin
     * @param targetChannel The target channel
     * @return A new source plugin register channel event
     */
    public static RegisterChannelEvent.SourcePlugin createRegisterChannelEventSourcePlugin(Game game, PluginContainer plugin, String targetChannel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("plugin", plugin);
        values.put("targetChannel", targetChannel);
        return SpongeEventFactoryUtils.createEventImpl(RegisterChannelEvent.SourcePlugin.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.channel.TargetChannelEvent}.
     * 
     * @param game The game
     * @param targetChannel The target channel
     * @return A new target channel event
     */
    public static TargetChannelEvent createTargetChannelEvent(Game game, String targetChannel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetChannel", targetChannel);
        return SpongeEventFactoryUtils.createEventImpl(TargetChannelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.channel.UnRegisterChannelEvent}.
     * 
     * @param game The game
     * @param targetChannel The target channel
     * @return A new un register channel event
     */
    public static UnRegisterChannelEvent createUnRegisterChannelEvent(Game game, String targetChannel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetChannel", targetChannel);
        return SpongeEventFactoryUtils.createEventImpl(UnRegisterChannelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.channel.UnRegisterChannelEvent.SourcePlugin}.
     * 
     * @param game The game
     * @param plugin The plugin
     * @param targetChannel The target channel
     * @return A new source plugin un register channel event
     */
    public static UnRegisterChannelEvent.SourcePlugin createUnRegisterChannelEventSourcePlugin(Game game, PluginContainer plugin, String targetChannel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("plugin", plugin);
        values.put("targetChannel", targetChannel);
        return SpongeEventFactoryUtils.createEventImpl(UnRegisterChannelEvent.SourcePlugin.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.BasicQueryServerEvent}.
     * 
     * @param address The address
     * @param gameType The game type
     * @param map The map
     * @param motd The motd
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param playerCount The player count
     * @param size The size
     * @return A new basic query server event
     */
    public static BasicQueryServerEvent createBasicQueryServerEvent(InetSocketAddress address, String gameType, String map, String motd, int maxPlayerCount, int maxSize, int playerCount, int size) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("address", address);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("motd", motd);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("playerCount", playerCount);
        values.put("size", size);
        return SpongeEventFactoryUtils.createEventImpl(BasicQueryServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.FullQueryServerEvent}.
     * 
     * @param address The address
     * @param customValuesMap The custom values map
     * @param gameId The game id
     * @param gameType The game type
     * @param map The map
     * @param motd The motd
     * @param players The players
     * @param plugins The plugins
     * @param version The version
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param playerCount The player count
     * @param size The size
     * @return A new full query server event
     */
    public static FullQueryServerEvent createFullQueryServerEvent(InetSocketAddress address, Map<String, String> customValuesMap, String gameId, String gameType, String map, String motd, List<String> players, String plugins, String version, int maxPlayerCount, int maxSize, int playerCount, int size) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("address", address);
        values.put("customValuesMap", customValuesMap);
        values.put("gameId", gameId);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("motd", motd);
        values.put("players", players);
        values.put("plugins", plugins);
        values.put("version", version);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("playerCount", playerCount);
        values.put("size", size);
        return SpongeEventFactoryUtils.createEventImpl(FullQueryServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.QueryServerEvent}.
     * 
     * @param address The address
     * @param gameType The game type
     * @param map The map
     * @param motd The motd
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param playerCount The player count
     * @param size The size
     * @return A new query server event
     */
    public static QueryServerEvent createQueryServerEvent(InetSocketAddress address, String gameType, String map, String motd, int maxPlayerCount, int maxSize, int playerCount, int size) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("address", address);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("motd", motd);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("playerCount", playerCount);
        values.put("size", size);
        return SpongeEventFactoryUtils.createEventImpl(QueryServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.BanUserEvent}.
     * 
     * @param ban The ban
     * @param targetUser The target user
     * @return A new ban user event
     */
    public static BanUserEvent createBanUserEvent(Ban.User ban, User targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("ban", ban);
        values.put("targetUser", targetUser);
        return SpongeEventFactoryUtils.createEventImpl(BanUserEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.BanUserEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param ban The ban
     * @param targetEntity The target entity
     * @param targetUser The target user
     * @return A new target player ban user event
     */
    public static BanUserEvent.TargetPlayer createBanUserEventTargetPlayer(Game game, Ban.User ban, Player targetEntity, User targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("ban", ban);
        values.put("targetEntity", targetEntity);
        values.put("targetUser", targetUser);
        return SpongeEventFactoryUtils.createEventImpl(BanUserEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.PardonUserEvent}.
     * 
     * @param ban The ban
     * @param targetUser The target user
     * @return A new pardon user event
     */
    public static PardonUserEvent createPardonUserEvent(Ban.User ban, User targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("ban", ban);
        values.put("targetUser", targetUser);
        return SpongeEventFactoryUtils.createEventImpl(PardonUserEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.PardonUserEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param ban The ban
     * @param targetEntity The target entity
     * @param targetUser The target user
     * @return A new target player pardon user event
     */
    public static PardonUserEvent.TargetPlayer createPardonUserEventTargetPlayer(Game game, Ban.User ban, Player targetEntity, Player targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("ban", ban);
        values.put("targetEntity", targetEntity);
        values.put("targetUser", targetUser);
        return SpongeEventFactoryUtils.createEventImpl(PardonUserEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.TargetUserEvent}.
     * 
     * @param targetUser The target user
     * @return A new target user event
     */
    public static TargetUserEvent createTargetUserEvent(User targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("targetUser", targetUser);
        return SpongeEventFactoryUtils.createEventImpl(TargetUserEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ChangeWorldGameRuleEvent}.
     * 
     * @param game The game
     * @param originalValue The original value
     * @param value The value
     * @param name The name
     * @param targetWorld The target world
     * @return A new change world game rule event
     */
    public static ChangeWorldGameRuleEvent createChangeWorldGameRuleEvent(Game game, String originalValue, String value, String name, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalValue", originalValue);
        values.put("value", value);
        values.put("name", name);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(ChangeWorldGameRuleEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ChangeWorldWeatherEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param initialWeather The initial weather
     * @param resultingWeather The resulting weather
     * @param world The world
     * @param duration The duration
     * @return A new change world weather event
     */
    public static ChangeWorldWeatherEvent createChangeWorldWeatherEvent(Game game, Cause cause, Weather initialWeather, Weather resultingWeather, World world, int duration) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("initialWeather", initialWeather);
        values.put("resultingWeather", resultingWeather);
        values.put("world", world);
        values.put("duration", duration);
        return SpongeEventFactoryUtils.createEventImpl(ChangeWorldWeatherEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ConstructPortalEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param portalLocation The portal location
     * @return A new construct portal event
     */
    public static ConstructPortalEvent createConstructPortalEvent(Game game, Cause cause, Location<World> portalLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("portalLocation", portalLocation);
        return SpongeEventFactoryUtils.createEventImpl(ConstructPortalEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ConstructPortalEvent.SourceEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @return A new source entity construct portal event
     */
    public static ConstructPortalEvent.SourceEntity createConstructPortalEventSourceEntity(Game game, Cause cause, Location<World> portalLocation, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(ConstructPortalEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ConstructPortalEvent.SourceHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @return A new source human construct portal event
     */
    public static ConstructPortalEvent.SourceHuman createConstructPortalEventSourceHuman(Game game, Cause cause, Location<World> portalLocation, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(ConstructPortalEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ConstructPortalEvent.SourceLiving}.
     * 
     * @param game The game
     * @param cause The cause
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @return A new source living construct portal event
     */
    public static ConstructPortalEvent.SourceLiving createConstructPortalEventSourceLiving(Game game, Cause cause, Location<World> portalLocation, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(ConstructPortalEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ConstructPortalEvent.SourcePlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @return A new source player construct portal event
     */
    public static ConstructPortalEvent.SourcePlayer createConstructPortalEventSourcePlayer(Game game, Cause cause, Location<World> portalLocation, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(ConstructPortalEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ConstructWorldEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param worldCreationSettings The world creation settings
     * @param worldProperties The world properties
     * @return A new construct world event
     */
    public static ConstructWorldEvent createConstructWorldEvent(Game game, Cause cause, WorldCreationSettings worldCreationSettings, WorldProperties worldProperties) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("worldCreationSettings", worldCreationSettings);
        values.put("worldProperties", worldProperties);
        return SpongeEventFactoryUtils.createEventImpl(ConstructWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.LoadWorldEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @return A new load world event
     */
    public static LoadWorldEvent createLoadWorldEvent(Game game, Cause cause, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(LoadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.UnloadWorldEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @return A new unload world event
     */
    public static UnloadWorldEvent createUnloadWorldEvent(Game game, Cause cause, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(UnloadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @return A new world event
     */
    public static WorldEvent createWorldEvent(Game game, Cause cause, World sourceWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        return SpongeEventFactoryUtils.createEventImpl(WorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param explosion The explosion
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new world explosion event
     */
    public static WorldExplosionEvent createWorldExplosionEvent(Game game, Cause cause, Explosion explosion, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(WorldExplosionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent.Detonate}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param explosion The explosion
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new detonate world explosion event
     */
    public static WorldExplosionEvent.Detonate createWorldExplosionEventDetonate(Game game, Cause cause, List<? extends Entity> entities, List<EntitySnapshot> entitySnapshots, Explosion explosion, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("explosion", explosion);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(WorldExplosionEvent.Detonate.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param explosion The explosion
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new pre world explosion event
     */
    public static WorldExplosionEvent.Pre createWorldExplosionEventPre(Game game, Cause cause, Explosion explosion, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(WorldExplosionEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new world generate chunk event
     */
    public static WorldGenerateChunkEvent createWorldGenerateChunkEvent(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(WorldGenerateChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new post world generate chunk event
     */
    public static WorldGenerateChunkEvent.Post createWorldGenerateChunkEventPost(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(WorldGenerateChunkEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new pre world generate chunk event
     */
    public static WorldGenerateChunkEvent.Pre createWorldGenerateChunkEventPre(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(WorldGenerateChunkEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceChunk The source chunk
     * @param sourceLocation The source location
     * @return A new chunk event
     */
    public static ChunkEvent createChunkEvent(Game game, Cause cause, Chunk sourceChunk, Location<Chunk> sourceLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceChunk", sourceChunk);
        values.put("sourceLocation", sourceLocation);
        return SpongeEventFactoryUtils.createEventImpl(ChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ForcedChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param targetChunk The target chunk
     * @param ticket The ticket
     * @return A new forced chunk event
     */
    public static ForcedChunkEvent createForcedChunkEvent(Game game, Cause cause, Vector3i chunkCoords, Chunk targetChunk, ChunkLoadService.LoadingTicket ticket) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("chunkCoords", chunkCoords);
        values.put("targetChunk", targetChunk);
        values.put("ticket", ticket);
        return SpongeEventFactoryUtils.createEventImpl(ForcedChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.LoadChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new load chunk event
     */
    public static LoadChunkEvent createLoadChunkEvent(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(LoadChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.LoadChunkEvent.SourceWorld}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world load chunk event
     */
    public static LoadChunkEvent.SourceWorld createLoadChunkEventSourceWorld(Game game, Cause cause, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(LoadChunkEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new populate chunk event
     */
    public static PopulateChunkEvent createPopulateChunkEvent(Game game, Cause cause, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(PopulateChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Populate}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new populate populate chunk event
     */
    public static PopulateChunkEvent.Populate createPopulateChunkEventPopulate(Game game, Cause cause, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(PopulateChunkEvent.Populate.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new post populate chunk event
     */
    public static PopulateChunkEvent.Post createPopulateChunkEventPost(Game game, Cause cause, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(PopulateChunkEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param pendingPopulators The pending populators
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new pre populate chunk event
     */
    public static PopulateChunkEvent.Pre createPopulateChunkEventPre(Game game, Cause cause, List<Populator> pendingPopulators, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("pendingPopulators", pendingPopulators);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(PopulateChunkEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.TargetChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new target chunk event
     */
    public static TargetChunkEvent createTargetChunkEvent(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(TargetChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.TargetChunkEvent.SourceWorld}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world target chunk event
     */
    public static TargetChunkEvent.SourceWorld createTargetChunkEventSourceWorld(Game game, Cause cause, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(TargetChunkEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnforcedChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param ticket The ticket
     * @return A new unforced chunk event
     */
    public static UnforcedChunkEvent createUnforcedChunkEvent(Game game, Cause cause, Vector3i chunkCoords, ChunkLoadService.LoadingTicket ticket) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("chunkCoords", chunkCoords);
        values.put("ticket", ticket);
        return SpongeEventFactoryUtils.createEventImpl(UnforcedChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnloadChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new unload chunk event
     */
    public static UnloadChunkEvent createUnloadChunkEvent(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(UnloadChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnloadChunkEvent.SourceWorld}.
     * 
     * @param game The game
     * @param cause The cause
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world unload chunk event
     */
    public static UnloadChunkEvent.SourceWorld createUnloadChunkEventSourceWorld(Game game, Cause cause, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(UnloadChunkEvent.SourceWorld.class, values);
    }
}
