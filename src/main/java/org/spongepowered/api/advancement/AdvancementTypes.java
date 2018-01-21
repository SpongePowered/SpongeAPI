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
package org.spongepowered.api.advancement;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all the available {@link AdvancementType}s in Minecraft.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class AdvancementTypes {

    // SORTFIELDS:ON

    /**
     * Represents the challenge completion advancement type.
     *
     * @see <a href="https://minecraft.gamepedia.com/File:ChallengeComplete.png">
     *     the Minecraft Wiki for an example of this advancement type</a>
     */
    public static final AdvancementType CHALLENGE = DummyObjectProvider.createFor(AdvancementType.class, "CHALLENGE");

    /**
     * Represents the goal reached advancement type.
     *
     * @see <a href="https://minecraft.gamepedia.com/File:GoalReached.png">
     *     the Minecraft Wiki for an example of this advancement type</a>
     */
    public static final AdvancementType GOAL = DummyObjectProvider.createFor(AdvancementType.class, "GOAL");

    /**
     * Represents the advancement made advancement type.
     *
     * @see <a href="https://minecraft.gamepedia.com/File:AdvancementMade.png">
     *     the Minecraft Wiki for an example of this advancement type</a>
     */
    public static final AdvancementType TASK = DummyObjectProvider.createFor(AdvancementType.class, "TASK");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private AdvancementTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
