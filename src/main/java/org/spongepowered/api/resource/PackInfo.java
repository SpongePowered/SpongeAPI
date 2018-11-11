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
package org.spongepowered.api.resource;

import org.spongepowered.api.text.Text;

/**
 * Basic info about a {@link Pack}
 */
public interface PackInfo {

    /**
     * Gets the name of the {@link Pack} used to identify it in the
     * {@link PackRepository}.
     *
     * @return The pack name
     */
    String getName();

    /**
     * Gets the display name of the {@link Pack} which is displayed to the user.
     *
     * @return The display name
     */
    Text getDisplayName();

    /**
     * Gets the description of the {@link Pack} which is displayed as the hover
     * text to the user.
     *
     * @return The description
     */
    Text getDescription();

    /**
     * Formats the text of the pack info to display to the user.
     *
     * @param active Whether this pack is active or not
     * @return The formatted text
     */
    Text formatName(boolean active);

    /**
     * Gets the {@link Pack} associated with this pack info.
     *
     * @return
     */
    Pack getPack();

    /**
     * Gets whether or not this pack is required to be active. If it is
     * required to be active, it cannot be disabled and will be reactivated
     * when reloaded.
     *
     * @return True if required, false otherwise
     */
    boolean isRequired();

    /**
     * Gets whether or not this pack was loaded from a remote location. For
     * example, if this is a server-defined client resource pack.
     *
     * @return Whether this pack is remote
     */
    boolean isRemote();

}
