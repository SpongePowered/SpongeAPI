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
package org.spongepowered.api.event.block.tile;

import org.spongepowered.api.block.tile.Sign;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.event.Cancellable;

/**
 * An event when a {@link Sign} is changed.
 *
 * <p>Examples may include: A player writing a sign.</p>
 */
public interface SignChangeEvent extends SignEvent, Cancellable {

    /**
     * Gets the previous messages in order of line number of the sign.
     *
     * @return The previous messages
     */
    Text[] getPreviousLines();

    /**
     * Gets the changed messages.
     *
     * @return The new messages
     */
    Text[] getNewLines();

    /**
     * Sets the changed messages.
     *
     * @param messages The new messages
     */
    void setNewMessages(Text[] messages);

}
