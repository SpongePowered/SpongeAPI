/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Optional;
import org.spongepowered.api.event.cause.reason.Reason;

import javax.annotation.Nullable;

/**
 * A cause represents the reason or initiator of an event.
 *
 * <p>
 * For example, if a block of sand is placed where it drops, the block of sand
 * would create a falling sand entity, which would cause an EntitySpawnEvent.
 * The cause of this entity spawn event would have a {@link Reason} of
 * EntitySpawnReasons#FALLING_BLOCK which would have a parent cause with a
 * BlockReason attached to it which provides a reference to the BlockLoc that
 * the block fell from.
 * </p>
 * 
 * @param <T> The reason type
 */
public class Cause<T extends Reason> {

    private final Optional<Cause<?>> parent;
    private final T reason;

    /**
     * Create a new cause instance.
     *
     * @param parent An optional parent
     * @param reason The reason
     */
    public Cause(@Nullable Cause<?> parent, T reason) {
        checkNotNull(reason);
        this.parent = Optional.<Cause<?>> fromNullable(parent);
        this.reason = reason;
    }

    /**
     * Get the parent cause of this cause.
     *
     * @return The parent cause
     */
    public Optional<Cause<?>> getParent() {
        return this.parent;
    }

    /**
     * Get the reason.
     *
     * @return The reason
     */
    public T getReason() {
        return this.reason;
    }

}
