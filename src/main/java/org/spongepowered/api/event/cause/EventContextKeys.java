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
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.cause.entity.dismount.DismountType;
import org.spongepowered.api.event.cause.entity.spawn.SpawnType;
import org.spongepowered.api.event.cause.entity.teleport.TeleportType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.World;

/**
 * Standard keys for use within {@link EventContext}s.
 */
public final class EventContextKeys {

    // SORTFIELDS:ON

    public static final EventContextKey<BlockSnapshot> BLOCK_HIT = createFor("BLOCK_HIT");

    public static final EventContextKey<User> CREATOR = createFor("CREATOR");

    public static final EventContextKey<DamageType> DAMAGE_TYPE = createFor("DAMAGE_TYPE");

    public static final EventContextKey<DismountType> DISMOUNT_TYPE = createFor("DISMOUNT_TYPE");

    public static final EventContextKey<Entity> ENTITY_HIT = createFor("ENTITY_HIT");

    public static final EventContextKey<Player> FAKE_PLAYER = createFor("FAKE_PLAYER");

    public static final EventContextKey<World> FIRE_SPREAD = createFor("FIRE_SPREAD");

    public static final EventContextKey<Living> IGNITER = createFor("IGNITER");

    public static final EventContextKey<DamageSource> LAST_DAMAGE_SOURCE = createFor("LAST_DAMAGE_SOURCE");

    public static final EventContextKey<World> LEAVES_DECAY = createFor("LEAVES_DECAY");

    public static final EventContextKey<World> LIQUID_BREAK = createFor("LIQUID_BREAK");

    public static final EventContextKey<World> LIQUID_FLOW = createFor("LIQUID_FLOW");

    public static final EventContextKey<World> LIQUID_MIX = createFor("LIQUID_MIX");

    public static final EventContextKey<MessageChannel> MESSAGE_CHANNEL = createFor("MESSAGE_CHANNEL");

    public static final EventContextKey<User> NOTIFIER = createFor("NOTIFIER");

    public static final EventContextKey<User> OWNER = createFor("OWNER");

    public static final EventContextKey<World> PISTON_EXTEND = createFor("PISTON_EXTEND");

    public static final EventContextKey<World> PISTON_RETRACT = createFor("PISTON_RETRACT");

    public static final EventContextKey<Player> PLAYER = createFor("PLAYER");

    public static final EventContextKey<World> PLAYER_BREAK = createFor("PLAYER_BREAK");

    public static final EventContextKey<World> PLAYER_PLACE = createFor("PLAYER_PLACE");

    public static final EventContextKey<GameProfile> PLAYER_SIMULATED = createFor("PLAYER_SIMULATED");

    public static final EventContextKey<PluginContainer> PLUGIN = createFor("PLUGIN");

    public static final EventContextKey<ProjectileSource> PROJECTILE_SOURCE = createFor("PROJECTILE_SOURCE");

    public static final EventContextKey<ServiceManager> SERVICE_MANAGER = createFor("SERVICE_MANAGER");

    public static final EventContextKey<Subject> SUBJECT = createFor("SUBJECT");

    public static final EventContextKey<SpawnType> SPAWN_TYPE = createFor("SPAWN_TYPE");

    public static final EventContextKey<TeleportType> TELEPORT_TYPE = createFor("TELEPORT_TYPE");

    public static final EventContextKey<ItemStackSnapshot> USED_ITEM = createFor("USED_ITEM");

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
