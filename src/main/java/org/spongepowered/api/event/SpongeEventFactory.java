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
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.GameState;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.tileentity.Sign;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.block.tileentity.carrier.BrewingStand;
import org.spongepowered.api.block.tileentity.carrier.Furnace;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.SignData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.ai.Goal;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.projectile.FishHook;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.event.achievement.GrantAchievementEvent;
import org.spongepowered.api.event.action.FishingEvent;
import org.spongepowered.api.event.action.InteractEvent;
import org.spongepowered.api.event.action.LightningEvent;
import org.spongepowered.api.event.action.MessageEvent;
import org.spongepowered.api.event.action.SleepingEvent;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.block.CollideBlockEvent;
import org.spongepowered.api.event.block.GrowBlockEvent;
import org.spongepowered.api.event.block.InteractBlockEvent;
import org.spongepowered.api.event.block.MoveBlockEvent;
import org.spongepowered.api.event.block.NotifyNeighborBlockEvent;
import org.spongepowered.api.event.block.TargetBlockEvent;
import org.spongepowered.api.event.block.TickBlockEvent;
import org.spongepowered.api.event.block.tileentity.BrewingEvent;
import org.spongepowered.api.event.block.tileentity.ChangeSignEvent;
import org.spongepowered.api.event.block.tileentity.SmeltEvent;
import org.spongepowered.api.event.block.tileentity.TargetTileEntityEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.cause.entity.health.HealthModifier;
import org.spongepowered.api.event.command.MessageSinkEvent;
import org.spongepowered.api.event.command.SendCommandEvent;
import org.spongepowered.api.event.command.TabCompleteCommandEvent;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;
import org.spongepowered.api.event.entity.AffectEntityEvent;
import org.spongepowered.api.event.entity.BreedEntityEvent;
import org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent;
import org.spongepowered.api.event.entity.ChangeEntityExperienceEvent;
import org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent;
import org.spongepowered.api.event.entity.CollideEntityEvent;
import org.spongepowered.api.event.entity.ConstructEntityEvent;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.entity.DismountEntityEvent;
import org.spongepowered.api.event.entity.DisplaceEntityEvent;
import org.spongepowered.api.event.entity.ExpireEntityEvent;
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
import org.spongepowered.api.event.entity.ai.AITaskEvent;
import org.spongepowered.api.event.entity.item.ItemMergeItemEvent;
import org.spongepowered.api.event.entity.item.TargetItemEvent;
import org.spongepowered.api.event.entity.living.TargetAgentEvent;
import org.spongepowered.api.event.entity.living.TargetLivingEvent;
import org.spongepowered.api.event.entity.living.human.ChangeGameModeEvent;
import org.spongepowered.api.event.entity.living.human.ChangeLevelEvent;
import org.spongepowered.api.event.entity.living.human.TargetHumanEvent;
import org.spongepowered.api.event.entity.living.player.KickPlayerEvent;
import org.spongepowered.api.event.entity.living.player.ResourcePackStatusEvent;
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
import org.spongepowered.api.event.game.state.GameStoppedEvent;
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.event.item.inventory.AffectItemStackEvent;
import org.spongepowered.api.event.item.inventory.AffectSlotEvent;
import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.event.item.inventory.ClickInventoryEvent;
import org.spongepowered.api.event.item.inventory.CreativeInventoryEvent;
import org.spongepowered.api.event.item.inventory.DropItemEvent;
import org.spongepowered.api.event.item.inventory.InteractInventoryEvent;
import org.spongepowered.api.event.item.inventory.TargetContainerEvent;
import org.spongepowered.api.event.item.inventory.TargetInventoryEvent;
import org.spongepowered.api.event.item.inventory.UseItemStackEvent;
import org.spongepowered.api.event.network.BanIpEvent;
import org.spongepowered.api.event.network.ChannelRegistrationEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.network.PardonIpEvent;
import org.spongepowered.api.event.network.rcon.RconConnectionEvent;
import org.spongepowered.api.event.server.ClientPingServerEvent;
import org.spongepowered.api.event.server.query.QueryServerEvent;
import org.spongepowered.api.event.statistic.ChangeStatisticEvent;
import org.spongepowered.api.event.user.BanUserEvent;
import org.spongepowered.api.event.user.PardonUserEvent;
import org.spongepowered.api.event.user.TargetUserEvent;
import org.spongepowered.api.event.world.ChangeWorldGameRuleEvent;
import org.spongepowered.api.event.world.ChangeWorldWeatherEvent;
import org.spongepowered.api.event.world.ConstructPortalEvent;
import org.spongepowered.api.event.world.ConstructWorldEvent;
import org.spongepowered.api.event.world.ExplosionEvent;
import org.spongepowered.api.event.world.GenerateChunkEvent;
import org.spongepowered.api.event.world.LoadWorldEvent;
import org.spongepowered.api.event.world.TargetWorldEvent;
import org.spongepowered.api.event.world.UnloadWorldEvent;
import org.spongepowered.api.event.world.chunk.ForcedChunkEvent;
import org.spongepowered.api.event.world.chunk.LoadChunkEvent;
import org.spongepowered.api.event.world.chunk.PopulateChunkEvent;
import org.spongepowered.api.event.world.chunk.TargetChunkEvent;
import org.spongepowered.api.event.world.chunk.UnforcedChunkEvent;
import org.spongepowered.api.event.world.chunk.UnloadChunkEvent;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.transaction.SlotTransaction;
import org.spongepowered.api.network.RemoteConnection;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.service.world.ChunkLoadService;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.achievement.Achievement;
import org.spongepowered.api.status.Favicon;
import org.spongepowered.api.status.StatusClient;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.ban.Ban;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.source.RconSource;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.TeleporterAgent;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldCreationSettings;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.gen.PopulatorType;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.weather.Weather;

public class SpongeEventFactory {
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
     * {@link org.spongepowered.api.event.achievement.GrantAchievementEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param achievement The achievement
     * @return A new grant achievement event
     */
    public static GrantAchievementEvent createGrantAchievementEvent(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Achievement achievement) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("achievement", achievement);
        return SpongeEventFactoryUtils.createEventImpl(GrantAchievementEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.achievement.GrantAchievementEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param achievement The achievement
     * @param targetEntity The target entity
     * @return A new target player grant achievement event
     */
    public static GrantAchievementEvent.TargetPlayer createGrantAchievementEventTargetPlayer(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Achievement achievement, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("achievement", achievement);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(GrantAchievementEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.FishingEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @return A new fishing event
     */
    public static FishingEvent createFishingEvent(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.FishingEvent.HookEntity}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param targetEntity The target entity
     * @return A new hook entity fishing event
     */
    public static FishingEvent.HookEntity createFishingEventHookEntity(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.HookEntity.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.FishingEvent.Start}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @return A new start fishing event
     */
    public static FishingEvent.Start createFishingEventStart(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.FishingEvent.Stop}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param itemStackTransaction The item stack transaction
     * @param targetEntity The target entity
     * @return A new stop fishing event
     */
    public static FishingEvent.Stop createFishingEventStop(Game game, Cause cause, int originalExperience, int experience, EntitySnapshot originalFishHook, FishHook fishHook, Transaction<ItemStackSnapshot> itemStackTransaction, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        values.put("itemStackTransaction", itemStackTransaction);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Stop.class, values);
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
     * {@link org.spongepowered.api.event.action.LightningEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @return A new lightning event
     */
    public static LightningEvent createLightningEvent(Game game, Cause cause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        return SpongeEventFactoryUtils.createEventImpl(LightningEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.LightningEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @return A new post lightning event
     */
    public static LightningEvent.Post createLightningEventPost(Game game, Cause cause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        return SpongeEventFactoryUtils.createEventImpl(LightningEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.LightningEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @return A new pre lightning event
     */
    public static LightningEvent.Pre createLightningEventPre(Game game, Cause cause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        return SpongeEventFactoryUtils.createEventImpl(LightningEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.LightningEvent.Strike}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new strike lightning event
     */
    public static LightningEvent.Strike createLightningEventStrike(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(LightningEvent.Strike.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.MessageEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @return A new message event
     */
    public static MessageEvent createMessageEvent(Game game, Cause cause, Text originalMessage, Text message) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        return SpongeEventFactoryUtils.createEventImpl(MessageEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param targetEntity The target entity
     * @return A new sleeping event
     */
    public static SleepingEvent createSleepingEvent(Game game, Cause cause, BlockSnapshot bed, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SleepingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent.Finish}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param targetEntity The target entity
     * @return A new finish sleeping event
     */
    public static SleepingEvent.Finish createSleepingEventFinish(Game game, Cause cause, BlockSnapshot bed, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SleepingEvent.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param spawnTransform The spawn transform
     * @param targetEntity The target entity
     * @param spawnSet The spawn set
     * @return A new post sleeping event
     */
    public static SleepingEvent.Post createSleepingEventPost(Game game, Cause cause, BlockSnapshot bed, Optional<Transform<World>> spawnTransform, Entity targetEntity, boolean spawnSet) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("spawnTransform", spawnTransform);
        values.put("targetEntity", targetEntity);
        values.put("spawnSet", spawnSet);
        return SpongeEventFactoryUtils.createEventImpl(SleepingEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param targetEntity The target entity
     * @return A new pre sleeping event
     */
    public static SleepingEvent.Pre createSleepingEventPre(Game game, Cause cause, BlockSnapshot bed, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SleepingEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent.Tick}.
     * 
     * @param game The game
     * @param cause The cause
     * @param bed The bed
     * @param targetEntity The target entity
     * @return A new tick sleeping event
     */
    public static SleepingEvent.Tick createSleepingEventTick(Game game, Cause cause, BlockSnapshot bed, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(SleepingEvent.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new change block event
     */
    public static ChangeBlockEvent createChangeBlockEvent(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Break}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new break change block event
     */
    public static ChangeBlockEvent.Break createChangeBlockEventBreak(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.Break.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Decay}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new decay change block event
     */
    public static ChangeBlockEvent.Decay createChangeBlockEventDecay(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.Decay.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Fluid}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new fluid change block event
     */
    public static ChangeBlockEvent.Fluid createChangeBlockEventFluid(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.Fluid.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Grow}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new grow change block event
     */
    public static ChangeBlockEvent.Grow createChangeBlockEventGrow(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.Grow.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Modify}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new modify change block event
     */
    public static ChangeBlockEvent.Modify createChangeBlockEventModify(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.Modify.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Place}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new place change block event
     */
    public static ChangeBlockEvent.Place createChangeBlockEventPlace(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.Place.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new post change block event
     */
    public static ChangeBlockEvent.Post createChangeBlockEventPost(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeBlockEvent.Post.class, values);
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
     * {@link org.spongepowered.api.event.block.GrowBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new grow block event
     */
    public static GrowBlockEvent createGrowBlockEvent(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(GrowBlockEvent.class, values);
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
     * @param targetSide The target side
     * @return A new interact block event
     */
    public static InteractBlockEvent createInteractBlockEvent(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Primary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @return A new primary interact block event
     */
    public static InteractBlockEvent.Primary createInteractBlockEventPrimary(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Primary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Secondary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @return A new secondary interact block event
     */
    public static InteractBlockEvent.Secondary createInteractBlockEventSecondary(Game game, Cause cause, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Direction targetSide) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetBlock", targetBlock);
        values.put("targetSide", targetSide);
        return SpongeEventFactoryUtils.createEventImpl(InteractBlockEvent.Secondary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.MoveBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new move block event
     */
    public static MoveBlockEvent createMoveBlockEvent(Game game, Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(MoveBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalNeighbors The original neighbors
     * @param neighbors The neighbors
     * @return A new notify neighbor block event
     */
    public static NotifyNeighborBlockEvent createNotifyNeighborBlockEvent(Game game, Cause cause, Map<Direction, BlockState> originalNeighbors, Map<Direction, BlockState> neighbors) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalNeighbors", originalNeighbors);
        values.put("neighbors", neighbors);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.TargetBlockEvent}.
     * 
     * @param game The game
     * @param targetBlock The target block
     * @return A new target block event
     */
    public static TargetBlockEvent createTargetBlockEvent(Game game, BlockSnapshot targetBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetBlock", targetBlock);
        return SpongeEventFactoryUtils.createEventImpl(TargetBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.TickBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetBlock The target block
     * @return A new tick block event
     */
    public static TickBlockEvent createTickBlockEvent(Game game, Cause cause, BlockSnapshot targetBlock) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetBlock", targetBlock);
        return SpongeEventFactoryUtils.createEventImpl(TickBlockEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @return A new brewing event
     */
    public static BrewingEvent createBrewingEvent(Game game, Cause cause, ItemStackSnapshot ingredient, BrewingStand targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("ingredient", ingredient);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(BrewingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent.Finish}.
     * 
     * @param game The game
     * @param cause The cause
     * @param brewedItemStacks The brewed item stacks
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @return A new finish brewing event
     */
    public static BrewingEvent.Finish createBrewingEventFinish(Game game, Cause cause, List<ItemStackSnapshot> brewedItemStacks, ItemStackSnapshot ingredient, BrewingStand targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("brewedItemStacks", brewedItemStacks);
        values.put("ingredient", ingredient);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(BrewingEvent.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent.Interrupt}.
     * 
     * @param game The game
     * @param cause The cause
     * @param brewedItemStacks The brewed item stacks
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @return A new interrupt brewing event
     */
    public static BrewingEvent.Interrupt createBrewingEventInterrupt(Game game, Cause cause, List<ItemStackSnapshot> brewedItemStacks, ItemStackSnapshot ingredient, BrewingStand targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("brewedItemStacks", brewedItemStacks);
        values.put("ingredient", ingredient);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(BrewingEvent.Interrupt.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent.Start}.
     * 
     * @param game The game
     * @param cause The cause
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new start brewing event
     */
    public static BrewingEvent.Start createBrewingEventStart(Game game, Cause cause, ItemStackSnapshot ingredient, BrewingStand targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("ingredient", ingredient);
        values.put("targetTile", targetTile);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BrewingEvent.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent.Tick}.
     * 
     * @param game The game
     * @param cause The cause
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new tick brewing event
     */
    public static BrewingEvent.Tick createBrewingEventTick(Game game, Cause cause, ItemStackSnapshot ingredient, BrewingStand targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("ingredient", ingredient);
        values.put("targetTile", targetTile);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BrewingEvent.Tick.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalText The original text
     * @param text The text
     * @param targetTile The target tile
     * @return A new change sign event
     */
    public static ChangeSignEvent createChangeSignEvent(Game game, Cause cause, ImmutableSignData originalText, SignData text, Sign targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalText", originalText);
        values.put("text", text);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(ChangeSignEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fuel The fuel
     * @param targetTile The target tile
     * @return A new smelt event
     */
    public static SmeltEvent createSmeltEvent(Game game, Cause cause, ItemStackSnapshot fuel, Furnace targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(SmeltEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.ConsumeFuel}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fuel The fuel
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new consume fuel smelt event
     */
    public static SmeltEvent.ConsumeFuel createSmeltEventConsumeFuel(Game game, Cause cause, ItemStackSnapshot fuel, Furnace targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("targetTile", targetTile);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(SmeltEvent.ConsumeFuel.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.Finish}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fuel The fuel
     * @param smeltedItems The smelted items
     * @param targetTile The target tile
     * @return A new finish smelt event
     */
    public static SmeltEvent.Finish createSmeltEventFinish(Game game, Cause cause, ItemStackSnapshot fuel, List<ItemStackSnapshot> smeltedItems, Furnace targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("smeltedItems", smeltedItems);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(SmeltEvent.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.Interrupt}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fuel The fuel
     * @param smeltedItems The smelted items
     * @param targetTile The target tile
     * @return A new interrupt smelt event
     */
    public static SmeltEvent.Interrupt createSmeltEventInterrupt(Game game, Cause cause, ItemStackSnapshot fuel, List<ItemStackSnapshot> smeltedItems, Furnace targetTile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("smeltedItems", smeltedItems);
        values.put("targetTile", targetTile);
        return SpongeEventFactoryUtils.createEventImpl(SmeltEvent.Interrupt.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.Start}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fuel The fuel
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new start smelt event
     */
    public static SmeltEvent.Start createSmeltEventStart(Game game, Cause cause, ItemStackSnapshot fuel, Furnace targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("targetTile", targetTile);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(SmeltEvent.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.Tick}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fuel The fuel
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new tick smelt event
     */
    public static SmeltEvent.Tick createSmeltEventTick(Game game, Cause cause, ItemStackSnapshot fuel, Furnace targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("targetTile", targetTile);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(SmeltEvent.Tick.class, values);
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
     * {@link org.spongepowered.api.event.command.MessageSinkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @return A new message sink event
     */
    public static MessageSinkEvent createMessageSinkEvent(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.MessageSinkEvent.Chat}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param rawMessage The raw message
     * @return A new chat message sink event
     */
    public static MessageSinkEvent.Chat createMessageSinkEventChat(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Text rawMessage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("rawMessage", rawMessage);
        return SpongeEventFactoryUtils.createEventImpl(MessageSinkEvent.Chat.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.SendCommandEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param arguments The arguments
     * @param command The command
     * @param result The result
     * @return A new send command event
     */
    public static SendCommandEvent createSendCommandEvent(Game game, Cause cause, String arguments, String command, CommandResult result) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("arguments", arguments);
        values.put("command", command);
        values.put("result", result);
        return SpongeEventFactoryUtils.createEventImpl(SendCommandEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.TabCompleteCommandEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param arguments The arguments
     * @param command The command
     * @param tabCompletions The tab completions
     * @return A new tab complete command event
     */
    public static TabCompleteCommandEvent createTabCompleteCommandEvent(Game game, Cause cause, String arguments, String command, List<String> tabCompletions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("arguments", arguments);
        values.put("command", command);
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
     * @param originalChanges The original changes
     * @param targetHolder The target holder
     * @return A new value change change data holder event
     */
    public static ChangeDataHolderEvent.ValueChange createChangeDataHolderEventValueChange(Game game, DataTransactionResult originalChanges, DataHolder targetHolder) {
        Map<String, Object> values = Maps.newHashMap();
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
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new affect entity event
     */
    public static AffectEntityEvent createAffectEntityEvent(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
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
    public static BreedEntityEvent createBreedEntityEvent(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity targetEntity) {
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
     * @param targetEntity The target entity
     * @return A new breed breed entity event
     */
    public static BreedEntityEvent.Breed createBreedEntityEventBreed(Game game, Cause cause, Optional<Vector3d> interactionPoint, Ageable offspringEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("offspringEntity", offspringEntity);
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
     * @param targetEntity The target entity
     * @param hasAllowResult The has allow result
     * @return A new find mate breed entity event
     */
    public static BreedEntityEvent.FindMate createBreedEntityEventFindMate(Game game, Cause cause, TristateResult.Result originalResult, TristateResult.Result result, Optional<Vector3d> interactionPoint, Entity targetEntity, boolean hasAllowResult) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalResult", originalResult);
        values.put("result", result);
        values.put("interactionPoint", interactionPoint);
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
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @return A new change entity equipment event
     */
    public static ChangeEntityEquipmentEvent createChangeEntityEquipmentEvent(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<Transaction<ItemStackSnapshot>> itemStack, Entity targetEntity, Slot targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalItemStack", originalItemStack);
        values.put("itemStack", itemStack);
        values.put("targetEntity", targetEntity);
        values.put("targetInventory", targetInventory);
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
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @return A new target human change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetHuman createChangeEntityEquipmentEventTargetHuman(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<Transaction<ItemStackSnapshot>> itemStack, Humanoid targetEntity, Slot targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalItemStack", originalItemStack);
        values.put("itemStack", itemStack);
        values.put("targetEntity", targetEntity);
        values.put("targetInventory", targetInventory);
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
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @return A new target living change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetLiving createChangeEntityEquipmentEventTargetLiving(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<Transaction<ItemStackSnapshot>> itemStack, Living targetEntity, Slot targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalItemStack", originalItemStack);
        values.put("itemStack", itemStack);
        values.put("targetEntity", targetEntity);
        values.put("targetInventory", targetInventory);
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
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @return A new target player change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetPlayer createChangeEntityEquipmentEventTargetPlayer(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<Transaction<ItemStackSnapshot>> itemStack, Player targetEntity, Slot targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalItemStack", originalItemStack);
        values.put("itemStack", itemStack);
        values.put("targetEntity", targetEntity);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityEquipmentEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityExperienceEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @return A new change entity experience event
     */
    public static ChangeEntityExperienceEvent createChangeEntityExperienceEvent(Game game, Cause cause, int originalExperience, int experience, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeEntityExperienceEvent.class, values);
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
     * @param originalEntities The original entities
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new collide entity event
     */
    public static CollideEntityEvent createCollideEntityEvent(Game game, Cause cause, List<Entity> originalEntities, List<Entity> entities, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalEntities", originalEntities);
        values.put("entities", entities);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(CollideEntityEvent.class, values);
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
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param originalDamage The original damage
     * @return A new damage entity event
     */
    public static DamageEntityEvent createDamageEntityEvent(Game game, Cause cause, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity, double originalDamage) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFunctions", originalFunctions);
        values.put("targetEntity", targetEntity);
        values.put("originalDamage", originalDamage);
        return SpongeEventFactoryUtils.createEventImpl(DamageEntityEvent.class, values);
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
     * @param targetEntity The target entity
     * @return A new destruct entity event
     */
    public static DestructEntityEvent createDestructEntityEvent(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DestructEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DestructEntityEvent.Death}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param targetEntity The target entity
     * @return A new death destruct entity event
     */
    public static DestructEntityEvent.Death createDestructEntityEventDeath(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Living targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(DestructEntityEvent.Death.class, values);
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
    public static DisplaceEntityEvent.Move.TargetHuman createDisplaceEntityEventMoveTargetHuman(Game game, Transform<World> fromTransform, Transform<World> toTransform, Humanoid targetEntity) {
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
    public static DisplaceEntityEvent.TargetHuman createDisplaceEntityEventTargetHuman(Game game, Transform<World> fromTransform, Transform<World> toTransform, Humanoid targetEntity) {
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
    public static DisplaceEntityEvent.Teleport.TargetHuman createDisplaceEntityEventTeleportTargetHuman(Game game, Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Humanoid targetEntity, TeleporterAgent teleporterAgent, boolean keepsVelocity) {
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
    public static HarvestEntityEvent.TargetHuman createHarvestEntityEventTargetHuman(Game game, Cause cause, int originalExperience, int experience, Humanoid targetEntity) {
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
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param originalHealAmount The original heal amount
     * @return A new heal entity event
     */
    public static HealEntityEvent createHealEntityEvent(Game game, Cause cause, List<Tuple<HealthModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity, double originalHealAmount) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFunctions", originalFunctions);
        values.put("targetEntity", targetEntity);
        values.put("originalHealAmount", originalHealAmount);
        return SpongeEventFactoryUtils.createEventImpl(HealEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.IgniteEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFireTicks The original fire ticks
     * @param fireTicks The fire ticks
     * @param targetEntity The target entity
     * @return A new ignite entity event
     */
    public static IgniteEntityEvent createIgniteEntityEvent(Game game, Cause cause, int originalFireTicks, int fireTicks, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFireTicks", originalFireTicks);
        values.put("fireTicks", fireTicks);
        values.put("targetEntity", targetEntity);
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
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Primary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new primary interact entity event
     */
    public static InteractEntityEvent.Primary createInteractEntityEventPrimary(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Primary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Secondary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new secondary interact entity event
     */
    public static InteractEntityEvent.Secondary createInteractEntityEventSecondary(Game game, Cause cause, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("interactionPoint", interactionPoint);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(InteractEntityEvent.Secondary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new leash entity event
     */
    public static LeashEntityEvent createLeashEntityEvent(Game game, Cause cause, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LeashEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MountEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new mount entity event
     */
    public static MountEntityEvent createMountEntityEvent(Game game, Cause cause, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(MountEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new spawn entity event
     */
    public static SpawnEntityEvent createSpawnEntityEvent(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.ChunkLoad}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new chunk load spawn entity event
     */
    public static SpawnEntityEvent.ChunkLoad createSpawnEntityEventChunkLoad(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.ChunkLoad.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.Custom}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new custom spawn entity event
     */
    public static SpawnEntityEvent.Custom createSpawnEntityEventCustom(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.Custom.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.Spawner}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new spawner spawn entity event
     */
    public static SpawnEntityEvent.Spawner createSpawnEntityEventSpawner(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(SpawnEntityEvent.Spawner.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new tame entity event
     */
    public static TameEntityEvent createTameEntityEvent(Game game, Cause cause, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TameEntityEvent.class, values);
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
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new unleash entity event
     */
    public static UnleashEntityEvent createUnleashEntityEvent(Game game, Cause cause, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(UnleashEntityEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ai.AITaskEvent}.
     * 
     * @param game The game
     * @param goal The goal
     * @param targetEntity The target entity
     * @param task The task
     * @param priority The priority
     * @return A new a i task event
     */
    public static AITaskEvent createAITaskEvent(Game game, Goal<? extends Agent> goal, Agent targetEntity, AITask<? extends Agent> task, int priority) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("goal", goal);
        values.put("targetEntity", targetEntity);
        values.put("task", task);
        values.put("priority", priority);
        return SpongeEventFactoryUtils.createEventImpl(AITaskEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ai.AITaskEvent.Add}.
     * 
     * @param game The game
     * @param originalPriority The original priority
     * @param priority The priority
     * @param goal The goal
     * @param targetEntity The target entity
     * @param task The task
     * @return A new add a i task event
     */
    public static AITaskEvent.Add createAITaskEventAdd(Game game, int originalPriority, int priority, Goal<? extends Agent> goal, Agent targetEntity, AITask<? extends Agent> task) {
        Preconditions.checkArgument(((goal.getOwner()) == targetEntity), String.format("The target entity \'%s\' is not the owner of the goal \'%s\'!", goal, targetEntity));
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("originalPriority", originalPriority);
        values.put("priority", priority);
        values.put("goal", goal);
        values.put("targetEntity", targetEntity);
        values.put("task", task);
        return SpongeEventFactoryUtils.createEventImpl(AITaskEvent.Add.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ai.AITaskEvent.Remove}.
     * 
     * @param game The game
     * @param goal The goal
     * @param targetEntity The target entity
     * @param task The task
     * @param priority The priority
     * @return A new remove a i task event
     */
    public static AITaskEvent.Remove createAITaskEventRemove(Game game, Goal<? extends Agent> goal, Agent targetEntity, AITask<? extends Agent> task, int priority) {
        Preconditions.checkArgument(((goal.getOwner()) == targetEntity), String.format("The target entity \'%s\' is not the owner of the goal \'%s\'!", goal, targetEntity));
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("goal", goal);
        values.put("targetEntity", targetEntity);
        values.put("task", task);
        values.put("priority", priority);
        return SpongeEventFactoryUtils.createEventImpl(AITaskEvent.Remove.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.item.ItemMergeItemEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param itemToMerge The item to merge
     * @param targetEntity The target entity
     * @return A new item merge item event
     */
    public static ItemMergeItemEvent createItemMergeItemEvent(Game game, Cause cause, Item itemToMerge, Item targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * {@link org.spongepowered.api.event.entity.living.TargetAgentEvent}.
     * 
     * @param game The game
     * @param targetEntity The target entity
     * @return A new target agent event
     */
    public static TargetAgentEvent createTargetAgentEvent(Game game, Agent targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(TargetAgentEvent.class, values);
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
     * {@link org.spongepowered.api.event.entity.living.human.ChangeGameModeEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalGameMode The original game mode
     * @param gameMode The game mode
     * @return A new change game mode event
     */
    public static ChangeGameModeEvent createChangeGameModeEvent(Game game, Cause cause, GameMode originalGameMode, GameMode gameMode) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalGameMode", originalGameMode);
        values.put("gameMode", gameMode);
        return SpongeEventFactoryUtils.createEventImpl(ChangeGameModeEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeGameModeEvent.TargetHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalGameMode The original game mode
     * @param gameMode The game mode
     * @param targetEntity The target entity
     * @return A new target human change game mode event
     */
    public static ChangeGameModeEvent.TargetHuman createChangeGameModeEventTargetHuman(Game game, Cause cause, GameMode originalGameMode, GameMode gameMode, Humanoid targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalGameMode", originalGameMode);
        values.put("gameMode", gameMode);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeGameModeEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeGameModeEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalGameMode The original game mode
     * @param gameMode The game mode
     * @param targetEntity The target entity
     * @return A new target player change game mode event
     */
    public static ChangeGameModeEvent.TargetPlayer createChangeGameModeEventTargetPlayer(Game game, Cause cause, GameMode originalGameMode, GameMode gameMode, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalGameMode", originalGameMode);
        values.put("gameMode", gameMode);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeGameModeEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeLevelEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalLevel The original level
     * @param level The level
     * @return A new change level event
     */
    public static ChangeLevelEvent createChangeLevelEvent(Game game, Cause cause, int originalLevel, int level) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalLevel", originalLevel);
        values.put("level", level);
        return SpongeEventFactoryUtils.createEventImpl(ChangeLevelEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeLevelEvent.TargetHuman}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalLevel The original level
     * @param level The level
     * @param targetEntity The target entity
     * @return A new target human change level event
     */
    public static ChangeLevelEvent.TargetHuman createChangeLevelEventTargetHuman(Game game, Cause cause, int originalLevel, int level, Humanoid targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalLevel", originalLevel);
        values.put("level", level);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeLevelEvent.TargetHuman.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.human.ChangeLevelEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalLevel The original level
     * @param level The level
     * @param targetEntity The target entity
     * @return A new target player change level event
     */
    public static ChangeLevelEvent.TargetPlayer createChangeLevelEventTargetPlayer(Game game, Cause cause, int originalLevel, int level, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalLevel", originalLevel);
        values.put("level", level);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeLevelEvent.TargetPlayer.class, values);
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
    public static TargetHumanEvent createTargetHumanEvent(Game game, Humanoid targetEntity) {
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
     * {@link org.spongepowered.api.event.entity.living.player.ResourcePackStatusEvent}.
     * 
     * @param game The game
     * @param pack The pack
     * @param player The player
     * @param status The status
     * @return A new resource pack status event
     */
    public static ResourcePackStatusEvent createResourcePackStatusEvent(Game game, ResourcePack pack, Player player, ResourcePackStatusEvent.ResourcePackStatus status) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("pack", pack);
        values.put("player", player);
        values.put("status", status);
        return SpongeEventFactoryUtils.createEventImpl(ResourcePackStatusEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.player.RespawnPlayerEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @param bedSpawn The bed spawn
     * @return A new respawn player event
     */
    public static RespawnPlayerEvent createRespawnPlayerEvent(Game game, Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Player targetEntity, boolean bedSpawn) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * @param targetEntity The target entity
     * @return A new launch projectile event
     */
    public static LaunchProjectileEvent createLaunchProjectileEvent(Game game, Cause cause, Projectile targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(LaunchProjectileEvent.class, values);
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
     * @param state The state
     * @return A new game about to start server event
     */
    public static GameAboutToStartServerEvent createGameAboutToStartServerEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameAboutToStartServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameConstructionEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game construction event
     */
    public static GameConstructionEvent createGameConstructionEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameConstructionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameInitializationEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game initialization event
     */
    public static GameInitializationEvent createGameInitializationEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameInitializationEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameLoadCompleteEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game load complete event
     */
    public static GameLoadCompleteEvent createGameLoadCompleteEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameLoadCompleteEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GamePostInitializationEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game post initialization event
     */
    public static GamePostInitializationEvent createGamePostInitializationEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GamePostInitializationEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GamePreInitializationEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game pre initialization event
     */
    public static GamePreInitializationEvent createGamePreInitializationEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GamePreInitializationEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStartedServerEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game started server event
     */
    public static GameStartedServerEvent createGameStartedServerEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameStartedServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStartingServerEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game starting server event
     */
    public static GameStartingServerEvent createGameStartingServerEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameStartingServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStateEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game state event
     */
    public static GameStateEvent createGameStateEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameStateEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppedEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game stopped event
     */
    public static GameStoppedEvent createGameStoppedEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameStoppedEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppedServerEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game stopped server event
     */
    public static GameStoppedServerEvent createGameStoppedServerEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameStoppedServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppingEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game stopping event
     */
    public static GameStoppingEvent createGameStoppingEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameStoppingEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppingServerEvent}.
     * 
     * @param game The game
     * @param state The state
     * @return A new game stopping server event
     */
    public static GameStoppingServerEvent createGameStoppingServerEvent(Game game, GameState state) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("state", state);
        return SpongeEventFactoryUtils.createEventImpl(GameStoppingServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.AffectItemStackEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param transactions The transactions
     * @return A new affect item stack event
     */
    public static AffectItemStackEvent createAffectItemStackEvent(Game game, Cause cause, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(AffectItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.AffectSlotEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param transactions The transactions
     * @return A new affect slot event
     */
    public static AffectSlotEvent createAffectSlotEvent(Game game, Cause cause, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(AffectSlotEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new change inventory event
     */
    public static ChangeInventoryEvent createChangeInventoryEvent(Game game, Cause cause, Inventory targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeInventoryEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent.Equipment}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new equipment change inventory event
     */
    public static ChangeInventoryEvent.Equipment createChangeInventoryEventEquipment(Game game, Cause cause, Inventory targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeInventoryEvent.Equipment.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent.Held}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new held change inventory event
     */
    public static ChangeInventoryEvent.Held createChangeInventoryEventHeld(Game game, Cause cause, Inventory targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeInventoryEvent.Held.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent.Pickup}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new pickup change inventory event
     */
    public static ChangeInventoryEvent.Pickup createChangeInventoryEventPickup(Game game, Cause cause, Inventory targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeInventoryEvent.Pickup.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent.Transfer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new transfer change inventory event
     */
    public static ChangeInventoryEvent.Transfer createChangeInventoryEventTransfer(Game game, Cause cause, Inventory targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ChangeInventoryEvent.Transfer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new click inventory event
     */
    public static ClickInventoryEvent createClickInventoryEvent(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Creative}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new creative click inventory event
     */
    public static ClickInventoryEvent.Creative createClickInventoryEventCreative(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Creative.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Double}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new double click inventory event
     */
    public static ClickInventoryEvent.Double createClickInventoryEventDouble(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Double.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drag}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new drag click inventory event
     */
    public static ClickInventoryEvent.Drag createClickInventoryEventDrag(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drag.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drag.Primary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new primary drag click inventory event
     */
    public static ClickInventoryEvent.Drag.Primary createClickInventoryEventDragPrimary(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drag.Primary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drag.Secondary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new secondary drag click inventory event
     */
    public static ClickInventoryEvent.Drag.Secondary createClickInventoryEventDragSecondary(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drag.Secondary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new drop click inventory event
     */
    public static ClickInventoryEvent.Drop createClickInventoryEventDrop(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, List<EntitySnapshot> entitySnapshots, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetInventory", targetInventory);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Full}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new full drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Full createClickInventoryEventDropFull(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, List<EntitySnapshot> entitySnapshots, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetInventory", targetInventory);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drop.Full.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Outside}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new outside drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Outside createClickInventoryEventDropOutside(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, List<EntitySnapshot> entitySnapshots, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetInventory", targetInventory);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drop.Outside.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Outside.Primary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new primary outside drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Outside.Primary createClickInventoryEventDropOutsidePrimary(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, List<EntitySnapshot> entitySnapshots, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetInventory", targetInventory);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drop.Outside.Primary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Outside.Secondary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new secondary outside drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Outside.Secondary createClickInventoryEventDropOutsideSecondary(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, List<EntitySnapshot> entitySnapshots, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetInventory", targetInventory);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drop.Outside.Secondary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Single}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new single drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Single createClickInventoryEventDropSingle(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, List<EntitySnapshot> entitySnapshots, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetInventory", targetInventory);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Drop.Single.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Middle}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new middle click inventory event
     */
    public static ClickInventoryEvent.Middle createClickInventoryEventMiddle(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Middle.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.NumberPress}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @param number The number
     * @return A new number press click inventory event
     */
    public static ClickInventoryEvent.NumberPress createClickInventoryEventNumberPress(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions, int number) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        values.put("number", number);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.NumberPress.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Primary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new primary click inventory event
     */
    public static ClickInventoryEvent.Primary createClickInventoryEventPrimary(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Primary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Secondary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new secondary click inventory event
     */
    public static ClickInventoryEvent.Secondary createClickInventoryEventSecondary(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Secondary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Shift}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new shift click inventory event
     */
    public static ClickInventoryEvent.Shift createClickInventoryEventShift(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Shift.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Shift.Primary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new primary shift click inventory event
     */
    public static ClickInventoryEvent.Shift.Primary createClickInventoryEventShiftPrimary(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Shift.Primary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Shift.Secondary}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new secondary shift click inventory event
     */
    public static ClickInventoryEvent.Shift.Secondary createClickInventoryEventShiftSecondary(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ClickInventoryEvent.Shift.Secondary.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.CreativeInventoryEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new creative inventory event
     */
    public static CreativeInventoryEvent createCreativeInventoryEvent(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(CreativeInventoryEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.CreativeInventoryEvent.Click}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new click creative inventory event
     */
    public static CreativeInventoryEvent.Click createCreativeInventoryEventClick(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(CreativeInventoryEvent.Click.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.CreativeInventoryEvent.Drop}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new drop creative inventory event
     */
    public static CreativeInventoryEvent.Drop createCreativeInventoryEventDrop(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, List<EntitySnapshot> entitySnapshots, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetInventory", targetInventory);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(CreativeInventoryEvent.Drop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @return A new drop item event
     */
    public static DropItemEvent createDropItemEvent(Game game, Cause cause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        return SpongeEventFactoryUtils.createEventImpl(DropItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent.Custom}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new custom drop item event
     */
    public static DropItemEvent.Custom createDropItemEventCustom(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(DropItemEvent.Custom.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent.Destruct}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new destruct drop item event
     */
    public static DropItemEvent.Destruct createDropItemEventDestruct(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(DropItemEvent.Destruct.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent.Dispense}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new dispense drop item event
     */
    public static DropItemEvent.Dispense createDropItemEventDispense(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(DropItemEvent.Dispense.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalDroppedItems The original dropped items
     * @param droppedItems The dropped items
     * @return A new pre drop item event
     */
    public static DropItemEvent.Pre createDropItemEventPre(Game game, Cause cause, List<ItemStackSnapshot> originalDroppedItems, List<ItemStackSnapshot> droppedItems) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalDroppedItems", originalDroppedItems);
        values.put("droppedItems", droppedItems);
        return SpongeEventFactoryUtils.createEventImpl(DropItemEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractInventoryEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @return A new interact inventory event
     */
    public static InteractInventoryEvent createInteractInventoryEvent(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(InteractInventoryEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractInventoryEvent.Close}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @return A new close interact inventory event
     */
    public static InteractInventoryEvent.Close createInteractInventoryEventClose(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(InteractInventoryEvent.Close.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractInventoryEvent.Open}.
     * 
     * @param game The game
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @return A new open interact inventory event
     */
    public static InteractInventoryEvent.Open createInteractInventoryEventOpen(Game game, Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("cursorTransaction", cursorTransaction);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(InteractInventoryEvent.Open.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.TargetContainerEvent}.
     * 
     * @param game The game
     * @param targetInventory The target inventory
     * @return A new target container event
     */
    public static TargetContainerEvent createTargetContainerEvent(Game game, Container targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(TargetContainerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.TargetInventoryEvent}.
     * 
     * @param game The game
     * @param targetInventory The target inventory
     * @return A new target inventory event
     */
    public static TargetInventoryEvent createTargetInventoryEvent(Game game, Inventory targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(TargetInventoryEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new use item stack event
     */
    public static UseItemStackEvent createUseItemStackEvent(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, Transaction<ItemStackSnapshot> itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRemainingDuration", originalRemainingDuration);
        values.put("remainingDuration", remainingDuration);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Finish}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @param itemStackResult The item stack result
     * @return A new finish use item stack event
     */
    public static UseItemStackEvent.Finish createUseItemStackEventFinish(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, Transaction<ItemStackSnapshot> itemStackInUse, Transaction<ItemStackSnapshot> itemStackResult) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRemainingDuration", originalRemainingDuration);
        values.put("remainingDuration", remainingDuration);
        values.put("itemStackInUse", itemStackInUse);
        values.put("itemStackResult", itemStackResult);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Start}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new start use item stack event
     */
    public static UseItemStackEvent.Start createUseItemStackEventStart(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, Transaction<ItemStackSnapshot> itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRemainingDuration", originalRemainingDuration);
        values.put("remainingDuration", remainingDuration);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Start.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Stop}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new stop use item stack event
     */
    public static UseItemStackEvent.Stop createUseItemStackEventStop(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, Transaction<ItemStackSnapshot> itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRemainingDuration", originalRemainingDuration);
        values.put("remainingDuration", remainingDuration);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Stop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Tick}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new tick use item stack event
     */
    public static UseItemStackEvent.Tick createUseItemStackEventTick(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, Transaction<ItemStackSnapshot> itemStackInUse) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRemainingDuration", originalRemainingDuration);
        values.put("remainingDuration", remainingDuration);
        values.put("itemStackInUse", itemStackInUse);
        return SpongeEventFactoryUtils.createEventImpl(UseItemStackEvent.Tick.class, values);
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
     * {@link org.spongepowered.api.event.network.ChannelRegistrationEvent}.
     * 
     * @param cause The cause
     * @param channel The channel
     * @return A new channel registration event
     */
    public static ChannelRegistrationEvent createChannelRegistrationEvent(Cause cause, String channel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("channel", channel);
        return SpongeEventFactoryUtils.createEventImpl(ChannelRegistrationEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ChannelRegistrationEvent.Register}.
     * 
     * @param cause The cause
     * @param channel The channel
     * @return A new register channel registration event
     */
    public static ChannelRegistrationEvent.Register createChannelRegistrationEventRegister(Cause cause, String channel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("channel", channel);
        return SpongeEventFactoryUtils.createEventImpl(ChannelRegistrationEvent.Register.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ChannelRegistrationEvent.Unregister}.
     * 
     * @param cause The cause
     * @param channel The channel
     * @return A new unregister channel registration event
     */
    public static ChannelRegistrationEvent.Unregister createChannelRegistrationEventUnregister(Cause cause, String channel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
        values.put("channel", channel);
        return SpongeEventFactoryUtils.createEventImpl(ChannelRegistrationEvent.Unregister.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent}.
     * 
     * @param game The game
     * @return A new client connection event
     */
    public static ClientConnectionEvent createClientConnectionEvent(Game game) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Auth}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param connection The connection
     * @param profile The profile
     * @return A new auth client connection event
     */
    public static ClientConnectionEvent.Auth createClientConnectionEventAuth(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, RemoteConnection connection, GameProfile profile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
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
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param targetEntity The target entity
     * @return A new disconnect client connection event
     */
    public static ClientConnectionEvent.Disconnect createClientConnectionEventDisconnect(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.Disconnect.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Join}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param targetEntity The target entity
     * @return A new join client connection event
     */
    public static ClientConnectionEvent.Join createClientConnectionEventJoin(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ClientConnectionEvent.Join.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Login}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalMessage The original message
     * @param message The message
     * @param originalSink The original sink
     * @param sink The sink
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param connection The connection
     * @param profile The profile
     * @param targetEntity The target entity
     * @return A new login client connection event
     */
    public static ClientConnectionEvent.Login createClientConnectionEventLogin(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Transform<World> fromTransform, Transform<World> toTransform, RemoteConnection connection, GameProfile profile, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
        values.put("connection", connection);
        values.put("profile", profile);
        values.put("targetEntity", targetEntity);
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
     * {@link org.spongepowered.api.event.network.rcon.RconConnectionEvent}.
     * 
     * @param source The source
     * @return A new rcon connection event
     */
    public static RconConnectionEvent createRconConnectionEvent(RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(RconConnectionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.rcon.RconConnectionEvent.Connect}.
     * 
     * @param source The source
     * @return A new connect rcon connection event
     */
    public static RconConnectionEvent.Connect createRconConnectionEventConnect(RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(RconConnectionEvent.Connect.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.rcon.RconConnectionEvent.Disconnect}.
     * 
     * @param source The source
     * @return A new disconnect rcon connection event
     */
    public static RconConnectionEvent.Disconnect createRconConnectionEventDisconnect(RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(RconConnectionEvent.Disconnect.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.rcon.RconConnectionEvent.Login}.
     * 
     * @param source The source
     * @return A new login rcon connection event
     */
    public static RconConnectionEvent.Login createRconConnectionEventLogin(RconSource source) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("source", source);
        return SpongeEventFactoryUtils.createEventImpl(RconConnectionEvent.Login.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ClientPingServerEvent}.
     * 
     * @param client The client
     * @param response The response
     * @return A new client ping server event
     */
    public static ClientPingServerEvent createClientPingServerEvent(StatusClient client, ClientPingServerEvent.Response response) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("client", client);
        values.put("response", response);
        return SpongeEventFactoryUtils.createEventImpl(ClientPingServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ClientPingServerEvent.Response}.
     * 
     * @param description The description
     * @param favicon The favicon
     * @param players The players
     * @param version The version
     * @return A new response client ping server event
     */
    public static ClientPingServerEvent.Response createClientPingServerEventResponse(Text description, Optional<Favicon> favicon, Optional<ClientPingServerEvent.Response.Players> players, MinecraftVersion version) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("description", description);
        values.put("favicon", favicon);
        values.put("players", players);
        values.put("version", version);
        return SpongeEventFactoryUtils.createEventImpl(ClientPingServerEvent.Response.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ClientPingServerEvent.Response.Players}.
     * 
     * @param profiles The profiles
     * @param max The max
     * @param online The online
     * @return A new players response client ping server event
     */
    public static ClientPingServerEvent.Response.Players createClientPingServerEventResponsePlayers(List<GameProfile> profiles, int max, int online) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("profiles", profiles);
        values.put("max", max);
        values.put("online", online);
        return SpongeEventFactoryUtils.createEventImpl(ClientPingServerEvent.Response.Players.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.QueryServerEvent}.
     * 
     * @return A new query server event
     */
    public static QueryServerEvent createQueryServerEvent() {
        Map<String, Object> values = Maps.newHashMap();
        return SpongeEventFactoryUtils.createEventImpl(QueryServerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.QueryServerEvent.Basic}.
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
    public static QueryServerEvent.Basic createQueryServerEventBasic(InetSocketAddress address, String gameType, String map, String motd, int maxPlayerCount, int maxSize, int playerCount, int size) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("address", address);
        values.put("gameType", gameType);
        values.put("map", map);
        values.put("motd", motd);
        values.put("maxPlayerCount", maxPlayerCount);
        values.put("maxSize", maxSize);
        values.put("playerCount", playerCount);
        values.put("size", size);
        return SpongeEventFactoryUtils.createEventImpl(QueryServerEvent.Basic.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.QueryServerEvent.Full}.
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
    public static QueryServerEvent.Full createQueryServerEventFull(InetSocketAddress address, Map<String, String> customValuesMap, String gameId, String gameType, String map, String motd, List<String> players, String plugins, String version, int maxPlayerCount, int maxSize, int playerCount, int size) {
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
        return SpongeEventFactoryUtils.createEventImpl(QueryServerEvent.Full.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.statistic.ChangeStatisticEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalValue The original value
     * @param value The value
     * @param statistic The statistic
     * @return A new change statistic event
     */
    public static ChangeStatisticEvent createChangeStatisticEvent(Game game, Cause cause, long originalValue, long value, Statistic statistic) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalValue", originalValue);
        values.put("value", value);
        values.put("statistic", statistic);
        return SpongeEventFactoryUtils.createEventImpl(ChangeStatisticEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.statistic.ChangeStatisticEvent.TargetPlayer}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalValue The original value
     * @param value The value
     * @param statistic The statistic
     * @param targetEntity The target entity
     * @return A new target player change statistic event
     */
    public static ChangeStatisticEvent.TargetPlayer createChangeStatisticEventTargetPlayer(Game game, Cause cause, long originalValue, long value, Statistic statistic, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalValue", originalValue);
        values.put("value", value);
        values.put("statistic", statistic);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(ChangeStatisticEvent.TargetPlayer.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.BanUserEvent}.
     * 
     * @param cause The cause
     * @param ban The ban
     * @param targetUser The target user
     * @return A new ban user event
     */
    public static BanUserEvent createBanUserEvent(Cause cause, Ban.User ban, User targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
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
     * @param cause The cause
     * @param ban The ban
     * @param targetEntity The target entity
     * @param targetUser The target user
     * @return A new target player ban user event
     */
    public static BanUserEvent.TargetPlayer createBanUserEventTargetPlayer(Game game, Cause cause, Ban.User ban, Player targetEntity, User targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * @param cause The cause
     * @param ban The ban
     * @param targetUser The target user
     * @return A new pardon user event
     */
    public static PardonUserEvent createPardonUserEvent(Cause cause, Ban.User ban, User targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("cause", cause);
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
     * @param cause The cause
     * @param ban The ban
     * @param targetEntity The target entity
     * @param targetUser The target user
     * @return A new target player pardon user event
     */
    public static PardonUserEvent.TargetPlayer createPardonUserEventTargetPlayer(Game game, Cause cause, Ban.User ban, Player targetEntity, Player targetUser) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * @param cause The cause
     * @param originalValue The original value
     * @param value The value
     * @param name The name
     * @param targetWorld The target world
     * @return A new change world game rule event
     */
    public static ChangeWorldGameRuleEvent createChangeWorldGameRuleEvent(Game game, Cause cause, String originalValue, String value, String name, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * @param originalDuration The original duration
     * @param duration The duration
     * @param originalWeather The original weather
     * @param weather The weather
     * @param initialWeather The initial weather
     * @param targetWorld The target world
     * @return A new change world weather event
     */
    public static ChangeWorldWeatherEvent createChangeWorldWeatherEvent(Game game, Cause cause, int originalDuration, int duration, Weather originalWeather, Weather weather, Weather initialWeather, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalDuration", originalDuration);
        values.put("duration", duration);
        values.put("originalWeather", originalWeather);
        values.put("weather", weather);
        values.put("initialWeather", initialWeather);
        values.put("targetWorld", targetWorld);
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
     * {@link org.spongepowered.api.event.world.ExplosionEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param explosion The explosion
     * @param targetWorld The target world
     * @return A new explosion event
     */
    public static ExplosionEvent createExplosionEvent(Game game, Cause cause, Explosion explosion, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(ExplosionEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ExplosionEvent.Detonate}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param explosion The explosion
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new detonate explosion event
     */
    public static ExplosionEvent.Detonate createExplosionEventDetonate(Game game, Cause cause, List<Entity> entities, List<EntitySnapshot> entitySnapshots, Explosion explosion, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("explosion", explosion);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(ExplosionEvent.Detonate.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ExplosionEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @param explosion The explosion
     * @param targetWorld The target world
     * @return A new post explosion event
     */
    public static ExplosionEvent.Post createExplosionEventPost(Game game, Cause cause, Explosion explosion, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(ExplosionEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ExplosionEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param explosion The explosion
     * @param targetWorld The target world
     * @return A new pre explosion event
     */
    public static ExplosionEvent.Pre createExplosionEventPre(Game game, Cause cause, Explosion explosion, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("explosion", explosion);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(ExplosionEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.GenerateChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new generate chunk event
     */
    public static GenerateChunkEvent createGenerateChunkEvent(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(GenerateChunkEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.GenerateChunkEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new post generate chunk event
     */
    public static GenerateChunkEvent.Post createGenerateChunkEventPost(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(GenerateChunkEvent.Post.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.GenerateChunkEvent.Pre}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new pre generate chunk event
     */
    public static GenerateChunkEvent.Pre createGenerateChunkEventPre(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(GenerateChunkEvent.Pre.class, values);
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
     * {@link org.spongepowered.api.event.world.TargetWorldEvent}.
     * 
     * @param game The game
     * @param targetWorld The target world
     * @return A new target world event
     */
    public static TargetWorldEvent createTargetWorldEvent(Game game, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(TargetWorldEvent.class, values);
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
     * {@link org.spongepowered.api.event.world.chunk.ForcedChunkEvent}.
     * 
     * @param game The game
     * @param chunkCoords The chunk coords
     * @param targetChunk The target chunk
     * @param ticket The ticket
     * @return A new forced chunk event
     */
    public static ForcedChunkEvent createForcedChunkEvent(Game game, Vector3i chunkCoords, Chunk targetChunk, ChunkLoadService.LoadingTicket ticket) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
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
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new populate chunk event
     */
    public static PopulateChunkEvent createPopulateChunkEvent(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * @param targetChunk The target chunk
     * @return A new populate populate chunk event
     */
    public static PopulateChunkEvent.Populate createPopulateChunkEventPopulate(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * @param populatedTransactions The populated transactions
     * @param targetChunk The target chunk
     * @return A new post populate chunk event
     */
    public static PopulateChunkEvent.Post createPopulateChunkEventPost(Game game, Cause cause, Map<PopulatorType, List<Transaction<BlockSnapshot>>> populatedTransactions, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("populatedTransactions", populatedTransactions);
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
     * @param targetChunk The target chunk
     * @return A new pre populate chunk event
     */
    public static PopulateChunkEvent.Pre createPopulateChunkEventPre(Game game, Cause cause, List<Populator> pendingPopulators, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("pendingPopulators", pendingPopulators);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(PopulateChunkEvent.Pre.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.TargetChunkEvent}.
     * 
     * @param game The game
     * @param targetChunk The target chunk
     * @return A new target chunk event
     */
    public static TargetChunkEvent createTargetChunkEvent(Game game, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetChunk", targetChunk);
        return SpongeEventFactoryUtils.createEventImpl(TargetChunkEvent.class, values);
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
}

