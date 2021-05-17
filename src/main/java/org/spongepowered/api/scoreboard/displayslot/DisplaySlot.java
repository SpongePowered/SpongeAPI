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
package org.spongepowered.api.scoreboard.displayslot;

import net.kyori.adventure.text.format.NamedTextColor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

/**
 * Represents an area to display an objective.
 */
@CatalogedBy(DisplaySlots.class)
public interface DisplaySlot extends DefaultedRegistryValue {

    /**
     * Finds and retrieves the sidebar display slot for the specified
     * {@link NamedTextColor} associated with a {@link Team}, if one exists.
     *
     * @param color The {@link NamedTextColor}
     * @return The slot, if one was found
     */
    static Optional<DisplaySlot> findByTeamColor(final NamedTextColor color) {
        return Sponge.game().factoryProvider().provide(Factory.class).findByTeamColor(color);
    }

    /**
     * Gets the {@link Team} color that this objective will display.
     *
     * @return The team color or {@link Optional#empty()} if not set
     */
    Optional<NamedTextColor> teamColor();

    /**
     * Used to support {@link #findByTeamColor(NamedTextColor)}
     */
    interface Factory {

        /**
         * Finds and retrieves the sidebar display slot for the specified
         * {@link NamedTextColor} associated with a {@link Team}, if one exists.
         *
         * @param color The {@link NamedTextColor}
         * @return The slot, if one was found
         */
        Optional<DisplaySlot> findByTeamColor(NamedTextColor color);

    }

}
