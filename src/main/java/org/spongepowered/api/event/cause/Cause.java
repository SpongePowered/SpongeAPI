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
import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.reason.Reason;

import javax.annotation.Nullable;

/**
 * A cause represents the reason or initiator of an event.
 *
 * <p>For example, if a block of sand is placed where it drops, the block
 * of sand would create a falling sand entity, which then would place another
 * block of sand. The block place event for the final block of sand would have
 * the cause chain of the block of sand -&gt; falling sand entity.</p>
 *
 * <p>It is not possible to accurately the describe the chain of causes in
 * all scenarios so a best effort approach is generally acceptable. For
 * example, a player might press a lever, activating a complex Redstone
 * circuit, which would then launch TNT and cause the destruction of
 * some blocks, but tracing this event would be too complicated and thus
 * may not be attempted.</p>
 */
public class Cause {
    
    private final Optional<Cause> parent;
    private final Object cause;
    private final Optional<Reason> reason;

    /**
     * Create a new cause instance.
     *
     * @param parent An optional parent
     * @param cause The causing object (may be a block, entity, etc.)
     * @param reason An optional reason
     */
    public Cause(@Nullable Cause parent, Object cause, @Nullable Reason reason) {
        checkNotNull(cause);
        this.parent = Optional.fromNullable(parent);
        this.cause = cause;
        this.reason = Optional.fromNullable(reason);
    }

    /**
     * Get the parent cause of this cause.
     *
     * @return The parent cause
     */
    public Optional<Cause> getParent() {
        return parent;
    }

    /**
     * Get the causing object (it may be an {@link Entity}, {@link BlockLoc},
     * etc.).
     *
     * @return The cause
     */
    public Object getCause() {
        return cause;
    }

    /**
     * Get the reason.
     *
     * @return The reason
     */
    public Optional<Reason> getReason() {
        return reason;
    }

}
