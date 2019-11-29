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
package org.spongepowered.api.event.cause;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.cause.entity.dismount.DismountType;
import org.spongepowered.api.event.cause.entity.spawn.SpawnType;
import org.spongepowered.api.event.cause.entity.teleport.TeleportType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.projectile.source.ProjectileSource;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.plugin.PluginContainer;

import java.util.function.Supplier;

/**
 * Standard keys for use within {@link EventContext}s.
 */
public final class EventContextKeys {

    // SORTFIELDS:ON

    /**
     * Used when a {@link World} block event is being processed.
     * 
     * For example, a piston head retracting and extending.
     * 
     * Note: This represents vanilla's block event.
     * Note: This occurs at the end of a world tick after
     *  {@link #BLOCK_EVENT_QUEUE}.
     */
    public static final Supplier<EventContextKey<LocatableBlock>> BLOCK_EVENT_PROCESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "BLOCK_EVENT_PROCESS");

    /**
     * Used to queue a block event to be processed in a {@link World}.
     * 
     * For example, a piston will queue retract/extend movements using this
     * event.
     * 
     * Note: This represents vanilla's block event.
     */
    public static final Supplier<EventContextKey<LocatableBlock>> BLOCK_EVENT_QUEUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "BLOCK_EVENT_QUEUE");

    /**
     * Used when an {@link Entity} interacts with a block.
     */
    public static final Supplier<EventContextKey<BlockSnapshot>> BLOCK_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "BLOCK_HIT");

    /**
     * Used during command execution, indicates the {@link BlockSnapshot} that
     * is the target of the invocation.
     */
    public static final Supplier<EventContextKey<BlockSnapshot>> BLOCK_TARGET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "BLOCK_TARGET");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final Supplier<EventContextKey<ChangeBlockEvent.Break>> BREAK_EVENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "BREAK_EVENT");

    /**
     * Represents the command string that was provided to the command processor.
     */
    public static final Supplier<EventContextKey<String>> COMMAND_STRING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "COMMAND_STRING");

    /**
     * Represents the creator of an {@link Entity}.
     */
    public static final Supplier<EventContextKey<User>> CREATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "CREATOR");

    /**
     * Represents the {@link DamageType} to an entity.
     */
    public static final Supplier<EventContextKey<DamageType>> DAMAGE_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "DAMAGE_TYPE");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final Supplier<EventContextKey<ChangeBlockEvent.Decay>> DECAY_EVENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "DECAY_EVENT");

    /**
     * Used when a {@link Player} dismounts from an {@link Entity}.
     */
    public static final Supplier<EventContextKey<DismountType>> DISMOUNT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "DISMOUNT_TYPE");

    /**
     * Represents the target {@link Entity}.
     * 
     * Used when an entity, such as a Player, targets an entity via an
     * interaction.
     */
    public static final Supplier<EventContextKey<Entity>> ENTITY_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "ENTITY_HIT");

    /**
     * Represents a fake player responsible for an action.
     * 
     * Note: This is normally only used with mods.
     */
    public static final Supplier<EventContextKey<Player>> FAKE_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "FAKE_PLAYER");

    /**
     * Used when fire spreads to other blocks.
     */
    public static final Supplier<EventContextKey<ServerWorld>> FIRE_SPREAD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "FIRE_SPREAD");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Grow} to provide
     * the origin {@link BlockSnapshot} that is doing the "growing".
     */
    public static final Supplier<EventContextKey<BlockSnapshot>> GROWTH_ORIGIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "GROWTH_ORIGIN");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final Supplier<EventContextKey<ChangeBlockEvent.Grow>> GROW_EVENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "GROW_EVENT");

    /**
     * Used when an {@link Entity} ignites causing an {@link Explosion}.
     */
    public static final Supplier<EventContextKey<Living>> IGNITER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "IGNITER");

    /**
     * Represents the last {@link DamageSource} to an {@link Entity}.
     */
    public static final Supplier<EventContextKey<DamageSource>> LAST_DAMAGE_SOURCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "LAST_DAMAGE_SOURCE");

    /**
     * Used when leaves decay.
     */
    public static final Supplier<EventContextKey<ServerWorld>> LEAVES_DECAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "LEAVES_DECAY");

    /**
     * Used when flowing liquid causing another block to break.
     */
    public static final Supplier<EventContextKey<ServerWorld>> LIQUID_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "LIQUID_BREAK");

    /**
     * Used when flowing liquid moves to another location.
     */
    public static final Supplier<EventContextKey<ServerWorld>> LIQUID_FLOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "LIQUID_FLOW");

    /**
     * Used when liquid changes state.
     */
    public static final Supplier<EventContextKey<ServerWorld>> LIQUID_MIX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "LIQUID_MIX");

    /**
     * Used during command execution, indicates the {@link ServerLocation} that the
     * command is centered around.
     */
    public static final Supplier<EventContextKey<ServerLocation>> LOCATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "LOCATION");

    /**
     * Used during command execution, indicates the {@link MessageChannel} to
     * send any messages to.
     */
    public static final Supplier<EventContextKey<MessageChannel>> MESSAGE_CHANNEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "MESSAGE_CHANNEL");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final Supplier<EventContextKey<ChangeBlockEvent.Modify>> MODIFY_EVENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "MODIFY_EVENT");

    /**
     * Represents the source {@link BlockSnapshot} of a block notification.
     */
    public static final Supplier<EventContextKey<BlockSnapshot>> NEIGHBOR_NOTIFY_SOURCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "NEIGHBOR_NOTIFY_SOURCE");

    /**
     * Represents the {@link User} that notified a block.
     */
    public static final Supplier<EventContextKey<User>> NOTIFIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "NOTIFIER");

    /**
     * Represents the {@link User} that owns a block.
     */
    public static final Supplier<EventContextKey<User>> OWNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "OWNER");

    /**
     * Used when a {@link BlockTypes#PISTON_HEAD} extends.
     */
    public static final Supplier<EventContextKey<ServerWorld>> PISTON_EXTEND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PISTON_EXTEND");

    /**
     * Used when a {@link BlockTypes#PISTON_HEAD} retracts.
     */
    public static final Supplier<EventContextKey<ServerWorld>> PISTON_RETRACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PISTON_RETRACT");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final Supplier<EventContextKey<ChangeBlockEvent.Place>> PLACE_EVENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PLACE_EVENT");

    /**
     * Represents a {@link Player}.
     */
    public static final Supplier<EventContextKey<Player>> PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PLAYER");

    /**
     * Used when a {@link Player} breaks a block.
     */
    public static final Supplier<EventContextKey<ServerWorld>> PLAYER_BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PLAYER_BREAK");

    /**
     * Used when a {@link Player} places a block.
     */
    public static final Supplier<EventContextKey<ServerWorld>> PLAYER_PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PLAYER_PLACE");

    /**
     * Represents a simulated {@link Player}.
     */
    public static final Supplier<EventContextKey<GameProfile>> PLAYER_SIMULATED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PLAYER_SIMULATED");

    /**
     * Represents a {@link PluginContainer}.
     */
    public static final Supplier<EventContextKey<PluginContainer>> PLUGIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PLUGIN");

    /**
     * Represents a {@link ProjectileSource}.
     */
    public static final Supplier<EventContextKey<ProjectileSource>> PROJECTILE_SOURCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "PROJECTILE_SOURCE");

    /**
     * Represents a rotation as a {@link Vector3d}, for use with commands.
     */
    public static final Supplier<EventContextKey<Vector3d>> ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "ROTATION");

    /**
     * Represents the {@link ServiceManager}.
     */
    public static final Supplier<EventContextKey<ServiceManager>> SERVICE_MANAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "SERVICE_MANAGER");

    /**
     * Represents the {@link SpawnType} of an entity spawn.
     */
    public static final Supplier<EventContextKey<SpawnType>> SPAWN_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "SPAWN_TYPE");

    /**
     * Used during command invocation, indicates the {@link Subject} that
     * permission checks should be performed against.
     */
    public static final Supplier<EventContextKey<Subject>> SUBJECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "SUBJECT");

    /**
     * Represents the {@link TeleportType} when an entity teleports.
     */
    public static final Supplier<EventContextKey<TeleportType>> TELEPORT_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "TELEPORT_TYPE");

    /**
     * Represents a {@link HandType}.
     */
    public static final Supplier<EventContextKey<HandType>> USED_HAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "USED_HAND");

    /**
     * Represents an {@link ItemStackSnapshot} of used item.
     */
    public static final Supplier<EventContextKey<ItemStackSnapshot>> USED_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "USED_ITEM");

    /**
     * Represents an {@link ItemStackSnapshot} of a weapon.
     */
    public static final Supplier<EventContextKey<ItemStackSnapshot>> WEAPON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EventContextKey.class, "WEAPON");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private EventContextKeys() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
