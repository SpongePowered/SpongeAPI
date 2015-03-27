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
package org.spongepowered.api.event.rcon;

import org.spongepowered.api.event.message.CommandEvent;
import org.spongepowered.api.util.command.source.RconSource;

/**
 * An event when an {@link RconSource} executes a command.
 */
public interface RconCommandEvent extends CommandEvent, RconEvent {

    @Override
    RconSource getSource();

    /**
     * Gets whether {@link RconSource#getLoggedIn()} will be ignored when
     * determining whether to execute the supplied {@link #getRawPayload() command}.
     *
     * <p>Normally, if an {@link RconSource} is not {@link RconSource#getLoggedIn()} logged in},
     * the supplied {@link #getRawPayload() command} will not be executed.</p>
     *
     * <p>The opposite scenario, preventing the execution of a command by a logged in
     * client, can be achieved with {@link #setCancelled(boolean)}.</p>
     *
     * @return Whether to override the client's logged in status
     */
    boolean isIgnoringLoginStatus();

    /**
     * Sets whether {@link RconSource#getLoggedIn()} will be ignored when
     * determining whether to execute the supplied {@link #getRawPayload() command}.
     *
     * <p>Normally, if an {@link RconSource} is not {@link RconSource#getLoggedIn()} logged in},
     * the supplied {@link #getRawPayload() command} will not be executed.</p>
     *
     * <p>The opposite scenario, preventing the execution of a command by a logged in
     * client, can be achieved with {@link #setCancelled(boolean)}.</p>
     *
     * @param ignoringLoginStatus Whether to ignore the client's logged in status
     */
    void setIgnoringLoginStatus(boolean ignoringLoginStatus);
}
