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
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.projectile.Projectile;
import org.spongepowered.api.event.block.CollideBlockEvent;
import org.spongepowered.api.event.item.inventory.InteractItemEvent;
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

    /**
     * Used by {@link ChangeBlockEvent.Pre} before a vanilla block event.
     */
    public static final String BLOCK_EVENT = "BlockEvent";

    /**
     * Used by {@link ChangeBlockEvent.Pre} during vanilla block protection
     * checks.
     */
    public static final String BLOCK_PROTECTED = "BlockProtected";

    /**
     * Used by {@link ChangeBlockEvent.Pre} before a block decays.
     */
    public static final String DECAY = "Decay";

    /**
     * Used by any event involving a fake {@link Player}.
     */
    public static final String FAKE_PLAYER = "FakePlayer";

    /**
     * Used by {@link ChangeBlockEvent.Pre} before fire spreads.
     */
    public static final String FIRE_SPREAD = "FireSpread";

    /**
     * Used by {@link InteractItemEvent} and will contain either a
     * {@link Entity} or {@link BlockSnapshot} which represents
     * the player's current target.
     */
    public static final String HIT_TARGET = "HitTarget";

    /**
     * Used by any event where an {@link Entity} ignites one or more
     * blocks.
     */
    public static final String IGNITER = "Igniter";

    /**
     * Used by {@link ChangeBlockEvent.Pre} before liquid flows.
     */
    public static final String LIQUID_FLOW = "LiquidFlow";

    /**
     * Used by any event where a {@link User} notifies either a
     * block or entity.
     */
    public static final String NOTIFIER = "Notifier";

    /**
     * Used by any event where a {@link User} created a block
     * or entity.
     */
    public static final String OWNER = "Owner";

    /**
     * Used by {@link CollideBlockEvent} when an {@link Entity}
     * collides with a block.
     */
    public static final String PHYSICAL = "Physical";

    /**
     * Used by {@link ChangeBlockEvent.Pre} before a
     * {@link BlockTypes#PISTON_HEAD} extends;
     */
    public static final String PISTON_EXTEND = "PistonExtend";

    /**
     * Used by {@link ChangeBlockEvent.Pre} before a
     * {@link BlockTypes#PISTON_HEAD} retracts;
     */
    public static final String PISTON_RETRACT = "PistonRetract";

    /**
     * Used by {@link ChangeBlockEvent.Pre} before a {@link Player}
     * breaks a block.
     */
    public static final String PLAYER_BREAK = "PlayerBreak";

    /**
     * Used by {@link ChangeBlockEvent.Pre} before a {@link Player}
     * places a block.
     */
    public static final String PLAYER_PLACE = "PlayerPlace";

    /**
     * Used by any event where a simulated {@link Human} is involved.
     */
    public static final String PLAYER_SIMULATED = "PlayerSimulated";

    /**
     * Used by any event that wants to represent a source.
     */
    public static final String SOURCE = "Source";

    /**
     * Used by any event where an {@link Entity} threw another
     * {@link Entity}, usually a {@link Projectile}.
     */
    public static final String THROWER = "Thrower";

    public static NamedCause source(Object object) {
        return of(SOURCE, object);
    }

    public static NamedCause owner(Object object) {
        return of(OWNER, object);
    }

    public static NamedCause notifier(Object obj) {
        return of(NOTIFIER, obj);
    }

    public static NamedCause hitTarget(Object obj) {
        return of(HIT_TARGET, obj);
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
