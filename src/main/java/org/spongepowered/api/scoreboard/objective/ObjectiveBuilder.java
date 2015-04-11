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
package org.spongepowered.api.scoreboard.objective;

import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.scoreboard.displayslot.DisplaySlot;
import org.spongepowered.api.scoreboard.objective.displaymode.ObjectiveDisplayMode;
import org.spongepowered.api.text.Text;

import java.util.Map;

/**
 * Represents a builder to create {@link Objective} instances.
 */
public interface ObjectiveBuilder {

    /**
     * Sets the name of the {@link Objective}.
     *
     * @param name The name to set
     * @return This builder
     */
    ObjectiveBuilder name(String name);

    /**
     * Sets the display name of the {@link Objective}.
     *
     * @param displayName The display name to set
     * @return This builder
     */
    ObjectiveBuilder displayName(Text displayName);

    /**
     * Sets the {@link Criterion} of the {@link Objective}.
     *
     * @param criterion The {@link Criterion} to set
     * @return This builder
     */
    ObjectiveBuilder criterion(Criterion criterion);

    /**
     * Sets the {@link ObjectiveDisplayMode} of the {@link Objective}.
     *
     * @param objectiveDisplayMode The {@link ObjectiveDisplayMode} to set
     * @return This builder
     */
    ObjectiveBuilder objectiveDisplayMode(ObjectiveDisplayMode objectiveDisplayMode);

    /**
     * Sets the {@link DisplaySlot} of the {@link Objective}.
     *
     * @param displaySlot The {@link DisplaySlot} to set
     * @return This builder
     */
    ObjectiveBuilder displaySlot(DisplaySlot displaySlot);

    /**
     * Sets the map of entries and {@link Score}s of the {@link Objective}.
     *
     * <p>By default, this is the empty map.</p>
     *
     * @param entries The map of entries and {@link Score}s to set
     * @return This builder
     */
    ObjectiveBuilder entries(Map<String, Score> entries);

    /**
     * Resets all information regarding the {@link Objective} to be created.
     *
     * @return This builder
     */
    ObjectiveBuilder reset();

    /**
     * Builds an instance of an {@link Objective}.
     *
     * @return A new instance of an {@link Objective}
     * @throws IllegalStateException if the {@link Objective} is not complete
     */
    Objective build() throws IllegalStateException;

}
