/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.event;

/**
 * Order that a {@link org.spongepowered.api.event.SpongeEventHandler} may be registered at.
 */
public enum Order {
    /**
     * Called before all other handlers. Should be used for high-priority event cancelling. Should not be used to make changes to any implementation core objects.
     */
    PRE(0, false),
    /**
     * Called after "Pre". Should be used for high-priority event cancelling.
     */
    FIRST(1, false),
    /**
     * Called after "First" handlers and before "Early" handlers.<br> Is called even when event has been cancelled.<br> Should generally be used to un-cancel events cancelled in First.<br>
     */
    FIRST_IGNORE_CANCELLED(2, true),
    /**
     * Called after "First" handlers. Should generally be used for low priority event cancelling.
     */
    EARLY(3, false),
    /**
     * Called after "Early" handlers and before "Default" handlers.<br> Called even when event has been cancelled.<br> This is for general-purpose always-run events.<br>
     */
    EARLY_IGNORE_CANCELLED(4, true),
    /**
     * Default call, for general purpose handlers.
     */
    DEFAULT(5, false),
    /**
     * Called after "Default" handlers and before "Late" handlers.<br> Called even when the event has been canceled.<br> This is for general-purpose always-run events.<br>
     */
    DEFAULT_IGNORE_CANCELLED(6, true),
    /**
     * Called after "Default" handlers.
     */
    LATE(7, false),
    /**
     * Called after "Late" handlers and before "Last" handlers.<br> Called even when the event has been cancelled.<br>
     */
    LATE_IGNORE_CANCELLED(8, true),
    /**
     * Called after "Late" handlers.<br> No changes to the event should be made in this order slot (may be enforced by implementation).<br>
     */
    LAST(9, false),
    /**
     * Called after "Last" handlers and before "Post" handlers.<br> No changes to the event should be made in this order slot (may be enforced by implementation).<br> This is called even when event has been cancelled.<br>
     */
    LAST_IGNORE_CANCELLED(10, true),
    /**
     * Called after all other handlers. Should not be used to make changes to the event or any implementation core objects.
     */
    POST(11, false);

    private final int index;
    private final boolean ignoreCancelled;

    Order(int index, boolean ignoreCancelled) {
        this.index = index;
        this.ignoreCancelled = ignoreCancelled;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @return whether this Order ignores cancellation status
     */
    public boolean ignoresCancelled() {
        return ignoreCancelled;
    }
}
