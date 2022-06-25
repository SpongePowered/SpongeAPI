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
package org.spongepowered.api.world;

import org.spongepowered.api.Client;
import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.ResourceKeyedBuilder;

/**
 * Represents the effect a {@link WorldType} will play on a {@link Player player's}
 * {@link Client}
 */
public interface WorldTypeEffect extends ResourceKeyed {

    interface Builder extends ResourceKeyedBuilder<WorldTypeEffect, Builder> {

    }

    interface Factory {

        /**
         * Clouds and celestial objects.
         */
        WorldTypeEffect overworld();

        /**
         * Nether Fog
         */
        WorldTypeEffect nether();

        /**
         * End Sky
         */
        WorldTypeEffect end();
    }
}
