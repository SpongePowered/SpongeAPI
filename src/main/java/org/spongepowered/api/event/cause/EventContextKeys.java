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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.cause.entity.dismount.DismountType;
import org.spongepowered.api.event.cause.entity.spawn.SpawnType;
import org.spongepowered.api.event.cause.entity.teleport.TeleportType;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.ServiceManager;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.UUID;

/**
 * Standard keys for use within {@link EventContext}s.
 */
public final class EventContextKeys {

    public static final EventContextKey<UUID> CREATOR = createFor("CREATOR");
    public static final EventContextKey<DamageType> DAMAGE_TYPE = createFor("DAMAGE_TYPE");
    public static final EventContextKey<DismountType> DISMOUNT_TYPE = createFor("DISMOUNT_TYPE");
    public static final EventContextKey<User> IGNITER = createFor("IGNITER");
    public static final EventContextKey<DamageSource> LAST_DAMAGE_SOURCE = createFor("LAST_DAMAGE_SOURCE");
    public static final EventContextKey<User> NOTIFIER = createFor("NOTIFIER");
    public static final EventContextKey<User> OWNER = createFor("OWNER");
    public static final EventContextKey<Player> PLAYER = createFor("PLAYER");
    public static final EventContextKey<GameProfile> PLAYER_SIMULATED = createFor("PLAYER_SIMULATED");
    public static final EventContextKey<ProjectileSource> PROJECTILE_SOURCE = createFor("PROJECTILE_SOURCE");
    public static final EventContextKey<ServiceManager> SERVICE_MANAGER = createFor("SERVICE_MANAGER");
    public static final EventContextKey<SpawnType> SPAWN_TYPE = createFor("SPAWN_TYPE");
    public static final EventContextKey<TeleportType> TELEPORT_TYPE = createFor("TELEPORT_TYPE");
    public static final EventContextKey<User> THROWER = createFor("THROWER");
    public static final EventContextKey<ItemStackSnapshot> WEAPON = createFor("WEAPON");

    @SuppressWarnings("unchecked")
    private static <T> EventContextKey<T> createFor(String id) {
        return DummyObjectProvider.createFor(EventContextKey.class, id);
    }

    private EventContextKeys() {
    }

}
