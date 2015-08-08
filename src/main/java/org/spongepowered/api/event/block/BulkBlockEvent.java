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
package org.spongepowered.api.event.block;

import com.google.common.base.Predicate;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.util.annotation.ImplementedBy;
import org.spongepowered.api.util.event.superclasses.AbstractBulkBlockEvent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;

/**
 * A base event for events affecting several {@link Location}s (as their target).
 */
@ImplementedBy(AbstractBulkBlockEvent.class)
public interface BulkBlockEvent extends GameEvent, CauseTracked {

    /**
     * Get the list of the affected {@link Location}s.
     *
     * <p>Removal of any location from this list will, by consequence,
     * cause the event to not affect the removed location. This is only
     * true if and only if this event is not cancelled (if the event
     * implements cancellable).</p>
     *
     * @return The list of locations
     */
    List<Location<World>> getLocations();

    /**
     * Apply the given predicate to the list of {@link Location}s.
     *
     * <p>The given predicate should return {@code true} by default, and
     * return {@code false} to remove the location from the list
     * of locations (if the event isn't cancelled -- see {@link #getLocations()}
     * for more information).</p>
     *
     * @param predicate A predicate that returns false to remove the given block
     */
    void filterLocations(Predicate<Location<World>> predicate);

}
