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
package org.spongepowered.api.data.manipulator.mutable;

import com.flowpowered.math.vector.Vector2i;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMapInfoData;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.map.MapCanvas;
import org.spongepowered.api.map.decoration.MapDecoration;
import org.spongepowered.api.world.World;

/**
 * Represents an {@link DataManipulator} hosting the specific map
 * information of an {@link org.spongepowered.api.map.MapInfo}.
 */
public interface MapInfoData extends DataManipulator<MapInfoData, ImmutableMapInfoData> {
    /**
     * Gets the center of where the map refers to.
     * @return The Vector2i centre point
     */
    Value<Vector2i> location();

    /**
     * Gets the {@link World} that the map refers to.
     * @return The world
     */
    Value<World> world();

    /**
     * Gets whether this map tracks player position.
     * @return boolean If this map tracks players
     */
    Value<Boolean> trackPosition();

    /**
     * Gets whether this map tracks players from unlimited distance away
     * @return boolean If the map has unlimited tracking
     */
    Value<Boolean> unlimitedTracking();

    /**
     * Gets the scale of this map
     * @see <a href="https://minecraft.gamepedia.com/Map#Zoom_details">Minecraft Wiki - Zoom Details</a>
     * @return Integer The scale of this map
     */
    MutableBoundedValue<Integer> scale();

    /**
     * Gets the canvas from this map.
     * This contains the colors in the map.
     * @return MapCanvas canvas for this map
     */
    Value<MapCanvas> canvas();

    /**
     * Gets the MapDecorations from this map.
     * This is a list of MapDecorations.
     * @return List of MapDecorations
     */
    SetValue<MapDecoration> decorations();

    /**
     * Gets whether this map is locked
     * Brought forward version of <a href="https://minecraft.gamepedia.com/Map#Locking">Minecraft Wiki - Map Locking</a>
     * (Plugins can still modify the map)
     * @return Boolean if it is locked
     */
    Value<Boolean> locked();
}
