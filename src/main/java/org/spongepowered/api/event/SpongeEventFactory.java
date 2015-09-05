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
import org.spongepowered.api.event.world.CreatePortalEvent;
import org.spongepowered.api.event.world.CreateWorldEvent;
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
     * @param experience The experience
     * @param originalExperience The original experience
     * @return A new change experience event
     */
    public static ChangeExperienceEvent createChangeExperienceEvent(int experience, int originalExperience) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("experience", experience);
        values.put("originalExperience", originalExperience);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @return A new interact event
     */
    public static InteractEvent createInteractEvent(Cause cause, Game game, Optional<Vector3d> interactionPoint) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        return SpongeEventFactoryUtils.createEventImpl(InteractEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.MessageEvent}.
     * 
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @return A new message event
     */
    public static MessageEvent createMessageEvent(Game game, Text message, Text originalMessage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
        return SpongeEventFactoryUtils.createEventImpl(MessageEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.AttackBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new attack block event
     */
    public static AttackBlockEvent createAttackBlockEvent(Cause cause, Game game, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity attack block event
     */
    public static AttackBlockEvent.SourceEntity createAttackBlockEventSourceEntity(Cause cause, Game game, Optional<Vector3d> interactionPoint, Entity sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human attack block event
     */
    public static AttackBlockEvent.SourceHuman createAttackBlockEventSourceHuman(Cause cause, Game game, Optional<Vector3d> interactionPoint, Human sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living attack block event
     */
    public static AttackBlockEvent.SourceLiving createAttackBlockEventSourceLiving(Cause cause, Game game, Optional<Vector3d> interactionPoint, Living sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player attack block event
     */
    public static AttackBlockEvent.SourcePlayer createAttackBlockEventSourcePlayer(Cause cause, Game game, Optional<Vector3d> interactionPoint, Player sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block event
     */
    public static BlockEvent createBlockEvent(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new break block event
     */
    public static BreakBlockEvent createBreakBlockEvent(Cause cause, Game game, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block break block event
     */
    public static BreakBlockEvent.SourceBlock createBreakBlockEventSourceBlock(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source entity break block event
     */
    public static BreakBlockEvent.SourceEntity createBreakBlockEventSourceEntity(Cause cause, Game game, Entity sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source human break block event
     */
    public static BreakBlockEvent.SourceHuman createBreakBlockEventSourceHuman(Cause cause, Game game, Human sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source living break block event
     */
    public static BreakBlockEvent.SourceLiving createBreakBlockEventSourceLiving(Cause cause, Game game, Living sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.BreakBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source player break block event
     */
    public static BreakBlockEvent.SourcePlayer createBreakBlockEventSourcePlayer(Cause cause, Game game, Player sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new change block event
     */
    public static ChangeBlockEvent createChangeBlockEvent(Cause cause, Game game, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block change block event
     */
    public static ChangeBlockEvent.SourceBlock createChangeBlockEventSourceBlock(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source entity change block event
     */
    public static ChangeBlockEvent.SourceEntity createChangeBlockEventSourceEntity(Cause cause, Game game, Entity sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source human change block event
     */
    public static ChangeBlockEvent.SourceHuman createChangeBlockEventSourceHuman(Cause cause, Game game, Human sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source living change block event
     */
    public static ChangeBlockEvent.SourceLiving createChangeBlockEventSourceLiving(Cause cause, Game game, Living sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source player change block event
     */
    public static ChangeBlockEvent.SourcePlayer createChangeBlockEventSourcePlayer(Cause cause, Game game, Player sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world change block event
     */
    public static ChangeBlockEvent.SourceWorld createChangeBlockEventSourceWorld(Cause cause, Game game, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new collide block event
     */
    public static CollideBlockEvent createCollideBlockEvent(Cause cause, Game game, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity collide block event
     */
    public static CollideBlockEvent.SourceEntity createCollideBlockEventSourceEntity(Cause cause, Game game, Entity sourceEntity, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human collide block event
     */
    public static CollideBlockEvent.SourceHuman createCollideBlockEventSourceHuman(Cause cause, Game game, Human sourceEntity, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living collide block event
     */
    public static CollideBlockEvent.SourceLiving createCollideBlockEventSourceLiving(Cause cause, Game game, Living sourceEntity, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player collide block event
     */
    public static CollideBlockEvent.SourcePlayer createCollideBlockEventSourcePlayer(Cause cause, Game game, Player sourceEntity, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new decay block event
     */
    public static DecayBlockEvent createDecayBlockEvent(Cause cause, Game game, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(DecayBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.DecayBlockEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world decay block event
     */
    public static DecayBlockEvent.SourceWorld createDecayBlockEventSourceWorld(Cause cause, Game game, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(DecayBlockEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.GrowBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new grow block event
     */
    public static GrowBlockEvent createGrowBlockEvent(Cause cause, Game game, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(GrowBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.GrowBlockEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new source world grow block event
     */
    public static GrowBlockEvent.SourceWorld createGrowBlockEventSourceWorld(Cause cause, Game game, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(GrowBlockEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent}.
     * 
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new harvest block event
     */
    public static HarvestBlockEvent createHarvestBlockEvent(float dropChance, int experience, Game game, Collection<ItemStack> itemStacks, float originalDropChance, int originalExperience, Collection<ItemStack> originalItemStacks, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(HarvestBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source block harvest block event
     */
    public static HarvestBlockEvent.SourceBlock createHarvestBlockEventSourceBlock(Cause cause, float dropChance, int experience, Game game, Collection<ItemStack> itemStacks, float originalDropChance, int originalExperience, Collection<ItemStack> originalItemStacks, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
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
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source entity harvest block event
     */
    public static HarvestBlockEvent.SourceEntity createHarvestBlockEventSourceEntity(Cause cause, float dropChance, int experience, Game game, Collection<ItemStack> itemStacks, float originalDropChance, int originalExperience, Collection<ItemStack> originalItemStacks, Entity sourceEntity, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
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
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source human harvest block event
     */
    public static HarvestBlockEvent.SourceHuman createHarvestBlockEventSourceHuman(Cause cause, float dropChance, int experience, Game game, Collection<ItemStack> itemStacks, float originalDropChance, int originalExperience, Collection<ItemStack> originalItemStacks, Human sourceEntity, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
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
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source living harvest block event
     */
    public static HarvestBlockEvent.SourceLiving createHarvestBlockEventSourceLiving(Cause cause, float dropChance, int experience, Game game, Collection<ItemStack> itemStacks, float originalDropChance, int originalExperience, Collection<ItemStack> originalItemStacks, Living sourceEntity, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
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
     * @param cause The cause
     * @param dropChance The drop chance
     * @param experience The experience
     * @param game The game
     * @param itemStacks The item stacks
     * @param originalDropChance The original drop chance
     * @param originalExperience The original experience
     * @param originalItemStacks The original item stacks
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new source player harvest block event
     */
    public static HarvestBlockEvent.SourcePlayer createHarvestBlockEventSourcePlayer(Cause cause, float dropChance, int experience, Game game, Collection<ItemStack> itemStacks, float originalDropChance, int originalExperience, Collection<ItemStack> originalItemStacks, Player sourceEntity, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("dropChance", dropChance);
        values.put("experience", experience);
        values.put("game", game);
        values.put("itemStacks", itemStacks);
        values.put("originalDropChance", originalDropChance);
        values.put("originalExperience", originalExperience);
        values.put("originalItemStacks", originalItemStacks);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new interact block event
     */
    public static InteractBlockEvent createInteractBlockEvent(Cause cause, Game game, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new attack interact block event
     */
    public static InteractBlockEvent.Attack createInteractBlockEventAttack(Cause cause, Game game, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity attack interact block event
     */
    public static InteractBlockEvent.Attack.SourceEntity createInteractBlockEventAttackSourceEntity(Cause cause, Game game, Optional<Vector3d> interactionPoint, Entity sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human attack interact block event
     */
    public static InteractBlockEvent.Attack.SourceHuman createInteractBlockEventAttackSourceHuman(Cause cause, Game game, Optional<Vector3d> interactionPoint, Human sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living attack interact block event
     */
    public static InteractBlockEvent.Attack.SourceLiving createInteractBlockEventAttackSourceLiving(Cause cause, Game game, Optional<Vector3d> interactionPoint, Living sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player attack interact block event
     */
    public static InteractBlockEvent.Attack.SourcePlayer createInteractBlockEventAttackSourcePlayer(Cause cause, Game game, Optional<Vector3d> interactionPoint, Player sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source block interact block event
     */
    public static InteractBlockEvent.SourceBlock createInteractBlockEventSourceBlock(Cause cause, Game game, Optional<Vector3d> interactionPoint, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity interact block event
     */
    public static InteractBlockEvent.SourceEntity createInteractBlockEventSourceEntity(Cause cause, Game game, Optional<Vector3d> interactionPoint, Entity sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human interact block event
     */
    public static InteractBlockEvent.SourceHuman createInteractBlockEventSourceHuman(Cause cause, Game game, Optional<Vector3d> interactionPoint, Human sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living interact block event
     */
    public static InteractBlockEvent.SourceLiving createInteractBlockEventSourceLiving(Cause cause, Game game, Optional<Vector3d> interactionPoint, Living sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player interact block event
     */
    public static InteractBlockEvent.SourcePlayer createInteractBlockEventSourcePlayer(Cause cause, Game game, Optional<Vector3d> interactionPoint, Player sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new use interact block event
     */
    public static InteractBlockEvent.Use createInteractBlockEventUse(Cause cause, Game game, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source block use interact block event
     */
    public static InteractBlockEvent.Use.SourceBlock createInteractBlockEventUseSourceBlock(Cause cause, Game game, Optional<Vector3d> interactionPoint, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source entity use interact block event
     */
    public static InteractBlockEvent.Use.SourceEntity createInteractBlockEventUseSourceEntity(Cause cause, Game game, Optional<Vector3d> interactionPoint, Entity sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source human use interact block event
     */
    public static InteractBlockEvent.Use.SourceHuman createInteractBlockEventUseSourceHuman(Cause cause, Game game, Optional<Vector3d> interactionPoint, Human sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source living use interact block event
     */
    public static InteractBlockEvent.Use.SourceLiving createInteractBlockEventUseSourceLiving(Cause cause, Game game, Optional<Vector3d> interactionPoint, Living sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new source player use interact block event
     */
    public static InteractBlockEvent.Use.SourcePlayer createInteractBlockEventUseSourcePlayer(Cause cause, Game game, Optional<Vector3d> interactionPoint, Player sourceEntity, BlockSnapshot targetBlock, Location<World> targetLocation, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new move block event
     */
    public static MoveBlockEvent createMoveBlockEvent(Cause cause, Game game, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(MoveBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.MoveBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block move block event
     */
    public static MoveBlockEvent.SourceBlock createMoveBlockEventSourceBlock(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new notify neighbor block event
     */
    public static NotifyNeighborBlockEvent createNotifyNeighborBlockEvent(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new burn notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Burn createNotifyNeighborBlockEventBurn(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Burn.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Burn.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block burn notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Burn.SourceBlock createNotifyNeighborBlockEventBurnSourceBlock(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new ignite notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Ignite createNotifyNeighborBlockEventIgnite(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Ignite.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Ignite.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block ignite notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Ignite.SourceBlock createNotifyNeighborBlockEventIgniteSourceBlock(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @return A new power notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Power createNotifyNeighborBlockEventPower(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Power.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Power.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block power notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Power.SourceBlock createNotifyNeighborBlockEventPowerSourceBlock(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.SourceBlock createNotifyNeighborBlockEventSourceBlock(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param spreadingBlock The spreading block
     * @return A new spread notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Spread createNotifyNeighborBlockEventSpread(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockState spreadingBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param spreadingBlock The spreading block
     * @param transactions The transactions
     * @return A new source block spread notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Spread.SourceBlock createNotifyNeighborBlockEventSpreadSourceBlock(Cause cause, Game game, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BlockState spreadingBlock, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param transactions The transactions
     * @return A new place block event
     */
    public static PlaceBlockEvent createPlaceBlockEvent(Cause cause, Game game, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param transactions The transactions
     * @return A new source block place block event
     */
    public static PlaceBlockEvent.SourceBlock createPlaceBlockEventSourceBlock(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source entity place block event
     */
    public static PlaceBlockEvent.SourceEntity createPlaceBlockEventSourceEntity(Cause cause, Game game, Entity sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source human place block event
     */
    public static PlaceBlockEvent.SourceHuman createPlaceBlockEventSourceHuman(Cause cause, Game game, Human sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source living place block event
     */
    public static PlaceBlockEvent.SourceLiving createPlaceBlockEventSourceLiving(Cause cause, Game game, Living sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param transactions The transactions
     * @return A new source player place block event
     */
    public static PlaceBlockEvent.SourcePlayer createPlaceBlockEventSourcePlayer(Cause cause, Game game, Player sourceEntity, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.TickBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @return A new tick block event
     */
    public static TickBlockEvent createTickBlockEvent(Cause cause, Game game, BlockState targetBlock, Location<World> targetLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetBlock", targetBlock);
        values.put("targetLocation", targetLocation);
        return SpongeEventFactoryUtils.createEventImpl(TickBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingStandBrewItemsEvent}.
     * 
     * @param brewedItems The brewed items
     * @param cause The cause
     * @param fuelSource The fuel source
     * @param game The game
     * @param inventory The inventory
     * @param results The results
     * @param sourceBlock The source block
     * @param sourceItems The source items
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new brewing stand brew items event
     */
    public static BrewingStandBrewItemsEvent createBrewingStandBrewItemsEvent(List<ItemStack> brewedItems, Cause cause, ItemStack fuelSource, Game game, Inventory inventory, List<ItemStack> results, BlockSnapshot sourceBlock, List<ItemStack> sourceItems, Location<World> sourceLocation, Optional<Direction> sourceSide, BrewingStand tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("brewedItems", brewedItems);
        values.put("cause", cause);
        values.put("fuelSource", fuelSource);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new brewing stand event
     */
    public static BrewingStandEvent createBrewingStandEvent(Cause cause, Game game, Inventory inventory, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, BrewingStand tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param targetTile The target tile
     * @param text The text
     * @return A new change sign event
     */
    public static ChangeSignEvent createChangeSignEvent(Game game, ImmutableSignData originalText, Sign targetTile, SignData text) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceCommandSource}.
     * 
     * @param game The game
     * @param originalText The original text
     * @param source The source
     * @param targetTile The target tile
     * @param text The text
     * @return A new source command source change sign event
     */
    public static ChangeSignEvent.SourceCommandSource createChangeSignEventSourceCommandSource(Game game, ImmutableSignData originalText, CommandSource source, Sign targetTile, SignData text) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("source", source);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourceCommandSource.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalText The original text
     * @param sourceEntity The source entity
     * @param targetTile The target tile
     * @param text The text
     * @return A new source entity change sign event
     */
    public static ChangeSignEvent.SourceEntity createChangeSignEventSourceEntity(Cause cause, Game game, ImmutableSignData originalText, Entity sourceEntity, Sign targetTile, SignData text) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("sourceEntity", sourceEntity);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalText The original text
     * @param sourceEntity The source entity
     * @param targetTile The target tile
     * @param text The text
     * @return A new source human change sign event
     */
    public static ChangeSignEvent.SourceHuman createChangeSignEventSourceHuman(Cause cause, Game game, ImmutableSignData originalText, Human sourceEntity, Sign targetTile, SignData text) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("sourceEntity", sourceEntity);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalText The original text
     * @param sourceEntity The source entity
     * @param targetTile The target tile
     * @param text The text
     * @return A new source living change sign event
     */
    public static ChangeSignEvent.SourceLiving createChangeSignEventSourceLiving(Cause cause, Game game, ImmutableSignData originalText, Living sourceEntity, Sign targetTile, SignData text) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("sourceEntity", sourceEntity);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param originalText The original text
     * @param sourceEntity The source entity
     * @param targetTile The target tile
     * @param text The text
     * @return A new source player change sign event
     */
    public static ChangeSignEvent.SourcePlayer createChangeSignEventSourcePlayer(Cause cause, Game game, ImmutableSignData originalText, Player sourceEntity, Sign targetTile, SignData text) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("originalText", originalText);
        values.put("sourceEntity", sourceEntity);
        values.put("targetTile", targetTile);
        values.put("text", text);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.CommandBlockEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new command block event
     */
    public static CommandBlockEvent createCommandBlockEvent(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, CommandBlock tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param burnedItem The burned item
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param remainingFuel The remaining fuel
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace consume fuel event
     */
    public static FurnaceConsumeFuelEvent createFurnaceConsumeFuelEvent(ItemStack burnedItem, Cause cause, Game game, Inventory inventory, Optional<ItemStack> remainingFuel, Optional<ItemStack> result, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, Furnace tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("burnedItem", burnedItem);
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace event
     */
    public static FurnaceEvent createFurnaceEvent(Cause cause, Game game, Inventory inventory, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, Furnace tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param cookedItem The cooked item
     * @param game The game
     * @param inventory The inventory
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceItem The source item
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new furnace smelt item event
     */
    public static FurnaceSmeltItemEvent createFurnaceSmeltItemEvent(Cause cause, ItemStack cookedItem, Game game, Inventory inventory, Optional<ItemStack> result, BlockSnapshot sourceBlock, ItemStack sourceItem, Location<World> sourceLocation, Optional<Direction> sourceSide, Furnace tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("cookedItem", cookedItem);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new tile entity event
     */
    public static TileEntityEvent createTileEntityEvent(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, TileEntity tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param sink The sink
     * @return A new message sink event
     */
    public static MessageSinkEvent createMessageSinkEvent(Game game, Text message, Text originalMessage, MessageSink originalSink, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.SourceCommandBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param sink The sink
     * @param source The source
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param tile The tile
     * @return A new source command block message sink event
     */
    public static MessageSinkEvent.SourceCommandBlock createMessageSinkEventSourceCommandBlock(Cause cause, Game game, Text message, Text originalMessage, MessageSink originalSink, MessageSink sink, CommandBlock source, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, CommandBlock tile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
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
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param sink The sink
     * @param source The source
     * @return A new source command source message sink event
     */
    public static MessageSinkEvent.SourceCommandSource createMessageSinkEventSourceCommandSource(Game game, Text message, Text originalMessage, MessageSink originalSink, MessageSink sink, CommandSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
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
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param server The server
     * @param sink The sink
     * @param source The source
     * @return A new source console message sink event
     */
    public static MessageSinkEvent.SourceConsole createMessageSinkEventSourceConsole(Game game, Text message, Text originalMessage, MessageSink originalSink, Server server, MessageSink sink, CommandSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
        values.put("originalSink", originalSink);
        values.put("server", server);
        values.put("sink", sink);
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.SourceConsole.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param originalUnformattedMessage The original unformatted message
     * @param sink The sink
     * @param source The source
     * @param sourceEntity The source entity
     * @param unformattedMessage The unformatted message
     * @return A new source player message sink event
     */
    public static MessageSinkEvent.SourcePlayer createMessageSinkEventSourcePlayer(Cause cause, Game game, Text message, Text originalMessage, MessageSink originalSink, Text originalUnformattedMessage, MessageSink sink, Player source, Player sourceEntity, Text unformattedMessage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
        values.put("originalSink", originalSink);
        values.put("originalUnformattedMessage", originalUnformattedMessage);
        values.put("sink", sink);
        values.put("source", source);
        values.put("sourceEntity", sourceEntity);
        values.put("unformattedMessage", unformattedMessage);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.SourcePlugin}.
     * 
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param plugin The plugin
     * @param sink The sink
     * @return A new source plugin message sink event
     */
    public static MessageSinkEvent.SourcePlugin createMessageSinkEventSourcePlugin(Game game, Text message, Text originalMessage, MessageSink originalSink, PluginContainer plugin, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
        values.put("originalSink", originalSink);
        values.put("plugin", plugin);
        values.put("sink", sink);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.SourcePlugin.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.SendCommandEvent}.
     * 
     * @param arguments The arguments
     * @param command The command
     * @param game The game
     * @param result The result
     * @param source The source
     * @return A new send command event
     */
    public static SendCommandEvent createSendCommandEvent(String arguments, String command, Game game, CommandResult result, CommandSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("arguments", arguments);
        values.put("command", command);
        values.put("game", game);
        values.put("result", result);
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(SendCommandEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.TabCompleteCommandEvent}.
     * 
     * @param arguments The arguments
     * @param command The command
     * @param game The game
     * @param source The source
     * @param tabCompletions The tab completions
     * @return A new tab complete command event
     */
    public static TabCompleteCommandEvent createTabCompleteCommandEvent(String arguments, String command, Game game, CommandSource source, List<String> tabCompletions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("arguments", arguments);
        values.put("command", command);
        values.put("game", game);
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
     * @param endResult The end result
     * @param game The game
     * @param originalChanges The original changes
     * @param targetHolder The target holder
     * @return A new value change change data holder event
     */
    public static ChangeDataHolderEvent.ValueChange createChangeDataHolderEventValueChange(DataTransactionResult endResult, Game game, DataTransactionResult originalChanges, DataHolder targetHolder) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("endResult", endResult);
        values.put("game", game);
        values.put("originalChanges", originalChanges);
        values.put("targetHolder", targetHolder);
        return SpongeEventFactoryUtils.createEventImpl(ChangeDataHolderEvent.ValueChange.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AffectEntityEvent}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @return A new affect entity event
     */
    public static AffectEntityEvent createAffectEntityEvent(Cause cause, List<? extends Entity> entities, List<EntitySnapshot> entitySnapshots, Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(AffectEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new breed entity event
     */
    public static BreedEntityEvent createBreedEntityEvent(Cause cause, Game game, Optional<Vector3d> interactionPoint, Ageable targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(BreedEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent.Breed}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param offspringEntity The offspring entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new breed breed entity event
     */
    public static BreedEntityEvent.Breed createBreedEntityEventBreed(Cause cause, Game game, Optional<Vector3d> interactionPoint, Ageable offspringEntity, Ageable sourceEntity, Ageable targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param hasAllowResult The has allow result
     * @param interactionPoint The interaction point
     * @param originalResult The original result
     * @param result The result
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new find mate breed entity event
     */
    public static BreedEntityEvent.FindMate createBreedEntityEventFindMate(Cause cause, Game game, boolean hasAllowResult, Optional<Vector3d> interactionPoint, TristateResult.Result originalResult, TristateResult.Result result, Ageable sourceEntity, Ageable targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("hasAllowResult", hasAllowResult);
        values.put("interactionPoint", interactionPoint);
        values.put("originalResult", originalResult);
        values.put("result", result);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(BreedEntityEvent.FindMate.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param itemStack The item stack
     * @param originalItemStack The original item stack
     * @param targetEntity The target entity
     * @return A new change entity equipment event
     */
    public static ChangeEntityEquipmentEvent createChangeEntityEquipmentEvent(Game game, Slot inventory, Optional<ItemStackTransaction> itemStack, Optional<ItemStackSnapshot> originalItemStack, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("itemStack", itemStack);
        values.put("originalItemStack", originalItemStack);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHuman}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param itemStack The item stack
     * @param originalItemStack The original item stack
     * @param targetEntity The target entity
     * @return A new target human change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetHuman createChangeEntityEquipmentEventTargetHuman(Game game, Slot inventory, Optional<ItemStackTransaction> itemStack, Optional<ItemStackSnapshot> originalItemStack, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("itemStack", itemStack);
        values.put("originalItemStack", originalItemStack);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param itemStack The item stack
     * @param originalItemStack The original item stack
     * @param targetEntity The target entity
     * @return A new target living change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetLiving createChangeEntityEquipmentEventTargetLiving(Game game, Slot inventory, Optional<ItemStackTransaction> itemStack, Optional<ItemStackSnapshot> originalItemStack, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("itemStack", itemStack);
        values.put("originalItemStack", originalItemStack);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param inventory The inventory
     * @param itemStack The item stack
     * @param originalItemStack The original item stack
     * @param targetEntity The target entity
     * @return A new target player change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetPlayer createChangeEntityEquipmentEventTargetPlayer(Game game, Slot inventory, Optional<ItemStackTransaction> itemStack, Optional<ItemStackSnapshot> originalItemStack, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("inventory", inventory);
        values.put("itemStack", itemStack);
        values.put("originalItemStack", originalItemStack);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param game The game
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent createChangeEntityPotionEffectEvent(Cause cause, List<PotionEffect> currentEffects, Game game, PotionEffect potionEffect, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("game", game);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityPotionEffectEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param game The game
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new expire change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Expire createChangeEntityPotionEffectEventExpire(Cause cause, List<PotionEffect> currentEffects, Game game, PotionEffect potionEffect, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("game", game);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityPotionEffectEvent.Expire.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param game The game
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new gain change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Gain createChangeEntityPotionEffectEventGain(Cause cause, List<PotionEffect> currentEffects, Game game, PotionEffect potionEffect, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("game", game);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityPotionEffectEvent.Gain.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param game The game
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new remove change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Remove createChangeEntityPotionEffectEventRemove(Cause cause, List<PotionEffect> currentEffects, Game game, PotionEffect potionEffect, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentEffects", currentEffects);
        values.put("game", game);
        values.put("potionEffect", potionEffect);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityPotionEffectEvent.Remove.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @return A new collide entity event
     */
    public static CollideEntityEvent createCollideEntityEvent(Cause cause, Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity collide entity event
     */
    public static CollideEntityEvent.SourceEntity createCollideEntityEventSourceEntity(Cause cause, Game game, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human collide entity event
     */
    public static CollideEntityEvent.SourceHuman createCollideEntityEventSourceHuman(Cause cause, Game game, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living collide entity event
     */
    public static CollideEntityEvent.SourceLiving createCollideEntityEventSourceLiving(Cause cause, Game game, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player collide entity event
     */
    public static CollideEntityEvent.SourcePlayer createCollideEntityEventSourcePlayer(Cause cause, Game game, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ConstructEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param location The location
     * @param targetType The target type
     * @return A new construct entity event
     */
    public static ConstructEntityEvent createConstructEntityEvent(Cause cause, Game game, Location<World> location, EntityType targetType) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("location", location);
        values.put("targetType", targetType);
        return SpongeEventFactoryUtils.createEventImpl(ConstructEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ConstructEntityEvent.Post}.
     * 
     * @param cause The cause
     * @param game The game
     * @param location The location
     * @param targetEntity The target entity
     * @param targetType The target type
     * @return A new post construct entity event
     */
    public static ConstructEntityEvent.Post createConstructEntityEventPost(Cause cause, Game game, Location<World> location, Entity targetEntity, EntityType targetType) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("location", location);
        values.put("targetEntity", targetEntity);
        values.put("targetType", targetType);
        return SpongeEventFactoryUtils.createEventImpl(ConstructEntityEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ConstructEntityEvent.Pre}.
     * 
     * @param cause The cause
     * @param game The game
     * @param location The location
     * @param targetType The target type
     * @return A new pre construct entity event
     */
    public static ConstructEntityEvent.Pre createConstructEntityEventPre(Cause cause, Game game, Location<World> location, EntityType targetType) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("location", location);
        values.put("targetType", targetType);
        return SpongeEventFactoryUtils.createEventImpl(ConstructEntityEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @return A new damage entity event
     */
    public static DamageEntityEvent createDamageEntityEvent(double baseDamage, Cause cause, double finalDamage, Game game, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, double originalDamage, Map<DamageModifier, Double> originalDamages, double originalFinalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceEntity}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity damage entity event
     */
    public static DamageEntityEvent.SourceEntity createDamageEntityEventSourceEntity(double baseDamage, Cause cause, double finalDamage, Game game, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, double originalDamage, Map<DamageModifier, Double> originalDamages, double originalFinalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceHuman}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human damage entity event
     */
    public static DamageEntityEvent.SourceHuman createDamageEntityEventSourceHuman(double baseDamage, Cause cause, double finalDamage, Game game, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, double originalDamage, Map<DamageModifier, Double> originalDamages, double originalFinalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourceLiving}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living damage entity event
     */
    public static DamageEntityEvent.SourceLiving createDamageEntityEventSourceLiving(double baseDamage, Cause cause, double finalDamage, Game game, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, double originalDamage, Map<DamageModifier, Double> originalDamages, double originalFinalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent.SourcePlayer}.
     * 
     * @param baseDamage The base damage
     * @param cause The cause
     * @param finalDamage The final damage
     * @param game The game
     * @param modifiers The modifiers
     * @param originalDamage The original damage
     * @param originalDamages The original damages
     * @param originalFinalDamage The original final damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player damage entity event
     */
    public static DamageEntityEvent.SourcePlayer createDamageEntityEventSourcePlayer(double baseDamage, Cause cause, double finalDamage, Game game, List<Tuple<DamageModifier, Function<? super Double, Double>>> modifiers, double originalDamage, Map<DamageModifier, Double> originalDamages, double originalFinalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("baseDamage", baseDamage);
        values.put("cause", cause);
        values.put("finalDamage", finalDamage);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalDamage", originalDamage);
        values.put("originalDamages", originalDamages);
        values.put("originalFinalDamage", originalFinalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DestructEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param sink The sink
     * @param source The source
     * @param targetEntity The target entity
     * @return A new destruct entity event
     */
    public static DestructEntityEvent createDestructEntityEvent(Cause cause, Game game, Text message, Text originalMessage, MessageSink originalSink, MessageSink sink, CommandSource source, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
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
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @return A new dismount entity event
     */
    public static DismountEntityEvent createDismountEntityEvent(Cause cause, Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity dismount entity event
     */
    public static DismountEntityEvent.SourceEntity createDismountEntityEventSourceEntity(Cause cause, Game game, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human dismount entity event
     */
    public static DismountEntityEvent.SourceHuman createDismountEntityEventSourceHuman(Cause cause, Game game, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living dismount entity event
     */
    public static DismountEntityEvent.SourceLiving createDismountEntityEventSourceLiving(Cause cause, Game game, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DismountEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player dismount entity event
     */
    public static DismountEntityEvent.SourcePlayer createDismountEntityEventSourcePlayer(Cause cause, Game game, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DismountEntityEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent}.
     * 
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new displace entity event
     */
    public static DisplaceEntityEvent createDisplaceEntityEvent(Transform<World> fromTransform, Game game, Entity targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move}.
     * 
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new move displace entity event
     */
    public static DisplaceEntityEvent.Move createDisplaceEntityEventMove(Transform<World> fromTransform, Game game, Entity targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Move.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetHuman}.
     * 
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new target human move displace entity event
     */
    public static DisplaceEntityEvent.Move.TargetHuman createDisplaceEntityEventMoveTargetHuman(Transform<World> fromTransform, Game game, Human targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Move.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetLiving}.
     * 
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new target living move displace entity event
     */
    public static DisplaceEntityEvent.Move.TargetLiving createDisplaceEntityEventMoveTargetLiving(Transform<World> fromTransform, Game game, Living targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Move.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Move.TargetPlayer}.
     * 
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new target player move displace entity event
     */
    public static DisplaceEntityEvent.Move.TargetPlayer createDisplaceEntityEventMoveTargetPlayer(Transform<World> fromTransform, Game game, Player targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Move.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetHuman}.
     * 
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new target human displace entity event
     */
    public static DisplaceEntityEvent.TargetHuman createDisplaceEntityEventTargetHuman(Transform<World> fromTransform, Game game, Human targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetLiving}.
     * 
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new target living displace entity event
     */
    public static DisplaceEntityEvent.TargetLiving createDisplaceEntityEventTargetLiving(Transform<World> fromTransform, Game game, Living targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.TargetPlayer}.
     * 
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new target player displace entity event
     */
    public static DisplaceEntityEvent.TargetPlayer createDisplaceEntityEventTargetPlayer(Transform<World> fromTransform, Game game, Player targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param game The game
     * @param keepsVelocity The keeps velocity
     * @param targetEntity The target entity
     * @param teleporterAgent The teleporter agent
     * @param toTransform The to transform
     * @return A new teleport displace entity event
     */
    public static DisplaceEntityEvent.Teleport createDisplaceEntityEventTeleport(Cause cause, Transform<World> fromTransform, Game game, boolean keepsVelocity, Entity targetEntity, TeleporterAgent teleporterAgent, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("keepsVelocity", keepsVelocity);
        values.put("targetEntity", targetEntity);
        values.put("teleporterAgent", teleporterAgent);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Teleport.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetHuman}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param game The game
     * @param keepsVelocity The keeps velocity
     * @param targetEntity The target entity
     * @param teleporterAgent The teleporter agent
     * @param toTransform The to transform
     * @return A new target human teleport displace entity event
     */
    public static DisplaceEntityEvent.Teleport.TargetHuman createDisplaceEntityEventTeleportTargetHuman(Cause cause, Transform<World> fromTransform, Game game, boolean keepsVelocity, Human targetEntity, TeleporterAgent teleporterAgent, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("keepsVelocity", keepsVelocity);
        values.put("targetEntity", targetEntity);
        values.put("teleporterAgent", teleporterAgent);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Teleport.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetLiving}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param game The game
     * @param keepsVelocity The keeps velocity
     * @param targetEntity The target entity
     * @param teleporterAgent The teleporter agent
     * @param toTransform The to transform
     * @return A new target living teleport displace entity event
     */
    public static DisplaceEntityEvent.Teleport.TargetLiving createDisplaceEntityEventTeleportTargetLiving(Cause cause, Transform<World> fromTransform, Game game, boolean keepsVelocity, Living targetEntity, TeleporterAgent teleporterAgent, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("keepsVelocity", keepsVelocity);
        values.put("targetEntity", targetEntity);
        values.put("teleporterAgent", teleporterAgent);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Teleport.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DisplaceEntityEvent.Teleport.TargetPlayer}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param game The game
     * @param keepsVelocity The keeps velocity
     * @param targetEntity The target entity
     * @param teleporterAgent The teleporter agent
     * @param toTransform The to transform
     * @return A new target player teleport displace entity event
     */
    public static DisplaceEntityEvent.Teleport.TargetPlayer createDisplaceEntityEventTeleportTargetPlayer(Cause cause, Transform<World> fromTransform, Game game, boolean keepsVelocity, Player targetEntity, TeleporterAgent teleporterAgent, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("keepsVelocity", keepsVelocity);
        values.put("targetEntity", targetEntity);
        values.put("teleporterAgent", teleporterAgent);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(DisplaceEntityEvent.Teleport.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new entity event
     */
    public static EntityEvent createEntityEvent(Cause cause, Game game, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(EntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new entity portal event
     */
    public static EntityPortalEvent createEntityPortalEvent(Cause cause, Game game, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(EntityPortalEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent.Enter}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new enter entity portal event
     */
    public static EntityPortalEvent.Enter createEntityPortalEventEnter(Cause cause, Game game, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(EntityPortalEvent.Enter.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.EntityPortalEvent.Exit}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new exit entity portal event
     */
    public static EntityPortalEvent.Exit createEntityPortalEventExit(Cause cause, Game game, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(EntityPortalEvent.Exit.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ExpireEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @return A new expire entity event
     */
    public static ExpireEntityEvent createExpireEntityEvent(Cause cause, Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ExpireEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ExpireEntityEvent.TargetItem}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target item expire entity event
     */
    public static ExpireEntityEvent.TargetItem createExpireEntityEventTargetItem(Cause cause, Game game, Item targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ExpireEntityEvent.TargetItem.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent}.
     * 
     * @param fishHook The fish hook
     * @param game The game
     * @param originalFishHook The original fish hook
     * @return A new fishing event
     */
    public static FishingEvent createFishingEvent(FishHook fishHook, Game game, EntitySnapshot originalFishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast}.
     * 
     * @param fishHook The fish hook
     * @param game The game
     * @param originalFishHook The original fish hook
     * @return A new cast fishing event
     */
    public static FishingEvent.Cast createFishingEventCast(FishHook fishHook, Game game, EntitySnapshot originalFishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceEntity}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param originalFishHook The original fish hook
     * @param sourceEntity The source entity
     * @return A new source entity cast fishing event
     */
    public static FishingEvent.Cast.SourceEntity createFishingEventCastSourceEntity(Cause cause, FishHook fishHook, Game game, EntitySnapshot originalFishHook, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceHuman}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param originalFishHook The original fish hook
     * @param sourceEntity The source entity
     * @return A new source human cast fishing event
     */
    public static FishingEvent.Cast.SourceHuman createFishingEventCastSourceHuman(Cause cause, FishHook fishHook, Game game, EntitySnapshot originalFishHook, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourceLiving}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param originalFishHook The original fish hook
     * @param sourceEntity The source entity
     * @return A new source living cast fishing event
     */
    public static FishingEvent.Cast.SourceLiving createFishingEventCastSourceLiving(Cause cause, FishHook fishHook, Game game, EntitySnapshot originalFishHook, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Cast.SourcePlayer}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param originalFishHook The original fish hook
     * @param sourceEntity The source entity
     * @return A new source player cast fishing event
     */
    public static FishingEvent.Cast.SourcePlayer createFishingEventCastSourcePlayer(Cause cause, FishHook fishHook, Game game, EntitySnapshot originalFishHook, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("originalFishHook", originalFishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Cast.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook}.
     * 
     * @param fishHook The fish hook
     * @param game The game
     * @param hookedEntity The hooked entity
     * @param originalFishHook The original fish hook
     * @param originalHookedEntity The original hooked entity
     * @param targetEntity The target entity
     * @return A new hook fishing event
     */
    public static FishingEvent.Hook createFishingEventHook(FishHook fishHook, Game game, Optional<Entity> hookedEntity, EntitySnapshot originalFishHook, EntitySnapshot originalHookedEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("hookedEntity", hookedEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceEntity}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param hookedEntity The hooked entity
     * @param originalFishHook The original fish hook
     * @param originalHookedEntity The original hooked entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity hook fishing event
     */
    public static FishingEvent.Hook.SourceEntity createFishingEventHookSourceEntity(Cause cause, FishHook fishHook, Game game, Optional<Entity> hookedEntity, EntitySnapshot originalFishHook, EntitySnapshot originalHookedEntity, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("hookedEntity", hookedEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceHuman}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param hookedEntity The hooked entity
     * @param originalFishHook The original fish hook
     * @param originalHookedEntity The original hooked entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human hook fishing event
     */
    public static FishingEvent.Hook.SourceHuman createFishingEventHookSourceHuman(Cause cause, FishHook fishHook, Game game, Optional<Entity> hookedEntity, EntitySnapshot originalFishHook, EntitySnapshot originalHookedEntity, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("hookedEntity", hookedEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourceLiving}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param hookedEntity The hooked entity
     * @param originalFishHook The original fish hook
     * @param originalHookedEntity The original hooked entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living hook fishing event
     */
    public static FishingEvent.Hook.SourceLiving createFishingEventHookSourceLiving(Cause cause, FishHook fishHook, Game game, Optional<Entity> hookedEntity, EntitySnapshot originalFishHook, EntitySnapshot originalHookedEntity, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("hookedEntity", hookedEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Hook.SourcePlayer}.
     * 
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param hookedEntity The hooked entity
     * @param originalFishHook The original fish hook
     * @param originalHookedEntity The original hooked entity
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player hook fishing event
     */
    public static FishingEvent.Hook.SourcePlayer createFishingEventHookSourcePlayer(Cause cause, FishHook fishHook, Game game, Optional<Entity> hookedEntity, EntitySnapshot originalFishHook, EntitySnapshot originalHookedEntity, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("hookedEntity", hookedEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("originalHookedEntity", originalHookedEntity);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Hook.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract}.
     * 
     * @param caughtEntity The caught entity
     * @param fishHook The fish hook
     * @param game The game
     * @param itemStackTransaction The item stack transaction
     * @param originalCaughtEntity The original caught entity
     * @param originalFishHook The original fish hook
     * @return A new retract fishing event
     */
    public static FishingEvent.Retract createFishingEventRetract(Optional<Entity> caughtEntity, FishHook fishHook, Game game, Optional<ItemStackTransaction> itemStackTransaction, Optional<EntitySnapshot> originalCaughtEntity, EntitySnapshot originalFishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("originalFishHook", originalFishHook);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceEntity}.
     * 
     * @param caughtEntity The caught entity
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param itemStackTransaction The item stack transaction
     * @param originalCaughtEntity The original caught entity
     * @param originalFishHook The original fish hook
     * @param sourceEntity The source entity
     * @return A new source entity retract fishing event
     */
    public static FishingEvent.Retract.SourceEntity createFishingEventRetractSourceEntity(Optional<Entity> caughtEntity, Cause cause, FishHook fishHook, Game game, Optional<ItemStackTransaction> itemStackTransaction, Optional<EntitySnapshot> originalCaughtEntity, EntitySnapshot originalFishHook, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceHuman}.
     * 
     * @param caughtEntity The caught entity
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param itemStackTransaction The item stack transaction
     * @param originalCaughtEntity The original caught entity
     * @param originalFishHook The original fish hook
     * @param sourceEntity The source entity
     * @return A new source human retract fishing event
     */
    public static FishingEvent.Retract.SourceHuman createFishingEventRetractSourceHuman(Optional<Entity> caughtEntity, Cause cause, FishHook fishHook, Game game, Optional<ItemStackTransaction> itemStackTransaction, Optional<EntitySnapshot> originalCaughtEntity, EntitySnapshot originalFishHook, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourceLiving}.
     * 
     * @param caughtEntity The caught entity
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param itemStackTransaction The item stack transaction
     * @param originalCaughtEntity The original caught entity
     * @param originalFishHook The original fish hook
     * @param sourceEntity The source entity
     * @return A new source living retract fishing event
     */
    public static FishingEvent.Retract.SourceLiving createFishingEventRetractSourceLiving(Optional<Entity> caughtEntity, Cause cause, FishHook fishHook, Game game, Optional<ItemStackTransaction> itemStackTransaction, Optional<EntitySnapshot> originalCaughtEntity, EntitySnapshot originalFishHook, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.FishingEvent.Retract.SourcePlayer}.
     * 
     * @param caughtEntity The caught entity
     * @param cause The cause
     * @param fishHook The fish hook
     * @param game The game
     * @param itemStackTransaction The item stack transaction
     * @param originalCaughtEntity The original caught entity
     * @param originalFishHook The original fish hook
     * @param sourceEntity The source entity
     * @return A new source player retract fishing event
     */
    public static FishingEvent.Retract.SourcePlayer createFishingEventRetractSourcePlayer(Optional<Entity> caughtEntity, Cause cause, FishHook fishHook, Game game, Optional<ItemStackTransaction> itemStackTransaction, Optional<EntitySnapshot> originalCaughtEntity, EntitySnapshot originalFishHook, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("caughtEntity", caughtEntity);
        values.put("cause", cause);
        values.put("fishHook", fishHook);
        values.put("game", game);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("originalCaughtEntity", originalCaughtEntity);
        values.put("originalFishHook", originalFishHook);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Retract.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent}.
     * 
     * @param cause The cause
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param targetEntity The target entity
     * @return A new harvest entity event
     */
    public static HarvestEntityEvent createHarvestEntityEvent(Cause cause, int experience, Game game, int originalExperience, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HarvestEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHuman}.
     * 
     * @param cause The cause
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param targetEntity The target entity
     * @return A new target human harvest entity event
     */
    public static HarvestEntityEvent.TargetHuman createHarvestEntityEventTargetHuman(Cause cause, int experience, Game game, int originalExperience, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HarvestEntityEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving}.
     * 
     * @param cause The cause
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param targetEntity The target entity
     * @return A new target living harvest entity event
     */
    public static HarvestEntityEvent.TargetLiving createHarvestEntityEventTargetLiving(Cause cause, int experience, Game game, int originalExperience, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HarvestEntityEvent.TargetLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param experience The experience
     * @param game The game
     * @param keepsInventory The keeps inventory
     * @param keepsLevel The keeps level
     * @param level The level
     * @param originalExperience The original experience
     * @param targetEntity The target entity
     * @return A new target player harvest entity event
     */
    public static HarvestEntityEvent.TargetPlayer createHarvestEntityEventTargetPlayer(Cause cause, int experience, Game game, boolean keepsInventory, boolean keepsLevel, int level, int originalExperience, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("experience", experience);
        values.put("game", game);
        values.put("keepsInventory", keepsInventory);
        values.put("keepsLevel", keepsLevel);
        values.put("level", level);
        values.put("originalExperience", originalExperience);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HarvestEntityEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HealEntityEvent}.
     * 
     * @param baseHealAmount The base heal amount
     * @param cause The cause
     * @param finalHealAmount The final heal amount
     * @param game The game
     * @param modifiers The modifiers
     * @param originalFunctions The original functions
     * @param originalHealAmount The original heal amount
     * @param originalHealingAmounts The original healing amounts
     * @param targetEntity The target entity
     * @return A new heal entity event
     */
    public static HealEntityEvent createHealEntityEvent(double baseHealAmount, Cause cause, double finalHealAmount, Game game, List<Tuple<HealthModifier, Function<? super Double, Double>>> modifiers, List<Tuple<HealthModifier, Function<? super Double, Double>>> originalFunctions, double originalHealAmount, Map<HealthModifier, Double> originalHealingAmounts, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("baseHealAmount", baseHealAmount);
        values.put("cause", cause);
        values.put("finalHealAmount", finalHealAmount);
        values.put("game", game);
        values.put("modifiers", modifiers);
        values.put("originalFunctions", originalFunctions);
        values.put("originalHealAmount", originalHealAmount);
        values.put("originalHealingAmounts", originalHealingAmounts);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HealEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.IgniteEntityEvent}.
     * 
     * @param fireTicks The fire ticks
     * @param game The game
     * @param targetEntity The target entity
     * @return A new ignite entity event
     */
    public static IgniteEntityEvent createIgniteEntityEvent(int fireTicks, Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("fireTicks", fireTicks);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(IgniteEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new interact entity event
     */
    public static InteractEntityEvent createInteractEntityEvent(Cause cause, Game game, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @return A new attack interact entity event
     */
    public static InteractEntityEvent.Attack createInteractEntityEventAttack(Cause cause, Game game, Optional<Vector3d> interactionPoint, double originalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourceEntity createInteractEntityEventAttackSourceEntity(Cause cause, Game game, Optional<Vector3d> interactionPoint, double originalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourceHuman createInteractEntityEventAttackSourceHuman(Cause cause, Game game, Optional<Vector3d> interactionPoint, double originalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLightning}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source lightning attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourceLightning createInteractEntityEventAttackSourceLightning(Cause cause, Game game, Optional<Vector3d> interactionPoint, double originalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Lightning sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourceLightning.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourceLiving createInteractEntityEventAttackSourceLiving(Cause cause, Game game, Optional<Vector3d> interactionPoint, double originalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Attack.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param originalDamage The original damage
     * @param originalFunctions The original functions
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player attack interact entity event
     */
    public static InteractEntityEvent.Attack.SourcePlayer createInteractEntityEventAttackSourcePlayer(Cause cause, Game game, Optional<Vector3d> interactionPoint, double originalDamage, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("originalDamage", originalDamage);
        values.put("originalFunctions", originalFunctions);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Attack.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetEntity The target entity
     * @return A new source block interact entity event
     */
    public static InteractEntityEvent.SourceBlock createInteractEntityEventSourceBlock(Cause cause, Game game, Optional<Vector3d> interactionPoint, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity interact entity event
     */
    public static InteractEntityEvent.SourceEntity createInteractEntityEventSourceEntity(Cause cause, Game game, Optional<Vector3d> interactionPoint, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human interact entity event
     */
    public static InteractEntityEvent.SourceHuman createInteractEntityEventSourceHuman(Cause cause, Game game, Optional<Vector3d> interactionPoint, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living interact entity event
     */
    public static InteractEntityEvent.SourceLiving createInteractEntityEventSourceLiving(Cause cause, Game game, Optional<Vector3d> interactionPoint, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player interact entity event
     */
    public static InteractEntityEvent.SourcePlayer createInteractEntityEventSourcePlayer(Cause cause, Game game, Optional<Vector3d> interactionPoint, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new use interact entity event
     */
    public static InteractEntityEvent.Use createInteractEntityEventUse(Cause cause, Game game, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Use.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Use.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity use interact entity event
     */
    public static InteractEntityEvent.Use.SourceEntity createInteractEntityEventUseSourceEntity(Cause cause, Game game, Optional<Vector3d> interactionPoint, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human use interact entity event
     */
    public static InteractEntityEvent.Use.SourceHuman createInteractEntityEventUseSourceHuman(Cause cause, Game game, Optional<Vector3d> interactionPoint, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living use interact entity event
     */
    public static InteractEntityEvent.Use.SourceLiving createInteractEntityEventUseSourceLiving(Cause cause, Game game, Optional<Vector3d> interactionPoint, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param interactionPoint The interaction point
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player use interact entity event
     */
    public static InteractEntityEvent.Use.SourcePlayer createInteractEntityEventUseSourcePlayer(Cause cause, Game game, Optional<Vector3d> interactionPoint, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity leash entity event
     */
    public static LeashEntityEvent.SourceEntity createLeashEntityEventSourceEntity(Cause cause, Game game, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human leash entity event
     */
    public static LeashEntityEvent.SourceHuman createLeashEntityEventSourceHuman(Cause cause, Game game, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living leash entity event
     */
    public static LeashEntityEvent.SourceLiving createLeashEntityEventSourceLiving(Cause cause, Game game, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player leash entity event
     */
    public static LeashEntityEvent.SourcePlayer createLeashEntityEventSourcePlayer(Cause cause, Game game, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new source entity mount entity event
     */
    public static MountEntityEvent.SourceEntity createMountEntityEventSourceEntity(Cause cause, Game game, Entity sourceEntity, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new source human mount entity event
     */
    public static MountEntityEvent.SourceHuman createMountEntityEventSourceHuman(Cause cause, Game game, Human sourceEntity, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new source living mount entity event
     */
    public static MountEntityEvent.SourceLiving createMountEntityEventSourceLiving(Cause cause, Game game, Living sourceEntity, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @param vehicle The vehicle
     * @return A new source player mount entity event
     */
    public static MountEntityEvent.SourcePlayer createMountEntityEventSourcePlayer(Cause cause, Game game, Player sourceEntity, Entity targetEntity, Entity vehicle) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @return A new spawn entity event
     */
    public static SpawnEntityEvent createSpawnEntityEvent(Cause cause, Game game, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @param targetEntity The target entity
     * @return A new source block spawn entity event
     */
    public static SpawnEntityEvent.SourceBlock createSpawnEntityEventSourceBlock(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceBlock", sourceBlock);
        values.put("sourceLocation", sourceLocation);
        values.put("sourceSide", sourceSide);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.SourceBlock.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetEntity The target entity
     * @return A new source world spawn entity event
     */
    public static SpawnEntityEvent.SourceWorld createSpawnEntityEventSourceWorld(Cause cause, Game game, World sourceWorld, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.TargetLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target living spawn entity event
     */
    public static SpawnEntityEvent.TargetLiving createSpawnEntityEventTargetLiving(Cause cause, Game game, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.TargetLiving.class, values);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity tame entity event
     */
    public static TameEntityEvent.SourceEntity createTameEntityEventSourceEntity(Cause cause, Game game, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human tame entity event
     */
    public static TameEntityEvent.SourceHuman createTameEntityEventSourceHuman(Cause cause, Game game, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living tame entity event
     */
    public static TameEntityEvent.SourceLiving createTameEntityEventSourceLiving(Cause cause, Game game, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player tame entity event
     */
    public static TameEntityEvent.SourcePlayer createTameEntityEventSourcePlayer(Cause cause, Game game, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity unleash entity event
     */
    public static UnleashEntityEvent.SourceEntity createUnleashEntityEventSourceEntity(Cause cause, Game game, Entity sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human unleash entity event
     */
    public static UnleashEntityEvent.SourceHuman createUnleashEntityEventSourceHuman(Cause cause, Game game, Human sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living unleash entity event
     */
    public static UnleashEntityEvent.SourceLiving createUnleashEntityEventSourceLiving(Cause cause, Game game, Living sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player unleash entity event
     */
    public static UnleashEntityEvent.SourcePlayer createUnleashEntityEventSourcePlayer(Cause cause, Game game, Player sourceEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new living event
     */
    public static LivingEvent createLivingEvent(Cause cause, Game game, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param currentExperience The current experience
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param sourceEntity The source entity
     * @return A new change human experience event
     */
    public static ChangeHumanExperienceEvent createChangeHumanExperienceEvent(Cause cause, int currentExperience, int experience, Game game, int originalExperience, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentExperience", currentExperience);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanExperienceEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanExperienceEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param currentExperience The current experience
     * @param experience The experience
     * @param game The game
     * @param originalExperience The original experience
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new target player change human experience event
     */
    public static ChangeHumanExperienceEvent.TargetPlayer createChangeHumanExperienceEventTargetPlayer(Cause cause, int currentExperience, int experience, Game game, int originalExperience, Human sourceEntity, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("currentExperience", currentExperience);
        values.put("experience", experience);
        values.put("game", game);
        values.put("originalExperience", originalExperience);
        values.put("sourceEntity", sourceEntity);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanExperienceEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param gameMode The game mode
     * @param originalGameMode The original game mode
     * @param targetEntity The target entity
     * @return A new change human game mode event
     */
    public static ChangeHumanGameModeEvent createChangeHumanGameModeEvent(Cause cause, Game game, GameMode gameMode, GameMode originalGameMode, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("gameMode", gameMode);
        values.put("originalGameMode", originalGameMode);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanGameModeEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanGameModeEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param gameMode The game mode
     * @param originalGameMode The original game mode
     * @param targetEntity The target entity
     * @return A new target player change human game mode event
     */
    public static ChangeHumanGameModeEvent.TargetPlayer createChangeHumanGameModeEventTargetPlayer(Cause cause, Game game, GameMode gameMode, GameMode originalGameMode, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("gameMode", gameMode);
        values.put("originalGameMode", originalGameMode);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanGameModeEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent}.
     * 
     * @param game The game
     * @param level The level
     * @param originalLevel The original level
     * @param targetEntity The target entity
     * @return A new change human level event
     */
    public static ChangeHumanLevelEvent createChangeHumanLevelEvent(Game game, int level, int originalLevel, Human targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("level", level);
        values.put("originalLevel", originalLevel);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanLevelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeHumanLevelEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param level The level
     * @param originalLevel The original level
     * @param targetEntity The target entity
     * @return A new target player change human level event
     */
    public static ChangeHumanLevelEvent.TargetPlayer createChangeHumanLevelEventTargetPlayer(Game game, int level, int originalLevel, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("level", level);
        values.put("originalLevel", originalLevel);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeHumanLevelEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new human event
     */
    public static HumanEvent createHumanEvent(Cause cause, Game game, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new human sleep event
     */
    public static HumanSleepEvent createHumanSleepEvent(Location<World> bed, Cause cause, Game game, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.Enter}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new enter human sleep event
     */
    public static HumanSleepEvent.Enter createHumanSleepEventEnter(Location<World> bed, Cause cause, Game game, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.Enter.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source player human sleep event
     */
    public static HumanSleepEvent.SourcePlayer createHumanSleepEventSourcePlayer(Location<World> bed, Cause cause, Game game, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.Enter}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new enter source player human sleep event
     */
    public static HumanSleepEvent.SourcePlayer.Enter createHumanSleepEventSourcePlayerEnter(Location<World> bed, Cause cause, Game game, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.SourcePlayer.Enter.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StartSleeping}.
     * 
     * @param awokenPlayers The awoken players
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param ignoredPlayers The ignored players
     * @param sourceEntity The source entity
     * @return A new start sleeping source player human sleep event
     */
    public static HumanSleepEvent.SourcePlayer.StartSleeping createHumanSleepEventSourcePlayerStartSleeping(List<Player> awokenPlayers, Location<World> bed, Cause cause, Game game, List<Player> ignoredPlayers, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("awokenPlayers", awokenPlayers);
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("ignoredPlayers", ignoredPlayers);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.SourcePlayer.StartSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.SourcePlayer.StopSleeping}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param spawnTransform The spawn transform
     * @return A new stop sleeping source player human sleep event
     */
    public static HumanSleepEvent.SourcePlayer.StopSleeping createHumanSleepEventSourcePlayerStopSleeping(Location<World> bed, Cause cause, Game game, Player sourceEntity, Optional<Transform<World>> spawnTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        values.put("spawnTransform", spawnTransform);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.SourcePlayer.StopSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StartSleeping}.
     * 
     * @param awokenPlayers The awoken players
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param ignoredPlayers The ignored players
     * @param sourceEntity The source entity
     * @return A new start sleeping human sleep event
     */
    public static HumanSleepEvent.StartSleeping createHumanSleepEventStartSleeping(List<Player> awokenPlayers, Location<World> bed, Cause cause, Game game, List<Player> ignoredPlayers, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("awokenPlayers", awokenPlayers);
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
        values.put("ignoredPlayers", ignoredPlayers);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(HumanSleepEvent.StartSleeping.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.HumanSleepEvent.StopSleeping}.
     * 
     * @param bed The bed
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @param spawnTransform The spawn transform
     * @return A new stop sleeping human sleep event
     */
    public static HumanSleepEvent.StopSleeping createHumanSleepEventStopSleeping(Location<World> bed, Cause cause, Game game, Human sourceEntity, Optional<Transform<World>> spawnTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("bed", bed);
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param sink The sink
     * @param targetEntity The target entity
     * @return A new kick player event
     */
    public static KickPlayerEvent createKickPlayerEvent(Cause cause, Game game, Text message, Text originalMessage, MessageSink originalSink, MessageSink sink, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new player event
     */
    public static PlayerEvent createPlayerEvent(Cause cause, Game game, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(PlayerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.PlayerResourcePackStatusEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param pack The pack
     * @param sourceEntity The source entity
     * @param status The status
     * @return A new player resource pack status event
     */
    public static PlayerResourcePackStatusEvent createPlayerResourcePackStatusEvent(Cause cause, Game game, ResourcePack pack, Player sourceEntity, PlayerResourcePackStatusEvent.ResourcePackStatus status) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param bedSpawn The bed spawn
     * @param fromTransform The from transform
     * @param game The game
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new respawn player event
     */
    public static RespawnPlayerEvent createRespawnPlayerEvent(boolean bedSpawn, Transform<World> fromTransform, Game game, Player targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("bedSpawn", bedSpawn);
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
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
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param targetEntity The target entity
     * @return A new launch projectile event
     */
    public static LaunchProjectileEvent createLaunchProjectileEvent(Cause cause, Game game, Optional<ProjectileSource> source, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("source", source);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LaunchProjectileEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source entity launch projectile event
     */
    public static LaunchProjectileEvent.SourceEntity createLaunchProjectileEventSourceEntity(Cause cause, Game game, Optional<ProjectileSource> source, Entity sourceEntity, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source human launch projectile event
     */
    public static LaunchProjectileEvent.SourceHuman createLaunchProjectileEventSourceHuman(Cause cause, Game game, Optional<ProjectileSource> source, Human sourceEntity, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source living launch projectile event
     */
    public static LaunchProjectileEvent.SourceLiving createLaunchProjectileEventSourceLiving(Cause cause, Game game, Optional<ProjectileSource> source, Living sourceEntity, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param source The source
     * @param sourceEntity The source entity
     * @param targetEntity The target entity
     * @return A new source player launch projectile event
     */
    public static LaunchProjectileEvent.SourcePlayer createLaunchProjectileEventSourcePlayer(Cause cause, Game game, Optional<ProjectileSource> source, Player sourceEntity, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param result The result
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block brew event
     */
    public static BlockBrewEvent createBlockBrewEvent(Cause cause, Game game, Inventory inventory, Optional<ItemStack> result, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new block inventory event
     */
    public static BlockInventoryEvent createBlockInventoryEvent(Cause cause, Game game, Inventory inventory, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param container The container
     * @param game The game
     * @return A new container event
     */
    public static ContainerEvent createContainerEvent(Container container, Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(ContainerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @return A new drop item stack event
     */
    public static DropItemStackEvent createDropItemStackEvent(Cause cause, Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @return A new post drop item stack event
     */
    public static DropItemStackEvent.Post createDropItemStackEventPost(Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceBlock}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block post drop item stack event
     */
    public static DropItemStackEvent.Post.SourceBlock createDropItemStackEventPostSourceBlock(Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
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
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source entity post drop item stack event
     */
    public static DropItemStackEvent.Post.SourceEntity createDropItemStackEventPostSourceEntity(Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Game game, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceHuman}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source human post drop item stack event
     */
    public static DropItemStackEvent.Post.SourceHuman createDropItemStackEventPostSourceHuman(Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Game game, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourceLiving}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source living post drop item stack event
     */
    public static DropItemStackEvent.Post.SourceLiving createDropItemStackEventPostSourceLiving(Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Game game, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post.SourcePlayer}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source player post drop item stack event
     */
    public static DropItemStackEvent.Post.SourcePlayer createDropItemStackEventPostSourcePlayer(Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Game game, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @return A new pre drop item stack event
     */
    public static DropItemStackEvent.Pre createDropItemStackEventPre(Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceBlock}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourceBlock createDropItemStackEventPreSourceBlock(Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
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
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source entity pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourceEntity createDropItemStackEventPreSourceEntity(Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Game game, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceHuman}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source human pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourceHuman createDropItemStackEventPreSourceHuman(Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Game game, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourceLiving}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source living pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourceLiving createDropItemStackEventPreSourceLiving(Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Game game, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Pre.SourcePlayer}.
     * 
     * @param cause The cause
     * @param defaultDroppedItems The default dropped items
     * @param droppedItems The dropped items
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source player pre drop item stack event
     */
    public static DropItemStackEvent.Pre.SourcePlayer createDropItemStackEventPreSourcePlayer(Cause cause, List<ItemStackSnapshot> defaultDroppedItems, List<ItemStackTransaction> droppedItems, Game game, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("defaultDroppedItems", defaultDroppedItems);
        values.put("droppedItems", droppedItems);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Pre.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceBlock}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block drop item stack event
     */
    public static DropItemStackEvent.SourceBlock createDropItemStackEventSourceBlock(Cause cause, Game game, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source entity drop item stack event
     */
    public static DropItemStackEvent.SourceEntity createDropItemStackEventSourceEntity(Cause cause, Game game, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source human drop item stack event
     */
    public static DropItemStackEvent.SourceHuman createDropItemStackEventSourceHuman(Cause cause, Game game, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source living drop item stack event
     */
    public static DropItemStackEvent.SourceLiving createDropItemStackEventSourceLiving(Cause cause, Game game, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceEntity The source entity
     * @return A new source player drop item stack event
     */
    public static DropItemStackEvent.SourcePlayer createDropItemStackEventSourcePlayer(Cause cause, Game game, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryClickEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param viewer The viewer
     * @return A new inventory click event
     */
    public static InventoryClickEvent createInventoryClickEvent(Container container, Game game, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        values.put("viewer", viewer);
        return SpongeEventFactoryUtils.createEventImpl(InventoryClickEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InventoryCloseEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param viewer The viewer
     * @return A new inventory close event
     */
    public static InventoryCloseEvent createInventoryCloseEvent(Container container, Game game, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceBlock The source block
     * @param sourceLocation The source location
     * @param sourceSide The source side
     * @return A new source block pick up item event
     */
    public static PickUpItemEvent.SourceBlock createPickUpItemEventSourceBlock(Cause cause, Game game, Inventory inventory, Collection<Item> items, BlockSnapshot sourceBlock, Location<World> sourceLocation, Optional<Direction> sourceSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @return A new source entity pick up item event
     */
    public static PickUpItemEvent.SourceEntity createPickUpItemEventSourceEntity(Cause cause, Game game, Inventory inventory, Collection<Item> items, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @return A new source human pick up item event
     */
    public static PickUpItemEvent.SourceHuman createPickUpItemEventSourceHuman(Cause cause, Game game, Inventory inventory, Collection<Item> items, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @return A new source living pick up item event
     */
    public static PickUpItemEvent.SourceLiving createPickUpItemEventSourceLiving(Cause cause, Game game, Inventory inventory, Collection<Item> items, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param inventory The inventory
     * @param items The items
     * @param sourceEntity The source entity
     * @return A new source player pick up item event
     */
    public static PickUpItemEvent.SourcePlayer createPickUpItemEventSourcePlayer(Cause cause, Game game, Inventory inventory, Collection<Item> items, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new use item stack event
     */
    public static UseItemStackEvent createUseItemStackEvent(Cause cause, Game game, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new finish use item stack event
     */
    public static UseItemStackEvent.Finish createUseItemStackEventFinish(Cause cause, Game game, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source entity use item stack event
     */
    public static UseItemStackEvent.SourceEntity createUseItemStackEventSourceEntity(Cause cause, Game game, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new finish source entity use item stack event
     */
    public static UseItemStackEvent.SourceEntity.Finish createUseItemStackEventSourceEntityFinish(Cause cause, Game game, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceEntity.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new start source entity use item stack event
     */
    public static UseItemStackEvent.SourceEntity.Start createUseItemStackEventSourceEntityStart(Cause cause, Game game, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceEntity.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new stop source entity use item stack event
     */
    public static UseItemStackEvent.SourceEntity.Stop createUseItemStackEventSourceEntityStop(Cause cause, Game game, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceEntity.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceEntity.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new tick source entity use item stack event
     */
    public static UseItemStackEvent.SourceEntity.Tick createUseItemStackEventSourceEntityTick(Cause cause, Game game, ItemStackTransaction itemStackInUse, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceEntity.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source human use item stack event
     */
    public static UseItemStackEvent.SourceHuman createUseItemStackEventSourceHuman(Cause cause, Game game, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new finish source human use item stack event
     */
    public static UseItemStackEvent.SourceHuman.Finish createUseItemStackEventSourceHumanFinish(Cause cause, Game game, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceHuman.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new start source human use item stack event
     */
    public static UseItemStackEvent.SourceHuman.Start createUseItemStackEventSourceHumanStart(Cause cause, Game game, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceHuman.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new stop source human use item stack event
     */
    public static UseItemStackEvent.SourceHuman.Stop createUseItemStackEventSourceHumanStop(Cause cause, Game game, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceHuman.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceHuman.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new tick source human use item stack event
     */
    public static UseItemStackEvent.SourceHuman.Tick createUseItemStackEventSourceHumanTick(Cause cause, Game game, ItemStackTransaction itemStackInUse, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceHuman.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source living use item stack event
     */
    public static UseItemStackEvent.SourceLiving createUseItemStackEventSourceLiving(Cause cause, Game game, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new finish source living use item stack event
     */
    public static UseItemStackEvent.SourceLiving.Finish createUseItemStackEventSourceLivingFinish(Cause cause, Game game, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceLiving.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new start source living use item stack event
     */
    public static UseItemStackEvent.SourceLiving.Start createUseItemStackEventSourceLivingStart(Cause cause, Game game, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceLiving.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new stop source living use item stack event
     */
    public static UseItemStackEvent.SourceLiving.Stop createUseItemStackEventSourceLivingStop(Cause cause, Game game, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceLiving.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourceLiving.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new tick source living use item stack event
     */
    public static UseItemStackEvent.SourceLiving.Tick createUseItemStackEventSourceLivingTick(Cause cause, Game game, ItemStackTransaction itemStackInUse, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourceLiving.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new source player use item stack event
     */
    public static UseItemStackEvent.SourcePlayer createUseItemStackEventSourcePlayer(Cause cause, Game game, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Finish}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new finish source player use item stack event
     */
    public static UseItemStackEvent.SourcePlayer.Finish createUseItemStackEventSourcePlayerFinish(Cause cause, Game game, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourcePlayer.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new start source player use item stack event
     */
    public static UseItemStackEvent.SourcePlayer.Start createUseItemStackEventSourcePlayerStart(Cause cause, Game game, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourcePlayer.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new stop source player use item stack event
     */
    public static UseItemStackEvent.SourcePlayer.Stop createUseItemStackEventSourcePlayerStop(Cause cause, Game game, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourcePlayer.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.SourcePlayer.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @param sourceEntity The source entity
     * @return A new tick source player use item stack event
     */
    public static UseItemStackEvent.SourcePlayer.Tick createUseItemStackEventSourcePlayerTick(Cause cause, Game game, ItemStackTransaction itemStackInUse, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.SourcePlayer.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new start use item stack event
     */
    public static UseItemStackEvent.Start createUseItemStackEventStart(Cause cause, Game game, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new stop use item stack event
     */
    public static UseItemStackEvent.Stop createUseItemStackEventStop(Cause cause, Game game, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick}.
     * 
     * @param cause The cause
     * @param game The game
     * @param itemStackInUse The item stack in use
     * @return A new tick use item stack event
     */
    public static UseItemStackEvent.Tick createUseItemStackEventTick(Cause cause, Game game, ItemStackTransaction itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerCraftItemEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param inventory The inventory
     * @param recipe The recipe
     * @param resultTypes The result types
     * @param results The results
     * @param viewer The viewer
     * @return A new viewer craft item event
     */
    public static ViewerCraftItemEvent createViewerCraftItemEvent(Container container, Game game, CraftingInventory inventory, Recipe recipe, List<ItemType> resultTypes, List<ItemStack> results, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
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
     * @param container The container
     * @param game The game
     * @param viewer The viewer
     * @return A new viewer event
     */
    public static ViewerEvent createViewerEvent(Container container, Game game, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
        values.put("viewer", viewer);
        return SpongeEventFactoryUtils.createEventImpl(ViewerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.viewer.ViewerOpenContainerEvent}.
     * 
     * @param container The container
     * @param game The game
     * @param viewer The viewer
     * @return A new viewer open container event
     */
    public static ViewerOpenContainerEvent createViewerOpenContainerEvent(Container container, Game game, Human viewer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("container", container);
        values.put("game", game);
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
     * @param connection The connection
     * @param game The game
     * @param profile The profile
     * @return A new client connection event
     */
    public static ClientConnectionEvent createClientConnectionEvent(RemoteConnection connection, Game game, GameProfile profile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("connection", connection);
        values.put("game", game);
        values.put("profile", profile);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Disconnect}.
     * 
     * @param connection The connection
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param profile The profile
     * @param sink The sink
     * @param targetEntity The target entity
     * @return A new disconnect client connection event
     */
    public static ClientConnectionEvent.Disconnect createClientConnectionEventDisconnect(RemoteConnection connection, Game game, Text message, Text originalMessage, MessageSink originalSink, GameProfile profile, MessageSink sink, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("connection", connection);
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
        values.put("originalSink", originalSink);
        values.put("profile", profile);
        values.put("sink", sink);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.Disconnect.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Join}.
     * 
     * @param connection The connection
     * @param fromTransform The from transform
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param profile The profile
     * @param sink The sink
     * @param targetEntity The target entity
     * @param toTransform The to transform
     * @return A new join client connection event
     */
    public static ClientConnectionEvent.Join createClientConnectionEventJoin(RemoteConnection connection, Transform<World> fromTransform, Game game, Text message, Text originalMessage, MessageSink originalSink, GameProfile profile, MessageSink sink, Player targetEntity, Transform<World> toTransform) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("connection", connection);
        values.put("fromTransform", fromTransform);
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
        values.put("originalSink", originalSink);
        values.put("profile", profile);
        values.put("sink", sink);
        values.put("targetEntity", targetEntity);
        values.put("toTransform", toTransform);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.Join.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Login}.
     * 
     * @param connection The connection
     * @param game The game
     * @param message The message
     * @param originalMessage The original message
     * @param originalSink The original sink
     * @param profile The profile
     * @param sink The sink
     * @return A new login client connection event
     */
    public static ClientConnectionEvent.Login createClientConnectionEventLogin(RemoteConnection connection, Game game, Text message, Text originalMessage, MessageSink originalSink, GameProfile profile, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("connection", connection);
        values.put("game", game);
        values.put("message", message);
        values.put("originalMessage", originalMessage);
        values.put("originalSink", originalSink);
        values.put("profile", profile);
        values.put("sink", sink);
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
     * @param client The client
     * @param game The game
     * @param response The response
     * @param server The server
     * @return A new ping server event
     */
    public static PingServerEvent createPingServerEvent(StatusClient client, Game game, PingServerEvent.Response response, Server server) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("client", client);
        values.put("game", game);
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
     * @param max The max
     * @param online The online
     * @param profiles The profiles
     * @return A new players response ping server event
     */
    public static PingServerEvent.Response.Players createPingServerEventResponsePlayers(int max, int online, List<GameProfile> profiles) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("max", max);
        values.put("online", online);
        values.put("profiles", profiles);
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
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param motd The motd
     * @param playerCount The player count
     * @param size The size
     * @return A new basic query server event
     */
    public static BasicQueryServerEvent createBasicQueryServerEvent(InetSocketAddress address, String gameType, String map, int maxPlayerCount, int maxSize, String motd, int playerCount, int size) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("address", address);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("motd", motd);
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
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param motd The motd
     * @param playerCount The player count
     * @param players The players
     * @param plugins The plugins
     * @param size The size
     * @param version The version
     * @return A new full query server event
     */
    public static FullQueryServerEvent createFullQueryServerEvent(InetSocketAddress address, Map<String, String> customValuesMap, String gameId, String gameType, String map, int maxPlayerCount, int maxSize, String motd, int playerCount, List<String> players, String plugins, int size, String version) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("address", address);
        values.put("customValuesMap", customValuesMap);
        values.put("gameId", gameId);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("motd", motd);
        values.put("playerCount", playerCount);
        values.put("players", players);
        values.put("plugins", plugins);
        values.put("size", size);
        values.put("version", version);
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
     * @param maxPlayerCount The max player count
     * @param maxSize The max size
     * @param motd The motd
     * @param playerCount The player count
     * @param size The size
     * @return A new query server event
     */
    public static QueryServerEvent createQueryServerEvent(InetSocketAddress address, String gameType, String map, int maxPlayerCount, int maxSize, String motd, int playerCount, int size) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("address", address);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("motd", motd);
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
     * @param ban The ban
     * @param game The game
     * @param targetEntity The target entity
     * @param targetUser The target user
     * @return A new target player ban user event
     */
    public static BanUserEvent.TargetPlayer createBanUserEventTargetPlayer(Ban.User ban, Game game, Player targetEntity, User targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("ban", ban);
        values.put("game", game);
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
     * @param ban The ban
     * @param game The game
     * @param targetEntity The target entity
     * @param targetUser The target user
     * @return A new target player pardon user event
     */
    public static PardonUserEvent.TargetPlayer createPardonUserEventTargetPlayer(Ban.User ban, Game game, Player targetEntity, Player targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("ban", ban);
        values.put("game", game);
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
     * @param name The name
     * @param originalValue The original value
     * @param targetWorld The target world
     * @param value The value
     * @return A new change world game rule event
     */
    public static ChangeWorldGameRuleEvent createChangeWorldGameRuleEvent(Game game, String name, String originalValue, World targetWorld, String value) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("name", name);
        values.put("originalValue", originalValue);
        values.put("targetWorld", targetWorld);
        values.put("value", value);
        return SpongeEventFactoryUtils.createEventImpl(ChangeWorldGameRuleEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ChangeWorldWeatherEvent}.
     * 
     * @param cause The cause
     * @param duration The duration
     * @param game The game
     * @param initialWeather The initial weather
     * @param resultingWeather The resulting weather
     * @param world The world
     * @return A new change world weather event
     */
    public static ChangeWorldWeatherEvent createChangeWorldWeatherEvent(Cause cause, int duration, Game game, Weather initialWeather, Weather resultingWeather, World world) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("duration", duration);
        values.put("game", game);
        values.put("initialWeather", initialWeather);
        values.put("resultingWeather", resultingWeather);
        values.put("world", world);
        return SpongeEventFactoryUtils.createEventImpl(ChangeWorldWeatherEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @return A new create portal event
     */
    public static CreatePortalEvent createCreatePortalEvent(Cause cause, Game game, Location<World> portalLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        return SpongeEventFactoryUtils.createEventImpl(CreatePortalEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent.SourceEntity}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @return A new source entity create portal event
     */
    public static CreatePortalEvent.SourceEntity createCreatePortalEventSourceEntity(Cause cause, Game game, Location<World> portalLocation, Entity sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(CreatePortalEvent.SourceEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent.SourceHuman}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @return A new source human create portal event
     */
    public static CreatePortalEvent.SourceHuman createCreatePortalEventSourceHuman(Cause cause, Game game, Location<World> portalLocation, Human sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(CreatePortalEvent.SourceHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent.SourceLiving}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @return A new source living create portal event
     */
    public static CreatePortalEvent.SourceLiving createCreatePortalEventSourceLiving(Cause cause, Game game, Location<World> portalLocation, Living sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(CreatePortalEvent.SourceLiving.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreatePortalEvent.SourcePlayer}.
     * 
     * @param cause The cause
     * @param game The game
     * @param portalLocation The portal location
     * @param sourceEntity The source entity
     * @return A new source player create portal event
     */
    public static CreatePortalEvent.SourcePlayer createCreatePortalEventSourcePlayer(Cause cause, Game game, Location<World> portalLocation, Player sourceEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("portalLocation", portalLocation);
        values.put("sourceEntity", sourceEntity);
        return SpongeEventFactoryUtils.createEventImpl(CreatePortalEvent.SourcePlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.CreateWorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param worldCreationSettings The world creation settings
     * @param worldProperties The world properties
     * @return A new create world event
     */
    public static CreateWorldEvent createCreateWorldEvent(Cause cause, Game game, WorldCreationSettings worldCreationSettings, WorldProperties worldProperties) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("worldCreationSettings", worldCreationSettings);
        values.put("worldProperties", worldProperties);
        return SpongeEventFactoryUtils.createEventImpl(CreateWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.LoadWorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetWorld The target world
     * @return A new load world event
     */
    public static LoadWorldEvent createLoadWorldEvent(Cause cause, Game game, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(LoadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.UnloadWorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetWorld The target world
     * @return A new unload world event
     */
    public static UnloadWorldEvent createUnloadWorldEvent(Cause cause, Game game, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(UnloadWorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @return A new world event
     */
    public static WorldEvent createWorldEvent(Cause cause, Game game, World sourceWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        return SpongeEventFactoryUtils.createEventImpl(WorldEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent}.
     * 
     * @param cause The cause
     * @param explosion The explosion
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new world explosion event
     */
    public static WorldExplosionEvent createWorldExplosionEvent(Cause cause, Explosion explosion, Game game, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(WorldExplosionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent.Detonate}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param explosion The explosion
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new detonate world explosion event
     */
    public static WorldExplosionEvent.Detonate createWorldExplosionEventDetonate(Cause cause, List<? extends Entity> entities, List<EntitySnapshot> entitySnapshots, Explosion explosion, Game game, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("explosion", explosion);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(WorldExplosionEvent.Detonate.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldExplosionEvent.Pre}.
     * 
     * @param cause The cause
     * @param explosion The explosion
     * @param game The game
     * @param sourceWorld The source world
     * @param transactions The transactions
     * @return A new pre world explosion event
     */
    public static WorldExplosionEvent.Pre createWorldExplosionEventPre(Cause cause, Explosion explosion, Game game, World sourceWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(WorldExplosionEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new world generate chunk event
     */
    public static WorldGenerateChunkEvent createWorldGenerateChunkEvent(Cause cause, Game game, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(WorldGenerateChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent.Post}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new post world generate chunk event
     */
    public static WorldGenerateChunkEvent.Post createWorldGenerateChunkEventPost(Cause cause, Game game, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(WorldGenerateChunkEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.WorldGenerateChunkEvent.Pre}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new pre world generate chunk event
     */
    public static WorldGenerateChunkEvent.Pre createWorldGenerateChunkEventPre(Cause cause, Game game, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(WorldGenerateChunkEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceChunk The source chunk
     * @param sourceLocation The source location
     * @return A new chunk event
     */
    public static ChunkEvent createChunkEvent(Cause cause, Game game, Chunk sourceChunk, Location<Chunk> sourceLocation) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceChunk", sourceChunk);
        values.put("sourceLocation", sourceLocation);
        return SpongeEventFactoryUtils.createEventImpl(ChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ForcedChunkEvent}.
     * 
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param game The game
     * @param targetChunk The target chunk
     * @param ticket The ticket
     * @return A new forced chunk event
     */
    public static ForcedChunkEvent createForcedChunkEvent(Cause cause, Vector3i chunkCoords, Game game, Chunk targetChunk, ChunkLoadService.LoadingTicket ticket) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("chunkCoords", chunkCoords);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        values.put("ticket", ticket);
        return SpongeEventFactoryUtils.createEventImpl(ForcedChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.LoadChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new load chunk event
     */
    public static LoadChunkEvent createLoadChunkEvent(Cause cause, Game game, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(LoadChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.LoadChunkEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world load chunk event
     */
    public static LoadChunkEvent.SourceWorld createLoadChunkEventSourceWorld(Cause cause, Game game, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(LoadChunkEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new populate chunk event
     */
    public static PopulateChunkEvent createPopulateChunkEvent(Cause cause, Game game, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(PopulateChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Populate}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new populate populate chunk event
     */
    public static PopulateChunkEvent.Populate createPopulateChunkEventPopulate(Cause cause, Game game, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(PopulateChunkEvent.Populate.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Post}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new post populate chunk event
     */
    public static PopulateChunkEvent.Post createPopulateChunkEventPost(Cause cause, Game game, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(PopulateChunkEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Pre}.
     * 
     * @param cause The cause
     * @param game The game
     * @param pendingPopulators The pending populators
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new pre populate chunk event
     */
    public static PopulateChunkEvent.Pre createPopulateChunkEventPre(Cause cause, Game game, List<Populator> pendingPopulators, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
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
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new target chunk event
     */
    public static TargetChunkEvent createTargetChunkEvent(Cause cause, Game game, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(TargetChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.TargetChunkEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world target chunk event
     */
    public static TargetChunkEvent.SourceWorld createTargetChunkEventSourceWorld(Cause cause, Game game, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(TargetChunkEvent.SourceWorld.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnforcedChunkEvent}.
     * 
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param game The game
     * @param ticket The ticket
     * @return A new unforced chunk event
     */
    public static UnforcedChunkEvent createUnforcedChunkEvent(Cause cause, Vector3i chunkCoords, Game game, ChunkLoadService.LoadingTicket ticket) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("chunkCoords", chunkCoords);
        values.put("game", game);
        values.put("ticket", ticket);
        return SpongeEventFactoryUtils.createEventImpl(UnforcedChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnloadChunkEvent}.
     * 
     * @param cause The cause
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new unload chunk event
     */
    public static UnloadChunkEvent createUnloadChunkEvent(Cause cause, Game game, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(UnloadChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnloadChunkEvent.SourceWorld}.
     * 
     * @param cause The cause
     * @param game The game
     * @param sourceWorld The source world
     * @param targetChunk The target chunk
     * @return A new source world unload chunk event
     */
    public static UnloadChunkEvent.SourceWorld createUnloadChunkEventSourceWorld(Cause cause, Game game, World sourceWorld, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("game", game);
        values.put("sourceWorld", sourceWorld);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(UnloadChunkEvent.SourceWorld.class, values);
    }
}
