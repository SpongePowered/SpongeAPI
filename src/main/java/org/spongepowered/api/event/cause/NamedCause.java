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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.command.args.CommandArgs;

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

    public static final String OWNER = "Owner";
    public static final String NOTIFIER = "Notifier";
    public static final String THROWER = "Thrower";
    public static final String IGNITER = "Igniter";

    public static NamedCause of(String name, Object object) {
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

}
