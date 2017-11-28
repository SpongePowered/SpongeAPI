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
package org.spongepowered.api.packs;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.DataView;

import java.io.InputStream;
import java.util.Optional;

/**
 * A resource can represent any kind of loaded data. It can be a file on the filesystem, a network location, or
 * even generated at runtime. Use {@link #getInputStream()} to load the data held by a resource.
 */
public interface Resource {

    /**
     * Gets the path of this resource. The path follows the same rules as a
     * catalog identifier.
     *
     * @return The path
     * @see CatalogType#getId()
     */
    String getPath();

    /**
     * Gets the {@link Pack} which owns this resource.
     *
     * @return The parent pack.
     */
    Pack getPack();

    /**
     * Gets the metadata for this resource.
     *
     * <p>The metadata file has the same name as this resource, but has
     * {@code .mcmeta} appended to the end.</p>
     *
     * <p>For example: the metadata for the resource
     * {@code minecraft:textures/blocks/water_flow.png} would be located at
     * {@code minecraft:textures/blocks/water_flow.png.mcmeta}</p>
     *
     * @return The metadata or {@link Optional#empty() empty} if it doesn't exist.
     * @see <a href=http://minecraft.gamepedia.com/Resource_pack#Contents> Minecraft Wiki/Resource Packs
     */
    Optional<DataView> getMetadata();

    /**
     * Returns a new {@link InputStream} of this resource.
     *
     * @return A new input stream
     */
    InputStream getInputStream();

}
