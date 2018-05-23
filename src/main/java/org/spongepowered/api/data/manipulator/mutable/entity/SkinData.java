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
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableSkinData;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.profile.property.ProfileProperty;

/**
 * Represents the skin data for a {@link Humanoid}.
 *
 * <p>In order to be accepted by the client, all skins must be
 * signed by Mojang.</p>
 *
 * <p>SkinData should be used instead of manipulating a {@link Humanoid}'s
 * {@link GameProfile}. This ensures that the {@link Humanoid}'s skin is
 * properly updated on all viewing clients.</p>
 */
public interface SkinData extends DataManipulator<SkinData, ImmutableSkinData> {

    /**
     * Gets the {@link Value} for the {@link ProfileProperty} of the skin to display on a
     * {@link Humanoid} entity for customization.
     *
     * <p>The name of the {@link ProfileProperty} MUST be {@link ProfileProperty#TEXTURES},
     * and have a valid signature, in order to be accepted by the client.</p>
     *
     * @return The value for the skin property
     * @see Keys#SKIN
     */
    Value<ProfileProperty> skin();

    /**
     * Gets the {@Value} for whether or not to update the player's
     * {@link GameProfile}
     *
     * <p>If this value is <code>true</code>, then the player's new skin
     * will be automatically displayed in the tab list. Calls to
     * {@link User#getProfile()} will return a {@link GameProfile}
     * with its {@link ProfileProperty#TEXTURES} property
     * set to the new skin.</p>
     *
     * <p>If it is <code>false</code>, then the tab list will not be modified,
     * and {@link User#getProfile()} will return the user's original profile.
     * However, all players will still see the new skin in-game.</p>
     *
     * <p>Assuming that tab list hasn't been changed by a plugin, the
     * player's original skin will be displayed.</p>
     *
     * <p>For {@link Human}s, setting this to <code>false</code> will cause the human
     * to be completely absent from the tab list.</p>
     * @return Whether to update the gameprofile
     * @see Keys#UPDATE_GAME_PROFILE
     */
    Value<Boolean> updateGameProfile();

}
