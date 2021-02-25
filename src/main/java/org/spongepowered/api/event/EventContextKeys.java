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

import io.leangen.geantyref.TypeToken;
import net.kyori.adventure.audience.Audience;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.transaction.BlockTransaction;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.cause.entity.DismountType;
import org.spongepowered.api.event.cause.entity.MovementType;
import org.spongepowered.api.event.cause.entity.SpawnType;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.projectile.source.ProjectileSource;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.util.TypeTokens;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.plugin.PluginContainer;

/**
 * Standard keys for use within {@link EventContext}s.
 */
@SuppressWarnings("unused")
public final class EventContextKeys {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Used during command execution, indicates the {@link Audience} to
     * send any messages to.
     */
    public static final EventContextKey<Audience> AUDIENCE = EventContextKeys.key(ResourceKey.sponge("audience"), TypeTokens.AUDIENCE_TOKEN);

    /**
     * Used when a {@link World} block event is being processed.
     * 
     * For example, a piston head retracting and extending.
     * 
     * Note: This represents vanilla's block event.
     * Note: This occurs at the end of a world tick after
     *  {@link #BLOCK_EVENT_QUEUE}.
     */
    public static final EventContextKey<LocatableBlock> BLOCK_EVENT_PROCESS = EventContextKeys.key(ResourceKey.sponge("block_event_process"), TypeTokens.LOCATABLE_BLOCK_TOKEN);

    /**
     * Used to queue a block event to be processed in a {@link World}.
     * 
     * For example, a piston will queue retract/extend movements using this
     * event.
     * 
     * Note: This represents vanilla's block event.
     */
    public static final EventContextKey<LocatableBlock> BLOCK_EVENT_QUEUE = EventContextKeys.key(ResourceKey.sponge("block_event_queue"), TypeTokens.LOCATABLE_BLOCK_TOKEN);

    /**
     * Used when an {@link Entity} interacts with a block.
     */
    public static final EventContextKey<BlockSnapshot> BLOCK_HIT = EventContextKeys.key(ResourceKey.sponge("block_hit"), TypeTokens.BLOCK_SNAPSHOT_TOKEN);

    /**
     * Used during command execution, indicates the {@link BlockSnapshot} that
     * is the target of the invocation.
     */
    public static final EventContextKey<BlockSnapshot> BLOCK_TARGET = EventContextKeys.key(ResourceKey.sponge("block_target"), TypeTokens.BLOCK_SNAPSHOT_TOKEN);

    /**
     * Represents the command string that was provided to the command processor.
     */
    public static final EventContextKey<String> COMMAND = EventContextKeys.key(ResourceKey.sponge("command"), TypeTokens.STRING_TOKEN);

    /**
     * Represents the creator of an {@link Entity} or a {@link BlockState} at a {@link Location}
     */
    public static final EventContextKey<User> CREATOR = EventContextKeys.key(ResourceKey.sponge("creator"), TypeTokens.USER_TOKEN);

    /**
     * Represents the {@link DamageType} to an entity.
     */
    public static final EventContextKey<DamageType> DAMAGE_TYPE = EventContextKeys.key(ResourceKey.sponge("damage_type"), TypeTokens.DAMAGE_TYPE_TOKEN);

    /**
     * Used when a {@link Player} dismounts from an {@link Entity}.
     */
    public static final EventContextKey<DismountType> DISMOUNT_TYPE = EventContextKeys.key(ResourceKey.sponge("dismount_type"), TypeTokens.DISMOUNT_TYPE_TOKEN);

    /**
     * Represents the target {@link Entity}.
     * 
     * Used when an entity, such as a Player, targets an entity via an
     * interaction.
     */
    public static final EventContextKey<Entity> ENTITY_HIT = EventContextKeys.key(ResourceKey.sponge("entity_hit"), TypeTokens.ENTITY_TOKEN);

    /**
     * Represents a fake player responsible for an action.
     * 
     * Note: This is normally only used with mods.
     */
    public static final EventContextKey<Player> FAKE_PLAYER = EventContextKeys.key(ResourceKey.sponge("fake_player"), TypeTokens.PLAYER_TOKEN);

    /**
     * Used when fire spreads to other blocks.
     */
    public static final EventContextKey<ServerWorld> FIRE_SPREAD = EventContextKeys.key(ResourceKey.sponge("fire_spread"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent} to provide
     * the origin {@link BlockSnapshot} that is doing the "growing". This is likely
     * useful to determine what is the origin with {@link BlockTransaction#getOperation()}
     * when the {@link org.spongepowered.api.block.transaction.Operation operation} is of
     * {@link org.spongepowered.api.block.transaction.Operations#GROWTH Operations.GROWTH}.
     */
    public static final EventContextKey<BlockSnapshot> GROWTH_ORIGIN = EventContextKeys.key(ResourceKey.sponge("growth_origin"), TypeTokens.BLOCK_SNAPSHOT_TOKEN);

    /**
     * Used when an {@link Living} ignites causing an {@link Explosion}.
     */
    public static final EventContextKey<Living> IGNITER = EventContextKeys.key(ResourceKey.sponge("igniter"), TypeTokens.LIVING_TOKEN);

    /**
     * Represents the last {@link DamageSource} to an {@link Entity}.
     */
    public static final EventContextKey<DamageSource> LAST_DAMAGE_SOURCE = EventContextKeys.key(ResourceKey.sponge("last_damage_source"), TypeTokens.DAMAGE_SOURCE_TOKEN);

    /**
     * Used when leaves decay.
     */
    public static final EventContextKey<ServerWorld> LEAVES_DECAY = EventContextKeys.key(ResourceKey.sponge("leaves_decay"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Used when flowing liquid causing another block to break.
     */
    public static final EventContextKey<ServerWorld> LIQUID_BREAK = EventContextKeys.key(ResourceKey.sponge("liquid_break"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Used when flowing liquid moves to another location.
     */
    public static final EventContextKey<ServerWorld> LIQUID_FLOW = EventContextKeys.key(ResourceKey.sponge("liquid_flow"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Used when liquid changes state.
     */
    public static final EventContextKey<ServerWorld> LIQUID_MIX = EventContextKeys.key(ResourceKey.sponge("liquid_mix"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Used during command execution, indicates the {@link ServerLocation} that the
     * command is centered around.
     */
    public static final EventContextKey<ServerLocation> LOCATION = EventContextKeys.key(ResourceKey.sponge("location"), TypeTokens.SERVER_LOCATION_TOKEN);

    /**
     * Represents the {@link MovementType} when an entity moves.
     */
    public static final EventContextKey<MovementType> MOVEMENT_TYPE = EventContextKeys.key(ResourceKey.sponge("movement_type"), TypeTokens.MOVEMENT_TYPE_TOKEN);

    /**
     * Represents the source {@link BlockSnapshot} of a block notification.
     */
    public static final EventContextKey<BlockSnapshot> NEIGHBOR_NOTIFY_SOURCE = EventContextKeys.key(ResourceKey.sponge("neighbor_notify_source"), TypeTokens.BLOCK_SNAPSHOT_TOKEN);

    /**
     * Represents the {@link User} that notified a block.
     */
    public static final EventContextKey<User> NOTIFIER = EventContextKeys.key(ResourceKey.sponge("notifier"), TypeTokens.USER_TOKEN);

    /**
     * Used when a {@link BlockTypes#PISTON_HEAD} extends.
     */
    public static final EventContextKey<ServerWorld> PISTON_EXTEND = EventContextKeys.key(ResourceKey.sponge("piston_extend"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Used when a {@link BlockTypes#PISTON_HEAD} retracts.
     */
    public static final EventContextKey<ServerWorld> PISTON_RETRACT = EventContextKeys.key(ResourceKey.sponge("piston_retract"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Represents a {@link Player}.
     */
    public static final EventContextKey<Player> PLAYER = EventContextKeys.key(ResourceKey.sponge("player"), TypeTokens.PLAYER_TOKEN);

    /**
     * Used when a {@link Player} breaks a block.
     */
    public static final EventContextKey<ServerWorld> PLAYER_BREAK = EventContextKeys.key(ResourceKey.sponge("player_break"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Used when a {@link Player} places a block.
     */
    public static final EventContextKey<ServerWorld> PLAYER_PLACE = EventContextKeys.key(ResourceKey.sponge("player_place"), TypeTokens.SERVER_WORLD_TOKEN);

    /**
     * Represents a {@link PluginContainer}.
     */
    public static final EventContextKey<PluginContainer> PLUGIN = EventContextKeys.key(ResourceKey.sponge("plugin"), TypeTokens.PLUGIN_CONTAINER_TOKEN);

    /**
     * Represents a {@link ProjectileSource}.
     */
    public static final EventContextKey<ProjectileSource> PROJECTILE_SOURCE = EventContextKeys.key(ResourceKey.sponge("projectile_source"), TypeTokens.PROJECTILE_SOURCE_TOKEN);

    /**
     * Represents a rotation as a {@link Vector3d}, for use with commands.
     */
    public static final EventContextKey<Vector3d> ROTATION = EventContextKeys.key(ResourceKey.sponge("rotation"), TypeTokens.VECTOR_3D_TOKEN);

    /**
     * Represents a simulated {@link Player}.
     */
    public static final EventContextKey<GameProfile> SIMULATED_PLAYER = EventContextKeys.key(ResourceKey.sponge("simulated_player"), TypeTokens.GAME_PROFILE_TOKEN);

    /**
     * Represents the {@link SpawnType} of an entity spawn.
     */
    public static final EventContextKey<SpawnType> SPAWN_TYPE = EventContextKeys.key(ResourceKey.sponge("spawn_type"), TypeTokens.SPAWN_TYPE_TOKEN);

    /**
     * Used during command invocation, indicates the {@link Subject} that
     * permission checks should be performed against.
     */
    public static final EventContextKey<Subject> SUBJECT = EventContextKeys.key(ResourceKey.sponge("subject"), TypeTokens.SUBJECT_TOKEN);

    /**
     * Represents a {@link HandType}.
     */
    public static final EventContextKey<HandType> USED_HAND = EventContextKeys.key(ResourceKey.sponge("used_hand"), TypeTokens.HAND_TYPE_TOKEN);

    /**
     * Represents an {@link ItemStackSnapshot} of used item.
     */
    public static final EventContextKey<ItemStackSnapshot> USED_ITEM = EventContextKeys.key(ResourceKey.sponge("used_item"), TypeTokens.ITEM_STACK_SNAPSHOT_TOKEN);

    /**
     * Represents an {@link ItemStackSnapshot} of a weapon.
     */
    public static final EventContextKey<ItemStackSnapshot> WEAPON = EventContextKeys.key(ResourceKey.sponge("weapon"), TypeTokens.ITEM_STACK_SNAPSHOT_TOKEN);

    // SORTFIELDS:OFF

    // @formatter:on

    private EventContextKeys() {
    }

    private static <T> EventContextKey<T> key(final ResourceKey location, final TypeToken<T> token) {
        return EventContextKey.builder().key(location).type(token).build();
    }
}
