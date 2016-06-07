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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.profile.GameProfile;

/**
 * A pseudo naming schema for "named" Cause objects. This can be considered
 * a relative to {@link CommandArgs} in that multiple objects may be "named"
 * in a {@link Cause}. The use case could be for instances where multiple
 * {@link Player} objects are within a {@link Cause} such that the order
 * is known, but the "association" in the cause is unknown. With a
 * {@link NamedCause} however, it is possible to retrieve the "mentioned"
 * {@link Player} or "owner" {@link Player} for events where an "owner" is
 * known.
 */
public final class NamedCause {

    public static final String IGNITER = "Igniter";
    public static final String NOTIFIER = "Notifier";
    public static final String OWNER = "Owner";
    public static final String PHYSICAL = "Physical";
    public static final String SOURCE = "Source";
    public static final String THROWER = "Thrower";
    public static final String PLAYER_SIMULATED = "PlayerSimulated";

    public static NamedCause source(Object object) {
        return of(SOURCE, object);
    }

    public static NamedCause owner(Object object) {
        return of(OWNER, object);
    }

    public static NamedCause notifier(Object obj) {
        return of(NOTIFIER, obj);
    }

    public static NamedCause simulated(Object object) {
        checkArgument(object instanceof Player || object instanceof User || object instanceof GameProfile,
            "Invalid object provided for player simulated methods");
        return of(PLAYER_SIMULATED, object);
    }

    public static NamedCause simulated(Player player) {
        return of(PLAYER_SIMULATED, player);
    }

    public static NamedCause simulated(User user) {
        return of(PLAYER_SIMULATED, user);
    }

    public static NamedCause simulated(GameProfile profile) {
        return of(PLAYER_SIMULATED, profile);
    }

    public static NamedCause of(String name, Object object) {
        checkNotNull(name, "Cannot have a null name!");
        checkNotNull(object, "Cannot have a null object!");
        checkArgument(!name.isEmpty(), "The name cannot be empty!");
        checkArgument(!(object instanceof NamedCause), "Cannot nest a named cause in a named cause!");
        return new NamedCause(name, object);
    }


    private final String name;
    private final Object object;

    private NamedCause(String name, Object object) {
        this.name = checkNotNull(name);
        this.object = checkNotNull(object);
    }

    public String getName() {
        return this.name;
    }

    public Object getCauseObject() {
        return this.object;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name, this.object);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final NamedCause other = (NamedCause) obj;
        return Objects.equal(this.name, other.name)
               && Objects.equal(this.object, other.object);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("name", this.name)
            .add("object", this.object)
            .toString();
    }
}
