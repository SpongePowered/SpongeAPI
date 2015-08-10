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
package org.spongepowered.api.data.manipulator.immutable.entity;

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.InvisibilityData;
import org.spongepowered.api.data.value.immutable.ImmutableSetValue;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.player.Player;

import java.util.UUID;

/**
 * An {@link ImmutableDataManipulator} for the "invisible" state. If present,
 * the {@link Entity} is rendered "invisible". Alternatively, the
 * {@link Entity} can be rendered invisible to a specific {@link Player} by
 * including the {@link Player#getUniqueId()} in the
 * {@link #invisibleToPlayerIds()}.
 */
public interface ImmutableInvisibilityData extends ImmutableDataManipulator<ImmutableInvisibilityData, InvisibilityData> {

    /**
     * Gets the {@link ImmutableSetValue} of {@link Player} {@link UUID}s that
     * the owning {@link Entity} is rendered "invisible" to. If a
     * {@link Player}'s {@link UUID} is NOT included in the
     * {@link ImmutableSetValue}, then the entity is not "invisible".
     *
     * @return The set value of player id's the entity is invisible to
     */
    ImmutableSetValue<UUID> invisibleToPlayerIds();

}
