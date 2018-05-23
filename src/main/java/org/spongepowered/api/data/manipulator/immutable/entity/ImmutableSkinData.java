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

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.entity.SkinData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.property.ProfileProperty;

/**
 * Represents the UUID of the skin for a {@link Humanoid}.
 *
 * <p>In order to be accepted by the client, all skins must be
 * signed by Mojang.</p>
 *
 * <p>SkinData should be used instead of manipulating a {@link Humanoid}'s
 * {@link GameProfile}. This ensures that the {@link Humanoid}'s skin is
 * properly updated on all viewing clients.</p>
 */
public interface ImmutableSkinData extends ImmutableDataManipulator<ImmutableSkinData, SkinData> {

    /**
     * Gets the {@link ImmutableValue} for the {@link ProfileProperty} of the skin to display on a
     * {@link Humanoid} entity for customization.
     *
     * <p>The name of the {@link ProfileProperty} MUST be {@link ProfileProperty#TEXTURES},
     * and have a valid signature, in order to be accepted by the client.</p>
     *
     * @return The value for the skin uuid
     * @see Keys#SKIN
     */
    ImmutableValue<ProfileProperty> skin();

}
