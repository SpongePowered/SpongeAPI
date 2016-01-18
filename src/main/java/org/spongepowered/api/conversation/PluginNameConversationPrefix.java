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
package org.spongepowered.api.conversation;

import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;

public class PluginNameConversationPrefix implements ConversationPrefix {

    protected String separator;
    protected TextColor prefixColor;
    protected Plugin plugin;

    private String cachedPrefix;

    public PluginNameConversationPrefix(Plugin plugin) {
        this(plugin, " > ", TextColors.LIGHT_PURPLE);
    }

    public PluginNameConversationPrefix(Plugin plugin, String separator, TextColor prefixColor) {
        this.separator = separator;
        this.prefixColor = prefixColor;
        this.plugin = plugin;

        cachedPrefix = prefixColor + plugin.name() + separator + TextColors.WHITE;
    }

    /**
     * Prepends each conversation message with the plugin name.
     *
     * @param context Context information about the conversation.
     * @return An empty string.
     */
    public String getPrefix(ConversationContext context) {
        return cachedPrefix;
    }
}
