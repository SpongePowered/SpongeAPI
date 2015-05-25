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
package org.spongepowered.api.data.manipulator;

import org.spongepowered.api.GameProfile;
import org.spongepowered.api.block.tileentity.Skull;
import org.spongepowered.api.data.DataHolder;

/**
 * Represents data pertaining to a {@link GameProfile} that is marked as
 * "owning" the {@link DataHolder}. Usually applicable to {@link Skull}s.
 */
public interface OwnableData extends SingleValueData<GameProfile, OwnableData> {

    /**
     * Gets the owners profile.
     *
     * @return The owners profile, if available
     */
    GameProfile getProfile();

    /**
     * Sets the profile that owns this item stack.
     *
     * @param profile The profile that owns this item stack
     * @return This instance, for chaining
     */
    OwnableData setProfile(GameProfile profile);

}
