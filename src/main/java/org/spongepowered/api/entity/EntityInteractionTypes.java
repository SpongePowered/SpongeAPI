/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.entity;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.player.gamemode.GameModes;

/**
 * An list {@link EntityInteractionType}s available in Vanilla.
 */
public final class EntityInteractionTypes {

    /**
     * Represents an interaction by "attacking", bound to left
     * click in the client by default.
     */
    public static final EntityInteractionType ATTACK = null;

    /**
     * Represents an interaction by middle clicking, bound to the
     * scroll wheel in the client by default.
     *
     * <p>This is only valid for {@link BlockType}s, and has the effect
     * of giving a player the picked block if in {@link GameModes#CREATIVE}.</p>
     */
    public static final EntityInteractionType PICK_BLOCK = null;

    /**
     * Represents an interaction by right clicking, bound to right
     * click in the client by default.
     */
    public static final EntityInteractionType USE = null;

    private EntityInteractionTypes() {

    }
}
