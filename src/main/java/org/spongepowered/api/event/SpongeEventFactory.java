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
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.spongepowered.api.Game;
import org.spongepowered.api.GameProfile;
import org.spongepowered.api.MinecraftVersion;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTransaction;
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
import org.spongepowered.api.event.achievement.GrantAchievementEvent;
import org.spongepowered.api.event.action.FishingEvent;
import org.spongepowered.api.event.action.InteractEvent;
import org.spongepowered.api.event.action.LightningEvent;
import org.spongepowered.api.event.action.MessageEvent;
import org.spongepowered.api.event.action.SleepingEvent;
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
import org.spongepowered.api.event.entity.item.AffectItemEvent;
import org.spongepowered.api.event.entity.item.ItemMergeItemEvent;
import org.spongepowered.api.event.entity.item.TargetItemEvent;
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
import org.spongepowered.api.event.game.state.GameStoppedServerEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.event.inventory.AffectItemStackEvent;
import org.spongepowered.api.event.inventory.CraftItemEvent;
import org.spongepowered.api.event.inventory.DropItemStackEvent;
import org.spongepowered.api.event.inventory.InteractInventoryEvent;
import org.spongepowered.api.event.inventory.PickUpItemEvent;
import org.spongepowered.api.event.inventory.TargetContainerEvent;
import org.spongepowered.api.event.inventory.TargetInventoryEvent;
import org.spongepowered.api.event.inventory.UseItemStackEvent;
import org.spongepowered.api.event.network.BanIpEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.network.PardonIpEvent;
import org.spongepowered.api.event.network.rcon.RconConnectionEvent;
import org.spongepowered.api.event.server.ClientPingServerEvent;
import org.spongepowered.api.event.server.channel.RegisterChannelEvent;
import org.spongepowered.api.event.server.channel.TargetChannelEvent;
import org.spongepowered.api.event.server.channel.UnRegisterChannelEvent;
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
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.ItemStackTransaction;
import org.spongepowered.api.item.inventory.Slot;
import org.spongepowered.api.item.inventory.crafting.CraftingInventory;
import org.spongepowered.api.item.recipe.Recipe;
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
     * {@link org.spongepowered.api.event.action.FishingEvent.Finish}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @return A new finish fishing event
     */
    public static FishingEvent.Finish createFishingEventFinish(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalFishHook", originalFishHook);
        values.put("fishHook", fishHook);
        return SpongeEventFactoryUtils.createEventImpl(FishingEvent.Finish.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.FishingEvent.Hook}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param originalHookedEntity The original hooked entity
     * @param hookedEntity The hooked entity
     * @param targetEntity The target entity
     * @return A new hook fishing event
     */
    public static FishingEvent.Hook createFishingEventHook(Game game, Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, EntitySnapshot originalHookedEntity, Optional<Entity> hookedEntity, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * @param originalCaughtEntity The original caught entity
     * @param caughtEntity The caught entity
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param itemStackTransaction The item stack transaction
     * @param targetEntity The target entity
     * @return A new stop fishing event
     */
    public static FishingEvent.Stop createFishingEventStop(Game game, Cause cause, Optional<EntitySnapshot> originalCaughtEntity, Optional<Entity> caughtEntity, int originalExperience, int experience, EntitySnapshot originalFishHook, FishHook fishHook, Optional<ItemStackTransaction> itemStackTransaction, Entity targetEntity) {
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
    public static LightningEvent.Strike createLightningEventStrike(Game game, Cause cause, List<? extends Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld, List<BlockTransaction> transactions) {
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
     * @return A new post sleeping event
     */
    public static SleepingEvent.Post createSleepingEventPost(Game game, Cause cause, BlockSnapshot bed, Optional<Transform<World>> spawnTransform, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("bed", bed);
        values.put("spawnTransform", spawnTransform);
        values.put("targetEntity", targetEntity);
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
     * {@link org.spongepowered.api.event.block.BreakBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new break block event
     */
    public static BreakBlockEvent createBreakBlockEvent(Game game, Cause cause, World targetWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(BreakBlockEvent.class, values);
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
    public static ChangeBlockEvent createChangeBlockEvent(Game game, Cause cause, World targetWorld, List<BlockTransaction> transactions) {
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
     * {@link org.spongepowered.api.event.block.DecayBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new decay block event
     */
    public static DecayBlockEvent createDecayBlockEvent(Game game, Cause cause, World targetWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(DecayBlockEvent.class, values);
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
    public static GrowBlockEvent createGrowBlockEvent(Game game, Cause cause, World targetWorld, List<BlockTransaction> transactions) {
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
     * {@link org.spongepowered.api.event.block.HarvestBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalDropChance The original drop chance
     * @param dropChance The drop chance
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalItemStacks The original item stacks
     * @param itemStacks The item stacks
     * @param targetBlock The target block
     * @param targetEntity The target entity
     * @return A new harvest block event
     */
    public static HarvestBlockEvent createHarvestBlockEvent(Game game, Cause cause, float originalDropChance, float dropChance, int originalExperience, int experience, Collection<ItemStack> originalItemStacks, Collection<ItemStack> itemStacks, BlockSnapshot targetBlock, Entity targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalDropChance", originalDropChance);
        values.put("dropChance", dropChance);
        values.put("originalExperience", originalExperience);
        values.put("experience", experience);
        values.put("originalItemStacks", originalItemStacks);
        values.put("itemStacks", itemStacks);
        values.put("targetBlock", targetBlock);
        values.put("targetEntity", targetEntity);
        return SpongeEventFactoryUtils.createEventImpl(HarvestBlockEvent.class, values);
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
    public static MoveBlockEvent createMoveBlockEvent(Game game, Cause cause, World targetWorld, List<BlockTransaction> transactions) {
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
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent.Spread}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRelatives The original relatives
     * @param relatives The relatives
     * @param spreadingSnapshot The spreading snapshot
     * @return A new spread notify neighbor block event
     */
    public static NotifyNeighborBlockEvent.Spread createNotifyNeighborBlockEventSpread(Game game, Cause cause, Map<Direction, BlockSnapshot> originalRelatives, Map<Direction, Location<World>> relatives, BlockSnapshot spreadingSnapshot) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalRelatives", originalRelatives);
        values.put("relatives", relatives);
        values.put("spreadingSnapshot", spreadingSnapshot);
        return SpongeEventFactoryUtils.createEventImpl(NotifyNeighborBlockEvent.Spread.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.PlaceBlockEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new place block event
     */
    public static PlaceBlockEvent createPlaceBlockEvent(Game game, Cause cause, World targetWorld, List<BlockTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetWorld", targetWorld);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(PlaceBlockEvent.class, values);
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
     * @param targetInventory The target inventory
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new start brewing event
     */
    public static BrewingEvent.Start createBrewingEventStart(Game game, Cause cause, ItemStackSnapshot ingredient, Inventory targetInventory, BrewingStand targetTile, List<ItemStackTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("ingredient", ingredient);
        values.put("targetInventory", targetInventory);
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
     * @param targetInventory The target inventory
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new tick brewing event
     */
    public static BrewingEvent.Tick createBrewingEventTick(Game game, Cause cause, ItemStackSnapshot ingredient, Inventory targetInventory, BrewingStand targetTile, List<ItemStackTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("ingredient", ingredient);
        values.put("targetInventory", targetInventory);
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
     * @param targetInventory The target inventory
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new consume fuel smelt event
     */
    public static SmeltEvent.ConsumeFuel createSmeltEventConsumeFuel(Game game, Cause cause, ItemStackSnapshot fuel, Inventory targetInventory, Furnace targetTile, List<ItemStackTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("targetInventory", targetInventory);
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
     * @param targetInventory The target inventory
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new start smelt event
     */
    public static SmeltEvent.Start createSmeltEventStart(Game game, Cause cause, ItemStackSnapshot fuel, Inventory targetInventory, Furnace targetTile, List<ItemStackTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("targetInventory", targetInventory);
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
     * @param targetInventory The target inventory
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new tick smelt event
     */
    public static SmeltEvent.Tick createSmeltEventTick(Game game, Cause cause, ItemStackSnapshot fuel, Inventory targetInventory, Furnace targetTile, List<ItemStackTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("fuel", fuel);
        values.put("targetInventory", targetInventory);
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
     * @return A new chat message sink event
     */
    public static MessageSinkEvent.Chat createMessageSinkEventChat(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
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
     * @param targetWorld The target world
     * @return A new affect entity event
     */
    public static AffectEntityEvent createAffectEntityEvent(Game game, Cause cause, List<? extends Entity> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
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
    public static ChangeEntityEquipmentEvent createChangeEntityEquipmentEvent(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<ItemStackTransaction> itemStack, Entity targetEntity, Slot targetInventory) {
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
    public static ChangeEntityEquipmentEvent.TargetHuman createChangeEntityEquipmentEventTargetHuman(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<ItemStackTransaction> itemStack, Human targetEntity, Slot targetInventory) {
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
    public static ChangeEntityEquipmentEvent.TargetLiving createChangeEntityEquipmentEventTargetLiving(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<ItemStackTransaction> itemStack, Living targetEntity, Slot targetInventory) {
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
    public static ChangeEntityEquipmentEvent.TargetPlayer createChangeEntityEquipmentEventTargetPlayer(Game game, Optional<ItemStackSnapshot> originalItemStack, Optional<ItemStackTransaction> itemStack, Player targetEntity, Slot targetInventory) {
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
     * {@link org.spongepowered.api.event.entity.item.AffectItemEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new affect item event
     */
    public static AffectItemEvent createAffectItemEvent(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(AffectItemEvent.class, values);
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
    public static ChangeGameModeEvent.TargetHuman createChangeGameModeEventTargetHuman(Game game, Cause cause, GameMode originalGameMode, GameMode gameMode, Human targetEntity) {
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
    public static ChangeLevelEvent.TargetHuman createChangeLevelEventTargetHuman(Game game, Cause cause, int originalLevel, int level, Human targetEntity) {
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
     * {@link org.spongepowered.api.event.inventory.AffectItemStackEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new affect item stack event
     */
    public static AffectItemStackEvent createAffectItemStackEvent(Game game, Cause cause, Inventory targetInventory, List<ItemStackTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(AffectItemStackEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.CraftItemEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param recipe The recipe
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new craft item event
     */
    public static CraftItemEvent createCraftItemEvent(Game game, Cause cause, Recipe recipe, CraftingInventory targetInventory, List<ItemStackTransaction> transactions) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("recipe", recipe);
        values.put("targetInventory", targetInventory);
        values.put("transactions", transactions);
        return SpongeEventFactoryUtils.createEventImpl(CraftItemEvent.class, values);
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
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Drop}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetWorld The target world
     * @return A new drop drop item stack event
     */
    public static DropItemStackEvent.Drop createDropItemStackEventDrop(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Drop.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.DropItemStackEvent.Post}.
     * 
     * @param game The game
     * @param cause The cause
     * @return A new post drop item stack event
     */
    public static DropItemStackEvent.Post createDropItemStackEventPost(Game game, Cause cause) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        return SpongeEventFactoryUtils.createEventImpl(DropItemStackEvent.Post.class, values);
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
     * {@link org.spongepowered.api.event.inventory.InteractInventoryEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @return A new interact inventory event
     */
    public static InteractInventoryEvent createInteractInventoryEvent(Game game, Cause cause, Inventory targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(InteractInventoryEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InteractInventoryEvent.Click}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @return A new click interact inventory event
     */
    public static InteractInventoryEvent.Click createInteractInventoryEventClick(Game game, Cause cause, Inventory targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(InteractInventoryEvent.Click.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InteractInventoryEvent.Close}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @return A new close interact inventory event
     */
    public static InteractInventoryEvent.Close createInteractInventoryEventClose(Game game, Cause cause, Inventory targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(InteractInventoryEvent.Close.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InteractInventoryEvent.Drag}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @return A new drag interact inventory event
     */
    public static InteractInventoryEvent.Drag createInteractInventoryEventDrag(Game game, Cause cause, Inventory targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(InteractInventoryEvent.Drag.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.InteractInventoryEvent.Move}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetInventory The target inventory
     * @return A new move interact inventory event
     */
    public static InteractInventoryEvent.Move createInteractInventoryEventMove(Game game, Cause cause, Inventory targetInventory) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetInventory", targetInventory);
        return SpongeEventFactoryUtils.createEventImpl(InteractInventoryEvent.Move.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.PickUpItemEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param entities The entities
     * @param entitySnapshots The entity snapshots
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @return A new pick up item event
     */
    public static PickUpItemEvent createPickUpItemEvent(Game game, Cause cause, List<Item> entities, List<EntitySnapshot> entitySnapshots, Inventory targetInventory, World targetWorld) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("entities", entities);
        values.put("entitySnapshots", entitySnapshots);
        values.put("targetInventory", targetInventory);
        values.put("targetWorld", targetWorld);
        return SpongeEventFactoryUtils.createEventImpl(PickUpItemEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.TargetContainerEvent}.
     * 
     * @param game The game
     * @param targetContainer The target container
     * @return A new target container event
     */
    public static TargetContainerEvent createTargetContainerEvent(Game game, Container targetContainer) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("targetContainer", targetContainer);
        return SpongeEventFactoryUtils.createEventImpl(TargetContainerEvent.class, values);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.inventory.TargetInventoryEvent}.
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
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new use item stack event
     */
    public static UseItemStackEvent createUseItemStackEvent(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackTransaction itemStackInUse) {
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
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Finish}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @param itemStackResult The item stack result
     * @return A new finish use item stack event
     */
    public static UseItemStackEvent.Finish createUseItemStackEventFinish(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackTransaction itemStackInUse, ItemStackTransaction itemStackResult) {
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
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Start}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new start use item stack event
     */
    public static UseItemStackEvent.Start createUseItemStackEventStart(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackTransaction itemStackInUse) {
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
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Stop}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new stop use item stack event
     */
    public static UseItemStackEvent.Stop createUseItemStackEventStop(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackTransaction itemStackInUse) {
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
     * {@link org.spongepowered.api.event.inventory.UseItemStackEvent.Tick}.
     * 
     * @param game The game
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new tick use item stack event
     */
    public static UseItemStackEvent.Tick createUseItemStackEventTick(Game game, Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackTransaction itemStackInUse) {
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
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new join client connection event
     */
    public static ClientConnectionEvent.Join createClientConnectionEventJoin(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, Transform<World> fromTransform, Transform<World> toTransform, Player targetEntity) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("originalMessage", originalMessage);
        values.put("message", message);
        values.put("originalSink", originalSink);
        values.put("sink", sink);
        values.put("fromTransform", fromTransform);
        values.put("toTransform", toTransform);
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
     * @param connection The connection
     * @param profile The profile
     * @return A new login client connection event
     */
    public static ClientConnectionEvent.Login createClientConnectionEventLogin(Game game, Cause cause, Text originalMessage, Text message, MessageSink originalSink, MessageSink sink, RemoteConnection connection, GameProfile profile) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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
     * {@link org.spongepowered.api.event.server.channel.RegisterChannelEvent}.
     * 
     * @param game The game
     * @param cause The cause
     * @param targetChannel The target channel
     * @return A new register channel event
     */
    public static RegisterChannelEvent createRegisterChannelEvent(Game game, Cause cause, String targetChannel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChannel", targetChannel);
        return SpongeEventFactoryUtils.createEventImpl(RegisterChannelEvent.class, values);
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
     * @param cause The cause
     * @param targetChannel The target channel
     * @return A new un register channel event
     */
    public static UnRegisterChannelEvent createUnRegisterChannelEvent(Game game, Cause cause, String targetChannel) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
        values.put("targetChannel", targetChannel);
        return SpongeEventFactoryUtils.createEventImpl(UnRegisterChannelEvent.class, values);
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
    public static ExplosionEvent.Detonate createExplosionEventDetonate(Game game, Cause cause, List<? extends Entity> entities, List<EntitySnapshot> entitySnapshots, Explosion explosion, World targetWorld, List<BlockTransaction> transactions) {
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
     * @param targetChunk The target chunk
     * @return A new post populate chunk event
     */
    public static PopulateChunkEvent.Post createPopulateChunkEventPost(Game game, Cause cause, Chunk targetChunk) {
        Map<String, Object> values = Maps.newHashMap();
        values.put("game", game);
        values.put("cause", cause);
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

