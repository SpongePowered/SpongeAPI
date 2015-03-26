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
package org.spongepowered.api.service.command.sponge;

import org.spongepowered.api.util.command.CommandSource;

/**
 * Represents an alias that has been set to resolve to certain plugins under
 * certain circumstances.
 */
public interface AliasContext {

    /**
     * Gets if this alias context should be used when running from the specified
     * command source.
     * 
     * @param source The command source to check.
     * @return If this alias context should be used when running from the
     *         specified command source.
     */
    boolean appliesTo(CommandSource source);

    /**
     * Gets the ID of the plugin to use when running from the specified command
     * source.
     * 
     * @param source The command source to check.
     * @return The ID of the plugin to use when running from the specified
     *         command source.
     */
    String getPluginId(CommandSource source);

}
