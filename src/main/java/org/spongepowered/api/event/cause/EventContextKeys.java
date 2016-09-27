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

/**
 * Standard keys for use within {@link EventContext}s.
 */
public final class EventContextKeys {

    public static final String CREATOR = "Creator";
    public static final String DAMAGE_TYPE = "DamageType";
    public static final String IGNITER = "Igniter";
    public static final String NOTIFIER = "Notifier";
    public static final String OWNER = "Owner";
    public static final String PLAYER_SIMULATED = "PlayerSimulated";
    public static final String PROJECTILE_SOURCE = "ProjectileSource";
    public static final String SERVICE_MANAGER = "ServiceManager";
    public static final String SPAWN_TYPE = "SpawnType";
    public static final String TELEPORT_TYPE = "TeleportType";
    public static final String THROWER = "Thrower";
    public static final String WEAPON = "Weapon";

    private EventContextKeys() {
    }

}
