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
package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableJohnnyData;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.living.monster.Vindicator;

/**
 * Data which represents if a mob is exhibiting "johnny" behavior.
 *
 * <p>In vanilla this currently only applies to {@link Vindicator}s.</p>
 *
 * @see <a href="https://minecraft.gamepedia.com/Vindicator#Behavior">
 *     The Minecraft Wiki for more information about "johnny" behavior</a>
 */
public interface JohnnyData extends DataManipulator<JohnnyData, ImmutableJohnnyData> {

    /**
     * Gets the {@link Value} for whether this mob is exhibiting
     * "johnny" behavior.
     *
     * @return The value for whether this mob is exhibiting "johnny" behavior
     * @see Keys#IS_JOHNNY
     */
    Value<Boolean> johnny();

}
