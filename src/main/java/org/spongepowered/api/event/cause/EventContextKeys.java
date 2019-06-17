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

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.cause.entity.dismount.DismountType;
import org.spongepowered.api.event.cause.entity.spawn.SpawnType;
import org.spongepowered.api.event.cause.entity.teleport.TeleportType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.explosion.Explosion;

/**
 * Standard keys for use within {@link EventContext}s.
 */
public final class EventContextKeys {

    // SORTFIELDS:ON

    /**
     * Used to queue a block event to be processed in a {@link World}.
     * 
     * For example, a piston will queue retract/extend movements using this
     * event.
     * 
     * Note: This represents vanilla's block event.
     */
    public static final EventContextKey<LocatableBlock> BLOCK_EVENT_QUEUE = createFor("BLOCK_EVENT_QUEUE");

    /**
     * Used when a {@link World} block event is being processed.
     * 
     * For example, a piston head retracting and extending.
     * 
     * Note: This represents vanilla's block event.
     * Note: This occurs at the end of a world tick after
     *  {@link #BLOCK_EVENT_QUEUE}.
     */
    public static final EventContextKey<LocatableBlock> BLOCK_EVENT_PROCESS = createFor("BLOCK_EVENT_PROCESS");

    /**
     * Used when an {@link Entity} interacts with a block.
     */
    public static final EventContextKey<BlockSnapshot> BLOCK_HIT = createFor("BLOCK_HIT");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final EventContextKey<ChangeBlockEvent.Break> BREAK_EVENT = createFor("BREAK_EVENT");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final EventContextKey<ChangeBlockEvent.Place> PLACE_EVENT = createFor("PLACE_EVENT");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final EventContextKey<ChangeBlockEvent.Modify> MODIFY_EVENT = createFor("MODIFY_EVENT");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final EventContextKey<ChangeBlockEvent.Decay> DECAY_EVENT = createFor("DECAY_EVENT");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Post} to provide
     * the block event without relying on existing in the {@link Cause} stack.
     */
    public static final EventContextKey<ChangeBlockEvent.Grow> GROW_EVENT = createFor("GROW_EVENT");

    /**
     * Used for {@link org.spongepowered.api.event.block.ChangeBlockEvent.Grow} to provide
     * the origin {@link BlockSnapshot} that is doing the "growing".
     */
    public static final EventContextKey<BlockSnapshot> GROWTH_ORIGIN = createFor("GROWTH_ORIGIN");

    /**
     * Represents the creator of an {@link Entity}.
     */
    public static final EventContextKey<User> CREATOR = createFor("CREATOR");

    /**
     * Represents the {@link DamageType} to an entity.
     */
    public static final EventContextKey<DamageType> DAMAGE_TYPE = createFor("DAMAGE_TYPE");

    /**
     * Used when a {@link Player} dismounts from an {@link Entity}.
     */
    public static final EventContextKey<DismountType> DISMOUNT_TYPE = createFor("DISMOUNT_TYPE");

    /**
     * Represents the target {@link Entity}.
     * 
     * Used when an entity, such as a Player, targets an entity via an
     * interaction.
     */
    public static final EventContextKey<Entity> ENTITY_HIT = createFor("ENTITY_HIT");

    /**
     * Represents a fake player responsible for an action.
     * 
     * Note: This is normally only used with mods.
     */
    public static final EventContextKey<Player> FAKE_PLAYER = createFor("FAKE_PLAYER");

    /**
     * Used when fire spreads to other blocks.
     */
    public static final EventContextKey<World> FIRE_SPREAD = createFor("FIRE_SPREAD");

    /**
     * Used when an {@link Entity} ignites causing an {@link Explosion}.
     */
    public static final EventContextKey<Living> IGNITER = createFor("IGNITER");

    /**
     * Represents the last {@link DamageSource} to an {@link Entity}.
     */
    public static final EventContextKey<DamageSource> LAST_DAMAGE_SOURCE = createFor("LAST_DAMAGE_SOURCE");

    /**
     * Used when leaves decay.
     */
    public static final EventContextKey<World> LEAVES_DECAY = createFor("LEAVES_DECAY");

    /**
     * Used when flowing liquid causing another block to break.
     */
    public static final EventContextKey<World> LIQUID_BREAK = createFor("LIQUID_BREAK");

    /**
     * Used when flowing liquid moves to another location.
     */
    public static final EventContextKey<World> LIQUID_FLOW = createFor("LIQUID_FLOW");

    /**
     * Used when liquid changes state.
     */
    public static final EventContextKey<World> LIQUID_MIX = createFor("LIQUID_MIX");

    /**
     * Represents the source {@link BlockSnapshot} of a block notification.
     */
    public static final EventContextKey<BlockSnapshot> NEIGHBOR_NOTIFY_SOURCE = createFor("NEIGHBOR_NOTIFY_SOURCE");

    /**
     * Represents the {@link User} that notified a block.
     */
    public static final EventContextKey<User> NOTIFIER = createFor("NOTIFIER");

    /**
     * Represents the {@link User} that owns a block.
     */
    public static final EventContextKey<User> OWNER = createFor("OWNER");

    /**
     * Used when a {@link BlockTypes#PISTON_HEAD} extends.
     */
    public static final EventContextKey<World> PISTON_EXTEND = createFor("PISTON_EXTEND");

    /**
     * Used when a {@link BlockTypes#PISTON_HEAD} retracts.
     */
    public static final EventContextKey<World> PISTON_RETRACT = createFor("PISTON_RETRACT");

    /**
     * Represents a {@link Player}.
     */
    public static final EventContextKey<Player> PLAYER = createFor("PLAYER");

    /**
     * Used when a {@link Player} breaks a block.
     */
    public static final EventContextKey<World> PLAYER_BREAK = createFor("PLAYER_BREAK");

    /**
     * Used when a {@link Player} places a block.
     */
    public static final EventContextKey<World> PLAYER_PLACE = createFor("PLAYER_PLACE");

    /**
     * Represents a simulated {@link Player}.
     */
    public static final EventContextKey<GameProfile> PLAYER_SIMULATED = createFor("PLAYER_SIMULATED");

    /**
     * Represents a {@link PluginContainer}.
     */
    public static final EventContextKey<PluginContainer> PLUGIN = createFor("PLUGIN");

    /**
     * Represents a {@link ProjectileSource}.
     */
    public static final EventContextKey<ProjectileSource> PROJECTILE_SOURCE = createFor("PROJECTILE_SOURCE");

    /**
     * Represents the {@link ServiceManager}.
     */
    public static final EventContextKey<ServiceManager> SERVICE_MANAGER = createFor("SERVICE_MANAGER");

    /**
     * Represents the {@link SpawnType} of an entity spawn.
     */
    public static final EventContextKey<SpawnType> SPAWN_TYPE = createFor("SPAWN_TYPE");

    /**
     * Represents the {@link TeleportType} when an entity teleports.
     */
    public static final EventContextKey<TeleportType> TELEPORT_TYPE = createFor("TELEPORT_TYPE");

    /**
     * @deprecated this key is a duplicate of {@link #PROJECTILE_SOURCE} and
     *             will be removed in API 8. See <a
     *             href="https://github.com/SpongePowered/SpongeAPI/issues/1774">this
     *             issue on SpongeAPI</a>, Use {@link #PROJECTILE_SOURCE}
     *             instead.
     */
    @Deprecated
    public static final EventContextKey<ProjectileSource> THROWER = createFor("THROWER");

    /**
     * Represents an {@link ItemStackSnapshot} of used item.
     */
    public static final EventContextKey<ItemStackSnapshot> USED_ITEM = createFor("USED_ITEM");

    /**
     * Represents a {@link HandType}.
     */
    public static final EventContextKey<HandType> USED_HAND = createFor("USED_HAND");

    /**
     * Represents an {@link ItemStackSnapshot} of a weapon.
     */
    public static final EventContextKey<ItemStackSnapshot> WEAPON = createFor("WEAPON");

    // SORTFIELDS:OFF

    @SuppressWarnings("unchecked")
    private static <T> EventContextKey<T> createFor(String id) {
        return DummyObjectProvider.createFor(EventContextKey.class, id);
    }

    // Suppress default constructor to ensure non-instantiability.
    private EventContextKeys() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
