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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.server.ServerWorld;

/**
 * A listing of the {@link ResourceKey keys} of the default {@link ServerWorld worlds} in Minecraft.
 */
public final class DefaultWorldKeys {

    /**
     * The default "world" of a running game session. Typically, the Overworld.
     * <p>
     * Refer to: <a href="https://minecraft.wiki/w/Overworld">Overworld</a>
     */
    public static final ResourceKey DEFAULT = Sponge.game().factoryProvider().provide(DefaultWorldKeys.Factory.class).defaultWorld();

    /**
     * Refer to: <a href="https://minecraft.wiki/w/The_Nether">The Nether</a>
     */
    public static final ResourceKey THE_NETHER = Sponge.game().factoryProvider().provide(DefaultWorldKeys.Factory.class).theNether();

    /**
     * Refer to: <a href="https://minecraft.wiki/w/The_End">The End</a>
     */
    public static final ResourceKey THE_END = Sponge.game().factoryProvider().provide(DefaultWorldKeys.Factory.class).theEnd();

    private DefaultWorldKeys() {
    }

    public interface Factory {

        ResourceKey defaultWorld();

        ResourceKey theNether();

        ResourceKey theEnd();
    }
}
