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
package org.spongepowered.api.map;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.player.Player;

/**
 * Plugin classes should implement this to modify the image shown on a map.
 */
public interface MapRenderer {

    /**
     * Returns if this map renders different views for each player viewing it.
     *
     * <p>Most maps representing shared content are the same for all players
     * that hold them, but sometimes a plugin may wish to render a unique view
     * for each player.</p>
     *
     * @return True if the rendering is specific to each player, false otherwise
     */
    boolean isContextual();

    /**
     * Gives access to the {@link MapCanvas} for rendering onto a map, this also
     * provides a viewer and a reference to the original map data to allow
     * updating cursors and accessing relevant information to the render.
     *
     * <p>The viewer is guaranteed to be present if {@link #isContextual()}
     * returns true.</p>
     *
     * @param viewer The player viewing this render, {@link Optional#absent()}
     *        otherwise
     * @param view The map that's being rendered
     * @param canvas The canvas that the renderer will draw onto
     */
    void render(Optional<Player> viewer, MapView view, MapCanvas canvas);
}
