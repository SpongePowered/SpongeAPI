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
import org.spongepowered.api.data.manipulator.mutable.entity.SkinData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.player.Player;

import java.util.UUID;

/**
 * An {@link ImmutableDataManipulator} handling the {@link UUID} for  the
 * {@link Humanoid} skin used. Usually this is meant where the {@link UUID}
 * belongs to a {@link Player} but without relying on a {@link Player},
 * the {@link Humanoid} will use the same skin url on the server.
 */
public interface ImmutableSkinData extends ImmutableDataManipulator<ImmutableSkinData, SkinData> {

    /**
     * Gets the {@link ImmutableValue} for the {@link UUID} of the skin to
     * display on a {@link Humanoid} entity for customization.
     *
     * @return The immutable value for the skin uuid
     */
    ImmutableValue<UUID> skinUniqueId();

}
