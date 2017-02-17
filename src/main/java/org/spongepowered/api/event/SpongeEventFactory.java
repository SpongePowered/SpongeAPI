package org.spongepowered.api.event;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Preconditions;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import org.spongepowered.api.GameState;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.tileentity.Sign;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.block.tileentity.carrier.BrewingStand;
import org.spongepowered.api.block.tileentity.carrier.Furnace;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.source.RconSource;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.manipulator.immutable.tileentity.ImmutableSignData;
import org.spongepowered.api.data.manipulator.mutable.tileentity.SignData;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.data.type.SkinPart;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.Transform;
import org.spongepowered.api.entity.ai.Goal;
import org.spongepowered.api.entity.ai.task.AITask;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.entity.explosive.FusedExplosive;
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
import org.spongepowered.api.event.action.CollideEvent;
import org.spongepowered.api.event.action.FishingEvent;
import org.spongepowered.api.event.action.InteractEvent;
import org.spongepowered.api.event.action.LightningEvent;
import org.spongepowered.api.event.action.SleepingEvent;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.block.CollideBlockEvent;
import org.spongepowered.api.event.block.InteractBlockEvent;
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
import org.spongepowered.api.event.command.SendCommandEvent;
import org.spongepowered.api.event.command.TabCompleteEvent;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;
import org.spongepowered.api.event.economy.EconomyTransactionEvent;
import org.spongepowered.api.event.entity.AffectEntityEvent;
import org.spongepowered.api.event.entity.AttackEntityEvent;
import org.spongepowered.api.event.entity.BreedEntityEvent;
import org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent;
import org.spongepowered.api.event.entity.ChangeEntityExperienceEvent;
import org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent;
import org.spongepowered.api.event.entity.CollideEntityEvent;
import org.spongepowered.api.event.entity.ConstructEntityEvent;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.DestructEntityEvent;
import org.spongepowered.api.event.entity.ExpireEntityEvent;
import org.spongepowered.api.event.entity.HarvestEntityEvent;
import org.spongepowered.api.event.entity.HealEntityEvent;
import org.spongepowered.api.event.entity.IgniteEntityEvent;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.event.entity.LeashEntityEvent;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.entity.RideEntityEvent;
import org.spongepowered.api.event.entity.SpawnEntityEvent;
import org.spongepowered.api.event.entity.TameEntityEvent;
import org.spongepowered.api.event.entity.TargetEntityEvent;
import org.spongepowered.api.event.entity.UnleashEntityEvent;
import org.spongepowered.api.event.entity.ai.AITaskEvent;
import org.spongepowered.api.event.entity.explosive.DefuseExplosiveEvent;
import org.spongepowered.api.event.entity.explosive.DetonateExplosiveEvent;
import org.spongepowered.api.event.entity.explosive.PrimeExplosiveEvent;
import org.spongepowered.api.event.entity.explosive.TargetExplosiveEvent;
import org.spongepowered.api.event.entity.explosive.TargetFusedExplosiveEvent;
import org.spongepowered.api.event.entity.item.ItemMergeItemEvent;
import org.spongepowered.api.event.entity.item.TargetItemEvent;
import org.spongepowered.api.event.entity.living.TargetAgentEvent;
import org.spongepowered.api.event.entity.living.TargetLivingEvent;
import org.spongepowered.api.event.entity.living.humanoid.AnimateHandEvent;
import org.spongepowered.api.event.entity.living.humanoid.ChangeGameModeEvent;
import org.spongepowered.api.event.entity.living.humanoid.ChangeLevelEvent;
import org.spongepowered.api.event.entity.living.humanoid.HandInteractEvent;
import org.spongepowered.api.event.entity.living.humanoid.TargetHumanoidEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.KickPlayerEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.PlayerChangeClientSettingsEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.ResourcePackStatusEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent;
import org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent;
import org.spongepowered.api.event.entity.projectile.TargetProjectileEvent;
import org.spongepowered.api.event.game.GameReloadEvent;
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
import org.spongepowered.api.event.item.inventory.DropItemEvent;
import org.spongepowered.api.event.item.inventory.InteractInventoryEvent;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;
import org.spongepowered.api.event.item.inventory.TargetContainerEvent;
import org.spongepowered.api.event.item.inventory.TargetInventoryEvent;
import org.spongepowered.api.event.item.inventory.UseItemStackEvent;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.event.network.BanIpEvent;
import org.spongepowered.api.event.network.ChannelRegistrationEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.event.network.PardonIpEvent;
import org.spongepowered.api.event.network.rcon.RconConnectionEvent;
import org.spongepowered.api.event.server.ClientPingServerEvent;
import org.spongepowered.api.event.server.query.QueryServerEvent;
import org.spongepowered.api.event.service.ChangeServiceProviderEvent;
import org.spongepowered.api.event.statistic.ChangeStatisticEvent;
import org.spongepowered.api.event.user.BanUserEvent;
import org.spongepowered.api.event.user.PardonUserEvent;
import org.spongepowered.api.event.user.TargetUserEvent;
import org.spongepowered.api.event.world.ChangeWorldGameRuleEvent;
import org.spongepowered.api.event.world.ChangeWorldWeatherEvent;
import org.spongepowered.api.event.world.ConstructPortalEvent;
import org.spongepowered.api.event.world.ConstructWorldPropertiesEvent;
import org.spongepowered.api.event.world.ExplosionEvent;
import org.spongepowered.api.event.world.GenerateChunkEvent;
import org.spongepowered.api.event.world.LoadWorldEvent;
import org.spongepowered.api.event.world.SaveWorldEvent;
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
import org.spongepowered.api.network.status.StatusClient;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.resourcepack.ResourcePack;
import org.spongepowered.api.service.ProviderRegistration;
import org.spongepowered.api.service.economy.transaction.TransactionResult;
import org.spongepowered.api.statistic.Statistic;
import org.spongepowered.api.statistic.achievement.Achievement;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.chat.ChatVisibility;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.ban.Ban;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.ChunkTicketManager;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.PortalAgent;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldArchetype;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.weather.Weather;

public class SpongeEventFactory {
    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.achievement.GrantAchievementEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param originalChannel The original channel
     * @param channel The channel
     * @param achievement The achievement
     * @param formatter The formatter
     * @param targetEntity The target entity
     * @param messageCancelled The message cancelled
     * @return A new target player grant achievement event
     */
    public static GrantAchievementEvent.TargetPlayer createGrantAchievementEventTargetPlayer(Cause cause, MessageChannel originalChannel, Optional<MessageChannel> channel, Achievement achievement, MessageEvent.MessageFormatter formatter, Player targetEntity, boolean messageCancelled) {
        return Sponge.getEventFactory().createGrantAchievementEventTargetPlayer(cause, originalChannel, channel, achievement, formatter, targetEntity, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.CollideEvent.Impact}.
     * 
     * @param cause The cause
     * @param impactPoint The impact point
     * @return A new impact collide event
     */
    public static CollideEvent.Impact createCollideEventImpact(Cause cause, Location<World> impactPoint) {
        return Sponge.getEventFactory().createCollideEventImpact(cause, impactPoint);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.FishingEvent.HookEntity}.
     * 
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param targetEntity The target entity
     * @return A new hook entity fishing event
     */
    public static FishingEvent.HookEntity createFishingEventHookEntity(Cause cause, EntitySnapshot originalFishHook, FishHook fishHook, Entity targetEntity) {
        return Sponge.getEventFactory().createFishingEventHookEntity(cause, originalFishHook, fishHook, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.FishingEvent.Start}.
     * 
     * @param cause The cause
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @return A new start fishing event
     */
    public static FishingEvent.Start createFishingEventStart(Cause cause, EntitySnapshot originalFishHook, FishHook fishHook) {
        return Sponge.getEventFactory().createFishingEventStart(cause, originalFishHook, fishHook);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.FishingEvent.Stop}.
     * 
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param originalFishHook The original fish hook
     * @param fishHook The fish hook
     * @param itemStackTransaction The item stack transaction
     * @param targetEntity The target entity
     * @return A new stop fishing event
     */
    public static FishingEvent.Stop createFishingEventStop(Cause cause, int originalExperience, int experience, EntitySnapshot originalFishHook, FishHook fishHook, List<Transaction<ItemStackSnapshot>> itemStackTransaction, Entity targetEntity) {
        return Sponge.getEventFactory().createFishingEventStop(cause, originalExperience, experience, originalFishHook, fishHook, itemStackTransaction, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.InteractEvent}.
     * 
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @return A new interact event
     */
    public static InteractEvent createInteractEvent(Cause cause, Optional<Vector3d> interactionPoint) {
        return Sponge.getEventFactory().createInteractEvent(cause, interactionPoint);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.LightningEvent.Post}.
     * 
     * @param cause The cause
     * @return A new post lightning event
     */
    public static LightningEvent.Post createLightningEventPost(Cause cause) {
        return Sponge.getEventFactory().createLightningEventPost(cause);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.LightningEvent.Pre}.
     * 
     * @param cause The cause
     * @return A new pre lightning event
     */
    public static LightningEvent.Pre createLightningEventPre(Cause cause) {
        return Sponge.getEventFactory().createLightningEventPre(cause);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.LightningEvent.Strike}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new strike lightning event
     */
    public static LightningEvent.Strike createLightningEventStrike(Cause cause, List<Entity> entities, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        return Sponge.getEventFactory().createLightningEventStrike(cause, entities, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent.Finish}.
     * 
     * @param cause The cause
     * @param bed The bed
     * @param targetEntity The target entity
     * @return A new finish sleeping event
     */
    public static SleepingEvent.Finish createSleepingEventFinish(Cause cause, BlockSnapshot bed, Entity targetEntity) {
        return Sponge.getEventFactory().createSleepingEventFinish(cause, bed, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent.Post}.
     * 
     * @param cause The cause
     * @param bed The bed
     * @param spawnTransform The spawn transform
     * @param targetEntity The target entity
     * @param spawnSet The spawn set
     * @return A new post sleeping event
     */
    public static SleepingEvent.Post createSleepingEventPost(Cause cause, BlockSnapshot bed, Optional<Transform<World>> spawnTransform, Entity targetEntity, boolean spawnSet) {
        return Sponge.getEventFactory().createSleepingEventPost(cause, bed, spawnTransform, targetEntity, spawnSet);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent.Pre}.
     * 
     * @param cause The cause
     * @param bed The bed
     * @param targetEntity The target entity
     * @return A new pre sleeping event
     */
    public static SleepingEvent.Pre createSleepingEventPre(Cause cause, BlockSnapshot bed, Entity targetEntity) {
        return Sponge.getEventFactory().createSleepingEventPre(cause, bed, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.action.SleepingEvent.Tick}.
     * 
     * @param cause The cause
     * @param bed The bed
     * @param targetEntity The target entity
     * @return A new tick sleeping event
     */
    public static SleepingEvent.Tick createSleepingEventTick(Cause cause, BlockSnapshot bed, Entity targetEntity) {
        return Sponge.getEventFactory().createSleepingEventTick(cause, bed, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Break}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new break change block event
     */
    public static ChangeBlockEvent.Break createChangeBlockEventBreak(Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        return Sponge.getEventFactory().createChangeBlockEventBreak(cause, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Decay}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new decay change block event
     */
    public static ChangeBlockEvent.Decay createChangeBlockEventDecay(Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        return Sponge.getEventFactory().createChangeBlockEventDecay(cause, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Grow}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new grow change block event
     */
    public static ChangeBlockEvent.Grow createChangeBlockEventGrow(Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        return Sponge.getEventFactory().createChangeBlockEventGrow(cause, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Modify}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new modify change block event
     */
    public static ChangeBlockEvent.Modify createChangeBlockEventModify(Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        return Sponge.getEventFactory().createChangeBlockEventModify(cause, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Place}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new place change block event
     */
    public static ChangeBlockEvent.Place createChangeBlockEventPlace(Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        return Sponge.getEventFactory().createChangeBlockEventPlace(cause, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new post change block event
     */
    public static ChangeBlockEvent.Post createChangeBlockEventPost(Cause cause, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        return Sponge.getEventFactory().createChangeBlockEventPost(cause, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.ChangeBlockEvent.Pre}.
     * 
     * @param cause The cause
     * @param locations The locations
     * @param targetWorld The target world
     * @return A new pre change block event
     */
    public static ChangeBlockEvent.Pre createChangeBlockEventPre(Cause cause, List<Location<World>> locations, World targetWorld) {
        return Sponge.getEventFactory().createChangeBlockEventPre(cause, locations, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent}.
     * 
     * @param cause The cause
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new collide block event
     */
    public static CollideBlockEvent createCollideBlockEvent(Cause cause, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        return Sponge.getEventFactory().createCollideBlockEvent(cause, targetBlock, targetLocation, targetSide);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.CollideBlockEvent.Impact}.
     * 
     * @param cause The cause
     * @param impactPoint The impact point
     * @param targetBlock The target block
     * @param targetLocation The target location
     * @param targetSide The target side
     * @return A new impact collide block event
     */
    public static CollideBlockEvent.Impact createCollideBlockEventImpact(Cause cause, Location<World> impactPoint, BlockState targetBlock, Location<World> targetLocation, Direction targetSide) {
        return Sponge.getEventFactory().createCollideBlockEventImpact(cause, impactPoint, targetBlock, targetLocation, targetSide);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Primary.MainHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @return A new main hand primary interact block event
     */
    public static InteractBlockEvent.Primary.MainHand createInteractBlockEventPrimaryMainHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Direction targetSide) {
        return Sponge.getEventFactory().createInteractBlockEventPrimaryMainHand(cause, handType, interactionPoint, targetBlock, targetSide);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Primary.OffHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @return A new off hand primary interact block event
     */
    public static InteractBlockEvent.Primary.OffHand createInteractBlockEventPrimaryOffHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Direction targetSide) {
        return Sponge.getEventFactory().createInteractBlockEventPrimaryOffHand(cause, handType, interactionPoint, targetBlock, targetSide);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Secondary.MainHand}.
     * 
     * @param cause The cause
     * @param originalUseBlockResult The original use block result
     * @param useBlockResult The use block result
     * @param originalUseItemResult The original use item result
     * @param useItemResult The use item result
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @return A new main hand secondary interact block event
     */
    public static InteractBlockEvent.Secondary.MainHand createInteractBlockEventSecondaryMainHand(Cause cause, Tristate originalUseBlockResult, Tristate useBlockResult, Tristate originalUseItemResult, Tristate useItemResult, HandType handType, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Direction targetSide) {
        return Sponge.getEventFactory().createInteractBlockEventSecondaryMainHand(cause, originalUseBlockResult, useBlockResult, originalUseItemResult, useItemResult, handType, interactionPoint, targetBlock, targetSide);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.InteractBlockEvent.Secondary.OffHand}.
     * 
     * @param cause The cause
     * @param originalUseBlockResult The original use block result
     * @param useBlockResult The use block result
     * @param originalUseItemResult The original use item result
     * @param useItemResult The use item result
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param targetBlock The target block
     * @param targetSide The target side
     * @return A new off hand secondary interact block event
     */
    public static InteractBlockEvent.Secondary.OffHand createInteractBlockEventSecondaryOffHand(Cause cause, Tristate originalUseBlockResult, Tristate useBlockResult, Tristate originalUseItemResult, Tristate useItemResult, HandType handType, Optional<Vector3d> interactionPoint, BlockSnapshot targetBlock, Direction targetSide) {
        return Sponge.getEventFactory().createInteractBlockEventSecondaryOffHand(cause, originalUseBlockResult, useBlockResult, originalUseItemResult, useItemResult, handType, interactionPoint, targetBlock, targetSide);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.NotifyNeighborBlockEvent}.
     * 
     * @param cause The cause
     * @param originalNeighbors The original neighbors
     * @param neighbors The neighbors
     * @return A new notify neighbor block event
     */
    public static NotifyNeighborBlockEvent createNotifyNeighborBlockEvent(Cause cause, Map<Direction, BlockState> originalNeighbors, Map<Direction, BlockState> neighbors) {
        return Sponge.getEventFactory().createNotifyNeighborBlockEvent(cause, originalNeighbors, neighbors);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.TargetBlockEvent}.
     * 
     * @param cause The cause
     * @param targetBlock The target block
     * @return A new target block event
     */
    public static TargetBlockEvent createTargetBlockEvent(Cause cause, BlockSnapshot targetBlock) {
        return Sponge.getEventFactory().createTargetBlockEvent(cause, targetBlock);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.TickBlockEvent.Random}.
     * 
     * @param cause The cause
     * @param targetBlock The target block
     * @return A new random tick block event
     */
    public static TickBlockEvent.Random createTickBlockEventRandom(Cause cause, BlockSnapshot targetBlock) {
        return Sponge.getEventFactory().createTickBlockEventRandom(cause, targetBlock);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.TickBlockEvent.Scheduled}.
     * 
     * @param cause The cause
     * @param targetBlock The target block
     * @return A new scheduled tick block event
     */
    public static TickBlockEvent.Scheduled createTickBlockEventScheduled(Cause cause, BlockSnapshot targetBlock) {
        return Sponge.getEventFactory().createTickBlockEventScheduled(cause, targetBlock);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent.Finish}.
     * 
     * @param cause The cause
     * @param brewedItemStacks The brewed item stacks
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @return A new finish brewing event
     */
    public static BrewingEvent.Finish createBrewingEventFinish(Cause cause, List<ItemStackSnapshot> brewedItemStacks, ItemStackSnapshot ingredient, BrewingStand targetTile) {
        return Sponge.getEventFactory().createBrewingEventFinish(cause, brewedItemStacks, ingredient, targetTile);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent.Interrupt}.
     * 
     * @param cause The cause
     * @param brewedItemStacks The brewed item stacks
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @return A new interrupt brewing event
     */
    public static BrewingEvent.Interrupt createBrewingEventInterrupt(Cause cause, List<ItemStackSnapshot> brewedItemStacks, ItemStackSnapshot ingredient, BrewingStand targetTile) {
        return Sponge.getEventFactory().createBrewingEventInterrupt(cause, brewedItemStacks, ingredient, targetTile);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent.Start}.
     * 
     * @param cause The cause
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new start brewing event
     */
    public static BrewingEvent.Start createBrewingEventStart(Cause cause, ItemStackSnapshot ingredient, BrewingStand targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        return Sponge.getEventFactory().createBrewingEventStart(cause, ingredient, targetTile, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.BrewingEvent.Tick}.
     * 
     * @param cause The cause
     * @param ingredient The ingredient
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new tick brewing event
     */
    public static BrewingEvent.Tick createBrewingEventTick(Cause cause, ItemStackSnapshot ingredient, BrewingStand targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        return Sponge.getEventFactory().createBrewingEventTick(cause, ingredient, targetTile, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.ChangeSignEvent}.
     * 
     * @param cause The cause
     * @param originalText The original text
     * @param text The text
     * @param targetTile The target tile
     * @return A new change sign event
     */
    public static ChangeSignEvent createChangeSignEvent(Cause cause, ImmutableSignData originalText, SignData text, Sign targetTile) {
        return Sponge.getEventFactory().createChangeSignEvent(cause, originalText, text, targetTile);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.ConsumeFuel}.
     * 
     * @param cause The cause
     * @param fuel The fuel
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new consume fuel smelt event
     */
    public static SmeltEvent.ConsumeFuel createSmeltEventConsumeFuel(Cause cause, ItemStackSnapshot fuel, Furnace targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        return Sponge.getEventFactory().createSmeltEventConsumeFuel(cause, fuel, targetTile, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.Finish}.
     * 
     * @param cause The cause
     * @param fuel The fuel
     * @param smeltedItems The smelted items
     * @param targetTile The target tile
     * @return A new finish smelt event
     */
    public static SmeltEvent.Finish createSmeltEventFinish(Cause cause, ItemStackSnapshot fuel, List<ItemStackSnapshot> smeltedItems, Furnace targetTile) {
        return Sponge.getEventFactory().createSmeltEventFinish(cause, fuel, smeltedItems, targetTile);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.Interrupt}.
     * 
     * @param cause The cause
     * @param fuel The fuel
     * @param smeltedItems The smelted items
     * @param targetTile The target tile
     * @return A new interrupt smelt event
     */
    public static SmeltEvent.Interrupt createSmeltEventInterrupt(Cause cause, ItemStackSnapshot fuel, List<ItemStackSnapshot> smeltedItems, Furnace targetTile) {
        return Sponge.getEventFactory().createSmeltEventInterrupt(cause, fuel, smeltedItems, targetTile);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.Start}.
     * 
     * @param cause The cause
     * @param fuel The fuel
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new start smelt event
     */
    public static SmeltEvent.Start createSmeltEventStart(Cause cause, ItemStackSnapshot fuel, Furnace targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        return Sponge.getEventFactory().createSmeltEventStart(cause, fuel, targetTile, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.SmeltEvent.Tick}.
     * 
     * @param cause The cause
     * @param fuel The fuel
     * @param targetTile The target tile
     * @param transactions The transactions
     * @return A new tick smelt event
     */
    public static SmeltEvent.Tick createSmeltEventTick(Cause cause, ItemStackSnapshot fuel, Furnace targetTile, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        return Sponge.getEventFactory().createSmeltEventTick(cause, fuel, targetTile, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.block.tileentity.TargetTileEntityEvent}.
     * 
     * @param cause The cause
     * @param targetTile The target tile
     * @return A new target tile entity event
     */
    public static TargetTileEntityEvent createTargetTileEntityEvent(Cause cause, TileEntity targetTile) {
        return Sponge.getEventFactory().createTargetTileEntityEvent(cause, targetTile);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.SendCommandEvent}.
     * 
     * @param cause The cause
     * @param arguments The arguments
     * @param command The command
     * @param result The result
     * @return A new send command event
     */
    public static SendCommandEvent createSendCommandEvent(Cause cause, String arguments, String command, CommandResult result) {
        return Sponge.getEventFactory().createSendCommandEvent(cause, arguments, command, result);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.TabCompleteEvent.Chat}.
     * 
     * @param cause The cause
     * @param originalTabCompletions The original tab completions
     * @param tabCompletions The tab completions
     * @param rawMessage The raw message
     * @param targetPos The target pos
     * @param usingBlock The using block
     * @return A new chat tab complete event
     */
    public static TabCompleteEvent.Chat createTabCompleteEventChat(Cause cause, List<String> originalTabCompletions, List<String> tabCompletions, String rawMessage, Optional<Location<World>> targetPos, boolean usingBlock) {
        return Sponge.getEventFactory().createTabCompleteEventChat(cause, originalTabCompletions, tabCompletions, rawMessage, targetPos, usingBlock);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.command.TabCompleteEvent.Command}.
     * 
     * @param cause The cause
     * @param originalTabCompletions The original tab completions
     * @param tabCompletions The tab completions
     * @param arguments The arguments
     * @param command The command
     * @param rawMessage The raw message
     * @param targetPos The target pos
     * @param usingBlock The using block
     * @return A new command tab complete event
     */
    public static TabCompleteEvent.Command createTabCompleteEventCommand(Cause cause, List<String> originalTabCompletions, List<String> tabCompletions, String arguments, String command, String rawMessage, Optional<Location<World>> targetPos, boolean usingBlock) {
        return Sponge.getEventFactory().createTabCompleteEventCommand(cause, originalTabCompletions, tabCompletions, arguments, command, rawMessage, targetPos, usingBlock);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange}.
     * 
     * @param cause The cause
     * @param originalChanges The original changes
     * @param targetHolder The target holder
     * @return A new value change change data holder event
     */
    public static ChangeDataHolderEvent.ValueChange createChangeDataHolderEventValueChange(Cause cause, DataTransactionResult originalChanges, DataHolder targetHolder) {
        return Sponge.getEventFactory().createChangeDataHolderEventValueChange(cause, originalChanges, targetHolder);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.economy.EconomyTransactionEvent}.
     * 
     * @param cause The cause
     * @param transactionResult The transaction result
     * @return A new economy transaction event
     */
    public static EconomyTransactionEvent createEconomyTransactionEvent(Cause cause, TransactionResult transactionResult) {
        return Sponge.getEventFactory().createEconomyTransactionEvent(cause, transactionResult);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AffectEntityEvent}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new affect entity event
     */
    public static AffectEntityEvent createAffectEntityEvent(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createAffectEntityEvent(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.AttackEntityEvent}.
     * 
     * @param cause The cause
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param knockbackModifier The knockback modifier
     * @param originalDamage The original damage
     * @return A new attack entity event
     */
    public static AttackEntityEvent createAttackEntityEvent(Cause cause, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity, int knockbackModifier, double originalDamage) {
        return Sponge.getEventFactory().createAttackEntityEvent(cause, originalFunctions, targetEntity, knockbackModifier, originalDamage);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent.Breed}.
     * 
     * @param cause The cause
     * @param interactionPoint The interaction point
     * @param offspringEntity The offspring entity
     * @param targetEntity The target entity
     * @return A new breed breed entity event
     */
    public static BreedEntityEvent.Breed createBreedEntityEventBreed(Cause cause, Optional<Vector3d> interactionPoint, Ageable offspringEntity, Entity targetEntity) {
        return Sponge.getEventFactory().createBreedEntityEventBreed(cause, interactionPoint, offspringEntity, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.BreedEntityEvent.FindMate}.
     * 
     * @param cause The cause
     * @param originalResult The original result
     * @param result The result
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @param hasAllowResult The has allow result
     * @return A new find mate breed entity event
     */
    public static BreedEntityEvent.FindMate createBreedEntityEventFindMate(Cause cause, TristateResult.Result originalResult, TristateResult.Result result, Optional<Vector3d> interactionPoint, Entity targetEntity, boolean hasAllowResult) {
        return Sponge.getEventFactory().createBreedEntityEventFindMate(cause, originalResult, result, interactionPoint, targetEntity, hasAllowResult);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent}.
     * 
     * @param cause The cause
     * @param originalItemStack The original item stack
     * @param itemStack The item stack
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @return A new change entity equipment event
     */
    public static ChangeEntityEquipmentEvent createChangeEntityEquipmentEvent(Cause cause, Optional<ItemStackSnapshot> originalItemStack, Optional<Transaction<ItemStackSnapshot>> itemStack, Entity targetEntity, Slot targetInventory) {
        return Sponge.getEventFactory().createChangeEntityEquipmentEvent(cause, originalItemStack, itemStack, targetEntity, targetInventory);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetHumanoid}.
     * 
     * @param cause The cause
     * @param originalItemStack The original item stack
     * @param itemStack The item stack
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @return A new target humanoid change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetHumanoid createChangeEntityEquipmentEventTargetHumanoid(Cause cause, Optional<ItemStackSnapshot> originalItemStack, Optional<Transaction<ItemStackSnapshot>> itemStack, Humanoid targetEntity, Slot targetInventory) {
        return Sponge.getEventFactory().createChangeEntityEquipmentEventTargetHumanoid(cause, originalItemStack, itemStack, targetEntity, targetInventory);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetLiving}.
     * 
     * @param cause The cause
     * @param originalItemStack The original item stack
     * @param itemStack The item stack
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @return A new target living change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetLiving createChangeEntityEquipmentEventTargetLiving(Cause cause, Optional<ItemStackSnapshot> originalItemStack, Optional<Transaction<ItemStackSnapshot>> itemStack, Living targetEntity, Slot targetInventory) {
        return Sponge.getEventFactory().createChangeEntityEquipmentEventTargetLiving(cause, originalItemStack, itemStack, targetEntity, targetInventory);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityEquipmentEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param originalItemStack The original item stack
     * @param itemStack The item stack
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @return A new target player change entity equipment event
     */
    public static ChangeEntityEquipmentEvent.TargetPlayer createChangeEntityEquipmentEventTargetPlayer(Cause cause, Optional<ItemStackSnapshot> originalItemStack, Optional<Transaction<ItemStackSnapshot>> itemStack, Player targetEntity, Slot targetInventory) {
        return Sponge.getEventFactory().createChangeEntityEquipmentEventTargetPlayer(cause, originalItemStack, itemStack, targetEntity, targetInventory);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityExperienceEvent}.
     * 
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @return A new change entity experience event
     */
    public static ChangeEntityExperienceEvent createChangeEntityExperienceEvent(Cause cause, int originalExperience, int experience, Entity targetEntity) {
        return Sponge.getEventFactory().createChangeEntityExperienceEvent(cause, originalExperience, experience, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Expire}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new expire change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Expire createChangeEntityPotionEffectEventExpire(Cause cause, List<PotionEffect> currentEffects, PotionEffect potionEffect, Entity targetEntity) {
        return Sponge.getEventFactory().createChangeEntityPotionEffectEventExpire(cause, currentEffects, potionEffect, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Gain}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new gain change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Gain createChangeEntityPotionEffectEventGain(Cause cause, List<PotionEffect> currentEffects, PotionEffect potionEffect, Entity targetEntity) {
        return Sponge.getEventFactory().createChangeEntityPotionEffectEventGain(cause, currentEffects, potionEffect, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ChangeEntityPotionEffectEvent.Remove}.
     * 
     * @param cause The cause
     * @param currentEffects The current effects
     * @param potionEffect The potion effect
     * @param targetEntity The target entity
     * @return A new remove change entity potion effect event
     */
    public static ChangeEntityPotionEffectEvent.Remove createChangeEntityPotionEffectEventRemove(Cause cause, List<PotionEffect> currentEffects, PotionEffect potionEffect, Entity targetEntity) {
        return Sponge.getEventFactory().createChangeEntityPotionEffectEventRemove(cause, currentEffects, potionEffect, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new collide entity event
     */
    public static CollideEntityEvent createCollideEntityEvent(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createCollideEntityEvent(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.CollideEntityEvent.Impact}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param impactPoint The impact point
     * @param targetWorld The target world
     * @return A new impact collide entity event
     */
    public static CollideEntityEvent.Impact createCollideEntityEventImpact(Cause cause, List<Entity> entities, Location<World> impactPoint, World targetWorld) {
        return Sponge.getEventFactory().createCollideEntityEventImpact(cause, entities, impactPoint, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ConstructEntityEvent.Post}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @param targetType The target type
     * @param transform The transform
     * @return A new post construct entity event
     */
    public static ConstructEntityEvent.Post createConstructEntityEventPost(Cause cause, Entity targetEntity, EntityType targetType, Transform<World> transform) {
        return Sponge.getEventFactory().createConstructEntityEventPost(cause, targetEntity, targetType, transform);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ConstructEntityEvent.Pre}.
     * 
     * @param cause The cause
     * @param targetType The target type
     * @param transform The transform
     * @return A new pre construct entity event
     */
    public static ConstructEntityEvent.Pre createConstructEntityEventPre(Cause cause, EntityType targetType, Transform<World> transform) {
        return Sponge.getEventFactory().createConstructEntityEventPre(cause, targetType, transform);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DamageEntityEvent}.
     * 
     * @param cause The cause
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param originalDamage The original damage
     * @return A new damage entity event
     */
    public static DamageEntityEvent createDamageEntityEvent(Cause cause, List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity, double originalDamage) {
        return Sponge.getEventFactory().createDamageEntityEvent(cause, originalFunctions, targetEntity, originalDamage);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DestructEntityEvent}.
     * 
     * @param cause The cause
     * @param originalChannel The original channel
     * @param channel The channel
     * @param formatter The formatter
     * @param targetEntity The target entity
     * @param messageCancelled The message cancelled
     * @return A new destruct entity event
     */
    public static DestructEntityEvent createDestructEntityEvent(Cause cause, MessageChannel originalChannel, Optional<MessageChannel> channel, MessageEvent.MessageFormatter formatter, Entity targetEntity, boolean messageCancelled) {
        return Sponge.getEventFactory().createDestructEntityEvent(cause, originalChannel, channel, formatter, targetEntity, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.DestructEntityEvent.Death}.
     * 
     * @param cause The cause
     * @param originalChannel The original channel
     * @param channel The channel
     * @param formatter The formatter
     * @param targetEntity The target entity
     * @param messageCancelled The message cancelled
     * @return A new death destruct entity event
     */
    public static DestructEntityEvent.Death createDestructEntityEventDeath(Cause cause, MessageChannel originalChannel, Optional<MessageChannel> channel, MessageEvent.MessageFormatter formatter, Living targetEntity, boolean messageCancelled) {
        return Sponge.getEventFactory().createDestructEntityEventDeath(cause, originalChannel, channel, formatter, targetEntity, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ExpireEntityEvent.TargetItem}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target item expire entity event
     */
    public static ExpireEntityEvent.TargetItem createExpireEntityEventTargetItem(Cause cause, Item targetEntity) {
        return Sponge.getEventFactory().createExpireEntityEventTargetItem(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetHumanoid}.
     * 
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @return A new target humanoid harvest entity event
     */
    public static HarvestEntityEvent.TargetHumanoid createHarvestEntityEventTargetHumanoid(Cause cause, int originalExperience, int experience, Humanoid targetEntity) {
        return Sponge.getEventFactory().createHarvestEntityEventTargetHumanoid(cause, originalExperience, experience, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetLiving}.
     * 
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @return A new target living harvest entity event
     */
    public static HarvestEntityEvent.TargetLiving createHarvestEntityEventTargetLiving(Cause cause, int originalExperience, int experience, Living targetEntity) {
        return Sponge.getEventFactory().createHarvestEntityEventTargetLiving(cause, originalExperience, experience, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HarvestEntityEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param originalExperience The original experience
     * @param experience The experience
     * @param targetEntity The target entity
     * @param keepsInventory The keeps inventory
     * @param keepsLevel The keeps level
     * @param level The level
     * @return A new target player harvest entity event
     */
    public static HarvestEntityEvent.TargetPlayer createHarvestEntityEventTargetPlayer(Cause cause, int originalExperience, int experience, Player targetEntity, boolean keepsInventory, boolean keepsLevel, int level) {
        return Sponge.getEventFactory().createHarvestEntityEventTargetPlayer(cause, originalExperience, experience, targetEntity, keepsInventory, keepsLevel, level);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.HealEntityEvent}.
     * 
     * @param cause The cause
     * @param originalFunctions The original functions
     * @param targetEntity The target entity
     * @param originalHealAmount The original heal amount
     * @return A new heal entity event
     */
    public static HealEntityEvent createHealEntityEvent(Cause cause, List<Tuple<HealthModifier, Function<? super Double, Double>>> originalFunctions, Entity targetEntity, double originalHealAmount) {
        return Sponge.getEventFactory().createHealEntityEvent(cause, originalFunctions, targetEntity, originalHealAmount);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.IgniteEntityEvent}.
     * 
     * @param cause The cause
     * @param originalFireTicks The original fire ticks
     * @param fireTicks The fire ticks
     * @param targetEntity The target entity
     * @return A new ignite entity event
     */
    public static IgniteEntityEvent createIgniteEntityEvent(Cause cause, int originalFireTicks, int fireTicks, Entity targetEntity) {
        return Sponge.getEventFactory().createIgniteEntityEvent(cause, originalFireTicks, fireTicks, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Primary.MainHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new main hand primary interact entity event
     */
    public static InteractEntityEvent.Primary.MainHand createInteractEntityEventPrimaryMainHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        return Sponge.getEventFactory().createInteractEntityEventPrimaryMainHand(cause, handType, interactionPoint, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Primary.OffHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new off hand primary interact entity event
     */
    public static InteractEntityEvent.Primary.OffHand createInteractEntityEventPrimaryOffHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        return Sponge.getEventFactory().createInteractEntityEventPrimaryOffHand(cause, handType, interactionPoint, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Secondary.MainHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new main hand secondary interact entity event
     */
    public static InteractEntityEvent.Secondary.MainHand createInteractEntityEventSecondaryMainHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        return Sponge.getEventFactory().createInteractEntityEventSecondaryMainHand(cause, handType, interactionPoint, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.InteractEntityEvent.Secondary.OffHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param targetEntity The target entity
     * @return A new off hand secondary interact entity event
     */
    public static InteractEntityEvent.Secondary.OffHand createInteractEntityEventSecondaryOffHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, Entity targetEntity) {
        return Sponge.getEventFactory().createInteractEntityEventSecondaryOffHand(cause, handType, interactionPoint, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.LeashEntityEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new leash entity event
     */
    public static LeashEntityEvent createLeashEntityEvent(Cause cause, Entity targetEntity) {
        return Sponge.getEventFactory().createLeashEntityEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MoveEntityEvent}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new move entity event
     */
    public static MoveEntityEvent createMoveEntityEvent(Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Entity targetEntity) {
        return Sponge.getEventFactory().createMoveEntityEvent(cause, fromTransform, toTransform, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MoveEntityEvent.Teleport}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param targetEntity The target entity
     * @return A new teleport move entity event
     */
    public static MoveEntityEvent.Teleport createMoveEntityEventTeleport(Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Entity targetEntity) {
        return Sponge.getEventFactory().createMoveEntityEventTeleport(cause, fromTransform, toTransform, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.MoveEntityEvent.Teleport.Portal}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param portalAgent The portal agent
     * @param targetEntity The target entity
     * @param usePortalAgent The use portal agent
     * @return A new portal teleport move entity event
     */
    public static MoveEntityEvent.Teleport.Portal createMoveEntityEventTeleportPortal(Cause cause, Transform<World> fromTransform, Transform<World> toTransform, PortalAgent portalAgent, Entity targetEntity, boolean usePortalAgent) {
        return Sponge.getEventFactory().createMoveEntityEventTeleportPortal(cause, fromTransform, toTransform, portalAgent, targetEntity, usePortalAgent);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.RideEntityEvent.Dismount}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new dismount ride entity event
     */
    public static RideEntityEvent.Dismount createRideEntityEventDismount(Cause cause, Entity targetEntity) {
        return Sponge.getEventFactory().createRideEntityEventDismount(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.RideEntityEvent.Mount}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new mount ride entity event
     */
    public static RideEntityEvent.Mount createRideEntityEventMount(Cause cause, Entity targetEntity) {
        return Sponge.getEventFactory().createRideEntityEventMount(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new spawn entity event
     */
    public static SpawnEntityEvent createSpawnEntityEvent(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createSpawnEntityEvent(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.ChunkLoad}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new chunk load spawn entity event
     */
    public static SpawnEntityEvent.ChunkLoad createSpawnEntityEventChunkLoad(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createSpawnEntityEventChunkLoad(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.Custom}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new custom spawn entity event
     */
    public static SpawnEntityEvent.Custom createSpawnEntityEventCustom(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createSpawnEntityEventCustom(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.SpawnEntityEvent.Spawner}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new spawner spawn entity event
     */
    public static SpawnEntityEvent.Spawner createSpawnEntityEventSpawner(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createSpawnEntityEventSpawner(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TameEntityEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new tame entity event
     */
    public static TameEntityEvent createTameEntityEvent(Cause cause, Entity targetEntity) {
        return Sponge.getEventFactory().createTameEntityEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.TargetEntityEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target entity event
     */
    public static TargetEntityEvent createTargetEntityEvent(Cause cause, Entity targetEntity) {
        return Sponge.getEventFactory().createTargetEntityEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.UnleashEntityEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new unleash entity event
     */
    public static UnleashEntityEvent createUnleashEntityEvent(Cause cause, Entity targetEntity) {
        return Sponge.getEventFactory().createUnleashEntityEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ai.AITaskEvent.Add}.
     * 
     * @param cause The cause
     * @param originalPriority The original priority
     * @param priority The priority
     * @param goal The goal
     * @param targetEntity The target entity
     * @param task The task
     * @return A new add a i task event
     */
    public static AITaskEvent.Add createAITaskEventAdd(Cause cause, int originalPriority, int priority, Goal<? extends Agent> goal, Agent targetEntity, AITask<? extends Agent> task) {
        Preconditions.checkArgument(((goal.getOwner()) == targetEntity), String.format("The target entity \'%s\' is not the owner of the goal \'%s\'!", goal, targetEntity));
        return Sponge.getEventFactory().createAITaskEventAdd(cause, originalPriority, priority, goal, targetEntity, task);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.ai.AITaskEvent.Remove}.
     * 
     * @param cause The cause
     * @param goal The goal
     * @param targetEntity The target entity
     * @param task The task
     * @param priority The priority
     * @return A new remove a i task event
     */
    public static AITaskEvent.Remove createAITaskEventRemove(Cause cause, Goal<? extends Agent> goal, Agent targetEntity, AITask<? extends Agent> task, int priority) {
        Preconditions.checkArgument(((goal.getOwner()) == targetEntity), String.format("The target entity \'%s\' is not the owner of the goal \'%s\'!", goal, targetEntity));
        return Sponge.getEventFactory().createAITaskEventRemove(cause, goal, targetEntity, task, priority);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.explosive.DefuseExplosiveEvent.Post}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new post defuse explosive event
     */
    public static DefuseExplosiveEvent.Post createDefuseExplosiveEventPost(Cause cause, FusedExplosive targetEntity) {
        return Sponge.getEventFactory().createDefuseExplosiveEventPost(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.explosive.DefuseExplosiveEvent.Pre}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new pre defuse explosive event
     */
    public static DefuseExplosiveEvent.Pre createDefuseExplosiveEventPre(Cause cause, FusedExplosive targetEntity) {
        return Sponge.getEventFactory().createDefuseExplosiveEventPre(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.explosive.DetonateExplosiveEvent}.
     * 
     * @param cause The cause
     * @param explosionBuilder The explosion builder
     * @param originalExplosion The original explosion
     * @param targetEntity The target entity
     * @return A new detonate explosive event
     */
    public static DetonateExplosiveEvent createDetonateExplosiveEvent(Cause cause, Explosion.Builder explosionBuilder, Explosion originalExplosion, Explosive targetEntity) {
        return Sponge.getEventFactory().createDetonateExplosiveEvent(cause, explosionBuilder, originalExplosion, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.explosive.PrimeExplosiveEvent.Post}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new post prime explosive event
     */
    public static PrimeExplosiveEvent.Post createPrimeExplosiveEventPost(Cause cause, FusedExplosive targetEntity) {
        return Sponge.getEventFactory().createPrimeExplosiveEventPost(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.explosive.PrimeExplosiveEvent.Pre}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new pre prime explosive event
     */
    public static PrimeExplosiveEvent.Pre createPrimeExplosiveEventPre(Cause cause, FusedExplosive targetEntity) {
        return Sponge.getEventFactory().createPrimeExplosiveEventPre(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.explosive.TargetExplosiveEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target explosive event
     */
    public static TargetExplosiveEvent createTargetExplosiveEvent(Cause cause, Explosive targetEntity) {
        return Sponge.getEventFactory().createTargetExplosiveEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.explosive.TargetFusedExplosiveEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target fused explosive event
     */
    public static TargetFusedExplosiveEvent createTargetFusedExplosiveEvent(Cause cause, FusedExplosive targetEntity) {
        return Sponge.getEventFactory().createTargetFusedExplosiveEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.item.ItemMergeItemEvent}.
     * 
     * @param cause The cause
     * @param itemToMerge The item to merge
     * @param targetEntity The target entity
     * @return A new item merge item event
     */
    public static ItemMergeItemEvent createItemMergeItemEvent(Cause cause, Item itemToMerge, Item targetEntity) {
        return Sponge.getEventFactory().createItemMergeItemEvent(cause, itemToMerge, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.item.TargetItemEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target item event
     */
    public static TargetItemEvent createTargetItemEvent(Cause cause, Item targetEntity) {
        return Sponge.getEventFactory().createTargetItemEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.TargetAgentEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target agent event
     */
    public static TargetAgentEvent createTargetAgentEvent(Cause cause, Agent targetEntity) {
        return Sponge.getEventFactory().createTargetAgentEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.TargetLivingEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target living event
     */
    public static TargetLivingEvent createTargetLivingEvent(Cause cause, Living targetEntity) {
        return Sponge.getEventFactory().createTargetLivingEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.AnimateHandEvent}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param targetEntity The target entity
     * @return A new animate hand event
     */
    public static AnimateHandEvent createAnimateHandEvent(Cause cause, HandType handType, Humanoid targetEntity) {
        return Sponge.getEventFactory().createAnimateHandEvent(cause, handType, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.ChangeGameModeEvent}.
     * 
     * @param cause The cause
     * @param originalGameMode The original game mode
     * @param gameMode The game mode
     * @param targetEntity The target entity
     * @return A new change game mode event
     */
    public static ChangeGameModeEvent createChangeGameModeEvent(Cause cause, GameMode originalGameMode, GameMode gameMode, Humanoid targetEntity) {
        return Sponge.getEventFactory().createChangeGameModeEvent(cause, originalGameMode, gameMode, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.ChangeGameModeEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param originalGameMode The original game mode
     * @param gameMode The game mode
     * @param targetEntity The target entity
     * @return A new target player change game mode event
     */
    public static ChangeGameModeEvent.TargetPlayer createChangeGameModeEventTargetPlayer(Cause cause, GameMode originalGameMode, GameMode gameMode, Player targetEntity) {
        return Sponge.getEventFactory().createChangeGameModeEventTargetPlayer(cause, originalGameMode, gameMode, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.ChangeLevelEvent}.
     * 
     * @param cause The cause
     * @param originalLevel The original level
     * @param level The level
     * @param targetEntity The target entity
     * @return A new change level event
     */
    public static ChangeLevelEvent createChangeLevelEvent(Cause cause, int originalLevel, int level, Humanoid targetEntity) {
        return Sponge.getEventFactory().createChangeLevelEvent(cause, originalLevel, level, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.ChangeLevelEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param originalLevel The original level
     * @param level The level
     * @param targetEntity The target entity
     * @return A new target player change level event
     */
    public static ChangeLevelEvent.TargetPlayer createChangeLevelEventTargetPlayer(Cause cause, int originalLevel, int level, Player targetEntity) {
        return Sponge.getEventFactory().createChangeLevelEventTargetPlayer(cause, originalLevel, level, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.HandInteractEvent}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @return A new hand interact event
     */
    public static HandInteractEvent createHandInteractEvent(Cause cause, HandType handType, Optional<Vector3d> interactionPoint) {
        return Sponge.getEventFactory().createHandInteractEvent(cause, handType, interactionPoint);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.TargetHumanoidEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target humanoid event
     */
    public static TargetHumanoidEvent createTargetHumanoidEvent(Cause cause, Humanoid targetEntity) {
        return Sponge.getEventFactory().createTargetHumanoidEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.player.KickPlayerEvent}.
     * 
     * @param cause The cause
     * @param originalChannel The original channel
     * @param channel The channel
     * @param formatter The formatter
     * @param targetEntity The target entity
     * @param messageCancelled The message cancelled
     * @return A new kick player event
     */
    public static KickPlayerEvent createKickPlayerEvent(Cause cause, MessageChannel originalChannel, Optional<MessageChannel> channel, MessageEvent.MessageFormatter formatter, Player targetEntity, boolean messageCancelled) {
        return Sponge.getEventFactory().createKickPlayerEvent(cause, originalChannel, channel, formatter, targetEntity, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.player.PlayerChangeClientSettingsEvent}.
     * 
     * @param cause The cause
     * @param chatVisibility The chat visibility
     * @param displayedSkinParts The displayed skin parts
     * @param locale The locale
     * @param targetEntity The target entity
     * @param chatColorsEnabled The chat colors enabled
     * @param viewDistance The view distance
     * @return A new player change client settings event
     */
    public static PlayerChangeClientSettingsEvent createPlayerChangeClientSettingsEvent(Cause cause, ChatVisibility chatVisibility, Set<SkinPart> displayedSkinParts, Locale locale, Player targetEntity, boolean chatColorsEnabled, int viewDistance) {
        return Sponge.getEventFactory().createPlayerChangeClientSettingsEvent(cause, chatVisibility, displayedSkinParts, locale, targetEntity, chatColorsEnabled, viewDistance);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.player.ResourcePackStatusEvent}.
     * 
     * @param cause The cause
     * @param pack The pack
     * @param player The player
     * @param status The status
     * @return A new resource pack status event
     */
    public static ResourcePackStatusEvent createResourcePackStatusEvent(Cause cause, ResourcePack pack, Player player, ResourcePackStatusEvent.ResourcePackStatus status) {
        return Sponge.getEventFactory().createResourcePackStatusEvent(cause, pack, player, status);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param originalPlayer The original player
     * @param targetEntity The target entity
     * @param bedSpawn The bed spawn
     * @param death The death
     * @return A new respawn player event
     */
    public static RespawnPlayerEvent createRespawnPlayerEvent(Cause cause, Transform<World> fromTransform, Transform<World> toTransform, Player originalPlayer, Player targetEntity, boolean bedSpawn, boolean death) {
        return Sponge.getEventFactory().createRespawnPlayerEvent(cause, fromTransform, toTransform, originalPlayer, targetEntity, bedSpawn, death);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target player event
     */
    public static TargetPlayerEvent createTargetPlayerEvent(Cause cause, Player targetEntity) {
        return Sponge.getEventFactory().createTargetPlayerEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.LaunchProjectileEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new launch projectile event
     */
    public static LaunchProjectileEvent createLaunchProjectileEvent(Cause cause, Projectile targetEntity) {
        return Sponge.getEventFactory().createLaunchProjectileEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.entity.projectile.TargetProjectileEvent}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @return A new target projectile event
     */
    public static TargetProjectileEvent createTargetProjectileEvent(Cause cause, Projectile targetEntity) {
        return Sponge.getEventFactory().createTargetProjectileEvent(cause, targetEntity);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.GameReloadEvent}.
     * 
     * @param cause The cause
     * @return A new game reload event
     */
    public static GameReloadEvent createGameReloadEvent(Cause cause) {
        return Sponge.getEventFactory().createGameReloadEvent(cause);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameAboutToStartServerEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game about to start server event
     */
    public static GameAboutToStartServerEvent createGameAboutToStartServerEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameAboutToStartServerEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameConstructionEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game construction event
     */
    public static GameConstructionEvent createGameConstructionEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameConstructionEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameInitializationEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game initialization event
     */
    public static GameInitializationEvent createGameInitializationEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameInitializationEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameLoadCompleteEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game load complete event
     */
    public static GameLoadCompleteEvent createGameLoadCompleteEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameLoadCompleteEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GamePostInitializationEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game post initialization event
     */
    public static GamePostInitializationEvent createGamePostInitializationEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGamePostInitializationEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GamePreInitializationEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game pre initialization event
     */
    public static GamePreInitializationEvent createGamePreInitializationEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGamePreInitializationEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStartedServerEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game started server event
     */
    public static GameStartedServerEvent createGameStartedServerEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameStartedServerEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStartingServerEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game starting server event
     */
    public static GameStartingServerEvent createGameStartingServerEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameStartingServerEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStateEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game state event
     */
    public static GameStateEvent createGameStateEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameStateEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppedEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game stopped event
     */
    public static GameStoppedEvent createGameStoppedEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameStoppedEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppedServerEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game stopped server event
     */
    public static GameStoppedServerEvent createGameStoppedServerEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameStoppedServerEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppingEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game stopping event
     */
    public static GameStoppingEvent createGameStoppingEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameStoppingEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.game.state.GameStoppingServerEvent}.
     * 
     * @param cause The cause
     * @param state The state
     * @return A new game stopping server event
     */
    public static GameStoppingServerEvent createGameStoppingServerEvent(Cause cause, GameState state) {
        return Sponge.getEventFactory().createGameStoppingServerEvent(cause, state);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.AffectItemStackEvent}.
     * 
     * @param cause The cause
     * @param transactions The transactions
     * @return A new affect item stack event
     */
    public static AffectItemStackEvent createAffectItemStackEvent(Cause cause, List<? extends Transaction<ItemStackSnapshot>> transactions) {
        return Sponge.getEventFactory().createAffectItemStackEvent(cause, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.AffectSlotEvent}.
     * 
     * @param cause The cause
     * @param transactions The transactions
     * @return A new affect slot event
     */
    public static AffectSlotEvent createAffectSlotEvent(Cause cause, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createAffectSlotEvent(cause, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent.Equipment}.
     * 
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new equipment change inventory event
     */
    public static ChangeInventoryEvent.Equipment createChangeInventoryEventEquipment(Cause cause, Inventory targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createChangeInventoryEventEquipment(cause, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent.Held}.
     * 
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new held change inventory event
     */
    public static ChangeInventoryEvent.Held createChangeInventoryEventHeld(Cause cause, Inventory targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createChangeInventoryEventHeld(cause, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent.Pickup}.
     * 
     * @param cause The cause
     * @param targetEntity The target entity
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new pickup change inventory event
     */
    public static ChangeInventoryEvent.Pickup createChangeInventoryEventPickup(Cause cause, Item targetEntity, Inventory targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createChangeInventoryEventPickup(cause, targetEntity, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ChangeInventoryEvent.Transfer}.
     * 
     * @param cause The cause
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new transfer change inventory event
     */
    public static ChangeInventoryEvent.Transfer createChangeInventoryEventTransfer(Cause cause, Inventory targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createChangeInventoryEventTransfer(cause, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Creative}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new creative click inventory event
     */
    public static ClickInventoryEvent.Creative createClickInventoryEventCreative(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventCreative(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Double}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new double click inventory event
     */
    public static ClickInventoryEvent.Double createClickInventoryEventDouble(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventDouble(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drag.Primary}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new primary drag click inventory event
     */
    public static ClickInventoryEvent.Drag.Primary createClickInventoryEventDragPrimary(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventDragPrimary(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drag.Secondary}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new secondary drag click inventory event
     */
    public static ClickInventoryEvent.Drag.Secondary createClickInventoryEventDragSecondary(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventDragSecondary(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Full}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new full drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Full createClickInventoryEventDropFull(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventDropFull(cause, cursorTransaction, entities, targetInventory, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Outside.Primary}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new primary outside drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Outside.Primary createClickInventoryEventDropOutsidePrimary(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventDropOutsidePrimary(cause, cursorTransaction, entities, targetInventory, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Outside.Secondary}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new secondary outside drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Outside.Secondary createClickInventoryEventDropOutsideSecondary(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventDropOutsideSecondary(cause, cursorTransaction, entities, targetInventory, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Drop.Single}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param entities The entities
     * @param targetInventory The target inventory
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new single drop click inventory event
     */
    public static ClickInventoryEvent.Drop.Single createClickInventoryEventDropSingle(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, List<Entity> entities, Container targetInventory, World targetWorld, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventDropSingle(cause, cursorTransaction, entities, targetInventory, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Middle}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new middle click inventory event
     */
    public static ClickInventoryEvent.Middle createClickInventoryEventMiddle(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventMiddle(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.NumberPress}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @param number The number
     * @return A new number press click inventory event
     */
    public static ClickInventoryEvent.NumberPress createClickInventoryEventNumberPress(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions, int number) {
        return Sponge.getEventFactory().createClickInventoryEventNumberPress(cause, cursorTransaction, targetInventory, transactions, number);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Primary}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new primary click inventory event
     */
    public static ClickInventoryEvent.Primary createClickInventoryEventPrimary(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventPrimary(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Secondary}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new secondary click inventory event
     */
    public static ClickInventoryEvent.Secondary createClickInventoryEventSecondary(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventSecondary(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Shift.Primary}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new primary shift click inventory event
     */
    public static ClickInventoryEvent.Shift.Primary createClickInventoryEventShiftPrimary(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventShiftPrimary(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.ClickInventoryEvent.Shift.Secondary}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @param transactions The transactions
     * @return A new secondary shift click inventory event
     */
    public static ClickInventoryEvent.Shift.Secondary createClickInventoryEventShiftSecondary(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory, List<SlotTransaction> transactions) {
        return Sponge.getEventFactory().createClickInventoryEventShiftSecondary(cause, cursorTransaction, targetInventory, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent.Custom}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new custom drop item event
     */
    public static DropItemEvent.Custom createDropItemEventCustom(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createDropItemEventCustom(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent.Destruct}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new destruct drop item event
     */
    public static DropItemEvent.Destruct createDropItemEventDestruct(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createDropItemEventDestruct(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent.Dispense}.
     * 
     * @param cause The cause
     * @param entities The entities
     * @param targetWorld The target world
     * @return A new dispense drop item event
     */
    public static DropItemEvent.Dispense createDropItemEventDispense(Cause cause, List<Entity> entities, World targetWorld) {
        return Sponge.getEventFactory().createDropItemEventDispense(cause, entities, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.DropItemEvent.Pre}.
     * 
     * @param cause The cause
     * @param originalDroppedItems The original dropped items
     * @param droppedItems The dropped items
     * @return A new pre drop item event
     */
    public static DropItemEvent.Pre createDropItemEventPre(Cause cause, List<ItemStackSnapshot> originalDroppedItems, List<ItemStackSnapshot> droppedItems) {
        return Sponge.getEventFactory().createDropItemEventPre(cause, originalDroppedItems, droppedItems);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractInventoryEvent.Close}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @return A new close interact inventory event
     */
    public static InteractInventoryEvent.Close createInteractInventoryEventClose(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory) {
        return Sponge.getEventFactory().createInteractInventoryEventClose(cause, cursorTransaction, targetInventory);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractInventoryEvent.Open}.
     * 
     * @param cause The cause
     * @param cursorTransaction The cursor transaction
     * @param targetInventory The target inventory
     * @return A new open interact inventory event
     */
    public static InteractInventoryEvent.Open createInteractInventoryEventOpen(Cause cause, Transaction<ItemStackSnapshot> cursorTransaction, Container targetInventory) {
        return Sponge.getEventFactory().createInteractInventoryEventOpen(cause, cursorTransaction, targetInventory);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractItemEvent.Primary.MainHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param itemStack The item stack
     * @return A new main hand primary interact item event
     */
    public static InteractItemEvent.Primary.MainHand createInteractItemEventPrimaryMainHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, ItemStackSnapshot itemStack) {
        return Sponge.getEventFactory().createInteractItemEventPrimaryMainHand(cause, handType, interactionPoint, itemStack);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractItemEvent.Primary.OffHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param itemStack The item stack
     * @return A new off hand primary interact item event
     */
    public static InteractItemEvent.Primary.OffHand createInteractItemEventPrimaryOffHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, ItemStackSnapshot itemStack) {
        return Sponge.getEventFactory().createInteractItemEventPrimaryOffHand(cause, handType, interactionPoint, itemStack);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractItemEvent.Secondary.MainHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param itemStack The item stack
     * @return A new main hand secondary interact item event
     */
    public static InteractItemEvent.Secondary.MainHand createInteractItemEventSecondaryMainHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, ItemStackSnapshot itemStack) {
        return Sponge.getEventFactory().createInteractItemEventSecondaryMainHand(cause, handType, interactionPoint, itemStack);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.InteractItemEvent.Secondary.OffHand}.
     * 
     * @param cause The cause
     * @param handType The hand type
     * @param interactionPoint The interaction point
     * @param itemStack The item stack
     * @return A new off hand secondary interact item event
     */
    public static InteractItemEvent.Secondary.OffHand createInteractItemEventSecondaryOffHand(Cause cause, HandType handType, Optional<Vector3d> interactionPoint, ItemStackSnapshot itemStack) {
        return Sponge.getEventFactory().createInteractItemEventSecondaryOffHand(cause, handType, interactionPoint, itemStack);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.TargetContainerEvent}.
     * 
     * @param cause The cause
     * @param targetInventory The target inventory
     * @return A new target container event
     */
    public static TargetContainerEvent createTargetContainerEvent(Cause cause, Container targetInventory) {
        return Sponge.getEventFactory().createTargetContainerEvent(cause, targetInventory);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.TargetInventoryEvent}.
     * 
     * @param cause The cause
     * @param targetInventory The target inventory
     * @return A new target inventory event
     */
    public static TargetInventoryEvent createTargetInventoryEvent(Cause cause, Inventory targetInventory) {
        return Sponge.getEventFactory().createTargetInventoryEvent(cause, targetInventory);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Finish}.
     * 
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new finish use item stack event
     */
    public static UseItemStackEvent.Finish createUseItemStackEventFinish(Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackSnapshot itemStackInUse) {
        return Sponge.getEventFactory().createUseItemStackEventFinish(cause, originalRemainingDuration, remainingDuration, itemStackInUse);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Replace}.
     * 
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @param itemStackResult The item stack result
     * @return A new replace use item stack event
     */
    public static UseItemStackEvent.Replace createUseItemStackEventReplace(Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackSnapshot itemStackInUse, Transaction<ItemStackSnapshot> itemStackResult) {
        return Sponge.getEventFactory().createUseItemStackEventReplace(cause, originalRemainingDuration, remainingDuration, itemStackInUse, itemStackResult);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Reset}.
     * 
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new reset use item stack event
     */
    public static UseItemStackEvent.Reset createUseItemStackEventReset(Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackSnapshot itemStackInUse) {
        return Sponge.getEventFactory().createUseItemStackEventReset(cause, originalRemainingDuration, remainingDuration, itemStackInUse);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Start}.
     * 
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new start use item stack event
     */
    public static UseItemStackEvent.Start createUseItemStackEventStart(Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackSnapshot itemStackInUse) {
        return Sponge.getEventFactory().createUseItemStackEventStart(cause, originalRemainingDuration, remainingDuration, itemStackInUse);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Stop}.
     * 
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new stop use item stack event
     */
    public static UseItemStackEvent.Stop createUseItemStackEventStop(Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackSnapshot itemStackInUse) {
        return Sponge.getEventFactory().createUseItemStackEventStop(cause, originalRemainingDuration, remainingDuration, itemStackInUse);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.item.inventory.UseItemStackEvent.Tick}.
     * 
     * @param cause The cause
     * @param originalRemainingDuration The original remaining duration
     * @param remainingDuration The remaining duration
     * @param itemStackInUse The item stack in use
     * @return A new tick use item stack event
     */
    public static UseItemStackEvent.Tick createUseItemStackEventTick(Cause cause, int originalRemainingDuration, int remainingDuration, ItemStackSnapshot itemStackInUse) {
        return Sponge.getEventFactory().createUseItemStackEventTick(cause, originalRemainingDuration, remainingDuration, itemStackInUse);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.message.MessageChannelEvent}.
     * 
     * @param cause The cause
     * @param originalChannel The original channel
     * @param channel The channel
     * @param formatter The formatter
     * @param messageCancelled The message cancelled
     * @return A new message channel event
     */
    public static MessageChannelEvent createMessageChannelEvent(Cause cause, MessageChannel originalChannel, Optional<MessageChannel> channel, MessageEvent.MessageFormatter formatter, boolean messageCancelled) {
        return Sponge.getEventFactory().createMessageChannelEvent(cause, originalChannel, channel, formatter, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.message.MessageChannelEvent.Chat}.
     * 
     * @param cause The cause
     * @param originalChannel The original channel
     * @param channel The channel
     * @param formatter The formatter
     * @param rawMessage The raw message
     * @param messageCancelled The message cancelled
     * @return A new chat message channel event
     */
    public static MessageChannelEvent.Chat createMessageChannelEventChat(Cause cause, MessageChannel originalChannel, Optional<MessageChannel> channel, MessageEvent.MessageFormatter formatter, Text rawMessage, boolean messageCancelled) {
        return Sponge.getEventFactory().createMessageChannelEventChat(cause, originalChannel, channel, formatter, rawMessage, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.BanIpEvent}.
     * 
     * @param cause The cause
     * @param ban The ban
     * @return A new ban ip event
     */
    public static BanIpEvent createBanIpEvent(Cause cause, Ban.Ip ban) {
        return Sponge.getEventFactory().createBanIpEvent(cause, ban);
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
        return Sponge.getEventFactory().createChannelRegistrationEventRegister(cause, channel);
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
        return Sponge.getEventFactory().createChannelRegistrationEventUnregister(cause, channel);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Auth}.
     * 
     * @param cause The cause
     * @param connection The connection
     * @param formatter The formatter
     * @param profile The profile
     * @param messageCancelled The message cancelled
     * @return A new auth client connection event
     */
    public static ClientConnectionEvent.Auth createClientConnectionEventAuth(Cause cause, RemoteConnection connection, MessageEvent.MessageFormatter formatter, GameProfile profile, boolean messageCancelled) {
        return Sponge.getEventFactory().createClientConnectionEventAuth(cause, connection, formatter, profile, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Disconnect}.
     * 
     * @param cause The cause
     * @param originalChannel The original channel
     * @param channel The channel
     * @param formatter The formatter
     * @param targetEntity The target entity
     * @param messageCancelled The message cancelled
     * @return A new disconnect client connection event
     */
    public static ClientConnectionEvent.Disconnect createClientConnectionEventDisconnect(Cause cause, MessageChannel originalChannel, Optional<MessageChannel> channel, MessageEvent.MessageFormatter formatter, Player targetEntity, boolean messageCancelled) {
        return Sponge.getEventFactory().createClientConnectionEventDisconnect(cause, originalChannel, channel, formatter, targetEntity, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Join}.
     * 
     * @param cause The cause
     * @param originalChannel The original channel
     * @param channel The channel
     * @param formatter The formatter
     * @param targetEntity The target entity
     * @param messageCancelled The message cancelled
     * @return A new join client connection event
     */
    public static ClientConnectionEvent.Join createClientConnectionEventJoin(Cause cause, MessageChannel originalChannel, Optional<MessageChannel> channel, MessageEvent.MessageFormatter formatter, Player targetEntity, boolean messageCancelled) {
        return Sponge.getEventFactory().createClientConnectionEventJoin(cause, originalChannel, channel, formatter, targetEntity, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.ClientConnectionEvent.Login}.
     * 
     * @param cause The cause
     * @param fromTransform The from transform
     * @param toTransform The to transform
     * @param connection The connection
     * @param formatter The formatter
     * @param profile The profile
     * @param targetUser The target user
     * @param messageCancelled The message cancelled
     * @return A new login client connection event
     */
    public static ClientConnectionEvent.Login createClientConnectionEventLogin(Cause cause, Transform<World> fromTransform, Transform<World> toTransform, RemoteConnection connection, MessageEvent.MessageFormatter formatter, GameProfile profile, User targetUser, boolean messageCancelled) {
        return Sponge.getEventFactory().createClientConnectionEventLogin(cause, fromTransform, toTransform, connection, formatter, profile, targetUser, messageCancelled);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.PardonIpEvent}.
     * 
     * @param cause The cause
     * @param ban The ban
     * @return A new pardon ip event
     */
    public static PardonIpEvent createPardonIpEvent(Cause cause, Ban.Ip ban) {
        return Sponge.getEventFactory().createPardonIpEvent(cause, ban);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.rcon.RconConnectionEvent.Connect}.
     * 
     * @param cause The cause
     * @param source The source
     * @return A new connect rcon connection event
     */
    public static RconConnectionEvent.Connect createRconConnectionEventConnect(Cause cause, RconSource source) {
        return Sponge.getEventFactory().createRconConnectionEventConnect(cause, source);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.rcon.RconConnectionEvent.Disconnect}.
     * 
     * @param cause The cause
     * @param source The source
     * @return A new disconnect rcon connection event
     */
    public static RconConnectionEvent.Disconnect createRconConnectionEventDisconnect(Cause cause, RconSource source) {
        return Sponge.getEventFactory().createRconConnectionEventDisconnect(cause, source);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.network.rcon.RconConnectionEvent.Login}.
     * 
     * @param cause The cause
     * @param source The source
     * @return A new login rcon connection event
     */
    public static RconConnectionEvent.Login createRconConnectionEventLogin(Cause cause, RconSource source) {
        return Sponge.getEventFactory().createRconConnectionEventLogin(cause, source);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.ClientPingServerEvent}.
     * 
     * @param cause The cause
     * @param client The client
     * @param response The response
     * @return A new client ping server event
     */
    public static ClientPingServerEvent createClientPingServerEvent(Cause cause, StatusClient client, ClientPingServerEvent.Response response) {
        return Sponge.getEventFactory().createClientPingServerEvent(cause, client, response);
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
        return Sponge.getEventFactory().createClientPingServerEventResponsePlayers(profiles, max, online);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.QueryServerEvent.Basic}.
     * 
     * @param cause The cause
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
    public static QueryServerEvent.Basic createQueryServerEventBasic(Cause cause, InetSocketAddress address, String gameType, String map, String motd, int maxPlayerCount, int maxSize, int playerCount, int size) {
        return Sponge.getEventFactory().createQueryServerEventBasic(cause, address, gameType, map, motd, maxPlayerCount, maxSize, playerCount, size);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.server.query.QueryServerEvent.Full}.
     * 
     * @param cause The cause
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
    public static QueryServerEvent.Full createQueryServerEventFull(Cause cause, InetSocketAddress address, Map<String, String> customValuesMap, String gameId, String gameType, String map, String motd, List<String> players, String plugins, String version, int maxPlayerCount, int maxSize, int playerCount, int size) {
        return Sponge.getEventFactory().createQueryServerEventFull(cause, address, customValuesMap, gameId, gameType, map, motd, players, plugins, version, maxPlayerCount, maxSize, playerCount, size);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.service.ChangeServiceProviderEvent}.
     * 
     * @param cause The cause
     * @param newProviderRegistration The new provider registration
     * @param previousProviderRegistration The previous provider registration
     * @return A new change service provider event
     */
    public static ChangeServiceProviderEvent createChangeServiceProviderEvent(Cause cause, ProviderRegistration<?> newProviderRegistration, Optional<ProviderRegistration<?>> previousProviderRegistration) {
        return Sponge.getEventFactory().createChangeServiceProviderEvent(cause, newProviderRegistration, previousProviderRegistration);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.statistic.ChangeStatisticEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param originalValue The original value
     * @param value The value
     * @param statistic The statistic
     * @param targetEntity The target entity
     * @return A new target player change statistic event
     */
    public static ChangeStatisticEvent.TargetPlayer createChangeStatisticEventTargetPlayer(Cause cause, long originalValue, long value, Statistic statistic, Player targetEntity) {
        return Sponge.getEventFactory().createChangeStatisticEventTargetPlayer(cause, originalValue, value, statistic, targetEntity);
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
    public static BanUserEvent createBanUserEvent(Cause cause, Ban.Profile ban, User targetUser) {
        return Sponge.getEventFactory().createBanUserEvent(cause, ban, targetUser);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.BanUserEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param ban The ban
     * @param targetEntity The target entity
     * @param targetUser The target user
     * @return A new target player ban user event
     */
    public static BanUserEvent.TargetPlayer createBanUserEventTargetPlayer(Cause cause, Ban.Profile ban, Player targetEntity, User targetUser) {
        return Sponge.getEventFactory().createBanUserEventTargetPlayer(cause, ban, targetEntity, targetUser);
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
    public static PardonUserEvent createPardonUserEvent(Cause cause, Ban.Profile ban, User targetUser) {
        return Sponge.getEventFactory().createPardonUserEvent(cause, ban, targetUser);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.PardonUserEvent.TargetPlayer}.
     * 
     * @param cause The cause
     * @param ban The ban
     * @param targetEntity The target entity
     * @param targetUser The target user
     * @return A new target player pardon user event
     */
    public static PardonUserEvent.TargetPlayer createPardonUserEventTargetPlayer(Cause cause, Ban.Profile ban, Player targetEntity, Player targetUser) {
        return Sponge.getEventFactory().createPardonUserEventTargetPlayer(cause, ban, targetEntity, targetUser);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.user.TargetUserEvent}.
     * 
     * @param cause The cause
     * @param targetUser The target user
     * @return A new target user event
     */
    public static TargetUserEvent createTargetUserEvent(Cause cause, User targetUser) {
        return Sponge.getEventFactory().createTargetUserEvent(cause, targetUser);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ChangeWorldGameRuleEvent}.
     * 
     * @param cause The cause
     * @param originalValue The original value
     * @param value The value
     * @param name The name
     * @param targetWorld The target world
     * @return A new change world game rule event
     */
    public static ChangeWorldGameRuleEvent createChangeWorldGameRuleEvent(Cause cause, String originalValue, String value, String name, World targetWorld) {
        return Sponge.getEventFactory().createChangeWorldGameRuleEvent(cause, originalValue, value, name, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ChangeWorldWeatherEvent}.
     * 
     * @param cause The cause
     * @param originalDuration The original duration
     * @param duration The duration
     * @param originalWeather The original weather
     * @param weather The weather
     * @param initialWeather The initial weather
     * @param targetWorld The target world
     * @return A new change world weather event
     */
    public static ChangeWorldWeatherEvent createChangeWorldWeatherEvent(Cause cause, int originalDuration, int duration, Weather originalWeather, Weather weather, Weather initialWeather, World targetWorld) {
        return Sponge.getEventFactory().createChangeWorldWeatherEvent(cause, originalDuration, duration, originalWeather, weather, initialWeather, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ConstructPortalEvent}.
     * 
     * @param cause The cause
     * @param portalLocation The portal location
     * @return A new construct portal event
     */
    public static ConstructPortalEvent createConstructPortalEvent(Cause cause, Location<World> portalLocation) {
        return Sponge.getEventFactory().createConstructPortalEvent(cause, portalLocation);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ConstructWorldPropertiesEvent}.
     * 
     * @param cause The cause
     * @param worldArchetype The world archetype
     * @param worldProperties The world properties
     * @return A new construct world properties event
     */
    public static ConstructWorldPropertiesEvent createConstructWorldPropertiesEvent(Cause cause, WorldArchetype worldArchetype, WorldProperties worldProperties) {
        return Sponge.getEventFactory().createConstructWorldPropertiesEvent(cause, worldArchetype, worldProperties);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ExplosionEvent.Detonate}.
     * 
     * @param cause The cause
     * @param affectedLocations The affected locations
     * @param entities The entities
     * @param explosion The explosion
     * @param targetWorld The target world
     * @return A new detonate explosion event
     */
    public static ExplosionEvent.Detonate createExplosionEventDetonate(Cause cause, List<Location<World>> affectedLocations, List<Entity> entities, Explosion explosion, World targetWorld) {
        return Sponge.getEventFactory().createExplosionEventDetonate(cause, affectedLocations, entities, explosion, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ExplosionEvent.Post}.
     * 
     * @param cause The cause
     * @param explosion The explosion
     * @param targetWorld The target world
     * @param transactions The transactions
     * @return A new post explosion event
     */
    public static ExplosionEvent.Post createExplosionEventPost(Cause cause, Explosion explosion, World targetWorld, List<Transaction<BlockSnapshot>> transactions) {
        return Sponge.getEventFactory().createExplosionEventPost(cause, explosion, targetWorld, transactions);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.ExplosionEvent.Pre}.
     * 
     * @param cause The cause
     * @param explosion The explosion
     * @param targetWorld The target world
     * @return A new pre explosion event
     */
    public static ExplosionEvent.Pre createExplosionEventPre(Cause cause, Explosion explosion, World targetWorld) {
        return Sponge.getEventFactory().createExplosionEventPre(cause, explosion, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.GenerateChunkEvent.Post}.
     * 
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new post generate chunk event
     */
    public static GenerateChunkEvent.Post createGenerateChunkEventPost(Cause cause, Chunk targetChunk) {
        return Sponge.getEventFactory().createGenerateChunkEventPost(cause, targetChunk);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.GenerateChunkEvent.Pre}.
     * 
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new pre generate chunk event
     */
    public static GenerateChunkEvent.Pre createGenerateChunkEventPre(Cause cause, Chunk targetChunk) {
        return Sponge.getEventFactory().createGenerateChunkEventPre(cause, targetChunk);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.LoadWorldEvent}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @return A new load world event
     */
    public static LoadWorldEvent createLoadWorldEvent(Cause cause, World targetWorld) {
        return Sponge.getEventFactory().createLoadWorldEvent(cause, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.SaveWorldEvent}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @return A new save world event
     */
    public static SaveWorldEvent createSaveWorldEvent(Cause cause, World targetWorld) {
        return Sponge.getEventFactory().createSaveWorldEvent(cause, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.SaveWorldEvent.Post}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @return A new post save world event
     */
    public static SaveWorldEvent.Post createSaveWorldEventPost(Cause cause, World targetWorld) {
        return Sponge.getEventFactory().createSaveWorldEventPost(cause, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.SaveWorldEvent.Pre}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @return A new pre save world event
     */
    public static SaveWorldEvent.Pre createSaveWorldEventPre(Cause cause, World targetWorld) {
        return Sponge.getEventFactory().createSaveWorldEventPre(cause, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.TargetWorldEvent}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @return A new target world event
     */
    public static TargetWorldEvent createTargetWorldEvent(Cause cause, World targetWorld) {
        return Sponge.getEventFactory().createTargetWorldEvent(cause, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.UnloadWorldEvent}.
     * 
     * @param cause The cause
     * @param targetWorld The target world
     * @return A new unload world event
     */
    public static UnloadWorldEvent createUnloadWorldEvent(Cause cause, World targetWorld) {
        return Sponge.getEventFactory().createUnloadWorldEvent(cause, targetWorld);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.ForcedChunkEvent}.
     * 
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param ticket The ticket
     * @return A new forced chunk event
     */
    public static ForcedChunkEvent createForcedChunkEvent(Cause cause, Vector3i chunkCoords, ChunkTicketManager.LoadingTicket ticket) {
        return Sponge.getEventFactory().createForcedChunkEvent(cause, chunkCoords, ticket);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.LoadChunkEvent}.
     * 
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new load chunk event
     */
    public static LoadChunkEvent createLoadChunkEvent(Cause cause, Chunk targetChunk) {
        return Sponge.getEventFactory().createLoadChunkEvent(cause, targetChunk);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Populate}.
     * 
     * @param cause The cause
     * @param populator The populator
     * @param targetChunk The target chunk
     * @return A new populate populate chunk event
     */
    public static PopulateChunkEvent.Populate createPopulateChunkEventPopulate(Cause cause, Populator populator, Chunk targetChunk) {
        return Sponge.getEventFactory().createPopulateChunkEventPopulate(cause, populator, targetChunk);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Post}.
     * 
     * @param cause The cause
     * @param appliedPopulators The applied populators
     * @param targetChunk The target chunk
     * @return A new post populate chunk event
     */
    public static PopulateChunkEvent.Post createPopulateChunkEventPost(Cause cause, List<Populator> appliedPopulators, Chunk targetChunk) {
        return Sponge.getEventFactory().createPopulateChunkEventPost(cause, appliedPopulators, targetChunk);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.PopulateChunkEvent.Pre}.
     * 
     * @param cause The cause
     * @param pendingPopulators The pending populators
     * @param targetChunk The target chunk
     * @return A new pre populate chunk event
     */
    public static PopulateChunkEvent.Pre createPopulateChunkEventPre(Cause cause, List<Populator> pendingPopulators, Chunk targetChunk) {
        return Sponge.getEventFactory().createPopulateChunkEventPre(cause, pendingPopulators, targetChunk);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.TargetChunkEvent}.
     * 
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new target chunk event
     */
    public static TargetChunkEvent createTargetChunkEvent(Cause cause, Chunk targetChunk) {
        return Sponge.getEventFactory().createTargetChunkEvent(cause, targetChunk);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnforcedChunkEvent}.
     * 
     * @param cause The cause
     * @param chunkCoords The chunk coords
     * @param ticket The ticket
     * @return A new unforced chunk event
     */
    public static UnforcedChunkEvent createUnforcedChunkEvent(Cause cause, Vector3i chunkCoords, ChunkTicketManager.LoadingTicket ticket) {
        return Sponge.getEventFactory().createUnforcedChunkEvent(cause, chunkCoords, ticket);
    }

    /**
     * AUTOMATICALLY GENERATED, DO NOT EDIT.
     * Creates a new instance of
     * {@link org.spongepowered.api.event.world.chunk.UnloadChunkEvent}.
     * 
     * @param cause The cause
     * @param targetChunk The target chunk
     * @return A new unload chunk event
     */
    public static UnloadChunkEvent createUnloadChunkEvent(Cause cause, Chunk targetChunk) {
        return Sponge.getEventFactory().createUnloadChunkEvent(cause, targetChunk);
    }
}

