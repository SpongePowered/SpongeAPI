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
package org.spongepowered.api.entity.living.player.chat;

import net.kyori.adventure.audience.MessageType;
import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of the vanilla chat visibility modes for a client.
 */
public final class ChatVisibilities {

    private ChatVisibilities() {
    }

    // SORTFIELDS:ON

    /**
     * All chat is visible.
     */
    public static final Supplier<ChatVisibility> FULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ChatVisibility.class, "full");

    /**
     * No chat is visible.
     */
    public static final Supplier<ChatVisibility> HIDDEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ChatVisibility.class, "hidden");

    /**
     * Only {@link MessageType#SYSTEM} is visible.
     */
    public static final Supplier<ChatVisibility> SYSTEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ChatVisibility.class, "system");

    // SORTFIELDS:OFF
}
