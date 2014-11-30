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
package org.spongepowered.api.text.chat;

import com.google.common.base.Optional;

import java.util.List;

/**
 * ChatTypes is a list of the default chat positions that are available in
 * Minecraft. The values are filled in by mixins in Sponge at runtime.
 */
public final class ChatTypes {

    private static final ChatTypeFactory factory = null;

    private ChatTypes() {

    }

    /**
     * The standard chat position in prompt at the bottom-left.
     */
    public static final ChatType CHAT = null;

    /**
     * The same position as the {@link #CHAT} position, except messages sent to
     * this position are still seen when chat is turned off on the Minecraft
     * client.
     *
     * <p>
     * Use wisely as to not annoy players.
     * </p>
     */
    public static final ChatType SYSTEM = null;

    /**
     * The position right above the inventory, experience, health, item name,
     * etc. bars.
     */
    public static final ChatType ACTION_BAR = null;

    /**
     * Gets the {@link ChatType} with the specified name.
     *
     * @param name The identifier of the chat type, for example "ACTION_BAR"
     * @return The {@link ChatType} with the specified name, or
     *         {@link Optional#absent()} if not found
     */
    public static Optional<ChatType> valueOf(String name) {
        return factory.getTypeFromName(name);
    }

    /**
     * Returns a list of all available {@link ChatType}s on this server.
     *
     * @return An immutable list of all chat types
     */
    public static List<ChatType> getValues() {
        return factory.getTypes();
    }

}
