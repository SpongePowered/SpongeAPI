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
package org.spongepowered.api.resource.pack;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Nameable;

public interface PackInfo extends Nameable {

    Text getDisplayName(boolean enabled);

    PackVersion getVersion();

    /**
     * Gets the pack associated with this pack info.
     *
     * <p>The returned pack may be a new instance or cached, depending on the
     * implementation.</p>
     *
     * @return The pack
     */
    Pack getPack();

    /**
     * Gets whether this pack is forced to be enabled at all times.
     *
     * @return True if forced enabled, false if disable-able
     */
    boolean isForced();

    /**
     * Gets whether this pack is order locked on top or bottom.
     *
     * @return True if order locked, false if order-able
     * @see #getPriority()
     */
    boolean isLocked();

    /**
     * Gets the priority of this pack, first or last.
     *
     * @return The priority
     */
    Priority getPriority();

    enum Priority {
        FIRST, LAST
    }
}
